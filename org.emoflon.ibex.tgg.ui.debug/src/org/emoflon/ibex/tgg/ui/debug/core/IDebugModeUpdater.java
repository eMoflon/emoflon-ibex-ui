package org.emoflon.ibex.tgg.ui.debug.core;

import org.emoflon.ibex.tgg.ui.debug.api.enums.DebuggerMode;

public interface IDebugModeUpdater {
	
	public void setDebuggerMode(DebuggerMode newDebugMode);
	
	public DebuggerMode getDebuggerMode();
	
	public void step();

}
