package org.emoflon.ibex.common.slimgt.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.XtextResourceSet;

public class XtextResourceManager {
	protected Map<Resource, Map<URI, Resource>> resourceCache = new HashMap<>();

	public Resource loadResource(final Resource requester, final URI gtModelUri) {
		Map<URI, Resource> cache = resourceCache.get(requester);
		if (cache == null) {
			cache = new HashMap<>();
			resourceCache.put(requester, cache);
		}

		Resource other = cache.get(gtModelUri);
		if (other == null) {
			XtextResourceSet rs = new XtextResourceSet();
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
	
	public Resource loadResource(final XtextResourceSet rs, final Resource requester, final URI gtModelUri) {
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
