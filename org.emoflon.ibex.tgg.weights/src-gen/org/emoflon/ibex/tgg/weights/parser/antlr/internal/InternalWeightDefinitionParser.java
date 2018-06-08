package org.emoflon.ibex.tgg.weights.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.emoflon.ibex.tgg.weights.services.WeightDefinitionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class InternalWeightDefinitionParser extends AbstractInternalAntlrParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ANY_OTHER", "RULE_DECIMAL", 
		"RULE_HEX", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", 
		"RULE_STRING", "RULE_WS", "'!'", "'!='", "'!=='", "'#'", "'%'", "'%='", 
		"'&&'", "'&'", "'('", "')'", "'*'", "'**'", "'*='", "'+'", "'++'", "'+='", 
		"','", "'-'", "'--'", "'-='", "'->'", "'.'", "'..'", "'..<'", "'/'", "'/='", 
		"':'", "'::'", "';'", "'<'", "'<>'", "'='", "'=='", "'==='", "'=>'", "'>'", 
		"'>='", "'?'", "'?.'", "'?:'", "'['", "']'", "'as'", "'case'", "'catch'", 
		"'default'", "'do'", "'else'", "'extends'", "'extension'", "'false'", 
		"'finally'", "'for'", "'function'", "'if'", "'import'", "'instanceof'", 
		"'new'", "'null'", "'return'", "'rule'", "'static'", "'super'", "'switch'", 
		"'synchronized'", "'throw'", "'true'", "'try'", "'typeof'", "'val'", "'var'", 
		"'while'", "'{'", "'|'", "'||'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int T__60=60;
	public static final int T__61=61;
	public static final int T__62=62;
	public static final int T__63=63;
	public static final int T__64=64;
	public static final int T__65=65;
	public static final int T__66=66;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int RULE_ANY_OTHER=4;
	public static final int RULE_DECIMAL=5;
	public static final int RULE_HEX=6;
	public static final int RULE_ID=7;
	public static final int RULE_INT=8;
	public static final int RULE_ML_COMMENT=9;
	public static final int RULE_SL_COMMENT=10;
	public static final int RULE_STRING=11;
	public static final int RULE_WS=12;

	// delegates
	public AbstractInternalAntlrParser[] getDelegates() {
		return new AbstractInternalAntlrParser[] {};
	}

	// delegators


	public InternalWeightDefinitionParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public InternalWeightDefinitionParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return InternalWeightDefinitionParser.tokenNames; }
	@Override public String getGrammarFileName() { return "InternalWeightDefinition.g"; }



	 	private WeightDefinitionGrammarAccess grammarAccess;

	    public InternalWeightDefinitionParser(TokenStream input, WeightDefinitionGrammarAccess grammarAccess) {
	        this(input);
	        this.grammarAccess = grammarAccess;
	        registerRules(grammarAccess.getGrammar());
	    }

	    @Override
	    protected String getFirstRuleName() {
	    	return "WeightDefinitionFile";
	   	}

	   	@Override
	   	protected WeightDefinitionGrammarAccess getGrammarAccess() {
	   		return grammarAccess;
	   	}




	// $ANTLR start "entryRuleWeightDefinitionFile"
	// InternalWeightDefinition.g:64:1: entryRuleWeightDefinitionFile returns [EObject current=null] :iv_ruleWeightDefinitionFile= ruleWeightDefinitionFile EOF ;
	public final EObject entryRuleWeightDefinitionFile() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleWeightDefinitionFile =null;

		try {
			// InternalWeightDefinition.g:64:61: (iv_ruleWeightDefinitionFile= ruleWeightDefinitionFile EOF )
			// InternalWeightDefinition.g:65:2: iv_ruleWeightDefinitionFile= ruleWeightDefinitionFile EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getWeightDefinitionFileRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleWeightDefinitionFile=ruleWeightDefinitionFile();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleWeightDefinitionFile; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleWeightDefinitionFile"



	// $ANTLR start "ruleWeightDefinitionFile"
	// InternalWeightDefinition.g:71:1: ruleWeightDefinitionFile returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )* ( (lv_default_2_0= ruleDefaultCalculation ) )? ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )* ) ;
	public final EObject ruleWeightDefinitionFile() throws RecognitionException {
		EObject current = null;


		EObject lv_imports_0_0 =null;
		EObject lv_weigthDefinitions_1_0 =null;
		EObject lv_default_2_0 =null;
		EObject lv_helperFuntions_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:77:2: ( ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )* ( (lv_default_2_0= ruleDefaultCalculation ) )? ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )* ) )
			// InternalWeightDefinition.g:78:2: ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )* ( (lv_default_2_0= ruleDefaultCalculation ) )? ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )* )
			{
			// InternalWeightDefinition.g:78:2: ( ( (lv_imports_0_0= ruleImport ) ) ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )* ( (lv_default_2_0= ruleDefaultCalculation ) )? ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )* )
			// InternalWeightDefinition.g:79:3: ( (lv_imports_0_0= ruleImport ) ) ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )* ( (lv_default_2_0= ruleDefaultCalculation ) )? ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )*
			{
			// InternalWeightDefinition.g:79:3: ( (lv_imports_0_0= ruleImport ) )
			// InternalWeightDefinition.g:80:4: (lv_imports_0_0= ruleImport )
			{
			// InternalWeightDefinition.g:80:4: (lv_imports_0_0= ruleImport )
			// InternalWeightDefinition.g:81:5: lv_imports_0_0= ruleImport
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getWeightDefinitionFileAccess().getImportsImportParserRuleCall_0_0());
							}
			pushFollow(FOLLOW_3);
			lv_imports_0_0=ruleImport();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getWeightDefinitionFileRule());
								}
								set(
									current,
									"imports",
									lv_imports_0_0,
									"org.emoflon.ibex.tgg.weights.WeightDefinition.Import");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:98:3: ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==73) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// InternalWeightDefinition.g:99:4: (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition )
					{
					// InternalWeightDefinition.g:99:4: (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition )
					// InternalWeightDefinition.g:100:5: lv_weigthDefinitions_1_0= ruleRuleWeightDefinition
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getWeightDefinitionFileAccess().getWeigthDefinitionsRuleWeightDefinitionParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_3);
					lv_weigthDefinitions_1_0=ruleRuleWeightDefinition();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getWeightDefinitionFileRule());
										}
										add(
											current,
											"weigthDefinitions",
											lv_weigthDefinitions_1_0,
											"org.emoflon.ibex.tgg.weights.WeightDefinition.RuleWeightDefinition");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop1;
				}
			}

			// InternalWeightDefinition.g:117:3: ( (lv_default_2_0= ruleDefaultCalculation ) )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==58) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// InternalWeightDefinition.g:118:4: (lv_default_2_0= ruleDefaultCalculation )
					{
					// InternalWeightDefinition.g:118:4: (lv_default_2_0= ruleDefaultCalculation )
					// InternalWeightDefinition.g:119:5: lv_default_2_0= ruleDefaultCalculation
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getWeightDefinitionFileAccess().getDefaultDefaultCalculationParserRuleCall_2_0());
									}
					pushFollow(FOLLOW_4);
					lv_default_2_0=ruleDefaultCalculation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getWeightDefinitionFileRule());
										}
										set(
											current,
											"default",
											lv_default_2_0,
											"org.emoflon.ibex.tgg.weights.WeightDefinition.DefaultCalculation");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			// InternalWeightDefinition.g:136:3: ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==66) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// InternalWeightDefinition.g:137:4: (lv_helperFuntions_3_0= ruleHelperFuntion )
					{
					// InternalWeightDefinition.g:137:4: (lv_helperFuntions_3_0= ruleHelperFuntion )
					// InternalWeightDefinition.g:138:5: lv_helperFuntions_3_0= ruleHelperFuntion
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getWeightDefinitionFileAccess().getHelperFuntionsHelperFuntionParserRuleCall_3_0());
									}
					pushFollow(FOLLOW_4);
					lv_helperFuntions_3_0=ruleHelperFuntion();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getWeightDefinitionFileRule());
										}
										add(
											current,
											"helperFuntions",
											lv_helperFuntions_3_0,
											"org.emoflon.ibex.tgg.weights.WeightDefinition.HelperFuntion");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop3;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleWeightDefinitionFile"



	// $ANTLR start "entryRuleImport"
	// InternalWeightDefinition.g:159:1: entryRuleImport returns [EObject current=null] :iv_ruleImport= ruleImport EOF ;
	public final EObject entryRuleImport() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleImport =null;

		try {
			// InternalWeightDefinition.g:159:47: (iv_ruleImport= ruleImport EOF )
			// InternalWeightDefinition.g:160:2: iv_ruleImport= ruleImport EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getImportRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleImport=ruleImport();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleImport; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleImport"



	// $ANTLR start "ruleImport"
	// InternalWeightDefinition.g:166:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
	public final EObject ruleImport() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token lv_importURI_1_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:172:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
			// InternalWeightDefinition.g:173:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
			{
			// InternalWeightDefinition.g:173:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
			// InternalWeightDefinition.g:174:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
			{
			otherlv_0=(Token)match(input,68,FOLLOW_5); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
					}
			// InternalWeightDefinition.g:178:3: ( (lv_importURI_1_0= RULE_STRING ) )
			// InternalWeightDefinition.g:179:4: (lv_importURI_1_0= RULE_STRING )
			{
			// InternalWeightDefinition.g:179:4: (lv_importURI_1_0= RULE_STRING )
			// InternalWeightDefinition.g:180:5: lv_importURI_1_0= RULE_STRING
			{
			lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(lv_importURI_1_0, grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0());
							}
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getImportRule());
								}
								setWithLastConsumed(
									current,
									"importURI",
									lv_importURI_1_0,
									"org.eclipse.xtext.xbase.Xtype.STRING");
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleImport"



	// $ANTLR start "entryRuleRuleWeightDefinition"
	// InternalWeightDefinition.g:200:1: entryRuleRuleWeightDefinition returns [EObject current=null] :iv_ruleRuleWeightDefinition= ruleRuleWeightDefinition EOF ;
	public final EObject entryRuleRuleWeightDefinition() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRuleWeightDefinition =null;

		try {
			// InternalWeightDefinition.g:200:61: (iv_ruleRuleWeightDefinition= ruleRuleWeightDefinition EOF )
			// InternalWeightDefinition.g:201:2: iv_ruleRuleWeightDefinition= ruleRuleWeightDefinition EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getRuleWeightDefinitionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleRuleWeightDefinition=ruleRuleWeightDefinition();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleRuleWeightDefinition; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleRuleWeightDefinition"



	// $ANTLR start "ruleRuleWeightDefinition"
	// InternalWeightDefinition.g:207:1: ruleRuleWeightDefinition returns [EObject current=null] : ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) ) ;
	public final EObject ruleRuleWeightDefinition() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		EObject lv_weightCalc_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:213:2: ( ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) ) )
			// InternalWeightDefinition.g:214:2: ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) )
			{
			// InternalWeightDefinition.g:214:2: ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) )
			// InternalWeightDefinition.g:215:3: () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) )
			{
			// InternalWeightDefinition.g:215:3: ()
			// InternalWeightDefinition.g:216:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getRuleWeightDefinitionAccess().getRuleWeightDefinitionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,73,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getRuleWeightDefinitionAccess().getRuleKeyword_1());
					}
			// InternalWeightDefinition.g:226:3: ( (otherlv_2= RULE_ID ) )
			// InternalWeightDefinition.g:227:4: (otherlv_2= RULE_ID )
			{
			// InternalWeightDefinition.g:227:4: (otherlv_2= RULE_ID )
			// InternalWeightDefinition.g:228:5: otherlv_2= RULE_ID
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getRuleWeightDefinitionRule());
								}
							}
			otherlv_2=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getRuleWeightDefinitionAccess().getRuleTGGRuleCrossReference_2_0());
							}
			}

			}

			// InternalWeightDefinition.g:239:3: ( (lv_weightCalc_3_0= ruleWeightCalculation ) )
			// InternalWeightDefinition.g:240:4: (lv_weightCalc_3_0= ruleWeightCalculation )
			{
			// InternalWeightDefinition.g:240:4: (lv_weightCalc_3_0= ruleWeightCalculation )
			// InternalWeightDefinition.g:241:5: lv_weightCalc_3_0= ruleWeightCalculation
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getRuleWeightDefinitionAccess().getWeightCalcWeightCalculationParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_2);
			lv_weightCalc_3_0=ruleWeightCalculation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getRuleWeightDefinitionRule());
								}
								set(
									current,
									"weightCalc",
									lv_weightCalc_3_0,
									"org.emoflon.ibex.tgg.weights.WeightDefinition.WeightCalculation");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleRuleWeightDefinition"



	// $ANTLR start "entryRuleWeightCalculation"
	// InternalWeightDefinition.g:262:1: entryRuleWeightCalculation returns [EObject current=null] :iv_ruleWeightCalculation= ruleWeightCalculation EOF ;
	public final EObject entryRuleWeightCalculation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleWeightCalculation =null;

		try {
			// InternalWeightDefinition.g:262:58: (iv_ruleWeightCalculation= ruleWeightCalculation EOF )
			// InternalWeightDefinition.g:263:2: iv_ruleWeightCalculation= ruleWeightCalculation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getWeightCalculationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleWeightCalculation=ruleWeightCalculation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleWeightCalculation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleWeightCalculation"



	// $ANTLR start "ruleWeightCalculation"
	// InternalWeightDefinition.g:269:1: ruleWeightCalculation returns [EObject current=null] : ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleWeightCalculation() throws RecognitionException {
		EObject current = null;


		EObject lv_calc_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:275:2: ( ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) ) )
			// InternalWeightDefinition.g:276:2: ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) )
			{
			// InternalWeightDefinition.g:276:2: ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) )
			// InternalWeightDefinition.g:277:3: () ( (lv_calc_1_0= ruleXBlockExpression ) )
			{
			// InternalWeightDefinition.g:277:3: ()
			// InternalWeightDefinition.g:278:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getWeightCalculationAccess().getWeightCalculationAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:284:3: ( (lv_calc_1_0= ruleXBlockExpression ) )
			// InternalWeightDefinition.g:285:4: (lv_calc_1_0= ruleXBlockExpression )
			{
			// InternalWeightDefinition.g:285:4: (lv_calc_1_0= ruleXBlockExpression )
			// InternalWeightDefinition.g:286:5: lv_calc_1_0= ruleXBlockExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getWeightCalculationAccess().getCalcXBlockExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_calc_1_0=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getWeightCalculationRule());
								}
								set(
									current,
									"calc",
									lv_calc_1_0,
									"org.eclipse.xtext.xbase.Xbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleWeightCalculation"



	// $ANTLR start "entryRuleDefaultCalculation"
	// InternalWeightDefinition.g:307:1: entryRuleDefaultCalculation returns [EObject current=null] :iv_ruleDefaultCalculation= ruleDefaultCalculation EOF ;
	public final EObject entryRuleDefaultCalculation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleDefaultCalculation =null;

		try {
			// InternalWeightDefinition.g:307:59: (iv_ruleDefaultCalculation= ruleDefaultCalculation EOF )
			// InternalWeightDefinition.g:308:2: iv_ruleDefaultCalculation= ruleDefaultCalculation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getDefaultCalculationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleDefaultCalculation=ruleDefaultCalculation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleDefaultCalculation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleDefaultCalculation"



	// $ANTLR start "ruleDefaultCalculation"
	// InternalWeightDefinition.g:314:1: ruleDefaultCalculation returns [EObject current=null] : ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleDefaultCalculation() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_calc_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:320:2: ( ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) ) )
			// InternalWeightDefinition.g:321:2: ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) )
			{
			// InternalWeightDefinition.g:321:2: ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) )
			// InternalWeightDefinition.g:322:3: () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) )
			{
			// InternalWeightDefinition.g:322:3: ()
			// InternalWeightDefinition.g:323:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getDefaultCalculationAccess().getDefaultCalculationAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,58,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getDefaultCalculationAccess().getDefaultKeyword_1());
					}
			// InternalWeightDefinition.g:333:3: ( (lv_calc_2_0= ruleXBlockExpression ) )
			// InternalWeightDefinition.g:334:4: (lv_calc_2_0= ruleXBlockExpression )
			{
			// InternalWeightDefinition.g:334:4: (lv_calc_2_0= ruleXBlockExpression )
			// InternalWeightDefinition.g:335:5: lv_calc_2_0= ruleXBlockExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getDefaultCalculationAccess().getCalcXBlockExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_2);
			lv_calc_2_0=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getDefaultCalculationRule());
								}
								set(
									current,
									"calc",
									lv_calc_2_0,
									"org.eclipse.xtext.xbase.Xbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleDefaultCalculation"



	// $ANTLR start "entryRuleHelperFuntion"
	// InternalWeightDefinition.g:356:1: entryRuleHelperFuntion returns [EObject current=null] :iv_ruleHelperFuntion= ruleHelperFuntion EOF ;
	public final EObject entryRuleHelperFuntion() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleHelperFuntion =null;

		try {
			// InternalWeightDefinition.g:356:54: (iv_ruleHelperFuntion= ruleHelperFuntion EOF )
			// InternalWeightDefinition.g:357:2: iv_ruleHelperFuntion= ruleHelperFuntion EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getHelperFuntionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleHelperFuntion=ruleHelperFuntion();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleHelperFuntion; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleHelperFuntion"



	// $ANTLR start "ruleHelperFuntion"
	// InternalWeightDefinition.g:363:1: ruleHelperFuntion returns [EObject current=null] : ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleHelperFuntion() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		EObject lv_returnType_2_0 =null;
		AntlrDatatypeRuleToken lv_name_3_0 =null;
		EObject lv_params_5_0 =null;
		EObject lv_params_7_0 =null;
		EObject lv_body_9_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:369:2: ( ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) ) )
			// InternalWeightDefinition.g:370:2: ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) )
			{
			// InternalWeightDefinition.g:370:2: ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) )
			// InternalWeightDefinition.g:371:3: () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) )
			{
			// InternalWeightDefinition.g:371:3: ()
			// InternalWeightDefinition.g:372:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getHelperFuntionAccess().getHelperFunctionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,66,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getHelperFuntionAccess().getFunctionKeyword_1());
					}
			// InternalWeightDefinition.g:382:3: ( (lv_returnType_2_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:383:4: (lv_returnType_2_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:383:4: (lv_returnType_2_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:384:5: lv_returnType_2_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuntionAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_6);
			lv_returnType_2_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getHelperFuntionRule());
								}
								set(
									current,
									"returnType",
									lv_returnType_2_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:401:3: ( (lv_name_3_0= ruleValidID ) )
			// InternalWeightDefinition.g:402:4: (lv_name_3_0= ruleValidID )
			{
			// InternalWeightDefinition.g:402:4: (lv_name_3_0= ruleValidID )
			// InternalWeightDefinition.g:403:5: lv_name_3_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuntionAccess().getNameValidIDParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_9);
			lv_name_3_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getHelperFuntionRule());
								}
								set(
									current,
									"name",
									lv_name_3_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getHelperFuntionAccess().getLeftParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:424:3: ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==RULE_ID||LA5_0==21||LA5_0==47) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// InternalWeightDefinition.g:425:4: ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )*
					{
					// InternalWeightDefinition.g:425:4: ( (lv_params_5_0= ruleHelperFuncParameter ) )
					// InternalWeightDefinition.g:426:5: (lv_params_5_0= ruleHelperFuncParameter )
					{
					// InternalWeightDefinition.g:426:5: (lv_params_5_0= ruleHelperFuncParameter )
					// InternalWeightDefinition.g:427:6: lv_params_5_0= ruleHelperFuncParameter
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getHelperFuntionAccess().getParamsHelperFuncParameterParserRuleCall_5_0_0());
										}
					pushFollow(FOLLOW_11);
					lv_params_5_0=ruleHelperFuncParameter();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getHelperFuntionRule());
											}
											add(
												current,
												"params",
												lv_params_5_0,
												"org.emoflon.ibex.tgg.weights.WeightDefinition.HelperFuncParameter");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:444:4: (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )*
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==29) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// InternalWeightDefinition.g:445:5: otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) )
							{
							otherlv_6=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_6, grammarAccess.getHelperFuntionAccess().getCommaKeyword_5_1_0());
											}
							// InternalWeightDefinition.g:449:5: ( (lv_params_7_0= ruleHelperFuncParameter ) )
							// InternalWeightDefinition.g:450:6: (lv_params_7_0= ruleHelperFuncParameter )
							{
							// InternalWeightDefinition.g:450:6: (lv_params_7_0= ruleHelperFuncParameter )
							// InternalWeightDefinition.g:451:7: lv_params_7_0= ruleHelperFuncParameter
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getHelperFuntionAccess().getParamsHelperFuncParameterParserRuleCall_5_1_1_0());
													}
							pushFollow(FOLLOW_11);
							lv_params_7_0=ruleHelperFuncParameter();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getHelperFuntionRule());
														}
														add(
															current,
															"params",
															lv_params_7_0,
															"org.emoflon.ibex.tgg.weights.WeightDefinition.HelperFuncParameter");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop4;
						}
					}

					}
					break;

			}

			otherlv_8=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getHelperFuntionAccess().getRightParenthesisKeyword_6());
					}
			// InternalWeightDefinition.g:474:3: ( (lv_body_9_0= ruleXBlockExpression ) )
			// InternalWeightDefinition.g:475:4: (lv_body_9_0= ruleXBlockExpression )
			{
			// InternalWeightDefinition.g:475:4: (lv_body_9_0= ruleXBlockExpression )
			// InternalWeightDefinition.g:476:5: lv_body_9_0= ruleXBlockExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuntionAccess().getBodyXBlockExpressionParserRuleCall_7_0());
							}
			pushFollow(FOLLOW_2);
			lv_body_9_0=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getHelperFuntionRule());
								}
								set(
									current,
									"body",
									lv_body_9_0,
									"org.eclipse.xtext.xbase.Xbase.XBlockExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleHelperFuntion"



	// $ANTLR start "entryRuleHelperFuncParameter"
	// InternalWeightDefinition.g:497:1: entryRuleHelperFuncParameter returns [EObject current=null] :iv_ruleHelperFuncParameter= ruleHelperFuncParameter EOF ;
	public final EObject entryRuleHelperFuncParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleHelperFuncParameter =null;

		try {
			// InternalWeightDefinition.g:497:60: (iv_ruleHelperFuncParameter= ruleHelperFuncParameter EOF )
			// InternalWeightDefinition.g:498:2: iv_ruleHelperFuncParameter= ruleHelperFuncParameter EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getHelperFuncParameterRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleHelperFuncParameter=ruleHelperFuncParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleHelperFuncParameter; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleHelperFuncParameter"



	// $ANTLR start "ruleHelperFuncParameter"
	// InternalWeightDefinition.g:504:1: ruleHelperFuncParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleHelperFuncParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:510:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalWeightDefinition.g:511:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalWeightDefinition.g:511:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			// InternalWeightDefinition.g:512:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalWeightDefinition.g:512:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:513:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:513:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:514:5: lv_parameterType_0_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuncParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
							}
			pushFollow(FOLLOW_6);
			lv_parameterType_0_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getHelperFuncParameterRule());
								}
								set(
									current,
									"parameterType",
									lv_parameterType_0_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:531:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalWeightDefinition.g:532:4: (lv_name_1_0= ruleValidID )
			{
			// InternalWeightDefinition.g:532:4: (lv_name_1_0= ruleValidID )
			// InternalWeightDefinition.g:533:5: lv_name_1_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuncParameterAccess().getNameValidIDParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_1_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getHelperFuncParameterRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleHelperFuncParameter"



	// $ANTLR start "entryRuleXExpression"
	// InternalWeightDefinition.g:554:1: entryRuleXExpression returns [EObject current=null] :iv_ruleXExpression= ruleXExpression EOF ;
	public final EObject entryRuleXExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpression =null;

		try {
			// InternalWeightDefinition.g:554:52: (iv_ruleXExpression= ruleXExpression EOF )
			// InternalWeightDefinition.g:555:2: iv_ruleXExpression= ruleXExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXExpression=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXExpression"



	// $ANTLR start "ruleXExpression"
	// InternalWeightDefinition.g:561:1: ruleXExpression returns [EObject current=null] :this_XAssignment_0= ruleXAssignment ;
	public final EObject ruleXExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAssignment_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:567:2: (this_XAssignment_0= ruleXAssignment )
			// InternalWeightDefinition.g:568:2: this_XAssignment_0= ruleXAssignment
			{
			if ( state.backtracking==0 ) {
					newCompositeNode(grammarAccess.getXExpressionAccess().getXAssignmentParserRuleCall());
				}
			pushFollow(FOLLOW_2);
			this_XAssignment_0=ruleXAssignment();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current = this_XAssignment_0;
					afterParserOrEnumRuleCall();
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXExpression"



	// $ANTLR start "entryRuleXAssignment"
	// InternalWeightDefinition.g:579:1: entryRuleXAssignment returns [EObject current=null] :iv_ruleXAssignment= ruleXAssignment EOF ;
	public final EObject entryRuleXAssignment() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAssignment =null;

		try {
			// InternalWeightDefinition.g:579:52: (iv_ruleXAssignment= ruleXAssignment EOF )
			// InternalWeightDefinition.g:580:2: iv_ruleXAssignment= ruleXAssignment EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAssignmentRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAssignment=ruleXAssignment();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAssignment; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAssignment"



	// $ANTLR start "ruleXAssignment"
	// InternalWeightDefinition.g:586:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
	public final EObject ruleXAssignment() throws RecognitionException {
		EObject current = null;


		EObject lv_value_3_0 =null;
		EObject this_XOrExpression_4 =null;
		EObject lv_rightOperand_7_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:592:2: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
			// InternalWeightDefinition.g:593:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
			{
			// InternalWeightDefinition.g:593:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
			int alt7=2;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				int LA7_1 = input.LA(2);
				if ( (LA7_1==44) ) {
					alt7=1;
				}
				else if ( (LA7_1==EOF||(LA7_1 >= RULE_DECIMAL && LA7_1 <= RULE_INT)||LA7_1==RULE_STRING||(LA7_1 >= 13 && LA7_1 <= 19)||(LA7_1 >= 21 && LA7_1 <= 43)||(LA7_1 >= 45 && LA7_1 <= 49)||(LA7_1 >= 51 && LA7_1 <= 65)||(LA7_1 >= 67 && LA7_1 <= 72)||(LA7_1 >= 74 && LA7_1 <= 85)||(LA7_1 >= 87 && LA7_1 <= 88)) ) {
					alt7=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 61:
				{
				int LA7_2 = input.LA(2);
				if ( (LA7_2==44) ) {
					alt7=1;
				}
				else if ( (LA7_2==EOF||(LA7_2 >= RULE_DECIMAL && LA7_2 <= RULE_INT)||LA7_2==RULE_STRING||(LA7_2 >= 13 && LA7_2 <= 19)||(LA7_2 >= 21 && LA7_2 <= 43)||(LA7_2 >= 45 && LA7_2 <= 49)||(LA7_2 >= 51 && LA7_2 <= 65)||(LA7_2 >= 67 && LA7_2 <= 72)||(LA7_2 >= 74 && LA7_2 <= 85)||(LA7_2 >= 87 && LA7_2 <= 88)) ) {
					alt7=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 74:
				{
				int LA7_3 = input.LA(2);
				if ( (LA7_3==44) ) {
					alt7=1;
				}
				else if ( (LA7_3==EOF||(LA7_3 >= RULE_DECIMAL && LA7_3 <= RULE_INT)||LA7_3==RULE_STRING||(LA7_3 >= 13 && LA7_3 <= 19)||(LA7_3 >= 21 && LA7_3 <= 43)||(LA7_3 >= 45 && LA7_3 <= 49)||(LA7_3 >= 51 && LA7_3 <= 65)||(LA7_3 >= 67 && LA7_3 <= 72)||(LA7_3 >= 74 && LA7_3 <= 85)||(LA7_3 >= 87 && LA7_3 <= 88)) ) {
					alt7=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 68:
				{
				int LA7_4 = input.LA(2);
				if ( (LA7_4==44) ) {
					alt7=1;
				}
				else if ( (LA7_4==EOF||(LA7_4 >= RULE_DECIMAL && LA7_4 <= RULE_INT)||LA7_4==RULE_STRING||(LA7_4 >= 13 && LA7_4 <= 19)||(LA7_4 >= 21 && LA7_4 <= 43)||(LA7_4 >= 45 && LA7_4 <= 49)||(LA7_4 >= 51 && LA7_4 <= 65)||(LA7_4 >= 67 && LA7_4 <= 72)||(LA7_4 >= 74 && LA7_4 <= 85)||(LA7_4 >= 87 && LA7_4 <= 88)) ) {
					alt7=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 62:
				{
				int LA7_5 = input.LA(2);
				if ( (LA7_5==44) ) {
					alt7=1;
				}
				else if ( (LA7_5==EOF||(LA7_5 >= RULE_DECIMAL && LA7_5 <= RULE_INT)||LA7_5==RULE_STRING||(LA7_5 >= 13 && LA7_5 <= 19)||(LA7_5 >= 21 && LA7_5 <= 43)||(LA7_5 >= 45 && LA7_5 <= 49)||(LA7_5 >= 51 && LA7_5 <= 65)||(LA7_5 >= 67 && LA7_5 <= 72)||(LA7_5 >= 74 && LA7_5 <= 85)||(LA7_5 >= 87 && LA7_5 <= 88)) ) {
					alt7=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case RULE_DECIMAL:
			case RULE_HEX:
			case RULE_INT:
			case RULE_STRING:
			case 13:
			case 16:
			case 21:
			case 26:
			case 30:
			case 42:
			case 53:
			case 59:
			case 63:
			case 65:
			case 67:
			case 70:
			case 71:
			case 72:
			case 75:
			case 76:
			case 77:
			case 78:
			case 79:
			case 80:
			case 81:
			case 84:
			case 85:
				{
				alt7=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// InternalWeightDefinition.g:594:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
					{
					// InternalWeightDefinition.g:594:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
					// InternalWeightDefinition.g:595:4: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
					{
					// InternalWeightDefinition.g:595:4: ()
					// InternalWeightDefinition.g:596:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
											current);
									}
					}

					// InternalWeightDefinition.g:602:4: ( ( ruleFeatureCallID ) )
					// InternalWeightDefinition.g:603:5: ( ruleFeatureCallID )
					{
					// InternalWeightDefinition.g:603:5: ( ruleFeatureCallID )
					// InternalWeightDefinition.g:604:6: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXAssignmentRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
										}
					pushFollow(FOLLOW_12);
					ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXAssignmentAccess().getOpSingleAssignParserRuleCall_0_2());
								}
					pushFollow(FOLLOW_13);
					ruleOpSingleAssign();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									afterParserOrEnumRuleCall();
								}
					// InternalWeightDefinition.g:625:4: ( (lv_value_3_0= ruleXAssignment ) )
					// InternalWeightDefinition.g:626:5: (lv_value_3_0= ruleXAssignment )
					{
					// InternalWeightDefinition.g:626:5: (lv_value_3_0= ruleXAssignment )
					// InternalWeightDefinition.g:627:6: lv_value_3_0= ruleXAssignment
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAssignmentAccess().getValueXAssignmentParserRuleCall_0_3_0());
										}
					pushFollow(FOLLOW_2);
					lv_value_3_0=ruleXAssignment();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXAssignmentRule());
											}
											set(
												current,
												"value",
												lv_value_3_0,
												"org.eclipse.xtext.xbase.Xbase.XAssignment");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:646:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
					{
					// InternalWeightDefinition.g:646:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
					// InternalWeightDefinition.g:647:4: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0());
								}
					pushFollow(FOLLOW_14);
					this_XOrExpression_4=ruleXOrExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XOrExpression_4;
									afterParserOrEnumRuleCall();
								}
					// InternalWeightDefinition.g:655:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
					int alt6=2;
					switch ( input.LA(1) ) {
						case 28:
							{
							int LA6_1 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt6=1;
							}
							}
							break;
						case 32:
							{
							int LA6_2 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt6=1;
							}
							}
							break;
						case 25:
							{
							int LA6_3 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt6=1;
							}
							}
							break;
						case 38:
							{
							int LA6_4 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt6=1;
							}
							}
							break;
						case 18:
							{
							int LA6_5 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt6=1;
							}
							}
							break;
						case 42:
							{
							int LA6_6 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt6=1;
							}
							}
							break;
						case 48:
							{
							int LA6_7 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt6=1;
							}
							}
							break;
					}
					switch (alt6) {
						case 1 :
							// InternalWeightDefinition.g:656:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
							{
							// InternalWeightDefinition.g:656:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
							// InternalWeightDefinition.g:657:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
							{
							// InternalWeightDefinition.g:667:6: ( () ( ( ruleOpMultiAssign ) ) )
							// InternalWeightDefinition.g:668:7: () ( ( ruleOpMultiAssign ) )
							{
							// InternalWeightDefinition.g:668:7: ()
							// InternalWeightDefinition.g:669:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
																current);
														}
							}

							// InternalWeightDefinition.g:675:7: ( ( ruleOpMultiAssign ) )
							// InternalWeightDefinition.g:676:8: ( ruleOpMultiAssign )
							{
							// InternalWeightDefinition.g:676:8: ( ruleOpMultiAssign )
							// InternalWeightDefinition.g:677:9: ruleOpMultiAssign
							{
							if ( state.backtracking==0 ) {
																if (current==null) {
																	current = createModelElement(grammarAccess.getXAssignmentRule());
																}
															}
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
															}
							pushFollow(FOLLOW_13);
							ruleOpMultiAssign();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																afterParserOrEnumRuleCall();
															}
							}

							}

							}

							}

							// InternalWeightDefinition.g:693:5: ( (lv_rightOperand_7_0= ruleXAssignment ) )
							// InternalWeightDefinition.g:694:6: (lv_rightOperand_7_0= ruleXAssignment )
							{
							// InternalWeightDefinition.g:694:6: (lv_rightOperand_7_0= ruleXAssignment )
							// InternalWeightDefinition.g:695:7: lv_rightOperand_7_0= ruleXAssignment
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXAssignmentAccess().getRightOperandXAssignmentParserRuleCall_1_1_1_0());
													}
							pushFollow(FOLLOW_2);
							lv_rightOperand_7_0=ruleXAssignment();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXAssignmentRule());
														}
														set(
															current,
															"rightOperand",
															lv_rightOperand_7_0,
															"org.eclipse.xtext.xbase.Xbase.XAssignment");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

					}

					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAssignment"



	// $ANTLR start "entryRuleOpSingleAssign"
	// InternalWeightDefinition.g:718:1: entryRuleOpSingleAssign returns [String current=null] :iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
	public final String entryRuleOpSingleAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpSingleAssign =null;

		try {
			// InternalWeightDefinition.g:718:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
			// InternalWeightDefinition.g:719:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpSingleAssignRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpSingleAssign=ruleOpSingleAssign();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpSingleAssign.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpSingleAssign"



	// $ANTLR start "ruleOpSingleAssign"
	// InternalWeightDefinition.g:725:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
	public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:731:2: (kw= '=' )
			// InternalWeightDefinition.g:732:2: kw= '='
			{
			kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpSingleAssignAccess().getEqualsSignKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpSingleAssign"



	// $ANTLR start "entryRuleOpMultiAssign"
	// InternalWeightDefinition.g:740:1: entryRuleOpMultiAssign returns [String current=null] :iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
	public final String entryRuleOpMultiAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMultiAssign =null;

		try {
			// InternalWeightDefinition.g:740:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
			// InternalWeightDefinition.g:741:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpMultiAssignRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpMultiAssign=ruleOpMultiAssign();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpMultiAssign.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpMultiAssign"



	// $ANTLR start "ruleOpMultiAssign"
	// InternalWeightDefinition.g:747:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
	public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:753:2: ( (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
			// InternalWeightDefinition.g:754:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			{
			// InternalWeightDefinition.g:754:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			int alt9=7;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt9=1;
				}
				break;
			case 32:
				{
				alt9=2;
				}
				break;
			case 25:
				{
				alt9=3;
				}
				break;
			case 38:
				{
				alt9=4;
				}
				break;
			case 18:
				{
				alt9=5;
				}
				break;
			case 42:
				{
				alt9=6;
				}
				break;
			case 48:
				{
				alt9=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// InternalWeightDefinition.g:755:3: kw= '+='
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:761:3: kw= '-='
					{
					kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:767:3: kw= '*='
					{
					kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:773:3: kw= '/='
					{
					kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalWeightDefinition.g:779:3: kw= '%='
					{
					kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
							}
					}
					break;
				case 6 :
					// InternalWeightDefinition.g:785:3: (kw= '<' kw= '<' kw= '=' )
					{
					// InternalWeightDefinition.g:785:3: (kw= '<' kw= '<' kw= '=' )
					// InternalWeightDefinition.g:786:4: kw= '<' kw= '<' kw= '='
					{
					kw=(Token)match(input,42,FOLLOW_15); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0());
								}
					kw=(Token)match(input,42,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_1());
								}
					kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getEqualsSignKeyword_5_2());
								}
					}

					}
					break;
				case 7 :
					// InternalWeightDefinition.g:803:3: (kw= '>' (kw= '>' )? kw= '>=' )
					{
					// InternalWeightDefinition.g:803:3: (kw= '>' (kw= '>' )? kw= '>=' )
					// InternalWeightDefinition.g:804:4: kw= '>' (kw= '>' )? kw= '>='
					{
					kw=(Token)match(input,48,FOLLOW_16); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0());
								}
					// InternalWeightDefinition.g:809:4: (kw= '>' )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==48) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// InternalWeightDefinition.g:810:5: kw= '>'
							{
							kw=(Token)match(input,48,FOLLOW_17); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_1());
											}
							}
							break;

					}

					kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignEqualsSignKeyword_6_2());
								}
					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpMultiAssign"



	// $ANTLR start "entryRuleXOrExpression"
	// InternalWeightDefinition.g:826:1: entryRuleXOrExpression returns [EObject current=null] :iv_ruleXOrExpression= ruleXOrExpression EOF ;
	public final EObject entryRuleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOrExpression =null;

		try {
			// InternalWeightDefinition.g:826:54: (iv_ruleXOrExpression= ruleXOrExpression EOF )
			// InternalWeightDefinition.g:827:2: iv_ruleXOrExpression= ruleXOrExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXOrExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXOrExpression=ruleXOrExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXOrExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXOrExpression"



	// $ANTLR start "ruleXOrExpression"
	// InternalWeightDefinition.g:833:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
	public final EObject ruleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAndExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:839:2: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
			// InternalWeightDefinition.g:840:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			{
			// InternalWeightDefinition.g:840:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			// InternalWeightDefinition.g:841:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_18);
			this_XAndExpression_0=ruleXAndExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XAndExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:849:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==87) ) {
					int LA10_2 = input.LA(2);
					if ( (synpred2_InternalWeightDefinition()) ) {
						alt10=1;
					}

				}

				switch (alt10) {
				case 1 :
					// InternalWeightDefinition.g:850:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					{
					// InternalWeightDefinition.g:850:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
					// InternalWeightDefinition.g:851:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
					{
					// InternalWeightDefinition.g:861:5: ( () ( ( ruleOpOr ) ) )
					// InternalWeightDefinition.g:862:6: () ( ( ruleOpOr ) )
					{
					// InternalWeightDefinition.g:862:6: ()
					// InternalWeightDefinition.g:863:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:869:6: ( ( ruleOpOr ) )
					// InternalWeightDefinition.g:870:7: ( ruleOpOr )
					{
					// InternalWeightDefinition.g:870:7: ( ruleOpOr )
					// InternalWeightDefinition.g:871:8: ruleOpOr
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXOrExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_13);
					ruleOpOr();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalWeightDefinition.g:887:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					// InternalWeightDefinition.g:888:5: (lv_rightOperand_3_0= ruleXAndExpression )
					{
					// InternalWeightDefinition.g:888:5: (lv_rightOperand_3_0= ruleXAndExpression )
					// InternalWeightDefinition.g:889:6: lv_rightOperand_3_0= ruleXAndExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_18);
					lv_rightOperand_3_0=ruleXAndExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXOrExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XAndExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop10;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXOrExpression"



	// $ANTLR start "entryRuleOpOr"
	// InternalWeightDefinition.g:911:1: entryRuleOpOr returns [String current=null] :iv_ruleOpOr= ruleOpOr EOF ;
	public final String entryRuleOpOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOr =null;

		try {
			// InternalWeightDefinition.g:911:44: (iv_ruleOpOr= ruleOpOr EOF )
			// InternalWeightDefinition.g:912:2: iv_ruleOpOr= ruleOpOr EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpOrRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpOr=ruleOpOr();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpOr.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpOr"



	// $ANTLR start "ruleOpOr"
	// InternalWeightDefinition.g:918:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
	public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:924:2: (kw= '||' )
			// InternalWeightDefinition.g:925:2: kw= '||'
			{
			kw=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpOr"



	// $ANTLR start "entryRuleXAndExpression"
	// InternalWeightDefinition.g:933:1: entryRuleXAndExpression returns [EObject current=null] :iv_ruleXAndExpression= ruleXAndExpression EOF ;
	public final EObject entryRuleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAndExpression =null;

		try {
			// InternalWeightDefinition.g:933:55: (iv_ruleXAndExpression= ruleXAndExpression EOF )
			// InternalWeightDefinition.g:934:2: iv_ruleXAndExpression= ruleXAndExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAndExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAndExpression=ruleXAndExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAndExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAndExpression"



	// $ANTLR start "ruleXAndExpression"
	// InternalWeightDefinition.g:940:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
	public final EObject ruleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XEqualityExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:946:2: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
			// InternalWeightDefinition.g:947:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			{
			// InternalWeightDefinition.g:947:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			// InternalWeightDefinition.g:948:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_19);
			this_XEqualityExpression_0=ruleXEqualityExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XEqualityExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:956:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==19) ) {
					int LA11_2 = input.LA(2);
					if ( (synpred3_InternalWeightDefinition()) ) {
						alt11=1;
					}

				}

				switch (alt11) {
				case 1 :
					// InternalWeightDefinition.g:957:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					{
					// InternalWeightDefinition.g:957:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
					// InternalWeightDefinition.g:958:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
					{
					// InternalWeightDefinition.g:968:5: ( () ( ( ruleOpAnd ) ) )
					// InternalWeightDefinition.g:969:6: () ( ( ruleOpAnd ) )
					{
					// InternalWeightDefinition.g:969:6: ()
					// InternalWeightDefinition.g:970:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:976:6: ( ( ruleOpAnd ) )
					// InternalWeightDefinition.g:977:7: ( ruleOpAnd )
					{
					// InternalWeightDefinition.g:977:7: ( ruleOpAnd )
					// InternalWeightDefinition.g:978:8: ruleOpAnd
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAndExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_13);
					ruleOpAnd();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalWeightDefinition.g:994:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					// InternalWeightDefinition.g:995:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					{
					// InternalWeightDefinition.g:995:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					// InternalWeightDefinition.g:996:6: lv_rightOperand_3_0= ruleXEqualityExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_19);
					lv_rightOperand_3_0=ruleXEqualityExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXAndExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XEqualityExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop11;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAndExpression"



	// $ANTLR start "entryRuleOpAnd"
	// InternalWeightDefinition.g:1018:1: entryRuleOpAnd returns [String current=null] :iv_ruleOpAnd= ruleOpAnd EOF ;
	public final String entryRuleOpAnd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAnd =null;

		try {
			// InternalWeightDefinition.g:1018:45: (iv_ruleOpAnd= ruleOpAnd EOF )
			// InternalWeightDefinition.g:1019:2: iv_ruleOpAnd= ruleOpAnd EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpAndRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpAnd=ruleOpAnd();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpAnd.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpAnd"



	// $ANTLR start "ruleOpAnd"
	// InternalWeightDefinition.g:1025:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
	public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1031:2: (kw= '&&' )
			// InternalWeightDefinition.g:1032:2: kw= '&&'
			{
			kw=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(kw);
					newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpAnd"



	// $ANTLR start "entryRuleXEqualityExpression"
	// InternalWeightDefinition.g:1040:1: entryRuleXEqualityExpression returns [EObject current=null] :iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
	public final EObject entryRuleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXEqualityExpression =null;

		try {
			// InternalWeightDefinition.g:1040:60: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
			// InternalWeightDefinition.g:1041:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXEqualityExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXEqualityExpression=ruleXEqualityExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXEqualityExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXEqualityExpression"



	// $ANTLR start "ruleXEqualityExpression"
	// InternalWeightDefinition.g:1047:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
	public final EObject ruleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XRelationalExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1053:2: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
			// InternalWeightDefinition.g:1054:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			{
			// InternalWeightDefinition.g:1054:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			// InternalWeightDefinition.g:1055:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_20);
			this_XRelationalExpression_0=ruleXRelationalExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XRelationalExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1063:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
			loop12:
			while (true) {
				int alt12=2;
				switch ( input.LA(1) ) {
				case 45:
					{
					int LA12_2 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt12=1;
					}

					}
					break;
				case 14:
					{
					int LA12_3 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt12=1;
					}

					}
					break;
				case 46:
					{
					int LA12_4 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt12=1;
					}

					}
					break;
				case 15:
					{
					int LA12_5 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt12=1;
					}

					}
					break;
				}
				switch (alt12) {
				case 1 :
					// InternalWeightDefinition.g:1064:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					{
					// InternalWeightDefinition.g:1064:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
					// InternalWeightDefinition.g:1065:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
					{
					// InternalWeightDefinition.g:1075:5: ( () ( ( ruleOpEquality ) ) )
					// InternalWeightDefinition.g:1076:6: () ( ( ruleOpEquality ) )
					{
					// InternalWeightDefinition.g:1076:6: ()
					// InternalWeightDefinition.g:1077:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1083:6: ( ( ruleOpEquality ) )
					// InternalWeightDefinition.g:1084:7: ( ruleOpEquality )
					{
					// InternalWeightDefinition.g:1084:7: ( ruleOpEquality )
					// InternalWeightDefinition.g:1085:8: ruleOpEquality
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXEqualityExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_13);
					ruleOpEquality();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalWeightDefinition.g:1101:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					// InternalWeightDefinition.g:1102:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					{
					// InternalWeightDefinition.g:1102:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					// InternalWeightDefinition.g:1103:6: lv_rightOperand_3_0= ruleXRelationalExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_20);
					lv_rightOperand_3_0=ruleXRelationalExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXEqualityExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XRelationalExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop12;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXEqualityExpression"



	// $ANTLR start "entryRuleOpEquality"
	// InternalWeightDefinition.g:1125:1: entryRuleOpEquality returns [String current=null] :iv_ruleOpEquality= ruleOpEquality EOF ;
	public final String entryRuleOpEquality() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpEquality =null;

		try {
			// InternalWeightDefinition.g:1125:50: (iv_ruleOpEquality= ruleOpEquality EOF )
			// InternalWeightDefinition.g:1126:2: iv_ruleOpEquality= ruleOpEquality EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpEqualityRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpEquality=ruleOpEquality();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpEquality.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpEquality"



	// $ANTLR start "ruleOpEquality"
	// InternalWeightDefinition.g:1132:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' ) ;
	public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1138:2: ( (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' ) )
			// InternalWeightDefinition.g:1139:2: (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' )
			{
			// InternalWeightDefinition.g:1139:2: (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' )
			int alt13=4;
			switch ( input.LA(1) ) {
			case 45:
				{
				alt13=1;
				}
				break;
			case 14:
				{
				alt13=2;
				}
				break;
			case 46:
				{
				alt13=3;
				}
				break;
			case 15:
				{
				alt13=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// InternalWeightDefinition.g:1140:3: kw= '=='
					{
					kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1146:3: kw= '!='
					{
					kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1152:3: kw= '==='
					{
					kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:1158:3: kw= '!=='
					{
					kw=(Token)match(input,15,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignEqualsSignKeyword_3());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpEquality"



	// $ANTLR start "entryRuleXRelationalExpression"
	// InternalWeightDefinition.g:1167:1: entryRuleXRelationalExpression returns [EObject current=null] :iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
	public final EObject entryRuleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXRelationalExpression =null;

		try {
			// InternalWeightDefinition.g:1167:62: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
			// InternalWeightDefinition.g:1168:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXRelationalExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXRelationalExpression=ruleXRelationalExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXRelationalExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXRelationalExpression"



	// $ANTLR start "ruleXRelationalExpression"
	// InternalWeightDefinition.g:1174:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
	public final EObject ruleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_XOtherOperatorExpression_0 =null;
		EObject lv_type_3_0 =null;
		EObject lv_rightOperand_6_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1180:2: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
			// InternalWeightDefinition.g:1181:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			{
			// InternalWeightDefinition.g:1181:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			// InternalWeightDefinition.g:1182:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_21);
			this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XOtherOperatorExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1190:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
			loop14:
			while (true) {
				int alt14=3;
				switch ( input.LA(1) ) {
				case 42:
					{
					int LA14_2 = input.LA(2);
					if ( (synpred6_InternalWeightDefinition()) ) {
						alt14=2;
					}

					}
					break;
				case 48:
					{
					int LA14_3 = input.LA(2);
					if ( (synpred6_InternalWeightDefinition()) ) {
						alt14=2;
					}

					}
					break;
				case 69:
					{
					int LA14_4 = input.LA(2);
					if ( (synpred5_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 49:
					{
					int LA14_5 = input.LA(2);
					if ( (synpred6_InternalWeightDefinition()) ) {
						alt14=2;
					}

					}
					break;
				}
				switch (alt14) {
				case 1 :
					// InternalWeightDefinition.g:1191:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					{
					// InternalWeightDefinition.g:1191:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					// InternalWeightDefinition.g:1192:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
					{
					// InternalWeightDefinition.g:1192:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
					// InternalWeightDefinition.g:1193:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
					{
					// InternalWeightDefinition.g:1199:6: ( () otherlv_2= 'instanceof' )
					// InternalWeightDefinition.g:1200:7: () otherlv_2= 'instanceof'
					{
					// InternalWeightDefinition.g:1200:7: ()
					// InternalWeightDefinition.g:1201:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
														current);
												}
					}

					otherlv_2=(Token)match(input,69,FOLLOW_8); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
											}
					}

					}

					// InternalWeightDefinition.g:1213:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalWeightDefinition.g:1214:6: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:1214:6: (lv_type_3_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:1215:7: lv_type_3_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0());
											}
					pushFollow(FOLLOW_21);
					lv_type_3_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
												}
												set(
													current,
													"type",
													lv_type_3_0,
													"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1234:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					{
					// InternalWeightDefinition.g:1234:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					// InternalWeightDefinition.g:1235:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					{
					// InternalWeightDefinition.g:1235:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
					// InternalWeightDefinition.g:1236:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
					{
					// InternalWeightDefinition.g:1246:6: ( () ( ( ruleOpCompare ) ) )
					// InternalWeightDefinition.g:1247:7: () ( ( ruleOpCompare ) )
					{
					// InternalWeightDefinition.g:1247:7: ()
					// InternalWeightDefinition.g:1248:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
														current);
												}
					}

					// InternalWeightDefinition.g:1254:7: ( ( ruleOpCompare ) )
					// InternalWeightDefinition.g:1255:8: ( ruleOpCompare )
					{
					// InternalWeightDefinition.g:1255:8: ( ruleOpCompare )
					// InternalWeightDefinition.g:1256:9: ruleOpCompare
					{
					if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getXRelationalExpressionRule());
														}
													}
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
													}
					pushFollow(FOLLOW_13);
					ruleOpCompare();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
					}

					}

					}

					}

					// InternalWeightDefinition.g:1272:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					// InternalWeightDefinition.g:1273:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					{
					// InternalWeightDefinition.g:1273:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					// InternalWeightDefinition.g:1274:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0());
											}
					pushFollow(FOLLOW_21);
					lv_rightOperand_6_0=ruleXOtherOperatorExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXRelationalExpressionRule());
												}
												set(
													current,
													"rightOperand",
													lv_rightOperand_6_0,
													"org.eclipse.xtext.xbase.Xbase.XOtherOperatorExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;

				default :
					break loop14;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXRelationalExpression"



	// $ANTLR start "entryRuleOpCompare"
	// InternalWeightDefinition.g:1297:1: entryRuleOpCompare returns [String current=null] :iv_ruleOpCompare= ruleOpCompare EOF ;
	public final String entryRuleOpCompare() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpCompare =null;

		try {
			// InternalWeightDefinition.g:1297:49: (iv_ruleOpCompare= ruleOpCompare EOF )
			// InternalWeightDefinition.g:1298:2: iv_ruleOpCompare= ruleOpCompare EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpCompareRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpCompare=ruleOpCompare();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpCompare.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpCompare"



	// $ANTLR start "ruleOpCompare"
	// InternalWeightDefinition.g:1304:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) ;
	public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1310:2: ( (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) )
			// InternalWeightDefinition.g:1311:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			{
			// InternalWeightDefinition.g:1311:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			int alt15=4;
			switch ( input.LA(1) ) {
			case 49:
				{
				alt15=1;
				}
				break;
			case 42:
				{
				int LA15_2 = input.LA(2);
				if ( (LA15_2==44) ) {
					alt15=2;
				}
				else if ( (LA15_2==EOF||(LA15_2 >= RULE_DECIMAL && LA15_2 <= RULE_INT)||LA15_2==RULE_STRING||LA15_2==13||LA15_2==16||LA15_2==21||LA15_2==26||LA15_2==30||LA15_2==42||LA15_2==53||LA15_2==59||(LA15_2 >= 61 && LA15_2 <= 63)||LA15_2==65||(LA15_2 >= 67 && LA15_2 <= 68)||(LA15_2 >= 70 && LA15_2 <= 72)||(LA15_2 >= 74 && LA15_2 <= 81)||(LA15_2 >= 84 && LA15_2 <= 85)) ) {
					alt15=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 48:
				{
				alt15=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// InternalWeightDefinition.g:1312:3: kw= '>='
					{
					kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1318:3: (kw= '<' kw= '=' )
					{
					// InternalWeightDefinition.g:1318:3: (kw= '<' kw= '=' )
					// InternalWeightDefinition.g:1319:4: kw= '<' kw= '='
					{
					kw=(Token)match(input,42,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_1_0());
								}
					kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpCompareAccess().getEqualsSignKeyword_1_1());
								}
					}

					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1331:3: kw= '>'
					{
					kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:1337:3: kw= '<'
					{
					kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpCompare"



	// $ANTLR start "entryRuleXOtherOperatorExpression"
	// InternalWeightDefinition.g:1346:1: entryRuleXOtherOperatorExpression returns [EObject current=null] :iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
	public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOtherOperatorExpression =null;

		try {
			// InternalWeightDefinition.g:1346:65: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
			// InternalWeightDefinition.g:1347:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXOtherOperatorExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXOtherOperatorExpression=ruleXOtherOperatorExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXOtherOperatorExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXOtherOperatorExpression"



	// $ANTLR start "ruleXOtherOperatorExpression"
	// InternalWeightDefinition.g:1353:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
	public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAdditiveExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1359:2: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
			// InternalWeightDefinition.g:1360:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			{
			// InternalWeightDefinition.g:1360:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			// InternalWeightDefinition.g:1361:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_22);
			this_XAdditiveExpression_0=ruleXAdditiveExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XAdditiveExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1369:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
			loop16:
			while (true) {
				int alt16=2;
				switch ( input.LA(1) ) {
				case 42:
					{
					int LA16_2 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				case 48:
					{
					int LA16_3 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				case 33:
					{
					int LA16_4 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				case 36:
					{
					int LA16_5 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				case 35:
					{
					int LA16_6 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				case 47:
					{
					int LA16_7 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				case 43:
					{
					int LA16_8 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				case 52:
					{
					int LA16_9 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt16=1;
					}

					}
					break;
				}
				switch (alt16) {
				case 1 :
					// InternalWeightDefinition.g:1370:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					{
					// InternalWeightDefinition.g:1370:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
					// InternalWeightDefinition.g:1371:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
					{
					// InternalWeightDefinition.g:1381:5: ( () ( ( ruleOpOther ) ) )
					// InternalWeightDefinition.g:1382:6: () ( ( ruleOpOther ) )
					{
					// InternalWeightDefinition.g:1382:6: ()
					// InternalWeightDefinition.g:1383:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1389:6: ( ( ruleOpOther ) )
					// InternalWeightDefinition.g:1390:7: ( ruleOpOther )
					{
					// InternalWeightDefinition.g:1390:7: ( ruleOpOther )
					// InternalWeightDefinition.g:1391:8: ruleOpOther
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_13);
					ruleOpOther();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalWeightDefinition.g:1407:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					// InternalWeightDefinition.g:1408:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					{
					// InternalWeightDefinition.g:1408:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					// InternalWeightDefinition.g:1409:6: lv_rightOperand_3_0= ruleXAdditiveExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_22);
					lv_rightOperand_3_0=ruleXAdditiveExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXOtherOperatorExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XAdditiveExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop16;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXOtherOperatorExpression"



	// $ANTLR start "entryRuleOpOther"
	// InternalWeightDefinition.g:1431:1: entryRuleOpOther returns [String current=null] :iv_ruleOpOther= ruleOpOther EOF ;
	public final String entryRuleOpOther() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOther =null;

		try {
			// InternalWeightDefinition.g:1431:47: (iv_ruleOpOther= ruleOpOther EOF )
			// InternalWeightDefinition.g:1432:2: iv_ruleOpOther= ruleOpOther EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpOtherRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpOther=ruleOpOther();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpOther.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpOther"



	// $ANTLR start "ruleOpOther"
	// InternalWeightDefinition.g:1438:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' ) ;
	public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1444:2: ( (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' ) )
			// InternalWeightDefinition.g:1445:2: (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' )
			{
			// InternalWeightDefinition.g:1445:2: (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' )
			int alt19=9;
			switch ( input.LA(1) ) {
			case 33:
				{
				alt19=1;
				}
				break;
			case 36:
				{
				alt19=2;
				}
				break;
			case 48:
				{
				int LA19_3 = input.LA(2);
				if ( (LA19_3==35) ) {
					alt19=3;
				}
				else if ( (LA19_3==48) ) {
					alt19=6;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 35:
				{
				alt19=4;
				}
				break;
			case 47:
				{
				alt19=5;
				}
				break;
			case 42:
				{
				alt19=7;
				}
				break;
			case 43:
				{
				alt19=8;
				}
				break;
			case 52:
				{
				alt19=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// InternalWeightDefinition.g:1446:3: kw= '->'
					{
					kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1452:3: kw= '..<'
					{
					kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1458:3: (kw= '>' kw= '..' )
					{
					// InternalWeightDefinition.g:1458:3: (kw= '>' kw= '..' )
					// InternalWeightDefinition.g:1459:4: kw= '>' kw= '..'
					{
					kw=(Token)match(input,48,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_2_0());
								}
					kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_2_1());
								}
					}

					}
					break;
				case 4 :
					// InternalWeightDefinition.g:1471:3: kw= '..'
					{
					kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalWeightDefinition.g:1477:3: kw= '=>'
					{
					kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4());
							}
					}
					break;
				case 6 :
					// InternalWeightDefinition.g:1483:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					{
					// InternalWeightDefinition.g:1483:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					// InternalWeightDefinition.g:1484:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					{
					kw=(Token)match(input,48,FOLLOW_24); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0());
								}
					// InternalWeightDefinition.g:1489:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==48) ) {
						int LA17_1 = input.LA(2);
						if ( (LA17_1==48) && (synpred8_InternalWeightDefinition())) {
							alt17=1;
						}
						else if ( (LA17_1==EOF||(LA17_1 >= RULE_DECIMAL && LA17_1 <= RULE_INT)||LA17_1==RULE_STRING||LA17_1==13||LA17_1==16||LA17_1==21||LA17_1==26||LA17_1==30||LA17_1==42||LA17_1==53||LA17_1==59||(LA17_1 >= 61 && LA17_1 <= 63)||LA17_1==65||(LA17_1 >= 67 && LA17_1 <= 68)||(LA17_1 >= 70 && LA17_1 <= 72)||(LA17_1 >= 74 && LA17_1 <= 81)||(LA17_1 >= 84 && LA17_1 <= 85)) ) {
							alt17=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return current;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 17, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 17, 0, input);
						throw nvae;
					}

					switch (alt17) {
						case 1 :
							// InternalWeightDefinition.g:1490:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							{
							// InternalWeightDefinition.g:1490:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							// InternalWeightDefinition.g:1491:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
							{
							// InternalWeightDefinition.g:1496:6: (kw= '>' kw= '>' )
							// InternalWeightDefinition.g:1497:7: kw= '>' kw= '>'
							{
							kw=(Token)match(input,48,FOLLOW_24); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_0());
													}
							kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_0_0_1());
													}
							}

							}

							}
							break;
						case 2 :
							// InternalWeightDefinition.g:1510:5: kw= '>'
							{
							kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_1_1());
											}
							}
							break;

					}

					}

					}
					break;
				case 7 :
					// InternalWeightDefinition.g:1518:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) )
					{
					// InternalWeightDefinition.g:1518:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) )
					// InternalWeightDefinition.g:1519:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' )
					{
					kw=(Token)match(input,42,FOLLOW_25); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0());
								}
					// InternalWeightDefinition.g:1524:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' )
					int alt18=3;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==42) ) {
						int LA18_1 = input.LA(2);
						if ( (synpred9_InternalWeightDefinition()) ) {
							alt18=1;
						}
						else if ( (true) ) {
							alt18=2;
						}

					}
					else if ( (LA18_0==47) ) {
						alt18=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 18, 0, input);
						throw nvae;
					}

					switch (alt18) {
						case 1 :
							// InternalWeightDefinition.g:1525:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
							{
							// InternalWeightDefinition.g:1525:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
							// InternalWeightDefinition.g:1526:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
							{
							// InternalWeightDefinition.g:1531:6: (kw= '<' kw= '<' )
							// InternalWeightDefinition.g:1532:7: kw= '<' kw= '<'
							{
							kw=(Token)match(input,42,FOLLOW_15); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_0());
													}
							kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														current.merge(kw);
														newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_0_0_1());
													}
							}

							}

							}
							break;
						case 2 :
							// InternalWeightDefinition.g:1545:5: kw= '<'
							{
							kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1());
											}
							}
							break;
						case 3 :
							// InternalWeightDefinition.g:1551:5: kw= '=>'
							{
							kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_6_1_2());
											}
							}
							break;

					}

					}

					}
					break;
				case 8 :
					// InternalWeightDefinition.g:1559:3: kw= '<>'
					{
					kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7());
							}
					}
					break;
				case 9 :
					// InternalWeightDefinition.g:1565:3: kw= '?:'
					{
					kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getQuestionMarkColonKeyword_8());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpOther"



	// $ANTLR start "entryRuleXAdditiveExpression"
	// InternalWeightDefinition.g:1574:1: entryRuleXAdditiveExpression returns [EObject current=null] :iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
	public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAdditiveExpression =null;

		try {
			// InternalWeightDefinition.g:1574:60: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
			// InternalWeightDefinition.g:1575:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXAdditiveExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXAdditiveExpression=ruleXAdditiveExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXAdditiveExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXAdditiveExpression"



	// $ANTLR start "ruleXAdditiveExpression"
	// InternalWeightDefinition.g:1581:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
	public final EObject ruleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XMultiplicativeExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1587:2: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
			// InternalWeightDefinition.g:1588:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			{
			// InternalWeightDefinition.g:1588:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			// InternalWeightDefinition.g:1589:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_26);
			this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XMultiplicativeExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1597:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==26) ) {
					int LA20_2 = input.LA(2);
					if ( (synpred10_InternalWeightDefinition()) ) {
						alt20=1;
					}

				}
				else if ( (LA20_0==30) ) {
					int LA20_3 = input.LA(2);
					if ( (synpred10_InternalWeightDefinition()) ) {
						alt20=1;
					}

				}

				switch (alt20) {
				case 1 :
					// InternalWeightDefinition.g:1598:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					{
					// InternalWeightDefinition.g:1598:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
					// InternalWeightDefinition.g:1599:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
					{
					// InternalWeightDefinition.g:1609:5: ( () ( ( ruleOpAdd ) ) )
					// InternalWeightDefinition.g:1610:6: () ( ( ruleOpAdd ) )
					{
					// InternalWeightDefinition.g:1610:6: ()
					// InternalWeightDefinition.g:1611:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1617:6: ( ( ruleOpAdd ) )
					// InternalWeightDefinition.g:1618:7: ( ruleOpAdd )
					{
					// InternalWeightDefinition.g:1618:7: ( ruleOpAdd )
					// InternalWeightDefinition.g:1619:8: ruleOpAdd
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_13);
					ruleOpAdd();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalWeightDefinition.g:1635:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					// InternalWeightDefinition.g:1636:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					{
					// InternalWeightDefinition.g:1636:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					// InternalWeightDefinition.g:1637:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_26);
					lv_rightOperand_3_0=ruleXMultiplicativeExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXAdditiveExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XMultiplicativeExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop20;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXAdditiveExpression"



	// $ANTLR start "entryRuleOpAdd"
	// InternalWeightDefinition.g:1659:1: entryRuleOpAdd returns [String current=null] :iv_ruleOpAdd= ruleOpAdd EOF ;
	public final String entryRuleOpAdd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAdd =null;

		try {
			// InternalWeightDefinition.g:1659:45: (iv_ruleOpAdd= ruleOpAdd EOF )
			// InternalWeightDefinition.g:1660:2: iv_ruleOpAdd= ruleOpAdd EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpAddRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpAdd=ruleOpAdd();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpAdd.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpAdd"



	// $ANTLR start "ruleOpAdd"
	// InternalWeightDefinition.g:1666:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' |kw= '-' ) ;
	public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1672:2: ( (kw= '+' |kw= '-' ) )
			// InternalWeightDefinition.g:1673:2: (kw= '+' |kw= '-' )
			{
			// InternalWeightDefinition.g:1673:2: (kw= '+' |kw= '-' )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==26) ) {
				alt21=1;
			}
			else if ( (LA21_0==30) ) {
				alt21=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// InternalWeightDefinition.g:1674:3: kw= '+'
					{
					kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1680:3: kw= '-'
					{
					kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpAdd"



	// $ANTLR start "entryRuleXMultiplicativeExpression"
	// InternalWeightDefinition.g:1689:1: entryRuleXMultiplicativeExpression returns [EObject current=null] :iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
	public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMultiplicativeExpression =null;

		try {
			// InternalWeightDefinition.g:1689:66: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
			// InternalWeightDefinition.g:1690:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXMultiplicativeExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXMultiplicativeExpression=ruleXMultiplicativeExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXMultiplicativeExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXMultiplicativeExpression"



	// $ANTLR start "ruleXMultiplicativeExpression"
	// InternalWeightDefinition.g:1696:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
	public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XUnaryOperation_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1702:2: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
			// InternalWeightDefinition.g:1703:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			{
			// InternalWeightDefinition.g:1703:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			// InternalWeightDefinition.g:1704:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0());
					}
			pushFollow(FOLLOW_27);
			this_XUnaryOperation_0=ruleXUnaryOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XUnaryOperation_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1712:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
			loop22:
			while (true) {
				int alt22=2;
				switch ( input.LA(1) ) {
				case 23:
					{
					int LA22_2 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt22=1;
					}

					}
					break;
				case 24:
					{
					int LA22_3 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt22=1;
					}

					}
					break;
				case 37:
					{
					int LA22_4 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt22=1;
					}

					}
					break;
				case 17:
					{
					int LA22_5 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt22=1;
					}

					}
					break;
				}
				switch (alt22) {
				case 1 :
					// InternalWeightDefinition.g:1713:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					{
					// InternalWeightDefinition.g:1713:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
					// InternalWeightDefinition.g:1714:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
					{
					// InternalWeightDefinition.g:1724:5: ( () ( ( ruleOpMulti ) ) )
					// InternalWeightDefinition.g:1725:6: () ( ( ruleOpMulti ) )
					{
					// InternalWeightDefinition.g:1725:6: ()
					// InternalWeightDefinition.g:1726:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1732:6: ( ( ruleOpMulti ) )
					// InternalWeightDefinition.g:1733:7: ( ruleOpMulti )
					{
					// InternalWeightDefinition.g:1733:7: ( ruleOpMulti )
					// InternalWeightDefinition.g:1734:8: ruleOpMulti
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_13);
					ruleOpMulti();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					// InternalWeightDefinition.g:1750:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					// InternalWeightDefinition.g:1751:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					{
					// InternalWeightDefinition.g:1751:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					// InternalWeightDefinition.g:1752:6: lv_rightOperand_3_0= ruleXUnaryOperation
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_27);
					lv_rightOperand_3_0=ruleXUnaryOperation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXMultiplicativeExpressionRule());
											}
											set(
												current,
												"rightOperand",
												lv_rightOperand_3_0,
												"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop22;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXMultiplicativeExpression"



	// $ANTLR start "entryRuleOpMulti"
	// InternalWeightDefinition.g:1774:1: entryRuleOpMulti returns [String current=null] :iv_ruleOpMulti= ruleOpMulti EOF ;
	public final String entryRuleOpMulti() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMulti =null;

		try {
			// InternalWeightDefinition.g:1774:47: (iv_ruleOpMulti= ruleOpMulti EOF )
			// InternalWeightDefinition.g:1775:2: iv_ruleOpMulti= ruleOpMulti EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpMultiRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpMulti=ruleOpMulti();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpMulti.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpMulti"



	// $ANTLR start "ruleOpMulti"
	// InternalWeightDefinition.g:1781:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' |kw= '**' |kw= '/' |kw= '%' ) ;
	public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1787:2: ( (kw= '*' |kw= '**' |kw= '/' |kw= '%' ) )
			// InternalWeightDefinition.g:1788:2: (kw= '*' |kw= '**' |kw= '/' |kw= '%' )
			{
			// InternalWeightDefinition.g:1788:2: (kw= '*' |kw= '**' |kw= '/' |kw= '%' )
			int alt23=4;
			switch ( input.LA(1) ) {
			case 23:
				{
				alt23=1;
				}
				break;
			case 24:
				{
				alt23=2;
				}
				break;
			case 37:
				{
				alt23=3;
				}
				break;
			case 17:
				{
				alt23=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// InternalWeightDefinition.g:1789:3: kw= '*'
					{
					kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1795:3: kw= '**'
					{
					kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1801:3: kw= '/'
					{
					kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:1807:3: kw= '%'
					{
					kw=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getPercentSignKeyword_3());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpMulti"



	// $ANTLR start "entryRuleXUnaryOperation"
	// InternalWeightDefinition.g:1816:1: entryRuleXUnaryOperation returns [EObject current=null] :iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
	public final EObject entryRuleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXUnaryOperation =null;

		try {
			// InternalWeightDefinition.g:1816:56: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
			// InternalWeightDefinition.g:1817:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXUnaryOperationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXUnaryOperation=ruleXUnaryOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXUnaryOperation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXUnaryOperation"



	// $ANTLR start "ruleXUnaryOperation"
	// InternalWeightDefinition.g:1823:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) ;
	public final EObject ruleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject lv_operand_2_0 =null;
		EObject this_XCastedExpression_3 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1829:2: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) )
			// InternalWeightDefinition.g:1830:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			{
			// InternalWeightDefinition.g:1830:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==13||LA24_0==26||LA24_0==30) ) {
				alt24=1;
			}
			else if ( ((LA24_0 >= RULE_DECIMAL && LA24_0 <= RULE_INT)||LA24_0==RULE_STRING||LA24_0==16||LA24_0==21||LA24_0==42||LA24_0==53||LA24_0==59||(LA24_0 >= 61 && LA24_0 <= 63)||LA24_0==65||(LA24_0 >= 67 && LA24_0 <= 68)||(LA24_0 >= 70 && LA24_0 <= 72)||(LA24_0 >= 74 && LA24_0 <= 81)||(LA24_0 >= 84 && LA24_0 <= 85)) ) {
				alt24=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// InternalWeightDefinition.g:1831:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					{
					// InternalWeightDefinition.g:1831:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					// InternalWeightDefinition.g:1832:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
					{
					// InternalWeightDefinition.g:1832:4: ()
					// InternalWeightDefinition.g:1833:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
											current);
									}
					}

					// InternalWeightDefinition.g:1839:4: ( ( ruleOpUnary ) )
					// InternalWeightDefinition.g:1840:5: ( ruleOpUnary )
					{
					// InternalWeightDefinition.g:1840:5: ( ruleOpUnary )
					// InternalWeightDefinition.g:1841:6: ruleOpUnary
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXUnaryOperationRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
										}
					pushFollow(FOLLOW_13);
					ruleOpUnary();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:1855:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
					// InternalWeightDefinition.g:1856:5: (lv_operand_2_0= ruleXUnaryOperation )
					{
					// InternalWeightDefinition.g:1856:5: (lv_operand_2_0= ruleXUnaryOperation )
					// InternalWeightDefinition.g:1857:6: lv_operand_2_0= ruleXUnaryOperation
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXUnaryOperationAccess().getOperandXUnaryOperationParserRuleCall_0_2_0());
										}
					pushFollow(FOLLOW_2);
					lv_operand_2_0=ruleXUnaryOperation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXUnaryOperationRule());
											}
											set(
												current,
												"operand",
												lv_operand_2_0,
												"org.eclipse.xtext.xbase.Xbase.XUnaryOperation");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1876:3: this_XCastedExpression_3= ruleXCastedExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXUnaryOperationAccess().getXCastedExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XCastedExpression_3=ruleXCastedExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XCastedExpression_3;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXUnaryOperation"



	// $ANTLR start "entryRuleOpUnary"
	// InternalWeightDefinition.g:1888:1: entryRuleOpUnary returns [String current=null] :iv_ruleOpUnary= ruleOpUnary EOF ;
	public final String entryRuleOpUnary() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpUnary =null;

		try {
			// InternalWeightDefinition.g:1888:47: (iv_ruleOpUnary= ruleOpUnary EOF )
			// InternalWeightDefinition.g:1889:2: iv_ruleOpUnary= ruleOpUnary EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpUnaryRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpUnary=ruleOpUnary();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpUnary.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpUnary"



	// $ANTLR start "ruleOpUnary"
	// InternalWeightDefinition.g:1895:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' |kw= '-' |kw= '+' ) ;
	public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1901:2: ( (kw= '!' |kw= '-' |kw= '+' ) )
			// InternalWeightDefinition.g:1902:2: (kw= '!' |kw= '-' |kw= '+' )
			{
			// InternalWeightDefinition.g:1902:2: (kw= '!' |kw= '-' |kw= '+' )
			int alt25=3;
			switch ( input.LA(1) ) {
			case 13:
				{
				alt25=1;
				}
				break;
			case 30:
				{
				alt25=2;
				}
				break;
			case 26:
				{
				alt25=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// InternalWeightDefinition.g:1903:3: kw= '!'
					{
					kw=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1909:3: kw= '-'
					{
					kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1915:3: kw= '+'
					{
					kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpUnary"



	// $ANTLR start "entryRuleXCastedExpression"
	// InternalWeightDefinition.g:1924:1: entryRuleXCastedExpression returns [EObject current=null] :iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
	public final EObject entryRuleXCastedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCastedExpression =null;

		try {
			// InternalWeightDefinition.g:1924:58: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
			// InternalWeightDefinition.g:1925:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCastedExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCastedExpression=ruleXCastedExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCastedExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCastedExpression"



	// $ANTLR start "ruleXCastedExpression"
	// InternalWeightDefinition.g:1931:1: ruleXCastedExpression returns [EObject current=null] : (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
	public final EObject ruleXCastedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_XPostfixOperation_0 =null;
		EObject lv_type_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1937:2: ( (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
			// InternalWeightDefinition.g:1938:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
			{
			// InternalWeightDefinition.g:1938:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
			// InternalWeightDefinition.g:1939:3: this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0());
					}
			pushFollow(FOLLOW_28);
			this_XPostfixOperation_0=ruleXPostfixOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XPostfixOperation_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1947:3: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==55) ) {
					int LA26_2 = input.LA(2);
					if ( (synpred12_InternalWeightDefinition()) ) {
						alt26=1;
					}

				}

				switch (alt26) {
				case 1 :
					// InternalWeightDefinition.g:1948:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
					{
					// InternalWeightDefinition.g:1948:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
					// InternalWeightDefinition.g:1949:5: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
					{
					// InternalWeightDefinition.g:1955:5: ( () otherlv_2= 'as' )
					// InternalWeightDefinition.g:1956:6: () otherlv_2= 'as'
					{
					// InternalWeightDefinition.g:1956:6: ()
					// InternalWeightDefinition.g:1957:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
													current);
											}
					}

					otherlv_2=(Token)match(input,55,FOLLOW_8); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
										}
					}

					}

					// InternalWeightDefinition.g:1969:4: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalWeightDefinition.g:1970:5: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:1970:5: (lv_type_3_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:1971:6: lv_type_3_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_28);
					lv_type_3_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXCastedExpressionRule());
											}
											set(
												current,
												"type",
												lv_type_3_0,
												"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

				default :
					break loop26;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCastedExpression"



	// $ANTLR start "entryRuleXPostfixOperation"
	// InternalWeightDefinition.g:1993:1: entryRuleXPostfixOperation returns [EObject current=null] :iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
	public final EObject entryRuleXPostfixOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPostfixOperation =null;

		try {
			// InternalWeightDefinition.g:1993:58: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
			// InternalWeightDefinition.g:1994:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXPostfixOperationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXPostfixOperation=ruleXPostfixOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXPostfixOperation; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXPostfixOperation"



	// $ANTLR start "ruleXPostfixOperation"
	// InternalWeightDefinition.g:2000:1: ruleXPostfixOperation returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
	public final EObject ruleXPostfixOperation() throws RecognitionException {
		EObject current = null;


		EObject this_XMemberFeatureCall_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2006:2: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
			// InternalWeightDefinition.g:2007:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
			{
			// InternalWeightDefinition.g:2007:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
			// InternalWeightDefinition.g:2008:3: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0());
					}
			pushFollow(FOLLOW_29);
			this_XMemberFeatureCall_0=ruleXMemberFeatureCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XMemberFeatureCall_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:2016:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==27) ) {
				int LA27_1 = input.LA(2);
				if ( (synpred13_InternalWeightDefinition()) ) {
					alt27=1;
				}
			}
			else if ( (LA27_0==31) ) {
				int LA27_2 = input.LA(2);
				if ( (synpred13_InternalWeightDefinition()) ) {
					alt27=1;
				}
			}
			switch (alt27) {
				case 1 :
					// InternalWeightDefinition.g:2017:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
					{
					// InternalWeightDefinition.g:2027:4: ( () ( ( ruleOpPostfix ) ) )
					// InternalWeightDefinition.g:2028:5: () ( ( ruleOpPostfix ) )
					{
					// InternalWeightDefinition.g:2028:5: ()
					// InternalWeightDefinition.g:2029:6: 
					{
					if ( state.backtracking==0 ) {
											current = forceCreateModelElementAndSet(
												grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(),
												current);
										}
					}

					// InternalWeightDefinition.g:2035:5: ( ( ruleOpPostfix ) )
					// InternalWeightDefinition.g:2036:6: ( ruleOpPostfix )
					{
					// InternalWeightDefinition.g:2036:6: ( ruleOpPostfix )
					// InternalWeightDefinition.g:2037:7: ruleOpPostfix
					{
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXPostfixOperationRule());
												}
											}
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXPostfixOperationAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_1_0());
											}
					pushFollow(FOLLOW_2);
					ruleOpPostfix();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXPostfixOperation"



	// $ANTLR start "entryRuleOpPostfix"
	// InternalWeightDefinition.g:2057:1: entryRuleOpPostfix returns [String current=null] :iv_ruleOpPostfix= ruleOpPostfix EOF ;
	public final String entryRuleOpPostfix() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpPostfix =null;

		try {
			// InternalWeightDefinition.g:2057:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
			// InternalWeightDefinition.g:2058:2: iv_ruleOpPostfix= ruleOpPostfix EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getOpPostfixRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleOpPostfix=ruleOpPostfix();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleOpPostfix.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleOpPostfix"



	// $ANTLR start "ruleOpPostfix"
	// InternalWeightDefinition.g:2064:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' |kw= '--' ) ;
	public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2070:2: ( (kw= '++' |kw= '--' ) )
			// InternalWeightDefinition.g:2071:2: (kw= '++' |kw= '--' )
			{
			// InternalWeightDefinition.g:2071:2: (kw= '++' |kw= '--' )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==27) ) {
				alt28=1;
			}
			else if ( (LA28_0==31) ) {
				alt28=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// InternalWeightDefinition.g:2072:3: kw= '++'
					{
					kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:2078:3: kw= '--'
					{
					kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpPostfixAccess().getHyphenMinusHyphenMinusKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleOpPostfix"



	// $ANTLR start "entryRuleXMemberFeatureCall"
	// InternalWeightDefinition.g:2087:1: entryRuleXMemberFeatureCall returns [EObject current=null] :iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
	public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMemberFeatureCall =null;

		try {
			// InternalWeightDefinition.g:2087:59: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
			// InternalWeightDefinition.g:2088:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXMemberFeatureCallRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXMemberFeatureCall=ruleXMemberFeatureCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXMemberFeatureCall; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXMemberFeatureCall"



	// $ANTLR start "ruleXMemberFeatureCall"
	// InternalWeightDefinition.g:2094:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
	public final EObject ruleXMemberFeatureCall() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token lv_explicitStatic_3_0=null;
		Token otherlv_8=null;
		Token lv_nullSafe_9_0=null;
		Token lv_explicitStatic_10_0=null;
		Token otherlv_11=null;
		Token otherlv_13=null;
		Token otherlv_15=null;
		Token lv_explicitOperationCall_17_0=null;
		Token otherlv_20=null;
		Token otherlv_22=null;
		EObject this_XPrimaryExpression_0 =null;
		EObject lv_value_6_0 =null;
		EObject lv_typeArguments_12_0 =null;
		EObject lv_typeArguments_14_0 =null;
		EObject lv_memberCallArguments_18_0 =null;
		EObject lv_memberCallArguments_19_0 =null;
		EObject lv_memberCallArguments_21_0 =null;
		EObject lv_memberCallArguments_23_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2100:2: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
			// InternalWeightDefinition.g:2101:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
			{
			// InternalWeightDefinition.g:2101:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
			// InternalWeightDefinition.g:2102:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_30);
			this_XPrimaryExpression_0=ruleXPrimaryExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XPrimaryExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:2110:3: ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
			loop37:
			while (true) {
				int alt37=3;
				switch ( input.LA(1) ) {
				case 34:
					{
					int LA37_2 = input.LA(2);
					if ( (synpred14_InternalWeightDefinition()) ) {
						alt37=1;
					}
					else if ( (synpred15_InternalWeightDefinition()) ) {
						alt37=2;
					}

					}
					break;
				case 40:
					{
					int LA37_3 = input.LA(2);
					if ( (synpred14_InternalWeightDefinition()) ) {
						alt37=1;
					}
					else if ( (synpred15_InternalWeightDefinition()) ) {
						alt37=2;
					}

					}
					break;
				case 51:
					{
					int LA37_4 = input.LA(2);
					if ( (synpred15_InternalWeightDefinition()) ) {
						alt37=2;
					}

					}
					break;
				}
				switch (alt37) {
				case 1 :
					// InternalWeightDefinition.g:2111:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
					{
					// InternalWeightDefinition.g:2111:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
					// InternalWeightDefinition.g:2112:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
					{
					// InternalWeightDefinition.g:2112:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
					// InternalWeightDefinition.g:2113:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					{
					// InternalWeightDefinition.g:2133:6: ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					// InternalWeightDefinition.g:2134:7: () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
					{
					// InternalWeightDefinition.g:2134:7: ()
					// InternalWeightDefinition.g:2135:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
														current);
												}
					}

					// InternalWeightDefinition.g:2141:7: (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) )
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==34) ) {
						alt29=1;
					}
					else if ( (LA29_0==40) ) {
						alt29=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 29, 0, input);
						throw nvae;
					}

					switch (alt29) {
						case 1 :
							// InternalWeightDefinition.g:2142:8: otherlv_2= '.'
							{
							otherlv_2=(Token)match(input,34,FOLLOW_31); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0());
														}
							}
							break;
						case 2 :
							// InternalWeightDefinition.g:2147:8: ( (lv_explicitStatic_3_0= '::' ) )
							{
							// InternalWeightDefinition.g:2147:8: ( (lv_explicitStatic_3_0= '::' ) )
							// InternalWeightDefinition.g:2148:9: (lv_explicitStatic_3_0= '::' )
							{
							// InternalWeightDefinition.g:2148:9: (lv_explicitStatic_3_0= '::' )
							// InternalWeightDefinition.g:2149:10: lv_explicitStatic_3_0= '::'
							{
							lv_explicitStatic_3_0=(Token)match(input,40,FOLLOW_31); if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	newLeafNode(lv_explicitStatic_3_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_0_0_0_1_1_0());
																}
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
																	}
																	setWithLastConsumed(current, "explicitStatic", true, "::");
																}
							}

							}

							}
							break;

					}

					// InternalWeightDefinition.g:2162:7: ( ( ruleFeatureCallID ) )
					// InternalWeightDefinition.g:2163:8: ( ruleFeatureCallID )
					{
					// InternalWeightDefinition.g:2163:8: ( ruleFeatureCallID )
					// InternalWeightDefinition.g:2164:9: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
														}
													}
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0());
													}
					pushFollow(FOLLOW_12);
					ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
					}

					}

					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getOpSingleAssignParserRuleCall_1_0_0_0_3());
											}
					pushFollow(FOLLOW_13);
					ruleOpSingleAssign();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:2187:5: ( (lv_value_6_0= ruleXAssignment ) )
					// InternalWeightDefinition.g:2188:6: (lv_value_6_0= ruleXAssignment )
					{
					// InternalWeightDefinition.g:2188:6: (lv_value_6_0= ruleXAssignment )
					// InternalWeightDefinition.g:2189:7: lv_value_6_0= ruleXAssignment
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0());
											}
					pushFollow(FOLLOW_30);
					lv_value_6_0=ruleXAssignment();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
												}
												set(
													current,
													"value",
													lv_value_6_0,
													"org.eclipse.xtext.xbase.Xbase.XAssignment");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:2208:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
					{
					// InternalWeightDefinition.g:2208:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
					// InternalWeightDefinition.g:2209:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
					{
					// InternalWeightDefinition.g:2209:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) )
					// InternalWeightDefinition.g:2210:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
					{
					// InternalWeightDefinition.g:2230:6: ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
					// InternalWeightDefinition.g:2231:7: () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
					{
					// InternalWeightDefinition.g:2231:7: ()
					// InternalWeightDefinition.g:2232:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
														current);
												}
					}

					// InternalWeightDefinition.g:2238:7: (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
					int alt30=3;
					switch ( input.LA(1) ) {
					case 34:
						{
						alt30=1;
						}
						break;
					case 51:
						{
						alt30=2;
						}
						break;
					case 40:
						{
						alt30=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 30, 0, input);
						throw nvae;
					}
					switch (alt30) {
						case 1 :
							// InternalWeightDefinition.g:2239:8: otherlv_8= '.'
							{
							otherlv_8=(Token)match(input,34,FOLLOW_32); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
														}
							}
							break;
						case 2 :
							// InternalWeightDefinition.g:2244:8: ( (lv_nullSafe_9_0= '?.' ) )
							{
							// InternalWeightDefinition.g:2244:8: ( (lv_nullSafe_9_0= '?.' ) )
							// InternalWeightDefinition.g:2245:9: (lv_nullSafe_9_0= '?.' )
							{
							// InternalWeightDefinition.g:2245:9: (lv_nullSafe_9_0= '?.' )
							// InternalWeightDefinition.g:2246:10: lv_nullSafe_9_0= '?.'
							{
							lv_nullSafe_9_0=(Token)match(input,51,FOLLOW_32); if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	newLeafNode(lv_nullSafe_9_0, grammarAccess.getXMemberFeatureCallAccess().getNullSafeQuestionMarkFullStopKeyword_1_1_0_0_1_1_0());
																}
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
																	}
																	setWithLastConsumed(current, "nullSafe", true, "?.");
																}
							}

							}

							}
							break;
						case 3 :
							// InternalWeightDefinition.g:2259:8: ( (lv_explicitStatic_10_0= '::' ) )
							{
							// InternalWeightDefinition.g:2259:8: ( (lv_explicitStatic_10_0= '::' ) )
							// InternalWeightDefinition.g:2260:9: (lv_explicitStatic_10_0= '::' )
							{
							// InternalWeightDefinition.g:2260:9: (lv_explicitStatic_10_0= '::' )
							// InternalWeightDefinition.g:2261:10: lv_explicitStatic_10_0= '::'
							{
							lv_explicitStatic_10_0=(Token)match(input,40,FOLLOW_32); if (state.failed) return current;
							if ( state.backtracking==0 ) {
																	newLeafNode(lv_explicitStatic_10_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitStaticColonColonKeyword_1_1_0_0_1_2_0());
																}
							if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
																	}
																	setWithLastConsumed(current, "explicitStatic", true, "::");
																}
							}

							}

							}
							break;

					}

					}

					}

					// InternalWeightDefinition.g:2276:5: (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )?
					int alt32=2;
					int LA32_0 = input.LA(1);
					if ( (LA32_0==42) ) {
						alt32=1;
					}
					switch (alt32) {
						case 1 :
							// InternalWeightDefinition.g:2277:6: otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>'
							{
							otherlv_11=(Token)match(input,42,FOLLOW_33); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
												}
							// InternalWeightDefinition.g:2281:6: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:2282:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:2282:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:2283:8: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0());
														}
							pushFollow(FOLLOW_34);
							lv_typeArguments_12_0=ruleJvmArgumentTypeReference();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
															}
															add(
																current,
																"typeArguments",
																lv_typeArguments_12_0,
																"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
															afterParserOrEnumRuleCall();
														}
							}

							}

							// InternalWeightDefinition.g:2300:6: (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
							loop31:
							while (true) {
								int alt31=2;
								int LA31_0 = input.LA(1);
								if ( (LA31_0==29) ) {
									alt31=1;
								}

								switch (alt31) {
								case 1 :
									// InternalWeightDefinition.g:2301:7: otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
									{
									otherlv_13=(Token)match(input,29,FOLLOW_33); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
															}
									// InternalWeightDefinition.g:2305:7: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
									// InternalWeightDefinition.g:2306:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
									{
									// InternalWeightDefinition.g:2306:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
									// InternalWeightDefinition.g:2307:9: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0());
																	}
									pushFollow(FOLLOW_34);
									lv_typeArguments_14_0=ruleJvmArgumentTypeReference();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		if (current==null) {
																			current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
																		}
																		add(
																			current,
																			"typeArguments",
																			lv_typeArguments_14_0,
																			"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
																		afterParserOrEnumRuleCall();
																	}
									}

									}

									}
									break;

								default :
									break loop31;
								}
							}

							otherlv_15=(Token)match(input,48,FOLLOW_35); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
												}
							}
							break;

					}

					// InternalWeightDefinition.g:2330:5: ( ( ruleIdOrSuper ) )
					// InternalWeightDefinition.g:2331:6: ( ruleIdOrSuper )
					{
					// InternalWeightDefinition.g:2331:6: ( ruleIdOrSuper )
					// InternalWeightDefinition.g:2332:7: ruleIdOrSuper
					{
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
												}
											}
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0());
											}
					pushFollow(FOLLOW_36);
					ruleIdOrSuper();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:2346:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?
					int alt35=2;
					alt35 = dfa35.predict(input);
					switch (alt35) {
						case 1 :
							// InternalWeightDefinition.g:2347:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')'
							{
							// InternalWeightDefinition.g:2347:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) )
							// InternalWeightDefinition.g:2348:7: ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' )
							{
							// InternalWeightDefinition.g:2352:7: (lv_explicitOperationCall_17_0= '(' )
							// InternalWeightDefinition.g:2353:8: lv_explicitOperationCall_17_0= '('
							{
							lv_explicitOperationCall_17_0=(Token)match(input,21,FOLLOW_37); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_explicitOperationCall_17_0, grammarAccess.getXMemberFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_1_1_3_0_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
															}
															setWithLastConsumed(current, "explicitOperationCall", true, "(");
														}
							}

							}

							// InternalWeightDefinition.g:2365:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
							int alt34=3;
							int LA34_0 = input.LA(1);
							if ( (LA34_0==RULE_ID) ) {
								int LA34_1 = input.LA(2);
								if ( (synpred17_InternalWeightDefinition()) ) {
									alt34=1;
								}
								else if ( (true) ) {
									alt34=2;
								}
							}
							else if ( (LA34_0==21) ) {
								int LA34_2 = input.LA(2);
								if ( (synpred17_InternalWeightDefinition()) ) {
									alt34=1;
								}
								else if ( (true) ) {
									alt34=2;
								}
							}
							else if ( (LA34_0==47) && (synpred17_InternalWeightDefinition())) {
								alt34=1;
							}
							else if ( (LA34_0==86) && (synpred17_InternalWeightDefinition())) {
								alt34=1;
							}
							else if ( ((LA34_0 >= RULE_DECIMAL && LA34_0 <= RULE_HEX)||LA34_0==RULE_INT||LA34_0==RULE_STRING||LA34_0==13||LA34_0==16||LA34_0==26||LA34_0==30||LA34_0==42||LA34_0==53||LA34_0==59||(LA34_0 >= 61 && LA34_0 <= 63)||LA34_0==65||(LA34_0 >= 67 && LA34_0 <= 68)||(LA34_0 >= 70 && LA34_0 <= 72)||(LA34_0 >= 74 && LA34_0 <= 81)||(LA34_0 >= 84 && LA34_0 <= 85)) ) {
								alt34=2;
							}
							switch (alt34) {
								case 1 :
									// InternalWeightDefinition.g:2366:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
									{
									// InternalWeightDefinition.g:2366:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
									// InternalWeightDefinition.g:2367:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
									{
									// InternalWeightDefinition.g:2392:8: (lv_memberCallArguments_18_0= ruleXShortClosure )
									// InternalWeightDefinition.g:2393:9: lv_memberCallArguments_18_0= ruleXShortClosure
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0());
																	}
									pushFollow(FOLLOW_38);
									lv_memberCallArguments_18_0=ruleXShortClosure();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		if (current==null) {
																			current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
																		}
																		add(
																			current,
																			"memberCallArguments",
																			lv_memberCallArguments_18_0,
																			"org.eclipse.xtext.xbase.Xbase.XShortClosure");
																		afterParserOrEnumRuleCall();
																	}
									}

									}

									}
									break;
								case 2 :
									// InternalWeightDefinition.g:2411:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
									{
									// InternalWeightDefinition.g:2411:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
									// InternalWeightDefinition.g:2412:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
									{
									// InternalWeightDefinition.g:2412:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
									// InternalWeightDefinition.g:2413:9: (lv_memberCallArguments_19_0= ruleXExpression )
									{
									// InternalWeightDefinition.g:2413:9: (lv_memberCallArguments_19_0= ruleXExpression )
									// InternalWeightDefinition.g:2414:10: lv_memberCallArguments_19_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																			newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0());
																		}
									pushFollow(FOLLOW_11);
									lv_memberCallArguments_19_0=ruleXExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																			if (current==null) {
																				current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
																			}
																			add(
																				current,
																				"memberCallArguments",
																				lv_memberCallArguments_19_0,
																				"org.eclipse.xtext.xbase.Xbase.XExpression");
																			afterParserOrEnumRuleCall();
																		}
									}

									}

									// InternalWeightDefinition.g:2431:8: (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
									loop33:
									while (true) {
										int alt33=2;
										int LA33_0 = input.LA(1);
										if ( (LA33_0==29) ) {
											alt33=1;
										}

										switch (alt33) {
										case 1 :
											// InternalWeightDefinition.g:2432:9: otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) )
											{
											otherlv_20=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																				newLeafNode(otherlv_20, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
																			}
											// InternalWeightDefinition.g:2436:9: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
											// InternalWeightDefinition.g:2437:10: (lv_memberCallArguments_21_0= ruleXExpression )
											{
											// InternalWeightDefinition.g:2437:10: (lv_memberCallArguments_21_0= ruleXExpression )
											// InternalWeightDefinition.g:2438:11: lv_memberCallArguments_21_0= ruleXExpression
											{
											if ( state.backtracking==0 ) {
																						newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0());
																					}
											pushFollow(FOLLOW_11);
											lv_memberCallArguments_21_0=ruleXExpression();
											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {
																						if (current==null) {
																							current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
																						}
																						add(
																							current,
																							"memberCallArguments",
																							lv_memberCallArguments_21_0,
																							"org.eclipse.xtext.xbase.Xbase.XExpression");
																						afterParserOrEnumRuleCall();
																					}
											}

											}

											}
											break;

										default :
											break loop33;
										}
									}

									}

									}
									break;

							}

							otherlv_22=(Token)match(input,22,FOLLOW_39); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_22, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
												}
							}
							break;

					}

					// InternalWeightDefinition.g:2463:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
					int alt36=2;
					alt36 = dfa36.predict(input);
					switch (alt36) {
						case 1 :
							// InternalWeightDefinition.g:2464:6: ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
							{
							// InternalWeightDefinition.g:2470:6: (lv_memberCallArguments_23_0= ruleXClosure )
							// InternalWeightDefinition.g:2471:7: lv_memberCallArguments_23_0= ruleXClosure
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0());
													}
							pushFollow(FOLLOW_30);
							lv_memberCallArguments_23_0=ruleXClosure();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXMemberFeatureCallRule());
														}
														add(
															current,
															"memberCallArguments",
															lv_memberCallArguments_23_0,
															"org.eclipse.xtext.xbase.Xbase.XClosure");
														afterParserOrEnumRuleCall();
													}
							}

							}
							break;

					}

					}

					}
					break;

				default :
					break loop37;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXMemberFeatureCall"



	// $ANTLR start "entryRuleXPrimaryExpression"
	// InternalWeightDefinition.g:2494:1: entryRuleXPrimaryExpression returns [EObject current=null] :iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
	public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPrimaryExpression =null;

		try {
			// InternalWeightDefinition.g:2494:59: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
			// InternalWeightDefinition.g:2495:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXPrimaryExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXPrimaryExpression=ruleXPrimaryExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXPrimaryExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXPrimaryExpression"



	// $ANTLR start "ruleXPrimaryExpression"
	// InternalWeightDefinition.g:2501:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) ;
	public final EObject ruleXPrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XConstructorCall_0 =null;
		EObject this_XBlockExpression_1 =null;
		EObject this_XSwitchExpression_2 =null;
		EObject this_XSynchronizedExpression_3 =null;
		EObject this_XFeatureCall_4 =null;
		EObject this_XLiteral_5 =null;
		EObject this_XIfExpression_6 =null;
		EObject this_XForLoopExpression_7 =null;
		EObject this_XBasicForLoopExpression_8 =null;
		EObject this_XWhileExpression_9 =null;
		EObject this_XDoWhileExpression_10 =null;
		EObject this_XThrowExpression_11 =null;
		EObject this_XReturnExpression_12 =null;
		EObject this_XTryCatchFinallyExpression_13 =null;
		EObject this_XParenthesizedExpression_14 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2507:2: ( (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) )
			// InternalWeightDefinition.g:2508:2: (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
			{
			// InternalWeightDefinition.g:2508:2: (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
			int alt38=15;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==70) ) {
				alt38=1;
			}
			else if ( (LA38_0==85) ) {
				alt38=2;
			}
			else if ( (LA38_0==76) ) {
				alt38=3;
			}
			else if ( (LA38_0==77) && (synpred19_InternalWeightDefinition())) {
				alt38=4;
			}
			else if ( (LA38_0==RULE_ID||LA38_0==42||(LA38_0 >= 61 && LA38_0 <= 62)||LA38_0==68||(LA38_0 >= 74 && LA38_0 <= 75)) ) {
				alt38=5;
			}
			else if ( ((LA38_0 >= RULE_DECIMAL && LA38_0 <= RULE_HEX)||LA38_0==RULE_INT||LA38_0==RULE_STRING||LA38_0==16||LA38_0==53||LA38_0==63||LA38_0==71||LA38_0==79||LA38_0==81) ) {
				alt38=6;
			}
			else if ( (LA38_0==67) ) {
				alt38=7;
			}
			else if ( (LA38_0==65) ) {
				int LA38_23 = input.LA(2);
				if ( (synpred20_InternalWeightDefinition()) ) {
					alt38=8;
				}
				else if ( (true) ) {
					alt38=9;
				}

			}
			else if ( (LA38_0==84) ) {
				alt38=10;
			}
			else if ( (LA38_0==59) ) {
				alt38=11;
			}
			else if ( (LA38_0==78) ) {
				alt38=12;
			}
			else if ( (LA38_0==72) ) {
				alt38=13;
			}
			else if ( (LA38_0==80) ) {
				alt38=14;
			}
			else if ( (LA38_0==21) ) {
				alt38=15;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// InternalWeightDefinition.g:2509:3: this_XConstructorCall_0= ruleXConstructorCall
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXConstructorCallParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_XConstructorCall_0=ruleXConstructorCall();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XConstructorCall_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:2518:3: this_XBlockExpression_1= ruleXBlockExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBlockExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XBlockExpression_1=ruleXBlockExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XBlockExpression_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:2527:3: this_XSwitchExpression_2= ruleXSwitchExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSwitchExpressionParserRuleCall_2());
							}
					pushFollow(FOLLOW_2);
					this_XSwitchExpression_2=ruleXSwitchExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XSwitchExpression_2;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:2536:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
					{
					// InternalWeightDefinition.g:2536:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
					// InternalWeightDefinition.g:2537:4: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXSynchronizedExpressionParserRuleCall_3());
								}
					pushFollow(FOLLOW_2);
					this_XSynchronizedExpression_3=ruleXSynchronizedExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XSynchronizedExpression_3;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 5 :
					// InternalWeightDefinition.g:2554:3: this_XFeatureCall_4= ruleXFeatureCall
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXFeatureCallParserRuleCall_4());
							}
					pushFollow(FOLLOW_2);
					this_XFeatureCall_4=ruleXFeatureCall();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XFeatureCall_4;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 6 :
					// InternalWeightDefinition.g:2563:3: this_XLiteral_5= ruleXLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXLiteralParserRuleCall_5());
							}
					pushFollow(FOLLOW_2);
					this_XLiteral_5=ruleXLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XLiteral_5;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 7 :
					// InternalWeightDefinition.g:2572:3: this_XIfExpression_6= ruleXIfExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXIfExpressionParserRuleCall_6());
							}
					pushFollow(FOLLOW_2);
					this_XIfExpression_6=ruleXIfExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XIfExpression_6;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 8 :
					// InternalWeightDefinition.g:2581:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
					{
					// InternalWeightDefinition.g:2581:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
					// InternalWeightDefinition.g:2582:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXForLoopExpressionParserRuleCall_7());
								}
					pushFollow(FOLLOW_2);
					this_XForLoopExpression_7=ruleXForLoopExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XForLoopExpression_7;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 9 :
					// InternalWeightDefinition.g:2605:3: this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXBasicForLoopExpressionParserRuleCall_8());
							}
					pushFollow(FOLLOW_2);
					this_XBasicForLoopExpression_8=ruleXBasicForLoopExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XBasicForLoopExpression_8;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 10 :
					// InternalWeightDefinition.g:2614:3: this_XWhileExpression_9= ruleXWhileExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXWhileExpressionParserRuleCall_9());
							}
					pushFollow(FOLLOW_2);
					this_XWhileExpression_9=ruleXWhileExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XWhileExpression_9;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 11 :
					// InternalWeightDefinition.g:2623:3: this_XDoWhileExpression_10= ruleXDoWhileExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXDoWhileExpressionParserRuleCall_10());
							}
					pushFollow(FOLLOW_2);
					this_XDoWhileExpression_10=ruleXDoWhileExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XDoWhileExpression_10;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 12 :
					// InternalWeightDefinition.g:2632:3: this_XThrowExpression_11= ruleXThrowExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXThrowExpressionParserRuleCall_11());
							}
					pushFollow(FOLLOW_2);
					this_XThrowExpression_11=ruleXThrowExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XThrowExpression_11;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 13 :
					// InternalWeightDefinition.g:2641:3: this_XReturnExpression_12= ruleXReturnExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXReturnExpressionParserRuleCall_12());
							}
					pushFollow(FOLLOW_2);
					this_XReturnExpression_12=ruleXReturnExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XReturnExpression_12;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 14 :
					// InternalWeightDefinition.g:2650:3: this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXTryCatchFinallyExpressionParserRuleCall_13());
							}
					pushFollow(FOLLOW_2);
					this_XTryCatchFinallyExpression_13=ruleXTryCatchFinallyExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XTryCatchFinallyExpression_13;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 15 :
					// InternalWeightDefinition.g:2659:3: this_XParenthesizedExpression_14= ruleXParenthesizedExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXPrimaryExpressionAccess().getXParenthesizedExpressionParserRuleCall_14());
							}
					pushFollow(FOLLOW_2);
					this_XParenthesizedExpression_14=ruleXParenthesizedExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XParenthesizedExpression_14;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXPrimaryExpression"



	// $ANTLR start "entryRuleXLiteral"
	// InternalWeightDefinition.g:2671:1: entryRuleXLiteral returns [EObject current=null] :iv_ruleXLiteral= ruleXLiteral EOF ;
	public final EObject entryRuleXLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXLiteral =null;

		try {
			// InternalWeightDefinition.g:2671:49: (iv_ruleXLiteral= ruleXLiteral EOF )
			// InternalWeightDefinition.g:2672:2: iv_ruleXLiteral= ruleXLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXLiteral=ruleXLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXLiteral"



	// $ANTLR start "ruleXLiteral"
	// InternalWeightDefinition.g:2678:1: ruleXLiteral returns [EObject current=null] : (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral ) ;
	public final EObject ruleXLiteral() throws RecognitionException {
		EObject current = null;


		EObject this_XCollectionLiteral_0 =null;
		EObject this_XClosure_1 =null;
		EObject this_XBooleanLiteral_2 =null;
		EObject this_XNumberLiteral_3 =null;
		EObject this_XNullLiteral_4 =null;
		EObject this_XStringLiteral_5 =null;
		EObject this_XTypeLiteral_6 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2684:2: ( (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral ) )
			// InternalWeightDefinition.g:2685:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral )
			{
			// InternalWeightDefinition.g:2685:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral )
			int alt39=7;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==16) ) {
				alt39=1;
			}
			else if ( (LA39_0==53) && (synpred21_InternalWeightDefinition())) {
				alt39=2;
			}
			else if ( (LA39_0==63||LA39_0==79) ) {
				alt39=3;
			}
			else if ( ((LA39_0 >= RULE_DECIMAL && LA39_0 <= RULE_HEX)||LA39_0==RULE_INT) ) {
				alt39=4;
			}
			else if ( (LA39_0==71) ) {
				alt39=5;
			}
			else if ( (LA39_0==RULE_STRING) ) {
				alt39=6;
			}
			else if ( (LA39_0==81) ) {
				alt39=7;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// InternalWeightDefinition.g:2686:3: this_XCollectionLiteral_0= ruleXCollectionLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXCollectionLiteralParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_XCollectionLiteral_0=ruleXCollectionLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XCollectionLiteral_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:2695:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
					{
					// InternalWeightDefinition.g:2695:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
					// InternalWeightDefinition.g:2696:4: ( ( () '[' ) )=>this_XClosure_1= ruleXClosure
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXLiteralAccess().getXClosureParserRuleCall_1());
								}
					pushFollow(FOLLOW_2);
					this_XClosure_1=ruleXClosure();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XClosure_1;
									afterParserOrEnumRuleCall();
								}
					}

					}
					break;
				case 3 :
					// InternalWeightDefinition.g:2712:3: this_XBooleanLiteral_2= ruleXBooleanLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXBooleanLiteralParserRuleCall_2());
							}
					pushFollow(FOLLOW_2);
					this_XBooleanLiteral_2=ruleXBooleanLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XBooleanLiteral_2;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:2721:3: this_XNumberLiteral_3= ruleXNumberLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXNumberLiteralParserRuleCall_3());
							}
					pushFollow(FOLLOW_2);
					this_XNumberLiteral_3=ruleXNumberLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XNumberLiteral_3;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 5 :
					// InternalWeightDefinition.g:2730:3: this_XNullLiteral_4= ruleXNullLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXNullLiteralParserRuleCall_4());
							}
					pushFollow(FOLLOW_2);
					this_XNullLiteral_4=ruleXNullLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XNullLiteral_4;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 6 :
					// InternalWeightDefinition.g:2739:3: this_XStringLiteral_5= ruleXStringLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXStringLiteralParserRuleCall_5());
							}
					pushFollow(FOLLOW_2);
					this_XStringLiteral_5=ruleXStringLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XStringLiteral_5;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 7 :
					// InternalWeightDefinition.g:2748:3: this_XTypeLiteral_6= ruleXTypeLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXLiteralAccess().getXTypeLiteralParserRuleCall_6());
							}
					pushFollow(FOLLOW_2);
					this_XTypeLiteral_6=ruleXTypeLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XTypeLiteral_6;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXLiteral"



	// $ANTLR start "entryRuleXCollectionLiteral"
	// InternalWeightDefinition.g:2760:1: entryRuleXCollectionLiteral returns [EObject current=null] :iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF ;
	public final EObject entryRuleXCollectionLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCollectionLiteral =null;

		try {
			// InternalWeightDefinition.g:2760:59: (iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF )
			// InternalWeightDefinition.g:2761:2: iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCollectionLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCollectionLiteral=ruleXCollectionLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCollectionLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCollectionLiteral"



	// $ANTLR start "ruleXCollectionLiteral"
	// InternalWeightDefinition.g:2767:1: ruleXCollectionLiteral returns [EObject current=null] : (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral ) ;
	public final EObject ruleXCollectionLiteral() throws RecognitionException {
		EObject current = null;


		EObject this_XSetLiteral_0 =null;
		EObject this_XListLiteral_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2773:2: ( (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral ) )
			// InternalWeightDefinition.g:2774:2: (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral )
			{
			// InternalWeightDefinition.g:2774:2: (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==16) ) {
				int LA40_1 = input.LA(2);
				if ( (LA40_1==85) ) {
					alt40=1;
				}
				else if ( (LA40_1==53) ) {
					alt40=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 40, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// InternalWeightDefinition.g:2775:3: this_XSetLiteral_0= ruleXSetLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXSetLiteralParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_XSetLiteral_0=ruleXSetLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XSetLiteral_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:2784:3: this_XListLiteral_1= ruleXListLiteral
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCollectionLiteralAccess().getXListLiteralParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XListLiteral_1=ruleXListLiteral();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XListLiteral_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCollectionLiteral"



	// $ANTLR start "entryRuleXSetLiteral"
	// InternalWeightDefinition.g:2796:1: entryRuleXSetLiteral returns [EObject current=null] :iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
	public final EObject entryRuleXSetLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSetLiteral =null;

		try {
			// InternalWeightDefinition.g:2796:52: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
			// InternalWeightDefinition.g:2797:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXSetLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXSetLiteral=ruleXSetLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXSetLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXSetLiteral"



	// $ANTLR start "ruleXSetLiteral"
	// InternalWeightDefinition.g:2803:1: ruleXSetLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
	public final EObject ruleXSetLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_elements_3_0 =null;
		EObject lv_elements_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2809:2: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
			// InternalWeightDefinition.g:2810:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			{
			// InternalWeightDefinition.g:2810:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			// InternalWeightDefinition.g:2811:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
			{
			// InternalWeightDefinition.g:2811:3: ()
			// InternalWeightDefinition.g:2812:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,16,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1());
					}
			otherlv_2=(Token)match(input,85,FOLLOW_40); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
					}
			// InternalWeightDefinition.g:2826:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( ((LA42_0 >= RULE_DECIMAL && LA42_0 <= RULE_INT)||LA42_0==RULE_STRING||LA42_0==13||LA42_0==16||LA42_0==21||LA42_0==26||LA42_0==30||LA42_0==42||LA42_0==53||LA42_0==59||(LA42_0 >= 61 && LA42_0 <= 63)||LA42_0==65||(LA42_0 >= 67 && LA42_0 <= 68)||(LA42_0 >= 70 && LA42_0 <= 72)||(LA42_0 >= 74 && LA42_0 <= 81)||(LA42_0 >= 84 && LA42_0 <= 85)) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// InternalWeightDefinition.g:2827:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalWeightDefinition.g:2827:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalWeightDefinition.g:2828:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:2828:5: (lv_elements_3_0= ruleXExpression )
					// InternalWeightDefinition.g:2829:6: lv_elements_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_41);
					lv_elements_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
											}
											add(
												current,
												"elements",
												lv_elements_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:2846:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop41:
					while (true) {
						int alt41=2;
						int LA41_0 = input.LA(1);
						if ( (LA41_0==29) ) {
							alt41=1;
						}

						switch (alt41) {
						case 1 :
							// InternalWeightDefinition.g:2847:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalWeightDefinition.g:2851:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalWeightDefinition.g:2852:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:2852:6: (lv_elements_5_0= ruleXExpression )
							// InternalWeightDefinition.g:2853:7: lv_elements_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_41);
							lv_elements_5_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXSetLiteralRule());
														}
														add(
															current,
															"elements",
															lv_elements_5_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop41;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXSetLiteralAccess().getRightCurlyBracketKeyword_4());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXSetLiteral"



	// $ANTLR start "entryRuleXListLiteral"
	// InternalWeightDefinition.g:2880:1: entryRuleXListLiteral returns [EObject current=null] :iv_ruleXListLiteral= ruleXListLiteral EOF ;
	public final EObject entryRuleXListLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXListLiteral =null;

		try {
			// InternalWeightDefinition.g:2880:53: (iv_ruleXListLiteral= ruleXListLiteral EOF )
			// InternalWeightDefinition.g:2881:2: iv_ruleXListLiteral= ruleXListLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXListLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXListLiteral=ruleXListLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXListLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXListLiteral"



	// $ANTLR start "ruleXListLiteral"
	// InternalWeightDefinition.g:2887:1: ruleXListLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
	public final EObject ruleXListLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_elements_3_0 =null;
		EObject lv_elements_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2893:2: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
			// InternalWeightDefinition.g:2894:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			{
			// InternalWeightDefinition.g:2894:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			// InternalWeightDefinition.g:2895:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
			{
			// InternalWeightDefinition.g:2895:3: ()
			// InternalWeightDefinition.g:2896:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,16,FOLLOW_42); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
					}
			otherlv_2=(Token)match(input,53,FOLLOW_43); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
					}
			// InternalWeightDefinition.g:2910:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( ((LA44_0 >= RULE_DECIMAL && LA44_0 <= RULE_INT)||LA44_0==RULE_STRING||LA44_0==13||LA44_0==16||LA44_0==21||LA44_0==26||LA44_0==30||LA44_0==42||LA44_0==53||LA44_0==59||(LA44_0 >= 61 && LA44_0 <= 63)||LA44_0==65||(LA44_0 >= 67 && LA44_0 <= 68)||(LA44_0 >= 70 && LA44_0 <= 72)||(LA44_0 >= 74 && LA44_0 <= 81)||(LA44_0 >= 84 && LA44_0 <= 85)) ) {
				alt44=1;
			}
			switch (alt44) {
				case 1 :
					// InternalWeightDefinition.g:2911:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalWeightDefinition.g:2911:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalWeightDefinition.g:2912:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:2912:5: (lv_elements_3_0= ruleXExpression )
					// InternalWeightDefinition.g:2913:6: lv_elements_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_44);
					lv_elements_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXListLiteralRule());
											}
											add(
												current,
												"elements",
												lv_elements_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:2930:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop43:
					while (true) {
						int alt43=2;
						int LA43_0 = input.LA(1);
						if ( (LA43_0==29) ) {
							alt43=1;
						}

						switch (alt43) {
						case 1 :
							// InternalWeightDefinition.g:2931:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalWeightDefinition.g:2935:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalWeightDefinition.g:2936:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:2936:6: (lv_elements_5_0= ruleXExpression )
							// InternalWeightDefinition.g:2937:7: lv_elements_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_44);
							lv_elements_5_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXListLiteralRule());
														}
														add(
															current,
															"elements",
															lv_elements_5_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop43;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXListLiteralAccess().getRightSquareBracketKeyword_4());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXListLiteral"



	// $ANTLR start "entryRuleXClosure"
	// InternalWeightDefinition.g:2964:1: entryRuleXClosure returns [EObject current=null] :iv_ruleXClosure= ruleXClosure EOF ;
	public final EObject entryRuleXClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXClosure =null;

		try {
			// InternalWeightDefinition.g:2964:49: (iv_ruleXClosure= ruleXClosure EOF )
			// InternalWeightDefinition.g:2965:2: iv_ruleXClosure= ruleXClosure EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXClosureRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXClosure=ruleXClosure();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXClosure; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXClosure"



	// $ANTLR start "ruleXClosure"
	// InternalWeightDefinition.g:2971:1: ruleXClosure returns [EObject current=null] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
	public final EObject ruleXClosure() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token lv_explicitSyntax_5_0=null;
		Token otherlv_7=null;
		EObject lv_declaredFormalParameters_2_0 =null;
		EObject lv_declaredFormalParameters_4_0 =null;
		EObject lv_expression_6_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2977:2: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
			// InternalWeightDefinition.g:2978:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
			{
			// InternalWeightDefinition.g:2978:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
			// InternalWeightDefinition.g:2979:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
			{
			// InternalWeightDefinition.g:2979:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
			// InternalWeightDefinition.g:2980:4: ( ( () '[' ) )=> ( () otherlv_1= '[' )
			{
			// InternalWeightDefinition.g:2986:4: ( () otherlv_1= '[' )
			// InternalWeightDefinition.g:2987:5: () otherlv_1= '['
			{
			// InternalWeightDefinition.g:2987:5: ()
			// InternalWeightDefinition.g:2988:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,53,FOLLOW_45); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
							}
			}

			}

			// InternalWeightDefinition.g:3000:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==RULE_ID) ) {
				int LA47_1 = input.LA(2);
				if ( (synpred23_InternalWeightDefinition()) ) {
					alt47=1;
				}
			}
			else if ( (LA47_0==21) ) {
				int LA47_2 = input.LA(2);
				if ( (synpred23_InternalWeightDefinition()) ) {
					alt47=1;
				}
			}
			else if ( (LA47_0==47) && (synpred23_InternalWeightDefinition())) {
				alt47=1;
			}
			else if ( (LA47_0==86) && (synpred23_InternalWeightDefinition())) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// InternalWeightDefinition.g:3001:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
					{
					// InternalWeightDefinition.g:3024:4: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
					// InternalWeightDefinition.g:3025:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
					{
					// InternalWeightDefinition.g:3025:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
					int alt46=2;
					int LA46_0 = input.LA(1);
					if ( (LA46_0==RULE_ID||LA46_0==21||LA46_0==47) ) {
						alt46=1;
					}
					switch (alt46) {
						case 1 :
							// InternalWeightDefinition.g:3026:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
							{
							// InternalWeightDefinition.g:3026:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
							// InternalWeightDefinition.g:3027:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
							{
							// InternalWeightDefinition.g:3027:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
							// InternalWeightDefinition.g:3028:8: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0());
														}
							pushFollow(FOLLOW_46);
							lv_declaredFormalParameters_2_0=ruleJvmFormalParameter();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXClosureRule());
															}
															add(
																current,
																"declaredFormalParameters",
																lv_declaredFormalParameters_2_0,
																"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
															afterParserOrEnumRuleCall();
														}
							}

							}

							// InternalWeightDefinition.g:3045:6: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
							loop45:
							while (true) {
								int alt45=2;
								int LA45_0 = input.LA(1);
								if ( (LA45_0==29) ) {
									alt45=1;
								}

								switch (alt45) {
								case 1 :
									// InternalWeightDefinition.g:3046:7: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
									{
									otherlv_3=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
															}
									// InternalWeightDefinition.g:3050:7: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
									// InternalWeightDefinition.g:3051:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
									{
									// InternalWeightDefinition.g:3051:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
									// InternalWeightDefinition.g:3052:9: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0());
																	}
									pushFollow(FOLLOW_46);
									lv_declaredFormalParameters_4_0=ruleJvmFormalParameter();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		if (current==null) {
																			current = createModelElementForParent(grammarAccess.getXClosureRule());
																		}
																		add(
																			current,
																			"declaredFormalParameters",
																			lv_declaredFormalParameters_4_0,
																			"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
																		afterParserOrEnumRuleCall();
																	}
									}

									}

									}
									break;

								default :
									break loop45;
								}
							}

							}
							break;

					}

					// InternalWeightDefinition.g:3071:5: ( (lv_explicitSyntax_5_0= '|' ) )
					// InternalWeightDefinition.g:3072:6: (lv_explicitSyntax_5_0= '|' )
					{
					// InternalWeightDefinition.g:3072:6: (lv_explicitSyntax_5_0= '|' )
					// InternalWeightDefinition.g:3073:7: lv_explicitSyntax_5_0= '|'
					{
					lv_explicitSyntax_5_0=(Token)match(input,86,FOLLOW_47); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(lv_explicitSyntax_5_0, grammarAccess.getXClosureAccess().getExplicitSyntaxVerticalLineKeyword_1_0_1_0());
											}
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXClosureRule());
												}
												setWithLastConsumed(current, "explicitSyntax", true, "|");
											}
					}

					}

					}

					}
					break;

			}

			// InternalWeightDefinition.g:3087:3: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
			// InternalWeightDefinition.g:3088:4: (lv_expression_6_0= ruleXExpressionInClosure )
			{
			// InternalWeightDefinition.g:3088:4: (lv_expression_6_0= ruleXExpressionInClosure )
			// InternalWeightDefinition.g:3089:5: lv_expression_6_0= ruleXExpressionInClosure
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_48);
			lv_expression_6_0=ruleXExpressionInClosure();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXClosureRule());
								}
								set(
									current,
									"expression",
									lv_expression_6_0,
									"org.eclipse.xtext.xbase.Xbase.XExpressionInClosure");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_7=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_7, grammarAccess.getXClosureAccess().getRightSquareBracketKeyword_3());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXClosure"



	// $ANTLR start "entryRuleXExpressionInClosure"
	// InternalWeightDefinition.g:3114:1: entryRuleXExpressionInClosure returns [EObject current=null] :iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
	public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionInClosure =null;

		try {
			// InternalWeightDefinition.g:3114:61: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
			// InternalWeightDefinition.g:3115:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXExpressionInClosureRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXExpressionInClosure=ruleXExpressionInClosure();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXExpressionInClosure; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXExpressionInClosure"



	// $ANTLR start "ruleXExpressionInClosure"
	// InternalWeightDefinition.g:3121:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
	public final EObject ruleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject lv_expressions_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3127:2: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
			// InternalWeightDefinition.g:3128:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			{
			// InternalWeightDefinition.g:3128:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			// InternalWeightDefinition.g:3129:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			{
			// InternalWeightDefinition.g:3129:3: ()
			// InternalWeightDefinition.g:3130:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:3136:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			loop49:
			while (true) {
				int alt49=2;
				int LA49_0 = input.LA(1);
				if ( ((LA49_0 >= RULE_DECIMAL && LA49_0 <= RULE_INT)||LA49_0==RULE_STRING||LA49_0==13||LA49_0==16||LA49_0==21||LA49_0==26||LA49_0==30||LA49_0==42||LA49_0==53||LA49_0==59||(LA49_0 >= 61 && LA49_0 <= 63)||LA49_0==65||(LA49_0 >= 67 && LA49_0 <= 68)||(LA49_0 >= 70 && LA49_0 <= 72)||(LA49_0 >= 74 && LA49_0 <= 85)) ) {
					alt49=1;
				}

				switch (alt49) {
				case 1 :
					// InternalWeightDefinition.g:3137:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
					{
					// InternalWeightDefinition.g:3137:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
					// InternalWeightDefinition.g:3138:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalWeightDefinition.g:3138:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					// InternalWeightDefinition.g:3139:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0());
										}
					pushFollow(FOLLOW_49);
					lv_expressions_1_0=ruleXExpressionOrVarDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXExpressionInClosureRule());
											}
											add(
												current,
												"expressions",
												lv_expressions_1_0,
												"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:3156:4: (otherlv_2= ';' )?
					int alt48=2;
					int LA48_0 = input.LA(1);
					if ( (LA48_0==41) ) {
						alt48=1;
					}
					switch (alt48) {
						case 1 :
							// InternalWeightDefinition.g:3157:5: otherlv_2= ';'
							{
							otherlv_2=(Token)match(input,41,FOLLOW_50); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
											}
							}
							break;

					}

					}
					break;

				default :
					break loop49;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXExpressionInClosure"



	// $ANTLR start "entryRuleXShortClosure"
	// InternalWeightDefinition.g:3167:1: entryRuleXShortClosure returns [EObject current=null] :iv_ruleXShortClosure= ruleXShortClosure EOF ;
	public final EObject entryRuleXShortClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXShortClosure =null;

		try {
			// InternalWeightDefinition.g:3167:54: (iv_ruleXShortClosure= ruleXShortClosure EOF )
			// InternalWeightDefinition.g:3168:2: iv_ruleXShortClosure= ruleXShortClosure EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXShortClosureRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXShortClosure=ruleXShortClosure();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXShortClosure; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXShortClosure"



	// $ANTLR start "ruleXShortClosure"
	// InternalWeightDefinition.g:3174:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
	public final EObject ruleXShortClosure() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token lv_explicitSyntax_4_0=null;
		EObject lv_declaredFormalParameters_1_0 =null;
		EObject lv_declaredFormalParameters_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3180:2: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:3181:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:3181:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:3182:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:3182:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
			// InternalWeightDefinition.g:3183:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
			{
			// InternalWeightDefinition.g:3208:4: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
			// InternalWeightDefinition.g:3209:5: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
			{
			// InternalWeightDefinition.g:3209:5: ()
			// InternalWeightDefinition.g:3210:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
										current);
								}
			}

			// InternalWeightDefinition.g:3216:5: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==RULE_ID||LA51_0==21||LA51_0==47) ) {
				alt51=1;
			}
			switch (alt51) {
				case 1 :
					// InternalWeightDefinition.g:3217:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
					{
					// InternalWeightDefinition.g:3217:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
					// InternalWeightDefinition.g:3218:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
					{
					// InternalWeightDefinition.g:3218:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
					// InternalWeightDefinition.g:3219:8: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
					{
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0());
												}
					pushFollow(FOLLOW_46);
					lv_declaredFormalParameters_1_0=ruleJvmFormalParameter();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElementForParent(grammarAccess.getXShortClosureRule());
													}
													add(
														current,
														"declaredFormalParameters",
														lv_declaredFormalParameters_1_0,
														"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
													afterParserOrEnumRuleCall();
												}
					}

					}

					// InternalWeightDefinition.g:3236:6: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
					loop50:
					while (true) {
						int alt50=2;
						int LA50_0 = input.LA(1);
						if ( (LA50_0==29) ) {
							alt50=1;
						}

						switch (alt50) {
						case 1 :
							// InternalWeightDefinition.g:3237:7: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
							{
							otherlv_2=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
													}
							// InternalWeightDefinition.g:3241:7: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
							// InternalWeightDefinition.g:3242:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
							{
							// InternalWeightDefinition.g:3242:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
							// InternalWeightDefinition.g:3243:9: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
							{
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0());
															}
							pushFollow(FOLLOW_46);
							lv_declaredFormalParameters_3_0=ruleJvmFormalParameter();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																if (current==null) {
																	current = createModelElementForParent(grammarAccess.getXShortClosureRule());
																}
																add(
																	current,
																	"declaredFormalParameters",
																	lv_declaredFormalParameters_3_0,
																	"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
																afterParserOrEnumRuleCall();
															}
							}

							}

							}
							break;

						default :
							break loop50;
						}
					}

					}
					break;

			}

			// InternalWeightDefinition.g:3262:5: ( (lv_explicitSyntax_4_0= '|' ) )
			// InternalWeightDefinition.g:3263:6: (lv_explicitSyntax_4_0= '|' )
			{
			// InternalWeightDefinition.g:3263:6: (lv_explicitSyntax_4_0= '|' )
			// InternalWeightDefinition.g:3264:7: lv_explicitSyntax_4_0= '|'
			{
			lv_explicitSyntax_4_0=(Token)match(input,86,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
										newLeafNode(lv_explicitSyntax_4_0, grammarAccess.getXShortClosureAccess().getExplicitSyntaxVerticalLineKeyword_0_0_2_0());
									}
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElement(grammarAccess.getXShortClosureRule());
										}
										setWithLastConsumed(current, "explicitSyntax", true, "|");
									}
			}

			}

			}

			}

			// InternalWeightDefinition.g:3278:3: ( (lv_expression_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3279:4: (lv_expression_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3279:4: (lv_expression_5_0= ruleXExpression )
			// InternalWeightDefinition.g:3280:5: lv_expression_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXShortClosureAccess().getExpressionXExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_expression_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXShortClosureRule());
								}
								set(
									current,
									"expression",
									lv_expression_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXShortClosure"



	// $ANTLR start "entryRuleXParenthesizedExpression"
	// InternalWeightDefinition.g:3301:1: entryRuleXParenthesizedExpression returns [EObject current=null] :iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
	public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXParenthesizedExpression =null;

		try {
			// InternalWeightDefinition.g:3301:65: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
			// InternalWeightDefinition.g:3302:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXParenthesizedExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXParenthesizedExpression=ruleXParenthesizedExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXParenthesizedExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXParenthesizedExpression"



	// $ANTLR start "ruleXParenthesizedExpression"
	// InternalWeightDefinition.g:3308:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
	public final EObject ruleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_2=null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3314:2: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
			// InternalWeightDefinition.g:3315:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			{
			// InternalWeightDefinition.g:3315:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			// InternalWeightDefinition.g:3316:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
			{
			otherlv_0=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
					}
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
					}
			pushFollow(FOLLOW_38);
			this_XExpression_1=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XExpression_1;
						afterParserOrEnumRuleCall();
					}
			otherlv_2=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXParenthesizedExpression"



	// $ANTLR start "entryRuleXIfExpression"
	// InternalWeightDefinition.g:3336:1: entryRuleXIfExpression returns [EObject current=null] :iv_ruleXIfExpression= ruleXIfExpression EOF ;
	public final EObject entryRuleXIfExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXIfExpression =null;

		try {
			// InternalWeightDefinition.g:3336:54: (iv_ruleXIfExpression= ruleXIfExpression EOF )
			// InternalWeightDefinition.g:3337:2: iv_ruleXIfExpression= ruleXIfExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXIfExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXIfExpression=ruleXIfExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXIfExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXIfExpression"



	// $ANTLR start "ruleXIfExpression"
	// InternalWeightDefinition.g:3343:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
	public final EObject ruleXIfExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_if_3_0 =null;
		EObject lv_then_5_0 =null;
		EObject lv_else_7_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3349:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
			// InternalWeightDefinition.g:3350:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
			{
			// InternalWeightDefinition.g:3350:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
			// InternalWeightDefinition.g:3351:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
			{
			// InternalWeightDefinition.g:3351:3: ()
			// InternalWeightDefinition.g:3352:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,67,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:3366:3: ( (lv_if_3_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3367:4: (lv_if_3_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3367:4: (lv_if_3_0= ruleXExpression )
			// InternalWeightDefinition.g:3368:5: lv_if_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_38);
			lv_if_3_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
								}
								set(
									current,
									"if",
									lv_if_3_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:3389:3: ( (lv_then_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3390:4: (lv_then_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3390:4: (lv_then_5_0= ruleXExpression )
			// InternalWeightDefinition.g:3391:5: lv_then_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_51);
			lv_then_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
								}
								set(
									current,
									"then",
									lv_then_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:3408:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==60) ) {
				int LA52_1 = input.LA(2);
				if ( (synpred25_InternalWeightDefinition()) ) {
					alt52=1;
				}
			}
			switch (alt52) {
				case 1 :
					// InternalWeightDefinition.g:3409:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
					{
					// InternalWeightDefinition.g:3409:4: ( ( 'else' )=>otherlv_6= 'else' )
					// InternalWeightDefinition.g:3410:5: ( 'else' )=>otherlv_6= 'else'
					{
					otherlv_6=(Token)match(input,60,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
									}
					}

					// InternalWeightDefinition.g:3416:4: ( (lv_else_7_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3417:5: (lv_else_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3417:5: (lv_else_7_0= ruleXExpression )
					// InternalWeightDefinition.g:3418:6: lv_else_7_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXIfExpressionAccess().getElseXExpressionParserRuleCall_6_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_else_7_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXIfExpressionRule());
											}
											set(
												current,
												"else",
												lv_else_7_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXIfExpression"



	// $ANTLR start "entryRuleXSwitchExpression"
	// InternalWeightDefinition.g:3440:1: entryRuleXSwitchExpression returns [EObject current=null] :iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
	public final EObject entryRuleXSwitchExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSwitchExpression =null;

		try {
			// InternalWeightDefinition.g:3440:58: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
			// InternalWeightDefinition.g:3441:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXSwitchExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXSwitchExpression=ruleXSwitchExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXSwitchExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXSwitchExpression"



	// $ANTLR start "ruleXSwitchExpression"
	// InternalWeightDefinition.g:3447:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
	public final EObject ruleXSwitchExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		Token otherlv_13=null;
		Token otherlv_15=null;
		EObject lv_declaredParam_3_0 =null;
		EObject lv_switch_5_0 =null;
		EObject lv_declaredParam_7_0 =null;
		EObject lv_switch_9_0 =null;
		EObject lv_cases_11_0 =null;
		EObject lv_default_14_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3453:2: ( ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
			// InternalWeightDefinition.g:3454:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
			{
			// InternalWeightDefinition.g:3454:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
			// InternalWeightDefinition.g:3455:3: () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
			{
			// InternalWeightDefinition.g:3455:3: ()
			// InternalWeightDefinition.g:3456:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,76,FOLLOW_52); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
					}
			// InternalWeightDefinition.g:3466:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==21) ) {
				int LA54_1 = input.LA(2);
				if ( (synpred26_InternalWeightDefinition()) ) {
					alt54=1;
				}
				else if ( (true) ) {
					alt54=2;
				}

			}
			else if ( ((LA54_0 >= RULE_DECIMAL && LA54_0 <= RULE_INT)||LA54_0==RULE_STRING||LA54_0==13||LA54_0==16||LA54_0==26||LA54_0==30||LA54_0==42||LA54_0==47||LA54_0==53||LA54_0==59||(LA54_0 >= 61 && LA54_0 <= 63)||LA54_0==65||(LA54_0 >= 67 && LA54_0 <= 68)||(LA54_0 >= 70 && LA54_0 <= 72)||(LA54_0 >= 74 && LA54_0 <= 81)||(LA54_0 >= 84 && LA54_0 <= 85)) ) {
				alt54=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 54, 0, input);
				throw nvae;
			}

			switch (alt54) {
				case 1 :
					// InternalWeightDefinition.g:3467:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
					{
					// InternalWeightDefinition.g:3467:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
					// InternalWeightDefinition.g:3468:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')'
					{
					// InternalWeightDefinition.g:3468:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
					// InternalWeightDefinition.g:3469:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
					{
					// InternalWeightDefinition.g:3479:6: (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
					// InternalWeightDefinition.g:3480:7: otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
					{
					otherlv_2=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0());
											}
					// InternalWeightDefinition.g:3484:7: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
					// InternalWeightDefinition.g:3485:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
					{
					// InternalWeightDefinition.g:3485:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
					// InternalWeightDefinition.g:3486:9: lv_declaredParam_3_0= ruleJvmFormalParameter
					{
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0());
													}
					pushFollow(FOLLOW_53);
					lv_declaredParam_3_0=ruleJvmFormalParameter();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
														}
														set(
															current,
															"declaredParam",
															lv_declaredParam_3_0,
															"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
														afterParserOrEnumRuleCall();
													}
					}

					}

					otherlv_4=(Token)match(input,39,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2());
											}
					}

					}

					// InternalWeightDefinition.g:3509:5: ( (lv_switch_5_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3510:6: (lv_switch_5_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3510:6: (lv_switch_5_0= ruleXExpression )
					// InternalWeightDefinition.g:3511:7: lv_switch_5_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0());
											}
					pushFollow(FOLLOW_38);
					lv_switch_5_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
												}
												set(
													current,
													"switch",
													lv_switch_5_0,
													"org.eclipse.xtext.xbase.Xbase.XExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					otherlv_6=(Token)match(input,22,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2());
									}
					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:3534:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
					{
					// InternalWeightDefinition.g:3534:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
					// InternalWeightDefinition.g:3535:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) )
					{
					// InternalWeightDefinition.g:3535:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?
					int alt53=2;
					int LA53_0 = input.LA(1);
					if ( (LA53_0==RULE_ID) ) {
						int LA53_1 = input.LA(2);
						if ( (synpred27_InternalWeightDefinition()) ) {
							alt53=1;
						}
					}
					else if ( (LA53_0==21) ) {
						int LA53_2 = input.LA(2);
						if ( (synpred27_InternalWeightDefinition()) ) {
							alt53=1;
						}
					}
					else if ( (LA53_0==47) && (synpred27_InternalWeightDefinition())) {
						alt53=1;
					}
					switch (alt53) {
						case 1 :
							// InternalWeightDefinition.g:3536:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
							{
							// InternalWeightDefinition.g:3545:6: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
							// InternalWeightDefinition.g:3546:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':'
							{
							// InternalWeightDefinition.g:3546:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
							// InternalWeightDefinition.g:3547:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
							{
							// InternalWeightDefinition.g:3547:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
							// InternalWeightDefinition.g:3548:9: lv_declaredParam_7_0= ruleJvmFormalParameter
							{
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0());
															}
							pushFollow(FOLLOW_53);
							lv_declaredParam_7_0=ruleJvmFormalParameter();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
																if (current==null) {
																	current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
																}
																set(
																	current,
																	"declaredParam",
																	lv_declaredParam_7_0,
																	"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
																afterParserOrEnumRuleCall();
															}
							}

							}

							otherlv_8=(Token)match(input,39,FOLLOW_13); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1());
													}
							}

							}
							break;

					}

					// InternalWeightDefinition.g:3571:5: ( (lv_switch_9_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3572:6: (lv_switch_9_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3572:6: (lv_switch_9_0= ruleXExpression )
					// InternalWeightDefinition.g:3573:7: lv_switch_9_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0());
											}
					pushFollow(FOLLOW_7);
					lv_switch_9_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
												}
												set(
													current,
													"switch",
													lv_switch_9_0,
													"org.eclipse.xtext.xbase.Xbase.XExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;

			}

			otherlv_10=(Token)match(input,85,FOLLOW_54); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
					}
			// InternalWeightDefinition.g:3596:3: ( (lv_cases_11_0= ruleXCasePart ) )*
			loop55:
			while (true) {
				int alt55=2;
				int LA55_0 = input.LA(1);
				if ( (LA55_0==RULE_ID||LA55_0==21||LA55_0==29||LA55_0==39||LA55_0==47||LA55_0==56) ) {
					alt55=1;
				}

				switch (alt55) {
				case 1 :
					// InternalWeightDefinition.g:3597:4: (lv_cases_11_0= ruleXCasePart )
					{
					// InternalWeightDefinition.g:3597:4: (lv_cases_11_0= ruleXCasePart )
					// InternalWeightDefinition.g:3598:5: lv_cases_11_0= ruleXCasePart
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_54);
					lv_cases_11_0=ruleXCasePart();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
										}
										add(
											current,
											"cases",
											lv_cases_11_0,
											"org.eclipse.xtext.xbase.Xbase.XCasePart");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop55;
				}
			}

			// InternalWeightDefinition.g:3615:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==58) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// InternalWeightDefinition.g:3616:4: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
					{
					otherlv_12=(Token)match(input,58,FOLLOW_53); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
								}
					otherlv_13=(Token)match(input,39,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
								}
					// InternalWeightDefinition.g:3624:4: ( (lv_default_14_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3625:5: (lv_default_14_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3625:5: (lv_default_14_0= ruleXExpression )
					// InternalWeightDefinition.g:3626:6: lv_default_14_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0());
										}
					pushFollow(FOLLOW_55);
					lv_default_14_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXSwitchExpressionRule());
											}
											set(
												current,
												"default",
												lv_default_14_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			otherlv_15=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_15, grammarAccess.getXSwitchExpressionAccess().getRightCurlyBracketKeyword_6());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXSwitchExpression"



	// $ANTLR start "entryRuleXCasePart"
	// InternalWeightDefinition.g:3652:1: entryRuleXCasePart returns [EObject current=null] :iv_ruleXCasePart= ruleXCasePart EOF ;
	public final EObject entryRuleXCasePart() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCasePart =null;

		try {
			// InternalWeightDefinition.g:3652:50: (iv_ruleXCasePart= ruleXCasePart EOF )
			// InternalWeightDefinition.g:3653:2: iv_ruleXCasePart= ruleXCasePart EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCasePartRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCasePart=ruleXCasePart();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCasePart; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCasePart"



	// $ANTLR start "ruleXCasePart"
	// InternalWeightDefinition.g:3659:1: ruleXCasePart returns [EObject current=null] : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) ;
	public final EObject ruleXCasePart() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token otherlv_4=null;
		Token lv_fallThrough_6_0=null;
		EObject lv_typeGuard_1_0 =null;
		EObject lv_case_3_0 =null;
		EObject lv_then_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3665:2: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) )
			// InternalWeightDefinition.g:3666:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
			{
			// InternalWeightDefinition.g:3666:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
			// InternalWeightDefinition.g:3667:3: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
			{
			// InternalWeightDefinition.g:3667:3: ()
			// InternalWeightDefinition.g:3668:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:3674:3: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==RULE_ID||LA57_0==21||LA57_0==47) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// InternalWeightDefinition.g:3675:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:3675:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:3676:5: lv_typeGuard_1_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_56);
					lv_typeGuard_1_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXCasePartRule());
										}
										set(
											current,
											"typeGuard",
											lv_typeGuard_1_0,
											"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			// InternalWeightDefinition.g:3693:3: (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )?
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==56) ) {
				alt58=1;
			}
			switch (alt58) {
				case 1 :
					// InternalWeightDefinition.g:3694:4: otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) )
					{
					otherlv_2=(Token)match(input,56,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getXCasePartAccess().getCaseKeyword_2_0());
								}
					// InternalWeightDefinition.g:3698:4: ( (lv_case_3_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3699:5: (lv_case_3_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3699:5: (lv_case_3_0= ruleXExpression )
					// InternalWeightDefinition.g:3700:6: lv_case_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0());
										}
					pushFollow(FOLLOW_57);
					lv_case_3_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXCasePartRule());
											}
											set(
												current,
												"case",
												lv_case_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			// InternalWeightDefinition.g:3718:3: ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==39) ) {
				alt59=1;
			}
			else if ( (LA59_0==29) ) {
				alt59=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}

			switch (alt59) {
				case 1 :
					// InternalWeightDefinition.g:3719:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
					{
					// InternalWeightDefinition.g:3719:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
					// InternalWeightDefinition.g:3720:5: otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) )
					{
					otherlv_4=(Token)match(input,39,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_4, grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0());
									}
					// InternalWeightDefinition.g:3724:5: ( (lv_then_5_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3725:6: (lv_then_5_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3725:6: (lv_then_5_0= ruleXExpression )
					// InternalWeightDefinition.g:3726:7: lv_then_5_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXCasePartAccess().getThenXExpressionParserRuleCall_3_0_1_0());
											}
					pushFollow(FOLLOW_2);
					lv_then_5_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXCasePartRule());
												}
												set(
													current,
													"then",
													lv_then_5_0,
													"org.eclipse.xtext.xbase.Xbase.XExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:3745:4: ( (lv_fallThrough_6_0= ',' ) )
					{
					// InternalWeightDefinition.g:3745:4: ( (lv_fallThrough_6_0= ',' ) )
					// InternalWeightDefinition.g:3746:5: (lv_fallThrough_6_0= ',' )
					{
					// InternalWeightDefinition.g:3746:5: (lv_fallThrough_6_0= ',' )
					// InternalWeightDefinition.g:3747:6: lv_fallThrough_6_0= ','
					{
					lv_fallThrough_6_0=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_fallThrough_6_0, grammarAccess.getXCasePartAccess().getFallThroughCommaKeyword_3_1_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXCasePartRule());
											}
											setWithLastConsumed(current, "fallThrough", true, ",");
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCasePart"



	// $ANTLR start "entryRuleXForLoopExpression"
	// InternalWeightDefinition.g:3764:1: entryRuleXForLoopExpression returns [EObject current=null] :iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
	public final EObject entryRuleXForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXForLoopExpression =null;

		try {
			// InternalWeightDefinition.g:3764:59: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
			// InternalWeightDefinition.g:3765:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXForLoopExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXForLoopExpression=ruleXForLoopExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXForLoopExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXForLoopExpression"



	// $ANTLR start "ruleXForLoopExpression"
	// InternalWeightDefinition.g:3771:1: ruleXForLoopExpression returns [EObject current=null] : ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
	public final EObject ruleXForLoopExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_declaredParam_3_0 =null;
		EObject lv_forExpression_5_0 =null;
		EObject lv_eachExpression_7_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3777:2: ( ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:3778:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:3778:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:3779:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:3779:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
			// InternalWeightDefinition.g:3780:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
			{
			// InternalWeightDefinition.g:3793:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
			// InternalWeightDefinition.g:3794:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
			{
			// InternalWeightDefinition.g:3794:5: ()
			// InternalWeightDefinition.g:3795:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,65,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			// InternalWeightDefinition.g:3809:5: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
			// InternalWeightDefinition.g:3810:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
			{
			// InternalWeightDefinition.g:3810:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
			// InternalWeightDefinition.g:3811:7: lv_declaredParam_3_0= ruleJvmFormalParameter
			{
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0());
									}
			pushFollow(FOLLOW_53);
			lv_declaredParam_3_0=ruleJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
										}
										set(
											current,
											"declaredParam",
											lv_declaredParam_3_0,
											"org.eclipse.xtext.xbase.Xbase.JvmFormalParameter");
										afterParserOrEnumRuleCall();
									}
			}

			}

			otherlv_4=(Token)match(input,39,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
							}
			}

			}

			// InternalWeightDefinition.g:3834:3: ( (lv_forExpression_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3835:4: (lv_forExpression_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3835:4: (lv_forExpression_5_0= ruleXExpression )
			// InternalWeightDefinition.g:3836:5: lv_forExpression_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_38);
			lv_forExpression_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
								}
								set(
									current,
									"forExpression",
									lv_forExpression_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_6=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:3857:3: ( (lv_eachExpression_7_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3858:4: (lv_eachExpression_7_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3858:4: (lv_eachExpression_7_0= ruleXExpression )
			// InternalWeightDefinition.g:3859:5: lv_eachExpression_7_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_2);
			lv_eachExpression_7_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXForLoopExpressionRule());
								}
								set(
									current,
									"eachExpression",
									lv_eachExpression_7_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXForLoopExpression"



	// $ANTLR start "entryRuleXBasicForLoopExpression"
	// InternalWeightDefinition.g:3880:1: entryRuleXBasicForLoopExpression returns [EObject current=null] :iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
	public final EObject entryRuleXBasicForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBasicForLoopExpression =null;

		try {
			// InternalWeightDefinition.g:3880:64: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
			// InternalWeightDefinition.g:3881:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBasicForLoopExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBasicForLoopExpression=ruleXBasicForLoopExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBasicForLoopExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBasicForLoopExpression"



	// $ANTLR start "ruleXBasicForLoopExpression"
	// InternalWeightDefinition.g:3887:1: ruleXBasicForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
	public final EObject ruleXBasicForLoopExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		Token otherlv_8=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		EObject lv_initExpressions_3_0 =null;
		EObject lv_initExpressions_5_0 =null;
		EObject lv_expression_7_0 =null;
		EObject lv_updateExpressions_9_0 =null;
		EObject lv_updateExpressions_11_0 =null;
		EObject lv_eachExpression_13_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3893:2: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:3894:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:3894:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:3895:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:3895:3: ()
			// InternalWeightDefinition.g:3896:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,65,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_58); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:3910:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( ((LA61_0 >= RULE_DECIMAL && LA61_0 <= RULE_INT)||LA61_0==RULE_STRING||LA61_0==13||LA61_0==16||LA61_0==21||LA61_0==26||LA61_0==30||LA61_0==42||LA61_0==53||LA61_0==59||(LA61_0 >= 61 && LA61_0 <= 63)||LA61_0==65||(LA61_0 >= 67 && LA61_0 <= 68)||(LA61_0 >= 70 && LA61_0 <= 72)||(LA61_0 >= 74 && LA61_0 <= 85)) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// InternalWeightDefinition.g:3911:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					{
					// InternalWeightDefinition.g:3911:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
					// InternalWeightDefinition.g:3912:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalWeightDefinition.g:3912:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					// InternalWeightDefinition.g:3913:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_59);
					lv_initExpressions_3_0=ruleXExpressionOrVarDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
											}
											add(
												current,
												"initExpressions",
												lv_initExpressions_3_0,
												"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:3930:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					loop60:
					while (true) {
						int alt60=2;
						int LA60_0 = input.LA(1);
						if ( (LA60_0==29) ) {
							alt60=1;
						}

						switch (alt60) {
						case 1 :
							// InternalWeightDefinition.g:3931:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							{
							otherlv_4=(Token)match(input,29,FOLLOW_60); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
											}
							// InternalWeightDefinition.g:3935:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							// InternalWeightDefinition.g:3936:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							{
							// InternalWeightDefinition.g:3936:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							// InternalWeightDefinition.g:3937:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_59);
							lv_initExpressions_5_0=ruleXExpressionOrVarDeclaration();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
														}
														add(
															current,
															"initExpressions",
															lv_initExpressions_5_0,
															"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop60;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,41,FOLLOW_61); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
					}
			// InternalWeightDefinition.g:3960:3: ( (lv_expression_7_0= ruleXExpression ) )?
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( ((LA62_0 >= RULE_DECIMAL && LA62_0 <= RULE_INT)||LA62_0==RULE_STRING||LA62_0==13||LA62_0==16||LA62_0==21||LA62_0==26||LA62_0==30||LA62_0==42||LA62_0==53||LA62_0==59||(LA62_0 >= 61 && LA62_0 <= 63)||LA62_0==65||(LA62_0 >= 67 && LA62_0 <= 68)||(LA62_0 >= 70 && LA62_0 <= 72)||(LA62_0 >= 74 && LA62_0 <= 81)||(LA62_0 >= 84 && LA62_0 <= 85)) ) {
				alt62=1;
			}
			switch (alt62) {
				case 1 :
					// InternalWeightDefinition.g:3961:4: (lv_expression_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3961:4: (lv_expression_7_0= ruleXExpression )
					// InternalWeightDefinition.g:3962:5: lv_expression_7_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
									}
					pushFollow(FOLLOW_62);
					lv_expression_7_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
										}
										set(
											current,
											"expression",
											lv_expression_7_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			otherlv_8=(Token)match(input,41,FOLLOW_63); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
					}
			// InternalWeightDefinition.g:3983:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( ((LA64_0 >= RULE_DECIMAL && LA64_0 <= RULE_INT)||LA64_0==RULE_STRING||LA64_0==13||LA64_0==16||LA64_0==21||LA64_0==26||LA64_0==30||LA64_0==42||LA64_0==53||LA64_0==59||(LA64_0 >= 61 && LA64_0 <= 63)||LA64_0==65||(LA64_0 >= 67 && LA64_0 <= 68)||(LA64_0 >= 70 && LA64_0 <= 72)||(LA64_0 >= 74 && LA64_0 <= 81)||(LA64_0 >= 84 && LA64_0 <= 85)) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// InternalWeightDefinition.g:3984:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					{
					// InternalWeightDefinition.g:3984:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3985:5: (lv_updateExpressions_9_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3985:5: (lv_updateExpressions_9_0= ruleXExpression )
					// InternalWeightDefinition.g:3986:6: lv_updateExpressions_9_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0());
										}
					pushFollow(FOLLOW_11);
					lv_updateExpressions_9_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
											}
											add(
												current,
												"updateExpressions",
												lv_updateExpressions_9_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:4003:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					loop63:
					while (true) {
						int alt63=2;
						int LA63_0 = input.LA(1);
						if ( (LA63_0==29) ) {
							alt63=1;
						}

						switch (alt63) {
						case 1 :
							// InternalWeightDefinition.g:4004:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
							{
							otherlv_10=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
											}
							// InternalWeightDefinition.g:4008:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
							// InternalWeightDefinition.g:4009:6: (lv_updateExpressions_11_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:4009:6: (lv_updateExpressions_11_0= ruleXExpression )
							// InternalWeightDefinition.g:4010:7: lv_updateExpressions_11_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0());
													}
							pushFollow(FOLLOW_11);
							lv_updateExpressions_11_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
														}
														add(
															current,
															"updateExpressions",
															lv_updateExpressions_11_0,
															"org.eclipse.xtext.xbase.Xbase.XExpression");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop63;
						}
					}

					}
					break;

			}

			otherlv_12=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
					}
			// InternalWeightDefinition.g:4033:3: ( (lv_eachExpression_13_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4034:4: (lv_eachExpression_13_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4034:4: (lv_eachExpression_13_0= ruleXExpression )
			// InternalWeightDefinition.g:4035:5: lv_eachExpression_13_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionXExpressionParserRuleCall_9_0());
							}
			pushFollow(FOLLOW_2);
			lv_eachExpression_13_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXBasicForLoopExpressionRule());
								}
								set(
									current,
									"eachExpression",
									lv_eachExpression_13_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBasicForLoopExpression"



	// $ANTLR start "entryRuleXWhileExpression"
	// InternalWeightDefinition.g:4056:1: entryRuleXWhileExpression returns [EObject current=null] :iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
	public final EObject entryRuleXWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXWhileExpression =null;

		try {
			// InternalWeightDefinition.g:4056:57: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
			// InternalWeightDefinition.g:4057:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXWhileExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXWhileExpression=ruleXWhileExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXWhileExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXWhileExpression"



	// $ANTLR start "ruleXWhileExpression"
	// InternalWeightDefinition.g:4063:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
	public final EObject ruleXWhileExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_predicate_3_0 =null;
		EObject lv_body_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4069:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:4070:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:4070:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:4071:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:4071:3: ()
			// InternalWeightDefinition.g:4072:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,84,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:4086:3: ( (lv_predicate_3_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4087:4: (lv_predicate_3_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4087:4: (lv_predicate_3_0= ruleXExpression )
			// InternalWeightDefinition.g:4088:5: lv_predicate_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_38);
			lv_predicate_3_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
								}
								set(
									current,
									"predicate",
									lv_predicate_3_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:4109:3: ( (lv_body_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4110:4: (lv_body_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4110:4: (lv_body_5_0= ruleXExpression )
			// InternalWeightDefinition.g:4111:5: lv_body_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXWhileExpressionAccess().getBodyXExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_2);
			lv_body_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXWhileExpressionRule());
								}
								set(
									current,
									"body",
									lv_body_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXWhileExpression"



	// $ANTLR start "entryRuleXDoWhileExpression"
	// InternalWeightDefinition.g:4132:1: entryRuleXDoWhileExpression returns [EObject current=null] :iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
	public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXDoWhileExpression =null;

		try {
			// InternalWeightDefinition.g:4132:59: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
			// InternalWeightDefinition.g:4133:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXDoWhileExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXDoWhileExpression=ruleXDoWhileExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXDoWhileExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXDoWhileExpression"



	// $ANTLR start "ruleXDoWhileExpression"
	// InternalWeightDefinition.g:4139:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
	public final EObject ruleXDoWhileExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_body_2_0 =null;
		EObject lv_predicate_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4145:2: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
			// InternalWeightDefinition.g:4146:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			{
			// InternalWeightDefinition.g:4146:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			// InternalWeightDefinition.g:4147:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
			{
			// InternalWeightDefinition.g:4147:3: ()
			// InternalWeightDefinition.g:4148:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,59,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
					}
			// InternalWeightDefinition.g:4158:3: ( (lv_body_2_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4159:4: (lv_body_2_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4159:4: (lv_body_2_0= ruleXExpression )
			// InternalWeightDefinition.g:4160:5: lv_body_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_64);
			lv_body_2_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
								}
								set(
									current,
									"body",
									lv_body_2_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_3=(Token)match(input,84,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
					}
			otherlv_4=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:4185:3: ( (lv_predicate_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4186:4: (lv_predicate_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4186:4: (lv_predicate_5_0= ruleXExpression )
			// InternalWeightDefinition.g:4187:5: lv_predicate_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_38);
			lv_predicate_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXDoWhileExpressionRule());
								}
								set(
									current,
									"predicate",
									lv_predicate_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_6=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXDoWhileExpressionAccess().getRightParenthesisKeyword_6());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXDoWhileExpression"



	// $ANTLR start "entryRuleXBlockExpression"
	// InternalWeightDefinition.g:4212:1: entryRuleXBlockExpression returns [EObject current=null] :iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
	public final EObject entryRuleXBlockExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBlockExpression =null;

		try {
			// InternalWeightDefinition.g:4212:57: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
			// InternalWeightDefinition.g:4213:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBlockExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBlockExpression=ruleXBlockExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBlockExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBlockExpression"



	// $ANTLR start "ruleXBlockExpression"
	// InternalWeightDefinition.g:4219:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
	public final EObject ruleXBlockExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_4=null;
		EObject lv_expressions_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4225:2: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
			// InternalWeightDefinition.g:4226:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
			{
			// InternalWeightDefinition.g:4226:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
			// InternalWeightDefinition.g:4227:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
			{
			// InternalWeightDefinition.g:4227:3: ()
			// InternalWeightDefinition.g:4228:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,85,FOLLOW_65); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalWeightDefinition.g:4238:3: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
			loop66:
			while (true) {
				int alt66=2;
				int LA66_0 = input.LA(1);
				if ( ((LA66_0 >= RULE_DECIMAL && LA66_0 <= RULE_INT)||LA66_0==RULE_STRING||LA66_0==13||LA66_0==16||LA66_0==21||LA66_0==26||LA66_0==30||LA66_0==42||LA66_0==53||LA66_0==59||(LA66_0 >= 61 && LA66_0 <= 63)||LA66_0==65||(LA66_0 >= 67 && LA66_0 <= 68)||(LA66_0 >= 70 && LA66_0 <= 72)||(LA66_0 >= 74 && LA66_0 <= 85)) ) {
					alt66=1;
				}

				switch (alt66) {
				case 1 :
					// InternalWeightDefinition.g:4239:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
					{
					// InternalWeightDefinition.g:4239:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
					// InternalWeightDefinition.g:4240:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalWeightDefinition.g:4240:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
					// InternalWeightDefinition.g:4241:6: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0());
										}
					pushFollow(FOLLOW_66);
					lv_expressions_2_0=ruleXExpressionOrVarDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXBlockExpressionRule());
											}
											add(
												current,
												"expressions",
												lv_expressions_2_0,
												"org.eclipse.xtext.xbase.Xbase.XExpressionOrVarDeclaration");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:4258:4: (otherlv_3= ';' )?
					int alt65=2;
					int LA65_0 = input.LA(1);
					if ( (LA65_0==41) ) {
						alt65=1;
					}
					switch (alt65) {
						case 1 :
							// InternalWeightDefinition.g:4259:5: otherlv_3= ';'
							{
							otherlv_3=(Token)match(input,41,FOLLOW_65); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
											}
							}
							break;

					}

					}
					break;

				default :
					break loop66;
				}
			}

			otherlv_4=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXBlockExpressionAccess().getRightCurlyBracketKeyword_3());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBlockExpression"



	// $ANTLR start "entryRuleXExpressionOrVarDeclaration"
	// InternalWeightDefinition.g:4273:1: entryRuleXExpressionOrVarDeclaration returns [EObject current=null] :iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
	public final EObject entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionOrVarDeclaration =null;

		try {
			// InternalWeightDefinition.g:4273:68: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
			// InternalWeightDefinition.g:4274:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXExpressionOrVarDeclaration=ruleXExpressionOrVarDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXExpressionOrVarDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXExpressionOrVarDeclaration"



	// $ANTLR start "ruleXExpressionOrVarDeclaration"
	// InternalWeightDefinition.g:4280:1: ruleXExpressionOrVarDeclaration returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression ) ;
	public final EObject ruleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject this_XVariableDeclaration_0 =null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4286:2: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression ) )
			// InternalWeightDefinition.g:4287:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression )
			{
			// InternalWeightDefinition.g:4287:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression )
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( ((LA67_0 >= 82 && LA67_0 <= 83)) ) {
				alt67=1;
			}
			else if ( ((LA67_0 >= RULE_DECIMAL && LA67_0 <= RULE_INT)||LA67_0==RULE_STRING||LA67_0==13||LA67_0==16||LA67_0==21||LA67_0==26||LA67_0==30||LA67_0==42||LA67_0==53||LA67_0==59||(LA67_0 >= 61 && LA67_0 <= 63)||LA67_0==65||(LA67_0 >= 67 && LA67_0 <= 68)||(LA67_0 >= 70 && LA67_0 <= 72)||(LA67_0 >= 74 && LA67_0 <= 81)||(LA67_0 >= 84 && LA67_0 <= 85)) ) {
				alt67=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 67, 0, input);
				throw nvae;
			}

			switch (alt67) {
				case 1 :
					// InternalWeightDefinition.g:4288:3: this_XVariableDeclaration_0= ruleXVariableDeclaration
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXVariableDeclarationParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_XVariableDeclaration_0=ruleXVariableDeclaration();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XVariableDeclaration_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:4297:3: this_XExpression_1= ruleXExpression
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXExpressionOrVarDeclarationAccess().getXExpressionParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XExpression_1=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XExpression_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXExpressionOrVarDeclaration"



	// $ANTLR start "entryRuleXVariableDeclaration"
	// InternalWeightDefinition.g:4309:1: entryRuleXVariableDeclaration returns [EObject current=null] :iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
	public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXVariableDeclaration =null;

		try {
			// InternalWeightDefinition.g:4309:61: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
			// InternalWeightDefinition.g:4310:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXVariableDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXVariableDeclaration=ruleXVariableDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXVariableDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXVariableDeclaration"



	// $ANTLR start "ruleXVariableDeclaration"
	// InternalWeightDefinition.g:4316:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
	public final EObject ruleXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		Token lv_writeable_1_0=null;
		Token otherlv_2=null;
		Token otherlv_6=null;
		EObject lv_type_3_0 =null;
		AntlrDatatypeRuleToken lv_name_4_0 =null;
		AntlrDatatypeRuleToken lv_name_5_0 =null;
		EObject lv_right_7_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4322:2: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
			// InternalWeightDefinition.g:4323:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
			{
			// InternalWeightDefinition.g:4323:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
			// InternalWeightDefinition.g:4324:3: () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
			{
			// InternalWeightDefinition.g:4324:3: ()
			// InternalWeightDefinition.g:4325:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:4331:3: ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' )
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==83) ) {
				alt68=1;
			}
			else if ( (LA68_0==82) ) {
				alt68=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 68, 0, input);
				throw nvae;
			}

			switch (alt68) {
				case 1 :
					// InternalWeightDefinition.g:4332:4: ( (lv_writeable_1_0= 'var' ) )
					{
					// InternalWeightDefinition.g:4332:4: ( (lv_writeable_1_0= 'var' ) )
					// InternalWeightDefinition.g:4333:5: (lv_writeable_1_0= 'var' )
					{
					// InternalWeightDefinition.g:4333:5: (lv_writeable_1_0= 'var' )
					// InternalWeightDefinition.g:4334:6: lv_writeable_1_0= 'var'
					{
					lv_writeable_1_0=(Token)match(input,83,FOLLOW_8); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_writeable_1_0, grammarAccess.getXVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXVariableDeclarationRule());
											}
											setWithLastConsumed(current, "writeable", true, "var");
										}
					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:4347:4: otherlv_2= 'val'
					{
					otherlv_2=(Token)match(input,82,FOLLOW_8); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:4352:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==RULE_ID) ) {
				int LA69_1 = input.LA(2);
				if ( (synpred29_InternalWeightDefinition()) ) {
					alt69=1;
				}
				else if ( (true) ) {
					alt69=2;
				}

			}
			else if ( (LA69_0==21) && (synpred29_InternalWeightDefinition())) {
				alt69=1;
			}
			else if ( (LA69_0==47) && (synpred29_InternalWeightDefinition())) {
				alt69=1;
			}

			switch (alt69) {
				case 1 :
					// InternalWeightDefinition.g:4353:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
					{
					// InternalWeightDefinition.g:4353:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
					// InternalWeightDefinition.g:4354:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
					{
					// InternalWeightDefinition.g:4367:5: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
					// InternalWeightDefinition.g:4368:6: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
					{
					// InternalWeightDefinition.g:4368:6: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalWeightDefinition.g:4369:7: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:4369:7: (lv_type_3_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:4370:8: lv_type_3_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0());
												}
					pushFollow(FOLLOW_6);
					lv_type_3_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
													}
													set(
														current,
														"type",
														lv_type_3_0,
														"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
													afterParserOrEnumRuleCall();
												}
					}

					}

					// InternalWeightDefinition.g:4387:6: ( (lv_name_4_0= ruleValidID ) )
					// InternalWeightDefinition.g:4388:7: (lv_name_4_0= ruleValidID )
					{
					// InternalWeightDefinition.g:4388:7: (lv_name_4_0= ruleValidID )
					// InternalWeightDefinition.g:4389:8: lv_name_4_0= ruleValidID
					{
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0());
												}
					pushFollow(FOLLOW_67);
					lv_name_4_0=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
													}
													set(
														current,
														"name",
														lv_name_4_0,
														"org.eclipse.xtext.xbase.Xtype.ValidID");
													afterParserOrEnumRuleCall();
												}
					}

					}

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:4409:4: ( (lv_name_5_0= ruleValidID ) )
					{
					// InternalWeightDefinition.g:4409:4: ( (lv_name_5_0= ruleValidID ) )
					// InternalWeightDefinition.g:4410:5: (lv_name_5_0= ruleValidID )
					{
					// InternalWeightDefinition.g:4410:5: (lv_name_5_0= ruleValidID )
					// InternalWeightDefinition.g:4411:6: lv_name_5_0= ruleValidID
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0());
										}
					pushFollow(FOLLOW_67);
					lv_name_5_0=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
											}
											set(
												current,
												"name",
												lv_name_5_0,
												"org.eclipse.xtext.xbase.Xtype.ValidID");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			// InternalWeightDefinition.g:4429:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==44) ) {
				alt70=1;
			}
			switch (alt70) {
				case 1 :
					// InternalWeightDefinition.g:4430:4: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
					{
					otherlv_6=(Token)match(input,44,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
								}
					// InternalWeightDefinition.g:4434:4: ( (lv_right_7_0= ruleXExpression ) )
					// InternalWeightDefinition.g:4435:5: (lv_right_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:4435:5: (lv_right_7_0= ruleXExpression )
					// InternalWeightDefinition.g:4436:6: lv_right_7_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getRightXExpressionParserRuleCall_3_1_0());
										}
					pushFollow(FOLLOW_2);
					lv_right_7_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXVariableDeclarationRule());
											}
											set(
												current,
												"right",
												lv_right_7_0,
												"org.eclipse.xtext.xbase.Xbase.XExpression");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXVariableDeclaration"



	// $ANTLR start "entryRuleJvmFormalParameter"
	// InternalWeightDefinition.g:4458:1: entryRuleJvmFormalParameter returns [EObject current=null] :iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
	public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmFormalParameter =null;

		try {
			// InternalWeightDefinition.g:4458:59: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
			// InternalWeightDefinition.g:4459:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmFormalParameterRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmFormalParameter=ruleJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmFormalParameter; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmFormalParameter"



	// $ANTLR start "ruleJvmFormalParameter"
	// InternalWeightDefinition.g:4465:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4471:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalWeightDefinition.g:4472:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalWeightDefinition.g:4472:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			// InternalWeightDefinition.g:4473:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalWeightDefinition.g:4473:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==RULE_ID) ) {
				int LA71_1 = input.LA(2);
				if ( (LA71_1==RULE_ID||LA71_1==34||LA71_1==42||LA71_1==53) ) {
					alt71=1;
				}
			}
			else if ( (LA71_0==21||LA71_0==47) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// InternalWeightDefinition.g:4474:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:4474:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:4475:5: lv_parameterType_0_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
									}
					pushFollow(FOLLOW_6);
					lv_parameterType_0_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
										}
										set(
											current,
											"parameterType",
											lv_parameterType_0_0,
											"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			// InternalWeightDefinition.g:4492:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalWeightDefinition.g:4493:4: (lv_name_1_0= ruleValidID )
			{
			// InternalWeightDefinition.g:4493:4: (lv_name_1_0= ruleValidID )
			// InternalWeightDefinition.g:4494:5: lv_name_1_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_1_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmFormalParameterRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmFormalParameter"



	// $ANTLR start "entryRuleFullJvmFormalParameter"
	// InternalWeightDefinition.g:4515:1: entryRuleFullJvmFormalParameter returns [EObject current=null] :iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
	public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleFullJvmFormalParameter =null;

		try {
			// InternalWeightDefinition.g:4515:63: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
			// InternalWeightDefinition.g:4516:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getFullJvmFormalParameterRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleFullJvmFormalParameter=ruleFullJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleFullJvmFormalParameter; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleFullJvmFormalParameter"



	// $ANTLR start "ruleFullJvmFormalParameter"
	// InternalWeightDefinition.g:4522:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4528:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalWeightDefinition.g:4529:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalWeightDefinition.g:4529:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			// InternalWeightDefinition.g:4530:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalWeightDefinition.g:4530:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:4531:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:4531:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:4532:5: lv_parameterType_0_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
							}
			pushFollow(FOLLOW_6);
			lv_parameterType_0_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
								}
								set(
									current,
									"parameterType",
									lv_parameterType_0_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:4549:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalWeightDefinition.g:4550:4: (lv_name_1_0= ruleValidID )
			{
			// InternalWeightDefinition.g:4550:4: (lv_name_1_0= ruleValidID )
			// InternalWeightDefinition.g:4551:5: lv_name_1_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getNameValidIDParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_name_1_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getFullJvmFormalParameterRule());
								}
								set(
									current,
									"name",
									lv_name_1_0,
									"org.eclipse.xtext.xbase.Xtype.ValidID");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleFullJvmFormalParameter"



	// $ANTLR start "entryRuleXFeatureCall"
	// InternalWeightDefinition.g:4572:1: entryRuleXFeatureCall returns [EObject current=null] :iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
	public final EObject entryRuleXFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXFeatureCall =null;

		try {
			// InternalWeightDefinition.g:4572:53: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
			// InternalWeightDefinition.g:4573:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXFeatureCallRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXFeatureCall=ruleXFeatureCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXFeatureCall; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXFeatureCall"



	// $ANTLR start "ruleXFeatureCall"
	// InternalWeightDefinition.g:4579:1: ruleXFeatureCall returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
	public final EObject ruleXFeatureCall() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token lv_explicitOperationCall_7_0=null;
		Token otherlv_10=null;
		Token otherlv_12=null;
		EObject lv_typeArguments_2_0 =null;
		EObject lv_typeArguments_4_0 =null;
		EObject lv_featureCallArguments_8_0 =null;
		EObject lv_featureCallArguments_9_0 =null;
		EObject lv_featureCallArguments_11_0 =null;
		EObject lv_featureCallArguments_13_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4585:2: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
			// InternalWeightDefinition.g:4586:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
			{
			// InternalWeightDefinition.g:4586:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
			// InternalWeightDefinition.g:4587:3: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
			{
			// InternalWeightDefinition.g:4587:3: ()
			// InternalWeightDefinition.g:4588:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:4594:3: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
			int alt73=2;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==42) ) {
				alt73=1;
			}
			switch (alt73) {
				case 1 :
					// InternalWeightDefinition.g:4595:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
					{
					otherlv_1=(Token)match(input,42,FOLLOW_33); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
								}
					// InternalWeightDefinition.g:4599:4: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
					// InternalWeightDefinition.g:4600:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
					{
					// InternalWeightDefinition.g:4600:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
					// InternalWeightDefinition.g:4601:6: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_34);
					lv_typeArguments_2_0=ruleJvmArgumentTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
											}
											add(
												current,
												"typeArguments",
												lv_typeArguments_2_0,
												"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:4618:4: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
					loop72:
					while (true) {
						int alt72=2;
						int LA72_0 = input.LA(1);
						if ( (LA72_0==29) ) {
							alt72=1;
						}

						switch (alt72) {
						case 1 :
							// InternalWeightDefinition.g:4619:5: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_3=(Token)match(input,29,FOLLOW_33); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
											}
							// InternalWeightDefinition.g:4623:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:4624:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:4624:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:4625:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
													}
							pushFollow(FOLLOW_34);
							lv_typeArguments_4_0=ruleJvmArgumentTypeReference();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
														}
														add(
															current,
															"typeArguments",
															lv_typeArguments_4_0,
															"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop72;
						}
					}

					otherlv_5=(Token)match(input,48,FOLLOW_35); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:4648:3: ( ( ruleIdOrSuper ) )
			// InternalWeightDefinition.g:4649:4: ( ruleIdOrSuper )
			{
			// InternalWeightDefinition.g:4649:4: ( ruleIdOrSuper )
			// InternalWeightDefinition.g:4650:5: ruleIdOrSuper
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXFeatureCallRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0());
							}
			pushFollow(FOLLOW_68);
			ruleIdOrSuper();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:4664:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
			int alt76=2;
			alt76 = dfa76.predict(input);
			switch (alt76) {
				case 1 :
					// InternalWeightDefinition.g:4665:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
					{
					// InternalWeightDefinition.g:4665:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
					// InternalWeightDefinition.g:4666:5: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
					{
					// InternalWeightDefinition.g:4670:5: (lv_explicitOperationCall_7_0= '(' )
					// InternalWeightDefinition.g:4671:6: lv_explicitOperationCall_7_0= '('
					{
					lv_explicitOperationCall_7_0=(Token)match(input,21,FOLLOW_37); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitOperationCall_7_0, grammarAccess.getXFeatureCallAccess().getExplicitOperationCallLeftParenthesisKeyword_3_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXFeatureCallRule());
											}
											setWithLastConsumed(current, "explicitOperationCall", true, "(");
										}
					}

					}

					// InternalWeightDefinition.g:4683:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
					int alt75=3;
					int LA75_0 = input.LA(1);
					if ( (LA75_0==RULE_ID) ) {
						int LA75_1 = input.LA(2);
						if ( (synpred31_InternalWeightDefinition()) ) {
							alt75=1;
						}
						else if ( (true) ) {
							alt75=2;
						}
					}
					else if ( (LA75_0==21) ) {
						int LA75_2 = input.LA(2);
						if ( (synpred31_InternalWeightDefinition()) ) {
							alt75=1;
						}
						else if ( (true) ) {
							alt75=2;
						}
					}
					else if ( (LA75_0==47) && (synpred31_InternalWeightDefinition())) {
						alt75=1;
					}
					else if ( (LA75_0==86) && (synpred31_InternalWeightDefinition())) {
						alt75=1;
					}
					else if ( ((LA75_0 >= RULE_DECIMAL && LA75_0 <= RULE_HEX)||LA75_0==RULE_INT||LA75_0==RULE_STRING||LA75_0==13||LA75_0==16||LA75_0==26||LA75_0==30||LA75_0==42||LA75_0==53||LA75_0==59||(LA75_0 >= 61 && LA75_0 <= 63)||LA75_0==65||(LA75_0 >= 67 && LA75_0 <= 68)||(LA75_0 >= 70 && LA75_0 <= 72)||(LA75_0 >= 74 && LA75_0 <= 81)||(LA75_0 >= 84 && LA75_0 <= 85)) ) {
						alt75=2;
					}
					switch (alt75) {
						case 1 :
							// InternalWeightDefinition.g:4684:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
							{
							// InternalWeightDefinition.g:4684:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
							// InternalWeightDefinition.g:4685:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
							{
							// InternalWeightDefinition.g:4710:6: (lv_featureCallArguments_8_0= ruleXShortClosure )
							// InternalWeightDefinition.g:4711:7: lv_featureCallArguments_8_0= ruleXShortClosure
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0());
													}
							pushFollow(FOLLOW_38);
							lv_featureCallArguments_8_0=ruleXShortClosure();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
														}
														add(
															current,
															"featureCallArguments",
															lv_featureCallArguments_8_0,
															"org.eclipse.xtext.xbase.Xbase.XShortClosure");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;
						case 2 :
							// InternalWeightDefinition.g:4729:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
							{
							// InternalWeightDefinition.g:4729:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
							// InternalWeightDefinition.g:4730:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
							{
							// InternalWeightDefinition.g:4730:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
							// InternalWeightDefinition.g:4731:7: (lv_featureCallArguments_9_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:4731:7: (lv_featureCallArguments_9_0= ruleXExpression )
							// InternalWeightDefinition.g:4732:8: lv_featureCallArguments_9_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0());
														}
							pushFollow(FOLLOW_11);
							lv_featureCallArguments_9_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
															}
															add(
																current,
																"featureCallArguments",
																lv_featureCallArguments_9_0,
																"org.eclipse.xtext.xbase.Xbase.XExpression");
															afterParserOrEnumRuleCall();
														}
							}

							}

							// InternalWeightDefinition.g:4749:6: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
							loop74:
							while (true) {
								int alt74=2;
								int LA74_0 = input.LA(1);
								if ( (LA74_0==29) ) {
									alt74=1;
								}

								switch (alt74) {
								case 1 :
									// InternalWeightDefinition.g:4750:7: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
									{
									otherlv_10=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
															}
									// InternalWeightDefinition.g:4754:7: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
									// InternalWeightDefinition.g:4755:8: (lv_featureCallArguments_11_0= ruleXExpression )
									{
									// InternalWeightDefinition.g:4755:8: (lv_featureCallArguments_11_0= ruleXExpression )
									// InternalWeightDefinition.g:4756:9: lv_featureCallArguments_11_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0());
																	}
									pushFollow(FOLLOW_11);
									lv_featureCallArguments_11_0=ruleXExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		if (current==null) {
																			current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
																		}
																		add(
																			current,
																			"featureCallArguments",
																			lv_featureCallArguments_11_0,
																			"org.eclipse.xtext.xbase.Xbase.XExpression");
																		afterParserOrEnumRuleCall();
																	}
									}

									}

									}
									break;

								default :
									break loop74;
								}
							}

							}

							}
							break;

					}

					otherlv_12=(Token)match(input,22,FOLLOW_69); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_12, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:4781:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
			int alt77=2;
			alt77 = dfa77.predict(input);
			switch (alt77) {
				case 1 :
					// InternalWeightDefinition.g:4782:4: ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
					{
					// InternalWeightDefinition.g:4788:4: (lv_featureCallArguments_13_0= ruleXClosure )
					// InternalWeightDefinition.g:4789:5: lv_featureCallArguments_13_0= ruleXClosure
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXClosureParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_2);
					lv_featureCallArguments_13_0=ruleXClosure();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXFeatureCallRule());
										}
										add(
											current,
											"featureCallArguments",
											lv_featureCallArguments_13_0,
											"org.eclipse.xtext.xbase.Xbase.XClosure");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXFeatureCall"



	// $ANTLR start "entryRuleFeatureCallID"
	// InternalWeightDefinition.g:4810:1: entryRuleFeatureCallID returns [String current=null] :iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
	public final String entryRuleFeatureCallID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleFeatureCallID =null;

		try {
			// InternalWeightDefinition.g:4810:53: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
			// InternalWeightDefinition.g:4811:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getFeatureCallIDRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleFeatureCallID=ruleFeatureCallID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleFeatureCallID.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleFeatureCallID"



	// $ANTLR start "ruleFeatureCallID"
	// InternalWeightDefinition.g:4817:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) ;
	public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4823:2: ( (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) )
			// InternalWeightDefinition.g:4824:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			{
			// InternalWeightDefinition.g:4824:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			int alt78=5;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				alt78=1;
				}
				break;
			case 61:
				{
				alt78=2;
				}
				break;
			case 74:
				{
				alt78=3;
				}
				break;
			case 68:
				{
				alt78=4;
				}
				break;
			case 62:
				{
				alt78=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 78, 0, input);
				throw nvae;
			}
			switch (alt78) {
				case 1 :
					// InternalWeightDefinition.g:4825:3: this_ValidID_0= ruleValidID
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getFeatureCallIDAccess().getValidIDParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_ValidID_0=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ValidID_0);
							}
					if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:4836:3: kw= 'extends'
					{
					kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtendsKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:4842:3: kw= 'static'
					{
					kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getStaticKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:4848:3: kw= 'import'
					{
					kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getImportKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalWeightDefinition.g:4854:3: kw= 'extension'
					{
					kw=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtensionKeyword_4());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleFeatureCallID"



	// $ANTLR start "entryRuleIdOrSuper"
	// InternalWeightDefinition.g:4863:1: entryRuleIdOrSuper returns [String current=null] :iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
	public final String entryRuleIdOrSuper() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleIdOrSuper =null;

		try {
			// InternalWeightDefinition.g:4863:49: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
			// InternalWeightDefinition.g:4864:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getIdOrSuperRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleIdOrSuper=ruleIdOrSuper();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleIdOrSuper.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleIdOrSuper"



	// $ANTLR start "ruleIdOrSuper"
	// InternalWeightDefinition.g:4870:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) ;
	public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_FeatureCallID_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4876:2: ( (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) )
			// InternalWeightDefinition.g:4877:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			{
			// InternalWeightDefinition.g:4877:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			int alt79=2;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==RULE_ID||(LA79_0 >= 61 && LA79_0 <= 62)||LA79_0==68||LA79_0==74) ) {
				alt79=1;
			}
			else if ( (LA79_0==75) ) {
				alt79=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 79, 0, input);
				throw nvae;
			}

			switch (alt79) {
				case 1 :
					// InternalWeightDefinition.g:4878:3: this_FeatureCallID_0= ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getIdOrSuperAccess().getFeatureCallIDParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_FeatureCallID_0=ruleFeatureCallID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_FeatureCallID_0);
							}
					if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:4889:3: kw= 'super'
					{
					kw=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getIdOrSuperAccess().getSuperKeyword_1());
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleIdOrSuper"



	// $ANTLR start "entryRuleXConstructorCall"
	// InternalWeightDefinition.g:4898:1: entryRuleXConstructorCall returns [EObject current=null] :iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
	public final EObject entryRuleXConstructorCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXConstructorCall =null;

		try {
			// InternalWeightDefinition.g:4898:57: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
			// InternalWeightDefinition.g:4899:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXConstructorCallRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXConstructorCall=ruleXConstructorCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXConstructorCall; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXConstructorCall"



	// $ANTLR start "ruleXConstructorCall"
	// InternalWeightDefinition.g:4905:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
	public final EObject ruleXConstructorCall() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token lv_explicitConstructorCall_8_0=null;
		Token otherlv_11=null;
		Token otherlv_13=null;
		EObject lv_typeArguments_4_0 =null;
		EObject lv_typeArguments_6_0 =null;
		EObject lv_arguments_9_0 =null;
		EObject lv_arguments_10_0 =null;
		EObject lv_arguments_12_0 =null;
		EObject lv_arguments_14_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4911:2: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
			// InternalWeightDefinition.g:4912:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
			{
			// InternalWeightDefinition.g:4912:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
			// InternalWeightDefinition.g:4913:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
			{
			// InternalWeightDefinition.g:4913:3: ()
			// InternalWeightDefinition.g:4914:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,70,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
					}
			// InternalWeightDefinition.g:4924:3: ( ( ruleQualifiedName ) )
			// InternalWeightDefinition.g:4925:4: ( ruleQualifiedName )
			{
			// InternalWeightDefinition.g:4925:4: ( ruleQualifiedName )
			// InternalWeightDefinition.g:4926:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXConstructorCallRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0());
							}
			pushFollow(FOLLOW_70);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:4940:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
			int alt81=2;
			alt81 = dfa81.predict(input);
			switch (alt81) {
				case 1 :
					// InternalWeightDefinition.g:4941:4: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
					{
					// InternalWeightDefinition.g:4941:4: ( ( '<' )=>otherlv_3= '<' )
					// InternalWeightDefinition.g:4942:5: ( '<' )=>otherlv_3= '<'
					{
					otherlv_3=(Token)match(input,42,FOLLOW_33); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
									}
					}

					// InternalWeightDefinition.g:4948:4: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
					// InternalWeightDefinition.g:4949:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
					{
					// InternalWeightDefinition.g:4949:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
					// InternalWeightDefinition.g:4950:6: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0());
										}
					pushFollow(FOLLOW_34);
					lv_typeArguments_4_0=ruleJvmArgumentTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
											}
											add(
												current,
												"typeArguments",
												lv_typeArguments_4_0,
												"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:4967:4: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
					loop80:
					while (true) {
						int alt80=2;
						int LA80_0 = input.LA(1);
						if ( (LA80_0==29) ) {
							alt80=1;
						}

						switch (alt80) {
						case 1 :
							// InternalWeightDefinition.g:4968:5: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_5=(Token)match(input,29,FOLLOW_33); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
											}
							// InternalWeightDefinition.g:4972:5: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:4973:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:4973:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:4974:7: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0());
													}
							pushFollow(FOLLOW_34);
							lv_typeArguments_6_0=ruleJvmArgumentTypeReference();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
														}
														add(
															current,
															"typeArguments",
															lv_typeArguments_6_0,
															"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop80;
						}
					}

					otherlv_7=(Token)match(input,48,FOLLOW_68); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:4997:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
			int alt84=2;
			alt84 = dfa84.predict(input);
			switch (alt84) {
				case 1 :
					// InternalWeightDefinition.g:4998:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
					{
					// InternalWeightDefinition.g:4998:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
					// InternalWeightDefinition.g:4999:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
					{
					// InternalWeightDefinition.g:5003:5: (lv_explicitConstructorCall_8_0= '(' )
					// InternalWeightDefinition.g:5004:6: lv_explicitConstructorCall_8_0= '('
					{
					lv_explicitConstructorCall_8_0=(Token)match(input,21,FOLLOW_37); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_explicitConstructorCall_8_0, grammarAccess.getXConstructorCallAccess().getExplicitConstructorCallLeftParenthesisKeyword_4_0_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXConstructorCallRule());
											}
											setWithLastConsumed(current, "explicitConstructorCall", true, "(");
										}
					}

					}

					// InternalWeightDefinition.g:5016:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
					int alt83=3;
					int LA83_0 = input.LA(1);
					if ( (LA83_0==RULE_ID) ) {
						int LA83_1 = input.LA(2);
						if ( (synpred35_InternalWeightDefinition()) ) {
							alt83=1;
						}
						else if ( (true) ) {
							alt83=2;
						}
					}
					else if ( (LA83_0==21) ) {
						int LA83_2 = input.LA(2);
						if ( (synpred35_InternalWeightDefinition()) ) {
							alt83=1;
						}
						else if ( (true) ) {
							alt83=2;
						}
					}
					else if ( (LA83_0==47) && (synpred35_InternalWeightDefinition())) {
						alt83=1;
					}
					else if ( (LA83_0==86) && (synpred35_InternalWeightDefinition())) {
						alt83=1;
					}
					else if ( ((LA83_0 >= RULE_DECIMAL && LA83_0 <= RULE_HEX)||LA83_0==RULE_INT||LA83_0==RULE_STRING||LA83_0==13||LA83_0==16||LA83_0==26||LA83_0==30||LA83_0==42||LA83_0==53||LA83_0==59||(LA83_0 >= 61 && LA83_0 <= 63)||LA83_0==65||(LA83_0 >= 67 && LA83_0 <= 68)||(LA83_0 >= 70 && LA83_0 <= 72)||(LA83_0 >= 74 && LA83_0 <= 81)||(LA83_0 >= 84 && LA83_0 <= 85)) ) {
						alt83=2;
					}
					switch (alt83) {
						case 1 :
							// InternalWeightDefinition.g:5017:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
							{
							// InternalWeightDefinition.g:5017:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
							// InternalWeightDefinition.g:5018:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
							{
							// InternalWeightDefinition.g:5043:6: (lv_arguments_9_0= ruleXShortClosure )
							// InternalWeightDefinition.g:5044:7: lv_arguments_9_0= ruleXShortClosure
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0());
													}
							pushFollow(FOLLOW_38);
							lv_arguments_9_0=ruleXShortClosure();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
														}
														add(
															current,
															"arguments",
															lv_arguments_9_0,
															"org.eclipse.xtext.xbase.Xbase.XShortClosure");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;
						case 2 :
							// InternalWeightDefinition.g:5062:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
							{
							// InternalWeightDefinition.g:5062:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
							// InternalWeightDefinition.g:5063:6: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
							{
							// InternalWeightDefinition.g:5063:6: ( (lv_arguments_10_0= ruleXExpression ) )
							// InternalWeightDefinition.g:5064:7: (lv_arguments_10_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:5064:7: (lv_arguments_10_0= ruleXExpression )
							// InternalWeightDefinition.g:5065:8: lv_arguments_10_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0());
														}
							pushFollow(FOLLOW_11);
							lv_arguments_10_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
															}
															add(
																current,
																"arguments",
																lv_arguments_10_0,
																"org.eclipse.xtext.xbase.Xbase.XExpression");
															afterParserOrEnumRuleCall();
														}
							}

							}

							// InternalWeightDefinition.g:5082:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
							loop82:
							while (true) {
								int alt82=2;
								int LA82_0 = input.LA(1);
								if ( (LA82_0==29) ) {
									alt82=1;
								}

								switch (alt82) {
								case 1 :
									// InternalWeightDefinition.g:5083:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
									{
									otherlv_11=(Token)match(input,29,FOLLOW_13); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
															}
									// InternalWeightDefinition.g:5087:7: ( (lv_arguments_12_0= ruleXExpression ) )
									// InternalWeightDefinition.g:5088:8: (lv_arguments_12_0= ruleXExpression )
									{
									// InternalWeightDefinition.g:5088:8: (lv_arguments_12_0= ruleXExpression )
									// InternalWeightDefinition.g:5089:9: lv_arguments_12_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0());
																	}
									pushFollow(FOLLOW_11);
									lv_arguments_12_0=ruleXExpression();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																		if (current==null) {
																			current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
																		}
																		add(
																			current,
																			"arguments",
																			lv_arguments_12_0,
																			"org.eclipse.xtext.xbase.Xbase.XExpression");
																		afterParserOrEnumRuleCall();
																	}
									}

									}

									}
									break;

								default :
									break loop82;
								}
							}

							}

							}
							break;

					}

					otherlv_13=(Token)match(input,22,FOLLOW_69); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:5114:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
			int alt85=2;
			alt85 = dfa85.predict(input);
			switch (alt85) {
				case 1 :
					// InternalWeightDefinition.g:5115:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
					{
					// InternalWeightDefinition.g:5121:4: (lv_arguments_14_0= ruleXClosure )
					// InternalWeightDefinition.g:5122:5: lv_arguments_14_0= ruleXClosure
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXClosureParserRuleCall_5_0());
									}
					pushFollow(FOLLOW_2);
					lv_arguments_14_0=ruleXClosure();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXConstructorCallRule());
										}
										add(
											current,
											"arguments",
											lv_arguments_14_0,
											"org.eclipse.xtext.xbase.Xbase.XClosure");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXConstructorCall"



	// $ANTLR start "entryRuleXBooleanLiteral"
	// InternalWeightDefinition.g:5143:1: entryRuleXBooleanLiteral returns [EObject current=null] :iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
	public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBooleanLiteral =null;

		try {
			// InternalWeightDefinition.g:5143:56: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
			// InternalWeightDefinition.g:5144:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXBooleanLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXBooleanLiteral=ruleXBooleanLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXBooleanLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXBooleanLiteral"



	// $ANTLR start "ruleXBooleanLiteral"
	// InternalWeightDefinition.g:5150:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
	public final EObject ruleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_isTrue_2_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5156:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
			// InternalWeightDefinition.g:5157:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			{
			// InternalWeightDefinition.g:5157:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			// InternalWeightDefinition.g:5158:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			{
			// InternalWeightDefinition.g:5158:3: ()
			// InternalWeightDefinition.g:5159:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:5165:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			int alt86=2;
			int LA86_0 = input.LA(1);
			if ( (LA86_0==63) ) {
				alt86=1;
			}
			else if ( (LA86_0==79) ) {
				alt86=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 86, 0, input);
				throw nvae;
			}

			switch (alt86) {
				case 1 :
					// InternalWeightDefinition.g:5166:4: otherlv_1= 'false'
					{
					otherlv_1=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
								}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:5171:4: ( (lv_isTrue_2_0= 'true' ) )
					{
					// InternalWeightDefinition.g:5171:4: ( (lv_isTrue_2_0= 'true' ) )
					// InternalWeightDefinition.g:5172:5: (lv_isTrue_2_0= 'true' )
					{
					// InternalWeightDefinition.g:5172:5: (lv_isTrue_2_0= 'true' )
					// InternalWeightDefinition.g:5173:6: lv_isTrue_2_0= 'true'
					{
					lv_isTrue_2_0=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(lv_isTrue_2_0, grammarAccess.getXBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
										}
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXBooleanLiteralRule());
											}
											setWithLastConsumed(current, "isTrue", true, "true");
										}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXBooleanLiteral"



	// $ANTLR start "entryRuleXNullLiteral"
	// InternalWeightDefinition.g:5190:1: entryRuleXNullLiteral returns [EObject current=null] :iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
	public final EObject entryRuleXNullLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNullLiteral =null;

		try {
			// InternalWeightDefinition.g:5190:53: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
			// InternalWeightDefinition.g:5191:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXNullLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXNullLiteral=ruleXNullLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXNullLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXNullLiteral"



	// $ANTLR start "ruleXNullLiteral"
	// InternalWeightDefinition.g:5197:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
	public final EObject ruleXNullLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5203:2: ( ( () otherlv_1= 'null' ) )
			// InternalWeightDefinition.g:5204:2: ( () otherlv_1= 'null' )
			{
			// InternalWeightDefinition.g:5204:2: ( () otherlv_1= 'null' )
			// InternalWeightDefinition.g:5205:3: () otherlv_1= 'null'
			{
			// InternalWeightDefinition.g:5205:3: ()
			// InternalWeightDefinition.g:5206:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXNullLiteralAccess().getXNullLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXNullLiteralAccess().getNullKeyword_1());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXNullLiteral"



	// $ANTLR start "entryRuleXNumberLiteral"
	// InternalWeightDefinition.g:5220:1: entryRuleXNumberLiteral returns [EObject current=null] :iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
	public final EObject entryRuleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNumberLiteral =null;

		try {
			// InternalWeightDefinition.g:5220:55: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
			// InternalWeightDefinition.g:5221:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXNumberLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXNumberLiteral=ruleXNumberLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXNumberLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXNumberLiteral"



	// $ANTLR start "ruleXNumberLiteral"
	// InternalWeightDefinition.g:5227:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
	public final EObject ruleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_value_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5233:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
			// InternalWeightDefinition.g:5234:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			{
			// InternalWeightDefinition.g:5234:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			// InternalWeightDefinition.g:5235:3: () ( (lv_value_1_0= ruleNumber ) )
			{
			// InternalWeightDefinition.g:5235:3: ()
			// InternalWeightDefinition.g:5236:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:5242:3: ( (lv_value_1_0= ruleNumber ) )
			// InternalWeightDefinition.g:5243:4: (lv_value_1_0= ruleNumber )
			{
			// InternalWeightDefinition.g:5243:4: (lv_value_1_0= ruleNumber )
			// InternalWeightDefinition.g:5244:5: lv_value_1_0= ruleNumber
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXNumberLiteralAccess().getValueNumberParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_value_1_0=ruleNumber();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXNumberLiteralRule());
								}
								set(
									current,
									"value",
									lv_value_1_0,
									"org.eclipse.xtext.xbase.Xbase.Number");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXNumberLiteral"



	// $ANTLR start "entryRuleXStringLiteral"
	// InternalWeightDefinition.g:5265:1: entryRuleXStringLiteral returns [EObject current=null] :iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
	public final EObject entryRuleXStringLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXStringLiteral =null;

		try {
			// InternalWeightDefinition.g:5265:55: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
			// InternalWeightDefinition.g:5266:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXStringLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXStringLiteral=ruleXStringLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXStringLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXStringLiteral"



	// $ANTLR start "ruleXStringLiteral"
	// InternalWeightDefinition.g:5272:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
	public final EObject ruleXStringLiteral() throws RecognitionException {
		EObject current = null;


		Token lv_value_1_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5278:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
			// InternalWeightDefinition.g:5279:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			{
			// InternalWeightDefinition.g:5279:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			// InternalWeightDefinition.g:5280:3: () ( (lv_value_1_0= RULE_STRING ) )
			{
			// InternalWeightDefinition.g:5280:3: ()
			// InternalWeightDefinition.g:5281:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:5287:3: ( (lv_value_1_0= RULE_STRING ) )
			// InternalWeightDefinition.g:5288:4: (lv_value_1_0= RULE_STRING )
			{
			// InternalWeightDefinition.g:5288:4: (lv_value_1_0= RULE_STRING )
			// InternalWeightDefinition.g:5289:5: lv_value_1_0= RULE_STRING
			{
			lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(lv_value_1_0, grammarAccess.getXStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
							}
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXStringLiteralRule());
								}
								setWithLastConsumed(
									current,
									"value",
									lv_value_1_0,
									"org.eclipse.xtext.xbase.Xtype.STRING");
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXStringLiteral"



	// $ANTLR start "entryRuleXTypeLiteral"
	// InternalWeightDefinition.g:5309:1: entryRuleXTypeLiteral returns [EObject current=null] :iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
	public final EObject entryRuleXTypeLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXTypeLiteral =null;

		try {
			// InternalWeightDefinition.g:5309:53: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
			// InternalWeightDefinition.g:5310:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXTypeLiteralRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXTypeLiteral=ruleXTypeLiteral();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXTypeLiteral; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXTypeLiteral"



	// $ANTLR start "ruleXTypeLiteral"
	// InternalWeightDefinition.g:5316:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
	public final EObject ruleXTypeLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_5=null;
		AntlrDatatypeRuleToken lv_arrayDimensions_4_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5322:2: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
			// InternalWeightDefinition.g:5323:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
			{
			// InternalWeightDefinition.g:5323:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
			// InternalWeightDefinition.g:5324:3: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
			{
			// InternalWeightDefinition.g:5324:3: ()
			// InternalWeightDefinition.g:5325:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,81,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:5339:3: ( ( ruleQualifiedName ) )
			// InternalWeightDefinition.g:5340:4: ( ruleQualifiedName )
			{
			// InternalWeightDefinition.g:5340:4: ( ruleQualifiedName )
			// InternalWeightDefinition.g:5341:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXTypeLiteralRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0());
							}
			pushFollow(FOLLOW_71);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:5355:3: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
			loop87:
			while (true) {
				int alt87=2;
				int LA87_0 = input.LA(1);
				if ( (LA87_0==53) ) {
					alt87=1;
				}

				switch (alt87) {
				case 1 :
					// InternalWeightDefinition.g:5356:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
					{
					// InternalWeightDefinition.g:5356:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
					// InternalWeightDefinition.g:5357:5: lv_arrayDimensions_4_0= ruleArrayBrackets
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_71);
					lv_arrayDimensions_4_0=ruleArrayBrackets();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXTypeLiteralRule());
										}
										add(
											current,
											"arrayDimensions",
											lv_arrayDimensions_4_0,
											"org.eclipse.xtext.xbase.Xtype.ArrayBrackets");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

				default :
					break loop87;
				}
			}

			otherlv_5=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXTypeLiteralAccess().getRightParenthesisKeyword_5());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXTypeLiteral"



	// $ANTLR start "entryRuleXThrowExpression"
	// InternalWeightDefinition.g:5382:1: entryRuleXThrowExpression returns [EObject current=null] :iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
	public final EObject entryRuleXThrowExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXThrowExpression =null;

		try {
			// InternalWeightDefinition.g:5382:57: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
			// InternalWeightDefinition.g:5383:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXThrowExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXThrowExpression=ruleXThrowExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXThrowExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXThrowExpression"



	// $ANTLR start "ruleXThrowExpression"
	// InternalWeightDefinition.g:5389:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
	public final EObject ruleXThrowExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5395:2: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:5396:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:5396:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:5397:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:5397:3: ()
			// InternalWeightDefinition.g:5398:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,78,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
					}
			// InternalWeightDefinition.g:5408:3: ( (lv_expression_2_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5409:4: (lv_expression_2_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5409:4: (lv_expression_2_0= ruleXExpression )
			// InternalWeightDefinition.g:5410:5: lv_expression_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXThrowExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_2);
			lv_expression_2_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXThrowExpressionRule());
								}
								set(
									current,
									"expression",
									lv_expression_2_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXThrowExpression"



	// $ANTLR start "entryRuleXReturnExpression"
	// InternalWeightDefinition.g:5431:1: entryRuleXReturnExpression returns [EObject current=null] :iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
	public final EObject entryRuleXReturnExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXReturnExpression =null;

		try {
			// InternalWeightDefinition.g:5431:58: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
			// InternalWeightDefinition.g:5432:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXReturnExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXReturnExpression=ruleXReturnExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXReturnExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXReturnExpression"



	// $ANTLR start "ruleXReturnExpression"
	// InternalWeightDefinition.g:5438:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
	public final EObject ruleXReturnExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5444:2: ( ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
			// InternalWeightDefinition.g:5445:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			{
			// InternalWeightDefinition.g:5445:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			// InternalWeightDefinition.g:5446:3: () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			{
			// InternalWeightDefinition.g:5446:3: ()
			// InternalWeightDefinition.g:5447:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,72,FOLLOW_72); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
					}
			// InternalWeightDefinition.g:5457:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			int alt88=2;
			alt88 = dfa88.predict(input);
			switch (alt88) {
				case 1 :
					// InternalWeightDefinition.g:5458:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:5459:4: (lv_expression_2_0= ruleXExpression )
					// InternalWeightDefinition.g:5460:5: lv_expression_2_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXReturnExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
									}
					pushFollow(FOLLOW_2);
					lv_expression_2_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
										if (current==null) {
											current = createModelElementForParent(grammarAccess.getXReturnExpressionRule());
										}
										set(
											current,
											"expression",
											lv_expression_2_0,
											"org.eclipse.xtext.xbase.Xbase.XExpression");
										afterParserOrEnumRuleCall();
									}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXReturnExpression"



	// $ANTLR start "entryRuleXTryCatchFinallyExpression"
	// InternalWeightDefinition.g:5481:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] :iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
	public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXTryCatchFinallyExpression =null;

		try {
			// InternalWeightDefinition.g:5481:67: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
			// InternalWeightDefinition.g:5482:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXTryCatchFinallyExpression=ruleXTryCatchFinallyExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXTryCatchFinallyExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXTryCatchFinallyExpression"



	// $ANTLR start "ruleXTryCatchFinallyExpression"
	// InternalWeightDefinition.g:5488:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
	public final EObject ruleXTryCatchFinallyExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_4=null;
		Token otherlv_6=null;
		EObject lv_expression_2_0 =null;
		EObject lv_catchClauses_3_0 =null;
		EObject lv_finallyExpression_5_0 =null;
		EObject lv_finallyExpression_7_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5494:2: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
			// InternalWeightDefinition.g:5495:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
			{
			// InternalWeightDefinition.g:5495:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
			// InternalWeightDefinition.g:5496:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
			{
			// InternalWeightDefinition.g:5496:3: ()
			// InternalWeightDefinition.g:5497:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,80,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
					}
			// InternalWeightDefinition.g:5507:3: ( (lv_expression_2_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5508:4: (lv_expression_2_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5508:4: (lv_expression_2_0= ruleXExpression )
			// InternalWeightDefinition.g:5509:5: lv_expression_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_73);
			lv_expression_2_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
								}
								set(
									current,
									"expression",
									lv_expression_2_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:5526:3: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==57) ) {
				alt91=1;
			}
			else if ( (LA91_0==64) ) {
				alt91=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 91, 0, input);
				throw nvae;
			}

			switch (alt91) {
				case 1 :
					// InternalWeightDefinition.g:5527:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
					{
					// InternalWeightDefinition.g:5527:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
					// InternalWeightDefinition.g:5528:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
					{
					// InternalWeightDefinition.g:5528:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
					int cnt89=0;
					loop89:
					while (true) {
						int alt89=2;
						int LA89_0 = input.LA(1);
						if ( (LA89_0==57) ) {
							int LA89_2 = input.LA(2);
							if ( (synpred38_InternalWeightDefinition()) ) {
								alt89=1;
							}

						}

						switch (alt89) {
						case 1 :
							// InternalWeightDefinition.g:5529:6: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
							{
							// InternalWeightDefinition.g:5530:6: (lv_catchClauses_3_0= ruleXCatchClause )
							// InternalWeightDefinition.g:5531:7: lv_catchClauses_3_0= ruleXCatchClause
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0());
													}
							pushFollow(FOLLOW_74);
							lv_catchClauses_3_0=ruleXCatchClause();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
														}
														add(
															current,
															"catchClauses",
															lv_catchClauses_3_0,
															"org.eclipse.xtext.xbase.Xbase.XCatchClause");
														afterParserOrEnumRuleCall();
													}
							}

							}
							break;

						default :
							if ( cnt89 >= 1 ) break loop89;
							if (state.backtracking>0) {state.failed=true; return current;}
							EarlyExitException eee = new EarlyExitException(89, input);
							throw eee;
						}
						cnt89++;
					}

					// InternalWeightDefinition.g:5548:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
					int alt90=2;
					int LA90_0 = input.LA(1);
					if ( (LA90_0==64) ) {
						int LA90_1 = input.LA(2);
						if ( (synpred39_InternalWeightDefinition()) ) {
							alt90=1;
						}
					}
					switch (alt90) {
						case 1 :
							// InternalWeightDefinition.g:5549:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
							{
							// InternalWeightDefinition.g:5549:6: ( ( 'finally' )=>otherlv_4= 'finally' )
							// InternalWeightDefinition.g:5550:7: ( 'finally' )=>otherlv_4= 'finally'
							{
							otherlv_4=(Token)match(input,64,FOLLOW_13); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
													}
							}

							// InternalWeightDefinition.g:5556:6: ( (lv_finallyExpression_5_0= ruleXExpression ) )
							// InternalWeightDefinition.g:5557:7: (lv_finallyExpression_5_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:5557:7: (lv_finallyExpression_5_0= ruleXExpression )
							// InternalWeightDefinition.g:5558:8: lv_finallyExpression_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0());
														}
							pushFollow(FOLLOW_2);
							lv_finallyExpression_5_0=ruleXExpression();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
															}
															set(
																current,
																"finallyExpression",
																lv_finallyExpression_5_0,
																"org.eclipse.xtext.xbase.Xbase.XExpression");
															afterParserOrEnumRuleCall();
														}
							}

							}

							}
							break;

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:5578:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
					{
					// InternalWeightDefinition.g:5578:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
					// InternalWeightDefinition.g:5579:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
					{
					otherlv_6=(Token)match(input,64,FOLLOW_13); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
									}
					// InternalWeightDefinition.g:5583:5: ( (lv_finallyExpression_7_0= ruleXExpression ) )
					// InternalWeightDefinition.g:5584:6: (lv_finallyExpression_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:5584:6: (lv_finallyExpression_7_0= ruleXExpression )
					// InternalWeightDefinition.g:5585:7: lv_finallyExpression_7_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyExpressionXExpressionParserRuleCall_3_1_1_0());
											}
					pushFollow(FOLLOW_2);
					lv_finallyExpression_7_0=ruleXExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getXTryCatchFinallyExpressionRule());
												}
												set(
													current,
													"finallyExpression",
													lv_finallyExpression_7_0,
													"org.eclipse.xtext.xbase.Xbase.XExpression");
												afterParserOrEnumRuleCall();
											}
					}

					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXTryCatchFinallyExpression"



	// $ANTLR start "entryRuleXSynchronizedExpression"
	// InternalWeightDefinition.g:5608:1: entryRuleXSynchronizedExpression returns [EObject current=null] :iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
	public final EObject entryRuleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSynchronizedExpression =null;

		try {
			// InternalWeightDefinition.g:5608:64: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
			// InternalWeightDefinition.g:5609:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXSynchronizedExpressionRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXSynchronizedExpression=ruleXSynchronizedExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXSynchronizedExpression; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXSynchronizedExpression"



	// $ANTLR start "ruleXSynchronizedExpression"
	// InternalWeightDefinition.g:5615:1: ruleXSynchronizedExpression returns [EObject current=null] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
	public final EObject ruleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_param_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5621:2: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:5622:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:5622:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:5623:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:5623:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
			// InternalWeightDefinition.g:5624:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			{
			// InternalWeightDefinition.g:5631:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			// InternalWeightDefinition.g:5632:5: () otherlv_1= 'synchronized' otherlv_2= '('
			{
			// InternalWeightDefinition.g:5632:5: ()
			// InternalWeightDefinition.g:5633:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,77,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,21,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			}

			}

			// InternalWeightDefinition.g:5649:3: ( (lv_param_3_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5650:4: (lv_param_3_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5650:4: (lv_param_3_0= ruleXExpression )
			// InternalWeightDefinition.g:5651:5: lv_param_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_38);
			lv_param_3_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
								}
								set(
									current,
									"param",
									lv_param_3_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_4=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:5672:3: ( (lv_expression_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5673:4: (lv_expression_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5673:4: (lv_expression_5_0= ruleXExpression )
			// InternalWeightDefinition.g:5674:5: lv_expression_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getExpressionXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_2);
			lv_expression_5_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXSynchronizedExpressionRule());
								}
								set(
									current,
									"expression",
									lv_expression_5_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXSynchronizedExpression"



	// $ANTLR start "entryRuleXCatchClause"
	// InternalWeightDefinition.g:5695:1: entryRuleXCatchClause returns [EObject current=null] :iv_ruleXCatchClause= ruleXCatchClause EOF ;
	public final EObject entryRuleXCatchClause() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCatchClause =null;

		try {
			// InternalWeightDefinition.g:5695:53: (iv_ruleXCatchClause= ruleXCatchClause EOF )
			// InternalWeightDefinition.g:5696:2: iv_ruleXCatchClause= ruleXCatchClause EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXCatchClauseRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXCatchClause=ruleXCatchClause();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXCatchClause; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXCatchClause"



	// $ANTLR start "ruleXCatchClause"
	// InternalWeightDefinition.g:5702:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
	public final EObject ruleXCatchClause() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_declaredParam_2_0 =null;
		EObject lv_expression_4_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5708:2: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:5709:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:5709:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:5710:3: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:5710:3: ( ( 'catch' )=>otherlv_0= 'catch' )
			// InternalWeightDefinition.g:5711:4: ( 'catch' )=>otherlv_0= 'catch'
			{
			otherlv_0=(Token)match(input,57,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
						}
			}

			otherlv_1=(Token)match(input,21,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
					}
			// InternalWeightDefinition.g:5721:3: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
			// InternalWeightDefinition.g:5722:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
			{
			// InternalWeightDefinition.g:5722:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
			// InternalWeightDefinition.g:5723:5: lv_declaredParam_2_0= ruleFullJvmFormalParameter
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_38);
			lv_declaredParam_2_0=ruleFullJvmFormalParameter();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
								}
								set(
									current,
									"declaredParam",
									lv_declaredParam_2_0,
									"org.eclipse.xtext.xbase.Xbase.FullJvmFormalParameter");
								afterParserOrEnumRuleCall();
							}
			}

			}

			otherlv_3=(Token)match(input,22,FOLLOW_13); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
					}
			// InternalWeightDefinition.g:5744:3: ( (lv_expression_4_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5745:4: (lv_expression_4_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5745:4: (lv_expression_4_0= ruleXExpression )
			// InternalWeightDefinition.g:5746:5: lv_expression_4_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCatchClauseAccess().getExpressionXExpressionParserRuleCall_4_0());
							}
			pushFollow(FOLLOW_2);
			lv_expression_4_0=ruleXExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXCatchClauseRule());
								}
								set(
									current,
									"expression",
									lv_expression_4_0,
									"org.eclipse.xtext.xbase.Xbase.XExpression");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXCatchClause"



	// $ANTLR start "entryRuleQualifiedName"
	// InternalWeightDefinition.g:5767:1: entryRuleQualifiedName returns [String current=null] :iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final String entryRuleQualifiedName() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedName =null;

		try {
			// InternalWeightDefinition.g:5767:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalWeightDefinition.g:5768:2: iv_ruleQualifiedName= ruleQualifiedName EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getQualifiedNameRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleQualifiedName=ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleQualifiedName.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleQualifiedName"



	// $ANTLR start "ruleQualifiedName"
	// InternalWeightDefinition.g:5774:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;
		AntlrDatatypeRuleToken this_ValidID_2 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5780:2: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
			// InternalWeightDefinition.g:5781:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			{
			// InternalWeightDefinition.g:5781:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			// InternalWeightDefinition.g:5782:3: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
					}
			pushFollow(FOLLOW_75);
			this_ValidID_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(this_ValidID_0);
					}
			if ( state.backtracking==0 ) {
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:5792:3: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
			loop92:
			while (true) {
				int alt92=2;
				int LA92_0 = input.LA(1);
				if ( (LA92_0==34) ) {
					int LA92_2 = input.LA(2);
					if ( (LA92_2==RULE_ID) ) {
						int LA92_3 = input.LA(3);
						if ( (synpred42_InternalWeightDefinition()) ) {
							alt92=1;
						}

					}

				}

				switch (alt92) {
				case 1 :
					// InternalWeightDefinition.g:5793:4: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
					{
					// InternalWeightDefinition.g:5793:4: ( ( '.' )=>kw= '.' )
					// InternalWeightDefinition.g:5794:5: ( '.' )=>kw= '.'
					{
					kw=(Token)match(input,34,FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										current.merge(kw);
										newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
									}
					}

					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
								}
					pushFollow(FOLLOW_75);
					this_ValidID_2=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(this_ValidID_2);
								}
					if ( state.backtracking==0 ) {
									afterParserOrEnumRuleCall();
								}
					}
					break;

				default :
					break loop92;
				}
			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleQualifiedName"



	// $ANTLR start "entryRuleNumber"
	// InternalWeightDefinition.g:5816:1: entryRuleNumber returns [String current=null] :iv_ruleNumber= ruleNumber EOF ;
	public final String entryRuleNumber() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleNumber =null;


			HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

		try {
			// InternalWeightDefinition.g:5818:2: (iv_ruleNumber= ruleNumber EOF )
			// InternalWeightDefinition.g:5819:2: iv_ruleNumber= ruleNumber EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getNumberRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleNumber=ruleNumber();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleNumber.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving

				myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "entryRuleNumber"



	// $ANTLR start "ruleNumber"
	// InternalWeightDefinition.g:5828:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
	public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_HEX_0=null;
		Token this_INT_1=null;
		Token this_DECIMAL_2=null;
		Token kw=null;
		Token this_INT_4=null;
		Token this_DECIMAL_5=null;


			enterRule();
			HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

		try {
			// InternalWeightDefinition.g:5835:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
			// InternalWeightDefinition.g:5836:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			{
			// InternalWeightDefinition.g:5836:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			int alt96=2;
			int LA96_0 = input.LA(1);
			if ( (LA96_0==RULE_HEX) ) {
				alt96=1;
			}
			else if ( (LA96_0==RULE_DECIMAL||LA96_0==RULE_INT) ) {
				alt96=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 96, 0, input);
				throw nvae;
			}

			switch (alt96) {
				case 1 :
					// InternalWeightDefinition.g:5837:3: this_HEX_0= RULE_HEX
					{
					this_HEX_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_HEX_0);
							}
					if ( state.backtracking==0 ) {
								newLeafNode(this_HEX_0, grammarAccess.getNumberAccess().getHEXTerminalRuleCall_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:5845:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					{
					// InternalWeightDefinition.g:5845:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					// InternalWeightDefinition.g:5846:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					{
					// InternalWeightDefinition.g:5846:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL )
					int alt93=2;
					int LA93_0 = input.LA(1);
					if ( (LA93_0==RULE_INT) ) {
						alt93=1;
					}
					else if ( (LA93_0==RULE_DECIMAL) ) {
						alt93=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 93, 0, input);
						throw nvae;
					}

					switch (alt93) {
						case 1 :
							// InternalWeightDefinition.g:5847:5: this_INT_1= RULE_INT
							{
							this_INT_1=(Token)match(input,RULE_INT,FOLLOW_75); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(this_INT_1);
											}
							if ( state.backtracking==0 ) {
												newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0());
											}
							}
							break;
						case 2 :
							// InternalWeightDefinition.g:5855:5: this_DECIMAL_2= RULE_DECIMAL
							{
							this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_75); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(this_DECIMAL_2);
											}
							if ( state.backtracking==0 ) {
												newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1());
											}
							}
							break;

					}

					// InternalWeightDefinition.g:5863:4: (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					int alt95=2;
					int LA95_0 = input.LA(1);
					if ( (LA95_0==34) ) {
						int LA95_1 = input.LA(2);
						if ( (LA95_1==RULE_DECIMAL||LA95_1==RULE_INT) ) {
							alt95=1;
						}
					}
					switch (alt95) {
						case 1 :
							// InternalWeightDefinition.g:5864:5: kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
							{
							kw=(Token)match(input,34,FOLLOW_76); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0());
											}
							// InternalWeightDefinition.g:5869:5: (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
							int alt94=2;
							int LA94_0 = input.LA(1);
							if ( (LA94_0==RULE_INT) ) {
								alt94=1;
							}
							else if ( (LA94_0==RULE_DECIMAL) ) {
								alt94=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 94, 0, input);
								throw nvae;
							}

							switch (alt94) {
								case 1 :
									// InternalWeightDefinition.g:5870:6: this_INT_4= RULE_INT
									{
									this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															current.merge(this_INT_4);
														}
									if ( state.backtracking==0 ) {
															newLeafNode(this_INT_4, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1_1_0());
														}
									}
									break;
								case 2 :
									// InternalWeightDefinition.g:5878:6: this_DECIMAL_5= RULE_DECIMAL
									{
									this_DECIMAL_5=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															current.merge(this_DECIMAL_5);
														}
									if ( state.backtracking==0 ) {
															newLeafNode(this_DECIMAL_5, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_1_1_1());
														}
									}
									break;

							}

							}
							break;

					}

					}

					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving

				myHiddenTokenState.restore();

		}
		return current;
	}
	// $ANTLR end "ruleNumber"



	// $ANTLR start "entryRuleJvmTypeReference"
	// InternalWeightDefinition.g:5895:1: entryRuleJvmTypeReference returns [EObject current=null] :iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
	public final EObject entryRuleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmTypeReference =null;

		try {
			// InternalWeightDefinition.g:5895:57: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
			// InternalWeightDefinition.g:5896:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmTypeReference=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmTypeReference"



	// $ANTLR start "ruleJvmTypeReference"
	// InternalWeightDefinition.g:5902:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
	public final EObject ruleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmParameterizedTypeReference_0 =null;
		EObject this_XFunctionTypeRef_3 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5908:2: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
			// InternalWeightDefinition.g:5909:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
			{
			// InternalWeightDefinition.g:5909:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==RULE_ID) ) {
				alt98=1;
			}
			else if ( (LA98_0==21||LA98_0==47) ) {
				alt98=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 98, 0, input);
				throw nvae;
			}

			switch (alt98) {
				case 1 :
					// InternalWeightDefinition.g:5910:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
					{
					// InternalWeightDefinition.g:5910:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
					// InternalWeightDefinition.g:5911:4: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0());
								}
					pushFollow(FOLLOW_69);
					this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_JvmParameterizedTypeReference_0;
									afterParserOrEnumRuleCall();
								}
					// InternalWeightDefinition.g:5919:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
					loop97:
					while (true) {
						int alt97=2;
						int LA97_0 = input.LA(1);
						if ( (LA97_0==53) ) {
							int LA97_2 = input.LA(2);
							if ( (LA97_2==54) ) {
								int LA97_3 = input.LA(3);
								if ( (synpred43_InternalWeightDefinition()) ) {
									alt97=1;
								}

							}

						}

						switch (alt97) {
						case 1 :
							// InternalWeightDefinition.g:5920:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
							{
							// InternalWeightDefinition.g:5926:5: ( () ruleArrayBrackets )
							// InternalWeightDefinition.g:5927:6: () ruleArrayBrackets
							{
							// InternalWeightDefinition.g:5927:6: ()
							// InternalWeightDefinition.g:5928:7: 
							{
							if ( state.backtracking==0 ) {
														current = forceCreateModelElementAndSet(
															grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
															current);
													}
							}

							if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1());
												}
							pushFollow(FOLLOW_69);
							ruleArrayBrackets();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
													afterParserOrEnumRuleCall();
												}
							}

							}
							break;

						default :
							break loop97;
						}
					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:5945:3: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_XFunctionTypeRef_3=ruleXFunctionTypeRef();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_XFunctionTypeRef_3;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmTypeReference"



	// $ANTLR start "entryRuleArrayBrackets"
	// InternalWeightDefinition.g:5957:1: entryRuleArrayBrackets returns [String current=null] :iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
	public final String entryRuleArrayBrackets() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleArrayBrackets =null;

		try {
			// InternalWeightDefinition.g:5957:53: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
			// InternalWeightDefinition.g:5958:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getArrayBracketsRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleArrayBrackets=ruleArrayBrackets();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleArrayBrackets.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleArrayBrackets"



	// $ANTLR start "ruleArrayBrackets"
	// InternalWeightDefinition.g:5964:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
	public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5970:2: ( (kw= '[' kw= ']' ) )
			// InternalWeightDefinition.g:5971:2: (kw= '[' kw= ']' )
			{
			// InternalWeightDefinition.g:5971:2: (kw= '[' kw= ']' )
			// InternalWeightDefinition.g:5972:3: kw= '[' kw= ']'
			{
			kw=(Token)match(input,53,FOLLOW_48); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0());
					}
			kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleArrayBrackets"



	// $ANTLR start "entryRuleXFunctionTypeRef"
	// InternalWeightDefinition.g:5986:1: entryRuleXFunctionTypeRef returns [EObject current=null] :iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
	public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXFunctionTypeRef =null;

		try {
			// InternalWeightDefinition.g:5986:57: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
			// InternalWeightDefinition.g:5987:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXFunctionTypeRef; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXFunctionTypeRef"



	// $ANTLR start "ruleXFunctionTypeRef"
	// InternalWeightDefinition.g:5993:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleXFunctionTypeRef() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		Token otherlv_5=null;
		EObject lv_paramTypes_1_0 =null;
		EObject lv_paramTypes_3_0 =null;
		EObject lv_returnType_6_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5999:2: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6000:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6000:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6001:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
			{
			// InternalWeightDefinition.g:6001:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
			int alt101=2;
			int LA101_0 = input.LA(1);
			if ( (LA101_0==21) ) {
				alt101=1;
			}
			switch (alt101) {
				case 1 :
					// InternalWeightDefinition.g:6002:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
					{
					otherlv_0=(Token)match(input,21,FOLLOW_10); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
								}
					// InternalWeightDefinition.g:6006:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
					int alt100=2;
					int LA100_0 = input.LA(1);
					if ( (LA100_0==RULE_ID||LA100_0==21||LA100_0==47) ) {
						alt100=1;
					}
					switch (alt100) {
						case 1 :
							// InternalWeightDefinition.g:6007:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
							{
							// InternalWeightDefinition.g:6007:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
							// InternalWeightDefinition.g:6008:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
							{
							// InternalWeightDefinition.g:6008:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
							// InternalWeightDefinition.g:6009:7: lv_paramTypes_1_0= ruleJvmTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
													}
							pushFollow(FOLLOW_11);
							lv_paramTypes_1_0=ruleJvmTypeReference();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
														}
														add(
															current,
															"paramTypes",
															lv_paramTypes_1_0,
															"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalWeightDefinition.g:6026:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
							loop99:
							while (true) {
								int alt99=2;
								int LA99_0 = input.LA(1);
								if ( (LA99_0==29) ) {
									alt99=1;
								}

								switch (alt99) {
								case 1 :
									// InternalWeightDefinition.g:6027:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
									{
									otherlv_2=(Token)match(input,29,FOLLOW_8); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
														}
									// InternalWeightDefinition.g:6031:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
									// InternalWeightDefinition.g:6032:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
									{
									// InternalWeightDefinition.g:6032:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
									// InternalWeightDefinition.g:6033:8: lv_paramTypes_3_0= ruleJvmTypeReference
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
																}
									pushFollow(FOLLOW_11);
									lv_paramTypes_3_0=ruleJvmTypeReference();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
																	}
																	add(
																		current,
																		"paramTypes",
																		lv_paramTypes_3_0,
																		"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									}
									break;

								default :
									break loop99;
								}
							}

							}
							break;

					}

					otherlv_4=(Token)match(input,22,FOLLOW_77); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
								}
					}
					break;

			}

			otherlv_5=(Token)match(input,47,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
					}
			// InternalWeightDefinition.g:6061:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6062:4: (lv_returnType_6_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6062:4: (lv_returnType_6_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6063:5: lv_returnType_6_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_2);
			lv_returnType_6_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
								}
								set(
									current,
									"returnType",
									lv_returnType_6_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXFunctionTypeRef"



	// $ANTLR start "entryRuleJvmParameterizedTypeReference"
	// InternalWeightDefinition.g:6084:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] :iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
	public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmParameterizedTypeReference =null;

		try {
			// InternalWeightDefinition.g:6084:70: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
			// InternalWeightDefinition.g:6085:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmParameterizedTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmParameterizedTypeReference"



	// $ANTLR start "ruleJvmParameterizedTypeReference"
	// InternalWeightDefinition.g:6091:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
	public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_5=null;
		Token otherlv_7=null;
		Token otherlv_9=null;
		Token otherlv_11=null;
		Token otherlv_13=null;
		EObject lv_arguments_2_0 =null;
		EObject lv_arguments_4_0 =null;
		EObject lv_arguments_10_0 =null;
		EObject lv_arguments_12_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6097:2: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
			// InternalWeightDefinition.g:6098:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			{
			// InternalWeightDefinition.g:6098:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			// InternalWeightDefinition.g:6099:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			{
			// InternalWeightDefinition.g:6099:3: ( ( ruleQualifiedName ) )
			// InternalWeightDefinition.g:6100:4: ( ruleQualifiedName )
			{
			// InternalWeightDefinition.g:6100:4: ( ruleQualifiedName )
			// InternalWeightDefinition.g:6101:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
							}
			pushFollow(FOLLOW_78);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:6115:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			int alt106=2;
			alt106 = dfa106.predict(input);
			switch (alt106) {
				case 1 :
					// InternalWeightDefinition.g:6116:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					{
					// InternalWeightDefinition.g:6116:4: ( ( '<' )=>otherlv_1= '<' )
					// InternalWeightDefinition.g:6117:5: ( '<' )=>otherlv_1= '<'
					{
					otherlv_1=(Token)match(input,42,FOLLOW_33); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
									}
					}

					// InternalWeightDefinition.g:6123:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
					// InternalWeightDefinition.g:6124:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					{
					// InternalWeightDefinition.g:6124:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					// InternalWeightDefinition.g:6125:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_34);
					lv_arguments_2_0=ruleJvmArgumentTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
											}
											add(
												current,
												"arguments",
												lv_arguments_2_0,
												"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:6142:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
					loop102:
					while (true) {
						int alt102=2;
						int LA102_0 = input.LA(1);
						if ( (LA102_0==29) ) {
							alt102=1;
						}

						switch (alt102) {
						case 1 :
							// InternalWeightDefinition.g:6143:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_3=(Token)match(input,29,FOLLOW_33); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
											}
							// InternalWeightDefinition.g:6147:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:6148:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:6148:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:6149:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
													}
							pushFollow(FOLLOW_34);
							lv_arguments_4_0=ruleJvmArgumentTypeReference();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
														}
														add(
															current,
															"arguments",
															lv_arguments_4_0,
															"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
														afterParserOrEnumRuleCall();
													}
							}

							}

							}
							break;

						default :
							break loop102;
						}
					}

					otherlv_5=(Token)match(input,48,FOLLOW_75); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
								}
					// InternalWeightDefinition.g:6171:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					loop105:
					while (true) {
						int alt105=2;
						int LA105_0 = input.LA(1);
						if ( (LA105_0==34) ) {
							int LA105_2 = input.LA(2);
							if ( (LA105_2==RULE_ID) ) {
								int LA105_3 = input.LA(3);
								if ( (synpred45_InternalWeightDefinition()) ) {
									alt105=1;
								}

							}

						}

						switch (alt105) {
						case 1 :
							// InternalWeightDefinition.g:6172:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							{
							// InternalWeightDefinition.g:6172:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
							// InternalWeightDefinition.g:6173:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
							{
							// InternalWeightDefinition.g:6179:6: ( () otherlv_7= '.' )
							// InternalWeightDefinition.g:6180:7: () otherlv_7= '.'
							{
							// InternalWeightDefinition.g:6180:7: ()
							// InternalWeightDefinition.g:6181:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
																current);
														}
							}

							otherlv_7=(Token)match(input,34,FOLLOW_6); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
													}
							}

							}

							// InternalWeightDefinition.g:6193:5: ( ( ruleValidID ) )
							// InternalWeightDefinition.g:6194:6: ( ruleValidID )
							{
							// InternalWeightDefinition.g:6194:6: ( ruleValidID )
							// InternalWeightDefinition.g:6195:7: ruleValidID
							{
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
														}
													}
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
													}
							pushFollow(FOLLOW_79);
							ruleValidID();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalWeightDefinition.g:6209:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							int alt104=2;
							alt104 = dfa104.predict(input);
							switch (alt104) {
								case 1 :
									// InternalWeightDefinition.g:6210:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
									{
									// InternalWeightDefinition.g:6210:6: ( ( '<' )=>otherlv_9= '<' )
									// InternalWeightDefinition.g:6211:7: ( '<' )=>otherlv_9= '<'
									{
									otherlv_9=(Token)match(input,42,FOLLOW_33); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
															}
									}

									// InternalWeightDefinition.g:6217:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
									// InternalWeightDefinition.g:6218:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									{
									// InternalWeightDefinition.g:6218:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									// InternalWeightDefinition.g:6219:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
																}
									pushFollow(FOLLOW_34);
									lv_arguments_10_0=ruleJvmArgumentTypeReference();
									state._fsp--;
									if (state.failed) return current;
									if ( state.backtracking==0 ) {
																	if (current==null) {
																		current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
																	}
																	add(
																		current,
																		"arguments",
																		lv_arguments_10_0,
																		"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
																	afterParserOrEnumRuleCall();
																}
									}

									}

									// InternalWeightDefinition.g:6236:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
									loop103:
									while (true) {
										int alt103=2;
										int LA103_0 = input.LA(1);
										if ( (LA103_0==29) ) {
											alt103=1;
										}

										switch (alt103) {
										case 1 :
											// InternalWeightDefinition.g:6237:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											{
											otherlv_11=(Token)match(input,29,FOLLOW_33); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
																	}
											// InternalWeightDefinition.g:6241:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											// InternalWeightDefinition.g:6242:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											{
											// InternalWeightDefinition.g:6242:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											// InternalWeightDefinition.g:6243:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
											{
											if ( state.backtracking==0 ) {
																				newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
																			}
											pushFollow(FOLLOW_34);
											lv_arguments_12_0=ruleJvmArgumentTypeReference();
											state._fsp--;
											if (state.failed) return current;
											if ( state.backtracking==0 ) {
																				if (current==null) {
																					current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
																				}
																				add(
																					current,
																					"arguments",
																					lv_arguments_12_0,
																					"org.eclipse.xtext.xbase.Xtype.JvmArgumentTypeReference");
																				afterParserOrEnumRuleCall();
																			}
											}

											}

											}
											break;

										default :
											break loop103;
										}
									}

									otherlv_13=(Token)match(input,48,FOLLOW_75); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
														}
									}
									break;

							}

							}
							break;

						default :
							break loop105;
						}
					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmParameterizedTypeReference"



	// $ANTLR start "entryRuleJvmArgumentTypeReference"
	// InternalWeightDefinition.g:6272:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] :iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
	public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmArgumentTypeReference =null;

		try {
			// InternalWeightDefinition.g:6272:65: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
			// InternalWeightDefinition.g:6273:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmArgumentTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmArgumentTypeReference"



	// $ANTLR start "ruleJvmArgumentTypeReference"
	// InternalWeightDefinition.g:6279:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
	public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmTypeReference_0 =null;
		EObject this_JvmWildcardTypeReference_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6285:2: ( (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
			// InternalWeightDefinition.g:6286:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			{
			// InternalWeightDefinition.g:6286:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==RULE_ID||LA107_0==21||LA107_0==47) ) {
				alt107=1;
			}
			else if ( (LA107_0==50) ) {
				alt107=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 107, 0, input);
				throw nvae;
			}

			switch (alt107) {
				case 1 :
					// InternalWeightDefinition.g:6287:3: this_JvmTypeReference_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0());
							}
					pushFollow(FOLLOW_2);
					this_JvmTypeReference_0=ruleJvmTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_JvmTypeReference_0;
								afterParserOrEnumRuleCall();
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:6296:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1());
							}
					pushFollow(FOLLOW_2);
					this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current = this_JvmWildcardTypeReference_1;
								afterParserOrEnumRuleCall();
							}
					}
					break;

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmArgumentTypeReference"



	// $ANTLR start "entryRuleJvmWildcardTypeReference"
	// InternalWeightDefinition.g:6308:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] :iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
	public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmWildcardTypeReference =null;

		try {
			// InternalWeightDefinition.g:6308:65: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
			// InternalWeightDefinition.g:6309:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmWildcardTypeReference; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmWildcardTypeReference"



	// $ANTLR start "ruleJvmWildcardTypeReference"
	// InternalWeightDefinition.g:6315:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
	public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_constraints_2_0 =null;
		EObject lv_constraints_3_0 =null;
		EObject lv_constraints_4_0 =null;
		EObject lv_constraints_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6321:2: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
			// InternalWeightDefinition.g:6322:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			{
			// InternalWeightDefinition.g:6322:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			// InternalWeightDefinition.g:6323:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			{
			// InternalWeightDefinition.g:6323:3: ()
			// InternalWeightDefinition.g:6324:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,50,FOLLOW_80); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
					}
			// InternalWeightDefinition.g:6334:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			int alt110=3;
			int LA110_0 = input.LA(1);
			if ( (LA110_0==61) ) {
				alt110=1;
			}
			else if ( (LA110_0==75) ) {
				alt110=2;
			}
			switch (alt110) {
				case 1 :
					// InternalWeightDefinition.g:6335:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					{
					// InternalWeightDefinition.g:6335:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					// InternalWeightDefinition.g:6336:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					{
					// InternalWeightDefinition.g:6336:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
					// InternalWeightDefinition.g:6337:6: (lv_constraints_2_0= ruleJvmUpperBound )
					{
					// InternalWeightDefinition.g:6337:6: (lv_constraints_2_0= ruleJvmUpperBound )
					// InternalWeightDefinition.g:6338:7: lv_constraints_2_0= ruleJvmUpperBound
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
											}
					pushFollow(FOLLOW_81);
					lv_constraints_2_0=ruleJvmUpperBound();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
												}
												add(
													current,
													"constraints",
													lv_constraints_2_0,
													"org.eclipse.xtext.xbase.Xtype.JvmUpperBound");
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:6355:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					loop108:
					while (true) {
						int alt108=2;
						int LA108_0 = input.LA(1);
						if ( (LA108_0==20) ) {
							alt108=1;
						}

						switch (alt108) {
						case 1 :
							// InternalWeightDefinition.g:6356:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							{
							// InternalWeightDefinition.g:6356:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							// InternalWeightDefinition.g:6357:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
													}
							pushFollow(FOLLOW_81);
							lv_constraints_3_0=ruleJvmUpperBoundAnded();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
														}
														add(
															current,
															"constraints",
															lv_constraints_3_0,
															"org.eclipse.xtext.xbase.Xtype.JvmUpperBoundAnded");
														afterParserOrEnumRuleCall();
													}
							}

							}
							break;

						default :
							break loop108;
						}
					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:6376:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					{
					// InternalWeightDefinition.g:6376:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					// InternalWeightDefinition.g:6377:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					{
					// InternalWeightDefinition.g:6377:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
					// InternalWeightDefinition.g:6378:6: (lv_constraints_4_0= ruleJvmLowerBound )
					{
					// InternalWeightDefinition.g:6378:6: (lv_constraints_4_0= ruleJvmLowerBound )
					// InternalWeightDefinition.g:6379:7: lv_constraints_4_0= ruleJvmLowerBound
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
											}
					pushFollow(FOLLOW_81);
					lv_constraints_4_0=ruleJvmLowerBound();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
												}
												add(
													current,
													"constraints",
													lv_constraints_4_0,
													"org.eclipse.xtext.xbase.Xtype.JvmLowerBound");
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:6396:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					loop109:
					while (true) {
						int alt109=2;
						int LA109_0 = input.LA(1);
						if ( (LA109_0==20) ) {
							alt109=1;
						}

						switch (alt109) {
						case 1 :
							// InternalWeightDefinition.g:6397:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							{
							// InternalWeightDefinition.g:6397:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							// InternalWeightDefinition.g:6398:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
													}
							pushFollow(FOLLOW_81);
							lv_constraints_5_0=ruleJvmLowerBoundAnded();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
														}
														add(
															current,
															"constraints",
															lv_constraints_5_0,
															"org.eclipse.xtext.xbase.Xtype.JvmLowerBoundAnded");
														afterParserOrEnumRuleCall();
													}
							}

							}
							break;

						default :
							break loop109;
						}
					}

					}

					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmWildcardTypeReference"



	// $ANTLR start "entryRuleJvmUpperBound"
	// InternalWeightDefinition.g:6421:1: entryRuleJvmUpperBound returns [EObject current=null] :iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
	public final EObject entryRuleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBound =null;

		try {
			// InternalWeightDefinition.g:6421:54: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
			// InternalWeightDefinition.g:6422:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmUpperBoundRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmUpperBound=ruleJvmUpperBound();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmUpperBound; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmUpperBound"



	// $ANTLR start "ruleJvmUpperBound"
	// InternalWeightDefinition.g:6428:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6434:2: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6435:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6435:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6436:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,61,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
					}
			// InternalWeightDefinition.g:6440:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6441:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6441:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6442:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmUpperBound"



	// $ANTLR start "entryRuleJvmUpperBoundAnded"
	// InternalWeightDefinition.g:6463:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] :iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
	public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBoundAnded =null;

		try {
			// InternalWeightDefinition.g:6463:59: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
			// InternalWeightDefinition.g:6464:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmUpperBoundAnded; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmUpperBoundAnded"



	// $ANTLR start "ruleJvmUpperBoundAnded"
	// InternalWeightDefinition.g:6470:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6476:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6477:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6477:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6478:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalWeightDefinition.g:6482:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6483:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6483:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6484:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmUpperBoundAnded"



	// $ANTLR start "entryRuleJvmLowerBound"
	// InternalWeightDefinition.g:6505:1: entryRuleJvmLowerBound returns [EObject current=null] :iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
	public final EObject entryRuleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBound =null;

		try {
			// InternalWeightDefinition.g:6505:54: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
			// InternalWeightDefinition.g:6506:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmLowerBoundRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmLowerBound=ruleJvmLowerBound();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmLowerBound; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmLowerBound"



	// $ANTLR start "ruleJvmLowerBound"
	// InternalWeightDefinition.g:6512:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6518:2: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6519:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6519:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6520:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,75,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
					}
			// InternalWeightDefinition.g:6524:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6525:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6525:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6526:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmLowerBound"



	// $ANTLR start "entryRuleJvmLowerBoundAnded"
	// InternalWeightDefinition.g:6547:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] :iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
	public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBoundAnded =null;

		try {
			// InternalWeightDefinition.g:6547:59: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
			// InternalWeightDefinition.g:6548:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getJvmLowerBoundAndedRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleJvmLowerBoundAnded=ruleJvmLowerBoundAnded();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleJvmLowerBoundAnded; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleJvmLowerBoundAnded"



	// $ANTLR start "ruleJvmLowerBoundAnded"
	// InternalWeightDefinition.g:6554:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6560:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6561:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6561:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6562:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalWeightDefinition.g:6566:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6567:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6567:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6568:5: lv_typeReference_1_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmLowerBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_2);
			lv_typeReference_1_0=ruleJvmTypeReference();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElementForParent(grammarAccess.getJvmLowerBoundAndedRule());
								}
								set(
									current,
									"typeReference",
									lv_typeReference_1_0,
									"org.eclipse.xtext.xbase.Xtype.JvmTypeReference");
								afterParserOrEnumRuleCall();
							}
			}

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleJvmLowerBoundAnded"



	// $ANTLR start "entryRuleQualifiedNameWithWildcard"
	// InternalWeightDefinition.g:6589:1: entryRuleQualifiedNameWithWildcard returns [String current=null] :iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
	public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard =null;

		try {
			// InternalWeightDefinition.g:6589:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
			// InternalWeightDefinition.g:6590:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleQualifiedNameWithWildcard.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleQualifiedNameWithWildcard"



	// $ANTLR start "ruleQualifiedNameWithWildcard"
	// InternalWeightDefinition.g:6596:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_QualifiedName_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6602:2: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
			// InternalWeightDefinition.g:6603:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			{
			// InternalWeightDefinition.g:6603:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			// InternalWeightDefinition.g:6604:3: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
					}
			pushFollow(FOLLOW_82);
			this_QualifiedName_0=ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(this_QualifiedName_0);
					}
			if ( state.backtracking==0 ) {
						afterParserOrEnumRuleCall();
					}
			kw=(Token)match(input,34,FOLLOW_83); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopKeyword_1());
					}
			kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(kw);
						newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getAsteriskKeyword_2());
					}
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleQualifiedNameWithWildcard"



	// $ANTLR start "entryRuleValidID"
	// InternalWeightDefinition.g:6628:1: entryRuleValidID returns [String current=null] :iv_ruleValidID= ruleValidID EOF ;
	public final String entryRuleValidID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleValidID =null;

		try {
			// InternalWeightDefinition.g:6628:47: (iv_ruleValidID= ruleValidID EOF )
			// InternalWeightDefinition.g:6629:2: iv_ruleValidID= ruleValidID EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getValidIDRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleValidID=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleValidID.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleValidID"



	// $ANTLR start "ruleValidID"
	// InternalWeightDefinition.g:6635:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
	public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_ID_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6641:2: (this_ID_0= RULE_ID )
			// InternalWeightDefinition.g:6642:2: this_ID_0= RULE_ID
			{
			this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
			if ( state.backtracking==0 ) {
					current.merge(this_ID_0);
				}
			if ( state.backtracking==0 ) {
					newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall());
				}
			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleValidID"



	// $ANTLR start "entryRuleXImportDeclaration"
	// InternalWeightDefinition.g:6652:1: entryRuleXImportDeclaration returns [EObject current=null] :iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
	public final EObject entryRuleXImportDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXImportDeclaration =null;

		try {
			// InternalWeightDefinition.g:6652:59: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
			// InternalWeightDefinition.g:6653:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getXImportDeclarationRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleXImportDeclaration=ruleXImportDeclaration();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleXImportDeclaration; }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleXImportDeclaration"



	// $ANTLR start "ruleXImportDeclaration"
	// InternalWeightDefinition.g:6659:1: ruleXImportDeclaration returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
	public final EObject ruleXImportDeclaration() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token lv_static_1_0=null;
		Token lv_extension_2_0=null;
		Token lv_wildcard_4_0=null;
		Token otherlv_8=null;
		AntlrDatatypeRuleToken lv_memberName_5_0 =null;
		AntlrDatatypeRuleToken lv_importedNamespace_7_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6665:2: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
			// InternalWeightDefinition.g:6666:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
			{
			// InternalWeightDefinition.g:6666:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
			// InternalWeightDefinition.g:6667:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
			{
			otherlv_0=(Token)match(input,68,FOLLOW_84); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
					}
			// InternalWeightDefinition.g:6671:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
			int alt113=3;
			alt113 = dfa113.predict(input);
			switch (alt113) {
				case 1 :
					// InternalWeightDefinition.g:6672:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
					{
					// InternalWeightDefinition.g:6672:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
					// InternalWeightDefinition.g:6673:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
					{
					// InternalWeightDefinition.g:6673:5: ( (lv_static_1_0= 'static' ) )
					// InternalWeightDefinition.g:6674:6: (lv_static_1_0= 'static' )
					{
					// InternalWeightDefinition.g:6674:6: (lv_static_1_0= 'static' )
					// InternalWeightDefinition.g:6675:7: lv_static_1_0= 'static'
					{
					lv_static_1_0=(Token)match(input,74,FOLLOW_85); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(lv_static_1_0, grammarAccess.getXImportDeclarationAccess().getStaticStaticKeyword_1_0_0_0());
											}
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXImportDeclarationRule());
												}
												setWithLastConsumed(current, "static", true, "static");
											}
					}

					}

					// InternalWeightDefinition.g:6687:5: ( (lv_extension_2_0= 'extension' ) )?
					int alt111=2;
					int LA111_0 = input.LA(1);
					if ( (LA111_0==62) ) {
						alt111=1;
					}
					switch (alt111) {
						case 1 :
							// InternalWeightDefinition.g:6688:6: (lv_extension_2_0= 'extension' )
							{
							// InternalWeightDefinition.g:6688:6: (lv_extension_2_0= 'extension' )
							// InternalWeightDefinition.g:6689:7: lv_extension_2_0= 'extension'
							{
							lv_extension_2_0=(Token)match(input,62,FOLLOW_6); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(lv_extension_2_0, grammarAccess.getXImportDeclarationAccess().getExtensionExtensionKeyword_1_0_1_0());
													}
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getXImportDeclarationRule());
														}
														setWithLastConsumed(current, "extension", true, "extension");
													}
							}

							}
							break;

					}

					// InternalWeightDefinition.g:6701:5: ( ( ruleQualifiedNameInStaticImport ) )
					// InternalWeightDefinition.g:6702:6: ( ruleQualifiedNameInStaticImport )
					{
					// InternalWeightDefinition.g:6702:6: ( ruleQualifiedNameInStaticImport )
					// InternalWeightDefinition.g:6703:7: ruleQualifiedNameInStaticImport
					{
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXImportDeclarationRule());
												}
											}
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0());
											}
					pushFollow(FOLLOW_86);
					ruleQualifiedNameInStaticImport();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:6717:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
					int alt112=2;
					int LA112_0 = input.LA(1);
					if ( (LA112_0==23) ) {
						alt112=1;
					}
					else if ( (LA112_0==RULE_ID) ) {
						alt112=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 112, 0, input);
						throw nvae;
					}

					switch (alt112) {
						case 1 :
							// InternalWeightDefinition.g:6718:6: ( (lv_wildcard_4_0= '*' ) )
							{
							// InternalWeightDefinition.g:6718:6: ( (lv_wildcard_4_0= '*' ) )
							// InternalWeightDefinition.g:6719:7: (lv_wildcard_4_0= '*' )
							{
							// InternalWeightDefinition.g:6719:7: (lv_wildcard_4_0= '*' )
							// InternalWeightDefinition.g:6720:8: lv_wildcard_4_0= '*'
							{
							lv_wildcard_4_0=(Token)match(input,23,FOLLOW_87); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(lv_wildcard_4_0, grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_1_0_3_0_0());
														}
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElement(grammarAccess.getXImportDeclarationRule());
															}
															setWithLastConsumed(current, "wildcard", true, "*");
														}
							}

							}

							}
							break;
						case 2 :
							// InternalWeightDefinition.g:6733:6: ( (lv_memberName_5_0= ruleValidID ) )
							{
							// InternalWeightDefinition.g:6733:6: ( (lv_memberName_5_0= ruleValidID ) )
							// InternalWeightDefinition.g:6734:7: (lv_memberName_5_0= ruleValidID )
							{
							// InternalWeightDefinition.g:6734:7: (lv_memberName_5_0= ruleValidID )
							// InternalWeightDefinition.g:6735:8: lv_memberName_5_0= ruleValidID
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0());
														}
							pushFollow(FOLLOW_87);
							lv_memberName_5_0=ruleValidID();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
															if (current==null) {
																current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
															}
															set(
																current,
																"memberName",
																lv_memberName_5_0,
																"org.eclipse.xtext.xbase.Xtype.ValidID");
															afterParserOrEnumRuleCall();
														}
							}

							}

							}
							break;

					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:6755:4: ( ( ruleQualifiedName ) )
					{
					// InternalWeightDefinition.g:6755:4: ( ( ruleQualifiedName ) )
					// InternalWeightDefinition.g:6756:5: ( ruleQualifiedName )
					{
					// InternalWeightDefinition.g:6756:5: ( ruleQualifiedName )
					// InternalWeightDefinition.g:6757:6: ruleQualifiedName
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXImportDeclarationRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
										}
					pushFollow(FOLLOW_87);
					ruleQualifiedName();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;
				case 3 :
					// InternalWeightDefinition.g:6772:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
					{
					// InternalWeightDefinition.g:6772:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
					// InternalWeightDefinition.g:6773:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
					{
					// InternalWeightDefinition.g:6773:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
					// InternalWeightDefinition.g:6774:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_87);
					lv_importedNamespace_7_0=ruleQualifiedNameWithWildcard();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getXImportDeclarationRule());
											}
											set(
												current,
												"importedNamespace",
												lv_importedNamespace_7_0,
												"org.eclipse.xtext.xbase.Xtype.QualifiedNameWithWildcard");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;

			}

			// InternalWeightDefinition.g:6792:3: (otherlv_8= ';' )?
			int alt114=2;
			int LA114_0 = input.LA(1);
			if ( (LA114_0==41) ) {
				alt114=1;
			}
			switch (alt114) {
				case 1 :
					// InternalWeightDefinition.g:6793:4: otherlv_8= ';'
					{
					otherlv_8=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_8, grammarAccess.getXImportDeclarationAccess().getSemicolonKeyword_2());
								}
					}
					break;

			}

			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleXImportDeclaration"



	// $ANTLR start "entryRuleQualifiedNameInStaticImport"
	// InternalWeightDefinition.g:6802:1: entryRuleQualifiedNameInStaticImport returns [String current=null] :iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
	public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport =null;

		try {
			// InternalWeightDefinition.g:6802:67: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
			// InternalWeightDefinition.g:6803:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
			{
			if ( state.backtracking==0 ) { newCompositeNode(grammarAccess.getQualifiedNameInStaticImportRule()); }
			pushFollow(FOLLOW_1);
			iv_ruleQualifiedNameInStaticImport=ruleQualifiedNameInStaticImport();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) { current =iv_ruleQualifiedNameInStaticImport.getText(); }
			match(input,EOF,FOLLOW_2); if (state.failed) return current;
			}

		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "entryRuleQualifiedNameInStaticImport"



	// $ANTLR start "ruleQualifiedNameInStaticImport"
	// InternalWeightDefinition.g:6809:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '.' )+ ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6815:2: ( (this_ValidID_0= ruleValidID kw= '.' )+ )
			// InternalWeightDefinition.g:6816:2: (this_ValidID_0= ruleValidID kw= '.' )+
			{
			// InternalWeightDefinition.g:6816:2: (this_ValidID_0= ruleValidID kw= '.' )+
			int cnt115=0;
			loop115:
			while (true) {
				int alt115=2;
				int LA115_0 = input.LA(1);
				if ( (LA115_0==RULE_ID) ) {
					int LA115_2 = input.LA(2);
					if ( (LA115_2==34) ) {
						alt115=1;
					}

				}

				switch (alt115) {
				case 1 :
					// InternalWeightDefinition.g:6817:3: this_ValidID_0= ruleValidID kw= '.'
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
							}
					pushFollow(FOLLOW_82);
					this_ValidID_0=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ValidID_0);
							}
					if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
					kw=(Token)match(input,34,FOLLOW_88); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
							}
					}
					break;

				default :
					if ( cnt115 >= 1 ) break loop115;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(115, input);
					throw eee;
				}
				cnt115++;
			}

			}

			if ( state.backtracking==0 ) {
				leaveRule();
			}
		}

		    catch (RecognitionException re) {
		        recover(input,re);
		        appendSkippedTokens();
		    }

		finally {
			// do for sure before leaving
		}
		return current;
	}
	// $ANTLR end "ruleQualifiedNameInStaticImport"

	// $ANTLR start synpred1_InternalWeightDefinition
	public final void synpred1_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:657:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
		// InternalWeightDefinition.g:657:7: ( () ( ( ruleOpMultiAssign ) ) )
		{
		// InternalWeightDefinition.g:657:7: ( () ( ( ruleOpMultiAssign ) ) )
		// InternalWeightDefinition.g:658:7: () ( ( ruleOpMultiAssign ) )
		{
		// InternalWeightDefinition.g:658:7: ()
		// InternalWeightDefinition.g:659:7: 
		{
		}

		// InternalWeightDefinition.g:660:7: ( ( ruleOpMultiAssign ) )
		// InternalWeightDefinition.g:661:8: ( ruleOpMultiAssign )
		{
		// InternalWeightDefinition.g:661:8: ( ruleOpMultiAssign )
		// InternalWeightDefinition.g:662:9: ruleOpMultiAssign
		{
		pushFollow(FOLLOW_2);
		ruleOpMultiAssign();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred1_InternalWeightDefinition

	// $ANTLR start synpred2_InternalWeightDefinition
	public final void synpred2_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:851:5: ( ( () ( ( ruleOpOr ) ) ) )
		// InternalWeightDefinition.g:851:6: ( () ( ( ruleOpOr ) ) )
		{
		// InternalWeightDefinition.g:851:6: ( () ( ( ruleOpOr ) ) )
		// InternalWeightDefinition.g:852:6: () ( ( ruleOpOr ) )
		{
		// InternalWeightDefinition.g:852:6: ()
		// InternalWeightDefinition.g:853:6: 
		{
		}

		// InternalWeightDefinition.g:854:6: ( ( ruleOpOr ) )
		// InternalWeightDefinition.g:855:7: ( ruleOpOr )
		{
		// InternalWeightDefinition.g:855:7: ( ruleOpOr )
		// InternalWeightDefinition.g:856:8: ruleOpOr
		{
		pushFollow(FOLLOW_2);
		ruleOpOr();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred2_InternalWeightDefinition

	// $ANTLR start synpred3_InternalWeightDefinition
	public final void synpred3_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:958:5: ( ( () ( ( ruleOpAnd ) ) ) )
		// InternalWeightDefinition.g:958:6: ( () ( ( ruleOpAnd ) ) )
		{
		// InternalWeightDefinition.g:958:6: ( () ( ( ruleOpAnd ) ) )
		// InternalWeightDefinition.g:959:6: () ( ( ruleOpAnd ) )
		{
		// InternalWeightDefinition.g:959:6: ()
		// InternalWeightDefinition.g:960:6: 
		{
		}

		// InternalWeightDefinition.g:961:6: ( ( ruleOpAnd ) )
		// InternalWeightDefinition.g:962:7: ( ruleOpAnd )
		{
		// InternalWeightDefinition.g:962:7: ( ruleOpAnd )
		// InternalWeightDefinition.g:963:8: ruleOpAnd
		{
		pushFollow(FOLLOW_2);
		ruleOpAnd();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred3_InternalWeightDefinition

	// $ANTLR start synpred4_InternalWeightDefinition
	public final void synpred4_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1065:5: ( ( () ( ( ruleOpEquality ) ) ) )
		// InternalWeightDefinition.g:1065:6: ( () ( ( ruleOpEquality ) ) )
		{
		// InternalWeightDefinition.g:1065:6: ( () ( ( ruleOpEquality ) ) )
		// InternalWeightDefinition.g:1066:6: () ( ( ruleOpEquality ) )
		{
		// InternalWeightDefinition.g:1066:6: ()
		// InternalWeightDefinition.g:1067:6: 
		{
		}

		// InternalWeightDefinition.g:1068:6: ( ( ruleOpEquality ) )
		// InternalWeightDefinition.g:1069:7: ( ruleOpEquality )
		{
		// InternalWeightDefinition.g:1069:7: ( ruleOpEquality )
		// InternalWeightDefinition.g:1070:8: ruleOpEquality
		{
		pushFollow(FOLLOW_2);
		ruleOpEquality();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred4_InternalWeightDefinition

	// $ANTLR start synpred5_InternalWeightDefinition
	public final void synpred5_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1193:6: ( ( () 'instanceof' ) )
		// InternalWeightDefinition.g:1193:7: ( () 'instanceof' )
		{
		// InternalWeightDefinition.g:1193:7: ( () 'instanceof' )
		// InternalWeightDefinition.g:1194:7: () 'instanceof'
		{
		// InternalWeightDefinition.g:1194:7: ()
		// InternalWeightDefinition.g:1195:7: 
		{
		}

		match(input,69,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred5_InternalWeightDefinition

	// $ANTLR start synpred6_InternalWeightDefinition
	public final void synpred6_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1236:6: ( ( () ( ( ruleOpCompare ) ) ) )
		// InternalWeightDefinition.g:1236:7: ( () ( ( ruleOpCompare ) ) )
		{
		// InternalWeightDefinition.g:1236:7: ( () ( ( ruleOpCompare ) ) )
		// InternalWeightDefinition.g:1237:7: () ( ( ruleOpCompare ) )
		{
		// InternalWeightDefinition.g:1237:7: ()
		// InternalWeightDefinition.g:1238:7: 
		{
		}

		// InternalWeightDefinition.g:1239:7: ( ( ruleOpCompare ) )
		// InternalWeightDefinition.g:1240:8: ( ruleOpCompare )
		{
		// InternalWeightDefinition.g:1240:8: ( ruleOpCompare )
		// InternalWeightDefinition.g:1241:9: ruleOpCompare
		{
		pushFollow(FOLLOW_2);
		ruleOpCompare();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred6_InternalWeightDefinition

	// $ANTLR start synpred7_InternalWeightDefinition
	public final void synpred7_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1371:5: ( ( () ( ( ruleOpOther ) ) ) )
		// InternalWeightDefinition.g:1371:6: ( () ( ( ruleOpOther ) ) )
		{
		// InternalWeightDefinition.g:1371:6: ( () ( ( ruleOpOther ) ) )
		// InternalWeightDefinition.g:1372:6: () ( ( ruleOpOther ) )
		{
		// InternalWeightDefinition.g:1372:6: ()
		// InternalWeightDefinition.g:1373:6: 
		{
		}

		// InternalWeightDefinition.g:1374:6: ( ( ruleOpOther ) )
		// InternalWeightDefinition.g:1375:7: ( ruleOpOther )
		{
		// InternalWeightDefinition.g:1375:7: ( ruleOpOther )
		// InternalWeightDefinition.g:1376:8: ruleOpOther
		{
		pushFollow(FOLLOW_2);
		ruleOpOther();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred7_InternalWeightDefinition

	// $ANTLR start synpred8_InternalWeightDefinition
	public final void synpred8_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1491:6: ( ( '>' '>' ) )
		// InternalWeightDefinition.g:1491:7: ( '>' '>' )
		{
		// InternalWeightDefinition.g:1491:7: ( '>' '>' )
		// InternalWeightDefinition.g:1492:7: '>' '>'
		{
		match(input,48,FOLLOW_24); if (state.failed) return;
		match(input,48,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred8_InternalWeightDefinition

	// $ANTLR start synpred9_InternalWeightDefinition
	public final void synpred9_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1526:6: ( ( '<' '<' ) )
		// InternalWeightDefinition.g:1526:7: ( '<' '<' )
		{
		// InternalWeightDefinition.g:1526:7: ( '<' '<' )
		// InternalWeightDefinition.g:1527:7: '<' '<'
		{
		match(input,42,FOLLOW_15); if (state.failed) return;
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred9_InternalWeightDefinition

	// $ANTLR start synpred10_InternalWeightDefinition
	public final void synpred10_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1599:5: ( ( () ( ( ruleOpAdd ) ) ) )
		// InternalWeightDefinition.g:1599:6: ( () ( ( ruleOpAdd ) ) )
		{
		// InternalWeightDefinition.g:1599:6: ( () ( ( ruleOpAdd ) ) )
		// InternalWeightDefinition.g:1600:6: () ( ( ruleOpAdd ) )
		{
		// InternalWeightDefinition.g:1600:6: ()
		// InternalWeightDefinition.g:1601:6: 
		{
		}

		// InternalWeightDefinition.g:1602:6: ( ( ruleOpAdd ) )
		// InternalWeightDefinition.g:1603:7: ( ruleOpAdd )
		{
		// InternalWeightDefinition.g:1603:7: ( ruleOpAdd )
		// InternalWeightDefinition.g:1604:8: ruleOpAdd
		{
		pushFollow(FOLLOW_2);
		ruleOpAdd();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred10_InternalWeightDefinition

	// $ANTLR start synpred11_InternalWeightDefinition
	public final void synpred11_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1714:5: ( ( () ( ( ruleOpMulti ) ) ) )
		// InternalWeightDefinition.g:1714:6: ( () ( ( ruleOpMulti ) ) )
		{
		// InternalWeightDefinition.g:1714:6: ( () ( ( ruleOpMulti ) ) )
		// InternalWeightDefinition.g:1715:6: () ( ( ruleOpMulti ) )
		{
		// InternalWeightDefinition.g:1715:6: ()
		// InternalWeightDefinition.g:1716:6: 
		{
		}

		// InternalWeightDefinition.g:1717:6: ( ( ruleOpMulti ) )
		// InternalWeightDefinition.g:1718:7: ( ruleOpMulti )
		{
		// InternalWeightDefinition.g:1718:7: ( ruleOpMulti )
		// InternalWeightDefinition.g:1719:8: ruleOpMulti
		{
		pushFollow(FOLLOW_2);
		ruleOpMulti();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred11_InternalWeightDefinition

	// $ANTLR start synpred12_InternalWeightDefinition
	public final void synpred12_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1949:5: ( ( () 'as' ) )
		// InternalWeightDefinition.g:1949:6: ( () 'as' )
		{
		// InternalWeightDefinition.g:1949:6: ( () 'as' )
		// InternalWeightDefinition.g:1950:6: () 'as'
		{
		// InternalWeightDefinition.g:1950:6: ()
		// InternalWeightDefinition.g:1951:6: 
		{
		}

		match(input,55,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred12_InternalWeightDefinition

	// $ANTLR start synpred13_InternalWeightDefinition
	public final void synpred13_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2017:4: ( ( () ( ( ruleOpPostfix ) ) ) )
		// InternalWeightDefinition.g:2017:5: ( () ( ( ruleOpPostfix ) ) )
		{
		// InternalWeightDefinition.g:2017:5: ( () ( ( ruleOpPostfix ) ) )
		// InternalWeightDefinition.g:2018:5: () ( ( ruleOpPostfix ) )
		{
		// InternalWeightDefinition.g:2018:5: ()
		// InternalWeightDefinition.g:2019:5: 
		{
		}

		// InternalWeightDefinition.g:2020:5: ( ( ruleOpPostfix ) )
		// InternalWeightDefinition.g:2021:6: ( ruleOpPostfix )
		{
		// InternalWeightDefinition.g:2021:6: ( ruleOpPostfix )
		// InternalWeightDefinition.g:2022:7: ruleOpPostfix
		{
		pushFollow(FOLLOW_2);
		ruleOpPostfix();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred13_InternalWeightDefinition

	// $ANTLR start synpred14_InternalWeightDefinition
	public final void synpred14_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2113:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
		// InternalWeightDefinition.g:2113:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		{
		// InternalWeightDefinition.g:2113:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		// InternalWeightDefinition.g:2114:7: () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
		{
		// InternalWeightDefinition.g:2114:7: ()
		// InternalWeightDefinition.g:2115:7: 
		{
		}

		if ( input.LA(1)==34||input.LA(1)==40 ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}
		// InternalWeightDefinition.g:2125:7: ( ( ruleFeatureCallID ) )
		// InternalWeightDefinition.g:2126:8: ( ruleFeatureCallID )
		{
		// InternalWeightDefinition.g:2126:8: ( ruleFeatureCallID )
		// InternalWeightDefinition.g:2127:9: ruleFeatureCallID
		{
		pushFollow(FOLLOW_12);
		ruleFeatureCallID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		pushFollow(FOLLOW_2);
		ruleOpSingleAssign();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred14_InternalWeightDefinition

	// $ANTLR start synpred15_InternalWeightDefinition
	public final void synpred15_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2210:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )
		// InternalWeightDefinition.g:2210:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
		{
		// InternalWeightDefinition.g:2210:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
		// InternalWeightDefinition.g:2211:7: () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
		{
		// InternalWeightDefinition.g:2211:7: ()
		// InternalWeightDefinition.g:2212:7: 
		{
		}

		if ( input.LA(1)==34||input.LA(1)==40||input.LA(1)==51 ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}
		}

		}

	}
	// $ANTLR end synpred15_InternalWeightDefinition

	// $ANTLR start synpred16_InternalWeightDefinition
	public final void synpred16_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2348:7: ( ( '(' ) )
		// InternalWeightDefinition.g:2348:8: ( '(' )
		{
		// InternalWeightDefinition.g:2348:8: ( '(' )
		// InternalWeightDefinition.g:2349:8: '('
		{
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred16_InternalWeightDefinition

	// $ANTLR start synpred17_InternalWeightDefinition
	public final void synpred17_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2367:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:2367:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:2367:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:2368:9: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:2368:9: ()
		// InternalWeightDefinition.g:2369:9: 
		{
		}

		// InternalWeightDefinition.g:2370:9: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt117=2;
		int LA117_0 = input.LA(1);
		if ( (LA117_0==RULE_ID||LA117_0==21||LA117_0==47) ) {
			alt117=1;
		}
		switch (alt117) {
			case 1 :
				// InternalWeightDefinition.g:2371:10: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:2371:10: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:2372:11: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:2372:11: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:2373:12: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_46);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:2376:10: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop116:
				while (true) {
					int alt116=2;
					int LA116_0 = input.LA(1);
					if ( (LA116_0==29) ) {
						alt116=1;
					}

					switch (alt116) {
					case 1 :
						// InternalWeightDefinition.g:2377:11: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_8); if (state.failed) return;
						// InternalWeightDefinition.g:2378:11: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:2379:12: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:2379:12: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:2380:13: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_46);
						ruleJvmFormalParameter();
						state._fsp--;
						if (state.failed) return;
						}

						}

						}
						break;

					default :
						break loop116;
					}
				}

				}
				break;

		}

		// InternalWeightDefinition.g:2385:9: ( ( '|' ) )
		// InternalWeightDefinition.g:2386:10: ( '|' )
		{
		// InternalWeightDefinition.g:2386:10: ( '|' )
		// InternalWeightDefinition.g:2387:11: '|'
		{
		match(input,86,FOLLOW_2); if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred17_InternalWeightDefinition

	// $ANTLR start synpred18_InternalWeightDefinition
	public final void synpred18_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2464:6: ( ( () '[' ) )
		// InternalWeightDefinition.g:2464:7: ( () '[' )
		{
		// InternalWeightDefinition.g:2464:7: ( () '[' )
		// InternalWeightDefinition.g:2465:7: () '['
		{
		// InternalWeightDefinition.g:2465:7: ()
		// InternalWeightDefinition.g:2466:7: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred18_InternalWeightDefinition

	// $ANTLR start synpred19_InternalWeightDefinition
	public final void synpred19_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2537:4: ( ( () 'synchronized' '(' ) )
		// InternalWeightDefinition.g:2537:5: ( () 'synchronized' '(' )
		{
		// InternalWeightDefinition.g:2537:5: ( () 'synchronized' '(' )
		// InternalWeightDefinition.g:2538:5: () 'synchronized' '('
		{
		// InternalWeightDefinition.g:2538:5: ()
		// InternalWeightDefinition.g:2539:5: 
		{
		}

		match(input,77,FOLLOW_9); if (state.failed) return;
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred19_InternalWeightDefinition

	// $ANTLR start synpred20_InternalWeightDefinition
	public final void synpred20_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2582:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
		// InternalWeightDefinition.g:2582:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
		{
		// InternalWeightDefinition.g:2582:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
		// InternalWeightDefinition.g:2583:5: () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':'
		{
		// InternalWeightDefinition.g:2583:5: ()
		// InternalWeightDefinition.g:2584:5: 
		{
		}

		match(input,65,FOLLOW_9); if (state.failed) return;
		match(input,21,FOLLOW_8); if (state.failed) return;
		// InternalWeightDefinition.g:2587:5: ( ( ruleJvmFormalParameter ) )
		// InternalWeightDefinition.g:2588:6: ( ruleJvmFormalParameter )
		{
		// InternalWeightDefinition.g:2588:6: ( ruleJvmFormalParameter )
		// InternalWeightDefinition.g:2589:7: ruleJvmFormalParameter
		{
		pushFollow(FOLLOW_53);
		ruleJvmFormalParameter();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,39,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred20_InternalWeightDefinition

	// $ANTLR start synpred21_InternalWeightDefinition
	public final void synpred21_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2696:4: ( ( () '[' ) )
		// InternalWeightDefinition.g:2696:5: ( () '[' )
		{
		// InternalWeightDefinition.g:2696:5: ( () '[' )
		// InternalWeightDefinition.g:2697:5: () '['
		{
		// InternalWeightDefinition.g:2697:5: ()
		// InternalWeightDefinition.g:2698:5: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred21_InternalWeightDefinition

	// $ANTLR start synpred23_InternalWeightDefinition
	public final void synpred23_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:3001:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:3001:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:3001:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:3002:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:3002:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt119=2;
		int LA119_0 = input.LA(1);
		if ( (LA119_0==RULE_ID||LA119_0==21||LA119_0==47) ) {
			alt119=1;
		}
		switch (alt119) {
			case 1 :
				// InternalWeightDefinition.g:3003:6: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:3003:6: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:3004:7: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:3004:7: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:3005:8: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_46);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:3008:6: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop118:
				while (true) {
					int alt118=2;
					int LA118_0 = input.LA(1);
					if ( (LA118_0==29) ) {
						alt118=1;
					}

					switch (alt118) {
					case 1 :
						// InternalWeightDefinition.g:3009:7: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_8); if (state.failed) return;
						// InternalWeightDefinition.g:3010:7: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:3011:8: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:3011:8: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:3012:9: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_46);
						ruleJvmFormalParameter();
						state._fsp--;
						if (state.failed) return;
						}

						}

						}
						break;

					default :
						break loop118;
					}
				}

				}
				break;

		}

		// InternalWeightDefinition.g:3017:5: ( ( '|' ) )
		// InternalWeightDefinition.g:3018:6: ( '|' )
		{
		// InternalWeightDefinition.g:3018:6: ( '|' )
		// InternalWeightDefinition.g:3019:7: '|'
		{
		match(input,86,FOLLOW_2); if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred23_InternalWeightDefinition

	// $ANTLR start synpred25_InternalWeightDefinition
	public final void synpred25_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:3410:5: ( 'else' )
		// InternalWeightDefinition.g:3410:6: 'else'
		{
		match(input,60,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred25_InternalWeightDefinition

	// $ANTLR start synpred26_InternalWeightDefinition
	public final void synpred26_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:3469:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
		// InternalWeightDefinition.g:3469:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
		{
		// InternalWeightDefinition.g:3469:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
		// InternalWeightDefinition.g:3470:7: '(' ( ( ruleJvmFormalParameter ) ) ':'
		{
		match(input,21,FOLLOW_8); if (state.failed) return;
		// InternalWeightDefinition.g:3471:7: ( ( ruleJvmFormalParameter ) )
		// InternalWeightDefinition.g:3472:8: ( ruleJvmFormalParameter )
		{
		// InternalWeightDefinition.g:3472:8: ( ruleJvmFormalParameter )
		// InternalWeightDefinition.g:3473:9: ruleJvmFormalParameter
		{
		pushFollow(FOLLOW_53);
		ruleJvmFormalParameter();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,39,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred26_InternalWeightDefinition

	// $ANTLR start synpred27_InternalWeightDefinition
	public final void synpred27_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:3536:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )
		// InternalWeightDefinition.g:3536:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
		{
		// InternalWeightDefinition.g:3536:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
		// InternalWeightDefinition.g:3537:7: ( ( ruleJvmFormalParameter ) ) ':'
		{
		// InternalWeightDefinition.g:3537:7: ( ( ruleJvmFormalParameter ) )
		// InternalWeightDefinition.g:3538:8: ( ruleJvmFormalParameter )
		{
		// InternalWeightDefinition.g:3538:8: ( ruleJvmFormalParameter )
		// InternalWeightDefinition.g:3539:9: ruleJvmFormalParameter
		{
		pushFollow(FOLLOW_53);
		ruleJvmFormalParameter();
		state._fsp--;
		if (state.failed) return;
		}

		}

		match(input,39,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred27_InternalWeightDefinition

	// $ANTLR start synpred29_InternalWeightDefinition
	public final void synpred29_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4354:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
		// InternalWeightDefinition.g:4354:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		{
		// InternalWeightDefinition.g:4354:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		// InternalWeightDefinition.g:4355:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
		{
		// InternalWeightDefinition.g:4355:6: ( ( ruleJvmTypeReference ) )
		// InternalWeightDefinition.g:4356:7: ( ruleJvmTypeReference )
		{
		// InternalWeightDefinition.g:4356:7: ( ruleJvmTypeReference )
		// InternalWeightDefinition.g:4357:8: ruleJvmTypeReference
		{
		pushFollow(FOLLOW_6);
		ruleJvmTypeReference();
		state._fsp--;
		if (state.failed) return;
		}

		}

		// InternalWeightDefinition.g:4360:6: ( ( ruleValidID ) )
		// InternalWeightDefinition.g:4361:7: ( ruleValidID )
		{
		// InternalWeightDefinition.g:4361:7: ( ruleValidID )
		// InternalWeightDefinition.g:4362:8: ruleValidID
		{
		pushFollow(FOLLOW_2);
		ruleValidID();
		state._fsp--;
		if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred29_InternalWeightDefinition

	// $ANTLR start synpred30_InternalWeightDefinition
	public final void synpred30_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4666:5: ( ( '(' ) )
		// InternalWeightDefinition.g:4666:6: ( '(' )
		{
		// InternalWeightDefinition.g:4666:6: ( '(' )
		// InternalWeightDefinition.g:4667:6: '('
		{
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred30_InternalWeightDefinition

	// $ANTLR start synpred31_InternalWeightDefinition
	public final void synpred31_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4685:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:4685:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:4685:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:4686:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:4686:7: ()
		// InternalWeightDefinition.g:4687:7: 
		{
		}

		// InternalWeightDefinition.g:4688:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt123=2;
		int LA123_0 = input.LA(1);
		if ( (LA123_0==RULE_ID||LA123_0==21||LA123_0==47) ) {
			alt123=1;
		}
		switch (alt123) {
			case 1 :
				// InternalWeightDefinition.g:4689:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:4689:8: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:4690:9: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:4690:9: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:4691:10: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_46);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:4694:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop122:
				while (true) {
					int alt122=2;
					int LA122_0 = input.LA(1);
					if ( (LA122_0==29) ) {
						alt122=1;
					}

					switch (alt122) {
					case 1 :
						// InternalWeightDefinition.g:4695:9: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_8); if (state.failed) return;
						// InternalWeightDefinition.g:4696:9: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:4697:10: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:4697:10: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:4698:11: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_46);
						ruleJvmFormalParameter();
						state._fsp--;
						if (state.failed) return;
						}

						}

						}
						break;

					default :
						break loop122;
					}
				}

				}
				break;

		}

		// InternalWeightDefinition.g:4703:7: ( ( '|' ) )
		// InternalWeightDefinition.g:4704:8: ( '|' )
		{
		// InternalWeightDefinition.g:4704:8: ( '|' )
		// InternalWeightDefinition.g:4705:9: '|'
		{
		match(input,86,FOLLOW_2); if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred31_InternalWeightDefinition

	// $ANTLR start synpred32_InternalWeightDefinition
	public final void synpred32_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4782:4: ( ( () '[' ) )
		// InternalWeightDefinition.g:4782:5: ( () '[' )
		{
		// InternalWeightDefinition.g:4782:5: ( () '[' )
		// InternalWeightDefinition.g:4783:5: () '['
		{
		// InternalWeightDefinition.g:4783:5: ()
		// InternalWeightDefinition.g:4784:5: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred32_InternalWeightDefinition

	// $ANTLR start synpred33_InternalWeightDefinition
	public final void synpred33_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4942:5: ( '<' )
		// InternalWeightDefinition.g:4942:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred33_InternalWeightDefinition

	// $ANTLR start synpred34_InternalWeightDefinition
	public final void synpred34_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4999:5: ( ( '(' ) )
		// InternalWeightDefinition.g:4999:6: ( '(' )
		{
		// InternalWeightDefinition.g:4999:6: ( '(' )
		// InternalWeightDefinition.g:5000:6: '('
		{
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred34_InternalWeightDefinition

	// $ANTLR start synpred35_InternalWeightDefinition
	public final void synpred35_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5018:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:5018:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:5018:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:5019:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:5019:7: ()
		// InternalWeightDefinition.g:5020:7: 
		{
		}

		// InternalWeightDefinition.g:5021:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt125=2;
		int LA125_0 = input.LA(1);
		if ( (LA125_0==RULE_ID||LA125_0==21||LA125_0==47) ) {
			alt125=1;
		}
		switch (alt125) {
			case 1 :
				// InternalWeightDefinition.g:5022:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:5022:8: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:5023:9: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:5023:9: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:5024:10: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_46);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:5027:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop124:
				while (true) {
					int alt124=2;
					int LA124_0 = input.LA(1);
					if ( (LA124_0==29) ) {
						alt124=1;
					}

					switch (alt124) {
					case 1 :
						// InternalWeightDefinition.g:5028:9: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_8); if (state.failed) return;
						// InternalWeightDefinition.g:5029:9: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:5030:10: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:5030:10: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:5031:11: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_46);
						ruleJvmFormalParameter();
						state._fsp--;
						if (state.failed) return;
						}

						}

						}
						break;

					default :
						break loop124;
					}
				}

				}
				break;

		}

		// InternalWeightDefinition.g:5036:7: ( ( '|' ) )
		// InternalWeightDefinition.g:5037:8: ( '|' )
		{
		// InternalWeightDefinition.g:5037:8: ( '|' )
		// InternalWeightDefinition.g:5038:9: '|'
		{
		match(input,86,FOLLOW_2); if (state.failed) return;
		}

		}

		}

		}

	}
	// $ANTLR end synpred35_InternalWeightDefinition

	// $ANTLR start synpred36_InternalWeightDefinition
	public final void synpred36_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5115:4: ( ( () '[' ) )
		// InternalWeightDefinition.g:5115:5: ( () '[' )
		{
		// InternalWeightDefinition.g:5115:5: ( () '[' )
		// InternalWeightDefinition.g:5116:5: () '['
		{
		// InternalWeightDefinition.g:5116:5: ()
		// InternalWeightDefinition.g:5117:5: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred36_InternalWeightDefinition

	// $ANTLR start synpred37_InternalWeightDefinition
	public final void synpred37_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5458:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
		// InternalWeightDefinition.g:
		{
		if ( (input.LA(1) >= RULE_DECIMAL && input.LA(1) <= RULE_INT)||input.LA(1)==RULE_STRING||input.LA(1)==13||input.LA(1)==16||input.LA(1)==21||input.LA(1)==26||input.LA(1)==30||input.LA(1)==42||input.LA(1)==53||input.LA(1)==59||(input.LA(1) >= 61 && input.LA(1) <= 63)||input.LA(1)==65||(input.LA(1) >= 67 && input.LA(1) <= 68)||(input.LA(1) >= 70 && input.LA(1) <= 72)||(input.LA(1) >= 74 && input.LA(1) <= 81)||(input.LA(1) >= 84 && input.LA(1) <= 85) ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}
		}

	}
	// $ANTLR end synpred37_InternalWeightDefinition

	// $ANTLR start synpred38_InternalWeightDefinition
	public final void synpred38_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5529:6: ( 'catch' )
		// InternalWeightDefinition.g:5529:7: 'catch'
		{
		match(input,57,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred38_InternalWeightDefinition

	// $ANTLR start synpred39_InternalWeightDefinition
	public final void synpred39_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5550:7: ( 'finally' )
		// InternalWeightDefinition.g:5550:8: 'finally'
		{
		match(input,64,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred39_InternalWeightDefinition

	// $ANTLR start synpred42_InternalWeightDefinition
	public final void synpred42_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5794:5: ( '.' )
		// InternalWeightDefinition.g:5794:6: '.'
		{
		match(input,34,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred42_InternalWeightDefinition

	// $ANTLR start synpred43_InternalWeightDefinition
	public final void synpred43_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5920:5: ( ( () ruleArrayBrackets ) )
		// InternalWeightDefinition.g:5920:6: ( () ruleArrayBrackets )
		{
		// InternalWeightDefinition.g:5920:6: ( () ruleArrayBrackets )
		// InternalWeightDefinition.g:5921:6: () ruleArrayBrackets
		{
		// InternalWeightDefinition.g:5921:6: ()
		// InternalWeightDefinition.g:5922:6: 
		{
		}

		pushFollow(FOLLOW_2);
		ruleArrayBrackets();
		state._fsp--;
		if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred43_InternalWeightDefinition

	// $ANTLR start synpred44_InternalWeightDefinition
	public final void synpred44_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:6117:5: ( '<' )
		// InternalWeightDefinition.g:6117:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred44_InternalWeightDefinition

	// $ANTLR start synpred45_InternalWeightDefinition
	public final void synpred45_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:6173:6: ( ( () '.' ) )
		// InternalWeightDefinition.g:6173:7: ( () '.' )
		{
		// InternalWeightDefinition.g:6173:7: ( () '.' )
		// InternalWeightDefinition.g:6174:7: () '.'
		{
		// InternalWeightDefinition.g:6174:7: ()
		// InternalWeightDefinition.g:6175:7: 
		{
		}

		match(input,34,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred45_InternalWeightDefinition

	// $ANTLR start synpred46_InternalWeightDefinition
	public final void synpred46_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:6211:7: ( '<' )
		// InternalWeightDefinition.g:6211:8: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred46_InternalWeightDefinition

	// Delegated rules

	public final boolean synpred21_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred21_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred34_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred34_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred20_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred20_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred10_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred10_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred35_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred35_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred19_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred19_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred23_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred23_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred11_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred11_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred31_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred31_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred37_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred37_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred36_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred36_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred12_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred12_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred30_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred30_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred38_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred38_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred42_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred42_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred6_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred6_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred13_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred13_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred25_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred25_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred14_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred14_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred8_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred8_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred39_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred39_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred9_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred26_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred26_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred43_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred43_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred15_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred15_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred27_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred27_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred44_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred44_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred16_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred16_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred32_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred32_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred18_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred18_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred45_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred45_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred46_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred46_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred29_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred29_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred33_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred33_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred17_InternalWeightDefinition() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred17_InternalWeightDefinition_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA35 dfa35 = new DFA35(this);
	protected DFA36 dfa36 = new DFA36(this);
	protected DFA76 dfa76 = new DFA76(this);
	protected DFA77 dfa77 = new DFA77(this);
	protected DFA81 dfa81 = new DFA81(this);
	protected DFA84 dfa84 = new DFA84(this);
	protected DFA85 dfa85 = new DFA85(this);
	protected DFA88 dfa88 = new DFA88(this);
	protected DFA106 dfa106 = new DFA106(this);
	protected DFA104 dfa104 = new DFA104(this);
	protected DFA113 dfa113 = new DFA113(this);
	static final String dfa_1s = "\116\uffff";
	static final String dfa_2s = "\1\2\115\uffff";
	static final String dfa_3s = "\1\5\1\0\114\uffff";
	static final String dfa_4s = "\1\130\1\0\114\uffff";
	static final String dfa_5s = "\2\uffff\1\2\112\uffff\1\1";
	static final String dfa_6s = "\1\uffff\1\0\114\uffff}>";
	static final String[] dfa_7s = {
			"\4\2\2\uffff\1\2\1\uffff\7\2\1\uffff\1\1\26\2\1\uffff\5\2\1\uffff\17\2\1\uffff\6\2\1\uffff\14\2\1\uffff\2\2",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
	static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
	static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
	static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
	static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
	static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
	static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

	protected class DFA35 extends DFA {

		public DFA35(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 35;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_7;
		}
		@Override
		public String getDescription() {
			return "2346:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA35_1 = input.LA(1);
						 
						int index35_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred16_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index35_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 35, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_8s = {
			"\4\2\2\uffff\1\2\1\uffff\7\2\1\uffff\27\2\1\uffff\5\2\1\uffff\2\2\1\1\14\2\1\uffff\6\2\1\uffff\14\2\1\uffff\2\2",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final short[][] dfa_8 = unpackEncodedStringArray(dfa_8s);

	protected class DFA36 extends DFA {

		public DFA36(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 36;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_8;
		}
		@Override
		public String getDescription() {
			return "2463:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA36_1 = input.LA(1);
						 
						int index36_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred18_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index36_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 36, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA76 extends DFA {

		public DFA76(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 76;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_7;
		}
		@Override
		public String getDescription() {
			return "4664:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA76_1 = input.LA(1);
						 
						int index76_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred30_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index76_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 76, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA77 extends DFA {

		public DFA77(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 77;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_8;
		}
		@Override
		public String getDescription() {
			return "4781:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA77_1 = input.LA(1);
						 
						int index77_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred32_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index77_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 77, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String[] dfa_9s = {
			"\4\2\2\uffff\1\2\1\uffff\7\2\1\uffff\25\2\1\1\1\2\1\uffff\5\2\1\uffff\17\2\1\uffff\6\2\1\uffff\14\2\1\uffff\2\2",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final short[][] dfa_9 = unpackEncodedStringArray(dfa_9s);

	protected class DFA81 extends DFA {

		public DFA81(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 81;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_9;
		}
		@Override
		public String getDescription() {
			return "4940:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA81_1 = input.LA(1);
						 
						int index81_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred33_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index81_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 81, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA84 extends DFA {

		public DFA84(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 84;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_7;
		}
		@Override
		public String getDescription() {
			return "4997:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA84_1 = input.LA(1);
						 
						int index84_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred34_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index84_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 84, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA85 extends DFA {

		public DFA85(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 85;
			this.eot = dfa_1;
			this.eof = dfa_2;
			this.min = dfa_3;
			this.max = dfa_4;
			this.accept = dfa_5;
			this.special = dfa_6;
			this.transition = dfa_8;
		}
		@Override
		public String getDescription() {
			return "5114:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA85_1 = input.LA(1);
						 
						int index85_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred36_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index85_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 85, _s, input);
			error(nvae);
			throw nvae;
		}
	}
	static final String dfa_10s = "\1\41\115\uffff";
	static final String dfa_11s = "\1\5\40\0\55\uffff";
	static final String dfa_12s = "\1\130\40\0\55\uffff";
	static final String dfa_13s = "\41\uffff\1\2\53\uffff\1\1";
	static final String dfa_14s = "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\55\uffff}>";
	static final String[] dfa_15s = {
			"\1\25\1\23\1\1\1\24\2\uffff\1\27\1\uffff\1\6\2\41\1\17\3\41\1\uffff\1\40\4\41\1\10\3\41\1\7\13\41\1\15\1\41\1\uffff\5\41\1\uffff\2\41\1\20\5\41\1\34\1\41\1\2\1\5\1\21\1\41\1\32\1\uffff\1\31\1\4\1\41\1\11\1\26\1\36\1\uffff\1\3\1\16\1\13\1\14\1\35\1\22\1\37\1\30\2\41\1\33\1\12\1\uffff\2\41",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};
	static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
	static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
	static final char[] dfa_12 = DFA.unpackEncodedStringToUnsignedChars(dfa_12s);
	static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
	static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
	static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

	protected class DFA88 extends DFA {

		public DFA88(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 88;
			this.eot = dfa_1;
			this.eof = dfa_10;
			this.min = dfa_11;
			this.max = dfa_12;
			this.accept = dfa_13;
			this.special = dfa_14;
			this.transition = dfa_15;
		}
		@Override
		public String getDescription() {
			return "5457:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA88_1 = input.LA(1);
						 
						int index88_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_1);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA88_2 = input.LA(1);
						 
						int index88_2 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_2);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA88_3 = input.LA(1);
						 
						int index88_3 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_3);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA88_4 = input.LA(1);
						 
						int index88_4 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_4);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA88_5 = input.LA(1);
						 
						int index88_5 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_5);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA88_6 = input.LA(1);
						 
						int index88_6 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_6);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA88_7 = input.LA(1);
						 
						int index88_7 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_7);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA88_8 = input.LA(1);
						 
						int index88_8 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_8);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA88_9 = input.LA(1);
						 
						int index88_9 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_9);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA88_10 = input.LA(1);
						 
						int index88_10 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_10);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA88_11 = input.LA(1);
						 
						int index88_11 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_11);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA88_12 = input.LA(1);
						 
						int index88_12 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_12);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA88_13 = input.LA(1);
						 
						int index88_13 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_13);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA88_14 = input.LA(1);
						 
						int index88_14 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_14);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA88_15 = input.LA(1);
						 
						int index88_15 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_15);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA88_16 = input.LA(1);
						 
						int index88_16 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_16);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA88_17 = input.LA(1);
						 
						int index88_17 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_17);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA88_18 = input.LA(1);
						 
						int index88_18 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_18);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA88_19 = input.LA(1);
						 
						int index88_19 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_19);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA88_20 = input.LA(1);
						 
						int index88_20 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_20);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA88_21 = input.LA(1);
						 
						int index88_21 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_21);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA88_22 = input.LA(1);
						 
						int index88_22 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_22);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA88_23 = input.LA(1);
						 
						int index88_23 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_23);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA88_24 = input.LA(1);
						 
						int index88_24 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_24);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA88_25 = input.LA(1);
						 
						int index88_25 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_25);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA88_26 = input.LA(1);
						 
						int index88_26 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_26);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA88_27 = input.LA(1);
						 
						int index88_27 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_27);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA88_28 = input.LA(1);
						 
						int index88_28 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_28);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA88_29 = input.LA(1);
						 
						int index88_29 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_29);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA88_30 = input.LA(1);
						 
						int index88_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_30);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA88_31 = input.LA(1);
						 
						int index88_31 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_31);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA88_32 = input.LA(1);
						 
						int index88_32 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index88_32);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 88, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String dfa_16s = "\117\uffff";
	static final String dfa_17s = "\1\2\116\uffff";
	static final String dfa_18s = "\1\5\1\0\115\uffff";
	static final String dfa_19s = "\1\130\1\0\115\uffff";
	static final String dfa_20s = "\2\uffff\1\2\113\uffff\1\1";
	static final String dfa_21s = "\1\uffff\1\0\115\uffff}>";
	static final String[] dfa_22s = {
			"\4\2\2\uffff\1\2\1\uffff\35\2\1\1\1\2\1\uffff\5\2\1\uffff\17\2\1\uffff\6\2\1\uffff\14\2\1\uffff\2\2",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
	static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
	static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
	static final char[] dfa_19 = DFA.unpackEncodedStringToUnsignedChars(dfa_19s);
	static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
	static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
	static final short[][] dfa_22 = unpackEncodedStringArray(dfa_22s);

	protected class DFA106 extends DFA {

		public DFA106(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 106;
			this.eot = dfa_16;
			this.eof = dfa_17;
			this.min = dfa_18;
			this.max = dfa_19;
			this.accept = dfa_20;
			this.special = dfa_21;
			this.transition = dfa_22;
		}
		@Override
		public String getDescription() {
			return "6115:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA106_1 = input.LA(1);
						 
						int index106_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred44_InternalWeightDefinition()) ) {s = 78;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index106_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 106, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA104 extends DFA {

		public DFA104(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 104;
			this.eot = dfa_16;
			this.eof = dfa_17;
			this.min = dfa_18;
			this.max = dfa_19;
			this.accept = dfa_20;
			this.special = dfa_21;
			this.transition = dfa_22;
		}
		@Override
		public String getDescription() {
			return "6209:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA104_1 = input.LA(1);
						 
						int index104_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred46_InternalWeightDefinition()) ) {s = 78;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index104_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 104, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String dfa_23s = "\7\uffff";
	static final String dfa_24s = "\2\uffff\1\4\2\uffff\1\4\1\uffff";
	static final String dfa_25s = "\1\7\1\uffff\1\42\1\7\1\uffff\1\42\1\uffff";
	static final String dfa_26s = "\1\112\1\uffff\1\51\1\27\1\uffff\1\51\1\uffff";
	static final String dfa_27s = "\1\uffff\1\1\2\uffff\1\2\1\uffff\1\3";
	static final String dfa_28s = "\7\uffff}>";
	static final String[] dfa_29s = {
			"\1\2\102\uffff\1\1",
			"",
			"\1\3\6\uffff\1\4",
			"\1\5\17\uffff\1\6",
			"",
			"\1\3\6\uffff\1\4",
			""
	};

	static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
	static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
	static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
	static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
	static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
	static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
	static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

	protected class DFA113 extends DFA {

		public DFA113(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 113;
			this.eot = dfa_23;
			this.eof = dfa_24;
			this.min = dfa_25;
			this.max = dfa_26;
			this.accept = dfa_27;
			this.special = dfa_28;
			this.transition = dfa_29;
		}
		@Override
		public String getDescription() {
			return "6671:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
		}
	}

	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000204L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000800000200080L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000800000600080L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000020400000L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_13 = new BitSet(new long[]{0xE8200400442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0001044112040002L});
	public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0003000000000000L});
	public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
	public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x000060000000C002L});
	public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0003040000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00118C1A00000002L});
	public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000840000000000L});
	public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000044000002L});
	public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000002001820002L});
	public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000088000002L});
	public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0008010400000002L});
	public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x6000000000000080L,0x0000000000000410L});
	public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x6000040000000080L,0x0000000000000C10L});
	public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0004800000200080L});
	public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001000020000000L});
	public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x6000000000000080L,0x0000000000000C10L});
	public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0028010400200002L});
	public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xE8208400446129E0L,0x000000000073FDDAL});
	public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0028010400000002L});
	public static final BitSet FOLLOW_40 = new BitSet(new long[]{0xE8200400442129E0L,0x000000000133FDDAL});
	public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000020000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_43 = new BitSet(new long[]{0xE8600400442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0040000020000000L});
	public static final BitSet FOLLOW_45 = new BitSet(new long[]{0xE8608400442129E0L,0x00000000007FFDDAL});
	public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000020000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_47 = new BitSet(new long[]{0xE8600400442129E0L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xE8200600442129E2L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_50 = new BitSet(new long[]{0xE8200400442129E2L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_52 = new BitSet(new long[]{0xE8208400442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0500808020200080L,0x0000000001000000L});
	public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0100008020000000L});
	public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000008020000000L});
	public static final BitSet FOLLOW_58 = new BitSet(new long[]{0xE8200600442129E0L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000020020000000L});
	public static final BitSet FOLLOW_60 = new BitSet(new long[]{0xE8200400442129E0L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_61 = new BitSet(new long[]{0xE8200600442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_63 = new BitSet(new long[]{0xE8200400446129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_65 = new BitSet(new long[]{0xE8200400442129E0L,0x00000000013FFDDAL});
	public static final BitSet FOLLOW_66 = new BitSet(new long[]{0xE8200600442129E0L,0x00000000013FFDDAL});
	public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0020000000200002L});
	public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0020040000200002L});
	public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0020000000400000L});
	public static final BitSet FOLLOW_72 = new BitSet(new long[]{0xE8200400442129E2L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000120L});
	public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000040400000002L});
	public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000080L,0x0000000000000400L});
	public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x4000000000000080L});
	public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000800080L});
	public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000082L});
}
