package org.emoflon.ibex.common.slimgt.util;

import org.eclipse.emf.ecore.EObject;

public final class SlimGTModelUtil {
	@SuppressWarnings("unchecked")
	public static <T> T getContainer(EObject node, Class<T> clazz) {
		EObject current = node;
		while (current != null && !(current.getClass() == clazz)) {
			if (node.eContainer() == null)
				return null;

			current = current.eContainer();
		}
		return (T) current;
	}
}
