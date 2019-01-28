package org.emoflon.ibex.gt.editor.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.emoflon.ibex.gt.editor.gT.EditorAttribute;
import org.emoflon.ibex.gt.editor.gT.EditorNode;
import org.emoflon.ibex.gt.editor.gT.EditorOperator;
import org.emoflon.ibex.gt.editor.gT.EditorRelation;

/**
 * Utility methods for flattening of patterns.
 */
public class GTFlatteningUtils {

	/**
	 * Returns the operator if elements with the two given elements are merged.
	 * 
	 * @param a the operator of the first element
	 * @param b the operator of the second element
	 * @return the operator of the merged element
	 */
	public static Optional<EditorOperator> mergedOperators(final EditorOperator a, final EditorOperator b) {
		if (a.equals(b)) {
			return Optional.of(a);
		}

		// Context overwrites create/delete.
		if (a == EditorOperator.CONTEXT || b == EditorOperator.CONTEXT) {
			return Optional.of(EditorOperator.CONTEXT);
		}

		return Optional.empty();
	}

	/**
	 * Returns the operator if elements with the two given elements are merged.
	 * 
	 * @param operators the operators
	 * @return an Optional for the operator of the merged element. The Optional is
	 *         empty if and only if no operator can be derived according to the
	 *         flattening algorithm.
	 */
	public static Optional<EditorOperator> mergeOperators(final EditorOperator... operators) {
		if (operators.length < 1) {
			return Optional.empty();
		}
		EditorOperator result = operators[0];
		for (int i = 1; i < operators.length; i++) {
			final Optional<EditorOperator> o = mergedOperators(result, operators[i]);
			if (o.isPresent()) {
				result = o.get();
			} else {
				return Optional.empty();
			}
		}
		return Optional.of(result);
	}

	/**
	 * Returns the lowest type of the given classes.
	 * 
	 * @param classes the types
	 * @return the merged type
	 */
	private static EClass mergeTypes(final List<EClass> classes) {
		EClass result = classes.get(0);
		for (int i = 1; i < classes.size(); i++) {
			if (result.isSuperTypeOf(classes.get(i))) {
				result = classes.get(i);
			}
		}
		return result;
	}

	/**
	 * Checks whether the nodes have conflicting type declarations.
	 * 
	 * @param nodes the nodes
	 * @return the type declarations which are not compatible with the merged type
	 */
	public static Set<EClass> getConflictingNodeTypes(final Set<EditorNode> nodes) {
		final List<EClass> types = nodes.stream() //
				.filter(n -> n.getType() != null) //
				.map(n -> n.getType()) //
				.distinct() //
				.collect(Collectors.toList());
		final EClass mergedType = mergeTypes(types);

		final Set<EClass> conflictingTypes = new HashSet<>();
		for (final EClass typeToTest : types) {
			if (!typeToTest.isSuperTypeOf(mergedType)) {
				conflictingTypes.add(mergedType);
				conflictingTypes.add(typeToTest);
			}
		}
		return conflictingTypes;
	}

	/**
	 * Checks whether the node has any attribute assignment for the same attribute,
	 * but another value.
	 * 
	 * @param node      the node to check
	 * @param attribute the attribute assignment to check
	 * @return <code>true</code> if and only if the node has another assignment for
	 *         the same attribute
	 */
	public static boolean hasConflictingAssignment(final EditorNode node, final EditorAttribute attribute) {
		final boolean isAssignment = attribute.getRelation() == EditorRelation.ASSIGNMENT;
		return isAssignment && !node.getAttributes().stream().filter(
				a -> a.getRelation() == EditorRelation.ASSIGNMENT && a.getAttribute().equals(attribute.getAttribute()))
				.allMatch(a -> GTEditorAttributeComparator.areExpressionsEqual(a.getValue(), attribute.getValue()));
	}

	/**
	 * Checks whether the nodes have conflicting assignments.
	 * 
	 * @param nodes the nodes
	 * @return <code>true</code> if and only if there are multiple, different
	 *         assignments for the same attribute
	 */
	public static boolean hasConflictingAssignment(final Set<EditorNode> nodes) {
		final List<EditorAttribute> assignments = nodes.stream() //
				.flatMap(n -> n.getAttributes().stream()) //
				.filter(a -> a.getRelation() == EditorRelation.ASSIGNMENT) //
				.collect(Collectors.toList());

		final HashMap<EAttribute, EditorAttribute> attributeAssignments = new HashMap<>();
		for (final EditorAttribute assignment : assignments) {
			if (attributeAssignments.containsKey(assignment.getAttribute())) {
				// Check whether the assignment is compatible with assignment in map
				if (!GTEditorAttributeComparator.areAttributeConstraintsEqual(assignment,
						attributeAssignments.get(assignment.getAttribute()))) {
					return true;
				}
			} else {
				attributeAssignments.put(assignment.getAttribute(), assignment);
			}
		}
		return false;
	}
}
