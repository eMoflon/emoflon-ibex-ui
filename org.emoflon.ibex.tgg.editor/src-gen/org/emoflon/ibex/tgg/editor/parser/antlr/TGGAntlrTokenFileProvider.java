/*
 * generated by Xtext 2.27.0
 */
package org.emoflon.ibex.tgg.editor.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class TGGAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/emoflon/ibex/tgg/editor/parser/antlr/internal/InternalTGG.tokens");
	}
}
