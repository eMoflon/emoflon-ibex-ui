package org.emoflon.ibex.common.editor.handbook;

import java.net.MalformedURLException;
import java.net.URL;

import org.moflon.core.ui.autosetup.handler.RegisterPsfUrlExtension;

public abstract class SokobanHandbookPsfUrlRegistration implements RegisterPsfUrlExtension {
	protected static final String PREFIX = "IBeX Handbook:";
	private String label;
	private String url;

	public SokobanHandbookPsfUrlRegistration(int part, String url) {
		this(PREFIX + " Part " + part, url);
	}
	
	public SokobanHandbookPsfUrlRegistration(String label, String url) {
		this.url = url;
		this.label = label;
	}
	
	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public URL getUrl() {
		try {
			return new URL(url);
		} catch (MalformedURLException e) {
			throw new IllegalStateException(e);
		}
	}
}
