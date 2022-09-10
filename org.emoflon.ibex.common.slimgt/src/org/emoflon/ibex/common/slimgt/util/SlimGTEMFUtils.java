package org.emoflon.ibex.common.slimgt.util;

import java.io.IOException;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public final class SlimGTEMFUtils {
	public static EPackage loadMetamodel(URI uri) throws IOException {
		Optional<EPackage> metamodel = loadMetamodelInternal(uri.toString());
		if (metamodel.isPresent()) {
			return metamodel.get();
		} else {
			throw new IOException(
					"No registered metamodel or generated metamodel code found for: " + uri + ", can not load model.");
		}
	}

	public static EPackage loadMetamodel(String uri) throws IOException {
		Optional<EPackage> metamodel = loadMetamodelInternal(uri);
		if (metamodel.isPresent()) {
			return metamodel.get();
		} else {
			throw new IOException(
					"No registered metamodel or generated metamodel code found for: " + uri + ", can not load model.");
		}
	}

	private static Optional<EPackage> loadMetamodelInternal(String uri) throws IOException {
		String metamodelUri = uri.split("#")[0];
		EPackage metamodel = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
		if (metamodel == null || metamodel.eIsProxy()) {
			// Retry with Plugin or Resource
			if (metamodelUri.contains("platform:/resource/")) {
				metamodelUri = metamodelUri.replaceFirst("/resource/", "/plugin/");
				metamodel = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
			} else if (metamodelUri.contains("platform:/plugin/")) {
				metamodelUri = metamodelUri.replaceFirst("/plugin/", "/resource/");
				metamodel = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
			}
		} else {
			return Optional.of(metamodel);
		}

		// The metamodel is not registered in the global registry -> try loading it from
		// file.
		if (metamodel == null || metamodel.eIsProxy()) {
			ResourceSet rs = new ResourceSetImpl();
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
			EcorePackage.eINSTANCE.eClass();

			try {
				Resource resource = rs.getResource(URI.createURI(uri), true);
				metamodel = (EPackage) resource.getContents().get(0);
			} catch (Exception e) {
				return Optional.empty();
			}

			if (!(metamodel == null || metamodel.eIsProxy())) {
				return Optional.of(metamodel);
			}
		} else {
			return Optional.of(metamodel);
		}

		// Uri did not lead to a loadable metamodel
		return Optional.empty();
	}

}
