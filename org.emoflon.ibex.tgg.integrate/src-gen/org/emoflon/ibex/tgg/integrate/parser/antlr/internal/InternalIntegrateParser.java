package org.emoflon.ibex.tgg.integrate.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.emoflon.ibex.tgg.integrate.services.IntegrateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIntegrateParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#import'", "'solve'", "'conflict'", "'for'", "'all'", "'{'", "'satisfies'", "'}'", "'with'", "'var'", "'='", "'|'", "'#src'", "'#trg'", "'created'", "'deleted'", "'type'", "'count'", "'and'", "'or'", "'>'", "'>='", "'<'", "'<='", "'actAndLetRepair'", "'mergeAndPreserve'", "'preferSource'", "'preferTarget'", "'revokeAddition'", "'revokeDeletion'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalIntegrateParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalIntegrateParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalIntegrateParser.tokenNames; }
    public String getGrammarFileName() { return "InternalIntegrate.g"; }



     	private IntegrateGrammarAccess grammarAccess;

        public InternalIntegrateParser(TokenStream input, IntegrateGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Integrate";
       	}

       	@Override
       	protected IntegrateGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleIntegrate"
    // InternalIntegrate.g:64:1: entryRuleIntegrate returns [EObject current=null] : iv_ruleIntegrate= ruleIntegrate EOF ;
    public final EObject entryRuleIntegrate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegrate = null;


        try {
            // InternalIntegrate.g:64:50: (iv_ruleIntegrate= ruleIntegrate EOF )
            // InternalIntegrate.g:65:2: iv_ruleIntegrate= ruleIntegrate EOF
            {
             newCompositeNode(grammarAccess.getIntegrateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegrate=ruleIntegrate();

            state._fsp--;

             current =iv_ruleIntegrate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegrate"


    // $ANTLR start "ruleIntegrate"
    // InternalIntegrate.g:71:1: ruleIntegrate returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy ) )* ) ;
    public final EObject ruleIntegrate() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_conflictResolutionStrategies_1_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:77:2: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy ) )* ) )
            // InternalIntegrate.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy ) )* )
            {
            // InternalIntegrate.g:78:2: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy ) )* )
            // InternalIntegrate.g:79:3: ( (lv_imports_0_0= ruleImport ) )* ( (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy ) )*
            {
            // InternalIntegrate.g:79:3: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalIntegrate.g:80:4: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalIntegrate.g:80:4: (lv_imports_0_0= ruleImport )
            	    // InternalIntegrate.g:81:5: lv_imports_0_0= ruleImport
            	    {

            	    					newCompositeNode(grammarAccess.getIntegrateAccess().getImportsImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntegrateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.emoflon.ibex.tgg.integrate.Integrate.Import");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalIntegrate.g:98:3: ( (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalIntegrate.g:99:4: (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy )
            	    {
            	    // InternalIntegrate.g:99:4: (lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy )
            	    // InternalIntegrate.g:100:5: lv_conflictResolutionStrategies_1_0= ruleConflictResolutionStrategy
            	    {

            	    					newCompositeNode(grammarAccess.getIntegrateAccess().getConflictResolutionStrategiesConflictResolutionStrategyParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_conflictResolutionStrategies_1_0=ruleConflictResolutionStrategy();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntegrateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"conflictResolutionStrategies",
            	    						lv_conflictResolutionStrategies_1_0,
            	    						"org.emoflon.ibex.tgg.integrate.Integrate.ConflictResolutionStrategy");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegrate"


    // $ANTLR start "entryRuleImport"
    // InternalIntegrate.g:121:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalIntegrate.g:121:47: (iv_ruleImport= ruleImport EOF )
            // InternalIntegrate.g:122:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalIntegrate.g:128:1: ruleImport returns [EObject current=null] : (otherlv_0= '#import' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalIntegrate.g:134:2: ( (otherlv_0= '#import' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalIntegrate.g:135:2: (otherlv_0= '#import' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalIntegrate.g:135:2: (otherlv_0= '#import' ( (otherlv_1= RULE_ID ) ) )
            // InternalIntegrate.g:136:3: otherlv_0= '#import' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalIntegrate.g:140:3: ( (otherlv_1= RULE_ID ) )
            // InternalIntegrate.g:141:4: (otherlv_1= RULE_ID )
            {
            // InternalIntegrate.g:141:4: (otherlv_1= RULE_ID )
            // InternalIntegrate.g:142:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getImportAccess().getRuleRuleCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleConflictResolutionStrategy"
    // InternalIntegrate.g:157:1: entryRuleConflictResolutionStrategy returns [EObject current=null] : iv_ruleConflictResolutionStrategy= ruleConflictResolutionStrategy EOF ;
    public final EObject entryRuleConflictResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictResolutionStrategy = null;


        try {
            // InternalIntegrate.g:157:67: (iv_ruleConflictResolutionStrategy= ruleConflictResolutionStrategy EOF )
            // InternalIntegrate.g:158:2: iv_ruleConflictResolutionStrategy= ruleConflictResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getConflictResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConflictResolutionStrategy=ruleConflictResolutionStrategy();

            state._fsp--;

             current =iv_ruleConflictResolutionStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConflictResolutionStrategy"


    // $ANTLR start "ruleConflictResolutionStrategy"
    // InternalIntegrate.g:164:1: ruleConflictResolutionStrategy returns [EObject current=null] : ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' otherlv_12= 'with' ( (lv_resolutionStrategy_13_0= ruleResolutionStrategy ) ) ) ;
    public final EObject ruleConflictResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_variables_6_0 = null;

        EObject lv_rule_9_0 = null;

        EObject lv_resolutionStrategy_13_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:170:2: ( ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' otherlv_12= 'with' ( (lv_resolutionStrategy_13_0= ruleResolutionStrategy ) ) ) )
            // InternalIntegrate.g:171:2: ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' otherlv_12= 'with' ( (lv_resolutionStrategy_13_0= ruleResolutionStrategy ) ) )
            {
            // InternalIntegrate.g:171:2: ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' otherlv_12= 'with' ( (lv_resolutionStrategy_13_0= ruleResolutionStrategy ) ) )
            // InternalIntegrate.g:172:3: () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' otherlv_12= 'with' ( (lv_resolutionStrategy_13_0= ruleResolutionStrategy ) )
            {
            // InternalIntegrate.g:172:3: ()
            // InternalIntegrate.g:173:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getConflictResolutionStrategyAccess().getConflictResolutionStrategyAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getConflictResolutionStrategyAccess().getSolveKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getConflictResolutionStrategyAccess().getConflictKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_3, grammarAccess.getConflictResolutionStrategyAccess().getForKeyword_3());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_4, grammarAccess.getConflictResolutionStrategyAccess().getAllKeyword_4());
            		
            otherlv_5=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_5, grammarAccess.getConflictResolutionStrategyAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalIntegrate.g:199:3: ( (lv_variables_6_0= ruleVariable ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==20) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIntegrate.g:200:4: (lv_variables_6_0= ruleVariable )
            	    {
            	    // InternalIntegrate.g:200:4: (lv_variables_6_0= ruleVariable )
            	    // InternalIntegrate.g:201:5: lv_variables_6_0= ruleVariable
            	    {

            	    					newCompositeNode(grammarAccess.getConflictResolutionStrategyAccess().getVariablesVariableParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_variables_6_0=ruleVariable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConflictResolutionStrategyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_6_0,
            	    						"org.emoflon.ibex.tgg.integrate.Integrate.Variable");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_7=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_7, grammarAccess.getConflictResolutionStrategyAccess().getSatisfiesKeyword_7());
            		
            otherlv_8=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_8, grammarAccess.getConflictResolutionStrategyAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalIntegrate.g:226:3: ( (lv_rule_9_0= ruleSatisfactionRule ) )
            // InternalIntegrate.g:227:4: (lv_rule_9_0= ruleSatisfactionRule )
            {
            // InternalIntegrate.g:227:4: (lv_rule_9_0= ruleSatisfactionRule )
            // InternalIntegrate.g:228:5: lv_rule_9_0= ruleSatisfactionRule
            {

            					newCompositeNode(grammarAccess.getConflictResolutionStrategyAccess().getRuleSatisfactionRuleParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_13);
            lv_rule_9_0=ruleSatisfactionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConflictResolutionStrategyRule());
            					}
            					set(
            						current,
            						"rule",
            						lv_rule_9_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.SatisfactionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_10, grammarAccess.getConflictResolutionStrategyAccess().getRightCurlyBracketKeyword_10());
            		
            otherlv_11=(Token)match(input,18,FOLLOW_14); 

            			newLeafNode(otherlv_11, grammarAccess.getConflictResolutionStrategyAccess().getRightCurlyBracketKeyword_11());
            		
            otherlv_12=(Token)match(input,19,FOLLOW_15); 

            			newLeafNode(otherlv_12, grammarAccess.getConflictResolutionStrategyAccess().getWithKeyword_12());
            		
            // InternalIntegrate.g:257:3: ( (lv_resolutionStrategy_13_0= ruleResolutionStrategy ) )
            // InternalIntegrate.g:258:4: (lv_resolutionStrategy_13_0= ruleResolutionStrategy )
            {
            // InternalIntegrate.g:258:4: (lv_resolutionStrategy_13_0= ruleResolutionStrategy )
            // InternalIntegrate.g:259:5: lv_resolutionStrategy_13_0= ruleResolutionStrategy
            {

            					newCompositeNode(grammarAccess.getConflictResolutionStrategyAccess().getResolutionStrategyResolutionStrategyParserRuleCall_13_0());
            				
            pushFollow(FOLLOW_2);
            lv_resolutionStrategy_13_0=ruleResolutionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConflictResolutionStrategyRule());
            					}
            					set(
            						current,
            						"resolutionStrategy",
            						lv_resolutionStrategy_13_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.ResolutionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConflictResolutionStrategy"


    // $ANTLR start "entryRuleVariable"
    // InternalIntegrate.g:280:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalIntegrate.g:280:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalIntegrate.g:281:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalIntegrate.g:287:1: ruleVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_pipeline_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:293:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) ) )
            // InternalIntegrate.g:294:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) )
            {
            // InternalIntegrate.g:294:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) )
            // InternalIntegrate.g:295:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getVarKeyword_0());
            		
            // InternalIntegrate.g:299:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIntegrate.g:300:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIntegrate.g:300:4: (lv_name_1_0= RULE_ID )
            // InternalIntegrate.g:301:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_17); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getEqualsSignKeyword_2());
            		
            // InternalIntegrate.g:321:3: ( (lv_pipeline_3_0= rulePipeline ) )
            // InternalIntegrate.g:322:4: (lv_pipeline_3_0= rulePipeline )
            {
            // InternalIntegrate.g:322:4: (lv_pipeline_3_0= rulePipeline )
            // InternalIntegrate.g:323:5: lv_pipeline_3_0= rulePipeline
            {

            					newCompositeNode(grammarAccess.getVariableAccess().getPipelinePipelineParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_pipeline_3_0=rulePipeline();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRule());
            					}
            					set(
            						current,
            						"pipeline",
            						lv_pipeline_3_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.Pipeline");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRulePipeline"
    // InternalIntegrate.g:344:1: entryRulePipeline returns [EObject current=null] : iv_rulePipeline= rulePipeline EOF ;
    public final EObject entryRulePipeline() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipeline = null;


        try {
            // InternalIntegrate.g:344:49: (iv_rulePipeline= rulePipeline EOF )
            // InternalIntegrate.g:345:2: iv_rulePipeline= rulePipeline EOF
            {
             newCompositeNode(grammarAccess.getPipelineRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipeline=rulePipeline();

            state._fsp--;

             current =iv_rulePipeline; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipeline"


    // $ANTLR start "rulePipeline"
    // InternalIntegrate.g:351:1: rulePipeline returns [EObject current=null] : ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* ) ;
    public final EObject rulePipeline() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_first_0_1 = null;

        EObject lv_first_0_2 = null;

        EObject lv_next_2_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:357:2: ( ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* ) )
            // InternalIntegrate.g:358:2: ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* )
            {
            // InternalIntegrate.g:358:2: ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* )
            // InternalIntegrate.g:359:3: ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )*
            {
            // InternalIntegrate.g:359:3: ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) )
            // InternalIntegrate.g:360:4: ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) )
            {
            // InternalIntegrate.g:360:4: ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) )
            // InternalIntegrate.g:361:5: (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg )
            {
            // InternalIntegrate.g:361:5: (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==23) ) {
                alt4=1;
            }
            else if ( (LA4_0==24) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalIntegrate.g:362:6: lv_first_0_1= rulePipelineStageSrc
                    {

                    						newCompositeNode(grammarAccess.getPipelineAccess().getFirstPipelineStageSrcParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_first_0_1=rulePipelineStageSrc();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineRule());
                    						}
                    						set(
                    							current,
                    							"first",
                    							lv_first_0_1,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageSrc");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:378:6: lv_first_0_2= rulePipelineStageTrg
                    {

                    						newCompositeNode(grammarAccess.getPipelineAccess().getFirstPipelineStageTrgParserRuleCall_0_0_1());
                    					
                    pushFollow(FOLLOW_18);
                    lv_first_0_2=rulePipelineStageTrg();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineRule());
                    						}
                    						set(
                    							current,
                    							"first",
                    							lv_first_0_2,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageTrg");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }

            // InternalIntegrate.g:396:3: (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==22) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalIntegrate.g:397:4: otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) )
            	    {
            	    otherlv_1=(Token)match(input,22,FOLLOW_19); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPipelineAccess().getVerticalLineKeyword_1_0());
            	    			
            	    // InternalIntegrate.g:401:4: ( (lv_next_2_0= rulePipelineStage ) )
            	    // InternalIntegrate.g:402:5: (lv_next_2_0= rulePipelineStage )
            	    {
            	    // InternalIntegrate.g:402:5: (lv_next_2_0= rulePipelineStage )
            	    // InternalIntegrate.g:403:6: lv_next_2_0= rulePipelineStage
            	    {

            	    						newCompositeNode(grammarAccess.getPipelineAccess().getNextPipelineStageParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_18);
            	    lv_next_2_0=rulePipelineStage();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPipelineRule());
            	    						}
            	    						add(
            	    							current,
            	    							"next",
            	    							lv_next_2_0,
            	    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStage");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipeline"


    // $ANTLR start "entryRulePipelineStageSrc"
    // InternalIntegrate.g:425:1: entryRulePipelineStageSrc returns [EObject current=null] : iv_rulePipelineStageSrc= rulePipelineStageSrc EOF ;
    public final EObject entryRulePipelineStageSrc() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageSrc = null;


        try {
            // InternalIntegrate.g:425:57: (iv_rulePipelineStageSrc= rulePipelineStageSrc EOF )
            // InternalIntegrate.g:426:2: iv_rulePipelineStageSrc= rulePipelineStageSrc EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageSrcRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageSrc=rulePipelineStageSrc();

            state._fsp--;

             current =iv_rulePipelineStageSrc; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineStageSrc"


    // $ANTLR start "rulePipelineStageSrc"
    // InternalIntegrate.g:432:1: rulePipelineStageSrc returns [EObject current=null] : ( (lv_name_0_0= '#src' ) ) ;
    public final EObject rulePipelineStageSrc() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:438:2: ( ( (lv_name_0_0= '#src' ) ) )
            // InternalIntegrate.g:439:2: ( (lv_name_0_0= '#src' ) )
            {
            // InternalIntegrate.g:439:2: ( (lv_name_0_0= '#src' ) )
            // InternalIntegrate.g:440:3: (lv_name_0_0= '#src' )
            {
            // InternalIntegrate.g:440:3: (lv_name_0_0= '#src' )
            // InternalIntegrate.g:441:4: lv_name_0_0= '#src'
            {
            lv_name_0_0=(Token)match(input,23,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineStageSrcRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "#src");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineStageSrc"


    // $ANTLR start "entryRulePipelineStageTrg"
    // InternalIntegrate.g:456:1: entryRulePipelineStageTrg returns [EObject current=null] : iv_rulePipelineStageTrg= rulePipelineStageTrg EOF ;
    public final EObject entryRulePipelineStageTrg() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageTrg = null;


        try {
            // InternalIntegrate.g:456:57: (iv_rulePipelineStageTrg= rulePipelineStageTrg EOF )
            // InternalIntegrate.g:457:2: iv_rulePipelineStageTrg= rulePipelineStageTrg EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageTrgRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageTrg=rulePipelineStageTrg();

            state._fsp--;

             current =iv_rulePipelineStageTrg; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineStageTrg"


    // $ANTLR start "rulePipelineStageTrg"
    // InternalIntegrate.g:463:1: rulePipelineStageTrg returns [EObject current=null] : ( (lv_name_0_0= '#trg' ) ) ;
    public final EObject rulePipelineStageTrg() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:469:2: ( ( (lv_name_0_0= '#trg' ) ) )
            // InternalIntegrate.g:470:2: ( (lv_name_0_0= '#trg' ) )
            {
            // InternalIntegrate.g:470:2: ( (lv_name_0_0= '#trg' ) )
            // InternalIntegrate.g:471:3: (lv_name_0_0= '#trg' )
            {
            // InternalIntegrate.g:471:3: (lv_name_0_0= '#trg' )
            // InternalIntegrate.g:472:4: lv_name_0_0= '#trg'
            {
            lv_name_0_0=(Token)match(input,24,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineStageTrgRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "#trg");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineStageTrg"


    // $ANTLR start "entryRulePipelineStage"
    // InternalIntegrate.g:487:1: entryRulePipelineStage returns [EObject current=null] : iv_rulePipelineStage= rulePipelineStage EOF ;
    public final EObject entryRulePipelineStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStage = null;


        try {
            // InternalIntegrate.g:487:54: (iv_rulePipelineStage= rulePipelineStage EOF )
            // InternalIntegrate.g:488:2: iv_rulePipelineStage= rulePipelineStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStage=rulePipelineStage();

            state._fsp--;

             current =iv_rulePipelineStage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineStage"


    // $ANTLR start "rulePipelineStage"
    // InternalIntegrate.g:494:1: rulePipelineStage returns [EObject current=null] : (this_PipelineFilterStage_0= rulePipelineFilterStage | this_PipelineCountStage_1= rulePipelineCountStage ) ;
    public final EObject rulePipelineStage() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineFilterStage_0 = null;

        EObject this_PipelineCountStage_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:500:2: ( (this_PipelineFilterStage_0= rulePipelineFilterStage | this_PipelineCountStage_1= rulePipelineCountStage ) )
            // InternalIntegrate.g:501:2: (this_PipelineFilterStage_0= rulePipelineFilterStage | this_PipelineCountStage_1= rulePipelineCountStage )
            {
            // InternalIntegrate.g:501:2: (this_PipelineFilterStage_0= rulePipelineFilterStage | this_PipelineCountStage_1= rulePipelineCountStage )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=25 && LA6_0<=27)) ) {
                alt6=1;
            }
            else if ( (LA6_0==28) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalIntegrate.g:502:3: this_PipelineFilterStage_0= rulePipelineFilterStage
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageAccess().getPipelineFilterStageParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineFilterStage_0=rulePipelineFilterStage();

                    state._fsp--;


                    			current = this_PipelineFilterStage_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:511:3: this_PipelineCountStage_1= rulePipelineCountStage
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageAccess().getPipelineCountStageParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineCountStage_1=rulePipelineCountStage();

                    state._fsp--;


                    			current = this_PipelineCountStage_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineStage"


    // $ANTLR start "entryRulePipelineFilterStage"
    // InternalIntegrate.g:523:1: entryRulePipelineFilterStage returns [EObject current=null] : iv_rulePipelineFilterStage= rulePipelineFilterStage EOF ;
    public final EObject entryRulePipelineFilterStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineFilterStage = null;


        try {
            // InternalIntegrate.g:523:60: (iv_rulePipelineFilterStage= rulePipelineFilterStage EOF )
            // InternalIntegrate.g:524:2: iv_rulePipelineFilterStage= rulePipelineFilterStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineFilterStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineFilterStage=rulePipelineFilterStage();

            state._fsp--;

             current =iv_rulePipelineFilterStage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineFilterStage"


    // $ANTLR start "rulePipelineFilterStage"
    // InternalIntegrate.g:530:1: rulePipelineFilterStage returns [EObject current=null] : (this_PipelineCreatedFilterStage_0= rulePipelineCreatedFilterStage | this_PipelineDeletedFilterStage_1= rulePipelineDeletedFilterStage | this_PipelineTypeFilterStage_2= rulePipelineTypeFilterStage ) ;
    public final EObject rulePipelineFilterStage() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineCreatedFilterStage_0 = null;

        EObject this_PipelineDeletedFilterStage_1 = null;

        EObject this_PipelineTypeFilterStage_2 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:536:2: ( (this_PipelineCreatedFilterStage_0= rulePipelineCreatedFilterStage | this_PipelineDeletedFilterStage_1= rulePipelineDeletedFilterStage | this_PipelineTypeFilterStage_2= rulePipelineTypeFilterStage ) )
            // InternalIntegrate.g:537:2: (this_PipelineCreatedFilterStage_0= rulePipelineCreatedFilterStage | this_PipelineDeletedFilterStage_1= rulePipelineDeletedFilterStage | this_PipelineTypeFilterStage_2= rulePipelineTypeFilterStage )
            {
            // InternalIntegrate.g:537:2: (this_PipelineCreatedFilterStage_0= rulePipelineCreatedFilterStage | this_PipelineDeletedFilterStage_1= rulePipelineDeletedFilterStage | this_PipelineTypeFilterStage_2= rulePipelineTypeFilterStage )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt7=1;
                }
                break;
            case 26:
                {
                alt7=2;
                }
                break;
            case 27:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalIntegrate.g:538:3: this_PipelineCreatedFilterStage_0= rulePipelineCreatedFilterStage
                    {

                    			newCompositeNode(grammarAccess.getPipelineFilterStageAccess().getPipelineCreatedFilterStageParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineCreatedFilterStage_0=rulePipelineCreatedFilterStage();

                    state._fsp--;


                    			current = this_PipelineCreatedFilterStage_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:547:3: this_PipelineDeletedFilterStage_1= rulePipelineDeletedFilterStage
                    {

                    			newCompositeNode(grammarAccess.getPipelineFilterStageAccess().getPipelineDeletedFilterStageParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineDeletedFilterStage_1=rulePipelineDeletedFilterStage();

                    state._fsp--;


                    			current = this_PipelineDeletedFilterStage_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:556:3: this_PipelineTypeFilterStage_2= rulePipelineTypeFilterStage
                    {

                    			newCompositeNode(grammarAccess.getPipelineFilterStageAccess().getPipelineTypeFilterStageParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineTypeFilterStage_2=rulePipelineTypeFilterStage();

                    state._fsp--;


                    			current = this_PipelineTypeFilterStage_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineFilterStage"


    // $ANTLR start "entryRulePipelineCreatedFilterStage"
    // InternalIntegrate.g:568:1: entryRulePipelineCreatedFilterStage returns [EObject current=null] : iv_rulePipelineCreatedFilterStage= rulePipelineCreatedFilterStage EOF ;
    public final EObject entryRulePipelineCreatedFilterStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineCreatedFilterStage = null;


        try {
            // InternalIntegrate.g:568:67: (iv_rulePipelineCreatedFilterStage= rulePipelineCreatedFilterStage EOF )
            // InternalIntegrate.g:569:2: iv_rulePipelineCreatedFilterStage= rulePipelineCreatedFilterStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineCreatedFilterStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineCreatedFilterStage=rulePipelineCreatedFilterStage();

            state._fsp--;

             current =iv_rulePipelineCreatedFilterStage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineCreatedFilterStage"


    // $ANTLR start "rulePipelineCreatedFilterStage"
    // InternalIntegrate.g:575:1: rulePipelineCreatedFilterStage returns [EObject current=null] : ( (lv_name_0_0= 'created' ) ) ;
    public final EObject rulePipelineCreatedFilterStage() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:581:2: ( ( (lv_name_0_0= 'created' ) ) )
            // InternalIntegrate.g:582:2: ( (lv_name_0_0= 'created' ) )
            {
            // InternalIntegrate.g:582:2: ( (lv_name_0_0= 'created' ) )
            // InternalIntegrate.g:583:3: (lv_name_0_0= 'created' )
            {
            // InternalIntegrate.g:583:3: (lv_name_0_0= 'created' )
            // InternalIntegrate.g:584:4: lv_name_0_0= 'created'
            {
            lv_name_0_0=(Token)match(input,25,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPipelineCreatedFilterStageAccess().getNameCreatedKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineCreatedFilterStageRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "created");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineCreatedFilterStage"


    // $ANTLR start "entryRulePipelineDeletedFilterStage"
    // InternalIntegrate.g:599:1: entryRulePipelineDeletedFilterStage returns [EObject current=null] : iv_rulePipelineDeletedFilterStage= rulePipelineDeletedFilterStage EOF ;
    public final EObject entryRulePipelineDeletedFilterStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineDeletedFilterStage = null;


        try {
            // InternalIntegrate.g:599:67: (iv_rulePipelineDeletedFilterStage= rulePipelineDeletedFilterStage EOF )
            // InternalIntegrate.g:600:2: iv_rulePipelineDeletedFilterStage= rulePipelineDeletedFilterStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineDeletedFilterStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineDeletedFilterStage=rulePipelineDeletedFilterStage();

            state._fsp--;

             current =iv_rulePipelineDeletedFilterStage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineDeletedFilterStage"


    // $ANTLR start "rulePipelineDeletedFilterStage"
    // InternalIntegrate.g:606:1: rulePipelineDeletedFilterStage returns [EObject current=null] : ( (lv_name_0_0= 'deleted' ) ) ;
    public final EObject rulePipelineDeletedFilterStage() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:612:2: ( ( (lv_name_0_0= 'deleted' ) ) )
            // InternalIntegrate.g:613:2: ( (lv_name_0_0= 'deleted' ) )
            {
            // InternalIntegrate.g:613:2: ( (lv_name_0_0= 'deleted' ) )
            // InternalIntegrate.g:614:3: (lv_name_0_0= 'deleted' )
            {
            // InternalIntegrate.g:614:3: (lv_name_0_0= 'deleted' )
            // InternalIntegrate.g:615:4: lv_name_0_0= 'deleted'
            {
            lv_name_0_0=(Token)match(input,26,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPipelineDeletedFilterStageAccess().getNameDeletedKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineDeletedFilterStageRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "deleted");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineDeletedFilterStage"


    // $ANTLR start "entryRulePipelineTypeFilterStage"
    // InternalIntegrate.g:630:1: entryRulePipelineTypeFilterStage returns [EObject current=null] : iv_rulePipelineTypeFilterStage= rulePipelineTypeFilterStage EOF ;
    public final EObject entryRulePipelineTypeFilterStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineTypeFilterStage = null;


        try {
            // InternalIntegrate.g:630:64: (iv_rulePipelineTypeFilterStage= rulePipelineTypeFilterStage EOF )
            // InternalIntegrate.g:631:2: iv_rulePipelineTypeFilterStage= rulePipelineTypeFilterStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineTypeFilterStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineTypeFilterStage=rulePipelineTypeFilterStage();

            state._fsp--;

             current =iv_rulePipelineTypeFilterStage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineTypeFilterStage"


    // $ANTLR start "rulePipelineTypeFilterStage"
    // InternalIntegrate.g:637:1: rulePipelineTypeFilterStage returns [EObject current=null] : ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject rulePipelineTypeFilterStage() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalIntegrate.g:643:2: ( ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // InternalIntegrate.g:644:2: ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalIntegrate.g:644:2: ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) )
            // InternalIntegrate.g:645:3: ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) )
            {
            // InternalIntegrate.g:645:3: ( (lv_name_0_0= 'type' ) )
            // InternalIntegrate.g:646:4: (lv_name_0_0= 'type' )
            {
            // InternalIntegrate.g:646:4: (lv_name_0_0= 'type' )
            // InternalIntegrate.g:647:5: lv_name_0_0= 'type'
            {
            lv_name_0_0=(Token)match(input,27,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPipelineTypeFilterStageAccess().getNameTypeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineTypeFilterStageRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "type");
            				

            }


            }

            // InternalIntegrate.g:659:3: ( (otherlv_1= RULE_ID ) )
            // InternalIntegrate.g:660:4: (otherlv_1= RULE_ID )
            {
            // InternalIntegrate.g:660:4: (otherlv_1= RULE_ID )
            // InternalIntegrate.g:661:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineTypeFilterStageRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getPipelineTypeFilterStageAccess().getTypeEClassifierCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineTypeFilterStage"


    // $ANTLR start "entryRulePipelineCountStage"
    // InternalIntegrate.g:676:1: entryRulePipelineCountStage returns [EObject current=null] : iv_rulePipelineCountStage= rulePipelineCountStage EOF ;
    public final EObject entryRulePipelineCountStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineCountStage = null;


        try {
            // InternalIntegrate.g:676:59: (iv_rulePipelineCountStage= rulePipelineCountStage EOF )
            // InternalIntegrate.g:677:2: iv_rulePipelineCountStage= rulePipelineCountStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineCountStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineCountStage=rulePipelineCountStage();

            state._fsp--;

             current =iv_rulePipelineCountStage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePipelineCountStage"


    // $ANTLR start "rulePipelineCountStage"
    // InternalIntegrate.g:683:1: rulePipelineCountStage returns [EObject current=null] : ( (lv_name_0_0= 'count' ) ) ;
    public final EObject rulePipelineCountStage() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:689:2: ( ( (lv_name_0_0= 'count' ) ) )
            // InternalIntegrate.g:690:2: ( (lv_name_0_0= 'count' ) )
            {
            // InternalIntegrate.g:690:2: ( (lv_name_0_0= 'count' ) )
            // InternalIntegrate.g:691:3: (lv_name_0_0= 'count' )
            {
            // InternalIntegrate.g:691:3: (lv_name_0_0= 'count' )
            // InternalIntegrate.g:692:4: lv_name_0_0= 'count'
            {
            lv_name_0_0=(Token)match(input,28,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPipelineCountStageAccess().getNameCountKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineCountStageRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "count");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePipelineCountStage"


    // $ANTLR start "entryRuleSatisfactionRule"
    // InternalIntegrate.g:707:1: entryRuleSatisfactionRule returns [EObject current=null] : iv_ruleSatisfactionRule= ruleSatisfactionRule EOF ;
    public final EObject entryRuleSatisfactionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSatisfactionRule = null;


        try {
            // InternalIntegrate.g:707:57: (iv_ruleSatisfactionRule= ruleSatisfactionRule EOF )
            // InternalIntegrate.g:708:2: iv_ruleSatisfactionRule= ruleSatisfactionRule EOF
            {
             newCompositeNode(grammarAccess.getSatisfactionRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSatisfactionRule=ruleSatisfactionRule();

            state._fsp--;

             current =iv_ruleSatisfactionRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSatisfactionRule"


    // $ANTLR start "ruleSatisfactionRule"
    // InternalIntegrate.g:714:1: ruleSatisfactionRule returns [EObject current=null] : ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* ) ;
    public final EObject ruleSatisfactionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_firstRule_0_0 = null;

        EObject lv_otherRules_1_1 = null;

        EObject lv_otherRules_1_2 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:720:2: ( ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* ) )
            // InternalIntegrate.g:721:2: ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* )
            {
            // InternalIntegrate.g:721:2: ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* )
            // InternalIntegrate.g:722:3: ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )*
            {
            // InternalIntegrate.g:722:3: ( (lv_firstRule_0_0= ruleComparison ) )
            // InternalIntegrate.g:723:4: (lv_firstRule_0_0= ruleComparison )
            {
            // InternalIntegrate.g:723:4: (lv_firstRule_0_0= ruleComparison )
            // InternalIntegrate.g:724:5: lv_firstRule_0_0= ruleComparison
            {

            					newCompositeNode(grammarAccess.getSatisfactionRuleAccess().getFirstRuleComparisonParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_20);
            lv_firstRule_0_0=ruleComparison();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSatisfactionRuleRule());
            					}
            					set(
            						current,
            						"firstRule",
            						lv_firstRule_0_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.Comparison");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalIntegrate.g:741:3: ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=29 && LA9_0<=30)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIntegrate.g:742:4: ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) )
            	    {
            	    // InternalIntegrate.g:742:4: ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) )
            	    // InternalIntegrate.g:743:5: (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr )
            	    {
            	    // InternalIntegrate.g:743:5: (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==29) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==30) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalIntegrate.g:744:6: lv_otherRules_1_1= ruleAnd
            	            {

            	            						newCompositeNode(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAndParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_20);
            	            lv_otherRules_1_1=ruleAnd();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getSatisfactionRuleRule());
            	            						}
            	            						add(
            	            							current,
            	            							"otherRules",
            	            							lv_otherRules_1_1,
            	            							"org.emoflon.ibex.tgg.integrate.Integrate.And");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;
            	        case 2 :
            	            // InternalIntegrate.g:760:6: lv_otherRules_1_2= ruleOr
            	            {

            	            						newCompositeNode(grammarAccess.getSatisfactionRuleAccess().getOtherRulesOrParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_20);
            	            lv_otherRules_1_2=ruleOr();

            	            state._fsp--;


            	            						if (current==null) {
            	            							current = createModelElementForParent(grammarAccess.getSatisfactionRuleRule());
            	            						}
            	            						add(
            	            							current,
            	            							"otherRules",
            	            							lv_otherRules_1_2,
            	            							"org.emoflon.ibex.tgg.integrate.Integrate.Or");
            	            						afterParserOrEnumRuleCall();
            	            					

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSatisfactionRule"


    // $ANTLR start "entryRuleAnd"
    // InternalIntegrate.g:782:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalIntegrate.g:782:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalIntegrate.g:783:2: iv_ruleAnd= ruleAnd EOF
            {
             newCompositeNode(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;

             current =iv_ruleAnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalIntegrate.g:789:1: ruleAnd returns [EObject current=null] : (otherlv_0= 'and' this_Comparison_1= ruleComparison ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Comparison_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:795:2: ( (otherlv_0= 'and' this_Comparison_1= ruleComparison ) )
            // InternalIntegrate.g:796:2: (otherlv_0= 'and' this_Comparison_1= ruleComparison )
            {
            // InternalIntegrate.g:796:2: (otherlv_0= 'and' this_Comparison_1= ruleComparison )
            // InternalIntegrate.g:797:3: otherlv_0= 'and' this_Comparison_1= ruleComparison
            {
            otherlv_0=(Token)match(input,29,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getAndAccess().getAndKeyword_0());
            		

            			newCompositeNode(grammarAccess.getAndAccess().getComparisonParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            this_Comparison_1=ruleComparison();

            state._fsp--;


            			current = this_Comparison_1;
            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleOr"
    // InternalIntegrate.g:813:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalIntegrate.g:813:43: (iv_ruleOr= ruleOr EOF )
            // InternalIntegrate.g:814:2: iv_ruleOr= ruleOr EOF
            {
             newCompositeNode(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;

             current =iv_ruleOr; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalIntegrate.g:820:1: ruleOr returns [EObject current=null] : (otherlv_0= 'or' this_Comparison_1= ruleComparison ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Comparison_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:826:2: ( (otherlv_0= 'or' this_Comparison_1= ruleComparison ) )
            // InternalIntegrate.g:827:2: (otherlv_0= 'or' this_Comparison_1= ruleComparison )
            {
            // InternalIntegrate.g:827:2: (otherlv_0= 'or' this_Comparison_1= ruleComparison )
            // InternalIntegrate.g:828:3: otherlv_0= 'or' this_Comparison_1= ruleComparison
            {
            otherlv_0=(Token)match(input,30,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getOrAccess().getOrKeyword_0());
            		

            			newCompositeNode(grammarAccess.getOrAccess().getComparisonParserRuleCall_1());
            		
            pushFollow(FOLLOW_2);
            this_Comparison_1=ruleComparison();

            state._fsp--;


            			current = this_Comparison_1;
            			afterParserOrEnumRuleCall();
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleComparison"
    // InternalIntegrate.g:844:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalIntegrate.g:844:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalIntegrate.g:845:2: iv_ruleComparison= ruleComparison EOF
            {
             newCompositeNode(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;

             current =iv_ruleComparison; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalIntegrate.g:851:1: ruleComparison returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_n1_1_0=null;
        Token lv_c1_2_1=null;
        Token lv_c1_2_2=null;
        Token lv_c1_2_3=null;
        Token lv_c1_2_4=null;
        Token otherlv_3=null;
        Token lv_n2_4_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:857:2: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) ) )
            // InternalIntegrate.g:858:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) )
            {
            // InternalIntegrate.g:858:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) )
            // InternalIntegrate.g:859:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) )
            {
            // InternalIntegrate.g:859:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_INT) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalIntegrate.g:860:4: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalIntegrate.g:860:4: ( (otherlv_0= RULE_ID ) )
                    // InternalIntegrate.g:861:5: (otherlv_0= RULE_ID )
                    {
                    // InternalIntegrate.g:861:5: (otherlv_0= RULE_ID )
                    // InternalIntegrate.g:862:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_21); 

                    						newLeafNode(otherlv_0, grammarAccess.getComparisonAccess().getV1VariableCrossReference_0_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:874:4: ( (lv_n1_1_0= RULE_INT ) )
                    {
                    // InternalIntegrate.g:874:4: ( (lv_n1_1_0= RULE_INT ) )
                    // InternalIntegrate.g:875:5: (lv_n1_1_0= RULE_INT )
                    {
                    // InternalIntegrate.g:875:5: (lv_n1_1_0= RULE_INT )
                    // InternalIntegrate.g:876:6: lv_n1_1_0= RULE_INT
                    {
                    lv_n1_1_0=(Token)match(input,RULE_INT,FOLLOW_21); 

                    						newLeafNode(lv_n1_1_0, grammarAccess.getComparisonAccess().getN1INTTerminalRuleCall_0_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"n1",
                    							lv_n1_1_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalIntegrate.g:893:3: ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) )
            // InternalIntegrate.g:894:4: ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) )
            {
            // InternalIntegrate.g:894:4: ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) )
            // InternalIntegrate.g:895:5: (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' )
            {
            // InternalIntegrate.g:895:5: (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt11=1;
                }
                break;
            case 32:
                {
                alt11=2;
                }
                break;
            case 33:
                {
                alt11=3;
                }
                break;
            case 34:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalIntegrate.g:896:6: lv_c1_2_1= '>'
                    {
                    lv_c1_2_1=(Token)match(input,31,FOLLOW_12); 

                    						newLeafNode(lv_c1_2_1, grammarAccess.getComparisonAccess().getC1GreaterThanSignKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(current, "c1", lv_c1_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:907:6: lv_c1_2_2= '>='
                    {
                    lv_c1_2_2=(Token)match(input,32,FOLLOW_12); 

                    						newLeafNode(lv_c1_2_2, grammarAccess.getComparisonAccess().getC1GreaterThanSignEqualsSignKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(current, "c1", lv_c1_2_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:918:6: lv_c1_2_3= '<'
                    {
                    lv_c1_2_3=(Token)match(input,33,FOLLOW_12); 

                    						newLeafNode(lv_c1_2_3, grammarAccess.getComparisonAccess().getC1LessThanSignKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(current, "c1", lv_c1_2_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:929:6: lv_c1_2_4= '<='
                    {
                    lv_c1_2_4=(Token)match(input,34,FOLLOW_12); 

                    						newLeafNode(lv_c1_2_4, grammarAccess.getComparisonAccess().getC1LessThanSignEqualsSignKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(current, "c1", lv_c1_2_4, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalIntegrate.g:942:3: ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_INT) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalIntegrate.g:943:4: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalIntegrate.g:943:4: ( (otherlv_3= RULE_ID ) )
                    // InternalIntegrate.g:944:5: (otherlv_3= RULE_ID )
                    {
                    // InternalIntegrate.g:944:5: (otherlv_3= RULE_ID )
                    // InternalIntegrate.g:945:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_3, grammarAccess.getComparisonAccess().getV2VariableCrossReference_2_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:957:4: ( (lv_n2_4_0= RULE_INT ) )
                    {
                    // InternalIntegrate.g:957:4: ( (lv_n2_4_0= RULE_INT ) )
                    // InternalIntegrate.g:958:5: (lv_n2_4_0= RULE_INT )
                    {
                    // InternalIntegrate.g:958:5: (lv_n2_4_0= RULE_INT )
                    // InternalIntegrate.g:959:6: lv_n2_4_0= RULE_INT
                    {
                    lv_n2_4_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_n2_4_0, grammarAccess.getComparisonAccess().getN2INTTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"n2",
                    							lv_n2_4_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleResolutionStrategy"
    // InternalIntegrate.g:980:1: entryRuleResolutionStrategy returns [EObject current=null] : iv_ruleResolutionStrategy= ruleResolutionStrategy EOF ;
    public final EObject entryRuleResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResolutionStrategy = null;


        try {
            // InternalIntegrate.g:980:59: (iv_ruleResolutionStrategy= ruleResolutionStrategy EOF )
            // InternalIntegrate.g:981:2: iv_ruleResolutionStrategy= ruleResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResolutionStrategy=ruleResolutionStrategy();

            state._fsp--;

             current =iv_ruleResolutionStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResolutionStrategy"


    // $ANTLR start "ruleResolutionStrategy"
    // InternalIntegrate.g:987:1: ruleResolutionStrategy returns [EObject current=null] : ( ( (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' ) ) ) ;
    public final EObject ruleResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;
        Token lv_name_0_3=null;
        Token lv_name_0_4=null;
        Token lv_name_0_5=null;
        Token lv_name_0_6=null;


        	enterRule();

        try {
            // InternalIntegrate.g:993:2: ( ( ( (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' ) ) ) )
            // InternalIntegrate.g:994:2: ( ( (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' ) ) )
            {
            // InternalIntegrate.g:994:2: ( ( (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' ) ) )
            // InternalIntegrate.g:995:3: ( (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' ) )
            {
            // InternalIntegrate.g:995:3: ( (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' ) )
            // InternalIntegrate.g:996:4: (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' )
            {
            // InternalIntegrate.g:996:4: (lv_name_0_1= 'actAndLetRepair' | lv_name_0_2= 'mergeAndPreserve' | lv_name_0_3= 'preferSource' | lv_name_0_4= 'preferTarget' | lv_name_0_5= 'revokeAddition' | lv_name_0_6= 'revokeDeletion' )
            int alt13=6;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt13=1;
                }
                break;
            case 36:
                {
                alt13=2;
                }
                break;
            case 37:
                {
                alt13=3;
                }
                break;
            case 38:
                {
                alt13=4;
                }
                break;
            case 39:
                {
                alt13=5;
                }
                break;
            case 40:
                {
                alt13=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalIntegrate.g:997:5: lv_name_0_1= 'actAndLetRepair'
                    {
                    lv_name_0_1=(Token)match(input,35,FOLLOW_2); 

                    					newLeafNode(lv_name_0_1, grammarAccess.getResolutionStrategyAccess().getNameActAndLetRepairKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getResolutionStrategyRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_1, null);
                    				

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1008:5: lv_name_0_2= 'mergeAndPreserve'
                    {
                    lv_name_0_2=(Token)match(input,36,FOLLOW_2); 

                    					newLeafNode(lv_name_0_2, grammarAccess.getResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0_1());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getResolutionStrategyRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_2, null);
                    				

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1019:5: lv_name_0_3= 'preferSource'
                    {
                    lv_name_0_3=(Token)match(input,37,FOLLOW_2); 

                    					newLeafNode(lv_name_0_3, grammarAccess.getResolutionStrategyAccess().getNamePreferSourceKeyword_0_2());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getResolutionStrategyRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_3, null);
                    				

                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:1030:5: lv_name_0_4= 'preferTarget'
                    {
                    lv_name_0_4=(Token)match(input,38,FOLLOW_2); 

                    					newLeafNode(lv_name_0_4, grammarAccess.getResolutionStrategyAccess().getNamePreferTargetKeyword_0_3());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getResolutionStrategyRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_4, null);
                    				

                    }
                    break;
                case 5 :
                    // InternalIntegrate.g:1041:5: lv_name_0_5= 'revokeAddition'
                    {
                    lv_name_0_5=(Token)match(input,39,FOLLOW_2); 

                    					newLeafNode(lv_name_0_5, grammarAccess.getResolutionStrategyAccess().getNameRevokeAdditionKeyword_0_4());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getResolutionStrategyRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_5, null);
                    				

                    }
                    break;
                case 6 :
                    // InternalIntegrate.g:1052:5: lv_name_0_6= 'revokeDeletion'
                    {
                    lv_name_0_6=(Token)match(input,40,FOLLOW_2); 

                    					newLeafNode(lv_name_0_6, grammarAccess.getResolutionStrategyAccess().getNameRevokeDeletionKeyword_0_5());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getResolutionStrategyRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_6, null);
                    				

                    }
                    break;

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResolutionStrategy"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000001F800000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000001E000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000780000000L});

}