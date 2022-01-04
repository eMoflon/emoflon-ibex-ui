package org.moflon.tgg.mosl.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.moflon.tgg.mosl.services.TGGGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTGGParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_BOOL", "RULE_INT", "RULE_DECIMAL", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'B'", "'F'", "'=='", "'!='", "'<='", "'>='", "'>'", "'<'", "'#schema'", "'#source'", "'{'", "'}'", "'#target'", "'#correspondence'", "'#attributeConditions'", "'#extends'", "'#src->'", "'#trg->'", "'('", "')'", "'#sync:'", "','", "'#gen:'", "':'", "'#rule'", "'#with'", "'#library'", "'['", "']'", "'enum::'", "'::'", "'.'", "'-'", "'->'", "'#nac'", "'#for'", "'#import'", "'#using'", "'.*'", "'#userDefined'", "'#abstract'", "':='", "'#derived'", "'++'"
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
    public static final int RULE_ID=8;
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
    public static final int RULE_STRING=4;
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
    public static final int RULE_BOOL=5;
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
     	
        public void setGrammarAccess(TGGGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleTripleGraphGrammarFile"
    // InternalTGG.g:60:1: entryRuleTripleGraphGrammarFile : ruleTripleGraphGrammarFile EOF ;
    public final void entryRuleTripleGraphGrammarFile() throws RecognitionException {
        try {
            // InternalTGG.g:61:1: ( ruleTripleGraphGrammarFile EOF )
            // InternalTGG.g:62:1: ruleTripleGraphGrammarFile EOF
            {
             before(grammarAccess.getTripleGraphGrammarFileRule()); 
            pushFollow(FOLLOW_1);
            ruleTripleGraphGrammarFile();

            state._fsp--;

             after(grammarAccess.getTripleGraphGrammarFileRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTripleGraphGrammarFile"


    // $ANTLR start "ruleTripleGraphGrammarFile"
    // InternalTGG.g:69:1: ruleTripleGraphGrammarFile : ( ( rule__TripleGraphGrammarFile__Group__0 ) ) ;
    public final void ruleTripleGraphGrammarFile() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:73:2: ( ( ( rule__TripleGraphGrammarFile__Group__0 ) ) )
            // InternalTGG.g:74:1: ( ( rule__TripleGraphGrammarFile__Group__0 ) )
            {
            // InternalTGG.g:74:1: ( ( rule__TripleGraphGrammarFile__Group__0 ) )
            // InternalTGG.g:75:1: ( rule__TripleGraphGrammarFile__Group__0 )
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getGroup()); 
            // InternalTGG.g:76:1: ( rule__TripleGraphGrammarFile__Group__0 )
            // InternalTGG.g:76:2: rule__TripleGraphGrammarFile__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TripleGraphGrammarFile__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTripleGraphGrammarFileAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTripleGraphGrammarFile"


    // $ANTLR start "entryRuleSchema"
    // InternalTGG.g:88:1: entryRuleSchema : ruleSchema EOF ;
    public final void entryRuleSchema() throws RecognitionException {
        try {
            // InternalTGG.g:89:1: ( ruleSchema EOF )
            // InternalTGG.g:90:1: ruleSchema EOF
            {
             before(grammarAccess.getSchemaRule()); 
            pushFollow(FOLLOW_1);
            ruleSchema();

            state._fsp--;

             after(grammarAccess.getSchemaRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSchema"


    // $ANTLR start "ruleSchema"
    // InternalTGG.g:97:1: ruleSchema : ( ( rule__Schema__Group__0 ) ) ;
    public final void ruleSchema() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:101:2: ( ( ( rule__Schema__Group__0 ) ) )
            // InternalTGG.g:102:1: ( ( rule__Schema__Group__0 ) )
            {
            // InternalTGG.g:102:1: ( ( rule__Schema__Group__0 ) )
            // InternalTGG.g:103:1: ( rule__Schema__Group__0 )
            {
             before(grammarAccess.getSchemaAccess().getGroup()); 
            // InternalTGG.g:104:1: ( rule__Schema__Group__0 )
            // InternalTGG.g:104:2: rule__Schema__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Schema__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSchemaAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSchema"


    // $ANTLR start "entryRuleCorrType"
    // InternalTGG.g:116:1: entryRuleCorrType : ruleCorrType EOF ;
    public final void entryRuleCorrType() throws RecognitionException {
        try {
            // InternalTGG.g:117:1: ( ruleCorrType EOF )
            // InternalTGG.g:118:1: ruleCorrType EOF
            {
             before(grammarAccess.getCorrTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleCorrType();

            state._fsp--;

             after(grammarAccess.getCorrTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCorrType"


    // $ANTLR start "ruleCorrType"
    // InternalTGG.g:125:1: ruleCorrType : ( ( rule__CorrType__Group__0 ) ) ;
    public final void ruleCorrType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:129:2: ( ( ( rule__CorrType__Group__0 ) ) )
            // InternalTGG.g:130:1: ( ( rule__CorrType__Group__0 ) )
            {
            // InternalTGG.g:130:1: ( ( rule__CorrType__Group__0 ) )
            // InternalTGG.g:131:1: ( rule__CorrType__Group__0 )
            {
             before(grammarAccess.getCorrTypeAccess().getGroup()); 
            // InternalTGG.g:132:1: ( rule__CorrType__Group__0 )
            // InternalTGG.g:132:2: rule__CorrType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCorrTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCorrType"


    // $ANTLR start "entryRuleAttrCondDef"
    // InternalTGG.g:144:1: entryRuleAttrCondDef : ruleAttrCondDef EOF ;
    public final void entryRuleAttrCondDef() throws RecognitionException {
        try {
            // InternalTGG.g:145:1: ( ruleAttrCondDef EOF )
            // InternalTGG.g:146:1: ruleAttrCondDef EOF
            {
             before(grammarAccess.getAttrCondDefRule()); 
            pushFollow(FOLLOW_1);
            ruleAttrCondDef();

            state._fsp--;

             after(grammarAccess.getAttrCondDefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttrCondDef"


    // $ANTLR start "ruleAttrCondDef"
    // InternalTGG.g:153:1: ruleAttrCondDef : ( ( rule__AttrCondDef__Group__0 ) ) ;
    public final void ruleAttrCondDef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:157:2: ( ( ( rule__AttrCondDef__Group__0 ) ) )
            // InternalTGG.g:158:1: ( ( rule__AttrCondDef__Group__0 ) )
            {
            // InternalTGG.g:158:1: ( ( rule__AttrCondDef__Group__0 ) )
            // InternalTGG.g:159:1: ( rule__AttrCondDef__Group__0 )
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup()); 
            // InternalTGG.g:160:1: ( rule__AttrCondDef__Group__0 )
            // InternalTGG.g:160:2: rule__AttrCondDef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttrCondDef"


    // $ANTLR start "entryRuleParam"
    // InternalTGG.g:172:1: entryRuleParam : ruleParam EOF ;
    public final void entryRuleParam() throws RecognitionException {
        try {
            // InternalTGG.g:173:1: ( ruleParam EOF )
            // InternalTGG.g:174:1: ruleParam EOF
            {
             before(grammarAccess.getParamRule()); 
            pushFollow(FOLLOW_1);
            ruleParam();

            state._fsp--;

             after(grammarAccess.getParamRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParam"


    // $ANTLR start "ruleParam"
    // InternalTGG.g:181:1: ruleParam : ( ( rule__Param__Group__0 ) ) ;
    public final void ruleParam() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:185:2: ( ( ( rule__Param__Group__0 ) ) )
            // InternalTGG.g:186:1: ( ( rule__Param__Group__0 ) )
            {
            // InternalTGG.g:186:1: ( ( rule__Param__Group__0 ) )
            // InternalTGG.g:187:1: ( rule__Param__Group__0 )
            {
             before(grammarAccess.getParamAccess().getGroup()); 
            // InternalTGG.g:188:1: ( rule__Param__Group__0 )
            // InternalTGG.g:188:2: rule__Param__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Param__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParamAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParam"


    // $ANTLR start "entryRuleRule"
    // InternalTGG.g:200:1: entryRuleRule : ruleRule EOF ;
    public final void entryRuleRule() throws RecognitionException {
        try {
            // InternalTGG.g:201:1: ( ruleRule EOF )
            // InternalTGG.g:202:1: ruleRule EOF
            {
             before(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleRule();

            state._fsp--;

             after(grammarAccess.getRuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalTGG.g:209:1: ruleRule : ( ( rule__Rule__Group__0 ) ) ;
    public final void ruleRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:213:2: ( ( ( rule__Rule__Group__0 ) ) )
            // InternalTGG.g:214:1: ( ( rule__Rule__Group__0 ) )
            {
            // InternalTGG.g:214:1: ( ( rule__Rule__Group__0 ) )
            // InternalTGG.g:215:1: ( rule__Rule__Group__0 )
            {
             before(grammarAccess.getRuleAccess().getGroup()); 
            // InternalTGG.g:216:1: ( rule__Rule__Group__0 )
            // InternalTGG.g:216:2: rule__Rule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleAttrCond"
    // InternalTGG.g:228:1: entryRuleAttrCond : ruleAttrCond EOF ;
    public final void entryRuleAttrCond() throws RecognitionException {
        try {
            // InternalTGG.g:229:1: ( ruleAttrCond EOF )
            // InternalTGG.g:230:1: ruleAttrCond EOF
            {
             before(grammarAccess.getAttrCondRule()); 
            pushFollow(FOLLOW_1);
            ruleAttrCond();

            state._fsp--;

             after(grammarAccess.getAttrCondRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttrCond"


    // $ANTLR start "ruleAttrCond"
    // InternalTGG.g:237:1: ruleAttrCond : ( ( rule__AttrCond__Group__0 ) ) ;
    public final void ruleAttrCond() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:241:2: ( ( ( rule__AttrCond__Group__0 ) ) )
            // InternalTGG.g:242:1: ( ( rule__AttrCond__Group__0 ) )
            {
            // InternalTGG.g:242:1: ( ( rule__AttrCond__Group__0 ) )
            // InternalTGG.g:243:1: ( rule__AttrCond__Group__0 )
            {
             before(grammarAccess.getAttrCondAccess().getGroup()); 
            // InternalTGG.g:244:1: ( rule__AttrCond__Group__0 )
            // InternalTGG.g:244:2: rule__AttrCond__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttrCond__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttrCond"


    // $ANTLR start "entryRuleAttrCondDefLibrary"
    // InternalTGG.g:256:1: entryRuleAttrCondDefLibrary : ruleAttrCondDefLibrary EOF ;
    public final void entryRuleAttrCondDefLibrary() throws RecognitionException {
        try {
            // InternalTGG.g:257:1: ( ruleAttrCondDefLibrary EOF )
            // InternalTGG.g:258:1: ruleAttrCondDefLibrary EOF
            {
             before(grammarAccess.getAttrCondDefLibraryRule()); 
            pushFollow(FOLLOW_1);
            ruleAttrCondDefLibrary();

            state._fsp--;

             after(grammarAccess.getAttrCondDefLibraryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttrCondDefLibrary"


    // $ANTLR start "ruleAttrCondDefLibrary"
    // InternalTGG.g:265:1: ruleAttrCondDefLibrary : ( ( rule__AttrCondDefLibrary__Group__0 ) ) ;
    public final void ruleAttrCondDefLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:269:2: ( ( ( rule__AttrCondDefLibrary__Group__0 ) ) )
            // InternalTGG.g:270:1: ( ( rule__AttrCondDefLibrary__Group__0 ) )
            {
            // InternalTGG.g:270:1: ( ( rule__AttrCondDefLibrary__Group__0 ) )
            // InternalTGG.g:271:1: ( rule__AttrCondDefLibrary__Group__0 )
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getGroup()); 
            // InternalTGG.g:272:1: ( rule__AttrCondDefLibrary__Group__0 )
            // InternalTGG.g:272:2: rule__AttrCondDefLibrary__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefLibraryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttrCondDefLibrary"


    // $ANTLR start "entryRuleAdornment"
    // InternalTGG.g:284:1: entryRuleAdornment : ruleAdornment EOF ;
    public final void entryRuleAdornment() throws RecognitionException {
        try {
            // InternalTGG.g:285:1: ( ruleAdornment EOF )
            // InternalTGG.g:286:1: ruleAdornment EOF
            {
             before(grammarAccess.getAdornmentRule()); 
            pushFollow(FOLLOW_1);
            ruleAdornment();

            state._fsp--;

             after(grammarAccess.getAdornmentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdornment"


    // $ANTLR start "ruleAdornment"
    // InternalTGG.g:293:1: ruleAdornment : ( ( rule__Adornment__Group__0 ) ) ;
    public final void ruleAdornment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:297:2: ( ( ( rule__Adornment__Group__0 ) ) )
            // InternalTGG.g:298:1: ( ( rule__Adornment__Group__0 ) )
            {
            // InternalTGG.g:298:1: ( ( rule__Adornment__Group__0 ) )
            // InternalTGG.g:299:1: ( rule__Adornment__Group__0 )
            {
             before(grammarAccess.getAdornmentAccess().getGroup()); 
            // InternalTGG.g:300:1: ( rule__Adornment__Group__0 )
            // InternalTGG.g:300:2: rule__Adornment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Adornment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdornmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdornment"


    // $ANTLR start "entryRuleParamValue"
    // InternalTGG.g:312:1: entryRuleParamValue : ruleParamValue EOF ;
    public final void entryRuleParamValue() throws RecognitionException {
        try {
            // InternalTGG.g:313:1: ( ruleParamValue EOF )
            // InternalTGG.g:314:1: ruleParamValue EOF
            {
             before(grammarAccess.getParamValueRule()); 
            pushFollow(FOLLOW_1);
            ruleParamValue();

            state._fsp--;

             after(grammarAccess.getParamValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParamValue"


    // $ANTLR start "ruleParamValue"
    // InternalTGG.g:321:1: ruleParamValue : ( ( rule__ParamValue__Alternatives ) ) ;
    public final void ruleParamValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:325:2: ( ( ( rule__ParamValue__Alternatives ) ) )
            // InternalTGG.g:326:1: ( ( rule__ParamValue__Alternatives ) )
            {
            // InternalTGG.g:326:1: ( ( rule__ParamValue__Alternatives ) )
            // InternalTGG.g:327:1: ( rule__ParamValue__Alternatives )
            {
             before(grammarAccess.getParamValueAccess().getAlternatives()); 
            // InternalTGG.g:328:1: ( rule__ParamValue__Alternatives )
            // InternalTGG.g:328:2: rule__ParamValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ParamValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParamValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParamValue"


    // $ANTLR start "entryRuleLocalVariable"
    // InternalTGG.g:340:1: entryRuleLocalVariable : ruleLocalVariable EOF ;
    public final void entryRuleLocalVariable() throws RecognitionException {
        try {
            // InternalTGG.g:341:1: ( ruleLocalVariable EOF )
            // InternalTGG.g:342:1: ruleLocalVariable EOF
            {
             before(grammarAccess.getLocalVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleLocalVariable();

            state._fsp--;

             after(grammarAccess.getLocalVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLocalVariable"


    // $ANTLR start "ruleLocalVariable"
    // InternalTGG.g:349:1: ruleLocalVariable : ( ( rule__LocalVariable__NameAssignment ) ) ;
    public final void ruleLocalVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:353:2: ( ( ( rule__LocalVariable__NameAssignment ) ) )
            // InternalTGG.g:354:1: ( ( rule__LocalVariable__NameAssignment ) )
            {
            // InternalTGG.g:354:1: ( ( rule__LocalVariable__NameAssignment ) )
            // InternalTGG.g:355:1: ( rule__LocalVariable__NameAssignment )
            {
             before(grammarAccess.getLocalVariableAccess().getNameAssignment()); 
            // InternalTGG.g:356:1: ( rule__LocalVariable__NameAssignment )
            // InternalTGG.g:356:2: rule__LocalVariable__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LocalVariable__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLocalVariableAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLocalVariable"


    // $ANTLR start "entryRuleCorrVariablePattern"
    // InternalTGG.g:368:1: entryRuleCorrVariablePattern : ruleCorrVariablePattern EOF ;
    public final void entryRuleCorrVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:369:1: ( ruleCorrVariablePattern EOF )
            // InternalTGG.g:370:1: ruleCorrVariablePattern EOF
            {
             before(grammarAccess.getCorrVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            ruleCorrVariablePattern();

            state._fsp--;

             after(grammarAccess.getCorrVariablePatternRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCorrVariablePattern"


    // $ANTLR start "ruleCorrVariablePattern"
    // InternalTGG.g:377:1: ruleCorrVariablePattern : ( ( rule__CorrVariablePattern__Group__0 ) ) ;
    public final void ruleCorrVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:381:2: ( ( ( rule__CorrVariablePattern__Group__0 ) ) )
            // InternalTGG.g:382:1: ( ( rule__CorrVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:382:1: ( ( rule__CorrVariablePattern__Group__0 ) )
            // InternalTGG.g:383:1: ( rule__CorrVariablePattern__Group__0 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getGroup()); 
            // InternalTGG.g:384:1: ( rule__CorrVariablePattern__Group__0 )
            // InternalTGG.g:384:2: rule__CorrVariablePattern__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCorrVariablePatternAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCorrVariablePattern"


    // $ANTLR start "entryRuleObjectVariablePattern"
    // InternalTGG.g:396:1: entryRuleObjectVariablePattern : ruleObjectVariablePattern EOF ;
    public final void entryRuleObjectVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:397:1: ( ruleObjectVariablePattern EOF )
            // InternalTGG.g:398:1: ruleObjectVariablePattern EOF
            {
             before(grammarAccess.getObjectVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            ruleObjectVariablePattern();

            state._fsp--;

             after(grammarAccess.getObjectVariablePatternRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleObjectVariablePattern"


    // $ANTLR start "ruleObjectVariablePattern"
    // InternalTGG.g:405:1: ruleObjectVariablePattern : ( ( rule__ObjectVariablePattern__Group__0 ) ) ;
    public final void ruleObjectVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:409:2: ( ( ( rule__ObjectVariablePattern__Group__0 ) ) )
            // InternalTGG.g:410:1: ( ( rule__ObjectVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:410:1: ( ( rule__ObjectVariablePattern__Group__0 ) )
            // InternalTGG.g:411:1: ( rule__ObjectVariablePattern__Group__0 )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getGroup()); 
            // InternalTGG.g:412:1: ( rule__ObjectVariablePattern__Group__0 )
            // InternalTGG.g:412:2: rule__ObjectVariablePattern__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getObjectVariablePatternAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleObjectVariablePattern"


    // $ANTLR start "entryRuleContextObjectVariablePattern"
    // InternalTGG.g:424:1: entryRuleContextObjectVariablePattern : ruleContextObjectVariablePattern EOF ;
    public final void entryRuleContextObjectVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:425:1: ( ruleContextObjectVariablePattern EOF )
            // InternalTGG.g:426:1: ruleContextObjectVariablePattern EOF
            {
             before(grammarAccess.getContextObjectVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            ruleContextObjectVariablePattern();

            state._fsp--;

             after(grammarAccess.getContextObjectVariablePatternRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContextObjectVariablePattern"


    // $ANTLR start "ruleContextObjectVariablePattern"
    // InternalTGG.g:433:1: ruleContextObjectVariablePattern : ( ( rule__ContextObjectVariablePattern__Group__0 ) ) ;
    public final void ruleContextObjectVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:437:2: ( ( ( rule__ContextObjectVariablePattern__Group__0 ) ) )
            // InternalTGG.g:438:1: ( ( rule__ContextObjectVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:438:1: ( ( rule__ContextObjectVariablePattern__Group__0 ) )
            // InternalTGG.g:439:1: ( rule__ContextObjectVariablePattern__Group__0 )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getGroup()); 
            // InternalTGG.g:440:1: ( rule__ContextObjectVariablePattern__Group__0 )
            // InternalTGG.g:440:2: rule__ContextObjectVariablePattern__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContextObjectVariablePatternAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContextObjectVariablePattern"


    // $ANTLR start "entryRuleAttributeConstraint"
    // InternalTGG.g:452:1: entryRuleAttributeConstraint : ruleAttributeConstraint EOF ;
    public final void entryRuleAttributeConstraint() throws RecognitionException {
        try {
            // InternalTGG.g:453:1: ( ruleAttributeConstraint EOF )
            // InternalTGG.g:454:1: ruleAttributeConstraint EOF
            {
             before(grammarAccess.getAttributeConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeConstraint();

            state._fsp--;

             after(grammarAccess.getAttributeConstraintRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeConstraint"


    // $ANTLR start "ruleAttributeConstraint"
    // InternalTGG.g:461:1: ruleAttributeConstraint : ( ( rule__AttributeConstraint__Group__0 ) ) ;
    public final void ruleAttributeConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:465:2: ( ( ( rule__AttributeConstraint__Group__0 ) ) )
            // InternalTGG.g:466:1: ( ( rule__AttributeConstraint__Group__0 ) )
            {
            // InternalTGG.g:466:1: ( ( rule__AttributeConstraint__Group__0 ) )
            // InternalTGG.g:467:1: ( rule__AttributeConstraint__Group__0 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getGroup()); 
            // InternalTGG.g:468:1: ( rule__AttributeConstraint__Group__0 )
            // InternalTGG.g:468:2: rule__AttributeConstraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeConstraint"


    // $ANTLR start "entryRuleAttributeAssignment"
    // InternalTGG.g:480:1: entryRuleAttributeAssignment : ruleAttributeAssignment EOF ;
    public final void entryRuleAttributeAssignment() throws RecognitionException {
        try {
            // InternalTGG.g:481:1: ( ruleAttributeAssignment EOF )
            // InternalTGG.g:482:1: ruleAttributeAssignment EOF
            {
             before(grammarAccess.getAttributeAssignmentRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeAssignment();

            state._fsp--;

             after(grammarAccess.getAttributeAssignmentRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeAssignment"


    // $ANTLR start "ruleAttributeAssignment"
    // InternalTGG.g:489:1: ruleAttributeAssignment : ( ( rule__AttributeAssignment__Group__0 ) ) ;
    public final void ruleAttributeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:493:2: ( ( ( rule__AttributeAssignment__Group__0 ) ) )
            // InternalTGG.g:494:1: ( ( rule__AttributeAssignment__Group__0 ) )
            {
            // InternalTGG.g:494:1: ( ( rule__AttributeAssignment__Group__0 ) )
            // InternalTGG.g:495:1: ( rule__AttributeAssignment__Group__0 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getGroup()); 
            // InternalTGG.g:496:1: ( rule__AttributeAssignment__Group__0 )
            // InternalTGG.g:496:2: rule__AttributeAssignment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeAssignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeAssignment"


    // $ANTLR start "entryRuleExpression"
    // InternalTGG.g:508:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalTGG.g:509:1: ( ruleExpression EOF )
            // InternalTGG.g:510:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalTGG.g:517:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:521:2: ( ( ( rule__Expression__Alternatives ) ) )
            // InternalTGG.g:522:1: ( ( rule__Expression__Alternatives ) )
            {
            // InternalTGG.g:522:1: ( ( rule__Expression__Alternatives ) )
            // InternalTGG.g:523:1: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // InternalTGG.g:524:1: ( rule__Expression__Alternatives )
            // InternalTGG.g:524:2: rule__Expression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleEnumExpression"
    // InternalTGG.g:536:1: entryRuleEnumExpression : ruleEnumExpression EOF ;
    public final void entryRuleEnumExpression() throws RecognitionException {
        try {
            // InternalTGG.g:537:1: ( ruleEnumExpression EOF )
            // InternalTGG.g:538:1: ruleEnumExpression EOF
            {
             before(grammarAccess.getEnumExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumExpression();

            state._fsp--;

             after(grammarAccess.getEnumExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumExpression"


    // $ANTLR start "ruleEnumExpression"
    // InternalTGG.g:545:1: ruleEnumExpression : ( ( rule__EnumExpression__Group__0 ) ) ;
    public final void ruleEnumExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:549:2: ( ( ( rule__EnumExpression__Group__0 ) ) )
            // InternalTGG.g:550:1: ( ( rule__EnumExpression__Group__0 ) )
            {
            // InternalTGG.g:550:1: ( ( rule__EnumExpression__Group__0 ) )
            // InternalTGG.g:551:1: ( rule__EnumExpression__Group__0 )
            {
             before(grammarAccess.getEnumExpressionAccess().getGroup()); 
            // InternalTGG.g:552:1: ( rule__EnumExpression__Group__0 )
            // InternalTGG.g:552:2: rule__EnumExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EnumExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumExpression"


    // $ANTLR start "entryRuleAttributeExpression"
    // InternalTGG.g:564:1: entryRuleAttributeExpression : ruleAttributeExpression EOF ;
    public final void entryRuleAttributeExpression() throws RecognitionException {
        try {
            // InternalTGG.g:565:1: ( ruleAttributeExpression EOF )
            // InternalTGG.g:566:1: ruleAttributeExpression EOF
            {
             before(grammarAccess.getAttributeExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleAttributeExpression();

            state._fsp--;

             after(grammarAccess.getAttributeExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttributeExpression"


    // $ANTLR start "ruleAttributeExpression"
    // InternalTGG.g:573:1: ruleAttributeExpression : ( ( rule__AttributeExpression__Group__0 ) ) ;
    public final void ruleAttributeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:577:2: ( ( ( rule__AttributeExpression__Group__0 ) ) )
            // InternalTGG.g:578:1: ( ( rule__AttributeExpression__Group__0 ) )
            {
            // InternalTGG.g:578:1: ( ( rule__AttributeExpression__Group__0 ) )
            // InternalTGG.g:579:1: ( rule__AttributeExpression__Group__0 )
            {
             before(grammarAccess.getAttributeExpressionAccess().getGroup()); 
            // InternalTGG.g:580:1: ( rule__AttributeExpression__Group__0 )
            // InternalTGG.g:580:2: rule__AttributeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttributeExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalTGG.g:592:1: entryRuleLiteralExpression : ruleLiteralExpression EOF ;
    public final void entryRuleLiteralExpression() throws RecognitionException {
        try {
            // InternalTGG.g:593:1: ( ruleLiteralExpression EOF )
            // InternalTGG.g:594:1: ruleLiteralExpression EOF
            {
             before(grammarAccess.getLiteralExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralExpression();

            state._fsp--;

             after(grammarAccess.getLiteralExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalTGG.g:601:1: ruleLiteralExpression : ( ( rule__LiteralExpression__ValueAssignment ) ) ;
    public final void ruleLiteralExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:605:2: ( ( ( rule__LiteralExpression__ValueAssignment ) ) )
            // InternalTGG.g:606:1: ( ( rule__LiteralExpression__ValueAssignment ) )
            {
            // InternalTGG.g:606:1: ( ( rule__LiteralExpression__ValueAssignment ) )
            // InternalTGG.g:607:1: ( rule__LiteralExpression__ValueAssignment )
            {
             before(grammarAccess.getLiteralExpressionAccess().getValueAssignment()); 
            // InternalTGG.g:608:1: ( rule__LiteralExpression__ValueAssignment )
            // InternalTGG.g:608:2: rule__LiteralExpression__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LiteralExpression__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralExpressionAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleLinkVariablePattern"
    // InternalTGG.g:620:1: entryRuleLinkVariablePattern : ruleLinkVariablePattern EOF ;
    public final void entryRuleLinkVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:621:1: ( ruleLinkVariablePattern EOF )
            // InternalTGG.g:622:1: ruleLinkVariablePattern EOF
            {
             before(grammarAccess.getLinkVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            ruleLinkVariablePattern();

            state._fsp--;

             after(grammarAccess.getLinkVariablePatternRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLinkVariablePattern"


    // $ANTLR start "ruleLinkVariablePattern"
    // InternalTGG.g:629:1: ruleLinkVariablePattern : ( ( rule__LinkVariablePattern__Group__0 ) ) ;
    public final void ruleLinkVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:633:2: ( ( ( rule__LinkVariablePattern__Group__0 ) ) )
            // InternalTGG.g:634:1: ( ( rule__LinkVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:634:1: ( ( rule__LinkVariablePattern__Group__0 ) )
            // InternalTGG.g:635:1: ( rule__LinkVariablePattern__Group__0 )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getGroup()); 
            // InternalTGG.g:636:1: ( rule__LinkVariablePattern__Group__0 )
            // InternalTGG.g:636:2: rule__LinkVariablePattern__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLinkVariablePatternAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLinkVariablePattern"


    // $ANTLR start "entryRuleContextLinkVariablePattern"
    // InternalTGG.g:648:1: entryRuleContextLinkVariablePattern : ruleContextLinkVariablePattern EOF ;
    public final void entryRuleContextLinkVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:649:1: ( ruleContextLinkVariablePattern EOF )
            // InternalTGG.g:650:1: ruleContextLinkVariablePattern EOF
            {
             before(grammarAccess.getContextLinkVariablePatternRule()); 
            pushFollow(FOLLOW_1);
            ruleContextLinkVariablePattern();

            state._fsp--;

             after(grammarAccess.getContextLinkVariablePatternRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleContextLinkVariablePattern"


    // $ANTLR start "ruleContextLinkVariablePattern"
    // InternalTGG.g:657:1: ruleContextLinkVariablePattern : ( ( rule__ContextLinkVariablePattern__Group__0 ) ) ;
    public final void ruleContextLinkVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:661:2: ( ( ( rule__ContextLinkVariablePattern__Group__0 ) ) )
            // InternalTGG.g:662:1: ( ( rule__ContextLinkVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:662:1: ( ( rule__ContextLinkVariablePattern__Group__0 ) )
            // InternalTGG.g:663:1: ( rule__ContextLinkVariablePattern__Group__0 )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getGroup()); 
            // InternalTGG.g:664:1: ( rule__ContextLinkVariablePattern__Group__0 )
            // InternalTGG.g:664:2: rule__ContextLinkVariablePattern__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ContextLinkVariablePattern__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContextLinkVariablePatternAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContextLinkVariablePattern"


    // $ANTLR start "entryRuleOperator"
    // InternalTGG.g:676:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalTGG.g:677:1: ( ruleOperator EOF )
            // InternalTGG.g:678:1: ruleOperator EOF
            {
             before(grammarAccess.getOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperator"


    // $ANTLR start "ruleOperator"
    // InternalTGG.g:685:1: ruleOperator : ( ( rule__Operator__ValueAssignment ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:689:2: ( ( ( rule__Operator__ValueAssignment ) ) )
            // InternalTGG.g:690:1: ( ( rule__Operator__ValueAssignment ) )
            {
            // InternalTGG.g:690:1: ( ( rule__Operator__ValueAssignment ) )
            // InternalTGG.g:691:1: ( rule__Operator__ValueAssignment )
            {
             before(grammarAccess.getOperatorAccess().getValueAssignment()); 
            // InternalTGG.g:692:1: ( rule__Operator__ValueAssignment )
            // InternalTGG.g:692:2: rule__Operator__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Operator__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getOperatorAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "entryRuleNac"
    // InternalTGG.g:704:1: entryRuleNac : ruleNac EOF ;
    public final void entryRuleNac() throws RecognitionException {
        try {
            // InternalTGG.g:705:1: ( ruleNac EOF )
            // InternalTGG.g:706:1: ruleNac EOF
            {
             before(grammarAccess.getNacRule()); 
            pushFollow(FOLLOW_1);
            ruleNac();

            state._fsp--;

             after(grammarAccess.getNacRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNac"


    // $ANTLR start "ruleNac"
    // InternalTGG.g:713:1: ruleNac : ( ( rule__Nac__Group__0 ) ) ;
    public final void ruleNac() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:717:2: ( ( ( rule__Nac__Group__0 ) ) )
            // InternalTGG.g:718:1: ( ( rule__Nac__Group__0 ) )
            {
            // InternalTGG.g:718:1: ( ( rule__Nac__Group__0 ) )
            // InternalTGG.g:719:1: ( rule__Nac__Group__0 )
            {
             before(grammarAccess.getNacAccess().getGroup()); 
            // InternalTGG.g:720:1: ( rule__Nac__Group__0 )
            // InternalTGG.g:720:2: rule__Nac__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Nac__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNacAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNac"


    // $ANTLR start "entryRuleImport"
    // InternalTGG.g:732:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalTGG.g:733:1: ( ruleImport EOF )
            // InternalTGG.g:734:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalTGG.g:741:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:745:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalTGG.g:746:1: ( ( rule__Import__Group__0 ) )
            {
            // InternalTGG.g:746:1: ( ( rule__Import__Group__0 ) )
            // InternalTGG.g:747:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalTGG.g:748:1: ( rule__Import__Group__0 )
            // InternalTGG.g:748:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleUsing"
    // InternalTGG.g:760:1: entryRuleUsing : ruleUsing EOF ;
    public final void entryRuleUsing() throws RecognitionException {
        try {
            // InternalTGG.g:761:1: ( ruleUsing EOF )
            // InternalTGG.g:762:1: ruleUsing EOF
            {
             before(grammarAccess.getUsingRule()); 
            pushFollow(FOLLOW_1);
            ruleUsing();

            state._fsp--;

             after(grammarAccess.getUsingRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUsing"


    // $ANTLR start "ruleUsing"
    // InternalTGG.g:769:1: ruleUsing : ( ( rule__Using__Group__0 ) ) ;
    public final void ruleUsing() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:773:2: ( ( ( rule__Using__Group__0 ) ) )
            // InternalTGG.g:774:1: ( ( rule__Using__Group__0 ) )
            {
            // InternalTGG.g:774:1: ( ( rule__Using__Group__0 ) )
            // InternalTGG.g:775:1: ( rule__Using__Group__0 )
            {
             before(grammarAccess.getUsingAccess().getGroup()); 
            // InternalTGG.g:776:1: ( rule__Using__Group__0 )
            // InternalTGG.g:776:2: rule__Using__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Using__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUsingAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUsing"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalTGG.g:788:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {
        try {
            // InternalTGG.g:789:1: ( ruleLiteralValue EOF )
            // InternalTGG.g:790:1: ruleLiteralValue EOF
            {
             before(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getLiteralValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // InternalTGG.g:797:1: ruleLiteralValue : ( ( rule__LiteralValue__Alternatives ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:801:2: ( ( ( rule__LiteralValue__Alternatives ) ) )
            // InternalTGG.g:802:1: ( ( rule__LiteralValue__Alternatives ) )
            {
            // InternalTGG.g:802:1: ( ( rule__LiteralValue__Alternatives ) )
            // InternalTGG.g:803:1: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalTGG.g:804:1: ( rule__LiteralValue__Alternatives )
            // InternalTGG.g:804:2: rule__LiteralValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__LiteralValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // InternalTGG.g:816:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // InternalTGG.g:817:1: ( ruleQualifiedNameWithWildcard EOF )
            // InternalTGG.g:818:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // InternalTGG.g:825:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:829:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // InternalTGG.g:830:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // InternalTGG.g:830:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // InternalTGG.g:831:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // InternalTGG.g:832:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // InternalTGG.g:832:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTGG.g:844:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalTGG.g:845:1: ( ruleQualifiedName EOF )
            // InternalTGG.g:846:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTGG.g:853:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:857:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalTGG.g:858:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalTGG.g:858:1: ( ( rule__QualifiedName__Group__0 ) )
            // InternalTGG.g:859:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalTGG.g:860:1: ( rule__QualifiedName__Group__0 )
            // InternalTGG.g:860:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleNamePattern"
    // InternalTGG.g:876:1: entryRuleNamePattern : ruleNamePattern EOF ;
    public final void entryRuleNamePattern() throws RecognitionException {
        try {
            // InternalTGG.g:877:1: ( ruleNamePattern EOF )
            // InternalTGG.g:878:1: ruleNamePattern EOF
            {
             before(grammarAccess.getNamePatternRule()); 
            pushFollow(FOLLOW_1);
            ruleNamePattern();

            state._fsp--;

             after(grammarAccess.getNamePatternRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamePattern"


    // $ANTLR start "ruleNamePattern"
    // InternalTGG.g:885:1: ruleNamePattern : ( ( rule__NamePattern__Alternatives ) ) ;
    public final void ruleNamePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:889:2: ( ( ( rule__NamePattern__Alternatives ) ) )
            // InternalTGG.g:890:1: ( ( rule__NamePattern__Alternatives ) )
            {
            // InternalTGG.g:890:1: ( ( rule__NamePattern__Alternatives ) )
            // InternalTGG.g:891:1: ( rule__NamePattern__Alternatives )
            {
             before(grammarAccess.getNamePatternAccess().getAlternatives()); 
            // InternalTGG.g:892:1: ( rule__NamePattern__Alternatives )
            // InternalTGG.g:892:2: rule__NamePattern__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NamePattern__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNamePatternAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamePattern"


    // $ANTLR start "rule__CorrType__Alternatives_1"
    // InternalTGG.g:904:1: rule__CorrType__Alternatives_1 : ( ( ( rule__CorrType__Group_1_0__0 ) ) | ( ( rule__CorrType__Group_1_1__0 ) ) );
    public final void rule__CorrType__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:908:1: ( ( ( rule__CorrType__Group_1_0__0 ) ) | ( ( rule__CorrType__Group_1_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==28) ) {
                alt1=1;
            }
            else if ( (LA1_0==23) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalTGG.g:909:1: ( ( rule__CorrType__Group_1_0__0 ) )
                    {
                    // InternalTGG.g:909:1: ( ( rule__CorrType__Group_1_0__0 ) )
                    // InternalTGG.g:910:1: ( rule__CorrType__Group_1_0__0 )
                    {
                     before(grammarAccess.getCorrTypeAccess().getGroup_1_0()); 
                    // InternalTGG.g:911:1: ( rule__CorrType__Group_1_0__0 )
                    // InternalTGG.g:911:2: rule__CorrType__Group_1_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CorrType__Group_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCorrTypeAccess().getGroup_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:915:6: ( ( rule__CorrType__Group_1_1__0 ) )
                    {
                    // InternalTGG.g:915:6: ( ( rule__CorrType__Group_1_1__0 ) )
                    // InternalTGG.g:916:1: ( rule__CorrType__Group_1_1__0 )
                    {
                     before(grammarAccess.getCorrTypeAccess().getGroup_1_1()); 
                    // InternalTGG.g:917:1: ( rule__CorrType__Group_1_1__0 )
                    // InternalTGG.g:917:2: rule__CorrType__Group_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CorrType__Group_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getCorrTypeAccess().getGroup_1_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Alternatives_1"


    // $ANTLR start "rule__Adornment__ValueAlternatives_1_0"
    // InternalTGG.g:926:1: rule__Adornment__ValueAlternatives_1_0 : ( ( 'B' ) | ( 'F' ) );
    public final void rule__Adornment__ValueAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:930:1: ( ( 'B' ) | ( 'F' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            else if ( (LA2_0==14) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalTGG.g:931:1: ( 'B' )
                    {
                    // InternalTGG.g:931:1: ( 'B' )
                    // InternalTGG.g:932:1: 'B'
                    {
                     before(grammarAccess.getAdornmentAccess().getValueBKeyword_1_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getAdornmentAccess().getValueBKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:939:6: ( 'F' )
                    {
                    // InternalTGG.g:939:6: ( 'F' )
                    // InternalTGG.g:940:1: 'F'
                    {
                     before(grammarAccess.getAdornmentAccess().getValueFKeyword_1_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getAdornmentAccess().getValueFKeyword_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__ValueAlternatives_1_0"


    // $ANTLR start "rule__ParamValue__Alternatives"
    // InternalTGG.g:952:1: rule__ParamValue__Alternatives : ( ( ruleLocalVariable ) | ( ruleExpression ) );
    public final void rule__ParamValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:956:1: ( ( ruleLocalVariable ) | ( ruleExpression ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==44) ) {
                    alt3=2;
                }
                else if ( (LA3_1==EOF||LA3_1==32||LA3_1==34) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_DECIMAL)||LA3_0==42||LA3_0==45||LA3_0==55) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalTGG.g:957:1: ( ruleLocalVariable )
                    {
                    // InternalTGG.g:957:1: ( ruleLocalVariable )
                    // InternalTGG.g:958:1: ruleLocalVariable
                    {
                     before(grammarAccess.getParamValueAccess().getLocalVariableParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleLocalVariable();

                    state._fsp--;

                     after(grammarAccess.getParamValueAccess().getLocalVariableParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:963:6: ( ruleExpression )
                    {
                    // InternalTGG.g:963:6: ( ruleExpression )
                    // InternalTGG.g:964:1: ruleExpression
                    {
                     before(grammarAccess.getParamValueAccess().getExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleExpression();

                    state._fsp--;

                     after(grammarAccess.getParamValueAccess().getExpressionParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParamValue__Alternatives"


    // $ANTLR start "rule__AttributeConstraint__OpAlternatives_1_0"
    // InternalTGG.g:974:1: rule__AttributeConstraint__OpAlternatives_1_0 : ( ( '==' ) | ( '!=' ) | ( '<=' ) | ( '>=' ) | ( '>' ) | ( '<' ) );
    public final void rule__AttributeConstraint__OpAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:978:1: ( ( '==' ) | ( '!=' ) | ( '<=' ) | ( '>=' ) | ( '>' ) | ( '<' ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            case 18:
                {
                alt4=4;
                }
                break;
            case 19:
                {
                alt4=5;
                }
                break;
            case 20:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalTGG.g:979:1: ( '==' )
                    {
                    // InternalTGG.g:979:1: ( '==' )
                    // InternalTGG.g:980:1: '=='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpEqualsSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpEqualsSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:987:6: ( '!=' )
                    {
                    // InternalTGG.g:987:6: ( '!=' )
                    // InternalTGG.g:988:1: '!='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTGG.g:995:6: ( '<=' )
                    {
                    // InternalTGG.g:995:6: ( '<=' )
                    // InternalTGG.g:996:1: '<='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpLessThanSignEqualsSignKeyword_1_0_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpLessThanSignEqualsSignKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTGG.g:1003:6: ( '>=' )
                    {
                    // InternalTGG.g:1003:6: ( '>=' )
                    // InternalTGG.g:1004:1: '>='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_3()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTGG.g:1011:6: ( '>' )
                    {
                    // InternalTGG.g:1011:6: ( '>' )
                    // InternalTGG.g:1012:1: '>'
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignKeyword_1_0_4()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalTGG.g:1019:6: ( '<' )
                    {
                    // InternalTGG.g:1019:6: ( '<' )
                    // InternalTGG.g:1020:1: '<'
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpLessThanSignKeyword_1_0_5()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpLessThanSignKeyword_1_0_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__OpAlternatives_1_0"


    // $ANTLR start "rule__Expression__Alternatives"
    // InternalTGG.g:1032:1: rule__Expression__Alternatives : ( ( ruleEnumExpression ) | ( ruleAttributeExpression ) | ( ruleLiteralExpression ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1036:1: ( ( ruleEnumExpression ) | ( ruleAttributeExpression ) | ( ruleLiteralExpression ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt5=1;
                }
                break;
            case RULE_ID:
            case 55:
                {
                alt5=2;
                }
                break;
            case RULE_STRING:
            case RULE_BOOL:
            case RULE_INT:
            case RULE_DECIMAL:
            case 45:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalTGG.g:1037:1: ( ruleEnumExpression )
                    {
                    // InternalTGG.g:1037:1: ( ruleEnumExpression )
                    // InternalTGG.g:1038:1: ruleEnumExpression
                    {
                     before(grammarAccess.getExpressionAccess().getEnumExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEnumExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getEnumExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:1043:6: ( ruleAttributeExpression )
                    {
                    // InternalTGG.g:1043:6: ( ruleAttributeExpression )
                    // InternalTGG.g:1044:1: ruleAttributeExpression
                    {
                     before(grammarAccess.getExpressionAccess().getAttributeExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleAttributeExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getAttributeExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTGG.g:1049:6: ( ruleLiteralExpression )
                    {
                    // InternalTGG.g:1049:6: ( ruleLiteralExpression )
                    // InternalTGG.g:1050:1: ruleLiteralExpression
                    {
                     before(grammarAccess.getExpressionAccess().getLiteralExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteralExpression();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getLiteralExpressionParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Expression__Alternatives"


    // $ANTLR start "rule__Nac__Alternatives_4"
    // InternalTGG.g:1060:1: rule__Nac__Alternatives_4 : ( ( ( rule__Nac__Group_4_0__0 ) ) | ( ( rule__Nac__Group_4_1__0 ) ) );
    public final void rule__Nac__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1064:1: ( ( ( rule__Nac__Group_4_0__0 ) ) | ( ( rule__Nac__Group_4_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            else if ( (LA6_0==25) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalTGG.g:1065:1: ( ( rule__Nac__Group_4_0__0 ) )
                    {
                    // InternalTGG.g:1065:1: ( ( rule__Nac__Group_4_0__0 ) )
                    // InternalTGG.g:1066:1: ( rule__Nac__Group_4_0__0 )
                    {
                     before(grammarAccess.getNacAccess().getGroup_4_0()); 
                    // InternalTGG.g:1067:1: ( rule__Nac__Group_4_0__0 )
                    // InternalTGG.g:1067:2: rule__Nac__Group_4_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Nac__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNacAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:1071:6: ( ( rule__Nac__Group_4_1__0 ) )
                    {
                    // InternalTGG.g:1071:6: ( ( rule__Nac__Group_4_1__0 ) )
                    // InternalTGG.g:1072:1: ( rule__Nac__Group_4_1__0 )
                    {
                     before(grammarAccess.getNacAccess().getGroup_4_1()); 
                    // InternalTGG.g:1073:1: ( rule__Nac__Group_4_1__0 )
                    // InternalTGG.g:1073:2: rule__Nac__Group_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Nac__Group_4_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getNacAccess().getGroup_4_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Alternatives_4"


    // $ANTLR start "rule__LiteralValue__Alternatives"
    // InternalTGG.g:1082:1: rule__LiteralValue__Alternatives : ( ( RULE_STRING ) | ( ( rule__LiteralValue__Group_1__0 ) ) | ( ( rule__LiteralValue__Group_2__0 ) ) | ( RULE_BOOL ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1086:1: ( ( RULE_STRING ) | ( ( rule__LiteralValue__Group_1__0 ) ) | ( ( rule__LiteralValue__Group_2__0 ) ) | ( RULE_BOOL ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt7=1;
                }
                break;
            case 45:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==RULE_DECIMAL) ) {
                    alt7=3;
                }
                else if ( (LA7_2==RULE_INT) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt7=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt7=3;
                }
                break;
            case RULE_BOOL:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalTGG.g:1087:1: ( RULE_STRING )
                    {
                    // InternalTGG.g:1087:1: ( RULE_STRING )
                    // InternalTGG.g:1088:1: RULE_STRING
                    {
                     before(grammarAccess.getLiteralValueAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:1093:6: ( ( rule__LiteralValue__Group_1__0 ) )
                    {
                    // InternalTGG.g:1093:6: ( ( rule__LiteralValue__Group_1__0 ) )
                    // InternalTGG.g:1094:1: ( rule__LiteralValue__Group_1__0 )
                    {
                     before(grammarAccess.getLiteralValueAccess().getGroup_1()); 
                    // InternalTGG.g:1095:1: ( rule__LiteralValue__Group_1__0 )
                    // InternalTGG.g:1095:2: rule__LiteralValue__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LiteralValue__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralValueAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTGG.g:1099:6: ( ( rule__LiteralValue__Group_2__0 ) )
                    {
                    // InternalTGG.g:1099:6: ( ( rule__LiteralValue__Group_2__0 ) )
                    // InternalTGG.g:1100:1: ( rule__LiteralValue__Group_2__0 )
                    {
                     before(grammarAccess.getLiteralValueAccess().getGroup_2()); 
                    // InternalTGG.g:1101:1: ( rule__LiteralValue__Group_2__0 )
                    // InternalTGG.g:1101:2: rule__LiteralValue__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LiteralValue__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLiteralValueAccess().getGroup_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTGG.g:1105:6: ( RULE_BOOL )
                    {
                    // InternalTGG.g:1105:6: ( RULE_BOOL )
                    // InternalTGG.g:1106:1: RULE_BOOL
                    {
                     before(grammarAccess.getLiteralValueAccess().getBOOLTerminalRuleCall_3()); 
                    match(input,RULE_BOOL,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getBOOLTerminalRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Alternatives"


    // $ANTLR start "rule__NamePattern__Alternatives"
    // InternalTGG.g:1118:1: rule__NamePattern__Alternatives : ( ( ruleCorrVariablePattern ) | ( ruleObjectVariablePattern ) );
    public final void rule__NamePattern__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1122:1: ( ( ruleCorrVariablePattern ) | ( ruleObjectVariablePattern ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalTGG.g:1123:1: ( ruleCorrVariablePattern )
                    {
                    // InternalTGG.g:1123:1: ( ruleCorrVariablePattern )
                    // InternalTGG.g:1124:1: ruleCorrVariablePattern
                    {
                     before(grammarAccess.getNamePatternAccess().getCorrVariablePatternParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleCorrVariablePattern();

                    state._fsp--;

                     after(grammarAccess.getNamePatternAccess().getCorrVariablePatternParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:1129:6: ( ruleObjectVariablePattern )
                    {
                    // InternalTGG.g:1129:6: ( ruleObjectVariablePattern )
                    // InternalTGG.g:1130:1: ruleObjectVariablePattern
                    {
                     before(grammarAccess.getNamePatternAccess().getObjectVariablePatternParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleObjectVariablePattern();

                    state._fsp--;

                     after(grammarAccess.getNamePatternAccess().getObjectVariablePatternParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamePattern__Alternatives"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__0"
    // InternalTGG.g:1142:1: rule__TripleGraphGrammarFile__Group__0 : rule__TripleGraphGrammarFile__Group__0__Impl rule__TripleGraphGrammarFile__Group__1 ;
    public final void rule__TripleGraphGrammarFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1146:1: ( rule__TripleGraphGrammarFile__Group__0__Impl rule__TripleGraphGrammarFile__Group__1 )
            // InternalTGG.g:1147:2: rule__TripleGraphGrammarFile__Group__0__Impl rule__TripleGraphGrammarFile__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__TripleGraphGrammarFile__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TripleGraphGrammarFile__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__0"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__0__Impl"
    // InternalTGG.g:1154:1: rule__TripleGraphGrammarFile__Group__0__Impl : ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* ) ;
    public final void rule__TripleGraphGrammarFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1158:1: ( ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* ) )
            // InternalTGG.g:1159:1: ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* )
            {
            // InternalTGG.g:1159:1: ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* )
            // InternalTGG.g:1160:1: ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )*
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getImportsAssignment_0()); 
            // InternalTGG.g:1161:1: ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==49) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalTGG.g:1161:2: rule__TripleGraphGrammarFile__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__TripleGraphGrammarFile__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getTripleGraphGrammarFileAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__0__Impl"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__1"
    // InternalTGG.g:1171:1: rule__TripleGraphGrammarFile__Group__1 : rule__TripleGraphGrammarFile__Group__1__Impl rule__TripleGraphGrammarFile__Group__2 ;
    public final void rule__TripleGraphGrammarFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1175:1: ( rule__TripleGraphGrammarFile__Group__1__Impl rule__TripleGraphGrammarFile__Group__2 )
            // InternalTGG.g:1176:2: rule__TripleGraphGrammarFile__Group__1__Impl rule__TripleGraphGrammarFile__Group__2
            {
            pushFollow(FOLLOW_3);
            rule__TripleGraphGrammarFile__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TripleGraphGrammarFile__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__1"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__1__Impl"
    // InternalTGG.g:1183:1: rule__TripleGraphGrammarFile__Group__1__Impl : ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* ) ;
    public final void rule__TripleGraphGrammarFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1187:1: ( ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* ) )
            // InternalTGG.g:1188:1: ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* )
            {
            // InternalTGG.g:1188:1: ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* )
            // InternalTGG.g:1189:1: ( rule__TripleGraphGrammarFile__UsingAssignment_1 )*
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getUsingAssignment_1()); 
            // InternalTGG.g:1190:1: ( rule__TripleGraphGrammarFile__UsingAssignment_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==50) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTGG.g:1190:2: rule__TripleGraphGrammarFile__UsingAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__TripleGraphGrammarFile__UsingAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getTripleGraphGrammarFileAccess().getUsingAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__1__Impl"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__2"
    // InternalTGG.g:1200:1: rule__TripleGraphGrammarFile__Group__2 : rule__TripleGraphGrammarFile__Group__2__Impl rule__TripleGraphGrammarFile__Group__3 ;
    public final void rule__TripleGraphGrammarFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1204:1: ( rule__TripleGraphGrammarFile__Group__2__Impl rule__TripleGraphGrammarFile__Group__3 )
            // InternalTGG.g:1205:2: rule__TripleGraphGrammarFile__Group__2__Impl rule__TripleGraphGrammarFile__Group__3
            {
            pushFollow(FOLLOW_3);
            rule__TripleGraphGrammarFile__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TripleGraphGrammarFile__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__2"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__2__Impl"
    // InternalTGG.g:1212:1: rule__TripleGraphGrammarFile__Group__2__Impl : ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? ) ;
    public final void rule__TripleGraphGrammarFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1216:1: ( ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? ) )
            // InternalTGG.g:1217:1: ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? )
            {
            // InternalTGG.g:1217:1: ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? )
            // InternalTGG.g:1218:1: ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )?
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getSchemaAssignment_2()); 
            // InternalTGG.g:1219:1: ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTGG.g:1219:2: rule__TripleGraphGrammarFile__SchemaAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__TripleGraphGrammarFile__SchemaAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTripleGraphGrammarFileAccess().getSchemaAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__2__Impl"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__3"
    // InternalTGG.g:1229:1: rule__TripleGraphGrammarFile__Group__3 : rule__TripleGraphGrammarFile__Group__3__Impl rule__TripleGraphGrammarFile__Group__4 ;
    public final void rule__TripleGraphGrammarFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1233:1: ( rule__TripleGraphGrammarFile__Group__3__Impl rule__TripleGraphGrammarFile__Group__4 )
            // InternalTGG.g:1234:2: rule__TripleGraphGrammarFile__Group__3__Impl rule__TripleGraphGrammarFile__Group__4
            {
            pushFollow(FOLLOW_3);
            rule__TripleGraphGrammarFile__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TripleGraphGrammarFile__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__3"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__3__Impl"
    // InternalTGG.g:1241:1: rule__TripleGraphGrammarFile__Group__3__Impl : ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* ) ;
    public final void rule__TripleGraphGrammarFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1245:1: ( ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* ) )
            // InternalTGG.g:1246:1: ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* )
            {
            // InternalTGG.g:1246:1: ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* )
            // InternalTGG.g:1247:1: ( rule__TripleGraphGrammarFile__RulesAssignment_3 )*
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getRulesAssignment_3()); 
            // InternalTGG.g:1248:1: ( rule__TripleGraphGrammarFile__RulesAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==37||LA12_0==53) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTGG.g:1248:2: rule__TripleGraphGrammarFile__RulesAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__TripleGraphGrammarFile__RulesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getTripleGraphGrammarFileAccess().getRulesAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__3__Impl"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__4"
    // InternalTGG.g:1258:1: rule__TripleGraphGrammarFile__Group__4 : rule__TripleGraphGrammarFile__Group__4__Impl ;
    public final void rule__TripleGraphGrammarFile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1262:1: ( rule__TripleGraphGrammarFile__Group__4__Impl )
            // InternalTGG.g:1263:2: rule__TripleGraphGrammarFile__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TripleGraphGrammarFile__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__4"


    // $ANTLR start "rule__TripleGraphGrammarFile__Group__4__Impl"
    // InternalTGG.g:1269:1: rule__TripleGraphGrammarFile__Group__4__Impl : ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? ) ;
    public final void rule__TripleGraphGrammarFile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1273:1: ( ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? ) )
            // InternalTGG.g:1274:1: ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? )
            {
            // InternalTGG.g:1274:1: ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? )
            // InternalTGG.g:1275:1: ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )?
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getLibraryAssignment_4()); 
            // InternalTGG.g:1276:1: ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==39) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTGG.g:1276:2: rule__TripleGraphGrammarFile__LibraryAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__TripleGraphGrammarFile__LibraryAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTripleGraphGrammarFileAccess().getLibraryAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__Group__4__Impl"


    // $ANTLR start "rule__Schema__Group__0"
    // InternalTGG.g:1296:1: rule__Schema__Group__0 : rule__Schema__Group__0__Impl rule__Schema__Group__1 ;
    public final void rule__Schema__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1300:1: ( rule__Schema__Group__0__Impl rule__Schema__Group__1 )
            // InternalTGG.g:1301:2: rule__Schema__Group__0__Impl rule__Schema__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Schema__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__0"


    // $ANTLR start "rule__Schema__Group__0__Impl"
    // InternalTGG.g:1308:1: rule__Schema__Group__0__Impl : ( '#schema' ) ;
    public final void rule__Schema__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1312:1: ( ( '#schema' ) )
            // InternalTGG.g:1313:1: ( '#schema' )
            {
            // InternalTGG.g:1313:1: ( '#schema' )
            // InternalTGG.g:1314:1: '#schema'
            {
             before(grammarAccess.getSchemaAccess().getSchemaKeyword_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getSchemaKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__0__Impl"


    // $ANTLR start "rule__Schema__Group__1"
    // InternalTGG.g:1327:1: rule__Schema__Group__1 : rule__Schema__Group__1__Impl rule__Schema__Group__2 ;
    public final void rule__Schema__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1331:1: ( rule__Schema__Group__1__Impl rule__Schema__Group__2 )
            // InternalTGG.g:1332:2: rule__Schema__Group__1__Impl rule__Schema__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Schema__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__1"


    // $ANTLR start "rule__Schema__Group__1__Impl"
    // InternalTGG.g:1339:1: rule__Schema__Group__1__Impl : ( ( rule__Schema__NameAssignment_1 ) ) ;
    public final void rule__Schema__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1343:1: ( ( ( rule__Schema__NameAssignment_1 ) ) )
            // InternalTGG.g:1344:1: ( ( rule__Schema__NameAssignment_1 ) )
            {
            // InternalTGG.g:1344:1: ( ( rule__Schema__NameAssignment_1 ) )
            // InternalTGG.g:1345:1: ( rule__Schema__NameAssignment_1 )
            {
             before(grammarAccess.getSchemaAccess().getNameAssignment_1()); 
            // InternalTGG.g:1346:1: ( rule__Schema__NameAssignment_1 )
            // InternalTGG.g:1346:2: rule__Schema__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Schema__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSchemaAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__1__Impl"


    // $ANTLR start "rule__Schema__Group__2"
    // InternalTGG.g:1356:1: rule__Schema__Group__2 : rule__Schema__Group__2__Impl rule__Schema__Group__3 ;
    public final void rule__Schema__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1360:1: ( rule__Schema__Group__2__Impl rule__Schema__Group__3 )
            // InternalTGG.g:1361:2: rule__Schema__Group__2__Impl rule__Schema__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Schema__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__2"


    // $ANTLR start "rule__Schema__Group__2__Impl"
    // InternalTGG.g:1368:1: rule__Schema__Group__2__Impl : ( ( rule__Schema__Group_2__0 )? ) ;
    public final void rule__Schema__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1372:1: ( ( ( rule__Schema__Group_2__0 )? ) )
            // InternalTGG.g:1373:1: ( ( rule__Schema__Group_2__0 )? )
            {
            // InternalTGG.g:1373:1: ( ( rule__Schema__Group_2__0 )? )
            // InternalTGG.g:1374:1: ( rule__Schema__Group_2__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_2()); 
            // InternalTGG.g:1375:1: ( rule__Schema__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTGG.g:1375:2: rule__Schema__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Schema__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSchemaAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__2__Impl"


    // $ANTLR start "rule__Schema__Group__3"
    // InternalTGG.g:1385:1: rule__Schema__Group__3 : rule__Schema__Group__3__Impl rule__Schema__Group__4 ;
    public final void rule__Schema__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1389:1: ( rule__Schema__Group__3__Impl rule__Schema__Group__4 )
            // InternalTGG.g:1390:2: rule__Schema__Group__3__Impl rule__Schema__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__Schema__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__3"


    // $ANTLR start "rule__Schema__Group__3__Impl"
    // InternalTGG.g:1397:1: rule__Schema__Group__3__Impl : ( ( rule__Schema__Group_3__0 )? ) ;
    public final void rule__Schema__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1401:1: ( ( ( rule__Schema__Group_3__0 )? ) )
            // InternalTGG.g:1402:1: ( ( rule__Schema__Group_3__0 )? )
            {
            // InternalTGG.g:1402:1: ( ( rule__Schema__Group_3__0 )? )
            // InternalTGG.g:1403:1: ( rule__Schema__Group_3__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_3()); 
            // InternalTGG.g:1404:1: ( rule__Schema__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTGG.g:1404:2: rule__Schema__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Schema__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSchemaAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__3__Impl"


    // $ANTLR start "rule__Schema__Group__4"
    // InternalTGG.g:1414:1: rule__Schema__Group__4 : rule__Schema__Group__4__Impl rule__Schema__Group__5 ;
    public final void rule__Schema__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1418:1: ( rule__Schema__Group__4__Impl rule__Schema__Group__5 )
            // InternalTGG.g:1419:2: rule__Schema__Group__4__Impl rule__Schema__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Schema__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__4"


    // $ANTLR start "rule__Schema__Group__4__Impl"
    // InternalTGG.g:1426:1: rule__Schema__Group__4__Impl : ( ( rule__Schema__Group_4__0 )? ) ;
    public final void rule__Schema__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1430:1: ( ( ( rule__Schema__Group_4__0 )? ) )
            // InternalTGG.g:1431:1: ( ( rule__Schema__Group_4__0 )? )
            {
            // InternalTGG.g:1431:1: ( ( rule__Schema__Group_4__0 )? )
            // InternalTGG.g:1432:1: ( rule__Schema__Group_4__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_4()); 
            // InternalTGG.g:1433:1: ( rule__Schema__Group_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTGG.g:1433:2: rule__Schema__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Schema__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSchemaAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__4__Impl"


    // $ANTLR start "rule__Schema__Group__5"
    // InternalTGG.g:1443:1: rule__Schema__Group__5 : rule__Schema__Group__5__Impl ;
    public final void rule__Schema__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1447:1: ( rule__Schema__Group__5__Impl )
            // InternalTGG.g:1448:2: rule__Schema__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Schema__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__5"


    // $ANTLR start "rule__Schema__Group__5__Impl"
    // InternalTGG.g:1454:1: rule__Schema__Group__5__Impl : ( ( rule__Schema__Group_5__0 )? ) ;
    public final void rule__Schema__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1458:1: ( ( ( rule__Schema__Group_5__0 )? ) )
            // InternalTGG.g:1459:1: ( ( rule__Schema__Group_5__0 )? )
            {
            // InternalTGG.g:1459:1: ( ( rule__Schema__Group_5__0 )? )
            // InternalTGG.g:1460:1: ( rule__Schema__Group_5__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_5()); 
            // InternalTGG.g:1461:1: ( rule__Schema__Group_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTGG.g:1461:2: rule__Schema__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Schema__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSchemaAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__5__Impl"


    // $ANTLR start "rule__Schema__Group_2__0"
    // InternalTGG.g:1483:1: rule__Schema__Group_2__0 : rule__Schema__Group_2__0__Impl rule__Schema__Group_2__1 ;
    public final void rule__Schema__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1487:1: ( rule__Schema__Group_2__0__Impl rule__Schema__Group_2__1 )
            // InternalTGG.g:1488:2: rule__Schema__Group_2__0__Impl rule__Schema__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__Schema__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__0"


    // $ANTLR start "rule__Schema__Group_2__0__Impl"
    // InternalTGG.g:1495:1: rule__Schema__Group_2__0__Impl : ( '#source' ) ;
    public final void rule__Schema__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1499:1: ( ( '#source' ) )
            // InternalTGG.g:1500:1: ( '#source' )
            {
            // InternalTGG.g:1500:1: ( '#source' )
            // InternalTGG.g:1501:1: '#source'
            {
             before(grammarAccess.getSchemaAccess().getSourceKeyword_2_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getSourceKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__0__Impl"


    // $ANTLR start "rule__Schema__Group_2__1"
    // InternalTGG.g:1514:1: rule__Schema__Group_2__1 : rule__Schema__Group_2__1__Impl rule__Schema__Group_2__2 ;
    public final void rule__Schema__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1518:1: ( rule__Schema__Group_2__1__Impl rule__Schema__Group_2__2 )
            // InternalTGG.g:1519:2: rule__Schema__Group_2__1__Impl rule__Schema__Group_2__2
            {
            pushFollow(FOLLOW_10);
            rule__Schema__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__1"


    // $ANTLR start "rule__Schema__Group_2__1__Impl"
    // InternalTGG.g:1526:1: rule__Schema__Group_2__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1530:1: ( ( '{' ) )
            // InternalTGG.g:1531:1: ( '{' )
            {
            // InternalTGG.g:1531:1: ( '{' )
            // InternalTGG.g:1532:1: '{'
            {
             before(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_2_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__1__Impl"


    // $ANTLR start "rule__Schema__Group_2__2"
    // InternalTGG.g:1545:1: rule__Schema__Group_2__2 : rule__Schema__Group_2__2__Impl rule__Schema__Group_2__3 ;
    public final void rule__Schema__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1549:1: ( rule__Schema__Group_2__2__Impl rule__Schema__Group_2__3 )
            // InternalTGG.g:1550:2: rule__Schema__Group_2__2__Impl rule__Schema__Group_2__3
            {
            pushFollow(FOLLOW_10);
            rule__Schema__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__2"


    // $ANTLR start "rule__Schema__Group_2__2__Impl"
    // InternalTGG.g:1557:1: rule__Schema__Group_2__2__Impl : ( ( rule__Schema__SourceTypesAssignment_2_2 )* ) ;
    public final void rule__Schema__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1561:1: ( ( ( rule__Schema__SourceTypesAssignment_2_2 )* ) )
            // InternalTGG.g:1562:1: ( ( rule__Schema__SourceTypesAssignment_2_2 )* )
            {
            // InternalTGG.g:1562:1: ( ( rule__Schema__SourceTypesAssignment_2_2 )* )
            // InternalTGG.g:1563:1: ( rule__Schema__SourceTypesAssignment_2_2 )*
            {
             before(grammarAccess.getSchemaAccess().getSourceTypesAssignment_2_2()); 
            // InternalTGG.g:1564:1: ( rule__Schema__SourceTypesAssignment_2_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTGG.g:1564:2: rule__Schema__SourceTypesAssignment_2_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Schema__SourceTypesAssignment_2_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getSchemaAccess().getSourceTypesAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__2__Impl"


    // $ANTLR start "rule__Schema__Group_2__3"
    // InternalTGG.g:1574:1: rule__Schema__Group_2__3 : rule__Schema__Group_2__3__Impl ;
    public final void rule__Schema__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1578:1: ( rule__Schema__Group_2__3__Impl )
            // InternalTGG.g:1579:2: rule__Schema__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Schema__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__3"


    // $ANTLR start "rule__Schema__Group_2__3__Impl"
    // InternalTGG.g:1585:1: rule__Schema__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1589:1: ( ( '}' ) )
            // InternalTGG.g:1590:1: ( '}' )
            {
            // InternalTGG.g:1590:1: ( '}' )
            // InternalTGG.g:1591:1: '}'
            {
             before(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_2_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_2__3__Impl"


    // $ANTLR start "rule__Schema__Group_3__0"
    // InternalTGG.g:1612:1: rule__Schema__Group_3__0 : rule__Schema__Group_3__0__Impl rule__Schema__Group_3__1 ;
    public final void rule__Schema__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1616:1: ( rule__Schema__Group_3__0__Impl rule__Schema__Group_3__1 )
            // InternalTGG.g:1617:2: rule__Schema__Group_3__0__Impl rule__Schema__Group_3__1
            {
            pushFollow(FOLLOW_9);
            rule__Schema__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__0"


    // $ANTLR start "rule__Schema__Group_3__0__Impl"
    // InternalTGG.g:1624:1: rule__Schema__Group_3__0__Impl : ( '#target' ) ;
    public final void rule__Schema__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1628:1: ( ( '#target' ) )
            // InternalTGG.g:1629:1: ( '#target' )
            {
            // InternalTGG.g:1629:1: ( '#target' )
            // InternalTGG.g:1630:1: '#target'
            {
             before(grammarAccess.getSchemaAccess().getTargetKeyword_3_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getTargetKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__0__Impl"


    // $ANTLR start "rule__Schema__Group_3__1"
    // InternalTGG.g:1643:1: rule__Schema__Group_3__1 : rule__Schema__Group_3__1__Impl rule__Schema__Group_3__2 ;
    public final void rule__Schema__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1647:1: ( rule__Schema__Group_3__1__Impl rule__Schema__Group_3__2 )
            // InternalTGG.g:1648:2: rule__Schema__Group_3__1__Impl rule__Schema__Group_3__2
            {
            pushFollow(FOLLOW_10);
            rule__Schema__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__1"


    // $ANTLR start "rule__Schema__Group_3__1__Impl"
    // InternalTGG.g:1655:1: rule__Schema__Group_3__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1659:1: ( ( '{' ) )
            // InternalTGG.g:1660:1: ( '{' )
            {
            // InternalTGG.g:1660:1: ( '{' )
            // InternalTGG.g:1661:1: '{'
            {
             before(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_3_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__1__Impl"


    // $ANTLR start "rule__Schema__Group_3__2"
    // InternalTGG.g:1674:1: rule__Schema__Group_3__2 : rule__Schema__Group_3__2__Impl rule__Schema__Group_3__3 ;
    public final void rule__Schema__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1678:1: ( rule__Schema__Group_3__2__Impl rule__Schema__Group_3__3 )
            // InternalTGG.g:1679:2: rule__Schema__Group_3__2__Impl rule__Schema__Group_3__3
            {
            pushFollow(FOLLOW_10);
            rule__Schema__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__2"


    // $ANTLR start "rule__Schema__Group_3__2__Impl"
    // InternalTGG.g:1686:1: rule__Schema__Group_3__2__Impl : ( ( rule__Schema__TargetTypesAssignment_3_2 )* ) ;
    public final void rule__Schema__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1690:1: ( ( ( rule__Schema__TargetTypesAssignment_3_2 )* ) )
            // InternalTGG.g:1691:1: ( ( rule__Schema__TargetTypesAssignment_3_2 )* )
            {
            // InternalTGG.g:1691:1: ( ( rule__Schema__TargetTypesAssignment_3_2 )* )
            // InternalTGG.g:1692:1: ( rule__Schema__TargetTypesAssignment_3_2 )*
            {
             before(grammarAccess.getSchemaAccess().getTargetTypesAssignment_3_2()); 
            // InternalTGG.g:1693:1: ( rule__Schema__TargetTypesAssignment_3_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTGG.g:1693:2: rule__Schema__TargetTypesAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Schema__TargetTypesAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getSchemaAccess().getTargetTypesAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__2__Impl"


    // $ANTLR start "rule__Schema__Group_3__3"
    // InternalTGG.g:1703:1: rule__Schema__Group_3__3 : rule__Schema__Group_3__3__Impl ;
    public final void rule__Schema__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1707:1: ( rule__Schema__Group_3__3__Impl )
            // InternalTGG.g:1708:2: rule__Schema__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Schema__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__3"


    // $ANTLR start "rule__Schema__Group_3__3__Impl"
    // InternalTGG.g:1714:1: rule__Schema__Group_3__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1718:1: ( ( '}' ) )
            // InternalTGG.g:1719:1: ( '}' )
            {
            // InternalTGG.g:1719:1: ( '}' )
            // InternalTGG.g:1720:1: '}'
            {
             before(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_3_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_3__3__Impl"


    // $ANTLR start "rule__Schema__Group_4__0"
    // InternalTGG.g:1741:1: rule__Schema__Group_4__0 : rule__Schema__Group_4__0__Impl rule__Schema__Group_4__1 ;
    public final void rule__Schema__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1745:1: ( rule__Schema__Group_4__0__Impl rule__Schema__Group_4__1 )
            // InternalTGG.g:1746:2: rule__Schema__Group_4__0__Impl rule__Schema__Group_4__1
            {
            pushFollow(FOLLOW_9);
            rule__Schema__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__0"


    // $ANTLR start "rule__Schema__Group_4__0__Impl"
    // InternalTGG.g:1753:1: rule__Schema__Group_4__0__Impl : ( '#correspondence' ) ;
    public final void rule__Schema__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1757:1: ( ( '#correspondence' ) )
            // InternalTGG.g:1758:1: ( '#correspondence' )
            {
            // InternalTGG.g:1758:1: ( '#correspondence' )
            // InternalTGG.g:1759:1: '#correspondence'
            {
             before(grammarAccess.getSchemaAccess().getCorrespondenceKeyword_4_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getCorrespondenceKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__0__Impl"


    // $ANTLR start "rule__Schema__Group_4__1"
    // InternalTGG.g:1772:1: rule__Schema__Group_4__1 : rule__Schema__Group_4__1__Impl rule__Schema__Group_4__2 ;
    public final void rule__Schema__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1776:1: ( rule__Schema__Group_4__1__Impl rule__Schema__Group_4__2 )
            // InternalTGG.g:1777:2: rule__Schema__Group_4__1__Impl rule__Schema__Group_4__2
            {
            pushFollow(FOLLOW_10);
            rule__Schema__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__1"


    // $ANTLR start "rule__Schema__Group_4__1__Impl"
    // InternalTGG.g:1784:1: rule__Schema__Group_4__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1788:1: ( ( '{' ) )
            // InternalTGG.g:1789:1: ( '{' )
            {
            // InternalTGG.g:1789:1: ( '{' )
            // InternalTGG.g:1790:1: '{'
            {
             before(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_4_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__1__Impl"


    // $ANTLR start "rule__Schema__Group_4__2"
    // InternalTGG.g:1803:1: rule__Schema__Group_4__2 : rule__Schema__Group_4__2__Impl rule__Schema__Group_4__3 ;
    public final void rule__Schema__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1807:1: ( rule__Schema__Group_4__2__Impl rule__Schema__Group_4__3 )
            // InternalTGG.g:1808:2: rule__Schema__Group_4__2__Impl rule__Schema__Group_4__3
            {
            pushFollow(FOLLOW_10);
            rule__Schema__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__2"


    // $ANTLR start "rule__Schema__Group_4__2__Impl"
    // InternalTGG.g:1815:1: rule__Schema__Group_4__2__Impl : ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* ) ;
    public final void rule__Schema__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1819:1: ( ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* ) )
            // InternalTGG.g:1820:1: ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* )
            {
            // InternalTGG.g:1820:1: ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* )
            // InternalTGG.g:1821:1: ( rule__Schema__CorrespondenceTypesAssignment_4_2 )*
            {
             before(grammarAccess.getSchemaAccess().getCorrespondenceTypesAssignment_4_2()); 
            // InternalTGG.g:1822:1: ( rule__Schema__CorrespondenceTypesAssignment_4_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalTGG.g:1822:2: rule__Schema__CorrespondenceTypesAssignment_4_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Schema__CorrespondenceTypesAssignment_4_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getSchemaAccess().getCorrespondenceTypesAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__2__Impl"


    // $ANTLR start "rule__Schema__Group_4__3"
    // InternalTGG.g:1832:1: rule__Schema__Group_4__3 : rule__Schema__Group_4__3__Impl ;
    public final void rule__Schema__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1836:1: ( rule__Schema__Group_4__3__Impl )
            // InternalTGG.g:1837:2: rule__Schema__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Schema__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__3"


    // $ANTLR start "rule__Schema__Group_4__3__Impl"
    // InternalTGG.g:1843:1: rule__Schema__Group_4__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1847:1: ( ( '}' ) )
            // InternalTGG.g:1848:1: ( '}' )
            {
            // InternalTGG.g:1848:1: ( '}' )
            // InternalTGG.g:1849:1: '}'
            {
             before(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_4_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_4__3__Impl"


    // $ANTLR start "rule__Schema__Group_5__0"
    // InternalTGG.g:1870:1: rule__Schema__Group_5__0 : rule__Schema__Group_5__0__Impl rule__Schema__Group_5__1 ;
    public final void rule__Schema__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1874:1: ( rule__Schema__Group_5__0__Impl rule__Schema__Group_5__1 )
            // InternalTGG.g:1875:2: rule__Schema__Group_5__0__Impl rule__Schema__Group_5__1
            {
            pushFollow(FOLLOW_9);
            rule__Schema__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__0"


    // $ANTLR start "rule__Schema__Group_5__0__Impl"
    // InternalTGG.g:1882:1: rule__Schema__Group_5__0__Impl : ( '#attributeConditions' ) ;
    public final void rule__Schema__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1886:1: ( ( '#attributeConditions' ) )
            // InternalTGG.g:1887:1: ( '#attributeConditions' )
            {
            // InternalTGG.g:1887:1: ( '#attributeConditions' )
            // InternalTGG.g:1888:1: '#attributeConditions'
            {
             before(grammarAccess.getSchemaAccess().getAttributeConditionsKeyword_5_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getAttributeConditionsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__0__Impl"


    // $ANTLR start "rule__Schema__Group_5__1"
    // InternalTGG.g:1901:1: rule__Schema__Group_5__1 : rule__Schema__Group_5__1__Impl rule__Schema__Group_5__2 ;
    public final void rule__Schema__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1905:1: ( rule__Schema__Group_5__1__Impl rule__Schema__Group_5__2 )
            // InternalTGG.g:1906:2: rule__Schema__Group_5__1__Impl rule__Schema__Group_5__2
            {
            pushFollow(FOLLOW_12);
            rule__Schema__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__1"


    // $ANTLR start "rule__Schema__Group_5__1__Impl"
    // InternalTGG.g:1913:1: rule__Schema__Group_5__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1917:1: ( ( '{' ) )
            // InternalTGG.g:1918:1: ( '{' )
            {
            // InternalTGG.g:1918:1: ( '{' )
            // InternalTGG.g:1919:1: '{'
            {
             before(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_5_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getLeftCurlyBracketKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__1__Impl"


    // $ANTLR start "rule__Schema__Group_5__2"
    // InternalTGG.g:1932:1: rule__Schema__Group_5__2 : rule__Schema__Group_5__2__Impl rule__Schema__Group_5__3 ;
    public final void rule__Schema__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1936:1: ( rule__Schema__Group_5__2__Impl rule__Schema__Group_5__3 )
            // InternalTGG.g:1937:2: rule__Schema__Group_5__2__Impl rule__Schema__Group_5__3
            {
            pushFollow(FOLLOW_12);
            rule__Schema__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Schema__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__2"


    // $ANTLR start "rule__Schema__Group_5__2__Impl"
    // InternalTGG.g:1944:1: rule__Schema__Group_5__2__Impl : ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* ) ;
    public final void rule__Schema__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1948:1: ( ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* ) )
            // InternalTGG.g:1949:1: ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* )
            {
            // InternalTGG.g:1949:1: ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* )
            // InternalTGG.g:1950:1: ( rule__Schema__AttributeCondDefsAssignment_5_2 )*
            {
             before(grammarAccess.getSchemaAccess().getAttributeCondDefsAssignment_5_2()); 
            // InternalTGG.g:1951:1: ( rule__Schema__AttributeCondDefsAssignment_5_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID||LA21_0==52) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalTGG.g:1951:2: rule__Schema__AttributeCondDefsAssignment_5_2
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Schema__AttributeCondDefsAssignment_5_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getSchemaAccess().getAttributeCondDefsAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__2__Impl"


    // $ANTLR start "rule__Schema__Group_5__3"
    // InternalTGG.g:1961:1: rule__Schema__Group_5__3 : rule__Schema__Group_5__3__Impl ;
    public final void rule__Schema__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1965:1: ( rule__Schema__Group_5__3__Impl )
            // InternalTGG.g:1966:2: rule__Schema__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Schema__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__3"


    // $ANTLR start "rule__Schema__Group_5__3__Impl"
    // InternalTGG.g:1972:1: rule__Schema__Group_5__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:1976:1: ( ( '}' ) )
            // InternalTGG.g:1977:1: ( '}' )
            {
            // InternalTGG.g:1977:1: ( '}' )
            // InternalTGG.g:1978:1: '}'
            {
             before(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_5_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getSchemaAccess().getRightCurlyBracketKeyword_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_5__3__Impl"


    // $ANTLR start "rule__CorrType__Group__0"
    // InternalTGG.g:1999:1: rule__CorrType__Group__0 : rule__CorrType__Group__0__Impl rule__CorrType__Group__1 ;
    public final void rule__CorrType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2003:1: ( rule__CorrType__Group__0__Impl rule__CorrType__Group__1 )
            // InternalTGG.g:2004:2: rule__CorrType__Group__0__Impl rule__CorrType__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__CorrType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group__0"


    // $ANTLR start "rule__CorrType__Group__0__Impl"
    // InternalTGG.g:2011:1: rule__CorrType__Group__0__Impl : ( ( rule__CorrType__NameAssignment_0 ) ) ;
    public final void rule__CorrType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2015:1: ( ( ( rule__CorrType__NameAssignment_0 ) ) )
            // InternalTGG.g:2016:1: ( ( rule__CorrType__NameAssignment_0 ) )
            {
            // InternalTGG.g:2016:1: ( ( rule__CorrType__NameAssignment_0 ) )
            // InternalTGG.g:2017:1: ( rule__CorrType__NameAssignment_0 )
            {
             before(grammarAccess.getCorrTypeAccess().getNameAssignment_0()); 
            // InternalTGG.g:2018:1: ( rule__CorrType__NameAssignment_0 )
            // InternalTGG.g:2018:2: rule__CorrType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCorrTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group__0__Impl"


    // $ANTLR start "rule__CorrType__Group__1"
    // InternalTGG.g:2028:1: rule__CorrType__Group__1 : rule__CorrType__Group__1__Impl ;
    public final void rule__CorrType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2032:1: ( rule__CorrType__Group__1__Impl )
            // InternalTGG.g:2033:2: rule__CorrType__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group__1"


    // $ANTLR start "rule__CorrType__Group__1__Impl"
    // InternalTGG.g:2039:1: rule__CorrType__Group__1__Impl : ( ( rule__CorrType__Alternatives_1 ) ) ;
    public final void rule__CorrType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2043:1: ( ( ( rule__CorrType__Alternatives_1 ) ) )
            // InternalTGG.g:2044:1: ( ( rule__CorrType__Alternatives_1 ) )
            {
            // InternalTGG.g:2044:1: ( ( rule__CorrType__Alternatives_1 ) )
            // InternalTGG.g:2045:1: ( rule__CorrType__Alternatives_1 )
            {
             before(grammarAccess.getCorrTypeAccess().getAlternatives_1()); 
            // InternalTGG.g:2046:1: ( rule__CorrType__Alternatives_1 )
            // InternalTGG.g:2046:2: rule__CorrType__Alternatives_1
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__Alternatives_1();

            state._fsp--;


            }

             after(grammarAccess.getCorrTypeAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group__1__Impl"


    // $ANTLR start "rule__CorrType__Group_1_0__0"
    // InternalTGG.g:2060:1: rule__CorrType__Group_1_0__0 : rule__CorrType__Group_1_0__0__Impl rule__CorrType__Group_1_0__1 ;
    public final void rule__CorrType__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2064:1: ( rule__CorrType__Group_1_0__0__Impl rule__CorrType__Group_1_0__1 )
            // InternalTGG.g:2065:2: rule__CorrType__Group_1_0__0__Impl rule__CorrType__Group_1_0__1
            {
            pushFollow(FOLLOW_7);
            rule__CorrType__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_0__0"


    // $ANTLR start "rule__CorrType__Group_1_0__0__Impl"
    // InternalTGG.g:2072:1: rule__CorrType__Group_1_0__0__Impl : ( '#extends' ) ;
    public final void rule__CorrType__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2076:1: ( ( '#extends' ) )
            // InternalTGG.g:2077:1: ( '#extends' )
            {
            // InternalTGG.g:2077:1: ( '#extends' )
            // InternalTGG.g:2078:1: '#extends'
            {
             before(grammarAccess.getCorrTypeAccess().getExtendsKeyword_1_0_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getCorrTypeAccess().getExtendsKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_0__0__Impl"


    // $ANTLR start "rule__CorrType__Group_1_0__1"
    // InternalTGG.g:2091:1: rule__CorrType__Group_1_0__1 : rule__CorrType__Group_1_0__1__Impl ;
    public final void rule__CorrType__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2095:1: ( rule__CorrType__Group_1_0__1__Impl )
            // InternalTGG.g:2096:2: rule__CorrType__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_0__1"


    // $ANTLR start "rule__CorrType__Group_1_0__1__Impl"
    // InternalTGG.g:2102:1: rule__CorrType__Group_1_0__1__Impl : ( ( rule__CorrType__SuperAssignment_1_0_1 ) ) ;
    public final void rule__CorrType__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2106:1: ( ( ( rule__CorrType__SuperAssignment_1_0_1 ) ) )
            // InternalTGG.g:2107:1: ( ( rule__CorrType__SuperAssignment_1_0_1 ) )
            {
            // InternalTGG.g:2107:1: ( ( rule__CorrType__SuperAssignment_1_0_1 ) )
            // InternalTGG.g:2108:1: ( rule__CorrType__SuperAssignment_1_0_1 )
            {
             before(grammarAccess.getCorrTypeAccess().getSuperAssignment_1_0_1()); 
            // InternalTGG.g:2109:1: ( rule__CorrType__SuperAssignment_1_0_1 )
            // InternalTGG.g:2109:2: rule__CorrType__SuperAssignment_1_0_1
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__SuperAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getCorrTypeAccess().getSuperAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_0__1__Impl"


    // $ANTLR start "rule__CorrType__Group_1_1__0"
    // InternalTGG.g:2123:1: rule__CorrType__Group_1_1__0 : rule__CorrType__Group_1_1__0__Impl rule__CorrType__Group_1_1__1 ;
    public final void rule__CorrType__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2127:1: ( rule__CorrType__Group_1_1__0__Impl rule__CorrType__Group_1_1__1 )
            // InternalTGG.g:2128:2: rule__CorrType__Group_1_1__0__Impl rule__CorrType__Group_1_1__1
            {
            pushFollow(FOLLOW_15);
            rule__CorrType__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__0"


    // $ANTLR start "rule__CorrType__Group_1_1__0__Impl"
    // InternalTGG.g:2135:1: rule__CorrType__Group_1_1__0__Impl : ( '{' ) ;
    public final void rule__CorrType__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2139:1: ( ( '{' ) )
            // InternalTGG.g:2140:1: ( '{' )
            {
            // InternalTGG.g:2140:1: ( '{' )
            // InternalTGG.g:2141:1: '{'
            {
             before(grammarAccess.getCorrTypeAccess().getLeftCurlyBracketKeyword_1_1_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getCorrTypeAccess().getLeftCurlyBracketKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__0__Impl"


    // $ANTLR start "rule__CorrType__Group_1_1__1"
    // InternalTGG.g:2154:1: rule__CorrType__Group_1_1__1 : rule__CorrType__Group_1_1__1__Impl rule__CorrType__Group_1_1__2 ;
    public final void rule__CorrType__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2158:1: ( rule__CorrType__Group_1_1__1__Impl rule__CorrType__Group_1_1__2 )
            // InternalTGG.g:2159:2: rule__CorrType__Group_1_1__1__Impl rule__CorrType__Group_1_1__2
            {
            pushFollow(FOLLOW_7);
            rule__CorrType__Group_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__1"


    // $ANTLR start "rule__CorrType__Group_1_1__1__Impl"
    // InternalTGG.g:2166:1: rule__CorrType__Group_1_1__1__Impl : ( '#src->' ) ;
    public final void rule__CorrType__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2170:1: ( ( '#src->' ) )
            // InternalTGG.g:2171:1: ( '#src->' )
            {
            // InternalTGG.g:2171:1: ( '#src->' )
            // InternalTGG.g:2172:1: '#src->'
            {
             before(grammarAccess.getCorrTypeAccess().getSrcKeyword_1_1_1()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getCorrTypeAccess().getSrcKeyword_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__1__Impl"


    // $ANTLR start "rule__CorrType__Group_1_1__2"
    // InternalTGG.g:2185:1: rule__CorrType__Group_1_1__2 : rule__CorrType__Group_1_1__2__Impl rule__CorrType__Group_1_1__3 ;
    public final void rule__CorrType__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2189:1: ( rule__CorrType__Group_1_1__2__Impl rule__CorrType__Group_1_1__3 )
            // InternalTGG.g:2190:2: rule__CorrType__Group_1_1__2__Impl rule__CorrType__Group_1_1__3
            {
            pushFollow(FOLLOW_16);
            rule__CorrType__Group_1_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__2"


    // $ANTLR start "rule__CorrType__Group_1_1__2__Impl"
    // InternalTGG.g:2197:1: rule__CorrType__Group_1_1__2__Impl : ( ( rule__CorrType__SourceAssignment_1_1_2 ) ) ;
    public final void rule__CorrType__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2201:1: ( ( ( rule__CorrType__SourceAssignment_1_1_2 ) ) )
            // InternalTGG.g:2202:1: ( ( rule__CorrType__SourceAssignment_1_1_2 ) )
            {
            // InternalTGG.g:2202:1: ( ( rule__CorrType__SourceAssignment_1_1_2 ) )
            // InternalTGG.g:2203:1: ( rule__CorrType__SourceAssignment_1_1_2 )
            {
             before(grammarAccess.getCorrTypeAccess().getSourceAssignment_1_1_2()); 
            // InternalTGG.g:2204:1: ( rule__CorrType__SourceAssignment_1_1_2 )
            // InternalTGG.g:2204:2: rule__CorrType__SourceAssignment_1_1_2
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__SourceAssignment_1_1_2();

            state._fsp--;


            }

             after(grammarAccess.getCorrTypeAccess().getSourceAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__2__Impl"


    // $ANTLR start "rule__CorrType__Group_1_1__3"
    // InternalTGG.g:2214:1: rule__CorrType__Group_1_1__3 : rule__CorrType__Group_1_1__3__Impl rule__CorrType__Group_1_1__4 ;
    public final void rule__CorrType__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2218:1: ( rule__CorrType__Group_1_1__3__Impl rule__CorrType__Group_1_1__4 )
            // InternalTGG.g:2219:2: rule__CorrType__Group_1_1__3__Impl rule__CorrType__Group_1_1__4
            {
            pushFollow(FOLLOW_7);
            rule__CorrType__Group_1_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__3"


    // $ANTLR start "rule__CorrType__Group_1_1__3__Impl"
    // InternalTGG.g:2226:1: rule__CorrType__Group_1_1__3__Impl : ( '#trg->' ) ;
    public final void rule__CorrType__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2230:1: ( ( '#trg->' ) )
            // InternalTGG.g:2231:1: ( '#trg->' )
            {
            // InternalTGG.g:2231:1: ( '#trg->' )
            // InternalTGG.g:2232:1: '#trg->'
            {
             before(grammarAccess.getCorrTypeAccess().getTrgKeyword_1_1_3()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getCorrTypeAccess().getTrgKeyword_1_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__3__Impl"


    // $ANTLR start "rule__CorrType__Group_1_1__4"
    // InternalTGG.g:2245:1: rule__CorrType__Group_1_1__4 : rule__CorrType__Group_1_1__4__Impl rule__CorrType__Group_1_1__5 ;
    public final void rule__CorrType__Group_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2249:1: ( rule__CorrType__Group_1_1__4__Impl rule__CorrType__Group_1_1__5 )
            // InternalTGG.g:2250:2: rule__CorrType__Group_1_1__4__Impl rule__CorrType__Group_1_1__5
            {
            pushFollow(FOLLOW_17);
            rule__CorrType__Group_1_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__4"


    // $ANTLR start "rule__CorrType__Group_1_1__4__Impl"
    // InternalTGG.g:2257:1: rule__CorrType__Group_1_1__4__Impl : ( ( rule__CorrType__TargetAssignment_1_1_4 ) ) ;
    public final void rule__CorrType__Group_1_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2261:1: ( ( ( rule__CorrType__TargetAssignment_1_1_4 ) ) )
            // InternalTGG.g:2262:1: ( ( rule__CorrType__TargetAssignment_1_1_4 ) )
            {
            // InternalTGG.g:2262:1: ( ( rule__CorrType__TargetAssignment_1_1_4 ) )
            // InternalTGG.g:2263:1: ( rule__CorrType__TargetAssignment_1_1_4 )
            {
             before(grammarAccess.getCorrTypeAccess().getTargetAssignment_1_1_4()); 
            // InternalTGG.g:2264:1: ( rule__CorrType__TargetAssignment_1_1_4 )
            // InternalTGG.g:2264:2: rule__CorrType__TargetAssignment_1_1_4
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__TargetAssignment_1_1_4();

            state._fsp--;


            }

             after(grammarAccess.getCorrTypeAccess().getTargetAssignment_1_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__4__Impl"


    // $ANTLR start "rule__CorrType__Group_1_1__5"
    // InternalTGG.g:2274:1: rule__CorrType__Group_1_1__5 : rule__CorrType__Group_1_1__5__Impl ;
    public final void rule__CorrType__Group_1_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2278:1: ( rule__CorrType__Group_1_1__5__Impl )
            // InternalTGG.g:2279:2: rule__CorrType__Group_1_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CorrType__Group_1_1__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__5"


    // $ANTLR start "rule__CorrType__Group_1_1__5__Impl"
    // InternalTGG.g:2285:1: rule__CorrType__Group_1_1__5__Impl : ( '}' ) ;
    public final void rule__CorrType__Group_1_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2289:1: ( ( '}' ) )
            // InternalTGG.g:2290:1: ( '}' )
            {
            // InternalTGG.g:2290:1: ( '}' )
            // InternalTGG.g:2291:1: '}'
            {
             before(grammarAccess.getCorrTypeAccess().getRightCurlyBracketKeyword_1_1_5()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getCorrTypeAccess().getRightCurlyBracketKeyword_1_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__Group_1_1__5__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__0"
    // InternalTGG.g:2316:1: rule__AttrCondDef__Group__0 : rule__AttrCondDef__Group__0__Impl rule__AttrCondDef__Group__1 ;
    public final void rule__AttrCondDef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2320:1: ( rule__AttrCondDef__Group__0__Impl rule__AttrCondDef__Group__1 )
            // InternalTGG.g:2321:2: rule__AttrCondDef__Group__0__Impl rule__AttrCondDef__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__AttrCondDef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__0"


    // $ANTLR start "rule__AttrCondDef__Group__0__Impl"
    // InternalTGG.g:2328:1: rule__AttrCondDef__Group__0__Impl : ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? ) ;
    public final void rule__AttrCondDef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2332:1: ( ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? ) )
            // InternalTGG.g:2333:1: ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? )
            {
            // InternalTGG.g:2333:1: ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? )
            // InternalTGG.g:2334:1: ( rule__AttrCondDef__UserDefinedAssignment_0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getUserDefinedAssignment_0()); 
            // InternalTGG.g:2335:1: ( rule__AttrCondDef__UserDefinedAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==52) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTGG.g:2335:2: rule__AttrCondDef__UserDefinedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttrCondDef__UserDefinedAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrCondDefAccess().getUserDefinedAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__0__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__1"
    // InternalTGG.g:2345:1: rule__AttrCondDef__Group__1 : rule__AttrCondDef__Group__1__Impl rule__AttrCondDef__Group__2 ;
    public final void rule__AttrCondDef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2349:1: ( rule__AttrCondDef__Group__1__Impl rule__AttrCondDef__Group__2 )
            // InternalTGG.g:2350:2: rule__AttrCondDef__Group__1__Impl rule__AttrCondDef__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__AttrCondDef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__1"


    // $ANTLR start "rule__AttrCondDef__Group__1__Impl"
    // InternalTGG.g:2357:1: rule__AttrCondDef__Group__1__Impl : ( ( rule__AttrCondDef__NameAssignment_1 ) ) ;
    public final void rule__AttrCondDef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2361:1: ( ( ( rule__AttrCondDef__NameAssignment_1 ) ) )
            // InternalTGG.g:2362:1: ( ( rule__AttrCondDef__NameAssignment_1 ) )
            {
            // InternalTGG.g:2362:1: ( ( rule__AttrCondDef__NameAssignment_1 ) )
            // InternalTGG.g:2363:1: ( rule__AttrCondDef__NameAssignment_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getNameAssignment_1()); 
            // InternalTGG.g:2364:1: ( rule__AttrCondDef__NameAssignment_1 )
            // InternalTGG.g:2364:2: rule__AttrCondDef__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__1__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__2"
    // InternalTGG.g:2374:1: rule__AttrCondDef__Group__2 : rule__AttrCondDef__Group__2__Impl rule__AttrCondDef__Group__3 ;
    public final void rule__AttrCondDef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2378:1: ( rule__AttrCondDef__Group__2__Impl rule__AttrCondDef__Group__3 )
            // InternalTGG.g:2379:2: rule__AttrCondDef__Group__2__Impl rule__AttrCondDef__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__AttrCondDef__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__2"


    // $ANTLR start "rule__AttrCondDef__Group__2__Impl"
    // InternalTGG.g:2386:1: rule__AttrCondDef__Group__2__Impl : ( '(' ) ;
    public final void rule__AttrCondDef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2390:1: ( ( '(' ) )
            // InternalTGG.g:2391:1: ( '(' )
            {
            // InternalTGG.g:2391:1: ( '(' )
            // InternalTGG.g:2392:1: '('
            {
             before(grammarAccess.getAttrCondDefAccess().getLeftParenthesisKeyword_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__2__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__3"
    // InternalTGG.g:2405:1: rule__AttrCondDef__Group__3 : rule__AttrCondDef__Group__3__Impl rule__AttrCondDef__Group__4 ;
    public final void rule__AttrCondDef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2409:1: ( rule__AttrCondDef__Group__3__Impl rule__AttrCondDef__Group__4 )
            // InternalTGG.g:2410:2: rule__AttrCondDef__Group__3__Impl rule__AttrCondDef__Group__4
            {
            pushFollow(FOLLOW_20);
            rule__AttrCondDef__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__3"


    // $ANTLR start "rule__AttrCondDef__Group__3__Impl"
    // InternalTGG.g:2417:1: rule__AttrCondDef__Group__3__Impl : ( ( rule__AttrCondDef__Group_3__0 )? ) ;
    public final void rule__AttrCondDef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2421:1: ( ( ( rule__AttrCondDef__Group_3__0 )? ) )
            // InternalTGG.g:2422:1: ( ( rule__AttrCondDef__Group_3__0 )? )
            {
            // InternalTGG.g:2422:1: ( ( rule__AttrCondDef__Group_3__0 )? )
            // InternalTGG.g:2423:1: ( rule__AttrCondDef__Group_3__0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_3()); 
            // InternalTGG.g:2424:1: ( rule__AttrCondDef__Group_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTGG.g:2424:2: rule__AttrCondDef__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttrCondDef__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrCondDefAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__3__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__4"
    // InternalTGG.g:2434:1: rule__AttrCondDef__Group__4 : rule__AttrCondDef__Group__4__Impl rule__AttrCondDef__Group__5 ;
    public final void rule__AttrCondDef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2438:1: ( rule__AttrCondDef__Group__4__Impl rule__AttrCondDef__Group__5 )
            // InternalTGG.g:2439:2: rule__AttrCondDef__Group__4__Impl rule__AttrCondDef__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__AttrCondDef__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__4"


    // $ANTLR start "rule__AttrCondDef__Group__4__Impl"
    // InternalTGG.g:2446:1: rule__AttrCondDef__Group__4__Impl : ( ')' ) ;
    public final void rule__AttrCondDef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2450:1: ( ( ')' ) )
            // InternalTGG.g:2451:1: ( ')' )
            {
            // InternalTGG.g:2451:1: ( ')' )
            // InternalTGG.g:2452:1: ')'
            {
             before(grammarAccess.getAttrCondDefAccess().getRightParenthesisKeyword_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__4__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__5"
    // InternalTGG.g:2465:1: rule__AttrCondDef__Group__5 : rule__AttrCondDef__Group__5__Impl rule__AttrCondDef__Group__6 ;
    public final void rule__AttrCondDef__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2469:1: ( rule__AttrCondDef__Group__5__Impl rule__AttrCondDef__Group__6 )
            // InternalTGG.g:2470:2: rule__AttrCondDef__Group__5__Impl rule__AttrCondDef__Group__6
            {
            pushFollow(FOLLOW_21);
            rule__AttrCondDef__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__5"


    // $ANTLR start "rule__AttrCondDef__Group__5__Impl"
    // InternalTGG.g:2477:1: rule__AttrCondDef__Group__5__Impl : ( '{' ) ;
    public final void rule__AttrCondDef__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2481:1: ( ( '{' ) )
            // InternalTGG.g:2482:1: ( '{' )
            {
            // InternalTGG.g:2482:1: ( '{' )
            // InternalTGG.g:2483:1: '{'
            {
             before(grammarAccess.getAttrCondDefAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__5__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__6"
    // InternalTGG.g:2496:1: rule__AttrCondDef__Group__6 : rule__AttrCondDef__Group__6__Impl rule__AttrCondDef__Group__7 ;
    public final void rule__AttrCondDef__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2500:1: ( rule__AttrCondDef__Group__6__Impl rule__AttrCondDef__Group__7 )
            // InternalTGG.g:2501:2: rule__AttrCondDef__Group__6__Impl rule__AttrCondDef__Group__7
            {
            pushFollow(FOLLOW_22);
            rule__AttrCondDef__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__6"


    // $ANTLR start "rule__AttrCondDef__Group__6__Impl"
    // InternalTGG.g:2508:1: rule__AttrCondDef__Group__6__Impl : ( '#sync:' ) ;
    public final void rule__AttrCondDef__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2512:1: ( ( '#sync:' ) )
            // InternalTGG.g:2513:1: ( '#sync:' )
            {
            // InternalTGG.g:2513:1: ( '#sync:' )
            // InternalTGG.g:2514:1: '#sync:'
            {
             before(grammarAccess.getAttrCondDefAccess().getSyncKeyword_6()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getSyncKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__6__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__7"
    // InternalTGG.g:2527:1: rule__AttrCondDef__Group__7 : rule__AttrCondDef__Group__7__Impl rule__AttrCondDef__Group__8 ;
    public final void rule__AttrCondDef__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2531:1: ( rule__AttrCondDef__Group__7__Impl rule__AttrCondDef__Group__8 )
            // InternalTGG.g:2532:2: rule__AttrCondDef__Group__7__Impl rule__AttrCondDef__Group__8
            {
            pushFollow(FOLLOW_23);
            rule__AttrCondDef__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__7"


    // $ANTLR start "rule__AttrCondDef__Group__7__Impl"
    // InternalTGG.g:2539:1: rule__AttrCondDef__Group__7__Impl : ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) ) ;
    public final void rule__AttrCondDef__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2543:1: ( ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) ) )
            // InternalTGG.g:2544:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) )
            {
            // InternalTGG.g:2544:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) )
            // InternalTGG.g:2545:1: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_7()); 
            // InternalTGG.g:2546:1: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 )
            // InternalTGG.g:2546:2: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__7__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__8"
    // InternalTGG.g:2556:1: rule__AttrCondDef__Group__8 : rule__AttrCondDef__Group__8__Impl rule__AttrCondDef__Group__9 ;
    public final void rule__AttrCondDef__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2560:1: ( rule__AttrCondDef__Group__8__Impl rule__AttrCondDef__Group__9 )
            // InternalTGG.g:2561:2: rule__AttrCondDef__Group__8__Impl rule__AttrCondDef__Group__9
            {
            pushFollow(FOLLOW_23);
            rule__AttrCondDef__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__8"


    // $ANTLR start "rule__AttrCondDef__Group__8__Impl"
    // InternalTGG.g:2568:1: rule__AttrCondDef__Group__8__Impl : ( ( rule__AttrCondDef__Group_8__0 )* ) ;
    public final void rule__AttrCondDef__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2572:1: ( ( ( rule__AttrCondDef__Group_8__0 )* ) )
            // InternalTGG.g:2573:1: ( ( rule__AttrCondDef__Group_8__0 )* )
            {
            // InternalTGG.g:2573:1: ( ( rule__AttrCondDef__Group_8__0 )* )
            // InternalTGG.g:2574:1: ( rule__AttrCondDef__Group_8__0 )*
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_8()); 
            // InternalTGG.g:2575:1: ( rule__AttrCondDef__Group_8__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==34) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalTGG.g:2575:2: rule__AttrCondDef__Group_8__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__AttrCondDef__Group_8__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getAttrCondDefAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__8__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__9"
    // InternalTGG.g:2585:1: rule__AttrCondDef__Group__9 : rule__AttrCondDef__Group__9__Impl rule__AttrCondDef__Group__10 ;
    public final void rule__AttrCondDef__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2589:1: ( rule__AttrCondDef__Group__9__Impl rule__AttrCondDef__Group__10 )
            // InternalTGG.g:2590:2: rule__AttrCondDef__Group__9__Impl rule__AttrCondDef__Group__10
            {
            pushFollow(FOLLOW_23);
            rule__AttrCondDef__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__9"


    // $ANTLR start "rule__AttrCondDef__Group__9__Impl"
    // InternalTGG.g:2597:1: rule__AttrCondDef__Group__9__Impl : ( ( rule__AttrCondDef__Group_9__0 )? ) ;
    public final void rule__AttrCondDef__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2601:1: ( ( ( rule__AttrCondDef__Group_9__0 )? ) )
            // InternalTGG.g:2602:1: ( ( rule__AttrCondDef__Group_9__0 )? )
            {
            // InternalTGG.g:2602:1: ( ( rule__AttrCondDef__Group_9__0 )? )
            // InternalTGG.g:2603:1: ( rule__AttrCondDef__Group_9__0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_9()); 
            // InternalTGG.g:2604:1: ( rule__AttrCondDef__Group_9__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTGG.g:2604:2: rule__AttrCondDef__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttrCondDef__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrCondDefAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__9__Impl"


    // $ANTLR start "rule__AttrCondDef__Group__10"
    // InternalTGG.g:2614:1: rule__AttrCondDef__Group__10 : rule__AttrCondDef__Group__10__Impl ;
    public final void rule__AttrCondDef__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2618:1: ( rule__AttrCondDef__Group__10__Impl )
            // InternalTGG.g:2619:2: rule__AttrCondDef__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__10"


    // $ANTLR start "rule__AttrCondDef__Group__10__Impl"
    // InternalTGG.g:2625:1: rule__AttrCondDef__Group__10__Impl : ( '}' ) ;
    public final void rule__AttrCondDef__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2629:1: ( ( '}' ) )
            // InternalTGG.g:2630:1: ( '}' )
            {
            // InternalTGG.g:2630:1: ( '}' )
            // InternalTGG.g:2631:1: '}'
            {
             before(grammarAccess.getAttrCondDefAccess().getRightCurlyBracketKeyword_10()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group__10__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_3__0"
    // InternalTGG.g:2666:1: rule__AttrCondDef__Group_3__0 : rule__AttrCondDef__Group_3__0__Impl rule__AttrCondDef__Group_3__1 ;
    public final void rule__AttrCondDef__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2670:1: ( rule__AttrCondDef__Group_3__0__Impl rule__AttrCondDef__Group_3__1 )
            // InternalTGG.g:2671:2: rule__AttrCondDef__Group_3__0__Impl rule__AttrCondDef__Group_3__1
            {
            pushFollow(FOLLOW_25);
            rule__AttrCondDef__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3__0"


    // $ANTLR start "rule__AttrCondDef__Group_3__0__Impl"
    // InternalTGG.g:2678:1: rule__AttrCondDef__Group_3__0__Impl : ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) ) ;
    public final void rule__AttrCondDef__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2682:1: ( ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) ) )
            // InternalTGG.g:2683:1: ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) )
            {
            // InternalTGG.g:2683:1: ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) )
            // InternalTGG.g:2684:1: ( rule__AttrCondDef__ParamsAssignment_3_0 )
            {
             before(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_0()); 
            // InternalTGG.g:2685:1: ( rule__AttrCondDef__ParamsAssignment_3_0 )
            // InternalTGG.g:2685:2: rule__AttrCondDef__ParamsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__ParamsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3__0__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_3__1"
    // InternalTGG.g:2695:1: rule__AttrCondDef__Group_3__1 : rule__AttrCondDef__Group_3__1__Impl ;
    public final void rule__AttrCondDef__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2699:1: ( rule__AttrCondDef__Group_3__1__Impl )
            // InternalTGG.g:2700:2: rule__AttrCondDef__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3__1"


    // $ANTLR start "rule__AttrCondDef__Group_3__1__Impl"
    // InternalTGG.g:2706:1: rule__AttrCondDef__Group_3__1__Impl : ( ( rule__AttrCondDef__Group_3_1__0 )* ) ;
    public final void rule__AttrCondDef__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2710:1: ( ( ( rule__AttrCondDef__Group_3_1__0 )* ) )
            // InternalTGG.g:2711:1: ( ( rule__AttrCondDef__Group_3_1__0 )* )
            {
            // InternalTGG.g:2711:1: ( ( rule__AttrCondDef__Group_3_1__0 )* )
            // InternalTGG.g:2712:1: ( rule__AttrCondDef__Group_3_1__0 )*
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_3_1()); 
            // InternalTGG.g:2713:1: ( rule__AttrCondDef__Group_3_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==34) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTGG.g:2713:2: rule__AttrCondDef__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__AttrCondDef__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getAttrCondDefAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3__1__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_3_1__0"
    // InternalTGG.g:2727:1: rule__AttrCondDef__Group_3_1__0 : rule__AttrCondDef__Group_3_1__0__Impl rule__AttrCondDef__Group_3_1__1 ;
    public final void rule__AttrCondDef__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2731:1: ( rule__AttrCondDef__Group_3_1__0__Impl rule__AttrCondDef__Group_3_1__1 )
            // InternalTGG.g:2732:2: rule__AttrCondDef__Group_3_1__0__Impl rule__AttrCondDef__Group_3_1__1
            {
            pushFollow(FOLLOW_7);
            rule__AttrCondDef__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3_1__0"


    // $ANTLR start "rule__AttrCondDef__Group_3_1__0__Impl"
    // InternalTGG.g:2739:1: rule__AttrCondDef__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__AttrCondDef__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2743:1: ( ( ',' ) )
            // InternalTGG.g:2744:1: ( ',' )
            {
            // InternalTGG.g:2744:1: ( ',' )
            // InternalTGG.g:2745:1: ','
            {
             before(grammarAccess.getAttrCondDefAccess().getCommaKeyword_3_1_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3_1__0__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_3_1__1"
    // InternalTGG.g:2758:1: rule__AttrCondDef__Group_3_1__1 : rule__AttrCondDef__Group_3_1__1__Impl ;
    public final void rule__AttrCondDef__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2762:1: ( rule__AttrCondDef__Group_3_1__1__Impl )
            // InternalTGG.g:2763:2: rule__AttrCondDef__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3_1__1"


    // $ANTLR start "rule__AttrCondDef__Group_3_1__1__Impl"
    // InternalTGG.g:2769:1: rule__AttrCondDef__Group_3_1__1__Impl : ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) ) ;
    public final void rule__AttrCondDef__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2773:1: ( ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) ) )
            // InternalTGG.g:2774:1: ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) )
            {
            // InternalTGG.g:2774:1: ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) )
            // InternalTGG.g:2775:1: ( rule__AttrCondDef__ParamsAssignment_3_1_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_1_1()); 
            // InternalTGG.g:2776:1: ( rule__AttrCondDef__ParamsAssignment_3_1_1 )
            // InternalTGG.g:2776:2: rule__AttrCondDef__ParamsAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__ParamsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_3_1__1__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_8__0"
    // InternalTGG.g:2790:1: rule__AttrCondDef__Group_8__0 : rule__AttrCondDef__Group_8__0__Impl rule__AttrCondDef__Group_8__1 ;
    public final void rule__AttrCondDef__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2794:1: ( rule__AttrCondDef__Group_8__0__Impl rule__AttrCondDef__Group_8__1 )
            // InternalTGG.g:2795:2: rule__AttrCondDef__Group_8__0__Impl rule__AttrCondDef__Group_8__1
            {
            pushFollow(FOLLOW_22);
            rule__AttrCondDef__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_8__0"


    // $ANTLR start "rule__AttrCondDef__Group_8__0__Impl"
    // InternalTGG.g:2802:1: rule__AttrCondDef__Group_8__0__Impl : ( ',' ) ;
    public final void rule__AttrCondDef__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2806:1: ( ( ',' ) )
            // InternalTGG.g:2807:1: ( ',' )
            {
            // InternalTGG.g:2807:1: ( ',' )
            // InternalTGG.g:2808:1: ','
            {
             before(grammarAccess.getAttrCondDefAccess().getCommaKeyword_8_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getCommaKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_8__0__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_8__1"
    // InternalTGG.g:2821:1: rule__AttrCondDef__Group_8__1 : rule__AttrCondDef__Group_8__1__Impl ;
    public final void rule__AttrCondDef__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2825:1: ( rule__AttrCondDef__Group_8__1__Impl )
            // InternalTGG.g:2826:2: rule__AttrCondDef__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_8__1"


    // $ANTLR start "rule__AttrCondDef__Group_8__1__Impl"
    // InternalTGG.g:2832:1: rule__AttrCondDef__Group_8__1__Impl : ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) ) ;
    public final void rule__AttrCondDef__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2836:1: ( ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) ) )
            // InternalTGG.g:2837:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) )
            {
            // InternalTGG.g:2837:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) )
            // InternalTGG.g:2838:1: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_8_1()); 
            // InternalTGG.g:2839:1: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 )
            // InternalTGG.g:2839:2: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_8__1__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_9__0"
    // InternalTGG.g:2853:1: rule__AttrCondDef__Group_9__0 : rule__AttrCondDef__Group_9__0__Impl rule__AttrCondDef__Group_9__1 ;
    public final void rule__AttrCondDef__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2857:1: ( rule__AttrCondDef__Group_9__0__Impl rule__AttrCondDef__Group_9__1 )
            // InternalTGG.g:2858:2: rule__AttrCondDef__Group_9__0__Impl rule__AttrCondDef__Group_9__1
            {
            pushFollow(FOLLOW_22);
            rule__AttrCondDef__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9__0"


    // $ANTLR start "rule__AttrCondDef__Group_9__0__Impl"
    // InternalTGG.g:2865:1: rule__AttrCondDef__Group_9__0__Impl : ( '#gen:' ) ;
    public final void rule__AttrCondDef__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2869:1: ( ( '#gen:' ) )
            // InternalTGG.g:2870:1: ( '#gen:' )
            {
            // InternalTGG.g:2870:1: ( '#gen:' )
            // InternalTGG.g:2871:1: '#gen:'
            {
             before(grammarAccess.getAttrCondDefAccess().getGenKeyword_9_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getGenKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9__0__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_9__1"
    // InternalTGG.g:2884:1: rule__AttrCondDef__Group_9__1 : rule__AttrCondDef__Group_9__1__Impl ;
    public final void rule__AttrCondDef__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2888:1: ( rule__AttrCondDef__Group_9__1__Impl )
            // InternalTGG.g:2889:2: rule__AttrCondDef__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_9__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9__1"


    // $ANTLR start "rule__AttrCondDef__Group_9__1__Impl"
    // InternalTGG.g:2895:1: rule__AttrCondDef__Group_9__1__Impl : ( ( rule__AttrCondDef__Group_9_1__0 )? ) ;
    public final void rule__AttrCondDef__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2899:1: ( ( ( rule__AttrCondDef__Group_9_1__0 )? ) )
            // InternalTGG.g:2900:1: ( ( rule__AttrCondDef__Group_9_1__0 )? )
            {
            // InternalTGG.g:2900:1: ( ( rule__AttrCondDef__Group_9_1__0 )? )
            // InternalTGG.g:2901:1: ( rule__AttrCondDef__Group_9_1__0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_9_1()); 
            // InternalTGG.g:2902:1: ( rule__AttrCondDef__Group_9_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTGG.g:2902:2: rule__AttrCondDef__Group_9_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttrCondDef__Group_9_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrCondDefAccess().getGroup_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9__1__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_9_1__0"
    // InternalTGG.g:2916:1: rule__AttrCondDef__Group_9_1__0 : rule__AttrCondDef__Group_9_1__0__Impl rule__AttrCondDef__Group_9_1__1 ;
    public final void rule__AttrCondDef__Group_9_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2920:1: ( rule__AttrCondDef__Group_9_1__0__Impl rule__AttrCondDef__Group_9_1__1 )
            // InternalTGG.g:2921:2: rule__AttrCondDef__Group_9_1__0__Impl rule__AttrCondDef__Group_9_1__1
            {
            pushFollow(FOLLOW_25);
            rule__AttrCondDef__Group_9_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_9_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1__0"


    // $ANTLR start "rule__AttrCondDef__Group_9_1__0__Impl"
    // InternalTGG.g:2928:1: rule__AttrCondDef__Group_9_1__0__Impl : ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) ) ;
    public final void rule__AttrCondDef__Group_9_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2932:1: ( ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) ) )
            // InternalTGG.g:2933:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) )
            {
            // InternalTGG.g:2933:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) )
            // InternalTGG.g:2934:1: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_0()); 
            // InternalTGG.g:2935:1: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 )
            // InternalTGG.g:2935:2: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1__0__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_9_1__1"
    // InternalTGG.g:2945:1: rule__AttrCondDef__Group_9_1__1 : rule__AttrCondDef__Group_9_1__1__Impl ;
    public final void rule__AttrCondDef__Group_9_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2949:1: ( rule__AttrCondDef__Group_9_1__1__Impl )
            // InternalTGG.g:2950:2: rule__AttrCondDef__Group_9_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_9_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1__1"


    // $ANTLR start "rule__AttrCondDef__Group_9_1__1__Impl"
    // InternalTGG.g:2956:1: rule__AttrCondDef__Group_9_1__1__Impl : ( ( rule__AttrCondDef__Group_9_1_1__0 )* ) ;
    public final void rule__AttrCondDef__Group_9_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2960:1: ( ( ( rule__AttrCondDef__Group_9_1_1__0 )* ) )
            // InternalTGG.g:2961:1: ( ( rule__AttrCondDef__Group_9_1_1__0 )* )
            {
            // InternalTGG.g:2961:1: ( ( rule__AttrCondDef__Group_9_1_1__0 )* )
            // InternalTGG.g:2962:1: ( rule__AttrCondDef__Group_9_1_1__0 )*
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_9_1_1()); 
            // InternalTGG.g:2963:1: ( rule__AttrCondDef__Group_9_1_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalTGG.g:2963:2: rule__AttrCondDef__Group_9_1_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__AttrCondDef__Group_9_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getAttrCondDefAccess().getGroup_9_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1__1__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_9_1_1__0"
    // InternalTGG.g:2977:1: rule__AttrCondDef__Group_9_1_1__0 : rule__AttrCondDef__Group_9_1_1__0__Impl rule__AttrCondDef__Group_9_1_1__1 ;
    public final void rule__AttrCondDef__Group_9_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2981:1: ( rule__AttrCondDef__Group_9_1_1__0__Impl rule__AttrCondDef__Group_9_1_1__1 )
            // InternalTGG.g:2982:2: rule__AttrCondDef__Group_9_1_1__0__Impl rule__AttrCondDef__Group_9_1_1__1
            {
            pushFollow(FOLLOW_22);
            rule__AttrCondDef__Group_9_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_9_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1_1__0"


    // $ANTLR start "rule__AttrCondDef__Group_9_1_1__0__Impl"
    // InternalTGG.g:2989:1: rule__AttrCondDef__Group_9_1_1__0__Impl : ( ',' ) ;
    public final void rule__AttrCondDef__Group_9_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:2993:1: ( ( ',' ) )
            // InternalTGG.g:2994:1: ( ',' )
            {
            // InternalTGG.g:2994:1: ( ',' )
            // InternalTGG.g:2995:1: ','
            {
             before(grammarAccess.getAttrCondDefAccess().getCommaKeyword_9_1_1_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getCommaKeyword_9_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1_1__0__Impl"


    // $ANTLR start "rule__AttrCondDef__Group_9_1_1__1"
    // InternalTGG.g:3008:1: rule__AttrCondDef__Group_9_1_1__1 : rule__AttrCondDef__Group_9_1_1__1__Impl ;
    public final void rule__AttrCondDef__Group_9_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3012:1: ( rule__AttrCondDef__Group_9_1_1__1__Impl )
            // InternalTGG.g:3013:2: rule__AttrCondDef__Group_9_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__Group_9_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1_1__1"


    // $ANTLR start "rule__AttrCondDef__Group_9_1_1__1__Impl"
    // InternalTGG.g:3019:1: rule__AttrCondDef__Group_9_1_1__1__Impl : ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) ) ;
    public final void rule__AttrCondDef__Group_9_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3023:1: ( ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) ) )
            // InternalTGG.g:3024:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) )
            {
            // InternalTGG.g:3024:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) )
            // InternalTGG.g:3025:1: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_1_1()); 
            // InternalTGG.g:3026:1: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 )
            // InternalTGG.g:3026:2: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__Group_9_1_1__1__Impl"


    // $ANTLR start "rule__Param__Group__0"
    // InternalTGG.g:3040:1: rule__Param__Group__0 : rule__Param__Group__0__Impl rule__Param__Group__1 ;
    public final void rule__Param__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3044:1: ( rule__Param__Group__0__Impl rule__Param__Group__1 )
            // InternalTGG.g:3045:2: rule__Param__Group__0__Impl rule__Param__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__Param__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Param__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__0"


    // $ANTLR start "rule__Param__Group__0__Impl"
    // InternalTGG.g:3052:1: rule__Param__Group__0__Impl : ( ( rule__Param__ParamNameAssignment_0 ) ) ;
    public final void rule__Param__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3056:1: ( ( ( rule__Param__ParamNameAssignment_0 ) ) )
            // InternalTGG.g:3057:1: ( ( rule__Param__ParamNameAssignment_0 ) )
            {
            // InternalTGG.g:3057:1: ( ( rule__Param__ParamNameAssignment_0 ) )
            // InternalTGG.g:3058:1: ( rule__Param__ParamNameAssignment_0 )
            {
             before(grammarAccess.getParamAccess().getParamNameAssignment_0()); 
            // InternalTGG.g:3059:1: ( rule__Param__ParamNameAssignment_0 )
            // InternalTGG.g:3059:2: rule__Param__ParamNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Param__ParamNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParamAccess().getParamNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__0__Impl"


    // $ANTLR start "rule__Param__Group__1"
    // InternalTGG.g:3069:1: rule__Param__Group__1 : rule__Param__Group__1__Impl rule__Param__Group__2 ;
    public final void rule__Param__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3073:1: ( rule__Param__Group__1__Impl rule__Param__Group__2 )
            // InternalTGG.g:3074:2: rule__Param__Group__1__Impl rule__Param__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Param__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Param__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__1"


    // $ANTLR start "rule__Param__Group__1__Impl"
    // InternalTGG.g:3081:1: rule__Param__Group__1__Impl : ( ':' ) ;
    public final void rule__Param__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3085:1: ( ( ':' ) )
            // InternalTGG.g:3086:1: ( ':' )
            {
            // InternalTGG.g:3086:1: ( ':' )
            // InternalTGG.g:3087:1: ':'
            {
             before(grammarAccess.getParamAccess().getColonKeyword_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getParamAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__1__Impl"


    // $ANTLR start "rule__Param__Group__2"
    // InternalTGG.g:3100:1: rule__Param__Group__2 : rule__Param__Group__2__Impl ;
    public final void rule__Param__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3104:1: ( rule__Param__Group__2__Impl )
            // InternalTGG.g:3105:2: rule__Param__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Param__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__2"


    // $ANTLR start "rule__Param__Group__2__Impl"
    // InternalTGG.g:3111:1: rule__Param__Group__2__Impl : ( ( rule__Param__TypeAssignment_2 ) ) ;
    public final void rule__Param__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3115:1: ( ( ( rule__Param__TypeAssignment_2 ) ) )
            // InternalTGG.g:3116:1: ( ( rule__Param__TypeAssignment_2 ) )
            {
            // InternalTGG.g:3116:1: ( ( rule__Param__TypeAssignment_2 ) )
            // InternalTGG.g:3117:1: ( rule__Param__TypeAssignment_2 )
            {
             before(grammarAccess.getParamAccess().getTypeAssignment_2()); 
            // InternalTGG.g:3118:1: ( rule__Param__TypeAssignment_2 )
            // InternalTGG.g:3118:2: rule__Param__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Param__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParamAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__Group__2__Impl"


    // $ANTLR start "rule__Rule__Group__0"
    // InternalTGG.g:3134:1: rule__Rule__Group__0 : rule__Rule__Group__0__Impl rule__Rule__Group__1 ;
    public final void rule__Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3138:1: ( rule__Rule__Group__0__Impl rule__Rule__Group__1 )
            // InternalTGG.g:3139:2: rule__Rule__Group__0__Impl rule__Rule__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__Rule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0"


    // $ANTLR start "rule__Rule__Group__0__Impl"
    // InternalTGG.g:3146:1: rule__Rule__Group__0__Impl : ( ( rule__Rule__AbstractRuleAssignment_0 )? ) ;
    public final void rule__Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3150:1: ( ( ( rule__Rule__AbstractRuleAssignment_0 )? ) )
            // InternalTGG.g:3151:1: ( ( rule__Rule__AbstractRuleAssignment_0 )? )
            {
            // InternalTGG.g:3151:1: ( ( rule__Rule__AbstractRuleAssignment_0 )? )
            // InternalTGG.g:3152:1: ( rule__Rule__AbstractRuleAssignment_0 )?
            {
             before(grammarAccess.getRuleAccess().getAbstractRuleAssignment_0()); 
            // InternalTGG.g:3153:1: ( rule__Rule__AbstractRuleAssignment_0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==53) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalTGG.g:3153:2: rule__Rule__AbstractRuleAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Rule__AbstractRuleAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleAccess().getAbstractRuleAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__0__Impl"


    // $ANTLR start "rule__Rule__Group__1"
    // InternalTGG.g:3163:1: rule__Rule__Group__1 : rule__Rule__Group__1__Impl rule__Rule__Group__2 ;
    public final void rule__Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3167:1: ( rule__Rule__Group__1__Impl rule__Rule__Group__2 )
            // InternalTGG.g:3168:2: rule__Rule__Group__1__Impl rule__Rule__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Rule__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1"


    // $ANTLR start "rule__Rule__Group__1__Impl"
    // InternalTGG.g:3175:1: rule__Rule__Group__1__Impl : ( '#rule' ) ;
    public final void rule__Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3179:1: ( ( '#rule' ) )
            // InternalTGG.g:3180:1: ( '#rule' )
            {
            // InternalTGG.g:3180:1: ( '#rule' )
            // InternalTGG.g:3181:1: '#rule'
            {
             before(grammarAccess.getRuleAccess().getRuleKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getRuleKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__1__Impl"


    // $ANTLR start "rule__Rule__Group__2"
    // InternalTGG.g:3194:1: rule__Rule__Group__2 : rule__Rule__Group__2__Impl rule__Rule__Group__3 ;
    public final void rule__Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3198:1: ( rule__Rule__Group__2__Impl rule__Rule__Group__3 )
            // InternalTGG.g:3199:2: rule__Rule__Group__2__Impl rule__Rule__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__Rule__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2"


    // $ANTLR start "rule__Rule__Group__2__Impl"
    // InternalTGG.g:3206:1: rule__Rule__Group__2__Impl : ( ( rule__Rule__NameAssignment_2 ) ) ;
    public final void rule__Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3210:1: ( ( ( rule__Rule__NameAssignment_2 ) ) )
            // InternalTGG.g:3211:1: ( ( rule__Rule__NameAssignment_2 ) )
            {
            // InternalTGG.g:3211:1: ( ( rule__Rule__NameAssignment_2 ) )
            // InternalTGG.g:3212:1: ( rule__Rule__NameAssignment_2 )
            {
             before(grammarAccess.getRuleAccess().getNameAssignment_2()); 
            // InternalTGG.g:3213:1: ( rule__Rule__NameAssignment_2 )
            // InternalTGG.g:3213:2: rule__Rule__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Rule__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__2__Impl"


    // $ANTLR start "rule__Rule__Group__3"
    // InternalTGG.g:3223:1: rule__Rule__Group__3 : rule__Rule__Group__3__Impl rule__Rule__Group__4 ;
    public final void rule__Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3227:1: ( rule__Rule__Group__3__Impl rule__Rule__Group__4 )
            // InternalTGG.g:3228:2: rule__Rule__Group__3__Impl rule__Rule__Group__4
            {
            pushFollow(FOLLOW_28);
            rule__Rule__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3"


    // $ANTLR start "rule__Rule__Group__3__Impl"
    // InternalTGG.g:3235:1: rule__Rule__Group__3__Impl : ( ( rule__Rule__Group_3__0 )? ) ;
    public final void rule__Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3239:1: ( ( ( rule__Rule__Group_3__0 )? ) )
            // InternalTGG.g:3240:1: ( ( rule__Rule__Group_3__0 )? )
            {
            // InternalTGG.g:3240:1: ( ( rule__Rule__Group_3__0 )? )
            // InternalTGG.g:3241:1: ( rule__Rule__Group_3__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_3()); 
            // InternalTGG.g:3242:1: ( rule__Rule__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==28) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTGG.g:3242:2: rule__Rule__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Rule__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__3__Impl"


    // $ANTLR start "rule__Rule__Group__4"
    // InternalTGG.g:3252:1: rule__Rule__Group__4 : rule__Rule__Group__4__Impl rule__Rule__Group__5 ;
    public final void rule__Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3256:1: ( rule__Rule__Group__4__Impl rule__Rule__Group__5 )
            // InternalTGG.g:3257:2: rule__Rule__Group__4__Impl rule__Rule__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Rule__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__4"


    // $ANTLR start "rule__Rule__Group__4__Impl"
    // InternalTGG.g:3264:1: rule__Rule__Group__4__Impl : ( '#with' ) ;
    public final void rule__Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3268:1: ( ( '#with' ) )
            // InternalTGG.g:3269:1: ( '#with' )
            {
            // InternalTGG.g:3269:1: ( '#with' )
            // InternalTGG.g:3270:1: '#with'
            {
             before(grammarAccess.getRuleAccess().getWithKeyword_4()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getWithKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__4__Impl"


    // $ANTLR start "rule__Rule__Group__5"
    // InternalTGG.g:3283:1: rule__Rule__Group__5 : rule__Rule__Group__5__Impl rule__Rule__Group__6 ;
    public final void rule__Rule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3287:1: ( rule__Rule__Group__5__Impl rule__Rule__Group__6 )
            // InternalTGG.g:3288:2: rule__Rule__Group__5__Impl rule__Rule__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__Rule__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__5"


    // $ANTLR start "rule__Rule__Group__5__Impl"
    // InternalTGG.g:3295:1: rule__Rule__Group__5__Impl : ( ( rule__Rule__SchemaAssignment_5 ) ) ;
    public final void rule__Rule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3299:1: ( ( ( rule__Rule__SchemaAssignment_5 ) ) )
            // InternalTGG.g:3300:1: ( ( rule__Rule__SchemaAssignment_5 ) )
            {
            // InternalTGG.g:3300:1: ( ( rule__Rule__SchemaAssignment_5 ) )
            // InternalTGG.g:3301:1: ( rule__Rule__SchemaAssignment_5 )
            {
             before(grammarAccess.getRuleAccess().getSchemaAssignment_5()); 
            // InternalTGG.g:3302:1: ( rule__Rule__SchemaAssignment_5 )
            // InternalTGG.g:3302:2: rule__Rule__SchemaAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Rule__SchemaAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getSchemaAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__5__Impl"


    // $ANTLR start "rule__Rule__Group__6"
    // InternalTGG.g:3312:1: rule__Rule__Group__6 : rule__Rule__Group__6__Impl rule__Rule__Group__7 ;
    public final void rule__Rule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3316:1: ( rule__Rule__Group__6__Impl rule__Rule__Group__7 )
            // InternalTGG.g:3317:2: rule__Rule__Group__6__Impl rule__Rule__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__Rule__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__6"


    // $ANTLR start "rule__Rule__Group__6__Impl"
    // InternalTGG.g:3324:1: rule__Rule__Group__6__Impl : ( ( rule__Rule__Group_6__0 )? ) ;
    public final void rule__Rule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3328:1: ( ( ( rule__Rule__Group_6__0 )? ) )
            // InternalTGG.g:3329:1: ( ( rule__Rule__Group_6__0 )? )
            {
            // InternalTGG.g:3329:1: ( ( rule__Rule__Group_6__0 )? )
            // InternalTGG.g:3330:1: ( rule__Rule__Group_6__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_6()); 
            // InternalTGG.g:3331:1: ( rule__Rule__Group_6__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==22) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTGG.g:3331:2: rule__Rule__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Rule__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__6__Impl"


    // $ANTLR start "rule__Rule__Group__7"
    // InternalTGG.g:3341:1: rule__Rule__Group__7 : rule__Rule__Group__7__Impl rule__Rule__Group__8 ;
    public final void rule__Rule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3345:1: ( rule__Rule__Group__7__Impl rule__Rule__Group__8 )
            // InternalTGG.g:3346:2: rule__Rule__Group__7__Impl rule__Rule__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__Rule__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__7"


    // $ANTLR start "rule__Rule__Group__7__Impl"
    // InternalTGG.g:3353:1: rule__Rule__Group__7__Impl : ( ( rule__Rule__Group_7__0 )? ) ;
    public final void rule__Rule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3357:1: ( ( ( rule__Rule__Group_7__0 )? ) )
            // InternalTGG.g:3358:1: ( ( rule__Rule__Group_7__0 )? )
            {
            // InternalTGG.g:3358:1: ( ( rule__Rule__Group_7__0 )? )
            // InternalTGG.g:3359:1: ( rule__Rule__Group_7__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_7()); 
            // InternalTGG.g:3360:1: ( rule__Rule__Group_7__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTGG.g:3360:2: rule__Rule__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Rule__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__7__Impl"


    // $ANTLR start "rule__Rule__Group__8"
    // InternalTGG.g:3370:1: rule__Rule__Group__8 : rule__Rule__Group__8__Impl rule__Rule__Group__9 ;
    public final void rule__Rule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3374:1: ( rule__Rule__Group__8__Impl rule__Rule__Group__9 )
            // InternalTGG.g:3375:2: rule__Rule__Group__8__Impl rule__Rule__Group__9
            {
            pushFollow(FOLLOW_8);
            rule__Rule__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__8"


    // $ANTLR start "rule__Rule__Group__8__Impl"
    // InternalTGG.g:3382:1: rule__Rule__Group__8__Impl : ( ( rule__Rule__Group_8__0 )? ) ;
    public final void rule__Rule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3386:1: ( ( ( rule__Rule__Group_8__0 )? ) )
            // InternalTGG.g:3387:1: ( ( rule__Rule__Group_8__0 )? )
            {
            // InternalTGG.g:3387:1: ( ( rule__Rule__Group_8__0 )? )
            // InternalTGG.g:3388:1: ( rule__Rule__Group_8__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_8()); 
            // InternalTGG.g:3389:1: ( rule__Rule__Group_8__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==26) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalTGG.g:3389:2: rule__Rule__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Rule__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__8__Impl"


    // $ANTLR start "rule__Rule__Group__9"
    // InternalTGG.g:3399:1: rule__Rule__Group__9 : rule__Rule__Group__9__Impl ;
    public final void rule__Rule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3403:1: ( rule__Rule__Group__9__Impl )
            // InternalTGG.g:3404:2: rule__Rule__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__9"


    // $ANTLR start "rule__Rule__Group__9__Impl"
    // InternalTGG.g:3410:1: rule__Rule__Group__9__Impl : ( ( rule__Rule__Group_9__0 )? ) ;
    public final void rule__Rule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3414:1: ( ( ( rule__Rule__Group_9__0 )? ) )
            // InternalTGG.g:3415:1: ( ( rule__Rule__Group_9__0 )? )
            {
            // InternalTGG.g:3415:1: ( ( rule__Rule__Group_9__0 )? )
            // InternalTGG.g:3416:1: ( rule__Rule__Group_9__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_9()); 
            // InternalTGG.g:3417:1: ( rule__Rule__Group_9__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==27) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTGG.g:3417:2: rule__Rule__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Rule__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group__9__Impl"


    // $ANTLR start "rule__Rule__Group_3__0"
    // InternalTGG.g:3447:1: rule__Rule__Group_3__0 : rule__Rule__Group_3__0__Impl rule__Rule__Group_3__1 ;
    public final void rule__Rule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3451:1: ( rule__Rule__Group_3__0__Impl rule__Rule__Group_3__1 )
            // InternalTGG.g:3452:2: rule__Rule__Group_3__0__Impl rule__Rule__Group_3__1
            {
            pushFollow(FOLLOW_7);
            rule__Rule__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3__0"


    // $ANTLR start "rule__Rule__Group_3__0__Impl"
    // InternalTGG.g:3459:1: rule__Rule__Group_3__0__Impl : ( '#extends' ) ;
    public final void rule__Rule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3463:1: ( ( '#extends' ) )
            // InternalTGG.g:3464:1: ( '#extends' )
            {
            // InternalTGG.g:3464:1: ( '#extends' )
            // InternalTGG.g:3465:1: '#extends'
            {
             before(grammarAccess.getRuleAccess().getExtendsKeyword_3_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getExtendsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3__0__Impl"


    // $ANTLR start "rule__Rule__Group_3__1"
    // InternalTGG.g:3478:1: rule__Rule__Group_3__1 : rule__Rule__Group_3__1__Impl rule__Rule__Group_3__2 ;
    public final void rule__Rule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3482:1: ( rule__Rule__Group_3__1__Impl rule__Rule__Group_3__2 )
            // InternalTGG.g:3483:2: rule__Rule__Group_3__1__Impl rule__Rule__Group_3__2
            {
            pushFollow(FOLLOW_25);
            rule__Rule__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3__1"


    // $ANTLR start "rule__Rule__Group_3__1__Impl"
    // InternalTGG.g:3490:1: rule__Rule__Group_3__1__Impl : ( ( rule__Rule__SupertypesAssignment_3_1 ) ) ;
    public final void rule__Rule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3494:1: ( ( ( rule__Rule__SupertypesAssignment_3_1 ) ) )
            // InternalTGG.g:3495:1: ( ( rule__Rule__SupertypesAssignment_3_1 ) )
            {
            // InternalTGG.g:3495:1: ( ( rule__Rule__SupertypesAssignment_3_1 ) )
            // InternalTGG.g:3496:1: ( rule__Rule__SupertypesAssignment_3_1 )
            {
             before(grammarAccess.getRuleAccess().getSupertypesAssignment_3_1()); 
            // InternalTGG.g:3497:1: ( rule__Rule__SupertypesAssignment_3_1 )
            // InternalTGG.g:3497:2: rule__Rule__SupertypesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Rule__SupertypesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getSupertypesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3__1__Impl"


    // $ANTLR start "rule__Rule__Group_3__2"
    // InternalTGG.g:3507:1: rule__Rule__Group_3__2 : rule__Rule__Group_3__2__Impl ;
    public final void rule__Rule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3511:1: ( rule__Rule__Group_3__2__Impl )
            // InternalTGG.g:3512:2: rule__Rule__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3__2"


    // $ANTLR start "rule__Rule__Group_3__2__Impl"
    // InternalTGG.g:3518:1: rule__Rule__Group_3__2__Impl : ( ( rule__Rule__Group_3_2__0 )* ) ;
    public final void rule__Rule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3522:1: ( ( ( rule__Rule__Group_3_2__0 )* ) )
            // InternalTGG.g:3523:1: ( ( rule__Rule__Group_3_2__0 )* )
            {
            // InternalTGG.g:3523:1: ( ( rule__Rule__Group_3_2__0 )* )
            // InternalTGG.g:3524:1: ( rule__Rule__Group_3_2__0 )*
            {
             before(grammarAccess.getRuleAccess().getGroup_3_2()); 
            // InternalTGG.g:3525:1: ( rule__Rule__Group_3_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==34) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalTGG.g:3525:2: rule__Rule__Group_3_2__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__Rule__Group_3_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getRuleAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3__2__Impl"


    // $ANTLR start "rule__Rule__Group_3_2__0"
    // InternalTGG.g:3541:1: rule__Rule__Group_3_2__0 : rule__Rule__Group_3_2__0__Impl rule__Rule__Group_3_2__1 ;
    public final void rule__Rule__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3545:1: ( rule__Rule__Group_3_2__0__Impl rule__Rule__Group_3_2__1 )
            // InternalTGG.g:3546:2: rule__Rule__Group_3_2__0__Impl rule__Rule__Group_3_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Rule__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3_2__0"


    // $ANTLR start "rule__Rule__Group_3_2__0__Impl"
    // InternalTGG.g:3553:1: rule__Rule__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Rule__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3557:1: ( ( ',' ) )
            // InternalTGG.g:3558:1: ( ',' )
            {
            // InternalTGG.g:3558:1: ( ',' )
            // InternalTGG.g:3559:1: ','
            {
             before(grammarAccess.getRuleAccess().getCommaKeyword_3_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getCommaKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3_2__0__Impl"


    // $ANTLR start "rule__Rule__Group_3_2__1"
    // InternalTGG.g:3572:1: rule__Rule__Group_3_2__1 : rule__Rule__Group_3_2__1__Impl ;
    public final void rule__Rule__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3576:1: ( rule__Rule__Group_3_2__1__Impl )
            // InternalTGG.g:3577:2: rule__Rule__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3_2__1"


    // $ANTLR start "rule__Rule__Group_3_2__1__Impl"
    // InternalTGG.g:3583:1: rule__Rule__Group_3_2__1__Impl : ( ( rule__Rule__SupertypesAssignment_3_2_1 ) ) ;
    public final void rule__Rule__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3587:1: ( ( ( rule__Rule__SupertypesAssignment_3_2_1 ) ) )
            // InternalTGG.g:3588:1: ( ( rule__Rule__SupertypesAssignment_3_2_1 ) )
            {
            // InternalTGG.g:3588:1: ( ( rule__Rule__SupertypesAssignment_3_2_1 ) )
            // InternalTGG.g:3589:1: ( rule__Rule__SupertypesAssignment_3_2_1 )
            {
             before(grammarAccess.getRuleAccess().getSupertypesAssignment_3_2_1()); 
            // InternalTGG.g:3590:1: ( rule__Rule__SupertypesAssignment_3_2_1 )
            // InternalTGG.g:3590:2: rule__Rule__SupertypesAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Rule__SupertypesAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleAccess().getSupertypesAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_3_2__1__Impl"


    // $ANTLR start "rule__Rule__Group_6__0"
    // InternalTGG.g:3604:1: rule__Rule__Group_6__0 : rule__Rule__Group_6__0__Impl rule__Rule__Group_6__1 ;
    public final void rule__Rule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3608:1: ( rule__Rule__Group_6__0__Impl rule__Rule__Group_6__1 )
            // InternalTGG.g:3609:2: rule__Rule__Group_6__0__Impl rule__Rule__Group_6__1
            {
            pushFollow(FOLLOW_9);
            rule__Rule__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__0"


    // $ANTLR start "rule__Rule__Group_6__0__Impl"
    // InternalTGG.g:3616:1: rule__Rule__Group_6__0__Impl : ( '#source' ) ;
    public final void rule__Rule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3620:1: ( ( '#source' ) )
            // InternalTGG.g:3621:1: ( '#source' )
            {
            // InternalTGG.g:3621:1: ( '#source' )
            // InternalTGG.g:3622:1: '#source'
            {
             before(grammarAccess.getRuleAccess().getSourceKeyword_6_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getSourceKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__0__Impl"


    // $ANTLR start "rule__Rule__Group_6__1"
    // InternalTGG.g:3635:1: rule__Rule__Group_6__1 : rule__Rule__Group_6__1__Impl rule__Rule__Group_6__2 ;
    public final void rule__Rule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3639:1: ( rule__Rule__Group_6__1__Impl rule__Rule__Group_6__2 )
            // InternalTGG.g:3640:2: rule__Rule__Group_6__1__Impl rule__Rule__Group_6__2
            {
            pushFollow(FOLLOW_29);
            rule__Rule__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__1"


    // $ANTLR start "rule__Rule__Group_6__1__Impl"
    // InternalTGG.g:3647:1: rule__Rule__Group_6__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3651:1: ( ( '{' ) )
            // InternalTGG.g:3652:1: ( '{' )
            {
            // InternalTGG.g:3652:1: ( '{' )
            // InternalTGG.g:3653:1: '{'
            {
             before(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_6_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__1__Impl"


    // $ANTLR start "rule__Rule__Group_6__2"
    // InternalTGG.g:3666:1: rule__Rule__Group_6__2 : rule__Rule__Group_6__2__Impl rule__Rule__Group_6__3 ;
    public final void rule__Rule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3670:1: ( rule__Rule__Group_6__2__Impl rule__Rule__Group_6__3 )
            // InternalTGG.g:3671:2: rule__Rule__Group_6__2__Impl rule__Rule__Group_6__3
            {
            pushFollow(FOLLOW_29);
            rule__Rule__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__2"


    // $ANTLR start "rule__Rule__Group_6__2__Impl"
    // InternalTGG.g:3678:1: rule__Rule__Group_6__2__Impl : ( ( rule__Rule__SourcePatternsAssignment_6_2 )* ) ;
    public final void rule__Rule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3682:1: ( ( ( rule__Rule__SourcePatternsAssignment_6_2 )* ) )
            // InternalTGG.g:3683:1: ( ( rule__Rule__SourcePatternsAssignment_6_2 )* )
            {
            // InternalTGG.g:3683:1: ( ( rule__Rule__SourcePatternsAssignment_6_2 )* )
            // InternalTGG.g:3684:1: ( rule__Rule__SourcePatternsAssignment_6_2 )*
            {
             before(grammarAccess.getRuleAccess().getSourcePatternsAssignment_6_2()); 
            // InternalTGG.g:3685:1: ( rule__Rule__SourcePatternsAssignment_6_2 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID||LA36_0==56) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalTGG.g:3685:2: rule__Rule__SourcePatternsAssignment_6_2
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__Rule__SourcePatternsAssignment_6_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getRuleAccess().getSourcePatternsAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__2__Impl"


    // $ANTLR start "rule__Rule__Group_6__3"
    // InternalTGG.g:3695:1: rule__Rule__Group_6__3 : rule__Rule__Group_6__3__Impl ;
    public final void rule__Rule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3699:1: ( rule__Rule__Group_6__3__Impl )
            // InternalTGG.g:3700:2: rule__Rule__Group_6__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group_6__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__3"


    // $ANTLR start "rule__Rule__Group_6__3__Impl"
    // InternalTGG.g:3706:1: rule__Rule__Group_6__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3710:1: ( ( '}' ) )
            // InternalTGG.g:3711:1: ( '}' )
            {
            // InternalTGG.g:3711:1: ( '}' )
            // InternalTGG.g:3712:1: '}'
            {
             before(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_6_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_6__3__Impl"


    // $ANTLR start "rule__Rule__Group_7__0"
    // InternalTGG.g:3733:1: rule__Rule__Group_7__0 : rule__Rule__Group_7__0__Impl rule__Rule__Group_7__1 ;
    public final void rule__Rule__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3737:1: ( rule__Rule__Group_7__0__Impl rule__Rule__Group_7__1 )
            // InternalTGG.g:3738:2: rule__Rule__Group_7__0__Impl rule__Rule__Group_7__1
            {
            pushFollow(FOLLOW_9);
            rule__Rule__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__0"


    // $ANTLR start "rule__Rule__Group_7__0__Impl"
    // InternalTGG.g:3745:1: rule__Rule__Group_7__0__Impl : ( '#target' ) ;
    public final void rule__Rule__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3749:1: ( ( '#target' ) )
            // InternalTGG.g:3750:1: ( '#target' )
            {
            // InternalTGG.g:3750:1: ( '#target' )
            // InternalTGG.g:3751:1: '#target'
            {
             before(grammarAccess.getRuleAccess().getTargetKeyword_7_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getTargetKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__0__Impl"


    // $ANTLR start "rule__Rule__Group_7__1"
    // InternalTGG.g:3764:1: rule__Rule__Group_7__1 : rule__Rule__Group_7__1__Impl rule__Rule__Group_7__2 ;
    public final void rule__Rule__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3768:1: ( rule__Rule__Group_7__1__Impl rule__Rule__Group_7__2 )
            // InternalTGG.g:3769:2: rule__Rule__Group_7__1__Impl rule__Rule__Group_7__2
            {
            pushFollow(FOLLOW_29);
            rule__Rule__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__1"


    // $ANTLR start "rule__Rule__Group_7__1__Impl"
    // InternalTGG.g:3776:1: rule__Rule__Group_7__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3780:1: ( ( '{' ) )
            // InternalTGG.g:3781:1: ( '{' )
            {
            // InternalTGG.g:3781:1: ( '{' )
            // InternalTGG.g:3782:1: '{'
            {
             before(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_7_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__1__Impl"


    // $ANTLR start "rule__Rule__Group_7__2"
    // InternalTGG.g:3795:1: rule__Rule__Group_7__2 : rule__Rule__Group_7__2__Impl rule__Rule__Group_7__3 ;
    public final void rule__Rule__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3799:1: ( rule__Rule__Group_7__2__Impl rule__Rule__Group_7__3 )
            // InternalTGG.g:3800:2: rule__Rule__Group_7__2__Impl rule__Rule__Group_7__3
            {
            pushFollow(FOLLOW_29);
            rule__Rule__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__2"


    // $ANTLR start "rule__Rule__Group_7__2__Impl"
    // InternalTGG.g:3807:1: rule__Rule__Group_7__2__Impl : ( ( rule__Rule__TargetPatternsAssignment_7_2 )* ) ;
    public final void rule__Rule__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3811:1: ( ( ( rule__Rule__TargetPatternsAssignment_7_2 )* ) )
            // InternalTGG.g:3812:1: ( ( rule__Rule__TargetPatternsAssignment_7_2 )* )
            {
            // InternalTGG.g:3812:1: ( ( rule__Rule__TargetPatternsAssignment_7_2 )* )
            // InternalTGG.g:3813:1: ( rule__Rule__TargetPatternsAssignment_7_2 )*
            {
             before(grammarAccess.getRuleAccess().getTargetPatternsAssignment_7_2()); 
            // InternalTGG.g:3814:1: ( rule__Rule__TargetPatternsAssignment_7_2 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID||LA37_0==56) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalTGG.g:3814:2: rule__Rule__TargetPatternsAssignment_7_2
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__Rule__TargetPatternsAssignment_7_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getRuleAccess().getTargetPatternsAssignment_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__2__Impl"


    // $ANTLR start "rule__Rule__Group_7__3"
    // InternalTGG.g:3824:1: rule__Rule__Group_7__3 : rule__Rule__Group_7__3__Impl ;
    public final void rule__Rule__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3828:1: ( rule__Rule__Group_7__3__Impl )
            // InternalTGG.g:3829:2: rule__Rule__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__3"


    // $ANTLR start "rule__Rule__Group_7__3__Impl"
    // InternalTGG.g:3835:1: rule__Rule__Group_7__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3839:1: ( ( '}' ) )
            // InternalTGG.g:3840:1: ( '}' )
            {
            // InternalTGG.g:3840:1: ( '}' )
            // InternalTGG.g:3841:1: '}'
            {
             before(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_7_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_7__3__Impl"


    // $ANTLR start "rule__Rule__Group_8__0"
    // InternalTGG.g:3862:1: rule__Rule__Group_8__0 : rule__Rule__Group_8__0__Impl rule__Rule__Group_8__1 ;
    public final void rule__Rule__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3866:1: ( rule__Rule__Group_8__0__Impl rule__Rule__Group_8__1 )
            // InternalTGG.g:3867:2: rule__Rule__Group_8__0__Impl rule__Rule__Group_8__1
            {
            pushFollow(FOLLOW_9);
            rule__Rule__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__0"


    // $ANTLR start "rule__Rule__Group_8__0__Impl"
    // InternalTGG.g:3874:1: rule__Rule__Group_8__0__Impl : ( '#correspondence' ) ;
    public final void rule__Rule__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3878:1: ( ( '#correspondence' ) )
            // InternalTGG.g:3879:1: ( '#correspondence' )
            {
            // InternalTGG.g:3879:1: ( '#correspondence' )
            // InternalTGG.g:3880:1: '#correspondence'
            {
             before(grammarAccess.getRuleAccess().getCorrespondenceKeyword_8_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getCorrespondenceKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__0__Impl"


    // $ANTLR start "rule__Rule__Group_8__1"
    // InternalTGG.g:3893:1: rule__Rule__Group_8__1 : rule__Rule__Group_8__1__Impl rule__Rule__Group_8__2 ;
    public final void rule__Rule__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3897:1: ( rule__Rule__Group_8__1__Impl rule__Rule__Group_8__2 )
            // InternalTGG.g:3898:2: rule__Rule__Group_8__1__Impl rule__Rule__Group_8__2
            {
            pushFollow(FOLLOW_29);
            rule__Rule__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__1"


    // $ANTLR start "rule__Rule__Group_8__1__Impl"
    // InternalTGG.g:3905:1: rule__Rule__Group_8__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3909:1: ( ( '{' ) )
            // InternalTGG.g:3910:1: ( '{' )
            {
            // InternalTGG.g:3910:1: ( '{' )
            // InternalTGG.g:3911:1: '{'
            {
             before(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_8_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__1__Impl"


    // $ANTLR start "rule__Rule__Group_8__2"
    // InternalTGG.g:3924:1: rule__Rule__Group_8__2 : rule__Rule__Group_8__2__Impl rule__Rule__Group_8__3 ;
    public final void rule__Rule__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3928:1: ( rule__Rule__Group_8__2__Impl rule__Rule__Group_8__3 )
            // InternalTGG.g:3929:2: rule__Rule__Group_8__2__Impl rule__Rule__Group_8__3
            {
            pushFollow(FOLLOW_29);
            rule__Rule__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__2"


    // $ANTLR start "rule__Rule__Group_8__2__Impl"
    // InternalTGG.g:3936:1: rule__Rule__Group_8__2__Impl : ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* ) ;
    public final void rule__Rule__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3940:1: ( ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* ) )
            // InternalTGG.g:3941:1: ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* )
            {
            // InternalTGG.g:3941:1: ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* )
            // InternalTGG.g:3942:1: ( rule__Rule__CorrespondencePatternsAssignment_8_2 )*
            {
             before(grammarAccess.getRuleAccess().getCorrespondencePatternsAssignment_8_2()); 
            // InternalTGG.g:3943:1: ( rule__Rule__CorrespondencePatternsAssignment_8_2 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||LA38_0==56) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalTGG.g:3943:2: rule__Rule__CorrespondencePatternsAssignment_8_2
            	    {
            	    pushFollow(FOLLOW_30);
            	    rule__Rule__CorrespondencePatternsAssignment_8_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getRuleAccess().getCorrespondencePatternsAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__2__Impl"


    // $ANTLR start "rule__Rule__Group_8__3"
    // InternalTGG.g:3953:1: rule__Rule__Group_8__3 : rule__Rule__Group_8__3__Impl ;
    public final void rule__Rule__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3957:1: ( rule__Rule__Group_8__3__Impl )
            // InternalTGG.g:3958:2: rule__Rule__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group_8__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__3"


    // $ANTLR start "rule__Rule__Group_8__3__Impl"
    // InternalTGG.g:3964:1: rule__Rule__Group_8__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3968:1: ( ( '}' ) )
            // InternalTGG.g:3969:1: ( '}' )
            {
            // InternalTGG.g:3969:1: ( '}' )
            // InternalTGG.g:3970:1: '}'
            {
             before(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_8_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_8__3__Impl"


    // $ANTLR start "rule__Rule__Group_9__0"
    // InternalTGG.g:3991:1: rule__Rule__Group_9__0 : rule__Rule__Group_9__0__Impl rule__Rule__Group_9__1 ;
    public final void rule__Rule__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:3995:1: ( rule__Rule__Group_9__0__Impl rule__Rule__Group_9__1 )
            // InternalTGG.g:3996:2: rule__Rule__Group_9__0__Impl rule__Rule__Group_9__1
            {
            pushFollow(FOLLOW_9);
            rule__Rule__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__0"


    // $ANTLR start "rule__Rule__Group_9__0__Impl"
    // InternalTGG.g:4003:1: rule__Rule__Group_9__0__Impl : ( '#attributeConditions' ) ;
    public final void rule__Rule__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4007:1: ( ( '#attributeConditions' ) )
            // InternalTGG.g:4008:1: ( '#attributeConditions' )
            {
            // InternalTGG.g:4008:1: ( '#attributeConditions' )
            // InternalTGG.g:4009:1: '#attributeConditions'
            {
             before(grammarAccess.getRuleAccess().getAttributeConditionsKeyword_9_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getAttributeConditionsKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__0__Impl"


    // $ANTLR start "rule__Rule__Group_9__1"
    // InternalTGG.g:4022:1: rule__Rule__Group_9__1 : rule__Rule__Group_9__1__Impl rule__Rule__Group_9__2 ;
    public final void rule__Rule__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4026:1: ( rule__Rule__Group_9__1__Impl rule__Rule__Group_9__2 )
            // InternalTGG.g:4027:2: rule__Rule__Group_9__1__Impl rule__Rule__Group_9__2
            {
            pushFollow(FOLLOW_10);
            rule__Rule__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__1"


    // $ANTLR start "rule__Rule__Group_9__1__Impl"
    // InternalTGG.g:4034:1: rule__Rule__Group_9__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4038:1: ( ( '{' ) )
            // InternalTGG.g:4039:1: ( '{' )
            {
            // InternalTGG.g:4039:1: ( '{' )
            // InternalTGG.g:4040:1: '{'
            {
             before(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_9_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getLeftCurlyBracketKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__1__Impl"


    // $ANTLR start "rule__Rule__Group_9__2"
    // InternalTGG.g:4053:1: rule__Rule__Group_9__2 : rule__Rule__Group_9__2__Impl rule__Rule__Group_9__3 ;
    public final void rule__Rule__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4057:1: ( rule__Rule__Group_9__2__Impl rule__Rule__Group_9__3 )
            // InternalTGG.g:4058:2: rule__Rule__Group_9__2__Impl rule__Rule__Group_9__3
            {
            pushFollow(FOLLOW_10);
            rule__Rule__Group_9__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Rule__Group_9__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__2"


    // $ANTLR start "rule__Rule__Group_9__2__Impl"
    // InternalTGG.g:4065:1: rule__Rule__Group_9__2__Impl : ( ( rule__Rule__AttrConditionsAssignment_9_2 )* ) ;
    public final void rule__Rule__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4069:1: ( ( ( rule__Rule__AttrConditionsAssignment_9_2 )* ) )
            // InternalTGG.g:4070:1: ( ( rule__Rule__AttrConditionsAssignment_9_2 )* )
            {
            // InternalTGG.g:4070:1: ( ( rule__Rule__AttrConditionsAssignment_9_2 )* )
            // InternalTGG.g:4071:1: ( rule__Rule__AttrConditionsAssignment_9_2 )*
            {
             before(grammarAccess.getRuleAccess().getAttrConditionsAssignment_9_2()); 
            // InternalTGG.g:4072:1: ( rule__Rule__AttrConditionsAssignment_9_2 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalTGG.g:4072:2: rule__Rule__AttrConditionsAssignment_9_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Rule__AttrConditionsAssignment_9_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getRuleAccess().getAttrConditionsAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__2__Impl"


    // $ANTLR start "rule__Rule__Group_9__3"
    // InternalTGG.g:4082:1: rule__Rule__Group_9__3 : rule__Rule__Group_9__3__Impl ;
    public final void rule__Rule__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4086:1: ( rule__Rule__Group_9__3__Impl )
            // InternalTGG.g:4087:2: rule__Rule__Group_9__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Rule__Group_9__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__3"


    // $ANTLR start "rule__Rule__Group_9__3__Impl"
    // InternalTGG.g:4093:1: rule__Rule__Group_9__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4097:1: ( ( '}' ) )
            // InternalTGG.g:4098:1: ( '}' )
            {
            // InternalTGG.g:4098:1: ( '}' )
            // InternalTGG.g:4099:1: '}'
            {
             before(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_9_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getRightCurlyBracketKeyword_9_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__Group_9__3__Impl"


    // $ANTLR start "rule__AttrCond__Group__0"
    // InternalTGG.g:4120:1: rule__AttrCond__Group__0 : rule__AttrCond__Group__0__Impl rule__AttrCond__Group__1 ;
    public final void rule__AttrCond__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4124:1: ( rule__AttrCond__Group__0__Impl rule__AttrCond__Group__1 )
            // InternalTGG.g:4125:2: rule__AttrCond__Group__0__Impl rule__AttrCond__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__AttrCond__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCond__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__0"


    // $ANTLR start "rule__AttrCond__Group__0__Impl"
    // InternalTGG.g:4132:1: rule__AttrCond__Group__0__Impl : ( ( rule__AttrCond__NameAssignment_0 ) ) ;
    public final void rule__AttrCond__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4136:1: ( ( ( rule__AttrCond__NameAssignment_0 ) ) )
            // InternalTGG.g:4137:1: ( ( rule__AttrCond__NameAssignment_0 ) )
            {
            // InternalTGG.g:4137:1: ( ( rule__AttrCond__NameAssignment_0 ) )
            // InternalTGG.g:4138:1: ( rule__AttrCond__NameAssignment_0 )
            {
             before(grammarAccess.getAttrCondAccess().getNameAssignment_0()); 
            // InternalTGG.g:4139:1: ( rule__AttrCond__NameAssignment_0 )
            // InternalTGG.g:4139:2: rule__AttrCond__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttrCond__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__0__Impl"


    // $ANTLR start "rule__AttrCond__Group__1"
    // InternalTGG.g:4149:1: rule__AttrCond__Group__1 : rule__AttrCond__Group__1__Impl rule__AttrCond__Group__2 ;
    public final void rule__AttrCond__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4153:1: ( rule__AttrCond__Group__1__Impl rule__AttrCond__Group__2 )
            // InternalTGG.g:4154:2: rule__AttrCond__Group__1__Impl rule__AttrCond__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__AttrCond__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCond__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__1"


    // $ANTLR start "rule__AttrCond__Group__1__Impl"
    // InternalTGG.g:4161:1: rule__AttrCond__Group__1__Impl : ( '(' ) ;
    public final void rule__AttrCond__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4165:1: ( ( '(' ) )
            // InternalTGG.g:4166:1: ( '(' )
            {
            // InternalTGG.g:4166:1: ( '(' )
            // InternalTGG.g:4167:1: '('
            {
             before(grammarAccess.getAttrCondAccess().getLeftParenthesisKeyword_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getAttrCondAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__1__Impl"


    // $ANTLR start "rule__AttrCond__Group__2"
    // InternalTGG.g:4180:1: rule__AttrCond__Group__2 : rule__AttrCond__Group__2__Impl rule__AttrCond__Group__3 ;
    public final void rule__AttrCond__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4184:1: ( rule__AttrCond__Group__2__Impl rule__AttrCond__Group__3 )
            // InternalTGG.g:4185:2: rule__AttrCond__Group__2__Impl rule__AttrCond__Group__3
            {
            pushFollow(FOLLOW_31);
            rule__AttrCond__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCond__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__2"


    // $ANTLR start "rule__AttrCond__Group__2__Impl"
    // InternalTGG.g:4192:1: rule__AttrCond__Group__2__Impl : ( ( rule__AttrCond__Group_2__0 )? ) ;
    public final void rule__AttrCond__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4196:1: ( ( ( rule__AttrCond__Group_2__0 )? ) )
            // InternalTGG.g:4197:1: ( ( rule__AttrCond__Group_2__0 )? )
            {
            // InternalTGG.g:4197:1: ( ( rule__AttrCond__Group_2__0 )? )
            // InternalTGG.g:4198:1: ( rule__AttrCond__Group_2__0 )?
            {
             before(grammarAccess.getAttrCondAccess().getGroup_2()); 
            // InternalTGG.g:4199:1: ( rule__AttrCond__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==42||LA40_0==45||LA40_0==55) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTGG.g:4199:2: rule__AttrCond__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttrCond__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrCondAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__2__Impl"


    // $ANTLR start "rule__AttrCond__Group__3"
    // InternalTGG.g:4209:1: rule__AttrCond__Group__3 : rule__AttrCond__Group__3__Impl ;
    public final void rule__AttrCond__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4213:1: ( rule__AttrCond__Group__3__Impl )
            // InternalTGG.g:4214:2: rule__AttrCond__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCond__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__3"


    // $ANTLR start "rule__AttrCond__Group__3__Impl"
    // InternalTGG.g:4220:1: rule__AttrCond__Group__3__Impl : ( ')' ) ;
    public final void rule__AttrCond__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4224:1: ( ( ')' ) )
            // InternalTGG.g:4225:1: ( ')' )
            {
            // InternalTGG.g:4225:1: ( ')' )
            // InternalTGG.g:4226:1: ')'
            {
             before(grammarAccess.getAttrCondAccess().getRightParenthesisKeyword_3()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getAttrCondAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group__3__Impl"


    // $ANTLR start "rule__AttrCond__Group_2__0"
    // InternalTGG.g:4247:1: rule__AttrCond__Group_2__0 : rule__AttrCond__Group_2__0__Impl rule__AttrCond__Group_2__1 ;
    public final void rule__AttrCond__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4251:1: ( rule__AttrCond__Group_2__0__Impl rule__AttrCond__Group_2__1 )
            // InternalTGG.g:4252:2: rule__AttrCond__Group_2__0__Impl rule__AttrCond__Group_2__1
            {
            pushFollow(FOLLOW_25);
            rule__AttrCond__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCond__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2__0"


    // $ANTLR start "rule__AttrCond__Group_2__0__Impl"
    // InternalTGG.g:4259:1: rule__AttrCond__Group_2__0__Impl : ( ( rule__AttrCond__ValuesAssignment_2_0 ) ) ;
    public final void rule__AttrCond__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4263:1: ( ( ( rule__AttrCond__ValuesAssignment_2_0 ) ) )
            // InternalTGG.g:4264:1: ( ( rule__AttrCond__ValuesAssignment_2_0 ) )
            {
            // InternalTGG.g:4264:1: ( ( rule__AttrCond__ValuesAssignment_2_0 ) )
            // InternalTGG.g:4265:1: ( rule__AttrCond__ValuesAssignment_2_0 )
            {
             before(grammarAccess.getAttrCondAccess().getValuesAssignment_2_0()); 
            // InternalTGG.g:4266:1: ( rule__AttrCond__ValuesAssignment_2_0 )
            // InternalTGG.g:4266:2: rule__AttrCond__ValuesAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__AttrCond__ValuesAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondAccess().getValuesAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2__0__Impl"


    // $ANTLR start "rule__AttrCond__Group_2__1"
    // InternalTGG.g:4276:1: rule__AttrCond__Group_2__1 : rule__AttrCond__Group_2__1__Impl ;
    public final void rule__AttrCond__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4280:1: ( rule__AttrCond__Group_2__1__Impl )
            // InternalTGG.g:4281:2: rule__AttrCond__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCond__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2__1"


    // $ANTLR start "rule__AttrCond__Group_2__1__Impl"
    // InternalTGG.g:4287:1: rule__AttrCond__Group_2__1__Impl : ( ( rule__AttrCond__Group_2_1__0 )* ) ;
    public final void rule__AttrCond__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4291:1: ( ( ( rule__AttrCond__Group_2_1__0 )* ) )
            // InternalTGG.g:4292:1: ( ( rule__AttrCond__Group_2_1__0 )* )
            {
            // InternalTGG.g:4292:1: ( ( rule__AttrCond__Group_2_1__0 )* )
            // InternalTGG.g:4293:1: ( rule__AttrCond__Group_2_1__0 )*
            {
             before(grammarAccess.getAttrCondAccess().getGroup_2_1()); 
            // InternalTGG.g:4294:1: ( rule__AttrCond__Group_2_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==34) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalTGG.g:4294:2: rule__AttrCond__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__AttrCond__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getAttrCondAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2__1__Impl"


    // $ANTLR start "rule__AttrCond__Group_2_1__0"
    // InternalTGG.g:4308:1: rule__AttrCond__Group_2_1__0 : rule__AttrCond__Group_2_1__0__Impl rule__AttrCond__Group_2_1__1 ;
    public final void rule__AttrCond__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4312:1: ( rule__AttrCond__Group_2_1__0__Impl rule__AttrCond__Group_2_1__1 )
            // InternalTGG.g:4313:2: rule__AttrCond__Group_2_1__0__Impl rule__AttrCond__Group_2_1__1
            {
            pushFollow(FOLLOW_32);
            rule__AttrCond__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCond__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2_1__0"


    // $ANTLR start "rule__AttrCond__Group_2_1__0__Impl"
    // InternalTGG.g:4320:1: rule__AttrCond__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__AttrCond__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4324:1: ( ( ',' ) )
            // InternalTGG.g:4325:1: ( ',' )
            {
            // InternalTGG.g:4325:1: ( ',' )
            // InternalTGG.g:4326:1: ','
            {
             before(grammarAccess.getAttrCondAccess().getCommaKeyword_2_1_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getAttrCondAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2_1__0__Impl"


    // $ANTLR start "rule__AttrCond__Group_2_1__1"
    // InternalTGG.g:4339:1: rule__AttrCond__Group_2_1__1 : rule__AttrCond__Group_2_1__1__Impl ;
    public final void rule__AttrCond__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4343:1: ( rule__AttrCond__Group_2_1__1__Impl )
            // InternalTGG.g:4344:2: rule__AttrCond__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCond__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2_1__1"


    // $ANTLR start "rule__AttrCond__Group_2_1__1__Impl"
    // InternalTGG.g:4350:1: rule__AttrCond__Group_2_1__1__Impl : ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__AttrCond__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4354:1: ( ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) ) )
            // InternalTGG.g:4355:1: ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) )
            {
            // InternalTGG.g:4355:1: ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) )
            // InternalTGG.g:4356:1: ( rule__AttrCond__ValuesAssignment_2_1_1 )
            {
             before(grammarAccess.getAttrCondAccess().getValuesAssignment_2_1_1()); 
            // InternalTGG.g:4357:1: ( rule__AttrCond__ValuesAssignment_2_1_1 )
            // InternalTGG.g:4357:2: rule__AttrCond__ValuesAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AttrCond__ValuesAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondAccess().getValuesAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__Group_2_1__1__Impl"


    // $ANTLR start "rule__AttrCondDefLibrary__Group__0"
    // InternalTGG.g:4371:1: rule__AttrCondDefLibrary__Group__0 : rule__AttrCondDefLibrary__Group__0__Impl rule__AttrCondDefLibrary__Group__1 ;
    public final void rule__AttrCondDefLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4375:1: ( rule__AttrCondDefLibrary__Group__0__Impl rule__AttrCondDefLibrary__Group__1 )
            // InternalTGG.g:4376:2: rule__AttrCondDefLibrary__Group__0__Impl rule__AttrCondDefLibrary__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__AttrCondDefLibrary__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group__0"


    // $ANTLR start "rule__AttrCondDefLibrary__Group__0__Impl"
    // InternalTGG.g:4383:1: rule__AttrCondDefLibrary__Group__0__Impl : ( '#library' ) ;
    public final void rule__AttrCondDefLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4387:1: ( ( '#library' ) )
            // InternalTGG.g:4388:1: ( '#library' )
            {
            // InternalTGG.g:4388:1: ( '#library' )
            // InternalTGG.g:4389:1: '#library'
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getLibraryKeyword_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefLibraryAccess().getLibraryKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group__0__Impl"


    // $ANTLR start "rule__AttrCondDefLibrary__Group__1"
    // InternalTGG.g:4402:1: rule__AttrCondDefLibrary__Group__1 : rule__AttrCondDefLibrary__Group__1__Impl rule__AttrCondDefLibrary__Group__2 ;
    public final void rule__AttrCondDefLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4406:1: ( rule__AttrCondDefLibrary__Group__1__Impl rule__AttrCondDefLibrary__Group__2 )
            // InternalTGG.g:4407:2: rule__AttrCondDefLibrary__Group__1__Impl rule__AttrCondDefLibrary__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__AttrCondDefLibrary__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group__1"


    // $ANTLR start "rule__AttrCondDefLibrary__Group__1__Impl"
    // InternalTGG.g:4414:1: rule__AttrCondDefLibrary__Group__1__Impl : ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) ) ;
    public final void rule__AttrCondDefLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4418:1: ( ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) ) )
            // InternalTGG.g:4419:1: ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) )
            {
            // InternalTGG.g:4419:1: ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) )
            // InternalTGG.g:4420:1: ( rule__AttrCondDefLibrary__NameAssignment_1 )
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getNameAssignment_1()); 
            // InternalTGG.g:4421:1: ( rule__AttrCondDefLibrary__NameAssignment_1 )
            // InternalTGG.g:4421:2: rule__AttrCondDefLibrary__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttrCondDefLibraryAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group__1__Impl"


    // $ANTLR start "rule__AttrCondDefLibrary__Group__2"
    // InternalTGG.g:4431:1: rule__AttrCondDefLibrary__Group__2 : rule__AttrCondDefLibrary__Group__2__Impl ;
    public final void rule__AttrCondDefLibrary__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4435:1: ( rule__AttrCondDefLibrary__Group__2__Impl )
            // InternalTGG.g:4436:2: rule__AttrCondDefLibrary__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group__2"


    // $ANTLR start "rule__AttrCondDefLibrary__Group__2__Impl"
    // InternalTGG.g:4442:1: rule__AttrCondDefLibrary__Group__2__Impl : ( ( rule__AttrCondDefLibrary__Group_2__0 )? ) ;
    public final void rule__AttrCondDefLibrary__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4446:1: ( ( ( rule__AttrCondDefLibrary__Group_2__0 )? ) )
            // InternalTGG.g:4447:1: ( ( rule__AttrCondDefLibrary__Group_2__0 )? )
            {
            // InternalTGG.g:4447:1: ( ( rule__AttrCondDefLibrary__Group_2__0 )? )
            // InternalTGG.g:4448:1: ( rule__AttrCondDefLibrary__Group_2__0 )?
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getGroup_2()); 
            // InternalTGG.g:4449:1: ( rule__AttrCondDefLibrary__Group_2__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==23) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTGG.g:4449:2: rule__AttrCondDefLibrary__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttrCondDefLibrary__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttrCondDefLibraryAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group__2__Impl"


    // $ANTLR start "rule__AttrCondDefLibrary__Group_2__0"
    // InternalTGG.g:4465:1: rule__AttrCondDefLibrary__Group_2__0 : rule__AttrCondDefLibrary__Group_2__0__Impl rule__AttrCondDefLibrary__Group_2__1 ;
    public final void rule__AttrCondDefLibrary__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4469:1: ( rule__AttrCondDefLibrary__Group_2__0__Impl rule__AttrCondDefLibrary__Group_2__1 )
            // InternalTGG.g:4470:2: rule__AttrCondDefLibrary__Group_2__0__Impl rule__AttrCondDefLibrary__Group_2__1
            {
            pushFollow(FOLLOW_12);
            rule__AttrCondDefLibrary__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group_2__0"


    // $ANTLR start "rule__AttrCondDefLibrary__Group_2__0__Impl"
    // InternalTGG.g:4477:1: rule__AttrCondDefLibrary__Group_2__0__Impl : ( '{' ) ;
    public final void rule__AttrCondDefLibrary__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4481:1: ( ( '{' ) )
            // InternalTGG.g:4482:1: ( '{' )
            {
            // InternalTGG.g:4482:1: ( '{' )
            // InternalTGG.g:4483:1: '{'
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getLeftCurlyBracketKeyword_2_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefLibraryAccess().getLeftCurlyBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group_2__0__Impl"


    // $ANTLR start "rule__AttrCondDefLibrary__Group_2__1"
    // InternalTGG.g:4496:1: rule__AttrCondDefLibrary__Group_2__1 : rule__AttrCondDefLibrary__Group_2__1__Impl rule__AttrCondDefLibrary__Group_2__2 ;
    public final void rule__AttrCondDefLibrary__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4500:1: ( rule__AttrCondDefLibrary__Group_2__1__Impl rule__AttrCondDefLibrary__Group_2__2 )
            // InternalTGG.g:4501:2: rule__AttrCondDefLibrary__Group_2__1__Impl rule__AttrCondDefLibrary__Group_2__2
            {
            pushFollow(FOLLOW_12);
            rule__AttrCondDefLibrary__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group_2__1"


    // $ANTLR start "rule__AttrCondDefLibrary__Group_2__1__Impl"
    // InternalTGG.g:4508:1: rule__AttrCondDefLibrary__Group_2__1__Impl : ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* ) ;
    public final void rule__AttrCondDefLibrary__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4512:1: ( ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* ) )
            // InternalTGG.g:4513:1: ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* )
            {
            // InternalTGG.g:4513:1: ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* )
            // InternalTGG.g:4514:1: ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )*
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getAttributeCondDefsAssignment_2_1()); 
            // InternalTGG.g:4515:1: ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==52) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalTGG.g:4515:2: rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

             after(grammarAccess.getAttrCondDefLibraryAccess().getAttributeCondDefsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group_2__1__Impl"


    // $ANTLR start "rule__AttrCondDefLibrary__Group_2__2"
    // InternalTGG.g:4525:1: rule__AttrCondDefLibrary__Group_2__2 : rule__AttrCondDefLibrary__Group_2__2__Impl ;
    public final void rule__AttrCondDefLibrary__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4529:1: ( rule__AttrCondDefLibrary__Group_2__2__Impl )
            // InternalTGG.g:4530:2: rule__AttrCondDefLibrary__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttrCondDefLibrary__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group_2__2"


    // $ANTLR start "rule__AttrCondDefLibrary__Group_2__2__Impl"
    // InternalTGG.g:4536:1: rule__AttrCondDefLibrary__Group_2__2__Impl : ( '}' ) ;
    public final void rule__AttrCondDefLibrary__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4540:1: ( ( '}' ) )
            // InternalTGG.g:4541:1: ( '}' )
            {
            // InternalTGG.g:4541:1: ( '}' )
            // InternalTGG.g:4542:1: '}'
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getRightCurlyBracketKeyword_2_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefLibraryAccess().getRightCurlyBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__Group_2__2__Impl"


    // $ANTLR start "rule__Adornment__Group__0"
    // InternalTGG.g:4561:1: rule__Adornment__Group__0 : rule__Adornment__Group__0__Impl rule__Adornment__Group__1 ;
    public final void rule__Adornment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4565:1: ( rule__Adornment__Group__0__Impl rule__Adornment__Group__1 )
            // InternalTGG.g:4566:2: rule__Adornment__Group__0__Impl rule__Adornment__Group__1
            {
            pushFollow(FOLLOW_33);
            rule__Adornment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Adornment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__Group__0"


    // $ANTLR start "rule__Adornment__Group__0__Impl"
    // InternalTGG.g:4573:1: rule__Adornment__Group__0__Impl : ( '[' ) ;
    public final void rule__Adornment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4577:1: ( ( '[' ) )
            // InternalTGG.g:4578:1: ( '[' )
            {
            // InternalTGG.g:4578:1: ( '[' )
            // InternalTGG.g:4579:1: '['
            {
             before(grammarAccess.getAdornmentAccess().getLeftSquareBracketKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getAdornmentAccess().getLeftSquareBracketKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__Group__0__Impl"


    // $ANTLR start "rule__Adornment__Group__1"
    // InternalTGG.g:4592:1: rule__Adornment__Group__1 : rule__Adornment__Group__1__Impl rule__Adornment__Group__2 ;
    public final void rule__Adornment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4596:1: ( rule__Adornment__Group__1__Impl rule__Adornment__Group__2 )
            // InternalTGG.g:4597:2: rule__Adornment__Group__1__Impl rule__Adornment__Group__2
            {
            pushFollow(FOLLOW_34);
            rule__Adornment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Adornment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__Group__1"


    // $ANTLR start "rule__Adornment__Group__1__Impl"
    // InternalTGG.g:4604:1: rule__Adornment__Group__1__Impl : ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) ) ;
    public final void rule__Adornment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4608:1: ( ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) ) )
            // InternalTGG.g:4609:1: ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) )
            {
            // InternalTGG.g:4609:1: ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) )
            // InternalTGG.g:4610:1: ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* )
            {
            // InternalTGG.g:4610:1: ( ( rule__Adornment__ValueAssignment_1 ) )
            // InternalTGG.g:4611:1: ( rule__Adornment__ValueAssignment_1 )
            {
             before(grammarAccess.getAdornmentAccess().getValueAssignment_1()); 
            // InternalTGG.g:4612:1: ( rule__Adornment__ValueAssignment_1 )
            // InternalTGG.g:4612:2: rule__Adornment__ValueAssignment_1
            {
            pushFollow(FOLLOW_35);
            rule__Adornment__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAdornmentAccess().getValueAssignment_1()); 

            }

            // InternalTGG.g:4615:1: ( ( rule__Adornment__ValueAssignment_1 )* )
            // InternalTGG.g:4616:1: ( rule__Adornment__ValueAssignment_1 )*
            {
             before(grammarAccess.getAdornmentAccess().getValueAssignment_1()); 
            // InternalTGG.g:4617:1: ( rule__Adornment__ValueAssignment_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=13 && LA44_0<=14)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalTGG.g:4617:2: rule__Adornment__ValueAssignment_1
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__Adornment__ValueAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getAdornmentAccess().getValueAssignment_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__Group__1__Impl"


    // $ANTLR start "rule__Adornment__Group__2"
    // InternalTGG.g:4628:1: rule__Adornment__Group__2 : rule__Adornment__Group__2__Impl ;
    public final void rule__Adornment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4632:1: ( rule__Adornment__Group__2__Impl )
            // InternalTGG.g:4633:2: rule__Adornment__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Adornment__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__Group__2"


    // $ANTLR start "rule__Adornment__Group__2__Impl"
    // InternalTGG.g:4639:1: rule__Adornment__Group__2__Impl : ( ']' ) ;
    public final void rule__Adornment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4643:1: ( ( ']' ) )
            // InternalTGG.g:4644:1: ( ']' )
            {
            // InternalTGG.g:4644:1: ( ']' )
            // InternalTGG.g:4645:1: ']'
            {
             before(grammarAccess.getAdornmentAccess().getRightSquareBracketKeyword_2()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getAdornmentAccess().getRightSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__Group__2__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__0"
    // InternalTGG.g:4664:1: rule__CorrVariablePattern__Group__0 : rule__CorrVariablePattern__Group__0__Impl rule__CorrVariablePattern__Group__1 ;
    public final void rule__CorrVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4668:1: ( rule__CorrVariablePattern__Group__0__Impl rule__CorrVariablePattern__Group__1 )
            // InternalTGG.g:4669:2: rule__CorrVariablePattern__Group__0__Impl rule__CorrVariablePattern__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__CorrVariablePattern__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__0"


    // $ANTLR start "rule__CorrVariablePattern__Group__0__Impl"
    // InternalTGG.g:4676:1: rule__CorrVariablePattern__Group__0__Impl : ( ( rule__CorrVariablePattern__OpAssignment_0 )? ) ;
    public final void rule__CorrVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4680:1: ( ( ( rule__CorrVariablePattern__OpAssignment_0 )? ) )
            // InternalTGG.g:4681:1: ( ( rule__CorrVariablePattern__OpAssignment_0 )? )
            {
            // InternalTGG.g:4681:1: ( ( rule__CorrVariablePattern__OpAssignment_0 )? )
            // InternalTGG.g:4682:1: ( rule__CorrVariablePattern__OpAssignment_0 )?
            {
             before(grammarAccess.getCorrVariablePatternAccess().getOpAssignment_0()); 
            // InternalTGG.g:4683:1: ( rule__CorrVariablePattern__OpAssignment_0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==56) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTGG.g:4683:2: rule__CorrVariablePattern__OpAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CorrVariablePattern__OpAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCorrVariablePatternAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__0__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__1"
    // InternalTGG.g:4693:1: rule__CorrVariablePattern__Group__1 : rule__CorrVariablePattern__Group__1__Impl rule__CorrVariablePattern__Group__2 ;
    public final void rule__CorrVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4697:1: ( rule__CorrVariablePattern__Group__1__Impl rule__CorrVariablePattern__Group__2 )
            // InternalTGG.g:4698:2: rule__CorrVariablePattern__Group__1__Impl rule__CorrVariablePattern__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__CorrVariablePattern__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__1"


    // $ANTLR start "rule__CorrVariablePattern__Group__1__Impl"
    // InternalTGG.g:4705:1: rule__CorrVariablePattern__Group__1__Impl : ( ( rule__CorrVariablePattern__NameAssignment_1 ) ) ;
    public final void rule__CorrVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4709:1: ( ( ( rule__CorrVariablePattern__NameAssignment_1 ) ) )
            // InternalTGG.g:4710:1: ( ( rule__CorrVariablePattern__NameAssignment_1 ) )
            {
            // InternalTGG.g:4710:1: ( ( rule__CorrVariablePattern__NameAssignment_1 ) )
            // InternalTGG.g:4711:1: ( rule__CorrVariablePattern__NameAssignment_1 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getNameAssignment_1()); 
            // InternalTGG.g:4712:1: ( rule__CorrVariablePattern__NameAssignment_1 )
            // InternalTGG.g:4712:2: rule__CorrVariablePattern__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCorrVariablePatternAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__1__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__2"
    // InternalTGG.g:4722:1: rule__CorrVariablePattern__Group__2 : rule__CorrVariablePattern__Group__2__Impl rule__CorrVariablePattern__Group__3 ;
    public final void rule__CorrVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4726:1: ( rule__CorrVariablePattern__Group__2__Impl rule__CorrVariablePattern__Group__3 )
            // InternalTGG.g:4727:2: rule__CorrVariablePattern__Group__2__Impl rule__CorrVariablePattern__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__CorrVariablePattern__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__2"


    // $ANTLR start "rule__CorrVariablePattern__Group__2__Impl"
    // InternalTGG.g:4734:1: rule__CorrVariablePattern__Group__2__Impl : ( ':' ) ;
    public final void rule__CorrVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4738:1: ( ( ':' ) )
            // InternalTGG.g:4739:1: ( ':' )
            {
            // InternalTGG.g:4739:1: ( ':' )
            // InternalTGG.g:4740:1: ':'
            {
             before(grammarAccess.getCorrVariablePatternAccess().getColonKeyword_2()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__2__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__3"
    // InternalTGG.g:4753:1: rule__CorrVariablePattern__Group__3 : rule__CorrVariablePattern__Group__3__Impl rule__CorrVariablePattern__Group__4 ;
    public final void rule__CorrVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4757:1: ( rule__CorrVariablePattern__Group__3__Impl rule__CorrVariablePattern__Group__4 )
            // InternalTGG.g:4758:2: rule__CorrVariablePattern__Group__3__Impl rule__CorrVariablePattern__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__CorrVariablePattern__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__3"


    // $ANTLR start "rule__CorrVariablePattern__Group__3__Impl"
    // InternalTGG.g:4765:1: rule__CorrVariablePattern__Group__3__Impl : ( ( rule__CorrVariablePattern__TypeAssignment_3 ) ) ;
    public final void rule__CorrVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4769:1: ( ( ( rule__CorrVariablePattern__TypeAssignment_3 ) ) )
            // InternalTGG.g:4770:1: ( ( rule__CorrVariablePattern__TypeAssignment_3 ) )
            {
            // InternalTGG.g:4770:1: ( ( rule__CorrVariablePattern__TypeAssignment_3 ) )
            // InternalTGG.g:4771:1: ( rule__CorrVariablePattern__TypeAssignment_3 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTypeAssignment_3()); 
            // InternalTGG.g:4772:1: ( rule__CorrVariablePattern__TypeAssignment_3 )
            // InternalTGG.g:4772:2: rule__CorrVariablePattern__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCorrVariablePatternAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__3__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__4"
    // InternalTGG.g:4782:1: rule__CorrVariablePattern__Group__4 : rule__CorrVariablePattern__Group__4__Impl rule__CorrVariablePattern__Group__5 ;
    public final void rule__CorrVariablePattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4786:1: ( rule__CorrVariablePattern__Group__4__Impl rule__CorrVariablePattern__Group__5 )
            // InternalTGG.g:4787:2: rule__CorrVariablePattern__Group__4__Impl rule__CorrVariablePattern__Group__5
            {
            pushFollow(FOLLOW_15);
            rule__CorrVariablePattern__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__4"


    // $ANTLR start "rule__CorrVariablePattern__Group__4__Impl"
    // InternalTGG.g:4794:1: rule__CorrVariablePattern__Group__4__Impl : ( '{' ) ;
    public final void rule__CorrVariablePattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4798:1: ( ( '{' ) )
            // InternalTGG.g:4799:1: ( '{' )
            {
            // InternalTGG.g:4799:1: ( '{' )
            // InternalTGG.g:4800:1: '{'
            {
             before(grammarAccess.getCorrVariablePatternAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__4__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__5"
    // InternalTGG.g:4813:1: rule__CorrVariablePattern__Group__5 : rule__CorrVariablePattern__Group__5__Impl rule__CorrVariablePattern__Group__6 ;
    public final void rule__CorrVariablePattern__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4817:1: ( rule__CorrVariablePattern__Group__5__Impl rule__CorrVariablePattern__Group__6 )
            // InternalTGG.g:4818:2: rule__CorrVariablePattern__Group__5__Impl rule__CorrVariablePattern__Group__6
            {
            pushFollow(FOLLOW_7);
            rule__CorrVariablePattern__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__5"


    // $ANTLR start "rule__CorrVariablePattern__Group__5__Impl"
    // InternalTGG.g:4825:1: rule__CorrVariablePattern__Group__5__Impl : ( '#src->' ) ;
    public final void rule__CorrVariablePattern__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4829:1: ( ( '#src->' ) )
            // InternalTGG.g:4830:1: ( '#src->' )
            {
            // InternalTGG.g:4830:1: ( '#src->' )
            // InternalTGG.g:4831:1: '#src->'
            {
             before(grammarAccess.getCorrVariablePatternAccess().getSrcKeyword_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getSrcKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__5__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__6"
    // InternalTGG.g:4844:1: rule__CorrVariablePattern__Group__6 : rule__CorrVariablePattern__Group__6__Impl rule__CorrVariablePattern__Group__7 ;
    public final void rule__CorrVariablePattern__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4848:1: ( rule__CorrVariablePattern__Group__6__Impl rule__CorrVariablePattern__Group__7 )
            // InternalTGG.g:4849:2: rule__CorrVariablePattern__Group__6__Impl rule__CorrVariablePattern__Group__7
            {
            pushFollow(FOLLOW_16);
            rule__CorrVariablePattern__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__6"


    // $ANTLR start "rule__CorrVariablePattern__Group__6__Impl"
    // InternalTGG.g:4856:1: rule__CorrVariablePattern__Group__6__Impl : ( ( rule__CorrVariablePattern__SourceAssignment_6 ) ) ;
    public final void rule__CorrVariablePattern__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4860:1: ( ( ( rule__CorrVariablePattern__SourceAssignment_6 ) ) )
            // InternalTGG.g:4861:1: ( ( rule__CorrVariablePattern__SourceAssignment_6 ) )
            {
            // InternalTGG.g:4861:1: ( ( rule__CorrVariablePattern__SourceAssignment_6 ) )
            // InternalTGG.g:4862:1: ( rule__CorrVariablePattern__SourceAssignment_6 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getSourceAssignment_6()); 
            // InternalTGG.g:4863:1: ( rule__CorrVariablePattern__SourceAssignment_6 )
            // InternalTGG.g:4863:2: rule__CorrVariablePattern__SourceAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__SourceAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getCorrVariablePatternAccess().getSourceAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__6__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__7"
    // InternalTGG.g:4873:1: rule__CorrVariablePattern__Group__7 : rule__CorrVariablePattern__Group__7__Impl rule__CorrVariablePattern__Group__8 ;
    public final void rule__CorrVariablePattern__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4877:1: ( rule__CorrVariablePattern__Group__7__Impl rule__CorrVariablePattern__Group__8 )
            // InternalTGG.g:4878:2: rule__CorrVariablePattern__Group__7__Impl rule__CorrVariablePattern__Group__8
            {
            pushFollow(FOLLOW_7);
            rule__CorrVariablePattern__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__7"


    // $ANTLR start "rule__CorrVariablePattern__Group__7__Impl"
    // InternalTGG.g:4885:1: rule__CorrVariablePattern__Group__7__Impl : ( '#trg->' ) ;
    public final void rule__CorrVariablePattern__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4889:1: ( ( '#trg->' ) )
            // InternalTGG.g:4890:1: ( '#trg->' )
            {
            // InternalTGG.g:4890:1: ( '#trg->' )
            // InternalTGG.g:4891:1: '#trg->'
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTrgKeyword_7()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getTrgKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__7__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__8"
    // InternalTGG.g:4904:1: rule__CorrVariablePattern__Group__8 : rule__CorrVariablePattern__Group__8__Impl rule__CorrVariablePattern__Group__9 ;
    public final void rule__CorrVariablePattern__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4908:1: ( rule__CorrVariablePattern__Group__8__Impl rule__CorrVariablePattern__Group__9 )
            // InternalTGG.g:4909:2: rule__CorrVariablePattern__Group__8__Impl rule__CorrVariablePattern__Group__9
            {
            pushFollow(FOLLOW_17);
            rule__CorrVariablePattern__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__8"


    // $ANTLR start "rule__CorrVariablePattern__Group__8__Impl"
    // InternalTGG.g:4916:1: rule__CorrVariablePattern__Group__8__Impl : ( ( rule__CorrVariablePattern__TargetAssignment_8 ) ) ;
    public final void rule__CorrVariablePattern__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4920:1: ( ( ( rule__CorrVariablePattern__TargetAssignment_8 ) ) )
            // InternalTGG.g:4921:1: ( ( rule__CorrVariablePattern__TargetAssignment_8 ) )
            {
            // InternalTGG.g:4921:1: ( ( rule__CorrVariablePattern__TargetAssignment_8 ) )
            // InternalTGG.g:4922:1: ( rule__CorrVariablePattern__TargetAssignment_8 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTargetAssignment_8()); 
            // InternalTGG.g:4923:1: ( rule__CorrVariablePattern__TargetAssignment_8 )
            // InternalTGG.g:4923:2: rule__CorrVariablePattern__TargetAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__TargetAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getCorrVariablePatternAccess().getTargetAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__8__Impl"


    // $ANTLR start "rule__CorrVariablePattern__Group__9"
    // InternalTGG.g:4933:1: rule__CorrVariablePattern__Group__9 : rule__CorrVariablePattern__Group__9__Impl ;
    public final void rule__CorrVariablePattern__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4937:1: ( rule__CorrVariablePattern__Group__9__Impl )
            // InternalTGG.g:4938:2: rule__CorrVariablePattern__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CorrVariablePattern__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__9"


    // $ANTLR start "rule__CorrVariablePattern__Group__9__Impl"
    // InternalTGG.g:4944:1: rule__CorrVariablePattern__Group__9__Impl : ( '}' ) ;
    public final void rule__CorrVariablePattern__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4948:1: ( ( '}' ) )
            // InternalTGG.g:4949:1: ( '}' )
            {
            // InternalTGG.g:4949:1: ( '}' )
            // InternalTGG.g:4950:1: '}'
            {
             before(grammarAccess.getCorrVariablePatternAccess().getRightCurlyBracketKeyword_9()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__Group__9__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group__0"
    // InternalTGG.g:4983:1: rule__ObjectVariablePattern__Group__0 : rule__ObjectVariablePattern__Group__0__Impl rule__ObjectVariablePattern__Group__1 ;
    public final void rule__ObjectVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4987:1: ( rule__ObjectVariablePattern__Group__0__Impl rule__ObjectVariablePattern__Group__1 )
            // InternalTGG.g:4988:2: rule__ObjectVariablePattern__Group__0__Impl rule__ObjectVariablePattern__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__ObjectVariablePattern__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__0"


    // $ANTLR start "rule__ObjectVariablePattern__Group__0__Impl"
    // InternalTGG.g:4995:1: rule__ObjectVariablePattern__Group__0__Impl : ( ( rule__ObjectVariablePattern__OpAssignment_0 )? ) ;
    public final void rule__ObjectVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:4999:1: ( ( ( rule__ObjectVariablePattern__OpAssignment_0 )? ) )
            // InternalTGG.g:5000:1: ( ( rule__ObjectVariablePattern__OpAssignment_0 )? )
            {
            // InternalTGG.g:5000:1: ( ( rule__ObjectVariablePattern__OpAssignment_0 )? )
            // InternalTGG.g:5001:1: ( rule__ObjectVariablePattern__OpAssignment_0 )?
            {
             before(grammarAccess.getObjectVariablePatternAccess().getOpAssignment_0()); 
            // InternalTGG.g:5002:1: ( rule__ObjectVariablePattern__OpAssignment_0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==56) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalTGG.g:5002:2: rule__ObjectVariablePattern__OpAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ObjectVariablePattern__OpAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectVariablePatternAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__0__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group__1"
    // InternalTGG.g:5012:1: rule__ObjectVariablePattern__Group__1 : rule__ObjectVariablePattern__Group__1__Impl rule__ObjectVariablePattern__Group__2 ;
    public final void rule__ObjectVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5016:1: ( rule__ObjectVariablePattern__Group__1__Impl rule__ObjectVariablePattern__Group__2 )
            // InternalTGG.g:5017:2: rule__ObjectVariablePattern__Group__1__Impl rule__ObjectVariablePattern__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__ObjectVariablePattern__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__1"


    // $ANTLR start "rule__ObjectVariablePattern__Group__1__Impl"
    // InternalTGG.g:5024:1: rule__ObjectVariablePattern__Group__1__Impl : ( ( rule__ObjectVariablePattern__NameAssignment_1 ) ) ;
    public final void rule__ObjectVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5028:1: ( ( ( rule__ObjectVariablePattern__NameAssignment_1 ) ) )
            // InternalTGG.g:5029:1: ( ( rule__ObjectVariablePattern__NameAssignment_1 ) )
            {
            // InternalTGG.g:5029:1: ( ( rule__ObjectVariablePattern__NameAssignment_1 ) )
            // InternalTGG.g:5030:1: ( rule__ObjectVariablePattern__NameAssignment_1 )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getNameAssignment_1()); 
            // InternalTGG.g:5031:1: ( rule__ObjectVariablePattern__NameAssignment_1 )
            // InternalTGG.g:5031:2: rule__ObjectVariablePattern__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getObjectVariablePatternAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__1__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group__2"
    // InternalTGG.g:5041:1: rule__ObjectVariablePattern__Group__2 : rule__ObjectVariablePattern__Group__2__Impl rule__ObjectVariablePattern__Group__3 ;
    public final void rule__ObjectVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5045:1: ( rule__ObjectVariablePattern__Group__2__Impl rule__ObjectVariablePattern__Group__3 )
            // InternalTGG.g:5046:2: rule__ObjectVariablePattern__Group__2__Impl rule__ObjectVariablePattern__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ObjectVariablePattern__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__2"


    // $ANTLR start "rule__ObjectVariablePattern__Group__2__Impl"
    // InternalTGG.g:5053:1: rule__ObjectVariablePattern__Group__2__Impl : ( ':' ) ;
    public final void rule__ObjectVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5057:1: ( ( ':' ) )
            // InternalTGG.g:5058:1: ( ':' )
            {
            // InternalTGG.g:5058:1: ( ':' )
            // InternalTGG.g:5059:1: ':'
            {
             before(grammarAccess.getObjectVariablePatternAccess().getColonKeyword_2()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getObjectVariablePatternAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__2__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group__3"
    // InternalTGG.g:5072:1: rule__ObjectVariablePattern__Group__3 : rule__ObjectVariablePattern__Group__3__Impl rule__ObjectVariablePattern__Group__4 ;
    public final void rule__ObjectVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5076:1: ( rule__ObjectVariablePattern__Group__3__Impl rule__ObjectVariablePattern__Group__4 )
            // InternalTGG.g:5077:2: rule__ObjectVariablePattern__Group__3__Impl rule__ObjectVariablePattern__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__ObjectVariablePattern__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__3"


    // $ANTLR start "rule__ObjectVariablePattern__Group__3__Impl"
    // InternalTGG.g:5084:1: rule__ObjectVariablePattern__Group__3__Impl : ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) ) ;
    public final void rule__ObjectVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5088:1: ( ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) ) )
            // InternalTGG.g:5089:1: ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) )
            {
            // InternalTGG.g:5089:1: ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) )
            // InternalTGG.g:5090:1: ( rule__ObjectVariablePattern__TypeAssignment_3 )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getTypeAssignment_3()); 
            // InternalTGG.g:5091:1: ( rule__ObjectVariablePattern__TypeAssignment_3 )
            // InternalTGG.g:5091:2: rule__ObjectVariablePattern__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getObjectVariablePatternAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__3__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group__4"
    // InternalTGG.g:5101:1: rule__ObjectVariablePattern__Group__4 : rule__ObjectVariablePattern__Group__4__Impl ;
    public final void rule__ObjectVariablePattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5105:1: ( rule__ObjectVariablePattern__Group__4__Impl )
            // InternalTGG.g:5106:2: rule__ObjectVariablePattern__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__4"


    // $ANTLR start "rule__ObjectVariablePattern__Group__4__Impl"
    // InternalTGG.g:5112:1: rule__ObjectVariablePattern__Group__4__Impl : ( ( rule__ObjectVariablePattern__Group_4__0 )? ) ;
    public final void rule__ObjectVariablePattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5116:1: ( ( ( rule__ObjectVariablePattern__Group_4__0 )? ) )
            // InternalTGG.g:5117:1: ( ( rule__ObjectVariablePattern__Group_4__0 )? )
            {
            // InternalTGG.g:5117:1: ( ( rule__ObjectVariablePattern__Group_4__0 )? )
            // InternalTGG.g:5118:1: ( rule__ObjectVariablePattern__Group_4__0 )?
            {
             before(grammarAccess.getObjectVariablePatternAccess().getGroup_4()); 
            // InternalTGG.g:5119:1: ( rule__ObjectVariablePattern__Group_4__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==23) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTGG.g:5119:2: rule__ObjectVariablePattern__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ObjectVariablePattern__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getObjectVariablePatternAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group__4__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__0"
    // InternalTGG.g:5139:1: rule__ObjectVariablePattern__Group_4__0 : rule__ObjectVariablePattern__Group_4__0__Impl rule__ObjectVariablePattern__Group_4__1 ;
    public final void rule__ObjectVariablePattern__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5143:1: ( rule__ObjectVariablePattern__Group_4__0__Impl rule__ObjectVariablePattern__Group_4__1 )
            // InternalTGG.g:5144:2: rule__ObjectVariablePattern__Group_4__0__Impl rule__ObjectVariablePattern__Group_4__1
            {
            pushFollow(FOLLOW_37);
            rule__ObjectVariablePattern__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__0"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__0__Impl"
    // InternalTGG.g:5151:1: rule__ObjectVariablePattern__Group_4__0__Impl : ( '{' ) ;
    public final void rule__ObjectVariablePattern__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5155:1: ( ( '{' ) )
            // InternalTGG.g:5156:1: ( '{' )
            {
            // InternalTGG.g:5156:1: ( '{' )
            // InternalTGG.g:5157:1: '{'
            {
             before(grammarAccess.getObjectVariablePatternAccess().getLeftCurlyBracketKeyword_4_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getObjectVariablePatternAccess().getLeftCurlyBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__0__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__1"
    // InternalTGG.g:5170:1: rule__ObjectVariablePattern__Group_4__1 : rule__ObjectVariablePattern__Group_4__1__Impl rule__ObjectVariablePattern__Group_4__2 ;
    public final void rule__ObjectVariablePattern__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5174:1: ( rule__ObjectVariablePattern__Group_4__1__Impl rule__ObjectVariablePattern__Group_4__2 )
            // InternalTGG.g:5175:2: rule__ObjectVariablePattern__Group_4__1__Impl rule__ObjectVariablePattern__Group_4__2
            {
            pushFollow(FOLLOW_37);
            rule__ObjectVariablePattern__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__1"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__1__Impl"
    // InternalTGG.g:5182:1: rule__ObjectVariablePattern__Group_4__1__Impl : ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* ) ;
    public final void rule__ObjectVariablePattern__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5186:1: ( ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* ) )
            // InternalTGG.g:5187:1: ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* )
            {
            // InternalTGG.g:5187:1: ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* )
            // InternalTGG.g:5188:1: ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )*
            {
             before(grammarAccess.getObjectVariablePatternAccess().getAttributeAssignmentsAssignment_4_1()); 
            // InternalTGG.g:5189:1: ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    int LA48_1 = input.LA(2);

                    if ( (LA48_1==54) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalTGG.g:5189:2: rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

             after(grammarAccess.getObjectVariablePatternAccess().getAttributeAssignmentsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__1__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__2"
    // InternalTGG.g:5199:1: rule__ObjectVariablePattern__Group_4__2 : rule__ObjectVariablePattern__Group_4__2__Impl rule__ObjectVariablePattern__Group_4__3 ;
    public final void rule__ObjectVariablePattern__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5203:1: ( rule__ObjectVariablePattern__Group_4__2__Impl rule__ObjectVariablePattern__Group_4__3 )
            // InternalTGG.g:5204:2: rule__ObjectVariablePattern__Group_4__2__Impl rule__ObjectVariablePattern__Group_4__3
            {
            pushFollow(FOLLOW_37);
            rule__ObjectVariablePattern__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__2"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__2__Impl"
    // InternalTGG.g:5211:1: rule__ObjectVariablePattern__Group_4__2__Impl : ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* ) ;
    public final void rule__ObjectVariablePattern__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5215:1: ( ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* ) )
            // InternalTGG.g:5216:1: ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* )
            {
            // InternalTGG.g:5216:1: ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* )
            // InternalTGG.g:5217:1: ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )*
            {
             before(grammarAccess.getObjectVariablePatternAccess().getAttributeConstraintsAssignment_4_2()); 
            // InternalTGG.g:5218:1: ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalTGG.g:5218:2: rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

             after(grammarAccess.getObjectVariablePatternAccess().getAttributeConstraintsAssignment_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__2__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__3"
    // InternalTGG.g:5228:1: rule__ObjectVariablePattern__Group_4__3 : rule__ObjectVariablePattern__Group_4__3__Impl rule__ObjectVariablePattern__Group_4__4 ;
    public final void rule__ObjectVariablePattern__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5232:1: ( rule__ObjectVariablePattern__Group_4__3__Impl rule__ObjectVariablePattern__Group_4__4 )
            // InternalTGG.g:5233:2: rule__ObjectVariablePattern__Group_4__3__Impl rule__ObjectVariablePattern__Group_4__4
            {
            pushFollow(FOLLOW_37);
            rule__ObjectVariablePattern__Group_4__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group_4__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__3"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__3__Impl"
    // InternalTGG.g:5240:1: rule__ObjectVariablePattern__Group_4__3__Impl : ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* ) ;
    public final void rule__ObjectVariablePattern__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5244:1: ( ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* ) )
            // InternalTGG.g:5245:1: ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* )
            {
            // InternalTGG.g:5245:1: ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* )
            // InternalTGG.g:5246:1: ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )*
            {
             before(grammarAccess.getObjectVariablePatternAccess().getLinkVariablePatternsAssignment_4_3()); 
            // InternalTGG.g:5247:1: ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==45||LA50_0==56) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalTGG.g:5247:2: rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3
            	    {
            	    pushFollow(FOLLOW_38);
            	    rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

             after(grammarAccess.getObjectVariablePatternAccess().getLinkVariablePatternsAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__3__Impl"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__4"
    // InternalTGG.g:5257:1: rule__ObjectVariablePattern__Group_4__4 : rule__ObjectVariablePattern__Group_4__4__Impl ;
    public final void rule__ObjectVariablePattern__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5261:1: ( rule__ObjectVariablePattern__Group_4__4__Impl )
            // InternalTGG.g:5262:2: rule__ObjectVariablePattern__Group_4__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ObjectVariablePattern__Group_4__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__4"


    // $ANTLR start "rule__ObjectVariablePattern__Group_4__4__Impl"
    // InternalTGG.g:5268:1: rule__ObjectVariablePattern__Group_4__4__Impl : ( '}' ) ;
    public final void rule__ObjectVariablePattern__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5272:1: ( ( '}' ) )
            // InternalTGG.g:5273:1: ( '}' )
            {
            // InternalTGG.g:5273:1: ( '}' )
            // InternalTGG.g:5274:1: '}'
            {
             before(grammarAccess.getObjectVariablePatternAccess().getRightCurlyBracketKeyword_4_4()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getObjectVariablePatternAccess().getRightCurlyBracketKeyword_4_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__Group_4__4__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__0"
    // InternalTGG.g:5297:1: rule__ContextObjectVariablePattern__Group__0 : rule__ContextObjectVariablePattern__Group__0__Impl rule__ContextObjectVariablePattern__Group__1 ;
    public final void rule__ContextObjectVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5301:1: ( rule__ContextObjectVariablePattern__Group__0__Impl rule__ContextObjectVariablePattern__Group__1 )
            // InternalTGG.g:5302:2: rule__ContextObjectVariablePattern__Group__0__Impl rule__ContextObjectVariablePattern__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__ContextObjectVariablePattern__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__0"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__0__Impl"
    // InternalTGG.g:5309:1: rule__ContextObjectVariablePattern__Group__0__Impl : ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) ) ;
    public final void rule__ContextObjectVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5313:1: ( ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) ) )
            // InternalTGG.g:5314:1: ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) )
            {
            // InternalTGG.g:5314:1: ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) )
            // InternalTGG.g:5315:1: ( rule__ContextObjectVariablePattern__NameAssignment_0 )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getNameAssignment_0()); 
            // InternalTGG.g:5316:1: ( rule__ContextObjectVariablePattern__NameAssignment_0 )
            // InternalTGG.g:5316:2: rule__ContextObjectVariablePattern__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getContextObjectVariablePatternAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__0__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__1"
    // InternalTGG.g:5326:1: rule__ContextObjectVariablePattern__Group__1 : rule__ContextObjectVariablePattern__Group__1__Impl rule__ContextObjectVariablePattern__Group__2 ;
    public final void rule__ContextObjectVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5330:1: ( rule__ContextObjectVariablePattern__Group__1__Impl rule__ContextObjectVariablePattern__Group__2 )
            // InternalTGG.g:5331:2: rule__ContextObjectVariablePattern__Group__1__Impl rule__ContextObjectVariablePattern__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ContextObjectVariablePattern__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__1"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__1__Impl"
    // InternalTGG.g:5338:1: rule__ContextObjectVariablePattern__Group__1__Impl : ( ':' ) ;
    public final void rule__ContextObjectVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5342:1: ( ( ':' ) )
            // InternalTGG.g:5343:1: ( ':' )
            {
            // InternalTGG.g:5343:1: ( ':' )
            // InternalTGG.g:5344:1: ':'
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getColonKeyword_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getContextObjectVariablePatternAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__1__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__2"
    // InternalTGG.g:5357:1: rule__ContextObjectVariablePattern__Group__2 : rule__ContextObjectVariablePattern__Group__2__Impl rule__ContextObjectVariablePattern__Group__3 ;
    public final void rule__ContextObjectVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5361:1: ( rule__ContextObjectVariablePattern__Group__2__Impl rule__ContextObjectVariablePattern__Group__3 )
            // InternalTGG.g:5362:2: rule__ContextObjectVariablePattern__Group__2__Impl rule__ContextObjectVariablePattern__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__ContextObjectVariablePattern__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__2"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__2__Impl"
    // InternalTGG.g:5369:1: rule__ContextObjectVariablePattern__Group__2__Impl : ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) ) ;
    public final void rule__ContextObjectVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5373:1: ( ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) ) )
            // InternalTGG.g:5374:1: ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) )
            {
            // InternalTGG.g:5374:1: ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) )
            // InternalTGG.g:5375:1: ( rule__ContextObjectVariablePattern__TypeAssignment_2 )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getTypeAssignment_2()); 
            // InternalTGG.g:5376:1: ( rule__ContextObjectVariablePattern__TypeAssignment_2 )
            // InternalTGG.g:5376:2: rule__ContextObjectVariablePattern__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getContextObjectVariablePatternAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__2__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__3"
    // InternalTGG.g:5386:1: rule__ContextObjectVariablePattern__Group__3 : rule__ContextObjectVariablePattern__Group__3__Impl ;
    public final void rule__ContextObjectVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5390:1: ( rule__ContextObjectVariablePattern__Group__3__Impl )
            // InternalTGG.g:5391:2: rule__ContextObjectVariablePattern__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__3"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group__3__Impl"
    // InternalTGG.g:5397:1: rule__ContextObjectVariablePattern__Group__3__Impl : ( ( rule__ContextObjectVariablePattern__Group_3__0 )? ) ;
    public final void rule__ContextObjectVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5401:1: ( ( ( rule__ContextObjectVariablePattern__Group_3__0 )? ) )
            // InternalTGG.g:5402:1: ( ( rule__ContextObjectVariablePattern__Group_3__0 )? )
            {
            // InternalTGG.g:5402:1: ( ( rule__ContextObjectVariablePattern__Group_3__0 )? )
            // InternalTGG.g:5403:1: ( rule__ContextObjectVariablePattern__Group_3__0 )?
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getGroup_3()); 
            // InternalTGG.g:5404:1: ( rule__ContextObjectVariablePattern__Group_3__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==23) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalTGG.g:5404:2: rule__ContextObjectVariablePattern__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ContextObjectVariablePattern__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getContextObjectVariablePatternAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group__3__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__0"
    // InternalTGG.g:5422:1: rule__ContextObjectVariablePattern__Group_3__0 : rule__ContextObjectVariablePattern__Group_3__0__Impl rule__ContextObjectVariablePattern__Group_3__1 ;
    public final void rule__ContextObjectVariablePattern__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5426:1: ( rule__ContextObjectVariablePattern__Group_3__0__Impl rule__ContextObjectVariablePattern__Group_3__1 )
            // InternalTGG.g:5427:2: rule__ContextObjectVariablePattern__Group_3__0__Impl rule__ContextObjectVariablePattern__Group_3__1
            {
            pushFollow(FOLLOW_39);
            rule__ContextObjectVariablePattern__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__0"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__0__Impl"
    // InternalTGG.g:5434:1: rule__ContextObjectVariablePattern__Group_3__0__Impl : ( '{' ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5438:1: ( ( '{' ) )
            // InternalTGG.g:5439:1: ( '{' )
            {
            // InternalTGG.g:5439:1: ( '{' )
            // InternalTGG.g:5440:1: '{'
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getLeftCurlyBracketKeyword_3_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getContextObjectVariablePatternAccess().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__0__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__1"
    // InternalTGG.g:5453:1: rule__ContextObjectVariablePattern__Group_3__1 : rule__ContextObjectVariablePattern__Group_3__1__Impl rule__ContextObjectVariablePattern__Group_3__2 ;
    public final void rule__ContextObjectVariablePattern__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5457:1: ( rule__ContextObjectVariablePattern__Group_3__1__Impl rule__ContextObjectVariablePattern__Group_3__2 )
            // InternalTGG.g:5458:2: rule__ContextObjectVariablePattern__Group_3__1__Impl rule__ContextObjectVariablePattern__Group_3__2
            {
            pushFollow(FOLLOW_39);
            rule__ContextObjectVariablePattern__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__1"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__1__Impl"
    // InternalTGG.g:5465:1: rule__ContextObjectVariablePattern__Group_3__1__Impl : ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5469:1: ( ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* ) )
            // InternalTGG.g:5470:1: ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* )
            {
            // InternalTGG.g:5470:1: ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* )
            // InternalTGG.g:5471:1: ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )*
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getAttributeConstraintsAssignment_3_1()); 
            // InternalTGG.g:5472:1: ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalTGG.g:5472:2: rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getContextObjectVariablePatternAccess().getAttributeConstraintsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__1__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__2"
    // InternalTGG.g:5482:1: rule__ContextObjectVariablePattern__Group_3__2 : rule__ContextObjectVariablePattern__Group_3__2__Impl rule__ContextObjectVariablePattern__Group_3__3 ;
    public final void rule__ContextObjectVariablePattern__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5486:1: ( rule__ContextObjectVariablePattern__Group_3__2__Impl rule__ContextObjectVariablePattern__Group_3__3 )
            // InternalTGG.g:5487:2: rule__ContextObjectVariablePattern__Group_3__2__Impl rule__ContextObjectVariablePattern__Group_3__3
            {
            pushFollow(FOLLOW_39);
            rule__ContextObjectVariablePattern__Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__2"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__2__Impl"
    // InternalTGG.g:5494:1: rule__ContextObjectVariablePattern__Group_3__2__Impl : ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5498:1: ( ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* ) )
            // InternalTGG.g:5499:1: ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* )
            {
            // InternalTGG.g:5499:1: ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* )
            // InternalTGG.g:5500:1: ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )*
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getLinkVariablePatternsAssignment_3_2()); 
            // InternalTGG.g:5501:1: ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==45) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalTGG.g:5501:2: rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2
            	    {
            	    pushFollow(FOLLOW_40);
            	    rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getContextObjectVariablePatternAccess().getLinkVariablePatternsAssignment_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__2__Impl"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__3"
    // InternalTGG.g:5511:1: rule__ContextObjectVariablePattern__Group_3__3 : rule__ContextObjectVariablePattern__Group_3__3__Impl ;
    public final void rule__ContextObjectVariablePattern__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5515:1: ( rule__ContextObjectVariablePattern__Group_3__3__Impl )
            // InternalTGG.g:5516:2: rule__ContextObjectVariablePattern__Group_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ContextObjectVariablePattern__Group_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__3"


    // $ANTLR start "rule__ContextObjectVariablePattern__Group_3__3__Impl"
    // InternalTGG.g:5522:1: rule__ContextObjectVariablePattern__Group_3__3__Impl : ( '}' ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5526:1: ( ( '}' ) )
            // InternalTGG.g:5527:1: ( '}' )
            {
            // InternalTGG.g:5527:1: ( '}' )
            // InternalTGG.g:5528:1: '}'
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getRightCurlyBracketKeyword_3_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getContextObjectVariablePatternAccess().getRightCurlyBracketKeyword_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__Group_3__3__Impl"


    // $ANTLR start "rule__AttributeConstraint__Group__0"
    // InternalTGG.g:5549:1: rule__AttributeConstraint__Group__0 : rule__AttributeConstraint__Group__0__Impl rule__AttributeConstraint__Group__1 ;
    public final void rule__AttributeConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5553:1: ( rule__AttributeConstraint__Group__0__Impl rule__AttributeConstraint__Group__1 )
            // InternalTGG.g:5554:2: rule__AttributeConstraint__Group__0__Impl rule__AttributeConstraint__Group__1
            {
            pushFollow(FOLLOW_41);
            rule__AttributeConstraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__Group__0"


    // $ANTLR start "rule__AttributeConstraint__Group__0__Impl"
    // InternalTGG.g:5561:1: rule__AttributeConstraint__Group__0__Impl : ( ( rule__AttributeConstraint__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5565:1: ( ( ( rule__AttributeConstraint__AttributeAssignment_0 ) ) )
            // InternalTGG.g:5566:1: ( ( rule__AttributeConstraint__AttributeAssignment_0 ) )
            {
            // InternalTGG.g:5566:1: ( ( rule__AttributeConstraint__AttributeAssignment_0 ) )
            // InternalTGG.g:5567:1: ( rule__AttributeConstraint__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getAttributeAssignment_0()); 
            // InternalTGG.g:5568:1: ( rule__AttributeConstraint__AttributeAssignment_0 )
            // InternalTGG.g:5568:2: rule__AttributeConstraint__AttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__AttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeConstraintAccess().getAttributeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__Group__0__Impl"


    // $ANTLR start "rule__AttributeConstraint__Group__1"
    // InternalTGG.g:5578:1: rule__AttributeConstraint__Group__1 : rule__AttributeConstraint__Group__1__Impl rule__AttributeConstraint__Group__2 ;
    public final void rule__AttributeConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5582:1: ( rule__AttributeConstraint__Group__1__Impl rule__AttributeConstraint__Group__2 )
            // InternalTGG.g:5583:2: rule__AttributeConstraint__Group__1__Impl rule__AttributeConstraint__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__AttributeConstraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__Group__1"


    // $ANTLR start "rule__AttributeConstraint__Group__1__Impl"
    // InternalTGG.g:5590:1: rule__AttributeConstraint__Group__1__Impl : ( ( rule__AttributeConstraint__OpAssignment_1 ) ) ;
    public final void rule__AttributeConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5594:1: ( ( ( rule__AttributeConstraint__OpAssignment_1 ) ) )
            // InternalTGG.g:5595:1: ( ( rule__AttributeConstraint__OpAssignment_1 ) )
            {
            // InternalTGG.g:5595:1: ( ( rule__AttributeConstraint__OpAssignment_1 ) )
            // InternalTGG.g:5596:1: ( rule__AttributeConstraint__OpAssignment_1 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getOpAssignment_1()); 
            // InternalTGG.g:5597:1: ( rule__AttributeConstraint__OpAssignment_1 )
            // InternalTGG.g:5597:2: rule__AttributeConstraint__OpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__OpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeConstraintAccess().getOpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__Group__1__Impl"


    // $ANTLR start "rule__AttributeConstraint__Group__2"
    // InternalTGG.g:5607:1: rule__AttributeConstraint__Group__2 : rule__AttributeConstraint__Group__2__Impl ;
    public final void rule__AttributeConstraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5611:1: ( rule__AttributeConstraint__Group__2__Impl )
            // InternalTGG.g:5612:2: rule__AttributeConstraint__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__Group__2"


    // $ANTLR start "rule__AttributeConstraint__Group__2__Impl"
    // InternalTGG.g:5618:1: rule__AttributeConstraint__Group__2__Impl : ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) ) ;
    public final void rule__AttributeConstraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5622:1: ( ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) ) )
            // InternalTGG.g:5623:1: ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) )
            {
            // InternalTGG.g:5623:1: ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) )
            // InternalTGG.g:5624:1: ( rule__AttributeConstraint__ValueExpAssignment_2 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getValueExpAssignment_2()); 
            // InternalTGG.g:5625:1: ( rule__AttributeConstraint__ValueExpAssignment_2 )
            // InternalTGG.g:5625:2: rule__AttributeConstraint__ValueExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__ValueExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeConstraintAccess().getValueExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__Group__2__Impl"


    // $ANTLR start "rule__AttributeAssignment__Group__0"
    // InternalTGG.g:5641:1: rule__AttributeAssignment__Group__0 : rule__AttributeAssignment__Group__0__Impl rule__AttributeAssignment__Group__1 ;
    public final void rule__AttributeAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5645:1: ( rule__AttributeAssignment__Group__0__Impl rule__AttributeAssignment__Group__1 )
            // InternalTGG.g:5646:2: rule__AttributeAssignment__Group__0__Impl rule__AttributeAssignment__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__AttributeAssignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeAssignment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__Group__0"


    // $ANTLR start "rule__AttributeAssignment__Group__0__Impl"
    // InternalTGG.g:5653:1: rule__AttributeAssignment__Group__0__Impl : ( ( rule__AttributeAssignment__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5657:1: ( ( ( rule__AttributeAssignment__AttributeAssignment_0 ) ) )
            // InternalTGG.g:5658:1: ( ( rule__AttributeAssignment__AttributeAssignment_0 ) )
            {
            // InternalTGG.g:5658:1: ( ( rule__AttributeAssignment__AttributeAssignment_0 ) )
            // InternalTGG.g:5659:1: ( rule__AttributeAssignment__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getAttributeAssignment_0()); 
            // InternalTGG.g:5660:1: ( rule__AttributeAssignment__AttributeAssignment_0 )
            // InternalTGG.g:5660:2: rule__AttributeAssignment__AttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeAssignment__AttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAssignmentAccess().getAttributeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__Group__0__Impl"


    // $ANTLR start "rule__AttributeAssignment__Group__1"
    // InternalTGG.g:5670:1: rule__AttributeAssignment__Group__1 : rule__AttributeAssignment__Group__1__Impl rule__AttributeAssignment__Group__2 ;
    public final void rule__AttributeAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5674:1: ( rule__AttributeAssignment__Group__1__Impl rule__AttributeAssignment__Group__2 )
            // InternalTGG.g:5675:2: rule__AttributeAssignment__Group__1__Impl rule__AttributeAssignment__Group__2
            {
            pushFollow(FOLLOW_32);
            rule__AttributeAssignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeAssignment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__Group__1"


    // $ANTLR start "rule__AttributeAssignment__Group__1__Impl"
    // InternalTGG.g:5682:1: rule__AttributeAssignment__Group__1__Impl : ( ( rule__AttributeAssignment__OpAssignment_1 ) ) ;
    public final void rule__AttributeAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5686:1: ( ( ( rule__AttributeAssignment__OpAssignment_1 ) ) )
            // InternalTGG.g:5687:1: ( ( rule__AttributeAssignment__OpAssignment_1 ) )
            {
            // InternalTGG.g:5687:1: ( ( rule__AttributeAssignment__OpAssignment_1 ) )
            // InternalTGG.g:5688:1: ( rule__AttributeAssignment__OpAssignment_1 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getOpAssignment_1()); 
            // InternalTGG.g:5689:1: ( rule__AttributeAssignment__OpAssignment_1 )
            // InternalTGG.g:5689:2: rule__AttributeAssignment__OpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeAssignment__OpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAssignmentAccess().getOpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__Group__1__Impl"


    // $ANTLR start "rule__AttributeAssignment__Group__2"
    // InternalTGG.g:5699:1: rule__AttributeAssignment__Group__2 : rule__AttributeAssignment__Group__2__Impl ;
    public final void rule__AttributeAssignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5703:1: ( rule__AttributeAssignment__Group__2__Impl )
            // InternalTGG.g:5704:2: rule__AttributeAssignment__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeAssignment__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__Group__2"


    // $ANTLR start "rule__AttributeAssignment__Group__2__Impl"
    // InternalTGG.g:5710:1: rule__AttributeAssignment__Group__2__Impl : ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) ) ;
    public final void rule__AttributeAssignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5714:1: ( ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) ) )
            // InternalTGG.g:5715:1: ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) )
            {
            // InternalTGG.g:5715:1: ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) )
            // InternalTGG.g:5716:1: ( rule__AttributeAssignment__ValueExpAssignment_2 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getValueExpAssignment_2()); 
            // InternalTGG.g:5717:1: ( rule__AttributeAssignment__ValueExpAssignment_2 )
            // InternalTGG.g:5717:2: rule__AttributeAssignment__ValueExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AttributeAssignment__ValueExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAssignmentAccess().getValueExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__Group__2__Impl"


    // $ANTLR start "rule__EnumExpression__Group__0"
    // InternalTGG.g:5733:1: rule__EnumExpression__Group__0 : rule__EnumExpression__Group__0__Impl rule__EnumExpression__Group__1 ;
    public final void rule__EnumExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5737:1: ( rule__EnumExpression__Group__0__Impl rule__EnumExpression__Group__1 )
            // InternalTGG.g:5738:2: rule__EnumExpression__Group__0__Impl rule__EnumExpression__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__EnumExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__0"


    // $ANTLR start "rule__EnumExpression__Group__0__Impl"
    // InternalTGG.g:5745:1: rule__EnumExpression__Group__0__Impl : ( 'enum::' ) ;
    public final void rule__EnumExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5749:1: ( ( 'enum::' ) )
            // InternalTGG.g:5750:1: ( 'enum::' )
            {
            // InternalTGG.g:5750:1: ( 'enum::' )
            // InternalTGG.g:5751:1: 'enum::'
            {
             before(grammarAccess.getEnumExpressionAccess().getEnumKeyword_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getEnumExpressionAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__0__Impl"


    // $ANTLR start "rule__EnumExpression__Group__1"
    // InternalTGG.g:5764:1: rule__EnumExpression__Group__1 : rule__EnumExpression__Group__1__Impl rule__EnumExpression__Group__2 ;
    public final void rule__EnumExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5768:1: ( rule__EnumExpression__Group__1__Impl rule__EnumExpression__Group__2 )
            // InternalTGG.g:5769:2: rule__EnumExpression__Group__1__Impl rule__EnumExpression__Group__2
            {
            pushFollow(FOLLOW_43);
            rule__EnumExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__1"


    // $ANTLR start "rule__EnumExpression__Group__1__Impl"
    // InternalTGG.g:5776:1: rule__EnumExpression__Group__1__Impl : ( ( rule__EnumExpression__EenumAssignment_1 ) ) ;
    public final void rule__EnumExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5780:1: ( ( ( rule__EnumExpression__EenumAssignment_1 ) ) )
            // InternalTGG.g:5781:1: ( ( rule__EnumExpression__EenumAssignment_1 ) )
            {
            // InternalTGG.g:5781:1: ( ( rule__EnumExpression__EenumAssignment_1 ) )
            // InternalTGG.g:5782:1: ( rule__EnumExpression__EenumAssignment_1 )
            {
             before(grammarAccess.getEnumExpressionAccess().getEenumAssignment_1()); 
            // InternalTGG.g:5783:1: ( rule__EnumExpression__EenumAssignment_1 )
            // InternalTGG.g:5783:2: rule__EnumExpression__EenumAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EnumExpression__EenumAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumExpressionAccess().getEenumAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__1__Impl"


    // $ANTLR start "rule__EnumExpression__Group__2"
    // InternalTGG.g:5793:1: rule__EnumExpression__Group__2 : rule__EnumExpression__Group__2__Impl rule__EnumExpression__Group__3 ;
    public final void rule__EnumExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5797:1: ( rule__EnumExpression__Group__2__Impl rule__EnumExpression__Group__3 )
            // InternalTGG.g:5798:2: rule__EnumExpression__Group__2__Impl rule__EnumExpression__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__EnumExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EnumExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__2"


    // $ANTLR start "rule__EnumExpression__Group__2__Impl"
    // InternalTGG.g:5805:1: rule__EnumExpression__Group__2__Impl : ( '::' ) ;
    public final void rule__EnumExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5809:1: ( ( '::' ) )
            // InternalTGG.g:5810:1: ( '::' )
            {
            // InternalTGG.g:5810:1: ( '::' )
            // InternalTGG.g:5811:1: '::'
            {
             before(grammarAccess.getEnumExpressionAccess().getColonColonKeyword_2()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getEnumExpressionAccess().getColonColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__2__Impl"


    // $ANTLR start "rule__EnumExpression__Group__3"
    // InternalTGG.g:5824:1: rule__EnumExpression__Group__3 : rule__EnumExpression__Group__3__Impl ;
    public final void rule__EnumExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5828:1: ( rule__EnumExpression__Group__3__Impl )
            // InternalTGG.g:5829:2: rule__EnumExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EnumExpression__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__3"


    // $ANTLR start "rule__EnumExpression__Group__3__Impl"
    // InternalTGG.g:5835:1: rule__EnumExpression__Group__3__Impl : ( ( rule__EnumExpression__LiteralAssignment_3 ) ) ;
    public final void rule__EnumExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5839:1: ( ( ( rule__EnumExpression__LiteralAssignment_3 ) ) )
            // InternalTGG.g:5840:1: ( ( rule__EnumExpression__LiteralAssignment_3 ) )
            {
            // InternalTGG.g:5840:1: ( ( rule__EnumExpression__LiteralAssignment_3 ) )
            // InternalTGG.g:5841:1: ( rule__EnumExpression__LiteralAssignment_3 )
            {
             before(grammarAccess.getEnumExpressionAccess().getLiteralAssignment_3()); 
            // InternalTGG.g:5842:1: ( rule__EnumExpression__LiteralAssignment_3 )
            // InternalTGG.g:5842:2: rule__EnumExpression__LiteralAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EnumExpression__LiteralAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEnumExpressionAccess().getLiteralAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__Group__3__Impl"


    // $ANTLR start "rule__AttributeExpression__Group__0"
    // InternalTGG.g:5860:1: rule__AttributeExpression__Group__0 : rule__AttributeExpression__Group__0__Impl rule__AttributeExpression__Group__1 ;
    public final void rule__AttributeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5864:1: ( rule__AttributeExpression__Group__0__Impl rule__AttributeExpression__Group__1 )
            // InternalTGG.g:5865:2: rule__AttributeExpression__Group__0__Impl rule__AttributeExpression__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__AttributeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__0"


    // $ANTLR start "rule__AttributeExpression__Group__0__Impl"
    // InternalTGG.g:5872:1: rule__AttributeExpression__Group__0__Impl : ( ( rule__AttributeExpression__DerivedAssignment_0 )? ) ;
    public final void rule__AttributeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5876:1: ( ( ( rule__AttributeExpression__DerivedAssignment_0 )? ) )
            // InternalTGG.g:5877:1: ( ( rule__AttributeExpression__DerivedAssignment_0 )? )
            {
            // InternalTGG.g:5877:1: ( ( rule__AttributeExpression__DerivedAssignment_0 )? )
            // InternalTGG.g:5878:1: ( rule__AttributeExpression__DerivedAssignment_0 )?
            {
             before(grammarAccess.getAttributeExpressionAccess().getDerivedAssignment_0()); 
            // InternalTGG.g:5879:1: ( rule__AttributeExpression__DerivedAssignment_0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==55) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalTGG.g:5879:2: rule__AttributeExpression__DerivedAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AttributeExpression__DerivedAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeExpressionAccess().getDerivedAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__0__Impl"


    // $ANTLR start "rule__AttributeExpression__Group__1"
    // InternalTGG.g:5889:1: rule__AttributeExpression__Group__1 : rule__AttributeExpression__Group__1__Impl rule__AttributeExpression__Group__2 ;
    public final void rule__AttributeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5893:1: ( rule__AttributeExpression__Group__1__Impl rule__AttributeExpression__Group__2 )
            // InternalTGG.g:5894:2: rule__AttributeExpression__Group__1__Impl rule__AttributeExpression__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__AttributeExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__1"


    // $ANTLR start "rule__AttributeExpression__Group__1__Impl"
    // InternalTGG.g:5901:1: rule__AttributeExpression__Group__1__Impl : ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) ) ;
    public final void rule__AttributeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5905:1: ( ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) ) )
            // InternalTGG.g:5906:1: ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) )
            {
            // InternalTGG.g:5906:1: ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) )
            // InternalTGG.g:5907:1: ( rule__AttributeExpression__ObjectVarAssignment_1 )
            {
             before(grammarAccess.getAttributeExpressionAccess().getObjectVarAssignment_1()); 
            // InternalTGG.g:5908:1: ( rule__AttributeExpression__ObjectVarAssignment_1 )
            // InternalTGG.g:5908:2: rule__AttributeExpression__ObjectVarAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__AttributeExpression__ObjectVarAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAttributeExpressionAccess().getObjectVarAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__1__Impl"


    // $ANTLR start "rule__AttributeExpression__Group__2"
    // InternalTGG.g:5918:1: rule__AttributeExpression__Group__2 : rule__AttributeExpression__Group__2__Impl rule__AttributeExpression__Group__3 ;
    public final void rule__AttributeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5922:1: ( rule__AttributeExpression__Group__2__Impl rule__AttributeExpression__Group__3 )
            // InternalTGG.g:5923:2: rule__AttributeExpression__Group__2__Impl rule__AttributeExpression__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__AttributeExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AttributeExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__2"


    // $ANTLR start "rule__AttributeExpression__Group__2__Impl"
    // InternalTGG.g:5930:1: rule__AttributeExpression__Group__2__Impl : ( '.' ) ;
    public final void rule__AttributeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5934:1: ( ( '.' ) )
            // InternalTGG.g:5935:1: ( '.' )
            {
            // InternalTGG.g:5935:1: ( '.' )
            // InternalTGG.g:5936:1: '.'
            {
             before(grammarAccess.getAttributeExpressionAccess().getFullStopKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getAttributeExpressionAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__2__Impl"


    // $ANTLR start "rule__AttributeExpression__Group__3"
    // InternalTGG.g:5949:1: rule__AttributeExpression__Group__3 : rule__AttributeExpression__Group__3__Impl ;
    public final void rule__AttributeExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5953:1: ( rule__AttributeExpression__Group__3__Impl )
            // InternalTGG.g:5954:2: rule__AttributeExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AttributeExpression__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__3"


    // $ANTLR start "rule__AttributeExpression__Group__3__Impl"
    // InternalTGG.g:5960:1: rule__AttributeExpression__Group__3__Impl : ( ( rule__AttributeExpression__AttributeAssignment_3 ) ) ;
    public final void rule__AttributeExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5964:1: ( ( ( rule__AttributeExpression__AttributeAssignment_3 ) ) )
            // InternalTGG.g:5965:1: ( ( rule__AttributeExpression__AttributeAssignment_3 ) )
            {
            // InternalTGG.g:5965:1: ( ( rule__AttributeExpression__AttributeAssignment_3 ) )
            // InternalTGG.g:5966:1: ( rule__AttributeExpression__AttributeAssignment_3 )
            {
             before(grammarAccess.getAttributeExpressionAccess().getAttributeAssignment_3()); 
            // InternalTGG.g:5967:1: ( rule__AttributeExpression__AttributeAssignment_3 )
            // InternalTGG.g:5967:2: rule__AttributeExpression__AttributeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AttributeExpression__AttributeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAttributeExpressionAccess().getAttributeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__Group__3__Impl"


    // $ANTLR start "rule__LinkVariablePattern__Group__0"
    // InternalTGG.g:5985:1: rule__LinkVariablePattern__Group__0 : rule__LinkVariablePattern__Group__0__Impl rule__LinkVariablePattern__Group__1 ;
    public final void rule__LinkVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:5989:1: ( rule__LinkVariablePattern__Group__0__Impl rule__LinkVariablePattern__Group__1 )
            // InternalTGG.g:5990:2: rule__LinkVariablePattern__Group__0__Impl rule__LinkVariablePattern__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__LinkVariablePattern__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__0"


    // $ANTLR start "rule__LinkVariablePattern__Group__0__Impl"
    // InternalTGG.g:5997:1: rule__LinkVariablePattern__Group__0__Impl : ( ( rule__LinkVariablePattern__OpAssignment_0 )? ) ;
    public final void rule__LinkVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6001:1: ( ( ( rule__LinkVariablePattern__OpAssignment_0 )? ) )
            // InternalTGG.g:6002:1: ( ( rule__LinkVariablePattern__OpAssignment_0 )? )
            {
            // InternalTGG.g:6002:1: ( ( rule__LinkVariablePattern__OpAssignment_0 )? )
            // InternalTGG.g:6003:1: ( rule__LinkVariablePattern__OpAssignment_0 )?
            {
             before(grammarAccess.getLinkVariablePatternAccess().getOpAssignment_0()); 
            // InternalTGG.g:6004:1: ( rule__LinkVariablePattern__OpAssignment_0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalTGG.g:6004:2: rule__LinkVariablePattern__OpAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__LinkVariablePattern__OpAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLinkVariablePatternAccess().getOpAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__0__Impl"


    // $ANTLR start "rule__LinkVariablePattern__Group__1"
    // InternalTGG.g:6014:1: rule__LinkVariablePattern__Group__1 : rule__LinkVariablePattern__Group__1__Impl rule__LinkVariablePattern__Group__2 ;
    public final void rule__LinkVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6018:1: ( rule__LinkVariablePattern__Group__1__Impl rule__LinkVariablePattern__Group__2 )
            // InternalTGG.g:6019:2: rule__LinkVariablePattern__Group__1__Impl rule__LinkVariablePattern__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__LinkVariablePattern__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__1"


    // $ANTLR start "rule__LinkVariablePattern__Group__1__Impl"
    // InternalTGG.g:6026:1: rule__LinkVariablePattern__Group__1__Impl : ( '-' ) ;
    public final void rule__LinkVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6030:1: ( ( '-' ) )
            // InternalTGG.g:6031:1: ( '-' )
            {
            // InternalTGG.g:6031:1: ( '-' )
            // InternalTGG.g:6032:1: '-'
            {
             before(grammarAccess.getLinkVariablePatternAccess().getHyphenMinusKeyword_1()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getLinkVariablePatternAccess().getHyphenMinusKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__1__Impl"


    // $ANTLR start "rule__LinkVariablePattern__Group__2"
    // InternalTGG.g:6045:1: rule__LinkVariablePattern__Group__2 : rule__LinkVariablePattern__Group__2__Impl rule__LinkVariablePattern__Group__3 ;
    public final void rule__LinkVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6049:1: ( rule__LinkVariablePattern__Group__2__Impl rule__LinkVariablePattern__Group__3 )
            // InternalTGG.g:6050:2: rule__LinkVariablePattern__Group__2__Impl rule__LinkVariablePattern__Group__3
            {
            pushFollow(FOLLOW_47);
            rule__LinkVariablePattern__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__2"


    // $ANTLR start "rule__LinkVariablePattern__Group__2__Impl"
    // InternalTGG.g:6057:1: rule__LinkVariablePattern__Group__2__Impl : ( ( rule__LinkVariablePattern__TypeAssignment_2 ) ) ;
    public final void rule__LinkVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6061:1: ( ( ( rule__LinkVariablePattern__TypeAssignment_2 ) ) )
            // InternalTGG.g:6062:1: ( ( rule__LinkVariablePattern__TypeAssignment_2 ) )
            {
            // InternalTGG.g:6062:1: ( ( rule__LinkVariablePattern__TypeAssignment_2 ) )
            // InternalTGG.g:6063:1: ( rule__LinkVariablePattern__TypeAssignment_2 )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTypeAssignment_2()); 
            // InternalTGG.g:6064:1: ( rule__LinkVariablePattern__TypeAssignment_2 )
            // InternalTGG.g:6064:2: rule__LinkVariablePattern__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLinkVariablePatternAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__2__Impl"


    // $ANTLR start "rule__LinkVariablePattern__Group__3"
    // InternalTGG.g:6074:1: rule__LinkVariablePattern__Group__3 : rule__LinkVariablePattern__Group__3__Impl rule__LinkVariablePattern__Group__4 ;
    public final void rule__LinkVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6078:1: ( rule__LinkVariablePattern__Group__3__Impl rule__LinkVariablePattern__Group__4 )
            // InternalTGG.g:6079:2: rule__LinkVariablePattern__Group__3__Impl rule__LinkVariablePattern__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__LinkVariablePattern__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__3"


    // $ANTLR start "rule__LinkVariablePattern__Group__3__Impl"
    // InternalTGG.g:6086:1: rule__LinkVariablePattern__Group__3__Impl : ( '->' ) ;
    public final void rule__LinkVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6090:1: ( ( '->' ) )
            // InternalTGG.g:6091:1: ( '->' )
            {
            // InternalTGG.g:6091:1: ( '->' )
            // InternalTGG.g:6092:1: '->'
            {
             before(grammarAccess.getLinkVariablePatternAccess().getHyphenMinusGreaterThanSignKeyword_3()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getLinkVariablePatternAccess().getHyphenMinusGreaterThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__3__Impl"


    // $ANTLR start "rule__LinkVariablePattern__Group__4"
    // InternalTGG.g:6105:1: rule__LinkVariablePattern__Group__4 : rule__LinkVariablePattern__Group__4__Impl ;
    public final void rule__LinkVariablePattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6109:1: ( rule__LinkVariablePattern__Group__4__Impl )
            // InternalTGG.g:6110:2: rule__LinkVariablePattern__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__4"


    // $ANTLR start "rule__LinkVariablePattern__Group__4__Impl"
    // InternalTGG.g:6116:1: rule__LinkVariablePattern__Group__4__Impl : ( ( rule__LinkVariablePattern__TargetAssignment_4 ) ) ;
    public final void rule__LinkVariablePattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6120:1: ( ( ( rule__LinkVariablePattern__TargetAssignment_4 ) ) )
            // InternalTGG.g:6121:1: ( ( rule__LinkVariablePattern__TargetAssignment_4 ) )
            {
            // InternalTGG.g:6121:1: ( ( rule__LinkVariablePattern__TargetAssignment_4 ) )
            // InternalTGG.g:6122:1: ( rule__LinkVariablePattern__TargetAssignment_4 )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTargetAssignment_4()); 
            // InternalTGG.g:6123:1: ( rule__LinkVariablePattern__TargetAssignment_4 )
            // InternalTGG.g:6123:2: rule__LinkVariablePattern__TargetAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LinkVariablePattern__TargetAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLinkVariablePatternAccess().getTargetAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__Group__4__Impl"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__0"
    // InternalTGG.g:6143:1: rule__ContextLinkVariablePattern__Group__0 : rule__ContextLinkVariablePattern__Group__0__Impl rule__ContextLinkVariablePattern__Group__1 ;
    public final void rule__ContextLinkVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6147:1: ( rule__ContextLinkVariablePattern__Group__0__Impl rule__ContextLinkVariablePattern__Group__1 )
            // InternalTGG.g:6148:2: rule__ContextLinkVariablePattern__Group__0__Impl rule__ContextLinkVariablePattern__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__ContextLinkVariablePattern__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextLinkVariablePattern__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__0"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__0__Impl"
    // InternalTGG.g:6155:1: rule__ContextLinkVariablePattern__Group__0__Impl : ( '-' ) ;
    public final void rule__ContextLinkVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6159:1: ( ( '-' ) )
            // InternalTGG.g:6160:1: ( '-' )
            {
            // InternalTGG.g:6160:1: ( '-' )
            // InternalTGG.g:6161:1: '-'
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getHyphenMinusKeyword_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getContextLinkVariablePatternAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__0__Impl"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__1"
    // InternalTGG.g:6174:1: rule__ContextLinkVariablePattern__Group__1 : rule__ContextLinkVariablePattern__Group__1__Impl rule__ContextLinkVariablePattern__Group__2 ;
    public final void rule__ContextLinkVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6178:1: ( rule__ContextLinkVariablePattern__Group__1__Impl rule__ContextLinkVariablePattern__Group__2 )
            // InternalTGG.g:6179:2: rule__ContextLinkVariablePattern__Group__1__Impl rule__ContextLinkVariablePattern__Group__2
            {
            pushFollow(FOLLOW_47);
            rule__ContextLinkVariablePattern__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextLinkVariablePattern__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__1"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__1__Impl"
    // InternalTGG.g:6186:1: rule__ContextLinkVariablePattern__Group__1__Impl : ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) ) ;
    public final void rule__ContextLinkVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6190:1: ( ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) ) )
            // InternalTGG.g:6191:1: ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) )
            {
            // InternalTGG.g:6191:1: ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) )
            // InternalTGG.g:6192:1: ( rule__ContextLinkVariablePattern__TypeAssignment_1 )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTypeAssignment_1()); 
            // InternalTGG.g:6193:1: ( rule__ContextLinkVariablePattern__TypeAssignment_1 )
            // InternalTGG.g:6193:2: rule__ContextLinkVariablePattern__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ContextLinkVariablePattern__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getContextLinkVariablePatternAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__1__Impl"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__2"
    // InternalTGG.g:6203:1: rule__ContextLinkVariablePattern__Group__2 : rule__ContextLinkVariablePattern__Group__2__Impl rule__ContextLinkVariablePattern__Group__3 ;
    public final void rule__ContextLinkVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6207:1: ( rule__ContextLinkVariablePattern__Group__2__Impl rule__ContextLinkVariablePattern__Group__3 )
            // InternalTGG.g:6208:2: rule__ContextLinkVariablePattern__Group__2__Impl rule__ContextLinkVariablePattern__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__ContextLinkVariablePattern__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ContextLinkVariablePattern__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__2"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__2__Impl"
    // InternalTGG.g:6215:1: rule__ContextLinkVariablePattern__Group__2__Impl : ( '->' ) ;
    public final void rule__ContextLinkVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6219:1: ( ( '->' ) )
            // InternalTGG.g:6220:1: ( '->' )
            {
            // InternalTGG.g:6220:1: ( '->' )
            // InternalTGG.g:6221:1: '->'
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getContextLinkVariablePatternAccess().getHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__2__Impl"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__3"
    // InternalTGG.g:6234:1: rule__ContextLinkVariablePattern__Group__3 : rule__ContextLinkVariablePattern__Group__3__Impl ;
    public final void rule__ContextLinkVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6238:1: ( rule__ContextLinkVariablePattern__Group__3__Impl )
            // InternalTGG.g:6239:2: rule__ContextLinkVariablePattern__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ContextLinkVariablePattern__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__3"


    // $ANTLR start "rule__ContextLinkVariablePattern__Group__3__Impl"
    // InternalTGG.g:6245:1: rule__ContextLinkVariablePattern__Group__3__Impl : ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) ) ;
    public final void rule__ContextLinkVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6249:1: ( ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) ) )
            // InternalTGG.g:6250:1: ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) )
            {
            // InternalTGG.g:6250:1: ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) )
            // InternalTGG.g:6251:1: ( rule__ContextLinkVariablePattern__TargetAssignment_3 )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTargetAssignment_3()); 
            // InternalTGG.g:6252:1: ( rule__ContextLinkVariablePattern__TargetAssignment_3 )
            // InternalTGG.g:6252:2: rule__ContextLinkVariablePattern__TargetAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__ContextLinkVariablePattern__TargetAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getContextLinkVariablePatternAccess().getTargetAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__Group__3__Impl"


    // $ANTLR start "rule__Nac__Group__0"
    // InternalTGG.g:6270:1: rule__Nac__Group__0 : rule__Nac__Group__0__Impl rule__Nac__Group__1 ;
    public final void rule__Nac__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6274:1: ( rule__Nac__Group__0__Impl rule__Nac__Group__1 )
            // InternalTGG.g:6275:2: rule__Nac__Group__0__Impl rule__Nac__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Nac__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__0"


    // $ANTLR start "rule__Nac__Group__0__Impl"
    // InternalTGG.g:6282:1: rule__Nac__Group__0__Impl : ( '#nac' ) ;
    public final void rule__Nac__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6286:1: ( ( '#nac' ) )
            // InternalTGG.g:6287:1: ( '#nac' )
            {
            // InternalTGG.g:6287:1: ( '#nac' )
            // InternalTGG.g:6288:1: '#nac'
            {
             before(grammarAccess.getNacAccess().getNacKeyword_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getNacKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__0__Impl"


    // $ANTLR start "rule__Nac__Group__1"
    // InternalTGG.g:6301:1: rule__Nac__Group__1 : rule__Nac__Group__1__Impl rule__Nac__Group__2 ;
    public final void rule__Nac__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6305:1: ( rule__Nac__Group__1__Impl rule__Nac__Group__2 )
            // InternalTGG.g:6306:2: rule__Nac__Group__1__Impl rule__Nac__Group__2
            {
            pushFollow(FOLLOW_48);
            rule__Nac__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__1"


    // $ANTLR start "rule__Nac__Group__1__Impl"
    // InternalTGG.g:6313:1: rule__Nac__Group__1__Impl : ( ( rule__Nac__NameAssignment_1 ) ) ;
    public final void rule__Nac__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6317:1: ( ( ( rule__Nac__NameAssignment_1 ) ) )
            // InternalTGG.g:6318:1: ( ( rule__Nac__NameAssignment_1 ) )
            {
            // InternalTGG.g:6318:1: ( ( rule__Nac__NameAssignment_1 ) )
            // InternalTGG.g:6319:1: ( rule__Nac__NameAssignment_1 )
            {
             before(grammarAccess.getNacAccess().getNameAssignment_1()); 
            // InternalTGG.g:6320:1: ( rule__Nac__NameAssignment_1 )
            // InternalTGG.g:6320:2: rule__Nac__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Nac__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNacAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__1__Impl"


    // $ANTLR start "rule__Nac__Group__2"
    // InternalTGG.g:6330:1: rule__Nac__Group__2 : rule__Nac__Group__2__Impl rule__Nac__Group__3 ;
    public final void rule__Nac__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6334:1: ( rule__Nac__Group__2__Impl rule__Nac__Group__3 )
            // InternalTGG.g:6335:2: rule__Nac__Group__2__Impl rule__Nac__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Nac__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__2"


    // $ANTLR start "rule__Nac__Group__2__Impl"
    // InternalTGG.g:6342:1: rule__Nac__Group__2__Impl : ( '#for' ) ;
    public final void rule__Nac__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6346:1: ( ( '#for' ) )
            // InternalTGG.g:6347:1: ( '#for' )
            {
            // InternalTGG.g:6347:1: ( '#for' )
            // InternalTGG.g:6348:1: '#for'
            {
             before(grammarAccess.getNacAccess().getForKeyword_2()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getForKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__2__Impl"


    // $ANTLR start "rule__Nac__Group__3"
    // InternalTGG.g:6361:1: rule__Nac__Group__3 : rule__Nac__Group__3__Impl rule__Nac__Group__4 ;
    public final void rule__Nac__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6365:1: ( rule__Nac__Group__3__Impl rule__Nac__Group__4 )
            // InternalTGG.g:6366:2: rule__Nac__Group__3__Impl rule__Nac__Group__4
            {
            pushFollow(FOLLOW_49);
            rule__Nac__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__3"


    // $ANTLR start "rule__Nac__Group__3__Impl"
    // InternalTGG.g:6373:1: rule__Nac__Group__3__Impl : ( ( rule__Nac__RuleAssignment_3 ) ) ;
    public final void rule__Nac__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6377:1: ( ( ( rule__Nac__RuleAssignment_3 ) ) )
            // InternalTGG.g:6378:1: ( ( rule__Nac__RuleAssignment_3 ) )
            {
            // InternalTGG.g:6378:1: ( ( rule__Nac__RuleAssignment_3 ) )
            // InternalTGG.g:6379:1: ( rule__Nac__RuleAssignment_3 )
            {
             before(grammarAccess.getNacAccess().getRuleAssignment_3()); 
            // InternalTGG.g:6380:1: ( rule__Nac__RuleAssignment_3 )
            // InternalTGG.g:6380:2: rule__Nac__RuleAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Nac__RuleAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getNacAccess().getRuleAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__3__Impl"


    // $ANTLR start "rule__Nac__Group__4"
    // InternalTGG.g:6390:1: rule__Nac__Group__4 : rule__Nac__Group__4__Impl rule__Nac__Group__5 ;
    public final void rule__Nac__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6394:1: ( rule__Nac__Group__4__Impl rule__Nac__Group__5 )
            // InternalTGG.g:6395:2: rule__Nac__Group__4__Impl rule__Nac__Group__5
            {
            pushFollow(FOLLOW_50);
            rule__Nac__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__4"


    // $ANTLR start "rule__Nac__Group__4__Impl"
    // InternalTGG.g:6402:1: rule__Nac__Group__4__Impl : ( ( rule__Nac__Alternatives_4 ) ) ;
    public final void rule__Nac__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6406:1: ( ( ( rule__Nac__Alternatives_4 ) ) )
            // InternalTGG.g:6407:1: ( ( rule__Nac__Alternatives_4 ) )
            {
            // InternalTGG.g:6407:1: ( ( rule__Nac__Alternatives_4 ) )
            // InternalTGG.g:6408:1: ( rule__Nac__Alternatives_4 )
            {
             before(grammarAccess.getNacAccess().getAlternatives_4()); 
            // InternalTGG.g:6409:1: ( rule__Nac__Alternatives_4 )
            // InternalTGG.g:6409:2: rule__Nac__Alternatives_4
            {
            pushFollow(FOLLOW_2);
            rule__Nac__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getNacAccess().getAlternatives_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__4__Impl"


    // $ANTLR start "rule__Nac__Group__5"
    // InternalTGG.g:6419:1: rule__Nac__Group__5 : rule__Nac__Group__5__Impl ;
    public final void rule__Nac__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6423:1: ( rule__Nac__Group__5__Impl )
            // InternalTGG.g:6424:2: rule__Nac__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Nac__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__5"


    // $ANTLR start "rule__Nac__Group__5__Impl"
    // InternalTGG.g:6430:1: rule__Nac__Group__5__Impl : ( ( rule__Nac__Group_5__0 )? ) ;
    public final void rule__Nac__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6434:1: ( ( ( rule__Nac__Group_5__0 )? ) )
            // InternalTGG.g:6435:1: ( ( rule__Nac__Group_5__0 )? )
            {
            // InternalTGG.g:6435:1: ( ( rule__Nac__Group_5__0 )? )
            // InternalTGG.g:6436:1: ( rule__Nac__Group_5__0 )?
            {
             before(grammarAccess.getNacAccess().getGroup_5()); 
            // InternalTGG.g:6437:1: ( rule__Nac__Group_5__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==27) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalTGG.g:6437:2: rule__Nac__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Nac__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNacAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group__5__Impl"


    // $ANTLR start "rule__Nac__Group_4_0__0"
    // InternalTGG.g:6459:1: rule__Nac__Group_4_0__0 : rule__Nac__Group_4_0__0__Impl rule__Nac__Group_4_0__1 ;
    public final void rule__Nac__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6463:1: ( rule__Nac__Group_4_0__0__Impl rule__Nac__Group_4_0__1 )
            // InternalTGG.g:6464:2: rule__Nac__Group_4_0__0__Impl rule__Nac__Group_4_0__1
            {
            pushFollow(FOLLOW_9);
            rule__Nac__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__0"


    // $ANTLR start "rule__Nac__Group_4_0__0__Impl"
    // InternalTGG.g:6471:1: rule__Nac__Group_4_0__0__Impl : ( '#source' ) ;
    public final void rule__Nac__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6475:1: ( ( '#source' ) )
            // InternalTGG.g:6476:1: ( '#source' )
            {
            // InternalTGG.g:6476:1: ( '#source' )
            // InternalTGG.g:6477:1: '#source'
            {
             before(grammarAccess.getNacAccess().getSourceKeyword_4_0_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getSourceKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__0__Impl"


    // $ANTLR start "rule__Nac__Group_4_0__1"
    // InternalTGG.g:6490:1: rule__Nac__Group_4_0__1 : rule__Nac__Group_4_0__1__Impl rule__Nac__Group_4_0__2 ;
    public final void rule__Nac__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6494:1: ( rule__Nac__Group_4_0__1__Impl rule__Nac__Group_4_0__2 )
            // InternalTGG.g:6495:2: rule__Nac__Group_4_0__1__Impl rule__Nac__Group_4_0__2
            {
            pushFollow(FOLLOW_10);
            rule__Nac__Group_4_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__1"


    // $ANTLR start "rule__Nac__Group_4_0__1__Impl"
    // InternalTGG.g:6502:1: rule__Nac__Group_4_0__1__Impl : ( '{' ) ;
    public final void rule__Nac__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6506:1: ( ( '{' ) )
            // InternalTGG.g:6507:1: ( '{' )
            {
            // InternalTGG.g:6507:1: ( '{' )
            // InternalTGG.g:6508:1: '{'
            {
             before(grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_4_0_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__1__Impl"


    // $ANTLR start "rule__Nac__Group_4_0__2"
    // InternalTGG.g:6521:1: rule__Nac__Group_4_0__2 : rule__Nac__Group_4_0__2__Impl rule__Nac__Group_4_0__3 ;
    public final void rule__Nac__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6525:1: ( rule__Nac__Group_4_0__2__Impl rule__Nac__Group_4_0__3 )
            // InternalTGG.g:6526:2: rule__Nac__Group_4_0__2__Impl rule__Nac__Group_4_0__3
            {
            pushFollow(FOLLOW_10);
            rule__Nac__Group_4_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__2"


    // $ANTLR start "rule__Nac__Group_4_0__2__Impl"
    // InternalTGG.g:6533:1: rule__Nac__Group_4_0__2__Impl : ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* ) ;
    public final void rule__Nac__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6537:1: ( ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* ) )
            // InternalTGG.g:6538:1: ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* )
            {
            // InternalTGG.g:6538:1: ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* )
            // InternalTGG.g:6539:1: ( rule__Nac__SourcePatternsAssignment_4_0_2 )*
            {
             before(grammarAccess.getNacAccess().getSourcePatternsAssignment_4_0_2()); 
            // InternalTGG.g:6540:1: ( rule__Nac__SourcePatternsAssignment_4_0_2 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalTGG.g:6540:2: rule__Nac__SourcePatternsAssignment_4_0_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Nac__SourcePatternsAssignment_4_0_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

             after(grammarAccess.getNacAccess().getSourcePatternsAssignment_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__2__Impl"


    // $ANTLR start "rule__Nac__Group_4_0__3"
    // InternalTGG.g:6550:1: rule__Nac__Group_4_0__3 : rule__Nac__Group_4_0__3__Impl ;
    public final void rule__Nac__Group_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6554:1: ( rule__Nac__Group_4_0__3__Impl )
            // InternalTGG.g:6555:2: rule__Nac__Group_4_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__3"


    // $ANTLR start "rule__Nac__Group_4_0__3__Impl"
    // InternalTGG.g:6561:1: rule__Nac__Group_4_0__3__Impl : ( '}' ) ;
    public final void rule__Nac__Group_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6565:1: ( ( '}' ) )
            // InternalTGG.g:6566:1: ( '}' )
            {
            // InternalTGG.g:6566:1: ( '}' )
            // InternalTGG.g:6567:1: '}'
            {
             before(grammarAccess.getNacAccess().getRightCurlyBracketKeyword_4_0_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getRightCurlyBracketKeyword_4_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_0__3__Impl"


    // $ANTLR start "rule__Nac__Group_4_1__0"
    // InternalTGG.g:6588:1: rule__Nac__Group_4_1__0 : rule__Nac__Group_4_1__0__Impl rule__Nac__Group_4_1__1 ;
    public final void rule__Nac__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6592:1: ( rule__Nac__Group_4_1__0__Impl rule__Nac__Group_4_1__1 )
            // InternalTGG.g:6593:2: rule__Nac__Group_4_1__0__Impl rule__Nac__Group_4_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Nac__Group_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__0"


    // $ANTLR start "rule__Nac__Group_4_1__0__Impl"
    // InternalTGG.g:6600:1: rule__Nac__Group_4_1__0__Impl : ( '#target' ) ;
    public final void rule__Nac__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6604:1: ( ( '#target' ) )
            // InternalTGG.g:6605:1: ( '#target' )
            {
            // InternalTGG.g:6605:1: ( '#target' )
            // InternalTGG.g:6606:1: '#target'
            {
             before(grammarAccess.getNacAccess().getTargetKeyword_4_1_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getTargetKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__0__Impl"


    // $ANTLR start "rule__Nac__Group_4_1__1"
    // InternalTGG.g:6619:1: rule__Nac__Group_4_1__1 : rule__Nac__Group_4_1__1__Impl rule__Nac__Group_4_1__2 ;
    public final void rule__Nac__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6623:1: ( rule__Nac__Group_4_1__1__Impl rule__Nac__Group_4_1__2 )
            // InternalTGG.g:6624:2: rule__Nac__Group_4_1__1__Impl rule__Nac__Group_4_1__2
            {
            pushFollow(FOLLOW_10);
            rule__Nac__Group_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__1"


    // $ANTLR start "rule__Nac__Group_4_1__1__Impl"
    // InternalTGG.g:6631:1: rule__Nac__Group_4_1__1__Impl : ( '{' ) ;
    public final void rule__Nac__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6635:1: ( ( '{' ) )
            // InternalTGG.g:6636:1: ( '{' )
            {
            // InternalTGG.g:6636:1: ( '{' )
            // InternalTGG.g:6637:1: '{'
            {
             before(grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_4_1_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__1__Impl"


    // $ANTLR start "rule__Nac__Group_4_1__2"
    // InternalTGG.g:6650:1: rule__Nac__Group_4_1__2 : rule__Nac__Group_4_1__2__Impl rule__Nac__Group_4_1__3 ;
    public final void rule__Nac__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6654:1: ( rule__Nac__Group_4_1__2__Impl rule__Nac__Group_4_1__3 )
            // InternalTGG.g:6655:2: rule__Nac__Group_4_1__2__Impl rule__Nac__Group_4_1__3
            {
            pushFollow(FOLLOW_10);
            rule__Nac__Group_4_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__2"


    // $ANTLR start "rule__Nac__Group_4_1__2__Impl"
    // InternalTGG.g:6662:1: rule__Nac__Group_4_1__2__Impl : ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* ) ;
    public final void rule__Nac__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6666:1: ( ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* ) )
            // InternalTGG.g:6667:1: ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* )
            {
            // InternalTGG.g:6667:1: ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* )
            // InternalTGG.g:6668:1: ( rule__Nac__TargetPatternsAssignment_4_1_2 )*
            {
             before(grammarAccess.getNacAccess().getTargetPatternsAssignment_4_1_2()); 
            // InternalTGG.g:6669:1: ( rule__Nac__TargetPatternsAssignment_4_1_2 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalTGG.g:6669:2: rule__Nac__TargetPatternsAssignment_4_1_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Nac__TargetPatternsAssignment_4_1_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

             after(grammarAccess.getNacAccess().getTargetPatternsAssignment_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__2__Impl"


    // $ANTLR start "rule__Nac__Group_4_1__3"
    // InternalTGG.g:6679:1: rule__Nac__Group_4_1__3 : rule__Nac__Group_4_1__3__Impl ;
    public final void rule__Nac__Group_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6683:1: ( rule__Nac__Group_4_1__3__Impl )
            // InternalTGG.g:6684:2: rule__Nac__Group_4_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Nac__Group_4_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__3"


    // $ANTLR start "rule__Nac__Group_4_1__3__Impl"
    // InternalTGG.g:6690:1: rule__Nac__Group_4_1__3__Impl : ( '}' ) ;
    public final void rule__Nac__Group_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6694:1: ( ( '}' ) )
            // InternalTGG.g:6695:1: ( '}' )
            {
            // InternalTGG.g:6695:1: ( '}' )
            // InternalTGG.g:6696:1: '}'
            {
             before(grammarAccess.getNacAccess().getRightCurlyBracketKeyword_4_1_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getRightCurlyBracketKeyword_4_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_4_1__3__Impl"


    // $ANTLR start "rule__Nac__Group_5__0"
    // InternalTGG.g:6717:1: rule__Nac__Group_5__0 : rule__Nac__Group_5__0__Impl rule__Nac__Group_5__1 ;
    public final void rule__Nac__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6721:1: ( rule__Nac__Group_5__0__Impl rule__Nac__Group_5__1 )
            // InternalTGG.g:6722:2: rule__Nac__Group_5__0__Impl rule__Nac__Group_5__1
            {
            pushFollow(FOLLOW_9);
            rule__Nac__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__0"


    // $ANTLR start "rule__Nac__Group_5__0__Impl"
    // InternalTGG.g:6729:1: rule__Nac__Group_5__0__Impl : ( '#attributeConditions' ) ;
    public final void rule__Nac__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6733:1: ( ( '#attributeConditions' ) )
            // InternalTGG.g:6734:1: ( '#attributeConditions' )
            {
            // InternalTGG.g:6734:1: ( '#attributeConditions' )
            // InternalTGG.g:6735:1: '#attributeConditions'
            {
             before(grammarAccess.getNacAccess().getAttributeConditionsKeyword_5_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getAttributeConditionsKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__0__Impl"


    // $ANTLR start "rule__Nac__Group_5__1"
    // InternalTGG.g:6748:1: rule__Nac__Group_5__1 : rule__Nac__Group_5__1__Impl rule__Nac__Group_5__2 ;
    public final void rule__Nac__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6752:1: ( rule__Nac__Group_5__1__Impl rule__Nac__Group_5__2 )
            // InternalTGG.g:6753:2: rule__Nac__Group_5__1__Impl rule__Nac__Group_5__2
            {
            pushFollow(FOLLOW_10);
            rule__Nac__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__1"


    // $ANTLR start "rule__Nac__Group_5__1__Impl"
    // InternalTGG.g:6760:1: rule__Nac__Group_5__1__Impl : ( '{' ) ;
    public final void rule__Nac__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6764:1: ( ( '{' ) )
            // InternalTGG.g:6765:1: ( '{' )
            {
            // InternalTGG.g:6765:1: ( '{' )
            // InternalTGG.g:6766:1: '{'
            {
             before(grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_5_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getLeftCurlyBracketKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__1__Impl"


    // $ANTLR start "rule__Nac__Group_5__2"
    // InternalTGG.g:6779:1: rule__Nac__Group_5__2 : rule__Nac__Group_5__2__Impl rule__Nac__Group_5__3 ;
    public final void rule__Nac__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6783:1: ( rule__Nac__Group_5__2__Impl rule__Nac__Group_5__3 )
            // InternalTGG.g:6784:2: rule__Nac__Group_5__2__Impl rule__Nac__Group_5__3
            {
            pushFollow(FOLLOW_10);
            rule__Nac__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Nac__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__2"


    // $ANTLR start "rule__Nac__Group_5__2__Impl"
    // InternalTGG.g:6791:1: rule__Nac__Group_5__2__Impl : ( ( rule__Nac__AttrConditionsAssignment_5_2 )* ) ;
    public final void rule__Nac__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6795:1: ( ( ( rule__Nac__AttrConditionsAssignment_5_2 )* ) )
            // InternalTGG.g:6796:1: ( ( rule__Nac__AttrConditionsAssignment_5_2 )* )
            {
            // InternalTGG.g:6796:1: ( ( rule__Nac__AttrConditionsAssignment_5_2 )* )
            // InternalTGG.g:6797:1: ( rule__Nac__AttrConditionsAssignment_5_2 )*
            {
             before(grammarAccess.getNacAccess().getAttrConditionsAssignment_5_2()); 
            // InternalTGG.g:6798:1: ( rule__Nac__AttrConditionsAssignment_5_2 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalTGG.g:6798:2: rule__Nac__AttrConditionsAssignment_5_2
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Nac__AttrConditionsAssignment_5_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

             after(grammarAccess.getNacAccess().getAttrConditionsAssignment_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__2__Impl"


    // $ANTLR start "rule__Nac__Group_5__3"
    // InternalTGG.g:6808:1: rule__Nac__Group_5__3 : rule__Nac__Group_5__3__Impl ;
    public final void rule__Nac__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6812:1: ( rule__Nac__Group_5__3__Impl )
            // InternalTGG.g:6813:2: rule__Nac__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Nac__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__3"


    // $ANTLR start "rule__Nac__Group_5__3__Impl"
    // InternalTGG.g:6819:1: rule__Nac__Group_5__3__Impl : ( '}' ) ;
    public final void rule__Nac__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6823:1: ( ( '}' ) )
            // InternalTGG.g:6824:1: ( '}' )
            {
            // InternalTGG.g:6824:1: ( '}' )
            // InternalTGG.g:6825:1: '}'
            {
             before(grammarAccess.getNacAccess().getRightCurlyBracketKeyword_5_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getRightCurlyBracketKeyword_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__Group_5__3__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalTGG.g:6846:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6850:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalTGG.g:6851:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_51);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalTGG.g:6858:1: rule__Import__Group__0__Impl : ( '#import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6862:1: ( ( '#import' ) )
            // InternalTGG.g:6863:1: ( '#import' )
            {
            // InternalTGG.g:6863:1: ( '#import' )
            // InternalTGG.g:6864:1: '#import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalTGG.g:6877:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6881:1: ( rule__Import__Group__1__Impl )
            // InternalTGG.g:6882:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalTGG.g:6888:1: rule__Import__Group__1__Impl : ( ( rule__Import__NameAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6892:1: ( ( ( rule__Import__NameAssignment_1 ) ) )
            // InternalTGG.g:6893:1: ( ( rule__Import__NameAssignment_1 ) )
            {
            // InternalTGG.g:6893:1: ( ( rule__Import__NameAssignment_1 ) )
            // InternalTGG.g:6894:1: ( rule__Import__NameAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getNameAssignment_1()); 
            // InternalTGG.g:6895:1: ( rule__Import__NameAssignment_1 )
            // InternalTGG.g:6895:2: rule__Import__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Using__Group__0"
    // InternalTGG.g:6909:1: rule__Using__Group__0 : rule__Using__Group__0__Impl rule__Using__Group__1 ;
    public final void rule__Using__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6913:1: ( rule__Using__Group__0__Impl rule__Using__Group__1 )
            // InternalTGG.g:6914:2: rule__Using__Group__0__Impl rule__Using__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Using__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Using__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Using__Group__0"


    // $ANTLR start "rule__Using__Group__0__Impl"
    // InternalTGG.g:6921:1: rule__Using__Group__0__Impl : ( '#using' ) ;
    public final void rule__Using__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6925:1: ( ( '#using' ) )
            // InternalTGG.g:6926:1: ( '#using' )
            {
            // InternalTGG.g:6926:1: ( '#using' )
            // InternalTGG.g:6927:1: '#using'
            {
             before(grammarAccess.getUsingAccess().getUsingKeyword_0()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getUsingAccess().getUsingKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Using__Group__0__Impl"


    // $ANTLR start "rule__Using__Group__1"
    // InternalTGG.g:6940:1: rule__Using__Group__1 : rule__Using__Group__1__Impl ;
    public final void rule__Using__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6944:1: ( rule__Using__Group__1__Impl )
            // InternalTGG.g:6945:2: rule__Using__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Using__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Using__Group__1"


    // $ANTLR start "rule__Using__Group__1__Impl"
    // InternalTGG.g:6951:1: rule__Using__Group__1__Impl : ( ( rule__Using__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Using__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6955:1: ( ( ( rule__Using__ImportedNamespaceAssignment_1 ) ) )
            // InternalTGG.g:6956:1: ( ( rule__Using__ImportedNamespaceAssignment_1 ) )
            {
            // InternalTGG.g:6956:1: ( ( rule__Using__ImportedNamespaceAssignment_1 ) )
            // InternalTGG.g:6957:1: ( rule__Using__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getUsingAccess().getImportedNamespaceAssignment_1()); 
            // InternalTGG.g:6958:1: ( rule__Using__ImportedNamespaceAssignment_1 )
            // InternalTGG.g:6958:2: rule__Using__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Using__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUsingAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Using__Group__1__Impl"


    // $ANTLR start "rule__LiteralValue__Group_1__0"
    // InternalTGG.g:6972:1: rule__LiteralValue__Group_1__0 : rule__LiteralValue__Group_1__0__Impl rule__LiteralValue__Group_1__1 ;
    public final void rule__LiteralValue__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6976:1: ( rule__LiteralValue__Group_1__0__Impl rule__LiteralValue__Group_1__1 )
            // InternalTGG.g:6977:2: rule__LiteralValue__Group_1__0__Impl rule__LiteralValue__Group_1__1
            {
            pushFollow(FOLLOW_52);
            rule__LiteralValue__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LiteralValue__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_1__0"


    // $ANTLR start "rule__LiteralValue__Group_1__0__Impl"
    // InternalTGG.g:6984:1: rule__LiteralValue__Group_1__0__Impl : ( ( '-' )? ) ;
    public final void rule__LiteralValue__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:6988:1: ( ( ( '-' )? ) )
            // InternalTGG.g:6989:1: ( ( '-' )? )
            {
            // InternalTGG.g:6989:1: ( ( '-' )? )
            // InternalTGG.g:6990:1: ( '-' )?
            {
             before(grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_1_0()); 
            // InternalTGG.g:6991:1: ( '-' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==45) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalTGG.g:6992:2: '-'
                    {
                    match(input,45,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_1__0__Impl"


    // $ANTLR start "rule__LiteralValue__Group_1__1"
    // InternalTGG.g:7003:1: rule__LiteralValue__Group_1__1 : rule__LiteralValue__Group_1__1__Impl ;
    public final void rule__LiteralValue__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7007:1: ( rule__LiteralValue__Group_1__1__Impl )
            // InternalTGG.g:7008:2: rule__LiteralValue__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LiteralValue__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_1__1"


    // $ANTLR start "rule__LiteralValue__Group_1__1__Impl"
    // InternalTGG.g:7014:1: rule__LiteralValue__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__LiteralValue__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7018:1: ( ( RULE_INT ) )
            // InternalTGG.g:7019:1: ( RULE_INT )
            {
            // InternalTGG.g:7019:1: ( RULE_INT )
            // InternalTGG.g:7020:1: RULE_INT
            {
             before(grammarAccess.getLiteralValueAccess().getINTTerminalRuleCall_1_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getLiteralValueAccess().getINTTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_1__1__Impl"


    // $ANTLR start "rule__LiteralValue__Group_2__0"
    // InternalTGG.g:7035:1: rule__LiteralValue__Group_2__0 : rule__LiteralValue__Group_2__0__Impl rule__LiteralValue__Group_2__1 ;
    public final void rule__LiteralValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7039:1: ( rule__LiteralValue__Group_2__0__Impl rule__LiteralValue__Group_2__1 )
            // InternalTGG.g:7040:2: rule__LiteralValue__Group_2__0__Impl rule__LiteralValue__Group_2__1
            {
            pushFollow(FOLLOW_53);
            rule__LiteralValue__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LiteralValue__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_2__0"


    // $ANTLR start "rule__LiteralValue__Group_2__0__Impl"
    // InternalTGG.g:7047:1: rule__LiteralValue__Group_2__0__Impl : ( ( '-' )? ) ;
    public final void rule__LiteralValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7051:1: ( ( ( '-' )? ) )
            // InternalTGG.g:7052:1: ( ( '-' )? )
            {
            // InternalTGG.g:7052:1: ( ( '-' )? )
            // InternalTGG.g:7053:1: ( '-' )?
            {
             before(grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_2_0()); 
            // InternalTGG.g:7054:1: ( '-' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==45) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalTGG.g:7055:2: '-'
                    {
                    match(input,45,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_2__0__Impl"


    // $ANTLR start "rule__LiteralValue__Group_2__1"
    // InternalTGG.g:7066:1: rule__LiteralValue__Group_2__1 : rule__LiteralValue__Group_2__1__Impl ;
    public final void rule__LiteralValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7070:1: ( rule__LiteralValue__Group_2__1__Impl )
            // InternalTGG.g:7071:2: rule__LiteralValue__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LiteralValue__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_2__1"


    // $ANTLR start "rule__LiteralValue__Group_2__1__Impl"
    // InternalTGG.g:7077:1: rule__LiteralValue__Group_2__1__Impl : ( RULE_DECIMAL ) ;
    public final void rule__LiteralValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7081:1: ( ( RULE_DECIMAL ) )
            // InternalTGG.g:7082:1: ( RULE_DECIMAL )
            {
            // InternalTGG.g:7082:1: ( RULE_DECIMAL )
            // InternalTGG.g:7083:1: RULE_DECIMAL
            {
             before(grammarAccess.getLiteralValueAccess().getDECIMALTerminalRuleCall_2_1()); 
            match(input,RULE_DECIMAL,FOLLOW_2); 
             after(grammarAccess.getLiteralValueAccess().getDECIMALTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__Group_2__1__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0"
    // InternalTGG.g:7098:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7102:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // InternalTGG.g:7103:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0__Impl"
    // InternalTGG.g:7110:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7114:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7115:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:7115:1: ( ruleQualifiedName )
            // InternalTGG.g:7116:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1"
    // InternalTGG.g:7127:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7131:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // InternalTGG.g:7132:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedNameWithWildcard__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1__Impl"
    // InternalTGG.g:7138:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( '.*' ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7142:1: ( ( '.*' ) )
            // InternalTGG.g:7143:1: ( '.*' )
            {
            // InternalTGG.g:7143:1: ( '.*' )
            // InternalTGG.g:7144:1: '.*'
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalTGG.g:7161:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7165:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalTGG.g:7166:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // InternalTGG.g:7173:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7177:1: ( ( RULE_ID ) )
            // InternalTGG.g:7178:1: ( RULE_ID )
            {
            // InternalTGG.g:7178:1: ( RULE_ID )
            // InternalTGG.g:7179:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // InternalTGG.g:7190:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7194:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalTGG.g:7195:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // InternalTGG.g:7201:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7205:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalTGG.g:7206:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalTGG.g:7206:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalTGG.g:7207:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalTGG.g:7208:1: ( rule__QualifiedName__Group_1__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==44) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalTGG.g:7208:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_55);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // InternalTGG.g:7222:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7226:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalTGG.g:7227:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // InternalTGG.g:7234:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7238:1: ( ( '.' ) )
            // InternalTGG.g:7239:1: ( '.' )
            {
            // InternalTGG.g:7239:1: ( '.' )
            // InternalTGG.g:7240:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // InternalTGG.g:7253:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7257:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalTGG.g:7258:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // InternalTGG.g:7264:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7268:1: ( ( RULE_ID ) )
            // InternalTGG.g:7269:1: ( RULE_ID )
            {
            // InternalTGG.g:7269:1: ( RULE_ID )
            // InternalTGG.g:7270:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__TripleGraphGrammarFile__ImportsAssignment_0"
    // InternalTGG.g:7286:1: rule__TripleGraphGrammarFile__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__TripleGraphGrammarFile__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7290:1: ( ( ruleImport ) )
            // InternalTGG.g:7291:1: ( ruleImport )
            {
            // InternalTGG.g:7291:1: ( ruleImport )
            // InternalTGG.g:7292:1: ruleImport
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getTripleGraphGrammarFileAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__ImportsAssignment_0"


    // $ANTLR start "rule__TripleGraphGrammarFile__UsingAssignment_1"
    // InternalTGG.g:7301:1: rule__TripleGraphGrammarFile__UsingAssignment_1 : ( ruleUsing ) ;
    public final void rule__TripleGraphGrammarFile__UsingAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7305:1: ( ( ruleUsing ) )
            // InternalTGG.g:7306:1: ( ruleUsing )
            {
            // InternalTGG.g:7306:1: ( ruleUsing )
            // InternalTGG.g:7307:1: ruleUsing
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getUsingUsingParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleUsing();

            state._fsp--;

             after(grammarAccess.getTripleGraphGrammarFileAccess().getUsingUsingParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__UsingAssignment_1"


    // $ANTLR start "rule__TripleGraphGrammarFile__SchemaAssignment_2"
    // InternalTGG.g:7316:1: rule__TripleGraphGrammarFile__SchemaAssignment_2 : ( ruleSchema ) ;
    public final void rule__TripleGraphGrammarFile__SchemaAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7320:1: ( ( ruleSchema ) )
            // InternalTGG.g:7321:1: ( ruleSchema )
            {
            // InternalTGG.g:7321:1: ( ruleSchema )
            // InternalTGG.g:7322:1: ruleSchema
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getSchemaSchemaParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleSchema();

            state._fsp--;

             after(grammarAccess.getTripleGraphGrammarFileAccess().getSchemaSchemaParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__SchemaAssignment_2"


    // $ANTLR start "rule__TripleGraphGrammarFile__RulesAssignment_3"
    // InternalTGG.g:7331:1: rule__TripleGraphGrammarFile__RulesAssignment_3 : ( ruleRule ) ;
    public final void rule__TripleGraphGrammarFile__RulesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7335:1: ( ( ruleRule ) )
            // InternalTGG.g:7336:1: ( ruleRule )
            {
            // InternalTGG.g:7336:1: ( ruleRule )
            // InternalTGG.g:7337:1: ruleRule
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getRulesRuleParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleRule();

            state._fsp--;

             after(grammarAccess.getTripleGraphGrammarFileAccess().getRulesRuleParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__RulesAssignment_3"


    // $ANTLR start "rule__TripleGraphGrammarFile__LibraryAssignment_4"
    // InternalTGG.g:7346:1: rule__TripleGraphGrammarFile__LibraryAssignment_4 : ( ruleAttrCondDefLibrary ) ;
    public final void rule__TripleGraphGrammarFile__LibraryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7350:1: ( ( ruleAttrCondDefLibrary ) )
            // InternalTGG.g:7351:1: ( ruleAttrCondDefLibrary )
            {
            // InternalTGG.g:7351:1: ( ruleAttrCondDefLibrary )
            // InternalTGG.g:7352:1: ruleAttrCondDefLibrary
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getLibraryAttrCondDefLibraryParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleAttrCondDefLibrary();

            state._fsp--;

             after(grammarAccess.getTripleGraphGrammarFileAccess().getLibraryAttrCondDefLibraryParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TripleGraphGrammarFile__LibraryAssignment_4"


    // $ANTLR start "rule__Schema__NameAssignment_1"
    // InternalTGG.g:7361:1: rule__Schema__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Schema__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7365:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7366:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:7366:1: ( ruleQualifiedName )
            // InternalTGG.g:7367:1: ruleQualifiedName
            {
             before(grammarAccess.getSchemaAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__NameAssignment_1"


    // $ANTLR start "rule__Schema__SourceTypesAssignment_2_2"
    // InternalTGG.g:7376:1: rule__Schema__SourceTypesAssignment_2_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Schema__SourceTypesAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7380:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7381:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7381:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7382:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSchemaAccess().getSourceTypesEPackageCrossReference_2_2_0()); 
            // InternalTGG.g:7383:1: ( ruleQualifiedName )
            // InternalTGG.g:7384:1: ruleQualifiedName
            {
             before(grammarAccess.getSchemaAccess().getSourceTypesEPackageQualifiedNameParserRuleCall_2_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getSourceTypesEPackageQualifiedNameParserRuleCall_2_2_0_1()); 

            }

             after(grammarAccess.getSchemaAccess().getSourceTypesEPackageCrossReference_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__SourceTypesAssignment_2_2"


    // $ANTLR start "rule__Schema__TargetTypesAssignment_3_2"
    // InternalTGG.g:7395:1: rule__Schema__TargetTypesAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Schema__TargetTypesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7399:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7400:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7400:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7401:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSchemaAccess().getTargetTypesEPackageCrossReference_3_2_0()); 
            // InternalTGG.g:7402:1: ( ruleQualifiedName )
            // InternalTGG.g:7403:1: ruleQualifiedName
            {
             before(grammarAccess.getSchemaAccess().getTargetTypesEPackageQualifiedNameParserRuleCall_3_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getTargetTypesEPackageQualifiedNameParserRuleCall_3_2_0_1()); 

            }

             after(grammarAccess.getSchemaAccess().getTargetTypesEPackageCrossReference_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__TargetTypesAssignment_3_2"


    // $ANTLR start "rule__Schema__CorrespondenceTypesAssignment_4_2"
    // InternalTGG.g:7414:1: rule__Schema__CorrespondenceTypesAssignment_4_2 : ( ruleCorrType ) ;
    public final void rule__Schema__CorrespondenceTypesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7418:1: ( ( ruleCorrType ) )
            // InternalTGG.g:7419:1: ( ruleCorrType )
            {
            // InternalTGG.g:7419:1: ( ruleCorrType )
            // InternalTGG.g:7420:1: ruleCorrType
            {
             before(grammarAccess.getSchemaAccess().getCorrespondenceTypesCorrTypeParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCorrType();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getCorrespondenceTypesCorrTypeParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__CorrespondenceTypesAssignment_4_2"


    // $ANTLR start "rule__Schema__AttributeCondDefsAssignment_5_2"
    // InternalTGG.g:7429:1: rule__Schema__AttributeCondDefsAssignment_5_2 : ( ruleAttrCondDef ) ;
    public final void rule__Schema__AttributeCondDefsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7433:1: ( ( ruleAttrCondDef ) )
            // InternalTGG.g:7434:1: ( ruleAttrCondDef )
            {
            // InternalTGG.g:7434:1: ( ruleAttrCondDef )
            // InternalTGG.g:7435:1: ruleAttrCondDef
            {
             before(grammarAccess.getSchemaAccess().getAttributeCondDefsAttrCondDefParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttrCondDef();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getAttributeCondDefsAttrCondDefParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__AttributeCondDefsAssignment_5_2"


    // $ANTLR start "rule__CorrType__NameAssignment_0"
    // InternalTGG.g:7444:1: rule__CorrType__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__CorrType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7448:1: ( ( RULE_ID ) )
            // InternalTGG.g:7449:1: ( RULE_ID )
            {
            // InternalTGG.g:7449:1: ( RULE_ID )
            // InternalTGG.g:7450:1: RULE_ID
            {
             before(grammarAccess.getCorrTypeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCorrTypeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__NameAssignment_0"


    // $ANTLR start "rule__CorrType__SuperAssignment_1_0_1"
    // InternalTGG.g:7459:1: rule__CorrType__SuperAssignment_1_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__CorrType__SuperAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7463:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7464:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7464:1: ( ( RULE_ID ) )
            // InternalTGG.g:7465:1: ( RULE_ID )
            {
             before(grammarAccess.getCorrTypeAccess().getSuperCorrTypeCrossReference_1_0_1_0()); 
            // InternalTGG.g:7466:1: ( RULE_ID )
            // InternalTGG.g:7467:1: RULE_ID
            {
             before(grammarAccess.getCorrTypeAccess().getSuperCorrTypeIDTerminalRuleCall_1_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCorrTypeAccess().getSuperCorrTypeIDTerminalRuleCall_1_0_1_0_1()); 

            }

             after(grammarAccess.getCorrTypeAccess().getSuperCorrTypeCrossReference_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__SuperAssignment_1_0_1"


    // $ANTLR start "rule__CorrType__SourceAssignment_1_1_2"
    // InternalTGG.g:7478:1: rule__CorrType__SourceAssignment_1_1_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CorrType__SourceAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7482:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7483:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7483:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7484:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCorrTypeAccess().getSourceEClassCrossReference_1_1_2_0()); 
            // InternalTGG.g:7485:1: ( ruleQualifiedName )
            // InternalTGG.g:7486:1: ruleQualifiedName
            {
             before(grammarAccess.getCorrTypeAccess().getSourceEClassQualifiedNameParserRuleCall_1_1_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCorrTypeAccess().getSourceEClassQualifiedNameParserRuleCall_1_1_2_0_1()); 

            }

             after(grammarAccess.getCorrTypeAccess().getSourceEClassCrossReference_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__SourceAssignment_1_1_2"


    // $ANTLR start "rule__CorrType__TargetAssignment_1_1_4"
    // InternalTGG.g:7497:1: rule__CorrType__TargetAssignment_1_1_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CorrType__TargetAssignment_1_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7501:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7502:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7502:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7503:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCorrTypeAccess().getTargetEClassCrossReference_1_1_4_0()); 
            // InternalTGG.g:7504:1: ( ruleQualifiedName )
            // InternalTGG.g:7505:1: ruleQualifiedName
            {
             before(grammarAccess.getCorrTypeAccess().getTargetEClassQualifiedNameParserRuleCall_1_1_4_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCorrTypeAccess().getTargetEClassQualifiedNameParserRuleCall_1_1_4_0_1()); 

            }

             after(grammarAccess.getCorrTypeAccess().getTargetEClassCrossReference_1_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrType__TargetAssignment_1_1_4"


    // $ANTLR start "rule__AttrCondDef__UserDefinedAssignment_0"
    // InternalTGG.g:7516:1: rule__AttrCondDef__UserDefinedAssignment_0 : ( ( '#userDefined' ) ) ;
    public final void rule__AttrCondDef__UserDefinedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7520:1: ( ( ( '#userDefined' ) ) )
            // InternalTGG.g:7521:1: ( ( '#userDefined' ) )
            {
            // InternalTGG.g:7521:1: ( ( '#userDefined' ) )
            // InternalTGG.g:7522:1: ( '#userDefined' )
            {
             before(grammarAccess.getAttrCondDefAccess().getUserDefinedUserDefinedKeyword_0_0()); 
            // InternalTGG.g:7523:1: ( '#userDefined' )
            // InternalTGG.g:7524:1: '#userDefined'
            {
             before(grammarAccess.getAttrCondDefAccess().getUserDefinedUserDefinedKeyword_0_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getUserDefinedUserDefinedKeyword_0_0()); 

            }

             after(grammarAccess.getAttrCondDefAccess().getUserDefinedUserDefinedKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__UserDefinedAssignment_0"


    // $ANTLR start "rule__AttrCondDef__NameAssignment_1"
    // InternalTGG.g:7539:1: rule__AttrCondDef__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__AttrCondDef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7543:1: ( ( RULE_ID ) )
            // InternalTGG.g:7544:1: ( RULE_ID )
            {
            // InternalTGG.g:7544:1: ( RULE_ID )
            // InternalTGG.g:7545:1: RULE_ID
            {
             before(grammarAccess.getAttrCondDefAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttrCondDefAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__NameAssignment_1"


    // $ANTLR start "rule__AttrCondDef__ParamsAssignment_3_0"
    // InternalTGG.g:7554:1: rule__AttrCondDef__ParamsAssignment_3_0 : ( ruleParam ) ;
    public final void rule__AttrCondDef__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7558:1: ( ( ruleParam ) )
            // InternalTGG.g:7559:1: ( ruleParam )
            {
            // InternalTGG.g:7559:1: ( ruleParam )
            // InternalTGG.g:7560:1: ruleParam
            {
             before(grammarAccess.getAttrCondDefAccess().getParamsParamParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParam();

            state._fsp--;

             after(grammarAccess.getAttrCondDefAccess().getParamsParamParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__ParamsAssignment_3_0"


    // $ANTLR start "rule__AttrCondDef__ParamsAssignment_3_1_1"
    // InternalTGG.g:7569:1: rule__AttrCondDef__ParamsAssignment_3_1_1 : ( ruleParam ) ;
    public final void rule__AttrCondDef__ParamsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7573:1: ( ( ruleParam ) )
            // InternalTGG.g:7574:1: ( ruleParam )
            {
            // InternalTGG.g:7574:1: ( ruleParam )
            // InternalTGG.g:7575:1: ruleParam
            {
             before(grammarAccess.getAttrCondDefAccess().getParamsParamParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParam();

            state._fsp--;

             after(grammarAccess.getAttrCondDefAccess().getParamsParamParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__ParamsAssignment_3_1_1"


    // $ANTLR start "rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7"
    // InternalTGG.g:7584:1: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7588:1: ( ( ruleAdornment ) )
            // InternalTGG.g:7589:1: ( ruleAdornment )
            {
            // InternalTGG.g:7589:1: ( ruleAdornment )
            // InternalTGG.g:7590:1: ruleAdornment
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAdornmentParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleAdornment();

            state._fsp--;

             after(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAdornmentParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7"


    // $ANTLR start "rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1"
    // InternalTGG.g:7599:1: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7603:1: ( ( ruleAdornment ) )
            // InternalTGG.g:7604:1: ( ruleAdornment )
            {
            // InternalTGG.g:7604:1: ( ruleAdornment )
            // InternalTGG.g:7605:1: ruleAdornment
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAdornmentParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAdornment();

            state._fsp--;

             after(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAdornmentParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1"


    // $ANTLR start "rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0"
    // InternalTGG.g:7614:1: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7618:1: ( ( ruleAdornment ) )
            // InternalTGG.g:7619:1: ( ruleAdornment )
            {
            // InternalTGG.g:7619:1: ( ruleAdornment )
            // InternalTGG.g:7620:1: ruleAdornment
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAdornmentParserRuleCall_9_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleAdornment();

            state._fsp--;

             after(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAdornmentParserRuleCall_9_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0"


    // $ANTLR start "rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1"
    // InternalTGG.g:7629:1: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7633:1: ( ( ruleAdornment ) )
            // InternalTGG.g:7634:1: ( ruleAdornment )
            {
            // InternalTGG.g:7634:1: ( ruleAdornment )
            // InternalTGG.g:7635:1: ruleAdornment
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAdornmentParserRuleCall_9_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAdornment();

            state._fsp--;

             after(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAdornmentParserRuleCall_9_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1"


    // $ANTLR start "rule__Param__ParamNameAssignment_0"
    // InternalTGG.g:7644:1: rule__Param__ParamNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Param__ParamNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7648:1: ( ( RULE_ID ) )
            // InternalTGG.g:7649:1: ( RULE_ID )
            {
            // InternalTGG.g:7649:1: ( RULE_ID )
            // InternalTGG.g:7650:1: RULE_ID
            {
             before(grammarAccess.getParamAccess().getParamNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getParamAccess().getParamNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__ParamNameAssignment_0"


    // $ANTLR start "rule__Param__TypeAssignment_2"
    // InternalTGG.g:7659:1: rule__Param__TypeAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Param__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7663:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7664:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7664:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7665:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getParamAccess().getTypeEDataTypeCrossReference_2_0()); 
            // InternalTGG.g:7666:1: ( ruleQualifiedName )
            // InternalTGG.g:7667:1: ruleQualifiedName
            {
             before(grammarAccess.getParamAccess().getTypeEDataTypeQualifiedNameParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getParamAccess().getTypeEDataTypeQualifiedNameParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getParamAccess().getTypeEDataTypeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Param__TypeAssignment_2"


    // $ANTLR start "rule__Rule__AbstractRuleAssignment_0"
    // InternalTGG.g:7678:1: rule__Rule__AbstractRuleAssignment_0 : ( ( '#abstract' ) ) ;
    public final void rule__Rule__AbstractRuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7682:1: ( ( ( '#abstract' ) ) )
            // InternalTGG.g:7683:1: ( ( '#abstract' ) )
            {
            // InternalTGG.g:7683:1: ( ( '#abstract' ) )
            // InternalTGG.g:7684:1: ( '#abstract' )
            {
             before(grammarAccess.getRuleAccess().getAbstractRuleAbstractKeyword_0_0()); 
            // InternalTGG.g:7685:1: ( '#abstract' )
            // InternalTGG.g:7686:1: '#abstract'
            {
             before(grammarAccess.getRuleAccess().getAbstractRuleAbstractKeyword_0_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getAbstractRuleAbstractKeyword_0_0()); 

            }

             after(grammarAccess.getRuleAccess().getAbstractRuleAbstractKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__AbstractRuleAssignment_0"


    // $ANTLR start "rule__Rule__NameAssignment_2"
    // InternalTGG.g:7701:1: rule__Rule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Rule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7705:1: ( ( RULE_ID ) )
            // InternalTGG.g:7706:1: ( RULE_ID )
            {
            // InternalTGG.g:7706:1: ( RULE_ID )
            // InternalTGG.g:7707:1: RULE_ID
            {
             before(grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__NameAssignment_2"


    // $ANTLR start "rule__Rule__SupertypesAssignment_3_1"
    // InternalTGG.g:7716:1: rule__Rule__SupertypesAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Rule__SupertypesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7720:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7721:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7721:1: ( ( RULE_ID ) )
            // InternalTGG.g:7722:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_1_0()); 
            // InternalTGG.g:7723:1: ( RULE_ID )
            // InternalTGG.g:7724:1: RULE_ID
            {
             before(grammarAccess.getRuleAccess().getSupertypesRuleIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getSupertypesRuleIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__SupertypesAssignment_3_1"


    // $ANTLR start "rule__Rule__SupertypesAssignment_3_2_1"
    // InternalTGG.g:7735:1: rule__Rule__SupertypesAssignment_3_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Rule__SupertypesAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7739:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7740:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7740:1: ( ( RULE_ID ) )
            // InternalTGG.g:7741:1: ( RULE_ID )
            {
             before(grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_2_1_0()); 
            // InternalTGG.g:7742:1: ( RULE_ID )
            // InternalTGG.g:7743:1: RULE_ID
            {
             before(grammarAccess.getRuleAccess().getSupertypesRuleIDTerminalRuleCall_3_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getRuleAccess().getSupertypesRuleIDTerminalRuleCall_3_2_1_0_1()); 

            }

             after(grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__SupertypesAssignment_3_2_1"


    // $ANTLR start "rule__Rule__SchemaAssignment_5"
    // InternalTGG.g:7754:1: rule__Rule__SchemaAssignment_5 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Rule__SchemaAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7758:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7759:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7759:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7760:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getRuleAccess().getSchemaSchemaCrossReference_5_0()); 
            // InternalTGG.g:7761:1: ( ruleQualifiedName )
            // InternalTGG.g:7762:1: ruleQualifiedName
            {
             before(grammarAccess.getRuleAccess().getSchemaSchemaQualifiedNameParserRuleCall_5_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getSchemaSchemaQualifiedNameParserRuleCall_5_0_1()); 

            }

             after(grammarAccess.getRuleAccess().getSchemaSchemaCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__SchemaAssignment_5"


    // $ANTLR start "rule__Rule__SourcePatternsAssignment_6_2"
    // InternalTGG.g:7773:1: rule__Rule__SourcePatternsAssignment_6_2 : ( ruleObjectVariablePattern ) ;
    public final void rule__Rule__SourcePatternsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7777:1: ( ( ruleObjectVariablePattern ) )
            // InternalTGG.g:7778:1: ( ruleObjectVariablePattern )
            {
            // InternalTGG.g:7778:1: ( ruleObjectVariablePattern )
            // InternalTGG.g:7779:1: ruleObjectVariablePattern
            {
             before(grammarAccess.getRuleAccess().getSourcePatternsObjectVariablePatternParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            ruleObjectVariablePattern();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getSourcePatternsObjectVariablePatternParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__SourcePatternsAssignment_6_2"


    // $ANTLR start "rule__Rule__TargetPatternsAssignment_7_2"
    // InternalTGG.g:7788:1: rule__Rule__TargetPatternsAssignment_7_2 : ( ruleObjectVariablePattern ) ;
    public final void rule__Rule__TargetPatternsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7792:1: ( ( ruleObjectVariablePattern ) )
            // InternalTGG.g:7793:1: ( ruleObjectVariablePattern )
            {
            // InternalTGG.g:7793:1: ( ruleObjectVariablePattern )
            // InternalTGG.g:7794:1: ruleObjectVariablePattern
            {
             before(grammarAccess.getRuleAccess().getTargetPatternsObjectVariablePatternParserRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleObjectVariablePattern();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getTargetPatternsObjectVariablePatternParserRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__TargetPatternsAssignment_7_2"


    // $ANTLR start "rule__Rule__CorrespondencePatternsAssignment_8_2"
    // InternalTGG.g:7803:1: rule__Rule__CorrespondencePatternsAssignment_8_2 : ( ruleCorrVariablePattern ) ;
    public final void rule__Rule__CorrespondencePatternsAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7807:1: ( ( ruleCorrVariablePattern ) )
            // InternalTGG.g:7808:1: ( ruleCorrVariablePattern )
            {
            // InternalTGG.g:7808:1: ( ruleCorrVariablePattern )
            // InternalTGG.g:7809:1: ruleCorrVariablePattern
            {
             before(grammarAccess.getRuleAccess().getCorrespondencePatternsCorrVariablePatternParserRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCorrVariablePattern();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getCorrespondencePatternsCorrVariablePatternParserRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__CorrespondencePatternsAssignment_8_2"


    // $ANTLR start "rule__Rule__AttrConditionsAssignment_9_2"
    // InternalTGG.g:7818:1: rule__Rule__AttrConditionsAssignment_9_2 : ( ruleAttrCond ) ;
    public final void rule__Rule__AttrConditionsAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7822:1: ( ( ruleAttrCond ) )
            // InternalTGG.g:7823:1: ( ruleAttrCond )
            {
            // InternalTGG.g:7823:1: ( ruleAttrCond )
            // InternalTGG.g:7824:1: ruleAttrCond
            {
             before(grammarAccess.getRuleAccess().getAttrConditionsAttrCondParserRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttrCond();

            state._fsp--;

             after(grammarAccess.getRuleAccess().getAttrConditionsAttrCondParserRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Rule__AttrConditionsAssignment_9_2"


    // $ANTLR start "rule__AttrCond__NameAssignment_0"
    // InternalTGG.g:7833:1: rule__AttrCond__NameAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AttrCond__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7837:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7838:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7838:1: ( ( RULE_ID ) )
            // InternalTGG.g:7839:1: ( RULE_ID )
            {
             before(grammarAccess.getAttrCondAccess().getNameAttrCondDefCrossReference_0_0()); 
            // InternalTGG.g:7840:1: ( RULE_ID )
            // InternalTGG.g:7841:1: RULE_ID
            {
             before(grammarAccess.getAttrCondAccess().getNameAttrCondDefIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttrCondAccess().getNameAttrCondDefIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttrCondAccess().getNameAttrCondDefCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__NameAssignment_0"


    // $ANTLR start "rule__AttrCond__ValuesAssignment_2_0"
    // InternalTGG.g:7852:1: rule__AttrCond__ValuesAssignment_2_0 : ( ruleParamValue ) ;
    public final void rule__AttrCond__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7856:1: ( ( ruleParamValue ) )
            // InternalTGG.g:7857:1: ( ruleParamValue )
            {
            // InternalTGG.g:7857:1: ( ruleParamValue )
            // InternalTGG.g:7858:1: ruleParamValue
            {
             before(grammarAccess.getAttrCondAccess().getValuesParamValueParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleParamValue();

            state._fsp--;

             after(grammarAccess.getAttrCondAccess().getValuesParamValueParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__ValuesAssignment_2_0"


    // $ANTLR start "rule__AttrCond__ValuesAssignment_2_1_1"
    // InternalTGG.g:7867:1: rule__AttrCond__ValuesAssignment_2_1_1 : ( ruleParamValue ) ;
    public final void rule__AttrCond__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7871:1: ( ( ruleParamValue ) )
            // InternalTGG.g:7872:1: ( ruleParamValue )
            {
            // InternalTGG.g:7872:1: ( ruleParamValue )
            // InternalTGG.g:7873:1: ruleParamValue
            {
             before(grammarAccess.getAttrCondAccess().getValuesParamValueParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleParamValue();

            state._fsp--;

             after(grammarAccess.getAttrCondAccess().getValuesParamValueParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCond__ValuesAssignment_2_1_1"


    // $ANTLR start "rule__AttrCondDefLibrary__NameAssignment_1"
    // InternalTGG.g:7882:1: rule__AttrCondDefLibrary__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__AttrCondDefLibrary__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7886:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7887:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:7887:1: ( ruleQualifiedName )
            // InternalTGG.g:7888:1: ruleQualifiedName
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getAttrCondDefLibraryAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__NameAssignment_1"


    // $ANTLR start "rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1"
    // InternalTGG.g:7897:1: rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 : ( ruleAttrCondDef ) ;
    public final void rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7901:1: ( ( ruleAttrCondDef ) )
            // InternalTGG.g:7902:1: ( ruleAttrCondDef )
            {
            // InternalTGG.g:7902:1: ( ruleAttrCondDef )
            // InternalTGG.g:7903:1: ruleAttrCondDef
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getAttributeCondDefsAttrCondDefParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttrCondDef();

            state._fsp--;

             after(grammarAccess.getAttrCondDefLibraryAccess().getAttributeCondDefsAttrCondDefParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1"


    // $ANTLR start "rule__Adornment__ValueAssignment_1"
    // InternalTGG.g:7912:1: rule__Adornment__ValueAssignment_1 : ( ( rule__Adornment__ValueAlternatives_1_0 ) ) ;
    public final void rule__Adornment__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7916:1: ( ( ( rule__Adornment__ValueAlternatives_1_0 ) ) )
            // InternalTGG.g:7917:1: ( ( rule__Adornment__ValueAlternatives_1_0 ) )
            {
            // InternalTGG.g:7917:1: ( ( rule__Adornment__ValueAlternatives_1_0 ) )
            // InternalTGG.g:7918:1: ( rule__Adornment__ValueAlternatives_1_0 )
            {
             before(grammarAccess.getAdornmentAccess().getValueAlternatives_1_0()); 
            // InternalTGG.g:7919:1: ( rule__Adornment__ValueAlternatives_1_0 )
            // InternalTGG.g:7919:2: rule__Adornment__ValueAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Adornment__ValueAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAdornmentAccess().getValueAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Adornment__ValueAssignment_1"


    // $ANTLR start "rule__LocalVariable__NameAssignment"
    // InternalTGG.g:7928:1: rule__LocalVariable__NameAssignment : ( RULE_ID ) ;
    public final void rule__LocalVariable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7932:1: ( ( RULE_ID ) )
            // InternalTGG.g:7933:1: ( RULE_ID )
            {
            // InternalTGG.g:7933:1: ( RULE_ID )
            // InternalTGG.g:7934:1: RULE_ID
            {
             before(grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__NameAssignment"


    // $ANTLR start "rule__CorrVariablePattern__OpAssignment_0"
    // InternalTGG.g:7943:1: rule__CorrVariablePattern__OpAssignment_0 : ( ruleOperator ) ;
    public final void rule__CorrVariablePattern__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7947:1: ( ( ruleOperator ) )
            // InternalTGG.g:7948:1: ( ruleOperator )
            {
            // InternalTGG.g:7948:1: ( ruleOperator )
            // InternalTGG.g:7949:1: ruleOperator
            {
             before(grammarAccess.getCorrVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getCorrVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__OpAssignment_0"


    // $ANTLR start "rule__CorrVariablePattern__NameAssignment_1"
    // InternalTGG.g:7958:1: rule__CorrVariablePattern__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CorrVariablePattern__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7962:1: ( ( RULE_ID ) )
            // InternalTGG.g:7963:1: ( RULE_ID )
            {
            // InternalTGG.g:7963:1: ( RULE_ID )
            // InternalTGG.g:7964:1: RULE_ID
            {
             before(grammarAccess.getCorrVariablePatternAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__NameAssignment_1"


    // $ANTLR start "rule__CorrVariablePattern__TypeAssignment_3"
    // InternalTGG.g:7973:1: rule__CorrVariablePattern__TypeAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CorrVariablePattern__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7977:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7978:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7978:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7979:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTypeCorrTypeCrossReference_3_0()); 
            // InternalTGG.g:7980:1: ( ruleQualifiedName )
            // InternalTGG.g:7981:1: ruleQualifiedName
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTypeCorrTypeQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCorrVariablePatternAccess().getTypeCorrTypeQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getCorrVariablePatternAccess().getTypeCorrTypeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__TypeAssignment_3"


    // $ANTLR start "rule__CorrVariablePattern__SourceAssignment_6"
    // InternalTGG.g:7992:1: rule__CorrVariablePattern__SourceAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__CorrVariablePattern__SourceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:7996:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7997:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7997:1: ( ( RULE_ID ) )
            // InternalTGG.g:7998:1: ( RULE_ID )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getSourceObjectVariablePatternCrossReference_6_0()); 
            // InternalTGG.g:7999:1: ( RULE_ID )
            // InternalTGG.g:8000:1: RULE_ID
            {
             before(grammarAccess.getCorrVariablePatternAccess().getSourceObjectVariablePatternIDTerminalRuleCall_6_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getSourceObjectVariablePatternIDTerminalRuleCall_6_0_1()); 

            }

             after(grammarAccess.getCorrVariablePatternAccess().getSourceObjectVariablePatternCrossReference_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__SourceAssignment_6"


    // $ANTLR start "rule__CorrVariablePattern__TargetAssignment_8"
    // InternalTGG.g:8011:1: rule__CorrVariablePattern__TargetAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__CorrVariablePattern__TargetAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8015:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8016:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8016:1: ( ( RULE_ID ) )
            // InternalTGG.g:8017:1: ( RULE_ID )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTargetObjectVariablePatternCrossReference_8_0()); 
            // InternalTGG.g:8018:1: ( RULE_ID )
            // InternalTGG.g:8019:1: RULE_ID
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTargetObjectVariablePatternIDTerminalRuleCall_8_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCorrVariablePatternAccess().getTargetObjectVariablePatternIDTerminalRuleCall_8_0_1()); 

            }

             after(grammarAccess.getCorrVariablePatternAccess().getTargetObjectVariablePatternCrossReference_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CorrVariablePattern__TargetAssignment_8"


    // $ANTLR start "rule__ObjectVariablePattern__OpAssignment_0"
    // InternalTGG.g:8030:1: rule__ObjectVariablePattern__OpAssignment_0 : ( ruleOperator ) ;
    public final void rule__ObjectVariablePattern__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8034:1: ( ( ruleOperator ) )
            // InternalTGG.g:8035:1: ( ruleOperator )
            {
            // InternalTGG.g:8035:1: ( ruleOperator )
            // InternalTGG.g:8036:1: ruleOperator
            {
             before(grammarAccess.getObjectVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getObjectVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__OpAssignment_0"


    // $ANTLR start "rule__ObjectVariablePattern__NameAssignment_1"
    // InternalTGG.g:8045:1: rule__ObjectVariablePattern__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ObjectVariablePattern__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8049:1: ( ( RULE_ID ) )
            // InternalTGG.g:8050:1: ( RULE_ID )
            {
            // InternalTGG.g:8050:1: ( RULE_ID )
            // InternalTGG.g:8051:1: RULE_ID
            {
             before(grammarAccess.getObjectVariablePatternAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getObjectVariablePatternAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__NameAssignment_1"


    // $ANTLR start "rule__ObjectVariablePattern__TypeAssignment_3"
    // InternalTGG.g:8060:1: rule__ObjectVariablePattern__TypeAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ObjectVariablePattern__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8064:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:8065:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:8065:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:8066:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getTypeEClassCrossReference_3_0()); 
            // InternalTGG.g:8067:1: ( ruleQualifiedName )
            // InternalTGG.g:8068:1: ruleQualifiedName
            {
             before(grammarAccess.getObjectVariablePatternAccess().getTypeEClassQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getObjectVariablePatternAccess().getTypeEClassQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getObjectVariablePatternAccess().getTypeEClassCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__TypeAssignment_3"


    // $ANTLR start "rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1"
    // InternalTGG.g:8079:1: rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 : ( ruleAttributeAssignment ) ;
    public final void rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8083:1: ( ( ruleAttributeAssignment ) )
            // InternalTGG.g:8084:1: ( ruleAttributeAssignment )
            {
            // InternalTGG.g:8084:1: ( ruleAttributeAssignment )
            // InternalTGG.g:8085:1: ruleAttributeAssignment
            {
             before(grammarAccess.getObjectVariablePatternAccess().getAttributeAssignmentsAttributeAssignmentParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeAssignment();

            state._fsp--;

             after(grammarAccess.getObjectVariablePatternAccess().getAttributeAssignmentsAttributeAssignmentParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1"


    // $ANTLR start "rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2"
    // InternalTGG.g:8094:1: rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 : ( ruleAttributeConstraint ) ;
    public final void rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8098:1: ( ( ruleAttributeConstraint ) )
            // InternalTGG.g:8099:1: ( ruleAttributeConstraint )
            {
            // InternalTGG.g:8099:1: ( ruleAttributeConstraint )
            // InternalTGG.g:8100:1: ruleAttributeConstraint
            {
             before(grammarAccess.getObjectVariablePatternAccess().getAttributeConstraintsAttributeConstraintParserRuleCall_4_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeConstraint();

            state._fsp--;

             after(grammarAccess.getObjectVariablePatternAccess().getAttributeConstraintsAttributeConstraintParserRuleCall_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2"


    // $ANTLR start "rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3"
    // InternalTGG.g:8109:1: rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 : ( ruleLinkVariablePattern ) ;
    public final void rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8113:1: ( ( ruleLinkVariablePattern ) )
            // InternalTGG.g:8114:1: ( ruleLinkVariablePattern )
            {
            // InternalTGG.g:8114:1: ( ruleLinkVariablePattern )
            // InternalTGG.g:8115:1: ruleLinkVariablePattern
            {
             before(grammarAccess.getObjectVariablePatternAccess().getLinkVariablePatternsLinkVariablePatternParserRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
            ruleLinkVariablePattern();

            state._fsp--;

             after(grammarAccess.getObjectVariablePatternAccess().getLinkVariablePatternsLinkVariablePatternParserRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3"


    // $ANTLR start "rule__ContextObjectVariablePattern__NameAssignment_0"
    // InternalTGG.g:8124:1: rule__ContextObjectVariablePattern__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ContextObjectVariablePattern__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8128:1: ( ( RULE_ID ) )
            // InternalTGG.g:8129:1: ( RULE_ID )
            {
            // InternalTGG.g:8129:1: ( RULE_ID )
            // InternalTGG.g:8130:1: RULE_ID
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getContextObjectVariablePatternAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__NameAssignment_0"


    // $ANTLR start "rule__ContextObjectVariablePattern__TypeAssignment_2"
    // InternalTGG.g:8139:1: rule__ContextObjectVariablePattern__TypeAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ContextObjectVariablePattern__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8143:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:8144:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:8144:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:8145:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getTypeEClassCrossReference_2_0()); 
            // InternalTGG.g:8146:1: ( ruleQualifiedName )
            // InternalTGG.g:8147:1: ruleQualifiedName
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getTypeEClassQualifiedNameParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getContextObjectVariablePatternAccess().getTypeEClassQualifiedNameParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getContextObjectVariablePatternAccess().getTypeEClassCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__TypeAssignment_2"


    // $ANTLR start "rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1"
    // InternalTGG.g:8158:1: rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 : ( ruleAttributeConstraint ) ;
    public final void rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8162:1: ( ( ruleAttributeConstraint ) )
            // InternalTGG.g:8163:1: ( ruleAttributeConstraint )
            {
            // InternalTGG.g:8163:1: ( ruleAttributeConstraint )
            // InternalTGG.g:8164:1: ruleAttributeConstraint
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getAttributeConstraintsAttributeConstraintParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttributeConstraint();

            state._fsp--;

             after(grammarAccess.getContextObjectVariablePatternAccess().getAttributeConstraintsAttributeConstraintParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1"


    // $ANTLR start "rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2"
    // InternalTGG.g:8173:1: rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 : ( ruleContextLinkVariablePattern ) ;
    public final void rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8177:1: ( ( ruleContextLinkVariablePattern ) )
            // InternalTGG.g:8178:1: ( ruleContextLinkVariablePattern )
            {
            // InternalTGG.g:8178:1: ( ruleContextLinkVariablePattern )
            // InternalTGG.g:8179:1: ruleContextLinkVariablePattern
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getLinkVariablePatternsContextLinkVariablePatternParserRuleCall_3_2_0()); 
            pushFollow(FOLLOW_2);
            ruleContextLinkVariablePattern();

            state._fsp--;

             after(grammarAccess.getContextObjectVariablePatternAccess().getLinkVariablePatternsContextLinkVariablePatternParserRuleCall_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2"


    // $ANTLR start "rule__AttributeConstraint__AttributeAssignment_0"
    // InternalTGG.g:8188:1: rule__AttributeConstraint__AttributeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeConstraint__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8192:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8193:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8193:1: ( ( RULE_ID ) )
            // InternalTGG.g:8194:1: ( RULE_ID )
            {
             before(grammarAccess.getAttributeConstraintAccess().getAttributeEAttributeCrossReference_0_0()); 
            // InternalTGG.g:8195:1: ( RULE_ID )
            // InternalTGG.g:8196:1: RULE_ID
            {
             before(grammarAccess.getAttributeConstraintAccess().getAttributeEAttributeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeConstraintAccess().getAttributeEAttributeIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeConstraintAccess().getAttributeEAttributeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__AttributeAssignment_0"


    // $ANTLR start "rule__AttributeConstraint__OpAssignment_1"
    // InternalTGG.g:8207:1: rule__AttributeConstraint__OpAssignment_1 : ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) ) ;
    public final void rule__AttributeConstraint__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8211:1: ( ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) ) )
            // InternalTGG.g:8212:1: ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) )
            {
            // InternalTGG.g:8212:1: ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) )
            // InternalTGG.g:8213:1: ( rule__AttributeConstraint__OpAlternatives_1_0 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getOpAlternatives_1_0()); 
            // InternalTGG.g:8214:1: ( rule__AttributeConstraint__OpAlternatives_1_0 )
            // InternalTGG.g:8214:2: rule__AttributeConstraint__OpAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AttributeConstraint__OpAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeConstraintAccess().getOpAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__OpAssignment_1"


    // $ANTLR start "rule__AttributeConstraint__ValueExpAssignment_2"
    // InternalTGG.g:8223:1: rule__AttributeConstraint__ValueExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__AttributeConstraint__ValueExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8227:1: ( ( ruleExpression ) )
            // InternalTGG.g:8228:1: ( ruleExpression )
            {
            // InternalTGG.g:8228:1: ( ruleExpression )
            // InternalTGG.g:8229:1: ruleExpression
            {
             before(grammarAccess.getAttributeConstraintAccess().getValueExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAttributeConstraintAccess().getValueExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeConstraint__ValueExpAssignment_2"


    // $ANTLR start "rule__AttributeAssignment__AttributeAssignment_0"
    // InternalTGG.g:8238:1: rule__AttributeAssignment__AttributeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeAssignment__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8242:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8243:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8243:1: ( ( RULE_ID ) )
            // InternalTGG.g:8244:1: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getAttributeEAttributeCrossReference_0_0()); 
            // InternalTGG.g:8245:1: ( RULE_ID )
            // InternalTGG.g:8246:1: RULE_ID
            {
             before(grammarAccess.getAttributeAssignmentAccess().getAttributeEAttributeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAssignmentAccess().getAttributeEAttributeIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAttributeAssignmentAccess().getAttributeEAttributeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__AttributeAssignment_0"


    // $ANTLR start "rule__AttributeAssignment__OpAssignment_1"
    // InternalTGG.g:8257:1: rule__AttributeAssignment__OpAssignment_1 : ( ( ':=' ) ) ;
    public final void rule__AttributeAssignment__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8261:1: ( ( ( ':=' ) ) )
            // InternalTGG.g:8262:1: ( ( ':=' ) )
            {
            // InternalTGG.g:8262:1: ( ( ':=' ) )
            // InternalTGG.g:8263:1: ( ':=' )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getOpColonEqualsSignKeyword_1_0()); 
            // InternalTGG.g:8264:1: ( ':=' )
            // InternalTGG.g:8265:1: ':='
            {
             before(grammarAccess.getAttributeAssignmentAccess().getOpColonEqualsSignKeyword_1_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getAttributeAssignmentAccess().getOpColonEqualsSignKeyword_1_0()); 

            }

             after(grammarAccess.getAttributeAssignmentAccess().getOpColonEqualsSignKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__OpAssignment_1"


    // $ANTLR start "rule__AttributeAssignment__ValueExpAssignment_2"
    // InternalTGG.g:8280:1: rule__AttributeAssignment__ValueExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__AttributeAssignment__ValueExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8284:1: ( ( ruleExpression ) )
            // InternalTGG.g:8285:1: ( ruleExpression )
            {
            // InternalTGG.g:8285:1: ( ruleExpression )
            // InternalTGG.g:8286:1: ruleExpression
            {
             before(grammarAccess.getAttributeAssignmentAccess().getValueExpExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAttributeAssignmentAccess().getValueExpExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeAssignment__ValueExpAssignment_2"


    // $ANTLR start "rule__EnumExpression__EenumAssignment_1"
    // InternalTGG.g:8295:1: rule__EnumExpression__EenumAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumExpression__EenumAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8299:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:8300:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:8300:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:8301:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getEnumExpressionAccess().getEenumEEnumCrossReference_1_0()); 
            // InternalTGG.g:8302:1: ( ruleQualifiedName )
            // InternalTGG.g:8303:1: ruleQualifiedName
            {
             before(grammarAccess.getEnumExpressionAccess().getEenumEEnumQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getEnumExpressionAccess().getEenumEEnumQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEnumExpressionAccess().getEenumEEnumCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__EenumAssignment_1"


    // $ANTLR start "rule__EnumExpression__LiteralAssignment_3"
    // InternalTGG.g:8314:1: rule__EnumExpression__LiteralAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumExpression__LiteralAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8318:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:8319:1: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:8319:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:8320:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getEnumExpressionAccess().getLiteralEEnumLiteralCrossReference_3_0()); 
            // InternalTGG.g:8321:1: ( ruleQualifiedName )
            // InternalTGG.g:8322:1: ruleQualifiedName
            {
             before(grammarAccess.getEnumExpressionAccess().getLiteralEEnumLiteralQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getEnumExpressionAccess().getLiteralEEnumLiteralQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getEnumExpressionAccess().getLiteralEEnumLiteralCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumExpression__LiteralAssignment_3"


    // $ANTLR start "rule__AttributeExpression__DerivedAssignment_0"
    // InternalTGG.g:8333:1: rule__AttributeExpression__DerivedAssignment_0 : ( ( '#derived' ) ) ;
    public final void rule__AttributeExpression__DerivedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8337:1: ( ( ( '#derived' ) ) )
            // InternalTGG.g:8338:1: ( ( '#derived' ) )
            {
            // InternalTGG.g:8338:1: ( ( '#derived' ) )
            // InternalTGG.g:8339:1: ( '#derived' )
            {
             before(grammarAccess.getAttributeExpressionAccess().getDerivedDerivedKeyword_0_0()); 
            // InternalTGG.g:8340:1: ( '#derived' )
            // InternalTGG.g:8341:1: '#derived'
            {
             before(grammarAccess.getAttributeExpressionAccess().getDerivedDerivedKeyword_0_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getAttributeExpressionAccess().getDerivedDerivedKeyword_0_0()); 

            }

             after(grammarAccess.getAttributeExpressionAccess().getDerivedDerivedKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__DerivedAssignment_0"


    // $ANTLR start "rule__AttributeExpression__ObjectVarAssignment_1"
    // InternalTGG.g:8356:1: rule__AttributeExpression__ObjectVarAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeExpression__ObjectVarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8360:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8361:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8361:1: ( ( RULE_ID ) )
            // InternalTGG.g:8362:1: ( RULE_ID )
            {
             before(grammarAccess.getAttributeExpressionAccess().getObjectVarEObjectCrossReference_1_0()); 
            // InternalTGG.g:8363:1: ( RULE_ID )
            // InternalTGG.g:8364:1: RULE_ID
            {
             before(grammarAccess.getAttributeExpressionAccess().getObjectVarEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeExpressionAccess().getObjectVarEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getAttributeExpressionAccess().getObjectVarEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__ObjectVarAssignment_1"


    // $ANTLR start "rule__AttributeExpression__AttributeAssignment_3"
    // InternalTGG.g:8375:1: rule__AttributeExpression__AttributeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeExpression__AttributeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8379:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8380:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8380:1: ( ( RULE_ID ) )
            // InternalTGG.g:8381:1: ( RULE_ID )
            {
             before(grammarAccess.getAttributeExpressionAccess().getAttributeEAttributeCrossReference_3_0()); 
            // InternalTGG.g:8382:1: ( RULE_ID )
            // InternalTGG.g:8383:1: RULE_ID
            {
             before(grammarAccess.getAttributeExpressionAccess().getAttributeEAttributeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeExpressionAccess().getAttributeEAttributeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getAttributeExpressionAccess().getAttributeEAttributeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AttributeExpression__AttributeAssignment_3"


    // $ANTLR start "rule__LiteralExpression__ValueAssignment"
    // InternalTGG.g:8394:1: rule__LiteralExpression__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__LiteralExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8398:1: ( ( ruleLiteralValue ) )
            // InternalTGG.g:8399:1: ( ruleLiteralValue )
            {
            // InternalTGG.g:8399:1: ( ruleLiteralValue )
            // InternalTGG.g:8400:1: ruleLiteralValue
            {
             before(grammarAccess.getLiteralExpressionAccess().getValueLiteralValueParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleLiteralValue();

            state._fsp--;

             after(grammarAccess.getLiteralExpressionAccess().getValueLiteralValueParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralExpression__ValueAssignment"


    // $ANTLR start "rule__LinkVariablePattern__OpAssignment_0"
    // InternalTGG.g:8409:1: rule__LinkVariablePattern__OpAssignment_0 : ( ruleOperator ) ;
    public final void rule__LinkVariablePattern__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8413:1: ( ( ruleOperator ) )
            // InternalTGG.g:8414:1: ( ruleOperator )
            {
            // InternalTGG.g:8414:1: ( ruleOperator )
            // InternalTGG.g:8415:1: ruleOperator
            {
             before(grammarAccess.getLinkVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOperator();

            state._fsp--;

             after(grammarAccess.getLinkVariablePatternAccess().getOpOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__OpAssignment_0"


    // $ANTLR start "rule__LinkVariablePattern__TypeAssignment_2"
    // InternalTGG.g:8424:1: rule__LinkVariablePattern__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LinkVariablePattern__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8428:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8429:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8429:1: ( ( RULE_ID ) )
            // InternalTGG.g:8430:1: ( RULE_ID )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTypeEReferenceCrossReference_2_0()); 
            // InternalTGG.g:8431:1: ( RULE_ID )
            // InternalTGG.g:8432:1: RULE_ID
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTypeEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLinkVariablePatternAccess().getTypeEReferenceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getLinkVariablePatternAccess().getTypeEReferenceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__TypeAssignment_2"


    // $ANTLR start "rule__LinkVariablePattern__TargetAssignment_4"
    // InternalTGG.g:8443:1: rule__LinkVariablePattern__TargetAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__LinkVariablePattern__TargetAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8447:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8448:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8448:1: ( ( RULE_ID ) )
            // InternalTGG.g:8449:1: ( RULE_ID )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTargetObjectVariablePatternCrossReference_4_0()); 
            // InternalTGG.g:8450:1: ( RULE_ID )
            // InternalTGG.g:8451:1: RULE_ID
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTargetObjectVariablePatternIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLinkVariablePatternAccess().getTargetObjectVariablePatternIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getLinkVariablePatternAccess().getTargetObjectVariablePatternCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LinkVariablePattern__TargetAssignment_4"


    // $ANTLR start "rule__ContextLinkVariablePattern__TypeAssignment_1"
    // InternalTGG.g:8462:1: rule__ContextLinkVariablePattern__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ContextLinkVariablePattern__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8466:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8467:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8467:1: ( ( RULE_ID ) )
            // InternalTGG.g:8468:1: ( RULE_ID )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTypeEReferenceCrossReference_1_0()); 
            // InternalTGG.g:8469:1: ( RULE_ID )
            // InternalTGG.g:8470:1: RULE_ID
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTypeEReferenceIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getContextLinkVariablePatternAccess().getTypeEReferenceIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getContextLinkVariablePatternAccess().getTypeEReferenceCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__TypeAssignment_1"


    // $ANTLR start "rule__ContextLinkVariablePattern__TargetAssignment_3"
    // InternalTGG.g:8481:1: rule__ContextLinkVariablePattern__TargetAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ContextLinkVariablePattern__TargetAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8485:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8486:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8486:1: ( ( RULE_ID ) )
            // InternalTGG.g:8487:1: ( RULE_ID )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTargetContextObjectVariablePatternCrossReference_3_0()); 
            // InternalTGG.g:8488:1: ( RULE_ID )
            // InternalTGG.g:8489:1: RULE_ID
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTargetContextObjectVariablePatternIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getContextLinkVariablePatternAccess().getTargetContextObjectVariablePatternIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getContextLinkVariablePatternAccess().getTargetContextObjectVariablePatternCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContextLinkVariablePattern__TargetAssignment_3"


    // $ANTLR start "rule__Operator__ValueAssignment"
    // InternalTGG.g:8500:1: rule__Operator__ValueAssignment : ( ( '++' ) ) ;
    public final void rule__Operator__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8504:1: ( ( ( '++' ) ) )
            // InternalTGG.g:8505:1: ( ( '++' ) )
            {
            // InternalTGG.g:8505:1: ( ( '++' ) )
            // InternalTGG.g:8506:1: ( '++' )
            {
             before(grammarAccess.getOperatorAccess().getValuePlusSignPlusSignKeyword_0()); 
            // InternalTGG.g:8507:1: ( '++' )
            // InternalTGG.g:8508:1: '++'
            {
             before(grammarAccess.getOperatorAccess().getValuePlusSignPlusSignKeyword_0()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getOperatorAccess().getValuePlusSignPlusSignKeyword_0()); 

            }

             after(grammarAccess.getOperatorAccess().getValuePlusSignPlusSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Operator__ValueAssignment"


    // $ANTLR start "rule__Nac__NameAssignment_1"
    // InternalTGG.g:8523:1: rule__Nac__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Nac__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8527:1: ( ( RULE_ID ) )
            // InternalTGG.g:8528:1: ( RULE_ID )
            {
            // InternalTGG.g:8528:1: ( RULE_ID )
            // InternalTGG.g:8529:1: RULE_ID
            {
             before(grammarAccess.getNacAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__NameAssignment_1"


    // $ANTLR start "rule__Nac__RuleAssignment_3"
    // InternalTGG.g:8538:1: rule__Nac__RuleAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Nac__RuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8542:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:8543:1: ( ( RULE_ID ) )
            {
            // InternalTGG.g:8543:1: ( ( RULE_ID ) )
            // InternalTGG.g:8544:1: ( RULE_ID )
            {
             before(grammarAccess.getNacAccess().getRuleRuleCrossReference_3_0()); 
            // InternalTGG.g:8545:1: ( RULE_ID )
            // InternalTGG.g:8546:1: RULE_ID
            {
             before(grammarAccess.getNacAccess().getRuleRuleIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNacAccess().getRuleRuleIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getNacAccess().getRuleRuleCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__RuleAssignment_3"


    // $ANTLR start "rule__Nac__SourcePatternsAssignment_4_0_2"
    // InternalTGG.g:8557:1: rule__Nac__SourcePatternsAssignment_4_0_2 : ( ruleContextObjectVariablePattern ) ;
    public final void rule__Nac__SourcePatternsAssignment_4_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8561:1: ( ( ruleContextObjectVariablePattern ) )
            // InternalTGG.g:8562:1: ( ruleContextObjectVariablePattern )
            {
            // InternalTGG.g:8562:1: ( ruleContextObjectVariablePattern )
            // InternalTGG.g:8563:1: ruleContextObjectVariablePattern
            {
             before(grammarAccess.getNacAccess().getSourcePatternsContextObjectVariablePatternParserRuleCall_4_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleContextObjectVariablePattern();

            state._fsp--;

             after(grammarAccess.getNacAccess().getSourcePatternsContextObjectVariablePatternParserRuleCall_4_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__SourcePatternsAssignment_4_0_2"


    // $ANTLR start "rule__Nac__TargetPatternsAssignment_4_1_2"
    // InternalTGG.g:8572:1: rule__Nac__TargetPatternsAssignment_4_1_2 : ( ruleContextObjectVariablePattern ) ;
    public final void rule__Nac__TargetPatternsAssignment_4_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8576:1: ( ( ruleContextObjectVariablePattern ) )
            // InternalTGG.g:8577:1: ( ruleContextObjectVariablePattern )
            {
            // InternalTGG.g:8577:1: ( ruleContextObjectVariablePattern )
            // InternalTGG.g:8578:1: ruleContextObjectVariablePattern
            {
             before(grammarAccess.getNacAccess().getTargetPatternsContextObjectVariablePatternParserRuleCall_4_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleContextObjectVariablePattern();

            state._fsp--;

             after(grammarAccess.getNacAccess().getTargetPatternsContextObjectVariablePatternParserRuleCall_4_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__TargetPatternsAssignment_4_1_2"


    // $ANTLR start "rule__Nac__AttrConditionsAssignment_5_2"
    // InternalTGG.g:8587:1: rule__Nac__AttrConditionsAssignment_5_2 : ( ruleAttrCond ) ;
    public final void rule__Nac__AttrConditionsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8591:1: ( ( ruleAttrCond ) )
            // InternalTGG.g:8592:1: ( ruleAttrCond )
            {
            // InternalTGG.g:8592:1: ( ruleAttrCond )
            // InternalTGG.g:8593:1: ruleAttrCond
            {
             before(grammarAccess.getNacAccess().getAttrConditionsAttrCondParserRuleCall_5_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAttrCond();

            state._fsp--;

             after(grammarAccess.getNacAccess().getAttrConditionsAttrCondParserRuleCall_5_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Nac__AttrConditionsAssignment_5_2"


    // $ANTLR start "rule__Import__NameAssignment_1"
    // InternalTGG.g:8602:1: rule__Import__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8606:1: ( ( RULE_STRING ) )
            // InternalTGG.g:8607:1: ( RULE_STRING )
            {
            // InternalTGG.g:8607:1: ( RULE_STRING )
            // InternalTGG.g:8608:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__NameAssignment_1"


    // $ANTLR start "rule__Using__ImportedNamespaceAssignment_1"
    // InternalTGG.g:8617:1: rule__Using__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Using__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalTGG.g:8621:1: ( ( ruleQualifiedNameWithWildcard ) )
            // InternalTGG.g:8622:1: ( ruleQualifiedNameWithWildcard )
            {
            // InternalTGG.g:8622:1: ( ruleQualifiedNameWithWildcard )
            // InternalTGG.g:8623:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getUsingAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getUsingAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Using__ImportedNamespaceAssignment_1"

    // Delegated rules


    protected DFA8 dfa8 = new DFA8(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\4\uffff\1\7\3\uffff\1\7\1\uffff";
    static final String dfa_3s = "\2\10\1\44\1\10\1\27\2\10\1\uffff\1\27\1\uffff";
    static final String dfa_4s = "\1\70\1\10\1\44\1\10\1\54\1\10\1\70\1\uffff\1\54\1\uffff";
    static final String dfa_5s = "\7\uffff\1\2\1\uffff\1\1";
    static final String dfa_6s = "\12\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\57\uffff\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\6\24\uffff\1\5",
            "\1\10",
            "\1\7\17\uffff\1\7\4\uffff\1\11\17\uffff\1\7\12\uffff\1\7",
            "",
            "\1\6\24\uffff\1\5",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1118:1: rule__NamePattern__Alternatives : ( ( ruleCorrVariablePattern ) | ( ruleObjectVariablePattern ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x002400A000200000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0020002000000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000E400000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001000100L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0010000001000100L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0010000000000102L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010800000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0010000000000100L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000100L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000C01000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0020002000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000004010000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0100000001000100L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0100000000000102L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x00802401000001F0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x00802400000001F0L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0100000000000100L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0100200001000100L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0100200000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000200001000100L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0080000000000100L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0100200000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000002400000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000200000000040L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000200000000080L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000100000000002L});

}