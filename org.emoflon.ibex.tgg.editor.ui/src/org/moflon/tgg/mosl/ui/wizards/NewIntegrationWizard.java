package org.moflon.tgg.mosl.ui.wizards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.INewWizard;
import org.emoflon.ibex.tgg.ide.admin.IbexTGGNature;
import org.moflon.core.utilities.LogUtils;
import org.moflon.core.utilities.MoflonUtil;
import org.moflon.core.utilities.WorkspaceHelper;
import org.moflon.tgg.mosl.defaults.AttrCondDefLibraryProvider;
import org.moflon.tgg.mosl.defaults.DefaultFilesHelper;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class NewIntegrationWizard extends AbstractMoflonWizard implements INewWizard {
	protected AbstractMoflonProjectInfoPage projectInfo;
	protected AbstractMoflonMetaModelSelectionPage srcSelection;
	protected AbstractMoflonMetaModelSelectionPage trgSelection;
	protected Set<String> importURIs;
	protected List<String> sourceMetamodelsNames;
	protected List<String> targetMetamodelsNames;

	private static final Logger logger = Logger.getLogger(NewIntegrationWizard.class);

	public static final String NEW_INTEGRATION_PROJECT_WIZARD_ID = "org.moflon.tgg.mosl.newIntegrationProject";

	@Override
	public void addPages() {
		importURIs = Sets.newHashSet();
		sourceMetamodelsNames = new ArrayList<String>();
		targetMetamodelsNames = new ArrayList<String>();
		projectInfo = new NewIntegrationProjectInfoPage();
		srcSelection = new NewIntegrationProjectSrcModelSelectionPage();
		trgSelection = new NewIntegrationProjectTrgModelSelectionPage();
		addPage(projectInfo);
		addPage(srcSelection);
		addPage(trgSelection);
	}

	@Override
	public IWizardPage getNextPage(IWizardPage currentPage) {
		if (currentPage == projectInfo && projectInfo.isSelectMetaModels()) {
			return srcSelection;
		} else if (currentPage == srcSelection) {
			return trgSelection;
		}

		return null;
	}

	protected void createProject(IProgressMonitor monitor, IProject project) throws CoreException {
		final SubMonitor subMon = SubMonitor.convert(monitor, "Creating " + project.getName(), 3);

		// Create project
		project.create(subMon.split(1));
		project.open(subMon.split(1));

		// Add Ibex TGG Nature
		WorkspaceHelper.addNature(project, IbexTGGNature.IBEX_TGG_NATURE_ID, subMon.split(1));
	}

	protected void generateDefaultFiles(final IProgressMonitor monitor, IProject project) throws CoreException {
		try {
			final SubMonitor subMon = SubMonitor.convert(monitor, "Generating default files", 3);
			String defaultSchema = DefaultFilesHelper.generateDefaultSchema(MoflonUtil.lastCapitalizedSegmentOf(project.getName()),
					Lists.newArrayList(importURIs), sourceMetamodelsNames, targetMetamodelsNames);
			IPath pathToSchema = new Path(IbexTGGNature.SCHEMA_FILE);
			WorkspaceHelper.addAllFoldersAndFile(project, pathToSchema, defaultSchema, subMon.split(1));
			WorkspaceHelper.addAllFolders(project, "src/org/emoflon/ibex/tgg/rules", subMon.split(1));
			WorkspaceHelper.addAllFolders(project, "model", subMon.split(1));
			AttrCondDefLibraryProvider.syncAttrCondDefLibrary(project);
		} catch (IOException e) {
			LogUtils.error(logger, e);
		}
	}

	private void getMetamodelURIs(IProgressMonitor monitor, Object[] selectedPackages, boolean isSource) {
		final SubMonitor subMon = SubMonitor.convert(monitor, "Getting metamodel URIs", 3);
		if (selectedPackages != null) {
			List<?> nsURIs = Arrays.asList(selectedPackages);
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(true));

			Map<String, URI> ePackageNsURItoGenModelLocationMapEnv = EcorePlugin
					.getEPackageNsURIToGenModelLocationMap(false);
			Map<String, URI> ePackageNsURItoGenModelLocationMapTrg = EcorePlugin
					.getEPackageNsURIToGenModelLocationMap(true);
			for (int i = 0, length = selectedPackages.length; i < length; i++) {
				URI location = ePackageNsURItoGenModelLocationMapEnv.get(selectedPackages[i]);
				if (location == null) {
					location = ePackageNsURItoGenModelLocationMapTrg.get(selectedPackages[i]);
				}
				if (location == null) {
					LogUtils.error(logger, "Package with URI %s not found", selectedPackages[i].toString());
					continue;
				}
				try {
					Resource resource = resourceSet.getResource(location, true);
					EcoreUtil.resolveAll(resource);
				} catch (RuntimeException e) {
					LogUtils.error(logger, "Error while loading resource with URI: %s", location.toString());
				}

			}

			subMon.worked(1);

			List<Resource> resources = resourceSet.getResources();

			for (Resource resource : resources) {
				for (EPackage ePackage : getAllPackages(resource)) {
					if (nsURIs.contains(ePackage.getNsURI())) {
						if (isSource)
							sourceMetamodelsNames.add(ePackage.getName());
						else
							targetMetamodelsNames.add(ePackage.getName());
						importURIs.add(resource.getURI().toString());
						break;
					}
				}
			}

			subMon.worked(2);
		}

		subMon.setWorkRemaining(0);
	}

	private Collection<EPackage> getAllPackages(Resource resource) {
		List<EPackage> result = new ArrayList<EPackage>();
		for (TreeIterator<?> j = new EcoreUtil.ContentTreeIterator<Object>(resource.getContents()) {
			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
				return eObject instanceof EPackage ? ((EPackage) eObject).getESubpackages().iterator()
						: Collections.<EObject>emptyList().iterator();
			}
		};j.hasNext();) {
			Object content = j.next();
			if (content instanceof EPackage) {
				result.add((EPackage) content);
			}
		}
		return result;
	}

	@Override
	protected void doFinish(final IProgressMonitor monitor) throws CoreException {
		try {
			final SubMonitor subMon = SubMonitor.convert(monitor, "Creating eMoflon::Ibex project", 12);

			String projectName = projectInfo.getProjectName();
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
			createProject(subMon.split(3), project);
			getMetamodelURIs(subMon.split(3), srcSelection.getSelectedMetaModels(), true);
			getMetamodelURIs(subMon.split(3), trgSelection.getSelectedMetaModels(), false);
			generateDefaultFiles(subMon.split(3), project);
		} catch (Exception e) {
			LogUtils.error(logger, e);
		}
	}
}
