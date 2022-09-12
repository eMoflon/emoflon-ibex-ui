package org.emoflon.ibex.common.slimgt.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public final class SlimGTEMFUtils {
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
		return metamodel;
	}
	
	public static EPackage loadMetamodelInternal(String uri) throws IOException {
		var metamodel = EPackage.Registry.INSTANCE.getEPackage(uri);
		if (metamodel == null || metamodel.eIsProxy()) {
			var resourceSet = new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			EcorePackage.eINSTANCE.eClass();
			
			var resource = resourceSet.createResource(URI.createURI(uri));
			try {
			    resource.load(null);
			}
			catch(IOException e) {
				return null;
			}
			if(resource != null && !resource.getContents().isEmpty()) {
				if(resource.getContents().get(0) instanceof EPackage ePackage)
					metamodel = ePackage;
			}
		}
		
		return metamodel;
	}
	
}
