package org.emoflon.ibex.common.slimgt.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;

public final class SlimGTEMFUtils {
	public static EPackage loadMetamodel(URI uri) throws IOException {
		return loadMetamodel(uri.toString());
	}

	public static EPackage loadMetamodel(String uri) throws IOException {
		String metamodelUri = uri.split("#")[0];
		EPackage metamodel = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
		if (metamodel == null || metamodel.eIsProxy()) {
			// Retry with Plugin or Resource
			if (metamodelUri.contains("platform:/resource/")) {
				metamodelUri = metamodelUri.replaceFirst("/resource/", "/plugin/");
				metamodel = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
				if (metamodel == null || metamodel.eIsProxy()) {
					throw new IOException("No registered metamodel or generated metamodel code found for: "
							+ metamodelUri + ", can not load model.");
				}
			} else if (metamodelUri.contains("platform:/plugin/")) {
				metamodelUri = metamodelUri.replaceFirst("/plugin/", "/resource/");
				metamodel = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
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

}
