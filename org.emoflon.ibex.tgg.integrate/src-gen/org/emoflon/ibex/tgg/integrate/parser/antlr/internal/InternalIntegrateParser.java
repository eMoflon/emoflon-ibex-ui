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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'package'", "'.'", "'import'", "':'", "'solve'", "'{'", "'satisfies'", "'}'", "'with'", "'var'", "'='", "'src'", "'|'", "'trg'", "'created'", "'deleted'", "'type'", "','", "'count'", "'exists'", "'or'", "'and'", "'not'", "'('", "')'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'when'", "'mergeAndPreserve'", "'revokeAddition'", "'revokeDeletion'", "'preferSource'", "'preferTarget'", "'deleteCorrespondences'", "'continue'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
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
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
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
    // InternalIntegrate.g:71:1: ruleIntegrate returns [EObject current=null] : ( ( (lv_package_0_0= rulePackage ) )? ( (lv_imports_1_0= ruleImport ) ) ( (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification ) )* ) ;
    public final EObject ruleIntegrate() throws RecognitionException {
        EObject current = null;

        EObject lv_package_0_0 = null;

        EObject lv_imports_1_0 = null;

        EObject lv_conflictResolutionSpecifications_2_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:77:2: ( ( ( (lv_package_0_0= rulePackage ) )? ( (lv_imports_1_0= ruleImport ) ) ( (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification ) )* ) )
            // InternalIntegrate.g:78:2: ( ( (lv_package_0_0= rulePackage ) )? ( (lv_imports_1_0= ruleImport ) ) ( (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification ) )* )
            {
            // InternalIntegrate.g:78:2: ( ( (lv_package_0_0= rulePackage ) )? ( (lv_imports_1_0= ruleImport ) ) ( (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification ) )* )
            // InternalIntegrate.g:79:3: ( (lv_package_0_0= rulePackage ) )? ( (lv_imports_1_0= ruleImport ) ) ( (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification ) )*
            {
            // InternalIntegrate.g:79:3: ( (lv_package_0_0= rulePackage ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalIntegrate.g:80:4: (lv_package_0_0= rulePackage )
                    {
                    // InternalIntegrate.g:80:4: (lv_package_0_0= rulePackage )
                    // InternalIntegrate.g:81:5: lv_package_0_0= rulePackage
                    {

                    					newCompositeNode(grammarAccess.getIntegrateAccess().getPackagePackageParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_package_0_0=rulePackage();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIntegrateRule());
                    					}
                    					set(
                    						current,
                    						"package",
                    						lv_package_0_0,
                    						"org.emoflon.ibex.tgg.integrate.Integrate.Package");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalIntegrate.g:98:3: ( (lv_imports_1_0= ruleImport ) )
            // InternalIntegrate.g:99:4: (lv_imports_1_0= ruleImport )
            {
            // InternalIntegrate.g:99:4: (lv_imports_1_0= ruleImport )
            // InternalIntegrate.g:100:5: lv_imports_1_0= ruleImport
            {

            					newCompositeNode(grammarAccess.getIntegrateAccess().getImportsImportParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_4);
            lv_imports_1_0=ruleImport();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntegrateRule());
            					}
            					add(
            						current,
            						"imports",
            						lv_imports_1_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.Import");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalIntegrate.g:117:3: ( (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalIntegrate.g:118:4: (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification )
            	    {
            	    // InternalIntegrate.g:118:4: (lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification )
            	    // InternalIntegrate.g:119:5: lv_conflictResolutionSpecifications_2_0= ruleConflictResolutionSpecification
            	    {

            	    					newCompositeNode(grammarAccess.getIntegrateAccess().getConflictResolutionSpecificationsConflictResolutionSpecificationParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_conflictResolutionSpecifications_2_0=ruleConflictResolutionSpecification();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntegrateRule());
            	    					}
            	    					add(
            	    						current,
            	    						"conflictResolutionSpecifications",
            	    						lv_conflictResolutionSpecifications_2_0,
            	    						"org.emoflon.ibex.tgg.integrate.Integrate.ConflictResolutionSpecification");
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


    // $ANTLR start "entryRulePackage"
    // InternalIntegrate.g:140:1: entryRulePackage returns [EObject current=null] : iv_rulePackage= rulePackage EOF ;
    public final EObject entryRulePackage() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage = null;


        try {
            // InternalIntegrate.g:140:48: (iv_rulePackage= rulePackage EOF )
            // InternalIntegrate.g:141:2: iv_rulePackage= rulePackage EOF
            {
             newCompositeNode(grammarAccess.getPackageRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackage=rulePackage();

            state._fsp--;

             current =iv_rulePackage; 
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
    // $ANTLR end "entryRulePackage"


    // $ANTLR start "rulePackage"
    // InternalIntegrate.g:147:1: rulePackage returns [EObject current=null] : (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ) ;
    public final EObject rulePackage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:153:2: ( (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) ) )
            // InternalIntegrate.g:154:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )
            {
            // InternalIntegrate.g:154:2: (otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) ) )
            // InternalIntegrate.g:155:3: otherlv_0= 'package' ( (lv_name_1_0= ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getPackageAccess().getPackageKeyword_0());
            		
            // InternalIntegrate.g:159:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalIntegrate.g:160:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalIntegrate.g:160:4: (lv_name_1_0= ruleQualifiedName )
            // InternalIntegrate.g:161:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getPackageAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPackageRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.QualifiedName");
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
    // $ANTLR end "rulePackage"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalIntegrate.g:182:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalIntegrate.g:182:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalIntegrate.g:183:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalIntegrate.g:189:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalIntegrate.g:195:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalIntegrate.g:196:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalIntegrate.g:196:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalIntegrate.g:197:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalIntegrate.g:204:3: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalIntegrate.g:205:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,12,FOLLOW_5); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_6); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop3;
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleImport"
    // InternalIntegrate.g:222:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalIntegrate.g:222:47: (iv_ruleImport= ruleImport EOF )
            // InternalIntegrate.g:223:2: iv_ruleImport= ruleImport EOF
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
    // InternalIntegrate.g:229:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalIntegrate.g:235:2: ( (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalIntegrate.g:236:2: (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalIntegrate.g:236:2: (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) )
            // InternalIntegrate.g:237:3: otherlv_0= 'import' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
            		
            // InternalIntegrate.g:241:3: ( (otherlv_1= RULE_ID ) )
            // InternalIntegrate.g:242:4: (otherlv_1= RULE_ID )
            {
            // InternalIntegrate.g:242:4: (otherlv_1= RULE_ID )
            // InternalIntegrate.g:243:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getImportAccess().getSchemaSchemaCrossReference_1_0());
            				

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


    // $ANTLR start "entryRuleConflictResolutionSpecification"
    // InternalIntegrate.g:258:1: entryRuleConflictResolutionSpecification returns [EObject current=null] : iv_ruleConflictResolutionSpecification= ruleConflictResolutionSpecification EOF ;
    public final EObject entryRuleConflictResolutionSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConflictResolutionSpecification = null;


        try {
            // InternalIntegrate.g:258:72: (iv_ruleConflictResolutionSpecification= ruleConflictResolutionSpecification EOF )
            // InternalIntegrate.g:259:2: iv_ruleConflictResolutionSpecification= ruleConflictResolutionSpecification EOF
            {
             newCompositeNode(grammarAccess.getConflictResolutionSpecificationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConflictResolutionSpecification=ruleConflictResolutionSpecification();

            state._fsp--;

             current =iv_ruleConflictResolutionSpecification; 
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
    // $ANTLR end "entryRuleConflictResolutionSpecification"


    // $ANTLR start "ruleConflictResolutionSpecification"
    // InternalIntegrate.g:265:1: ruleConflictResolutionSpecification returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'solve' otherlv_3= '{' ( (lv_variables_4_0= ruleVariable ) )+ otherlv_5= 'satisfies' otherlv_6= '{' ( (lv_rule_7_0= ruleSatisfactionRule ) ) otherlv_8= '}' otherlv_9= '}' otherlv_10= 'with' ( (lv_resolution_11_0= ruleResolution ) ) ) ;
    public final EObject ruleConflictResolutionSpecification() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        EObject lv_variables_4_0 = null;

        EObject lv_rule_7_0 = null;

        EObject lv_resolution_11_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:271:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'solve' otherlv_3= '{' ( (lv_variables_4_0= ruleVariable ) )+ otherlv_5= 'satisfies' otherlv_6= '{' ( (lv_rule_7_0= ruleSatisfactionRule ) ) otherlv_8= '}' otherlv_9= '}' otherlv_10= 'with' ( (lv_resolution_11_0= ruleResolution ) ) ) )
            // InternalIntegrate.g:272:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'solve' otherlv_3= '{' ( (lv_variables_4_0= ruleVariable ) )+ otherlv_5= 'satisfies' otherlv_6= '{' ( (lv_rule_7_0= ruleSatisfactionRule ) ) otherlv_8= '}' otherlv_9= '}' otherlv_10= 'with' ( (lv_resolution_11_0= ruleResolution ) ) )
            {
            // InternalIntegrate.g:272:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'solve' otherlv_3= '{' ( (lv_variables_4_0= ruleVariable ) )+ otherlv_5= 'satisfies' otherlv_6= '{' ( (lv_rule_7_0= ruleSatisfactionRule ) ) otherlv_8= '}' otherlv_9= '}' otherlv_10= 'with' ( (lv_resolution_11_0= ruleResolution ) ) )
            // InternalIntegrate.g:273:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' otherlv_2= 'solve' otherlv_3= '{' ( (lv_variables_4_0= ruleVariable ) )+ otherlv_5= 'satisfies' otherlv_6= '{' ( (lv_rule_7_0= ruleSatisfactionRule ) ) otherlv_8= '}' otherlv_9= '}' otherlv_10= 'with' ( (lv_resolution_11_0= ruleResolution ) )
            {
            // InternalIntegrate.g:273:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalIntegrate.g:274:4: (lv_name_0_0= RULE_ID )
            {
            // InternalIntegrate.g:274:4: (lv_name_0_0= RULE_ID )
            // InternalIntegrate.g:275:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_7); 

            					newLeafNode(lv_name_0_0, grammarAccess.getConflictResolutionSpecificationAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConflictResolutionSpecificationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_1, grammarAccess.getConflictResolutionSpecificationAccess().getColonKeyword_1());
            		
            otherlv_2=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getConflictResolutionSpecificationAccess().getSolveKeyword_2());
            		
            otherlv_3=(Token)match(input,16,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getConflictResolutionSpecificationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalIntegrate.g:303:3: ( (lv_variables_4_0= ruleVariable ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==20) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalIntegrate.g:304:4: (lv_variables_4_0= ruleVariable )
            	    {
            	    // InternalIntegrate.g:304:4: (lv_variables_4_0= ruleVariable )
            	    // InternalIntegrate.g:305:5: lv_variables_4_0= ruleVariable
            	    {

            	    					newCompositeNode(grammarAccess.getConflictResolutionSpecificationAccess().getVariablesVariableParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_variables_4_0=ruleVariable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConflictResolutionSpecificationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_4_0,
            	    						"org.emoflon.ibex.tgg.integrate.Integrate.Variable");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_5=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_5, grammarAccess.getConflictResolutionSpecificationAccess().getSatisfiesKeyword_5());
            		
            otherlv_6=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_6, grammarAccess.getConflictResolutionSpecificationAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalIntegrate.g:330:3: ( (lv_rule_7_0= ruleSatisfactionRule ) )
            // InternalIntegrate.g:331:4: (lv_rule_7_0= ruleSatisfactionRule )
            {
            // InternalIntegrate.g:331:4: (lv_rule_7_0= ruleSatisfactionRule )
            // InternalIntegrate.g:332:5: lv_rule_7_0= ruleSatisfactionRule
            {

            					newCompositeNode(grammarAccess.getConflictResolutionSpecificationAccess().getRuleSatisfactionRuleParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_13);
            lv_rule_7_0=ruleSatisfactionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConflictResolutionSpecificationRule());
            					}
            					set(
            						current,
            						"rule",
            						lv_rule_7_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.SatisfactionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,18,FOLLOW_13); 

            			newLeafNode(otherlv_8, grammarAccess.getConflictResolutionSpecificationAccess().getRightCurlyBracketKeyword_8());
            		
            otherlv_9=(Token)match(input,18,FOLLOW_14); 

            			newLeafNode(otherlv_9, grammarAccess.getConflictResolutionSpecificationAccess().getRightCurlyBracketKeyword_9());
            		
            otherlv_10=(Token)match(input,19,FOLLOW_15); 

            			newLeafNode(otherlv_10, grammarAccess.getConflictResolutionSpecificationAccess().getWithKeyword_10());
            		
            // InternalIntegrate.g:361:3: ( (lv_resolution_11_0= ruleResolution ) )
            // InternalIntegrate.g:362:4: (lv_resolution_11_0= ruleResolution )
            {
            // InternalIntegrate.g:362:4: (lv_resolution_11_0= ruleResolution )
            // InternalIntegrate.g:363:5: lv_resolution_11_0= ruleResolution
            {

            					newCompositeNode(grammarAccess.getConflictResolutionSpecificationAccess().getResolutionResolutionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_2);
            lv_resolution_11_0=ruleResolution();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConflictResolutionSpecificationRule());
            					}
            					set(
            						current,
            						"resolution",
            						lv_resolution_11_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.Resolution");
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
    // $ANTLR end "ruleConflictResolutionSpecification"


    // $ANTLR start "entryRuleVariable"
    // InternalIntegrate.g:384:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalIntegrate.g:384:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalIntegrate.g:385:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalIntegrate.g:391:1: ruleVariable returns [EObject current=null] : (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_pipeline_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:397:2: ( (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) ) )
            // InternalIntegrate.g:398:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) )
            {
            // InternalIntegrate.g:398:2: (otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) ) )
            // InternalIntegrate.g:399:3: otherlv_0= 'var' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_pipeline_3_0= rulePipeline ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getVarKeyword_0());
            		
            // InternalIntegrate.g:403:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalIntegrate.g:404:4: (lv_name_1_0= RULE_ID )
            {
            // InternalIntegrate.g:404:4: (lv_name_1_0= RULE_ID )
            // InternalIntegrate.g:405:5: lv_name_1_0= RULE_ID
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
            		
            // InternalIntegrate.g:425:3: ( (lv_pipeline_3_0= rulePipeline ) )
            // InternalIntegrate.g:426:4: (lv_pipeline_3_0= rulePipeline )
            {
            // InternalIntegrate.g:426:4: (lv_pipeline_3_0= rulePipeline )
            // InternalIntegrate.g:427:5: lv_pipeline_3_0= rulePipeline
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


    // $ANTLR start "entryRuleVariableReference"
    // InternalIntegrate.g:448:1: entryRuleVariableReference returns [EObject current=null] : iv_ruleVariableReference= ruleVariableReference EOF ;
    public final EObject entryRuleVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableReference = null;


        try {
            // InternalIntegrate.g:448:58: (iv_ruleVariableReference= ruleVariableReference EOF )
            // InternalIntegrate.g:449:2: iv_ruleVariableReference= ruleVariableReference EOF
            {
             newCompositeNode(grammarAccess.getVariableReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableReference=ruleVariableReference();

            state._fsp--;

             current =iv_ruleVariableReference; 
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
    // $ANTLR end "entryRuleVariableReference"


    // $ANTLR start "ruleVariableReference"
    // InternalIntegrate.g:455:1: ruleVariableReference returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:461:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalIntegrate.g:462:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalIntegrate.g:462:2: ( (otherlv_0= RULE_ID ) )
            // InternalIntegrate.g:463:3: (otherlv_0= RULE_ID )
            {
            // InternalIntegrate.g:463:3: (otherlv_0= RULE_ID )
            // InternalIntegrate.g:464:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getVariableReferenceRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getVariableReferenceAccess().getRefVariableCrossReference_0());
            			

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
    // $ANTLR end "ruleVariableReference"


    // $ANTLR start "entryRulePipeline"
    // InternalIntegrate.g:478:1: entryRulePipeline returns [EObject current=null] : iv_rulePipeline= rulePipeline EOF ;
    public final EObject entryRulePipeline() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipeline = null;


        try {
            // InternalIntegrate.g:478:49: (iv_rulePipeline= rulePipeline EOF )
            // InternalIntegrate.g:479:2: iv_rulePipeline= rulePipeline EOF
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
    // InternalIntegrate.g:485:1: rulePipeline returns [EObject current=null] : ( (lv_start_0_0= rulePipelineStageStart ) ) ;
    public final EObject rulePipeline() throws RecognitionException {
        EObject current = null;

        EObject lv_start_0_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:491:2: ( ( (lv_start_0_0= rulePipelineStageStart ) ) )
            // InternalIntegrate.g:492:2: ( (lv_start_0_0= rulePipelineStageStart ) )
            {
            // InternalIntegrate.g:492:2: ( (lv_start_0_0= rulePipelineStageStart ) )
            // InternalIntegrate.g:493:3: (lv_start_0_0= rulePipelineStageStart )
            {
            // InternalIntegrate.g:493:3: (lv_start_0_0= rulePipelineStageStart )
            // InternalIntegrate.g:494:4: lv_start_0_0= rulePipelineStageStart
            {

            				newCompositeNode(grammarAccess.getPipelineAccess().getStartPipelineStageStartParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_start_0_0=rulePipelineStageStart();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getPipelineRule());
            				}
            				set(
            					current,
            					"start",
            					lv_start_0_0,
            					"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageStart");
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
    // $ANTLR end "rulePipeline"


    // $ANTLR start "entryRulePipelineStageStart"
    // InternalIntegrate.g:514:1: entryRulePipelineStageStart returns [EObject current=null] : iv_rulePipelineStageStart= rulePipelineStageStart EOF ;
    public final EObject entryRulePipelineStageStart() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageStart = null;


        try {
            // InternalIntegrate.g:514:59: (iv_rulePipelineStageStart= rulePipelineStageStart EOF )
            // InternalIntegrate.g:515:2: iv_rulePipelineStageStart= rulePipelineStageStart EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageStartRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageStart=rulePipelineStageStart();

            state._fsp--;

             current =iv_rulePipelineStageStart; 
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
    // $ANTLR end "entryRulePipelineStageStart"


    // $ANTLR start "rulePipelineStageStart"
    // InternalIntegrate.g:521:1: rulePipelineStageStart returns [EObject current=null] : (this_PipelineStageSrc_0= rulePipelineStageSrc | this_PipelineStageTrg_1= rulePipelineStageTrg ) ;
    public final EObject rulePipelineStageStart() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineStageSrc_0 = null;

        EObject this_PipelineStageTrg_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:527:2: ( (this_PipelineStageSrc_0= rulePipelineStageSrc | this_PipelineStageTrg_1= rulePipelineStageTrg ) )
            // InternalIntegrate.g:528:2: (this_PipelineStageSrc_0= rulePipelineStageSrc | this_PipelineStageTrg_1= rulePipelineStageTrg )
            {
            // InternalIntegrate.g:528:2: (this_PipelineStageSrc_0= rulePipelineStageSrc | this_PipelineStageTrg_1= rulePipelineStageTrg )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            else if ( (LA5_0==24) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalIntegrate.g:529:3: this_PipelineStageSrc_0= rulePipelineStageSrc
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageStartAccess().getPipelineStageSrcParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageSrc_0=rulePipelineStageSrc();

                    state._fsp--;


                    			current = this_PipelineStageSrc_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:538:3: this_PipelineStageTrg_1= rulePipelineStageTrg
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageStartAccess().getPipelineStageTrgParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageTrg_1=rulePipelineStageTrg();

                    state._fsp--;


                    			current = this_PipelineStageTrg_1;
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
    // $ANTLR end "rulePipelineStageStart"


    // $ANTLR start "entryRulePipelineStageSrc"
    // InternalIntegrate.g:550:1: entryRulePipelineStageSrc returns [EObject current=null] : iv_rulePipelineStageSrc= rulePipelineStageSrc EOF ;
    public final EObject entryRulePipelineStageSrc() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageSrc = null;


        try {
            // InternalIntegrate.g:550:57: (iv_rulePipelineStageSrc= rulePipelineStageSrc EOF )
            // InternalIntegrate.g:551:2: iv_rulePipelineStageSrc= rulePipelineStageSrc EOF
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
    // InternalIntegrate.g:557:1: rulePipelineStageSrc returns [EObject current=null] : ( ( (lv_name_0_0= 'src' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) ) ;
    public final EObject rulePipelineStageSrc() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_next_2_1 = null;

        EObject lv_next_2_2 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:563:2: ( ( ( (lv_name_0_0= 'src' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) ) )
            // InternalIntegrate.g:564:2: ( ( (lv_name_0_0= 'src' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            {
            // InternalIntegrate.g:564:2: ( ( (lv_name_0_0= 'src' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            // InternalIntegrate.g:565:3: ( (lv_name_0_0= 'src' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) )
            {
            // InternalIntegrate.g:565:3: ( (lv_name_0_0= 'src' ) )
            // InternalIntegrate.g:566:4: (lv_name_0_0= 'src' )
            {
            // InternalIntegrate.g:566:4: (lv_name_0_0= 'src' )
            // InternalIntegrate.g:567:5: lv_name_0_0= 'src'
            {
            lv_name_0_0=(Token)match(input,22,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineStageSrcRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "src");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getPipelineStageSrcAccess().getVerticalLineKeyword_1());
            		
            // InternalIntegrate.g:583:3: ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) )
            // InternalIntegrate.g:584:4: ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) )
            {
            // InternalIntegrate.g:584:4: ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) )
            // InternalIntegrate.g:585:5: (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd )
            {
            // InternalIntegrate.g:585:5: (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=25 && LA6_0<=27)) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=29 && LA6_0<=30)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalIntegrate.g:586:6: lv_next_2_1= rulePipelineStageFilter
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageSrcAccess().getNextPipelineStageFilterParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_1=rulePipelineStageFilter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageSrcRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_1,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageFilter");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:602:6: lv_next_2_2= rulePipelineStageEnd
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageSrcAccess().getNextPipelineStageEndParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_2=rulePipelineStageEnd();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageSrcRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_2,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageEnd");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


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
    // $ANTLR end "rulePipelineStageSrc"


    // $ANTLR start "entryRulePipelineStageTrg"
    // InternalIntegrate.g:624:1: entryRulePipelineStageTrg returns [EObject current=null] : iv_rulePipelineStageTrg= rulePipelineStageTrg EOF ;
    public final EObject entryRulePipelineStageTrg() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageTrg = null;


        try {
            // InternalIntegrate.g:624:57: (iv_rulePipelineStageTrg= rulePipelineStageTrg EOF )
            // InternalIntegrate.g:625:2: iv_rulePipelineStageTrg= rulePipelineStageTrg EOF
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
    // InternalIntegrate.g:631:1: rulePipelineStageTrg returns [EObject current=null] : ( ( (lv_name_0_0= 'trg' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) ) ;
    public final EObject rulePipelineStageTrg() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_next_2_1 = null;

        EObject lv_next_2_2 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:637:2: ( ( ( (lv_name_0_0= 'trg' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) ) )
            // InternalIntegrate.g:638:2: ( ( (lv_name_0_0= 'trg' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            {
            // InternalIntegrate.g:638:2: ( ( (lv_name_0_0= 'trg' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            // InternalIntegrate.g:639:3: ( (lv_name_0_0= 'trg' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) )
            {
            // InternalIntegrate.g:639:3: ( (lv_name_0_0= 'trg' ) )
            // InternalIntegrate.g:640:4: (lv_name_0_0= 'trg' )
            {
            // InternalIntegrate.g:640:4: (lv_name_0_0= 'trg' )
            // InternalIntegrate.g:641:5: lv_name_0_0= 'trg'
            {
            lv_name_0_0=(Token)match(input,24,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineStageTrgRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "trg");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getPipelineStageTrgAccess().getVerticalLineKeyword_1());
            		
            // InternalIntegrate.g:657:3: ( ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) ) )
            // InternalIntegrate.g:658:4: ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) )
            {
            // InternalIntegrate.g:658:4: ( (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd ) )
            // InternalIntegrate.g:659:5: (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd )
            {
            // InternalIntegrate.g:659:5: (lv_next_2_1= rulePipelineStageFilter | lv_next_2_2= rulePipelineStageEnd )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=25 && LA7_0<=27)) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=29 && LA7_0<=30)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalIntegrate.g:660:6: lv_next_2_1= rulePipelineStageFilter
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageTrgAccess().getNextPipelineStageFilterParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_1=rulePipelineStageFilter();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageTrgRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_1,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageFilter");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:676:6: lv_next_2_2= rulePipelineStageEnd
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageTrgAccess().getNextPipelineStageEndParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_2=rulePipelineStageEnd();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageTrgRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_2,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageEnd");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


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
    // $ANTLR end "rulePipelineStageTrg"


    // $ANTLR start "entryRulePipelineStageFilter"
    // InternalIntegrate.g:698:1: entryRulePipelineStageFilter returns [EObject current=null] : iv_rulePipelineStageFilter= rulePipelineStageFilter EOF ;
    public final EObject entryRulePipelineStageFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageFilter = null;


        try {
            // InternalIntegrate.g:698:60: (iv_rulePipelineStageFilter= rulePipelineStageFilter EOF )
            // InternalIntegrate.g:699:2: iv_rulePipelineStageFilter= rulePipelineStageFilter EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageFilter=rulePipelineStageFilter();

            state._fsp--;

             current =iv_rulePipelineStageFilter; 
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
    // $ANTLR end "entryRulePipelineStageFilter"


    // $ANTLR start "rulePipelineStageFilter"
    // InternalIntegrate.g:705:1: rulePipelineStageFilter returns [EObject current=null] : (this_PipelineStageModification_0= rulePipelineStageModification | this_PipelineStageType_1= rulePipelineStageType ) ;
    public final EObject rulePipelineStageFilter() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineStageModification_0 = null;

        EObject this_PipelineStageType_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:711:2: ( (this_PipelineStageModification_0= rulePipelineStageModification | this_PipelineStageType_1= rulePipelineStageType ) )
            // InternalIntegrate.g:712:2: (this_PipelineStageModification_0= rulePipelineStageModification | this_PipelineStageType_1= rulePipelineStageType )
            {
            // InternalIntegrate.g:712:2: (this_PipelineStageModification_0= rulePipelineStageModification | this_PipelineStageType_1= rulePipelineStageType )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=25 && LA8_0<=26)) ) {
                alt8=1;
            }
            else if ( (LA8_0==27) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalIntegrate.g:713:3: this_PipelineStageModification_0= rulePipelineStageModification
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageFilterAccess().getPipelineStageModificationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageModification_0=rulePipelineStageModification();

                    state._fsp--;


                    			current = this_PipelineStageModification_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:722:3: this_PipelineStageType_1= rulePipelineStageType
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageFilterAccess().getPipelineStageTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageType_1=rulePipelineStageType();

                    state._fsp--;


                    			current = this_PipelineStageType_1;
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
    // $ANTLR end "rulePipelineStageFilter"


    // $ANTLR start "entryRulePipelineStageModification"
    // InternalIntegrate.g:734:1: entryRulePipelineStageModification returns [EObject current=null] : iv_rulePipelineStageModification= rulePipelineStageModification EOF ;
    public final EObject entryRulePipelineStageModification() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageModification = null;


        try {
            // InternalIntegrate.g:734:66: (iv_rulePipelineStageModification= rulePipelineStageModification EOF )
            // InternalIntegrate.g:735:2: iv_rulePipelineStageModification= rulePipelineStageModification EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageModificationRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageModification=rulePipelineStageModification();

            state._fsp--;

             current =iv_rulePipelineStageModification; 
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
    // $ANTLR end "entryRulePipelineStageModification"


    // $ANTLR start "rulePipelineStageModification"
    // InternalIntegrate.g:741:1: rulePipelineStageModification returns [EObject current=null] : (this_PipelineStageCreated_0= rulePipelineStageCreated | this_PipelineStageDeleted_1= rulePipelineStageDeleted ) ;
    public final EObject rulePipelineStageModification() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineStageCreated_0 = null;

        EObject this_PipelineStageDeleted_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:747:2: ( (this_PipelineStageCreated_0= rulePipelineStageCreated | this_PipelineStageDeleted_1= rulePipelineStageDeleted ) )
            // InternalIntegrate.g:748:2: (this_PipelineStageCreated_0= rulePipelineStageCreated | this_PipelineStageDeleted_1= rulePipelineStageDeleted )
            {
            // InternalIntegrate.g:748:2: (this_PipelineStageCreated_0= rulePipelineStageCreated | this_PipelineStageDeleted_1= rulePipelineStageDeleted )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            else if ( (LA9_0==26) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalIntegrate.g:749:3: this_PipelineStageCreated_0= rulePipelineStageCreated
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageModificationAccess().getPipelineStageCreatedParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageCreated_0=rulePipelineStageCreated();

                    state._fsp--;


                    			current = this_PipelineStageCreated_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:758:3: this_PipelineStageDeleted_1= rulePipelineStageDeleted
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageModificationAccess().getPipelineStageDeletedParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageDeleted_1=rulePipelineStageDeleted();

                    state._fsp--;


                    			current = this_PipelineStageDeleted_1;
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
    // $ANTLR end "rulePipelineStageModification"


    // $ANTLR start "entryRulePipelineStageCreated"
    // InternalIntegrate.g:770:1: entryRulePipelineStageCreated returns [EObject current=null] : iv_rulePipelineStageCreated= rulePipelineStageCreated EOF ;
    public final EObject entryRulePipelineStageCreated() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageCreated = null;


        try {
            // InternalIntegrate.g:770:61: (iv_rulePipelineStageCreated= rulePipelineStageCreated EOF )
            // InternalIntegrate.g:771:2: iv_rulePipelineStageCreated= rulePipelineStageCreated EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageCreatedRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageCreated=rulePipelineStageCreated();

            state._fsp--;

             current =iv_rulePipelineStageCreated; 
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
    // $ANTLR end "entryRulePipelineStageCreated"


    // $ANTLR start "rulePipelineStageCreated"
    // InternalIntegrate.g:777:1: rulePipelineStageCreated returns [EObject current=null] : ( ( (lv_name_0_0= 'created' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) ) ;
    public final EObject rulePipelineStageCreated() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_next_2_1 = null;

        EObject lv_next_2_2 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:783:2: ( ( ( (lv_name_0_0= 'created' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) ) )
            // InternalIntegrate.g:784:2: ( ( (lv_name_0_0= 'created' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            {
            // InternalIntegrate.g:784:2: ( ( (lv_name_0_0= 'created' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            // InternalIntegrate.g:785:3: ( (lv_name_0_0= 'created' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) )
            {
            // InternalIntegrate.g:785:3: ( (lv_name_0_0= 'created' ) )
            // InternalIntegrate.g:786:4: (lv_name_0_0= 'created' )
            {
            // InternalIntegrate.g:786:4: (lv_name_0_0= 'created' )
            // InternalIntegrate.g:787:5: lv_name_0_0= 'created'
            {
            lv_name_0_0=(Token)match(input,25,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageCreatedAccess().getNameCreatedKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineStageCreatedRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "created");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getPipelineStageCreatedAccess().getVerticalLineKeyword_1());
            		
            // InternalIntegrate.g:803:3: ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) )
            // InternalIntegrate.g:804:4: ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) )
            {
            // InternalIntegrate.g:804:4: ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) )
            // InternalIntegrate.g:805:5: (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd )
            {
            // InternalIntegrate.g:805:5: (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=29 && LA10_0<=30)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalIntegrate.g:806:6: lv_next_2_1= rulePipelineStageType
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageCreatedAccess().getNextPipelineStageTypeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_1=rulePipelineStageType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageCreatedRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_1,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageType");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:822:6: lv_next_2_2= rulePipelineStageEnd
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageCreatedAccess().getNextPipelineStageEndParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_2=rulePipelineStageEnd();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageCreatedRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_2,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageEnd");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


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
    // $ANTLR end "rulePipelineStageCreated"


    // $ANTLR start "entryRulePipelineStageDeleted"
    // InternalIntegrate.g:844:1: entryRulePipelineStageDeleted returns [EObject current=null] : iv_rulePipelineStageDeleted= rulePipelineStageDeleted EOF ;
    public final EObject entryRulePipelineStageDeleted() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageDeleted = null;


        try {
            // InternalIntegrate.g:844:61: (iv_rulePipelineStageDeleted= rulePipelineStageDeleted EOF )
            // InternalIntegrate.g:845:2: iv_rulePipelineStageDeleted= rulePipelineStageDeleted EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageDeletedRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageDeleted=rulePipelineStageDeleted();

            state._fsp--;

             current =iv_rulePipelineStageDeleted; 
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
    // $ANTLR end "entryRulePipelineStageDeleted"


    // $ANTLR start "rulePipelineStageDeleted"
    // InternalIntegrate.g:851:1: rulePipelineStageDeleted returns [EObject current=null] : ( ( (lv_name_0_0= 'deleted' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) ) ;
    public final EObject rulePipelineStageDeleted() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_next_2_1 = null;

        EObject lv_next_2_2 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:857:2: ( ( ( (lv_name_0_0= 'deleted' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) ) )
            // InternalIntegrate.g:858:2: ( ( (lv_name_0_0= 'deleted' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            {
            // InternalIntegrate.g:858:2: ( ( (lv_name_0_0= 'deleted' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) ) )
            // InternalIntegrate.g:859:3: ( (lv_name_0_0= 'deleted' ) ) otherlv_1= '|' ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) )
            {
            // InternalIntegrate.g:859:3: ( (lv_name_0_0= 'deleted' ) )
            // InternalIntegrate.g:860:4: (lv_name_0_0= 'deleted' )
            {
            // InternalIntegrate.g:860:4: (lv_name_0_0= 'deleted' )
            // InternalIntegrate.g:861:5: lv_name_0_0= 'deleted'
            {
            lv_name_0_0=(Token)match(input,26,FOLLOW_18); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageDeletedAccess().getNameDeletedKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineStageDeletedRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "deleted");
            				

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_1, grammarAccess.getPipelineStageDeletedAccess().getVerticalLineKeyword_1());
            		
            // InternalIntegrate.g:877:3: ( ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) ) )
            // InternalIntegrate.g:878:4: ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) )
            {
            // InternalIntegrate.g:878:4: ( (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd ) )
            // InternalIntegrate.g:879:5: (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd )
            {
            // InternalIntegrate.g:879:5: (lv_next_2_1= rulePipelineStageType | lv_next_2_2= rulePipelineStageEnd )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==27) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=29 && LA11_0<=30)) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalIntegrate.g:880:6: lv_next_2_1= rulePipelineStageType
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageDeletedAccess().getNextPipelineStageTypeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_1=rulePipelineStageType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageDeletedRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_1,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageType");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:896:6: lv_next_2_2= rulePipelineStageEnd
                    {

                    						newCompositeNode(grammarAccess.getPipelineStageDeletedAccess().getNextPipelineStageEndParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_next_2_2=rulePipelineStageEnd();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPipelineStageDeletedRule());
                    						}
                    						set(
                    							current,
                    							"next",
                    							lv_next_2_2,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageEnd");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


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
    // $ANTLR end "rulePipelineStageDeleted"


    // $ANTLR start "entryRulePipelineStageType"
    // InternalIntegrate.g:918:1: entryRulePipelineStageType returns [EObject current=null] : iv_rulePipelineStageType= rulePipelineStageType EOF ;
    public final EObject entryRulePipelineStageType() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageType = null;


        try {
            // InternalIntegrate.g:918:58: (iv_rulePipelineStageType= rulePipelineStageType EOF )
            // InternalIntegrate.g:919:2: iv_rulePipelineStageType= rulePipelineStageType EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageType=rulePipelineStageType();

            state._fsp--;

             current =iv_rulePipelineStageType; 
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
    // $ANTLR end "entryRulePipelineStageType"


    // $ANTLR start "rulePipelineStageType"
    // InternalIntegrate.g:925:1: rulePipelineStageType returns [EObject current=null] : ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' ( (lv_next_5_0= rulePipelineStageEnd ) ) ) ;
    public final EObject rulePipelineStageType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_next_5_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:931:2: ( ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' ( (lv_next_5_0= rulePipelineStageEnd ) ) ) )
            // InternalIntegrate.g:932:2: ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' ( (lv_next_5_0= rulePipelineStageEnd ) ) )
            {
            // InternalIntegrate.g:932:2: ( ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' ( (lv_next_5_0= rulePipelineStageEnd ) ) )
            // InternalIntegrate.g:933:3: ( (lv_name_0_0= 'type' ) ) ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* otherlv_4= '|' ( (lv_next_5_0= rulePipelineStageEnd ) )
            {
            // InternalIntegrate.g:933:3: ( (lv_name_0_0= 'type' ) )
            // InternalIntegrate.g:934:4: (lv_name_0_0= 'type' )
            {
            // InternalIntegrate.g:934:4: (lv_name_0_0= 'type' )
            // InternalIntegrate.g:935:5: lv_name_0_0= 'type'
            {
            lv_name_0_0=(Token)match(input,27,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageTypeAccess().getNameTypeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineStageTypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "type");
            				

            }


            }

            // InternalIntegrate.g:947:3: ( (otherlv_1= RULE_ID ) )
            // InternalIntegrate.g:948:4: (otherlv_1= RULE_ID )
            {
            // InternalIntegrate.g:948:4: (otherlv_1= RULE_ID )
            // InternalIntegrate.g:949:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPipelineStageTypeRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(otherlv_1, grammarAccess.getPipelineStageTypeAccess().getTypesEClassCrossReference_1_0());
            				

            }


            }

            // InternalIntegrate.g:960:3: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==28) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalIntegrate.g:961:4: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,28,FOLLOW_5); 

            	    				newLeafNode(otherlv_2, grammarAccess.getPipelineStageTypeAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalIntegrate.g:965:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalIntegrate.g:966:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalIntegrate.g:966:5: (otherlv_3= RULE_ID )
            	    // InternalIntegrate.g:967:6: otherlv_3= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getPipelineStageTypeRule());
            	    						}
            	    					
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_20); 

            	    						newLeafNode(otherlv_3, grammarAccess.getPipelineStageTypeAccess().getTypesEClassCrossReference_2_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_4=(Token)match(input,23,FOLLOW_19); 

            			newLeafNode(otherlv_4, grammarAccess.getPipelineStageTypeAccess().getVerticalLineKeyword_3());
            		
            // InternalIntegrate.g:983:3: ( (lv_next_5_0= rulePipelineStageEnd ) )
            // InternalIntegrate.g:984:4: (lv_next_5_0= rulePipelineStageEnd )
            {
            // InternalIntegrate.g:984:4: (lv_next_5_0= rulePipelineStageEnd )
            // InternalIntegrate.g:985:5: lv_next_5_0= rulePipelineStageEnd
            {

            					newCompositeNode(grammarAccess.getPipelineStageTypeAccess().getNextPipelineStageEndParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_next_5_0=rulePipelineStageEnd();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPipelineStageTypeRule());
            					}
            					set(
            						current,
            						"next",
            						lv_next_5_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.PipelineStageEnd");
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
    // $ANTLR end "rulePipelineStageType"


    // $ANTLR start "entryRulePipelineStageEnd"
    // InternalIntegrate.g:1006:1: entryRulePipelineStageEnd returns [EObject current=null] : iv_rulePipelineStageEnd= rulePipelineStageEnd EOF ;
    public final EObject entryRulePipelineStageEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageEnd = null;


        try {
            // InternalIntegrate.g:1006:57: (iv_rulePipelineStageEnd= rulePipelineStageEnd EOF )
            // InternalIntegrate.g:1007:2: iv_rulePipelineStageEnd= rulePipelineStageEnd EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageEndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageEnd=rulePipelineStageEnd();

            state._fsp--;

             current =iv_rulePipelineStageEnd; 
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
    // $ANTLR end "entryRulePipelineStageEnd"


    // $ANTLR start "rulePipelineStageEnd"
    // InternalIntegrate.g:1013:1: rulePipelineStageEnd returns [EObject current=null] : (this_PipelineStageCount_0= rulePipelineStageCount | this_PipelineStageExists_1= rulePipelineStageExists ) ;
    public final EObject rulePipelineStageEnd() throws RecognitionException {
        EObject current = null;

        EObject this_PipelineStageCount_0 = null;

        EObject this_PipelineStageExists_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1019:2: ( (this_PipelineStageCount_0= rulePipelineStageCount | this_PipelineStageExists_1= rulePipelineStageExists ) )
            // InternalIntegrate.g:1020:2: (this_PipelineStageCount_0= rulePipelineStageCount | this_PipelineStageExists_1= rulePipelineStageExists )
            {
            // InternalIntegrate.g:1020:2: (this_PipelineStageCount_0= rulePipelineStageCount | this_PipelineStageExists_1= rulePipelineStageExists )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==29) ) {
                alt13=1;
            }
            else if ( (LA13_0==30) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalIntegrate.g:1021:3: this_PipelineStageCount_0= rulePipelineStageCount
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageEndAccess().getPipelineStageCountParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageCount_0=rulePipelineStageCount();

                    state._fsp--;


                    			current = this_PipelineStageCount_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1030:3: this_PipelineStageExists_1= rulePipelineStageExists
                    {

                    			newCompositeNode(grammarAccess.getPipelineStageEndAccess().getPipelineStageExistsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PipelineStageExists_1=rulePipelineStageExists();

                    state._fsp--;


                    			current = this_PipelineStageExists_1;
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
    // $ANTLR end "rulePipelineStageEnd"


    // $ANTLR start "entryRulePipelineStageCount"
    // InternalIntegrate.g:1042:1: entryRulePipelineStageCount returns [EObject current=null] : iv_rulePipelineStageCount= rulePipelineStageCount EOF ;
    public final EObject entryRulePipelineStageCount() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageCount = null;


        try {
            // InternalIntegrate.g:1042:59: (iv_rulePipelineStageCount= rulePipelineStageCount EOF )
            // InternalIntegrate.g:1043:2: iv_rulePipelineStageCount= rulePipelineStageCount EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageCountRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageCount=rulePipelineStageCount();

            state._fsp--;

             current =iv_rulePipelineStageCount; 
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
    // $ANTLR end "entryRulePipelineStageCount"


    // $ANTLR start "rulePipelineStageCount"
    // InternalIntegrate.g:1049:1: rulePipelineStageCount returns [EObject current=null] : ( (lv_name_0_0= 'count' ) ) ;
    public final EObject rulePipelineStageCount() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1055:2: ( ( (lv_name_0_0= 'count' ) ) )
            // InternalIntegrate.g:1056:2: ( (lv_name_0_0= 'count' ) )
            {
            // InternalIntegrate.g:1056:2: ( (lv_name_0_0= 'count' ) )
            // InternalIntegrate.g:1057:3: (lv_name_0_0= 'count' )
            {
            // InternalIntegrate.g:1057:3: (lv_name_0_0= 'count' )
            // InternalIntegrate.g:1058:4: lv_name_0_0= 'count'
            {
            lv_name_0_0=(Token)match(input,29,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageCountAccess().getNameCountKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineStageCountRule());
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
    // $ANTLR end "rulePipelineStageCount"


    // $ANTLR start "entryRulePipelineStageExists"
    // InternalIntegrate.g:1073:1: entryRulePipelineStageExists returns [EObject current=null] : iv_rulePipelineStageExists= rulePipelineStageExists EOF ;
    public final EObject entryRulePipelineStageExists() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePipelineStageExists = null;


        try {
            // InternalIntegrate.g:1073:60: (iv_rulePipelineStageExists= rulePipelineStageExists EOF )
            // InternalIntegrate.g:1074:2: iv_rulePipelineStageExists= rulePipelineStageExists EOF
            {
             newCompositeNode(grammarAccess.getPipelineStageExistsRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePipelineStageExists=rulePipelineStageExists();

            state._fsp--;

             current =iv_rulePipelineStageExists; 
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
    // $ANTLR end "entryRulePipelineStageExists"


    // $ANTLR start "rulePipelineStageExists"
    // InternalIntegrate.g:1080:1: rulePipelineStageExists returns [EObject current=null] : ( (lv_name_0_0= 'exists' ) ) ;
    public final EObject rulePipelineStageExists() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1086:2: ( ( (lv_name_0_0= 'exists' ) ) )
            // InternalIntegrate.g:1087:2: ( (lv_name_0_0= 'exists' ) )
            {
            // InternalIntegrate.g:1087:2: ( (lv_name_0_0= 'exists' ) )
            // InternalIntegrate.g:1088:3: (lv_name_0_0= 'exists' )
            {
            // InternalIntegrate.g:1088:3: (lv_name_0_0= 'exists' )
            // InternalIntegrate.g:1089:4: lv_name_0_0= 'exists'
            {
            lv_name_0_0=(Token)match(input,30,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPipelineStageExistsAccess().getNameExistsKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPipelineStageExistsRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "exists");
            			

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
    // $ANTLR end "rulePipelineStageExists"


    // $ANTLR start "entryRuleSatisfactionRule"
    // InternalIntegrate.g:1104:1: entryRuleSatisfactionRule returns [EObject current=null] : iv_ruleSatisfactionRule= ruleSatisfactionRule EOF ;
    public final EObject entryRuleSatisfactionRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSatisfactionRule = null;


        try {
            // InternalIntegrate.g:1104:57: (iv_ruleSatisfactionRule= ruleSatisfactionRule EOF )
            // InternalIntegrate.g:1105:2: iv_ruleSatisfactionRule= ruleSatisfactionRule EOF
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
    // InternalIntegrate.g:1111:1: ruleSatisfactionRule returns [EObject current=null] : ( (lv_expression_0_0= ruleOrExpression ) ) ;
    public final EObject ruleSatisfactionRule() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1117:2: ( ( (lv_expression_0_0= ruleOrExpression ) ) )
            // InternalIntegrate.g:1118:2: ( (lv_expression_0_0= ruleOrExpression ) )
            {
            // InternalIntegrate.g:1118:2: ( (lv_expression_0_0= ruleOrExpression ) )
            // InternalIntegrate.g:1119:3: (lv_expression_0_0= ruleOrExpression )
            {
            // InternalIntegrate.g:1119:3: (lv_expression_0_0= ruleOrExpression )
            // InternalIntegrate.g:1120:4: lv_expression_0_0= ruleOrExpression
            {

            				newCompositeNode(grammarAccess.getSatisfactionRuleAccess().getExpressionOrExpressionParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_expression_0_0=ruleOrExpression();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getSatisfactionRuleRule());
            				}
            				set(
            					current,
            					"expression",
            					lv_expression_0_0,
            					"org.emoflon.ibex.tgg.integrate.Integrate.OrExpression");
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
    // $ANTLR end "ruleSatisfactionRule"


    // $ANTLR start "entryRuleOrExpression"
    // InternalIntegrate.g:1140:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalIntegrate.g:1140:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalIntegrate.g:1141:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             newCompositeNode(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;

             current =iv_ruleOrExpression; 
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
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalIntegrate.g:1147:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1153:2: ( (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalIntegrate.g:1154:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalIntegrate.g:1154:2: (this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalIntegrate.g:1155:3: this_AndExpression_0= ruleAndExpression ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_21);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;


            			current = this_AndExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalIntegrate.g:1163:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==31) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalIntegrate.g:1164:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalIntegrate.g:1164:4: ()
            	    // InternalIntegrate.g:1165:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,31,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getOrExpressionAccess().getOrKeyword_1_1());
            	    			
            	    // InternalIntegrate.g:1175:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalIntegrate.g:1176:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalIntegrate.g:1176:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalIntegrate.g:1177:6: lv_right_3_0= ruleAndExpression
            	    {

            	    						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.emoflon.ibex.tgg.integrate.Integrate.AndExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalIntegrate.g:1199:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalIntegrate.g:1199:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalIntegrate.g:1200:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             newCompositeNode(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;

             current =iv_ruleAndExpression; 
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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalIntegrate.g:1206:1: ruleAndExpression returns [EObject current=null] : (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_BooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1212:2: ( (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* ) )
            // InternalIntegrate.g:1213:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            {
            // InternalIntegrate.g:1213:2: (this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )* )
            // InternalIntegrate.g:1214:3: this_BooleanExpression_0= ruleBooleanExpression ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndExpressionAccess().getBooleanExpressionParserRuleCall_0());
            		
            pushFollow(FOLLOW_22);
            this_BooleanExpression_0=ruleBooleanExpression();

            state._fsp--;


            			current = this_BooleanExpression_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalIntegrate.g:1222:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==32) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalIntegrate.g:1223:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleBooleanExpression ) )
            	    {
            	    // InternalIntegrate.g:1223:4: ()
            	    // InternalIntegrate.g:1224:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	    						current);
            	    				

            	    }

            	    otherlv_2=(Token)match(input,32,FOLLOW_12); 

            	    				newLeafNode(otherlv_2, grammarAccess.getAndExpressionAccess().getAndKeyword_1_1());
            	    			
            	    // InternalIntegrate.g:1234:4: ( (lv_right_3_0= ruleBooleanExpression ) )
            	    // InternalIntegrate.g:1235:5: (lv_right_3_0= ruleBooleanExpression )
            	    {
            	    // InternalIntegrate.g:1235:5: (lv_right_3_0= ruleBooleanExpression )
            	    // InternalIntegrate.g:1236:6: lv_right_3_0= ruleBooleanExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightBooleanExpressionParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_right_3_0=ruleBooleanExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"right",
            	    							lv_right_3_0,
            	    							"org.emoflon.ibex.tgg.integrate.Integrate.BooleanExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalIntegrate.g:1258:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalIntegrate.g:1258:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalIntegrate.g:1259:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;

             current =iv_ruleBooleanExpression; 
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
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalIntegrate.g:1265:1: ruleBooleanExpression returns [EObject current=null] : ( ( (lv_invert_0_0= 'not' ) )? ( ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) ) ) ) ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_invert_0_0=null;
        EObject lv_expression_1_1 = null;

        EObject lv_expression_1_2 = null;

        EObject lv_expression_1_3 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1271:2: ( ( ( (lv_invert_0_0= 'not' ) )? ( ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) ) ) ) )
            // InternalIntegrate.g:1272:2: ( ( (lv_invert_0_0= 'not' ) )? ( ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) ) ) )
            {
            // InternalIntegrate.g:1272:2: ( ( (lv_invert_0_0= 'not' ) )? ( ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) ) ) )
            // InternalIntegrate.g:1273:3: ( (lv_invert_0_0= 'not' ) )? ( ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) ) )
            {
            // InternalIntegrate.g:1273:3: ( (lv_invert_0_0= 'not' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==33) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalIntegrate.g:1274:4: (lv_invert_0_0= 'not' )
                    {
                    // InternalIntegrate.g:1274:4: (lv_invert_0_0= 'not' )
                    // InternalIntegrate.g:1275:5: lv_invert_0_0= 'not'
                    {
                    lv_invert_0_0=(Token)match(input,33,FOLLOW_12); 

                    					newLeafNode(lv_invert_0_0, grammarAccess.getBooleanExpressionAccess().getInvertNotKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanExpressionRule());
                    					}
                    					setWithLastConsumed(current, "invert", lv_invert_0_0 != null, "not");
                    				

                    }


                    }
                    break;

            }

            // InternalIntegrate.g:1287:3: ( ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) ) )
            // InternalIntegrate.g:1288:4: ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) )
            {
            // InternalIntegrate.g:1288:4: ( (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression ) )
            // InternalIntegrate.g:1289:5: (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression )
            {
            // InternalIntegrate.g:1289:5: (lv_expression_1_1= ruleComparisonExpression | lv_expression_1_2= ruleVariableReference | lv_expression_1_3= ruleWrappedOrExpression )
            int alt17=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA17_1 = input.LA(2);

                if ( ((LA17_1>=36 && LA17_1<=41)) ) {
                    alt17=1;
                }
                else if ( (LA17_1==EOF||LA17_1==18||(LA17_1>=31 && LA17_1<=32)||LA17_1==35) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt17=1;
                }
                break;
            case 34:
                {
                alt17=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalIntegrate.g:1290:6: lv_expression_1_1= ruleComparisonExpression
                    {

                    						newCompositeNode(grammarAccess.getBooleanExpressionAccess().getExpressionComparisonExpressionParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_1_1=ruleComparisonExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBooleanExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_1_1,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.ComparisonExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1306:6: lv_expression_1_2= ruleVariableReference
                    {

                    						newCompositeNode(grammarAccess.getBooleanExpressionAccess().getExpressionVariableReferenceParserRuleCall_1_0_1());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_1_2=ruleVariableReference();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBooleanExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_1_2,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.VariableReference");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1322:6: lv_expression_1_3= ruleWrappedOrExpression
                    {

                    						newCompositeNode(grammarAccess.getBooleanExpressionAccess().getExpressionWrappedOrExpressionParserRuleCall_1_0_2());
                    					
                    pushFollow(FOLLOW_2);
                    lv_expression_1_3=ruleWrappedOrExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBooleanExpressionRule());
                    						}
                    						set(
                    							current,
                    							"expression",
                    							lv_expression_1_3,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.WrappedOrExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


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
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleWrappedOrExpression"
    // InternalIntegrate.g:1344:1: entryRuleWrappedOrExpression returns [EObject current=null] : iv_ruleWrappedOrExpression= ruleWrappedOrExpression EOF ;
    public final EObject entryRuleWrappedOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWrappedOrExpression = null;


        try {
            // InternalIntegrate.g:1344:60: (iv_ruleWrappedOrExpression= ruleWrappedOrExpression EOF )
            // InternalIntegrate.g:1345:2: iv_ruleWrappedOrExpression= ruleWrappedOrExpression EOF
            {
             newCompositeNode(grammarAccess.getWrappedOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWrappedOrExpression=ruleWrappedOrExpression();

            state._fsp--;

             current =iv_ruleWrappedOrExpression; 
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
    // $ANTLR end "entryRuleWrappedOrExpression"


    // $ANTLR start "ruleWrappedOrExpression"
    // InternalIntegrate.g:1351:1: ruleWrappedOrExpression returns [EObject current=null] : (otherlv_0= '(' ( (lv_expression_1_0= ruleOrExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleWrappedOrExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1357:2: ( (otherlv_0= '(' ( (lv_expression_1_0= ruleOrExpression ) ) otherlv_2= ')' ) )
            // InternalIntegrate.g:1358:2: (otherlv_0= '(' ( (lv_expression_1_0= ruleOrExpression ) ) otherlv_2= ')' )
            {
            // InternalIntegrate.g:1358:2: (otherlv_0= '(' ( (lv_expression_1_0= ruleOrExpression ) ) otherlv_2= ')' )
            // InternalIntegrate.g:1359:3: otherlv_0= '(' ( (lv_expression_1_0= ruleOrExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_12); 

            			newLeafNode(otherlv_0, grammarAccess.getWrappedOrExpressionAccess().getLeftParenthesisKeyword_0());
            		
            // InternalIntegrate.g:1363:3: ( (lv_expression_1_0= ruleOrExpression ) )
            // InternalIntegrate.g:1364:4: (lv_expression_1_0= ruleOrExpression )
            {
            // InternalIntegrate.g:1364:4: (lv_expression_1_0= ruleOrExpression )
            // InternalIntegrate.g:1365:5: lv_expression_1_0= ruleOrExpression
            {

            					newCompositeNode(grammarAccess.getWrappedOrExpressionAccess().getExpressionOrExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_23);
            lv_expression_1_0=ruleOrExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWrappedOrExpressionRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_1_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.OrExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,35,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getWrappedOrExpressionAccess().getRightParenthesisKeyword_2());
            		

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
    // $ANTLR end "ruleWrappedOrExpression"


    // $ANTLR start "entryRuleComparisonExpression"
    // InternalIntegrate.g:1390:1: entryRuleComparisonExpression returns [EObject current=null] : iv_ruleComparisonExpression= ruleComparisonExpression EOF ;
    public final EObject entryRuleComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpression = null;


        try {
            // InternalIntegrate.g:1390:61: (iv_ruleComparisonExpression= ruleComparisonExpression EOF )
            // InternalIntegrate.g:1391:2: iv_ruleComparisonExpression= ruleComparisonExpression EOF
            {
             newCompositeNode(grammarAccess.getComparisonExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparisonExpression=ruleComparisonExpression();

            state._fsp--;

             current =iv_ruleComparisonExpression; 
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
    // $ANTLR end "entryRuleComparisonExpression"


    // $ANTLR start "ruleComparisonExpression"
    // InternalIntegrate.g:1397:1: ruleComparisonExpression returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleComparisonParameter ) ) ( ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) ) ) ( (lv_rhs_2_0= ruleComparisonParameter ) ) ) ;
    public final EObject ruleComparisonExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        Token lv_op_1_5=null;
        Token lv_op_1_6=null;
        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_2_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1403:2: ( ( ( (lv_lhs_0_0= ruleComparisonParameter ) ) ( ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) ) ) ( (lv_rhs_2_0= ruleComparisonParameter ) ) ) )
            // InternalIntegrate.g:1404:2: ( ( (lv_lhs_0_0= ruleComparisonParameter ) ) ( ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) ) ) ( (lv_rhs_2_0= ruleComparisonParameter ) ) )
            {
            // InternalIntegrate.g:1404:2: ( ( (lv_lhs_0_0= ruleComparisonParameter ) ) ( ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) ) ) ( (lv_rhs_2_0= ruleComparisonParameter ) ) )
            // InternalIntegrate.g:1405:3: ( (lv_lhs_0_0= ruleComparisonParameter ) ) ( ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) ) ) ( (lv_rhs_2_0= ruleComparisonParameter ) )
            {
            // InternalIntegrate.g:1405:3: ( (lv_lhs_0_0= ruleComparisonParameter ) )
            // InternalIntegrate.g:1406:4: (lv_lhs_0_0= ruleComparisonParameter )
            {
            // InternalIntegrate.g:1406:4: (lv_lhs_0_0= ruleComparisonParameter )
            // InternalIntegrate.g:1407:5: lv_lhs_0_0= ruleComparisonParameter
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionAccess().getLhsComparisonParameterParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_24);
            lv_lhs_0_0=ruleComparisonParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonExpressionRule());
            					}
            					set(
            						current,
            						"lhs",
            						lv_lhs_0_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.ComparisonParameter");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalIntegrate.g:1424:3: ( ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) ) )
            // InternalIntegrate.g:1425:4: ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) )
            {
            // InternalIntegrate.g:1425:4: ( (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' ) )
            // InternalIntegrate.g:1426:5: (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' )
            {
            // InternalIntegrate.g:1426:5: (lv_op_1_1= '>' | lv_op_1_2= '>=' | lv_op_1_3= '<' | lv_op_1_4= '<=' | lv_op_1_5= '==' | lv_op_1_6= '!=' )
            int alt18=6;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt18=1;
                }
                break;
            case 37:
                {
                alt18=2;
                }
                break;
            case 38:
                {
                alt18=3;
                }
                break;
            case 39:
                {
                alt18=4;
                }
                break;
            case 40:
                {
                alt18=5;
                }
                break;
            case 41:
                {
                alt18=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalIntegrate.g:1427:6: lv_op_1_1= '>'
                    {
                    lv_op_1_1=(Token)match(input,36,FOLLOW_25); 

                    						newLeafNode(lv_op_1_1, grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonExpressionRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1438:6: lv_op_1_2= '>='
                    {
                    lv_op_1_2=(Token)match(input,37,FOLLOW_25); 

                    						newLeafNode(lv_op_1_2, grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonExpressionRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1449:6: lv_op_1_3= '<'
                    {
                    lv_op_1_3=(Token)match(input,38,FOLLOW_25); 

                    						newLeafNode(lv_op_1_3, grammarAccess.getComparisonExpressionAccess().getOpLessThanSignKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonExpressionRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:1460:6: lv_op_1_4= '<='
                    {
                    lv_op_1_4=(Token)match(input,39,FOLLOW_25); 

                    						newLeafNode(lv_op_1_4, grammarAccess.getComparisonExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonExpressionRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalIntegrate.g:1471:6: lv_op_1_5= '=='
                    {
                    lv_op_1_5=(Token)match(input,40,FOLLOW_25); 

                    						newLeafNode(lv_op_1_5, grammarAccess.getComparisonExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonExpressionRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_1_5, null);
                    					

                    }
                    break;
                case 6 :
                    // InternalIntegrate.g:1482:6: lv_op_1_6= '!='
                    {
                    lv_op_1_6=(Token)match(input,41,FOLLOW_25); 

                    						newLeafNode(lv_op_1_6, grammarAccess.getComparisonExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_5());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getComparisonExpressionRule());
                    						}
                    						setWithLastConsumed(current, "op", lv_op_1_6, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalIntegrate.g:1495:3: ( (lv_rhs_2_0= ruleComparisonParameter ) )
            // InternalIntegrate.g:1496:4: (lv_rhs_2_0= ruleComparisonParameter )
            {
            // InternalIntegrate.g:1496:4: (lv_rhs_2_0= ruleComparisonParameter )
            // InternalIntegrate.g:1497:5: lv_rhs_2_0= ruleComparisonParameter
            {

            					newCompositeNode(grammarAccess.getComparisonExpressionAccess().getRhsComparisonParameterParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_rhs_2_0=ruleComparisonParameter();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComparisonExpressionRule());
            					}
            					set(
            						current,
            						"rhs",
            						lv_rhs_2_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.ComparisonParameter");
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
    // $ANTLR end "ruleComparisonExpression"


    // $ANTLR start "entryRuleComparisonParameter"
    // InternalIntegrate.g:1518:1: entryRuleComparisonParameter returns [EObject current=null] : iv_ruleComparisonParameter= ruleComparisonParameter EOF ;
    public final EObject entryRuleComparisonParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonParameter = null;


        try {
            // InternalIntegrate.g:1518:60: (iv_ruleComparisonParameter= ruleComparisonParameter EOF )
            // InternalIntegrate.g:1519:2: iv_ruleComparisonParameter= ruleComparisonParameter EOF
            {
             newCompositeNode(grammarAccess.getComparisonParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparisonParameter=ruleComparisonParameter();

            state._fsp--;

             current =iv_ruleComparisonParameter; 
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
    // $ANTLR end "entryRuleComparisonParameter"


    // $ANTLR start "ruleComparisonParameter"
    // InternalIntegrate.g:1525:1: ruleComparisonParameter returns [EObject current=null] : (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue ) ;
    public final EObject ruleComparisonParameter() throws RecognitionException {
        EObject current = null;

        EObject this_VariableReference_0 = null;

        EObject this_LiteralValue_1 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1531:2: ( (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue ) )
            // InternalIntegrate.g:1532:2: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue )
            {
            // InternalIntegrate.g:1532:2: (this_VariableReference_0= ruleVariableReference | this_LiteralValue_1= ruleLiteralValue )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_INT) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalIntegrate.g:1533:3: this_VariableReference_0= ruleVariableReference
                    {

                    			newCompositeNode(grammarAccess.getComparisonParameterAccess().getVariableReferenceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableReference_0=ruleVariableReference();

                    state._fsp--;


                    			current = this_VariableReference_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1542:3: this_LiteralValue_1= ruleLiteralValue
                    {

                    			newCompositeNode(grammarAccess.getComparisonParameterAccess().getLiteralValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LiteralValue_1=ruleLiteralValue();

                    state._fsp--;


                    			current = this_LiteralValue_1;
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
    // $ANTLR end "ruleComparisonParameter"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalIntegrate.g:1554:1: entryRuleLiteralValue returns [EObject current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final EObject entryRuleLiteralValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralValue = null;


        try {
            // InternalIntegrate.g:1554:53: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalIntegrate.g:1555:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             newCompositeNode(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue; 
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
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // InternalIntegrate.g:1561:1: ruleLiteralValue returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleLiteralValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1567:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalIntegrate.g:1568:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalIntegrate.g:1568:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalIntegrate.g:1569:3: (lv_value_0_0= RULE_INT )
            {
            // InternalIntegrate.g:1569:3: (lv_value_0_0= RULE_INT )
            // InternalIntegrate.g:1570:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getLiteralValueAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getLiteralValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

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
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleResolution"
    // InternalIntegrate.g:1589:1: entryRuleResolution returns [EObject current=null] : iv_ruleResolution= ruleResolution EOF ;
    public final EObject entryRuleResolution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResolution = null;


        try {
            // InternalIntegrate.g:1589:51: (iv_ruleResolution= ruleResolution EOF )
            // InternalIntegrate.g:1590:2: iv_ruleResolution= ruleResolution EOF
            {
             newCompositeNode(grammarAccess.getResolutionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResolution=ruleResolution();

            state._fsp--;

             current =iv_ruleResolution; 
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
    // $ANTLR end "entryRuleResolution"


    // $ANTLR start "ruleResolution"
    // InternalIntegrate.g:1596:1: ruleResolution returns [EObject current=null] : ( ( (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta ) ) (otherlv_1= 'or' ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) ) )* ( (lv_fallback_3_0= ruleFallbackResolutionStrategy ) )? ) ;
    public final EObject ruleResolution() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_strategies_0_0 = null;

        EObject lv_strategies_2_0 = null;

        EObject lv_fallback_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1602:2: ( ( ( (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta ) ) (otherlv_1= 'or' ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) ) )* ( (lv_fallback_3_0= ruleFallbackResolutionStrategy ) )? ) )
            // InternalIntegrate.g:1603:2: ( ( (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta ) ) (otherlv_1= 'or' ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) ) )* ( (lv_fallback_3_0= ruleFallbackResolutionStrategy ) )? )
            {
            // InternalIntegrate.g:1603:2: ( ( (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta ) ) (otherlv_1= 'or' ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) ) )* ( (lv_fallback_3_0= ruleFallbackResolutionStrategy ) )? )
            // InternalIntegrate.g:1604:3: ( (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta ) ) (otherlv_1= 'or' ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) ) )* ( (lv_fallback_3_0= ruleFallbackResolutionStrategy ) )?
            {
            // InternalIntegrate.g:1604:3: ( (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta ) )
            // InternalIntegrate.g:1605:4: (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta )
            {
            // InternalIntegrate.g:1605:4: (lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta )
            // InternalIntegrate.g:1606:5: lv_strategies_0_0= ruleResolutionStrategyWithOperationalDelta
            {

            					newCompositeNode(grammarAccess.getResolutionAccess().getStrategiesResolutionStrategyWithOperationalDeltaParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_26);
            lv_strategies_0_0=ruleResolutionStrategyWithOperationalDelta();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getResolutionRule());
            					}
            					add(
            						current,
            						"strategies",
            						lv_strategies_0_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.ResolutionStrategyWithOperationalDelta");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalIntegrate.g:1623:3: (otherlv_1= 'or' ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalIntegrate.g:1624:4: otherlv_1= 'or' ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) )
            	    {
            	    otherlv_1=(Token)match(input,31,FOLLOW_15); 

            	    				newLeafNode(otherlv_1, grammarAccess.getResolutionAccess().getOrKeyword_1_0());
            	    			
            	    // InternalIntegrate.g:1628:4: ( (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta ) )
            	    // InternalIntegrate.g:1629:5: (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta )
            	    {
            	    // InternalIntegrate.g:1629:5: (lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta )
            	    // InternalIntegrate.g:1630:6: lv_strategies_2_0= ruleResolutionStrategyWithOperationalDelta
            	    {

            	    						newCompositeNode(grammarAccess.getResolutionAccess().getStrategiesResolutionStrategyWithOperationalDeltaParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_strategies_2_0=ruleResolutionStrategyWithOperationalDelta();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getResolutionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"strategies",
            	    							lv_strategies_2_0,
            	    							"org.emoflon.ibex.tgg.integrate.Integrate.ResolutionStrategyWithOperationalDelta");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // InternalIntegrate.g:1648:3: ( (lv_fallback_3_0= ruleFallbackResolutionStrategy ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=46 && LA21_0<=49)) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalIntegrate.g:1649:4: (lv_fallback_3_0= ruleFallbackResolutionStrategy )
                    {
                    // InternalIntegrate.g:1649:4: (lv_fallback_3_0= ruleFallbackResolutionStrategy )
                    // InternalIntegrate.g:1650:5: lv_fallback_3_0= ruleFallbackResolutionStrategy
                    {

                    					newCompositeNode(grammarAccess.getResolutionAccess().getFallbackFallbackResolutionStrategyParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_fallback_3_0=ruleFallbackResolutionStrategy();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getResolutionRule());
                    					}
                    					set(
                    						current,
                    						"fallback",
                    						lv_fallback_3_0,
                    						"org.emoflon.ibex.tgg.integrate.Integrate.FallbackResolutionStrategy");
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
    // $ANTLR end "ruleResolution"


    // $ANTLR start "entryRuleResolutionStrategyWithOperationalDelta"
    // InternalIntegrate.g:1671:1: entryRuleResolutionStrategyWithOperationalDelta returns [EObject current=null] : iv_ruleResolutionStrategyWithOperationalDelta= ruleResolutionStrategyWithOperationalDelta EOF ;
    public final EObject entryRuleResolutionStrategyWithOperationalDelta() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResolutionStrategyWithOperationalDelta = null;


        try {
            // InternalIntegrate.g:1671:79: (iv_ruleResolutionStrategyWithOperationalDelta= ruleResolutionStrategyWithOperationalDelta EOF )
            // InternalIntegrate.g:1672:2: iv_ruleResolutionStrategyWithOperationalDelta= ruleResolutionStrategyWithOperationalDelta EOF
            {
             newCompositeNode(grammarAccess.getResolutionStrategyWithOperationalDeltaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResolutionStrategyWithOperationalDelta=ruleResolutionStrategyWithOperationalDelta();

            state._fsp--;

             current =iv_ruleResolutionStrategyWithOperationalDelta; 
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
    // $ANTLR end "entryRuleResolutionStrategyWithOperationalDelta"


    // $ANTLR start "ruleResolutionStrategyWithOperationalDelta"
    // InternalIntegrate.g:1678:1: ruleResolutionStrategyWithOperationalDelta returns [EObject current=null] : ( ( (lv_strategy_0_0= ruleResolutionStrategy ) ) (otherlv_1= 'when' otherlv_2= '{' ( (lv_operationalDelta_3_0= ruleOperationalDelta ) ) otherlv_4= '}' )? ) ;
    public final EObject ruleResolutionStrategyWithOperationalDelta() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_strategy_0_0 = null;

        EObject lv_operationalDelta_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1684:2: ( ( ( (lv_strategy_0_0= ruleResolutionStrategy ) ) (otherlv_1= 'when' otherlv_2= '{' ( (lv_operationalDelta_3_0= ruleOperationalDelta ) ) otherlv_4= '}' )? ) )
            // InternalIntegrate.g:1685:2: ( ( (lv_strategy_0_0= ruleResolutionStrategy ) ) (otherlv_1= 'when' otherlv_2= '{' ( (lv_operationalDelta_3_0= ruleOperationalDelta ) ) otherlv_4= '}' )? )
            {
            // InternalIntegrate.g:1685:2: ( ( (lv_strategy_0_0= ruleResolutionStrategy ) ) (otherlv_1= 'when' otherlv_2= '{' ( (lv_operationalDelta_3_0= ruleOperationalDelta ) ) otherlv_4= '}' )? )
            // InternalIntegrate.g:1686:3: ( (lv_strategy_0_0= ruleResolutionStrategy ) ) (otherlv_1= 'when' otherlv_2= '{' ( (lv_operationalDelta_3_0= ruleOperationalDelta ) ) otherlv_4= '}' )?
            {
            // InternalIntegrate.g:1686:3: ( (lv_strategy_0_0= ruleResolutionStrategy ) )
            // InternalIntegrate.g:1687:4: (lv_strategy_0_0= ruleResolutionStrategy )
            {
            // InternalIntegrate.g:1687:4: (lv_strategy_0_0= ruleResolutionStrategy )
            // InternalIntegrate.g:1688:5: lv_strategy_0_0= ruleResolutionStrategy
            {

            					newCompositeNode(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getStrategyResolutionStrategyParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_27);
            lv_strategy_0_0=ruleResolutionStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getResolutionStrategyWithOperationalDeltaRule());
            					}
            					set(
            						current,
            						"strategy",
            						lv_strategy_0_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.ResolutionStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalIntegrate.g:1705:3: (otherlv_1= 'when' otherlv_2= '{' ( (lv_operationalDelta_3_0= ruleOperationalDelta ) ) otherlv_4= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==42) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalIntegrate.g:1706:4: otherlv_1= 'when' otherlv_2= '{' ( (lv_operationalDelta_3_0= ruleOperationalDelta ) ) otherlv_4= '}'
                    {
                    otherlv_1=(Token)match(input,42,FOLLOW_9); 

                    				newLeafNode(otherlv_1, grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getWhenKeyword_1_0());
                    			
                    otherlv_2=(Token)match(input,16,FOLLOW_10); 

                    				newLeafNode(otherlv_2, grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getLeftCurlyBracketKeyword_1_1());
                    			
                    // InternalIntegrate.g:1714:4: ( (lv_operationalDelta_3_0= ruleOperationalDelta ) )
                    // InternalIntegrate.g:1715:5: (lv_operationalDelta_3_0= ruleOperationalDelta )
                    {
                    // InternalIntegrate.g:1715:5: (lv_operationalDelta_3_0= ruleOperationalDelta )
                    // InternalIntegrate.g:1716:6: lv_operationalDelta_3_0= ruleOperationalDelta
                    {

                    						newCompositeNode(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getOperationalDeltaOperationalDeltaParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_operationalDelta_3_0=ruleOperationalDelta();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getResolutionStrategyWithOperationalDeltaRule());
                    						}
                    						set(
                    							current,
                    							"operationalDelta",
                    							lv_operationalDelta_3_0,
                    							"org.emoflon.ibex.tgg.integrate.Integrate.OperationalDelta");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,18,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getRightCurlyBracketKeyword_1_3());
                    			

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
    // $ANTLR end "ruleResolutionStrategyWithOperationalDelta"


    // $ANTLR start "entryRuleResolutionStrategy"
    // InternalIntegrate.g:1742:1: entryRuleResolutionStrategy returns [EObject current=null] : iv_ruleResolutionStrategy= ruleResolutionStrategy EOF ;
    public final EObject entryRuleResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResolutionStrategy = null;


        try {
            // InternalIntegrate.g:1742:59: (iv_ruleResolutionStrategy= ruleResolutionStrategy EOF )
            // InternalIntegrate.g:1743:2: iv_ruleResolutionStrategy= ruleResolutionStrategy EOF
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
    // InternalIntegrate.g:1749:1: ruleResolutionStrategy returns [EObject current=null] : (this_MergeAndPreserveResolutionStrategy_0= ruleMergeAndPreserveResolutionStrategy | this_RevokeAdditionResolutionStrategy_1= ruleRevokeAdditionResolutionStrategy | this_RevokeDeletionResolutionStrategy_2= ruleRevokeDeletionResolutionStrategy | this_FallbackResolutionStrategy_3= ruleFallbackResolutionStrategy ) ;
    public final EObject ruleResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject this_MergeAndPreserveResolutionStrategy_0 = null;

        EObject this_RevokeAdditionResolutionStrategy_1 = null;

        EObject this_RevokeDeletionResolutionStrategy_2 = null;

        EObject this_FallbackResolutionStrategy_3 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1755:2: ( (this_MergeAndPreserveResolutionStrategy_0= ruleMergeAndPreserveResolutionStrategy | this_RevokeAdditionResolutionStrategy_1= ruleRevokeAdditionResolutionStrategy | this_RevokeDeletionResolutionStrategy_2= ruleRevokeDeletionResolutionStrategy | this_FallbackResolutionStrategy_3= ruleFallbackResolutionStrategy ) )
            // InternalIntegrate.g:1756:2: (this_MergeAndPreserveResolutionStrategy_0= ruleMergeAndPreserveResolutionStrategy | this_RevokeAdditionResolutionStrategy_1= ruleRevokeAdditionResolutionStrategy | this_RevokeDeletionResolutionStrategy_2= ruleRevokeDeletionResolutionStrategy | this_FallbackResolutionStrategy_3= ruleFallbackResolutionStrategy )
            {
            // InternalIntegrate.g:1756:2: (this_MergeAndPreserveResolutionStrategy_0= ruleMergeAndPreserveResolutionStrategy | this_RevokeAdditionResolutionStrategy_1= ruleRevokeAdditionResolutionStrategy | this_RevokeDeletionResolutionStrategy_2= ruleRevokeDeletionResolutionStrategy | this_FallbackResolutionStrategy_3= ruleFallbackResolutionStrategy )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt23=1;
                }
                break;
            case 44:
                {
                alt23=2;
                }
                break;
            case 45:
                {
                alt23=3;
                }
                break;
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalIntegrate.g:1757:3: this_MergeAndPreserveResolutionStrategy_0= ruleMergeAndPreserveResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getResolutionStrategyAccess().getMergeAndPreserveResolutionStrategyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_MergeAndPreserveResolutionStrategy_0=ruleMergeAndPreserveResolutionStrategy();

                    state._fsp--;


                    			current = this_MergeAndPreserveResolutionStrategy_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1766:3: this_RevokeAdditionResolutionStrategy_1= ruleRevokeAdditionResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getResolutionStrategyAccess().getRevokeAdditionResolutionStrategyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RevokeAdditionResolutionStrategy_1=ruleRevokeAdditionResolutionStrategy();

                    state._fsp--;


                    			current = this_RevokeAdditionResolutionStrategy_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1775:3: this_RevokeDeletionResolutionStrategy_2= ruleRevokeDeletionResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getResolutionStrategyAccess().getRevokeDeletionResolutionStrategyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_RevokeDeletionResolutionStrategy_2=ruleRevokeDeletionResolutionStrategy();

                    state._fsp--;


                    			current = this_RevokeDeletionResolutionStrategy_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:1784:3: this_FallbackResolutionStrategy_3= ruleFallbackResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getResolutionStrategyAccess().getFallbackResolutionStrategyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_FallbackResolutionStrategy_3=ruleFallbackResolutionStrategy();

                    state._fsp--;


                    			current = this_FallbackResolutionStrategy_3;
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
    // $ANTLR end "ruleResolutionStrategy"


    // $ANTLR start "entryRuleFallbackResolutionStrategy"
    // InternalIntegrate.g:1796:1: entryRuleFallbackResolutionStrategy returns [EObject current=null] : iv_ruleFallbackResolutionStrategy= ruleFallbackResolutionStrategy EOF ;
    public final EObject entryRuleFallbackResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFallbackResolutionStrategy = null;


        try {
            // InternalIntegrate.g:1796:67: (iv_ruleFallbackResolutionStrategy= ruleFallbackResolutionStrategy EOF )
            // InternalIntegrate.g:1797:2: iv_ruleFallbackResolutionStrategy= ruleFallbackResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getFallbackResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFallbackResolutionStrategy=ruleFallbackResolutionStrategy();

            state._fsp--;

             current =iv_ruleFallbackResolutionStrategy; 
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
    // $ANTLR end "entryRuleFallbackResolutionStrategy"


    // $ANTLR start "ruleFallbackResolutionStrategy"
    // InternalIntegrate.g:1803:1: ruleFallbackResolutionStrategy returns [EObject current=null] : (this_PreferSourceResolutionStrategy_0= rulePreferSourceResolutionStrategy | this_PreferTargetResolutionStrategy_1= rulePreferTargetResolutionStrategy | this_DeleteCorrespondencesResolutionStrategy_2= ruleDeleteCorrespondencesResolutionStrategy | this_ContinueResolutionStrategy_3= ruleContinueResolutionStrategy ) ;
    public final EObject ruleFallbackResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject this_PreferSourceResolutionStrategy_0 = null;

        EObject this_PreferTargetResolutionStrategy_1 = null;

        EObject this_DeleteCorrespondencesResolutionStrategy_2 = null;

        EObject this_ContinueResolutionStrategy_3 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:1809:2: ( (this_PreferSourceResolutionStrategy_0= rulePreferSourceResolutionStrategy | this_PreferTargetResolutionStrategy_1= rulePreferTargetResolutionStrategy | this_DeleteCorrespondencesResolutionStrategy_2= ruleDeleteCorrespondencesResolutionStrategy | this_ContinueResolutionStrategy_3= ruleContinueResolutionStrategy ) )
            // InternalIntegrate.g:1810:2: (this_PreferSourceResolutionStrategy_0= rulePreferSourceResolutionStrategy | this_PreferTargetResolutionStrategy_1= rulePreferTargetResolutionStrategy | this_DeleteCorrespondencesResolutionStrategy_2= ruleDeleteCorrespondencesResolutionStrategy | this_ContinueResolutionStrategy_3= ruleContinueResolutionStrategy )
            {
            // InternalIntegrate.g:1810:2: (this_PreferSourceResolutionStrategy_0= rulePreferSourceResolutionStrategy | this_PreferTargetResolutionStrategy_1= rulePreferTargetResolutionStrategy | this_DeleteCorrespondencesResolutionStrategy_2= ruleDeleteCorrespondencesResolutionStrategy | this_ContinueResolutionStrategy_3= ruleContinueResolutionStrategy )
            int alt24=4;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt24=1;
                }
                break;
            case 47:
                {
                alt24=2;
                }
                break;
            case 48:
                {
                alt24=3;
                }
                break;
            case 49:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalIntegrate.g:1811:3: this_PreferSourceResolutionStrategy_0= rulePreferSourceResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getFallbackResolutionStrategyAccess().getPreferSourceResolutionStrategyParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_PreferSourceResolutionStrategy_0=rulePreferSourceResolutionStrategy();

                    state._fsp--;


                    			current = this_PreferSourceResolutionStrategy_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1820:3: this_PreferTargetResolutionStrategy_1= rulePreferTargetResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getFallbackResolutionStrategyAccess().getPreferTargetResolutionStrategyParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_PreferTargetResolutionStrategy_1=rulePreferTargetResolutionStrategy();

                    state._fsp--;


                    			current = this_PreferTargetResolutionStrategy_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1829:3: this_DeleteCorrespondencesResolutionStrategy_2= ruleDeleteCorrespondencesResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getFallbackResolutionStrategyAccess().getDeleteCorrespondencesResolutionStrategyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_DeleteCorrespondencesResolutionStrategy_2=ruleDeleteCorrespondencesResolutionStrategy();

                    state._fsp--;


                    			current = this_DeleteCorrespondencesResolutionStrategy_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:1838:3: this_ContinueResolutionStrategy_3= ruleContinueResolutionStrategy
                    {

                    			newCompositeNode(grammarAccess.getFallbackResolutionStrategyAccess().getContinueResolutionStrategyParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ContinueResolutionStrategy_3=ruleContinueResolutionStrategy();

                    state._fsp--;


                    			current = this_ContinueResolutionStrategy_3;
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
    // $ANTLR end "ruleFallbackResolutionStrategy"


    // $ANTLR start "entryRuleMergeAndPreserveResolutionStrategy"
    // InternalIntegrate.g:1850:1: entryRuleMergeAndPreserveResolutionStrategy returns [EObject current=null] : iv_ruleMergeAndPreserveResolutionStrategy= ruleMergeAndPreserveResolutionStrategy EOF ;
    public final EObject entryRuleMergeAndPreserveResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMergeAndPreserveResolutionStrategy = null;


        try {
            // InternalIntegrate.g:1850:75: (iv_ruleMergeAndPreserveResolutionStrategy= ruleMergeAndPreserveResolutionStrategy EOF )
            // InternalIntegrate.g:1851:2: iv_ruleMergeAndPreserveResolutionStrategy= ruleMergeAndPreserveResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getMergeAndPreserveResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMergeAndPreserveResolutionStrategy=ruleMergeAndPreserveResolutionStrategy();

            state._fsp--;

             current =iv_ruleMergeAndPreserveResolutionStrategy; 
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
    // $ANTLR end "entryRuleMergeAndPreserveResolutionStrategy"


    // $ANTLR start "ruleMergeAndPreserveResolutionStrategy"
    // InternalIntegrate.g:1857:1: ruleMergeAndPreserveResolutionStrategy returns [EObject current=null] : ( (lv_name_0_0= 'mergeAndPreserve' ) ) ;
    public final EObject ruleMergeAndPreserveResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1863:2: ( ( (lv_name_0_0= 'mergeAndPreserve' ) ) )
            // InternalIntegrate.g:1864:2: ( (lv_name_0_0= 'mergeAndPreserve' ) )
            {
            // InternalIntegrate.g:1864:2: ( (lv_name_0_0= 'mergeAndPreserve' ) )
            // InternalIntegrate.g:1865:3: (lv_name_0_0= 'mergeAndPreserve' )
            {
            // InternalIntegrate.g:1865:3: (lv_name_0_0= 'mergeAndPreserve' )
            // InternalIntegrate.g:1866:4: lv_name_0_0= 'mergeAndPreserve'
            {
            lv_name_0_0=(Token)match(input,43,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getMergeAndPreserveResolutionStrategyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "mergeAndPreserve");
            			

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
    // $ANTLR end "ruleMergeAndPreserveResolutionStrategy"


    // $ANTLR start "entryRuleRevokeAdditionResolutionStrategy"
    // InternalIntegrate.g:1881:1: entryRuleRevokeAdditionResolutionStrategy returns [EObject current=null] : iv_ruleRevokeAdditionResolutionStrategy= ruleRevokeAdditionResolutionStrategy EOF ;
    public final EObject entryRuleRevokeAdditionResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRevokeAdditionResolutionStrategy = null;


        try {
            // InternalIntegrate.g:1881:73: (iv_ruleRevokeAdditionResolutionStrategy= ruleRevokeAdditionResolutionStrategy EOF )
            // InternalIntegrate.g:1882:2: iv_ruleRevokeAdditionResolutionStrategy= ruleRevokeAdditionResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getRevokeAdditionResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRevokeAdditionResolutionStrategy=ruleRevokeAdditionResolutionStrategy();

            state._fsp--;

             current =iv_ruleRevokeAdditionResolutionStrategy; 
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
    // $ANTLR end "entryRuleRevokeAdditionResolutionStrategy"


    // $ANTLR start "ruleRevokeAdditionResolutionStrategy"
    // InternalIntegrate.g:1888:1: ruleRevokeAdditionResolutionStrategy returns [EObject current=null] : ( (lv_name_0_0= 'revokeAddition' ) ) ;
    public final EObject ruleRevokeAdditionResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1894:2: ( ( (lv_name_0_0= 'revokeAddition' ) ) )
            // InternalIntegrate.g:1895:2: ( (lv_name_0_0= 'revokeAddition' ) )
            {
            // InternalIntegrate.g:1895:2: ( (lv_name_0_0= 'revokeAddition' ) )
            // InternalIntegrate.g:1896:3: (lv_name_0_0= 'revokeAddition' )
            {
            // InternalIntegrate.g:1896:3: (lv_name_0_0= 'revokeAddition' )
            // InternalIntegrate.g:1897:4: lv_name_0_0= 'revokeAddition'
            {
            lv_name_0_0=(Token)match(input,44,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameRevokeAdditionKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getRevokeAdditionResolutionStrategyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "revokeAddition");
            			

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
    // $ANTLR end "ruleRevokeAdditionResolutionStrategy"


    // $ANTLR start "entryRuleRevokeDeletionResolutionStrategy"
    // InternalIntegrate.g:1912:1: entryRuleRevokeDeletionResolutionStrategy returns [EObject current=null] : iv_ruleRevokeDeletionResolutionStrategy= ruleRevokeDeletionResolutionStrategy EOF ;
    public final EObject entryRuleRevokeDeletionResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRevokeDeletionResolutionStrategy = null;


        try {
            // InternalIntegrate.g:1912:73: (iv_ruleRevokeDeletionResolutionStrategy= ruleRevokeDeletionResolutionStrategy EOF )
            // InternalIntegrate.g:1913:2: iv_ruleRevokeDeletionResolutionStrategy= ruleRevokeDeletionResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getRevokeDeletionResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRevokeDeletionResolutionStrategy=ruleRevokeDeletionResolutionStrategy();

            state._fsp--;

             current =iv_ruleRevokeDeletionResolutionStrategy; 
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
    // $ANTLR end "entryRuleRevokeDeletionResolutionStrategy"


    // $ANTLR start "ruleRevokeDeletionResolutionStrategy"
    // InternalIntegrate.g:1919:1: ruleRevokeDeletionResolutionStrategy returns [EObject current=null] : ( (lv_name_0_0= 'revokeDeletion' ) ) ;
    public final EObject ruleRevokeDeletionResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1925:2: ( ( (lv_name_0_0= 'revokeDeletion' ) ) )
            // InternalIntegrate.g:1926:2: ( (lv_name_0_0= 'revokeDeletion' ) )
            {
            // InternalIntegrate.g:1926:2: ( (lv_name_0_0= 'revokeDeletion' ) )
            // InternalIntegrate.g:1927:3: (lv_name_0_0= 'revokeDeletion' )
            {
            // InternalIntegrate.g:1927:3: (lv_name_0_0= 'revokeDeletion' )
            // InternalIntegrate.g:1928:4: lv_name_0_0= 'revokeDeletion'
            {
            lv_name_0_0=(Token)match(input,45,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameRevokeDeletionKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getRevokeDeletionResolutionStrategyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "revokeDeletion");
            			

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
    // $ANTLR end "ruleRevokeDeletionResolutionStrategy"


    // $ANTLR start "entryRulePreferSourceResolutionStrategy"
    // InternalIntegrate.g:1943:1: entryRulePreferSourceResolutionStrategy returns [EObject current=null] : iv_rulePreferSourceResolutionStrategy= rulePreferSourceResolutionStrategy EOF ;
    public final EObject entryRulePreferSourceResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreferSourceResolutionStrategy = null;


        try {
            // InternalIntegrate.g:1943:71: (iv_rulePreferSourceResolutionStrategy= rulePreferSourceResolutionStrategy EOF )
            // InternalIntegrate.g:1944:2: iv_rulePreferSourceResolutionStrategy= rulePreferSourceResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getPreferSourceResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePreferSourceResolutionStrategy=rulePreferSourceResolutionStrategy();

            state._fsp--;

             current =iv_rulePreferSourceResolutionStrategy; 
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
    // $ANTLR end "entryRulePreferSourceResolutionStrategy"


    // $ANTLR start "rulePreferSourceResolutionStrategy"
    // InternalIntegrate.g:1950:1: rulePreferSourceResolutionStrategy returns [EObject current=null] : ( (lv_name_0_0= 'preferSource' ) ) ;
    public final EObject rulePreferSourceResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1956:2: ( ( (lv_name_0_0= 'preferSource' ) ) )
            // InternalIntegrate.g:1957:2: ( (lv_name_0_0= 'preferSource' ) )
            {
            // InternalIntegrate.g:1957:2: ( (lv_name_0_0= 'preferSource' ) )
            // InternalIntegrate.g:1958:3: (lv_name_0_0= 'preferSource' )
            {
            // InternalIntegrate.g:1958:3: (lv_name_0_0= 'preferSource' )
            // InternalIntegrate.g:1959:4: lv_name_0_0= 'preferSource'
            {
            lv_name_0_0=(Token)match(input,46,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPreferSourceResolutionStrategyAccess().getNamePreferSourceKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPreferSourceResolutionStrategyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "preferSource");
            			

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
    // $ANTLR end "rulePreferSourceResolutionStrategy"


    // $ANTLR start "entryRulePreferTargetResolutionStrategy"
    // InternalIntegrate.g:1974:1: entryRulePreferTargetResolutionStrategy returns [EObject current=null] : iv_rulePreferTargetResolutionStrategy= rulePreferTargetResolutionStrategy EOF ;
    public final EObject entryRulePreferTargetResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePreferTargetResolutionStrategy = null;


        try {
            // InternalIntegrate.g:1974:71: (iv_rulePreferTargetResolutionStrategy= rulePreferTargetResolutionStrategy EOF )
            // InternalIntegrate.g:1975:2: iv_rulePreferTargetResolutionStrategy= rulePreferTargetResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getPreferTargetResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePreferTargetResolutionStrategy=rulePreferTargetResolutionStrategy();

            state._fsp--;

             current =iv_rulePreferTargetResolutionStrategy; 
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
    // $ANTLR end "entryRulePreferTargetResolutionStrategy"


    // $ANTLR start "rulePreferTargetResolutionStrategy"
    // InternalIntegrate.g:1981:1: rulePreferTargetResolutionStrategy returns [EObject current=null] : ( (lv_name_0_0= 'preferTarget' ) ) ;
    public final EObject rulePreferTargetResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:1987:2: ( ( (lv_name_0_0= 'preferTarget' ) ) )
            // InternalIntegrate.g:1988:2: ( (lv_name_0_0= 'preferTarget' ) )
            {
            // InternalIntegrate.g:1988:2: ( (lv_name_0_0= 'preferTarget' ) )
            // InternalIntegrate.g:1989:3: (lv_name_0_0= 'preferTarget' )
            {
            // InternalIntegrate.g:1989:3: (lv_name_0_0= 'preferTarget' )
            // InternalIntegrate.g:1990:4: lv_name_0_0= 'preferTarget'
            {
            lv_name_0_0=(Token)match(input,47,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getPreferTargetResolutionStrategyAccess().getNamePreferTargetKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getPreferTargetResolutionStrategyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "preferTarget");
            			

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
    // $ANTLR end "rulePreferTargetResolutionStrategy"


    // $ANTLR start "entryRuleDeleteCorrespondencesResolutionStrategy"
    // InternalIntegrate.g:2005:1: entryRuleDeleteCorrespondencesResolutionStrategy returns [EObject current=null] : iv_ruleDeleteCorrespondencesResolutionStrategy= ruleDeleteCorrespondencesResolutionStrategy EOF ;
    public final EObject entryRuleDeleteCorrespondencesResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeleteCorrespondencesResolutionStrategy = null;


        try {
            // InternalIntegrate.g:2005:80: (iv_ruleDeleteCorrespondencesResolutionStrategy= ruleDeleteCorrespondencesResolutionStrategy EOF )
            // InternalIntegrate.g:2006:2: iv_ruleDeleteCorrespondencesResolutionStrategy= ruleDeleteCorrespondencesResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getDeleteCorrespondencesResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeleteCorrespondencesResolutionStrategy=ruleDeleteCorrespondencesResolutionStrategy();

            state._fsp--;

             current =iv_ruleDeleteCorrespondencesResolutionStrategy; 
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
    // $ANTLR end "entryRuleDeleteCorrespondencesResolutionStrategy"


    // $ANTLR start "ruleDeleteCorrespondencesResolutionStrategy"
    // InternalIntegrate.g:2012:1: ruleDeleteCorrespondencesResolutionStrategy returns [EObject current=null] : ( (lv_name_0_0= 'deleteCorrespondences' ) ) ;
    public final EObject ruleDeleteCorrespondencesResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:2018:2: ( ( (lv_name_0_0= 'deleteCorrespondences' ) ) )
            // InternalIntegrate.g:2019:2: ( (lv_name_0_0= 'deleteCorrespondences' ) )
            {
            // InternalIntegrate.g:2019:2: ( (lv_name_0_0= 'deleteCorrespondences' ) )
            // InternalIntegrate.g:2020:3: (lv_name_0_0= 'deleteCorrespondences' )
            {
            // InternalIntegrate.g:2020:3: (lv_name_0_0= 'deleteCorrespondences' )
            // InternalIntegrate.g:2021:4: lv_name_0_0= 'deleteCorrespondences'
            {
            lv_name_0_0=(Token)match(input,48,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameDeleteCorrespondencesKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDeleteCorrespondencesResolutionStrategyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "deleteCorrespondences");
            			

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
    // $ANTLR end "ruleDeleteCorrespondencesResolutionStrategy"


    // $ANTLR start "entryRuleContinueResolutionStrategy"
    // InternalIntegrate.g:2036:1: entryRuleContinueResolutionStrategy returns [EObject current=null] : iv_ruleContinueResolutionStrategy= ruleContinueResolutionStrategy EOF ;
    public final EObject entryRuleContinueResolutionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContinueResolutionStrategy = null;


        try {
            // InternalIntegrate.g:2036:67: (iv_ruleContinueResolutionStrategy= ruleContinueResolutionStrategy EOF )
            // InternalIntegrate.g:2037:2: iv_ruleContinueResolutionStrategy= ruleContinueResolutionStrategy EOF
            {
             newCompositeNode(grammarAccess.getContinueResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContinueResolutionStrategy=ruleContinueResolutionStrategy();

            state._fsp--;

             current =iv_ruleContinueResolutionStrategy; 
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
    // $ANTLR end "entryRuleContinueResolutionStrategy"


    // $ANTLR start "ruleContinueResolutionStrategy"
    // InternalIntegrate.g:2043:1: ruleContinueResolutionStrategy returns [EObject current=null] : ( (lv_name_0_0= 'continue' ) ) ;
    public final EObject ruleContinueResolutionStrategy() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalIntegrate.g:2049:2: ( ( (lv_name_0_0= 'continue' ) ) )
            // InternalIntegrate.g:2050:2: ( (lv_name_0_0= 'continue' ) )
            {
            // InternalIntegrate.g:2050:2: ( (lv_name_0_0= 'continue' ) )
            // InternalIntegrate.g:2051:3: (lv_name_0_0= 'continue' )
            {
            // InternalIntegrate.g:2051:3: (lv_name_0_0= 'continue' )
            // InternalIntegrate.g:2052:4: lv_name_0_0= 'continue'
            {
            lv_name_0_0=(Token)match(input,49,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getContinueResolutionStrategyAccess().getNameContinueKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getContinueResolutionStrategyRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "continue");
            			

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
    // $ANTLR end "ruleContinueResolutionStrategy"


    // $ANTLR start "entryRuleOperationalDelta"
    // InternalIntegrate.g:2067:1: entryRuleOperationalDelta returns [EObject current=null] : iv_ruleOperationalDelta= ruleOperationalDelta EOF ;
    public final EObject entryRuleOperationalDelta() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationalDelta = null;


        try {
            // InternalIntegrate.g:2067:57: (iv_ruleOperationalDelta= ruleOperationalDelta EOF )
            // InternalIntegrate.g:2068:2: iv_ruleOperationalDelta= ruleOperationalDelta EOF
            {
             newCompositeNode(grammarAccess.getOperationalDeltaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationalDelta=ruleOperationalDelta();

            state._fsp--;

             current =iv_ruleOperationalDelta; 
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
    // $ANTLR end "entryRuleOperationalDelta"


    // $ANTLR start "ruleOperationalDelta"
    // InternalIntegrate.g:2074:1: ruleOperationalDelta returns [EObject current=null] : ( ( (lv_variables_0_0= ruleVariable ) )+ otherlv_1= 'satisfies' otherlv_2= '{' ( (lv_rule_3_0= ruleSatisfactionRule ) ) otherlv_4= '}' ) ;
    public final EObject ruleOperationalDelta() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_variables_0_0 = null;

        EObject lv_rule_3_0 = null;



        	enterRule();

        try {
            // InternalIntegrate.g:2080:2: ( ( ( (lv_variables_0_0= ruleVariable ) )+ otherlv_1= 'satisfies' otherlv_2= '{' ( (lv_rule_3_0= ruleSatisfactionRule ) ) otherlv_4= '}' ) )
            // InternalIntegrate.g:2081:2: ( ( (lv_variables_0_0= ruleVariable ) )+ otherlv_1= 'satisfies' otherlv_2= '{' ( (lv_rule_3_0= ruleSatisfactionRule ) ) otherlv_4= '}' )
            {
            // InternalIntegrate.g:2081:2: ( ( (lv_variables_0_0= ruleVariable ) )+ otherlv_1= 'satisfies' otherlv_2= '{' ( (lv_rule_3_0= ruleSatisfactionRule ) ) otherlv_4= '}' )
            // InternalIntegrate.g:2082:3: ( (lv_variables_0_0= ruleVariable ) )+ otherlv_1= 'satisfies' otherlv_2= '{' ( (lv_rule_3_0= ruleSatisfactionRule ) ) otherlv_4= '}'
            {
            // InternalIntegrate.g:2082:3: ( (lv_variables_0_0= ruleVariable ) )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==20) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalIntegrate.g:2083:4: (lv_variables_0_0= ruleVariable )
            	    {
            	    // InternalIntegrate.g:2083:4: (lv_variables_0_0= ruleVariable )
            	    // InternalIntegrate.g:2084:5: lv_variables_0_0= ruleVariable
            	    {

            	    					newCompositeNode(grammarAccess.getOperationalDeltaAccess().getVariablesVariableParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_11);
            	    lv_variables_0_0=ruleVariable();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperationalDeltaRule());
            	    					}
            	    					add(
            	    						current,
            	    						"variables",
            	    						lv_variables_0_0,
            	    						"org.emoflon.ibex.tgg.integrate.Integrate.Variable");
            	    					afterParserOrEnumRuleCall();
            	    				

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

            otherlv_1=(Token)match(input,17,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationalDeltaAccess().getSatisfiesKeyword_1());
            		
            otherlv_2=(Token)match(input,16,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationalDeltaAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalIntegrate.g:2109:3: ( (lv_rule_3_0= ruleSatisfactionRule ) )
            // InternalIntegrate.g:2110:4: (lv_rule_3_0= ruleSatisfactionRule )
            {
            // InternalIntegrate.g:2110:4: (lv_rule_3_0= ruleSatisfactionRule )
            // InternalIntegrate.g:2111:5: lv_rule_3_0= ruleSatisfactionRule
            {

            					newCompositeNode(grammarAccess.getOperationalDeltaAccess().getRuleSatisfactionRuleParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_13);
            lv_rule_3_0=ruleSatisfactionRule();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationalDeltaRule());
            					}
            					set(
            						current,
            						"rule",
            						lv_rule_3_0,
            						"org.emoflon.ibex.tgg.integrate.Integrate.SatisfactionRule");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getOperationalDeltaAccess().getRightCurlyBracketKeyword_4());
            		

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
    // $ANTLR end "ruleOperationalDelta"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000600000030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0003F80000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000006E000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000003F000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0003F80080000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000040000000002L});

}