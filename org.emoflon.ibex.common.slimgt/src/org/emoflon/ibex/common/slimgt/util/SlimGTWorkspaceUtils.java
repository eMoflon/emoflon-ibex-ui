package org.emoflon.ibex.common.slimgt.util;

import java.io.File;
import java.util.Collection;

public final class SlimGTWorkspaceUtils {
	public static void gatherFilesWithEnding(Collection<File> gtFiles, File root, String ending, boolean ignoreBin) {
		if (root.isDirectory() && root.exists()) {
			if (ignoreBin && root.getName().equals("bin"))
				return;
			for (File subFile : root.listFiles()) {
				gatherFilesWithEnding(gtFiles, subFile, ending, ignoreBin);
			}
			return;
		} else if (!root.isDirectory() && root.exists()) {
			if (root.getName().endsWith(ending)) {
				gtFiles.add(root);
				return;
			}
		} else {
			return;
		}
	}
}
