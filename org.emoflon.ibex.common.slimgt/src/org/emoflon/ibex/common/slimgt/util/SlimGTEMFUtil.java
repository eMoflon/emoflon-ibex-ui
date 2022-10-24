package org.emoflon.ibex.common.slimgt.util;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.pde.core.plugin.IPluginAttribute;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginObject;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.plugin.PluginElement;
import org.eclipse.xtext.EcoreUtil2;
import org.moflon.core.utilities.ProxyResolver;

@SuppressWarnings("restriction")
public final class SlimGTEMFUtil {
	public static EPackage loadMetamodel(URI uri) throws IOException {
		return loadMetamodel(uri.toString());
	}

	public static EPackage loadMetamodel(String uri) throws IOException {
		String metamodelUri = uri.split("#")[0];
		EPackage metamodel = loadMetamodelInternal(metamodelUri);
		if (metamodel == null || metamodel.eIsProxy()) {
			// Retry with Plugin or Resource
			if (metamodelUri.contains("platform:/resource/")) {
				metamodelUri = metamodelUri.replaceFirst("/resource/", "/plugin/");
				metamodel = loadMetamodelInternal(metamodelUri);
				if (metamodel == null || metamodel.eIsProxy()) {
					throw new IOException("No registered metamodel or generated metamodel code found for: "
							+ metamodelUri + ", can not load model.");
				}
			} else if (metamodelUri.contains("platform:/plugin/")) {
				metamodelUri = metamodelUri.replaceFirst("/plugin/", "/resource/");
				metamodel = loadMetamodelInternal(metamodelUri);
				if (metamodel == null || metamodel.eIsProxy()) {
					throw new IOException("No registered metamodel or generated metamodel code found for: "
							+ metamodelUri + ", can not load model.");
				}
			} else {
				throw new IOException("No registered metamodel or generated metamodel code found for: " + metamodelUri
						+ ", can not load model.");
			}
		}

		EcoreUtil2.resolveLazyCrossReferences(metamodel.eResource(), () -> false);
		EcoreUtil2.resolveAll(metamodel, () -> false);

		return metamodel;
	}

	public static EPackage loadMetamodelInternal(String uri) throws IOException {
		EPackage metamodel = EPackage.Registry.INSTANCE.getEPackage(uri);
		if (metamodel == null || metamodel.eIsProxy()) {
			ResourceSet resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
					new EcoreResourceFactoryImpl());
			EcorePackage.eINSTANCE.eClass();

			Resource resource = resourceSet.createResource(URI.createURI(uri));
			try {
				resource.load(null);
			} catch (IOException e) {
				return null;
			}
			if (resource != null && !resource.getContents().isEmpty()) {
				if (resource.getContents().get(0) instanceof EPackage ePackage)
					metamodel = ePackage;
			}
		}

		return metamodel;
	}

	public static IProject getProjectOfEPackage(final IProject current, final EPackage ePack) {
		IWorkspace workspace = current.getWorkspace();
		for (IProject project : workspace.getRoot().getProjects()) {
			if (project.equals(current))
				continue;

			IPluginModelBase pluginmodel = PluginRegistry.findModel(project);
			if (pluginmodel == null)
				continue;

			IPluginBase pluginBase = pluginmodel.getPluginBase();
			IPluginExtension[] ipe = pluginBase.getExtensions();

			for (IPluginExtension extensionPoint : ipe) {
				if ("org.eclipse.emf.ecore.generated_package".equals(extensionPoint.getPoint())) {
					IPluginObject[] children = extensionPoint.getChildren();
					for (IPluginObject child : children) {
						if (child instanceof PluginElement) {
							PluginElement element = (PluginElement) child;
							IPluginAttribute attribute = element.getAttribute("uri");
							if (attribute == null)
								continue;

							if (!ePack.getNsURI().equals(attribute.getValue()))
								continue;

							return project;

						}
					}
				}

			}
		}

		return null;
	}

	public static GenModel getGenModel(final EPackage ePack) {
		EPackage ePackage = ePack;
		while (ePackage.getESuperPackage() != null) {
			ePackage = ePackage.getESuperPackage();
		}
		URI uri = EcoreUtil.getURI(ePackage).trimFragment();
		String platformURI = uri.toString();

		// create resource and plugin uris if possible
		String pkgURI = ePackage.getNsURI();
		if (!pkgURI.contains("platform:/") && platformURI.contains("platform:/")) {
			pkgURI = platformURI;
		}
		String genModelURI = pkgURI.replace(".ecore", ".genmodel");
		String resourceURI = "";
		String pluginURI = "";
		if (genModelURI.contains("/resource/")) {
			resourceURI = genModelURI;
			pluginURI = genModelURI.replace("/resource/", "/plugin/");
		}
		if (genModelURI.contains("/plugin/")) {
			pluginURI = genModelURI;
			resourceURI = genModelURI.replace("/plugin/", "/resource/");
		}

		if (!genModelURI.contains("/resource/") && !genModelURI.contains("/plugin/")) {
			resourceURI = genModelURI.replace("platform:/", "platform:/resource/");
			pluginURI = genModelURI.replace("platform:/", "platform:/plugin/");
		}

		// try to load models from resource
		GenModel genModel = loadGenModelFromResource(platformURI.replace(".ecore", ".genmodel"));
		if (genModel != null) {
			return genModel;
		}

		genModel = loadGenModelFromResource(genModelURI);
		if (genModel != null) {
			return genModel;
		}
		genModel = loadGenModelFromResource(resourceURI);
		if (genModel != null) {
			return genModel;
		}
		genModel = loadGenModelFromResource(pluginURI);
		if (genModel != null) {
			return genModel;
		}

		return genModel;
	}

	public static GenModel loadGenModelFromResource(String uri) {
		// load resource
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI(uri));
		try {
			resource.load(null);
			if (resource.getContents().isEmpty())
				return null;

			if (resource.getContents().get(0) instanceof GenModel content) {
				// get rid of eproxies
				EcoreUtil.resolveAll(content);

				GenPackage genPkg = content.getGenPackages().get(0);
				if (genPkg.getEcorePackage().eIsProxy()) {
					InternalEObject intEPkg = (InternalEObject) genPkg.getEcorePackage();
					genPkg.setEcorePackage(ProxyResolver.resolvePackage(intEPkg.eProxyURI().trimFragment()));
				}

				return content;
			}

			return null;
		} catch (Exception e) {
			return null;
		}
	}

	public static String getFQName(GenPackage genPackage) {
		return getFQPackageName(genPackage);
	}

	public static String getFQName(EPackage ePackage) {
		GenPackage genPackage = getGenPack(ePackage);
		if (genPackage == null)
			return "";

		return getFQName(genPackage);
	}

	public static GenPackage getGenPack(EPackage ePackage) {
		GenModel genModel = getGenModel(ePackage);
		if (genModel == null)
			return null;

		GenPackage genPack = searchGenPackage(genModel.getGenPackages(), ePackage);
		return genPack;
	}

	public static GenPackage searchGenPackage(Collection<GenPackage> genpacks, EPackage epack) {
		for (GenPackage genpack : genpacks) {
			if (epack.getNsURI().equals(genpack.getEcorePackage().getNsURI())) {
				return genpack;
			}
			GenPackage foundGenPack = searchGenPackage(genpack.getSubGenPackages(), epack);
			if (foundGenPack != null) {
				return foundGenPack;
			}
		}
		return null;
	}

	public static String getFQPackageName(GenPackage genPackage) {
		String prefix = "";
		if (genPackage.getBasePackage() != null && !genPackage.getBasePackage().isEmpty())
			prefix += genPackage.getBasePackage() + ".";
		prefix += genPackage.getEcorePackage().getName();
		if (genPackage.getInterfacePackageSuffix() != null && !genPackage.getInterfacePackageSuffix().isEmpty())
			prefix += "." + genPackage.getInterfacePackageSuffix();
		return prefix;
	}

	public static String getFQName(EClassifier eClass) {
		if (eClass.getInstanceClassName() != null) {
			return eClass.getInstanceClassName();
		} else {
			return getFQName(eClass.getEPackage()) + "." + eClass.getName();
		}
	}

	public static String getPackageClassName(EPackage pkg) {
		if (!"EPackageImpl".equals(pkg.getClass().getSimpleName())) {
			String className = pkg.getClass().getSimpleName();
			int implIdx = className.lastIndexOf("Impl");
			return className.substring(0, implIdx);
		}
		return pkg.getName().substring(0, 1).toUpperCase() + pkg.getName().substring(1, pkg.getName().length())
				+ "Package";
	}

	public static String getPackageClassName(GenPackage genPackage) {
		return getPackageClassName(genPackage.getEcorePackage());
	}

	public static String getMetadataSuffix(GenPackage genPackage) {
		String prefix = "";
		if (genPackage.getBasePackage() != null && !genPackage.getBasePackage().isEmpty())
			prefix += genPackage.getBasePackage() + ".";
		prefix += genPackage.getEcorePackage().getName();
		if (genPackage.getMetaDataPackageSuffix() != null && !genPackage.getMetaDataPackageSuffix().isEmpty())
			prefix += "." + genPackage.getMetaDataPackageSuffix();
		return prefix;
	}

	public static String getFactoryClassName(GenPackage genPackage) {
		String fqName = getMetadataSuffix(genPackage);
		fqName += "." + genPackage.getEcorePackage().getName().substring(0, 1).toUpperCase()
				+ genPackage.getEcorePackage().getName().substring(1, genPackage.getEcorePackage().getName().length())
				+ "Factory";
		return fqName;
	}

	public static boolean hasEEnums(GenPackage genPackage) {
		return !getEEnums(genPackage).isEmpty();
	}

	public static Collection<EEnum> getEEnums(GenPackage genPackage) {
		EPackage ePack = genPackage.getEcorePackage();
		return ePack.getEClassifiers().stream().filter(c -> (c instanceof EEnum)).map(c -> (EEnum) c)
				.collect(Collectors.toSet());
	}

	public static Collection<EClass> getEClasses(GenPackage genPackage) {
		EPackage ePack = genPackage.getEcorePackage();
		return ePack.getEClassifiers().stream().filter(c -> (c instanceof EClass)).map(c -> (EClass) c)
				.collect(Collectors.toSet());
	}

}
