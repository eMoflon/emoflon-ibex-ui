package org.emoflon.ibex.gt.editor.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.emoflon.ibex.gt.editor.services.GTGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGTParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'abstract'", "'('", "','", "')'", "'refines'", "'{'", "'}'", "'when'", "'||'", "'@'", "':'", "'local'", "'#'", "'.'", "':='", "'count'", "'true'", "'false'", "'-'", "'enum::'", "'param::'", "'->'", "'forEach'", "'<'", "'>'", "'iterator::'", "'condition'", "'='", "'&&'", "'^'", "'pattern'", "'rule'", "'$context'", "'++'", "'--'", "'>='", "'=='", "'!='", "'<='", "'enforce'", "'forbid'", "'+'", "'N'", "'U'", "'Exp'", "'*'", "'/'", "'%'", "'min'", "'max'", "'sqrt'", "'abs'", "'sin'", "'cos'", "'tan'", "'exp'", "'log'", "'ln'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalGTParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalGTParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalGTParser.tokenNames; }
    public String getGrammarFileName() { return "InternalGT.g"; }



     	private GTGrammarAccess grammarAccess;

        public InternalGTParser(TokenStream input, GTGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "EditorGTFile";
       	}

       	@Override
       	protected GTGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleEditorGTFile"
    // InternalGT.g:65:1: entryRuleEditorGTFile returns [EObject current=null] : iv_ruleEditorGTFile= ruleEditorGTFile EOF ;
    public final EObject entryRuleEditorGTFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorGTFile = null;


        try {
            // InternalGT.g:65:53: (iv_ruleEditorGTFile= ruleEditorGTFile EOF )
            // InternalGT.g:66:2: iv_ruleEditorGTFile= ruleEditorGTFile EOF
            {
             newCompositeNode(grammarAccess.getEditorGTFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorGTFile=ruleEditorGTFile();

            state._fsp--;

             current =iv_ruleEditorGTFile; 
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
    // $ANTLR end "entryRuleEditorGTFile"


    // $ANTLR start "ruleEditorGTFile"
    // InternalGT.g:72:1: ruleEditorGTFile returns [EObject current=null] : ( ( (lv_imports_0_0= ruleEditorImport ) )* ( ( (lv_patterns_1_0= ruleEditorPattern ) ) | ( (lv_conditions_2_0= ruleEditorCondition ) ) )* ) ;
    public final EObject ruleEditorGTFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_patterns_1_0 = null;

        EObject lv_conditions_2_0 = null;



        	enterRule();

        try {
            // InternalGT.g:78:2: ( ( ( (lv_imports_0_0= ruleEditorImport ) )* ( ( (lv_patterns_1_0= ruleEditorPattern ) ) | ( (lv_conditions_2_0= ruleEditorCondition ) ) )* ) )
            // InternalGT.g:79:2: ( ( (lv_imports_0_0= ruleEditorImport ) )* ( ( (lv_patterns_1_0= ruleEditorPattern ) ) | ( (lv_conditions_2_0= ruleEditorCondition ) ) )* )
            {
            // InternalGT.g:79:2: ( ( (lv_imports_0_0= ruleEditorImport ) )* ( ( (lv_patterns_1_0= ruleEditorPattern ) ) | ( (lv_conditions_2_0= ruleEditorCondition ) ) )* )
            // InternalGT.g:80:3: ( (lv_imports_0_0= ruleEditorImport ) )* ( ( (lv_patterns_1_0= ruleEditorPattern ) ) | ( (lv_conditions_2_0= ruleEditorCondition ) ) )*
            {
            // InternalGT.g:80:3: ( (lv_imports_0_0= ruleEditorImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalGT.g:81:4: (lv_imports_0_0= ruleEditorImport )
            	    {
            	    // InternalGT.g:81:4: (lv_imports_0_0= ruleEditorImport )
            	    // InternalGT.g:82:5: lv_imports_0_0= ruleEditorImport
            	    {

            	    					newCompositeNode(grammarAccess.getEditorGTFileAccess().getImportsEditorImportParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleEditorImport();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEditorGTFileRule());
            	    					}
            	    					add(
            	    						current,
            	    						"imports",
            	    						lv_imports_0_0,
            	    						"org.emoflon.ibex.gt.editor.GT.EditorImport");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalGT.g:99:3: ( ( (lv_patterns_1_0= ruleEditorPattern ) ) | ( (lv_conditions_2_0= ruleEditorCondition ) ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==12||(LA2_0>=42 && LA2_0<=43)) ) {
                    alt2=1;
                }
                else if ( (LA2_0==38) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalGT.g:100:4: ( (lv_patterns_1_0= ruleEditorPattern ) )
            	    {
            	    // InternalGT.g:100:4: ( (lv_patterns_1_0= ruleEditorPattern ) )
            	    // InternalGT.g:101:5: (lv_patterns_1_0= ruleEditorPattern )
            	    {
            	    // InternalGT.g:101:5: (lv_patterns_1_0= ruleEditorPattern )
            	    // InternalGT.g:102:6: lv_patterns_1_0= ruleEditorPattern
            	    {

            	    						newCompositeNode(grammarAccess.getEditorGTFileAccess().getPatternsEditorPatternParserRuleCall_1_0_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_patterns_1_0=ruleEditorPattern();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEditorGTFileRule());
            	    						}
            	    						add(
            	    							current,
            	    							"patterns",
            	    							lv_patterns_1_0,
            	    							"org.emoflon.ibex.gt.editor.GT.EditorPattern");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGT.g:120:4: ( (lv_conditions_2_0= ruleEditorCondition ) )
            	    {
            	    // InternalGT.g:120:4: ( (lv_conditions_2_0= ruleEditorCondition ) )
            	    // InternalGT.g:121:5: (lv_conditions_2_0= ruleEditorCondition )
            	    {
            	    // InternalGT.g:121:5: (lv_conditions_2_0= ruleEditorCondition )
            	    // InternalGT.g:122:6: lv_conditions_2_0= ruleEditorCondition
            	    {

            	    						newCompositeNode(grammarAccess.getEditorGTFileAccess().getConditionsEditorConditionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_4);
            	    lv_conditions_2_0=ruleEditorCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEditorGTFileRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conditions",
            	    							lv_conditions_2_0,
            	    							"org.emoflon.ibex.gt.editor.GT.EditorCondition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


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
    // $ANTLR end "ruleEditorGTFile"


    // $ANTLR start "entryRuleEditorImport"
    // InternalGT.g:144:1: entryRuleEditorImport returns [EObject current=null] : iv_ruleEditorImport= ruleEditorImport EOF ;
    public final EObject entryRuleEditorImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorImport = null;


        try {
            // InternalGT.g:144:53: (iv_ruleEditorImport= ruleEditorImport EOF )
            // InternalGT.g:145:2: iv_ruleEditorImport= ruleEditorImport EOF
            {
             newCompositeNode(grammarAccess.getEditorImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorImport=ruleEditorImport();

            state._fsp--;

             current =iv_ruleEditorImport; 
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
    // $ANTLR end "entryRuleEditorImport"


    // $ANTLR start "ruleEditorImport"
    // InternalGT.g:151:1: ruleEditorImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleEditorImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalGT.g:157:2: ( (otherlv_0= 'import' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalGT.g:158:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalGT.g:158:2: (otherlv_0= 'import' ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalGT.g:159:3: otherlv_0= 'import' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorImportAccess().getImportKeyword_0());
            		
            // InternalGT.g:163:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalGT.g:164:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalGT.g:164:4: (lv_name_1_0= RULE_STRING )
            // InternalGT.g:165:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEditorImportAccess().getNameSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorImportRule());
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
    // $ANTLR end "ruleEditorImport"


    // $ANTLR start "entryRuleEditorPattern"
    // InternalGT.g:185:1: entryRuleEditorPattern returns [EObject current=null] : iv_ruleEditorPattern= ruleEditorPattern EOF ;
    public final EObject entryRuleEditorPattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorPattern = null;


        try {
            // InternalGT.g:185:54: (iv_ruleEditorPattern= ruleEditorPattern EOF )
            // InternalGT.g:186:2: iv_ruleEditorPattern= ruleEditorPattern EOF
            {
             newCompositeNode(grammarAccess.getEditorPatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorPattern=ruleEditorPattern();

            state._fsp--;

             current =iv_ruleEditorPattern; 
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
    // $ANTLR end "entryRuleEditorPattern"


    // $ANTLR start "ruleEditorPattern"
    // InternalGT.g:192:1: ruleEditorPattern returns [EObject current=null] : ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_type_1_0= ruleEditorPatternType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )? otherlv_7= ')' )? (otherlv_8= 'refines' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )* otherlv_15= '}' )? (otherlv_16= 'when' ( (otherlv_17= RULE_ID ) ) (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_stochastic_20_0= '@' ) ) ( (lv_probability_21_0= ruleEditorProbability ) ) )? ) ;
    public final EObject ruleEditorPattern() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token lv_stochastic_20_0=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_nodes_13_0 = null;

        EObject lv_attributeConstraints_14_0 = null;

        EObject lv_probability_21_0 = null;



        	enterRule();

        try {
            // InternalGT.g:198:2: ( ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_type_1_0= ruleEditorPatternType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )? otherlv_7= ')' )? (otherlv_8= 'refines' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )* otherlv_15= '}' )? (otherlv_16= 'when' ( (otherlv_17= RULE_ID ) ) (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_stochastic_20_0= '@' ) ) ( (lv_probability_21_0= ruleEditorProbability ) ) )? ) )
            // InternalGT.g:199:2: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_type_1_0= ruleEditorPatternType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )? otherlv_7= ')' )? (otherlv_8= 'refines' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )* otherlv_15= '}' )? (otherlv_16= 'when' ( (otherlv_17= RULE_ID ) ) (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_stochastic_20_0= '@' ) ) ( (lv_probability_21_0= ruleEditorProbability ) ) )? )
            {
            // InternalGT.g:199:2: ( ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_type_1_0= ruleEditorPatternType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )? otherlv_7= ')' )? (otherlv_8= 'refines' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )* otherlv_15= '}' )? (otherlv_16= 'when' ( (otherlv_17= RULE_ID ) ) (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_stochastic_20_0= '@' ) ) ( (lv_probability_21_0= ruleEditorProbability ) ) )? )
            // InternalGT.g:200:3: ( (lv_abstract_0_0= 'abstract' ) )? ( (lv_type_1_0= ruleEditorPatternType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '(' ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )? otherlv_7= ')' )? (otherlv_8= 'refines' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? (otherlv_12= '{' ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )* otherlv_15= '}' )? (otherlv_16= 'when' ( (otherlv_17= RULE_ID ) ) (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )* )? ( ( (lv_stochastic_20_0= '@' ) ) ( (lv_probability_21_0= ruleEditorProbability ) ) )?
            {
            // InternalGT.g:200:3: ( (lv_abstract_0_0= 'abstract' ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalGT.g:201:4: (lv_abstract_0_0= 'abstract' )
                    {
                    // InternalGT.g:201:4: (lv_abstract_0_0= 'abstract' )
                    // InternalGT.g:202:5: lv_abstract_0_0= 'abstract'
                    {
                    lv_abstract_0_0=(Token)match(input,12,FOLLOW_6); 

                    					newLeafNode(lv_abstract_0_0, grammarAccess.getEditorPatternAccess().getAbstractAbstractKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEditorPatternRule());
                    					}
                    					setWithLastConsumed(current, "abstract", lv_abstract_0_0 != null, "abstract");
                    				

                    }


                    }
                    break;

            }

            // InternalGT.g:214:3: ( (lv_type_1_0= ruleEditorPatternType ) )
            // InternalGT.g:215:4: (lv_type_1_0= ruleEditorPatternType )
            {
            // InternalGT.g:215:4: (lv_type_1_0= ruleEditorPatternType )
            // InternalGT.g:216:5: lv_type_1_0= ruleEditorPatternType
            {

            					newCompositeNode(grammarAccess.getEditorPatternAccess().getTypeEditorPatternTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_7);
            lv_type_1_0=ruleEditorPatternType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorPatternRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorPatternType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGT.g:233:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalGT.g:234:4: (lv_name_2_0= RULE_ID )
            {
            // InternalGT.g:234:4: (lv_name_2_0= RULE_ID )
            // InternalGT.g:235:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_2_0, grammarAccess.getEditorPatternAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorPatternRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalGT.g:251:3: (otherlv_3= '(' ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )? otherlv_7= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalGT.g:252:4: otherlv_3= '(' ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )? otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_9); 

                    				newLeafNode(otherlv_3, grammarAccess.getEditorPatternAccess().getLeftParenthesisKeyword_3_0());
                    			
                    // InternalGT.g:256:4: ( ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )* )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==RULE_ID) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // InternalGT.g:257:5: ( (lv_parameters_4_0= ruleEditorParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )*
                            {
                            // InternalGT.g:257:5: ( (lv_parameters_4_0= ruleEditorParameter ) )
                            // InternalGT.g:258:6: (lv_parameters_4_0= ruleEditorParameter )
                            {
                            // InternalGT.g:258:6: (lv_parameters_4_0= ruleEditorParameter )
                            // InternalGT.g:259:7: lv_parameters_4_0= ruleEditorParameter
                            {

                            							newCompositeNode(grammarAccess.getEditorPatternAccess().getParametersEditorParameterParserRuleCall_3_1_0_0());
                            						
                            pushFollow(FOLLOW_10);
                            lv_parameters_4_0=ruleEditorParameter();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getEditorPatternRule());
                            							}
                            							add(
                            								current,
                            								"parameters",
                            								lv_parameters_4_0,
                            								"org.emoflon.ibex.gt.editor.GT.EditorParameter");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalGT.g:276:5: (otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) ) )*
                            loop4:
                            do {
                                int alt4=2;
                                int LA4_0 = input.LA(1);

                                if ( (LA4_0==14) ) {
                                    alt4=1;
                                }


                                switch (alt4) {
                            	case 1 :
                            	    // InternalGT.g:277:6: otherlv_5= ',' ( (lv_parameters_6_0= ruleEditorParameter ) )
                            	    {
                            	    otherlv_5=(Token)match(input,14,FOLLOW_7); 

                            	    						newLeafNode(otherlv_5, grammarAccess.getEditorPatternAccess().getCommaKeyword_3_1_1_0());
                            	    					
                            	    // InternalGT.g:281:6: ( (lv_parameters_6_0= ruleEditorParameter ) )
                            	    // InternalGT.g:282:7: (lv_parameters_6_0= ruleEditorParameter )
                            	    {
                            	    // InternalGT.g:282:7: (lv_parameters_6_0= ruleEditorParameter )
                            	    // InternalGT.g:283:8: lv_parameters_6_0= ruleEditorParameter
                            	    {

                            	    								newCompositeNode(grammarAccess.getEditorPatternAccess().getParametersEditorParameterParserRuleCall_3_1_1_1_0());
                            	    							
                            	    pushFollow(FOLLOW_10);
                            	    lv_parameters_6_0=ruleEditorParameter();

                            	    state._fsp--;


                            	    								if (current==null) {
                            	    									current = createModelElementForParent(grammarAccess.getEditorPatternRule());
                            	    								}
                            	    								add(
                            	    									current,
                            	    									"parameters",
                            	    									lv_parameters_6_0,
                            	    									"org.emoflon.ibex.gt.editor.GT.EditorParameter");
                            	    								afterParserOrEnumRuleCall();
                            	    							

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop4;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,15,FOLLOW_11); 

                    				newLeafNode(otherlv_7, grammarAccess.getEditorPatternAccess().getRightParenthesisKeyword_3_2());
                    			

                    }
                    break;

            }

            // InternalGT.g:307:3: (otherlv_8= 'refines' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalGT.g:308:4: otherlv_8= 'refines' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_7); 

                    				newLeafNode(otherlv_8, grammarAccess.getEditorPatternAccess().getRefinesKeyword_4_0());
                    			
                    // InternalGT.g:312:4: ( (otherlv_9= RULE_ID ) )
                    // InternalGT.g:313:5: (otherlv_9= RULE_ID )
                    {
                    // InternalGT.g:313:5: (otherlv_9= RULE_ID )
                    // InternalGT.g:314:6: otherlv_9= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEditorPatternRule());
                    						}
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_12); 

                    						newLeafNode(otherlv_9, grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternCrossReference_4_1_0());
                    					

                    }


                    }

                    // InternalGT.g:325:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==14) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalGT.g:326:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,14,FOLLOW_7); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getEditorPatternAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalGT.g:330:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalGT.g:331:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalGT.g:331:6: (otherlv_11= RULE_ID )
                    	    // InternalGT.g:332:7: otherlv_11= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getEditorPatternRule());
                    	    							}
                    	    						
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_12); 

                    	    							newLeafNode(otherlv_11, grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternCrossReference_4_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGT.g:345:3: (otherlv_12= '{' ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )* otherlv_15= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalGT.g:346:4: otherlv_12= '{' ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )* otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,17,FOLLOW_13); 

                    				newLeafNode(otherlv_12, grammarAccess.getEditorPatternAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalGT.g:350:4: ( ( (lv_nodes_13_0= ruleEditorNode ) ) | ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) ) )*
                    loop9:
                    do {
                        int alt9=3;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID||LA9_0==23||(LA9_0>=44 && LA9_0<=46)) ) {
                            alt9=1;
                        }
                        else if ( (LA9_0==24) ) {
                            alt9=2;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalGT.g:351:5: ( (lv_nodes_13_0= ruleEditorNode ) )
                    	    {
                    	    // InternalGT.g:351:5: ( (lv_nodes_13_0= ruleEditorNode ) )
                    	    // InternalGT.g:352:6: (lv_nodes_13_0= ruleEditorNode )
                    	    {
                    	    // InternalGT.g:352:6: (lv_nodes_13_0= ruleEditorNode )
                    	    // InternalGT.g:353:7: lv_nodes_13_0= ruleEditorNode
                    	    {

                    	    							newCompositeNode(grammarAccess.getEditorPatternAccess().getNodesEditorNodeParserRuleCall_5_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_nodes_13_0=ruleEditorNode();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEditorPatternRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"nodes",
                    	    								lv_nodes_13_0,
                    	    								"org.emoflon.ibex.gt.editor.GT.EditorNode");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalGT.g:371:5: ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) )
                    	    {
                    	    // InternalGT.g:371:5: ( (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint ) )
                    	    // InternalGT.g:372:6: (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint )
                    	    {
                    	    // InternalGT.g:372:6: (lv_attributeConstraints_14_0= ruleEditorAttributeConstraint )
                    	    // InternalGT.g:373:7: lv_attributeConstraints_14_0= ruleEditorAttributeConstraint
                    	    {

                    	    							newCompositeNode(grammarAccess.getEditorPatternAccess().getAttributeConstraintsEditorAttributeConstraintParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_13);
                    	    lv_attributeConstraints_14_0=ruleEditorAttributeConstraint();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEditorPatternRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributeConstraints",
                    	    								lv_attributeConstraints_14_0,
                    	    								"org.emoflon.ibex.gt.editor.GT.EditorAttributeConstraint");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,18,FOLLOW_14); 

                    				newLeafNode(otherlv_15, grammarAccess.getEditorPatternAccess().getRightCurlyBracketKeyword_5_2());
                    			

                    }
                    break;

            }

            // InternalGT.g:396:3: (otherlv_16= 'when' ( (otherlv_17= RULE_ID ) ) (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalGT.g:397:4: otherlv_16= 'when' ( (otherlv_17= RULE_ID ) ) (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )*
                    {
                    otherlv_16=(Token)match(input,19,FOLLOW_7); 

                    				newLeafNode(otherlv_16, grammarAccess.getEditorPatternAccess().getWhenKeyword_6_0());
                    			
                    // InternalGT.g:401:4: ( (otherlv_17= RULE_ID ) )
                    // InternalGT.g:402:5: (otherlv_17= RULE_ID )
                    {
                    // InternalGT.g:402:5: (otherlv_17= RULE_ID )
                    // InternalGT.g:403:6: otherlv_17= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEditorPatternRule());
                    						}
                    					
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_15); 

                    						newLeafNode(otherlv_17, grammarAccess.getEditorPatternAccess().getConditionsEditorConditionCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalGT.g:414:4: (otherlv_18= '||' ( (otherlv_19= RULE_ID ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==20) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalGT.g:415:5: otherlv_18= '||' ( (otherlv_19= RULE_ID ) )
                    	    {
                    	    otherlv_18=(Token)match(input,20,FOLLOW_7); 

                    	    					newLeafNode(otherlv_18, grammarAccess.getEditorPatternAccess().getVerticalLineVerticalLineKeyword_6_2_0());
                    	    				
                    	    // InternalGT.g:419:5: ( (otherlv_19= RULE_ID ) )
                    	    // InternalGT.g:420:6: (otherlv_19= RULE_ID )
                    	    {
                    	    // InternalGT.g:420:6: (otherlv_19= RULE_ID )
                    	    // InternalGT.g:421:7: otherlv_19= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getEditorPatternRule());
                    	    							}
                    	    						
                    	    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_15); 

                    	    							newLeafNode(otherlv_19, grammarAccess.getEditorPatternAccess().getConditionsEditorConditionCrossReference_6_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalGT.g:434:3: ( ( (lv_stochastic_20_0= '@' ) ) ( (lv_probability_21_0= ruleEditorProbability ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalGT.g:435:4: ( (lv_stochastic_20_0= '@' ) ) ( (lv_probability_21_0= ruleEditorProbability ) )
                    {
                    // InternalGT.g:435:4: ( (lv_stochastic_20_0= '@' ) )
                    // InternalGT.g:436:5: (lv_stochastic_20_0= '@' )
                    {
                    // InternalGT.g:436:5: (lv_stochastic_20_0= '@' )
                    // InternalGT.g:437:6: lv_stochastic_20_0= '@'
                    {
                    lv_stochastic_20_0=(Token)match(input,21,FOLLOW_16); 

                    						newLeafNode(lv_stochastic_20_0, grammarAccess.getEditorPatternAccess().getStochasticCommercialAtKeyword_7_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEditorPatternRule());
                    						}
                    						setWithLastConsumed(current, "stochastic", lv_stochastic_20_0 != null, "@");
                    					

                    }


                    }

                    // InternalGT.g:449:4: ( (lv_probability_21_0= ruleEditorProbability ) )
                    // InternalGT.g:450:5: (lv_probability_21_0= ruleEditorProbability )
                    {
                    // InternalGT.g:450:5: (lv_probability_21_0= ruleEditorProbability )
                    // InternalGT.g:451:6: lv_probability_21_0= ruleEditorProbability
                    {

                    						newCompositeNode(grammarAccess.getEditorPatternAccess().getProbabilityEditorProbabilityParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_probability_21_0=ruleEditorProbability();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEditorPatternRule());
                    						}
                    						set(
                    							current,
                    							"probability",
                    							lv_probability_21_0,
                    							"org.emoflon.ibex.gt.editor.GT.EditorProbability");
                    						afterParserOrEnumRuleCall();
                    					

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
    // $ANTLR end "ruleEditorPattern"


    // $ANTLR start "entryRuleEditorParameter"
    // InternalGT.g:473:1: entryRuleEditorParameter returns [EObject current=null] : iv_ruleEditorParameter= ruleEditorParameter EOF ;
    public final EObject entryRuleEditorParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorParameter = null;


        try {
            // InternalGT.g:473:56: (iv_ruleEditorParameter= ruleEditorParameter EOF )
            // InternalGT.g:474:2: iv_ruleEditorParameter= ruleEditorParameter EOF
            {
             newCompositeNode(grammarAccess.getEditorParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorParameter=ruleEditorParameter();

            state._fsp--;

             current =iv_ruleEditorParameter; 
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
    // $ANTLR end "entryRuleEditorParameter"


    // $ANTLR start "ruleEditorParameter"
    // InternalGT.g:480:1: ruleEditorParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleEditorParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGT.g:486:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalGT.g:487:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalGT.g:487:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) ) )
            // InternalGT.g:488:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (otherlv_2= RULE_ID ) )
            {
            // InternalGT.g:488:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalGT.g:489:4: (lv_name_0_0= RULE_ID )
            {
            // InternalGT.g:489:4: (lv_name_0_0= RULE_ID )
            // InternalGT.g:490:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_0_0, grammarAccess.getEditorParameterAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorParameterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getEditorParameterAccess().getColonKeyword_1());
            		
            // InternalGT.g:510:3: ( (otherlv_2= RULE_ID ) )
            // InternalGT.g:511:4: (otherlv_2= RULE_ID )
            {
            // InternalGT.g:511:4: (otherlv_2= RULE_ID )
            // InternalGT.g:512:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorParameterRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getEditorParameterAccess().getTypeEDataTypeCrossReference_2_0());
            				

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
    // $ANTLR end "ruleEditorParameter"


    // $ANTLR start "entryRuleEditorNode"
    // InternalGT.g:527:1: entryRuleEditorNode returns [EObject current=null] : iv_ruleEditorNode= ruleEditorNode EOF ;
    public final EObject entryRuleEditorNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorNode = null;


        try {
            // InternalGT.g:527:51: (iv_ruleEditorNode= ruleEditorNode EOF )
            // InternalGT.g:528:2: iv_ruleEditorNode= ruleEditorNode EOF
            {
             newCompositeNode(grammarAccess.getEditorNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorNode=ruleEditorNode();

            state._fsp--;

             current =iv_ruleEditorNode; 
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
    // $ANTLR end "entryRuleEditorNode"


    // $ANTLR start "ruleEditorNode"
    // InternalGT.g:534:1: ruleEditorNode returns [EObject current=null] : ( ( (lv_operator_0_0= ruleEditorOperator ) )? ( (lv_local_1_0= 'local' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '{' ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )* otherlv_9= '}' )? ) ;
    public final EObject ruleEditorNode() throws RecognitionException {
        EObject current = null;

        Token lv_local_1_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Enumerator lv_operator_0_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_references_7_0 = null;

        EObject lv_iterators_8_0 = null;



        	enterRule();

        try {
            // InternalGT.g:540:2: ( ( ( (lv_operator_0_0= ruleEditorOperator ) )? ( (lv_local_1_0= 'local' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '{' ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )* otherlv_9= '}' )? ) )
            // InternalGT.g:541:2: ( ( (lv_operator_0_0= ruleEditorOperator ) )? ( (lv_local_1_0= 'local' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '{' ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )* otherlv_9= '}' )? )
            {
            // InternalGT.g:541:2: ( ( (lv_operator_0_0= ruleEditorOperator ) )? ( (lv_local_1_0= 'local' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '{' ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )* otherlv_9= '}' )? )
            // InternalGT.g:542:3: ( (lv_operator_0_0= ruleEditorOperator ) )? ( (lv_local_1_0= 'local' ) )? ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= '{' ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )* otherlv_9= '}' )?
            {
            // InternalGT.g:542:3: ( (lv_operator_0_0= ruleEditorOperator ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=44 && LA14_0<=46)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalGT.g:543:4: (lv_operator_0_0= ruleEditorOperator )
                    {
                    // InternalGT.g:543:4: (lv_operator_0_0= ruleEditorOperator )
                    // InternalGT.g:544:5: lv_operator_0_0= ruleEditorOperator
                    {

                    					newCompositeNode(grammarAccess.getEditorNodeAccess().getOperatorEditorOperatorEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_18);
                    lv_operator_0_0=ruleEditorOperator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEditorNodeRule());
                    					}
                    					set(
                    						current,
                    						"operator",
                    						lv_operator_0_0,
                    						"org.emoflon.ibex.gt.editor.GT.EditorOperator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalGT.g:561:3: ( (lv_local_1_0= 'local' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalGT.g:562:4: (lv_local_1_0= 'local' )
                    {
                    // InternalGT.g:562:4: (lv_local_1_0= 'local' )
                    // InternalGT.g:563:5: lv_local_1_0= 'local'
                    {
                    lv_local_1_0=(Token)match(input,23,FOLLOW_7); 

                    					newLeafNode(lv_local_1_0, grammarAccess.getEditorNodeAccess().getLocalLocalKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEditorNodeRule());
                    					}
                    					setWithLastConsumed(current, "local", lv_local_1_0 != null, "local");
                    				

                    }


                    }
                    break;

            }

            // InternalGT.g:575:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalGT.g:576:4: (lv_name_2_0= RULE_ID )
            {
            // InternalGT.g:576:4: (lv_name_2_0= RULE_ID )
            // InternalGT.g:577:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_17); 

            					newLeafNode(lv_name_2_0, grammarAccess.getEditorNodeAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorNodeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getEditorNodeAccess().getColonKeyword_3());
            		
            // InternalGT.g:597:3: ( (otherlv_4= RULE_ID ) )
            // InternalGT.g:598:4: (otherlv_4= RULE_ID )
            {
            // InternalGT.g:598:4: (otherlv_4= RULE_ID )
            // InternalGT.g:599:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorNodeRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_19); 

            					newLeafNode(otherlv_4, grammarAccess.getEditorNodeAccess().getTypeEClassCrossReference_4_0());
            				

            }


            }

            // InternalGT.g:610:3: (otherlv_5= '{' ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )* otherlv_9= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==17) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalGT.g:611:4: otherlv_5= '{' ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )* otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,17,FOLLOW_20); 

                    				newLeafNode(otherlv_5, grammarAccess.getEditorNodeAccess().getLeftCurlyBracketKeyword_5_0());
                    			
                    // InternalGT.g:615:4: ( ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) ) | ( (lv_references_7_0= ruleEditorReference ) ) | ( (lv_iterators_8_0= ruleEditorReferenceIterator ) ) )*
                    loop16:
                    do {
                        int alt16=4;
                        switch ( input.LA(1) ) {
                        case 25:
                            {
                            alt16=1;
                            }
                            break;
                        case 30:
                        case 44:
                        case 45:
                        case 46:
                            {
                            alt16=2;
                            }
                            break;
                        case 34:
                            {
                            alt16=3;
                            }
                            break;

                        }

                        switch (alt16) {
                    	case 1 :
                    	    // InternalGT.g:616:5: ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) )
                    	    {
                    	    // InternalGT.g:616:5: ( (lv_attributes_6_0= ruleEditorAttributeAssignment ) )
                    	    // InternalGT.g:617:6: (lv_attributes_6_0= ruleEditorAttributeAssignment )
                    	    {
                    	    // InternalGT.g:617:6: (lv_attributes_6_0= ruleEditorAttributeAssignment )
                    	    // InternalGT.g:618:7: lv_attributes_6_0= ruleEditorAttributeAssignment
                    	    {

                    	    							newCompositeNode(grammarAccess.getEditorNodeAccess().getAttributesEditorAttributeAssignmentParserRuleCall_5_1_0_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_attributes_6_0=ruleEditorAttributeAssignment();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEditorNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"attributes",
                    	    								lv_attributes_6_0,
                    	    								"org.emoflon.ibex.gt.editor.GT.EditorAttributeAssignment");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalGT.g:636:5: ( (lv_references_7_0= ruleEditorReference ) )
                    	    {
                    	    // InternalGT.g:636:5: ( (lv_references_7_0= ruleEditorReference ) )
                    	    // InternalGT.g:637:6: (lv_references_7_0= ruleEditorReference )
                    	    {
                    	    // InternalGT.g:637:6: (lv_references_7_0= ruleEditorReference )
                    	    // InternalGT.g:638:7: lv_references_7_0= ruleEditorReference
                    	    {

                    	    							newCompositeNode(grammarAccess.getEditorNodeAccess().getReferencesEditorReferenceParserRuleCall_5_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_references_7_0=ruleEditorReference();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEditorNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"references",
                    	    								lv_references_7_0,
                    	    								"org.emoflon.ibex.gt.editor.GT.EditorReference");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalGT.g:656:5: ( (lv_iterators_8_0= ruleEditorReferenceIterator ) )
                    	    {
                    	    // InternalGT.g:656:5: ( (lv_iterators_8_0= ruleEditorReferenceIterator ) )
                    	    // InternalGT.g:657:6: (lv_iterators_8_0= ruleEditorReferenceIterator )
                    	    {
                    	    // InternalGT.g:657:6: (lv_iterators_8_0= ruleEditorReferenceIterator )
                    	    // InternalGT.g:658:7: lv_iterators_8_0= ruleEditorReferenceIterator
                    	    {

                    	    							newCompositeNode(grammarAccess.getEditorNodeAccess().getIteratorsEditorReferenceIteratorParserRuleCall_5_1_2_0());
                    	    						
                    	    pushFollow(FOLLOW_20);
                    	    lv_iterators_8_0=ruleEditorReferenceIterator();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getEditorNodeRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"iterators",
                    	    								lv_iterators_8_0,
                    	    								"org.emoflon.ibex.gt.editor.GT.EditorReferenceIterator");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_9, grammarAccess.getEditorNodeAccess().getRightCurlyBracketKeyword_5_2());
                    			

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
    // $ANTLR end "ruleEditorNode"


    // $ANTLR start "entryRuleEditorAttributeConstraint"
    // InternalGT.g:685:1: entryRuleEditorAttributeConstraint returns [EObject current=null] : iv_ruleEditorAttributeConstraint= ruleEditorAttributeConstraint EOF ;
    public final EObject entryRuleEditorAttributeConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorAttributeConstraint = null;


        try {
            // InternalGT.g:685:66: (iv_ruleEditorAttributeConstraint= ruleEditorAttributeConstraint EOF )
            // InternalGT.g:686:2: iv_ruleEditorAttributeConstraint= ruleEditorAttributeConstraint EOF
            {
             newCompositeNode(grammarAccess.getEditorAttributeConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorAttributeConstraint=ruleEditorAttributeConstraint();

            state._fsp--;

             current =iv_ruleEditorAttributeConstraint; 
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
    // $ANTLR end "entryRuleEditorAttributeConstraint"


    // $ANTLR start "ruleEditorAttributeConstraint"
    // InternalGT.g:692:1: ruleEditorAttributeConstraint returns [EObject current=null] : (otherlv_0= '#' ( (lv_lhs_1_0= ruleEditorExpression ) ) ( (lv_relation_2_0= ruleEditorRelation ) ) ( (lv_rhs_3_0= ruleEditorExpression ) ) ) ;
    public final EObject ruleEditorAttributeConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_lhs_1_0 = null;

        Enumerator lv_relation_2_0 = null;

        EObject lv_rhs_3_0 = null;



        	enterRule();

        try {
            // InternalGT.g:698:2: ( (otherlv_0= '#' ( (lv_lhs_1_0= ruleEditorExpression ) ) ( (lv_relation_2_0= ruleEditorRelation ) ) ( (lv_rhs_3_0= ruleEditorExpression ) ) ) )
            // InternalGT.g:699:2: (otherlv_0= '#' ( (lv_lhs_1_0= ruleEditorExpression ) ) ( (lv_relation_2_0= ruleEditorRelation ) ) ( (lv_rhs_3_0= ruleEditorExpression ) ) )
            {
            // InternalGT.g:699:2: (otherlv_0= '#' ( (lv_lhs_1_0= ruleEditorExpression ) ) ( (lv_relation_2_0= ruleEditorRelation ) ) ( (lv_rhs_3_0= ruleEditorExpression ) ) )
            // InternalGT.g:700:3: otherlv_0= '#' ( (lv_lhs_1_0= ruleEditorExpression ) ) ( (lv_relation_2_0= ruleEditorRelation ) ) ( (lv_rhs_3_0= ruleEditorExpression ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_21); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorAttributeConstraintAccess().getNumberSignKeyword_0());
            		
            // InternalGT.g:704:3: ( (lv_lhs_1_0= ruleEditorExpression ) )
            // InternalGT.g:705:4: (lv_lhs_1_0= ruleEditorExpression )
            {
            // InternalGT.g:705:4: (lv_lhs_1_0= ruleEditorExpression )
            // InternalGT.g:706:5: lv_lhs_1_0= ruleEditorExpression
            {

            					newCompositeNode(grammarAccess.getEditorAttributeConstraintAccess().getLhsEditorExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_22);
            lv_lhs_1_0=ruleEditorExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorAttributeConstraintRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_1_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGT.g:723:3: ( (lv_relation_2_0= ruleEditorRelation ) )
            // InternalGT.g:724:4: (lv_relation_2_0= ruleEditorRelation )
            {
            // InternalGT.g:724:4: (lv_relation_2_0= ruleEditorRelation )
            // InternalGT.g:725:5: lv_relation_2_0= ruleEditorRelation
            {

            					newCompositeNode(grammarAccess.getEditorAttributeConstraintAccess().getRelationEditorRelationEnumRuleCall_2_0());
            				
            pushFollow(FOLLOW_21);
            lv_relation_2_0=ruleEditorRelation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorAttributeConstraintRule());
            					}
            					set(
            						current,
            						"relation",
            						lv_relation_2_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorRelation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGT.g:742:3: ( (lv_rhs_3_0= ruleEditorExpression ) )
            // InternalGT.g:743:4: (lv_rhs_3_0= ruleEditorExpression )
            {
            // InternalGT.g:743:4: (lv_rhs_3_0= ruleEditorExpression )
            // InternalGT.g:744:5: lv_rhs_3_0= ruleEditorExpression
            {

            					newCompositeNode(grammarAccess.getEditorAttributeConstraintAccess().getRhsEditorExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_rhs_3_0=ruleEditorExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorAttributeConstraintRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_3_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorExpression");
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
    // $ANTLR end "ruleEditorAttributeConstraint"


    // $ANTLR start "entryRuleEditorAttributeAssignment"
    // InternalGT.g:765:1: entryRuleEditorAttributeAssignment returns [EObject current=null] : iv_ruleEditorAttributeAssignment= ruleEditorAttributeAssignment EOF ;
    public final EObject entryRuleEditorAttributeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorAttributeAssignment = null;


        try {
            // InternalGT.g:765:66: (iv_ruleEditorAttributeAssignment= ruleEditorAttributeAssignment EOF )
            // InternalGT.g:766:2: iv_ruleEditorAttributeAssignment= ruleEditorAttributeAssignment EOF
            {
             newCompositeNode(grammarAccess.getEditorAttributeAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorAttributeAssignment=ruleEditorAttributeAssignment();

            state._fsp--;

             current =iv_ruleEditorAttributeAssignment; 
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
    // $ANTLR end "entryRuleEditorAttributeAssignment"


    // $ANTLR start "ruleEditorAttributeAssignment"
    // InternalGT.g:772:1: ruleEditorAttributeAssignment returns [EObject current=null] : (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleEditorExpression ) ) ) ;
    public final EObject ruleEditorAttributeAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalGT.g:778:2: ( (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleEditorExpression ) ) ) )
            // InternalGT.g:779:2: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleEditorExpression ) ) )
            {
            // InternalGT.g:779:2: (otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleEditorExpression ) ) )
            // InternalGT.g:780:3: otherlv_0= '.' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':=' ( (lv_value_3_0= ruleEditorExpression ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorAttributeAssignmentAccess().getFullStopKeyword_0());
            		
            // InternalGT.g:784:3: ( (otherlv_1= RULE_ID ) )
            // InternalGT.g:785:4: (otherlv_1= RULE_ID )
            {
            // InternalGT.g:785:4: (otherlv_1= RULE_ID )
            // InternalGT.g:786:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorAttributeAssignmentRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_23); 

            					newLeafNode(otherlv_1, grammarAccess.getEditorAttributeAssignmentAccess().getAttributeEAttributeCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_2, grammarAccess.getEditorAttributeAssignmentAccess().getColonEqualsSignKeyword_2());
            		
            // InternalGT.g:801:3: ( (lv_value_3_0= ruleEditorExpression ) )
            // InternalGT.g:802:4: (lv_value_3_0= ruleEditorExpression )
            {
            // InternalGT.g:802:4: (lv_value_3_0= ruleEditorExpression )
            // InternalGT.g:803:5: lv_value_3_0= ruleEditorExpression
            {

            					newCompositeNode(grammarAccess.getEditorAttributeAssignmentAccess().getValueEditorExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleEditorExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorAttributeAssignmentRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorExpression");
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
    // $ANTLR end "ruleEditorAttributeAssignment"


    // $ANTLR start "entryRuleEditorExpression"
    // InternalGT.g:824:1: entryRuleEditorExpression returns [EObject current=null] : iv_ruleEditorExpression= ruleEditorExpression EOF ;
    public final EObject entryRuleEditorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorExpression = null;


        try {
            // InternalGT.g:824:57: (iv_ruleEditorExpression= ruleEditorExpression EOF )
            // InternalGT.g:825:2: iv_ruleEditorExpression= ruleEditorExpression EOF
            {
             newCompositeNode(grammarAccess.getEditorExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorExpression=ruleEditorExpression();

            state._fsp--;

             current =iv_ruleEditorExpression; 
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
    // $ANTLR end "entryRuleEditorExpression"


    // $ANTLR start "ruleEditorExpression"
    // InternalGT.g:831:1: ruleEditorExpression returns [EObject current=null] : (this_EditorEnumExpression_0= ruleEditorEnumExpression | this_EditorParameterExpression_1= ruleEditorParameterExpression | this_StochasticFunctionExpression_2= ruleStochasticFunctionExpression | this_ArithmeticCalculationExpression_3= ruleArithmeticCalculationExpression ) ;
    public final EObject ruleEditorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EditorEnumExpression_0 = null;

        EObject this_EditorParameterExpression_1 = null;

        EObject this_StochasticFunctionExpression_2 = null;

        EObject this_ArithmeticCalculationExpression_3 = null;



        	enterRule();

        try {
            // InternalGT.g:837:2: ( (this_EditorEnumExpression_0= ruleEditorEnumExpression | this_EditorParameterExpression_1= ruleEditorParameterExpression | this_StochasticFunctionExpression_2= ruleStochasticFunctionExpression | this_ArithmeticCalculationExpression_3= ruleArithmeticCalculationExpression ) )
            // InternalGT.g:838:2: (this_EditorEnumExpression_0= ruleEditorEnumExpression | this_EditorParameterExpression_1= ruleEditorParameterExpression | this_StochasticFunctionExpression_2= ruleStochasticFunctionExpression | this_ArithmeticCalculationExpression_3= ruleArithmeticCalculationExpression )
            {
            // InternalGT.g:838:2: (this_EditorEnumExpression_0= ruleEditorEnumExpression | this_EditorParameterExpression_1= ruleEditorParameterExpression | this_StochasticFunctionExpression_2= ruleStochasticFunctionExpression | this_ArithmeticCalculationExpression_3= ruleArithmeticCalculationExpression )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt18=1;
                }
                break;
            case 32:
                {
                alt18=2;
                }
                break;
            case 53:
            case 54:
            case 55:
            case 56:
                {
                alt18=3;
                }
                break;
            case 30:
                {
                int LA18_4 = input.LA(2);

                if ( (LA18_4==RULE_INT||LA18_4==13||(LA18_4>=62 && LA18_4<=69)) ) {
                    alt18=4;
                }
                else if ( ((LA18_4>=54 && LA18_4<=56)) ) {
                    alt18=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 13:
            case 27:
            case 28:
            case 29:
            case 37:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalGT.g:839:3: this_EditorEnumExpression_0= ruleEditorEnumExpression
                    {

                    			newCompositeNode(grammarAccess.getEditorExpressionAccess().getEditorEnumExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorEnumExpression_0=ruleEditorEnumExpression();

                    state._fsp--;


                    			current = this_EditorEnumExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGT.g:848:3: this_EditorParameterExpression_1= ruleEditorParameterExpression
                    {

                    			newCompositeNode(grammarAccess.getEditorExpressionAccess().getEditorParameterExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorParameterExpression_1=ruleEditorParameterExpression();

                    state._fsp--;


                    			current = this_EditorParameterExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGT.g:857:3: this_StochasticFunctionExpression_2= ruleStochasticFunctionExpression
                    {

                    			newCompositeNode(grammarAccess.getEditorExpressionAccess().getStochasticFunctionExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_StochasticFunctionExpression_2=ruleStochasticFunctionExpression();

                    state._fsp--;


                    			current = this_StochasticFunctionExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalGT.g:866:3: this_ArithmeticCalculationExpression_3= ruleArithmeticCalculationExpression
                    {

                    			newCompositeNode(grammarAccess.getEditorExpressionAccess().getArithmeticCalculationExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithmeticCalculationExpression_3=ruleArithmeticCalculationExpression();

                    state._fsp--;


                    			current = this_ArithmeticCalculationExpression_3;
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
    // $ANTLR end "ruleEditorExpression"


    // $ANTLR start "entryRuleEditorAttributeExpression"
    // InternalGT.g:878:1: entryRuleEditorAttributeExpression returns [EObject current=null] : iv_ruleEditorAttributeExpression= ruleEditorAttributeExpression EOF ;
    public final EObject entryRuleEditorAttributeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorAttributeExpression = null;


        try {
            // InternalGT.g:878:66: (iv_ruleEditorAttributeExpression= ruleEditorAttributeExpression EOF )
            // InternalGT.g:879:2: iv_ruleEditorAttributeExpression= ruleEditorAttributeExpression EOF
            {
             newCompositeNode(grammarAccess.getEditorAttributeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorAttributeExpression=ruleEditorAttributeExpression();

            state._fsp--;

             current =iv_ruleEditorAttributeExpression; 
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
    // $ANTLR end "entryRuleEditorAttributeExpression"


    // $ANTLR start "ruleEditorAttributeExpression"
    // InternalGT.g:885:1: ruleEditorAttributeExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleEditorAttributeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalGT.g:891:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalGT.g:892:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalGT.g:892:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) )
            // InternalGT.g:893:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) )
            {
            // InternalGT.g:893:3: ( (otherlv_0= RULE_ID ) )
            // InternalGT.g:894:4: (otherlv_0= RULE_ID )
            {
            // InternalGT.g:894:4: (otherlv_0= RULE_ID )
            // InternalGT.g:895:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorAttributeExpressionRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_0, grammarAccess.getEditorAttributeExpressionAccess().getNodeEditorNodeCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,25,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getEditorAttributeExpressionAccess().getFullStopKeyword_1());
            		
            // InternalGT.g:910:3: ( (otherlv_2= RULE_ID ) )
            // InternalGT.g:911:4: (otherlv_2= RULE_ID )
            {
            // InternalGT.g:911:4: (otherlv_2= RULE_ID )
            // InternalGT.g:912:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorAttributeExpressionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_2, grammarAccess.getEditorAttributeExpressionAccess().getAttributeEAttributeCrossReference_2_0());
            				

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
    // $ANTLR end "ruleEditorAttributeExpression"


    // $ANTLR start "entryRuleEditorCountExpression"
    // InternalGT.g:927:1: entryRuleEditorCountExpression returns [EObject current=null] : iv_ruleEditorCountExpression= ruleEditorCountExpression EOF ;
    public final EObject entryRuleEditorCountExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorCountExpression = null;


        try {
            // InternalGT.g:927:62: (iv_ruleEditorCountExpression= ruleEditorCountExpression EOF )
            // InternalGT.g:928:2: iv_ruleEditorCountExpression= ruleEditorCountExpression EOF
            {
             newCompositeNode(grammarAccess.getEditorCountExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorCountExpression=ruleEditorCountExpression();

            state._fsp--;

             current =iv_ruleEditorCountExpression; 
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
    // $ANTLR end "entryRuleEditorCountExpression"


    // $ANTLR start "ruleEditorCountExpression"
    // InternalGT.g:934:1: ruleEditorCountExpression returns [EObject current=null] : (otherlv_0= 'count' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleEditorCountExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGT.g:940:2: ( (otherlv_0= 'count' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalGT.g:941:2: (otherlv_0= 'count' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalGT.g:941:2: (otherlv_0= 'count' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // InternalGT.g:942:3: otherlv_0= 'count' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_25); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorCountExpressionAccess().getCountKeyword_0());
            		
            otherlv_1=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getEditorCountExpressionAccess().getLeftParenthesisKeyword_1());
            		
            // InternalGT.g:950:3: ( (otherlv_2= RULE_ID ) )
            // InternalGT.g:951:4: (otherlv_2= RULE_ID )
            {
            // InternalGT.g:951:4: (otherlv_2= RULE_ID )
            // InternalGT.g:952:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorCountExpressionRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(otherlv_2, grammarAccess.getEditorCountExpressionAccess().getInvokedPattenEditorPatternCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getEditorCountExpressionAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleEditorCountExpression"


    // $ANTLR start "entryRuleEditorLiteralExpression"
    // InternalGT.g:971:1: entryRuleEditorLiteralExpression returns [EObject current=null] : iv_ruleEditorLiteralExpression= ruleEditorLiteralExpression EOF ;
    public final EObject entryRuleEditorLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorLiteralExpression = null;


        try {
            // InternalGT.g:971:64: (iv_ruleEditorLiteralExpression= ruleEditorLiteralExpression EOF )
            // InternalGT.g:972:2: iv_ruleEditorLiteralExpression= ruleEditorLiteralExpression EOF
            {
             newCompositeNode(grammarAccess.getEditorLiteralExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorLiteralExpression=ruleEditorLiteralExpression();

            state._fsp--;

             current =iv_ruleEditorLiteralExpression; 
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
    // $ANTLR end "entryRuleEditorLiteralExpression"


    // $ANTLR start "ruleEditorLiteralExpression"
    // InternalGT.g:978:1: ruleEditorLiteralExpression returns [EObject current=null] : ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) ) ) | ( () ( (lv_value_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleEditorLiteralExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_value_0_3 = null;



        	enterRule();

        try {
            // InternalGT.g:984:2: ( ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) ) ) | ( () ( (lv_value_2_0= RULE_STRING ) ) ) ) )
            // InternalGT.g:985:2: ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) ) ) | ( () ( (lv_value_2_0= RULE_STRING ) ) ) )
            {
            // InternalGT.g:985:2: ( ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) ) ) | ( () ( (lv_value_2_0= RULE_STRING ) ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_INT||(LA20_0>=28 && LA20_0<=30)) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_STRING) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalGT.g:986:3: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) ) )
                    {
                    // InternalGT.g:986:3: ( ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) ) )
                    // InternalGT.g:987:4: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) )
                    {
                    // InternalGT.g:987:4: ( (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber ) )
                    // InternalGT.g:988:5: (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber )
                    {
                    // InternalGT.g:988:5: (lv_value_0_1= 'true' | lv_value_0_2= 'false' | lv_value_0_3= ruleNumber )
                    int alt19=3;
                    switch ( input.LA(1) ) {
                    case 28:
                        {
                        alt19=1;
                        }
                        break;
                    case 29:
                        {
                        alt19=2;
                        }
                        break;
                    case RULE_INT:
                    case 30:
                        {
                        alt19=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }

                    switch (alt19) {
                        case 1 :
                            // InternalGT.g:989:6: lv_value_0_1= 'true'
                            {
                            lv_value_0_1=(Token)match(input,28,FOLLOW_2); 

                            						newLeafNode(lv_value_0_1, grammarAccess.getEditorLiteralExpressionAccess().getValueTrueKeyword_0_0_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getEditorLiteralExpressionRule());
                            						}
                            						setWithLastConsumed(current, "value", lv_value_0_1, null);
                            					

                            }
                            break;
                        case 2 :
                            // InternalGT.g:1000:6: lv_value_0_2= 'false'
                            {
                            lv_value_0_2=(Token)match(input,29,FOLLOW_2); 

                            						newLeafNode(lv_value_0_2, grammarAccess.getEditorLiteralExpressionAccess().getValueFalseKeyword_0_0_1());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getEditorLiteralExpressionRule());
                            						}
                            						setWithLastConsumed(current, "value", lv_value_0_2, null);
                            					

                            }
                            break;
                        case 3 :
                            // InternalGT.g:1011:6: lv_value_0_3= ruleNumber
                            {

                            						newCompositeNode(grammarAccess.getEditorLiteralExpressionAccess().getValueNumberParserRuleCall_0_0_2());
                            					
                            pushFollow(FOLLOW_2);
                            lv_value_0_3=ruleNumber();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getEditorLiteralExpressionRule());
                            						}
                            						set(
                            							current,
                            							"value",
                            							lv_value_0_3,
                            							"org.emoflon.ibex.gt.editor.GT.Number");
                            						afterParserOrEnumRuleCall();
                            					

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1030:3: ( () ( (lv_value_2_0= RULE_STRING ) ) )
                    {
                    // InternalGT.g:1030:3: ( () ( (lv_value_2_0= RULE_STRING ) ) )
                    // InternalGT.g:1031:4: () ( (lv_value_2_0= RULE_STRING ) )
                    {
                    // InternalGT.g:1031:4: ()
                    // InternalGT.g:1032:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getEditorLiteralExpressionAccess().getStringConstantAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGT.g:1038:4: ( (lv_value_2_0= RULE_STRING ) )
                    // InternalGT.g:1039:5: (lv_value_2_0= RULE_STRING )
                    {
                    // InternalGT.g:1039:5: (lv_value_2_0= RULE_STRING )
                    // InternalGT.g:1040:6: lv_value_2_0= RULE_STRING
                    {
                    lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_value_2_0, grammarAccess.getEditorLiteralExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEditorLiteralExpressionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"value",
                    							lv_value_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


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
    // $ANTLR end "ruleEditorLiteralExpression"


    // $ANTLR start "entryRuleNumber"
    // InternalGT.g:1061:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


        try {
            // InternalGT.g:1061:46: (iv_ruleNumber= ruleNumber EOF )
            // InternalGT.g:1062:2: iv_ruleNumber= ruleNumber EOF
            {
             newCompositeNode(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;

             current =iv_ruleNumber.getText(); 
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
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalGT.g:1068:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;


        	enterRule();

        try {
            // InternalGT.g:1074:2: ( ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? ) )
            // InternalGT.g:1075:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            {
            // InternalGT.g:1075:2: ( (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )? )
            // InternalGT.g:1076:3: (kw= '-' )? this_INT_1= RULE_INT (kw= '.' this_INT_3= RULE_INT )?
            {
            // InternalGT.g:1076:3: (kw= '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalGT.g:1077:4: kw= '-'
                    {
                    kw=(Token)match(input,30,FOLLOW_27); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getNumberAccess().getHyphenMinusKeyword_0());
                    			

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_28); 

            			current.merge(this_INT_1);
            		

            			newLeafNode(this_INT_1, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1());
            		
            // InternalGT.g:1090:3: (kw= '.' this_INT_3= RULE_INT )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==25) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==RULE_INT) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalGT.g:1091:4: kw= '.' this_INT_3= RULE_INT
                    {
                    kw=(Token)match(input,25,FOLLOW_27); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_2_0());
                    			
                    this_INT_3=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_3);
                    			

                    				newLeafNode(this_INT_3, grammarAccess.getNumberAccess().getINTTerminalRuleCall_2_1());
                    			

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
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleEditorEnumExpression"
    // InternalGT.g:1108:1: entryRuleEditorEnumExpression returns [EObject current=null] : iv_ruleEditorEnumExpression= ruleEditorEnumExpression EOF ;
    public final EObject entryRuleEditorEnumExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorEnumExpression = null;


        try {
            // InternalGT.g:1108:61: (iv_ruleEditorEnumExpression= ruleEditorEnumExpression EOF )
            // InternalGT.g:1109:2: iv_ruleEditorEnumExpression= ruleEditorEnumExpression EOF
            {
             newCompositeNode(grammarAccess.getEditorEnumExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorEnumExpression=ruleEditorEnumExpression();

            state._fsp--;

             current =iv_ruleEditorEnumExpression; 
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
    // $ANTLR end "entryRuleEditorEnumExpression"


    // $ANTLR start "ruleEditorEnumExpression"
    // InternalGT.g:1115:1: ruleEditorEnumExpression returns [EObject current=null] : (otherlv_0= 'enum::' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleEditorEnumExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGT.g:1121:2: ( (otherlv_0= 'enum::' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalGT.g:1122:2: (otherlv_0= 'enum::' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalGT.g:1122:2: (otherlv_0= 'enum::' ( (otherlv_1= RULE_ID ) ) )
            // InternalGT.g:1123:3: otherlv_0= 'enum::' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorEnumExpressionAccess().getEnumKeyword_0());
            		
            // InternalGT.g:1127:3: ( (otherlv_1= RULE_ID ) )
            // InternalGT.g:1128:4: (otherlv_1= RULE_ID )
            {
            // InternalGT.g:1128:4: (otherlv_1= RULE_ID )
            // InternalGT.g:1129:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorEnumExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getEditorEnumExpressionAccess().getLiteralEEnumLiteralCrossReference_1_0());
            				

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
    // $ANTLR end "ruleEditorEnumExpression"


    // $ANTLR start "entryRuleEditorParameterExpression"
    // InternalGT.g:1144:1: entryRuleEditorParameterExpression returns [EObject current=null] : iv_ruleEditorParameterExpression= ruleEditorParameterExpression EOF ;
    public final EObject entryRuleEditorParameterExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorParameterExpression = null;


        try {
            // InternalGT.g:1144:66: (iv_ruleEditorParameterExpression= ruleEditorParameterExpression EOF )
            // InternalGT.g:1145:2: iv_ruleEditorParameterExpression= ruleEditorParameterExpression EOF
            {
             newCompositeNode(grammarAccess.getEditorParameterExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorParameterExpression=ruleEditorParameterExpression();

            state._fsp--;

             current =iv_ruleEditorParameterExpression; 
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
    // $ANTLR end "entryRuleEditorParameterExpression"


    // $ANTLR start "ruleEditorParameterExpression"
    // InternalGT.g:1151:1: ruleEditorParameterExpression returns [EObject current=null] : (otherlv_0= 'param::' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleEditorParameterExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalGT.g:1157:2: ( (otherlv_0= 'param::' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalGT.g:1158:2: (otherlv_0= 'param::' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalGT.g:1158:2: (otherlv_0= 'param::' ( (otherlv_1= RULE_ID ) ) )
            // InternalGT.g:1159:3: otherlv_0= 'param::' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorParameterExpressionAccess().getParamKeyword_0());
            		
            // InternalGT.g:1163:3: ( (otherlv_1= RULE_ID ) )
            // InternalGT.g:1164:4: (otherlv_1= RULE_ID )
            {
            // InternalGT.g:1164:4: (otherlv_1= RULE_ID )
            // InternalGT.g:1165:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorParameterExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getEditorParameterExpressionAccess().getParameterEditorParameterCrossReference_1_0());
            				

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
    // $ANTLR end "ruleEditorParameterExpression"


    // $ANTLR start "entryRuleEditorReference"
    // InternalGT.g:1180:1: entryRuleEditorReference returns [EObject current=null] : iv_ruleEditorReference= ruleEditorReference EOF ;
    public final EObject entryRuleEditorReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorReference = null;


        try {
            // InternalGT.g:1180:56: (iv_ruleEditorReference= ruleEditorReference EOF )
            // InternalGT.g:1181:2: iv_ruleEditorReference= ruleEditorReference EOF
            {
             newCompositeNode(grammarAccess.getEditorReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorReference=ruleEditorReference();

            state._fsp--;

             current =iv_ruleEditorReference; 
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
    // $ANTLR end "entryRuleEditorReference"


    // $ANTLR start "ruleEditorReference"
    // InternalGT.g:1187:1: ruleEditorReference returns [EObject current=null] : ( ( (lv_operator_0_0= ruleEditorOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleEditorReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_0_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1193:2: ( ( ( (lv_operator_0_0= ruleEditorOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) ) )
            // InternalGT.g:1194:2: ( ( (lv_operator_0_0= ruleEditorOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalGT.g:1194:2: ( ( (lv_operator_0_0= ruleEditorOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )
            // InternalGT.g:1195:3: ( (lv_operator_0_0= ruleEditorOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
            {
            // InternalGT.g:1195:3: ( (lv_operator_0_0= ruleEditorOperator ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=44 && LA23_0<=46)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalGT.g:1196:4: (lv_operator_0_0= ruleEditorOperator )
                    {
                    // InternalGT.g:1196:4: (lv_operator_0_0= ruleEditorOperator )
                    // InternalGT.g:1197:5: lv_operator_0_0= ruleEditorOperator
                    {

                    					newCompositeNode(grammarAccess.getEditorReferenceAccess().getOperatorEditorOperatorEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_29);
                    lv_operator_0_0=ruleEditorOperator();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEditorReferenceRule());
                    					}
                    					set(
                    						current,
                    						"operator",
                    						lv_operator_0_0,
                    						"org.emoflon.ibex.gt.editor.GT.EditorOperator");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_1, grammarAccess.getEditorReferenceAccess().getHyphenMinusKeyword_1());
            		
            // InternalGT.g:1218:3: ( (otherlv_2= RULE_ID ) )
            // InternalGT.g:1219:4: (otherlv_2= RULE_ID )
            {
            // InternalGT.g:1219:4: (otherlv_2= RULE_ID )
            // InternalGT.g:1220:5: otherlv_2= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorReferenceRule());
            					}
            				
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_2, grammarAccess.getEditorReferenceAccess().getTypeEReferenceCrossReference_2_0());
            				

            }


            }

            otherlv_3=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getEditorReferenceAccess().getHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalGT.g:1235:3: ( (otherlv_4= RULE_ID ) )
            // InternalGT.g:1236:4: (otherlv_4= RULE_ID )
            {
            // InternalGT.g:1236:4: (otherlv_4= RULE_ID )
            // InternalGT.g:1237:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorReferenceRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getEditorReferenceAccess().getTargetEditorNodeCrossReference_4_0());
            				

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
    // $ANTLR end "ruleEditorReference"


    // $ANTLR start "entryRuleEditorReferenceIterator"
    // InternalGT.g:1252:1: entryRuleEditorReferenceIterator returns [EObject current=null] : iv_ruleEditorReferenceIterator= ruleEditorReferenceIterator EOF ;
    public final EObject entryRuleEditorReferenceIterator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorReferenceIterator = null;


        try {
            // InternalGT.g:1252:64: (iv_ruleEditorReferenceIterator= ruleEditorReferenceIterator EOF )
            // InternalGT.g:1253:2: iv_ruleEditorReferenceIterator= ruleEditorReferenceIterator EOF
            {
             newCompositeNode(grammarAccess.getEditorReferenceIteratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorReferenceIterator=ruleEditorReferenceIterator();

            state._fsp--;

             current =iv_ruleEditorReferenceIterator; 
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
    // $ANTLR end "entryRuleEditorReferenceIterator"


    // $ANTLR start "ruleEditorReferenceIterator"
    // InternalGT.g:1259:1: ruleEditorReferenceIterator returns [EObject current=null] : (otherlv_0= 'forEach' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (otherlv_5= RULE_ID ) ) otherlv_6= '>' )? otherlv_7= '{' ( ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) ) | ( (lv_references_9_0= ruleEditorIteratorReference ) ) )+ otherlv_10= '}' ) ;
    public final EObject ruleEditorReferenceIterator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_iteratorAttributes_8_0 = null;

        EObject lv_references_9_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1265:2: ( (otherlv_0= 'forEach' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (otherlv_5= RULE_ID ) ) otherlv_6= '>' )? otherlv_7= '{' ( ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) ) | ( (lv_references_9_0= ruleEditorIteratorReference ) ) )+ otherlv_10= '}' ) )
            // InternalGT.g:1266:2: (otherlv_0= 'forEach' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (otherlv_5= RULE_ID ) ) otherlv_6= '>' )? otherlv_7= '{' ( ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) ) | ( (lv_references_9_0= ruleEditorIteratorReference ) ) )+ otherlv_10= '}' )
            {
            // InternalGT.g:1266:2: (otherlv_0= 'forEach' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (otherlv_5= RULE_ID ) ) otherlv_6= '>' )? otherlv_7= '{' ( ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) ) | ( (lv_references_9_0= ruleEditorIteratorReference ) ) )+ otherlv_10= '}' )
            // InternalGT.g:1267:3: otherlv_0= 'forEach' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (otherlv_5= RULE_ID ) ) otherlv_6= '>' )? otherlv_7= '{' ( ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) ) | ( (lv_references_9_0= ruleEditorIteratorReference ) ) )+ otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorReferenceIteratorAccess().getForEachKeyword_0());
            		
            // InternalGT.g:1271:3: ( (otherlv_1= RULE_ID ) )
            // InternalGT.g:1272:4: (otherlv_1= RULE_ID )
            {
            // InternalGT.g:1272:4: (otherlv_1= RULE_ID )
            // InternalGT.g:1273:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorReferenceIteratorRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_1, grammarAccess.getEditorReferenceIteratorAccess().getTypeEReferenceCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEditorReferenceIteratorAccess().getHyphenMinusGreaterThanSignKeyword_2());
            		
            // InternalGT.g:1288:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalGT.g:1289:4: (lv_name_3_0= RULE_ID )
            {
            // InternalGT.g:1289:4: (lv_name_3_0= RULE_ID )
            // InternalGT.g:1290:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_31); 

            					newLeafNode(lv_name_3_0, grammarAccess.getEditorReferenceIteratorAccess().getNameIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorReferenceIteratorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalGT.g:1306:3: (otherlv_4= '<' ( (otherlv_5= RULE_ID ) ) otherlv_6= '>' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==35) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalGT.g:1307:4: otherlv_4= '<' ( (otherlv_5= RULE_ID ) ) otherlv_6= '>'
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_7); 

                    				newLeafNode(otherlv_4, grammarAccess.getEditorReferenceIteratorAccess().getLessThanSignKeyword_4_0());
                    			
                    // InternalGT.g:1311:4: ( (otherlv_5= RULE_ID ) )
                    // InternalGT.g:1312:5: (otherlv_5= RULE_ID )
                    {
                    // InternalGT.g:1312:5: (otherlv_5= RULE_ID )
                    // InternalGT.g:1313:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEditorReferenceIteratorRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_5, grammarAccess.getEditorReferenceIteratorAccess().getSubTypeEClassCrossReference_4_1_0());
                    					

                    }


                    }

                    otherlv_6=(Token)match(input,36,FOLLOW_33); 

                    				newLeafNode(otherlv_6, grammarAccess.getEditorReferenceIteratorAccess().getGreaterThanSignKeyword_4_2());
                    			

                    }
                    break;

            }

            otherlv_7=(Token)match(input,17,FOLLOW_34); 

            			newLeafNode(otherlv_7, grammarAccess.getEditorReferenceIteratorAccess().getLeftCurlyBracketKeyword_5());
            		
            // InternalGT.g:1333:3: ( ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) ) | ( (lv_references_9_0= ruleEditorIteratorReference ) ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=3;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID||LA25_0==37) ) {
                    alt25=1;
                }
                else if ( ((LA25_0>=44 && LA25_0<=46)) ) {
                    alt25=2;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalGT.g:1334:4: ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) )
            	    {
            	    // InternalGT.g:1334:4: ( (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment ) )
            	    // InternalGT.g:1335:5: (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment )
            	    {
            	    // InternalGT.g:1335:5: (lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment )
            	    // InternalGT.g:1336:6: lv_iteratorAttributes_8_0= ruleEditorIteratorAttributeAssignment
            	    {

            	    						newCompositeNode(grammarAccess.getEditorReferenceIteratorAccess().getIteratorAttributesEditorIteratorAttributeAssignmentParserRuleCall_6_0_0());
            	    					
            	    pushFollow(FOLLOW_35);
            	    lv_iteratorAttributes_8_0=ruleEditorIteratorAttributeAssignment();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEditorReferenceIteratorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"iteratorAttributes",
            	    							lv_iteratorAttributes_8_0,
            	    							"org.emoflon.ibex.gt.editor.GT.EditorIteratorAttributeAssignment");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalGT.g:1354:4: ( (lv_references_9_0= ruleEditorIteratorReference ) )
            	    {
            	    // InternalGT.g:1354:4: ( (lv_references_9_0= ruleEditorIteratorReference ) )
            	    // InternalGT.g:1355:5: (lv_references_9_0= ruleEditorIteratorReference )
            	    {
            	    // InternalGT.g:1355:5: (lv_references_9_0= ruleEditorIteratorReference )
            	    // InternalGT.g:1356:6: lv_references_9_0= ruleEditorIteratorReference
            	    {

            	    						newCompositeNode(grammarAccess.getEditorReferenceIteratorAccess().getReferencesEditorIteratorReferenceParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_35);
            	    lv_references_9_0=ruleEditorIteratorReference();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEditorReferenceIteratorRule());
            	    						}
            	    						add(
            	    							current,
            	    							"references",
            	    							lv_references_9_0,
            	    							"org.emoflon.ibex.gt.editor.GT.EditorIteratorReference");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);

            otherlv_10=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getEditorReferenceIteratorAccess().getRightCurlyBracketKeyword_7());
            		

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
    // $ANTLR end "ruleEditorReferenceIterator"


    // $ANTLR start "entryRuleEditorIteratorAttributeExpression"
    // InternalGT.g:1382:1: entryRuleEditorIteratorAttributeExpression returns [EObject current=null] : iv_ruleEditorIteratorAttributeExpression= ruleEditorIteratorAttributeExpression EOF ;
    public final EObject entryRuleEditorIteratorAttributeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorIteratorAttributeExpression = null;


        try {
            // InternalGT.g:1382:74: (iv_ruleEditorIteratorAttributeExpression= ruleEditorIteratorAttributeExpression EOF )
            // InternalGT.g:1383:2: iv_ruleEditorIteratorAttributeExpression= ruleEditorIteratorAttributeExpression EOF
            {
             newCompositeNode(grammarAccess.getEditorIteratorAttributeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorIteratorAttributeExpression=ruleEditorIteratorAttributeExpression();

            state._fsp--;

             current =iv_ruleEditorIteratorAttributeExpression; 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeExpression"


    // $ANTLR start "ruleEditorIteratorAttributeExpression"
    // InternalGT.g:1389:1: ruleEditorIteratorAttributeExpression returns [EObject current=null] : (otherlv_0= 'iterator::' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleEditorIteratorAttributeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalGT.g:1395:2: ( (otherlv_0= 'iterator::' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalGT.g:1396:2: (otherlv_0= 'iterator::' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalGT.g:1396:2: (otherlv_0= 'iterator::' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )
            // InternalGT.g:1397:3: otherlv_0= 'iterator::' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorKeyword_0());
            		
            // InternalGT.g:1401:3: ( (otherlv_1= RULE_ID ) )
            // InternalGT.g:1402:4: (otherlv_1= RULE_ID )
            {
            // InternalGT.g:1402:4: (otherlv_1= RULE_ID )
            // InternalGT.g:1403:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorIteratorAttributeExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(otherlv_1, grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorEditorReferenceIteratorCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,25,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEditorIteratorAttributeExpressionAccess().getFullStopKeyword_2());
            		
            // InternalGT.g:1418:3: ( (otherlv_3= RULE_ID ) )
            // InternalGT.g:1419:4: (otherlv_3= RULE_ID )
            {
            // InternalGT.g:1419:4: (otherlv_3= RULE_ID )
            // InternalGT.g:1420:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorIteratorAttributeExpressionRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_3, grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeEAttributeCrossReference_3_0());
            				

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
    // $ANTLR end "ruleEditorIteratorAttributeExpression"


    // $ANTLR start "entryRuleEditorIteratorAttributeAssignment"
    // InternalGT.g:1435:1: entryRuleEditorIteratorAttributeAssignment returns [EObject current=null] : iv_ruleEditorIteratorAttributeAssignment= ruleEditorIteratorAttributeAssignment EOF ;
    public final EObject entryRuleEditorIteratorAttributeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorIteratorAttributeAssignment = null;


        try {
            // InternalGT.g:1435:74: (iv_ruleEditorIteratorAttributeAssignment= ruleEditorIteratorAttributeAssignment EOF )
            // InternalGT.g:1436:2: iv_ruleEditorIteratorAttributeAssignment= ruleEditorIteratorAttributeAssignment EOF
            {
             newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorIteratorAttributeAssignment=ruleEditorIteratorAttributeAssignment();

            state._fsp--;

             current =iv_ruleEditorIteratorAttributeAssignment; 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeAssignment"


    // $ANTLR start "ruleEditorIteratorAttributeAssignment"
    // InternalGT.g:1442:1: ruleEditorIteratorAttributeAssignment returns [EObject current=null] : (this_EditorIteratorAttributeAssignmentItr_0= ruleEditorIteratorAttributeAssignmentItr | this_EditorIteratorAttributeAssignmentNode_1= ruleEditorIteratorAttributeAssignmentNode ) ;
    public final EObject ruleEditorIteratorAttributeAssignment() throws RecognitionException {
        EObject current = null;

        EObject this_EditorIteratorAttributeAssignmentItr_0 = null;

        EObject this_EditorIteratorAttributeAssignmentNode_1 = null;



        	enterRule();

        try {
            // InternalGT.g:1448:2: ( (this_EditorIteratorAttributeAssignmentItr_0= ruleEditorIteratorAttributeAssignmentItr | this_EditorIteratorAttributeAssignmentNode_1= ruleEditorIteratorAttributeAssignmentNode ) )
            // InternalGT.g:1449:2: (this_EditorIteratorAttributeAssignmentItr_0= ruleEditorIteratorAttributeAssignmentItr | this_EditorIteratorAttributeAssignmentNode_1= ruleEditorIteratorAttributeAssignmentNode )
            {
            // InternalGT.g:1449:2: (this_EditorIteratorAttributeAssignmentItr_0= ruleEditorIteratorAttributeAssignmentItr | this_EditorIteratorAttributeAssignmentNode_1= ruleEditorIteratorAttributeAssignmentNode )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            else if ( (LA26_0==RULE_ID) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalGT.g:1450:3: this_EditorIteratorAttributeAssignmentItr_0= ruleEditorIteratorAttributeAssignmentItr
                    {

                    			newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getEditorIteratorAttributeAssignmentItrParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorIteratorAttributeAssignmentItr_0=ruleEditorIteratorAttributeAssignmentItr();

                    state._fsp--;


                    			current = this_EditorIteratorAttributeAssignmentItr_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGT.g:1459:3: this_EditorIteratorAttributeAssignmentNode_1= ruleEditorIteratorAttributeAssignmentNode
                    {

                    			newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getEditorIteratorAttributeAssignmentNodeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorIteratorAttributeAssignmentNode_1=ruleEditorIteratorAttributeAssignmentNode();

                    state._fsp--;


                    			current = this_EditorIteratorAttributeAssignmentNode_1;
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
    // $ANTLR end "ruleEditorIteratorAttributeAssignment"


    // $ANTLR start "entryRuleEditorIteratorAttributeAssignmentItr"
    // InternalGT.g:1471:1: entryRuleEditorIteratorAttributeAssignmentItr returns [EObject current=null] : iv_ruleEditorIteratorAttributeAssignmentItr= ruleEditorIteratorAttributeAssignmentItr EOF ;
    public final EObject entryRuleEditorIteratorAttributeAssignmentItr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorIteratorAttributeAssignmentItr = null;


        try {
            // InternalGT.g:1471:77: (iv_ruleEditorIteratorAttributeAssignmentItr= ruleEditorIteratorAttributeAssignmentItr EOF )
            // InternalGT.g:1472:2: iv_ruleEditorIteratorAttributeAssignmentItr= ruleEditorIteratorAttributeAssignmentItr EOF
            {
             newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentItrRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorIteratorAttributeAssignmentItr=ruleEditorIteratorAttributeAssignmentItr();

            state._fsp--;

             current =iv_ruleEditorIteratorAttributeAssignmentItr; 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeAssignmentItr"


    // $ANTLR start "ruleEditorIteratorAttributeAssignmentItr"
    // InternalGT.g:1478:1: ruleEditorIteratorAttributeAssignmentItr returns [EObject current=null] : ( ( (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) ) ;
    public final EObject ruleEditorIteratorAttributeAssignmentItr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_iteratorAttribute_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1484:2: ( ( ( (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) ) )
            // InternalGT.g:1485:2: ( ( (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) )
            {
            // InternalGT.g:1485:2: ( ( (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) )
            // InternalGT.g:1486:3: ( (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) )
            {
            // InternalGT.g:1486:3: ( (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression ) )
            // InternalGT.g:1487:4: (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression )
            {
            // InternalGT.g:1487:4: (lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression )
            // InternalGT.g:1488:5: lv_iteratorAttribute_0_0= ruleEditorIteratorAttributeExpression
            {

            					newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getIteratorAttributeEditorIteratorAttributeExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_iteratorAttribute_0_0=ruleEditorIteratorAttributeExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorIteratorAttributeAssignmentItrRule());
            					}
            					set(
            						current,
            						"iteratorAttribute",
            						lv_iteratorAttribute_0_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorIteratorAttributeExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getColonEqualsSignKeyword_1());
            		
            // InternalGT.g:1509:3: ( (lv_value_2_0= ruleEditorExpression ) )
            // InternalGT.g:1510:4: (lv_value_2_0= ruleEditorExpression )
            {
            // InternalGT.g:1510:4: (lv_value_2_0= ruleEditorExpression )
            // InternalGT.g:1511:5: lv_value_2_0= ruleEditorExpression
            {

            					newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getValueEditorExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleEditorExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorIteratorAttributeAssignmentItrRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorExpression");
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
    // $ANTLR end "ruleEditorIteratorAttributeAssignmentItr"


    // $ANTLR start "entryRuleEditorIteratorAttributeAssignmentNode"
    // InternalGT.g:1532:1: entryRuleEditorIteratorAttributeAssignmentNode returns [EObject current=null] : iv_ruleEditorIteratorAttributeAssignmentNode= ruleEditorIteratorAttributeAssignmentNode EOF ;
    public final EObject entryRuleEditorIteratorAttributeAssignmentNode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorIteratorAttributeAssignmentNode = null;


        try {
            // InternalGT.g:1532:78: (iv_ruleEditorIteratorAttributeAssignmentNode= ruleEditorIteratorAttributeAssignmentNode EOF )
            // InternalGT.g:1533:2: iv_ruleEditorIteratorAttributeAssignmentNode= ruleEditorIteratorAttributeAssignmentNode EOF
            {
             newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorIteratorAttributeAssignmentNode=ruleEditorIteratorAttributeAssignmentNode();

            state._fsp--;

             current =iv_ruleEditorIteratorAttributeAssignmentNode; 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeAssignmentNode"


    // $ANTLR start "ruleEditorIteratorAttributeAssignmentNode"
    // InternalGT.g:1539:1: ruleEditorIteratorAttributeAssignmentNode returns [EObject current=null] : ( ( (lv_nodeAttribute_0_0= ruleEditorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) ) ;
    public final EObject ruleEditorIteratorAttributeAssignmentNode() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_nodeAttribute_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1545:2: ( ( ( (lv_nodeAttribute_0_0= ruleEditorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) ) )
            // InternalGT.g:1546:2: ( ( (lv_nodeAttribute_0_0= ruleEditorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) )
            {
            // InternalGT.g:1546:2: ( ( (lv_nodeAttribute_0_0= ruleEditorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) ) )
            // InternalGT.g:1547:3: ( (lv_nodeAttribute_0_0= ruleEditorAttributeExpression ) ) otherlv_1= ':=' ( (lv_value_2_0= ruleEditorExpression ) )
            {
            // InternalGT.g:1547:3: ( (lv_nodeAttribute_0_0= ruleEditorAttributeExpression ) )
            // InternalGT.g:1548:4: (lv_nodeAttribute_0_0= ruleEditorAttributeExpression )
            {
            // InternalGT.g:1548:4: (lv_nodeAttribute_0_0= ruleEditorAttributeExpression )
            // InternalGT.g:1549:5: lv_nodeAttribute_0_0= ruleEditorAttributeExpression
            {

            					newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getNodeAttributeEditorAttributeExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_23);
            lv_nodeAttribute_0_0=ruleEditorAttributeExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorIteratorAttributeAssignmentNodeRule());
            					}
            					set(
            						current,
            						"nodeAttribute",
            						lv_nodeAttribute_0_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorAttributeExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,26,FOLLOW_21); 

            			newLeafNode(otherlv_1, grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getColonEqualsSignKeyword_1());
            		
            // InternalGT.g:1570:3: ( (lv_value_2_0= ruleEditorExpression ) )
            // InternalGT.g:1571:4: (lv_value_2_0= ruleEditorExpression )
            {
            // InternalGT.g:1571:4: (lv_value_2_0= ruleEditorExpression )
            // InternalGT.g:1572:5: lv_value_2_0= ruleEditorExpression
            {

            					newCompositeNode(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getValueEditorExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleEditorExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorIteratorAttributeAssignmentNodeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorExpression");
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
    // $ANTLR end "ruleEditorIteratorAttributeAssignmentNode"


    // $ANTLR start "entryRuleEditorIteratorReference"
    // InternalGT.g:1593:1: entryRuleEditorIteratorReference returns [EObject current=null] : iv_ruleEditorIteratorReference= ruleEditorIteratorReference EOF ;
    public final EObject entryRuleEditorIteratorReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorIteratorReference = null;


        try {
            // InternalGT.g:1593:64: (iv_ruleEditorIteratorReference= ruleEditorIteratorReference EOF )
            // InternalGT.g:1594:2: iv_ruleEditorIteratorReference= ruleEditorIteratorReference EOF
            {
             newCompositeNode(grammarAccess.getEditorIteratorReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorIteratorReference=ruleEditorIteratorReference();

            state._fsp--;

             current =iv_ruleEditorIteratorReference; 
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
    // $ANTLR end "entryRuleEditorIteratorReference"


    // $ANTLR start "ruleEditorIteratorReference"
    // InternalGT.g:1600:1: ruleEditorIteratorReference returns [EObject current=null] : ( ( (lv_operator_0_0= ruleEditorOperator ) ) ( (otherlv_1= RULE_ID ) ) otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) ) ;
    public final EObject ruleEditorIteratorReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Enumerator lv_operator_0_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1606:2: ( ( ( (lv_operator_0_0= ruleEditorOperator ) ) ( (otherlv_1= RULE_ID ) ) otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) ) )
            // InternalGT.g:1607:2: ( ( (lv_operator_0_0= ruleEditorOperator ) ) ( (otherlv_1= RULE_ID ) ) otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )
            {
            // InternalGT.g:1607:2: ( ( (lv_operator_0_0= ruleEditorOperator ) ) ( (otherlv_1= RULE_ID ) ) otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )
            // InternalGT.g:1608:3: ( (lv_operator_0_0= ruleEditorOperator ) ) ( (otherlv_1= RULE_ID ) ) otherlv_2= '-' ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) )
            {
            // InternalGT.g:1608:3: ( (lv_operator_0_0= ruleEditorOperator ) )
            // InternalGT.g:1609:4: (lv_operator_0_0= ruleEditorOperator )
            {
            // InternalGT.g:1609:4: (lv_operator_0_0= ruleEditorOperator )
            // InternalGT.g:1610:5: lv_operator_0_0= ruleEditorOperator
            {

            					newCompositeNode(grammarAccess.getEditorIteratorReferenceAccess().getOperatorEditorOperatorEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_7);
            lv_operator_0_0=ruleEditorOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorIteratorReferenceRule());
            					}
            					set(
            						current,
            						"operator",
            						lv_operator_0_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGT.g:1627:3: ( (otherlv_1= RULE_ID ) )
            // InternalGT.g:1628:4: (otherlv_1= RULE_ID )
            {
            // InternalGT.g:1628:4: (otherlv_1= RULE_ID )
            // InternalGT.g:1629:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorIteratorReferenceRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(otherlv_1, grammarAccess.getEditorIteratorReferenceAccess().getSourceEditorNodeCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,30,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getEditorIteratorReferenceAccess().getHyphenMinusKeyword_2());
            		
            // InternalGT.g:1644:3: ( (otherlv_3= RULE_ID ) )
            // InternalGT.g:1645:4: (otherlv_3= RULE_ID )
            {
            // InternalGT.g:1645:4: (otherlv_3= RULE_ID )
            // InternalGT.g:1646:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorIteratorReferenceRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_3, grammarAccess.getEditorIteratorReferenceAccess().getTypeEReferenceCrossReference_3_0());
            				

            }


            }

            otherlv_4=(Token)match(input,33,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getEditorIteratorReferenceAccess().getHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalGT.g:1661:3: ( (otherlv_5= RULE_ID ) )
            // InternalGT.g:1662:4: (otherlv_5= RULE_ID )
            {
            // InternalGT.g:1662:4: (otherlv_5= RULE_ID )
            // InternalGT.g:1663:5: otherlv_5= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorIteratorReferenceRule());
            					}
            				
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_5, grammarAccess.getEditorIteratorReferenceAccess().getTargetEditorReferenceIteratorCrossReference_5_0());
            				

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
    // $ANTLR end "ruleEditorIteratorReference"


    // $ANTLR start "entryRuleEditorCondition"
    // InternalGT.g:1678:1: entryRuleEditorCondition returns [EObject current=null] : iv_ruleEditorCondition= ruleEditorCondition EOF ;
    public final EObject entryRuleEditorCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorCondition = null;


        try {
            // InternalGT.g:1678:56: (iv_ruleEditorCondition= ruleEditorCondition EOF )
            // InternalGT.g:1679:2: iv_ruleEditorCondition= ruleEditorCondition EOF
            {
             newCompositeNode(grammarAccess.getEditorConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorCondition=ruleEditorCondition();

            state._fsp--;

             current =iv_ruleEditorCondition; 
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
    // $ANTLR end "entryRuleEditorCondition"


    // $ANTLR start "ruleEditorCondition"
    // InternalGT.g:1685:1: ruleEditorCondition returns [EObject current=null] : (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_conditions_3_0= ruleEditorSimpleCondition ) ) (otherlv_4= '&&' ( (lv_conditions_5_0= ruleEditorSimpleCondition ) ) )* ) ;
    public final EObject ruleEditorCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_conditions_3_0 = null;

        EObject lv_conditions_5_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1691:2: ( (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_conditions_3_0= ruleEditorSimpleCondition ) ) (otherlv_4= '&&' ( (lv_conditions_5_0= ruleEditorSimpleCondition ) ) )* ) )
            // InternalGT.g:1692:2: (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_conditions_3_0= ruleEditorSimpleCondition ) ) (otherlv_4= '&&' ( (lv_conditions_5_0= ruleEditorSimpleCondition ) ) )* )
            {
            // InternalGT.g:1692:2: (otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_conditions_3_0= ruleEditorSimpleCondition ) ) (otherlv_4= '&&' ( (lv_conditions_5_0= ruleEditorSimpleCondition ) ) )* )
            // InternalGT.g:1693:3: otherlv_0= 'condition' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_conditions_3_0= ruleEditorSimpleCondition ) ) (otherlv_4= '&&' ( (lv_conditions_5_0= ruleEditorSimpleCondition ) ) )*
            {
            otherlv_0=(Token)match(input,38,FOLLOW_7); 

            			newLeafNode(otherlv_0, grammarAccess.getEditorConditionAccess().getConditionKeyword_0());
            		
            // InternalGT.g:1697:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalGT.g:1698:4: (lv_name_1_0= RULE_ID )
            {
            // InternalGT.g:1698:4: (lv_name_1_0= RULE_ID )
            // InternalGT.g:1699:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEditorConditionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEditorConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_37); 

            			newLeafNode(otherlv_2, grammarAccess.getEditorConditionAccess().getEqualsSignKeyword_2());
            		
            // InternalGT.g:1719:3: ( (lv_conditions_3_0= ruleEditorSimpleCondition ) )
            // InternalGT.g:1720:4: (lv_conditions_3_0= ruleEditorSimpleCondition )
            {
            // InternalGT.g:1720:4: (lv_conditions_3_0= ruleEditorSimpleCondition )
            // InternalGT.g:1721:5: lv_conditions_3_0= ruleEditorSimpleCondition
            {

            					newCompositeNode(grammarAccess.getEditorConditionAccess().getConditionsEditorSimpleConditionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_38);
            lv_conditions_3_0=ruleEditorSimpleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEditorConditionRule());
            					}
            					add(
            						current,
            						"conditions",
            						lv_conditions_3_0,
            						"org.emoflon.ibex.gt.editor.GT.EditorSimpleCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGT.g:1738:3: (otherlv_4= '&&' ( (lv_conditions_5_0= ruleEditorSimpleCondition ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==40) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalGT.g:1739:4: otherlv_4= '&&' ( (lv_conditions_5_0= ruleEditorSimpleCondition ) )
            	    {
            	    otherlv_4=(Token)match(input,40,FOLLOW_37); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEditorConditionAccess().getAmpersandAmpersandKeyword_4_0());
            	    			
            	    // InternalGT.g:1743:4: ( (lv_conditions_5_0= ruleEditorSimpleCondition ) )
            	    // InternalGT.g:1744:5: (lv_conditions_5_0= ruleEditorSimpleCondition )
            	    {
            	    // InternalGT.g:1744:5: (lv_conditions_5_0= ruleEditorSimpleCondition )
            	    // InternalGT.g:1745:6: lv_conditions_5_0= ruleEditorSimpleCondition
            	    {

            	    						newCompositeNode(grammarAccess.getEditorConditionAccess().getConditionsEditorSimpleConditionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_38);
            	    lv_conditions_5_0=ruleEditorSimpleCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEditorConditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conditions",
            	    							lv_conditions_5_0,
            	    							"org.emoflon.ibex.gt.editor.GT.EditorSimpleCondition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // $ANTLR end "ruleEditorCondition"


    // $ANTLR start "entryRuleEditorSimpleCondition"
    // InternalGT.g:1767:1: entryRuleEditorSimpleCondition returns [EObject current=null] : iv_ruleEditorSimpleCondition= ruleEditorSimpleCondition EOF ;
    public final EObject entryRuleEditorSimpleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorSimpleCondition = null;


        try {
            // InternalGT.g:1767:62: (iv_ruleEditorSimpleCondition= ruleEditorSimpleCondition EOF )
            // InternalGT.g:1768:2: iv_ruleEditorSimpleCondition= ruleEditorSimpleCondition EOF
            {
             newCompositeNode(grammarAccess.getEditorSimpleConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorSimpleCondition=ruleEditorSimpleCondition();

            state._fsp--;

             current =iv_ruleEditorSimpleCondition; 
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
    // $ANTLR end "entryRuleEditorSimpleCondition"


    // $ANTLR start "ruleEditorSimpleCondition"
    // InternalGT.g:1774:1: ruleEditorSimpleCondition returns [EObject current=null] : ( ( () ( (otherlv_1= RULE_ID ) ) ) | ( () ( (lv_type_3_0= ruleEditorApplicationConditionType ) ) ( (otherlv_4= RULE_ID ) ) ) ) ;
    public final EObject ruleEditorSimpleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1780:2: ( ( ( () ( (otherlv_1= RULE_ID ) ) ) | ( () ( (lv_type_3_0= ruleEditorApplicationConditionType ) ) ( (otherlv_4= RULE_ID ) ) ) ) )
            // InternalGT.g:1781:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) | ( () ( (lv_type_3_0= ruleEditorApplicationConditionType ) ) ( (otherlv_4= RULE_ID ) ) ) )
            {
            // InternalGT.g:1781:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) | ( () ( (lv_type_3_0= ruleEditorApplicationConditionType ) ) ( (otherlv_4= RULE_ID ) ) ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            else if ( ((LA28_0>=51 && LA28_0<=52)) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalGT.g:1782:3: ( () ( (otherlv_1= RULE_ID ) ) )
                    {
                    // InternalGT.g:1782:3: ( () ( (otherlv_1= RULE_ID ) ) )
                    // InternalGT.g:1783:4: () ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalGT.g:1783:4: ()
                    // InternalGT.g:1784:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getEditorSimpleConditionAccess().getEditorConditionReferenceAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGT.g:1790:4: ( (otherlv_1= RULE_ID ) )
                    // InternalGT.g:1791:5: (otherlv_1= RULE_ID )
                    {
                    // InternalGT.g:1791:5: (otherlv_1= RULE_ID )
                    // InternalGT.g:1792:6: otherlv_1= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEditorSimpleConditionRule());
                    						}
                    					
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_1, grammarAccess.getEditorSimpleConditionAccess().getConditionEditorConditionCrossReference_0_1_0());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1805:3: ( () ( (lv_type_3_0= ruleEditorApplicationConditionType ) ) ( (otherlv_4= RULE_ID ) ) )
                    {
                    // InternalGT.g:1805:3: ( () ( (lv_type_3_0= ruleEditorApplicationConditionType ) ) ( (otherlv_4= RULE_ID ) ) )
                    // InternalGT.g:1806:4: () ( (lv_type_3_0= ruleEditorApplicationConditionType ) ) ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalGT.g:1806:4: ()
                    // InternalGT.g:1807:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getEditorSimpleConditionAccess().getEditorApplicationConditionAction_1_0(),
                    						current);
                    				

                    }

                    // InternalGT.g:1813:4: ( (lv_type_3_0= ruleEditorApplicationConditionType ) )
                    // InternalGT.g:1814:5: (lv_type_3_0= ruleEditorApplicationConditionType )
                    {
                    // InternalGT.g:1814:5: (lv_type_3_0= ruleEditorApplicationConditionType )
                    // InternalGT.g:1815:6: lv_type_3_0= ruleEditorApplicationConditionType
                    {

                    						newCompositeNode(grammarAccess.getEditorSimpleConditionAccess().getTypeEditorApplicationConditionTypeEnumRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_type_3_0=ruleEditorApplicationConditionType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEditorSimpleConditionRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_3_0,
                    							"org.emoflon.ibex.gt.editor.GT.EditorApplicationConditionType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalGT.g:1832:4: ( (otherlv_4= RULE_ID ) )
                    // InternalGT.g:1833:5: (otherlv_4= RULE_ID )
                    {
                    // InternalGT.g:1833:5: (otherlv_4= RULE_ID )
                    // InternalGT.g:1834:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEditorSimpleConditionRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_4, grammarAccess.getEditorSimpleConditionAccess().getPatternEditorPatternCrossReference_1_2_0());
                    					

                    }


                    }


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
    // $ANTLR end "ruleEditorSimpleCondition"


    // $ANTLR start "entryRuleEditorProbability"
    // InternalGT.g:1850:1: entryRuleEditorProbability returns [EObject current=null] : iv_ruleEditorProbability= ruleEditorProbability EOF ;
    public final EObject entryRuleEditorProbability() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEditorProbability = null;


        try {
            // InternalGT.g:1850:58: (iv_ruleEditorProbability= ruleEditorProbability EOF )
            // InternalGT.g:1851:2: iv_ruleEditorProbability= ruleEditorProbability EOF
            {
             newCompositeNode(grammarAccess.getEditorProbabilityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEditorProbability=ruleEditorProbability();

            state._fsp--;

             current =iv_ruleEditorProbability; 
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
    // $ANTLR end "entryRuleEditorProbability"


    // $ANTLR start "ruleEditorProbability"
    // InternalGT.g:1857:1: ruleEditorProbability returns [EObject current=null] : (this_StochasticFunction_0= ruleStochasticFunction | this_ArithmeticExpression_1= ruleArithmeticExpression ) ;
    public final EObject ruleEditorProbability() throws RecognitionException {
        EObject current = null;

        EObject this_StochasticFunction_0 = null;

        EObject this_ArithmeticExpression_1 = null;



        	enterRule();

        try {
            // InternalGT.g:1863:2: ( (this_StochasticFunction_0= ruleStochasticFunction | this_ArithmeticExpression_1= ruleArithmeticExpression ) )
            // InternalGT.g:1864:2: (this_StochasticFunction_0= ruleStochasticFunction | this_ArithmeticExpression_1= ruleArithmeticExpression )
            {
            // InternalGT.g:1864:2: (this_StochasticFunction_0= ruleStochasticFunction | this_ArithmeticExpression_1= ruleArithmeticExpression )
            int alt29=2;
            switch ( input.LA(1) ) {
            case 53:
            case 54:
            case 55:
            case 56:
                {
                alt29=1;
                }
                break;
            case 30:
                {
                int LA29_2 = input.LA(2);

                if ( (LA29_2==RULE_INT||LA29_2==13||(LA29_2>=62 && LA29_2<=69)) ) {
                    alt29=2;
                }
                else if ( ((LA29_2>=54 && LA29_2<=56)) ) {
                    alt29=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 13:
            case 27:
            case 28:
            case 29:
            case 37:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                {
                alt29=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalGT.g:1865:3: this_StochasticFunction_0= ruleStochasticFunction
                    {

                    			newCompositeNode(grammarAccess.getEditorProbabilityAccess().getStochasticFunctionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StochasticFunction_0=ruleStochasticFunction();

                    state._fsp--;


                    			current = this_StochasticFunction_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGT.g:1874:3: this_ArithmeticExpression_1= ruleArithmeticExpression
                    {

                    			newCompositeNode(grammarAccess.getEditorProbabilityAccess().getArithmeticExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithmeticExpression_1=ruleArithmeticExpression();

                    state._fsp--;


                    			current = this_ArithmeticExpression_1;
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
    // $ANTLR end "ruleEditorProbability"


    // $ANTLR start "entryRuleStochasticFunction"
    // InternalGT.g:1886:1: entryRuleStochasticFunction returns [EObject current=null] : iv_ruleStochasticFunction= ruleStochasticFunction EOF ;
    public final EObject entryRuleStochasticFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStochasticFunction = null;


        try {
            // InternalGT.g:1886:59: (iv_ruleStochasticFunction= ruleStochasticFunction EOF )
            // InternalGT.g:1887:2: iv_ruleStochasticFunction= ruleStochasticFunction EOF
            {
             newCompositeNode(grammarAccess.getStochasticFunctionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStochasticFunction=ruleStochasticFunction();

            state._fsp--;

             current =iv_ruleStochasticFunction; 
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
    // $ANTLR end "entryRuleStochasticFunction"


    // $ANTLR start "ruleStochasticFunction"
    // InternalGT.g:1893:1: ruleStochasticFunction returns [EObject current=null] : ( ( (lv_functionExpression_0_0= ruleStochasticFunctionExpression ) ) ( (lv_parameter_1_0= ruleArithmeticExpression ) )? ) ;
    public final EObject ruleStochasticFunction() throws RecognitionException {
        EObject current = null;

        EObject lv_functionExpression_0_0 = null;

        EObject lv_parameter_1_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1899:2: ( ( ( (lv_functionExpression_0_0= ruleStochasticFunctionExpression ) ) ( (lv_parameter_1_0= ruleArithmeticExpression ) )? ) )
            // InternalGT.g:1900:2: ( ( (lv_functionExpression_0_0= ruleStochasticFunctionExpression ) ) ( (lv_parameter_1_0= ruleArithmeticExpression ) )? )
            {
            // InternalGT.g:1900:2: ( ( (lv_functionExpression_0_0= ruleStochasticFunctionExpression ) ) ( (lv_parameter_1_0= ruleArithmeticExpression ) )? )
            // InternalGT.g:1901:3: ( (lv_functionExpression_0_0= ruleStochasticFunctionExpression ) ) ( (lv_parameter_1_0= ruleArithmeticExpression ) )?
            {
            // InternalGT.g:1901:3: ( (lv_functionExpression_0_0= ruleStochasticFunctionExpression ) )
            // InternalGT.g:1902:4: (lv_functionExpression_0_0= ruleStochasticFunctionExpression )
            {
            // InternalGT.g:1902:4: (lv_functionExpression_0_0= ruleStochasticFunctionExpression )
            // InternalGT.g:1903:5: lv_functionExpression_0_0= ruleStochasticFunctionExpression
            {

            					newCompositeNode(grammarAccess.getStochasticFunctionAccess().getFunctionExpressionStochasticFunctionExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_39);
            lv_functionExpression_0_0=ruleStochasticFunctionExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStochasticFunctionRule());
            					}
            					set(
            						current,
            						"functionExpression",
            						lv_functionExpression_0_0,
            						"org.emoflon.ibex.gt.editor.GT.StochasticFunctionExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGT.g:1920:3: ( (lv_parameter_1_0= ruleArithmeticExpression ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_INT)||LA30_0==13||(LA30_0>=27 && LA30_0<=30)||LA30_0==37||(LA30_0>=60 && LA30_0<=69)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalGT.g:1921:4: (lv_parameter_1_0= ruleArithmeticExpression )
                    {
                    // InternalGT.g:1921:4: (lv_parameter_1_0= ruleArithmeticExpression )
                    // InternalGT.g:1922:5: lv_parameter_1_0= ruleArithmeticExpression
                    {

                    					newCompositeNode(grammarAccess.getStochasticFunctionAccess().getParameterArithmeticExpressionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_parameter_1_0=ruleArithmeticExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStochasticFunctionRule());
                    					}
                    					set(
                    						current,
                    						"parameter",
                    						lv_parameter_1_0,
                    						"org.emoflon.ibex.gt.editor.GT.ArithmeticExpression");
                    					afterParserOrEnumRuleCall();
                    				

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
    // $ANTLR end "ruleStochasticFunction"


    // $ANTLR start "entryRuleStochasticFunctionExpression"
    // InternalGT.g:1943:1: entryRuleStochasticFunctionExpression returns [EObject current=null] : iv_ruleStochasticFunctionExpression= ruleStochasticFunctionExpression EOF ;
    public final EObject entryRuleStochasticFunctionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStochasticFunctionExpression = null;


        try {
            // InternalGT.g:1943:69: (iv_ruleStochasticFunctionExpression= ruleStochasticFunctionExpression EOF )
            // InternalGT.g:1944:2: iv_ruleStochasticFunctionExpression= ruleStochasticFunctionExpression EOF
            {
             newCompositeNode(grammarAccess.getStochasticFunctionExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStochasticFunctionExpression=ruleStochasticFunctionExpression();

            state._fsp--;

             current =iv_ruleStochasticFunctionExpression; 
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
    // $ANTLR end "entryRuleStochasticFunctionExpression"


    // $ANTLR start "ruleStochasticFunctionExpression"
    // InternalGT.g:1950:1: ruleStochasticFunctionExpression returns [EObject current=null] : ( ( (lv_operatorRange_0_0= ruleStochasticRange ) )? ( (lv_distribution_1_0= ruleStochasticDistribution ) ) otherlv_2= '(' ( (lv_mean_3_0= ruleArithmeticExpression ) ) ( ( (lv_hasSd_4_0= ',' ) ) ( (lv_sd_5_0= ruleArithmeticExpression ) ) )? otherlv_6= ')' ) ;
    public final EObject ruleStochasticFunctionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_hasSd_4_0=null;
        Token otherlv_6=null;
        Enumerator lv_operatorRange_0_0 = null;

        Enumerator lv_distribution_1_0 = null;

        EObject lv_mean_3_0 = null;

        EObject lv_sd_5_0 = null;



        	enterRule();

        try {
            // InternalGT.g:1956:2: ( ( ( (lv_operatorRange_0_0= ruleStochasticRange ) )? ( (lv_distribution_1_0= ruleStochasticDistribution ) ) otherlv_2= '(' ( (lv_mean_3_0= ruleArithmeticExpression ) ) ( ( (lv_hasSd_4_0= ',' ) ) ( (lv_sd_5_0= ruleArithmeticExpression ) ) )? otherlv_6= ')' ) )
            // InternalGT.g:1957:2: ( ( (lv_operatorRange_0_0= ruleStochasticRange ) )? ( (lv_distribution_1_0= ruleStochasticDistribution ) ) otherlv_2= '(' ( (lv_mean_3_0= ruleArithmeticExpression ) ) ( ( (lv_hasSd_4_0= ',' ) ) ( (lv_sd_5_0= ruleArithmeticExpression ) ) )? otherlv_6= ')' )
            {
            // InternalGT.g:1957:2: ( ( (lv_operatorRange_0_0= ruleStochasticRange ) )? ( (lv_distribution_1_0= ruleStochasticDistribution ) ) otherlv_2= '(' ( (lv_mean_3_0= ruleArithmeticExpression ) ) ( ( (lv_hasSd_4_0= ',' ) ) ( (lv_sd_5_0= ruleArithmeticExpression ) ) )? otherlv_6= ')' )
            // InternalGT.g:1958:3: ( (lv_operatorRange_0_0= ruleStochasticRange ) )? ( (lv_distribution_1_0= ruleStochasticDistribution ) ) otherlv_2= '(' ( (lv_mean_3_0= ruleArithmeticExpression ) ) ( ( (lv_hasSd_4_0= ',' ) ) ( (lv_sd_5_0= ruleArithmeticExpression ) ) )? otherlv_6= ')'
            {
            // InternalGT.g:1958:3: ( (lv_operatorRange_0_0= ruleStochasticRange ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==30||LA31_0==53) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalGT.g:1959:4: (lv_operatorRange_0_0= ruleStochasticRange )
                    {
                    // InternalGT.g:1959:4: (lv_operatorRange_0_0= ruleStochasticRange )
                    // InternalGT.g:1960:5: lv_operatorRange_0_0= ruleStochasticRange
                    {

                    					newCompositeNode(grammarAccess.getStochasticFunctionExpressionAccess().getOperatorRangeStochasticRangeEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_40);
                    lv_operatorRange_0_0=ruleStochasticRange();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStochasticFunctionExpressionRule());
                    					}
                    					set(
                    						current,
                    						"operatorRange",
                    						lv_operatorRange_0_0,
                    						"org.emoflon.ibex.gt.editor.GT.StochasticRange");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalGT.g:1977:3: ( (lv_distribution_1_0= ruleStochasticDistribution ) )
            // InternalGT.g:1978:4: (lv_distribution_1_0= ruleStochasticDistribution )
            {
            // InternalGT.g:1978:4: (lv_distribution_1_0= ruleStochasticDistribution )
            // InternalGT.g:1979:5: lv_distribution_1_0= ruleStochasticDistribution
            {

            					newCompositeNode(grammarAccess.getStochasticFunctionExpressionAccess().getDistributionStochasticDistributionEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_distribution_1_0=ruleStochasticDistribution();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStochasticFunctionExpressionRule());
            					}
            					set(
            						current,
            						"distribution",
            						lv_distribution_1_0,
            						"org.emoflon.ibex.gt.editor.GT.StochasticDistribution");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getStochasticFunctionExpressionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalGT.g:2000:3: ( (lv_mean_3_0= ruleArithmeticExpression ) )
            // InternalGT.g:2001:4: (lv_mean_3_0= ruleArithmeticExpression )
            {
            // InternalGT.g:2001:4: (lv_mean_3_0= ruleArithmeticExpression )
            // InternalGT.g:2002:5: lv_mean_3_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getStochasticFunctionExpressionAccess().getMeanArithmeticExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_10);
            lv_mean_3_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStochasticFunctionExpressionRule());
            					}
            					set(
            						current,
            						"mean",
            						lv_mean_3_0,
            						"org.emoflon.ibex.gt.editor.GT.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalGT.g:2019:3: ( ( (lv_hasSd_4_0= ',' ) ) ( (lv_sd_5_0= ruleArithmeticExpression ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==14) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalGT.g:2020:4: ( (lv_hasSd_4_0= ',' ) ) ( (lv_sd_5_0= ruleArithmeticExpression ) )
                    {
                    // InternalGT.g:2020:4: ( (lv_hasSd_4_0= ',' ) )
                    // InternalGT.g:2021:5: (lv_hasSd_4_0= ',' )
                    {
                    // InternalGT.g:2021:5: (lv_hasSd_4_0= ',' )
                    // InternalGT.g:2022:6: lv_hasSd_4_0= ','
                    {
                    lv_hasSd_4_0=(Token)match(input,14,FOLLOW_16); 

                    						newLeafNode(lv_hasSd_4_0, grammarAccess.getStochasticFunctionExpressionAccess().getHasSdCommaKeyword_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStochasticFunctionExpressionRule());
                    						}
                    						setWithLastConsumed(current, "hasSd", lv_hasSd_4_0 != null, ",");
                    					

                    }


                    }

                    // InternalGT.g:2034:4: ( (lv_sd_5_0= ruleArithmeticExpression ) )
                    // InternalGT.g:2035:5: (lv_sd_5_0= ruleArithmeticExpression )
                    {
                    // InternalGT.g:2035:5: (lv_sd_5_0= ruleArithmeticExpression )
                    // InternalGT.g:2036:6: lv_sd_5_0= ruleArithmeticExpression
                    {

                    						newCompositeNode(grammarAccess.getStochasticFunctionExpressionAccess().getSdArithmeticExpressionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_sd_5_0=ruleArithmeticExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStochasticFunctionExpressionRule());
                    						}
                    						set(
                    							current,
                    							"sd",
                    							lv_sd_5_0,
                    							"org.emoflon.ibex.gt.editor.GT.ArithmeticExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getStochasticFunctionExpressionAccess().getRightParenthesisKeyword_5());
            		

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
    // $ANTLR end "ruleStochasticFunctionExpression"


    // $ANTLR start "entryRuleArithmeticCalculationExpression"
    // InternalGT.g:2062:1: entryRuleArithmeticCalculationExpression returns [EObject current=null] : iv_ruleArithmeticCalculationExpression= ruleArithmeticCalculationExpression EOF ;
    public final EObject entryRuleArithmeticCalculationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticCalculationExpression = null;


        try {
            // InternalGT.g:2062:72: (iv_ruleArithmeticCalculationExpression= ruleArithmeticCalculationExpression EOF )
            // InternalGT.g:2063:2: iv_ruleArithmeticCalculationExpression= ruleArithmeticCalculationExpression EOF
            {
             newCompositeNode(grammarAccess.getArithmeticCalculationExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticCalculationExpression=ruleArithmeticCalculationExpression();

            state._fsp--;

             current =iv_ruleArithmeticCalculationExpression; 
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
    // $ANTLR end "entryRuleArithmeticCalculationExpression"


    // $ANTLR start "ruleArithmeticCalculationExpression"
    // InternalGT.g:2069:1: ruleArithmeticCalculationExpression returns [EObject current=null] : ( (lv_expression_0_0= ruleArithmeticExpression ) ) ;
    public final EObject ruleArithmeticCalculationExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalGT.g:2075:2: ( ( (lv_expression_0_0= ruleArithmeticExpression ) ) )
            // InternalGT.g:2076:2: ( (lv_expression_0_0= ruleArithmeticExpression ) )
            {
            // InternalGT.g:2076:2: ( (lv_expression_0_0= ruleArithmeticExpression ) )
            // InternalGT.g:2077:3: (lv_expression_0_0= ruleArithmeticExpression )
            {
            // InternalGT.g:2077:3: (lv_expression_0_0= ruleArithmeticExpression )
            // InternalGT.g:2078:4: lv_expression_0_0= ruleArithmeticExpression
            {

            				newCompositeNode(grammarAccess.getArithmeticCalculationExpressionAccess().getExpressionArithmeticExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_expression_0_0=ruleArithmeticExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getArithmeticCalculationExpressionRule());
            				}
            				set(
            					current,
            					"expression",
            					lv_expression_0_0,
            					"org.emoflon.ibex.gt.editor.GT.ArithmeticExpression");
            				afterParserOrEnumRuleCall();
            			

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
    // $ANTLR end "ruleArithmeticCalculationExpression"


    // $ANTLR start "entryRuleArithmeticExpression"
    // InternalGT.g:2098:1: entryRuleArithmeticExpression returns [EObject current=null] : iv_ruleArithmeticExpression= ruleArithmeticExpression EOF ;
    public final EObject entryRuleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticExpression = null;


        try {
            // InternalGT.g:2098:61: (iv_ruleArithmeticExpression= ruleArithmeticExpression EOF )
            // InternalGT.g:2099:2: iv_ruleArithmeticExpression= ruleArithmeticExpression EOF
            {
             newCompositeNode(grammarAccess.getArithmeticExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticExpression=ruleArithmeticExpression();

            state._fsp--;

             current =iv_ruleArithmeticExpression; 
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
    // $ANTLR end "entryRuleArithmeticExpression"


    // $ANTLR start "ruleArithmeticExpression"
    // InternalGT.g:2105:1: ruleArithmeticExpression returns [EObject current=null] : this_AddExpression_0= ruleAddExpression ;
    public final EObject ruleArithmeticExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AddExpression_0 = null;



        	enterRule();

        try {
            // InternalGT.g:2111:2: (this_AddExpression_0= ruleAddExpression )
            // InternalGT.g:2112:2: this_AddExpression_0= ruleAddExpression
            {

            		newCompositeNode(grammarAccess.getArithmeticExpressionAccess().getAddExpressionParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_AddExpression_0=ruleAddExpression();

            state._fsp--;


            		current = this_AddExpression_0;
            		afterParserOrEnumRuleCall();
            	

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
    // $ANTLR end "ruleArithmeticExpression"


    // $ANTLR start "entryRuleAddExpression"
    // InternalGT.g:2123:1: entryRuleAddExpression returns [EObject current=null] : iv_ruleAddExpression= ruleAddExpression EOF ;
    public final EObject entryRuleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddExpression = null;


        try {
            // InternalGT.g:2123:54: (iv_ruleAddExpression= ruleAddExpression EOF )
            // InternalGT.g:2124:2: iv_ruleAddExpression= ruleAddExpression EOF
            {
             newCompositeNode(grammarAccess.getAddExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddExpression=ruleAddExpression();

            state._fsp--;

             current =iv_ruleAddExpression; 
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
    // $ANTLR end "entryRuleAddExpression"


    // $ANTLR start "ruleAddExpression"
    // InternalGT.g:2130:1: ruleAddExpression returns [EObject current=null] : (this_MultExpression_0= ruleMultExpression ( () ( (lv_addOperator_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMultExpression ) ) )* ) ;
    public final EObject ruleAddExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultExpression_0 = null;

        Enumerator lv_addOperator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGT.g:2136:2: ( (this_MultExpression_0= ruleMultExpression ( () ( (lv_addOperator_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMultExpression ) ) )* ) )
            // InternalGT.g:2137:2: (this_MultExpression_0= ruleMultExpression ( () ( (lv_addOperator_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMultExpression ) ) )* )
            {
            // InternalGT.g:2137:2: (this_MultExpression_0= ruleMultExpression ( () ( (lv_addOperator_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMultExpression ) ) )* )
            // InternalGT.g:2138:3: this_MultExpression_0= ruleMultExpression ( () ( (lv_addOperator_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMultExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAddExpressionAccess().getMultExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_41);
            this_MultExpression_0=ruleMultExpression();

            state._fsp--;


            			current = this_MultExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalGT.g:2146:3: ( () ( (lv_addOperator_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMultExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==30) ) {
                    int LA33_2 = input.LA(2);

                    if ( (LA33_2==RULE_STRING||LA33_2==RULE_INT||LA33_2==13||(LA33_2>=27 && LA33_2<=30)||LA33_2==37||(LA33_2>=60 && LA33_2<=69)) ) {
                        alt33=1;
                    }
                    else if ( (LA33_2==RULE_ID) ) {
                        int LA33_4 = input.LA(3);

                        if ( (LA33_4==25) ) {
                            alt33=1;
                        }


                    }


                }
                else if ( (LA33_0==53) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalGT.g:2147:4: () ( (lv_addOperator_2_0= ruleAddOperator ) ) ( (lv_right_3_0= ruleMultExpression ) )
            	    {
            	    // InternalGT.g:2147:4: ()
            	    // InternalGT.g:2148:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAddExpressionAccess().getAddExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalGT.g:2154:4: ( (lv_addOperator_2_0= ruleAddOperator ) )
            	    // InternalGT.g:2155:5: (lv_addOperator_2_0= ruleAddOperator )
            	    {
            	    // InternalGT.g:2155:5: (lv_addOperator_2_0= ruleAddOperator )
            	    // InternalGT.g:2156:6: lv_addOperator_2_0= ruleAddOperator
            	    {

            	    						newCompositeNode(grammarAccess.getAddExpressionAccess().getAddOperatorAddOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_addOperator_2_0=ruleAddOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"addOperator",
            	    							lv_addOperator_2_0,
            	    							"org.emoflon.ibex.gt.editor.GT.AddOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalGT.g:2173:4: ( (lv_right_3_0= ruleMultExpression ) )
            	    // InternalGT.g:2174:5: (lv_right_3_0= ruleMultExpression )
            	    {
            	    // InternalGT.g:2174:5: (lv_right_3_0= ruleMultExpression )
            	    // InternalGT.g:2175:6: lv_right_3_0= ruleMultExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAddExpressionAccess().getRightMultExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_41);
            	    lv_right_3_0=ruleMultExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAddExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.emoflon.ibex.gt.editor.GT.MultExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // $ANTLR end "ruleAddExpression"


    // $ANTLR start "entryRuleMultExpression"
    // InternalGT.g:2197:1: entryRuleMultExpression returns [EObject current=null] : iv_ruleMultExpression= ruleMultExpression EOF ;
    public final EObject entryRuleMultExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultExpression = null;


        try {
            // InternalGT.g:2197:55: (iv_ruleMultExpression= ruleMultExpression EOF )
            // InternalGT.g:2198:2: iv_ruleMultExpression= ruleMultExpression EOF
            {
             newCompositeNode(grammarAccess.getMultExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultExpression=ruleMultExpression();

            state._fsp--;

             current =iv_ruleMultExpression; 
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
    // $ANTLR end "entryRuleMultExpression"


    // $ANTLR start "ruleMultExpression"
    // InternalGT.g:2204:1: ruleMultExpression returns [EObject current=null] : (this_ExpExpression_0= ruleExpExpression ( () ( (lv_multOperator_2_0= ruleMultOperator ) ) ( (lv_right_3_0= ruleExpExpression ) ) )* ) ;
    public final EObject ruleMultExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ExpExpression_0 = null;

        Enumerator lv_multOperator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalGT.g:2210:2: ( (this_ExpExpression_0= ruleExpExpression ( () ( (lv_multOperator_2_0= ruleMultOperator ) ) ( (lv_right_3_0= ruleExpExpression ) ) )* ) )
            // InternalGT.g:2211:2: (this_ExpExpression_0= ruleExpExpression ( () ( (lv_multOperator_2_0= ruleMultOperator ) ) ( (lv_right_3_0= ruleExpExpression ) ) )* )
            {
            // InternalGT.g:2211:2: (this_ExpExpression_0= ruleExpExpression ( () ( (lv_multOperator_2_0= ruleMultOperator ) ) ( (lv_right_3_0= ruleExpExpression ) ) )* )
            // InternalGT.g:2212:3: this_ExpExpression_0= ruleExpExpression ( () ( (lv_multOperator_2_0= ruleMultOperator ) ) ( (lv_right_3_0= ruleExpExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultExpressionAccess().getExpExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_42);
            this_ExpExpression_0=ruleExpExpression();

            state._fsp--;


            			current = this_ExpExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalGT.g:2220:3: ( () ( (lv_multOperator_2_0= ruleMultOperator ) ) ( (lv_right_3_0= ruleExpExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=57 && LA34_0<=59)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalGT.g:2221:4: () ( (lv_multOperator_2_0= ruleMultOperator ) ) ( (lv_right_3_0= ruleExpExpression ) )
            	    {
            	    // InternalGT.g:2221:4: ()
            	    // InternalGT.g:2222:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMultExpressionAccess().getMultExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalGT.g:2228:4: ( (lv_multOperator_2_0= ruleMultOperator ) )
            	    // InternalGT.g:2229:5: (lv_multOperator_2_0= ruleMultOperator )
            	    {
            	    // InternalGT.g:2229:5: (lv_multOperator_2_0= ruleMultOperator )
            	    // InternalGT.g:2230:6: lv_multOperator_2_0= ruleMultOperator
            	    {

            	    						newCompositeNode(grammarAccess.getMultExpressionAccess().getMultOperatorMultOperatorEnumRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_multOperator_2_0=ruleMultOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"multOperator",
            	    							lv_multOperator_2_0,
            	    							"org.emoflon.ibex.gt.editor.GT.MultOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalGT.g:2247:4: ( (lv_right_3_0= ruleExpExpression ) )
            	    // InternalGT.g:2248:5: (lv_right_3_0= ruleExpExpression )
            	    {
            	    // InternalGT.g:2248:5: (lv_right_3_0= ruleExpExpression )
            	    // InternalGT.g:2249:6: lv_right_3_0= ruleExpExpression
            	    {

            	    						newCompositeNode(grammarAccess.getMultExpressionAccess().getRightExpExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_42);
            	    lv_right_3_0=ruleExpExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultExpressionRule());
            	    						}
            	    						set(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.emoflon.ibex.gt.editor.GT.ExpExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // $ANTLR end "ruleMultExpression"


    // $ANTLR start "entryRuleExpExpression"
    // InternalGT.g:2271:1: entryRuleExpExpression returns [EObject current=null] : iv_ruleExpExpression= ruleExpExpression EOF ;
    public final EObject entryRuleExpExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpExpression = null;


        try {
            // InternalGT.g:2271:54: (iv_ruleExpExpression= ruleExpExpression EOF )
            // InternalGT.g:2272:2: iv_ruleExpExpression= ruleExpExpression EOF
            {
             newCompositeNode(grammarAccess.getExpExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpExpression=ruleExpExpression();

            state._fsp--;

             current =iv_ruleExpExpression; 
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
    // $ANTLR end "entryRuleExpExpression"


    // $ANTLR start "ruleExpExpression"
    // InternalGT.g:2278:1: ruleExpExpression returns [EObject current=null] : ( (this_MinMaxExpression_0= ruleMinMaxExpression | this_OneParameterArithmetics_1= ruleOneParameterArithmetics ) ( () otherlv_3= '^' ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) ) )* ) ;
    public final EObject ruleExpExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_MinMaxExpression_0 = null;

        EObject this_OneParameterArithmetics_1 = null;

        EObject lv_right_4_1 = null;

        EObject lv_right_4_2 = null;



        	enterRule();

        try {
            // InternalGT.g:2284:2: ( ( (this_MinMaxExpression_0= ruleMinMaxExpression | this_OneParameterArithmetics_1= ruleOneParameterArithmetics ) ( () otherlv_3= '^' ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) ) )* ) )
            // InternalGT.g:2285:2: ( (this_MinMaxExpression_0= ruleMinMaxExpression | this_OneParameterArithmetics_1= ruleOneParameterArithmetics ) ( () otherlv_3= '^' ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) ) )* )
            {
            // InternalGT.g:2285:2: ( (this_MinMaxExpression_0= ruleMinMaxExpression | this_OneParameterArithmetics_1= ruleOneParameterArithmetics ) ( () otherlv_3= '^' ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) ) )* )
            // InternalGT.g:2286:3: (this_MinMaxExpression_0= ruleMinMaxExpression | this_OneParameterArithmetics_1= ruleOneParameterArithmetics ) ( () otherlv_3= '^' ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) ) )*
            {
            // InternalGT.g:2286:3: (this_MinMaxExpression_0= ruleMinMaxExpression | this_OneParameterArithmetics_1= ruleOneParameterArithmetics )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=60 && LA35_0<=61)) ) {
                alt35=1;
            }
            else if ( ((LA35_0>=RULE_STRING && LA35_0<=RULE_INT)||LA35_0==13||(LA35_0>=27 && LA35_0<=30)||LA35_0==37||(LA35_0>=62 && LA35_0<=69)) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalGT.g:2287:4: this_MinMaxExpression_0= ruleMinMaxExpression
                    {

                    				newCompositeNode(grammarAccess.getExpExpressionAccess().getMinMaxExpressionParserRuleCall_0_0());
                    			
                    pushFollow(FOLLOW_43);
                    this_MinMaxExpression_0=ruleMinMaxExpression();

                    state._fsp--;


                    				current = this_MinMaxExpression_0;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;
                case 2 :
                    // InternalGT.g:2296:4: this_OneParameterArithmetics_1= ruleOneParameterArithmetics
                    {

                    				newCompositeNode(grammarAccess.getExpExpressionAccess().getOneParameterArithmeticsParserRuleCall_0_1());
                    			
                    pushFollow(FOLLOW_43);
                    this_OneParameterArithmetics_1=ruleOneParameterArithmetics();

                    state._fsp--;


                    				current = this_OneParameterArithmetics_1;
                    				afterParserOrEnumRuleCall();
                    			

                    }
                    break;

            }

            // InternalGT.g:2305:3: ( () otherlv_3= '^' ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==41) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalGT.g:2306:4: () otherlv_3= '^' ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) )
            	    {
            	    // InternalGT.g:2306:4: ()
            	    // InternalGT.g:2307:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getExpExpressionAccess().getExpExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_3=(Token)match(input,41,FOLLOW_16); 

            	    				newLeafNode(otherlv_3, grammarAccess.getExpExpressionAccess().getCircumflexAccentKeyword_1_1());
            	    			
            	    // InternalGT.g:2317:4: ( ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) ) )
            	    // InternalGT.g:2318:5: ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) )
            	    {
            	    // InternalGT.g:2318:5: ( (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics ) )
            	    // InternalGT.g:2319:6: (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics )
            	    {
            	    // InternalGT.g:2319:6: (lv_right_4_1= ruleMinMaxExpression | lv_right_4_2= ruleOneParameterArithmetics )
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( ((LA36_0>=60 && LA36_0<=61)) ) {
            	        alt36=1;
            	    }
            	    else if ( ((LA36_0>=RULE_STRING && LA36_0<=RULE_INT)||LA36_0==13||(LA36_0>=27 && LA36_0<=30)||LA36_0==37||(LA36_0>=62 && LA36_0<=69)) ) {
            	        alt36=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // InternalGT.g:2320:7: lv_right_4_1= ruleMinMaxExpression
            	            {

            	            							newCompositeNode(grammarAccess.getExpExpressionAccess().getRightMinMaxExpressionParserRuleCall_1_2_0_0());
            	            						
            	            pushFollow(FOLLOW_43);
            	            lv_right_4_1=ruleMinMaxExpression();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getExpExpressionRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_1,
            	            								"org.emoflon.ibex.gt.editor.GT.MinMaxExpression");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalGT.g:2336:7: lv_right_4_2= ruleOneParameterArithmetics
            	            {

            	            							newCompositeNode(grammarAccess.getExpExpressionAccess().getRightOneParameterArithmeticsParserRuleCall_1_2_0_1());
            	            						
            	            pushFollow(FOLLOW_43);
            	            lv_right_4_2=ruleOneParameterArithmetics();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getExpExpressionRule());
            	            							}
            	            							set(
            	            								current,
            	            								"right",
            	            								lv_right_4_2,
            	            								"org.emoflon.ibex.gt.editor.GT.OneParameterArithmetics");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // $ANTLR end "ruleExpExpression"


    // $ANTLR start "entryRuleMinMaxExpression"
    // InternalGT.g:2359:1: entryRuleMinMaxExpression returns [EObject current=null] : iv_ruleMinMaxExpression= ruleMinMaxExpression EOF ;
    public final EObject entryRuleMinMaxExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinMaxExpression = null;


        try {
            // InternalGT.g:2359:57: (iv_ruleMinMaxExpression= ruleMinMaxExpression EOF )
            // InternalGT.g:2360:2: iv_ruleMinMaxExpression= ruleMinMaxExpression EOF
            {
             newCompositeNode(grammarAccess.getMinMaxExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMinMaxExpression=ruleMinMaxExpression();

            state._fsp--;

             current =iv_ruleMinMaxExpression; 
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
    // $ANTLR end "entryRuleMinMaxExpression"


    // $ANTLR start "ruleMinMaxExpression"
    // InternalGT.g:2366:1: ruleMinMaxExpression returns [EObject current=null] : ( () ( (lv_minMaxOperator_1_0= ruleMinMaxOperator ) ) otherlv_2= '(' ( (lv_left_3_0= ruleArithmeticExpression ) ) otherlv_4= ',' ( (lv_right_5_0= ruleArithmeticExpression ) ) otherlv_6= ')' ) ;
    public final EObject ruleMinMaxExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_minMaxOperator_1_0 = null;

        EObject lv_left_3_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalGT.g:2372:2: ( ( () ( (lv_minMaxOperator_1_0= ruleMinMaxOperator ) ) otherlv_2= '(' ( (lv_left_3_0= ruleArithmeticExpression ) ) otherlv_4= ',' ( (lv_right_5_0= ruleArithmeticExpression ) ) otherlv_6= ')' ) )
            // InternalGT.g:2373:2: ( () ( (lv_minMaxOperator_1_0= ruleMinMaxOperator ) ) otherlv_2= '(' ( (lv_left_3_0= ruleArithmeticExpression ) ) otherlv_4= ',' ( (lv_right_5_0= ruleArithmeticExpression ) ) otherlv_6= ')' )
            {
            // InternalGT.g:2373:2: ( () ( (lv_minMaxOperator_1_0= ruleMinMaxOperator ) ) otherlv_2= '(' ( (lv_left_3_0= ruleArithmeticExpression ) ) otherlv_4= ',' ( (lv_right_5_0= ruleArithmeticExpression ) ) otherlv_6= ')' )
            // InternalGT.g:2374:3: () ( (lv_minMaxOperator_1_0= ruleMinMaxOperator ) ) otherlv_2= '(' ( (lv_left_3_0= ruleArithmeticExpression ) ) otherlv_4= ',' ( (lv_right_5_0= ruleArithmeticExpression ) ) otherlv_6= ')'
            {
            // InternalGT.g:2374:3: ()
            // InternalGT.g:2375:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getMinMaxExpressionAccess().getMinMaxExpressionAction_0(),
            					current);
            			

            }

            // InternalGT.g:2381:3: ( (lv_minMaxOperator_1_0= ruleMinMaxOperator ) )
            // InternalGT.g:2382:4: (lv_minMaxOperator_1_0= ruleMinMaxOperator )
            {
            // InternalGT.g:2382:4: (lv_minMaxOperator_1_0= ruleMinMaxOperator )
            // InternalGT.g:2383:5: lv_minMaxOperator_1_0= ruleMinMaxOperator
            {

            					newCompositeNode(grammarAccess.getMinMaxExpressionAccess().getMinMaxOperatorMinMaxOperatorEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_minMaxOperator_1_0=ruleMinMaxOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMinMaxExpressionRule());
            					}
            					set(
            						current,
            						"minMaxOperator",
            						lv_minMaxOperator_1_0,
            						"org.emoflon.ibex.gt.editor.GT.MinMaxOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,13,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getMinMaxExpressionAccess().getLeftParenthesisKeyword_2());
            		
            // InternalGT.g:2404:3: ( (lv_left_3_0= ruleArithmeticExpression ) )
            // InternalGT.g:2405:4: (lv_left_3_0= ruleArithmeticExpression )
            {
            // InternalGT.g:2405:4: (lv_left_3_0= ruleArithmeticExpression )
            // InternalGT.g:2406:5: lv_left_3_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getMinMaxExpressionAccess().getLeftArithmeticExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_44);
            lv_left_3_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMinMaxExpressionRule());
            					}
            					set(
            						current,
            						"left",
            						lv_left_3_0,
            						"org.emoflon.ibex.gt.editor.GT.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getMinMaxExpressionAccess().getCommaKeyword_4());
            		
            // InternalGT.g:2427:3: ( (lv_right_5_0= ruleArithmeticExpression ) )
            // InternalGT.g:2428:4: (lv_right_5_0= ruleArithmeticExpression )
            {
            // InternalGT.g:2428:4: (lv_right_5_0= ruleArithmeticExpression )
            // InternalGT.g:2429:5: lv_right_5_0= ruleArithmeticExpression
            {

            					newCompositeNode(grammarAccess.getMinMaxExpressionAccess().getRightArithmeticExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_26);
            lv_right_5_0=ruleArithmeticExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMinMaxExpressionRule());
            					}
            					set(
            						current,
            						"right",
            						lv_right_5_0,
            						"org.emoflon.ibex.gt.editor.GT.ArithmeticExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getMinMaxExpressionAccess().getRightParenthesisKeyword_6());
            		

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
    // $ANTLR end "ruleMinMaxExpression"


    // $ANTLR start "entryRuleOneParameterArithmetics"
    // InternalGT.g:2454:1: entryRuleOneParameterArithmetics returns [EObject current=null] : iv_ruleOneParameterArithmetics= ruleOneParameterArithmetics EOF ;
    public final EObject entryRuleOneParameterArithmetics() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOneParameterArithmetics = null;


        try {
            // InternalGT.g:2454:64: (iv_ruleOneParameterArithmetics= ruleOneParameterArithmetics EOF )
            // InternalGT.g:2455:2: iv_ruleOneParameterArithmetics= ruleOneParameterArithmetics EOF
            {
             newCompositeNode(grammarAccess.getOneParameterArithmeticsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOneParameterArithmetics=ruleOneParameterArithmetics();

            state._fsp--;

             current =iv_ruleOneParameterArithmetics; 
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
    // $ANTLR end "entryRuleOneParameterArithmetics"


    // $ANTLR start "ruleOneParameterArithmetics"
    // InternalGT.g:2461:1: ruleOneParameterArithmetics returns [EObject current=null] : ( ( () ( (lv_negative_1_0= '-' ) )? ( (lv_operator_2_0= ruleOneParameterOperator ) )? otherlv_3= '(' ( (lv_expression_4_0= ruleArithmeticExpression ) ) otherlv_5= ')' ) | this_ArithmeticAttribute_6= ruleArithmeticAttribute ) ;
    public final EObject ruleOneParameterArithmetics() throws RecognitionException {
        EObject current = null;

        Token lv_negative_1_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_2_0 = null;

        EObject lv_expression_4_0 = null;

        EObject this_ArithmeticAttribute_6 = null;



        	enterRule();

        try {
            // InternalGT.g:2467:2: ( ( ( () ( (lv_negative_1_0= '-' ) )? ( (lv_operator_2_0= ruleOneParameterOperator ) )? otherlv_3= '(' ( (lv_expression_4_0= ruleArithmeticExpression ) ) otherlv_5= ')' ) | this_ArithmeticAttribute_6= ruleArithmeticAttribute ) )
            // InternalGT.g:2468:2: ( ( () ( (lv_negative_1_0= '-' ) )? ( (lv_operator_2_0= ruleOneParameterOperator ) )? otherlv_3= '(' ( (lv_expression_4_0= ruleArithmeticExpression ) ) otherlv_5= ')' ) | this_ArithmeticAttribute_6= ruleArithmeticAttribute )
            {
            // InternalGT.g:2468:2: ( ( () ( (lv_negative_1_0= '-' ) )? ( (lv_operator_2_0= ruleOneParameterOperator ) )? otherlv_3= '(' ( (lv_expression_4_0= ruleArithmeticExpression ) ) otherlv_5= ')' ) | this_ArithmeticAttribute_6= ruleArithmeticAttribute )
            int alt40=2;
            switch ( input.LA(1) ) {
            case 30:
                {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==RULE_INT) ) {
                    alt40=2;
                }
                else if ( (LA40_1==13||(LA40_1>=62 && LA40_1<=69)) ) {
                    alt40=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
                }
                break;
            case 13:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
                {
                alt40=1;
                }
                break;
            case RULE_STRING:
            case RULE_ID:
            case RULE_INT:
            case 27:
            case 28:
            case 29:
            case 37:
                {
                alt40=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalGT.g:2469:3: ( () ( (lv_negative_1_0= '-' ) )? ( (lv_operator_2_0= ruleOneParameterOperator ) )? otherlv_3= '(' ( (lv_expression_4_0= ruleArithmeticExpression ) ) otherlv_5= ')' )
                    {
                    // InternalGT.g:2469:3: ( () ( (lv_negative_1_0= '-' ) )? ( (lv_operator_2_0= ruleOneParameterOperator ) )? otherlv_3= '(' ( (lv_expression_4_0= ruleArithmeticExpression ) ) otherlv_5= ')' )
                    // InternalGT.g:2470:4: () ( (lv_negative_1_0= '-' ) )? ( (lv_operator_2_0= ruleOneParameterOperator ) )? otherlv_3= '(' ( (lv_expression_4_0= ruleArithmeticExpression ) ) otherlv_5= ')'
                    {
                    // InternalGT.g:2470:4: ()
                    // InternalGT.g:2471:5: 
                    {

                    					current = forceCreateModelElement(
                    						grammarAccess.getOneParameterArithmeticsAccess().getOneParameterArithmeticsAction_0_0(),
                    						current);
                    				

                    }

                    // InternalGT.g:2477:4: ( (lv_negative_1_0= '-' ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==30) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalGT.g:2478:5: (lv_negative_1_0= '-' )
                            {
                            // InternalGT.g:2478:5: (lv_negative_1_0= '-' )
                            // InternalGT.g:2479:6: lv_negative_1_0= '-'
                            {
                            lv_negative_1_0=(Token)match(input,30,FOLLOW_45); 

                            						newLeafNode(lv_negative_1_0, grammarAccess.getOneParameterArithmeticsAccess().getNegativeHyphenMinusKeyword_0_1_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getOneParameterArithmeticsRule());
                            						}
                            						setWithLastConsumed(current, "negative", lv_negative_1_0 != null, "-");
                            					

                            }


                            }
                            break;

                    }

                    // InternalGT.g:2491:4: ( (lv_operator_2_0= ruleOneParameterOperator ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=62 && LA39_0<=69)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalGT.g:2492:5: (lv_operator_2_0= ruleOneParameterOperator )
                            {
                            // InternalGT.g:2492:5: (lv_operator_2_0= ruleOneParameterOperator )
                            // InternalGT.g:2493:6: lv_operator_2_0= ruleOneParameterOperator
                            {

                            						newCompositeNode(grammarAccess.getOneParameterArithmeticsAccess().getOperatorOneParameterOperatorEnumRuleCall_0_2_0());
                            					
                            pushFollow(FOLLOW_25);
                            lv_operator_2_0=ruleOneParameterOperator();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getOneParameterArithmeticsRule());
                            						}
                            						set(
                            							current,
                            							"operator",
                            							lv_operator_2_0,
                            							"org.emoflon.ibex.gt.editor.GT.OneParameterOperator");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_16); 

                    				newLeafNode(otherlv_3, grammarAccess.getOneParameterArithmeticsAccess().getLeftParenthesisKeyword_0_3());
                    			
                    // InternalGT.g:2514:4: ( (lv_expression_4_0= ruleArithmeticExpression ) )
                    // InternalGT.g:2515:5: (lv_expression_4_0= ruleArithmeticExpression )
                    {
                    // InternalGT.g:2515:5: (lv_expression_4_0= ruleArithmeticExpression )
                    // InternalGT.g:2516:6: lv_expression_4_0= ruleArithmeticExpression
                    {

                    						newCompositeNode(grammarAccess.getOneParameterArithmeticsAccess().getExpressionArithmeticExpressionParserRuleCall_0_4_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_expression_4_0=ruleArithmeticExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOneParameterArithmeticsRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_4_0,
                    							"org.emoflon.ibex.gt.editor.GT.ArithmeticExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,15,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getOneParameterArithmeticsAccess().getRightParenthesisKeyword_0_5());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2539:3: this_ArithmeticAttribute_6= ruleArithmeticAttribute
                    {

                    			newCompositeNode(grammarAccess.getOneParameterArithmeticsAccess().getArithmeticAttributeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ArithmeticAttribute_6=ruleArithmeticAttribute();

                    state._fsp--;


                    			current = this_ArithmeticAttribute_6;
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
    // $ANTLR end "ruleOneParameterArithmetics"


    // $ANTLR start "entryRuleArithmeticAttribute"
    // InternalGT.g:2551:1: entryRuleArithmeticAttribute returns [EObject current=null] : iv_ruleArithmeticAttribute= ruleArithmeticAttribute EOF ;
    public final EObject entryRuleArithmeticAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArithmeticAttribute = null;


        try {
            // InternalGT.g:2551:60: (iv_ruleArithmeticAttribute= ruleArithmeticAttribute EOF )
            // InternalGT.g:2552:2: iv_ruleArithmeticAttribute= ruleArithmeticAttribute EOF
            {
             newCompositeNode(grammarAccess.getArithmeticAttributeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArithmeticAttribute=ruleArithmeticAttribute();

            state._fsp--;

             current =iv_ruleArithmeticAttribute; 
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
    // $ANTLR end "entryRuleArithmeticAttribute"


    // $ANTLR start "ruleArithmeticAttribute"
    // InternalGT.g:2558:1: ruleArithmeticAttribute returns [EObject current=null] : (this_EditorLiteralExpression_0= ruleEditorLiteralExpression | this_EditorAttributeExpression_1= ruleEditorAttributeExpression | this_EditorIteratorAttributeExpression_2= ruleEditorIteratorAttributeExpression | this_EditorCountExpression_3= ruleEditorCountExpression ) ;
    public final EObject ruleArithmeticAttribute() throws RecognitionException {
        EObject current = null;

        EObject this_EditorLiteralExpression_0 = null;

        EObject this_EditorAttributeExpression_1 = null;

        EObject this_EditorIteratorAttributeExpression_2 = null;

        EObject this_EditorCountExpression_3 = null;



        	enterRule();

        try {
            // InternalGT.g:2564:2: ( (this_EditorLiteralExpression_0= ruleEditorLiteralExpression | this_EditorAttributeExpression_1= ruleEditorAttributeExpression | this_EditorIteratorAttributeExpression_2= ruleEditorIteratorAttributeExpression | this_EditorCountExpression_3= ruleEditorCountExpression ) )
            // InternalGT.g:2565:2: (this_EditorLiteralExpression_0= ruleEditorLiteralExpression | this_EditorAttributeExpression_1= ruleEditorAttributeExpression | this_EditorIteratorAttributeExpression_2= ruleEditorIteratorAttributeExpression | this_EditorCountExpression_3= ruleEditorCountExpression )
            {
            // InternalGT.g:2565:2: (this_EditorLiteralExpression_0= ruleEditorLiteralExpression | this_EditorAttributeExpression_1= ruleEditorAttributeExpression | this_EditorIteratorAttributeExpression_2= ruleEditorIteratorAttributeExpression | this_EditorCountExpression_3= ruleEditorCountExpression )
            int alt41=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case 28:
            case 29:
            case 30:
                {
                alt41=1;
                }
                break;
            case RULE_ID:
                {
                alt41=2;
                }
                break;
            case 37:
                {
                alt41=3;
                }
                break;
            case 27:
                {
                alt41=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalGT.g:2566:3: this_EditorLiteralExpression_0= ruleEditorLiteralExpression
                    {

                    			newCompositeNode(grammarAccess.getArithmeticAttributeAccess().getEditorLiteralExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorLiteralExpression_0=ruleEditorLiteralExpression();

                    state._fsp--;


                    			current = this_EditorLiteralExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalGT.g:2575:3: this_EditorAttributeExpression_1= ruleEditorAttributeExpression
                    {

                    			newCompositeNode(grammarAccess.getArithmeticAttributeAccess().getEditorAttributeExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorAttributeExpression_1=ruleEditorAttributeExpression();

                    state._fsp--;


                    			current = this_EditorAttributeExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalGT.g:2584:3: this_EditorIteratorAttributeExpression_2= ruleEditorIteratorAttributeExpression
                    {

                    			newCompositeNode(grammarAccess.getArithmeticAttributeAccess().getEditorIteratorAttributeExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorIteratorAttributeExpression_2=ruleEditorIteratorAttributeExpression();

                    state._fsp--;


                    			current = this_EditorIteratorAttributeExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalGT.g:2593:3: this_EditorCountExpression_3= ruleEditorCountExpression
                    {

                    			newCompositeNode(grammarAccess.getArithmeticAttributeAccess().getEditorCountExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_EditorCountExpression_3=ruleEditorCountExpression();

                    state._fsp--;


                    			current = this_EditorCountExpression_3;
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
    // $ANTLR end "ruleArithmeticAttribute"


    // $ANTLR start "ruleEditorPatternType"
    // InternalGT.g:2605:1: ruleEditorPatternType returns [Enumerator current=null] : ( (enumLiteral_0= 'pattern' ) | (enumLiteral_1= 'rule' ) ) ;
    public final Enumerator ruleEditorPatternType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGT.g:2611:2: ( ( (enumLiteral_0= 'pattern' ) | (enumLiteral_1= 'rule' ) ) )
            // InternalGT.g:2612:2: ( (enumLiteral_0= 'pattern' ) | (enumLiteral_1= 'rule' ) )
            {
            // InternalGT.g:2612:2: ( (enumLiteral_0= 'pattern' ) | (enumLiteral_1= 'rule' ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==42) ) {
                alt42=1;
            }
            else if ( (LA42_0==43) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalGT.g:2613:3: (enumLiteral_0= 'pattern' )
                    {
                    // InternalGT.g:2613:3: (enumLiteral_0= 'pattern' )
                    // InternalGT.g:2614:4: enumLiteral_0= 'pattern'
                    {
                    enumLiteral_0=(Token)match(input,42,FOLLOW_2); 

                    				current = grammarAccess.getEditorPatternTypeAccess().getPATTERNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEditorPatternTypeAccess().getPATTERNEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2621:3: (enumLiteral_1= 'rule' )
                    {
                    // InternalGT.g:2621:3: (enumLiteral_1= 'rule' )
                    // InternalGT.g:2622:4: enumLiteral_1= 'rule'
                    {
                    enumLiteral_1=(Token)match(input,43,FOLLOW_2); 

                    				current = grammarAccess.getEditorPatternTypeAccess().getRULEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEditorPatternTypeAccess().getRULEEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEditorPatternType"


    // $ANTLR start "ruleEditorOperator"
    // InternalGT.g:2632:1: ruleEditorOperator returns [Enumerator current=null] : ( (enumLiteral_0= '$context' ) | (enumLiteral_1= '++' ) | (enumLiteral_2= '--' ) ) ;
    public final Enumerator ruleEditorOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalGT.g:2638:2: ( ( (enumLiteral_0= '$context' ) | (enumLiteral_1= '++' ) | (enumLiteral_2= '--' ) ) )
            // InternalGT.g:2639:2: ( (enumLiteral_0= '$context' ) | (enumLiteral_1= '++' ) | (enumLiteral_2= '--' ) )
            {
            // InternalGT.g:2639:2: ( (enumLiteral_0= '$context' ) | (enumLiteral_1= '++' ) | (enumLiteral_2= '--' ) )
            int alt43=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt43=1;
                }
                break;
            case 45:
                {
                alt43=2;
                }
                break;
            case 46:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // InternalGT.g:2640:3: (enumLiteral_0= '$context' )
                    {
                    // InternalGT.g:2640:3: (enumLiteral_0= '$context' )
                    // InternalGT.g:2641:4: enumLiteral_0= '$context'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); 

                    				current = grammarAccess.getEditorOperatorAccess().getCONTEXTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEditorOperatorAccess().getCONTEXTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2648:3: (enumLiteral_1= '++' )
                    {
                    // InternalGT.g:2648:3: (enumLiteral_1= '++' )
                    // InternalGT.g:2649:4: enumLiteral_1= '++'
                    {
                    enumLiteral_1=(Token)match(input,45,FOLLOW_2); 

                    				current = grammarAccess.getEditorOperatorAccess().getCREATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEditorOperatorAccess().getCREATEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:2656:3: (enumLiteral_2= '--' )
                    {
                    // InternalGT.g:2656:3: (enumLiteral_2= '--' )
                    // InternalGT.g:2657:4: enumLiteral_2= '--'
                    {
                    enumLiteral_2=(Token)match(input,46,FOLLOW_2); 

                    				current = grammarAccess.getEditorOperatorAccess().getDELETEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getEditorOperatorAccess().getDELETEEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleEditorOperator"


    // $ANTLR start "ruleEditorRelation"
    // InternalGT.g:2667:1: ruleEditorRelation returns [Enumerator current=null] : ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) ) ;
    public final Enumerator ruleEditorRelation() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalGT.g:2673:2: ( ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) ) )
            // InternalGT.g:2674:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) )
            {
            // InternalGT.g:2674:2: ( (enumLiteral_0= '>' ) | (enumLiteral_1= '>=' ) | (enumLiteral_2= '==' ) | (enumLiteral_3= '!=' ) | (enumLiteral_4= '<=' ) | (enumLiteral_5= '<' ) )
            int alt44=6;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt44=1;
                }
                break;
            case 47:
                {
                alt44=2;
                }
                break;
            case 48:
                {
                alt44=3;
                }
                break;
            case 49:
                {
                alt44=4;
                }
                break;
            case 50:
                {
                alt44=5;
                }
                break;
            case 35:
                {
                alt44=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalGT.g:2675:3: (enumLiteral_0= '>' )
                    {
                    // InternalGT.g:2675:3: (enumLiteral_0= '>' )
                    // InternalGT.g:2676:4: enumLiteral_0= '>'
                    {
                    enumLiteral_0=(Token)match(input,36,FOLLOW_2); 

                    				current = grammarAccess.getEditorRelationAccess().getGREATEREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEditorRelationAccess().getGREATEREnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2683:3: (enumLiteral_1= '>=' )
                    {
                    // InternalGT.g:2683:3: (enumLiteral_1= '>=' )
                    // InternalGT.g:2684:4: enumLiteral_1= '>='
                    {
                    enumLiteral_1=(Token)match(input,47,FOLLOW_2); 

                    				current = grammarAccess.getEditorRelationAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEditorRelationAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:2691:3: (enumLiteral_2= '==' )
                    {
                    // InternalGT.g:2691:3: (enumLiteral_2= '==' )
                    // InternalGT.g:2692:4: enumLiteral_2= '=='
                    {
                    enumLiteral_2=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getEditorRelationAccess().getEQUALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getEditorRelationAccess().getEQUALEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGT.g:2699:3: (enumLiteral_3= '!=' )
                    {
                    // InternalGT.g:2699:3: (enumLiteral_3= '!=' )
                    // InternalGT.g:2700:4: enumLiteral_3= '!='
                    {
                    enumLiteral_3=(Token)match(input,49,FOLLOW_2); 

                    				current = grammarAccess.getEditorRelationAccess().getUNEQUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getEditorRelationAccess().getUNEQUALEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGT.g:2707:3: (enumLiteral_4= '<=' )
                    {
                    // InternalGT.g:2707:3: (enumLiteral_4= '<=' )
                    // InternalGT.g:2708:4: enumLiteral_4= '<='
                    {
                    enumLiteral_4=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getEditorRelationAccess().getSMALLER_OR_EQUALEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getEditorRelationAccess().getSMALLER_OR_EQUALEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGT.g:2715:3: (enumLiteral_5= '<' )
                    {
                    // InternalGT.g:2715:3: (enumLiteral_5= '<' )
                    // InternalGT.g:2716:4: enumLiteral_5= '<'
                    {
                    enumLiteral_5=(Token)match(input,35,FOLLOW_2); 

                    				current = grammarAccess.getEditorRelationAccess().getSMALLEREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getEditorRelationAccess().getSMALLEREnumLiteralDeclaration_5());
                    			

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
    // $ANTLR end "ruleEditorRelation"


    // $ANTLR start "ruleEditorApplicationConditionType"
    // InternalGT.g:2726:1: ruleEditorApplicationConditionType returns [Enumerator current=null] : ( (enumLiteral_0= 'enforce' ) | (enumLiteral_1= 'forbid' ) ) ;
    public final Enumerator ruleEditorApplicationConditionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGT.g:2732:2: ( ( (enumLiteral_0= 'enforce' ) | (enumLiteral_1= 'forbid' ) ) )
            // InternalGT.g:2733:2: ( (enumLiteral_0= 'enforce' ) | (enumLiteral_1= 'forbid' ) )
            {
            // InternalGT.g:2733:2: ( (enumLiteral_0= 'enforce' ) | (enumLiteral_1= 'forbid' ) )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==51) ) {
                alt45=1;
            }
            else if ( (LA45_0==52) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalGT.g:2734:3: (enumLiteral_0= 'enforce' )
                    {
                    // InternalGT.g:2734:3: (enumLiteral_0= 'enforce' )
                    // InternalGT.g:2735:4: enumLiteral_0= 'enforce'
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getEditorApplicationConditionTypeAccess().getPOSITIVEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEditorApplicationConditionTypeAccess().getPOSITIVEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2742:3: (enumLiteral_1= 'forbid' )
                    {
                    // InternalGT.g:2742:3: (enumLiteral_1= 'forbid' )
                    // InternalGT.g:2743:4: enumLiteral_1= 'forbid'
                    {
                    enumLiteral_1=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getEditorApplicationConditionTypeAccess().getNEGATIVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEditorApplicationConditionTypeAccess().getNEGATIVEEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleEditorApplicationConditionType"


    // $ANTLR start "ruleStochasticRange"
    // InternalGT.g:2753:1: ruleStochasticRange returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleStochasticRange() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGT.g:2759:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalGT.g:2760:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalGT.g:2760:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==53) ) {
                alt46=1;
            }
            else if ( (LA46_0==30) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalGT.g:2761:3: (enumLiteral_0= '+' )
                    {
                    // InternalGT.g:2761:3: (enumLiteral_0= '+' )
                    // InternalGT.g:2762:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getStochasticRangeAccess().getPOSITIVEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStochasticRangeAccess().getPOSITIVEEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2769:3: (enumLiteral_1= '-' )
                    {
                    // InternalGT.g:2769:3: (enumLiteral_1= '-' )
                    // InternalGT.g:2770:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getStochasticRangeAccess().getNEGATIVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStochasticRangeAccess().getNEGATIVEEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleStochasticRange"


    // $ANTLR start "ruleStochasticDistribution"
    // InternalGT.g:2780:1: ruleStochasticDistribution returns [Enumerator current=null] : ( (enumLiteral_0= 'N' ) | (enumLiteral_1= 'U' ) | (enumLiteral_2= 'Exp' ) ) ;
    public final Enumerator ruleStochasticDistribution() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalGT.g:2786:2: ( ( (enumLiteral_0= 'N' ) | (enumLiteral_1= 'U' ) | (enumLiteral_2= 'Exp' ) ) )
            // InternalGT.g:2787:2: ( (enumLiteral_0= 'N' ) | (enumLiteral_1= 'U' ) | (enumLiteral_2= 'Exp' ) )
            {
            // InternalGT.g:2787:2: ( (enumLiteral_0= 'N' ) | (enumLiteral_1= 'U' ) | (enumLiteral_2= 'Exp' ) )
            int alt47=3;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt47=1;
                }
                break;
            case 55:
                {
                alt47=2;
                }
                break;
            case 56:
                {
                alt47=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalGT.g:2788:3: (enumLiteral_0= 'N' )
                    {
                    // InternalGT.g:2788:3: (enumLiteral_0= 'N' )
                    // InternalGT.g:2789:4: enumLiteral_0= 'N'
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getStochasticDistributionAccess().getNORMALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getStochasticDistributionAccess().getNORMALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2796:3: (enumLiteral_1= 'U' )
                    {
                    // InternalGT.g:2796:3: (enumLiteral_1= 'U' )
                    // InternalGT.g:2797:4: enumLiteral_1= 'U'
                    {
                    enumLiteral_1=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getStochasticDistributionAccess().getUNIFORMEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getStochasticDistributionAccess().getUNIFORMEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:2804:3: (enumLiteral_2= 'Exp' )
                    {
                    // InternalGT.g:2804:3: (enumLiteral_2= 'Exp' )
                    // InternalGT.g:2805:4: enumLiteral_2= 'Exp'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getStochasticDistributionAccess().getEXPONENTIALEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getStochasticDistributionAccess().getEXPONENTIALEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleStochasticDistribution"


    // $ANTLR start "ruleMultOperator"
    // InternalGT.g:2815:1: ruleMultOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalGT.g:2821:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalGT.g:2822:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalGT.g:2822:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt48=3;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt48=1;
                }
                break;
            case 58:
                {
                alt48=2;
                }
                break;
            case 59:
                {
                alt48=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalGT.g:2823:3: (enumLiteral_0= '*' )
                    {
                    // InternalGT.g:2823:3: (enumLiteral_0= '*' )
                    // InternalGT.g:2824:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getMultOperatorAccess().getMULTIPLICATIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMultOperatorAccess().getMULTIPLICATIONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2831:3: (enumLiteral_1= '/' )
                    {
                    // InternalGT.g:2831:3: (enumLiteral_1= '/' )
                    // InternalGT.g:2832:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getMultOperatorAccess().getDIVISIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMultOperatorAccess().getDIVISIONEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:2839:3: (enumLiteral_2= '%' )
                    {
                    // InternalGT.g:2839:3: (enumLiteral_2= '%' )
                    // InternalGT.g:2840:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getMultOperatorAccess().getMODULOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getMultOperatorAccess().getMODULOEnumLiteralDeclaration_2());
                    			

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
    // $ANTLR end "ruleMultOperator"


    // $ANTLR start "ruleMinMaxOperator"
    // InternalGT.g:2850:1: ruleMinMaxOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'min' ) | (enumLiteral_1= 'max' ) ) ;
    public final Enumerator ruleMinMaxOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGT.g:2856:2: ( ( (enumLiteral_0= 'min' ) | (enumLiteral_1= 'max' ) ) )
            // InternalGT.g:2857:2: ( (enumLiteral_0= 'min' ) | (enumLiteral_1= 'max' ) )
            {
            // InternalGT.g:2857:2: ( (enumLiteral_0= 'min' ) | (enumLiteral_1= 'max' ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==60) ) {
                alt49=1;
            }
            else if ( (LA49_0==61) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalGT.g:2858:3: (enumLiteral_0= 'min' )
                    {
                    // InternalGT.g:2858:3: (enumLiteral_0= 'min' )
                    // InternalGT.g:2859:4: enumLiteral_0= 'min'
                    {
                    enumLiteral_0=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getMinMaxOperatorAccess().getMINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getMinMaxOperatorAccess().getMINEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2866:3: (enumLiteral_1= 'max' )
                    {
                    // InternalGT.g:2866:3: (enumLiteral_1= 'max' )
                    // InternalGT.g:2867:4: enumLiteral_1= 'max'
                    {
                    enumLiteral_1=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getMinMaxOperatorAccess().getMAXEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getMinMaxOperatorAccess().getMAXEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleMinMaxOperator"


    // $ANTLR start "ruleAddOperator"
    // InternalGT.g:2877:1: ruleAddOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAddOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalGT.g:2883:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalGT.g:2884:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalGT.g:2884:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==53) ) {
                alt50=1;
            }
            else if ( (LA50_0==30) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // InternalGT.g:2885:3: (enumLiteral_0= '+' )
                    {
                    // InternalGT.g:2885:3: (enumLiteral_0= '+' )
                    // InternalGT.g:2886:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getAddOperatorAccess().getADDITIONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getAddOperatorAccess().getADDITIONEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2893:3: (enumLiteral_1= '-' )
                    {
                    // InternalGT.g:2893:3: (enumLiteral_1= '-' )
                    // InternalGT.g:2894:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_2); 

                    				current = grammarAccess.getAddOperatorAccess().getSUBTRACTIONEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getAddOperatorAccess().getSUBTRACTIONEnumLiteralDeclaration_1());
                    			

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
    // $ANTLR end "ruleAddOperator"


    // $ANTLR start "ruleOneParameterOperator"
    // InternalGT.g:2904:1: ruleOneParameterOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) | (enumLiteral_2= 'sin' ) | (enumLiteral_3= 'cos' ) | (enumLiteral_4= 'tan' ) | (enumLiteral_5= 'exp' ) | (enumLiteral_6= 'log' ) | (enumLiteral_7= 'ln' ) ) ;
    public final Enumerator ruleOneParameterOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;


        	enterRule();

        try {
            // InternalGT.g:2910:2: ( ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) | (enumLiteral_2= 'sin' ) | (enumLiteral_3= 'cos' ) | (enumLiteral_4= 'tan' ) | (enumLiteral_5= 'exp' ) | (enumLiteral_6= 'log' ) | (enumLiteral_7= 'ln' ) ) )
            // InternalGT.g:2911:2: ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) | (enumLiteral_2= 'sin' ) | (enumLiteral_3= 'cos' ) | (enumLiteral_4= 'tan' ) | (enumLiteral_5= 'exp' ) | (enumLiteral_6= 'log' ) | (enumLiteral_7= 'ln' ) )
            {
            // InternalGT.g:2911:2: ( (enumLiteral_0= 'sqrt' ) | (enumLiteral_1= 'abs' ) | (enumLiteral_2= 'sin' ) | (enumLiteral_3= 'cos' ) | (enumLiteral_4= 'tan' ) | (enumLiteral_5= 'exp' ) | (enumLiteral_6= 'log' ) | (enumLiteral_7= 'ln' ) )
            int alt51=8;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt51=1;
                }
                break;
            case 63:
                {
                alt51=2;
                }
                break;
            case 64:
                {
                alt51=3;
                }
                break;
            case 65:
                {
                alt51=4;
                }
                break;
            case 66:
                {
                alt51=5;
                }
                break;
            case 67:
                {
                alt51=6;
                }
                break;
            case 68:
                {
                alt51=7;
                }
                break;
            case 69:
                {
                alt51=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalGT.g:2912:3: (enumLiteral_0= 'sqrt' )
                    {
                    // InternalGT.g:2912:3: (enumLiteral_0= 'sqrt' )
                    // InternalGT.g:2913:4: enumLiteral_0= 'sqrt'
                    {
                    enumLiteral_0=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getROOTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getOneParameterOperatorAccess().getROOTEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:2920:3: (enumLiteral_1= 'abs' )
                    {
                    // InternalGT.g:2920:3: (enumLiteral_1= 'abs' )
                    // InternalGT.g:2921:4: enumLiteral_1= 'abs'
                    {
                    enumLiteral_1=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getABSOLUTEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getOneParameterOperatorAccess().getABSOLUTEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:2928:3: (enumLiteral_2= 'sin' )
                    {
                    // InternalGT.g:2928:3: (enumLiteral_2= 'sin' )
                    // InternalGT.g:2929:4: enumLiteral_2= 'sin'
                    {
                    enumLiteral_2=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getSINEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getOneParameterOperatorAccess().getSINEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalGT.g:2936:3: (enumLiteral_3= 'cos' )
                    {
                    // InternalGT.g:2936:3: (enumLiteral_3= 'cos' )
                    // InternalGT.g:2937:4: enumLiteral_3= 'cos'
                    {
                    enumLiteral_3=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getCOSEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getOneParameterOperatorAccess().getCOSEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalGT.g:2944:3: (enumLiteral_4= 'tan' )
                    {
                    // InternalGT.g:2944:3: (enumLiteral_4= 'tan' )
                    // InternalGT.g:2945:4: enumLiteral_4= 'tan'
                    {
                    enumLiteral_4=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getTANEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getOneParameterOperatorAccess().getTANEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalGT.g:2952:3: (enumLiteral_5= 'exp' )
                    {
                    // InternalGT.g:2952:3: (enumLiteral_5= 'exp' )
                    // InternalGT.g:2953:4: enumLiteral_5= 'exp'
                    {
                    enumLiteral_5=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getE_EXPONENTIALEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getOneParameterOperatorAccess().getE_EXPONENTIALEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalGT.g:2960:3: (enumLiteral_6= 'log' )
                    {
                    // InternalGT.g:2960:3: (enumLiteral_6= 'log' )
                    // InternalGT.g:2961:4: enumLiteral_6= 'log'
                    {
                    enumLiteral_6=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getLOGARITHMUSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getOneParameterOperatorAccess().getLOGARITHMUSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalGT.g:2968:3: (enumLiteral_7= 'ln' )
                    {
                    // InternalGT.g:2968:3: (enumLiteral_7= 'ln' )
                    // InternalGT.g:2969:4: enumLiteral_7= 'ln'
                    {
                    enumLiteral_7=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getOneParameterOperatorAccess().getNAT_LOGEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getOneParameterOperatorAccess().getNAT_LOGEnumLiteralDeclaration_7());
                    			

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
    // $ANTLR end "ruleOneParameterOperator"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000C4000001802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000C4000001002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x00000C0000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000000002B2002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000002B0002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000002A4002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000700001840020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0xF1E0002078002070L,0x000000000000003FL});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000700442040000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xF1E00021F8002070L,0x000000000000003FL});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0007801800000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000800020000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000702000000020L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000702000040020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0018000000000020L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0xF1E0002078002072L,0x000000000000003FL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x01E0000040000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0020000040000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0E00000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0xC000000000002000L,0x000000000000003FL});

}