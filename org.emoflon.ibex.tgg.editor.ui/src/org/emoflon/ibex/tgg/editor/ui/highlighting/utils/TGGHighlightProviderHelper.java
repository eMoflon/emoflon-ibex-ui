package org.emoflon.ibex.tgg.editor.ui.highlighting.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.emoflon.ibex.tgg.editor.ui.highlighting.TGGHighlightFactory;
import org.emoflon.ibex.tgg.editor.ui.highlighting.exceptions.IDAlreadyExistException;
import org.emoflon.ibex.tgg.editor.ui.highlighting.rules.AbstractHighlightingRule;

public class TGGHighlightProviderHelper {
	
	private static List<AbstractHighlightingRule> rules = new ArrayList<>(); 
	private static Set<String> ruleNames = new HashSet<>();
	
	public static void init(){
		rules.clear();
		ruleNames.clear();
		TGGHighlightFactory.createAllInstances();
		rules.sort(getComparator());
	}
	
	public static void addHighlightRule(AbstractHighlightingRule rule) throws IDAlreadyExistException{
		if(ruleNames.contains(rule.getID()))
			throw new IDAlreadyExistException();
		else{
			rules.add(rule);
			ruleNames.add(rule.getID());
		}
	}
	
	public static Collection<AbstractHighlightingRule> getHighlightRules(){
		return rules;
	}
	
	private static Comparator<? super AbstractHighlightingRule> getComparator(){
		return new Comparator<AbstractHighlightingRule>() {
			@Override
			public int compare(AbstractHighlightingRule rule1, AbstractHighlightingRule rule2) {
				return (int) Math.signum(rule2.getPriority()-rule1.getPriority());
			}
		};
	}
}
