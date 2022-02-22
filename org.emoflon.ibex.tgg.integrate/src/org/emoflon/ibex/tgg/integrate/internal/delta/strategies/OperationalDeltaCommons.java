package org.emoflon.ibex.tgg.integrate.internal.delta.strategies;

import java.util.Arrays;
import java.util.Collection;

import org.emoflon.ibex.tgg.compiler.patterns.PatternType;
import org.emoflon.ibex.tgg.operational.matches.ITGGMatch;

import language.TGGRule;

public class OperationalDeltaCommons {

	public static boolean ruleIsInAnyMatch(TGGRule rule, Collection<ITGGMatch> matches) {
		return matches.stream().anyMatch(match -> match.getRuleName().equals(rule.getName()));
	}


	public static boolean isOfType(ITGGMatch match, PatternType... types) {
		return Arrays.stream(types).anyMatch(type -> match.getType().equals(type));
	}
}
