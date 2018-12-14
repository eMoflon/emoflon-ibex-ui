package org.emoflon.ibex.tgg.ide.visualisation;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.emoflon.ibex.tgg.ide.admin.IbexTGGBuilder;
import org.emoflon.ibex.tgg.ide.transformation.EditorEMFtoFlattenedEMF;
import org.moflon.core.ui.visualisation.EMoflonPlantUMLGenerator;
import org.moflon.core.ui.visualisation.common.EMoflonVisualiser;
import org.moflon.core.utilities.MoflonUtil;
import org.moflon.tgg.mosl.tgg.EMFFile;

public class IbexEMFVisualiser extends EMoflonVisualiser{
	
	private Logger logger = Logger.getLogger(IbexEMFVisualiser.class);
	
	private Optional<String> lastDiagramBody = Optional.empty();
	

	@Override
	public boolean supportsEditor(IEditorPart arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String getDiagramBody(IEditorPart editor, ISelection selection) {
		// TODO Auto-generated method stub
		try {
			String body = maybeVisualiseEMFRule(editor, selection) //
						.orElse(maybeVisualiseEMFSchema(editor, selection)//
						.orElse(defaultDiagramBody()));
			lastDiagramBody = Optional.of(body);
		} 
		catch (Exception e) 
		{
			logger.warn("Unable to visualise current state in editor, reverting to last diagram if available.");
		}
		return defaultDiagramBody();
	}
	
	private Optional<String> maybeVisualiseEMFRule(IEditorPart editor, ISelection selection) {
		// TODO Auto-generated method stub
		return extractEMFFileFromEditor(editor) //
				.map(file -> file.getSchema() == null ? file : null) //
				.map(file -> visualise(file, selection));
	}

	private String visualise(EMFFile file, ISelection selection) {
		// TODO Auto-generated method stub
		Optional<EMFFile> flattenedOptional = flatten(file);
		
		return null;
	}

	private Optional<EMFFile> flatten(EMFFile file) {
		// TODO Auto-generated method stub
		return new EditorEMFtoFlattenedEMF().flatten(file);
	}

	//code added by Nikita
	private Optional<String> maybeVisualiseEMFSchema(IEditorPart editor, ISelection selection){
		try
		{
			return extractEMFFileFromEditor(editor) 					
					.filter(file -> file.getSchema() != null)
					.map(file -> file.eResource().getURI().segment(1))
					.map(projectName -> IbexPlantUMLGenerator.visualiseEMFRuleOverview(projectName,
							loadEMF(projectName)));			
		}
		catch(Exception e)
		{
			return Optional.empty();
		}
	}
	//end

	private EMFFile loadEMF(String projectName) {
		ResourceSet rs = new ResourceSetImpl();
		Resource tgg = rs.getResource(URI.createPlatformResourceURI(projectName + "/" + IbexTGGBuilder.MODEL_FOLDER
				+ "/" + MoflonUtil.lastCapitalizedSegmentOf(projectName) + IbexTGGBuilder.EDITOR_MODEL_EXTENSION, true),
				true);
		return (EMFFile) tgg.getContents().get(0);
	}
	
	private String defaultDiagramBody() {
		// TODO Auto-generated method stub
		return lastDiagramBody.orElse(EMoflonPlantUMLGenerator.errorDiagram());
	}
	
	//code added by Nikita
	private Optional<EMFFile> extractEMFFileFromEditor(IEditorPart editor){
		try 
		{
			return Optional.of(editor) //
					.flatMap(maybeCast(XtextEditor.class)) //
					.map(e -> e.getDocument().readOnly(res -> res.getContents().get(0)))
					.flatMap(maybeCast(EMFFile.class));
		}
		catch(Exception e)
		{
			return Optional.empty();
		}
	}
	//end
	
}