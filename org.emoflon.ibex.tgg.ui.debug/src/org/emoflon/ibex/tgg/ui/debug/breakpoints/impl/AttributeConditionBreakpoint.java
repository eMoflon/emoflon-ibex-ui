package org.emoflon.ibex.tgg.ui.debug.breakpoints.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import org.emoflon.ibex.tgg.ui.debug.api.Attribute;
import org.emoflon.ibex.tgg.ui.debug.api.Edge;
import org.emoflon.ibex.tgg.ui.debug.api.Match;
import org.emoflon.ibex.tgg.ui.debug.api.Node;
import org.emoflon.ibex.tgg.ui.debug.api.Rule;
import org.emoflon.ibex.tgg.ui.debug.api.enums.Action;
import org.emoflon.ibex.tgg.ui.debug.api.enums.EdgeType;
import org.emoflon.ibex.tgg.ui.debug.breakpoints.AbstractBreakpoint;

import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException;

import javafx.util.Pair;

public class AttributeConditionBreakpoint extends AbstractBreakpoint {
	
	private Class<?> classForAttributeEvaluation; 
	
	private String attributeCondition;
	
	private List<Pair<String, String>> parameterList;
	
	private String lastError = "";
	
	private Rule rule;
	
	private final String uuid;
	
	public AttributeConditionBreakpoint() {
		attributeCondition = "";
		rule = null;
		uuid = UUID.randomUUID().toString();
	}

	@Override
	public synchronized boolean evaluate(Match match) {
		if(classForAttributeEvaluation == null) {
			return false;
		}
		
		if(!match.getRule().getName().equals(this.getRule().getName())) {
			return false;
		}
		
		Method evaluationMethod = this.classForAttributeEvaluation.getMethods()[0];
		List<Object> callAttributes = new ArrayList<Object>(evaluationMethod.getParameterCount()); 
		
		HashMap<String, Node> ruleNodeToMatchedNode = new HashMap<String, Node>();
		
		// find the match node for a rule node
		for(Edge e : match.getGraph(0).getEdges()) {
			if(e.getType() != EdgeType.MATCH) {
				continue;
			}
			String ruleNodeName = e.getSrcNode().getName();
			Node matchedNode = e.getTrgNode();
			ruleNodeToMatchedNode.put(ruleNodeName, matchedNode);
		}
		
		// get the parameters for calling the evaluation method
		for(Pair<String,String> nodeParameter : this.parameterList) {
			String nodeName = nodeParameter.getKey();
			String parameterName = nodeParameter.getValue();
			Object parameterValue = null;
			// find the node
			Node matchedNode = ruleNodeToMatchedNode.get(nodeName);
			if(matchedNode != null) {
				// find the attribute of the node
				for(Attribute attr : matchedNode.getAttributes()) {
					if(attr.getName().equals(parameterName)) {
						// get the attribute value as a parameter value for the call
						parameterValue = attr.getValue();
						break;
					}
				}				
			}

			callAttributes.add(parameterValue);
		}
		
		try {
			// call the evaluation method
			boolean result = (boolean) evaluationMethod.invoke(null, callAttributes.toArray());
			this.lastError = "";
			return result;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			Throwable cause = e.getCause();
			if(cause != null) {
				this.lastError = cause.getClass().getSimpleName() + ": " + cause.getMessage();
				cause.printStackTrace();
			} else {
				this.lastError = e.getClass().getSimpleName() + ": " + e.getMessage();
				e.printStackTrace();
			}
			
			return false;
		}
	}
	
	public synchronized void setAttributeCondition(Rule rule, String condition) {
		if(rule == null || condition == null || condition.trim().length() == 0) {
			return;
		}
		
		try {
			String classText = this.createClassText(rule, condition);
			Path sourceFile = this.saveSource(classText);
			Path classFile = this.compileSource(sourceFile);
			classForAttributeEvaluation = this.loadClass(classFile);
			this.lastError = "";
		} catch (ClassNotFoundException | IOException | CompilerException | URISyntaxException e) {
			this.lastError = e.getClass().getSimpleName() + ": "+e.getMessage();
			e.printStackTrace();
		}
	}
	
	private String createClassText(Rule rule, String condition) {
		StringBuilder st = new StringBuilder();
		st.append("public class AttributeConditionBreakpointEvaluation {\n");
		st.append("\tpublic static boolean evaluate(");
		
		parameterList = new ArrayList<Pair<String, String>>();
		
		int counter = 0;
		for(Node n : rule.getGraph().getNodes()) {
			if(n.getAction() != Action.CONTEXT && n.getAction() != Action.TRANSLATE) {
				continue;
			}
			for(Attribute attr : n.getAttributes()) {
				if(counter != 0) {
					st.append(", ");
				}
				counter++;
				
				//save order of arguments for later so we can call it with the correct parameters 
				Pair<String,String> nodeParameter = new Pair<String, String>(n.getName(), attr.getName());
				
				parameterList.add(nodeParameter);
				
				st.append(attr.getType()+" "+n.getName()+"_"+attr.getName());
				condition = condition.replace(n.getName()+"."+attr.getName(), n.getName()+"_"+attr.getName());
			}
			
		}
		st.append(") {\n");
				
		st.append("\t\treturn "+condition+";\n");
		st.append("\t}\n");
		st.append("}\n");
		
		return st.toString();
		
	}
	
	private Path saveSource(String sourceCode) throws IOException {
		String tmpProperty = System.getProperty("java.io.tmpdir");
        Path sourcePath = Paths.get(tmpProperty, "AttrCond", uuid, "AttributeConditionBreakpointEvaluation.java");
        Files.deleteIfExists(sourcePath);
        Files.createDirectories(sourcePath.getParent());
        Files.write(sourcePath, sourceCode.getBytes("UTF8"));
        return sourcePath;
	}
	
	private Path compileSource(Path sourceFile) throws CompilerException, URISyntaxException {
		List<String> dependencyPaths = new ArrayList<String>();
		URL[] dependencies = getClassPath();
		for(URL dependency : dependencies) {
			File f = new File(dependency.toURI()); 
			dependencyPaths.add(f.getAbsolutePath());
		}
		dependencyPaths.add(".");
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		ByteArrayOutputStream errorOut = new ByteArrayOutputStream();
				
		String delimiter = System.getProperty("os.name").contains("Win")? ";" : ":";
		
		String dependencyString = String.join(delimiter, dependencyPaths);
		
        int exitCode = compiler.run(null, null, errorOut, "-cp", dependencyString, sourceFile.toFile().getAbsolutePath());
        if(exitCode != 0) {
        	String error = errorOut.toString();
        	throw new CompilerException(error);
        }
        return sourceFile.getParent().resolve("AttributeConditionBreakpointEvaluation.class");
	}
	
	private Class<?> loadClass(Path classFile) throws MalformedURLException, ClassNotFoundException, CompilerException {
		URL classUrl = classFile.getParent().toFile().toURI().toURL();
		URL[] programClassPath = this.getClassPath();		
		List<URL> classPathList = new ArrayList<URL>(Arrays.asList(programClassPath));
		classPathList.add(classUrl);
        URLClassLoader classLoader = URLClassLoader.newInstance(classPathList.toArray(new URL[classPathList.size()]));
        Class<?> loadedClass = Class.forName("AttributeConditionBreakpointEvaluation", false, classLoader);
		return loadedClass;
	}
	
	private URL[] getClassPath() throws CompilerException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		if(classloader instanceof URLClassLoader) {
			return ((URLClassLoader) classloader).getURLs();
		} else {
			throw new CompilerException("Resolving class paths has not been implemented for Classloaders that are not URLClassloaders");
			// URLClassloader is only used until Java 9
			// For newer versions, the classpath has to be found differently
			// See: https://stackoverflow.com/questions/41932635/scanning-classpath-modulepath-in-runtime-in-java-9/45612376#45612376
			// The implementation needs to be taken and adapted here
		}
	}
	

	public synchronized String getAttributeCondition() {
		return attributeCondition;
	}

	public synchronized void setAttributeCondition(String attributeCondition) {
		if(attributeCondition != null && !attributeCondition.equals(this.attributeCondition)) {
			this.resetHitCount();
			this.attributeCondition = attributeCondition;
			this.setAttributeCondition(getRule(), getAttributeCondition());			
		}
	}

	public synchronized Rule getRule() {
		return rule;
	}

	public synchronized void setRule(Rule rule) {
		if(this.rule != rule) {
			this.resetHitCount();
			this.rule = rule;
			this.setAttributeCondition(getRule(), getAttributeCondition());
		}
	}

	public synchronized String getLastError() {
		return lastError;
	}
	
	public String toString() {
		String ruleName = "";
		if(this.getRule() != null) {
			ruleName = this.getRule().getName();
		}
		return "AttributeConditionBreakpoint (Rule: "+ruleName+", Condition: "+this.getAttributeCondition()+")";
	}
	


}
