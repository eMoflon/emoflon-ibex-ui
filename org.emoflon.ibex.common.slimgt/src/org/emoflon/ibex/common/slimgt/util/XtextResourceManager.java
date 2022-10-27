package org.emoflon.ibex.common.slimgt.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.moflon.core.utilities.LogUtils;

public class XtextResourceManager {
	Logger logger = Logger.getLogger(XtextResourceManager.class);
	protected Map<Resource, Map<URI, Resource>> resourceCache = new HashMap<>();

	public Resource loadResource(final Resource requester, final URI gtModelUri) {
		IProject currentProject = SlimGTWorkspaceUtil.getCurrentProject(requester);

		Map<URI, Resource> cache = resourceCache.get(requester);
		if (cache == null) {
			cache = new HashMap<>();
			resourceCache.put(requester, cache);
		}

		// Prevent the requester trying to load itself again
		try {
			String fs = (requester.getURI().toFileString() == null) ? requester.getURI().toPlatformString(true)
					: requester.getURI().toFileString();
			fs = (fs.charAt(0) == '/') ? fs.replaceFirst("/", "") : fs;
			// Try project relative
			String absoluteRSPath = Paths.get(currentProject.getLocation().toPortableString()).resolve(Paths.get(fs))
					.toFile().getCanonicalPath();
			// Try workspace relative
			if (!new File(absoluteRSPath).exists())
				absoluteRSPath = Paths.get(currentProject.getLocation().toPortableString() + "/../")
						.resolve(Paths.get(fs)).toFile().getCanonicalPath();
			if (!new File(absoluteRSPath).exists())
				throw new IOException("Given path <" + fs + "> could not be resolved. File does probably not exist.");

			if (absoluteRSPath != null && absoluteRSPath.equals(gtModelUri.toFileString())) {
				cache.put(gtModelUri, requester);
				return requester;
			}
		} catch (Exception e1) {
			LogUtils.error(logger, e1);
		}

		Resource other = cache.get(gtModelUri);
		if (other == null) {
			XtextResourceSet rs = (XtextResourceSet) requester.getResourceSet();
			rs.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			try {
				other = rs.getResource(gtModelUri, true);
			} catch (Exception e) {
				return other;
			}
			cache.put(gtModelUri, other);

			if (other == null)
				return other;

//			EcoreUtil2.resolveLazyCrossReferences(other, () -> false);
		}

		return other;
	}

	public Resource loadResource(final ResourceSet rs, final Resource requester, final URI gtModelUri) {
		Map<URI, Resource> cache = resourceCache.get(requester);
		if (cache == null) {
			cache = new HashMap<>();
			resourceCache.put(requester, cache);
		}

		Resource other = cache.get(gtModelUri);
		if (other == null) {
			try {
				other = rs.getResource(gtModelUri, true);
			} catch (Exception e) {
				return other;
			}
			cache.put(gtModelUri, other);

			if (other == null)
				return other;

			EcoreUtil2.resolveLazyCrossReferences(other, () -> false);
		}

		return other;
	}
}
