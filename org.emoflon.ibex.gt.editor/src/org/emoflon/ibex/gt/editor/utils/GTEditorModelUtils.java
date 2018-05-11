package org.emoflon.ibex.gt.editor.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.emoflon.ibex.gt.editor.gT.EditorGTFile;

/**
 * Utility methods for dealing with meta-models.
 */
public class GTEditorModelUtils {
	/**
	 * The set of meta-model resources loaded.
	 */
	private static Map<String, Resource> metaModelResources = new HashMap<String, Resource>();

	/**
	 * The resource set used for loading the meta-model resources.
	 */
	private static final ResourceSetImpl resourceSet = new ResourceSetImpl();

	/**
	 * Returns all EClasses imported into the given file.
	 * 
	 * @param file
	 *            the GT file
	 */
	public static ArrayList<EClass> getClasses(final EditorGTFile file) {
		final ArrayList<EClass> classes = new ArrayList<EClass>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getName()).ifPresent(m -> classes.addAll(getElements(m, EClass.class)));
		});
		return classes;
	}

	/**
	 * Returns all EDataTypes imported into the given file.
	 * 
	 * @param file
	 *            the GT file
	 */
	public static ArrayList<EDataType> getDatatypes(final EditorGTFile file) {
		final ArrayList<EDataType> types = new ArrayList<EDataType>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getName()).ifPresent(m -> types.addAll(getElements(m, EDataType.class)));
		});
		return types;
	}

	/**
	 * Returns all objects from the given resource.
	 * 
	 * @param resource
	 *            the resource
	 * @param type
	 *            the type
	 * @return the elements with the given type in the resource
	 */
	public static <T extends EObject> List<T> getElements(final Resource resource, final Class<T> type) {
		return EcoreUtil2.getAllContentsOfType(resource.getContents().get(0), type);
	}

	/**
	 * Returns an Optional for the Ecore model resource with the given URI.
	 * 
	 * @param uriString
	 *            the URI of the resource to load
	 */
	public static Optional<Resource> loadEcoreModel(final String uriString) {
		try {
			URI uri = URI.createURI(uriString);
			final Resource resource = new ResourceSetImpl().getResource(uri, true);
			resource.load(null);

			// Early return if the resource does not exist or is empty.
			if (resource.getContents().isEmpty()) {
				removeResource(uriString);
				return Optional.empty();
			}

			// Add/update resource if necessary.
			if (!metaModelResources.containsKey(uriString)
					|| metaModelResources.get(uriString).getTimeStamp() < resource.getTimeStamp()) {
				updateResource(uriString);
			}
			return Optional.of(metaModelResources.get(uriString));
		} catch (final Exception e) {
			removeResource(uriString);
			return Optional.empty();
		}
	}

	/**
	 * Removes the resource for the given URI from the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uriString
	 *            the URI to remove
	 * @return an empty optional
	 */
	private static void removeResource(final String uriString) {
		URI uri = URI.createURI(uriString);
		resourceSet.getResources().removeIf(r -> r.getURI().equals(uri));
		metaModelResources.remove(uriString);
	}

	/**
	 * Updates the resource for the given URI in the resource set and the mapping
	 * between URIs and resources.
	 * 
	 * @param uriString
	 *            the URI to update
	 * @throws IOException
	 *             if the resource cannot be loaded
	 */
	private static void updateResource(final String uriString) throws IOException {
		URI uri = URI.createURI(uriString);
		resourceSet.getResources().removeIf(r -> r.getURI().equals(uri));
		Resource resource = resourceSet.getResource(uri, true);
		resource.load(null);
		EcoreUtil.resolveAll(resourceSet);
		metaModelResources.put(uriString, resource);
	}
}
