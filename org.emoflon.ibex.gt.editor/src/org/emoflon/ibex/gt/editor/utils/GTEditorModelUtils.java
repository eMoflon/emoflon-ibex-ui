package org.emoflon.ibex.gt.editor.utils;

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
import org.eclipse.xtext.EcoreUtil2;
import org.emoflon.ibex.gt.editor.gT.GraphTransformationFile;

/**
 * Utility methods for dealing with meta-models in
 * {@link GraphTransformationFile} models.
 */
public class GTEditorModelUtils {
	/**
	 * The set of meta-model resources loaded.
	 */
	private static Map<String, Resource> metaModelResources = new HashMap<String, Resource>();

	/**
	 * Returns all EClasses imported into the given file.
	 */
	public static ArrayList<EClass> getClasses(final GraphTransformationFile file) {
		final ArrayList<EClass> classes = new ArrayList<EClass>();
		file.getImports().forEach(i -> {
			loadEcoreModel(i.getName()).ifPresent(m -> classes.addAll(getElements(m, EClass.class)));
		});
		return classes;
	}

	/**
	 * Returns all EDataTypes imported into the given file.
	 */
	public static ArrayList<EDataType> getDatatypes(final GraphTransformationFile file) {
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
	 */
	public static Optional<Resource> loadEcoreModel(final String uri) {
		try {
			final ResourceSetImpl resourceSet = new ResourceSetImpl();
			final Resource resource = resourceSet.getResource(URI.createURI(uri), true);
			resource.load(null);

			// Add/update resource if necessary.
			if (!metaModelResources.containsKey(uri)
					|| metaModelResources.get(uri).getTimeStamp() < resource.getTimeStamp()) {
				metaModelResources.put(uri, resource);
			}
			return Optional.of(metaModelResources.get(uri));
		} catch (final Exception e) {
			return Optional.empty();
		}
	}
}
