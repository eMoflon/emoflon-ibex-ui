package org.emoflon.ibex.tgg.editor.ui.highlighting;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.ide.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.util.Arrays;

import com.google.inject.Inject;

public class TGGTokenMapper extends DefaultAntlrTokenToAttributeIdMapper {

	public TGGTokenMapper() {
		super();
		init();
	}

	private void init() {
		mappedTokens.clear();
	}

	private static Map<String, String> mappedTokens = new HashMap<>();

	@Inject
	static TGGTokenMapper mapper = new TGGTokenMapper();

	private static final String[] delemiters = { ":", "{", "}", "(", ")" };
	private static final String[] enumerationDelemiters = { "::", "enum::" };
	private static final String[] sourceTokens = { "#src->", "#source" };
	private static final String[] targetTokens = { "#trg->", "#target" };

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		String trimmedTokenName = tokenName.replaceAll("'", "");
		String id = super.calculateId(tokenName, tokenType);
		if ("RULE_BOOL".equals(tokenName)) {
			id = TGGHighlightingConfiguration.BOOL_ID;
		}
		if (Arrays.contains(delemiters, trimmedTokenName)) {
			id = TGGHighlightingConfiguration.DEFAULT_ID;
		}
		if (Arrays.contains(enumerationDelemiters, trimmedTokenName)) {
			id = TGGHighlightingConfiguration.ENUM_ID;
		}
		if (Arrays.contains(sourceTokens, trimmedTokenName)) {
			id = TGGHighlightingConfiguration.SOURCE_ID;
		}
		if (Arrays.contains(targetTokens, trimmedTokenName)) {
			id = TGGHighlightingConfiguration.TARGET_ID;
		}
		mappedTokens.put(trimmedTokenName, id);
		return id;
	}

	public static String getIDFromToken(String token) {
		String trimmedTokenName = token.replaceAll("'", "");
		return mappedTokens.get(trimmedTokenName);
	}

}
