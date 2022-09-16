package org.emoflon.ibex.common.slimgt.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.xtext.EcoreUtil2;

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

}
