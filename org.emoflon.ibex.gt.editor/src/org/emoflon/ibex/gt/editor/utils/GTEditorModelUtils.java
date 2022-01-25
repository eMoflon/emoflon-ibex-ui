package org.emoflon.ibex.gt.editor.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeAssignment;
import org.emoflon.ibex.gt.editor.gT.EditorAttributeConstraint;
import org.emoflon.ibex.gt.editor.gT.EditorGTFile;
import org.emoflon.ibex.gt.editor.gT.EditorImport;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorPattern;
import org.emoflon.ibex.gt.editor.gT.EditorReference;
import org.emoflon.ibex.gt.editor.gT.GTPackage;
import org.emoflon.ibex.gt.editor.gT.XMLImport;

/**
 * Utility methods for dealing with meta-models.
 */
public class GTEditorModelUtils {
	
	/**
	 * The uri for loading the XML model with the "import XML" shorthand.
	 */
	private static final String XMLURI = "platform:/resource/ModelXML/model/modelxml.ecore";
	
	/**
	 * The set of meta-model resources loaded.
	 */
	private static Map<URI, Resource> metaModelResources = new HashMap<>();

	/**
	 * The resource set used for loading the meta-model resources.
	 */
	private static final ResourceSetImpl resourceSet = new ResourceSetImpl();

	/**
	 * Returns all EClasses imported into the given file.
	 * 
	 * @param file the GT file
	 */
	public static ArrayList<EClass> getClasses(final EditorGTFile file) {
		final ArrayList<EClass> classes = new ArrayList<>();
		file.getImports().forEach(i -> {
			if (i instanceof XMLImport) {
				var xi = (XMLImport) i;
				loadEcoreModel(XMLURI);
//				classes.add(); TODO load eClass for XML
			}
		});
		
		file.getImports()
		.stream().filter(i -> i instanceof EditorImport).map(i -> (EditorImport) i)
		.forEach(i -> {
			loadEcoreModel(i.getName()).ifPresent(m -> classes.addAll(getElements(m, EClass.class)));
		});
		return classes;
	}

	/**
	 * Returns all EDataTypes imported into the given file.
	 * 
	 * @param file the GT file
	 */
	public static ArrayList<EDataType> getDatatypes(final EditorGTFile file) {
		final ArrayList<EDataType> types = new ArrayList<>();
		file.getImports()
		.stream().filter(i -> i instanceof EditorImport).map(i -> (EditorImport) i)
		.forEach(i -> {
			loadEcoreModel(i.getName()).ifPresent(m -> types.addAll(getElements(m, EDataType.class)));
		});
		return types;
	}
	
	/**
	 * Returns all Enums imported into the given file.
	 * 
	 * @param file the GT file
	 */
	public static ArrayList<EEnum> getEnums(final EditorGTFile file) {
		final ArrayList<EEnum> types = new ArrayList<>();
		file.getImports()
		.stream().filter(i -> i instanceof EditorImport).map(i -> (EditorImport) i)
		.forEach(i -> {
			loadEcoreModel(i.getName()).ifPresent(m -> types.addAll(getElements(m, EEnum.class)));
		});
		return types;
	}

	/**
	 * Returns all objects from the given resource.
	 * 
	 * @param resource the resource
	 * @param type     the type
	 * @return the elements with the given type in the resource
	 */
	public static <T extends EObject> List<T> getElements(final Resource resource, final Class<T> type) {
		return EcoreUtil2.getAllContentsOfType(resource.getContents().get(0), type);
	}

	/**
	 * Returns an Optional for the Ecore model resource with the given URI.
	 * 
	 * @param uriString the URI of the resource to load
	 */
	public static Optional<Resource> loadEcoreModel(final String uriString) {
		final URI uri = URI.createURI(uriString);
		try {
			final Resource resource = new ResourceSetImpl().getResource(uri, true);
			resource.load(null);

			// Early return if the resource does not exist or is empty.
			if (resource.getContents().isEmpty()) {
				removeResource(uri);
				return Optional.empty();
			}

			// Add/update resource if necessary.
			if (!metaModelResources.containsKey(uri)
					|| metaModelResources.get(uri).getTimeStamp() < resource.getTimeStamp()) {
				updateResource(uri);
			}
			return Optional.of(metaModelResources.get(uri));
		} catch (final Exception e) {
			removeResource(uri);
			return Optional.empty();
		}
	}

	/**
	 * Removes the resource for the given URI from the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uri the URI to remove
	 * @return an empty optional
	 */
	private static void removeResource(final URI uri) {
		if (metaModelResources.containsKey(uri)) {
			final Resource resource = metaModelResources.get(uri);
			resource.unload();
			resourceSet.getResources().remove(resource);
			metaModelResources.remove(uri);
		}
	}

	/**
	 * Updates the resource for the given URI in the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uri the URI to update
	 * @throws IOException if the resource cannot be loaded
	 */
	private static void updateResource(final URI uri) throws IOException {
		// Remove resource if it was loaded before -> force reload.
		removeResource(uri);

		final Resource resource = resourceSet.getResource(uri, true);
		resource.load(null);
		EcoreUtil.resolveAll(resourceSet);
		metaModelResources.put(uri, resource);
	}
	
	/**
	 * Returns the source node of the editor reference.
	 * 
	 * @param editorReference
	 *            the editor reference
	 * @return the editor node
	 */
	public static EditorNode getSourceNode(final EditorReference editorReference) {
		return (EditorNode) editorReference.eContainer();
	}

	/**
	 * Returns the node of the editor attribute.
	 * 
	 * @param editorAttribute
	 *            the editor attribute
	 * @return the editor node
	 */
	public static EditorNode getNode(final EditorAttributeAssignment editorAttribute) {
		return (EditorNode) editorAttribute.eContainer();
	}
	
	/**
	 * Returns the node of the editor attribute.
	 * 
	 * @param editorAttribute
	 *            the editor attribute
	 * @return the editor node
	 */
	public static EditorPattern getPattern(final EditorAttributeConstraint editorAttribute) {
		return (EditorPattern) editorAttribute.eContainer();
	}

	/**
	 * Filters the nodes of the rule for the ones with the given operator.
	 * 
	 * @param editorPattern
	 *            the editor pattern
	 * @param operators
	 *            the operators
	 * @return the stream of nodes, sorted alphabetically by the name
	 */
	public static List<EditorNode> getNodesByOperator(final EditorPattern editorPattern,
			final EditorOperator... operators) {
		Objects.requireNonNull(editorPattern, "The editor pattern must not be null!");
		List<EditorOperator> operatorsList = Arrays.asList(operators);
		return editorPattern.getNodes().stream() //
				.filter(n -> operatorsList.contains(n.getOperator()))
				.sorted((a, b) -> a.getName().compareTo(b.getName())) //
				.collect(Collectors.toList());
	}

	/**
	 * Filters the references of the editor pattern for the ones with the given
	 * operator.
	 * 
	 * @param editorPattern
	 *            the editor pattern
	 * @param operators
	 *            the operators
	 * @return the stream of edges, sorted alphabetically by the type name
	 */
	public static List<EditorReference> getReferencesByOperator(final EditorPattern editorPattern,
			final EditorOperator... operators) {
		Objects.requireNonNull(editorPattern, "The editor pattern must not be null!");
		List<EditorOperator> operatorsList = Arrays.asList(operators);
		return editorPattern.getNodes().stream() //
				.flatMap(n -> n.getReferences().stream()) //
				.filter(r -> operatorsList.contains(r.getOperator()))
				.sorted((a, b) -> getTypeName(a).compareTo(getTypeName(b))) //
				.collect(Collectors.toList());
	}

	/**
	 * Returns the name of the type of the reference.
	 * 
	 * @param editorReference
	 *            the editor reference
	 * @return the name of the type (or the empty string if the type is
	 *         <code>null</code>)
	 */
	private static String getTypeName(final EditorReference editorReference) {
		if (editorReference.getType() == null || editorReference.getType().getName() == null) {
			return "";
		}
		return editorReference.getType().getName();
	}

	/**
	 * Checks whether a node is local.
	 * 
	 * @param editorNode
	 *            the editor node
	 * @return <code>true</code> if and only if the node is local
	 */
	public static boolean isLocal(final EditorNode editorNode) {
		return editorNode.getName().startsWith("_");
	}
}
