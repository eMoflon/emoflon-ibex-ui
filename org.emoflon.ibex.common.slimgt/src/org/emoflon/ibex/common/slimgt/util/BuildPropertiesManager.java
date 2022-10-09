package org.emoflon.ibex.common.slimgt.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;

public class BuildPropertiesManager {

	final protected IProject project;
	protected File bpFile;
	protected Map<String, Set<String>> attribute2values = new LinkedHashMap<>();

	public BuildPropertiesManager(final IProject project) throws IOException {
		this.project = project;
		bpFile = new File(project.getLocation() + "/build.properties");

		if (hasProperites())
			loadProperties();
	}

	public boolean hasProperites() {
		return bpFile.exists();
	}

//	public boo

	protected void loadProperties() throws IOException {
		String content = Files.readString(bpFile.toPath());
		String[] lines = content.split("\n");
		String currentAttribute = null;
		Set<String> currentValues = null;
		for (String line : lines) {
			if (line.contains("=")) {
				String[] block = line.split("=");
				currentAttribute = block[0].trim();
				currentValues = attribute2values.get(currentAttribute);
				if (currentValues == null) {
					currentValues = new LinkedHashSet<>();
					attribute2values.put(currentAttribute, currentValues);
				}
				// Just to be sure: Split the current line at the value denominator ',\'
				String[] lineValues = block[1].split(",\\");
				for (String value : lineValues) {
					currentValues.add(value.trim());
				}
			} else {
				// Just to be sure: Split the current line at the value denominator ',\'
				String[] lineValues = line.split(",\\");
				for (String value : lineValues) {
					currentValues.add(value.trim());
				}
			}
		}
	}
}
