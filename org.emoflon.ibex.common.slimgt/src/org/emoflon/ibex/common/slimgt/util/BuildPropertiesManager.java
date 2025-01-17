package org.emoflon.ibex.common.slimgt.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;

import com.google.common.base.Strings;

public class BuildPropertiesManager {

	final protected IProject project;
	protected File bpFile;
	protected Map<String, Set<String>> attribute2values = new LinkedHashMap<>();
	protected boolean dirty = false;

	public BuildPropertiesManager(final IProject project) throws IOException {
		this.project = project;
		bpFile = new File(project.getLocation() + "/build.properties");

		if (hasProperites())
			loadProperties();
	}

	public boolean hasProperites() {
		return bpFile.exists();
	}

	public boolean hasAttribute(final String attribute) {
		return attribute2values.containsKey(attribute);
	}

	public boolean hasValue(final String attribute, final String value) {
		Set<String> values = attribute2values.get(attribute);
		if (values == null) {
			return false;
		}

		return values.contains(value);
	}

	public void addAttributeValue(final String attribute, final String value) {
		Set<String> values = attribute2values.get(attribute);
		if (values == null) {
			values = new LinkedHashSet<>();
			attribute2values.put(attribute, values);
		}

		if (!values.contains(value)) {
			values.add(value);
			dirty = true;
		}
	}

	public void setAttributeValues(final String attribute, final Collection<String> values) {
		Set<String> otherValues = attribute2values.get(attribute);
		if (values == null) {
			otherValues = new LinkedHashSet<>(values);
			attribute2values.put(attribute, otherValues);
			dirty = true;
			return;
		}

		for (String value : values) {
			if (!otherValues.contains(value)) {
				otherValues.add(value);
			} else {
				continue;
			}
		}
	}

	public void writeBack() {
		if (!dirty)
			return;

		StringBuilder sb = new StringBuilder();
		for (String attribute : attribute2values.keySet()) {
			String attributeDeclaration = attribute + " = ";
			sb.append(attributeDeclaration);

			LinkedList<String> values = new LinkedList<>(attribute2values.get(attribute));
			sb.append(values.poll());
			if (!values.isEmpty()) {
				sb.append(",\\\n");
			} else {
				sb.append("\n");
				return;
			}

			while (values.size() > 1) {
				sb.append(Strings.repeat(" ", attributeDeclaration.length()));
				sb.append(values.poll());
				sb.append(",\\\n");
			}

			sb.append(Strings.repeat(" ", attributeDeclaration.length()));
			sb.append(values.poll());
			sb.append("\n");
		}
	}

	protected void loadProperties() throws IOException {
		String content = Files.readString(bpFile.toPath());
		String[] lines = content.split("\\n");
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
				String[] lineValues = block[1].split(",\\\\");
				for (String value : lineValues) {
					currentValues.add(value.trim());
				}
			} else {
				// Just to be sure: Split the current line at the value denominator ',\'
				String[] lineValues = line.split(",\\\\");
				for (String value : lineValues) {
					currentValues.add(value.trim());
				}
			}
		}
	}
}
