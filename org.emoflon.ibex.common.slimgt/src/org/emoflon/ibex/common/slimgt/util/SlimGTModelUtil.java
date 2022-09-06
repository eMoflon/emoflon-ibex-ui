package org.emoflon.ibex.common.slimgt.util;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.emoflon.ibex.common.slimgt.slimGT.EditorFile;

public final class SlimGTModelUtil {
	@SuppressWarnings("unchecked")
	public static <T> T getContainer(EObject node, Class<T> clazz) {
		EObject current = node;
		while (current != null && !(current.getClass().isInstance(clazz))) {
			if (node.eContainer() == null)
				return null;

			current = current.eContainer();
		}
		return (T) current;
	}

	/**
	 * Returns all objects from the given resource.
	 * 
	 * @param resource the resource
	 * @param type     the type
	 * @return the elements with the given type in the resource
	 */
	public static <T extends EObject> Collection<T> getElements(final EObject model, final Class<T> type) {
		return EcoreUtil2.getAllContentsOfType(model, type);
	}

	/**
	 * Returns all EDataTypes imported into the given file.
	 * 
	 * @param file the SlimGT file
	 */
	public static Collection<EDataType> getDatatypes(final EditorFile file) {
		return file.getImports().stream().map(i -> {
			try {
				return Optional.of(SlimGTEMFUtils.loadMetamodel(i.getName()));
			} catch (Exception e) {
				return Optional.empty();
			}
		}).filter(model -> model.isPresent())
				.flatMap(model -> getElements((EObject) model.get(), EDataType.class).stream())
				.collect(Collectors.toSet());
	}

	/**
	 * Returns all EClasses imported into the given file.
	 * 
	 * @param file the SlimGT file
	 */
	public static Collection<EClass> getClasses(final EditorFile file) {
		return file.getImports().stream().map(i -> {
			try {
				return Optional.of(SlimGTEMFUtils.loadMetamodel(i.getName()));
			} catch (Exception e) {
				return Optional.empty();
			}
		}).filter(model -> model.isPresent())
				.flatMap(model -> getElements((EObject) model.get(), EClass.class).stream())
				.collect(Collectors.toSet());
	}
}
