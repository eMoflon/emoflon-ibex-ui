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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#import'", "'solve'", "'conflict'", "'for'", "'all'", "'{'", "'satisfies'", "'}'", "'var'", "'='", "'|'", "'#src'", "'#trg'", "'created'", "'deleted'", "'type'", "'count'", "'and'", "'or'", "'>'", "'>='", "'<'", "'<='"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
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
    // InternalIntegrate.g:128:1: ruleImport returns [EObject current=null] : (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:134:2: ( (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalIntegrate.g:135:2: (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalIntegrate.g:135:2: (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalIntegrate.g:136:3: otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalIntegrate.g:140:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalIntegrate.g:141:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalIntegrate.g:141:4: (lv_name_1_0= RULE_STRING )
            // InternalIntegrate.g:142:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getImportAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // InternalIntegrate.g:162:1: entryRuleConflictResolutionStrategy returns [EObject current=null] : iv_ruleConflictResolutionStrategy= ruleConflictResolutionStrategy EOF ;
    public final EObject entryRuleConflictResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictResolutionStrategy = null;


        try {
            // InternalIntegrate.g:162:67: (iv_ruleConflictResolutionStrategy= ruleConflictResolutionStrategy EOF )
            // InternalIntegrate.g:163:2: iv_ruleConflictResolutionStrategy= ruleConflictResolutionStrategy EOF
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
    // InternalIntegrate.g:169:1: ruleConflictResolutionStrategy returns [EObject current=null] : ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' ) ;
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
        EObject lv_variables_6_0 = null;

        EObject lv_rule_9_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:175:2: ( ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' ) )
            // InternalIntegrate.g:176:2: ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' )
            {
            // InternalIntegrate.g:176:2: ( () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}' )
            // InternalIntegrate.g:177:3: () otherlv_1= 'solve' otherlv_2= 'conflict' otherlv_3= 'for' otherlv_4= 'all' otherlv_5= '{' ( (lv_variables_6_0= ruleVariable ) )+ otherlv_7= 'satisfies' otherlv_8= '{' ( (lv_rule_9_0= ruleSatisfactionRule ) ) otherlv_10= '}' otherlv_11= '}'
            {
            // InternalIntegrate.g:177:3: ()
            // InternalIntegrate.g:178:4: 
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
            		
            // InternalIntegrate.g:204:3: ( (lv_variables_6_0= ruleVariable ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==19) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIntegrate.g:205:4: (lv_variables_6_0= ruleVariable )
            	    {
            	    // InternalIntegrate.g:205:4: (lv_variables_6_0= ruleVariable )
            	    // InternalIntegrate.g:206:5: lv_variables_6_0= ruleVariable
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
            		
            // InternalIntegrate.g:231:3: ( (lv_rule_9_0= ruleSatisfactionRule ) )
            // InternalIntegrate.g:232:4: (lv_rule_9_0= ruleSatisfactionRule )
            {
            // InternalIntegrate.g:232:4: (lv_rule_9_0= ruleSatisfactionRule )
            // InternalIntegrate.g:233:5: lv_rule_9_0= ruleSatisfactionRule
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
            		
            otherlv_11=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_11, grammarAccess.getConflictResolutionStrategyAccess().getRightCurlyBracketKeyword_11());
            		

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
    // InternalIntegrate.g:262:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalIntegrate.g:262:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalIntegrate.g:263:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalIntegrate.g:269:1: ruleVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_pipeline_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:275:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) ) )
            // InternalIntegrate.g:276:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) )
            {
            // InternalIntegrate.g:276:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) )
            // InternalIntegrate.g:277:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getVarKeyword_0());
            		
            // InternalIntegrate.g:281:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIntegrate.g:282:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIntegrate.g:282:4: (lv_name_1_0= RULE_ID )
            // InternalIntegrate.g:283:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_15); 

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

            otherlv_2=(Token)match(input,20,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getEqualsSignKeyword_2());
            		
            // InternalIntegrate.g:303:3: ( (lv_pipeline_3_0= rulePipeline ) )
            // InternalIntegrate.g:304:4: (lv_pipeline_3_0= rulePipeline )
            {
            // InternalIntegrate.g:304:4: (lv_pipeline_3_0= rulePipeline )
            // InternalIntegrate.g:305:5: lv_pipeline_3_0= rulePipeline
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
    // InternalIntegrate.g:326:1: entryRulePipeline returns [EObject current=null] : iv_rulePipeline= rulePipeline EOF ;
    public final EObject entryRulePipeline() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipeline = null;


        try {
            // InternalIntegrate.g:326:49: (iv_rulePipeline= rulePipeline EOF )
            // InternalIntegrate.g:327:2: iv_rulePipeline= rulePipeline EOF
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
    // InternalIntegrate.g:333:1: rulePipeline returns [EObject current=null] : ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* ) ;
    public final EObject rulePipeline() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_first_0_1 = null;

        AntlrDatatypeRuleToken lv_first_0_2 = null;

        EObject lv_next_2_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:339:2: ( ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* ) )
            // InternalIntegrate.g:340:2: ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* )
            {
            // InternalIntegrate.g:340:2: ( ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )* )
            // InternalIntegrate.g:341:3: ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) ) (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )*
            {
            // InternalIntegrate.g:341:3: ( ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) ) )
            // InternalIntegrate.g:342:4: ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) )
            {
            // InternalIntegrate.g:342:4: ( (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg ) )
            // InternalIntegrate.g:343:5: (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg )
            {
            // InternalIntegrate.g:343:5: (lv_first_0_1= rulePipelineStageSrc | lv_first_0_2= rulePipelineStageTrg )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==22) ) {
                alt4=1;
            }
            else if ( (LA4_0==23) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalIntegrate.g:344:6: lv_first_0_1= rulePipelineStageSrc
                    {

                    						newCompositeNode(grammarAccess.getPipelineAccess().getFirstPipelineStageSrcParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_17);
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
                    // InternalIntegrate.g:360:6: lv_first_0_2= rulePipelineStageTrg
                    {

                    						newCompositeNode(grammarAccess.getPipelineAccess().getFirstPipelineStageTrgParserRuleCall_0_0_1());
                    					
                    pushFollow(FOLLOW_17);
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

            // InternalIntegrate.g:378:3: (otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==21) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalIntegrate.g:379:4: otherlv_1= '|' ( (lv_next_2_0= rulePipelineStage ) )
            	    {
            	    otherlv_1=(Token)match(input,21,FOLLOW_18); 

            	    				newLeafNode(otherlv_1, grammarAccess.getPipelineAccess().getVerticalLineKeyword_1_0());
            	    			
            	    // InternalIntegrate.g:383:4: ( (lv_next_2_0= rulePipelineStage ) )
            	    // InternalIntegrate.g:384:5: (lv_next_2_0= rulePipelineStage )
            	    {
            	    // InternalIntegrate.g:384:5: (lv_next_2_0= rulePipelineStage )
            	    // InternalIntegrate.g:385:6: lv_next_2_0= rulePipelineStage
            	    {

            	    						newCompositeNode(grammarAccess.getPipelineAccess().getNextPipelineStageParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_17);
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
    // InternalIntegrate.g:407:1: entryRulePipelineStageSrc returns [String current=null] : iv_rulePipelineStageSrc= rulePipelineStageSrc EOF ;
    public final String entryRulePipelineStageSrc() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePipelineStageSrc = null;


        try {
            // InternalIntegrate.g:407:56: (iv_rulePipelineStageSrc= rulePipelineStageSrc EOF )
            // InternalIntegrate.g:408:2: iv_rulePipelineStageSrc= rulePipelineStageSrc EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageSrcRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageSrc=rulePipelineStageSrc();

            state._fsp--;

             current =iv_rulePipelineStageSrc.getText(); 
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
    // InternalIntegrate.g:414:1: rulePipelineStageSrc returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '#src' ;
    public final AntlrDatatypeRuleToken rulePipelineStageSrc() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIntegrate.g:420:2: (kw= '#src' )
            // InternalIntegrate.g:421:2: kw= '#src'
            {
            kw=(Token)match(input,22,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPipelineStageSrcAccess().getSrcKeyword());
            	

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
    // InternalIntegrate.g:429:1: entryRulePipelineStageTrg returns [String current=null] : iv_rulePipelineStageTrg= rulePipelineStageTrg EOF ;
    public final String entryRulePipelineStageTrg() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePipelineStageTrg = null;


        try {
            // InternalIntegrate.g:429:56: (iv_rulePipelineStageTrg= rulePipelineStageTrg EOF )
            // InternalIntegrate.g:430:2: iv_rulePipelineStageTrg= rulePipelineStageTrg EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageTrgRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageTrg=rulePipelineStageTrg();

            state._fsp--;

             current =iv_rulePipelineStageTrg.getText(); 
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
    // InternalIntegrate.g:436:1: rulePipelineStageTrg returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '#trg' ;
    public final AntlrDatatypeRuleToken rulePipelineStageTrg() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIntegrate.g:442:2: (kw= '#trg' )
            // InternalIntegrate.g:443:2: kw= '#trg'
            {
            kw=(Token)match(input,23,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPipelineStageTrgAccess().getTrgKeyword());
            	

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
    // InternalIntegrate.g:451:1: entryRulePipelineStage returns [EObject current=null] : iv_rulePipelineStage= rulePipelineStage EOF ;
    public final EObject entryRulePipelineStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStage = null;


        try {
            // InternalIntegrate.g:451:54: (iv_rulePipelineStage= rulePipelineStage EOF )
            // InternalIntegrate.g:452:2: iv_rulePipelineStage= rulePipelineStage EOF
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
    // InternalIntegrate.g:458:1: rulePipelineStage returns [EObject current=null] : (this_PipelineFilterStage_0= rulePipelineFilterStage | ( () rulePipelineCountStage ) ) ;
    public final EObject rulePipelineStage() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineFilterStage_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:464:2: ( (this_PipelineFilterStage_0= rulePipelineFilterStage | ( () rulePipelineCountStage ) ) )
            // InternalIntegrate.g:465:2: (this_PipelineFilterStage_0= rulePipelineFilterStage | ( () rulePipelineCountStage ) )
            {
            // InternalIntegrate.g:465:2: (this_PipelineFilterStage_0= rulePipelineFilterStage | ( () rulePipelineCountStage ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=24 && LA6_0<=26)) ) {
                alt6=1;
            }
            else if ( (LA6_0==27) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalIntegrate.g:466:3: this_PipelineFilterStage_0= rulePipelineFilterStage
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
                    // InternalIntegrate.g:475:3: ( () rulePipelineCountStage )
                    {
                    // InternalIntegrate.g:475:3: ( () rulePipelineCountStage )
                    // InternalIntegrate.g:476:4: () rulePipelineCountStage
                    {
                    // InternalIntegrate.g:476:4: ()
                    // InternalIntegrate.g:477:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPipelineStageAccess().getPipelineStageAction_1_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getPipelineStageAccess().getPipelineCountStageParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    rulePipelineCountStage();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


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
    // InternalIntegrate.g:495:1: entryRulePipelineFilterStage returns [EObject current=null] : iv_rulePipelineFilterStage= rulePipelineFilterStage EOF ;
    public final EObject entryRulePipelineFilterStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineFilterStage = null;


        try {
            // InternalIntegrate.g:495:60: (iv_rulePipelineFilterStage= rulePipelineFilterStage EOF )
            // InternalIntegrate.g:496:2: iv_rulePipelineFilterStage= rulePipelineFilterStage EOF
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
    // InternalIntegrate.g:502:1: rulePipelineFilterStage returns [EObject current=null] : ( ( () rulePipelineCreatedFilterStage ) | ( () rulePipelineDeletedFilterStage ) | this_PipelineTypeFilterStage_4= rulePipelineTypeFilterStage ) ;
    public final EObject rulePipelineFilterStage() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineTypeFilterStage_4 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:508:2: ( ( ( () rulePipelineCreatedFilterStage ) | ( () rulePipelineDeletedFilterStage ) | this_PipelineTypeFilterStage_4= rulePipelineTypeFilterStage ) )
            // InternalIntegrate.g:509:2: ( ( () rulePipelineCreatedFilterStage ) | ( () rulePipelineDeletedFilterStage ) | this_PipelineTypeFilterStage_4= rulePipelineTypeFilterStage )
            {
            // InternalIntegrate.g:509:2: ( ( () rulePipelineCreatedFilterStage ) | ( () rulePipelineDeletedFilterStage ) | this_PipelineTypeFilterStage_4= rulePipelineTypeFilterStage )
            int alt7=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt7=1;
                }
                break;
            case 25:
                {
                alt7=2;
                }
                break;
            case 26:
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
                    // InternalIntegrate.g:510:3: ( () rulePipelineCreatedFilterStage )
                    {
                    // InternalIntegrate.g:510:3: ( () rulePipelineCreatedFilterStage )
                    // InternalIntegrate.g:511:4: () rulePipelineCreatedFilterStage
                    {
                    // InternalIntegrate.g:511:4: ()
                    // InternalIntegrate.g:512:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPipelineFilterStageAccess().getPipelineFilterStageAction_0_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getPipelineFilterStageAccess().getPipelineCreatedFilterStageParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_2);
                    rulePipelineCreatedFilterStage();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:527:3: ( () rulePipelineDeletedFilterStage )
                    {
                    // InternalIntegrate.g:527:3: ( () rulePipelineDeletedFilterStage )
                    // InternalIntegrate.g:528:4: () rulePipelineDeletedFilterStage
                    {
                    // InternalIntegrate.g:528:4: ()
                    // InternalIntegrate.g:529:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getPipelineFilterStageAccess().getPipelineFilterStageAction_1_0(),
                    						current);
                    				

                    }


                    				newCompositeNode(grammarAccess.getPipelineFilterStageAccess().getPipelineDeletedFilterStageParserRuleCall_1_1());
                    			
                    pushFollow(FOLLOW_2);
                    rulePipelineDeletedFilterStage();

                    state._fsp--;


                    				afterParserOrEnumRuleCall();
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:544:3: this_PipelineTypeFilterStage_4= rulePipelineTypeFilterStage
                    {

                    			newCompositeNode(grammarAccess.getPipelineFilterStageAccess().getPipelineTypeFilterStageParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineTypeFilterStage_4=rulePipelineTypeFilterStage();

                    state._fsp--;


                    			current = this_PipelineTypeFilterStage_4;
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
    // InternalIntegrate.g:556:1: entryRulePipelineCreatedFilterStage returns [String current=null] : iv_rulePipelineCreatedFilterStage= rulePipelineCreatedFilterStage EOF ;
    public final String entryRulePipelineCreatedFilterStage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePipelineCreatedFilterStage = null;


        try {
            // InternalIntegrate.g:556:66: (iv_rulePipelineCreatedFilterStage= rulePipelineCreatedFilterStage EOF )
            // InternalIntegrate.g:557:2: iv_rulePipelineCreatedFilterStage= rulePipelineCreatedFilterStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineCreatedFilterStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineCreatedFilterStage=rulePipelineCreatedFilterStage();

            state._fsp--;

             current =iv_rulePipelineCreatedFilterStage.getText(); 
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
    // InternalIntegrate.g:563:1: rulePipelineCreatedFilterStage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'created' ;
    public final AntlrDatatypeRuleToken rulePipelineCreatedFilterStage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIntegrate.g:569:2: (kw= 'created' )
            // InternalIntegrate.g:570:2: kw= 'created'
            {
            kw=(Token)match(input,24,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPipelineCreatedFilterStageAccess().getCreatedKeyword());
            	

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
    // InternalIntegrate.g:578:1: entryRulePipelineDeletedFilterStage returns [String current=null] : iv_rulePipelineDeletedFilterStage= rulePipelineDeletedFilterStage EOF ;
    public final String entryRulePipelineDeletedFilterStage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePipelineDeletedFilterStage = null;


        try {
            // InternalIntegrate.g:578:66: (iv_rulePipelineDeletedFilterStage= rulePipelineDeletedFilterStage EOF )
            // InternalIntegrate.g:579:2: iv_rulePipelineDeletedFilterStage= rulePipelineDeletedFilterStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineDeletedFilterStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineDeletedFilterStage=rulePipelineDeletedFilterStage();

            state._fsp--;

             current =iv_rulePipelineDeletedFilterStage.getText(); 
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
    // InternalIntegrate.g:585:1: rulePipelineDeletedFilterStage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'deleted' ;
    public final AntlrDatatypeRuleToken rulePipelineDeletedFilterStage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIntegrate.g:591:2: (kw= 'deleted' )
            // InternalIntegrate.g:592:2: kw= 'deleted'
            {
            kw=(Token)match(input,25,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPipelineDeletedFilterStageAccess().getDeletedKeyword());
            	

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
    // InternalIntegrate.g:600:1: entryRulePipelineTypeFilterStage returns [EObject current=null] : iv_rulePipelineTypeFilterStage= rulePipelineTypeFilterStage EOF ;
    public final EObject entryRulePipelineTypeFilterStage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineTypeFilterStage = null;


        try {
            // InternalIntegrate.g:600:64: (iv_rulePipelineTypeFilterStage= rulePipelineTypeFilterStage EOF )
            // InternalIntegrate.g:601:2: iv_rulePipelineTypeFilterStage= rulePipelineTypeFilterStage EOF
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
    // InternalIntegrate.g:607:1: rulePipelineTypeFilterStage returns [EObject current=null] : (otherlv_0= 'type' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject rulePipelineTypeFilterStage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalIntegrate.g:613:2: ( (otherlv_0= 'type' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalIntegrate.g:614:2: (otherlv_0= 'type' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalIntegrate.g:614:2: (otherlv_0= 'type' ( (otherlv_1= RULE_ID ) ) )
            // InternalIntegrate.g:615:3: otherlv_0= 'type' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_14); 

            			newLeafNode(otherlv_0, grammarAccess.getPipelineTypeFilterStageAccess().getTypeKeyword_0());
            		
            // InternalIntegrate.g:619:3: ( (otherlv_1= RULE_ID ) )
            // InternalIntegrate.g:620:4: (otherlv_1= RULE_ID )
            {
            // InternalIntegrate.g:620:4: (otherlv_1= RULE_ID )
            // InternalIntegrate.g:621:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineTypeFilterStageRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getPipelineTypeFilterStageAccess().getTypesEClassifierCrossReference_1_0());
            				

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
    // InternalIntegrate.g:636:1: entryRulePipelineCountStage returns [String current=null] : iv_rulePipelineCountStage= rulePipelineCountStage EOF ;
    public final String entryRulePipelineCountStage() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePipelineCountStage = null;


        try {
            // InternalIntegrate.g:636:58: (iv_rulePipelineCountStage= rulePipelineCountStage EOF )
            // InternalIntegrate.g:637:2: iv_rulePipelineCountStage= rulePipelineCountStage EOF
            {
             newCompositeNode(grammarAccess.getPipelineCountStageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineCountStage=rulePipelineCountStage();

            state._fsp--;

             current =iv_rulePipelineCountStage.getText(); 
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
    // InternalIntegrate.g:643:1: rulePipelineCountStage returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'count' ;
    public final AntlrDatatypeRuleToken rulePipelineCountStage() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalIntegrate.g:649:2: (kw= 'count' )
            // InternalIntegrate.g:650:2: kw= 'count'
            {
            kw=(Token)match(input,27,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getPipelineCountStageAccess().getCountKeyword());
            	

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
    // InternalIntegrate.g:658:1: entryRuleSatisfactionRule returns [EObject current=null] : iv_ruleSatisfactionRule= ruleSatisfactionRule EOF ;
    public final EObject entryRuleSatisfactionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSatisfactionRule = null;


        try {
            // InternalIntegrate.g:658:57: (iv_ruleSatisfactionRule= ruleSatisfactionRule EOF )
            // InternalIntegrate.g:659:2: iv_ruleSatisfactionRule= ruleSatisfactionRule EOF
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
    // InternalIntegrate.g:665:1: ruleSatisfactionRule returns [EObject current=null] : ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* ) ;
    public final EObject ruleSatisfactionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_firstRule_0_0 = null;

        EObject lv_otherRules_1_1 = null;

        EObject lv_otherRules_1_2 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:671:2: ( ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* ) )
            // InternalIntegrate.g:672:2: ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* )
            {
            // InternalIntegrate.g:672:2: ( ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )* )
            // InternalIntegrate.g:673:3: ( (lv_firstRule_0_0= ruleComparison ) ) ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )*
            {
            // InternalIntegrate.g:673:3: ( (lv_firstRule_0_0= ruleComparison ) )
            // InternalIntegrate.g:674:4: (lv_firstRule_0_0= ruleComparison )
            {
            // InternalIntegrate.g:674:4: (lv_firstRule_0_0= ruleComparison )
            // InternalIntegrate.g:675:5: lv_firstRule_0_0= ruleComparison
            {

            					newCompositeNode(grammarAccess.getSatisfactionRuleAccess().getFirstRuleComparisonParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_19);
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

            // InternalIntegrate.g:692:3: ( ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=28 && LA9_0<=29)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIntegrate.g:693:4: ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) )
            	    {
            	    // InternalIntegrate.g:693:4: ( (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr ) )
            	    // InternalIntegrate.g:694:5: (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr )
            	    {
            	    // InternalIntegrate.g:694:5: (lv_otherRules_1_1= ruleAnd | lv_otherRules_1_2= ruleOr )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( (LA8_0==28) ) {
            	        alt8=1;
            	    }
            	    else if ( (LA8_0==29) ) {
            	        alt8=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // InternalIntegrate.g:695:6: lv_otherRules_1_1= ruleAnd
            	            {

            	            						newCompositeNode(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAndParserRuleCall_1_0_0());
            	            					
            	            pushFollow(FOLLOW_19);
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
            	            // InternalIntegrate.g:711:6: lv_otherRules_1_2= ruleOr
            	            {

            	            						newCompositeNode(grammarAccess.getSatisfactionRuleAccess().getOtherRulesOrParserRuleCall_1_0_1());
            	            					
            	            pushFollow(FOLLOW_19);
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
    // InternalIntegrate.g:733:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalIntegrate.g:733:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalIntegrate.g:734:2: iv_ruleAnd= ruleAnd EOF
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
    // InternalIntegrate.g:740:1: ruleAnd returns [EObject current=null] : (otherlv_0= 'and' this_Comparison_1= ruleComparison ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Comparison_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:746:2: ( (otherlv_0= 'and' this_Comparison_1= ruleComparison ) )
            // InternalIntegrate.g:747:2: (otherlv_0= 'and' this_Comparison_1= ruleComparison )
            {
            // InternalIntegrate.g:747:2: (otherlv_0= 'and' this_Comparison_1= ruleComparison )
            // InternalIntegrate.g:748:3: otherlv_0= 'and' this_Comparison_1= ruleComparison
            {
            otherlv_0=(Token)match(input,28,FOLLOW_12); 

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
    // InternalIntegrate.g:764:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalIntegrate.g:764:43: (iv_ruleOr= ruleOr EOF )
            // InternalIntegrate.g:765:2: iv_ruleOr= ruleOr EOF
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
    // InternalIntegrate.g:771:1: ruleOr returns [EObject current=null] : (otherlv_0= 'or' this_Comparison_1= ruleComparison ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Comparison_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:777:2: ( (otherlv_0= 'or' this_Comparison_1= ruleComparison ) )
            // InternalIntegrate.g:778:2: (otherlv_0= 'or' this_Comparison_1= ruleComparison )
            {
            // InternalIntegrate.g:778:2: (otherlv_0= 'or' this_Comparison_1= ruleComparison )
            // InternalIntegrate.g:779:3: otherlv_0= 'or' this_Comparison_1= ruleComparison
            {
            otherlv_0=(Token)match(input,29,FOLLOW_12); 

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
    // InternalIntegrate.g:795:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalIntegrate.g:795:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalIntegrate.g:796:2: iv_ruleComparison= ruleComparison EOF
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
    // InternalIntegrate.g:802:1: ruleComparison returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) ) ;
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
            // InternalIntegrate.g:808:2: ( ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) ) )
            // InternalIntegrate.g:809:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) )
            {
            // InternalIntegrate.g:809:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) ) )
            // InternalIntegrate.g:810:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) ) ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) ) ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) )
            {
            // InternalIntegrate.g:810:3: ( ( (otherlv_0= RULE_ID ) ) | ( (lv_n1_1_0= RULE_INT ) ) )
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
                    // InternalIntegrate.g:811:4: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalIntegrate.g:811:4: ( (otherlv_0= RULE_ID ) )
                    // InternalIntegrate.g:812:5: (otherlv_0= RULE_ID )
                    {
                    // InternalIntegrate.g:812:5: (otherlv_0= RULE_ID )
                    // InternalIntegrate.g:813:6: otherlv_0= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    					
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_20); 

                    						newLeafNode(otherlv_0, grammarAccess.getComparisonAccess().getV1VariableCrossReference_0_0_0());
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:825:4: ( (lv_n1_1_0= RULE_INT ) )
                    {
                    // InternalIntegrate.g:825:4: ( (lv_n1_1_0= RULE_INT ) )
                    // InternalIntegrate.g:826:5: (lv_n1_1_0= RULE_INT )
                    {
                    // InternalIntegrate.g:826:5: (lv_n1_1_0= RULE_INT )
                    // InternalIntegrate.g:827:6: lv_n1_1_0= RULE_INT
                    {
                    lv_n1_1_0=(Token)match(input,RULE_INT,FOLLOW_20); 

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

            // InternalIntegrate.g:844:3: ( ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) ) )
            // InternalIntegrate.g:845:4: ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) )
            {
            // InternalIntegrate.g:845:4: ( (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' ) )
            // InternalIntegrate.g:846:5: (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' )
            {
            // InternalIntegrate.g:846:5: (lv_c1_2_1= '>' | lv_c1_2_2= '>=' | lv_c1_2_3= '<' | lv_c1_2_4= '<=' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt11=1;
                }
                break;
            case 31:
                {
                alt11=2;
                }
                break;
            case 32:
                {
                alt11=3;
                }
                break;
            case 33:
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
                    // InternalIntegrate.g:847:6: lv_c1_2_1= '>'
                    {
                    lv_c1_2_1=(Token)match(input,30,FOLLOW_12); 

                    						newLeafNode(lv_c1_2_1, grammarAccess.getComparisonAccess().getC1GreaterThanSignKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(current, "c1", lv_c1_2_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:858:6: lv_c1_2_2= '>='
                    {
                    lv_c1_2_2=(Token)match(input,31,FOLLOW_12); 

                    						newLeafNode(lv_c1_2_2, grammarAccess.getComparisonAccess().getC1GreaterThanSignEqualsSignKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(current, "c1", lv_c1_2_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:869:6: lv_c1_2_3= '<'
                    {
                    lv_c1_2_3=(Token)match(input,32,FOLLOW_12); 

                    						newLeafNode(lv_c1_2_3, grammarAccess.getComparisonAccess().getC1LessThanSignKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonRule());
                    						}
                    						setWithLastConsumed(current, "c1", lv_c1_2_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:880:6: lv_c1_2_4= '<='
                    {
                    lv_c1_2_4=(Token)match(input,33,FOLLOW_12); 

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

            // InternalIntegrate.g:893:3: ( ( (otherlv_3= RULE_ID ) ) | ( (lv_n2_4_0= RULE_INT ) ) )
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
                    // InternalIntegrate.g:894:4: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalIntegrate.g:894:4: ( (otherlv_3= RULE_ID ) )
                    // InternalIntegrate.g:895:5: (otherlv_3= RULE_ID )
                    {
                    // InternalIntegrate.g:895:5: (otherlv_3= RULE_ID )
                    // InternalIntegrate.g:896:6: otherlv_3= RULE_ID
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
                    // InternalIntegrate.g:908:4: ( (lv_n2_4_0= RULE_INT ) )
                    {
                    // InternalIntegrate.g:908:4: ( (lv_n2_4_0= RULE_INT ) )
                    // InternalIntegrate.g:909:5: (lv_n2_4_0= RULE_INT )
                    {
                    // InternalIntegrate.g:909:5: (lv_n2_4_0= RULE_INT )
                    // InternalIntegrate.g:910:6: lv_n2_4_0= RULE_INT
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
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x000000000F000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000003C0000000L});

}