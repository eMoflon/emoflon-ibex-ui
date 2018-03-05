package org.moflon.util;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.moflon.core.utilities.LogUtils;

public class IbexUtil {
	
	private static final Logger logger = Logger.getLogger(IbexUtil.class);
	
	public static <T> Collection<T> collectExtensions(String extensionID, String property, Class<T> extensionType) {
		Collection<T> extensions = new ArrayList<T>();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionID);
		try {
			for (IConfigurationElement e : config) {
				logger.debug("Evaluating extension");
				final Object o = e.createExecutableExtension(property);
				if (extensionType.isInstance(o)) {
					extensions.add(extensionType.cast(o));
				}
			}
		} catch (CoreException ex) {
			LogUtils.error(logger, ex);
		}

		return extensions;
	} 
}
