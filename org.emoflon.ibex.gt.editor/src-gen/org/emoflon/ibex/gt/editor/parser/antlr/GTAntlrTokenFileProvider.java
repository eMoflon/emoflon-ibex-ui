/*
 * generated by Xtext 2.25.0
 */
package org.emoflon.ibex.gt.editor.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class GTAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/emoflon/ibex/gt/editor/parser/antlr/internal/InternalGT.tokens");
	}
}
