package org.emoflon.ibex.tgg.ui.debug.api;

import java.io.IOException;
import java.util.Collection;

public interface DataProvider {
    public Collection<Rule> getAllRules();

    public void saveModels(String[] saveLocations) throws IOException;

    public String[][] getDefaultSaveData();
}
