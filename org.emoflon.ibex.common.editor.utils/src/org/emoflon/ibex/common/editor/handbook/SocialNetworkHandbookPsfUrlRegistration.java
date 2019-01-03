package org.emoflon.ibex.common.editor.handbook;

import java.net.MalformedURLException;
import java.net.URL;

import org.moflon.core.ui.autosetup.handler.RegisterPsfUrlExtension;

public abstract class SocialNetworkHandbookPsfUrlRegistration implements RegisterPsfUrlExtension {
	protected static final String PREFIX = "II. Social Network Example: ";
	private String label;
	private String url;

	public SocialNetworkHandbookPsfUrlRegistration(int part, String url) {
		this(PREFIX + part, url);
	}
	
	public SocialNetworkHandbookPsfUrlRegistration(String label, String url) {
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
