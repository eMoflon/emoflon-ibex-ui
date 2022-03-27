package org.moflon.tgg.mosl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.moflon.tgg.mosl.services.TGGGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTGGParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_DECIMAL", "RULE_BOOL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'#schema'", "'#source'", "'{'", "'}'", "'#target'", "'#correspondence'", "'#attributeConditions'", "'#extends'", "'#src->'", "'#trg->'", "'#userDefined'", "'('", "','", "')'", "'#sync:'", "'#gen:'", "':'", "'#abstract'", "'#rule'", "'#with'", "'#library'", "'['", "'B'", "'F'", "']'", "'=='", "'!='", "'<='", "'>='", "'>'", "'<'", "':='", "'enum::'", "'::'", "'#derived'", "'.'", "'-'", "'->'", "'++'", "'#nac'", "'#for'", "'#import'", "'#using'", "'.*'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int RULE_DECIMAL=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
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
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int RULE_BOOL=8;
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


        public InternalTGGParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTGGParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTGGParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTGG.g"; }



     	private TGGGrammarAccess grammarAccess;
     	
        public InternalTGGParser(TokenStream input, TGGGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TripleGraphGrammarFile";	
       	}
       	
       	@Override
       	protected TGGGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTripleGraphGrammarFile"
    // InternalTGG.g:67:1: entryRuleTripleGraphGrammarFile returns [EObject current=null] : iv_ruleTripleGraphGrammarFile= ruleTripleGraphGrammarFile EOF ;
    public final EObject entryRuleTripleGraphGrammarFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTripleGraphGrammarFile = null;


        try {
            // InternalTGG.g:68:2: (iv_ruleTripleGraphGrammarFile= ruleTripleGraphGrammarFile EOF )
            // InternalTGG.g:69:2: iv_ruleTripleGraphGrammarFile= ruleTripleGraphGrammarFile EOF
            {
             newCompositeNode(grammarAccess.getTripleGraphGrammarFileRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTripleGraphGrammarFile=ruleTripleGraphGrammarFile();

            state._fsp--;

             current =iv_ruleTripleGraphGrammarFile; 
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
    // $ANTLR end "entryRuleTripleGraphGrammarFile"


    // $ANTLR start "ruleTripleGraphGrammarFile"
    // InternalTGG.g:76:1: ruleTripleGraphGrammarFile returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_using_1_0= ruleUsing ) )* ( (lv_schema_2_0= ruleSchema ) )? ( (lv_rules_3_0= ruleRule ) )* ( (lv_library_4_0= ruleAttrCondDefLibrary ) )? ) ;
    public final EObject ruleTripleGraphGrammarFile() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_using_1_0 = null;

        EObject lv_schema_2_0 = null;

        EObject lv_rules_3_0 = null;

        EObject lv_library_4_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:79:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_using_1_0= ruleUsing ) )* ( (lv_schema_2_0= ruleSchema ) )? ( (lv_rules_3_0= ruleRule ) )* ( (lv_library_4_0= ruleAttrCondDefLibrary ) )? ) )
            // InternalTGG.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_using_1_0= ruleUsing ) )* ( (lv_schema_2_0= ruleSchema ) )? ( (lv_rules_3_0= ruleRule ) )* ( (lv_library_4_0= ruleAttrCondDefLibrary ) )? )
            {
            // InternalTGG.g:80:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_using_1_0= ruleUsing ) )* ( (lv_schema_2_0= ruleSchema ) )? ( (lv_rules_3_0= ruleRule ) )* ( (lv_library_4_0= ruleAttrCondDefLibrary ) )? )
            // InternalTGG.g:80:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_using_1_0= ruleUsing ) )* ( (lv_schema_2_0= ruleSchema ) )? ( (lv_rules_3_0= ruleRule ) )* ( (lv_library_4_0= ruleAttrCondDefLibrary ) )?
            {
            // InternalTGG.g:80:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==54) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalTGG.g:81:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // InternalTGG.g:81:1: (lv_imports_0_0= ruleImport )
            	    // InternalTGG.g:82:3: lv_imports_0_0= ruleImport
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTripleGraphGrammarFileAccess().getImportsImportParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTripleGraphGrammarFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"imports",
            	            		lv_imports_0_0, 
            	            		"org.moflon.tgg.mosl.TGG.Import");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalTGG.g:98:3: ( (lv_using_1_0= ruleUsing ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==55) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalTGG.g:99:1: (lv_using_1_0= ruleUsing )
            	    {
            	    // InternalTGG.g:99:1: (lv_using_1_0= ruleUsing )
            	    // InternalTGG.g:100:3: lv_using_1_0= ruleUsing
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTripleGraphGrammarFileAccess().getUsingUsingParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_4);
            	    lv_using_1_0=ruleUsing();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTripleGraphGrammarFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"using",
            	            		lv_using_1_0, 
            	            		"org.moflon.tgg.mosl.TGG.Using");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalTGG.g:116:3: ( (lv_schema_2_0= ruleSchema ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalTGG.g:117:1: (lv_schema_2_0= ruleSchema )
                    {
                    // InternalTGG.g:117:1: (lv_schema_2_0= ruleSchema )
                    // InternalTGG.g:118:3: lv_schema_2_0= ruleSchema
                    {
                     
                    	        newCompositeNode(grammarAccess.getTripleGraphGrammarFileAccess().getSchemaSchemaParserRuleCall_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_schema_2_0=ruleSchema();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTripleGraphGrammarFileRule());
                    	        }
                           		set(
                           			current, 
                           			"schema",
                            		lv_schema_2_0, 
                            		"org.moflon.tgg.mosl.TGG.Schema");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTGG.g:134:3: ( (lv_rules_3_0= ruleRule ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=30 && LA4_0<=31)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalTGG.g:135:1: (lv_rules_3_0= ruleRule )
            	    {
            	    // InternalTGG.g:135:1: (lv_rules_3_0= ruleRule )
            	    // InternalTGG.g:136:3: lv_rules_3_0= ruleRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTripleGraphGrammarFileAccess().getRulesRuleParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_rules_3_0=ruleRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTripleGraphGrammarFileRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_3_0, 
            	            		"org.moflon.tgg.mosl.TGG.Rule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalTGG.g:152:3: ( (lv_library_4_0= ruleAttrCondDefLibrary ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==33) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalTGG.g:153:1: (lv_library_4_0= ruleAttrCondDefLibrary )
                    {
                    // InternalTGG.g:153:1: (lv_library_4_0= ruleAttrCondDefLibrary )
                    // InternalTGG.g:154:3: lv_library_4_0= ruleAttrCondDefLibrary
                    {
                     
                    	        newCompositeNode(grammarAccess.getTripleGraphGrammarFileAccess().getLibraryAttrCondDefLibraryParserRuleCall_4_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_library_4_0=ruleAttrCondDefLibrary();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTripleGraphGrammarFileRule());
                    	        }
                           		set(
                           			current, 
                           			"library",
                            		lv_library_4_0, 
                            		"org.moflon.tgg.mosl.TGG.AttrCondDefLibrary");
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
    // $ANTLR end "ruleTripleGraphGrammarFile"


    // $ANTLR start "entryRuleSchema"
    // InternalTGG.g:178:1: entryRuleSchema returns [EObject current=null] : iv_ruleSchema= ruleSchema EOF ;
    public final EObject entryRuleSchema() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSchema = null;


        try {
            // InternalTGG.g:179:2: (iv_ruleSchema= ruleSchema EOF )
            // InternalTGG.g:180:2: iv_ruleSchema= ruleSchema EOF
            {
             newCompositeNode(grammarAccess.getSchemaRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSchema=ruleSchema();

            state._fsp--;

             current =iv_ruleSchema; 
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
    // $ANTLR end "entryRuleSchema"


    // $ANTLR start "ruleSchema"
    // InternalTGG.g:187:1: ruleSchema returns [EObject current=null] : (otherlv_0= '#schema' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '#source' otherlv_3= '{' ( ( ruleQualifiedName ) )* otherlv_5= '}' )? (otherlv_6= '#target' otherlv_7= '{' ( ( ruleQualifiedName ) )* otherlv_9= '}' )? (otherlv_10= '#correspondence' otherlv_11= '{' ( (lv_correspondenceTypes_12_0= ruleCorrType ) )* otherlv_13= '}' )? (otherlv_14= '#attributeConditions' otherlv_15= '{' ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )* otherlv_17= '}' )? ) ;
    public final EObject ruleSchema() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_correspondenceTypes_12_0 = null;

        EObject lv_attributeCondDefs_16_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:190:28: ( (otherlv_0= '#schema' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '#source' otherlv_3= '{' ( ( ruleQualifiedName ) )* otherlv_5= '}' )? (otherlv_6= '#target' otherlv_7= '{' ( ( ruleQualifiedName ) )* otherlv_9= '}' )? (otherlv_10= '#correspondence' otherlv_11= '{' ( (lv_correspondenceTypes_12_0= ruleCorrType ) )* otherlv_13= '}' )? (otherlv_14= '#attributeConditions' otherlv_15= '{' ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )* otherlv_17= '}' )? ) )
            // InternalTGG.g:191:1: (otherlv_0= '#schema' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '#source' otherlv_3= '{' ( ( ruleQualifiedName ) )* otherlv_5= '}' )? (otherlv_6= '#target' otherlv_7= '{' ( ( ruleQualifiedName ) )* otherlv_9= '}' )? (otherlv_10= '#correspondence' otherlv_11= '{' ( (lv_correspondenceTypes_12_0= ruleCorrType ) )* otherlv_13= '}' )? (otherlv_14= '#attributeConditions' otherlv_15= '{' ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )* otherlv_17= '}' )? )
            {
            // InternalTGG.g:191:1: (otherlv_0= '#schema' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '#source' otherlv_3= '{' ( ( ruleQualifiedName ) )* otherlv_5= '}' )? (otherlv_6= '#target' otherlv_7= '{' ( ( ruleQualifiedName ) )* otherlv_9= '}' )? (otherlv_10= '#correspondence' otherlv_11= '{' ( (lv_correspondenceTypes_12_0= ruleCorrType ) )* otherlv_13= '}' )? (otherlv_14= '#attributeConditions' otherlv_15= '{' ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )* otherlv_17= '}' )? )
            // InternalTGG.g:191:3: otherlv_0= '#schema' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '#source' otherlv_3= '{' ( ( ruleQualifiedName ) )* otherlv_5= '}' )? (otherlv_6= '#target' otherlv_7= '{' ( ( ruleQualifiedName ) )* otherlv_9= '}' )? (otherlv_10= '#correspondence' otherlv_11= '{' ( (lv_correspondenceTypes_12_0= ruleCorrType ) )* otherlv_13= '}' )? (otherlv_14= '#attributeConditions' otherlv_15= '{' ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )* otherlv_17= '}' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getSchemaAccess().getSchemaKeyword_0());
                
            // InternalTGG.g:195:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTGG.g:196:1: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTGG.g:196:1: (lv_name_1_0= ruleQualifiedName )
            // InternalTGG.g:197:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSchemaAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSchemaRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.moflon.tgg.mosl.TGG.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTGG.g:213:2: (otherlv_2= '#source' otherlv_3= '{' ( ( ruleQualifiedName ) )* otherlv_5= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalTGG.g:213:4: otherlv_2= '#source' otherlv_3= '{' ( ( ruleQualifiedName ) )* otherlv_5= '}'
                    {
                    otherlv_2=(Token)match(input,14,FOLLOW_8); 

                        	newLeafNode(otherlv_2, grammarAccess.getSchemaAccess().getSourceKeyword_2_0());
                        
                    otherlv_3=(Token)match(input,15,FOLLOW_9); 

                        	newLeafNode(otherlv_3, grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_2_1());
                        
                    // InternalTGG.g:221:1: ( ( ruleQualifiedName ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalTGG.g:222:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalTGG.g:222:1: ( ruleQualifiedName )
                    	    // InternalTGG.g:223:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSchemaRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSchemaAccess().getSourceTypesEPackageCrossReference_2_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,16,FOLLOW_10); 

                        	newLeafNode(otherlv_5, grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_2_3());
                        

                    }
                    break;

            }

            // InternalTGG.g:240:3: (otherlv_6= '#target' otherlv_7= '{' ( ( ruleQualifiedName ) )* otherlv_9= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==17) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalTGG.g:240:5: otherlv_6= '#target' otherlv_7= '{' ( ( ruleQualifiedName ) )* otherlv_9= '}'
                    {
                    otherlv_6=(Token)match(input,17,FOLLOW_8); 

                        	newLeafNode(otherlv_6, grammarAccess.getSchemaAccess().getTargetKeyword_3_0());
                        
                    otherlv_7=(Token)match(input,15,FOLLOW_9); 

                        	newLeafNode(otherlv_7, grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // InternalTGG.g:248:1: ( ( ruleQualifiedName ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalTGG.g:249:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalTGG.g:249:1: ( ruleQualifiedName )
                    	    // InternalTGG.g:250:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSchemaRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSchemaAccess().getTargetTypesEPackageCrossReference_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,16,FOLLOW_11); 

                        	newLeafNode(otherlv_9, grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_3_3());
                        

                    }
                    break;

            }

            // InternalTGG.g:267:3: (otherlv_10= '#correspondence' otherlv_11= '{' ( (lv_correspondenceTypes_12_0= ruleCorrType ) )* otherlv_13= '}' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==18) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTGG.g:267:5: otherlv_10= '#correspondence' otherlv_11= '{' ( (lv_correspondenceTypes_12_0= ruleCorrType ) )* otherlv_13= '}'
                    {
                    otherlv_10=(Token)match(input,18,FOLLOW_8); 

                        	newLeafNode(otherlv_10, grammarAccess.getSchemaAccess().getCorrespondenceKeyword_4_0());
                        
                    otherlv_11=(Token)match(input,15,FOLLOW_9); 

                        	newLeafNode(otherlv_11, grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // InternalTGG.g:275:1: ( (lv_correspondenceTypes_12_0= ruleCorrType ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // InternalTGG.g:276:1: (lv_correspondenceTypes_12_0= ruleCorrType )
                    	    {
                    	    // InternalTGG.g:276:1: (lv_correspondenceTypes_12_0= ruleCorrType )
                    	    // InternalTGG.g:277:3: lv_correspondenceTypes_12_0= ruleCorrType
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSchemaAccess().getCorrespondenceTypesCorrTypeParserRuleCall_4_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    lv_correspondenceTypes_12_0=ruleCorrType();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSchemaRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"correspondenceTypes",
                    	            		lv_correspondenceTypes_12_0, 
                    	            		"org.moflon.tgg.mosl.TGG.CorrType");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,16,FOLLOW_12); 

                        	newLeafNode(otherlv_13, grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_4_3());
                        

                    }
                    break;

            }

            // InternalTGG.g:297:3: (otherlv_14= '#attributeConditions' otherlv_15= '{' ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )* otherlv_17= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTGG.g:297:5: otherlv_14= '#attributeConditions' otherlv_15= '{' ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )* otherlv_17= '}'
                    {
                    otherlv_14=(Token)match(input,19,FOLLOW_8); 

                        	newLeafNode(otherlv_14, grammarAccess.getSchemaAccess().getAttributeConditionsKeyword_5_0());
                        
                    otherlv_15=(Token)match(input,15,FOLLOW_13); 

                        	newLeafNode(otherlv_15, grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // InternalTGG.g:305:1: ( (lv_attributeCondDefs_16_0= ruleAttrCondDef ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID||LA12_0==23) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalTGG.g:306:1: (lv_attributeCondDefs_16_0= ruleAttrCondDef )
                    	    {
                    	    // InternalTGG.g:306:1: (lv_attributeCondDefs_16_0= ruleAttrCondDef )
                    	    // InternalTGG.g:307:3: lv_attributeCondDefs_16_0= ruleAttrCondDef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSchemaAccess().getAttributeCondDefsAttrCondDefParserRuleCall_5_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_13);
                    	    lv_attributeCondDefs_16_0=ruleAttrCondDef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSchemaRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributeCondDefs",
                    	            		lv_attributeCondDefs_16_0, 
                    	            		"org.moflon.tgg.mosl.TGG.AttrCondDef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,16,FOLLOW_2); 

                        	newLeafNode(otherlv_17, grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_5_3());
                        

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
    // $ANTLR end "ruleSchema"


    // $ANTLR start "entryRuleCorrType"
    // InternalTGG.g:335:1: entryRuleCorrType returns [EObject current=null] : iv_ruleCorrType= ruleCorrType EOF ;
    public final EObject entryRuleCorrType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCorrType = null;


        try {
            // InternalTGG.g:336:2: (iv_ruleCorrType= ruleCorrType EOF )
            // InternalTGG.g:337:2: iv_ruleCorrType= ruleCorrType EOF
            {
             newCompositeNode(grammarAccess.getCorrTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCorrType=ruleCorrType();

            state._fsp--;

             current =iv_ruleCorrType; 
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
    // $ANTLR end "entryRuleCorrType"


    // $ANTLR start "ruleCorrType"
    // InternalTGG.g:344:1: ruleCorrType returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' ) ) ) ;
    public final EObject ruleCorrType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:347:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' ) ) ) )
            // InternalTGG.g:348:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' ) ) )
            {
            // InternalTGG.g:348:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' ) ) )
            // InternalTGG.g:348:2: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' ) )
            {
            // InternalTGG.g:348:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalTGG.g:349:1: (lv_name_0_0= RULE_ID )
            {
            // InternalTGG.g:349:1: (lv_name_0_0= RULE_ID )
            // InternalTGG.g:350:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCorrTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCorrTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalTGG.g:366:2: ( (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) ) | (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                alt14=1;
            }
            else if ( (LA14_0==15) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalTGG.g:366:3: (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalTGG.g:366:3: (otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) ) )
                    // InternalTGG.g:366:5: otherlv_1= '#extends' ( (otherlv_2= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_6); 

                        	newLeafNode(otherlv_1, grammarAccess.getCorrTypeAccess().getExtendsKeyword_1_0_0());
                        
                    // InternalTGG.g:370:1: ( (otherlv_2= RULE_ID ) )
                    // InternalTGG.g:371:1: (otherlv_2= RULE_ID )
                    {
                    // InternalTGG.g:371:1: (otherlv_2= RULE_ID )
                    // InternalTGG.g:372:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCorrTypeRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		newLeafNode(otherlv_2, grammarAccess.getCorrTypeAccess().getSuperCorrTypeCrossReference_1_0_1_0()); 
                    	

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:384:6: (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' )
                    {
                    // InternalTGG.g:384:6: (otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}' )
                    // InternalTGG.g:384:8: otherlv_3= '{' otherlv_4= '#src->' ( ( ruleQualifiedName ) ) otherlv_6= '#trg->' ( ( ruleQualifiedName ) ) otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_15); 

                        	newLeafNode(otherlv_3, grammarAccess.getCorrTypeAccess().getLeftCurlyBracketKeyword_1_1_0());
                        
                    otherlv_4=(Token)match(input,21,FOLLOW_6); 

                        	newLeafNode(otherlv_4, grammarAccess.getCorrTypeAccess().getSrcKeyword_1_1_1());
                        
                    // InternalTGG.g:392:1: ( ( ruleQualifiedName ) )
                    // InternalTGG.g:393:1: ( ruleQualifiedName )
                    {
                    // InternalTGG.g:393:1: ( ruleQualifiedName )
                    // InternalTGG.g:394:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCorrTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getCorrTypeAccess().getSourceEClassCrossReference_1_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_16);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,22,FOLLOW_6); 

                        	newLeafNode(otherlv_6, grammarAccess.getCorrTypeAccess().getTrgKeyword_1_1_3());
                        
                    // InternalTGG.g:411:1: ( ( ruleQualifiedName ) )
                    // InternalTGG.g:412:1: ( ruleQualifiedName )
                    {
                    // InternalTGG.g:412:1: ( ruleQualifiedName )
                    // InternalTGG.g:413:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCorrTypeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getCorrTypeAccess().getTargetEClassCrossReference_1_1_4_0()); 
                    	    
                    pushFollow(FOLLOW_17);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,16,FOLLOW_2); 

                        	newLeafNode(otherlv_8, grammarAccess.getCorrTypeAccess().getRightCurlyBracketKeyword_1_1_5());
                        

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
    // $ANTLR end "ruleCorrType"


    // $ANTLR start "entryRuleAttrCondDef"
    // InternalTGG.g:438:1: entryRuleAttrCondDef returns [EObject current=null] : iv_ruleAttrCondDef= ruleAttrCondDef EOF ;
    public final EObject entryRuleAttrCondDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrCondDef = null;


        try {
            // InternalTGG.g:439:2: (iv_ruleAttrCondDef= ruleAttrCondDef EOF )
            // InternalTGG.g:440:2: iv_ruleAttrCondDef= ruleAttrCondDef EOF
            {
             newCompositeNode(grammarAccess.getAttrCondDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttrCondDef=ruleAttrCondDef();

            state._fsp--;

             current =iv_ruleAttrCondDef; 
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
    // $ANTLR end "entryRuleAttrCondDef"


    // $ANTLR start "ruleAttrCondDef"
    // InternalTGG.g:447:1: ruleAttrCondDef returns [EObject current=null] : ( ( (lv_userDefined_0_0= '#userDefined' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= '#sync:' ( (lv_allowedSyncAdornments_9_0= ruleAdornment ) ) (otherlv_10= ',' ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) ) )* (otherlv_12= '#gen:' ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )? )? otherlv_16= '}' ) ;
    public final EObject ruleAttrCondDef() throws RecognitionException {
        EObject current = null;

        Token lv_userDefined_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_allowedSyncAdornments_9_0 = null;

        EObject lv_allowedSyncAdornments_11_0 = null;

        EObject lv_allowedGenAdornments_13_0 = null;

        EObject lv_allowedGenAdornments_15_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:450:28: ( ( ( (lv_userDefined_0_0= '#userDefined' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= '#sync:' ( (lv_allowedSyncAdornments_9_0= ruleAdornment ) ) (otherlv_10= ',' ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) ) )* (otherlv_12= '#gen:' ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )? )? otherlv_16= '}' ) )
            // InternalTGG.g:451:1: ( ( (lv_userDefined_0_0= '#userDefined' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= '#sync:' ( (lv_allowedSyncAdornments_9_0= ruleAdornment ) ) (otherlv_10= ',' ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) ) )* (otherlv_12= '#gen:' ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )? )? otherlv_16= '}' )
            {
            // InternalTGG.g:451:1: ( ( (lv_userDefined_0_0= '#userDefined' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= '#sync:' ( (lv_allowedSyncAdornments_9_0= ruleAdornment ) ) (otherlv_10= ',' ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) ) )* (otherlv_12= '#gen:' ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )? )? otherlv_16= '}' )
            // InternalTGG.g:451:2: ( (lv_userDefined_0_0= '#userDefined' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )? otherlv_6= ')' otherlv_7= '{' otherlv_8= '#sync:' ( (lv_allowedSyncAdornments_9_0= ruleAdornment ) ) (otherlv_10= ',' ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) ) )* (otherlv_12= '#gen:' ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )? )? otherlv_16= '}'
            {
            // InternalTGG.g:451:2: ( (lv_userDefined_0_0= '#userDefined' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==23) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTGG.g:452:1: (lv_userDefined_0_0= '#userDefined' )
                    {
                    // InternalTGG.g:452:1: (lv_userDefined_0_0= '#userDefined' )
                    // InternalTGG.g:453:3: lv_userDefined_0_0= '#userDefined'
                    {
                    lv_userDefined_0_0=(Token)match(input,23,FOLLOW_6); 

                            newLeafNode(lv_userDefined_0_0, grammarAccess.getAttrCondDefAccess().getUserDefinedUserDefinedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttrCondDefRule());
                    	        }
                           		setWithLastConsumed(current, "userDefined", true, "#userDefined");
                    	    

                    }


                    }
                    break;

            }

            // InternalTGG.g:466:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTGG.g:467:1: (lv_name_1_0= RULE_ID )
            {
            // InternalTGG.g:467:1: (lv_name_1_0= RULE_ID )
            // InternalTGG.g:468:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            			newLeafNode(lv_name_1_0, grammarAccess.getAttrCondDefAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrCondDefRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_19); 

                	newLeafNode(otherlv_2, grammarAccess.getAttrCondDefAccess().getLeftParenthesisKeyword_2());
                
            // InternalTGG.g:488:1: ( ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTGG.g:488:2: ( (lv_params_3_0= ruleParam ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    {
                    // InternalTGG.g:488:2: ( (lv_params_3_0= ruleParam ) )
                    // InternalTGG.g:489:1: (lv_params_3_0= ruleParam )
                    {
                    // InternalTGG.g:489:1: (lv_params_3_0= ruleParam )
                    // InternalTGG.g:490:3: lv_params_3_0= ruleParam
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrCondDefAccess().getParamsParamParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_20);
                    lv_params_3_0=ruleParam();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttrCondDefRule());
                    	        }
                           		add(
                           			current, 
                           			"params",
                            		lv_params_3_0, 
                            		"org.moflon.tgg.mosl.TGG.Param");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalTGG.g:506:2: (otherlv_4= ',' ( (lv_params_5_0= ruleParam ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==25) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalTGG.g:506:4: otherlv_4= ',' ( (lv_params_5_0= ruleParam ) )
                    	    {
                    	    otherlv_4=(Token)match(input,25,FOLLOW_6); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getAttrCondDefAccess().getCommaKeyword_3_1_0());
                    	        
                    	    // InternalTGG.g:510:1: ( (lv_params_5_0= ruleParam ) )
                    	    // InternalTGG.g:511:1: (lv_params_5_0= ruleParam )
                    	    {
                    	    // InternalTGG.g:511:1: (lv_params_5_0= ruleParam )
                    	    // InternalTGG.g:512:3: lv_params_5_0= ruleParam
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrCondDefAccess().getParamsParamParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_20);
                    	    lv_params_5_0=ruleParam();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrCondDefRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"params",
                    	            		lv_params_5_0, 
                    	            		"org.moflon.tgg.mosl.TGG.Param");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,26,FOLLOW_8); 

                	newLeafNode(otherlv_6, grammarAccess.getAttrCondDefAccess().getRightParenthesisKeyword_4());
                
            otherlv_7=(Token)match(input,15,FOLLOW_21); 

                	newLeafNode(otherlv_7, grammarAccess.getAttrCondDefAccess().getLeftCurlyBracketKeyword_5());
                
            otherlv_8=(Token)match(input,27,FOLLOW_22); 

                	newLeafNode(otherlv_8, grammarAccess.getAttrCondDefAccess().getSyncKeyword_6());
                
            // InternalTGG.g:540:1: ( (lv_allowedSyncAdornments_9_0= ruleAdornment ) )
            // InternalTGG.g:541:1: (lv_allowedSyncAdornments_9_0= ruleAdornment )
            {
            // InternalTGG.g:541:1: (lv_allowedSyncAdornments_9_0= ruleAdornment )
            // InternalTGG.g:542:3: lv_allowedSyncAdornments_9_0= ruleAdornment
            {
             
            	        newCompositeNode(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAdornmentParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_23);
            lv_allowedSyncAdornments_9_0=ruleAdornment();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttrCondDefRule());
            	        }
                   		add(
                   			current, 
                   			"allowedSyncAdornments",
                    		lv_allowedSyncAdornments_9_0, 
                    		"org.moflon.tgg.mosl.TGG.Adornment");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTGG.g:558:2: (otherlv_10= ',' ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==25) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTGG.g:558:4: otherlv_10= ',' ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) )
            	    {
            	    otherlv_10=(Token)match(input,25,FOLLOW_22); 

            	        	newLeafNode(otherlv_10, grammarAccess.getAttrCondDefAccess().getCommaKeyword_8_0());
            	        
            	    // InternalTGG.g:562:1: ( (lv_allowedSyncAdornments_11_0= ruleAdornment ) )
            	    // InternalTGG.g:563:1: (lv_allowedSyncAdornments_11_0= ruleAdornment )
            	    {
            	    // InternalTGG.g:563:1: (lv_allowedSyncAdornments_11_0= ruleAdornment )
            	    // InternalTGG.g:564:3: lv_allowedSyncAdornments_11_0= ruleAdornment
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAdornmentParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_23);
            	    lv_allowedSyncAdornments_11_0=ruleAdornment();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAttrCondDefRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"allowedSyncAdornments",
            	            		lv_allowedSyncAdornments_11_0, 
            	            		"org.moflon.tgg.mosl.TGG.Adornment");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // InternalTGG.g:580:4: (otherlv_12= '#gen:' ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )? )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==28) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalTGG.g:580:6: otherlv_12= '#gen:' ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )?
                    {
                    otherlv_12=(Token)match(input,28,FOLLOW_24); 

                        	newLeafNode(otherlv_12, grammarAccess.getAttrCondDefAccess().getGenKeyword_9_0());
                        
                    // InternalTGG.g:584:1: ( ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==34) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalTGG.g:584:2: ( (lv_allowedGenAdornments_13_0= ruleAdornment ) ) (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )*
                            {
                            // InternalTGG.g:584:2: ( (lv_allowedGenAdornments_13_0= ruleAdornment ) )
                            // InternalTGG.g:585:1: (lv_allowedGenAdornments_13_0= ruleAdornment )
                            {
                            // InternalTGG.g:585:1: (lv_allowedGenAdornments_13_0= ruleAdornment )
                            // InternalTGG.g:586:3: lv_allowedGenAdornments_13_0= ruleAdornment
                            {
                             
                            	        newCompositeNode(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAdornmentParserRuleCall_9_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_25);
                            lv_allowedGenAdornments_13_0=ruleAdornment();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getAttrCondDefRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"allowedGenAdornments",
                                    		lv_allowedGenAdornments_13_0, 
                                    		"org.moflon.tgg.mosl.TGG.Adornment");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // InternalTGG.g:602:2: (otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) ) )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==25) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // InternalTGG.g:602:4: otherlv_14= ',' ( (lv_allowedGenAdornments_15_0= ruleAdornment ) )
                            	    {
                            	    otherlv_14=(Token)match(input,25,FOLLOW_22); 

                            	        	newLeafNode(otherlv_14, grammarAccess.getAttrCondDefAccess().getCommaKeyword_9_1_1_0());
                            	        
                            	    // InternalTGG.g:606:1: ( (lv_allowedGenAdornments_15_0= ruleAdornment ) )
                            	    // InternalTGG.g:607:1: (lv_allowedGenAdornments_15_0= ruleAdornment )
                            	    {
                            	    // InternalTGG.g:607:1: (lv_allowedGenAdornments_15_0= ruleAdornment )
                            	    // InternalTGG.g:608:3: lv_allowedGenAdornments_15_0= ruleAdornment
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAdornmentParserRuleCall_9_1_1_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_25);
                            	    lv_allowedGenAdornments_15_0=ruleAdornment();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getAttrCondDefRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"allowedGenAdornments",
                            	            		lv_allowedGenAdornments_15_0, 
                            	            		"org.moflon.tgg.mosl.TGG.Adornment");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,16,FOLLOW_2); 

                	newLeafNode(otherlv_16, grammarAccess.getAttrCondDefAccess().getRightCurlyBracketKeyword_10());
                

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
    // $ANTLR end "ruleAttrCondDef"


    // $ANTLR start "entryRuleParam"
    // InternalTGG.g:636:1: entryRuleParam returns [EObject current=null] : iv_ruleParam= ruleParam EOF ;
    public final EObject entryRuleParam() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParam = null;


        try {
            // InternalTGG.g:637:2: (iv_ruleParam= ruleParam EOF )
            // InternalTGG.g:638:2: iv_ruleParam= ruleParam EOF
            {
             newCompositeNode(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParam=ruleParam();

            state._fsp--;

             current =iv_ruleParam; 
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
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // InternalTGG.g:645:1: ruleParam returns [EObject current=null] : ( ( (lv_paramName_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleParam() throws RecognitionException {
        EObject current = null;

        Token lv_paramName_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:648:28: ( ( ( (lv_paramName_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) ) )
            // InternalTGG.g:649:1: ( ( (lv_paramName_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) )
            {
            // InternalTGG.g:649:1: ( ( (lv_paramName_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:649:2: ( (lv_paramName_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:649:2: ( (lv_paramName_0_0= RULE_ID ) )
            // InternalTGG.g:650:1: (lv_paramName_0_0= RULE_ID )
            {
            // InternalTGG.g:650:1: (lv_paramName_0_0= RULE_ID )
            // InternalTGG.g:651:3: lv_paramName_0_0= RULE_ID
            {
            lv_paramName_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            			newLeafNode(lv_paramName_0_0, grammarAccess.getParamAccess().getParamNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getParamRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"paramName",
                    		lv_paramName_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getParamAccess().getColonKeyword_1());
                
            // InternalTGG.g:671:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:672:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:672:1: ( ruleQualifiedName )
            // InternalTGG.g:673:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getParamRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getParamAccess().getTypeEDataTypeCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             
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
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleRule"
    // InternalTGG.g:694:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalTGG.g:695:2: (iv_ruleRule= ruleRule EOF )
            // InternalTGG.g:696:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
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
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalTGG.g:703:1: ruleRule returns [EObject current=null] : ( ( (lv_abstractRule_0_0= '#abstract' ) )? otherlv_1= '#rule' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '#extends' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )? otherlv_7= '#with' ( ( ruleQualifiedName ) ) (otherlv_9= '#source' otherlv_10= '{' ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )* otherlv_12= '}' )? (otherlv_13= '#target' otherlv_14= '{' ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )* otherlv_16= '}' )? (otherlv_17= '#correspondence' otherlv_18= '{' ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )* otherlv_20= '}' )? (otherlv_21= '#attributeConditions' otherlv_22= '{' ( (lv_attrConditions_23_0= ruleAttrCond ) )* otherlv_24= '}' )? ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token lv_abstractRule_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        EObject lv_sourcePatterns_11_0 = null;

        EObject lv_targetPatterns_15_0 = null;

        EObject lv_correspondencePatterns_19_0 = null;

        EObject lv_attrConditions_23_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:706:28: ( ( ( (lv_abstractRule_0_0= '#abstract' ) )? otherlv_1= '#rule' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '#extends' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )? otherlv_7= '#with' ( ( ruleQualifiedName ) ) (otherlv_9= '#source' otherlv_10= '{' ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )* otherlv_12= '}' )? (otherlv_13= '#target' otherlv_14= '{' ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )* otherlv_16= '}' )? (otherlv_17= '#correspondence' otherlv_18= '{' ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )* otherlv_20= '}' )? (otherlv_21= '#attributeConditions' otherlv_22= '{' ( (lv_attrConditions_23_0= ruleAttrCond ) )* otherlv_24= '}' )? ) )
            // InternalTGG.g:707:1: ( ( (lv_abstractRule_0_0= '#abstract' ) )? otherlv_1= '#rule' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '#extends' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )? otherlv_7= '#with' ( ( ruleQualifiedName ) ) (otherlv_9= '#source' otherlv_10= '{' ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )* otherlv_12= '}' )? (otherlv_13= '#target' otherlv_14= '{' ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )* otherlv_16= '}' )? (otherlv_17= '#correspondence' otherlv_18= '{' ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )* otherlv_20= '}' )? (otherlv_21= '#attributeConditions' otherlv_22= '{' ( (lv_attrConditions_23_0= ruleAttrCond ) )* otherlv_24= '}' )? )
            {
            // InternalTGG.g:707:1: ( ( (lv_abstractRule_0_0= '#abstract' ) )? otherlv_1= '#rule' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '#extends' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )? otherlv_7= '#with' ( ( ruleQualifiedName ) ) (otherlv_9= '#source' otherlv_10= '{' ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )* otherlv_12= '}' )? (otherlv_13= '#target' otherlv_14= '{' ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )* otherlv_16= '}' )? (otherlv_17= '#correspondence' otherlv_18= '{' ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )* otherlv_20= '}' )? (otherlv_21= '#attributeConditions' otherlv_22= '{' ( (lv_attrConditions_23_0= ruleAttrCond ) )* otherlv_24= '}' )? )
            // InternalTGG.g:707:2: ( (lv_abstractRule_0_0= '#abstract' ) )? otherlv_1= '#rule' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '#extends' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )? otherlv_7= '#with' ( ( ruleQualifiedName ) ) (otherlv_9= '#source' otherlv_10= '{' ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )* otherlv_12= '}' )? (otherlv_13= '#target' otherlv_14= '{' ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )* otherlv_16= '}' )? (otherlv_17= '#correspondence' otherlv_18= '{' ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )* otherlv_20= '}' )? (otherlv_21= '#attributeConditions' otherlv_22= '{' ( (lv_attrConditions_23_0= ruleAttrCond ) )* otherlv_24= '}' )?
            {
            // InternalTGG.g:707:2: ( (lv_abstractRule_0_0= '#abstract' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==30) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTGG.g:708:1: (lv_abstractRule_0_0= '#abstract' )
                    {
                    // InternalTGG.g:708:1: (lv_abstractRule_0_0= '#abstract' )
                    // InternalTGG.g:709:3: lv_abstractRule_0_0= '#abstract'
                    {
                    lv_abstractRule_0_0=(Token)match(input,30,FOLLOW_27); 

                            newLeafNode(lv_abstractRule_0_0, grammarAccess.getRuleAccess().getAbstractRuleAbstractKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleRule());
                    	        }
                           		setWithLastConsumed(current, "abstractRule", true, "#abstract");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,31,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getRuleAccess().getRuleKeyword_1());
                
            // InternalTGG.g:726:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalTGG.g:727:1: (lv_name_2_0= RULE_ID )
            {
            // InternalTGG.g:727:1: (lv_name_2_0= RULE_ID )
            // InternalTGG.g:728:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            			newLeafNode(lv_name_2_0, grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            // InternalTGG.g:744:2: (otherlv_3= '#extends' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==20) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTGG.g:744:4: otherlv_3= '#extends' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
                    {
                    otherlv_3=(Token)match(input,20,FOLLOW_6); 

                        	newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getExtendsKeyword_3_0());
                        
                    // InternalTGG.g:748:1: ( (otherlv_4= RULE_ID ) )
                    // InternalTGG.g:749:1: (otherlv_4= RULE_ID )
                    {
                    // InternalTGG.g:749:1: (otherlv_4= RULE_ID )
                    // InternalTGG.g:750:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRuleRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_29); 

                    		newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // InternalTGG.g:761:2: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==25) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalTGG.g:761:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,25,FOLLOW_6); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getRuleAccess().getCommaKeyword_3_2_0());
                    	        
                    	    // InternalTGG.g:765:1: ( (otherlv_6= RULE_ID ) )
                    	    // InternalTGG.g:766:1: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalTGG.g:766:1: (otherlv_6= RULE_ID )
                    	    // InternalTGG.g:767:3: otherlv_6= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getRuleRule());
                    	    	        }
                    	            
                    	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_29); 

                    	    		newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,32,FOLLOW_6); 

                	newLeafNode(otherlv_7, grammarAccess.getRuleAccess().getWithKeyword_4());
                
            // InternalTGG.g:782:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:783:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:783:1: ( ruleQualifiedName )
            // InternalTGG.g:784:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRuleRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRuleAccess().getSchemaSchemaCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_7);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTGG.g:797:2: (otherlv_9= '#source' otherlv_10= '{' ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )* otherlv_12= '}' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==14) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalTGG.g:797:4: otherlv_9= '#source' otherlv_10= '{' ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )* otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_8); 

                        	newLeafNode(otherlv_9, grammarAccess.getRuleAccess().getSourceKeyword_6_0());
                        
                    otherlv_10=(Token)match(input,15,FOLLOW_30); 

                        	newLeafNode(otherlv_10, grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // InternalTGG.g:805:1: ( (lv_sourcePatterns_11_0= ruleObjectVariablePattern ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==RULE_ID||LA25_0==51) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalTGG.g:806:1: (lv_sourcePatterns_11_0= ruleObjectVariablePattern )
                    	    {
                    	    // InternalTGG.g:806:1: (lv_sourcePatterns_11_0= ruleObjectVariablePattern )
                    	    // InternalTGG.g:807:3: lv_sourcePatterns_11_0= ruleObjectVariablePattern
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleAccess().getSourcePatternsObjectVariablePatternParserRuleCall_6_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_30);
                    	    lv_sourcePatterns_11_0=ruleObjectVariablePattern();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"sourcePatterns",
                    	            		lv_sourcePatterns_11_0, 
                    	            		"org.moflon.tgg.mosl.TGG.ObjectVariablePattern");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,16,FOLLOW_10); 

                        	newLeafNode(otherlv_12, grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_6_3());
                        

                    }
                    break;

            }

            // InternalTGG.g:827:3: (otherlv_13= '#target' otherlv_14= '{' ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )* otherlv_16= '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==17) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalTGG.g:827:5: otherlv_13= '#target' otherlv_14= '{' ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )* otherlv_16= '}'
                    {
                    otherlv_13=(Token)match(input,17,FOLLOW_8); 

                        	newLeafNode(otherlv_13, grammarAccess.getRuleAccess().getTargetKeyword_7_0());
                        
                    otherlv_14=(Token)match(input,15,FOLLOW_30); 

                        	newLeafNode(otherlv_14, grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_7_1());
                        
                    // InternalTGG.g:835:1: ( (lv_targetPatterns_15_0= ruleObjectVariablePattern ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_ID||LA27_0==51) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalTGG.g:836:1: (lv_targetPatterns_15_0= ruleObjectVariablePattern )
                    	    {
                    	    // InternalTGG.g:836:1: (lv_targetPatterns_15_0= ruleObjectVariablePattern )
                    	    // InternalTGG.g:837:3: lv_targetPatterns_15_0= ruleObjectVariablePattern
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleAccess().getTargetPatternsObjectVariablePatternParserRuleCall_7_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_30);
                    	    lv_targetPatterns_15_0=ruleObjectVariablePattern();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"targetPatterns",
                    	            		lv_targetPatterns_15_0, 
                    	            		"org.moflon.tgg.mosl.TGG.ObjectVariablePattern");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,16,FOLLOW_11); 

                        	newLeafNode(otherlv_16, grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_7_3());
                        

                    }
                    break;

            }

            // InternalTGG.g:857:3: (otherlv_17= '#correspondence' otherlv_18= '{' ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )* otherlv_20= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==18) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTGG.g:857:5: otherlv_17= '#correspondence' otherlv_18= '{' ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )* otherlv_20= '}'
                    {
                    otherlv_17=(Token)match(input,18,FOLLOW_8); 

                        	newLeafNode(otherlv_17, grammarAccess.getRuleAccess().getCorrespondenceKeyword_8_0());
                        
                    otherlv_18=(Token)match(input,15,FOLLOW_30); 

                        	newLeafNode(otherlv_18, grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_8_1());
                        
                    // InternalTGG.g:865:1: ( (lv_correspondencePatterns_19_0= ruleCorrVariablePattern ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_ID||LA29_0==51) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalTGG.g:866:1: (lv_correspondencePatterns_19_0= ruleCorrVariablePattern )
                    	    {
                    	    // InternalTGG.g:866:1: (lv_correspondencePatterns_19_0= ruleCorrVariablePattern )
                    	    // InternalTGG.g:867:3: lv_correspondencePatterns_19_0= ruleCorrVariablePattern
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleAccess().getCorrespondencePatternsCorrVariablePatternParserRuleCall_8_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_30);
                    	    lv_correspondencePatterns_19_0=ruleCorrVariablePattern();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"correspondencePatterns",
                    	            		lv_correspondencePatterns_19_0, 
                    	            		"org.moflon.tgg.mosl.TGG.CorrVariablePattern");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,16,FOLLOW_12); 

                        	newLeafNode(otherlv_20, grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_8_3());
                        

                    }
                    break;

            }

            // InternalTGG.g:887:3: (otherlv_21= '#attributeConditions' otherlv_22= '{' ( (lv_attrConditions_23_0= ruleAttrCond ) )* otherlv_24= '}' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==19) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTGG.g:887:5: otherlv_21= '#attributeConditions' otherlv_22= '{' ( (lv_attrConditions_23_0= ruleAttrCond ) )* otherlv_24= '}'
                    {
                    otherlv_21=(Token)match(input,19,FOLLOW_8); 

                        	newLeafNode(otherlv_21, grammarAccess.getRuleAccess().getAttributeConditionsKeyword_9_0());
                        
                    otherlv_22=(Token)match(input,15,FOLLOW_9); 

                        	newLeafNode(otherlv_22, grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_9_1());
                        
                    // InternalTGG.g:895:1: ( (lv_attrConditions_23_0= ruleAttrCond ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==RULE_ID) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // InternalTGG.g:896:1: (lv_attrConditions_23_0= ruleAttrCond )
                    	    {
                    	    // InternalTGG.g:896:1: (lv_attrConditions_23_0= ruleAttrCond )
                    	    // InternalTGG.g:897:3: lv_attrConditions_23_0= ruleAttrCond
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleAccess().getAttrConditionsAttrCondParserRuleCall_9_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    lv_attrConditions_23_0=ruleAttrCond();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attrConditions",
                    	            		lv_attrConditions_23_0, 
                    	            		"org.moflon.tgg.mosl.TGG.AttrCond");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,16,FOLLOW_2); 

                        	newLeafNode(otherlv_24, grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_9_3());
                        

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
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleAttrCond"
    // InternalTGG.g:925:1: entryRuleAttrCond returns [EObject current=null] : iv_ruleAttrCond= ruleAttrCond EOF ;
    public final EObject entryRuleAttrCond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrCond = null;


        try {
            // InternalTGG.g:926:2: (iv_ruleAttrCond= ruleAttrCond EOF )
            // InternalTGG.g:927:2: iv_ruleAttrCond= ruleAttrCond EOF
            {
             newCompositeNode(grammarAccess.getAttrCondRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttrCond=ruleAttrCond();

            state._fsp--;

             current =iv_ruleAttrCond; 
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
    // $ANTLR end "entryRuleAttrCond"


    // $ANTLR start "ruleAttrCond"
    // InternalTGG.g:934:1: ruleAttrCond returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= ruleParamValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleAttrCond() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_values_2_0 = null;

        EObject lv_values_4_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:937:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= ruleParamValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )* )? otherlv_5= ')' ) )
            // InternalTGG.g:938:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= ruleParamValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )* )? otherlv_5= ')' )
            {
            // InternalTGG.g:938:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= ruleParamValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )* )? otherlv_5= ')' )
            // InternalTGG.g:938:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_values_2_0= ruleParamValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )* )? otherlv_5= ')'
            {
            // InternalTGG.g:938:2: ( (otherlv_0= RULE_ID ) )
            // InternalTGG.g:939:1: (otherlv_0= RULE_ID )
            {
            // InternalTGG.g:939:1: (otherlv_0= RULE_ID )
            // InternalTGG.g:940:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttrCondRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_18); 

            		newLeafNode(otherlv_0, grammarAccess.getAttrCondAccess().getNameAttrCondDefCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_31); 

                	newLeafNode(otherlv_1, grammarAccess.getAttrCondAccess().getLeftParenthesisKeyword_1());
                
            // InternalTGG.g:955:1: ( ( (lv_values_2_0= ruleParamValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_BOOL)||LA34_0==45||LA34_0==47||LA34_0==49) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTGG.g:955:2: ( (lv_values_2_0= ruleParamValue ) ) (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )*
                    {
                    // InternalTGG.g:955:2: ( (lv_values_2_0= ruleParamValue ) )
                    // InternalTGG.g:956:1: (lv_values_2_0= ruleParamValue )
                    {
                    // InternalTGG.g:956:1: (lv_values_2_0= ruleParamValue )
                    // InternalTGG.g:957:3: lv_values_2_0= ruleParamValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttrCondAccess().getValuesParamValueParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_20);
                    lv_values_2_0=ruleParamValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttrCondRule());
                    	        }
                           		add(
                           			current, 
                           			"values",
                            		lv_values_2_0, 
                            		"org.moflon.tgg.mosl.TGG.ParamValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalTGG.g:973:2: (otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==25) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalTGG.g:973:4: otherlv_3= ',' ( (lv_values_4_0= ruleParamValue ) )
                    	    {
                    	    otherlv_3=(Token)match(input,25,FOLLOW_32); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getAttrCondAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalTGG.g:977:1: ( (lv_values_4_0= ruleParamValue ) )
                    	    // InternalTGG.g:978:1: (lv_values_4_0= ruleParamValue )
                    	    {
                    	    // InternalTGG.g:978:1: (lv_values_4_0= ruleParamValue )
                    	    // InternalTGG.g:979:3: lv_values_4_0= ruleParamValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrCondAccess().getValuesParamValueParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_20);
                    	    lv_values_4_0=ruleParamValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrCondRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"values",
                    	            		lv_values_4_0, 
                    	            		"org.moflon.tgg.mosl.TGG.ParamValue");
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
                    break;

            }

            otherlv_5=(Token)match(input,26,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getAttrCondAccess().getRightParenthesisKeyword_3());
                

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
    // $ANTLR end "ruleAttrCond"


    // $ANTLR start "entryRuleAttrCondDefLibrary"
    // InternalTGG.g:1007:1: entryRuleAttrCondDefLibrary returns [EObject current=null] : iv_ruleAttrCondDefLibrary= ruleAttrCondDefLibrary EOF ;
    public final EObject entryRuleAttrCondDefLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrCondDefLibrary = null;


        try {
            // InternalTGG.g:1008:2: (iv_ruleAttrCondDefLibrary= ruleAttrCondDefLibrary EOF )
            // InternalTGG.g:1009:2: iv_ruleAttrCondDefLibrary= ruleAttrCondDefLibrary EOF
            {
             newCompositeNode(grammarAccess.getAttrCondDefLibraryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttrCondDefLibrary=ruleAttrCondDefLibrary();

            state._fsp--;

             current =iv_ruleAttrCondDefLibrary; 
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
    // $ANTLR end "entryRuleAttrCondDefLibrary"


    // $ANTLR start "ruleAttrCondDefLibrary"
    // InternalTGG.g:1016:1: ruleAttrCondDefLibrary returns [EObject current=null] : (otherlv_0= '#library' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '{' ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )* otherlv_4= '}' )? ) ;
    public final EObject ruleAttrCondDefLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_attributeCondDefs_3_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1019:28: ( (otherlv_0= '#library' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '{' ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )* otherlv_4= '}' )? ) )
            // InternalTGG.g:1020:1: (otherlv_0= '#library' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '{' ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )* otherlv_4= '}' )? )
            {
            // InternalTGG.g:1020:1: (otherlv_0= '#library' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '{' ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )* otherlv_4= '}' )? )
            // InternalTGG.g:1020:3: otherlv_0= '#library' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= '{' ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )* otherlv_4= '}' )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getAttrCondDefLibraryAccess().getLibraryKeyword_0());
                
            // InternalTGG.g:1024:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTGG.g:1025:1: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTGG.g:1025:1: (lv_name_1_0= ruleQualifiedName )
            // InternalTGG.g:1026:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getAttrCondDefLibraryAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_33);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttrCondDefLibraryRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.moflon.tgg.mosl.TGG.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTGG.g:1042:2: (otherlv_2= '{' ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )* otherlv_4= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==15) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalTGG.g:1042:4: otherlv_2= '{' ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )* otherlv_4= '}'
                    {
                    otherlv_2=(Token)match(input,15,FOLLOW_13); 

                        	newLeafNode(otherlv_2, grammarAccess.getAttrCondDefLibraryAccess().getLeftCurlyBracketKeyword_2_0());
                        
                    // InternalTGG.g:1046:1: ( (lv_attributeCondDefs_3_0= ruleAttrCondDef ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==RULE_ID||LA35_0==23) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalTGG.g:1047:1: (lv_attributeCondDefs_3_0= ruleAttrCondDef )
                    	    {
                    	    // InternalTGG.g:1047:1: (lv_attributeCondDefs_3_0= ruleAttrCondDef )
                    	    // InternalTGG.g:1048:3: lv_attributeCondDefs_3_0= ruleAttrCondDef
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getAttrCondDefLibraryAccess().getAttributeCondDefsAttrCondDefParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_13);
                    	    lv_attributeCondDefs_3_0=ruleAttrCondDef();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getAttrCondDefLibraryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributeCondDefs",
                    	            		lv_attributeCondDefs_3_0, 
                    	            		"org.moflon.tgg.mosl.TGG.AttrCondDef");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,16,FOLLOW_2); 

                        	newLeafNode(otherlv_4, grammarAccess.getAttrCondDefLibraryAccess().getRightCurlyBracketKeyword_2_2());
                        

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
    // $ANTLR end "ruleAttrCondDefLibrary"


    // $ANTLR start "entryRuleAdornment"
    // InternalTGG.g:1076:1: entryRuleAdornment returns [EObject current=null] : iv_ruleAdornment= ruleAdornment EOF ;
    public final EObject entryRuleAdornment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdornment = null;


        try {
            // InternalTGG.g:1077:2: (iv_ruleAdornment= ruleAdornment EOF )
            // InternalTGG.g:1078:2: iv_ruleAdornment= ruleAdornment EOF
            {
             newCompositeNode(grammarAccess.getAdornmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdornment=ruleAdornment();

            state._fsp--;

             current =iv_ruleAdornment; 
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
    // $ANTLR end "entryRuleAdornment"


    // $ANTLR start "ruleAdornment"
    // InternalTGG.g:1085:1: ruleAdornment returns [EObject current=null] : (otherlv_0= '[' ( ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) ) )+ otherlv_2= ']' ) ;
    public final EObject ruleAdornment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_1=null;
        Token lv_value_1_2=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:1088:28: ( (otherlv_0= '[' ( ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) ) )+ otherlv_2= ']' ) )
            // InternalTGG.g:1089:1: (otherlv_0= '[' ( ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) ) )+ otherlv_2= ']' )
            {
            // InternalTGG.g:1089:1: (otherlv_0= '[' ( ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) ) )+ otherlv_2= ']' )
            // InternalTGG.g:1089:3: otherlv_0= '[' ( ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34); 

                	newLeafNode(otherlv_0, grammarAccess.getAdornmentAccess().getLeftSquareBracketKeyword_0());
                
            // InternalTGG.g:1093:1: ( ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) ) )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=35 && LA38_0<=36)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalTGG.g:1094:1: ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) )
            	    {
            	    // InternalTGG.g:1094:1: ( (lv_value_1_1= 'B' | lv_value_1_2= 'F' ) )
            	    // InternalTGG.g:1095:1: (lv_value_1_1= 'B' | lv_value_1_2= 'F' )
            	    {
            	    // InternalTGG.g:1095:1: (lv_value_1_1= 'B' | lv_value_1_2= 'F' )
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==35) ) {
            	        alt37=1;
            	    }
            	    else if ( (LA37_0==36) ) {
            	        alt37=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // InternalTGG.g:1096:3: lv_value_1_1= 'B'
            	            {
            	            lv_value_1_1=(Token)match(input,35,FOLLOW_35); 

            	                    newLeafNode(lv_value_1_1, grammarAccess.getAdornmentAccess().getValueBKeyword_1_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdornmentRule());
            	            	        }
            	                   		addWithLastConsumed(current, "value", lv_value_1_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalTGG.g:1108:8: lv_value_1_2= 'F'
            	            {
            	            lv_value_1_2=(Token)match(input,36,FOLLOW_35); 

            	                    newLeafNode(lv_value_1_2, grammarAccess.getAdornmentAccess().getValueFKeyword_1_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getAdornmentRule());
            	            	        }
            	                   		addWithLastConsumed(current, "value", lv_value_1_2, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            otherlv_2=(Token)match(input,37,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getAdornmentAccess().getRightSquareBracketKeyword_2());
                

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
    // $ANTLR end "ruleAdornment"


    // $ANTLR start "entryRuleParamValue"
    // InternalTGG.g:1135:1: entryRuleParamValue returns [EObject current=null] : iv_ruleParamValue= ruleParamValue EOF ;
    public final EObject entryRuleParamValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParamValue = null;


        try {
            // InternalTGG.g:1136:2: (iv_ruleParamValue= ruleParamValue EOF )
            // InternalTGG.g:1137:2: iv_ruleParamValue= ruleParamValue EOF
            {
             newCompositeNode(grammarAccess.getParamValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParamValue=ruleParamValue();

            state._fsp--;

             current =iv_ruleParamValue; 
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
    // $ANTLR end "entryRuleParamValue"


    // $ANTLR start "ruleParamValue"
    // InternalTGG.g:1144:1: ruleParamValue returns [EObject current=null] : (this_LocalVariable_0= ruleLocalVariable | this_Expression_1= ruleExpression ) ;
    public final EObject ruleParamValue() throws RecognitionException {
        EObject current = null;

        EObject this_LocalVariable_0 = null;

        EObject this_Expression_1 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1147:28: ( (this_LocalVariable_0= ruleLocalVariable | this_Expression_1= ruleExpression ) )
            // InternalTGG.g:1148:1: (this_LocalVariable_0= ruleLocalVariable | this_Expression_1= ruleExpression )
            {
            // InternalTGG.g:1148:1: (this_LocalVariable_0= ruleLocalVariable | this_Expression_1= ruleExpression )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==48) ) {
                    alt39=2;
                }
                else if ( (LA39_1==EOF||(LA39_1>=25 && LA39_1<=26)) ) {
                    alt39=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_BOOL)||LA39_0==45||LA39_0==47||LA39_0==49) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalTGG.g:1149:5: this_LocalVariable_0= ruleLocalVariable
                    {
                     
                            newCompositeNode(grammarAccess.getParamValueAccess().getLocalVariableParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_LocalVariable_0=ruleLocalVariable();

                    state._fsp--;

                     
                            current = this_LocalVariable_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTGG.g:1159:5: this_Expression_1= ruleExpression
                    {
                     
                            newCompositeNode(grammarAccess.getParamValueAccess().getExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Expression_1=ruleExpression();

                    state._fsp--;

                     
                            current = this_Expression_1; 
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
    // $ANTLR end "ruleParamValue"


    // $ANTLR start "entryRuleLocalVariable"
    // InternalTGG.g:1175:1: entryRuleLocalVariable returns [EObject current=null] : iv_ruleLocalVariable= ruleLocalVariable EOF ;
    public final EObject entryRuleLocalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalVariable = null;


        try {
            // InternalTGG.g:1176:2: (iv_ruleLocalVariable= ruleLocalVariable EOF )
            // InternalTGG.g:1177:2: iv_ruleLocalVariable= ruleLocalVariable EOF
            {
             newCompositeNode(grammarAccess.getLocalVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalVariable=ruleLocalVariable();

            state._fsp--;

             current =iv_ruleLocalVariable; 
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
    // $ANTLR end "entryRuleLocalVariable"


    // $ANTLR start "ruleLocalVariable"
    // InternalTGG.g:1184:1: ruleLocalVariable returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleLocalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:1187:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalTGG.g:1188:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalTGG.g:1188:1: ( (lv_name_0_0= RULE_ID ) )
            // InternalTGG.g:1189:1: (lv_name_0_0= RULE_ID )
            {
            // InternalTGG.g:1189:1: (lv_name_0_0= RULE_ID )
            // InternalTGG.g:1190:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            			newLeafNode(lv_name_0_0, grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getLocalVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

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
    // $ANTLR end "ruleLocalVariable"


    // $ANTLR start "entryRuleCorrVariablePattern"
    // InternalTGG.g:1214:1: entryRuleCorrVariablePattern returns [EObject current=null] : iv_ruleCorrVariablePattern= ruleCorrVariablePattern EOF ;
    public final EObject entryRuleCorrVariablePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCorrVariablePattern = null;


        try {
            // InternalTGG.g:1215:2: (iv_ruleCorrVariablePattern= ruleCorrVariablePattern EOF )
            // InternalTGG.g:1216:2: iv_ruleCorrVariablePattern= ruleCorrVariablePattern EOF
            {
             newCompositeNode(grammarAccess.getCorrVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCorrVariablePattern=ruleCorrVariablePattern();

            state._fsp--;

             current =iv_ruleCorrVariablePattern; 
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
    // $ANTLR end "entryRuleCorrVariablePattern"


    // $ANTLR start "ruleCorrVariablePattern"
    // InternalTGG.g:1223:1: ruleCorrVariablePattern returns [EObject current=null] : ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) otherlv_4= '{' otherlv_5= '#src->' ( (otherlv_6= RULE_ID ) ) otherlv_7= '#trg->' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) ;
    public final EObject ruleCorrVariablePattern() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1226:28: ( ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) otherlv_4= '{' otherlv_5= '#src->' ( (otherlv_6= RULE_ID ) ) otherlv_7= '#trg->' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' ) )
            // InternalTGG.g:1227:1: ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) otherlv_4= '{' otherlv_5= '#src->' ( (otherlv_6= RULE_ID ) ) otherlv_7= '#trg->' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            {
            // InternalTGG.g:1227:1: ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) otherlv_4= '{' otherlv_5= '#src->' ( (otherlv_6= RULE_ID ) ) otherlv_7= '#trg->' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}' )
            // InternalTGG.g:1227:2: ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) otherlv_4= '{' otherlv_5= '#src->' ( (otherlv_6= RULE_ID ) ) otherlv_7= '#trg->' ( (otherlv_8= RULE_ID ) ) otherlv_9= '}'
            {
            // InternalTGG.g:1227:2: ( (lv_op_0_0= ruleOperator ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==51) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTGG.g:1228:1: (lv_op_0_0= ruleOperator )
                    {
                    // InternalTGG.g:1228:1: (lv_op_0_0= ruleOperator )
                    // InternalTGG.g:1229:3: lv_op_0_0= ruleOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getCorrVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_op_0_0=ruleOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCorrVariablePatternRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"org.moflon.tgg.mosl.TGG.Operator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTGG.g:1245:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTGG.g:1246:1: (lv_name_1_0= RULE_ID )
            {
            // InternalTGG.g:1246:1: (lv_name_1_0= RULE_ID )
            // InternalTGG.g:1247:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            			newLeafNode(lv_name_1_0, grammarAccess.getCorrVariablePatternAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCorrVariablePatternRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getCorrVariablePatternAccess().getColonKeyword_2());
                
            // InternalTGG.g:1267:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:1268:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:1268:1: ( ruleQualifiedName )
            // InternalTGG.g:1269:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCorrVariablePatternRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCorrVariablePatternAccess().getTypeCorrTypeCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_8);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_15); 

                	newLeafNode(otherlv_4, grammarAccess.getCorrVariablePatternAccess().getLeftCurlyBracketKeyword_4());
                
            otherlv_5=(Token)match(input,21,FOLLOW_6); 

                	newLeafNode(otherlv_5, grammarAccess.getCorrVariablePatternAccess().getSrcKeyword_5());
                
            // InternalTGG.g:1290:1: ( (otherlv_6= RULE_ID ) )
            // InternalTGG.g:1291:1: (otherlv_6= RULE_ID )
            {
            // InternalTGG.g:1291:1: (otherlv_6= RULE_ID )
            // InternalTGG.g:1292:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCorrVariablePatternRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_16); 

            		newLeafNode(otherlv_6, grammarAccess.getCorrVariablePatternAccess().getSourceObjectVariablePatternCrossReference_6_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,22,FOLLOW_6); 

                	newLeafNode(otherlv_7, grammarAccess.getCorrVariablePatternAccess().getTrgKeyword_7());
                
            // InternalTGG.g:1307:1: ( (otherlv_8= RULE_ID ) )
            // InternalTGG.g:1308:1: (otherlv_8= RULE_ID )
            {
            // InternalTGG.g:1308:1: (otherlv_8= RULE_ID )
            // InternalTGG.g:1309:3: otherlv_8= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCorrVariablePatternRule());
            	        }
                    
            otherlv_8=(Token)match(input,RULE_ID,FOLLOW_17); 

            		newLeafNode(otherlv_8, grammarAccess.getCorrVariablePatternAccess().getTargetObjectVariablePatternCrossReference_8_0()); 
            	

            }


            }

            otherlv_9=(Token)match(input,16,FOLLOW_2); 

                	newLeafNode(otherlv_9, grammarAccess.getCorrVariablePatternAccess().getRightCurlyBracketKeyword_9());
                

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
    // $ANTLR end "ruleCorrVariablePattern"


    // $ANTLR start "entryRuleObjectVariablePattern"
    // InternalTGG.g:1332:1: entryRuleObjectVariablePattern returns [EObject current=null] : iv_ruleObjectVariablePattern= ruleObjectVariablePattern EOF ;
    public final EObject entryRuleObjectVariablePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectVariablePattern = null;


        try {
            // InternalTGG.g:1333:2: (iv_ruleObjectVariablePattern= ruleObjectVariablePattern EOF )
            // InternalTGG.g:1334:2: iv_ruleObjectVariablePattern= ruleObjectVariablePattern EOF
            {
             newCompositeNode(grammarAccess.getObjectVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjectVariablePattern=ruleObjectVariablePattern();

            state._fsp--;

             current =iv_ruleObjectVariablePattern; 
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
    // $ANTLR end "entryRuleObjectVariablePattern"


    // $ANTLR start "ruleObjectVariablePattern"
    // InternalTGG.g:1341:1: ruleObjectVariablePattern returns [EObject current=null] : ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) (otherlv_4= '{' ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )* ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )* otherlv_8= '}' )? ) ;
    public final EObject ruleObjectVariablePattern() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        EObject lv_op_0_0 = null;

        EObject lv_attributeAssignments_5_0 = null;

        EObject lv_attributeConstraints_6_0 = null;

        EObject lv_linkVariablePatterns_7_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1344:28: ( ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) (otherlv_4= '{' ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )* ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )* otherlv_8= '}' )? ) )
            // InternalTGG.g:1345:1: ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) (otherlv_4= '{' ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )* ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )* otherlv_8= '}' )? )
            {
            // InternalTGG.g:1345:1: ( ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) (otherlv_4= '{' ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )* ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )* otherlv_8= '}' )? )
            // InternalTGG.g:1345:2: ( (lv_op_0_0= ruleOperator ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleQualifiedName ) ) (otherlv_4= '{' ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )* ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )* otherlv_8= '}' )?
            {
            // InternalTGG.g:1345:2: ( (lv_op_0_0= ruleOperator ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==51) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTGG.g:1346:1: (lv_op_0_0= ruleOperator )
                    {
                    // InternalTGG.g:1346:1: (lv_op_0_0= ruleOperator )
                    // InternalTGG.g:1347:3: lv_op_0_0= ruleOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getObjectVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_op_0_0=ruleOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getObjectVariablePatternRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"org.moflon.tgg.mosl.TGG.Operator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalTGG.g:1363:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTGG.g:1364:1: (lv_name_1_0= RULE_ID )
            {
            // InternalTGG.g:1364:1: (lv_name_1_0= RULE_ID )
            // InternalTGG.g:1365:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            			newLeafNode(lv_name_1_0, grammarAccess.getObjectVariablePatternAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectVariablePatternRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,29,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getObjectVariablePatternAccess().getColonKeyword_2());
                
            // InternalTGG.g:1385:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:1386:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:1386:1: ( ruleQualifiedName )
            // InternalTGG.g:1387:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectVariablePatternRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getObjectVariablePatternAccess().getTypeEClassCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_33);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTGG.g:1400:2: (otherlv_4= '{' ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )* ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )* otherlv_8= '}' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==15) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTGG.g:1400:4: otherlv_4= '{' ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )* ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )* otherlv_8= '}'
                    {
                    otherlv_4=(Token)match(input,15,FOLLOW_36); 

                        	newLeafNode(otherlv_4, grammarAccess.getObjectVariablePatternAccess().getLeftCurlyBracketKeyword_4_0());
                        
                    // InternalTGG.g:1404:1: ( (lv_attributeAssignments_5_0= ruleAttributeAssignment ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==RULE_ID) ) {
                            int LA42_1 = input.LA(2);

                            if ( (LA42_1==44) ) {
                                alt42=1;
                            }


                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalTGG.g:1405:1: (lv_attributeAssignments_5_0= ruleAttributeAssignment )
                    	    {
                    	    // InternalTGG.g:1405:1: (lv_attributeAssignments_5_0= ruleAttributeAssignment )
                    	    // InternalTGG.g:1406:3: lv_attributeAssignments_5_0= ruleAttributeAssignment
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getObjectVariablePatternAccess().getAttributeAssignmentsAttributeAssignmentParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_36);
                    	    lv_attributeAssignments_5_0=ruleAttributeAssignment();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getObjectVariablePatternRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributeAssignments",
                    	            		lv_attributeAssignments_5_0, 
                    	            		"org.moflon.tgg.mosl.TGG.AttributeAssignment");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    // InternalTGG.g:1422:3: ( (lv_attributeConstraints_6_0= ruleAttributeConstraint ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==RULE_ID) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalTGG.g:1423:1: (lv_attributeConstraints_6_0= ruleAttributeConstraint )
                    	    {
                    	    // InternalTGG.g:1423:1: (lv_attributeConstraints_6_0= ruleAttributeConstraint )
                    	    // InternalTGG.g:1424:3: lv_attributeConstraints_6_0= ruleAttributeConstraint
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getObjectVariablePatternAccess().getAttributeConstraintsAttributeConstraintParserRuleCall_4_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_36);
                    	    lv_attributeConstraints_6_0=ruleAttributeConstraint();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getObjectVariablePatternRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributeConstraints",
                    	            		lv_attributeConstraints_6_0, 
                    	            		"org.moflon.tgg.mosl.TGG.AttributeConstraint");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);

                    // InternalTGG.g:1440:3: ( (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==49||LA44_0==51) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalTGG.g:1441:1: (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern )
                    	    {
                    	    // InternalTGG.g:1441:1: (lv_linkVariablePatterns_7_0= ruleLinkVariablePattern )
                    	    // InternalTGG.g:1442:3: lv_linkVariablePatterns_7_0= ruleLinkVariablePattern
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getObjectVariablePatternAccess().getLinkVariablePatternsLinkVariablePatternParserRuleCall_4_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_37);
                    	    lv_linkVariablePatterns_7_0=ruleLinkVariablePattern();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getObjectVariablePatternRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"linkVariablePatterns",
                    	            		lv_linkVariablePatterns_7_0, 
                    	            		"org.moflon.tgg.mosl.TGG.LinkVariablePattern");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,16,FOLLOW_2); 

                        	newLeafNode(otherlv_8, grammarAccess.getObjectVariablePatternAccess().getRightCurlyBracketKeyword_4_4());
                        

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
    // $ANTLR end "ruleObjectVariablePattern"


    // $ANTLR start "entryRuleContextObjectVariablePattern"
    // InternalTGG.g:1470:1: entryRuleContextObjectVariablePattern returns [EObject current=null] : iv_ruleContextObjectVariablePattern= ruleContextObjectVariablePattern EOF ;
    public final EObject entryRuleContextObjectVariablePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextObjectVariablePattern = null;


        try {
            // InternalTGG.g:1471:2: (iv_ruleContextObjectVariablePattern= ruleContextObjectVariablePattern EOF )
            // InternalTGG.g:1472:2: iv_ruleContextObjectVariablePattern= ruleContextObjectVariablePattern EOF
            {
             newCompositeNode(grammarAccess.getContextObjectVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextObjectVariablePattern=ruleContextObjectVariablePattern();

            state._fsp--;

             current =iv_ruleContextObjectVariablePattern; 
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
    // $ANTLR end "entryRuleContextObjectVariablePattern"


    // $ANTLR start "ruleContextObjectVariablePattern"
    // InternalTGG.g:1479:1: ruleContextObjectVariablePattern returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) (otherlv_3= '{' ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )* otherlv_6= '}' )? ) ;
    public final EObject ruleContextObjectVariablePattern() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_attributeConstraints_4_0 = null;

        EObject lv_linkVariablePatterns_5_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1482:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) (otherlv_3= '{' ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )* otherlv_6= '}' )? ) )
            // InternalTGG.g:1483:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) (otherlv_3= '{' ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )* otherlv_6= '}' )? )
            {
            // InternalTGG.g:1483:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) (otherlv_3= '{' ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )* otherlv_6= '}' )? )
            // InternalTGG.g:1483:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( ruleQualifiedName ) ) (otherlv_3= '{' ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )* otherlv_6= '}' )?
            {
            // InternalTGG.g:1483:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalTGG.g:1484:1: (lv_name_0_0= RULE_ID )
            {
            // InternalTGG.g:1484:1: (lv_name_0_0= RULE_ID )
            // InternalTGG.g:1485:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            			newLeafNode(lv_name_0_0, grammarAccess.getContextObjectVariablePatternAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getContextObjectVariablePatternRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,29,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getContextObjectVariablePatternAccess().getColonKeyword_1());
                
            // InternalTGG.g:1505:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:1506:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:1506:1: ( ruleQualifiedName )
            // InternalTGG.g:1507:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContextObjectVariablePatternRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContextObjectVariablePatternAccess().getTypeEClassCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_33);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalTGG.g:1520:2: (otherlv_3= '{' ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )* otherlv_6= '}' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==15) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalTGG.g:1520:4: otherlv_3= '{' ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )* ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )* otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_38); 

                        	newLeafNode(otherlv_3, grammarAccess.getContextObjectVariablePatternAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // InternalTGG.g:1524:1: ( (lv_attributeConstraints_4_0= ruleAttributeConstraint ) )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==RULE_ID) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // InternalTGG.g:1525:1: (lv_attributeConstraints_4_0= ruleAttributeConstraint )
                    	    {
                    	    // InternalTGG.g:1525:1: (lv_attributeConstraints_4_0= ruleAttributeConstraint )
                    	    // InternalTGG.g:1526:3: lv_attributeConstraints_4_0= ruleAttributeConstraint
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContextObjectVariablePatternAccess().getAttributeConstraintsAttributeConstraintParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_38);
                    	    lv_attributeConstraints_4_0=ruleAttributeConstraint();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContextObjectVariablePatternRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributeConstraints",
                    	            		lv_attributeConstraints_4_0, 
                    	            		"org.moflon.tgg.mosl.TGG.AttributeConstraint");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    // InternalTGG.g:1542:3: ( (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==49) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalTGG.g:1543:1: (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern )
                    	    {
                    	    // InternalTGG.g:1543:1: (lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern )
                    	    // InternalTGG.g:1544:3: lv_linkVariablePatterns_5_0= ruleContextLinkVariablePattern
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContextObjectVariablePatternAccess().getLinkVariablePatternsContextLinkVariablePatternParserRuleCall_3_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_39);
                    	    lv_linkVariablePatterns_5_0=ruleContextLinkVariablePattern();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContextObjectVariablePatternRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"linkVariablePatterns",
                    	            		lv_linkVariablePatterns_5_0, 
                    	            		"org.moflon.tgg.mosl.TGG.ContextLinkVariablePattern");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,16,FOLLOW_2); 

                        	newLeafNode(otherlv_6, grammarAccess.getContextObjectVariablePatternAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleContextObjectVariablePattern"


    // $ANTLR start "entryRuleAttributeConstraint"
    // InternalTGG.g:1572:1: entryRuleAttributeConstraint returns [EObject current=null] : iv_ruleAttributeConstraint= ruleAttributeConstraint EOF ;
    public final EObject entryRuleAttributeConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeConstraint = null;


        try {
            // InternalTGG.g:1573:2: (iv_ruleAttributeConstraint= ruleAttributeConstraint EOF )
            // InternalTGG.g:1574:2: iv_ruleAttributeConstraint= ruleAttributeConstraint EOF
            {
             newCompositeNode(grammarAccess.getAttributeConstraintRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeConstraint=ruleAttributeConstraint();

            state._fsp--;

             current =iv_ruleAttributeConstraint; 
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
    // $ANTLR end "entryRuleAttributeConstraint"


    // $ANTLR start "ruleAttributeConstraint"
    // InternalTGG.g:1581:1: ruleAttributeConstraint returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) ) ) ( (lv_valueExp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAttributeConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        Token lv_op_1_5=null;
        Token lv_op_1_6=null;
        EObject lv_valueExp_2_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1584:28: ( ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) ) ) ( (lv_valueExp_2_0= ruleExpression ) ) ) )
            // InternalTGG.g:1585:1: ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) ) ) ( (lv_valueExp_2_0= ruleExpression ) ) )
            {
            // InternalTGG.g:1585:1: ( ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) ) ) ( (lv_valueExp_2_0= ruleExpression ) ) )
            // InternalTGG.g:1585:2: ( (otherlv_0= RULE_ID ) ) ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) ) ) ( (lv_valueExp_2_0= ruleExpression ) )
            {
            // InternalTGG.g:1585:2: ( (otherlv_0= RULE_ID ) )
            // InternalTGG.g:1586:1: (otherlv_0= RULE_ID )
            {
            // InternalTGG.g:1586:1: (otherlv_0= RULE_ID )
            // InternalTGG.g:1587:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeConstraintRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_40); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeConstraintAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            // InternalTGG.g:1598:2: ( ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) ) )
            // InternalTGG.g:1599:1: ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) )
            {
            // InternalTGG.g:1599:1: ( (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' ) )
            // InternalTGG.g:1600:1: (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' )
            {
            // InternalTGG.g:1600:1: (lv_op_1_1= '==' | lv_op_1_2= '!=' | lv_op_1_3= '<=' | lv_op_1_4= '>=' | lv_op_1_5= '>' | lv_op_1_6= '<' )
            int alt49=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt49=1;
                }
                break;
            case 39:
                {
                alt49=2;
                }
                break;
            case 40:
                {
                alt49=3;
                }
                break;
            case 41:
                {
                alt49=4;
                }
                break;
            case 42:
                {
                alt49=5;
                }
                break;
            case 43:
                {
                alt49=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalTGG.g:1601:3: lv_op_1_1= '=='
                    {
                    lv_op_1_1=(Token)match(input,38,FOLLOW_32); 

                            newLeafNode(lv_op_1_1, grammarAccess.getAttributeConstraintAccess().getOpEqualsSignEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeConstraintRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // InternalTGG.g:1613:8: lv_op_1_2= '!='
                    {
                    lv_op_1_2=(Token)match(input,39,FOLLOW_32); 

                            newLeafNode(lv_op_1_2, grammarAccess.getAttributeConstraintAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeConstraintRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // InternalTGG.g:1625:8: lv_op_1_3= '<='
                    {
                    lv_op_1_3=(Token)match(input,40,FOLLOW_32); 

                            newLeafNode(lv_op_1_3, grammarAccess.getAttributeConstraintAccess().getOpLessThanSignEqualsSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeConstraintRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // InternalTGG.g:1637:8: lv_op_1_4= '>='
                    {
                    lv_op_1_4=(Token)match(input,41,FOLLOW_32); 

                            newLeafNode(lv_op_1_4, grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeConstraintRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // InternalTGG.g:1649:8: lv_op_1_5= '>'
                    {
                    lv_op_1_5=(Token)match(input,42,FOLLOW_32); 

                            newLeafNode(lv_op_1_5, grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeConstraintRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // InternalTGG.g:1661:8: lv_op_1_6= '<'
                    {
                    lv_op_1_6=(Token)match(input,43,FOLLOW_32); 

                            newLeafNode(lv_op_1_6, grammarAccess.getAttributeConstraintAccess().getOpLessThanSignKeyword_1_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeConstraintRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_6, null);
                    	    

                    }
                    break;

            }


            }


            }

            // InternalTGG.g:1676:2: ( (lv_valueExp_2_0= ruleExpression ) )
            // InternalTGG.g:1677:1: (lv_valueExp_2_0= ruleExpression )
            {
            // InternalTGG.g:1677:1: (lv_valueExp_2_0= ruleExpression )
            // InternalTGG.g:1678:3: lv_valueExp_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAttributeConstraintAccess().getValueExpExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_valueExp_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeConstraintRule());
            	        }
                   		set(
                   			current, 
                   			"valueExp",
                    		lv_valueExp_2_0, 
                    		"org.moflon.tgg.mosl.TGG.Expression");
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
    // $ANTLR end "ruleAttributeConstraint"


    // $ANTLR start "entryRuleAttributeAssignment"
    // InternalTGG.g:1702:1: entryRuleAttributeAssignment returns [EObject current=null] : iv_ruleAttributeAssignment= ruleAttributeAssignment EOF ;
    public final EObject entryRuleAttributeAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeAssignment = null;


        try {
            // InternalTGG.g:1703:2: (iv_ruleAttributeAssignment= ruleAttributeAssignment EOF )
            // InternalTGG.g:1704:2: iv_ruleAttributeAssignment= ruleAttributeAssignment EOF
            {
             newCompositeNode(grammarAccess.getAttributeAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeAssignment=ruleAttributeAssignment();

            state._fsp--;

             current =iv_ruleAttributeAssignment; 
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
    // $ANTLR end "entryRuleAttributeAssignment"


    // $ANTLR start "ruleAttributeAssignment"
    // InternalTGG.g:1711:1: ruleAttributeAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ':=' ) ) ( (lv_valueExp_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAttributeAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_op_1_0=null;
        EObject lv_valueExp_2_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1714:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ':=' ) ) ( (lv_valueExp_2_0= ruleExpression ) ) ) )
            // InternalTGG.g:1715:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ':=' ) ) ( (lv_valueExp_2_0= ruleExpression ) ) )
            {
            // InternalTGG.g:1715:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ':=' ) ) ( (lv_valueExp_2_0= ruleExpression ) ) )
            // InternalTGG.g:1715:2: ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ':=' ) ) ( (lv_valueExp_2_0= ruleExpression ) )
            {
            // InternalTGG.g:1715:2: ( (otherlv_0= RULE_ID ) )
            // InternalTGG.g:1716:1: (otherlv_0= RULE_ID )
            {
            // InternalTGG.g:1716:1: (otherlv_0= RULE_ID )
            // InternalTGG.g:1717:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeAssignmentRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeAssignmentAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            // InternalTGG.g:1728:2: ( (lv_op_1_0= ':=' ) )
            // InternalTGG.g:1729:1: (lv_op_1_0= ':=' )
            {
            // InternalTGG.g:1729:1: (lv_op_1_0= ':=' )
            // InternalTGG.g:1730:3: lv_op_1_0= ':='
            {
            lv_op_1_0=(Token)match(input,44,FOLLOW_32); 

                    newLeafNode(lv_op_1_0, grammarAccess.getAttributeAssignmentAccess().getOpColonEqualsSignKeyword_1_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeAssignmentRule());
            	        }
                   		setWithLastConsumed(current, "op", lv_op_1_0, ":=");
            	    

            }


            }

            // InternalTGG.g:1743:2: ( (lv_valueExp_2_0= ruleExpression ) )
            // InternalTGG.g:1744:1: (lv_valueExp_2_0= ruleExpression )
            {
            // InternalTGG.g:1744:1: (lv_valueExp_2_0= ruleExpression )
            // InternalTGG.g:1745:3: lv_valueExp_2_0= ruleExpression
            {
             
            	        newCompositeNode(grammarAccess.getAttributeAssignmentAccess().getValueExpExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_valueExp_2_0=ruleExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"valueExp",
                    		lv_valueExp_2_0, 
                    		"org.moflon.tgg.mosl.TGG.Expression");
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
    // $ANTLR end "ruleAttributeAssignment"


    // $ANTLR start "entryRuleExpression"
    // InternalTGG.g:1769:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalTGG.g:1770:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalTGG.g:1771:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalTGG.g:1778:1: ruleExpression returns [EObject current=null] : (this_EnumExpression_0= ruleEnumExpression | this_AttributeExpression_1= ruleAttributeExpression | this_LiteralExpression_2= ruleLiteralExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_EnumExpression_0 = null;

        EObject this_AttributeExpression_1 = null;

        EObject this_LiteralExpression_2 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1781:28: ( (this_EnumExpression_0= ruleEnumExpression | this_AttributeExpression_1= ruleAttributeExpression | this_LiteralExpression_2= ruleLiteralExpression ) )
            // InternalTGG.g:1782:1: (this_EnumExpression_0= ruleEnumExpression | this_AttributeExpression_1= ruleAttributeExpression | this_LiteralExpression_2= ruleLiteralExpression )
            {
            // InternalTGG.g:1782:1: (this_EnumExpression_0= ruleEnumExpression | this_AttributeExpression_1= ruleAttributeExpression | this_LiteralExpression_2= ruleLiteralExpression )
            int alt50=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt50=1;
                }
                break;
            case RULE_ID:
            case 47:
                {
                alt50=2;
                }
                break;
            case RULE_STRING:
            case RULE_INT:
            case RULE_DECIMAL:
            case RULE_BOOL:
            case 49:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalTGG.g:1783:5: this_EnumExpression_0= ruleEnumExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getEnumExpressionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EnumExpression_0=ruleEnumExpression();

                    state._fsp--;

                     
                            current = this_EnumExpression_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTGG.g:1793:5: this_AttributeExpression_1= ruleAttributeExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getAttributeExpressionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_AttributeExpression_1=ruleAttributeExpression();

                    state._fsp--;

                     
                            current = this_AttributeExpression_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalTGG.g:1803:5: this_LiteralExpression_2= ruleLiteralExpression
                    {
                     
                            newCompositeNode(grammarAccess.getExpressionAccess().getLiteralExpressionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_LiteralExpression_2=ruleLiteralExpression();

                    state._fsp--;

                     
                            current = this_LiteralExpression_2; 
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleEnumExpression"
    // InternalTGG.g:1819:1: entryRuleEnumExpression returns [EObject current=null] : iv_ruleEnumExpression= ruleEnumExpression EOF ;
    public final EObject entryRuleEnumExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumExpression = null;


        try {
            // InternalTGG.g:1820:2: (iv_ruleEnumExpression= ruleEnumExpression EOF )
            // InternalTGG.g:1821:2: iv_ruleEnumExpression= ruleEnumExpression EOF
            {
             newCompositeNode(grammarAccess.getEnumExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumExpression=ruleEnumExpression();

            state._fsp--;

             current =iv_ruleEnumExpression; 
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
    // $ANTLR end "entryRuleEnumExpression"


    // $ANTLR start "ruleEnumExpression"
    // InternalTGG.g:1828:1: ruleEnumExpression returns [EObject current=null] : (otherlv_0= 'enum::' ( ( ruleQualifiedName ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleEnumExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:1831:28: ( (otherlv_0= 'enum::' ( ( ruleQualifiedName ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) ) )
            // InternalTGG.g:1832:1: (otherlv_0= 'enum::' ( ( ruleQualifiedName ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) )
            {
            // InternalTGG.g:1832:1: (otherlv_0= 'enum::' ( ( ruleQualifiedName ) ) otherlv_2= '::' ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:1832:3: otherlv_0= 'enum::' ( ( ruleQualifiedName ) ) otherlv_2= '::' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getEnumExpressionAccess().getEnumKeyword_0());
                
            // InternalTGG.g:1836:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:1837:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:1837:1: ( ruleQualifiedName )
            // InternalTGG.g:1838:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumExpressionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEnumExpressionAccess().getEenumEEnumCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_42);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getEnumExpressionAccess().getColonColonKeyword_2());
                
            // InternalTGG.g:1855:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:1856:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:1856:1: ( ruleQualifiedName )
            // InternalTGG.g:1857:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumExpressionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEnumExpressionAccess().getLiteralEEnumLiteralCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             
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
    // $ANTLR end "ruleEnumExpression"


    // $ANTLR start "entryRuleAttributeExpression"
    // InternalTGG.g:1878:1: entryRuleAttributeExpression returns [EObject current=null] : iv_ruleAttributeExpression= ruleAttributeExpression EOF ;
    public final EObject entryRuleAttributeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeExpression = null;


        try {
            // InternalTGG.g:1879:2: (iv_ruleAttributeExpression= ruleAttributeExpression EOF )
            // InternalTGG.g:1880:2: iv_ruleAttributeExpression= ruleAttributeExpression EOF
            {
             newCompositeNode(grammarAccess.getAttributeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAttributeExpression=ruleAttributeExpression();

            state._fsp--;

             current =iv_ruleAttributeExpression; 
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
    // $ANTLR end "entryRuleAttributeExpression"


    // $ANTLR start "ruleAttributeExpression"
    // InternalTGG.g:1887:1: ruleAttributeExpression returns [EObject current=null] : ( ( (lv_derived_0_0= '#derived' ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleAttributeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_derived_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:1890:28: ( ( ( (lv_derived_0_0= '#derived' ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalTGG.g:1891:1: ( ( (lv_derived_0_0= '#derived' ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalTGG.g:1891:1: ( ( (lv_derived_0_0= '#derived' ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )
            // InternalTGG.g:1891:2: ( (lv_derived_0_0= '#derived' ) )? ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            {
            // InternalTGG.g:1891:2: ( (lv_derived_0_0= '#derived' ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==47) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalTGG.g:1892:1: (lv_derived_0_0= '#derived' )
                    {
                    // InternalTGG.g:1892:1: (lv_derived_0_0= '#derived' )
                    // InternalTGG.g:1893:3: lv_derived_0_0= '#derived'
                    {
                    lv_derived_0_0=(Token)match(input,47,FOLLOW_6); 

                            newLeafNode(lv_derived_0_0, grammarAccess.getAttributeExpressionAccess().getDerivedDerivedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getAttributeExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "#derived");
                    	    

                    }


                    }
                    break;

            }

            // InternalTGG.g:1906:3: ( (otherlv_1= RULE_ID ) )
            // InternalTGG.g:1907:1: (otherlv_1= RULE_ID )
            {
            // InternalTGG.g:1907:1: (otherlv_1= RULE_ID )
            // InternalTGG.g:1908:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeExpressionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_43); 

            		newLeafNode(otherlv_1, grammarAccess.getAttributeExpressionAccess().getObjectVarEObjectCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,48,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getAttributeExpressionAccess().getFullStopKeyword_2());
                
            // InternalTGG.g:1923:1: ( (otherlv_3= RULE_ID ) )
            // InternalTGG.g:1924:1: (otherlv_3= RULE_ID )
            {
            // InternalTGG.g:1924:1: (otherlv_3= RULE_ID )
            // InternalTGG.g:1925:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeExpressionRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getAttributeExpressionAccess().getAttributeEAttributeCrossReference_3_0()); 
            	

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
    // $ANTLR end "ruleAttributeExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalTGG.g:1944:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalTGG.g:1945:2: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalTGG.g:1946:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
             newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;

             current =iv_ruleLiteralExpression; 
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
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalTGG.g:1953:1: ruleLiteralExpression returns [EObject current=null] : ( (lv_value_0_0= ruleLiteralValue ) ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1956:28: ( ( (lv_value_0_0= ruleLiteralValue ) ) )
            // InternalTGG.g:1957:1: ( (lv_value_0_0= ruleLiteralValue ) )
            {
            // InternalTGG.g:1957:1: ( (lv_value_0_0= ruleLiteralValue ) )
            // InternalTGG.g:1958:1: (lv_value_0_0= ruleLiteralValue )
            {
            // InternalTGG.g:1958:1: (lv_value_0_0= ruleLiteralValue )
            // InternalTGG.g:1959:3: lv_value_0_0= ruleLiteralValue
            {
             
            	        newCompositeNode(grammarAccess.getLiteralExpressionAccess().getValueLiteralValueParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleLiteralValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLiteralExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.moflon.tgg.mosl.TGG.LiteralValue");
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
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleLinkVariablePattern"
    // InternalTGG.g:1983:1: entryRuleLinkVariablePattern returns [EObject current=null] : iv_ruleLinkVariablePattern= ruleLinkVariablePattern EOF ;
    public final EObject entryRuleLinkVariablePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinkVariablePattern = null;


        try {
            // InternalTGG.g:1984:2: (iv_ruleLinkVariablePattern= ruleLinkVariablePattern EOF )
            // InternalTGG.g:1985:2: iv_ruleLinkVariablePattern= ruleLinkVariablePattern EOF
            {
             newCompositeNode(grammarAccess.getLinkVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLinkVariablePattern=ruleLinkVariablePattern();

            state._fsp--;

             current =iv_ruleLinkVariablePattern; 
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
    // $ANTLR end "entryRuleLinkVariablePattern"


    // $ANTLR start "ruleLinkVariablePattern"
    // InternalTGG.g:1992:1: ruleLinkVariablePattern returns [EObject current=null] : ( ( (lv_op_0_0= ruleOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleLinkVariablePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_op_0_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:1995:28: ( ( ( (lv_op_0_0= ruleOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) ) )
            // InternalTGG.g:1996:1: ( ( (lv_op_0_0= ruleOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalTGG.g:1996:1: ( ( (lv_op_0_0= ruleOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )
            // InternalTGG.g:1996:2: ( (lv_op_0_0= ruleOperator ) )? otherlv_1= '-' ( (otherlv_2= RULE_ID ) ) otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
            {
            // InternalTGG.g:1996:2: ( (lv_op_0_0= ruleOperator ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==51) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalTGG.g:1997:1: (lv_op_0_0= ruleOperator )
                    {
                    // InternalTGG.g:1997:1: (lv_op_0_0= ruleOperator )
                    // InternalTGG.g:1998:3: lv_op_0_0= ruleOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getLinkVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_44);
                    lv_op_0_0=ruleOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLinkVariablePatternRule());
                    	        }
                           		set(
                           			current, 
                           			"op",
                            		lv_op_0_0, 
                            		"org.moflon.tgg.mosl.TGG.Operator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,49,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getLinkVariablePatternAccess().getHyphenMinusKeyword_1());
                
            // InternalTGG.g:2018:1: ( (otherlv_2= RULE_ID ) )
            // InternalTGG.g:2019:1: (otherlv_2= RULE_ID )
            {
            // InternalTGG.g:2019:1: (otherlv_2= RULE_ID )
            // InternalTGG.g:2020:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkVariablePatternRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_45); 

            		newLeafNode(otherlv_2, grammarAccess.getLinkVariablePatternAccess().getTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,50,FOLLOW_6); 

                	newLeafNode(otherlv_3, grammarAccess.getLinkVariablePatternAccess().getHyphenMinusGreaterThanSignKeyword_3());
                
            // InternalTGG.g:2035:1: ( (otherlv_4= RULE_ID ) )
            // InternalTGG.g:2036:1: (otherlv_4= RULE_ID )
            {
            // InternalTGG.g:2036:1: (otherlv_4= RULE_ID )
            // InternalTGG.g:2037:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLinkVariablePatternRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_4, grammarAccess.getLinkVariablePatternAccess().getTargetObjectVariablePatternCrossReference_4_0()); 
            	

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
    // $ANTLR end "ruleLinkVariablePattern"


    // $ANTLR start "entryRuleContextLinkVariablePattern"
    // InternalTGG.g:2056:1: entryRuleContextLinkVariablePattern returns [EObject current=null] : iv_ruleContextLinkVariablePattern= ruleContextLinkVariablePattern EOF ;
    public final EObject entryRuleContextLinkVariablePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextLinkVariablePattern = null;


        try {
            // InternalTGG.g:2057:2: (iv_ruleContextLinkVariablePattern= ruleContextLinkVariablePattern EOF )
            // InternalTGG.g:2058:2: iv_ruleContextLinkVariablePattern= ruleContextLinkVariablePattern EOF
            {
             newCompositeNode(grammarAccess.getContextLinkVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContextLinkVariablePattern=ruleContextLinkVariablePattern();

            state._fsp--;

             current =iv_ruleContextLinkVariablePattern; 
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
    // $ANTLR end "entryRuleContextLinkVariablePattern"


    // $ANTLR start "ruleContextLinkVariablePattern"
    // InternalTGG.g:2065:1: ruleContextLinkVariablePattern returns [EObject current=null] : (otherlv_0= '-' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleContextLinkVariablePattern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:2068:28: ( (otherlv_0= '-' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) ) )
            // InternalTGG.g:2069:1: (otherlv_0= '-' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalTGG.g:2069:1: (otherlv_0= '-' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )
            // InternalTGG.g:2069:3: otherlv_0= '-' ( (otherlv_1= RULE_ID ) ) otherlv_2= '->' ( (otherlv_3= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getContextLinkVariablePatternAccess().getHyphenMinusKeyword_0());
                
            // InternalTGG.g:2073:1: ( (otherlv_1= RULE_ID ) )
            // InternalTGG.g:2074:1: (otherlv_1= RULE_ID )
            {
            // InternalTGG.g:2074:1: (otherlv_1= RULE_ID )
            // InternalTGG.g:2075:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContextLinkVariablePatternRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_45); 

            		newLeafNode(otherlv_1, grammarAccess.getContextLinkVariablePatternAccess().getTypeEReferenceCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,50,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getContextLinkVariablePatternAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
            // InternalTGG.g:2090:1: ( (otherlv_3= RULE_ID ) )
            // InternalTGG.g:2091:1: (otherlv_3= RULE_ID )
            {
            // InternalTGG.g:2091:1: (otherlv_3= RULE_ID )
            // InternalTGG.g:2092:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContextLinkVariablePatternRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); 

            		newLeafNode(otherlv_3, grammarAccess.getContextLinkVariablePatternAccess().getTargetContextObjectVariablePatternCrossReference_3_0()); 
            	

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
    // $ANTLR end "ruleContextLinkVariablePattern"


    // $ANTLR start "entryRuleOperator"
    // InternalTGG.g:2111:1: entryRuleOperator returns [EObject current=null] : iv_ruleOperator= ruleOperator EOF ;
    public final EObject entryRuleOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperator = null;


        try {
            // InternalTGG.g:2112:2: (iv_ruleOperator= ruleOperator EOF )
            // InternalTGG.g:2113:2: iv_ruleOperator= ruleOperator EOF
            {
             newCompositeNode(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperator=ruleOperator();

            state._fsp--;

             current =iv_ruleOperator; 
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
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalTGG.g:2120:1: ruleOperator returns [EObject current=null] : ( (lv_value_0_0= '++' ) ) ;
    public final EObject ruleOperator() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:2123:28: ( ( (lv_value_0_0= '++' ) ) )
            // InternalTGG.g:2124:1: ( (lv_value_0_0= '++' ) )
            {
            // InternalTGG.g:2124:1: ( (lv_value_0_0= '++' ) )
            // InternalTGG.g:2125:1: (lv_value_0_0= '++' )
            {
            // InternalTGG.g:2125:1: (lv_value_0_0= '++' )
            // InternalTGG.g:2126:3: lv_value_0_0= '++'
            {
            lv_value_0_0=(Token)match(input,51,FOLLOW_2); 

                    newLeafNode(lv_value_0_0, grammarAccess.getOperatorAccess().getValuePlusSignPlusSignKeyword_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getOperatorRule());
            	        }
                   		setWithLastConsumed(current, "value", lv_value_0_0, "++");
            	    

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
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleNac"
    // InternalTGG.g:2147:1: entryRuleNac returns [EObject current=null] : iv_ruleNac= ruleNac EOF ;
    public final EObject entryRuleNac() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNac = null;


        try {
            // InternalTGG.g:2148:2: (iv_ruleNac= ruleNac EOF )
            // InternalTGG.g:2149:2: iv_ruleNac= ruleNac EOF
            {
             newCompositeNode(grammarAccess.getNacRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNac=ruleNac();

            state._fsp--;

             current =iv_ruleNac; 
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
    // $ANTLR end "entryRuleNac"


    // $ANTLR start "ruleNac"
    // InternalTGG.g:2156:1: ruleNac returns [EObject current=null] : (otherlv_0= '#nac' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '#for' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' ) | (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' ) ) (otherlv_12= '#attributeConditions' otherlv_13= '{' ( (lv_attrConditions_14_0= ruleAttrCond ) )* otherlv_15= '}' )? ) ;
    public final EObject ruleNac() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_sourcePatterns_6_0 = null;

        EObject lv_targetPatterns_10_0 = null;

        EObject lv_attrConditions_14_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:2159:28: ( (otherlv_0= '#nac' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '#for' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' ) | (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' ) ) (otherlv_12= '#attributeConditions' otherlv_13= '{' ( (lv_attrConditions_14_0= ruleAttrCond ) )* otherlv_15= '}' )? ) )
            // InternalTGG.g:2160:1: (otherlv_0= '#nac' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '#for' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' ) | (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' ) ) (otherlv_12= '#attributeConditions' otherlv_13= '{' ( (lv_attrConditions_14_0= ruleAttrCond ) )* otherlv_15= '}' )? )
            {
            // InternalTGG.g:2160:1: (otherlv_0= '#nac' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '#for' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' ) | (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' ) ) (otherlv_12= '#attributeConditions' otherlv_13= '{' ( (lv_attrConditions_14_0= ruleAttrCond ) )* otherlv_15= '}' )? )
            // InternalTGG.g:2160:3: otherlv_0= '#nac' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '#for' ( (otherlv_3= RULE_ID ) ) ( (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' ) | (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' ) ) (otherlv_12= '#attributeConditions' otherlv_13= '{' ( (lv_attrConditions_14_0= ruleAttrCond ) )* otherlv_15= '}' )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getNacAccess().getNacKeyword_0());
                
            // InternalTGG.g:2164:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalTGG.g:2165:1: (lv_name_1_0= RULE_ID )
            {
            // InternalTGG.g:2165:1: (lv_name_1_0= RULE_ID )
            // InternalTGG.g:2166:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_46); 

            			newLeafNode(lv_name_1_0, grammarAccess.getNacAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNacRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.eclipse.xtext.common.Terminals.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,53,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getNacAccess().getForKeyword_2());
                
            // InternalTGG.g:2186:1: ( (otherlv_3= RULE_ID ) )
            // InternalTGG.g:2187:1: (otherlv_3= RULE_ID )
            {
            // InternalTGG.g:2187:1: (otherlv_3= RULE_ID )
            // InternalTGG.g:2188:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNacRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_47); 

            		newLeafNode(otherlv_3, grammarAccess.getNacAccess().getRuleRuleCrossReference_3_0()); 
            	

            }


            }

            // InternalTGG.g:2199:2: ( (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' ) | (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==14) ) {
                alt55=1;
            }
            else if ( (LA55_0==17) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalTGG.g:2199:3: (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' )
                    {
                    // InternalTGG.g:2199:3: (otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}' )
                    // InternalTGG.g:2199:5: otherlv_4= '#source' otherlv_5= '{' ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )* otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,14,FOLLOW_8); 

                        	newLeafNode(otherlv_4, grammarAccess.getNacAccess().getSourceKeyword_4_0_0());
                        
                    otherlv_5=(Token)match(input,15,FOLLOW_9); 

                        	newLeafNode(otherlv_5, grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_4_0_1());
                        
                    // InternalTGG.g:2207:1: ( (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==RULE_ID) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalTGG.g:2208:1: (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern )
                    	    {
                    	    // InternalTGG.g:2208:1: (lv_sourcePatterns_6_0= ruleContextObjectVariablePattern )
                    	    // InternalTGG.g:2209:3: lv_sourcePatterns_6_0= ruleContextObjectVariablePattern
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getNacAccess().getSourcePatternsContextObjectVariablePatternParserRuleCall_4_0_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    lv_sourcePatterns_6_0=ruleContextObjectVariablePattern();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getNacRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"sourcePatterns",
                    	            		lv_sourcePatterns_6_0, 
                    	            		"org.moflon.tgg.mosl.TGG.ContextObjectVariablePattern");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,16,FOLLOW_12); 

                        	newLeafNode(otherlv_7, grammarAccess.getNacAccess().getRightCurlyBracketKeyword_4_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:2230:6: (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' )
                    {
                    // InternalTGG.g:2230:6: (otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}' )
                    // InternalTGG.g:2230:8: otherlv_8= '#target' otherlv_9= '{' ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )* otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,17,FOLLOW_8); 

                        	newLeafNode(otherlv_8, grammarAccess.getNacAccess().getTargetKeyword_4_1_0());
                        
                    otherlv_9=(Token)match(input,15,FOLLOW_9); 

                        	newLeafNode(otherlv_9, grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_4_1_1());
                        
                    // InternalTGG.g:2238:1: ( (lv_targetPatterns_10_0= ruleContextObjectVariablePattern ) )*
                    loop54:
                    do {
                        int alt54=2;
                        int LA54_0 = input.LA(1);

                        if ( (LA54_0==RULE_ID) ) {
                            alt54=1;
                        }


                        switch (alt54) {
                    	case 1 :
                    	    // InternalTGG.g:2239:1: (lv_targetPatterns_10_0= ruleContextObjectVariablePattern )
                    	    {
                    	    // InternalTGG.g:2239:1: (lv_targetPatterns_10_0= ruleContextObjectVariablePattern )
                    	    // InternalTGG.g:2240:3: lv_targetPatterns_10_0= ruleContextObjectVariablePattern
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getNacAccess().getTargetPatternsContextObjectVariablePatternParserRuleCall_4_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    lv_targetPatterns_10_0=ruleContextObjectVariablePattern();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getNacRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"targetPatterns",
                    	            		lv_targetPatterns_10_0, 
                    	            		"org.moflon.tgg.mosl.TGG.ContextObjectVariablePattern");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_12); 

                        	newLeafNode(otherlv_11, grammarAccess.getNacAccess().getRightCurlyBracketKeyword_4_1_3());
                        

                    }


                    }
                    break;

            }

            // InternalTGG.g:2260:3: (otherlv_12= '#attributeConditions' otherlv_13= '{' ( (lv_attrConditions_14_0= ruleAttrCond ) )* otherlv_15= '}' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==19) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalTGG.g:2260:5: otherlv_12= '#attributeConditions' otherlv_13= '{' ( (lv_attrConditions_14_0= ruleAttrCond ) )* otherlv_15= '}'
                    {
                    otherlv_12=(Token)match(input,19,FOLLOW_8); 

                        	newLeafNode(otherlv_12, grammarAccess.getNacAccess().getAttributeConditionsKeyword_5_0());
                        
                    otherlv_13=(Token)match(input,15,FOLLOW_9); 

                        	newLeafNode(otherlv_13, grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // InternalTGG.g:2268:1: ( (lv_attrConditions_14_0= ruleAttrCond ) )*
                    loop56:
                    do {
                        int alt56=2;
                        int LA56_0 = input.LA(1);

                        if ( (LA56_0==RULE_ID) ) {
                            alt56=1;
                        }


                        switch (alt56) {
                    	case 1 :
                    	    // InternalTGG.g:2269:1: (lv_attrConditions_14_0= ruleAttrCond )
                    	    {
                    	    // InternalTGG.g:2269:1: (lv_attrConditions_14_0= ruleAttrCond )
                    	    // InternalTGG.g:2270:3: lv_attrConditions_14_0= ruleAttrCond
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getNacAccess().getAttrConditionsAttrCondParserRuleCall_5_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_9);
                    	    lv_attrConditions_14_0=ruleAttrCond();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getNacRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attrConditions",
                    	            		lv_attrConditions_14_0, 
                    	            		"org.moflon.tgg.mosl.TGG.AttrCond");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,16,FOLLOW_2); 

                        	newLeafNode(otherlv_15, grammarAccess.getNacAccess().getRightCurlyBracketKeyword_5_3());
                        

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
    // $ANTLR end "ruleNac"


    // $ANTLR start "entryRuleImport"
    // InternalTGG.g:2298:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalTGG.g:2299:2: (iv_ruleImport= ruleImport EOF )
            // InternalTGG.g:2300:2: iv_ruleImport= ruleImport EOF
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
    // InternalTGG.g:2307:1: ruleImport returns [EObject current=null] : (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:2310:28: ( (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // InternalTGG.g:2311:1: (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // InternalTGG.g:2311:1: (otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) ) )
            // InternalTGG.g:2311:3: otherlv_0= '#import' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_48); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // InternalTGG.g:2315:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalTGG.g:2316:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalTGG.g:2316:1: (lv_name_1_0= RULE_STRING )
            // InternalTGG.g:2317:3: lv_name_1_0= RULE_STRING
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


    // $ANTLR start "entryRuleUsing"
    // InternalTGG.g:2341:1: entryRuleUsing returns [EObject current=null] : iv_ruleUsing= ruleUsing EOF ;
    public final EObject entryRuleUsing() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUsing = null;


        try {
            // InternalTGG.g:2342:2: (iv_ruleUsing= ruleUsing EOF )
            // InternalTGG.g:2343:2: iv_ruleUsing= ruleUsing EOF
            {
             newCompositeNode(grammarAccess.getUsingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUsing=ruleUsing();

            state._fsp--;

             current =iv_ruleUsing; 
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
    // $ANTLR end "entryRuleUsing"


    // $ANTLR start "ruleUsing"
    // InternalTGG.g:2350:1: ruleUsing returns [EObject current=null] : (otherlv_0= '#using' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleUsing() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:2353:28: ( (otherlv_0= '#using' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // InternalTGG.g:2354:1: (otherlv_0= '#using' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // InternalTGG.g:2354:1: (otherlv_0= '#using' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // InternalTGG.g:2354:3: otherlv_0= '#using' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getUsingAccess().getUsingKeyword_0());
                
            // InternalTGG.g:2358:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // InternalTGG.g:2359:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // InternalTGG.g:2359:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // InternalTGG.g:2360:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getUsingAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUsingRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"org.moflon.tgg.mosl.TGG.QualifiedNameWithWildcard");
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
    // $ANTLR end "ruleUsing"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalTGG.g:2384:1: entryRuleLiteralValue returns [String current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final String entryRuleLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralValue = null;


        try {
            // InternalTGG.g:2385:2: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // InternalTGG.g:2386:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             newCompositeNode(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue.getText(); 
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
    // InternalTGG.g:2393:1: ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | ( (kw= '-' )? this_INT_2= RULE_INT ) | ( (kw= '-' )? this_DECIMAL_4= RULE_DECIMAL ) | this_BOOL_5= RULE_BOOL ) ;
    public final AntlrDatatypeRuleToken ruleLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_DECIMAL_4=null;
        Token this_BOOL_5=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:2396:28: ( (this_STRING_0= RULE_STRING | ( (kw= '-' )? this_INT_2= RULE_INT ) | ( (kw= '-' )? this_DECIMAL_4= RULE_DECIMAL ) | this_BOOL_5= RULE_BOOL ) )
            // InternalTGG.g:2397:1: (this_STRING_0= RULE_STRING | ( (kw= '-' )? this_INT_2= RULE_INT ) | ( (kw= '-' )? this_DECIMAL_4= RULE_DECIMAL ) | this_BOOL_5= RULE_BOOL )
            {
            // InternalTGG.g:2397:1: (this_STRING_0= RULE_STRING | ( (kw= '-' )? this_INT_2= RULE_INT ) | ( (kw= '-' )? this_DECIMAL_4= RULE_DECIMAL ) | this_BOOL_5= RULE_BOOL )
            int alt60=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt60=1;
                }
                break;
            case 49:
                {
                int LA60_2 = input.LA(2);

                if ( (LA60_2==RULE_DECIMAL) ) {
                    alt60=3;
                }
                else if ( (LA60_2==RULE_INT) ) {
                    alt60=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 60, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt60=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt60=3;
                }
                break;
            case RULE_BOOL:
                {
                alt60=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalTGG.g:2397:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getLiteralValueAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalTGG.g:2405:6: ( (kw= '-' )? this_INT_2= RULE_INT )
                    {
                    // InternalTGG.g:2405:6: ( (kw= '-' )? this_INT_2= RULE_INT )
                    // InternalTGG.g:2405:7: (kw= '-' )? this_INT_2= RULE_INT
                    {
                    // InternalTGG.g:2405:7: (kw= '-' )?
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==49) ) {
                        alt58=1;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalTGG.g:2406:2: kw= '-'
                            {
                            kw=(Token)match(input,49,FOLLOW_49); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_1_0()); 
                                

                            }
                            break;

                    }

                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

                    		current.merge(this_INT_2);
                        
                     
                        newLeafNode(this_INT_2, grammarAccess.getLiteralValueAccess().getINTTerminalRuleCall_1_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // InternalTGG.g:2419:6: ( (kw= '-' )? this_DECIMAL_4= RULE_DECIMAL )
                    {
                    // InternalTGG.g:2419:6: ( (kw= '-' )? this_DECIMAL_4= RULE_DECIMAL )
                    // InternalTGG.g:2419:7: (kw= '-' )? this_DECIMAL_4= RULE_DECIMAL
                    {
                    // InternalTGG.g:2419:7: (kw= '-' )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==49) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalTGG.g:2420:2: kw= '-'
                            {
                            kw=(Token)match(input,49,FOLLOW_50); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_2_0()); 
                                

                            }
                            break;

                    }

                    this_DECIMAL_4=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

                    		current.merge(this_DECIMAL_4);
                        
                     
                        newLeafNode(this_DECIMAL_4, grammarAccess.getLiteralValueAccess().getDECIMALTerminalRuleCall_2_1()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // InternalTGG.g:2433:10: this_BOOL_5= RULE_BOOL
                    {
                    this_BOOL_5=(Token)match(input,RULE_BOOL,FOLLOW_2); 

                    		current.merge(this_BOOL_5);
                        
                     
                        newLeafNode(this_BOOL_5, grammarAccess.getLiteralValueAccess().getBOOLTerminalRuleCall_3()); 
                        

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
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalTGG.g:2448:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalTGG.g:2449:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalTGG.g:2450:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalTGG.g:2457:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.*' ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:2460:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.*' ) )
            // InternalTGG.g:2461:1: (this_QualifiedName_0= ruleQualifiedName kw= '.*' )
            {
            // InternalTGG.g:2461:1: (this_QualifiedName_0= ruleQualifiedName kw= '.*' )
            // InternalTGG.g:2462:5: this_QualifiedName_0= ruleQualifiedName kw= '.*'
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_51);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,56,FOLLOW_2); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
                

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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTGG.g:2486:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTGG.g:2487:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTGG.g:2488:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalTGG.g:2495:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalTGG.g:2498:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTGG.g:2499:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTGG.g:2499:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTGG.g:2499:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_52); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalTGG.g:2506:1: (kw= '.' this_ID_2= RULE_ID )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==48) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalTGG.g:2507:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,48,FOLLOW_6); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_52); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop61;
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


    // $ANTLR start "entryRuleNamePattern"
    // InternalTGG.g:2531:1: entryRuleNamePattern returns [EObject current=null] : iv_ruleNamePattern= ruleNamePattern EOF ;
    public final EObject entryRuleNamePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamePattern = null;


        try {
            // InternalTGG.g:2532:2: (iv_ruleNamePattern= ruleNamePattern EOF )
            // InternalTGG.g:2533:2: iv_ruleNamePattern= ruleNamePattern EOF
            {
             newCompositeNode(grammarAccess.getNamePatternRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamePattern=ruleNamePattern();

            state._fsp--;

             current =iv_ruleNamePattern; 
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
    // $ANTLR end "entryRuleNamePattern"


    // $ANTLR start "ruleNamePattern"
    // InternalTGG.g:2540:1: ruleNamePattern returns [EObject current=null] : (this_CorrVariablePattern_0= ruleCorrVariablePattern | this_ObjectVariablePattern_1= ruleObjectVariablePattern ) ;
    public final EObject ruleNamePattern() throws RecognitionException {
        EObject current = null;

        EObject this_CorrVariablePattern_0 = null;

        EObject this_ObjectVariablePattern_1 = null;


         enterRule(); 
            
        try {
            // InternalTGG.g:2543:28: ( (this_CorrVariablePattern_0= ruleCorrVariablePattern | this_ObjectVariablePattern_1= ruleObjectVariablePattern ) )
            // InternalTGG.g:2544:1: (this_CorrVariablePattern_0= ruleCorrVariablePattern | this_ObjectVariablePattern_1= ruleObjectVariablePattern )
            {
            // InternalTGG.g:2544:1: (this_CorrVariablePattern_0= ruleCorrVariablePattern | this_ObjectVariablePattern_1= ruleObjectVariablePattern )
            int alt62=2;
            alt62 = dfa62.predict(input);
            switch (alt62) {
                case 1 :
                    // InternalTGG.g:2545:5: this_CorrVariablePattern_0= ruleCorrVariablePattern
                    {
                     
                            newCompositeNode(grammarAccess.getNamePatternAccess().getCorrVariablePatternParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_CorrVariablePattern_0=ruleCorrVariablePattern();

                    state._fsp--;

                     
                            current = this_CorrVariablePattern_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalTGG.g:2555:5: this_ObjectVariablePattern_1= ruleObjectVariablePattern
                    {
                     
                            newCompositeNode(grammarAccess.getNamePatternAccess().getObjectVariablePatternParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ObjectVariablePattern_1=ruleObjectVariablePattern();

                    state._fsp--;

                     
                            current = this_ObjectVariablePattern_1; 
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
    // $ANTLR end "ruleNamePattern"

    // Delegated rules


    protected DFA62 dfa62 = new DFA62(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\4\uffff\1\7\3\uffff\1\7\1\uffff";
    static final String dfa_3s = "\2\4\1\35\1\4\1\17\2\4\1\uffff\1\17\1\uffff";
    static final String dfa_4s = "\1\63\1\4\1\35\1\4\1\60\1\4\1\63\1\uffff\1\60\1\uffff";
    static final String dfa_5s = "\7\uffff\1\2\1\uffff\1\1";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\56\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\40\uffff\1\5",
            "\1\10",
            "\1\7\13\uffff\1\7\4\uffff\1\11\33\uffff\1\7\1\uffff\1\7",
            "",
            "\1\6\40\uffff\1\5",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA62 extends DFA {

        public DFA62(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 62;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "2544:1: (this_CorrVariablePattern_0= ruleCorrVariablePattern | this_ObjectVariablePattern_1= ruleObjectVariablePattern )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00C00002C0002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00800002C0002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00000002C0000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00000000000E4002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000810010L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000012010000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002010000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000102000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0008000000010010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0002A000040001F0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0002A000000001F0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000003800000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x000A000000010010L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000A000000010000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0002000000010010L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0002000000010000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00000FC000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0001000000000002L});

}