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
	// InternalWeightDefinition.g:71:1: ruleWeightDefinitionFile returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) ) ( ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) ) | ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) ) | ( (lv_helperFuntions_3_0= ruleHelperFuntion ) ) )* ) ;
	public final EObject ruleWeightDefinitionFile() throws RecognitionException {
		EObject current = null;


		EObject lv_imports_0_0 =null;
		EObject lv_weigthDefinitions_1_0 =null;
		EObject lv_defaultCalc_2_0 =null;
		EObject lv_helperFuntions_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:77:2: ( ( ( (lv_imports_0_0= ruleImport ) ) ( ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) ) | ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) ) | ( (lv_helperFuntions_3_0= ruleHelperFuntion ) ) )* ) )
			// InternalWeightDefinition.g:78:2: ( ( (lv_imports_0_0= ruleImport ) ) ( ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) ) | ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) ) | ( (lv_helperFuntions_3_0= ruleHelperFuntion ) ) )* )
			{
			// InternalWeightDefinition.g:78:2: ( ( (lv_imports_0_0= ruleImport ) ) ( ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) ) | ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) ) | ( (lv_helperFuntions_3_0= ruleHelperFuntion ) ) )* )
			// InternalWeightDefinition.g:79:3: ( (lv_imports_0_0= ruleImport ) ) ( ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) ) | ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) ) | ( (lv_helperFuntions_3_0= ruleHelperFuntion ) ) )*
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

			// InternalWeightDefinition.g:98:3: ( ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) ) | ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) ) | ( (lv_helperFuntions_3_0= ruleHelperFuntion ) ) )*
			loop1:
			while (true) {
				int alt1=4;
				switch ( input.LA(1) ) {
				case 73:
					{
					alt1=1;
					}
					break;
				case 58:
					{
					alt1=2;
					}
					break;
				case 66:
					{
					alt1=3;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// InternalWeightDefinition.g:99:4: ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )
					{
					// InternalWeightDefinition.g:99:4: ( (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition ) )
					// InternalWeightDefinition.g:100:5: (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition )
					{
					// InternalWeightDefinition.g:100:5: (lv_weigthDefinitions_1_0= ruleRuleWeightDefinition )
					// InternalWeightDefinition.g:101:6: lv_weigthDefinitions_1_0= ruleRuleWeightDefinition
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getWeightDefinitionFileAccess().getWeigthDefinitionsRuleWeightDefinitionParserRuleCall_1_0_0());
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

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:119:4: ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) )
					{
					// InternalWeightDefinition.g:119:4: ( (lv_defaultCalc_2_0= ruleDefaultCalculation ) )
					// InternalWeightDefinition.g:120:5: (lv_defaultCalc_2_0= ruleDefaultCalculation )
					{
					// InternalWeightDefinition.g:120:5: (lv_defaultCalc_2_0= ruleDefaultCalculation )
					// InternalWeightDefinition.g:121:6: lv_defaultCalc_2_0= ruleDefaultCalculation
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getWeightDefinitionFileAccess().getDefaultCalcDefaultCalculationParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_3);
					lv_defaultCalc_2_0=ruleDefaultCalculation();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElementForParent(grammarAccess.getWeightDefinitionFileRule());
											}
											add(
												current,
												"defaultCalc",
												lv_defaultCalc_2_0,
												"org.emoflon.ibex.tgg.weights.WeightDefinition.DefaultCalculation");
											afterParserOrEnumRuleCall();
										}
					}

					}

					}
					break;
				case 3 :
					// InternalWeightDefinition.g:139:4: ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )
					{
					// InternalWeightDefinition.g:139:4: ( (lv_helperFuntions_3_0= ruleHelperFuntion ) )
					// InternalWeightDefinition.g:140:5: (lv_helperFuntions_3_0= ruleHelperFuntion )
					{
					// InternalWeightDefinition.g:140:5: (lv_helperFuntions_3_0= ruleHelperFuntion )
					// InternalWeightDefinition.g:141:6: lv_helperFuntions_3_0= ruleHelperFuntion
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getWeightDefinitionFileAccess().getHelperFuntionsHelperFuntionParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_3);
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

					}
					break;

				default :
					break loop1;
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
	// InternalWeightDefinition.g:163:1: entryRuleImport returns [EObject current=null] :iv_ruleImport= ruleImport EOF ;
	public final EObject entryRuleImport() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleImport =null;

		try {
			// InternalWeightDefinition.g:163:47: (iv_ruleImport= ruleImport EOF )
			// InternalWeightDefinition.g:164:2: iv_ruleImport= ruleImport EOF
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
	// InternalWeightDefinition.g:170:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
	public final EObject ruleImport() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token lv_importURI_1_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:176:2: ( (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
			// InternalWeightDefinition.g:177:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
			{
			// InternalWeightDefinition.g:177:2: (otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
			// InternalWeightDefinition.g:178:3: otherlv_0= 'import' ( (lv_importURI_1_0= RULE_STRING ) )
			{
			otherlv_0=(Token)match(input,68,FOLLOW_4); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
					}
			// InternalWeightDefinition.g:182:3: ( (lv_importURI_1_0= RULE_STRING ) )
			// InternalWeightDefinition.g:183:4: (lv_importURI_1_0= RULE_STRING )
			{
			// InternalWeightDefinition.g:183:4: (lv_importURI_1_0= RULE_STRING )
			// InternalWeightDefinition.g:184:5: lv_importURI_1_0= RULE_STRING
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
	// InternalWeightDefinition.g:204:1: entryRuleRuleWeightDefinition returns [EObject current=null] :iv_ruleRuleWeightDefinition= ruleRuleWeightDefinition EOF ;
	public final EObject entryRuleRuleWeightDefinition() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleRuleWeightDefinition =null;

		try {
			// InternalWeightDefinition.g:204:61: (iv_ruleRuleWeightDefinition= ruleRuleWeightDefinition EOF )
			// InternalWeightDefinition.g:205:2: iv_ruleRuleWeightDefinition= ruleRuleWeightDefinition EOF
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
	// InternalWeightDefinition.g:211:1: ruleRuleWeightDefinition returns [EObject current=null] : ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) ) ;
	public final EObject ruleRuleWeightDefinition() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		EObject lv_weightCalc_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:217:2: ( ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) ) )
			// InternalWeightDefinition.g:218:2: ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) )
			{
			// InternalWeightDefinition.g:218:2: ( () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) ) )
			// InternalWeightDefinition.g:219:3: () otherlv_1= 'rule' ( (otherlv_2= RULE_ID ) ) ( (lv_weightCalc_3_0= ruleWeightCalculation ) )
			{
			// InternalWeightDefinition.g:219:3: ()
			// InternalWeightDefinition.g:220:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getRuleWeightDefinitionAccess().getRuleWeightDefinitionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,73,FOLLOW_5); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getRuleWeightDefinitionAccess().getRuleKeyword_1());
					}
			// InternalWeightDefinition.g:230:3: ( (otherlv_2= RULE_ID ) )
			// InternalWeightDefinition.g:231:4: (otherlv_2= RULE_ID )
			{
			// InternalWeightDefinition.g:231:4: (otherlv_2= RULE_ID )
			// InternalWeightDefinition.g:232:5: otherlv_2= RULE_ID
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getRuleWeightDefinitionRule());
								}
							}
			otherlv_2=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getRuleWeightDefinitionAccess().getRuleTGGRuleCrossReference_2_0());
							}
			}

			}

			// InternalWeightDefinition.g:243:3: ( (lv_weightCalc_3_0= ruleWeightCalculation ) )
			// InternalWeightDefinition.g:244:4: (lv_weightCalc_3_0= ruleWeightCalculation )
			{
			// InternalWeightDefinition.g:244:4: (lv_weightCalc_3_0= ruleWeightCalculation )
			// InternalWeightDefinition.g:245:5: lv_weightCalc_3_0= ruleWeightCalculation
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
	// InternalWeightDefinition.g:266:1: entryRuleWeightCalculation returns [EObject current=null] :iv_ruleWeightCalculation= ruleWeightCalculation EOF ;
	public final EObject entryRuleWeightCalculation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleWeightCalculation =null;

		try {
			// InternalWeightDefinition.g:266:58: (iv_ruleWeightCalculation= ruleWeightCalculation EOF )
			// InternalWeightDefinition.g:267:2: iv_ruleWeightCalculation= ruleWeightCalculation EOF
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
	// InternalWeightDefinition.g:273:1: ruleWeightCalculation returns [EObject current=null] : ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleWeightCalculation() throws RecognitionException {
		EObject current = null;


		EObject lv_calc_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:279:2: ( ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) ) )
			// InternalWeightDefinition.g:280:2: ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) )
			{
			// InternalWeightDefinition.g:280:2: ( () ( (lv_calc_1_0= ruleXBlockExpression ) ) )
			// InternalWeightDefinition.g:281:3: () ( (lv_calc_1_0= ruleXBlockExpression ) )
			{
			// InternalWeightDefinition.g:281:3: ()
			// InternalWeightDefinition.g:282:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getWeightCalculationAccess().getWeightCalculationAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:288:3: ( (lv_calc_1_0= ruleXBlockExpression ) )
			// InternalWeightDefinition.g:289:4: (lv_calc_1_0= ruleXBlockExpression )
			{
			// InternalWeightDefinition.g:289:4: (lv_calc_1_0= ruleXBlockExpression )
			// InternalWeightDefinition.g:290:5: lv_calc_1_0= ruleXBlockExpression
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
	// InternalWeightDefinition.g:311:1: entryRuleDefaultCalculation returns [EObject current=null] :iv_ruleDefaultCalculation= ruleDefaultCalculation EOF ;
	public final EObject entryRuleDefaultCalculation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleDefaultCalculation =null;

		try {
			// InternalWeightDefinition.g:311:59: (iv_ruleDefaultCalculation= ruleDefaultCalculation EOF )
			// InternalWeightDefinition.g:312:2: iv_ruleDefaultCalculation= ruleDefaultCalculation EOF
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
	// InternalWeightDefinition.g:318:1: ruleDefaultCalculation returns [EObject current=null] : ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) ) ;
	public final EObject ruleDefaultCalculation() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_calc_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:324:2: ( ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) ) )
			// InternalWeightDefinition.g:325:2: ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) )
			{
			// InternalWeightDefinition.g:325:2: ( () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) ) )
			// InternalWeightDefinition.g:326:3: () otherlv_1= 'default' ( (lv_calc_2_0= ruleXBlockExpression ) )
			{
			// InternalWeightDefinition.g:326:3: ()
			// InternalWeightDefinition.g:327:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getDefaultCalculationAccess().getDefaultCalculationAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,58,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getDefaultCalculationAccess().getDefaultKeyword_1());
					}
			// InternalWeightDefinition.g:337:3: ( (lv_calc_2_0= ruleXBlockExpression ) )
			// InternalWeightDefinition.g:338:4: (lv_calc_2_0= ruleXBlockExpression )
			{
			// InternalWeightDefinition.g:338:4: (lv_calc_2_0= ruleXBlockExpression )
			// InternalWeightDefinition.g:339:5: lv_calc_2_0= ruleXBlockExpression
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
	// InternalWeightDefinition.g:360:1: entryRuleHelperFuntion returns [EObject current=null] :iv_ruleHelperFuntion= ruleHelperFuntion EOF ;
	public final EObject entryRuleHelperFuntion() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleHelperFuntion =null;

		try {
			// InternalWeightDefinition.g:360:54: (iv_ruleHelperFuntion= ruleHelperFuntion EOF )
			// InternalWeightDefinition.g:361:2: iv_ruleHelperFuntion= ruleHelperFuntion EOF
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
	// InternalWeightDefinition.g:367:1: ruleHelperFuntion returns [EObject current=null] : ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) ) ;
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
			// InternalWeightDefinition.g:373:2: ( ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) ) )
			// InternalWeightDefinition.g:374:2: ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) )
			{
			// InternalWeightDefinition.g:374:2: ( () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) ) )
			// InternalWeightDefinition.g:375:3: () otherlv_1= 'function' ( (lv_returnType_2_0= ruleJvmTypeReference ) ) ( (lv_name_3_0= ruleValidID ) ) otherlv_4= '(' ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )? otherlv_8= ')' ( (lv_body_9_0= ruleXBlockExpression ) )
			{
			// InternalWeightDefinition.g:375:3: ()
			// InternalWeightDefinition.g:376:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getHelperFuntionAccess().getHelperFunctionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,66,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getHelperFuntionAccess().getFunctionKeyword_1());
					}
			// InternalWeightDefinition.g:386:3: ( (lv_returnType_2_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:387:4: (lv_returnType_2_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:387:4: (lv_returnType_2_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:388:5: lv_returnType_2_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuntionAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_5);
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

			// InternalWeightDefinition.g:405:3: ( (lv_name_3_0= ruleValidID ) )
			// InternalWeightDefinition.g:406:4: (lv_name_3_0= ruleValidID )
			{
			// InternalWeightDefinition.g:406:4: (lv_name_3_0= ruleValidID )
			// InternalWeightDefinition.g:407:5: lv_name_3_0= ruleValidID
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuntionAccess().getNameValidIDParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_8);
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

			otherlv_4=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getHelperFuntionAccess().getLeftParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:428:3: ( ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )* )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==RULE_ID||LA3_0==21||LA3_0==47) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// InternalWeightDefinition.g:429:4: ( (lv_params_5_0= ruleHelperFuncParameter ) ) (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )*
					{
					// InternalWeightDefinition.g:429:4: ( (lv_params_5_0= ruleHelperFuncParameter ) )
					// InternalWeightDefinition.g:430:5: (lv_params_5_0= ruleHelperFuncParameter )
					{
					// InternalWeightDefinition.g:430:5: (lv_params_5_0= ruleHelperFuncParameter )
					// InternalWeightDefinition.g:431:6: lv_params_5_0= ruleHelperFuncParameter
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getHelperFuntionAccess().getParamsHelperFuncParameterParserRuleCall_5_0_0());
										}
					pushFollow(FOLLOW_10);
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

					// InternalWeightDefinition.g:448:4: (otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) ) )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==29) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// InternalWeightDefinition.g:449:5: otherlv_6= ',' ( (lv_params_7_0= ruleHelperFuncParameter ) )
							{
							otherlv_6=(Token)match(input,29,FOLLOW_7); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_6, grammarAccess.getHelperFuntionAccess().getCommaKeyword_5_1_0());
											}
							// InternalWeightDefinition.g:453:5: ( (lv_params_7_0= ruleHelperFuncParameter ) )
							// InternalWeightDefinition.g:454:6: (lv_params_7_0= ruleHelperFuncParameter )
							{
							// InternalWeightDefinition.g:454:6: (lv_params_7_0= ruleHelperFuncParameter )
							// InternalWeightDefinition.g:455:7: lv_params_7_0= ruleHelperFuncParameter
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getHelperFuntionAccess().getParamsHelperFuncParameterParserRuleCall_5_1_1_0());
													}
							pushFollow(FOLLOW_10);
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
							break loop2;
						}
					}

					}
					break;

			}

			otherlv_8=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getHelperFuntionAccess().getRightParenthesisKeyword_6());
					}
			// InternalWeightDefinition.g:478:3: ( (lv_body_9_0= ruleXBlockExpression ) )
			// InternalWeightDefinition.g:479:4: (lv_body_9_0= ruleXBlockExpression )
			{
			// InternalWeightDefinition.g:479:4: (lv_body_9_0= ruleXBlockExpression )
			// InternalWeightDefinition.g:480:5: lv_body_9_0= ruleXBlockExpression
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
	// InternalWeightDefinition.g:501:1: entryRuleHelperFuncParameter returns [EObject current=null] :iv_ruleHelperFuncParameter= ruleHelperFuncParameter EOF ;
	public final EObject entryRuleHelperFuncParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleHelperFuncParameter =null;

		try {
			// InternalWeightDefinition.g:501:60: (iv_ruleHelperFuncParameter= ruleHelperFuncParameter EOF )
			// InternalWeightDefinition.g:502:2: iv_ruleHelperFuncParameter= ruleHelperFuncParameter EOF
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
	// InternalWeightDefinition.g:508:1: ruleHelperFuncParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleHelperFuncParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:514:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalWeightDefinition.g:515:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalWeightDefinition.g:515:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			// InternalWeightDefinition.g:516:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalWeightDefinition.g:516:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:517:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:517:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:518:5: lv_parameterType_0_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getHelperFuncParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
							}
			pushFollow(FOLLOW_5);
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

			// InternalWeightDefinition.g:535:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalWeightDefinition.g:536:4: (lv_name_1_0= ruleValidID )
			{
			// InternalWeightDefinition.g:536:4: (lv_name_1_0= ruleValidID )
			// InternalWeightDefinition.g:537:5: lv_name_1_0= ruleValidID
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
	// InternalWeightDefinition.g:558:1: entryRuleXExpression returns [EObject current=null] :iv_ruleXExpression= ruleXExpression EOF ;
	public final EObject entryRuleXExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpression =null;

		try {
			// InternalWeightDefinition.g:558:52: (iv_ruleXExpression= ruleXExpression EOF )
			// InternalWeightDefinition.g:559:2: iv_ruleXExpression= ruleXExpression EOF
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
	// InternalWeightDefinition.g:565:1: ruleXExpression returns [EObject current=null] :this_XAssignment_0= ruleXAssignment ;
	public final EObject ruleXExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAssignment_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:571:2: (this_XAssignment_0= ruleXAssignment )
			// InternalWeightDefinition.g:572:2: this_XAssignment_0= ruleXAssignment
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
	// InternalWeightDefinition.g:583:1: entryRuleXAssignment returns [EObject current=null] :iv_ruleXAssignment= ruleXAssignment EOF ;
	public final EObject entryRuleXAssignment() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAssignment =null;

		try {
			// InternalWeightDefinition.g:583:52: (iv_ruleXAssignment= ruleXAssignment EOF )
			// InternalWeightDefinition.g:584:2: iv_ruleXAssignment= ruleXAssignment EOF
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
	// InternalWeightDefinition.g:590:1: ruleXAssignment returns [EObject current=null] : ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) ;
	public final EObject ruleXAssignment() throws RecognitionException {
		EObject current = null;


		EObject lv_value_3_0 =null;
		EObject this_XOrExpression_4 =null;
		EObject lv_rightOperand_7_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:596:2: ( ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) ) )
			// InternalWeightDefinition.g:597:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
			{
			// InternalWeightDefinition.g:597:2: ( ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) ) | (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? ) )
			int alt5=2;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				int LA5_1 = input.LA(2);
				if ( (LA5_1==44) ) {
					alt5=1;
				}
				else if ( (LA5_1==EOF||(LA5_1 >= RULE_DECIMAL && LA5_1 <= RULE_INT)||LA5_1==RULE_STRING||(LA5_1 >= 13 && LA5_1 <= 19)||(LA5_1 >= 21 && LA5_1 <= 43)||(LA5_1 >= 45 && LA5_1 <= 49)||(LA5_1 >= 51 && LA5_1 <= 65)||(LA5_1 >= 67 && LA5_1 <= 72)||(LA5_1 >= 74 && LA5_1 <= 85)||(LA5_1 >= 87 && LA5_1 <= 88)) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 61:
				{
				int LA5_2 = input.LA(2);
				if ( (LA5_2==44) ) {
					alt5=1;
				}
				else if ( (LA5_2==EOF||(LA5_2 >= RULE_DECIMAL && LA5_2 <= RULE_INT)||LA5_2==RULE_STRING||(LA5_2 >= 13 && LA5_2 <= 19)||(LA5_2 >= 21 && LA5_2 <= 43)||(LA5_2 >= 45 && LA5_2 <= 49)||(LA5_2 >= 51 && LA5_2 <= 65)||(LA5_2 >= 67 && LA5_2 <= 72)||(LA5_2 >= 74 && LA5_2 <= 85)||(LA5_2 >= 87 && LA5_2 <= 88)) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 74:
				{
				int LA5_3 = input.LA(2);
				if ( (LA5_3==44) ) {
					alt5=1;
				}
				else if ( (LA5_3==EOF||(LA5_3 >= RULE_DECIMAL && LA5_3 <= RULE_INT)||LA5_3==RULE_STRING||(LA5_3 >= 13 && LA5_3 <= 19)||(LA5_3 >= 21 && LA5_3 <= 43)||(LA5_3 >= 45 && LA5_3 <= 49)||(LA5_3 >= 51 && LA5_3 <= 65)||(LA5_3 >= 67 && LA5_3 <= 72)||(LA5_3 >= 74 && LA5_3 <= 85)||(LA5_3 >= 87 && LA5_3 <= 88)) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 68:
				{
				int LA5_4 = input.LA(2);
				if ( (LA5_4==44) ) {
					alt5=1;
				}
				else if ( (LA5_4==EOF||(LA5_4 >= RULE_DECIMAL && LA5_4 <= RULE_INT)||LA5_4==RULE_STRING||(LA5_4 >= 13 && LA5_4 <= 19)||(LA5_4 >= 21 && LA5_4 <= 43)||(LA5_4 >= 45 && LA5_4 <= 49)||(LA5_4 >= 51 && LA5_4 <= 65)||(LA5_4 >= 67 && LA5_4 <= 72)||(LA5_4 >= 74 && LA5_4 <= 85)||(LA5_4 >= 87 && LA5_4 <= 88)) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 62:
				{
				int LA5_5 = input.LA(2);
				if ( (LA5_5==44) ) {
					alt5=1;
				}
				else if ( (LA5_5==EOF||(LA5_5 >= RULE_DECIMAL && LA5_5 <= RULE_INT)||LA5_5==RULE_STRING||(LA5_5 >= 13 && LA5_5 <= 19)||(LA5_5 >= 21 && LA5_5 <= 43)||(LA5_5 >= 45 && LA5_5 <= 49)||(LA5_5 >= 51 && LA5_5 <= 65)||(LA5_5 >= 67 && LA5_5 <= 72)||(LA5_5 >= 74 && LA5_5 <= 85)||(LA5_5 >= 87 && LA5_5 <= 88)) ) {
					alt5=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 5, input);
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
				alt5=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// InternalWeightDefinition.g:598:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
					{
					// InternalWeightDefinition.g:598:3: ( () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) ) )
					// InternalWeightDefinition.g:599:4: () ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ( (lv_value_3_0= ruleXAssignment ) )
					{
					// InternalWeightDefinition.g:599:4: ()
					// InternalWeightDefinition.g:600:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXAssignmentAccess().getXAssignmentAction_0_0(),
											current);
									}
					}

					// InternalWeightDefinition.g:606:4: ( ( ruleFeatureCallID ) )
					// InternalWeightDefinition.g:607:5: ( ruleFeatureCallID )
					{
					// InternalWeightDefinition.g:607:5: ( ruleFeatureCallID )
					// InternalWeightDefinition.g:608:6: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXAssignmentRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
										}
					pushFollow(FOLLOW_11);
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
					pushFollow(FOLLOW_12);
					ruleOpSingleAssign();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									afterParserOrEnumRuleCall();
								}
					// InternalWeightDefinition.g:629:4: ( (lv_value_3_0= ruleXAssignment ) )
					// InternalWeightDefinition.g:630:5: (lv_value_3_0= ruleXAssignment )
					{
					// InternalWeightDefinition.g:630:5: (lv_value_3_0= ruleXAssignment )
					// InternalWeightDefinition.g:631:6: lv_value_3_0= ruleXAssignment
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
					// InternalWeightDefinition.g:650:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
					{
					// InternalWeightDefinition.g:650:3: (this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )? )
					// InternalWeightDefinition.g:651:4: this_XOrExpression_4= ruleXOrExpression ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getXAssignmentAccess().getXOrExpressionParserRuleCall_1_0());
								}
					pushFollow(FOLLOW_13);
					this_XOrExpression_4=ruleXOrExpression();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_XOrExpression_4;
									afterParserOrEnumRuleCall();
								}
					// InternalWeightDefinition.g:659:4: ( ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) ) )?
					int alt4=2;
					switch ( input.LA(1) ) {
						case 28:
							{
							int LA4_1 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt4=1;
							}
							}
							break;
						case 32:
							{
							int LA4_2 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt4=1;
							}
							}
							break;
						case 25:
							{
							int LA4_3 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt4=1;
							}
							}
							break;
						case 38:
							{
							int LA4_4 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt4=1;
							}
							}
							break;
						case 18:
							{
							int LA4_5 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt4=1;
							}
							}
							break;
						case 42:
							{
							int LA4_6 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt4=1;
							}
							}
							break;
						case 48:
							{
							int LA4_7 = input.LA(2);
							if ( (synpred1_InternalWeightDefinition()) ) {
								alt4=1;
							}
							}
							break;
					}
					switch (alt4) {
						case 1 :
							// InternalWeightDefinition.g:660:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) ) ( (lv_rightOperand_7_0= ruleXAssignment ) )
							{
							// InternalWeightDefinition.g:660:5: ( ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) ) )
							// InternalWeightDefinition.g:661:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )=> ( () ( ( ruleOpMultiAssign ) ) )
							{
							// InternalWeightDefinition.g:671:6: ( () ( ( ruleOpMultiAssign ) ) )
							// InternalWeightDefinition.g:672:7: () ( ( ruleOpMultiAssign ) )
							{
							// InternalWeightDefinition.g:672:7: ()
							// InternalWeightDefinition.g:673:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getXAssignmentAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
																current);
														}
							}

							// InternalWeightDefinition.g:679:7: ( ( ruleOpMultiAssign ) )
							// InternalWeightDefinition.g:680:8: ( ruleOpMultiAssign )
							{
							// InternalWeightDefinition.g:680:8: ( ruleOpMultiAssign )
							// InternalWeightDefinition.g:681:9: ruleOpMultiAssign
							{
							if ( state.backtracking==0 ) {
																if (current==null) {
																	current = createModelElement(grammarAccess.getXAssignmentRule());
																}
															}
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXAssignmentAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
															}
							pushFollow(FOLLOW_12);
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

							// InternalWeightDefinition.g:697:5: ( (lv_rightOperand_7_0= ruleXAssignment ) )
							// InternalWeightDefinition.g:698:6: (lv_rightOperand_7_0= ruleXAssignment )
							{
							// InternalWeightDefinition.g:698:6: (lv_rightOperand_7_0= ruleXAssignment )
							// InternalWeightDefinition.g:699:7: lv_rightOperand_7_0= ruleXAssignment
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
	// InternalWeightDefinition.g:722:1: entryRuleOpSingleAssign returns [String current=null] :iv_ruleOpSingleAssign= ruleOpSingleAssign EOF ;
	public final String entryRuleOpSingleAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpSingleAssign =null;

		try {
			// InternalWeightDefinition.g:722:54: (iv_ruleOpSingleAssign= ruleOpSingleAssign EOF )
			// InternalWeightDefinition.g:723:2: iv_ruleOpSingleAssign= ruleOpSingleAssign EOF
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
	// InternalWeightDefinition.g:729:1: ruleOpSingleAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '=' ;
	public final AntlrDatatypeRuleToken ruleOpSingleAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:735:2: (kw= '=' )
			// InternalWeightDefinition.g:736:2: kw= '='
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
	// InternalWeightDefinition.g:744:1: entryRuleOpMultiAssign returns [String current=null] :iv_ruleOpMultiAssign= ruleOpMultiAssign EOF ;
	public final String entryRuleOpMultiAssign() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMultiAssign =null;

		try {
			// InternalWeightDefinition.g:744:53: (iv_ruleOpMultiAssign= ruleOpMultiAssign EOF )
			// InternalWeightDefinition.g:745:2: iv_ruleOpMultiAssign= ruleOpMultiAssign EOF
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
	// InternalWeightDefinition.g:751:1: ruleOpMultiAssign returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) ;
	public final AntlrDatatypeRuleToken ruleOpMultiAssign() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:757:2: ( (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) ) )
			// InternalWeightDefinition.g:758:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			{
			// InternalWeightDefinition.g:758:2: (kw= '+=' |kw= '-=' |kw= '*=' |kw= '/=' |kw= '%=' | (kw= '<' kw= '<' kw= '=' ) | (kw= '>' (kw= '>' )? kw= '>=' ) )
			int alt7=7;
			switch ( input.LA(1) ) {
			case 28:
				{
				alt7=1;
				}
				break;
			case 32:
				{
				alt7=2;
				}
				break;
			case 25:
				{
				alt7=3;
				}
				break;
			case 38:
				{
				alt7=4;
				}
				break;
			case 18:
				{
				alt7=5;
				}
				break;
			case 42:
				{
				alt7=6;
				}
				break;
			case 48:
				{
				alt7=7;
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
					// InternalWeightDefinition.g:759:3: kw= '+='
					{
					kw=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPlusSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:765:3: kw= '-='
					{
					kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getHyphenMinusEqualsSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:771:3: kw= '*='
					{
					kw=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getAsteriskEqualsSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:777:3: kw= '/='
					{
					kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getSolidusEqualsSignKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalWeightDefinition.g:783:3: kw= '%='
					{
					kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getPercentSignEqualsSignKeyword_4());
							}
					}
					break;
				case 6 :
					// InternalWeightDefinition.g:789:3: (kw= '<' kw= '<' kw= '=' )
					{
					// InternalWeightDefinition.g:789:3: (kw= '<' kw= '<' kw= '=' )
					// InternalWeightDefinition.g:790:4: kw= '<' kw= '<' kw= '='
					{
					kw=(Token)match(input,42,FOLLOW_14); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getLessThanSignKeyword_5_0());
								}
					kw=(Token)match(input,42,FOLLOW_11); if (state.failed) return current;
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
					// InternalWeightDefinition.g:807:3: (kw= '>' (kw= '>' )? kw= '>=' )
					{
					// InternalWeightDefinition.g:807:3: (kw= '>' (kw= '>' )? kw= '>=' )
					// InternalWeightDefinition.g:808:4: kw= '>' (kw= '>' )? kw= '>='
					{
					kw=(Token)match(input,48,FOLLOW_15); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpMultiAssignAccess().getGreaterThanSignKeyword_6_0());
								}
					// InternalWeightDefinition.g:813:4: (kw= '>' )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==48) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// InternalWeightDefinition.g:814:5: kw= '>'
							{
							kw=(Token)match(input,48,FOLLOW_16); if (state.failed) return current;
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
	// InternalWeightDefinition.g:830:1: entryRuleXOrExpression returns [EObject current=null] :iv_ruleXOrExpression= ruleXOrExpression EOF ;
	public final EObject entryRuleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOrExpression =null;

		try {
			// InternalWeightDefinition.g:830:54: (iv_ruleXOrExpression= ruleXOrExpression EOF )
			// InternalWeightDefinition.g:831:2: iv_ruleXOrExpression= ruleXOrExpression EOF
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
	// InternalWeightDefinition.g:837:1: ruleXOrExpression returns [EObject current=null] : (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) ;
	public final EObject ruleXOrExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAndExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:843:2: ( (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* ) )
			// InternalWeightDefinition.g:844:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			{
			// InternalWeightDefinition.g:844:2: (this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )* )
			// InternalWeightDefinition.g:845:3: this_XAndExpression_0= ruleXAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXOrExpressionAccess().getXAndExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_17);
			this_XAndExpression_0=ruleXAndExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XAndExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:853:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) ) )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==87) ) {
					int LA8_2 = input.LA(2);
					if ( (synpred2_InternalWeightDefinition()) ) {
						alt8=1;
					}

				}

				switch (alt8) {
				case 1 :
					// InternalWeightDefinition.g:854:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) ) ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					{
					// InternalWeightDefinition.g:854:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) ) )
					// InternalWeightDefinition.g:855:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( ( ruleOpOr ) ) )
					{
					// InternalWeightDefinition.g:865:5: ( () ( ( ruleOpOr ) ) )
					// InternalWeightDefinition.g:866:6: () ( ( ruleOpOr ) )
					{
					// InternalWeightDefinition.g:866:6: ()
					// InternalWeightDefinition.g:867:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOrExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:873:6: ( ( ruleOpOr ) )
					// InternalWeightDefinition.g:874:7: ( ruleOpOr )
					{
					// InternalWeightDefinition.g:874:7: ( ruleOpOr )
					// InternalWeightDefinition.g:875:8: ruleOpOr
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXOrExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXOrExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_12);
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

					// InternalWeightDefinition.g:891:4: ( (lv_rightOperand_3_0= ruleXAndExpression ) )
					// InternalWeightDefinition.g:892:5: (lv_rightOperand_3_0= ruleXAndExpression )
					{
					// InternalWeightDefinition.g:892:5: (lv_rightOperand_3_0= ruleXAndExpression )
					// InternalWeightDefinition.g:893:6: lv_rightOperand_3_0= ruleXAndExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXOrExpressionAccess().getRightOperandXAndExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_17);
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
					break loop8;
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
	// InternalWeightDefinition.g:915:1: entryRuleOpOr returns [String current=null] :iv_ruleOpOr= ruleOpOr EOF ;
	public final String entryRuleOpOr() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOr =null;

		try {
			// InternalWeightDefinition.g:915:44: (iv_ruleOpOr= ruleOpOr EOF )
			// InternalWeightDefinition.g:916:2: iv_ruleOpOr= ruleOpOr EOF
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
	// InternalWeightDefinition.g:922:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
	public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:928:2: (kw= '||' )
			// InternalWeightDefinition.g:929:2: kw= '||'
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
	// InternalWeightDefinition.g:937:1: entryRuleXAndExpression returns [EObject current=null] :iv_ruleXAndExpression= ruleXAndExpression EOF ;
	public final EObject entryRuleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAndExpression =null;

		try {
			// InternalWeightDefinition.g:937:55: (iv_ruleXAndExpression= ruleXAndExpression EOF )
			// InternalWeightDefinition.g:938:2: iv_ruleXAndExpression= ruleXAndExpression EOF
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
	// InternalWeightDefinition.g:944:1: ruleXAndExpression returns [EObject current=null] : (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) ;
	public final EObject ruleXAndExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XEqualityExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:950:2: ( (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* ) )
			// InternalWeightDefinition.g:951:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			{
			// InternalWeightDefinition.g:951:2: (this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )* )
			// InternalWeightDefinition.g:952:3: this_XEqualityExpression_0= ruleXEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXAndExpressionAccess().getXEqualityExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_18);
			this_XEqualityExpression_0=ruleXEqualityExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XEqualityExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:960:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) ) )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==19) ) {
					int LA9_2 = input.LA(2);
					if ( (synpred3_InternalWeightDefinition()) ) {
						alt9=1;
					}

				}

				switch (alt9) {
				case 1 :
					// InternalWeightDefinition.g:961:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) ) ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					{
					// InternalWeightDefinition.g:961:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) ) )
					// InternalWeightDefinition.g:962:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( ( ruleOpAnd ) ) )
					{
					// InternalWeightDefinition.g:972:5: ( () ( ( ruleOpAnd ) ) )
					// InternalWeightDefinition.g:973:6: () ( ( ruleOpAnd ) )
					{
					// InternalWeightDefinition.g:973:6: ()
					// InternalWeightDefinition.g:974:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAndExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:980:6: ( ( ruleOpAnd ) )
					// InternalWeightDefinition.g:981:7: ( ruleOpAnd )
					{
					// InternalWeightDefinition.g:981:7: ( ruleOpAnd )
					// InternalWeightDefinition.g:982:8: ruleOpAnd
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAndExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAndExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_12);
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

					// InternalWeightDefinition.g:998:4: ( (lv_rightOperand_3_0= ruleXEqualityExpression ) )
					// InternalWeightDefinition.g:999:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					{
					// InternalWeightDefinition.g:999:5: (lv_rightOperand_3_0= ruleXEqualityExpression )
					// InternalWeightDefinition.g:1000:6: lv_rightOperand_3_0= ruleXEqualityExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAndExpressionAccess().getRightOperandXEqualityExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_18);
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
					break loop9;
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
	// InternalWeightDefinition.g:1022:1: entryRuleOpAnd returns [String current=null] :iv_ruleOpAnd= ruleOpAnd EOF ;
	public final String entryRuleOpAnd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAnd =null;

		try {
			// InternalWeightDefinition.g:1022:45: (iv_ruleOpAnd= ruleOpAnd EOF )
			// InternalWeightDefinition.g:1023:2: iv_ruleOpAnd= ruleOpAnd EOF
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
	// InternalWeightDefinition.g:1029:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
	public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1035:2: (kw= '&&' )
			// InternalWeightDefinition.g:1036:2: kw= '&&'
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
	// InternalWeightDefinition.g:1044:1: entryRuleXEqualityExpression returns [EObject current=null] :iv_ruleXEqualityExpression= ruleXEqualityExpression EOF ;
	public final EObject entryRuleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXEqualityExpression =null;

		try {
			// InternalWeightDefinition.g:1044:60: (iv_ruleXEqualityExpression= ruleXEqualityExpression EOF )
			// InternalWeightDefinition.g:1045:2: iv_ruleXEqualityExpression= ruleXEqualityExpression EOF
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
	// InternalWeightDefinition.g:1051:1: ruleXEqualityExpression returns [EObject current=null] : (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) ;
	public final EObject ruleXEqualityExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XRelationalExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1057:2: ( (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* ) )
			// InternalWeightDefinition.g:1058:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			{
			// InternalWeightDefinition.g:1058:2: (this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )* )
			// InternalWeightDefinition.g:1059:3: this_XRelationalExpression_0= ruleXRelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getXRelationalExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_19);
			this_XRelationalExpression_0=ruleXRelationalExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XRelationalExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1067:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) ) )*
			loop10:
			while (true) {
				int alt10=2;
				switch ( input.LA(1) ) {
				case 45:
					{
					int LA10_2 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt10=1;
					}

					}
					break;
				case 14:
					{
					int LA10_3 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt10=1;
					}

					}
					break;
				case 46:
					{
					int LA10_4 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt10=1;
					}

					}
					break;
				case 15:
					{
					int LA10_5 = input.LA(2);
					if ( (synpred4_InternalWeightDefinition()) ) {
						alt10=1;
					}

					}
					break;
				}
				switch (alt10) {
				case 1 :
					// InternalWeightDefinition.g:1068:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) ) ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					{
					// InternalWeightDefinition.g:1068:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) ) )
					// InternalWeightDefinition.g:1069:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( ( ruleOpEquality ) ) )
					{
					// InternalWeightDefinition.g:1079:5: ( () ( ( ruleOpEquality ) ) )
					// InternalWeightDefinition.g:1080:6: () ( ( ruleOpEquality ) )
					{
					// InternalWeightDefinition.g:1080:6: ()
					// InternalWeightDefinition.g:1081:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXEqualityExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1087:6: ( ( ruleOpEquality ) )
					// InternalWeightDefinition.g:1088:7: ( ruleOpEquality )
					{
					// InternalWeightDefinition.g:1088:7: ( ruleOpEquality )
					// InternalWeightDefinition.g:1089:8: ruleOpEquality
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXEqualityExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_12);
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

					// InternalWeightDefinition.g:1105:4: ( (lv_rightOperand_3_0= ruleXRelationalExpression ) )
					// InternalWeightDefinition.g:1106:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					{
					// InternalWeightDefinition.g:1106:5: (lv_rightOperand_3_0= ruleXRelationalExpression )
					// InternalWeightDefinition.g:1107:6: lv_rightOperand_3_0= ruleXRelationalExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXEqualityExpressionAccess().getRightOperandXRelationalExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_19);
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
	// $ANTLR end "ruleXEqualityExpression"



	// $ANTLR start "entryRuleOpEquality"
	// InternalWeightDefinition.g:1129:1: entryRuleOpEquality returns [String current=null] :iv_ruleOpEquality= ruleOpEquality EOF ;
	public final String entryRuleOpEquality() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpEquality =null;

		try {
			// InternalWeightDefinition.g:1129:50: (iv_ruleOpEquality= ruleOpEquality EOF )
			// InternalWeightDefinition.g:1130:2: iv_ruleOpEquality= ruleOpEquality EOF
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
	// InternalWeightDefinition.g:1136:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' ) ;
	public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1142:2: ( (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' ) )
			// InternalWeightDefinition.g:1143:2: (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' )
			{
			// InternalWeightDefinition.g:1143:2: (kw= '==' |kw= '!=' |kw= '===' |kw= '!==' )
			int alt11=4;
			switch ( input.LA(1) ) {
			case 45:
				{
				alt11=1;
				}
				break;
			case 14:
				{
				alt11=2;
				}
				break;
			case 46:
				{
				alt11=3;
				}
				break;
			case 15:
				{
				alt11=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// InternalWeightDefinition.g:1144:3: kw= '=='
					{
					kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1150:3: kw= '!='
					{
					kw=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1156:3: kw= '==='
					{
					kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignEqualsSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:1162:3: kw= '!=='
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
	// InternalWeightDefinition.g:1171:1: entryRuleXRelationalExpression returns [EObject current=null] :iv_ruleXRelationalExpression= ruleXRelationalExpression EOF ;
	public final EObject entryRuleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXRelationalExpression =null;

		try {
			// InternalWeightDefinition.g:1171:62: (iv_ruleXRelationalExpression= ruleXRelationalExpression EOF )
			// InternalWeightDefinition.g:1172:2: iv_ruleXRelationalExpression= ruleXRelationalExpression EOF
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
	// InternalWeightDefinition.g:1178:1: ruleXRelationalExpression returns [EObject current=null] : (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) ;
	public final EObject ruleXRelationalExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_XOtherOperatorExpression_0 =null;
		EObject lv_type_3_0 =null;
		EObject lv_rightOperand_6_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1184:2: ( (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* ) )
			// InternalWeightDefinition.g:1185:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			{
			// InternalWeightDefinition.g:1185:2: (this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )* )
			// InternalWeightDefinition.g:1186:3: this_XOtherOperatorExpression_0= ruleXOtherOperatorExpression ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getXOtherOperatorExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_20);
			this_XOtherOperatorExpression_0=ruleXOtherOperatorExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XOtherOperatorExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1194:3: ( ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) ) | ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) ) )*
			loop12:
			while (true) {
				int alt12=3;
				switch ( input.LA(1) ) {
				case 42:
					{
					int LA12_2 = input.LA(2);
					if ( (synpred6_InternalWeightDefinition()) ) {
						alt12=2;
					}

					}
					break;
				case 48:
					{
					int LA12_3 = input.LA(2);
					if ( (synpred6_InternalWeightDefinition()) ) {
						alt12=2;
					}

					}
					break;
				case 69:
					{
					int LA12_4 = input.LA(2);
					if ( (synpred5_InternalWeightDefinition()) ) {
						alt12=1;
					}

					}
					break;
				case 49:
					{
					int LA12_5 = input.LA(2);
					if ( (synpred6_InternalWeightDefinition()) ) {
						alt12=2;
					}

					}
					break;
				}
				switch (alt12) {
				case 1 :
					// InternalWeightDefinition.g:1195:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					{
					// InternalWeightDefinition.g:1195:4: ( ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )
					// InternalWeightDefinition.g:1196:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
					{
					// InternalWeightDefinition.g:1196:5: ( ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' ) )
					// InternalWeightDefinition.g:1197:6: ( ( () 'instanceof' ) )=> ( () otherlv_2= 'instanceof' )
					{
					// InternalWeightDefinition.g:1203:6: ( () otherlv_2= 'instanceof' )
					// InternalWeightDefinition.g:1204:7: () otherlv_2= 'instanceof'
					{
					// InternalWeightDefinition.g:1204:7: ()
					// InternalWeightDefinition.g:1205:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXInstanceOfExpressionExpressionAction_1_0_0_0_0(),
														current);
												}
					}

					otherlv_2=(Token)match(input,69,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXRelationalExpressionAccess().getInstanceofKeyword_1_0_0_0_1());
											}
					}

					}

					// InternalWeightDefinition.g:1217:5: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalWeightDefinition.g:1218:6: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:1218:6: (lv_type_3_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:1219:7: lv_type_3_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_0_1_0());
											}
					pushFollow(FOLLOW_20);
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
					// InternalWeightDefinition.g:1238:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					{
					// InternalWeightDefinition.g:1238:4: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) ) )
					// InternalWeightDefinition.g:1239:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) ) ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					{
					// InternalWeightDefinition.g:1239:5: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) ) )
					// InternalWeightDefinition.g:1240:6: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( ( ruleOpCompare ) ) )
					{
					// InternalWeightDefinition.g:1250:6: ( () ( ( ruleOpCompare ) ) )
					// InternalWeightDefinition.g:1251:7: () ( ( ruleOpCompare ) )
					{
					// InternalWeightDefinition.g:1251:7: ()
					// InternalWeightDefinition.g:1252:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXRelationalExpressionAccess().getXBinaryOperationLeftOperandAction_1_1_0_0_0(),
														current);
												}
					}

					// InternalWeightDefinition.g:1258:7: ( ( ruleOpCompare ) )
					// InternalWeightDefinition.g:1259:8: ( ruleOpCompare )
					{
					// InternalWeightDefinition.g:1259:8: ( ruleOpCompare )
					// InternalWeightDefinition.g:1260:9: ruleOpCompare
					{
					if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getXRelationalExpressionRule());
														}
													}
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_0_0_1_0());
													}
					pushFollow(FOLLOW_12);
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

					// InternalWeightDefinition.g:1276:5: ( (lv_rightOperand_6_0= ruleXOtherOperatorExpression ) )
					// InternalWeightDefinition.g:1277:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					{
					// InternalWeightDefinition.g:1277:6: (lv_rightOperand_6_0= ruleXOtherOperatorExpression )
					// InternalWeightDefinition.g:1278:7: lv_rightOperand_6_0= ruleXOtherOperatorExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXRelationalExpressionAccess().getRightOperandXOtherOperatorExpressionParserRuleCall_1_1_1_0());
											}
					pushFollow(FOLLOW_20);
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
	// $ANTLR end "ruleXRelationalExpression"



	// $ANTLR start "entryRuleOpCompare"
	// InternalWeightDefinition.g:1301:1: entryRuleOpCompare returns [String current=null] :iv_ruleOpCompare= ruleOpCompare EOF ;
	public final String entryRuleOpCompare() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpCompare =null;

		try {
			// InternalWeightDefinition.g:1301:49: (iv_ruleOpCompare= ruleOpCompare EOF )
			// InternalWeightDefinition.g:1302:2: iv_ruleOpCompare= ruleOpCompare EOF
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
	// InternalWeightDefinition.g:1308:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) ;
	public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1314:2: ( (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' ) )
			// InternalWeightDefinition.g:1315:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			{
			// InternalWeightDefinition.g:1315:2: (kw= '>=' | (kw= '<' kw= '=' ) |kw= '>' |kw= '<' )
			int alt13=4;
			switch ( input.LA(1) ) {
			case 49:
				{
				alt13=1;
				}
				break;
			case 42:
				{
				int LA13_2 = input.LA(2);
				if ( (LA13_2==44) ) {
					alt13=2;
				}
				else if ( (LA13_2==EOF||(LA13_2 >= RULE_DECIMAL && LA13_2 <= RULE_INT)||LA13_2==RULE_STRING||LA13_2==13||LA13_2==16||LA13_2==21||LA13_2==26||LA13_2==30||LA13_2==42||LA13_2==53||LA13_2==59||(LA13_2 >= 61 && LA13_2 <= 63)||LA13_2==65||(LA13_2 >= 67 && LA13_2 <= 68)||(LA13_2 >= 70 && LA13_2 <= 72)||(LA13_2 >= 74 && LA13_2 <= 81)||(LA13_2 >= 84 && LA13_2 <= 85)) ) {
					alt13=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 48:
				{
				alt13=3;
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
					// InternalWeightDefinition.g:1316:3: kw= '>='
					{
					kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1322:3: (kw= '<' kw= '=' )
					{
					// InternalWeightDefinition.g:1322:3: (kw= '<' kw= '=' )
					// InternalWeightDefinition.g:1323:4: kw= '<' kw= '='
					{
					kw=(Token)match(input,42,FOLLOW_11); if (state.failed) return current;
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
					// InternalWeightDefinition.g:1335:3: kw= '>'
					{
					kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:1341:3: kw= '<'
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
	// InternalWeightDefinition.g:1350:1: entryRuleXOtherOperatorExpression returns [EObject current=null] :iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF ;
	public final EObject entryRuleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXOtherOperatorExpression =null;

		try {
			// InternalWeightDefinition.g:1350:65: (iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF )
			// InternalWeightDefinition.g:1351:2: iv_ruleXOtherOperatorExpression= ruleXOtherOperatorExpression EOF
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
	// InternalWeightDefinition.g:1357:1: ruleXOtherOperatorExpression returns [EObject current=null] : (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) ;
	public final EObject ruleXOtherOperatorExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XAdditiveExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1363:2: ( (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* ) )
			// InternalWeightDefinition.g:1364:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			{
			// InternalWeightDefinition.g:1364:2: (this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )* )
			// InternalWeightDefinition.g:1365:3: this_XAdditiveExpression_0= ruleXAdditiveExpression ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getXAdditiveExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_21);
			this_XAdditiveExpression_0=ruleXAdditiveExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XAdditiveExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1373:3: ( ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) ) )*
			loop14:
			while (true) {
				int alt14=2;
				switch ( input.LA(1) ) {
				case 42:
					{
					int LA14_2 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 48:
					{
					int LA14_3 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 33:
					{
					int LA14_4 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 36:
					{
					int LA14_5 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 35:
					{
					int LA14_6 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 47:
					{
					int LA14_7 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 43:
					{
					int LA14_8 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				case 52:
					{
					int LA14_9 = input.LA(2);
					if ( (synpred7_InternalWeightDefinition()) ) {
						alt14=1;
					}

					}
					break;
				}
				switch (alt14) {
				case 1 :
					// InternalWeightDefinition.g:1374:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) ) ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					{
					// InternalWeightDefinition.g:1374:4: ( ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) ) )
					// InternalWeightDefinition.g:1375:5: ( ( () ( ( ruleOpOther ) ) ) )=> ( () ( ( ruleOpOther ) ) )
					{
					// InternalWeightDefinition.g:1385:5: ( () ( ( ruleOpOther ) ) )
					// InternalWeightDefinition.g:1386:6: () ( ( ruleOpOther ) )
					{
					// InternalWeightDefinition.g:1386:6: ()
					// InternalWeightDefinition.g:1387:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXOtherOperatorExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1393:6: ( ( ruleOpOther ) )
					// InternalWeightDefinition.g:1394:7: ( ruleOpOther )
					{
					// InternalWeightDefinition.g:1394:7: ( ruleOpOther )
					// InternalWeightDefinition.g:1395:8: ruleOpOther
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXOtherOperatorExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_12);
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

					// InternalWeightDefinition.g:1411:4: ( (lv_rightOperand_3_0= ruleXAdditiveExpression ) )
					// InternalWeightDefinition.g:1412:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					{
					// InternalWeightDefinition.g:1412:5: (lv_rightOperand_3_0= ruleXAdditiveExpression )
					// InternalWeightDefinition.g:1413:6: lv_rightOperand_3_0= ruleXAdditiveExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXOtherOperatorExpressionAccess().getRightOperandXAdditiveExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_21);
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
	// $ANTLR end "ruleXOtherOperatorExpression"



	// $ANTLR start "entryRuleOpOther"
	// InternalWeightDefinition.g:1435:1: entryRuleOpOther returns [String current=null] :iv_ruleOpOther= ruleOpOther EOF ;
	public final String entryRuleOpOther() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpOther =null;

		try {
			// InternalWeightDefinition.g:1435:47: (iv_ruleOpOther= ruleOpOther EOF )
			// InternalWeightDefinition.g:1436:2: iv_ruleOpOther= ruleOpOther EOF
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
	// InternalWeightDefinition.g:1442:1: ruleOpOther returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' ) ;
	public final AntlrDatatypeRuleToken ruleOpOther() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1448:2: ( (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' ) )
			// InternalWeightDefinition.g:1449:2: (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' )
			{
			// InternalWeightDefinition.g:1449:2: (kw= '->' |kw= '..<' | (kw= '>' kw= '..' ) |kw= '..' |kw= '=>' | (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) ) | (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) ) |kw= '<>' |kw= '?:' )
			int alt17=9;
			switch ( input.LA(1) ) {
			case 33:
				{
				alt17=1;
				}
				break;
			case 36:
				{
				alt17=2;
				}
				break;
			case 48:
				{
				int LA17_3 = input.LA(2);
				if ( (LA17_3==35) ) {
					alt17=3;
				}
				else if ( (LA17_3==48) ) {
					alt17=6;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 17, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 35:
				{
				alt17=4;
				}
				break;
			case 47:
				{
				alt17=5;
				}
				break;
			case 42:
				{
				alt17=7;
				}
				break;
			case 43:
				{
				alt17=8;
				}
				break;
			case 52:
				{
				alt17=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 17, 0, input);
				throw nvae;
			}
			switch (alt17) {
				case 1 :
					// InternalWeightDefinition.g:1450:3: kw= '->'
					{
					kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getHyphenMinusGreaterThanSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1456:3: kw= '..<'
					{
					kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopLessThanSignKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1462:3: (kw= '>' kw= '..' )
					{
					// InternalWeightDefinition.g:1462:3: (kw= '>' kw= '..' )
					// InternalWeightDefinition.g:1463:4: kw= '>' kw= '..'
					{
					kw=(Token)match(input,48,FOLLOW_22); if (state.failed) return current;
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
					// InternalWeightDefinition.g:1475:3: kw= '..'
					{
					kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getFullStopFullStopKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalWeightDefinition.g:1481:3: kw= '=>'
					{
					kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getEqualsSignGreaterThanSignKeyword_4());
							}
					}
					break;
				case 6 :
					// InternalWeightDefinition.g:1487:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					{
					// InternalWeightDefinition.g:1487:3: (kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' ) )
					// InternalWeightDefinition.g:1488:4: kw= '>' ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					{
					kw=(Token)match(input,48,FOLLOW_23); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getGreaterThanSignKeyword_5_0());
								}
					// InternalWeightDefinition.g:1493:4: ( ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) ) |kw= '>' )
					int alt15=2;
					int LA15_0 = input.LA(1);
					if ( (LA15_0==48) ) {
						int LA15_1 = input.LA(2);
						if ( (LA15_1==48) && (synpred8_InternalWeightDefinition())) {
							alt15=1;
						}
						else if ( (LA15_1==EOF||(LA15_1 >= RULE_DECIMAL && LA15_1 <= RULE_INT)||LA15_1==RULE_STRING||LA15_1==13||LA15_1==16||LA15_1==21||LA15_1==26||LA15_1==30||LA15_1==42||LA15_1==53||LA15_1==59||(LA15_1 >= 61 && LA15_1 <= 63)||LA15_1==65||(LA15_1 >= 67 && LA15_1 <= 68)||(LA15_1 >= 70 && LA15_1 <= 72)||(LA15_1 >= 74 && LA15_1 <= 81)||(LA15_1 >= 84 && LA15_1 <= 85)) ) {
							alt15=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return current;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 15, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 15, 0, input);
						throw nvae;
					}

					switch (alt15) {
						case 1 :
							// InternalWeightDefinition.g:1494:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							{
							// InternalWeightDefinition.g:1494:5: ( ( ( '>' '>' ) )=> (kw= '>' kw= '>' ) )
							// InternalWeightDefinition.g:1495:6: ( ( '>' '>' ) )=> (kw= '>' kw= '>' )
							{
							// InternalWeightDefinition.g:1500:6: (kw= '>' kw= '>' )
							// InternalWeightDefinition.g:1501:7: kw= '>' kw= '>'
							{
							kw=(Token)match(input,48,FOLLOW_23); if (state.failed) return current;
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
							// InternalWeightDefinition.g:1514:5: kw= '>'
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
					// InternalWeightDefinition.g:1522:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) )
					{
					// InternalWeightDefinition.g:1522:3: (kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' ) )
					// InternalWeightDefinition.g:1523:4: kw= '<' ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' )
					{
					kw=(Token)match(input,42,FOLLOW_24); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current.merge(kw);
									newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_0());
								}
					// InternalWeightDefinition.g:1528:4: ( ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) ) |kw= '<' |kw= '=>' )
					int alt16=3;
					int LA16_0 = input.LA(1);
					if ( (LA16_0==42) ) {
						int LA16_1 = input.LA(2);
						if ( (synpred9_InternalWeightDefinition()) ) {
							alt16=1;
						}
						else if ( (true) ) {
							alt16=2;
						}

					}
					else if ( (LA16_0==47) ) {
						alt16=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}

					switch (alt16) {
						case 1 :
							// InternalWeightDefinition.g:1529:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
							{
							// InternalWeightDefinition.g:1529:5: ( ( ( '<' '<' ) )=> (kw= '<' kw= '<' ) )
							// InternalWeightDefinition.g:1530:6: ( ( '<' '<' ) )=> (kw= '<' kw= '<' )
							{
							// InternalWeightDefinition.g:1535:6: (kw= '<' kw= '<' )
							// InternalWeightDefinition.g:1536:7: kw= '<' kw= '<'
							{
							kw=(Token)match(input,42,FOLLOW_14); if (state.failed) return current;
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
							// InternalWeightDefinition.g:1549:5: kw= '<'
							{
							kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignKeyword_6_1_1());
											}
							}
							break;
						case 3 :
							// InternalWeightDefinition.g:1555:5: kw= '=>'
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
					// InternalWeightDefinition.g:1563:3: kw= '<>'
					{
					kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpOtherAccess().getLessThanSignGreaterThanSignKeyword_7());
							}
					}
					break;
				case 9 :
					// InternalWeightDefinition.g:1569:3: kw= '?:'
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
	// InternalWeightDefinition.g:1578:1: entryRuleXAdditiveExpression returns [EObject current=null] :iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF ;
	public final EObject entryRuleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXAdditiveExpression =null;

		try {
			// InternalWeightDefinition.g:1578:60: (iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF )
			// InternalWeightDefinition.g:1579:2: iv_ruleXAdditiveExpression= ruleXAdditiveExpression EOF
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
	// InternalWeightDefinition.g:1585:1: ruleXAdditiveExpression returns [EObject current=null] : (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) ;
	public final EObject ruleXAdditiveExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XMultiplicativeExpression_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1591:2: ( (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* ) )
			// InternalWeightDefinition.g:1592:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			{
			// InternalWeightDefinition.g:1592:2: (this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )* )
			// InternalWeightDefinition.g:1593:3: this_XMultiplicativeExpression_0= ruleXMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getXMultiplicativeExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_25);
			this_XMultiplicativeExpression_0=ruleXMultiplicativeExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XMultiplicativeExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1601:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) ) )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==26) ) {
					int LA18_2 = input.LA(2);
					if ( (synpred10_InternalWeightDefinition()) ) {
						alt18=1;
					}

				}
				else if ( (LA18_0==30) ) {
					int LA18_3 = input.LA(2);
					if ( (synpred10_InternalWeightDefinition()) ) {
						alt18=1;
					}

				}

				switch (alt18) {
				case 1 :
					// InternalWeightDefinition.g:1602:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) ) ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					{
					// InternalWeightDefinition.g:1602:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) ) )
					// InternalWeightDefinition.g:1603:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( ( ruleOpAdd ) ) )
					{
					// InternalWeightDefinition.g:1613:5: ( () ( ( ruleOpAdd ) ) )
					// InternalWeightDefinition.g:1614:6: () ( ( ruleOpAdd ) )
					{
					// InternalWeightDefinition.g:1614:6: ()
					// InternalWeightDefinition.g:1615:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXAdditiveExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1621:6: ( ( ruleOpAdd ) )
					// InternalWeightDefinition.g:1622:7: ( ruleOpAdd )
					{
					// InternalWeightDefinition.g:1622:7: ( ruleOpAdd )
					// InternalWeightDefinition.g:1623:8: ruleOpAdd
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXAdditiveExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_12);
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

					// InternalWeightDefinition.g:1639:4: ( (lv_rightOperand_3_0= ruleXMultiplicativeExpression ) )
					// InternalWeightDefinition.g:1640:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					{
					// InternalWeightDefinition.g:1640:5: (lv_rightOperand_3_0= ruleXMultiplicativeExpression )
					// InternalWeightDefinition.g:1641:6: lv_rightOperand_3_0= ruleXMultiplicativeExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXAdditiveExpressionAccess().getRightOperandXMultiplicativeExpressionParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_25);
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
					break loop18;
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
	// InternalWeightDefinition.g:1663:1: entryRuleOpAdd returns [String current=null] :iv_ruleOpAdd= ruleOpAdd EOF ;
	public final String entryRuleOpAdd() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpAdd =null;

		try {
			// InternalWeightDefinition.g:1663:45: (iv_ruleOpAdd= ruleOpAdd EOF )
			// InternalWeightDefinition.g:1664:2: iv_ruleOpAdd= ruleOpAdd EOF
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
	// InternalWeightDefinition.g:1670:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' |kw= '-' ) ;
	public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1676:2: ( (kw= '+' |kw= '-' ) )
			// InternalWeightDefinition.g:1677:2: (kw= '+' |kw= '-' )
			{
			// InternalWeightDefinition.g:1677:2: (kw= '+' |kw= '-' )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==26) ) {
				alt19=1;
			}
			else if ( (LA19_0==30) ) {
				alt19=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// InternalWeightDefinition.g:1678:3: kw= '+'
					{
					kw=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1684:3: kw= '-'
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
	// InternalWeightDefinition.g:1693:1: entryRuleXMultiplicativeExpression returns [EObject current=null] :iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF ;
	public final EObject entryRuleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMultiplicativeExpression =null;

		try {
			// InternalWeightDefinition.g:1693:66: (iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF )
			// InternalWeightDefinition.g:1694:2: iv_ruleXMultiplicativeExpression= ruleXMultiplicativeExpression EOF
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
	// InternalWeightDefinition.g:1700:1: ruleXMultiplicativeExpression returns [EObject current=null] : (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) ;
	public final EObject ruleXMultiplicativeExpression() throws RecognitionException {
		EObject current = null;


		EObject this_XUnaryOperation_0 =null;
		EObject lv_rightOperand_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1706:2: ( (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* ) )
			// InternalWeightDefinition.g:1707:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			{
			// InternalWeightDefinition.g:1707:2: (this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )* )
			// InternalWeightDefinition.g:1708:3: this_XUnaryOperation_0= ruleXUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getXUnaryOperationParserRuleCall_0());
					}
			pushFollow(FOLLOW_26);
			this_XUnaryOperation_0=ruleXUnaryOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XUnaryOperation_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1716:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) ) )*
			loop20:
			while (true) {
				int alt20=2;
				switch ( input.LA(1) ) {
				case 23:
					{
					int LA20_2 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt20=1;
					}

					}
					break;
				case 24:
					{
					int LA20_3 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt20=1;
					}

					}
					break;
				case 37:
					{
					int LA20_4 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt20=1;
					}

					}
					break;
				case 17:
					{
					int LA20_5 = input.LA(2);
					if ( (synpred11_InternalWeightDefinition()) ) {
						alt20=1;
					}

					}
					break;
				}
				switch (alt20) {
				case 1 :
					// InternalWeightDefinition.g:1717:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) ) ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					{
					// InternalWeightDefinition.g:1717:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) ) )
					// InternalWeightDefinition.g:1718:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( ( ruleOpMulti ) ) )
					{
					// InternalWeightDefinition.g:1728:5: ( () ( ( ruleOpMulti ) ) )
					// InternalWeightDefinition.g:1729:6: () ( ( ruleOpMulti ) )
					{
					// InternalWeightDefinition.g:1729:6: ()
					// InternalWeightDefinition.g:1730:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXMultiplicativeExpressionAccess().getXBinaryOperationLeftOperandAction_1_0_0_0(),
													current);
											}
					}

					// InternalWeightDefinition.g:1736:6: ( ( ruleOpMulti ) )
					// InternalWeightDefinition.g:1737:7: ( ruleOpMulti )
					{
					// InternalWeightDefinition.g:1737:7: ( ruleOpMulti )
					// InternalWeightDefinition.g:1738:8: ruleOpMulti
					{
					if ( state.backtracking==0 ) {
													if (current==null) {
														current = createModelElement(grammarAccess.getXMultiplicativeExpressionRule());
													}
												}
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_1_0());
												}
					pushFollow(FOLLOW_12);
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

					// InternalWeightDefinition.g:1754:4: ( (lv_rightOperand_3_0= ruleXUnaryOperation ) )
					// InternalWeightDefinition.g:1755:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					{
					// InternalWeightDefinition.g:1755:5: (lv_rightOperand_3_0= ruleXUnaryOperation )
					// InternalWeightDefinition.g:1756:6: lv_rightOperand_3_0= ruleXUnaryOperation
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXMultiplicativeExpressionAccess().getRightOperandXUnaryOperationParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_26);
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
	// $ANTLR end "ruleXMultiplicativeExpression"



	// $ANTLR start "entryRuleOpMulti"
	// InternalWeightDefinition.g:1778:1: entryRuleOpMulti returns [String current=null] :iv_ruleOpMulti= ruleOpMulti EOF ;
	public final String entryRuleOpMulti() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpMulti =null;

		try {
			// InternalWeightDefinition.g:1778:47: (iv_ruleOpMulti= ruleOpMulti EOF )
			// InternalWeightDefinition.g:1779:2: iv_ruleOpMulti= ruleOpMulti EOF
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
	// InternalWeightDefinition.g:1785:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' |kw= '**' |kw= '/' |kw= '%' ) ;
	public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1791:2: ( (kw= '*' |kw= '**' |kw= '/' |kw= '%' ) )
			// InternalWeightDefinition.g:1792:2: (kw= '*' |kw= '**' |kw= '/' |kw= '%' )
			{
			// InternalWeightDefinition.g:1792:2: (kw= '*' |kw= '**' |kw= '/' |kw= '%' )
			int alt21=4;
			switch ( input.LA(1) ) {
			case 23:
				{
				alt21=1;
				}
				break;
			case 24:
				{
				alt21=2;
				}
				break;
			case 37:
				{
				alt21=3;
				}
				break;
			case 17:
				{
				alt21=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// InternalWeightDefinition.g:1793:3: kw= '*'
					{
					kw=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1799:3: kw= '**'
					{
					kw=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskAsteriskKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1805:3: kw= '/'
					{
					kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:1811:3: kw= '%'
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
	// InternalWeightDefinition.g:1820:1: entryRuleXUnaryOperation returns [EObject current=null] :iv_ruleXUnaryOperation= ruleXUnaryOperation EOF ;
	public final EObject entryRuleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXUnaryOperation =null;

		try {
			// InternalWeightDefinition.g:1820:56: (iv_ruleXUnaryOperation= ruleXUnaryOperation EOF )
			// InternalWeightDefinition.g:1821:2: iv_ruleXUnaryOperation= ruleXUnaryOperation EOF
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
	// InternalWeightDefinition.g:1827:1: ruleXUnaryOperation returns [EObject current=null] : ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) ;
	public final EObject ruleXUnaryOperation() throws RecognitionException {
		EObject current = null;


		EObject lv_operand_2_0 =null;
		EObject this_XCastedExpression_3 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1833:2: ( ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression ) )
			// InternalWeightDefinition.g:1834:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			{
			// InternalWeightDefinition.g:1834:2: ( ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) ) |this_XCastedExpression_3= ruleXCastedExpression )
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==13||LA22_0==26||LA22_0==30) ) {
				alt22=1;
			}
			else if ( ((LA22_0 >= RULE_DECIMAL && LA22_0 <= RULE_INT)||LA22_0==RULE_STRING||LA22_0==16||LA22_0==21||LA22_0==42||LA22_0==53||LA22_0==59||(LA22_0 >= 61 && LA22_0 <= 63)||LA22_0==65||(LA22_0 >= 67 && LA22_0 <= 68)||(LA22_0 >= 70 && LA22_0 <= 72)||(LA22_0 >= 74 && LA22_0 <= 81)||(LA22_0 >= 84 && LA22_0 <= 85)) ) {
				alt22=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// InternalWeightDefinition.g:1835:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					{
					// InternalWeightDefinition.g:1835:3: ( () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) ) )
					// InternalWeightDefinition.g:1836:4: () ( ( ruleOpUnary ) ) ( (lv_operand_2_0= ruleXUnaryOperation ) )
					{
					// InternalWeightDefinition.g:1836:4: ()
					// InternalWeightDefinition.g:1837:5: 
					{
					if ( state.backtracking==0 ) {
										current = forceCreateModelElement(
											grammarAccess.getXUnaryOperationAccess().getXUnaryOperationAction_0_0(),
											current);
									}
					}

					// InternalWeightDefinition.g:1843:4: ( ( ruleOpUnary ) )
					// InternalWeightDefinition.g:1844:5: ( ruleOpUnary )
					{
					// InternalWeightDefinition.g:1844:5: ( ruleOpUnary )
					// InternalWeightDefinition.g:1845:6: ruleOpUnary
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXUnaryOperationRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXUnaryOperationAccess().getFeatureJvmIdentifiableElementCrossReference_0_1_0());
										}
					pushFollow(FOLLOW_12);
					ruleOpUnary();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
											afterParserOrEnumRuleCall();
										}
					}

					}

					// InternalWeightDefinition.g:1859:4: ( (lv_operand_2_0= ruleXUnaryOperation ) )
					// InternalWeightDefinition.g:1860:5: (lv_operand_2_0= ruleXUnaryOperation )
					{
					// InternalWeightDefinition.g:1860:5: (lv_operand_2_0= ruleXUnaryOperation )
					// InternalWeightDefinition.g:1861:6: lv_operand_2_0= ruleXUnaryOperation
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
					// InternalWeightDefinition.g:1880:3: this_XCastedExpression_3= ruleXCastedExpression
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
	// InternalWeightDefinition.g:1892:1: entryRuleOpUnary returns [String current=null] :iv_ruleOpUnary= ruleOpUnary EOF ;
	public final String entryRuleOpUnary() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpUnary =null;

		try {
			// InternalWeightDefinition.g:1892:47: (iv_ruleOpUnary= ruleOpUnary EOF )
			// InternalWeightDefinition.g:1893:2: iv_ruleOpUnary= ruleOpUnary EOF
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
	// InternalWeightDefinition.g:1899:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' |kw= '-' |kw= '+' ) ;
	public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1905:2: ( (kw= '!' |kw= '-' |kw= '+' ) )
			// InternalWeightDefinition.g:1906:2: (kw= '!' |kw= '-' |kw= '+' )
			{
			// InternalWeightDefinition.g:1906:2: (kw= '!' |kw= '-' |kw= '+' )
			int alt23=3;
			switch ( input.LA(1) ) {
			case 13:
				{
				alt23=1;
				}
				break;
			case 30:
				{
				alt23=2;
				}
				break;
			case 26:
				{
				alt23=3;
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
					// InternalWeightDefinition.g:1907:3: kw= '!'
					{
					kw=(Token)match(input,13,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getExclamationMarkKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:1913:3: kw= '-'
					{
					kw=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:1919:3: kw= '+'
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
	// InternalWeightDefinition.g:1928:1: entryRuleXCastedExpression returns [EObject current=null] :iv_ruleXCastedExpression= ruleXCastedExpression EOF ;
	public final EObject entryRuleXCastedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCastedExpression =null;

		try {
			// InternalWeightDefinition.g:1928:58: (iv_ruleXCastedExpression= ruleXCastedExpression EOF )
			// InternalWeightDefinition.g:1929:2: iv_ruleXCastedExpression= ruleXCastedExpression EOF
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
	// InternalWeightDefinition.g:1935:1: ruleXCastedExpression returns [EObject current=null] : (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) ;
	public final EObject ruleXCastedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject this_XPostfixOperation_0 =null;
		EObject lv_type_3_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:1941:2: ( (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* ) )
			// InternalWeightDefinition.g:1942:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
			{
			// InternalWeightDefinition.g:1942:2: (this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )* )
			// InternalWeightDefinition.g:1943:3: this_XPostfixOperation_0= ruleXPostfixOperation ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXCastedExpressionAccess().getXPostfixOperationParserRuleCall_0());
					}
			pushFollow(FOLLOW_27);
			this_XPostfixOperation_0=ruleXPostfixOperation();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XPostfixOperation_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:1951:3: ( ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) ) )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==55) ) {
					int LA24_2 = input.LA(2);
					if ( (synpred12_InternalWeightDefinition()) ) {
						alt24=1;
					}

				}

				switch (alt24) {
				case 1 :
					// InternalWeightDefinition.g:1952:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) ) ( (lv_type_3_0= ruleJvmTypeReference ) )
					{
					// InternalWeightDefinition.g:1952:4: ( ( ( () 'as' ) )=> ( () otherlv_2= 'as' ) )
					// InternalWeightDefinition.g:1953:5: ( ( () 'as' ) )=> ( () otherlv_2= 'as' )
					{
					// InternalWeightDefinition.g:1959:5: ( () otherlv_2= 'as' )
					// InternalWeightDefinition.g:1960:6: () otherlv_2= 'as'
					{
					// InternalWeightDefinition.g:1960:6: ()
					// InternalWeightDefinition.g:1961:7: 
					{
					if ( state.backtracking==0 ) {
												current = forceCreateModelElementAndSet(
													grammarAccess.getXCastedExpressionAccess().getXCastedExpressionTargetAction_1_0_0_0(),
													current);
											}
					}

					otherlv_2=(Token)match(input,55,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
											newLeafNode(otherlv_2, grammarAccess.getXCastedExpressionAccess().getAsKeyword_1_0_0_1());
										}
					}

					}

					// InternalWeightDefinition.g:1973:4: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalWeightDefinition.g:1974:5: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:1974:5: (lv_type_3_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:1975:6: lv_type_3_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXCastedExpressionAccess().getTypeJvmTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_27);
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
					break loop24;
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
	// InternalWeightDefinition.g:1997:1: entryRuleXPostfixOperation returns [EObject current=null] :iv_ruleXPostfixOperation= ruleXPostfixOperation EOF ;
	public final EObject entryRuleXPostfixOperation() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPostfixOperation =null;

		try {
			// InternalWeightDefinition.g:1997:58: (iv_ruleXPostfixOperation= ruleXPostfixOperation EOF )
			// InternalWeightDefinition.g:1998:2: iv_ruleXPostfixOperation= ruleXPostfixOperation EOF
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
	// InternalWeightDefinition.g:2004:1: ruleXPostfixOperation returns [EObject current=null] : (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) ;
	public final EObject ruleXPostfixOperation() throws RecognitionException {
		EObject current = null;


		EObject this_XMemberFeatureCall_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2010:2: ( (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? ) )
			// InternalWeightDefinition.g:2011:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
			{
			// InternalWeightDefinition.g:2011:2: (this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )? )
			// InternalWeightDefinition.g:2012:3: this_XMemberFeatureCall_0= ruleXMemberFeatureCall ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXPostfixOperationAccess().getXMemberFeatureCallParserRuleCall_0());
					}
			pushFollow(FOLLOW_28);
			this_XMemberFeatureCall_0=ruleXMemberFeatureCall();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XMemberFeatureCall_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:2020:3: ( ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) ) )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==27) ) {
				int LA25_1 = input.LA(2);
				if ( (synpred13_InternalWeightDefinition()) ) {
					alt25=1;
				}
			}
			else if ( (LA25_0==31) ) {
				int LA25_2 = input.LA(2);
				if ( (synpred13_InternalWeightDefinition()) ) {
					alt25=1;
				}
			}
			switch (alt25) {
				case 1 :
					// InternalWeightDefinition.g:2021:4: ( ( () ( ( ruleOpPostfix ) ) ) )=> ( () ( ( ruleOpPostfix ) ) )
					{
					// InternalWeightDefinition.g:2031:4: ( () ( ( ruleOpPostfix ) ) )
					// InternalWeightDefinition.g:2032:5: () ( ( ruleOpPostfix ) )
					{
					// InternalWeightDefinition.g:2032:5: ()
					// InternalWeightDefinition.g:2033:6: 
					{
					if ( state.backtracking==0 ) {
											current = forceCreateModelElementAndSet(
												grammarAccess.getXPostfixOperationAccess().getXPostfixOperationOperandAction_1_0_0(),
												current);
										}
					}

					// InternalWeightDefinition.g:2039:5: ( ( ruleOpPostfix ) )
					// InternalWeightDefinition.g:2040:6: ( ruleOpPostfix )
					{
					// InternalWeightDefinition.g:2040:6: ( ruleOpPostfix )
					// InternalWeightDefinition.g:2041:7: ruleOpPostfix
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
	// InternalWeightDefinition.g:2061:1: entryRuleOpPostfix returns [String current=null] :iv_ruleOpPostfix= ruleOpPostfix EOF ;
	public final String entryRuleOpPostfix() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleOpPostfix =null;

		try {
			// InternalWeightDefinition.g:2061:49: (iv_ruleOpPostfix= ruleOpPostfix EOF )
			// InternalWeightDefinition.g:2062:2: iv_ruleOpPostfix= ruleOpPostfix EOF
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
	// InternalWeightDefinition.g:2068:1: ruleOpPostfix returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '++' |kw= '--' ) ;
	public final AntlrDatatypeRuleToken ruleOpPostfix() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2074:2: ( (kw= '++' |kw= '--' ) )
			// InternalWeightDefinition.g:2075:2: (kw= '++' |kw= '--' )
			{
			// InternalWeightDefinition.g:2075:2: (kw= '++' |kw= '--' )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==27) ) {
				alt26=1;
			}
			else if ( (LA26_0==31) ) {
				alt26=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// InternalWeightDefinition.g:2076:3: kw= '++'
					{
					kw=(Token)match(input,27,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getOpPostfixAccess().getPlusSignPlusSignKeyword_0());
							}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:2082:3: kw= '--'
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
	// InternalWeightDefinition.g:2091:1: entryRuleXMemberFeatureCall returns [EObject current=null] :iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF ;
	public final EObject entryRuleXMemberFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXMemberFeatureCall =null;

		try {
			// InternalWeightDefinition.g:2091:59: (iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF )
			// InternalWeightDefinition.g:2092:2: iv_ruleXMemberFeatureCall= ruleXMemberFeatureCall EOF
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
	// InternalWeightDefinition.g:2098:1: ruleXMemberFeatureCall returns [EObject current=null] : (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) ;
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
			// InternalWeightDefinition.g:2104:2: ( (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* ) )
			// InternalWeightDefinition.g:2105:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
			{
			// InternalWeightDefinition.g:2105:2: (this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )* )
			// InternalWeightDefinition.g:2106:3: this_XPrimaryExpression_0= ruleXPrimaryExpression ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getXPrimaryExpressionParserRuleCall_0());
					}
			pushFollow(FOLLOW_29);
			this_XPrimaryExpression_0=ruleXPrimaryExpression();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current = this_XPrimaryExpression_0;
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:2114:3: ( ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) ) | ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? ) )*
			loop35:
			while (true) {
				int alt35=3;
				switch ( input.LA(1) ) {
				case 34:
					{
					int LA35_2 = input.LA(2);
					if ( (synpred14_InternalWeightDefinition()) ) {
						alt35=1;
					}
					else if ( (synpred15_InternalWeightDefinition()) ) {
						alt35=2;
					}

					}
					break;
				case 40:
					{
					int LA35_3 = input.LA(2);
					if ( (synpred14_InternalWeightDefinition()) ) {
						alt35=1;
					}
					else if ( (synpred15_InternalWeightDefinition()) ) {
						alt35=2;
					}

					}
					break;
				case 51:
					{
					int LA35_4 = input.LA(2);
					if ( (synpred15_InternalWeightDefinition()) ) {
						alt35=2;
					}

					}
					break;
				}
				switch (alt35) {
				case 1 :
					// InternalWeightDefinition.g:2115:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
					{
					// InternalWeightDefinition.g:2115:4: ( ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) ) )
					// InternalWeightDefinition.g:2116:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) ) ( (lv_value_6_0= ruleXAssignment ) )
					{
					// InternalWeightDefinition.g:2116:5: ( ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
					// InternalWeightDefinition.g:2117:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )=> ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					{
					// InternalWeightDefinition.g:2137:6: ( () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
					// InternalWeightDefinition.g:2138:7: () (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
					{
					// InternalWeightDefinition.g:2138:7: ()
					// InternalWeightDefinition.g:2139:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXMemberFeatureCallAccess().getXAssignmentAssignableAction_1_0_0_0_0(),
														current);
												}
					}

					// InternalWeightDefinition.g:2145:7: (otherlv_2= '.' | ( (lv_explicitStatic_3_0= '::' ) ) )
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==34) ) {
						alt27=1;
					}
					else if ( (LA27_0==40) ) {
						alt27=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 27, 0, input);
						throw nvae;
					}

					switch (alt27) {
						case 1 :
							// InternalWeightDefinition.g:2146:8: otherlv_2= '.'
							{
							otherlv_2=(Token)match(input,34,FOLLOW_30); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(otherlv_2, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_0_0_0_1_0());
														}
							}
							break;
						case 2 :
							// InternalWeightDefinition.g:2151:8: ( (lv_explicitStatic_3_0= '::' ) )
							{
							// InternalWeightDefinition.g:2151:8: ( (lv_explicitStatic_3_0= '::' ) )
							// InternalWeightDefinition.g:2152:9: (lv_explicitStatic_3_0= '::' )
							{
							// InternalWeightDefinition.g:2152:9: (lv_explicitStatic_3_0= '::' )
							// InternalWeightDefinition.g:2153:10: lv_explicitStatic_3_0= '::'
							{
							lv_explicitStatic_3_0=(Token)match(input,40,FOLLOW_30); if (state.failed) return current;
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

					// InternalWeightDefinition.g:2166:7: ( ( ruleFeatureCallID ) )
					// InternalWeightDefinition.g:2167:8: ( ruleFeatureCallID )
					{
					// InternalWeightDefinition.g:2167:8: ( ruleFeatureCallID )
					// InternalWeightDefinition.g:2168:9: ruleFeatureCallID
					{
					if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
														}
													}
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_0_0_0_2_0());
													}
					pushFollow(FOLLOW_11);
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
					pushFollow(FOLLOW_12);
					ruleOpSingleAssign();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:2191:5: ( (lv_value_6_0= ruleXAssignment ) )
					// InternalWeightDefinition.g:2192:6: (lv_value_6_0= ruleXAssignment )
					{
					// InternalWeightDefinition.g:2192:6: (lv_value_6_0= ruleXAssignment )
					// InternalWeightDefinition.g:2193:7: lv_value_6_0= ruleXAssignment
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getValueXAssignmentParserRuleCall_1_0_1_0());
											}
					pushFollow(FOLLOW_29);
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
					// InternalWeightDefinition.g:2212:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
					{
					// InternalWeightDefinition.g:2212:4: ( ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )? )
					// InternalWeightDefinition.g:2213:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) ) (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )? ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
					{
					// InternalWeightDefinition.g:2213:5: ( ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) ) )
					// InternalWeightDefinition.g:2214:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )=> ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
					{
					// InternalWeightDefinition.g:2234:6: ( () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) ) )
					// InternalWeightDefinition.g:2235:7: () (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
					{
					// InternalWeightDefinition.g:2235:7: ()
					// InternalWeightDefinition.g:2236:8: 
					{
					if ( state.backtracking==0 ) {
													current = forceCreateModelElementAndSet(
														grammarAccess.getXMemberFeatureCallAccess().getXMemberFeatureCallMemberCallTargetAction_1_1_0_0_0(),
														current);
												}
					}

					// InternalWeightDefinition.g:2242:7: (otherlv_8= '.' | ( (lv_nullSafe_9_0= '?.' ) ) | ( (lv_explicitStatic_10_0= '::' ) ) )
					int alt28=3;
					switch ( input.LA(1) ) {
					case 34:
						{
						alt28=1;
						}
						break;
					case 51:
						{
						alt28=2;
						}
						break;
					case 40:
						{
						alt28=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 28, 0, input);
						throw nvae;
					}
					switch (alt28) {
						case 1 :
							// InternalWeightDefinition.g:2243:8: otherlv_8= '.'
							{
							otherlv_8=(Token)match(input,34,FOLLOW_31); if (state.failed) return current;
							if ( state.backtracking==0 ) {
															newLeafNode(otherlv_8, grammarAccess.getXMemberFeatureCallAccess().getFullStopKeyword_1_1_0_0_1_0());
														}
							}
							break;
						case 2 :
							// InternalWeightDefinition.g:2248:8: ( (lv_nullSafe_9_0= '?.' ) )
							{
							// InternalWeightDefinition.g:2248:8: ( (lv_nullSafe_9_0= '?.' ) )
							// InternalWeightDefinition.g:2249:9: (lv_nullSafe_9_0= '?.' )
							{
							// InternalWeightDefinition.g:2249:9: (lv_nullSafe_9_0= '?.' )
							// InternalWeightDefinition.g:2250:10: lv_nullSafe_9_0= '?.'
							{
							lv_nullSafe_9_0=(Token)match(input,51,FOLLOW_31); if (state.failed) return current;
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
							// InternalWeightDefinition.g:2263:8: ( (lv_explicitStatic_10_0= '::' ) )
							{
							// InternalWeightDefinition.g:2263:8: ( (lv_explicitStatic_10_0= '::' ) )
							// InternalWeightDefinition.g:2264:9: (lv_explicitStatic_10_0= '::' )
							{
							// InternalWeightDefinition.g:2264:9: (lv_explicitStatic_10_0= '::' )
							// InternalWeightDefinition.g:2265:10: lv_explicitStatic_10_0= '::'
							{
							lv_explicitStatic_10_0=(Token)match(input,40,FOLLOW_31); if (state.failed) return current;
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

					// InternalWeightDefinition.g:2280:5: (otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>' )?
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( (LA30_0==42) ) {
						alt30=1;
					}
					switch (alt30) {
						case 1 :
							// InternalWeightDefinition.g:2281:6: otherlv_11= '<' ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) ) (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )* otherlv_15= '>'
							{
							otherlv_11=(Token)match(input,42,FOLLOW_32); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_11, grammarAccess.getXMemberFeatureCallAccess().getLessThanSignKeyword_1_1_1_0());
												}
							// InternalWeightDefinition.g:2285:6: ( (lv_typeArguments_12_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:2286:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:2286:7: (lv_typeArguments_12_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:2287:8: lv_typeArguments_12_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_1_0());
														}
							pushFollow(FOLLOW_33);
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

							// InternalWeightDefinition.g:2304:6: (otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) ) )*
							loop29:
							while (true) {
								int alt29=2;
								int LA29_0 = input.LA(1);
								if ( (LA29_0==29) ) {
									alt29=1;
								}

								switch (alt29) {
								case 1 :
									// InternalWeightDefinition.g:2305:7: otherlv_13= ',' ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
									{
									otherlv_13=(Token)match(input,29,FOLLOW_32); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_13, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_1_2_0());
															}
									// InternalWeightDefinition.g:2309:7: ( (lv_typeArguments_14_0= ruleJvmArgumentTypeReference ) )
									// InternalWeightDefinition.g:2310:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
									{
									// InternalWeightDefinition.g:2310:8: (lv_typeArguments_14_0= ruleJvmArgumentTypeReference )
									// InternalWeightDefinition.g:2311:9: lv_typeArguments_14_0= ruleJvmArgumentTypeReference
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_1_2_1_0());
																	}
									pushFollow(FOLLOW_33);
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
									break loop29;
								}
							}

							otherlv_15=(Token)match(input,48,FOLLOW_34); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_15, grammarAccess.getXMemberFeatureCallAccess().getGreaterThanSignKeyword_1_1_1_3());
												}
							}
							break;

					}

					// InternalWeightDefinition.g:2334:5: ( ( ruleIdOrSuper ) )
					// InternalWeightDefinition.g:2335:6: ( ruleIdOrSuper )
					{
					// InternalWeightDefinition.g:2335:6: ( ruleIdOrSuper )
					// InternalWeightDefinition.g:2336:7: ruleIdOrSuper
					{
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXMemberFeatureCallRule());
												}
											}
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_1_1_2_0());
											}
					pushFollow(FOLLOW_35);
					ruleIdOrSuper();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:2350:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?
					int alt33=2;
					alt33 = dfa33.predict(input);
					switch (alt33) {
						case 1 :
							// InternalWeightDefinition.g:2351:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')'
							{
							// InternalWeightDefinition.g:2351:6: ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) )
							// InternalWeightDefinition.g:2352:7: ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' )
							{
							// InternalWeightDefinition.g:2356:7: (lv_explicitOperationCall_17_0= '(' )
							// InternalWeightDefinition.g:2357:8: lv_explicitOperationCall_17_0= '('
							{
							lv_explicitOperationCall_17_0=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
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

							// InternalWeightDefinition.g:2369:6: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )?
							int alt32=3;
							int LA32_0 = input.LA(1);
							if ( (LA32_0==RULE_ID) ) {
								int LA32_1 = input.LA(2);
								if ( (synpred17_InternalWeightDefinition()) ) {
									alt32=1;
								}
								else if ( (true) ) {
									alt32=2;
								}
							}
							else if ( (LA32_0==21) ) {
								int LA32_2 = input.LA(2);
								if ( (synpred17_InternalWeightDefinition()) ) {
									alt32=1;
								}
								else if ( (true) ) {
									alt32=2;
								}
							}
							else if ( (LA32_0==47) && (synpred17_InternalWeightDefinition())) {
								alt32=1;
							}
							else if ( (LA32_0==86) && (synpred17_InternalWeightDefinition())) {
								alt32=1;
							}
							else if ( ((LA32_0 >= RULE_DECIMAL && LA32_0 <= RULE_HEX)||LA32_0==RULE_INT||LA32_0==RULE_STRING||LA32_0==13||LA32_0==16||LA32_0==26||LA32_0==30||LA32_0==42||LA32_0==53||LA32_0==59||(LA32_0 >= 61 && LA32_0 <= 63)||LA32_0==65||(LA32_0 >= 67 && LA32_0 <= 68)||(LA32_0 >= 70 && LA32_0 <= 72)||(LA32_0 >= 74 && LA32_0 <= 81)||(LA32_0 >= 84 && LA32_0 <= 85)) ) {
								alt32=2;
							}
							switch (alt32) {
								case 1 :
									// InternalWeightDefinition.g:2370:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
									{
									// InternalWeightDefinition.g:2370:7: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) )
									// InternalWeightDefinition.g:2371:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure )
									{
									// InternalWeightDefinition.g:2396:8: (lv_memberCallArguments_18_0= ruleXShortClosure )
									// InternalWeightDefinition.g:2397:9: lv_memberCallArguments_18_0= ruleXShortClosure
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXShortClosureParserRuleCall_1_1_3_1_0_0());
																	}
									pushFollow(FOLLOW_37);
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
									// InternalWeightDefinition.g:2415:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
									{
									// InternalWeightDefinition.g:2415:7: ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* )
									// InternalWeightDefinition.g:2416:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
									{
									// InternalWeightDefinition.g:2416:8: ( (lv_memberCallArguments_19_0= ruleXExpression ) )
									// InternalWeightDefinition.g:2417:9: (lv_memberCallArguments_19_0= ruleXExpression )
									{
									// InternalWeightDefinition.g:2417:9: (lv_memberCallArguments_19_0= ruleXExpression )
									// InternalWeightDefinition.g:2418:10: lv_memberCallArguments_19_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																			newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_0_0());
																		}
									pushFollow(FOLLOW_10);
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

									// InternalWeightDefinition.g:2435:8: (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )*
									loop31:
									while (true) {
										int alt31=2;
										int LA31_0 = input.LA(1);
										if ( (LA31_0==29) ) {
											alt31=1;
										}

										switch (alt31) {
										case 1 :
											// InternalWeightDefinition.g:2436:9: otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) )
											{
											otherlv_20=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																				newLeafNode(otherlv_20, grammarAccess.getXMemberFeatureCallAccess().getCommaKeyword_1_1_3_1_1_1_0());
																			}
											// InternalWeightDefinition.g:2440:9: ( (lv_memberCallArguments_21_0= ruleXExpression ) )
											// InternalWeightDefinition.g:2441:10: (lv_memberCallArguments_21_0= ruleXExpression )
											{
											// InternalWeightDefinition.g:2441:10: (lv_memberCallArguments_21_0= ruleXExpression )
											// InternalWeightDefinition.g:2442:11: lv_memberCallArguments_21_0= ruleXExpression
											{
											if ( state.backtracking==0 ) {
																						newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXExpressionParserRuleCall_1_1_3_1_1_1_1_0());
																					}
											pushFollow(FOLLOW_10);
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
											break loop31;
										}
									}

									}

									}
									break;

							}

							otherlv_22=(Token)match(input,22,FOLLOW_38); if (state.failed) return current;
							if ( state.backtracking==0 ) {
													newLeafNode(otherlv_22, grammarAccess.getXMemberFeatureCallAccess().getRightParenthesisKeyword_1_1_3_2());
												}
							}
							break;

					}

					// InternalWeightDefinition.g:2467:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?
					int alt34=2;
					alt34 = dfa34.predict(input);
					switch (alt34) {
						case 1 :
							// InternalWeightDefinition.g:2468:6: ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure )
							{
							// InternalWeightDefinition.g:2474:6: (lv_memberCallArguments_23_0= ruleXClosure )
							// InternalWeightDefinition.g:2475:7: lv_memberCallArguments_23_0= ruleXClosure
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXMemberFeatureCallAccess().getMemberCallArgumentsXClosureParserRuleCall_1_1_4_0());
													}
							pushFollow(FOLLOW_29);
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
					break loop35;
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
	// InternalWeightDefinition.g:2498:1: entryRuleXPrimaryExpression returns [EObject current=null] :iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF ;
	public final EObject entryRuleXPrimaryExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXPrimaryExpression =null;

		try {
			// InternalWeightDefinition.g:2498:59: (iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF )
			// InternalWeightDefinition.g:2499:2: iv_ruleXPrimaryExpression= ruleXPrimaryExpression EOF
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
	// InternalWeightDefinition.g:2505:1: ruleXPrimaryExpression returns [EObject current=null] : (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) ;
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
			// InternalWeightDefinition.g:2511:2: ( (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression ) )
			// InternalWeightDefinition.g:2512:2: (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
			{
			// InternalWeightDefinition.g:2512:2: (this_XConstructorCall_0= ruleXConstructorCall |this_XBlockExpression_1= ruleXBlockExpression |this_XSwitchExpression_2= ruleXSwitchExpression | ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression ) |this_XFeatureCall_4= ruleXFeatureCall |this_XLiteral_5= ruleXLiteral |this_XIfExpression_6= ruleXIfExpression | ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression ) |this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression |this_XWhileExpression_9= ruleXWhileExpression |this_XDoWhileExpression_10= ruleXDoWhileExpression |this_XThrowExpression_11= ruleXThrowExpression |this_XReturnExpression_12= ruleXReturnExpression |this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression |this_XParenthesizedExpression_14= ruleXParenthesizedExpression )
			int alt36=15;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==70) ) {
				alt36=1;
			}
			else if ( (LA36_0==85) ) {
				alt36=2;
			}
			else if ( (LA36_0==76) ) {
				alt36=3;
			}
			else if ( (LA36_0==77) && (synpred19_InternalWeightDefinition())) {
				alt36=4;
			}
			else if ( (LA36_0==RULE_ID||LA36_0==42||(LA36_0 >= 61 && LA36_0 <= 62)||LA36_0==68||(LA36_0 >= 74 && LA36_0 <= 75)) ) {
				alt36=5;
			}
			else if ( ((LA36_0 >= RULE_DECIMAL && LA36_0 <= RULE_HEX)||LA36_0==RULE_INT||LA36_0==RULE_STRING||LA36_0==16||LA36_0==53||LA36_0==63||LA36_0==71||LA36_0==79||LA36_0==81) ) {
				alt36=6;
			}
			else if ( (LA36_0==67) ) {
				alt36=7;
			}
			else if ( (LA36_0==65) ) {
				int LA36_23 = input.LA(2);
				if ( (synpred20_InternalWeightDefinition()) ) {
					alt36=8;
				}
				else if ( (true) ) {
					alt36=9;
				}

			}
			else if ( (LA36_0==84) ) {
				alt36=10;
			}
			else if ( (LA36_0==59) ) {
				alt36=11;
			}
			else if ( (LA36_0==78) ) {
				alt36=12;
			}
			else if ( (LA36_0==72) ) {
				alt36=13;
			}
			else if ( (LA36_0==80) ) {
				alt36=14;
			}
			else if ( (LA36_0==21) ) {
				alt36=15;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// InternalWeightDefinition.g:2513:3: this_XConstructorCall_0= ruleXConstructorCall
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
					// InternalWeightDefinition.g:2522:3: this_XBlockExpression_1= ruleXBlockExpression
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
					// InternalWeightDefinition.g:2531:3: this_XSwitchExpression_2= ruleXSwitchExpression
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
					// InternalWeightDefinition.g:2540:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
					{
					// InternalWeightDefinition.g:2540:3: ( ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression )
					// InternalWeightDefinition.g:2541:4: ( ( () 'synchronized' '(' ) )=>this_XSynchronizedExpression_3= ruleXSynchronizedExpression
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
					// InternalWeightDefinition.g:2558:3: this_XFeatureCall_4= ruleXFeatureCall
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
					// InternalWeightDefinition.g:2567:3: this_XLiteral_5= ruleXLiteral
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
					// InternalWeightDefinition.g:2576:3: this_XIfExpression_6= ruleXIfExpression
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
					// InternalWeightDefinition.g:2585:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
					{
					// InternalWeightDefinition.g:2585:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression )
					// InternalWeightDefinition.g:2586:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=>this_XForLoopExpression_7= ruleXForLoopExpression
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
					// InternalWeightDefinition.g:2609:3: this_XBasicForLoopExpression_8= ruleXBasicForLoopExpression
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
					// InternalWeightDefinition.g:2618:3: this_XWhileExpression_9= ruleXWhileExpression
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
					// InternalWeightDefinition.g:2627:3: this_XDoWhileExpression_10= ruleXDoWhileExpression
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
					// InternalWeightDefinition.g:2636:3: this_XThrowExpression_11= ruleXThrowExpression
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
					// InternalWeightDefinition.g:2645:3: this_XReturnExpression_12= ruleXReturnExpression
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
					// InternalWeightDefinition.g:2654:3: this_XTryCatchFinallyExpression_13= ruleXTryCatchFinallyExpression
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
					// InternalWeightDefinition.g:2663:3: this_XParenthesizedExpression_14= ruleXParenthesizedExpression
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
	// InternalWeightDefinition.g:2675:1: entryRuleXLiteral returns [EObject current=null] :iv_ruleXLiteral= ruleXLiteral EOF ;
	public final EObject entryRuleXLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXLiteral =null;

		try {
			// InternalWeightDefinition.g:2675:49: (iv_ruleXLiteral= ruleXLiteral EOF )
			// InternalWeightDefinition.g:2676:2: iv_ruleXLiteral= ruleXLiteral EOF
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
	// InternalWeightDefinition.g:2682:1: ruleXLiteral returns [EObject current=null] : (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral ) ;
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
			// InternalWeightDefinition.g:2688:2: ( (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral ) )
			// InternalWeightDefinition.g:2689:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral )
			{
			// InternalWeightDefinition.g:2689:2: (this_XCollectionLiteral_0= ruleXCollectionLiteral | ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure ) |this_XBooleanLiteral_2= ruleXBooleanLiteral |this_XNumberLiteral_3= ruleXNumberLiteral |this_XNullLiteral_4= ruleXNullLiteral |this_XStringLiteral_5= ruleXStringLiteral |this_XTypeLiteral_6= ruleXTypeLiteral )
			int alt37=7;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==16) ) {
				alt37=1;
			}
			else if ( (LA37_0==53) && (synpred21_InternalWeightDefinition())) {
				alt37=2;
			}
			else if ( (LA37_0==63||LA37_0==79) ) {
				alt37=3;
			}
			else if ( ((LA37_0 >= RULE_DECIMAL && LA37_0 <= RULE_HEX)||LA37_0==RULE_INT) ) {
				alt37=4;
			}
			else if ( (LA37_0==71) ) {
				alt37=5;
			}
			else if ( (LA37_0==RULE_STRING) ) {
				alt37=6;
			}
			else if ( (LA37_0==81) ) {
				alt37=7;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// InternalWeightDefinition.g:2690:3: this_XCollectionLiteral_0= ruleXCollectionLiteral
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
					// InternalWeightDefinition.g:2699:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
					{
					// InternalWeightDefinition.g:2699:3: ( ( ( () '[' ) )=>this_XClosure_1= ruleXClosure )
					// InternalWeightDefinition.g:2700:4: ( ( () '[' ) )=>this_XClosure_1= ruleXClosure
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
					// InternalWeightDefinition.g:2716:3: this_XBooleanLiteral_2= ruleXBooleanLiteral
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
					// InternalWeightDefinition.g:2725:3: this_XNumberLiteral_3= ruleXNumberLiteral
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
					// InternalWeightDefinition.g:2734:3: this_XNullLiteral_4= ruleXNullLiteral
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
					// InternalWeightDefinition.g:2743:3: this_XStringLiteral_5= ruleXStringLiteral
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
					// InternalWeightDefinition.g:2752:3: this_XTypeLiteral_6= ruleXTypeLiteral
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
	// InternalWeightDefinition.g:2764:1: entryRuleXCollectionLiteral returns [EObject current=null] :iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF ;
	public final EObject entryRuleXCollectionLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCollectionLiteral =null;

		try {
			// InternalWeightDefinition.g:2764:59: (iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF )
			// InternalWeightDefinition.g:2765:2: iv_ruleXCollectionLiteral= ruleXCollectionLiteral EOF
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
	// InternalWeightDefinition.g:2771:1: ruleXCollectionLiteral returns [EObject current=null] : (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral ) ;
	public final EObject ruleXCollectionLiteral() throws RecognitionException {
		EObject current = null;


		EObject this_XSetLiteral_0 =null;
		EObject this_XListLiteral_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:2777:2: ( (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral ) )
			// InternalWeightDefinition.g:2778:2: (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral )
			{
			// InternalWeightDefinition.g:2778:2: (this_XSetLiteral_0= ruleXSetLiteral |this_XListLiteral_1= ruleXListLiteral )
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==16) ) {
				int LA38_1 = input.LA(2);
				if ( (LA38_1==85) ) {
					alt38=1;
				}
				else if ( (LA38_1==53) ) {
					alt38=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return current;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 38, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// InternalWeightDefinition.g:2779:3: this_XSetLiteral_0= ruleXSetLiteral
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
					// InternalWeightDefinition.g:2788:3: this_XListLiteral_1= ruleXListLiteral
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
	// InternalWeightDefinition.g:2800:1: entryRuleXSetLiteral returns [EObject current=null] :iv_ruleXSetLiteral= ruleXSetLiteral EOF ;
	public final EObject entryRuleXSetLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSetLiteral =null;

		try {
			// InternalWeightDefinition.g:2800:52: (iv_ruleXSetLiteral= ruleXSetLiteral EOF )
			// InternalWeightDefinition.g:2801:2: iv_ruleXSetLiteral= ruleXSetLiteral EOF
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
	// InternalWeightDefinition.g:2807:1: ruleXSetLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) ;
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
			// InternalWeightDefinition.g:2813:2: ( ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' ) )
			// InternalWeightDefinition.g:2814:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			{
			// InternalWeightDefinition.g:2814:2: ( () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}' )
			// InternalWeightDefinition.g:2815:3: () otherlv_1= '#' otherlv_2= '{' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= '}'
			{
			// InternalWeightDefinition.g:2815:3: ()
			// InternalWeightDefinition.g:2816:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXSetLiteralAccess().getXSetLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,16,FOLLOW_6); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXSetLiteralAccess().getNumberSignKeyword_1());
					}
			otherlv_2=(Token)match(input,85,FOLLOW_39); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXSetLiteralAccess().getLeftCurlyBracketKeyword_2());
					}
			// InternalWeightDefinition.g:2830:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( ((LA40_0 >= RULE_DECIMAL && LA40_0 <= RULE_INT)||LA40_0==RULE_STRING||LA40_0==13||LA40_0==16||LA40_0==21||LA40_0==26||LA40_0==30||LA40_0==42||LA40_0==53||LA40_0==59||(LA40_0 >= 61 && LA40_0 <= 63)||LA40_0==65||(LA40_0 >= 67 && LA40_0 <= 68)||(LA40_0 >= 70 && LA40_0 <= 72)||(LA40_0 >= 74 && LA40_0 <= 81)||(LA40_0 >= 84 && LA40_0 <= 85)) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// InternalWeightDefinition.g:2831:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalWeightDefinition.g:2831:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalWeightDefinition.g:2832:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:2832:5: (lv_elements_3_0= ruleXExpression )
					// InternalWeightDefinition.g:2833:6: lv_elements_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_40);
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

					// InternalWeightDefinition.g:2850:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop39:
					while (true) {
						int alt39=2;
						int LA39_0 = input.LA(1);
						if ( (LA39_0==29) ) {
							alt39=1;
						}

						switch (alt39) {
						case 1 :
							// InternalWeightDefinition.g:2851:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXSetLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalWeightDefinition.g:2855:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalWeightDefinition.g:2856:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:2856:6: (lv_elements_5_0= ruleXExpression )
							// InternalWeightDefinition.g:2857:7: lv_elements_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXSetLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_40);
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
							break loop39;
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
	// InternalWeightDefinition.g:2884:1: entryRuleXListLiteral returns [EObject current=null] :iv_ruleXListLiteral= ruleXListLiteral EOF ;
	public final EObject entryRuleXListLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXListLiteral =null;

		try {
			// InternalWeightDefinition.g:2884:53: (iv_ruleXListLiteral= ruleXListLiteral EOF )
			// InternalWeightDefinition.g:2885:2: iv_ruleXListLiteral= ruleXListLiteral EOF
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
	// InternalWeightDefinition.g:2891:1: ruleXListLiteral returns [EObject current=null] : ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) ;
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
			// InternalWeightDefinition.g:2897:2: ( ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' ) )
			// InternalWeightDefinition.g:2898:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			{
			// InternalWeightDefinition.g:2898:2: ( () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']' )
			// InternalWeightDefinition.g:2899:3: () otherlv_1= '#' otherlv_2= '[' ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )? otherlv_6= ']'
			{
			// InternalWeightDefinition.g:2899:3: ()
			// InternalWeightDefinition.g:2900:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXListLiteralAccess().getXListLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,16,FOLLOW_41); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXListLiteralAccess().getNumberSignKeyword_1());
					}
			otherlv_2=(Token)match(input,53,FOLLOW_42); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXListLiteralAccess().getLeftSquareBracketKeyword_2());
					}
			// InternalWeightDefinition.g:2914:3: ( ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )* )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( ((LA42_0 >= RULE_DECIMAL && LA42_0 <= RULE_INT)||LA42_0==RULE_STRING||LA42_0==13||LA42_0==16||LA42_0==21||LA42_0==26||LA42_0==30||LA42_0==42||LA42_0==53||LA42_0==59||(LA42_0 >= 61 && LA42_0 <= 63)||LA42_0==65||(LA42_0 >= 67 && LA42_0 <= 68)||(LA42_0 >= 70 && LA42_0 <= 72)||(LA42_0 >= 74 && LA42_0 <= 81)||(LA42_0 >= 84 && LA42_0 <= 85)) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// InternalWeightDefinition.g:2915:4: ( (lv_elements_3_0= ruleXExpression ) ) (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					{
					// InternalWeightDefinition.g:2915:4: ( (lv_elements_3_0= ruleXExpression ) )
					// InternalWeightDefinition.g:2916:5: (lv_elements_3_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:2916:5: (lv_elements_3_0= ruleXExpression )
					// InternalWeightDefinition.g:2917:6: lv_elements_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_43);
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

					// InternalWeightDefinition.g:2934:4: (otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) ) )*
					loop41:
					while (true) {
						int alt41=2;
						int LA41_0 = input.LA(1);
						if ( (LA41_0==29) ) {
							alt41=1;
						}

						switch (alt41) {
						case 1 :
							// InternalWeightDefinition.g:2935:5: otherlv_4= ',' ( (lv_elements_5_0= ruleXExpression ) )
							{
							otherlv_4=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXListLiteralAccess().getCommaKeyword_3_1_0());
											}
							// InternalWeightDefinition.g:2939:5: ( (lv_elements_5_0= ruleXExpression ) )
							// InternalWeightDefinition.g:2940:6: (lv_elements_5_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:2940:6: (lv_elements_5_0= ruleXExpression )
							// InternalWeightDefinition.g:2941:7: lv_elements_5_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXListLiteralAccess().getElementsXExpressionParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_43);
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
							break loop41;
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
	// InternalWeightDefinition.g:2968:1: entryRuleXClosure returns [EObject current=null] :iv_ruleXClosure= ruleXClosure EOF ;
	public final EObject entryRuleXClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXClosure =null;

		try {
			// InternalWeightDefinition.g:2968:49: (iv_ruleXClosure= ruleXClosure EOF )
			// InternalWeightDefinition.g:2969:2: iv_ruleXClosure= ruleXClosure EOF
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
	// InternalWeightDefinition.g:2975:1: ruleXClosure returns [EObject current=null] : ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) ;
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
			// InternalWeightDefinition.g:2981:2: ( ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' ) )
			// InternalWeightDefinition.g:2982:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
			{
			// InternalWeightDefinition.g:2982:2: ( ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']' )
			// InternalWeightDefinition.g:2983:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) ) ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )? ( (lv_expression_6_0= ruleXExpressionInClosure ) ) otherlv_7= ']'
			{
			// InternalWeightDefinition.g:2983:3: ( ( ( () '[' ) )=> ( () otherlv_1= '[' ) )
			// InternalWeightDefinition.g:2984:4: ( ( () '[' ) )=> ( () otherlv_1= '[' )
			{
			// InternalWeightDefinition.g:2990:4: ( () otherlv_1= '[' )
			// InternalWeightDefinition.g:2991:5: () otherlv_1= '['
			{
			// InternalWeightDefinition.g:2991:5: ()
			// InternalWeightDefinition.g:2992:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXClosureAccess().getXClosureAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,53,FOLLOW_44); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXClosureAccess().getLeftSquareBracketKeyword_0_0_1());
							}
			}

			}

			// InternalWeightDefinition.g:3004:3: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) ) )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==RULE_ID) ) {
				int LA45_1 = input.LA(2);
				if ( (synpred23_InternalWeightDefinition()) ) {
					alt45=1;
				}
			}
			else if ( (LA45_0==21) ) {
				int LA45_2 = input.LA(2);
				if ( (synpred23_InternalWeightDefinition()) ) {
					alt45=1;
				}
			}
			else if ( (LA45_0==47) && (synpred23_InternalWeightDefinition())) {
				alt45=1;
			}
			else if ( (LA45_0==86) && (synpred23_InternalWeightDefinition())) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// InternalWeightDefinition.g:3005:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
					{
					// InternalWeightDefinition.g:3028:4: ( ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) ) )
					// InternalWeightDefinition.g:3029:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_5_0= '|' ) )
					{
					// InternalWeightDefinition.g:3029:5: ( ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )* )?
					int alt44=2;
					int LA44_0 = input.LA(1);
					if ( (LA44_0==RULE_ID||LA44_0==21||LA44_0==47) ) {
						alt44=1;
					}
					switch (alt44) {
						case 1 :
							// InternalWeightDefinition.g:3030:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) ) (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
							{
							// InternalWeightDefinition.g:3030:6: ( (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter ) )
							// InternalWeightDefinition.g:3031:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
							{
							// InternalWeightDefinition.g:3031:7: (lv_declaredFormalParameters_2_0= ruleJvmFormalParameter )
							// InternalWeightDefinition.g:3032:8: lv_declaredFormalParameters_2_0= ruleJvmFormalParameter
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_0_0());
														}
							pushFollow(FOLLOW_45);
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

							// InternalWeightDefinition.g:3049:6: (otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) ) )*
							loop43:
							while (true) {
								int alt43=2;
								int LA43_0 = input.LA(1);
								if ( (LA43_0==29) ) {
									alt43=1;
								}

								switch (alt43) {
								case 1 :
									// InternalWeightDefinition.g:3050:7: otherlv_3= ',' ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
									{
									otherlv_3=(Token)match(input,29,FOLLOW_7); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_3, grammarAccess.getXClosureAccess().getCommaKeyword_1_0_0_1_0());
															}
									// InternalWeightDefinition.g:3054:7: ( (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter ) )
									// InternalWeightDefinition.g:3055:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
									{
									// InternalWeightDefinition.g:3055:8: (lv_declaredFormalParameters_4_0= ruleJvmFormalParameter )
									// InternalWeightDefinition.g:3056:9: lv_declaredFormalParameters_4_0= ruleJvmFormalParameter
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_1_0_0_1_1_0());
																	}
									pushFollow(FOLLOW_45);
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
									break loop43;
								}
							}

							}
							break;

					}

					// InternalWeightDefinition.g:3075:5: ( (lv_explicitSyntax_5_0= '|' ) )
					// InternalWeightDefinition.g:3076:6: (lv_explicitSyntax_5_0= '|' )
					{
					// InternalWeightDefinition.g:3076:6: (lv_explicitSyntax_5_0= '|' )
					// InternalWeightDefinition.g:3077:7: lv_explicitSyntax_5_0= '|'
					{
					lv_explicitSyntax_5_0=(Token)match(input,86,FOLLOW_46); if (state.failed) return current;
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

			// InternalWeightDefinition.g:3091:3: ( (lv_expression_6_0= ruleXExpressionInClosure ) )
			// InternalWeightDefinition.g:3092:4: (lv_expression_6_0= ruleXExpressionInClosure )
			{
			// InternalWeightDefinition.g:3092:4: (lv_expression_6_0= ruleXExpressionInClosure )
			// InternalWeightDefinition.g:3093:5: lv_expression_6_0= ruleXExpressionInClosure
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXClosureAccess().getExpressionXExpressionInClosureParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_47);
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
	// InternalWeightDefinition.g:3118:1: entryRuleXExpressionInClosure returns [EObject current=null] :iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF ;
	public final EObject entryRuleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionInClosure =null;

		try {
			// InternalWeightDefinition.g:3118:61: (iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF )
			// InternalWeightDefinition.g:3119:2: iv_ruleXExpressionInClosure= ruleXExpressionInClosure EOF
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
	// InternalWeightDefinition.g:3125:1: ruleXExpressionInClosure returns [EObject current=null] : ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) ;
	public final EObject ruleXExpressionInClosure() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		EObject lv_expressions_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3131:2: ( ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* ) )
			// InternalWeightDefinition.g:3132:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			{
			// InternalWeightDefinition.g:3132:2: ( () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )* )
			// InternalWeightDefinition.g:3133:3: () ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			{
			// InternalWeightDefinition.g:3133:3: ()
			// InternalWeightDefinition.g:3134:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXExpressionInClosureAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:3140:3: ( ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )? )*
			loop47:
			while (true) {
				int alt47=2;
				int LA47_0 = input.LA(1);
				if ( ((LA47_0 >= RULE_DECIMAL && LA47_0 <= RULE_INT)||LA47_0==RULE_STRING||LA47_0==13||LA47_0==16||LA47_0==21||LA47_0==26||LA47_0==30||LA47_0==42||LA47_0==53||LA47_0==59||(LA47_0 >= 61 && LA47_0 <= 63)||LA47_0==65||(LA47_0 >= 67 && LA47_0 <= 68)||(LA47_0 >= 70 && LA47_0 <= 72)||(LA47_0 >= 74 && LA47_0 <= 85)) ) {
					alt47=1;
				}

				switch (alt47) {
				case 1 :
					// InternalWeightDefinition.g:3141:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_2= ';' )?
					{
					// InternalWeightDefinition.g:3141:4: ( (lv_expressions_1_0= ruleXExpressionOrVarDeclaration ) )
					// InternalWeightDefinition.g:3142:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalWeightDefinition.g:3142:5: (lv_expressions_1_0= ruleXExpressionOrVarDeclaration )
					// InternalWeightDefinition.g:3143:6: lv_expressions_1_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXExpressionInClosureAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_1_0_0());
										}
					pushFollow(FOLLOW_48);
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

					// InternalWeightDefinition.g:3160:4: (otherlv_2= ';' )?
					int alt46=2;
					int LA46_0 = input.LA(1);
					if ( (LA46_0==41) ) {
						alt46=1;
					}
					switch (alt46) {
						case 1 :
							// InternalWeightDefinition.g:3161:5: otherlv_2= ';'
							{
							otherlv_2=(Token)match(input,41,FOLLOW_49); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXExpressionInClosureAccess().getSemicolonKeyword_1_1());
											}
							}
							break;

					}

					}
					break;

				default :
					break loop47;
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
	// InternalWeightDefinition.g:3171:1: entryRuleXShortClosure returns [EObject current=null] :iv_ruleXShortClosure= ruleXShortClosure EOF ;
	public final EObject entryRuleXShortClosure() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXShortClosure =null;

		try {
			// InternalWeightDefinition.g:3171:54: (iv_ruleXShortClosure= ruleXShortClosure EOF )
			// InternalWeightDefinition.g:3172:2: iv_ruleXShortClosure= ruleXShortClosure EOF
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
	// InternalWeightDefinition.g:3178:1: ruleXShortClosure returns [EObject current=null] : ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) ;
	public final EObject ruleXShortClosure() throws RecognitionException {
		EObject current = null;


		Token otherlv_2=null;
		Token lv_explicitSyntax_4_0=null;
		EObject lv_declaredFormalParameters_1_0 =null;
		EObject lv_declaredFormalParameters_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3184:2: ( ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:3185:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:3185:2: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:3186:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) ) ( (lv_expression_5_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:3186:3: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) ) )
			// InternalWeightDefinition.g:3187:4: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
			{
			// InternalWeightDefinition.g:3212:4: ( () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) ) )
			// InternalWeightDefinition.g:3213:5: () ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )? ( (lv_explicitSyntax_4_0= '|' ) )
			{
			// InternalWeightDefinition.g:3213:5: ()
			// InternalWeightDefinition.g:3214:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXShortClosureAccess().getXClosureAction_0_0_0(),
										current);
								}
			}

			// InternalWeightDefinition.g:3220:5: ( ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )* )?
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==RULE_ID||LA49_0==21||LA49_0==47) ) {
				alt49=1;
			}
			switch (alt49) {
				case 1 :
					// InternalWeightDefinition.g:3221:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) ) (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
					{
					// InternalWeightDefinition.g:3221:6: ( (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter ) )
					// InternalWeightDefinition.g:3222:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
					{
					// InternalWeightDefinition.g:3222:7: (lv_declaredFormalParameters_1_0= ruleJvmFormalParameter )
					// InternalWeightDefinition.g:3223:8: lv_declaredFormalParameters_1_0= ruleJvmFormalParameter
					{
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_0_0());
												}
					pushFollow(FOLLOW_45);
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

					// InternalWeightDefinition.g:3240:6: (otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) ) )*
					loop48:
					while (true) {
						int alt48=2;
						int LA48_0 = input.LA(1);
						if ( (LA48_0==29) ) {
							alt48=1;
						}

						switch (alt48) {
						case 1 :
							// InternalWeightDefinition.g:3241:7: otherlv_2= ',' ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
							{
							otherlv_2=(Token)match(input,29,FOLLOW_7); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_2, grammarAccess.getXShortClosureAccess().getCommaKeyword_0_0_1_1_0());
													}
							// InternalWeightDefinition.g:3245:7: ( (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter ) )
							// InternalWeightDefinition.g:3246:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
							{
							// InternalWeightDefinition.g:3246:8: (lv_declaredFormalParameters_3_0= ruleJvmFormalParameter )
							// InternalWeightDefinition.g:3247:9: lv_declaredFormalParameters_3_0= ruleJvmFormalParameter
							{
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXShortClosureAccess().getDeclaredFormalParametersJvmFormalParameterParserRuleCall_0_0_1_1_1_0());
															}
							pushFollow(FOLLOW_45);
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
							break loop48;
						}
					}

					}
					break;

			}

			// InternalWeightDefinition.g:3266:5: ( (lv_explicitSyntax_4_0= '|' ) )
			// InternalWeightDefinition.g:3267:6: (lv_explicitSyntax_4_0= '|' )
			{
			// InternalWeightDefinition.g:3267:6: (lv_explicitSyntax_4_0= '|' )
			// InternalWeightDefinition.g:3268:7: lv_explicitSyntax_4_0= '|'
			{
			lv_explicitSyntax_4_0=(Token)match(input,86,FOLLOW_12); if (state.failed) return current;
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

			// InternalWeightDefinition.g:3282:3: ( (lv_expression_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3283:4: (lv_expression_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3283:4: (lv_expression_5_0= ruleXExpression )
			// InternalWeightDefinition.g:3284:5: lv_expression_5_0= ruleXExpression
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
	// InternalWeightDefinition.g:3305:1: entryRuleXParenthesizedExpression returns [EObject current=null] :iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF ;
	public final EObject entryRuleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXParenthesizedExpression =null;

		try {
			// InternalWeightDefinition.g:3305:65: (iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF )
			// InternalWeightDefinition.g:3306:2: iv_ruleXParenthesizedExpression= ruleXParenthesizedExpression EOF
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
	// InternalWeightDefinition.g:3312:1: ruleXParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) ;
	public final EObject ruleXParenthesizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_2=null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:3318:2: ( (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' ) )
			// InternalWeightDefinition.g:3319:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			{
			// InternalWeightDefinition.g:3319:2: (otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')' )
			// InternalWeightDefinition.g:3320:3: otherlv_0= '(' this_XExpression_1= ruleXExpression otherlv_2= ')'
			{
			otherlv_0=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getXParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
					}
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getXParenthesizedExpressionAccess().getXExpressionParserRuleCall_1());
					}
			pushFollow(FOLLOW_37);
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
	// InternalWeightDefinition.g:3340:1: entryRuleXIfExpression returns [EObject current=null] :iv_ruleXIfExpression= ruleXIfExpression EOF ;
	public final EObject entryRuleXIfExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXIfExpression =null;

		try {
			// InternalWeightDefinition.g:3340:54: (iv_ruleXIfExpression= ruleXIfExpression EOF )
			// InternalWeightDefinition.g:3341:2: iv_ruleXIfExpression= ruleXIfExpression EOF
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
	// InternalWeightDefinition.g:3347:1: ruleXIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) ;
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
			// InternalWeightDefinition.g:3353:2: ( ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? ) )
			// InternalWeightDefinition.g:3354:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
			{
			// InternalWeightDefinition.g:3354:2: ( () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )? )
			// InternalWeightDefinition.g:3355:3: () otherlv_1= 'if' otherlv_2= '(' ( (lv_if_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_then_5_0= ruleXExpression ) ) ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
			{
			// InternalWeightDefinition.g:3355:3: ()
			// InternalWeightDefinition.g:3356:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXIfExpressionAccess().getXIfExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,67,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXIfExpressionAccess().getIfKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXIfExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:3370:3: ( (lv_if_3_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3371:4: (lv_if_3_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3371:4: (lv_if_3_0= ruleXExpression )
			// InternalWeightDefinition.g:3372:5: lv_if_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXIfExpressionAccess().getIfXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_37);
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

			otherlv_4=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXIfExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:3393:3: ( (lv_then_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3394:4: (lv_then_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3394:4: (lv_then_5_0= ruleXExpression )
			// InternalWeightDefinition.g:3395:5: lv_then_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXIfExpressionAccess().getThenXExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_50);
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

			// InternalWeightDefinition.g:3412:3: ( ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) ) )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==60) ) {
				int LA50_1 = input.LA(2);
				if ( (synpred25_InternalWeightDefinition()) ) {
					alt50=1;
				}
			}
			switch (alt50) {
				case 1 :
					// InternalWeightDefinition.g:3413:4: ( ( 'else' )=>otherlv_6= 'else' ) ( (lv_else_7_0= ruleXExpression ) )
					{
					// InternalWeightDefinition.g:3413:4: ( ( 'else' )=>otherlv_6= 'else' )
					// InternalWeightDefinition.g:3414:5: ( 'else' )=>otherlv_6= 'else'
					{
					otherlv_6=(Token)match(input,60,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXIfExpressionAccess().getElseKeyword_6_0());
									}
					}

					// InternalWeightDefinition.g:3420:4: ( (lv_else_7_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3421:5: (lv_else_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3421:5: (lv_else_7_0= ruleXExpression )
					// InternalWeightDefinition.g:3422:6: lv_else_7_0= ruleXExpression
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
	// InternalWeightDefinition.g:3444:1: entryRuleXSwitchExpression returns [EObject current=null] :iv_ruleXSwitchExpression= ruleXSwitchExpression EOF ;
	public final EObject entryRuleXSwitchExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSwitchExpression =null;

		try {
			// InternalWeightDefinition.g:3444:58: (iv_ruleXSwitchExpression= ruleXSwitchExpression EOF )
			// InternalWeightDefinition.g:3445:2: iv_ruleXSwitchExpression= ruleXSwitchExpression EOF
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
	// InternalWeightDefinition.g:3451:1: ruleXSwitchExpression returns [EObject current=null] : ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) ;
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
			// InternalWeightDefinition.g:3457:2: ( ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' ) )
			// InternalWeightDefinition.g:3458:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
			{
			// InternalWeightDefinition.g:3458:2: ( () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}' )
			// InternalWeightDefinition.g:3459:3: () otherlv_1= 'switch' ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) ) otherlv_10= '{' ( (lv_cases_11_0= ruleXCasePart ) )* (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )? otherlv_15= '}'
			{
			// InternalWeightDefinition.g:3459:3: ()
			// InternalWeightDefinition.g:3460:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXSwitchExpressionAccess().getXSwitchExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,76,FOLLOW_51); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXSwitchExpressionAccess().getSwitchKeyword_1());
					}
			// InternalWeightDefinition.g:3470:3: ( ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' ) | ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) ) )
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==21) ) {
				int LA52_1 = input.LA(2);
				if ( (synpred26_InternalWeightDefinition()) ) {
					alt52=1;
				}
				else if ( (true) ) {
					alt52=2;
				}

			}
			else if ( ((LA52_0 >= RULE_DECIMAL && LA52_0 <= RULE_INT)||LA52_0==RULE_STRING||LA52_0==13||LA52_0==16||LA52_0==26||LA52_0==30||LA52_0==42||LA52_0==47||LA52_0==53||LA52_0==59||(LA52_0 >= 61 && LA52_0 <= 63)||LA52_0==65||(LA52_0 >= 67 && LA52_0 <= 68)||(LA52_0 >= 70 && LA52_0 <= 72)||(LA52_0 >= 74 && LA52_0 <= 81)||(LA52_0 >= 84 && LA52_0 <= 85)) ) {
				alt52=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 52, 0, input);
				throw nvae;
			}

			switch (alt52) {
				case 1 :
					// InternalWeightDefinition.g:3471:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
					{
					// InternalWeightDefinition.g:3471:4: ( ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')' )
					// InternalWeightDefinition.g:3472:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_switch_5_0= ruleXExpression ) ) otherlv_6= ')'
					{
					// InternalWeightDefinition.g:3472:5: ( ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
					// InternalWeightDefinition.g:3473:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
					{
					// InternalWeightDefinition.g:3483:6: (otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
					// InternalWeightDefinition.g:3484:7: otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
					{
					otherlv_2=(Token)match(input,21,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_2, grammarAccess.getXSwitchExpressionAccess().getLeftParenthesisKeyword_2_0_0_0_0());
											}
					// InternalWeightDefinition.g:3488:7: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
					// InternalWeightDefinition.g:3489:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
					{
					// InternalWeightDefinition.g:3489:8: (lv_declaredParam_3_0= ruleJvmFormalParameter )
					// InternalWeightDefinition.g:3490:9: lv_declaredParam_3_0= ruleJvmFormalParameter
					{
					if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_0_0_0_1_0());
													}
					pushFollow(FOLLOW_52);
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

					otherlv_4=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_0_0_0_2());
											}
					}

					}

					// InternalWeightDefinition.g:3513:5: ( (lv_switch_5_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3514:6: (lv_switch_5_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3514:6: (lv_switch_5_0= ruleXExpression )
					// InternalWeightDefinition.g:3515:7: lv_switch_5_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_0_1_0());
											}
					pushFollow(FOLLOW_37);
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

					otherlv_6=(Token)match(input,22,FOLLOW_6); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXSwitchExpressionAccess().getRightParenthesisKeyword_2_0_2());
									}
					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:3538:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
					{
					// InternalWeightDefinition.g:3538:4: ( ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) ) )
					// InternalWeightDefinition.g:3539:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )? ( (lv_switch_9_0= ruleXExpression ) )
					{
					// InternalWeightDefinition.g:3539:5: ( ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' ) )?
					int alt51=2;
					int LA51_0 = input.LA(1);
					if ( (LA51_0==RULE_ID) ) {
						int LA51_1 = input.LA(2);
						if ( (synpred27_InternalWeightDefinition()) ) {
							alt51=1;
						}
					}
					else if ( (LA51_0==21) ) {
						int LA51_2 = input.LA(2);
						if ( (synpred27_InternalWeightDefinition()) ) {
							alt51=1;
						}
					}
					else if ( (LA51_0==47) && (synpred27_InternalWeightDefinition())) {
						alt51=1;
					}
					switch (alt51) {
						case 1 :
							// InternalWeightDefinition.g:3540:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
							{
							// InternalWeightDefinition.g:3549:6: ( ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':' )
							// InternalWeightDefinition.g:3550:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) ) otherlv_8= ':'
							{
							// InternalWeightDefinition.g:3550:7: ( (lv_declaredParam_7_0= ruleJvmFormalParameter ) )
							// InternalWeightDefinition.g:3551:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
							{
							// InternalWeightDefinition.g:3551:8: (lv_declaredParam_7_0= ruleJvmFormalParameter )
							// InternalWeightDefinition.g:3552:9: lv_declaredParam_7_0= ruleJvmFormalParameter
							{
							if ( state.backtracking==0 ) {
																newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_2_1_0_0_0_0());
															}
							pushFollow(FOLLOW_52);
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

							otherlv_8=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_8, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_2_1_0_0_1());
													}
							}

							}
							break;

					}

					// InternalWeightDefinition.g:3575:5: ( (lv_switch_9_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3576:6: (lv_switch_9_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3576:6: (lv_switch_9_0= ruleXExpression )
					// InternalWeightDefinition.g:3577:7: lv_switch_9_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getSwitchXExpressionParserRuleCall_2_1_1_0());
											}
					pushFollow(FOLLOW_6);
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

			otherlv_10=(Token)match(input,85,FOLLOW_53); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_10, grammarAccess.getXSwitchExpressionAccess().getLeftCurlyBracketKeyword_3());
					}
			// InternalWeightDefinition.g:3600:3: ( (lv_cases_11_0= ruleXCasePart ) )*
			loop53:
			while (true) {
				int alt53=2;
				int LA53_0 = input.LA(1);
				if ( (LA53_0==RULE_ID||LA53_0==21||LA53_0==29||LA53_0==39||LA53_0==47||LA53_0==56) ) {
					alt53=1;
				}

				switch (alt53) {
				case 1 :
					// InternalWeightDefinition.g:3601:4: (lv_cases_11_0= ruleXCasePart )
					{
					// InternalWeightDefinition.g:3601:4: (lv_cases_11_0= ruleXCasePart )
					// InternalWeightDefinition.g:3602:5: lv_cases_11_0= ruleXCasePart
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getCasesXCasePartParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_53);
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
					break loop53;
				}
			}

			// InternalWeightDefinition.g:3619:3: (otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) ) )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==58) ) {
				alt54=1;
			}
			switch (alt54) {
				case 1 :
					// InternalWeightDefinition.g:3620:4: otherlv_12= 'default' otherlv_13= ':' ( (lv_default_14_0= ruleXExpression ) )
					{
					otherlv_12=(Token)match(input,58,FOLLOW_52); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_12, grammarAccess.getXSwitchExpressionAccess().getDefaultKeyword_5_0());
								}
					otherlv_13=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_13, grammarAccess.getXSwitchExpressionAccess().getColonKeyword_5_1());
								}
					// InternalWeightDefinition.g:3628:4: ( (lv_default_14_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3629:5: (lv_default_14_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3629:5: (lv_default_14_0= ruleXExpression )
					// InternalWeightDefinition.g:3630:6: lv_default_14_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXSwitchExpressionAccess().getDefaultXExpressionParserRuleCall_5_2_0());
										}
					pushFollow(FOLLOW_54);
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
	// InternalWeightDefinition.g:3656:1: entryRuleXCasePart returns [EObject current=null] :iv_ruleXCasePart= ruleXCasePart EOF ;
	public final EObject entryRuleXCasePart() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCasePart =null;

		try {
			// InternalWeightDefinition.g:3656:50: (iv_ruleXCasePart= ruleXCasePart EOF )
			// InternalWeightDefinition.g:3657:2: iv_ruleXCasePart= ruleXCasePart EOF
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
	// InternalWeightDefinition.g:3663:1: ruleXCasePart returns [EObject current=null] : ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) ;
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
			// InternalWeightDefinition.g:3669:2: ( ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) ) )
			// InternalWeightDefinition.g:3670:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
			{
			// InternalWeightDefinition.g:3670:2: ( () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) ) )
			// InternalWeightDefinition.g:3671:3: () ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )? (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )? ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
			{
			// InternalWeightDefinition.g:3671:3: ()
			// InternalWeightDefinition.g:3672:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXCasePartAccess().getXCasePartAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:3678:3: ( (lv_typeGuard_1_0= ruleJvmTypeReference ) )?
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==RULE_ID||LA55_0==21||LA55_0==47) ) {
				alt55=1;
			}
			switch (alt55) {
				case 1 :
					// InternalWeightDefinition.g:3679:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:3679:4: (lv_typeGuard_1_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:3680:5: lv_typeGuard_1_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXCasePartAccess().getTypeGuardJvmTypeReferenceParserRuleCall_1_0());
									}
					pushFollow(FOLLOW_55);
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

			// InternalWeightDefinition.g:3697:3: (otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) ) )?
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==56) ) {
				alt56=1;
			}
			switch (alt56) {
				case 1 :
					// InternalWeightDefinition.g:3698:4: otherlv_2= 'case' ( (lv_case_3_0= ruleXExpression ) )
					{
					otherlv_2=(Token)match(input,56,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getXCasePartAccess().getCaseKeyword_2_0());
								}
					// InternalWeightDefinition.g:3702:4: ( (lv_case_3_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3703:5: (lv_case_3_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3703:5: (lv_case_3_0= ruleXExpression )
					// InternalWeightDefinition.g:3704:6: lv_case_3_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXCasePartAccess().getCaseXExpressionParserRuleCall_2_1_0());
										}
					pushFollow(FOLLOW_56);
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

			// InternalWeightDefinition.g:3722:3: ( (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) ) | ( (lv_fallThrough_6_0= ',' ) ) )
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==39) ) {
				alt57=1;
			}
			else if ( (LA57_0==29) ) {
				alt57=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}

			switch (alt57) {
				case 1 :
					// InternalWeightDefinition.g:3723:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
					{
					// InternalWeightDefinition.g:3723:4: (otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) ) )
					// InternalWeightDefinition.g:3724:5: otherlv_4= ':' ( (lv_then_5_0= ruleXExpression ) )
					{
					otherlv_4=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_4, grammarAccess.getXCasePartAccess().getColonKeyword_3_0_0());
									}
					// InternalWeightDefinition.g:3728:5: ( (lv_then_5_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3729:6: (lv_then_5_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3729:6: (lv_then_5_0= ruleXExpression )
					// InternalWeightDefinition.g:3730:7: lv_then_5_0= ruleXExpression
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
					// InternalWeightDefinition.g:3749:4: ( (lv_fallThrough_6_0= ',' ) )
					{
					// InternalWeightDefinition.g:3749:4: ( (lv_fallThrough_6_0= ',' ) )
					// InternalWeightDefinition.g:3750:5: (lv_fallThrough_6_0= ',' )
					{
					// InternalWeightDefinition.g:3750:5: (lv_fallThrough_6_0= ',' )
					// InternalWeightDefinition.g:3751:6: lv_fallThrough_6_0= ','
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
	// InternalWeightDefinition.g:3768:1: entryRuleXForLoopExpression returns [EObject current=null] :iv_ruleXForLoopExpression= ruleXForLoopExpression EOF ;
	public final EObject entryRuleXForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXForLoopExpression =null;

		try {
			// InternalWeightDefinition.g:3768:59: (iv_ruleXForLoopExpression= ruleXForLoopExpression EOF )
			// InternalWeightDefinition.g:3769:2: iv_ruleXForLoopExpression= ruleXForLoopExpression EOF
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
	// InternalWeightDefinition.g:3775:1: ruleXForLoopExpression returns [EObject current=null] : ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) ;
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
			// InternalWeightDefinition.g:3781:2: ( ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:3782:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:3782:2: ( ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:3783:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) ) ( (lv_forExpression_5_0= ruleXExpression ) ) otherlv_6= ')' ( (lv_eachExpression_7_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:3783:3: ( ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' ) )
			// InternalWeightDefinition.g:3784:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )=> ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
			{
			// InternalWeightDefinition.g:3797:4: ( () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':' )
			// InternalWeightDefinition.g:3798:5: () otherlv_1= 'for' otherlv_2= '(' ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) ) otherlv_4= ':'
			{
			// InternalWeightDefinition.g:3798:5: ()
			// InternalWeightDefinition.g:3799:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXForLoopExpressionAccess().getXForLoopExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,65,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXForLoopExpressionAccess().getForKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,21,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			// InternalWeightDefinition.g:3813:5: ( (lv_declaredParam_3_0= ruleJvmFormalParameter ) )
			// InternalWeightDefinition.g:3814:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
			{
			// InternalWeightDefinition.g:3814:6: (lv_declaredParam_3_0= ruleJvmFormalParameter )
			// InternalWeightDefinition.g:3815:7: lv_declaredParam_3_0= ruleJvmFormalParameter
			{
			if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getDeclaredParamJvmFormalParameterParserRuleCall_0_0_3_0());
									}
			pushFollow(FOLLOW_52);
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

			otherlv_4=(Token)match(input,39,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_4, grammarAccess.getXForLoopExpressionAccess().getColonKeyword_0_0_4());
							}
			}

			}

			// InternalWeightDefinition.g:3838:3: ( (lv_forExpression_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3839:4: (lv_forExpression_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3839:4: (lv_forExpression_5_0= ruleXExpression )
			// InternalWeightDefinition.g:3840:5: lv_forExpression_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXForLoopExpressionAccess().getForExpressionXExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_37);
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

			otherlv_6=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXForLoopExpressionAccess().getRightParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:3861:3: ( (lv_eachExpression_7_0= ruleXExpression ) )
			// InternalWeightDefinition.g:3862:4: (lv_eachExpression_7_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:3862:4: (lv_eachExpression_7_0= ruleXExpression )
			// InternalWeightDefinition.g:3863:5: lv_eachExpression_7_0= ruleXExpression
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
	// InternalWeightDefinition.g:3884:1: entryRuleXBasicForLoopExpression returns [EObject current=null] :iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF ;
	public final EObject entryRuleXBasicForLoopExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBasicForLoopExpression =null;

		try {
			// InternalWeightDefinition.g:3884:64: (iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF )
			// InternalWeightDefinition.g:3885:2: iv_ruleXBasicForLoopExpression= ruleXBasicForLoopExpression EOF
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
	// InternalWeightDefinition.g:3891:1: ruleXBasicForLoopExpression returns [EObject current=null] : ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) ;
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
			// InternalWeightDefinition.g:3897:2: ( ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:3898:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:3898:2: ( () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:3899:3: () otherlv_1= 'for' otherlv_2= '(' ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )? otherlv_6= ';' ( (lv_expression_7_0= ruleXExpression ) )? otherlv_8= ';' ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )? otherlv_12= ')' ( (lv_eachExpression_13_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:3899:3: ()
			// InternalWeightDefinition.g:3900:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBasicForLoopExpressionAccess().getXBasicForLoopExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,65,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBasicForLoopExpressionAccess().getForKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_57); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXBasicForLoopExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:3914:3: ( ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )* )?
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( ((LA59_0 >= RULE_DECIMAL && LA59_0 <= RULE_INT)||LA59_0==RULE_STRING||LA59_0==13||LA59_0==16||LA59_0==21||LA59_0==26||LA59_0==30||LA59_0==42||LA59_0==53||LA59_0==59||(LA59_0 >= 61 && LA59_0 <= 63)||LA59_0==65||(LA59_0 >= 67 && LA59_0 <= 68)||(LA59_0 >= 70 && LA59_0 <= 72)||(LA59_0 >= 74 && LA59_0 <= 85)) ) {
				alt59=1;
			}
			switch (alt59) {
				case 1 :
					// InternalWeightDefinition.g:3915:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					{
					// InternalWeightDefinition.g:3915:4: ( (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration ) )
					// InternalWeightDefinition.g:3916:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalWeightDefinition.g:3916:5: (lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration )
					// InternalWeightDefinition.g:3917:6: lv_initExpressions_3_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_0_0());
										}
					pushFollow(FOLLOW_58);
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

					// InternalWeightDefinition.g:3934:4: (otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) ) )*
					loop58:
					while (true) {
						int alt58=2;
						int LA58_0 = input.LA(1);
						if ( (LA58_0==29) ) {
							alt58=1;
						}

						switch (alt58) {
						case 1 :
							// InternalWeightDefinition.g:3935:5: otherlv_4= ',' ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							{
							otherlv_4=(Token)match(input,29,FOLLOW_59); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_4, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_3_1_0());
											}
							// InternalWeightDefinition.g:3939:5: ( (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration ) )
							// InternalWeightDefinition.g:3940:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							{
							// InternalWeightDefinition.g:3940:6: (lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration )
							// InternalWeightDefinition.g:3941:7: lv_initExpressions_5_0= ruleXExpressionOrVarDeclaration
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsXExpressionOrVarDeclarationParserRuleCall_3_1_1_0());
													}
							pushFollow(FOLLOW_58);
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
							break loop58;
						}
					}

					}
					break;

			}

			otherlv_6=(Token)match(input,41,FOLLOW_60); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_6, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_4());
					}
			// InternalWeightDefinition.g:3964:3: ( (lv_expression_7_0= ruleXExpression ) )?
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( ((LA60_0 >= RULE_DECIMAL && LA60_0 <= RULE_INT)||LA60_0==RULE_STRING||LA60_0==13||LA60_0==16||LA60_0==21||LA60_0==26||LA60_0==30||LA60_0==42||LA60_0==53||LA60_0==59||(LA60_0 >= 61 && LA60_0 <= 63)||LA60_0==65||(LA60_0 >= 67 && LA60_0 <= 68)||(LA60_0 >= 70 && LA60_0 <= 72)||(LA60_0 >= 74 && LA60_0 <= 81)||(LA60_0 >= 84 && LA60_0 <= 85)) ) {
				alt60=1;
			}
			switch (alt60) {
				case 1 :
					// InternalWeightDefinition.g:3965:4: (lv_expression_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3965:4: (lv_expression_7_0= ruleXExpression )
					// InternalWeightDefinition.g:3966:5: lv_expression_7_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getExpressionXExpressionParserRuleCall_5_0());
									}
					pushFollow(FOLLOW_61);
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

			otherlv_8=(Token)match(input,41,FOLLOW_62); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_8, grammarAccess.getXBasicForLoopExpressionAccess().getSemicolonKeyword_6());
					}
			// InternalWeightDefinition.g:3987:3: ( ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )* )?
			int alt62=2;
			int LA62_0 = input.LA(1);
			if ( ((LA62_0 >= RULE_DECIMAL && LA62_0 <= RULE_INT)||LA62_0==RULE_STRING||LA62_0==13||LA62_0==16||LA62_0==21||LA62_0==26||LA62_0==30||LA62_0==42||LA62_0==53||LA62_0==59||(LA62_0 >= 61 && LA62_0 <= 63)||LA62_0==65||(LA62_0 >= 67 && LA62_0 <= 68)||(LA62_0 >= 70 && LA62_0 <= 72)||(LA62_0 >= 74 && LA62_0 <= 81)||(LA62_0 >= 84 && LA62_0 <= 85)) ) {
				alt62=1;
			}
			switch (alt62) {
				case 1 :
					// InternalWeightDefinition.g:3988:4: ( (lv_updateExpressions_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					{
					// InternalWeightDefinition.g:3988:4: ( (lv_updateExpressions_9_0= ruleXExpression ) )
					// InternalWeightDefinition.g:3989:5: (lv_updateExpressions_9_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:3989:5: (lv_updateExpressions_9_0= ruleXExpression )
					// InternalWeightDefinition.g:3990:6: lv_updateExpressions_9_0= ruleXExpression
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_0_0());
										}
					pushFollow(FOLLOW_10);
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

					// InternalWeightDefinition.g:4007:4: (otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) ) )*
					loop61:
					while (true) {
						int alt61=2;
						int LA61_0 = input.LA(1);
						if ( (LA61_0==29) ) {
							alt61=1;
						}

						switch (alt61) {
						case 1 :
							// InternalWeightDefinition.g:4008:5: otherlv_10= ',' ( (lv_updateExpressions_11_0= ruleXExpression ) )
							{
							otherlv_10=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_10, grammarAccess.getXBasicForLoopExpressionAccess().getCommaKeyword_7_1_0());
											}
							// InternalWeightDefinition.g:4012:5: ( (lv_updateExpressions_11_0= ruleXExpression ) )
							// InternalWeightDefinition.g:4013:6: (lv_updateExpressions_11_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:4013:6: (lv_updateExpressions_11_0= ruleXExpression )
							// InternalWeightDefinition.g:4014:7: lv_updateExpressions_11_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsXExpressionParserRuleCall_7_1_1_0());
													}
							pushFollow(FOLLOW_10);
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
							break loop61;
						}
					}

					}
					break;

			}

			otherlv_12=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_12, grammarAccess.getXBasicForLoopExpressionAccess().getRightParenthesisKeyword_8());
					}
			// InternalWeightDefinition.g:4037:3: ( (lv_eachExpression_13_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4038:4: (lv_eachExpression_13_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4038:4: (lv_eachExpression_13_0= ruleXExpression )
			// InternalWeightDefinition.g:4039:5: lv_eachExpression_13_0= ruleXExpression
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
	// InternalWeightDefinition.g:4060:1: entryRuleXWhileExpression returns [EObject current=null] :iv_ruleXWhileExpression= ruleXWhileExpression EOF ;
	public final EObject entryRuleXWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXWhileExpression =null;

		try {
			// InternalWeightDefinition.g:4060:57: (iv_ruleXWhileExpression= ruleXWhileExpression EOF )
			// InternalWeightDefinition.g:4061:2: iv_ruleXWhileExpression= ruleXWhileExpression EOF
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
	// InternalWeightDefinition.g:4067:1: ruleXWhileExpression returns [EObject current=null] : ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) ;
	public final EObject ruleXWhileExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_predicate_3_0 =null;
		EObject lv_body_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4073:2: ( ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:4074:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:4074:2: ( () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:4075:3: () otherlv_1= 'while' otherlv_2= '(' ( (lv_predicate_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_body_5_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:4075:3: ()
			// InternalWeightDefinition.g:4076:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXWhileExpressionAccess().getXWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,84,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXWhileExpressionAccess().getWhileKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXWhileExpressionAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:4090:3: ( (lv_predicate_3_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4091:4: (lv_predicate_3_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4091:4: (lv_predicate_3_0= ruleXExpression )
			// InternalWeightDefinition.g:4092:5: lv_predicate_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXWhileExpressionAccess().getPredicateXExpressionParserRuleCall_3_0());
							}
			pushFollow(FOLLOW_37);
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

			otherlv_4=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXWhileExpressionAccess().getRightParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:4113:3: ( (lv_body_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4114:4: (lv_body_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4114:4: (lv_body_5_0= ruleXExpression )
			// InternalWeightDefinition.g:4115:5: lv_body_5_0= ruleXExpression
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
	// InternalWeightDefinition.g:4136:1: entryRuleXDoWhileExpression returns [EObject current=null] :iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF ;
	public final EObject entryRuleXDoWhileExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXDoWhileExpression =null;

		try {
			// InternalWeightDefinition.g:4136:59: (iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF )
			// InternalWeightDefinition.g:4137:2: iv_ruleXDoWhileExpression= ruleXDoWhileExpression EOF
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
	// InternalWeightDefinition.g:4143:1: ruleXDoWhileExpression returns [EObject current=null] : ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) ;
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
			// InternalWeightDefinition.g:4149:2: ( ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' ) )
			// InternalWeightDefinition.g:4150:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			{
			// InternalWeightDefinition.g:4150:2: ( () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')' )
			// InternalWeightDefinition.g:4151:3: () otherlv_1= 'do' ( (lv_body_2_0= ruleXExpression ) ) otherlv_3= 'while' otherlv_4= '(' ( (lv_predicate_5_0= ruleXExpression ) ) otherlv_6= ')'
			{
			// InternalWeightDefinition.g:4151:3: ()
			// InternalWeightDefinition.g:4152:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXDoWhileExpressionAccess().getXDoWhileExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,59,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXDoWhileExpressionAccess().getDoKeyword_1());
					}
			// InternalWeightDefinition.g:4162:3: ( (lv_body_2_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4163:4: (lv_body_2_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4163:4: (lv_body_2_0= ruleXExpression )
			// InternalWeightDefinition.g:4164:5: lv_body_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getBodyXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_63);
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

			otherlv_3=(Token)match(input,84,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXDoWhileExpressionAccess().getWhileKeyword_3());
					}
			otherlv_4=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXDoWhileExpressionAccess().getLeftParenthesisKeyword_4());
					}
			// InternalWeightDefinition.g:4189:3: ( (lv_predicate_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:4190:4: (lv_predicate_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:4190:4: (lv_predicate_5_0= ruleXExpression )
			// InternalWeightDefinition.g:4191:5: lv_predicate_5_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXDoWhileExpressionAccess().getPredicateXExpressionParserRuleCall_5_0());
							}
			pushFollow(FOLLOW_37);
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
	// InternalWeightDefinition.g:4216:1: entryRuleXBlockExpression returns [EObject current=null] :iv_ruleXBlockExpression= ruleXBlockExpression EOF ;
	public final EObject entryRuleXBlockExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBlockExpression =null;

		try {
			// InternalWeightDefinition.g:4216:57: (iv_ruleXBlockExpression= ruleXBlockExpression EOF )
			// InternalWeightDefinition.g:4217:2: iv_ruleXBlockExpression= ruleXBlockExpression EOF
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
	// InternalWeightDefinition.g:4223:1: ruleXBlockExpression returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) ;
	public final EObject ruleXBlockExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_3=null;
		Token otherlv_4=null;
		EObject lv_expressions_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4229:2: ( ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' ) )
			// InternalWeightDefinition.g:4230:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
			{
			// InternalWeightDefinition.g:4230:2: ( () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}' )
			// InternalWeightDefinition.g:4231:3: () otherlv_1= '{' ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )* otherlv_4= '}'
			{
			// InternalWeightDefinition.g:4231:3: ()
			// InternalWeightDefinition.g:4232:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBlockExpressionAccess().getXBlockExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,85,FOLLOW_64); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXBlockExpressionAccess().getLeftCurlyBracketKeyword_1());
					}
			// InternalWeightDefinition.g:4242:3: ( ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )? )*
			loop64:
			while (true) {
				int alt64=2;
				int LA64_0 = input.LA(1);
				if ( ((LA64_0 >= RULE_DECIMAL && LA64_0 <= RULE_INT)||LA64_0==RULE_STRING||LA64_0==13||LA64_0==16||LA64_0==21||LA64_0==26||LA64_0==30||LA64_0==42||LA64_0==53||LA64_0==59||(LA64_0 >= 61 && LA64_0 <= 63)||LA64_0==65||(LA64_0 >= 67 && LA64_0 <= 68)||(LA64_0 >= 70 && LA64_0 <= 72)||(LA64_0 >= 74 && LA64_0 <= 85)) ) {
					alt64=1;
				}

				switch (alt64) {
				case 1 :
					// InternalWeightDefinition.g:4243:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) ) (otherlv_3= ';' )?
					{
					// InternalWeightDefinition.g:4243:4: ( (lv_expressions_2_0= ruleXExpressionOrVarDeclaration ) )
					// InternalWeightDefinition.g:4244:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
					{
					// InternalWeightDefinition.g:4244:5: (lv_expressions_2_0= ruleXExpressionOrVarDeclaration )
					// InternalWeightDefinition.g:4245:6: lv_expressions_2_0= ruleXExpressionOrVarDeclaration
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXBlockExpressionAccess().getExpressionsXExpressionOrVarDeclarationParserRuleCall_2_0_0());
										}
					pushFollow(FOLLOW_65);
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

					// InternalWeightDefinition.g:4262:4: (otherlv_3= ';' )?
					int alt63=2;
					int LA63_0 = input.LA(1);
					if ( (LA63_0==41) ) {
						alt63=1;
					}
					switch (alt63) {
						case 1 :
							// InternalWeightDefinition.g:4263:5: otherlv_3= ';'
							{
							otherlv_3=(Token)match(input,41,FOLLOW_64); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getXBlockExpressionAccess().getSemicolonKeyword_2_1());
											}
							}
							break;

					}

					}
					break;

				default :
					break loop64;
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
	// InternalWeightDefinition.g:4277:1: entryRuleXExpressionOrVarDeclaration returns [EObject current=null] :iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF ;
	public final EObject entryRuleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXExpressionOrVarDeclaration =null;

		try {
			// InternalWeightDefinition.g:4277:68: (iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF )
			// InternalWeightDefinition.g:4278:2: iv_ruleXExpressionOrVarDeclaration= ruleXExpressionOrVarDeclaration EOF
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
	// InternalWeightDefinition.g:4284:1: ruleXExpressionOrVarDeclaration returns [EObject current=null] : (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression ) ;
	public final EObject ruleXExpressionOrVarDeclaration() throws RecognitionException {
		EObject current = null;


		EObject this_XVariableDeclaration_0 =null;
		EObject this_XExpression_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4290:2: ( (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression ) )
			// InternalWeightDefinition.g:4291:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression )
			{
			// InternalWeightDefinition.g:4291:2: (this_XVariableDeclaration_0= ruleXVariableDeclaration |this_XExpression_1= ruleXExpression )
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( ((LA65_0 >= 82 && LA65_0 <= 83)) ) {
				alt65=1;
			}
			else if ( ((LA65_0 >= RULE_DECIMAL && LA65_0 <= RULE_INT)||LA65_0==RULE_STRING||LA65_0==13||LA65_0==16||LA65_0==21||LA65_0==26||LA65_0==30||LA65_0==42||LA65_0==53||LA65_0==59||(LA65_0 >= 61 && LA65_0 <= 63)||LA65_0==65||(LA65_0 >= 67 && LA65_0 <= 68)||(LA65_0 >= 70 && LA65_0 <= 72)||(LA65_0 >= 74 && LA65_0 <= 81)||(LA65_0 >= 84 && LA65_0 <= 85)) ) {
				alt65=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 65, 0, input);
				throw nvae;
			}

			switch (alt65) {
				case 1 :
					// InternalWeightDefinition.g:4292:3: this_XVariableDeclaration_0= ruleXVariableDeclaration
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
					// InternalWeightDefinition.g:4301:3: this_XExpression_1= ruleXExpression
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
	// InternalWeightDefinition.g:4313:1: entryRuleXVariableDeclaration returns [EObject current=null] :iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF ;
	public final EObject entryRuleXVariableDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXVariableDeclaration =null;

		try {
			// InternalWeightDefinition.g:4313:61: (iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF )
			// InternalWeightDefinition.g:4314:2: iv_ruleXVariableDeclaration= ruleXVariableDeclaration EOF
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
	// InternalWeightDefinition.g:4320:1: ruleXVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) ;
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
			// InternalWeightDefinition.g:4326:2: ( ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? ) )
			// InternalWeightDefinition.g:4327:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
			{
			// InternalWeightDefinition.g:4327:2: ( () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )? )
			// InternalWeightDefinition.g:4328:3: () ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' ) ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) ) (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
			{
			// InternalWeightDefinition.g:4328:3: ()
			// InternalWeightDefinition.g:4329:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXVariableDeclarationAccess().getXVariableDeclarationAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:4335:3: ( ( (lv_writeable_1_0= 'var' ) ) |otherlv_2= 'val' )
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==83) ) {
				alt66=1;
			}
			else if ( (LA66_0==82) ) {
				alt66=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 66, 0, input);
				throw nvae;
			}

			switch (alt66) {
				case 1 :
					// InternalWeightDefinition.g:4336:4: ( (lv_writeable_1_0= 'var' ) )
					{
					// InternalWeightDefinition.g:4336:4: ( (lv_writeable_1_0= 'var' ) )
					// InternalWeightDefinition.g:4337:5: (lv_writeable_1_0= 'var' )
					{
					// InternalWeightDefinition.g:4337:5: (lv_writeable_1_0= 'var' )
					// InternalWeightDefinition.g:4338:6: lv_writeable_1_0= 'var'
					{
					lv_writeable_1_0=(Token)match(input,83,FOLLOW_7); if (state.failed) return current;
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
					// InternalWeightDefinition.g:4351:4: otherlv_2= 'val'
					{
					otherlv_2=(Token)match(input,82,FOLLOW_7); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_2, grammarAccess.getXVariableDeclarationAccess().getValKeyword_1_1());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:4356:3: ( ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) ) | ( (lv_name_5_0= ruleValidID ) ) )
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==RULE_ID) ) {
				int LA67_1 = input.LA(2);
				if ( (synpred29_InternalWeightDefinition()) ) {
					alt67=1;
				}
				else if ( (true) ) {
					alt67=2;
				}

			}
			else if ( (LA67_0==21) && (synpred29_InternalWeightDefinition())) {
				alt67=1;
			}
			else if ( (LA67_0==47) && (synpred29_InternalWeightDefinition())) {
				alt67=1;
			}

			switch (alt67) {
				case 1 :
					// InternalWeightDefinition.g:4357:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
					{
					// InternalWeightDefinition.g:4357:4: ( ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) ) )
					// InternalWeightDefinition.g:4358:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )=> ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
					{
					// InternalWeightDefinition.g:4371:5: ( ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) ) )
					// InternalWeightDefinition.g:4372:6: ( (lv_type_3_0= ruleJvmTypeReference ) ) ( (lv_name_4_0= ruleValidID ) )
					{
					// InternalWeightDefinition.g:4372:6: ( (lv_type_3_0= ruleJvmTypeReference ) )
					// InternalWeightDefinition.g:4373:7: (lv_type_3_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:4373:7: (lv_type_3_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:4374:8: lv_type_3_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getTypeJvmTypeReferenceParserRuleCall_2_0_0_0_0());
												}
					pushFollow(FOLLOW_5);
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

					// InternalWeightDefinition.g:4391:6: ( (lv_name_4_0= ruleValidID ) )
					// InternalWeightDefinition.g:4392:7: (lv_name_4_0= ruleValidID )
					{
					// InternalWeightDefinition.g:4392:7: (lv_name_4_0= ruleValidID )
					// InternalWeightDefinition.g:4393:8: lv_name_4_0= ruleValidID
					{
					if ( state.backtracking==0 ) {
													newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_0_0_1_0());
												}
					pushFollow(FOLLOW_66);
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
					// InternalWeightDefinition.g:4413:4: ( (lv_name_5_0= ruleValidID ) )
					{
					// InternalWeightDefinition.g:4413:4: ( (lv_name_5_0= ruleValidID ) )
					// InternalWeightDefinition.g:4414:5: (lv_name_5_0= ruleValidID )
					{
					// InternalWeightDefinition.g:4414:5: (lv_name_5_0= ruleValidID )
					// InternalWeightDefinition.g:4415:6: lv_name_5_0= ruleValidID
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXVariableDeclarationAccess().getNameValidIDParserRuleCall_2_1_0());
										}
					pushFollow(FOLLOW_66);
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

			// InternalWeightDefinition.g:4433:3: (otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) ) )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==44) ) {
				alt68=1;
			}
			switch (alt68) {
				case 1 :
					// InternalWeightDefinition.g:4434:4: otherlv_6= '=' ( (lv_right_7_0= ruleXExpression ) )
					{
					otherlv_6=(Token)match(input,44,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_6, grammarAccess.getXVariableDeclarationAccess().getEqualsSignKeyword_3_0());
								}
					// InternalWeightDefinition.g:4438:4: ( (lv_right_7_0= ruleXExpression ) )
					// InternalWeightDefinition.g:4439:5: (lv_right_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:4439:5: (lv_right_7_0= ruleXExpression )
					// InternalWeightDefinition.g:4440:6: lv_right_7_0= ruleXExpression
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
	// InternalWeightDefinition.g:4462:1: entryRuleJvmFormalParameter returns [EObject current=null] :iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF ;
	public final EObject entryRuleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmFormalParameter =null;

		try {
			// InternalWeightDefinition.g:4462:59: (iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF )
			// InternalWeightDefinition.g:4463:2: iv_ruleJvmFormalParameter= ruleJvmFormalParameter EOF
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
	// InternalWeightDefinition.g:4469:1: ruleJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4475:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalWeightDefinition.g:4476:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalWeightDefinition.g:4476:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) ) )
			// InternalWeightDefinition.g:4477:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )? ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalWeightDefinition.g:4477:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )?
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==RULE_ID) ) {
				int LA69_1 = input.LA(2);
				if ( (LA69_1==RULE_ID||LA69_1==34||LA69_1==42||LA69_1==53) ) {
					alt69=1;
				}
			}
			else if ( (LA69_0==21||LA69_0==47) ) {
				alt69=1;
			}
			switch (alt69) {
				case 1 :
					// InternalWeightDefinition.g:4478:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					{
					// InternalWeightDefinition.g:4478:4: (lv_parameterType_0_0= ruleJvmTypeReference )
					// InternalWeightDefinition.g:4479:5: lv_parameterType_0_0= ruleJvmTypeReference
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
									}
					pushFollow(FOLLOW_5);
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

			// InternalWeightDefinition.g:4496:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalWeightDefinition.g:4497:4: (lv_name_1_0= ruleValidID )
			{
			// InternalWeightDefinition.g:4497:4: (lv_name_1_0= ruleValidID )
			// InternalWeightDefinition.g:4498:5: lv_name_1_0= ruleValidID
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
	// InternalWeightDefinition.g:4519:1: entryRuleFullJvmFormalParameter returns [EObject current=null] :iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF ;
	public final EObject entryRuleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleFullJvmFormalParameter =null;

		try {
			// InternalWeightDefinition.g:4519:63: (iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF )
			// InternalWeightDefinition.g:4520:2: iv_ruleFullJvmFormalParameter= ruleFullJvmFormalParameter EOF
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
	// InternalWeightDefinition.g:4526:1: ruleFullJvmFormalParameter returns [EObject current=null] : ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) ;
	public final EObject ruleFullJvmFormalParameter() throws RecognitionException {
		EObject current = null;


		EObject lv_parameterType_0_0 =null;
		AntlrDatatypeRuleToken lv_name_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4532:2: ( ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) ) )
			// InternalWeightDefinition.g:4533:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			{
			// InternalWeightDefinition.g:4533:2: ( ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) ) )
			// InternalWeightDefinition.g:4534:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) ) ( (lv_name_1_0= ruleValidID ) )
			{
			// InternalWeightDefinition.g:4534:3: ( (lv_parameterType_0_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:4535:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:4535:4: (lv_parameterType_0_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:4536:5: lv_parameterType_0_0= ruleJvmTypeReference
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getFullJvmFormalParameterAccess().getParameterTypeJvmTypeReferenceParserRuleCall_0_0());
							}
			pushFollow(FOLLOW_5);
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

			// InternalWeightDefinition.g:4553:3: ( (lv_name_1_0= ruleValidID ) )
			// InternalWeightDefinition.g:4554:4: (lv_name_1_0= ruleValidID )
			{
			// InternalWeightDefinition.g:4554:4: (lv_name_1_0= ruleValidID )
			// InternalWeightDefinition.g:4555:5: lv_name_1_0= ruleValidID
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
	// InternalWeightDefinition.g:4576:1: entryRuleXFeatureCall returns [EObject current=null] :iv_ruleXFeatureCall= ruleXFeatureCall EOF ;
	public final EObject entryRuleXFeatureCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXFeatureCall =null;

		try {
			// InternalWeightDefinition.g:4576:53: (iv_ruleXFeatureCall= ruleXFeatureCall EOF )
			// InternalWeightDefinition.g:4577:2: iv_ruleXFeatureCall= ruleXFeatureCall EOF
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
	// InternalWeightDefinition.g:4583:1: ruleXFeatureCall returns [EObject current=null] : ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) ;
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
			// InternalWeightDefinition.g:4589:2: ( ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? ) )
			// InternalWeightDefinition.g:4590:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
			{
			// InternalWeightDefinition.g:4590:2: ( () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )? )
			// InternalWeightDefinition.g:4591:3: () (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ( ( ruleIdOrSuper ) ) ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )? ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
			{
			// InternalWeightDefinition.g:4591:3: ()
			// InternalWeightDefinition.g:4592:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXFeatureCallAccess().getXFeatureCallAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:4598:3: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==42) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// InternalWeightDefinition.g:4599:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
					{
					otherlv_1=(Token)match(input,42,FOLLOW_32); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXFeatureCallAccess().getLessThanSignKeyword_1_0());
								}
					// InternalWeightDefinition.g:4603:4: ( (lv_typeArguments_2_0= ruleJvmArgumentTypeReference ) )
					// InternalWeightDefinition.g:4604:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
					{
					// InternalWeightDefinition.g:4604:5: (lv_typeArguments_2_0= ruleJvmArgumentTypeReference )
					// InternalWeightDefinition.g:4605:6: lv_typeArguments_2_0= ruleJvmArgumentTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_33);
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

					// InternalWeightDefinition.g:4622:4: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) )*
					loop70:
					while (true) {
						int alt70=2;
						int LA70_0 = input.LA(1);
						if ( (LA70_0==29) ) {
							alt70=1;
						}

						switch (alt70) {
						case 1 :
							// InternalWeightDefinition.g:4623:5: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_3=(Token)match(input,29,FOLLOW_32); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getXFeatureCallAccess().getCommaKeyword_1_2_0());
											}
							// InternalWeightDefinition.g:4627:5: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:4628:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:4628:6: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:4629:7: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXFeatureCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
													}
							pushFollow(FOLLOW_33);
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
							break loop70;
						}
					}

					otherlv_5=(Token)match(input,48,FOLLOW_34); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getXFeatureCallAccess().getGreaterThanSignKeyword_1_3());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:4652:3: ( ( ruleIdOrSuper ) )
			// InternalWeightDefinition.g:4653:4: ( ruleIdOrSuper )
			{
			// InternalWeightDefinition.g:4653:4: ( ruleIdOrSuper )
			// InternalWeightDefinition.g:4654:5: ruleIdOrSuper
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXFeatureCallRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0());
							}
			pushFollow(FOLLOW_67);
			ruleIdOrSuper();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:4668:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?
			int alt74=2;
			alt74 = dfa74.predict(input);
			switch (alt74) {
				case 1 :
					// InternalWeightDefinition.g:4669:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')'
					{
					// InternalWeightDefinition.g:4669:4: ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) )
					// InternalWeightDefinition.g:4670:5: ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' )
					{
					// InternalWeightDefinition.g:4674:5: (lv_explicitOperationCall_7_0= '(' )
					// InternalWeightDefinition.g:4675:6: lv_explicitOperationCall_7_0= '('
					{
					lv_explicitOperationCall_7_0=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
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

					// InternalWeightDefinition.g:4687:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )?
					int alt73=3;
					int LA73_0 = input.LA(1);
					if ( (LA73_0==RULE_ID) ) {
						int LA73_1 = input.LA(2);
						if ( (synpred31_InternalWeightDefinition()) ) {
							alt73=1;
						}
						else if ( (true) ) {
							alt73=2;
						}
					}
					else if ( (LA73_0==21) ) {
						int LA73_2 = input.LA(2);
						if ( (synpred31_InternalWeightDefinition()) ) {
							alt73=1;
						}
						else if ( (true) ) {
							alt73=2;
						}
					}
					else if ( (LA73_0==47) && (synpred31_InternalWeightDefinition())) {
						alt73=1;
					}
					else if ( (LA73_0==86) && (synpred31_InternalWeightDefinition())) {
						alt73=1;
					}
					else if ( ((LA73_0 >= RULE_DECIMAL && LA73_0 <= RULE_HEX)||LA73_0==RULE_INT||LA73_0==RULE_STRING||LA73_0==13||LA73_0==16||LA73_0==26||LA73_0==30||LA73_0==42||LA73_0==53||LA73_0==59||(LA73_0 >= 61 && LA73_0 <= 63)||LA73_0==65||(LA73_0 >= 67 && LA73_0 <= 68)||(LA73_0 >= 70 && LA73_0 <= 72)||(LA73_0 >= 74 && LA73_0 <= 81)||(LA73_0 >= 84 && LA73_0 <= 85)) ) {
						alt73=2;
					}
					switch (alt73) {
						case 1 :
							// InternalWeightDefinition.g:4688:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
							{
							// InternalWeightDefinition.g:4688:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) )
							// InternalWeightDefinition.g:4689:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure )
							{
							// InternalWeightDefinition.g:4714:6: (lv_featureCallArguments_8_0= ruleXShortClosure )
							// InternalWeightDefinition.g:4715:7: lv_featureCallArguments_8_0= ruleXShortClosure
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXShortClosureParserRuleCall_3_1_0_0());
													}
							pushFollow(FOLLOW_37);
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
							// InternalWeightDefinition.g:4733:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
							{
							// InternalWeightDefinition.g:4733:5: ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* )
							// InternalWeightDefinition.g:4734:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
							{
							// InternalWeightDefinition.g:4734:6: ( (lv_featureCallArguments_9_0= ruleXExpression ) )
							// InternalWeightDefinition.g:4735:7: (lv_featureCallArguments_9_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:4735:7: (lv_featureCallArguments_9_0= ruleXExpression )
							// InternalWeightDefinition.g:4736:8: lv_featureCallArguments_9_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_0_0());
														}
							pushFollow(FOLLOW_10);
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

							// InternalWeightDefinition.g:4753:6: (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )*
							loop72:
							while (true) {
								int alt72=2;
								int LA72_0 = input.LA(1);
								if ( (LA72_0==29) ) {
									alt72=1;
								}

								switch (alt72) {
								case 1 :
									// InternalWeightDefinition.g:4754:7: otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) )
									{
									otherlv_10=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_10, grammarAccess.getXFeatureCallAccess().getCommaKeyword_3_1_1_1_0());
															}
									// InternalWeightDefinition.g:4758:7: ( (lv_featureCallArguments_11_0= ruleXExpression ) )
									// InternalWeightDefinition.g:4759:8: (lv_featureCallArguments_11_0= ruleXExpression )
									{
									// InternalWeightDefinition.g:4759:8: (lv_featureCallArguments_11_0= ruleXExpression )
									// InternalWeightDefinition.g:4760:9: lv_featureCallArguments_11_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXFeatureCallAccess().getFeatureCallArgumentsXExpressionParserRuleCall_3_1_1_1_1_0());
																	}
									pushFollow(FOLLOW_10);
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
									break loop72;
								}
							}

							}

							}
							break;

					}

					otherlv_12=(Token)match(input,22,FOLLOW_68); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_12, grammarAccess.getXFeatureCallAccess().getRightParenthesisKeyword_3_2());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:4785:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?
			int alt75=2;
			alt75 = dfa75.predict(input);
			switch (alt75) {
				case 1 :
					// InternalWeightDefinition.g:4786:4: ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure )
					{
					// InternalWeightDefinition.g:4792:4: (lv_featureCallArguments_13_0= ruleXClosure )
					// InternalWeightDefinition.g:4793:5: lv_featureCallArguments_13_0= ruleXClosure
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
	// InternalWeightDefinition.g:4814:1: entryRuleFeatureCallID returns [String current=null] :iv_ruleFeatureCallID= ruleFeatureCallID EOF ;
	public final String entryRuleFeatureCallID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleFeatureCallID =null;

		try {
			// InternalWeightDefinition.g:4814:53: (iv_ruleFeatureCallID= ruleFeatureCallID EOF )
			// InternalWeightDefinition.g:4815:2: iv_ruleFeatureCallID= ruleFeatureCallID EOF
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
	// InternalWeightDefinition.g:4821:1: ruleFeatureCallID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) ;
	public final AntlrDatatypeRuleToken ruleFeatureCallID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4827:2: ( (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' ) )
			// InternalWeightDefinition.g:4828:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			{
			// InternalWeightDefinition.g:4828:2: (this_ValidID_0= ruleValidID |kw= 'extends' |kw= 'static' |kw= 'import' |kw= 'extension' )
			int alt76=5;
			switch ( input.LA(1) ) {
			case RULE_ID:
				{
				alt76=1;
				}
				break;
			case 61:
				{
				alt76=2;
				}
				break;
			case 74:
				{
				alt76=3;
				}
				break;
			case 68:
				{
				alt76=4;
				}
				break;
			case 62:
				{
				alt76=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 76, 0, input);
				throw nvae;
			}
			switch (alt76) {
				case 1 :
					// InternalWeightDefinition.g:4829:3: this_ValidID_0= ruleValidID
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
					// InternalWeightDefinition.g:4840:3: kw= 'extends'
					{
					kw=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getExtendsKeyword_1());
							}
					}
					break;
				case 3 :
					// InternalWeightDefinition.g:4846:3: kw= 'static'
					{
					kw=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getStaticKeyword_2());
							}
					}
					break;
				case 4 :
					// InternalWeightDefinition.g:4852:3: kw= 'import'
					{
					kw=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getFeatureCallIDAccess().getImportKeyword_3());
							}
					}
					break;
				case 5 :
					// InternalWeightDefinition.g:4858:3: kw= 'extension'
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
	// InternalWeightDefinition.g:4867:1: entryRuleIdOrSuper returns [String current=null] :iv_ruleIdOrSuper= ruleIdOrSuper EOF ;
	public final String entryRuleIdOrSuper() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleIdOrSuper =null;

		try {
			// InternalWeightDefinition.g:4867:49: (iv_ruleIdOrSuper= ruleIdOrSuper EOF )
			// InternalWeightDefinition.g:4868:2: iv_ruleIdOrSuper= ruleIdOrSuper EOF
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
	// InternalWeightDefinition.g:4874:1: ruleIdOrSuper returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) ;
	public final AntlrDatatypeRuleToken ruleIdOrSuper() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_FeatureCallID_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:4880:2: ( (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' ) )
			// InternalWeightDefinition.g:4881:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			{
			// InternalWeightDefinition.g:4881:2: (this_FeatureCallID_0= ruleFeatureCallID |kw= 'super' )
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==RULE_ID||(LA77_0 >= 61 && LA77_0 <= 62)||LA77_0==68||LA77_0==74) ) {
				alt77=1;
			}
			else if ( (LA77_0==75) ) {
				alt77=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 77, 0, input);
				throw nvae;
			}

			switch (alt77) {
				case 1 :
					// InternalWeightDefinition.g:4882:3: this_FeatureCallID_0= ruleFeatureCallID
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
					// InternalWeightDefinition.g:4893:3: kw= 'super'
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
	// InternalWeightDefinition.g:4902:1: entryRuleXConstructorCall returns [EObject current=null] :iv_ruleXConstructorCall= ruleXConstructorCall EOF ;
	public final EObject entryRuleXConstructorCall() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXConstructorCall =null;

		try {
			// InternalWeightDefinition.g:4902:57: (iv_ruleXConstructorCall= ruleXConstructorCall EOF )
			// InternalWeightDefinition.g:4903:2: iv_ruleXConstructorCall= ruleXConstructorCall EOF
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
	// InternalWeightDefinition.g:4909:1: ruleXConstructorCall returns [EObject current=null] : ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) ;
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
			// InternalWeightDefinition.g:4915:2: ( ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? ) )
			// InternalWeightDefinition.g:4916:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
			{
			// InternalWeightDefinition.g:4916:2: ( () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )? )
			// InternalWeightDefinition.g:4917:3: () otherlv_1= 'new' ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )? ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )? ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
			{
			// InternalWeightDefinition.g:4917:3: ()
			// InternalWeightDefinition.g:4918:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXConstructorCallAccess().getXConstructorCallAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,70,FOLLOW_5); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXConstructorCallAccess().getNewKeyword_1());
					}
			// InternalWeightDefinition.g:4928:3: ( ( ruleQualifiedName ) )
			// InternalWeightDefinition.g:4929:4: ( ruleQualifiedName )
			{
			// InternalWeightDefinition.g:4929:4: ( ruleQualifiedName )
			// InternalWeightDefinition.g:4930:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXConstructorCallRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXConstructorCallAccess().getConstructorJvmConstructorCrossReference_2_0());
							}
			pushFollow(FOLLOW_69);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:4944:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?
			int alt79=2;
			alt79 = dfa79.predict(input);
			switch (alt79) {
				case 1 :
					// InternalWeightDefinition.g:4945:4: ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>'
					{
					// InternalWeightDefinition.g:4945:4: ( ( '<' )=>otherlv_3= '<' )
					// InternalWeightDefinition.g:4946:5: ( '<' )=>otherlv_3= '<'
					{
					otherlv_3=(Token)match(input,42,FOLLOW_32); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_3, grammarAccess.getXConstructorCallAccess().getLessThanSignKeyword_3_0());
									}
					}

					// InternalWeightDefinition.g:4952:4: ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) )
					// InternalWeightDefinition.g:4953:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
					{
					// InternalWeightDefinition.g:4953:5: (lv_typeArguments_4_0= ruleJvmArgumentTypeReference )
					// InternalWeightDefinition.g:4954:6: lv_typeArguments_4_0= ruleJvmArgumentTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_1_0());
										}
					pushFollow(FOLLOW_33);
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

					// InternalWeightDefinition.g:4971:4: (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )*
					loop78:
					while (true) {
						int alt78=2;
						int LA78_0 = input.LA(1);
						if ( (LA78_0==29) ) {
							alt78=1;
						}

						switch (alt78) {
						case 1 :
							// InternalWeightDefinition.g:4972:5: otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_5=(Token)match(input,29,FOLLOW_32); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_5, grammarAccess.getXConstructorCallAccess().getCommaKeyword_3_2_0());
											}
							// InternalWeightDefinition.g:4976:5: ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:4977:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:4977:6: (lv_typeArguments_6_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:4978:7: lv_typeArguments_6_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXConstructorCallAccess().getTypeArgumentsJvmArgumentTypeReferenceParserRuleCall_3_2_1_0());
													}
							pushFollow(FOLLOW_33);
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
							break loop78;
						}
					}

					otherlv_7=(Token)match(input,48,FOLLOW_67); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_7, grammarAccess.getXConstructorCallAccess().getGreaterThanSignKeyword_3_3());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:5001:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?
			int alt82=2;
			alt82 = dfa82.predict(input);
			switch (alt82) {
				case 1 :
					// InternalWeightDefinition.g:5002:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')'
					{
					// InternalWeightDefinition.g:5002:4: ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) )
					// InternalWeightDefinition.g:5003:5: ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' )
					{
					// InternalWeightDefinition.g:5007:5: (lv_explicitConstructorCall_8_0= '(' )
					// InternalWeightDefinition.g:5008:6: lv_explicitConstructorCall_8_0= '('
					{
					lv_explicitConstructorCall_8_0=(Token)match(input,21,FOLLOW_36); if (state.failed) return current;
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

					// InternalWeightDefinition.g:5020:4: ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )?
					int alt81=3;
					int LA81_0 = input.LA(1);
					if ( (LA81_0==RULE_ID) ) {
						int LA81_1 = input.LA(2);
						if ( (synpred35_InternalWeightDefinition()) ) {
							alt81=1;
						}
						else if ( (true) ) {
							alt81=2;
						}
					}
					else if ( (LA81_0==21) ) {
						int LA81_2 = input.LA(2);
						if ( (synpred35_InternalWeightDefinition()) ) {
							alt81=1;
						}
						else if ( (true) ) {
							alt81=2;
						}
					}
					else if ( (LA81_0==47) && (synpred35_InternalWeightDefinition())) {
						alt81=1;
					}
					else if ( (LA81_0==86) && (synpred35_InternalWeightDefinition())) {
						alt81=1;
					}
					else if ( ((LA81_0 >= RULE_DECIMAL && LA81_0 <= RULE_HEX)||LA81_0==RULE_INT||LA81_0==RULE_STRING||LA81_0==13||LA81_0==16||LA81_0==26||LA81_0==30||LA81_0==42||LA81_0==53||LA81_0==59||(LA81_0 >= 61 && LA81_0 <= 63)||LA81_0==65||(LA81_0 >= 67 && LA81_0 <= 68)||(LA81_0 >= 70 && LA81_0 <= 72)||(LA81_0 >= 74 && LA81_0 <= 81)||(LA81_0 >= 84 && LA81_0 <= 85)) ) {
						alt81=2;
					}
					switch (alt81) {
						case 1 :
							// InternalWeightDefinition.g:5021:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
							{
							// InternalWeightDefinition.g:5021:5: ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) )
							// InternalWeightDefinition.g:5022:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure )
							{
							// InternalWeightDefinition.g:5047:6: (lv_arguments_9_0= ruleXShortClosure )
							// InternalWeightDefinition.g:5048:7: lv_arguments_9_0= ruleXShortClosure
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXShortClosureParserRuleCall_4_1_0_0());
													}
							pushFollow(FOLLOW_37);
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
							// InternalWeightDefinition.g:5066:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
							{
							// InternalWeightDefinition.g:5066:5: ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* )
							// InternalWeightDefinition.g:5067:6: ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
							{
							// InternalWeightDefinition.g:5067:6: ( (lv_arguments_10_0= ruleXExpression ) )
							// InternalWeightDefinition.g:5068:7: (lv_arguments_10_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:5068:7: (lv_arguments_10_0= ruleXExpression )
							// InternalWeightDefinition.g:5069:8: lv_arguments_10_0= ruleXExpression
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_0_0());
														}
							pushFollow(FOLLOW_10);
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

							// InternalWeightDefinition.g:5086:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )*
							loop80:
							while (true) {
								int alt80=2;
								int LA80_0 = input.LA(1);
								if ( (LA80_0==29) ) {
									alt80=1;
								}

								switch (alt80) {
								case 1 :
									// InternalWeightDefinition.g:5087:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) )
									{
									otherlv_11=(Token)match(input,29,FOLLOW_12); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_11, grammarAccess.getXConstructorCallAccess().getCommaKeyword_4_1_1_1_0());
															}
									// InternalWeightDefinition.g:5091:7: ( (lv_arguments_12_0= ruleXExpression ) )
									// InternalWeightDefinition.g:5092:8: (lv_arguments_12_0= ruleXExpression )
									{
									// InternalWeightDefinition.g:5092:8: (lv_arguments_12_0= ruleXExpression )
									// InternalWeightDefinition.g:5093:9: lv_arguments_12_0= ruleXExpression
									{
									if ( state.backtracking==0 ) {
																		newCompositeNode(grammarAccess.getXConstructorCallAccess().getArgumentsXExpressionParserRuleCall_4_1_1_1_1_0());
																	}
									pushFollow(FOLLOW_10);
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
									break loop80;
								}
							}

							}

							}
							break;

					}

					otherlv_13=(Token)match(input,22,FOLLOW_68); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_13, grammarAccess.getXConstructorCallAccess().getRightParenthesisKeyword_4_2());
								}
					}
					break;

			}

			// InternalWeightDefinition.g:5118:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?
			int alt83=2;
			alt83 = dfa83.predict(input);
			switch (alt83) {
				case 1 :
					// InternalWeightDefinition.g:5119:4: ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure )
					{
					// InternalWeightDefinition.g:5125:4: (lv_arguments_14_0= ruleXClosure )
					// InternalWeightDefinition.g:5126:5: lv_arguments_14_0= ruleXClosure
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
	// InternalWeightDefinition.g:5147:1: entryRuleXBooleanLiteral returns [EObject current=null] :iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF ;
	public final EObject entryRuleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXBooleanLiteral =null;

		try {
			// InternalWeightDefinition.g:5147:56: (iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF )
			// InternalWeightDefinition.g:5148:2: iv_ruleXBooleanLiteral= ruleXBooleanLiteral EOF
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
	// InternalWeightDefinition.g:5154:1: ruleXBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) ;
	public final EObject ruleXBooleanLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token lv_isTrue_2_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5160:2: ( ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) ) )
			// InternalWeightDefinition.g:5161:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			{
			// InternalWeightDefinition.g:5161:2: ( () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) ) )
			// InternalWeightDefinition.g:5162:3: () (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			{
			// InternalWeightDefinition.g:5162:3: ()
			// InternalWeightDefinition.g:5163:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXBooleanLiteralAccess().getXBooleanLiteralAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:5169:3: (otherlv_1= 'false' | ( (lv_isTrue_2_0= 'true' ) ) )
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==63) ) {
				alt84=1;
			}
			else if ( (LA84_0==79) ) {
				alt84=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 84, 0, input);
				throw nvae;
			}

			switch (alt84) {
				case 1 :
					// InternalWeightDefinition.g:5170:4: otherlv_1= 'false'
					{
					otherlv_1=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_1, grammarAccess.getXBooleanLiteralAccess().getFalseKeyword_1_0());
								}
					}
					break;
				case 2 :
					// InternalWeightDefinition.g:5175:4: ( (lv_isTrue_2_0= 'true' ) )
					{
					// InternalWeightDefinition.g:5175:4: ( (lv_isTrue_2_0= 'true' ) )
					// InternalWeightDefinition.g:5176:5: (lv_isTrue_2_0= 'true' )
					{
					// InternalWeightDefinition.g:5176:5: (lv_isTrue_2_0= 'true' )
					// InternalWeightDefinition.g:5177:6: lv_isTrue_2_0= 'true'
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
	// InternalWeightDefinition.g:5194:1: entryRuleXNullLiteral returns [EObject current=null] :iv_ruleXNullLiteral= ruleXNullLiteral EOF ;
	public final EObject entryRuleXNullLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNullLiteral =null;

		try {
			// InternalWeightDefinition.g:5194:53: (iv_ruleXNullLiteral= ruleXNullLiteral EOF )
			// InternalWeightDefinition.g:5195:2: iv_ruleXNullLiteral= ruleXNullLiteral EOF
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
	// InternalWeightDefinition.g:5201:1: ruleXNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
	public final EObject ruleXNullLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5207:2: ( ( () otherlv_1= 'null' ) )
			// InternalWeightDefinition.g:5208:2: ( () otherlv_1= 'null' )
			{
			// InternalWeightDefinition.g:5208:2: ( () otherlv_1= 'null' )
			// InternalWeightDefinition.g:5209:3: () otherlv_1= 'null'
			{
			// InternalWeightDefinition.g:5209:3: ()
			// InternalWeightDefinition.g:5210:4: 
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
	// InternalWeightDefinition.g:5224:1: entryRuleXNumberLiteral returns [EObject current=null] :iv_ruleXNumberLiteral= ruleXNumberLiteral EOF ;
	public final EObject entryRuleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXNumberLiteral =null;

		try {
			// InternalWeightDefinition.g:5224:55: (iv_ruleXNumberLiteral= ruleXNumberLiteral EOF )
			// InternalWeightDefinition.g:5225:2: iv_ruleXNumberLiteral= ruleXNumberLiteral EOF
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
	// InternalWeightDefinition.g:5231:1: ruleXNumberLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleNumber ) ) ) ;
	public final EObject ruleXNumberLiteral() throws RecognitionException {
		EObject current = null;


		AntlrDatatypeRuleToken lv_value_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5237:2: ( ( () ( (lv_value_1_0= ruleNumber ) ) ) )
			// InternalWeightDefinition.g:5238:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			{
			// InternalWeightDefinition.g:5238:2: ( () ( (lv_value_1_0= ruleNumber ) ) )
			// InternalWeightDefinition.g:5239:3: () ( (lv_value_1_0= ruleNumber ) )
			{
			// InternalWeightDefinition.g:5239:3: ()
			// InternalWeightDefinition.g:5240:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXNumberLiteralAccess().getXNumberLiteralAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:5246:3: ( (lv_value_1_0= ruleNumber ) )
			// InternalWeightDefinition.g:5247:4: (lv_value_1_0= ruleNumber )
			{
			// InternalWeightDefinition.g:5247:4: (lv_value_1_0= ruleNumber )
			// InternalWeightDefinition.g:5248:5: lv_value_1_0= ruleNumber
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
	// InternalWeightDefinition.g:5269:1: entryRuleXStringLiteral returns [EObject current=null] :iv_ruleXStringLiteral= ruleXStringLiteral EOF ;
	public final EObject entryRuleXStringLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXStringLiteral =null;

		try {
			// InternalWeightDefinition.g:5269:55: (iv_ruleXStringLiteral= ruleXStringLiteral EOF )
			// InternalWeightDefinition.g:5270:2: iv_ruleXStringLiteral= ruleXStringLiteral EOF
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
	// InternalWeightDefinition.g:5276:1: ruleXStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
	public final EObject ruleXStringLiteral() throws RecognitionException {
		EObject current = null;


		Token lv_value_1_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5282:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
			// InternalWeightDefinition.g:5283:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			{
			// InternalWeightDefinition.g:5283:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
			// InternalWeightDefinition.g:5284:3: () ( (lv_value_1_0= RULE_STRING ) )
			{
			// InternalWeightDefinition.g:5284:3: ()
			// InternalWeightDefinition.g:5285:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXStringLiteralAccess().getXStringLiteralAction_0(),
								current);
						}
			}

			// InternalWeightDefinition.g:5291:3: ( (lv_value_1_0= RULE_STRING ) )
			// InternalWeightDefinition.g:5292:4: (lv_value_1_0= RULE_STRING )
			{
			// InternalWeightDefinition.g:5292:4: (lv_value_1_0= RULE_STRING )
			// InternalWeightDefinition.g:5293:5: lv_value_1_0= RULE_STRING
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
	// InternalWeightDefinition.g:5313:1: entryRuleXTypeLiteral returns [EObject current=null] :iv_ruleXTypeLiteral= ruleXTypeLiteral EOF ;
	public final EObject entryRuleXTypeLiteral() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXTypeLiteral =null;

		try {
			// InternalWeightDefinition.g:5313:53: (iv_ruleXTypeLiteral= ruleXTypeLiteral EOF )
			// InternalWeightDefinition.g:5314:2: iv_ruleXTypeLiteral= ruleXTypeLiteral EOF
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
	// InternalWeightDefinition.g:5320:1: ruleXTypeLiteral returns [EObject current=null] : ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) ;
	public final EObject ruleXTypeLiteral() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_5=null;
		AntlrDatatypeRuleToken lv_arrayDimensions_4_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5326:2: ( ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' ) )
			// InternalWeightDefinition.g:5327:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
			{
			// InternalWeightDefinition.g:5327:2: ( () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')' )
			// InternalWeightDefinition.g:5328:3: () otherlv_1= 'typeof' otherlv_2= '(' ( ( ruleQualifiedName ) ) ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )* otherlv_5= ')'
			{
			// InternalWeightDefinition.g:5328:3: ()
			// InternalWeightDefinition.g:5329:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXTypeLiteralAccess().getXTypeLiteralAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,81,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXTypeLiteralAccess().getTypeofKeyword_1());
					}
			otherlv_2=(Token)match(input,21,FOLLOW_5); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_2, grammarAccess.getXTypeLiteralAccess().getLeftParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:5343:3: ( ( ruleQualifiedName ) )
			// InternalWeightDefinition.g:5344:4: ( ruleQualifiedName )
			{
			// InternalWeightDefinition.g:5344:4: ( ruleQualifiedName )
			// InternalWeightDefinition.g:5345:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getXTypeLiteralRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXTypeLiteralAccess().getTypeJvmTypeCrossReference_3_0());
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

			// InternalWeightDefinition.g:5359:3: ( (lv_arrayDimensions_4_0= ruleArrayBrackets ) )*
			loop85:
			while (true) {
				int alt85=2;
				int LA85_0 = input.LA(1);
				if ( (LA85_0==53) ) {
					alt85=1;
				}

				switch (alt85) {
				case 1 :
					// InternalWeightDefinition.g:5360:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
					{
					// InternalWeightDefinition.g:5360:4: (lv_arrayDimensions_4_0= ruleArrayBrackets )
					// InternalWeightDefinition.g:5361:5: lv_arrayDimensions_4_0= ruleArrayBrackets
					{
					if ( state.backtracking==0 ) {
										newCompositeNode(grammarAccess.getXTypeLiteralAccess().getArrayDimensionsArrayBracketsParserRuleCall_4_0());
									}
					pushFollow(FOLLOW_70);
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
					break loop85;
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
	// InternalWeightDefinition.g:5386:1: entryRuleXThrowExpression returns [EObject current=null] :iv_ruleXThrowExpression= ruleXThrowExpression EOF ;
	public final EObject entryRuleXThrowExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXThrowExpression =null;

		try {
			// InternalWeightDefinition.g:5386:57: (iv_ruleXThrowExpression= ruleXThrowExpression EOF )
			// InternalWeightDefinition.g:5387:2: iv_ruleXThrowExpression= ruleXThrowExpression EOF
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
	// InternalWeightDefinition.g:5393:1: ruleXThrowExpression returns [EObject current=null] : ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) ;
	public final EObject ruleXThrowExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5399:2: ( ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:5400:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:5400:2: ( () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:5401:3: () otherlv_1= 'throw' ( (lv_expression_2_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:5401:3: ()
			// InternalWeightDefinition.g:5402:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXThrowExpressionAccess().getXThrowExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,78,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXThrowExpressionAccess().getThrowKeyword_1());
					}
			// InternalWeightDefinition.g:5412:3: ( (lv_expression_2_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5413:4: (lv_expression_2_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5413:4: (lv_expression_2_0= ruleXExpression )
			// InternalWeightDefinition.g:5414:5: lv_expression_2_0= ruleXExpression
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
	// InternalWeightDefinition.g:5435:1: entryRuleXReturnExpression returns [EObject current=null] :iv_ruleXReturnExpression= ruleXReturnExpression EOF ;
	public final EObject entryRuleXReturnExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXReturnExpression =null;

		try {
			// InternalWeightDefinition.g:5435:58: (iv_ruleXReturnExpression= ruleXReturnExpression EOF )
			// InternalWeightDefinition.g:5436:2: iv_ruleXReturnExpression= ruleXReturnExpression EOF
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
	// InternalWeightDefinition.g:5442:1: ruleXReturnExpression returns [EObject current=null] : ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) ;
	public final EObject ruleXReturnExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_expression_2_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5448:2: ( ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? ) )
			// InternalWeightDefinition.g:5449:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			{
			// InternalWeightDefinition.g:5449:2: ( () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )? )
			// InternalWeightDefinition.g:5450:3: () otherlv_1= 'return' ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			{
			// InternalWeightDefinition.g:5450:3: ()
			// InternalWeightDefinition.g:5451:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXReturnExpressionAccess().getXReturnExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,72,FOLLOW_71); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXReturnExpressionAccess().getReturnKeyword_1());
					}
			// InternalWeightDefinition.g:5461:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?
			int alt86=2;
			alt86 = dfa86.predict(input);
			switch (alt86) {
				case 1 :
					// InternalWeightDefinition.g:5462:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:5463:4: (lv_expression_2_0= ruleXExpression )
					// InternalWeightDefinition.g:5464:5: lv_expression_2_0= ruleXExpression
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
	// InternalWeightDefinition.g:5485:1: entryRuleXTryCatchFinallyExpression returns [EObject current=null] :iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF ;
	public final EObject entryRuleXTryCatchFinallyExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXTryCatchFinallyExpression =null;

		try {
			// InternalWeightDefinition.g:5485:67: (iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF )
			// InternalWeightDefinition.g:5486:2: iv_ruleXTryCatchFinallyExpression= ruleXTryCatchFinallyExpression EOF
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
	// InternalWeightDefinition.g:5492:1: ruleXTryCatchFinallyExpression returns [EObject current=null] : ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) ;
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
			// InternalWeightDefinition.g:5498:2: ( ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) ) )
			// InternalWeightDefinition.g:5499:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
			{
			// InternalWeightDefinition.g:5499:2: ( () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) ) )
			// InternalWeightDefinition.g:5500:3: () otherlv_1= 'try' ( (lv_expression_2_0= ruleXExpression ) ) ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
			{
			// InternalWeightDefinition.g:5500:3: ()
			// InternalWeightDefinition.g:5501:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getXTryCatchFinallyExpressionAccess().getXTryCatchFinallyExpressionAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,80,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXTryCatchFinallyExpressionAccess().getTryKeyword_1());
					}
			// InternalWeightDefinition.g:5511:3: ( (lv_expression_2_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5512:4: (lv_expression_2_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5512:4: (lv_expression_2_0= ruleXExpression )
			// InternalWeightDefinition.g:5513:5: lv_expression_2_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getExpressionXExpressionParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_72);
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

			// InternalWeightDefinition.g:5530:3: ( ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? ) | (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) ) )
			int alt89=2;
			int LA89_0 = input.LA(1);
			if ( (LA89_0==57) ) {
				alt89=1;
			}
			else if ( (LA89_0==64) ) {
				alt89=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 89, 0, input);
				throw nvae;
			}

			switch (alt89) {
				case 1 :
					// InternalWeightDefinition.g:5531:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
					{
					// InternalWeightDefinition.g:5531:4: ( ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )? )
					// InternalWeightDefinition.g:5532:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+ ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
					{
					// InternalWeightDefinition.g:5532:5: ( ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause ) )+
					int cnt87=0;
					loop87:
					while (true) {
						int alt87=2;
						int LA87_0 = input.LA(1);
						if ( (LA87_0==57) ) {
							int LA87_2 = input.LA(2);
							if ( (synpred38_InternalWeightDefinition()) ) {
								alt87=1;
							}

						}

						switch (alt87) {
						case 1 :
							// InternalWeightDefinition.g:5533:6: ( 'catch' )=> (lv_catchClauses_3_0= ruleXCatchClause )
							{
							// InternalWeightDefinition.g:5534:6: (lv_catchClauses_3_0= ruleXCatchClause )
							// InternalWeightDefinition.g:5535:7: lv_catchClauses_3_0= ruleXCatchClause
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXTryCatchFinallyExpressionAccess().getCatchClausesXCatchClauseParserRuleCall_3_0_0_0());
													}
							pushFollow(FOLLOW_73);
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
							if ( cnt87 >= 1 ) break loop87;
							if (state.backtracking>0) {state.failed=true; return current;}
							EarlyExitException eee = new EarlyExitException(87, input);
							throw eee;
						}
						cnt87++;
					}

					// InternalWeightDefinition.g:5552:5: ( ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) ) )?
					int alt88=2;
					int LA88_0 = input.LA(1);
					if ( (LA88_0==64) ) {
						int LA88_1 = input.LA(2);
						if ( (synpred39_InternalWeightDefinition()) ) {
							alt88=1;
						}
					}
					switch (alt88) {
						case 1 :
							// InternalWeightDefinition.g:5553:6: ( ( 'finally' )=>otherlv_4= 'finally' ) ( (lv_finallyExpression_5_0= ruleXExpression ) )
							{
							// InternalWeightDefinition.g:5553:6: ( ( 'finally' )=>otherlv_4= 'finally' )
							// InternalWeightDefinition.g:5554:7: ( 'finally' )=>otherlv_4= 'finally'
							{
							otherlv_4=(Token)match(input,64,FOLLOW_12); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_4, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_0_1_0());
													}
							}

							// InternalWeightDefinition.g:5560:6: ( (lv_finallyExpression_5_0= ruleXExpression ) )
							// InternalWeightDefinition.g:5561:7: (lv_finallyExpression_5_0= ruleXExpression )
							{
							// InternalWeightDefinition.g:5561:7: (lv_finallyExpression_5_0= ruleXExpression )
							// InternalWeightDefinition.g:5562:8: lv_finallyExpression_5_0= ruleXExpression
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
					// InternalWeightDefinition.g:5582:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
					{
					// InternalWeightDefinition.g:5582:4: (otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) ) )
					// InternalWeightDefinition.g:5583:5: otherlv_6= 'finally' ( (lv_finallyExpression_7_0= ruleXExpression ) )
					{
					otherlv_6=(Token)match(input,64,FOLLOW_12); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_6, grammarAccess.getXTryCatchFinallyExpressionAccess().getFinallyKeyword_3_1_0());
									}
					// InternalWeightDefinition.g:5587:5: ( (lv_finallyExpression_7_0= ruleXExpression ) )
					// InternalWeightDefinition.g:5588:6: (lv_finallyExpression_7_0= ruleXExpression )
					{
					// InternalWeightDefinition.g:5588:6: (lv_finallyExpression_7_0= ruleXExpression )
					// InternalWeightDefinition.g:5589:7: lv_finallyExpression_7_0= ruleXExpression
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
	// InternalWeightDefinition.g:5612:1: entryRuleXSynchronizedExpression returns [EObject current=null] :iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF ;
	public final EObject entryRuleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXSynchronizedExpression =null;

		try {
			// InternalWeightDefinition.g:5612:64: (iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF )
			// InternalWeightDefinition.g:5613:2: iv_ruleXSynchronizedExpression= ruleXSynchronizedExpression EOF
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
	// InternalWeightDefinition.g:5619:1: ruleXSynchronizedExpression returns [EObject current=null] : ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) ;
	public final EObject ruleXSynchronizedExpression() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		Token otherlv_2=null;
		Token otherlv_4=null;
		EObject lv_param_3_0 =null;
		EObject lv_expression_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5625:2: ( ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:5626:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:5626:2: ( ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:5627:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) ) ( (lv_param_3_0= ruleXExpression ) ) otherlv_4= ')' ( (lv_expression_5_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:5627:3: ( ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' ) )
			// InternalWeightDefinition.g:5628:4: ( ( () 'synchronized' '(' ) )=> ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			{
			// InternalWeightDefinition.g:5635:4: ( () otherlv_1= 'synchronized' otherlv_2= '(' )
			// InternalWeightDefinition.g:5636:5: () otherlv_1= 'synchronized' otherlv_2= '('
			{
			// InternalWeightDefinition.g:5636:5: ()
			// InternalWeightDefinition.g:5637:6: 
			{
			if ( state.backtracking==0 ) {
									current = forceCreateModelElement(
										grammarAccess.getXSynchronizedExpressionAccess().getXSynchronizedExpressionAction_0_0_0(),
										current);
								}
			}

			otherlv_1=(Token)match(input,77,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_1, grammarAccess.getXSynchronizedExpressionAccess().getSynchronizedKeyword_0_0_1());
							}
			otherlv_2=(Token)match(input,21,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
								newLeafNode(otherlv_2, grammarAccess.getXSynchronizedExpressionAccess().getLeftParenthesisKeyword_0_0_2());
							}
			}

			}

			// InternalWeightDefinition.g:5653:3: ( (lv_param_3_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5654:4: (lv_param_3_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5654:4: (lv_param_3_0= ruleXExpression )
			// InternalWeightDefinition.g:5655:5: lv_param_3_0= ruleXExpression
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXSynchronizedExpressionAccess().getParamXExpressionParserRuleCall_1_0());
							}
			pushFollow(FOLLOW_37);
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

			otherlv_4=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_4, grammarAccess.getXSynchronizedExpressionAccess().getRightParenthesisKeyword_2());
					}
			// InternalWeightDefinition.g:5676:3: ( (lv_expression_5_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5677:4: (lv_expression_5_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5677:4: (lv_expression_5_0= ruleXExpression )
			// InternalWeightDefinition.g:5678:5: lv_expression_5_0= ruleXExpression
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
	// InternalWeightDefinition.g:5699:1: entryRuleXCatchClause returns [EObject current=null] :iv_ruleXCatchClause= ruleXCatchClause EOF ;
	public final EObject entryRuleXCatchClause() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXCatchClause =null;

		try {
			// InternalWeightDefinition.g:5699:53: (iv_ruleXCatchClause= ruleXCatchClause EOF )
			// InternalWeightDefinition.g:5700:2: iv_ruleXCatchClause= ruleXCatchClause EOF
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
	// InternalWeightDefinition.g:5706:1: ruleXCatchClause returns [EObject current=null] : ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) ;
	public final EObject ruleXCatchClause() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		Token otherlv_1=null;
		Token otherlv_3=null;
		EObject lv_declaredParam_2_0 =null;
		EObject lv_expression_4_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5712:2: ( ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) ) )
			// InternalWeightDefinition.g:5713:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
			{
			// InternalWeightDefinition.g:5713:2: ( ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) ) )
			// InternalWeightDefinition.g:5714:3: ( ( 'catch' )=>otherlv_0= 'catch' ) otherlv_1= '(' ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) ) otherlv_3= ')' ( (lv_expression_4_0= ruleXExpression ) )
			{
			// InternalWeightDefinition.g:5714:3: ( ( 'catch' )=>otherlv_0= 'catch' )
			// InternalWeightDefinition.g:5715:4: ( 'catch' )=>otherlv_0= 'catch'
			{
			otherlv_0=(Token)match(input,57,FOLLOW_8); if (state.failed) return current;
			if ( state.backtracking==0 ) {
							newLeafNode(otherlv_0, grammarAccess.getXCatchClauseAccess().getCatchKeyword_0());
						}
			}

			otherlv_1=(Token)match(input,21,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getXCatchClauseAccess().getLeftParenthesisKeyword_1());
					}
			// InternalWeightDefinition.g:5725:3: ( (lv_declaredParam_2_0= ruleFullJvmFormalParameter ) )
			// InternalWeightDefinition.g:5726:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
			{
			// InternalWeightDefinition.g:5726:4: (lv_declaredParam_2_0= ruleFullJvmFormalParameter )
			// InternalWeightDefinition.g:5727:5: lv_declaredParam_2_0= ruleFullJvmFormalParameter
			{
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getXCatchClauseAccess().getDeclaredParamFullJvmFormalParameterParserRuleCall_2_0());
							}
			pushFollow(FOLLOW_37);
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

			otherlv_3=(Token)match(input,22,FOLLOW_12); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_3, grammarAccess.getXCatchClauseAccess().getRightParenthesisKeyword_3());
					}
			// InternalWeightDefinition.g:5748:3: ( (lv_expression_4_0= ruleXExpression ) )
			// InternalWeightDefinition.g:5749:4: (lv_expression_4_0= ruleXExpression )
			{
			// InternalWeightDefinition.g:5749:4: (lv_expression_4_0= ruleXExpression )
			// InternalWeightDefinition.g:5750:5: lv_expression_4_0= ruleXExpression
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
	// InternalWeightDefinition.g:5771:1: entryRuleQualifiedName returns [String current=null] :iv_ruleQualifiedName= ruleQualifiedName EOF ;
	public final String entryRuleQualifiedName() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedName =null;

		try {
			// InternalWeightDefinition.g:5771:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
			// InternalWeightDefinition.g:5772:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
	// InternalWeightDefinition.g:5778:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;
		AntlrDatatypeRuleToken this_ValidID_2 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5784:2: ( (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* ) )
			// InternalWeightDefinition.g:5785:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			{
			// InternalWeightDefinition.g:5785:2: (this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )* )
			// InternalWeightDefinition.g:5786:3: this_ValidID_0= ruleValidID ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0());
					}
			pushFollow(FOLLOW_74);
			this_ValidID_0=ruleValidID();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(this_ValidID_0);
					}
			if ( state.backtracking==0 ) {
						afterParserOrEnumRuleCall();
					}
			// InternalWeightDefinition.g:5796:3: ( ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID )*
			loop90:
			while (true) {
				int alt90=2;
				int LA90_0 = input.LA(1);
				if ( (LA90_0==34) ) {
					int LA90_2 = input.LA(2);
					if ( (LA90_2==RULE_ID) ) {
						int LA90_3 = input.LA(3);
						if ( (synpred42_InternalWeightDefinition()) ) {
							alt90=1;
						}

					}

				}

				switch (alt90) {
				case 1 :
					// InternalWeightDefinition.g:5797:4: ( ( '.' )=>kw= '.' ) this_ValidID_2= ruleValidID
					{
					// InternalWeightDefinition.g:5797:4: ( ( '.' )=>kw= '.' )
					// InternalWeightDefinition.g:5798:5: ( '.' )=>kw= '.'
					{
					kw=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										current.merge(kw);
										newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
									}
					}

					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1());
								}
					pushFollow(FOLLOW_74);
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
					break loop90;
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
	// InternalWeightDefinition.g:5820:1: entryRuleNumber returns [String current=null] :iv_ruleNumber= ruleNumber EOF ;
	public final String entryRuleNumber() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleNumber =null;


			HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

		try {
			// InternalWeightDefinition.g:5822:2: (iv_ruleNumber= ruleNumber EOF )
			// InternalWeightDefinition.g:5823:2: iv_ruleNumber= ruleNumber EOF
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
	// InternalWeightDefinition.g:5832:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) ;
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
			// InternalWeightDefinition.g:5839:2: ( (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) ) )
			// InternalWeightDefinition.g:5840:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			{
			// InternalWeightDefinition.g:5840:2: (this_HEX_0= RULE_HEX | ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? ) )
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==RULE_HEX) ) {
				alt94=1;
			}
			else if ( (LA94_0==RULE_DECIMAL||LA94_0==RULE_INT) ) {
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
					// InternalWeightDefinition.g:5841:3: this_HEX_0= RULE_HEX
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
					// InternalWeightDefinition.g:5849:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					{
					// InternalWeightDefinition.g:5849:3: ( (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )? )
					// InternalWeightDefinition.g:5850:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL ) (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					{
					// InternalWeightDefinition.g:5850:4: (this_INT_1= RULE_INT |this_DECIMAL_2= RULE_DECIMAL )
					int alt91=2;
					int LA91_0 = input.LA(1);
					if ( (LA91_0==RULE_INT) ) {
						alt91=1;
					}
					else if ( (LA91_0==RULE_DECIMAL) ) {
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
							// InternalWeightDefinition.g:5851:5: this_INT_1= RULE_INT
							{
							this_INT_1=(Token)match(input,RULE_INT,FOLLOW_74); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(this_INT_1);
											}
							if ( state.backtracking==0 ) {
												newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_0_0());
											}
							}
							break;
						case 2 :
							// InternalWeightDefinition.g:5859:5: this_DECIMAL_2= RULE_DECIMAL
							{
							this_DECIMAL_2=(Token)match(input,RULE_DECIMAL,FOLLOW_74); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(this_DECIMAL_2);
											}
							if ( state.backtracking==0 ) {
												newLeafNode(this_DECIMAL_2, grammarAccess.getNumberAccess().getDECIMALTerminalRuleCall_1_0_1());
											}
							}
							break;

					}

					// InternalWeightDefinition.g:5867:4: (kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL ) )?
					int alt93=2;
					int LA93_0 = input.LA(1);
					if ( (LA93_0==34) ) {
						int LA93_1 = input.LA(2);
						if ( (LA93_1==RULE_DECIMAL||LA93_1==RULE_INT) ) {
							alt93=1;
						}
					}
					switch (alt93) {
						case 1 :
							// InternalWeightDefinition.g:5868:5: kw= '.' (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
							{
							kw=(Token)match(input,34,FOLLOW_75); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												current.merge(kw);
												newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_1_0());
											}
							// InternalWeightDefinition.g:5873:5: (this_INT_4= RULE_INT |this_DECIMAL_5= RULE_DECIMAL )
							int alt92=2;
							int LA92_0 = input.LA(1);
							if ( (LA92_0==RULE_INT) ) {
								alt92=1;
							}
							else if ( (LA92_0==RULE_DECIMAL) ) {
								alt92=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return current;}
								NoViableAltException nvae =
									new NoViableAltException("", 92, 0, input);
								throw nvae;
							}

							switch (alt92) {
								case 1 :
									// InternalWeightDefinition.g:5874:6: this_INT_4= RULE_INT
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
									// InternalWeightDefinition.g:5882:6: this_DECIMAL_5= RULE_DECIMAL
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
	// InternalWeightDefinition.g:5899:1: entryRuleJvmTypeReference returns [EObject current=null] :iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
	public final EObject entryRuleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmTypeReference =null;

		try {
			// InternalWeightDefinition.g:5899:57: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
			// InternalWeightDefinition.g:5900:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
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
	// InternalWeightDefinition.g:5906:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
	public final EObject ruleJvmTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmParameterizedTypeReference_0 =null;
		EObject this_XFunctionTypeRef_3 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5912:2: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
			// InternalWeightDefinition.g:5913:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
			{
			// InternalWeightDefinition.g:5913:2: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) |this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
			int alt96=2;
			int LA96_0 = input.LA(1);
			if ( (LA96_0==RULE_ID) ) {
				alt96=1;
			}
			else if ( (LA96_0==21||LA96_0==47) ) {
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
					// InternalWeightDefinition.g:5914:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
					{
					// InternalWeightDefinition.g:5914:3: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
					// InternalWeightDefinition.g:5915:4: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
					{
					if ( state.backtracking==0 ) {
									newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0());
								}
					pushFollow(FOLLOW_68);
					this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
									current = this_JvmParameterizedTypeReference_0;
									afterParserOrEnumRuleCall();
								}
					// InternalWeightDefinition.g:5923:4: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
					loop95:
					while (true) {
						int alt95=2;
						int LA95_0 = input.LA(1);
						if ( (LA95_0==53) ) {
							int LA95_2 = input.LA(2);
							if ( (LA95_2==54) ) {
								int LA95_3 = input.LA(3);
								if ( (synpred43_InternalWeightDefinition()) ) {
									alt95=1;
								}

							}

						}

						switch (alt95) {
						case 1 :
							// InternalWeightDefinition.g:5924:5: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
							{
							// InternalWeightDefinition.g:5930:5: ( () ruleArrayBrackets )
							// InternalWeightDefinition.g:5931:6: () ruleArrayBrackets
							{
							// InternalWeightDefinition.g:5931:6: ()
							// InternalWeightDefinition.g:5932:7: 
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
							pushFollow(FOLLOW_68);
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
							break loop95;
						}
					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:5949:3: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
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
	// InternalWeightDefinition.g:5961:1: entryRuleArrayBrackets returns [String current=null] :iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
	public final String entryRuleArrayBrackets() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleArrayBrackets =null;

		try {
			// InternalWeightDefinition.g:5961:53: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
			// InternalWeightDefinition.g:5962:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
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
	// InternalWeightDefinition.g:5968:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
	public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:5974:2: ( (kw= '[' kw= ']' ) )
			// InternalWeightDefinition.g:5975:2: (kw= '[' kw= ']' )
			{
			// InternalWeightDefinition.g:5975:2: (kw= '[' kw= ']' )
			// InternalWeightDefinition.g:5976:3: kw= '[' kw= ']'
			{
			kw=(Token)match(input,53,FOLLOW_47); if (state.failed) return current;
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
	// InternalWeightDefinition.g:5990:1: entryRuleXFunctionTypeRef returns [EObject current=null] :iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
	public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXFunctionTypeRef =null;

		try {
			// InternalWeightDefinition.g:5990:57: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
			// InternalWeightDefinition.g:5991:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
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
	// InternalWeightDefinition.g:5997:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
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
			// InternalWeightDefinition.g:6003:2: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6004:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6004:2: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6005:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
			{
			// InternalWeightDefinition.g:6005:3: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
			int alt99=2;
			int LA99_0 = input.LA(1);
			if ( (LA99_0==21) ) {
				alt99=1;
			}
			switch (alt99) {
				case 1 :
					// InternalWeightDefinition.g:6006:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
					{
					otherlv_0=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
								}
					// InternalWeightDefinition.g:6010:4: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
					int alt98=2;
					int LA98_0 = input.LA(1);
					if ( (LA98_0==RULE_ID||LA98_0==21||LA98_0==47) ) {
						alt98=1;
					}
					switch (alt98) {
						case 1 :
							// InternalWeightDefinition.g:6011:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
							{
							// InternalWeightDefinition.g:6011:5: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
							// InternalWeightDefinition.g:6012:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
							{
							// InternalWeightDefinition.g:6012:6: (lv_paramTypes_1_0= ruleJvmTypeReference )
							// InternalWeightDefinition.g:6013:7: lv_paramTypes_1_0= ruleJvmTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0());
													}
							pushFollow(FOLLOW_10);
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

							// InternalWeightDefinition.g:6030:5: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
							loop97:
							while (true) {
								int alt97=2;
								int LA97_0 = input.LA(1);
								if ( (LA97_0==29) ) {
									alt97=1;
								}

								switch (alt97) {
								case 1 :
									// InternalWeightDefinition.g:6031:6: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
									{
									otherlv_2=(Token)match(input,29,FOLLOW_7); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
														}
									// InternalWeightDefinition.g:6035:6: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
									// InternalWeightDefinition.g:6036:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
									{
									// InternalWeightDefinition.g:6036:7: (lv_paramTypes_3_0= ruleJvmTypeReference )
									// InternalWeightDefinition.g:6037:8: lv_paramTypes_3_0= ruleJvmTypeReference
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0());
																}
									pushFollow(FOLLOW_10);
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
									break loop97;
								}
							}

							}
							break;

					}

					otherlv_4=(Token)match(input,22,FOLLOW_76); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
								}
					}
					break;

			}

			otherlv_5=(Token)match(input,47,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
					}
			// InternalWeightDefinition.g:6065:3: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6066:4: (lv_returnType_6_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6066:4: (lv_returnType_6_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6067:5: lv_returnType_6_0= ruleJvmTypeReference
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
	// InternalWeightDefinition.g:6088:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] :iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
	public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmParameterizedTypeReference =null;

		try {
			// InternalWeightDefinition.g:6088:70: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
			// InternalWeightDefinition.g:6089:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
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
	// InternalWeightDefinition.g:6095:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) ;
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
			// InternalWeightDefinition.g:6101:2: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? ) )
			// InternalWeightDefinition.g:6102:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			{
			// InternalWeightDefinition.g:6102:2: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )? )
			// InternalWeightDefinition.g:6103:3: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			{
			// InternalWeightDefinition.g:6103:3: ( ( ruleQualifiedName ) )
			// InternalWeightDefinition.g:6104:4: ( ruleQualifiedName )
			{
			// InternalWeightDefinition.g:6104:4: ( ruleQualifiedName )
			// InternalWeightDefinition.g:6105:5: ruleQualifiedName
			{
			if ( state.backtracking==0 ) {
								if (current==null) {
									current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
								}
							}
			if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0());
							}
			pushFollow(FOLLOW_77);
			ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
			}

			}

			// InternalWeightDefinition.g:6119:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?
			int alt104=2;
			alt104 = dfa104.predict(input);
			switch (alt104) {
				case 1 :
					// InternalWeightDefinition.g:6120:4: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					{
					// InternalWeightDefinition.g:6120:4: ( ( '<' )=>otherlv_1= '<' )
					// InternalWeightDefinition.g:6121:5: ( '<' )=>otherlv_1= '<'
					{
					otherlv_1=(Token)match(input,42,FOLLOW_32); if (state.failed) return current;
					if ( state.backtracking==0 ) {
										newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
									}
					}

					// InternalWeightDefinition.g:6127:4: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
					// InternalWeightDefinition.g:6128:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					{
					// InternalWeightDefinition.g:6128:5: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
					// InternalWeightDefinition.g:6129:6: lv_arguments_2_0= ruleJvmArgumentTypeReference
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0());
										}
					pushFollow(FOLLOW_33);
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

					// InternalWeightDefinition.g:6146:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
					loop100:
					while (true) {
						int alt100=2;
						int LA100_0 = input.LA(1);
						if ( (LA100_0==29) ) {
							alt100=1;
						}

						switch (alt100) {
						case 1 :
							// InternalWeightDefinition.g:6147:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							{
							otherlv_3=(Token)match(input,29,FOLLOW_32); if (state.failed) return current;
							if ( state.backtracking==0 ) {
												newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
											}
							// InternalWeightDefinition.g:6151:5: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
							// InternalWeightDefinition.g:6152:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							{
							// InternalWeightDefinition.g:6152:6: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
							// InternalWeightDefinition.g:6153:7: lv_arguments_4_0= ruleJvmArgumentTypeReference
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0());
													}
							pushFollow(FOLLOW_33);
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
							break loop100;
						}
					}

					otherlv_5=(Token)match(input,48,FOLLOW_74); if (state.failed) return current;
					if ( state.backtracking==0 ) {
									newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
								}
					// InternalWeightDefinition.g:6175:4: ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )*
					loop103:
					while (true) {
						int alt103=2;
						int LA103_0 = input.LA(1);
						if ( (LA103_0==34) ) {
							int LA103_2 = input.LA(2);
							if ( (LA103_2==RULE_ID) ) {
								int LA103_3 = input.LA(3);
								if ( (synpred45_InternalWeightDefinition()) ) {
									alt103=1;
								}

							}

						}

						switch (alt103) {
						case 1 :
							// InternalWeightDefinition.g:6176:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							{
							// InternalWeightDefinition.g:6176:5: ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) )
							// InternalWeightDefinition.g:6177:6: ( ( () '.' ) )=> ( () otherlv_7= '.' )
							{
							// InternalWeightDefinition.g:6183:6: ( () otherlv_7= '.' )
							// InternalWeightDefinition.g:6184:7: () otherlv_7= '.'
							{
							// InternalWeightDefinition.g:6184:7: ()
							// InternalWeightDefinition.g:6185:8: 
							{
							if ( state.backtracking==0 ) {
															current = forceCreateModelElementAndSet(
																grammarAccess.getJvmParameterizedTypeReferenceAccess().getJvmInnerTypeReferenceOuterAction_1_4_0_0_0(),
																current);
														}
							}

							otherlv_7=(Token)match(input,34,FOLLOW_5); if (state.failed) return current;
							if ( state.backtracking==0 ) {
														newLeafNode(otherlv_7, grammarAccess.getJvmParameterizedTypeReferenceAccess().getFullStopKeyword_1_4_0_0_1());
													}
							}

							}

							// InternalWeightDefinition.g:6197:5: ( ( ruleValidID ) )
							// InternalWeightDefinition.g:6198:6: ( ruleValidID )
							{
							// InternalWeightDefinition.g:6198:6: ( ruleValidID )
							// InternalWeightDefinition.g:6199:7: ruleValidID
							{
							if ( state.backtracking==0 ) {
														if (current==null) {
															current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
														}
													}
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_1_4_1_0());
													}
							pushFollow(FOLLOW_78);
							ruleValidID();
							state._fsp--;
							if (state.failed) return current;
							if ( state.backtracking==0 ) {
														afterParserOrEnumRuleCall();
													}
							}

							}

							// InternalWeightDefinition.g:6213:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?
							int alt102=2;
							alt102 = dfa102.predict(input);
							switch (alt102) {
								case 1 :
									// InternalWeightDefinition.g:6214:6: ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>'
									{
									// InternalWeightDefinition.g:6214:6: ( ( '<' )=>otherlv_9= '<' )
									// InternalWeightDefinition.g:6215:7: ( '<' )=>otherlv_9= '<'
									{
									otherlv_9=(Token)match(input,42,FOLLOW_32); if (state.failed) return current;
									if ( state.backtracking==0 ) {
																newLeafNode(otherlv_9, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_4_2_0());
															}
									}

									// InternalWeightDefinition.g:6221:6: ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) )
									// InternalWeightDefinition.g:6222:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									{
									// InternalWeightDefinition.g:6222:7: (lv_arguments_10_0= ruleJvmArgumentTypeReference )
									// InternalWeightDefinition.g:6223:8: lv_arguments_10_0= ruleJvmArgumentTypeReference
									{
									if ( state.backtracking==0 ) {
																	newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_1_0());
																}
									pushFollow(FOLLOW_33);
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

									// InternalWeightDefinition.g:6240:6: (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )*
									loop101:
									while (true) {
										int alt101=2;
										int LA101_0 = input.LA(1);
										if ( (LA101_0==29) ) {
											alt101=1;
										}

										switch (alt101) {
										case 1 :
											// InternalWeightDefinition.g:6241:7: otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											{
											otherlv_11=(Token)match(input,29,FOLLOW_32); if (state.failed) return current;
											if ( state.backtracking==0 ) {
																		newLeafNode(otherlv_11, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_4_2_2_0());
																	}
											// InternalWeightDefinition.g:6245:7: ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) )
											// InternalWeightDefinition.g:6246:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											{
											// InternalWeightDefinition.g:6246:8: (lv_arguments_12_0= ruleJvmArgumentTypeReference )
											// InternalWeightDefinition.g:6247:9: lv_arguments_12_0= ruleJvmArgumentTypeReference
											{
											if ( state.backtracking==0 ) {
																				newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_4_2_2_1_0());
																			}
											pushFollow(FOLLOW_33);
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
											break loop101;
										}
									}

									otherlv_13=(Token)match(input,48,FOLLOW_74); if (state.failed) return current;
									if ( state.backtracking==0 ) {
															newLeafNode(otherlv_13, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_4_2_3());
														}
									}
									break;

							}

							}
							break;

						default :
							break loop103;
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
	// InternalWeightDefinition.g:6276:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] :iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
	public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmArgumentTypeReference =null;

		try {
			// InternalWeightDefinition.g:6276:65: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
			// InternalWeightDefinition.g:6277:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
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
	// InternalWeightDefinition.g:6283:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
	public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
		EObject current = null;


		EObject this_JvmTypeReference_0 =null;
		EObject this_JvmWildcardTypeReference_1 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6289:2: ( (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
			// InternalWeightDefinition.g:6290:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			{
			// InternalWeightDefinition.g:6290:2: (this_JvmTypeReference_0= ruleJvmTypeReference |this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
			int alt105=2;
			int LA105_0 = input.LA(1);
			if ( (LA105_0==RULE_ID||LA105_0==21||LA105_0==47) ) {
				alt105=1;
			}
			else if ( (LA105_0==50) ) {
				alt105=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return current;}
				NoViableAltException nvae =
					new NoViableAltException("", 105, 0, input);
				throw nvae;
			}

			switch (alt105) {
				case 1 :
					// InternalWeightDefinition.g:6291:3: this_JvmTypeReference_0= ruleJvmTypeReference
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
					// InternalWeightDefinition.g:6300:3: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
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
	// InternalWeightDefinition.g:6312:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] :iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
	public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmWildcardTypeReference =null;

		try {
			// InternalWeightDefinition.g:6312:65: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
			// InternalWeightDefinition.g:6313:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
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
	// InternalWeightDefinition.g:6319:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) ;
	public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
		EObject current = null;


		Token otherlv_1=null;
		EObject lv_constraints_2_0 =null;
		EObject lv_constraints_3_0 =null;
		EObject lv_constraints_4_0 =null;
		EObject lv_constraints_5_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6325:2: ( ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? ) )
			// InternalWeightDefinition.g:6326:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			{
			// InternalWeightDefinition.g:6326:2: ( () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )? )
			// InternalWeightDefinition.g:6327:3: () otherlv_1= '?' ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			{
			// InternalWeightDefinition.g:6327:3: ()
			// InternalWeightDefinition.g:6328:4: 
			{
			if ( state.backtracking==0 ) {
							current = forceCreateModelElement(
								grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
								current);
						}
			}

			otherlv_1=(Token)match(input,50,FOLLOW_79); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
					}
			// InternalWeightDefinition.g:6338:3: ( ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* ) | ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* ) )?
			int alt108=3;
			int LA108_0 = input.LA(1);
			if ( (LA108_0==61) ) {
				alt108=1;
			}
			else if ( (LA108_0==75) ) {
				alt108=2;
			}
			switch (alt108) {
				case 1 :
					// InternalWeightDefinition.g:6339:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					{
					// InternalWeightDefinition.g:6339:4: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )* )
					// InternalWeightDefinition.g:6340:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) ) ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					{
					// InternalWeightDefinition.g:6340:5: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
					// InternalWeightDefinition.g:6341:6: (lv_constraints_2_0= ruleJvmUpperBound )
					{
					// InternalWeightDefinition.g:6341:6: (lv_constraints_2_0= ruleJvmUpperBound )
					// InternalWeightDefinition.g:6342:7: lv_constraints_2_0= ruleJvmUpperBound
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0_0());
											}
					pushFollow(FOLLOW_80);
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

					// InternalWeightDefinition.g:6359:5: ( (lv_constraints_3_0= ruleJvmUpperBoundAnded ) )*
					loop106:
					while (true) {
						int alt106=2;
						int LA106_0 = input.LA(1);
						if ( (LA106_0==20) ) {
							alt106=1;
						}

						switch (alt106) {
						case 1 :
							// InternalWeightDefinition.g:6360:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							{
							// InternalWeightDefinition.g:6360:6: (lv_constraints_3_0= ruleJvmUpperBoundAnded )
							// InternalWeightDefinition.g:6361:7: lv_constraints_3_0= ruleJvmUpperBoundAnded
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundAndedParserRuleCall_2_0_1_0());
													}
							pushFollow(FOLLOW_80);
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
							break loop106;
						}
					}

					}

					}
					break;
				case 2 :
					// InternalWeightDefinition.g:6380:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					{
					// InternalWeightDefinition.g:6380:4: ( ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )* )
					// InternalWeightDefinition.g:6381:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) ) ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					{
					// InternalWeightDefinition.g:6381:5: ( (lv_constraints_4_0= ruleJvmLowerBound ) )
					// InternalWeightDefinition.g:6382:6: (lv_constraints_4_0= ruleJvmLowerBound )
					{
					// InternalWeightDefinition.g:6382:6: (lv_constraints_4_0= ruleJvmLowerBound )
					// InternalWeightDefinition.g:6383:7: lv_constraints_4_0= ruleJvmLowerBound
					{
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0_0());
											}
					pushFollow(FOLLOW_80);
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

					// InternalWeightDefinition.g:6400:5: ( (lv_constraints_5_0= ruleJvmLowerBoundAnded ) )*
					loop107:
					while (true) {
						int alt107=2;
						int LA107_0 = input.LA(1);
						if ( (LA107_0==20) ) {
							alt107=1;
						}

						switch (alt107) {
						case 1 :
							// InternalWeightDefinition.g:6401:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							{
							// InternalWeightDefinition.g:6401:6: (lv_constraints_5_0= ruleJvmLowerBoundAnded )
							// InternalWeightDefinition.g:6402:7: lv_constraints_5_0= ruleJvmLowerBoundAnded
							{
							if ( state.backtracking==0 ) {
														newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundAndedParserRuleCall_2_1_1_0());
													}
							pushFollow(FOLLOW_80);
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
							break loop107;
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
	// InternalWeightDefinition.g:6425:1: entryRuleJvmUpperBound returns [EObject current=null] :iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
	public final EObject entryRuleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBound =null;

		try {
			// InternalWeightDefinition.g:6425:54: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
			// InternalWeightDefinition.g:6426:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
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
	// InternalWeightDefinition.g:6432:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6438:2: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6439:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6439:2: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6440:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,61,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
					}
			// InternalWeightDefinition.g:6444:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6445:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6445:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6446:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalWeightDefinition.g:6467:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] :iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
	public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmUpperBoundAnded =null;

		try {
			// InternalWeightDefinition.g:6467:59: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
			// InternalWeightDefinition.g:6468:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
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
	// InternalWeightDefinition.g:6474:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6480:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6481:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6481:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6482:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalWeightDefinition.g:6486:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6487:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6487:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6488:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalWeightDefinition.g:6509:1: entryRuleJvmLowerBound returns [EObject current=null] :iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
	public final EObject entryRuleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBound =null;

		try {
			// InternalWeightDefinition.g:6509:54: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
			// InternalWeightDefinition.g:6510:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
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
	// InternalWeightDefinition.g:6516:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBound() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6522:2: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6523:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6523:2: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6524:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,75,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
					}
			// InternalWeightDefinition.g:6528:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6529:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6529:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6530:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalWeightDefinition.g:6551:1: entryRuleJvmLowerBoundAnded returns [EObject current=null] :iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF ;
	public final EObject entryRuleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleJvmLowerBoundAnded =null;

		try {
			// InternalWeightDefinition.g:6551:59: (iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF )
			// InternalWeightDefinition.g:6552:2: iv_ruleJvmLowerBoundAnded= ruleJvmLowerBoundAnded EOF
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
	// InternalWeightDefinition.g:6558:1: ruleJvmLowerBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
	public final EObject ruleJvmLowerBoundAnded() throws RecognitionException {
		EObject current = null;


		Token otherlv_0=null;
		EObject lv_typeReference_1_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6564:2: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
			// InternalWeightDefinition.g:6565:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			{
			// InternalWeightDefinition.g:6565:2: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
			// InternalWeightDefinition.g:6566:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			{
			otherlv_0=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAndedAccess().getAmpersandKeyword_0());
					}
			// InternalWeightDefinition.g:6570:3: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
			// InternalWeightDefinition.g:6571:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			{
			// InternalWeightDefinition.g:6571:4: (lv_typeReference_1_0= ruleJvmTypeReference )
			// InternalWeightDefinition.g:6572:5: lv_typeReference_1_0= ruleJvmTypeReference
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
	// InternalWeightDefinition.g:6593:1: entryRuleQualifiedNameWithWildcard returns [String current=null] :iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
	public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard =null;

		try {
			// InternalWeightDefinition.g:6593:65: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
			// InternalWeightDefinition.g:6594:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
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
	// InternalWeightDefinition.g:6600:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_QualifiedName_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6606:2: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' ) )
			// InternalWeightDefinition.g:6607:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			{
			// InternalWeightDefinition.g:6607:2: (this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*' )
			// InternalWeightDefinition.g:6608:3: this_QualifiedName_0= ruleQualifiedName kw= '.' kw= '*'
			{
			if ( state.backtracking==0 ) {
						newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0());
					}
			pushFollow(FOLLOW_81);
			this_QualifiedName_0=ruleQualifiedName();
			state._fsp--;
			if (state.failed) return current;
			if ( state.backtracking==0 ) {
						current.merge(this_QualifiedName_0);
					}
			if ( state.backtracking==0 ) {
						afterParserOrEnumRuleCall();
					}
			kw=(Token)match(input,34,FOLLOW_82); if (state.failed) return current;
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
	// InternalWeightDefinition.g:6632:1: entryRuleValidID returns [String current=null] :iv_ruleValidID= ruleValidID EOF ;
	public final String entryRuleValidID() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleValidID =null;

		try {
			// InternalWeightDefinition.g:6632:47: (iv_ruleValidID= ruleValidID EOF )
			// InternalWeightDefinition.g:6633:2: iv_ruleValidID= ruleValidID EOF
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
	// InternalWeightDefinition.g:6639:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
	public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token this_ID_0=null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6645:2: (this_ID_0= RULE_ID )
			// InternalWeightDefinition.g:6646:2: this_ID_0= RULE_ID
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
	// InternalWeightDefinition.g:6656:1: entryRuleXImportDeclaration returns [EObject current=null] :iv_ruleXImportDeclaration= ruleXImportDeclaration EOF ;
	public final EObject entryRuleXImportDeclaration() throws RecognitionException {
		EObject current = null;


		EObject iv_ruleXImportDeclaration =null;

		try {
			// InternalWeightDefinition.g:6656:59: (iv_ruleXImportDeclaration= ruleXImportDeclaration EOF )
			// InternalWeightDefinition.g:6657:2: iv_ruleXImportDeclaration= ruleXImportDeclaration EOF
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
	// InternalWeightDefinition.g:6663:1: ruleXImportDeclaration returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) ;
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
			// InternalWeightDefinition.g:6669:2: ( (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? ) )
			// InternalWeightDefinition.g:6670:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
			{
			// InternalWeightDefinition.g:6670:2: (otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )? )
			// InternalWeightDefinition.g:6671:3: otherlv_0= 'import' ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) ) (otherlv_8= ';' )?
			{
			otherlv_0=(Token)match(input,68,FOLLOW_83); if (state.failed) return current;
			if ( state.backtracking==0 ) {
						newLeafNode(otherlv_0, grammarAccess.getXImportDeclarationAccess().getImportKeyword_0());
					}
			// InternalWeightDefinition.g:6675:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )
			int alt111=3;
			alt111 = dfa111.predict(input);
			switch (alt111) {
				case 1 :
					// InternalWeightDefinition.g:6676:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
					{
					// InternalWeightDefinition.g:6676:4: ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) )
					// InternalWeightDefinition.g:6677:5: ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
					{
					// InternalWeightDefinition.g:6677:5: ( (lv_static_1_0= 'static' ) )
					// InternalWeightDefinition.g:6678:6: (lv_static_1_0= 'static' )
					{
					// InternalWeightDefinition.g:6678:6: (lv_static_1_0= 'static' )
					// InternalWeightDefinition.g:6679:7: lv_static_1_0= 'static'
					{
					lv_static_1_0=(Token)match(input,74,FOLLOW_84); if (state.failed) return current;
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

					// InternalWeightDefinition.g:6691:5: ( (lv_extension_2_0= 'extension' ) )?
					int alt109=2;
					int LA109_0 = input.LA(1);
					if ( (LA109_0==62) ) {
						alt109=1;
					}
					switch (alt109) {
						case 1 :
							// InternalWeightDefinition.g:6692:6: (lv_extension_2_0= 'extension' )
							{
							// InternalWeightDefinition.g:6692:6: (lv_extension_2_0= 'extension' )
							// InternalWeightDefinition.g:6693:7: lv_extension_2_0= 'extension'
							{
							lv_extension_2_0=(Token)match(input,62,FOLLOW_5); if (state.failed) return current;
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

					// InternalWeightDefinition.g:6705:5: ( ( ruleQualifiedNameInStaticImport ) )
					// InternalWeightDefinition.g:6706:6: ( ruleQualifiedNameInStaticImport )
					{
					// InternalWeightDefinition.g:6706:6: ( ruleQualifiedNameInStaticImport )
					// InternalWeightDefinition.g:6707:7: ruleQualifiedNameInStaticImport
					{
					if ( state.backtracking==0 ) {
												if (current==null) {
													current = createModelElement(grammarAccess.getXImportDeclarationRule());
												}
											}
					if ( state.backtracking==0 ) {
												newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_0_2_0());
											}
					pushFollow(FOLLOW_85);
					ruleQualifiedNameInStaticImport();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
												afterParserOrEnumRuleCall();
											}
					}

					}

					// InternalWeightDefinition.g:6721:5: ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) )
					int alt110=2;
					int LA110_0 = input.LA(1);
					if ( (LA110_0==23) ) {
						alt110=1;
					}
					else if ( (LA110_0==RULE_ID) ) {
						alt110=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return current;}
						NoViableAltException nvae =
							new NoViableAltException("", 110, 0, input);
						throw nvae;
					}

					switch (alt110) {
						case 1 :
							// InternalWeightDefinition.g:6722:6: ( (lv_wildcard_4_0= '*' ) )
							{
							// InternalWeightDefinition.g:6722:6: ( (lv_wildcard_4_0= '*' ) )
							// InternalWeightDefinition.g:6723:7: (lv_wildcard_4_0= '*' )
							{
							// InternalWeightDefinition.g:6723:7: (lv_wildcard_4_0= '*' )
							// InternalWeightDefinition.g:6724:8: lv_wildcard_4_0= '*'
							{
							lv_wildcard_4_0=(Token)match(input,23,FOLLOW_86); if (state.failed) return current;
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
							// InternalWeightDefinition.g:6737:6: ( (lv_memberName_5_0= ruleValidID ) )
							{
							// InternalWeightDefinition.g:6737:6: ( (lv_memberName_5_0= ruleValidID ) )
							// InternalWeightDefinition.g:6738:7: (lv_memberName_5_0= ruleValidID )
							{
							// InternalWeightDefinition.g:6738:7: (lv_memberName_5_0= ruleValidID )
							// InternalWeightDefinition.g:6739:8: lv_memberName_5_0= ruleValidID
							{
							if ( state.backtracking==0 ) {
															newCompositeNode(grammarAccess.getXImportDeclarationAccess().getMemberNameValidIDParserRuleCall_1_0_3_1_0());
														}
							pushFollow(FOLLOW_86);
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
					// InternalWeightDefinition.g:6759:4: ( ( ruleQualifiedName ) )
					{
					// InternalWeightDefinition.g:6759:4: ( ( ruleQualifiedName ) )
					// InternalWeightDefinition.g:6760:5: ( ruleQualifiedName )
					{
					// InternalWeightDefinition.g:6760:5: ( ruleQualifiedName )
					// InternalWeightDefinition.g:6761:6: ruleQualifiedName
					{
					if ( state.backtracking==0 ) {
											if (current==null) {
												current = createModelElement(grammarAccess.getXImportDeclarationRule());
											}
										}
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedTypeJvmDeclaredTypeCrossReference_1_1_0());
										}
					pushFollow(FOLLOW_86);
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
					// InternalWeightDefinition.g:6776:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
					{
					// InternalWeightDefinition.g:6776:4: ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) )
					// InternalWeightDefinition.g:6777:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
					{
					// InternalWeightDefinition.g:6777:5: (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard )
					// InternalWeightDefinition.g:6778:6: lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard
					{
					if ( state.backtracking==0 ) {
											newCompositeNode(grammarAccess.getXImportDeclarationAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_2_0());
										}
					pushFollow(FOLLOW_86);
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

			// InternalWeightDefinition.g:6796:3: (otherlv_8= ';' )?
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( (LA112_0==41) ) {
				alt112=1;
			}
			switch (alt112) {
				case 1 :
					// InternalWeightDefinition.g:6797:4: otherlv_8= ';'
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
	// InternalWeightDefinition.g:6806:1: entryRuleQualifiedNameInStaticImport returns [String current=null] :iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF ;
	public final String entryRuleQualifiedNameInStaticImport() throws RecognitionException {
		String current = null;


		AntlrDatatypeRuleToken iv_ruleQualifiedNameInStaticImport =null;

		try {
			// InternalWeightDefinition.g:6806:67: (iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF )
			// InternalWeightDefinition.g:6807:2: iv_ruleQualifiedNameInStaticImport= ruleQualifiedNameInStaticImport EOF
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
	// InternalWeightDefinition.g:6813:1: ruleQualifiedNameInStaticImport returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID kw= '.' )+ ;
	public final AntlrDatatypeRuleToken ruleQualifiedNameInStaticImport() throws RecognitionException {
		AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();


		Token kw=null;
		AntlrDatatypeRuleToken this_ValidID_0 =null;


			enterRule();

		try {
			// InternalWeightDefinition.g:6819:2: ( (this_ValidID_0= ruleValidID kw= '.' )+ )
			// InternalWeightDefinition.g:6820:2: (this_ValidID_0= ruleValidID kw= '.' )+
			{
			// InternalWeightDefinition.g:6820:2: (this_ValidID_0= ruleValidID kw= '.' )+
			int cnt113=0;
			loop113:
			while (true) {
				int alt113=2;
				int LA113_0 = input.LA(1);
				if ( (LA113_0==RULE_ID) ) {
					int LA113_2 = input.LA(2);
					if ( (LA113_2==34) ) {
						alt113=1;
					}

				}

				switch (alt113) {
				case 1 :
					// InternalWeightDefinition.g:6821:3: this_ValidID_0= ruleValidID kw= '.'
					{
					if ( state.backtracking==0 ) {
								newCompositeNode(grammarAccess.getQualifiedNameInStaticImportAccess().getValidIDParserRuleCall_0());
							}
					pushFollow(FOLLOW_81);
					this_ValidID_0=ruleValidID();
					state._fsp--;
					if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(this_ValidID_0);
							}
					if ( state.backtracking==0 ) {
								afterParserOrEnumRuleCall();
							}
					kw=(Token)match(input,34,FOLLOW_87); if (state.failed) return current;
					if ( state.backtracking==0 ) {
								current.merge(kw);
								newLeafNode(kw, grammarAccess.getQualifiedNameInStaticImportAccess().getFullStopKeyword_1());
							}
					}
					break;

				default :
					if ( cnt113 >= 1 ) break loop113;
					if (state.backtracking>0) {state.failed=true; return current;}
					EarlyExitException eee = new EarlyExitException(113, input);
					throw eee;
				}
				cnt113++;
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
		// InternalWeightDefinition.g:661:6: ( ( () ( ( ruleOpMultiAssign ) ) ) )
		// InternalWeightDefinition.g:661:7: ( () ( ( ruleOpMultiAssign ) ) )
		{
		// InternalWeightDefinition.g:661:7: ( () ( ( ruleOpMultiAssign ) ) )
		// InternalWeightDefinition.g:662:7: () ( ( ruleOpMultiAssign ) )
		{
		// InternalWeightDefinition.g:662:7: ()
		// InternalWeightDefinition.g:663:7: 
		{
		}

		// InternalWeightDefinition.g:664:7: ( ( ruleOpMultiAssign ) )
		// InternalWeightDefinition.g:665:8: ( ruleOpMultiAssign )
		{
		// InternalWeightDefinition.g:665:8: ( ruleOpMultiAssign )
		// InternalWeightDefinition.g:666:9: ruleOpMultiAssign
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
		// InternalWeightDefinition.g:855:5: ( ( () ( ( ruleOpOr ) ) ) )
		// InternalWeightDefinition.g:855:6: ( () ( ( ruleOpOr ) ) )
		{
		// InternalWeightDefinition.g:855:6: ( () ( ( ruleOpOr ) ) )
		// InternalWeightDefinition.g:856:6: () ( ( ruleOpOr ) )
		{
		// InternalWeightDefinition.g:856:6: ()
		// InternalWeightDefinition.g:857:6: 
		{
		}

		// InternalWeightDefinition.g:858:6: ( ( ruleOpOr ) )
		// InternalWeightDefinition.g:859:7: ( ruleOpOr )
		{
		// InternalWeightDefinition.g:859:7: ( ruleOpOr )
		// InternalWeightDefinition.g:860:8: ruleOpOr
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
		// InternalWeightDefinition.g:962:5: ( ( () ( ( ruleOpAnd ) ) ) )
		// InternalWeightDefinition.g:962:6: ( () ( ( ruleOpAnd ) ) )
		{
		// InternalWeightDefinition.g:962:6: ( () ( ( ruleOpAnd ) ) )
		// InternalWeightDefinition.g:963:6: () ( ( ruleOpAnd ) )
		{
		// InternalWeightDefinition.g:963:6: ()
		// InternalWeightDefinition.g:964:6: 
		{
		}

		// InternalWeightDefinition.g:965:6: ( ( ruleOpAnd ) )
		// InternalWeightDefinition.g:966:7: ( ruleOpAnd )
		{
		// InternalWeightDefinition.g:966:7: ( ruleOpAnd )
		// InternalWeightDefinition.g:967:8: ruleOpAnd
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
		// InternalWeightDefinition.g:1069:5: ( ( () ( ( ruleOpEquality ) ) ) )
		// InternalWeightDefinition.g:1069:6: ( () ( ( ruleOpEquality ) ) )
		{
		// InternalWeightDefinition.g:1069:6: ( () ( ( ruleOpEquality ) ) )
		// InternalWeightDefinition.g:1070:6: () ( ( ruleOpEquality ) )
		{
		// InternalWeightDefinition.g:1070:6: ()
		// InternalWeightDefinition.g:1071:6: 
		{
		}

		// InternalWeightDefinition.g:1072:6: ( ( ruleOpEquality ) )
		// InternalWeightDefinition.g:1073:7: ( ruleOpEquality )
		{
		// InternalWeightDefinition.g:1073:7: ( ruleOpEquality )
		// InternalWeightDefinition.g:1074:8: ruleOpEquality
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
		// InternalWeightDefinition.g:1197:6: ( ( () 'instanceof' ) )
		// InternalWeightDefinition.g:1197:7: ( () 'instanceof' )
		{
		// InternalWeightDefinition.g:1197:7: ( () 'instanceof' )
		// InternalWeightDefinition.g:1198:7: () 'instanceof'
		{
		// InternalWeightDefinition.g:1198:7: ()
		// InternalWeightDefinition.g:1199:7: 
		{
		}

		match(input,69,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred5_InternalWeightDefinition

	// $ANTLR start synpred6_InternalWeightDefinition
	public final void synpred6_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1240:6: ( ( () ( ( ruleOpCompare ) ) ) )
		// InternalWeightDefinition.g:1240:7: ( () ( ( ruleOpCompare ) ) )
		{
		// InternalWeightDefinition.g:1240:7: ( () ( ( ruleOpCompare ) ) )
		// InternalWeightDefinition.g:1241:7: () ( ( ruleOpCompare ) )
		{
		// InternalWeightDefinition.g:1241:7: ()
		// InternalWeightDefinition.g:1242:7: 
		{
		}

		// InternalWeightDefinition.g:1243:7: ( ( ruleOpCompare ) )
		// InternalWeightDefinition.g:1244:8: ( ruleOpCompare )
		{
		// InternalWeightDefinition.g:1244:8: ( ruleOpCompare )
		// InternalWeightDefinition.g:1245:9: ruleOpCompare
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
		// InternalWeightDefinition.g:1375:5: ( ( () ( ( ruleOpOther ) ) ) )
		// InternalWeightDefinition.g:1375:6: ( () ( ( ruleOpOther ) ) )
		{
		// InternalWeightDefinition.g:1375:6: ( () ( ( ruleOpOther ) ) )
		// InternalWeightDefinition.g:1376:6: () ( ( ruleOpOther ) )
		{
		// InternalWeightDefinition.g:1376:6: ()
		// InternalWeightDefinition.g:1377:6: 
		{
		}

		// InternalWeightDefinition.g:1378:6: ( ( ruleOpOther ) )
		// InternalWeightDefinition.g:1379:7: ( ruleOpOther )
		{
		// InternalWeightDefinition.g:1379:7: ( ruleOpOther )
		// InternalWeightDefinition.g:1380:8: ruleOpOther
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
		// InternalWeightDefinition.g:1495:6: ( ( '>' '>' ) )
		// InternalWeightDefinition.g:1495:7: ( '>' '>' )
		{
		// InternalWeightDefinition.g:1495:7: ( '>' '>' )
		// InternalWeightDefinition.g:1496:7: '>' '>'
		{
		match(input,48,FOLLOW_23); if (state.failed) return;
		match(input,48,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred8_InternalWeightDefinition

	// $ANTLR start synpred9_InternalWeightDefinition
	public final void synpred9_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1530:6: ( ( '<' '<' ) )
		// InternalWeightDefinition.g:1530:7: ( '<' '<' )
		{
		// InternalWeightDefinition.g:1530:7: ( '<' '<' )
		// InternalWeightDefinition.g:1531:7: '<' '<'
		{
		match(input,42,FOLLOW_14); if (state.failed) return;
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred9_InternalWeightDefinition

	// $ANTLR start synpred10_InternalWeightDefinition
	public final void synpred10_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:1603:5: ( ( () ( ( ruleOpAdd ) ) ) )
		// InternalWeightDefinition.g:1603:6: ( () ( ( ruleOpAdd ) ) )
		{
		// InternalWeightDefinition.g:1603:6: ( () ( ( ruleOpAdd ) ) )
		// InternalWeightDefinition.g:1604:6: () ( ( ruleOpAdd ) )
		{
		// InternalWeightDefinition.g:1604:6: ()
		// InternalWeightDefinition.g:1605:6: 
		{
		}

		// InternalWeightDefinition.g:1606:6: ( ( ruleOpAdd ) )
		// InternalWeightDefinition.g:1607:7: ( ruleOpAdd )
		{
		// InternalWeightDefinition.g:1607:7: ( ruleOpAdd )
		// InternalWeightDefinition.g:1608:8: ruleOpAdd
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
		// InternalWeightDefinition.g:1718:5: ( ( () ( ( ruleOpMulti ) ) ) )
		// InternalWeightDefinition.g:1718:6: ( () ( ( ruleOpMulti ) ) )
		{
		// InternalWeightDefinition.g:1718:6: ( () ( ( ruleOpMulti ) ) )
		// InternalWeightDefinition.g:1719:6: () ( ( ruleOpMulti ) )
		{
		// InternalWeightDefinition.g:1719:6: ()
		// InternalWeightDefinition.g:1720:6: 
		{
		}

		// InternalWeightDefinition.g:1721:6: ( ( ruleOpMulti ) )
		// InternalWeightDefinition.g:1722:7: ( ruleOpMulti )
		{
		// InternalWeightDefinition.g:1722:7: ( ruleOpMulti )
		// InternalWeightDefinition.g:1723:8: ruleOpMulti
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
		// InternalWeightDefinition.g:1953:5: ( ( () 'as' ) )
		// InternalWeightDefinition.g:1953:6: ( () 'as' )
		{
		// InternalWeightDefinition.g:1953:6: ( () 'as' )
		// InternalWeightDefinition.g:1954:6: () 'as'
		{
		// InternalWeightDefinition.g:1954:6: ()
		// InternalWeightDefinition.g:1955:6: 
		{
		}

		match(input,55,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred12_InternalWeightDefinition

	// $ANTLR start synpred13_InternalWeightDefinition
	public final void synpred13_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2021:4: ( ( () ( ( ruleOpPostfix ) ) ) )
		// InternalWeightDefinition.g:2021:5: ( () ( ( ruleOpPostfix ) ) )
		{
		// InternalWeightDefinition.g:2021:5: ( () ( ( ruleOpPostfix ) ) )
		// InternalWeightDefinition.g:2022:5: () ( ( ruleOpPostfix ) )
		{
		// InternalWeightDefinition.g:2022:5: ()
		// InternalWeightDefinition.g:2023:5: 
		{
		}

		// InternalWeightDefinition.g:2024:5: ( ( ruleOpPostfix ) )
		// InternalWeightDefinition.g:2025:6: ( ruleOpPostfix )
		{
		// InternalWeightDefinition.g:2025:6: ( ruleOpPostfix )
		// InternalWeightDefinition.g:2026:7: ruleOpPostfix
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
		// InternalWeightDefinition.g:2117:6: ( ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign ) )
		// InternalWeightDefinition.g:2117:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		{
		// InternalWeightDefinition.g:2117:7: ( () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign )
		// InternalWeightDefinition.g:2118:7: () ( '.' | ( ( '::' ) ) ) ( ( ruleFeatureCallID ) ) ruleOpSingleAssign
		{
		// InternalWeightDefinition.g:2118:7: ()
		// InternalWeightDefinition.g:2119:7: 
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
		// InternalWeightDefinition.g:2129:7: ( ( ruleFeatureCallID ) )
		// InternalWeightDefinition.g:2130:8: ( ruleFeatureCallID )
		{
		// InternalWeightDefinition.g:2130:8: ( ruleFeatureCallID )
		// InternalWeightDefinition.g:2131:9: ruleFeatureCallID
		{
		pushFollow(FOLLOW_11);
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
		// InternalWeightDefinition.g:2214:6: ( ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) ) )
		// InternalWeightDefinition.g:2214:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
		{
		// InternalWeightDefinition.g:2214:7: ( () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) ) )
		// InternalWeightDefinition.g:2215:7: () ( '.' | ( ( '?.' ) ) | ( ( '::' ) ) )
		{
		// InternalWeightDefinition.g:2215:7: ()
		// InternalWeightDefinition.g:2216:7: 
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
		// InternalWeightDefinition.g:2352:7: ( ( '(' ) )
		// InternalWeightDefinition.g:2352:8: ( '(' )
		{
		// InternalWeightDefinition.g:2352:8: ( '(' )
		// InternalWeightDefinition.g:2353:8: '('
		{
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred16_InternalWeightDefinition

	// $ANTLR start synpred17_InternalWeightDefinition
	public final void synpred17_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2371:8: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:2371:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:2371:9: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:2372:9: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:2372:9: ()
		// InternalWeightDefinition.g:2373:9: 
		{
		}

		// InternalWeightDefinition.g:2374:9: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt115=2;
		int LA115_0 = input.LA(1);
		if ( (LA115_0==RULE_ID||LA115_0==21||LA115_0==47) ) {
			alt115=1;
		}
		switch (alt115) {
			case 1 :
				// InternalWeightDefinition.g:2375:10: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:2375:10: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:2376:11: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:2376:11: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:2377:12: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_45);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:2380:10: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop114:
				while (true) {
					int alt114=2;
					int LA114_0 = input.LA(1);
					if ( (LA114_0==29) ) {
						alt114=1;
					}

					switch (alt114) {
					case 1 :
						// InternalWeightDefinition.g:2381:11: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_7); if (state.failed) return;
						// InternalWeightDefinition.g:2382:11: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:2383:12: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:2383:12: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:2384:13: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_45);
						ruleJvmFormalParameter();
						state._fsp--;
						if (state.failed) return;
						}

						}

						}
						break;

					default :
						break loop114;
					}
				}

				}
				break;

		}

		// InternalWeightDefinition.g:2389:9: ( ( '|' ) )
		// InternalWeightDefinition.g:2390:10: ( '|' )
		{
		// InternalWeightDefinition.g:2390:10: ( '|' )
		// InternalWeightDefinition.g:2391:11: '|'
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
		// InternalWeightDefinition.g:2468:6: ( ( () '[' ) )
		// InternalWeightDefinition.g:2468:7: ( () '[' )
		{
		// InternalWeightDefinition.g:2468:7: ( () '[' )
		// InternalWeightDefinition.g:2469:7: () '['
		{
		// InternalWeightDefinition.g:2469:7: ()
		// InternalWeightDefinition.g:2470:7: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred18_InternalWeightDefinition

	// $ANTLR start synpred19_InternalWeightDefinition
	public final void synpred19_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2541:4: ( ( () 'synchronized' '(' ) )
		// InternalWeightDefinition.g:2541:5: ( () 'synchronized' '(' )
		{
		// InternalWeightDefinition.g:2541:5: ( () 'synchronized' '(' )
		// InternalWeightDefinition.g:2542:5: () 'synchronized' '('
		{
		// InternalWeightDefinition.g:2542:5: ()
		// InternalWeightDefinition.g:2543:5: 
		{
		}

		match(input,77,FOLLOW_8); if (state.failed) return;
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred19_InternalWeightDefinition

	// $ANTLR start synpred20_InternalWeightDefinition
	public final void synpred20_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:2586:4: ( ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
		// InternalWeightDefinition.g:2586:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
		{
		// InternalWeightDefinition.g:2586:5: ( () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':' )
		// InternalWeightDefinition.g:2587:5: () 'for' '(' ( ( ruleJvmFormalParameter ) ) ':'
		{
		// InternalWeightDefinition.g:2587:5: ()
		// InternalWeightDefinition.g:2588:5: 
		{
		}

		match(input,65,FOLLOW_8); if (state.failed) return;
		match(input,21,FOLLOW_7); if (state.failed) return;
		// InternalWeightDefinition.g:2591:5: ( ( ruleJvmFormalParameter ) )
		// InternalWeightDefinition.g:2592:6: ( ruleJvmFormalParameter )
		{
		// InternalWeightDefinition.g:2592:6: ( ruleJvmFormalParameter )
		// InternalWeightDefinition.g:2593:7: ruleJvmFormalParameter
		{
		pushFollow(FOLLOW_52);
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
		// InternalWeightDefinition.g:2700:4: ( ( () '[' ) )
		// InternalWeightDefinition.g:2700:5: ( () '[' )
		{
		// InternalWeightDefinition.g:2700:5: ( () '[' )
		// InternalWeightDefinition.g:2701:5: () '['
		{
		// InternalWeightDefinition.g:2701:5: ()
		// InternalWeightDefinition.g:2702:5: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred21_InternalWeightDefinition

	// $ANTLR start synpred23_InternalWeightDefinition
	public final void synpred23_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:3005:4: ( ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:3005:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:3005:5: ( ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:3006:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:3006:5: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt117=2;
		int LA117_0 = input.LA(1);
		if ( (LA117_0==RULE_ID||LA117_0==21||LA117_0==47) ) {
			alt117=1;
		}
		switch (alt117) {
			case 1 :
				// InternalWeightDefinition.g:3007:6: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:3007:6: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:3008:7: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:3008:7: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:3009:8: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_45);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:3012:6: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop116:
				while (true) {
					int alt116=2;
					int LA116_0 = input.LA(1);
					if ( (LA116_0==29) ) {
						alt116=1;
					}

					switch (alt116) {
					case 1 :
						// InternalWeightDefinition.g:3013:7: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_7); if (state.failed) return;
						// InternalWeightDefinition.g:3014:7: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:3015:8: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:3015:8: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:3016:9: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_45);
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

		// InternalWeightDefinition.g:3021:5: ( ( '|' ) )
		// InternalWeightDefinition.g:3022:6: ( '|' )
		{
		// InternalWeightDefinition.g:3022:6: ( '|' )
		// InternalWeightDefinition.g:3023:7: '|'
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
		// InternalWeightDefinition.g:3414:5: ( 'else' )
		// InternalWeightDefinition.g:3414:6: 'else'
		{
		match(input,60,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred25_InternalWeightDefinition

	// $ANTLR start synpred26_InternalWeightDefinition
	public final void synpred26_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:3473:6: ( ( '(' ( ( ruleJvmFormalParameter ) ) ':' ) )
		// InternalWeightDefinition.g:3473:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
		{
		// InternalWeightDefinition.g:3473:7: ( '(' ( ( ruleJvmFormalParameter ) ) ':' )
		// InternalWeightDefinition.g:3474:7: '(' ( ( ruleJvmFormalParameter ) ) ':'
		{
		match(input,21,FOLLOW_7); if (state.failed) return;
		// InternalWeightDefinition.g:3475:7: ( ( ruleJvmFormalParameter ) )
		// InternalWeightDefinition.g:3476:8: ( ruleJvmFormalParameter )
		{
		// InternalWeightDefinition.g:3476:8: ( ruleJvmFormalParameter )
		// InternalWeightDefinition.g:3477:9: ruleJvmFormalParameter
		{
		pushFollow(FOLLOW_52);
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
		// InternalWeightDefinition.g:3540:6: ( ( ( ( ruleJvmFormalParameter ) ) ':' ) )
		// InternalWeightDefinition.g:3540:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
		{
		// InternalWeightDefinition.g:3540:7: ( ( ( ruleJvmFormalParameter ) ) ':' )
		// InternalWeightDefinition.g:3541:7: ( ( ruleJvmFormalParameter ) ) ':'
		{
		// InternalWeightDefinition.g:3541:7: ( ( ruleJvmFormalParameter ) )
		// InternalWeightDefinition.g:3542:8: ( ruleJvmFormalParameter )
		{
		// InternalWeightDefinition.g:3542:8: ( ruleJvmFormalParameter )
		// InternalWeightDefinition.g:3543:9: ruleJvmFormalParameter
		{
		pushFollow(FOLLOW_52);
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
		// InternalWeightDefinition.g:4358:5: ( ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) ) )
		// InternalWeightDefinition.g:4358:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		{
		// InternalWeightDefinition.g:4358:6: ( ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) ) )
		// InternalWeightDefinition.g:4359:6: ( ( ruleJvmTypeReference ) ) ( ( ruleValidID ) )
		{
		// InternalWeightDefinition.g:4359:6: ( ( ruleJvmTypeReference ) )
		// InternalWeightDefinition.g:4360:7: ( ruleJvmTypeReference )
		{
		// InternalWeightDefinition.g:4360:7: ( ruleJvmTypeReference )
		// InternalWeightDefinition.g:4361:8: ruleJvmTypeReference
		{
		pushFollow(FOLLOW_5);
		ruleJvmTypeReference();
		state._fsp--;
		if (state.failed) return;
		}

		}

		// InternalWeightDefinition.g:4364:6: ( ( ruleValidID ) )
		// InternalWeightDefinition.g:4365:7: ( ruleValidID )
		{
		// InternalWeightDefinition.g:4365:7: ( ruleValidID )
		// InternalWeightDefinition.g:4366:8: ruleValidID
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
		// InternalWeightDefinition.g:4670:5: ( ( '(' ) )
		// InternalWeightDefinition.g:4670:6: ( '(' )
		{
		// InternalWeightDefinition.g:4670:6: ( '(' )
		// InternalWeightDefinition.g:4671:6: '('
		{
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred30_InternalWeightDefinition

	// $ANTLR start synpred31_InternalWeightDefinition
	public final void synpred31_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4689:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:4689:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:4689:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:4690:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:4690:7: ()
		// InternalWeightDefinition.g:4691:7: 
		{
		}

		// InternalWeightDefinition.g:4692:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt121=2;
		int LA121_0 = input.LA(1);
		if ( (LA121_0==RULE_ID||LA121_0==21||LA121_0==47) ) {
			alt121=1;
		}
		switch (alt121) {
			case 1 :
				// InternalWeightDefinition.g:4693:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:4693:8: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:4694:9: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:4694:9: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:4695:10: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_45);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:4698:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop120:
				while (true) {
					int alt120=2;
					int LA120_0 = input.LA(1);
					if ( (LA120_0==29) ) {
						alt120=1;
					}

					switch (alt120) {
					case 1 :
						// InternalWeightDefinition.g:4699:9: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_7); if (state.failed) return;
						// InternalWeightDefinition.g:4700:9: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:4701:10: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:4701:10: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:4702:11: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_45);
						ruleJvmFormalParameter();
						state._fsp--;
						if (state.failed) return;
						}

						}

						}
						break;

					default :
						break loop120;
					}
				}

				}
				break;

		}

		// InternalWeightDefinition.g:4707:7: ( ( '|' ) )
		// InternalWeightDefinition.g:4708:8: ( '|' )
		{
		// InternalWeightDefinition.g:4708:8: ( '|' )
		// InternalWeightDefinition.g:4709:9: '|'
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
		// InternalWeightDefinition.g:4786:4: ( ( () '[' ) )
		// InternalWeightDefinition.g:4786:5: ( () '[' )
		{
		// InternalWeightDefinition.g:4786:5: ( () '[' )
		// InternalWeightDefinition.g:4787:5: () '['
		{
		// InternalWeightDefinition.g:4787:5: ()
		// InternalWeightDefinition.g:4788:5: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred32_InternalWeightDefinition

	// $ANTLR start synpred33_InternalWeightDefinition
	public final void synpred33_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:4946:5: ( '<' )
		// InternalWeightDefinition.g:4946:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred33_InternalWeightDefinition

	// $ANTLR start synpred34_InternalWeightDefinition
	public final void synpred34_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5003:5: ( ( '(' ) )
		// InternalWeightDefinition.g:5003:6: ( '(' )
		{
		// InternalWeightDefinition.g:5003:6: ( '(' )
		// InternalWeightDefinition.g:5004:6: '('
		{
		match(input,21,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred34_InternalWeightDefinition

	// $ANTLR start synpred35_InternalWeightDefinition
	public final void synpred35_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5022:6: ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )
		// InternalWeightDefinition.g:5022:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		{
		// InternalWeightDefinition.g:5022:7: ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) )
		// InternalWeightDefinition.g:5023:7: () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) )
		{
		// InternalWeightDefinition.g:5023:7: ()
		// InternalWeightDefinition.g:5024:7: 
		{
		}

		// InternalWeightDefinition.g:5025:7: ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )?
		int alt123=2;
		int LA123_0 = input.LA(1);
		if ( (LA123_0==RULE_ID||LA123_0==21||LA123_0==47) ) {
			alt123=1;
		}
		switch (alt123) {
			case 1 :
				// InternalWeightDefinition.g:5026:8: ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )*
				{
				// InternalWeightDefinition.g:5026:8: ( ( ruleJvmFormalParameter ) )
				// InternalWeightDefinition.g:5027:9: ( ruleJvmFormalParameter )
				{
				// InternalWeightDefinition.g:5027:9: ( ruleJvmFormalParameter )
				// InternalWeightDefinition.g:5028:10: ruleJvmFormalParameter
				{
				pushFollow(FOLLOW_45);
				ruleJvmFormalParameter();
				state._fsp--;
				if (state.failed) return;
				}

				}

				// InternalWeightDefinition.g:5031:8: ( ',' ( ( ruleJvmFormalParameter ) ) )*
				loop122:
				while (true) {
					int alt122=2;
					int LA122_0 = input.LA(1);
					if ( (LA122_0==29) ) {
						alt122=1;
					}

					switch (alt122) {
					case 1 :
						// InternalWeightDefinition.g:5032:9: ',' ( ( ruleJvmFormalParameter ) )
						{
						match(input,29,FOLLOW_7); if (state.failed) return;
						// InternalWeightDefinition.g:5033:9: ( ( ruleJvmFormalParameter ) )
						// InternalWeightDefinition.g:5034:10: ( ruleJvmFormalParameter )
						{
						// InternalWeightDefinition.g:5034:10: ( ruleJvmFormalParameter )
						// InternalWeightDefinition.g:5035:11: ruleJvmFormalParameter
						{
						pushFollow(FOLLOW_45);
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

		// InternalWeightDefinition.g:5040:7: ( ( '|' ) )
		// InternalWeightDefinition.g:5041:8: ( '|' )
		{
		// InternalWeightDefinition.g:5041:8: ( '|' )
		// InternalWeightDefinition.g:5042:9: '|'
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
		// InternalWeightDefinition.g:5119:4: ( ( () '[' ) )
		// InternalWeightDefinition.g:5119:5: ( () '[' )
		{
		// InternalWeightDefinition.g:5119:5: ( () '[' )
		// InternalWeightDefinition.g:5120:5: () '['
		{
		// InternalWeightDefinition.g:5120:5: ()
		// InternalWeightDefinition.g:5121:5: 
		{
		}

		match(input,53,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred36_InternalWeightDefinition

	// $ANTLR start synpred37_InternalWeightDefinition
	public final void synpred37_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5462:4: ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )
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
		// InternalWeightDefinition.g:5533:6: ( 'catch' )
		// InternalWeightDefinition.g:5533:7: 'catch'
		{
		match(input,57,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred38_InternalWeightDefinition

	// $ANTLR start synpred39_InternalWeightDefinition
	public final void synpred39_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5554:7: ( 'finally' )
		// InternalWeightDefinition.g:5554:8: 'finally'
		{
		match(input,64,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred39_InternalWeightDefinition

	// $ANTLR start synpred42_InternalWeightDefinition
	public final void synpred42_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5798:5: ( '.' )
		// InternalWeightDefinition.g:5798:6: '.'
		{
		match(input,34,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred42_InternalWeightDefinition

	// $ANTLR start synpred43_InternalWeightDefinition
	public final void synpred43_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:5924:5: ( ( () ruleArrayBrackets ) )
		// InternalWeightDefinition.g:5924:6: ( () ruleArrayBrackets )
		{
		// InternalWeightDefinition.g:5924:6: ( () ruleArrayBrackets )
		// InternalWeightDefinition.g:5925:6: () ruleArrayBrackets
		{
		// InternalWeightDefinition.g:5925:6: ()
		// InternalWeightDefinition.g:5926:6: 
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
		// InternalWeightDefinition.g:6121:5: ( '<' )
		// InternalWeightDefinition.g:6121:6: '<'
		{
		match(input,42,FOLLOW_2); if (state.failed) return;
		}

	}
	// $ANTLR end synpred44_InternalWeightDefinition

	// $ANTLR start synpred45_InternalWeightDefinition
	public final void synpred45_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:6177:6: ( ( () '.' ) )
		// InternalWeightDefinition.g:6177:7: ( () '.' )
		{
		// InternalWeightDefinition.g:6177:7: ( () '.' )
		// InternalWeightDefinition.g:6178:7: () '.'
		{
		// InternalWeightDefinition.g:6178:7: ()
		// InternalWeightDefinition.g:6179:7: 
		{
		}

		match(input,34,FOLLOW_2); if (state.failed) return;
		}

		}

	}
	// $ANTLR end synpred45_InternalWeightDefinition

	// $ANTLR start synpred46_InternalWeightDefinition
	public final void synpred46_InternalWeightDefinition_fragment() throws RecognitionException {
		// InternalWeightDefinition.g:6215:7: ( '<' )
		// InternalWeightDefinition.g:6215:8: '<'
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


	protected DFA33 dfa33 = new DFA33(this);
	protected DFA34 dfa34 = new DFA34(this);
	protected DFA74 dfa74 = new DFA74(this);
	protected DFA75 dfa75 = new DFA75(this);
	protected DFA79 dfa79 = new DFA79(this);
	protected DFA82 dfa82 = new DFA82(this);
	protected DFA83 dfa83 = new DFA83(this);
	protected DFA86 dfa86 = new DFA86(this);
	protected DFA104 dfa104 = new DFA104(this);
	protected DFA102 dfa102 = new DFA102(this);
	protected DFA111 dfa111 = new DFA111(this);
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

	protected class DFA33 extends DFA {

		public DFA33(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 33;
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
			return "2350:5: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_17_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_memberCallArguments_18_0= ruleXShortClosure ) ) | ( ( (lv_memberCallArguments_19_0= ruleXExpression ) ) (otherlv_20= ',' ( (lv_memberCallArguments_21_0= ruleXExpression ) ) )* ) )? otherlv_22= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA33_1 = input.LA(1);
						 
						int index33_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred16_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index33_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 33, _s, input);
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

	protected class DFA34 extends DFA {

		public DFA34(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 34;
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
			return "2467:5: ( ( ( () '[' ) )=> (lv_memberCallArguments_23_0= ruleXClosure ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA34_1 = input.LA(1);
						 
						int index34_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred18_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index34_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 34, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA74 extends DFA {

		public DFA74(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 74;
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
			return "4668:3: ( ( ( ( '(' ) )=> (lv_explicitOperationCall_7_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_featureCallArguments_8_0= ruleXShortClosure ) ) | ( ( (lv_featureCallArguments_9_0= ruleXExpression ) ) (otherlv_10= ',' ( (lv_featureCallArguments_11_0= ruleXExpression ) ) )* ) )? otherlv_12= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA74_1 = input.LA(1);
						 
						int index74_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred30_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index74_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 74, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA75 extends DFA {

		public DFA75(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 75;
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
			return "4785:3: ( ( ( () '[' ) )=> (lv_featureCallArguments_13_0= ruleXClosure ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA75_1 = input.LA(1);
						 
						int index75_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred32_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index75_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 75, _s, input);
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

	protected class DFA79 extends DFA {

		public DFA79(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 79;
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
			return "4944:3: ( ( ( '<' )=>otherlv_3= '<' ) ( (lv_typeArguments_4_0= ruleJvmArgumentTypeReference ) ) (otherlv_5= ',' ( (lv_typeArguments_6_0= ruleJvmArgumentTypeReference ) ) )* otherlv_7= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA79_1 = input.LA(1);
						 
						int index79_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred33_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index79_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 79, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA82 extends DFA {

		public DFA82(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 82;
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
			return "5001:3: ( ( ( ( '(' ) )=> (lv_explicitConstructorCall_8_0= '(' ) ) ( ( ( ( () ( ( ( ruleJvmFormalParameter ) ) ( ',' ( ( ruleJvmFormalParameter ) ) )* )? ( ( '|' ) ) ) )=> (lv_arguments_9_0= ruleXShortClosure ) ) | ( ( (lv_arguments_10_0= ruleXExpression ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleXExpression ) ) )* ) )? otherlv_13= ')' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA82_1 = input.LA(1);
						 
						int index82_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred34_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index82_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 82, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	protected class DFA83 extends DFA {

		public DFA83(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 83;
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
			return "5118:3: ( ( ( () '[' ) )=> (lv_arguments_14_0= ruleXClosure ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA83_1 = input.LA(1);
						 
						int index83_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred36_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index83_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 83, _s, input);
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

	protected class DFA86 extends DFA {

		public DFA86(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 86;
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
			return "5461:3: ( ( 'extends' | 'static' | 'import' | 'extension' | '!' | '-' | '+' | 'new' | '{' | 'switch' | 'synchronized' | '<' | 'super' | '#' | '[' | 'false' | 'true' | 'null' | 'typeof' | 'if' | 'for' | 'while' | 'do' | 'throw' | 'return' | 'try' | '(' | RULE_ID | RULE_HEX | RULE_INT | RULE_DECIMAL | RULE_STRING )=> (lv_expression_2_0= ruleXExpression ) )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA86_1 = input.LA(1);
						 
						int index86_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_1);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA86_2 = input.LA(1);
						 
						int index86_2 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_2);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA86_3 = input.LA(1);
						 
						int index86_3 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_3);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA86_4 = input.LA(1);
						 
						int index86_4 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_4);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA86_5 = input.LA(1);
						 
						int index86_5 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_5);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA86_6 = input.LA(1);
						 
						int index86_6 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_6);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA86_7 = input.LA(1);
						 
						int index86_7 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_7);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA86_8 = input.LA(1);
						 
						int index86_8 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_8);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA86_9 = input.LA(1);
						 
						int index86_9 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_9);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA86_10 = input.LA(1);
						 
						int index86_10 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_10);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA86_11 = input.LA(1);
						 
						int index86_11 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_11);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA86_12 = input.LA(1);
						 
						int index86_12 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_12);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA86_13 = input.LA(1);
						 
						int index86_13 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_13);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA86_14 = input.LA(1);
						 
						int index86_14 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_14);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA86_15 = input.LA(1);
						 
						int index86_15 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_15);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA86_16 = input.LA(1);
						 
						int index86_16 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_16);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA86_17 = input.LA(1);
						 
						int index86_17 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_17);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA86_18 = input.LA(1);
						 
						int index86_18 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_18);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA86_19 = input.LA(1);
						 
						int index86_19 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_19);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA86_20 = input.LA(1);
						 
						int index86_20 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_20);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA86_21 = input.LA(1);
						 
						int index86_21 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_21);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA86_22 = input.LA(1);
						 
						int index86_22 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_22);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA86_23 = input.LA(1);
						 
						int index86_23 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_23);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA86_24 = input.LA(1);
						 
						int index86_24 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_24);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA86_25 = input.LA(1);
						 
						int index86_25 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_25);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA86_26 = input.LA(1);
						 
						int index86_26 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_26);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA86_27 = input.LA(1);
						 
						int index86_27 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_27);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA86_28 = input.LA(1);
						 
						int index86_28 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_28);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA86_29 = input.LA(1);
						 
						int index86_29 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_29);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA86_30 = input.LA(1);
						 
						int index86_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_30);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA86_31 = input.LA(1);
						 
						int index86_31 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_31);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA86_32 = input.LA(1);
						 
						int index86_32 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred37_InternalWeightDefinition()) ) {s = 77;}
						else if ( (true) ) {s = 33;}
						 
						input.seek(index86_32);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 86, _s, input);
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
			return "6119:3: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' ( ( ( ( () '.' ) )=> ( () otherlv_7= '.' ) ) ( ( ruleValidID ) ) ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )? )* )?";
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
						if ( (synpred44_InternalWeightDefinition()) ) {s = 78;}
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

	protected class DFA102 extends DFA {

		public DFA102(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 102;
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
			return "6213:5: ( ( ( '<' )=>otherlv_9= '<' ) ( (lv_arguments_10_0= ruleJvmArgumentTypeReference ) ) (otherlv_11= ',' ( (lv_arguments_12_0= ruleJvmArgumentTypeReference ) ) )* otherlv_13= '>' )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA102_1 = input.LA(1);
						 
						int index102_1 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred46_InternalWeightDefinition()) ) {s = 78;}
						else if ( (true) ) {s = 2;}
						 
						input.seek(index102_1);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 102, _s, input);
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

	protected class DFA111 extends DFA {

		public DFA111(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 111;
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
			return "6675:3: ( ( ( (lv_static_1_0= 'static' ) ) ( (lv_extension_2_0= 'extension' ) )? ( ( ruleQualifiedNameInStaticImport ) ) ( ( (lv_wildcard_4_0= '*' ) ) | ( (lv_memberName_5_0= ruleValidID ) ) ) ) | ( ( ruleQualifiedName ) ) | ( (lv_importedNamespace_7_0= ruleQualifiedNameWithWildcard ) ) )";
		}
	}

	public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0400000000000002L,0x0000000000000204L});
	public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000800000200080L});
	public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000800000600080L});
	public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000020400000L});
	public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_12 = new BitSet(new long[]{0xE8200400442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0001044112040002L});
	public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0003000000000000L});
	public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
	public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080002L});
	public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000060000000C002L});
	public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0003040000000002L,0x0000000000000020L});
	public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00118C1A00000002L});
	public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000840000000000L});
	public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000044000002L});
	public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000002001820002L});
	public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0080000000000002L});
	public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000088000002L});
	public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0008010400000002L});
	public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x6000000000000080L,0x0000000000000410L});
	public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x6000040000000080L,0x0000000000000C10L});
	public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0004800000200080L});
	public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0001000020000000L});
	public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x6000000000000080L,0x0000000000000C10L});
	public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0028010400200002L});
	public static final BitSet FOLLOW_36 = new BitSet(new long[]{0xE8208400446129E0L,0x000000000073FDDAL});
	public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0028010400000002L});
	public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xE8200400442129E0L,0x000000000133FDDAL});
	public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000020000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000000000000L});
	public static final BitSet FOLLOW_42 = new BitSet(new long[]{0xE8600400442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0040000020000000L});
	public static final BitSet FOLLOW_44 = new BitSet(new long[]{0xE8608400442129E0L,0x00000000007FFDDAL});
	public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000020000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_46 = new BitSet(new long[]{0xE8600400442129E0L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_48 = new BitSet(new long[]{0xE8200600442129E2L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_49 = new BitSet(new long[]{0xE8200400442129E2L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_51 = new BitSet(new long[]{0xE8208400442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0500808020200080L,0x0000000001000000L});
	public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0100008020000000L});
	public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000008020000000L});
	public static final BitSet FOLLOW_57 = new BitSet(new long[]{0xE8200600442129E0L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000020020000000L});
	public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xE8200400442129E0L,0x00000000003FFDDAL});
	public static final BitSet FOLLOW_60 = new BitSet(new long[]{0xE8200600442129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_62 = new BitSet(new long[]{0xE8200400446129E0L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_64 = new BitSet(new long[]{0xE8200400442129E0L,0x00000000013FFDDAL});
	public static final BitSet FOLLOW_65 = new BitSet(new long[]{0xE8200600442129E0L,0x00000000013FFDDAL});
	public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000100000000002L});
	public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0020000000200002L});
	public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0020000000000002L});
	public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0020040000200002L});
	public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0020000000400000L});
	public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xE8200400442129E2L,0x000000000033FDDAL});
	public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0200000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000400000002L});
	public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000120L});
	public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000040400000002L});
	public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x2000000000000002L,0x0000000000000800L});
	public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000100002L});
	public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000080L,0x0000000000000400L});
	public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x4000000000000080L});
	public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000800080L});
	public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000000082L});
}
