package org.emoflon.ibex.common.slimgt.util;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.EcoreUtil2;
import org.emoflon.ibex.common.slimgt.slimGT.EditorFile;

public final class SlimGTModelUtil {
	@SuppressWarnings("unchecked")
	public static <T> T getContainer(EObject node, Class<T> clazz) {
		EObject current = node;
		while (current != null && !(clazz.isInstance(current))) {
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
		Set<EDataType> dataTypes = file.getImports().stream().map(i -> {
			try {
				return Optional.of(SlimGTEMFUtils.loadMetamodel(i.getName()));
			} catch (Exception e) {
				return Optional.empty();
			}
		}).filter(model -> model.isPresent())
				.flatMap(model -> getElements((EObject) model.get(), EDataType.class).stream())
				.collect(Collectors.toSet());
		dataTypes.addAll(getElements(EcorePackage.eINSTANCE, EDataType.class));

		return dataTypes;
	}
	
	
	
	/**
	 * Returns all EPackages imported into the given file
	 * 
	 * @param file the SlimGT file
	 */
	public static Collection<EPackage> getPackages(final EditorFile file) {
		var imports = file.getImports();
		var allPackages = new HashSet<EPackage>();
		
		for(var imp : imports) {
			EPackage ePackage = null;
			try {
				ePackage = SlimGTEMFUtils.loadMetamodel(imp.getName());
			} catch (Exception e) {
			}
			
			if(ePackage == null)
				continue;
			
			allPackages.add(ePackage);
			allPackages.addAll(getElements((EObject) ePackage, EPackage.class));
		}
		return allPackages;
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

	/**
	 * Returns all Enums imported into the given file.
	 * 
	 * @param file the GT file
	 */
	public static Collection<EEnum> getEnums(final EditorFile file) {
		return file.getImports().stream().map(i -> {
			try {
				return Optional.of(SlimGTEMFUtils.loadMetamodel(i.getName()));
			} catch (Exception e) {
				return Optional.empty();
			}
		}).filter(model -> model.isPresent()).flatMap(model -> getElements((EObject) model.get(), EEnum.class).stream())
				.collect(Collectors.toSet());
	}
}
