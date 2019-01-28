package org.emoflon.ibex.gt.editor.utils;

import java.util.HashSet;
import java.util.Set;

import org.emoflon.ibex.gt.editor.gT.EditorApplicationCondition;
import org.emoflon.ibex.gt.editor.gT.EditorCondition;
import org.emoflon.ibex.gt.editor.gT.EditorConditionReference;
import org.emoflon.ibex.gt.editor.gT.EditorSimpleCondition;

/**
 * Utility class to flatten {@link EditorConditionReference}s.
 */
public class GTConditionHelper {
	private final Set<EditorApplicationCondition> applicationConditions = new HashSet<>();
	private final Set<EditorCondition> visitedConditions = new HashSet<>();
	private boolean hasIllegalReferences = false;

	/**
	 * Initializes a new GTConditionHelper for the given condition
	 * 
	 * @param condition the condition
	 */
	public GTConditionHelper(final EditorCondition condition) {
		visit(condition);
	}

	private void visit(final EditorCondition condition) {
		visitedConditions.add(condition);

		for (final EditorSimpleCondition c : condition.getConditions()) {
			visit(c);
		}
	}

	private void visit(final EditorSimpleCondition simpleCondition) {
		if (simpleCondition instanceof EditorApplicationCondition) {
			applicationConditions.add((EditorApplicationCondition) simpleCondition);
		} else if (simpleCondition instanceof EditorConditionReference) {
			final EditorCondition referencedCondition = ((EditorConditionReference) simpleCondition).getCondition();
			if (visitedConditions.contains(referencedCondition)) {
				hasIllegalReferences = true;
			} else {
				visit(referencedCondition);
			}
		}
	}

	/**
	 * Returns all enforce and forbid conditions of the condition.
	 * 
	 * @return the enforce and forbid conditions
	 */
	public Set<EditorApplicationCondition> getApplicationConditions() {
		return applicationConditions;
	}

	/**
	 * Checks whether the condition has self references.
	 * 
	 * @return <code>true</code> if and only if the condition references itself
	 */
	public boolean hasSelfReference() {
		return hasIllegalReferences;
	}
}
