package org.emoflon.ibex.common.editor.handbook;

import java.net.MalformedURLException;
import java.net.URL;

import org.moflon.core.ui.autosetup.handler.RegisterPsfUrlExtension;

public abstract class SokobanHandbookPsfUrlRegistration implements RegisterPsfUrlExtension {
	private String part;
	private String url;

	public SokobanHandbookPsfUrlRegistration(String part, String url) {
		this.part = part;
		this.url = url;
	}
	
	@Override
	public String getLabel() {
		return "IBeX Handbook: Part " + part;
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
