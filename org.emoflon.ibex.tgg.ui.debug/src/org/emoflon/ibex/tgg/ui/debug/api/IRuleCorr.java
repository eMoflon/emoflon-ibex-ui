package org.emoflon.ibex.tgg.ui.debug.api;



public interface IRuleCorr extends IRuleNode{
	IRuleNode getSource();
	IRuleNode getTarget();
	String getTypeName();
}
