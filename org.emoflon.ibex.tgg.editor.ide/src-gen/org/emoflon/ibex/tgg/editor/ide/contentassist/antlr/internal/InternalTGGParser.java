package org.emoflon.ibex.tgg.editor.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.emoflon.ibex.tgg.editor.services.TGGGrammarAccess;



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
    // InternalTGG.g:53:1: entryRuleTripleGraphGrammarFile : ruleTripleGraphGrammarFile EOF ;
    public final void entryRuleTripleGraphGrammarFile() throws RecognitionException {
        try {
            // InternalTGG.g:54:1: ( ruleTripleGraphGrammarFile EOF )
            // InternalTGG.g:55:1: ruleTripleGraphGrammarFile EOF
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
    // InternalTGG.g:62:1: ruleTripleGraphGrammarFile : ( ( rule__TripleGraphGrammarFile__Group__0 ) ) ;
    public final void ruleTripleGraphGrammarFile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:66:2: ( ( ( rule__TripleGraphGrammarFile__Group__0 ) ) )
            // InternalTGG.g:67:2: ( ( rule__TripleGraphGrammarFile__Group__0 ) )
            {
            // InternalTGG.g:67:2: ( ( rule__TripleGraphGrammarFile__Group__0 ) )
            // InternalTGG.g:68:3: ( rule__TripleGraphGrammarFile__Group__0 )
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getGroup()); 
            // InternalTGG.g:69:3: ( rule__TripleGraphGrammarFile__Group__0 )
            // InternalTGG.g:69:4: rule__TripleGraphGrammarFile__Group__0
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
    // InternalTGG.g:78:1: entryRuleSchema : ruleSchema EOF ;
    public final void entryRuleSchema() throws RecognitionException {
        try {
            // InternalTGG.g:79:1: ( ruleSchema EOF )
            // InternalTGG.g:80:1: ruleSchema EOF
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
    // InternalTGG.g:87:1: ruleSchema : ( ( rule__Schema__Group__0 ) ) ;
    public final void ruleSchema() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:91:2: ( ( ( rule__Schema__Group__0 ) ) )
            // InternalTGG.g:92:2: ( ( rule__Schema__Group__0 ) )
            {
            // InternalTGG.g:92:2: ( ( rule__Schema__Group__0 ) )
            // InternalTGG.g:93:3: ( rule__Schema__Group__0 )
            {
             before(grammarAccess.getSchemaAccess().getGroup()); 
            // InternalTGG.g:94:3: ( rule__Schema__Group__0 )
            // InternalTGG.g:94:4: rule__Schema__Group__0
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
    // InternalTGG.g:103:1: entryRuleCorrType : ruleCorrType EOF ;
    public final void entryRuleCorrType() throws RecognitionException {
        try {
            // InternalTGG.g:104:1: ( ruleCorrType EOF )
            // InternalTGG.g:105:1: ruleCorrType EOF
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
    // InternalTGG.g:112:1: ruleCorrType : ( ( rule__CorrType__Group__0 ) ) ;
    public final void ruleCorrType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:116:2: ( ( ( rule__CorrType__Group__0 ) ) )
            // InternalTGG.g:117:2: ( ( rule__CorrType__Group__0 ) )
            {
            // InternalTGG.g:117:2: ( ( rule__CorrType__Group__0 ) )
            // InternalTGG.g:118:3: ( rule__CorrType__Group__0 )
            {
             before(grammarAccess.getCorrTypeAccess().getGroup()); 
            // InternalTGG.g:119:3: ( rule__CorrType__Group__0 )
            // InternalTGG.g:119:4: rule__CorrType__Group__0
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
    // InternalTGG.g:128:1: entryRuleAttrCondDef : ruleAttrCondDef EOF ;
    public final void entryRuleAttrCondDef() throws RecognitionException {
        try {
            // InternalTGG.g:129:1: ( ruleAttrCondDef EOF )
            // InternalTGG.g:130:1: ruleAttrCondDef EOF
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
    // InternalTGG.g:137:1: ruleAttrCondDef : ( ( rule__AttrCondDef__Group__0 ) ) ;
    public final void ruleAttrCondDef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:141:2: ( ( ( rule__AttrCondDef__Group__0 ) ) )
            // InternalTGG.g:142:2: ( ( rule__AttrCondDef__Group__0 ) )
            {
            // InternalTGG.g:142:2: ( ( rule__AttrCondDef__Group__0 ) )
            // InternalTGG.g:143:3: ( rule__AttrCondDef__Group__0 )
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup()); 
            // InternalTGG.g:144:3: ( rule__AttrCondDef__Group__0 )
            // InternalTGG.g:144:4: rule__AttrCondDef__Group__0
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
    // InternalTGG.g:153:1: entryRuleParam : ruleParam EOF ;
    public final void entryRuleParam() throws RecognitionException {
        try {
            // InternalTGG.g:154:1: ( ruleParam EOF )
            // InternalTGG.g:155:1: ruleParam EOF
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
    // InternalTGG.g:162:1: ruleParam : ( ( rule__Param__Group__0 ) ) ;
    public final void ruleParam() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:166:2: ( ( ( rule__Param__Group__0 ) ) )
            // InternalTGG.g:167:2: ( ( rule__Param__Group__0 ) )
            {
            // InternalTGG.g:167:2: ( ( rule__Param__Group__0 ) )
            // InternalTGG.g:168:3: ( rule__Param__Group__0 )
            {
             before(grammarAccess.getParamAccess().getGroup()); 
            // InternalTGG.g:169:3: ( rule__Param__Group__0 )
            // InternalTGG.g:169:4: rule__Param__Group__0
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
    // InternalTGG.g:178:1: entryRuleRule : ruleRule EOF ;
    public final void entryRuleRule() throws RecognitionException {
        try {
            // InternalTGG.g:179:1: ( ruleRule EOF )
            // InternalTGG.g:180:1: ruleRule EOF
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
    // InternalTGG.g:187:1: ruleRule : ( ( rule__Rule__Group__0 ) ) ;
    public final void ruleRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:191:2: ( ( ( rule__Rule__Group__0 ) ) )
            // InternalTGG.g:192:2: ( ( rule__Rule__Group__0 ) )
            {
            // InternalTGG.g:192:2: ( ( rule__Rule__Group__0 ) )
            // InternalTGG.g:193:3: ( rule__Rule__Group__0 )
            {
             before(grammarAccess.getRuleAccess().getGroup()); 
            // InternalTGG.g:194:3: ( rule__Rule__Group__0 )
            // InternalTGG.g:194:4: rule__Rule__Group__0
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
    // InternalTGG.g:203:1: entryRuleAttrCond : ruleAttrCond EOF ;
    public final void entryRuleAttrCond() throws RecognitionException {
        try {
            // InternalTGG.g:204:1: ( ruleAttrCond EOF )
            // InternalTGG.g:205:1: ruleAttrCond EOF
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
    // InternalTGG.g:212:1: ruleAttrCond : ( ( rule__AttrCond__Group__0 ) ) ;
    public final void ruleAttrCond() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:216:2: ( ( ( rule__AttrCond__Group__0 ) ) )
            // InternalTGG.g:217:2: ( ( rule__AttrCond__Group__0 ) )
            {
            // InternalTGG.g:217:2: ( ( rule__AttrCond__Group__0 ) )
            // InternalTGG.g:218:3: ( rule__AttrCond__Group__0 )
            {
             before(grammarAccess.getAttrCondAccess().getGroup()); 
            // InternalTGG.g:219:3: ( rule__AttrCond__Group__0 )
            // InternalTGG.g:219:4: rule__AttrCond__Group__0
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
    // InternalTGG.g:228:1: entryRuleAttrCondDefLibrary : ruleAttrCondDefLibrary EOF ;
    public final void entryRuleAttrCondDefLibrary() throws RecognitionException {
        try {
            // InternalTGG.g:229:1: ( ruleAttrCondDefLibrary EOF )
            // InternalTGG.g:230:1: ruleAttrCondDefLibrary EOF
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
    // InternalTGG.g:237:1: ruleAttrCondDefLibrary : ( ( rule__AttrCondDefLibrary__Group__0 ) ) ;
    public final void ruleAttrCondDefLibrary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:241:2: ( ( ( rule__AttrCondDefLibrary__Group__0 ) ) )
            // InternalTGG.g:242:2: ( ( rule__AttrCondDefLibrary__Group__0 ) )
            {
            // InternalTGG.g:242:2: ( ( rule__AttrCondDefLibrary__Group__0 ) )
            // InternalTGG.g:243:3: ( rule__AttrCondDefLibrary__Group__0 )
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getGroup()); 
            // InternalTGG.g:244:3: ( rule__AttrCondDefLibrary__Group__0 )
            // InternalTGG.g:244:4: rule__AttrCondDefLibrary__Group__0
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
    // InternalTGG.g:253:1: entryRuleAdornment : ruleAdornment EOF ;
    public final void entryRuleAdornment() throws RecognitionException {
        try {
            // InternalTGG.g:254:1: ( ruleAdornment EOF )
            // InternalTGG.g:255:1: ruleAdornment EOF
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
    // InternalTGG.g:262:1: ruleAdornment : ( ( rule__Adornment__Group__0 ) ) ;
    public final void ruleAdornment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:266:2: ( ( ( rule__Adornment__Group__0 ) ) )
            // InternalTGG.g:267:2: ( ( rule__Adornment__Group__0 ) )
            {
            // InternalTGG.g:267:2: ( ( rule__Adornment__Group__0 ) )
            // InternalTGG.g:268:3: ( rule__Adornment__Group__0 )
            {
             before(grammarAccess.getAdornmentAccess().getGroup()); 
            // InternalTGG.g:269:3: ( rule__Adornment__Group__0 )
            // InternalTGG.g:269:4: rule__Adornment__Group__0
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
    // InternalTGG.g:278:1: entryRuleParamValue : ruleParamValue EOF ;
    public final void entryRuleParamValue() throws RecognitionException {
        try {
            // InternalTGG.g:279:1: ( ruleParamValue EOF )
            // InternalTGG.g:280:1: ruleParamValue EOF
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
    // InternalTGG.g:287:1: ruleParamValue : ( ( rule__ParamValue__Alternatives ) ) ;
    public final void ruleParamValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:291:2: ( ( ( rule__ParamValue__Alternatives ) ) )
            // InternalTGG.g:292:2: ( ( rule__ParamValue__Alternatives ) )
            {
            // InternalTGG.g:292:2: ( ( rule__ParamValue__Alternatives ) )
            // InternalTGG.g:293:3: ( rule__ParamValue__Alternatives )
            {
             before(grammarAccess.getParamValueAccess().getAlternatives()); 
            // InternalTGG.g:294:3: ( rule__ParamValue__Alternatives )
            // InternalTGG.g:294:4: rule__ParamValue__Alternatives
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
    // InternalTGG.g:303:1: entryRuleLocalVariable : ruleLocalVariable EOF ;
    public final void entryRuleLocalVariable() throws RecognitionException {
        try {
            // InternalTGG.g:304:1: ( ruleLocalVariable EOF )
            // InternalTGG.g:305:1: ruleLocalVariable EOF
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
    // InternalTGG.g:312:1: ruleLocalVariable : ( ( rule__LocalVariable__NameAssignment ) ) ;
    public final void ruleLocalVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:316:2: ( ( ( rule__LocalVariable__NameAssignment ) ) )
            // InternalTGG.g:317:2: ( ( rule__LocalVariable__NameAssignment ) )
            {
            // InternalTGG.g:317:2: ( ( rule__LocalVariable__NameAssignment ) )
            // InternalTGG.g:318:3: ( rule__LocalVariable__NameAssignment )
            {
             before(grammarAccess.getLocalVariableAccess().getNameAssignment()); 
            // InternalTGG.g:319:3: ( rule__LocalVariable__NameAssignment )
            // InternalTGG.g:319:4: rule__LocalVariable__NameAssignment
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
    // InternalTGG.g:328:1: entryRuleCorrVariablePattern : ruleCorrVariablePattern EOF ;
    public final void entryRuleCorrVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:329:1: ( ruleCorrVariablePattern EOF )
            // InternalTGG.g:330:1: ruleCorrVariablePattern EOF
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
    // InternalTGG.g:337:1: ruleCorrVariablePattern : ( ( rule__CorrVariablePattern__Group__0 ) ) ;
    public final void ruleCorrVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:341:2: ( ( ( rule__CorrVariablePattern__Group__0 ) ) )
            // InternalTGG.g:342:2: ( ( rule__CorrVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:342:2: ( ( rule__CorrVariablePattern__Group__0 ) )
            // InternalTGG.g:343:3: ( rule__CorrVariablePattern__Group__0 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getGroup()); 
            // InternalTGG.g:344:3: ( rule__CorrVariablePattern__Group__0 )
            // InternalTGG.g:344:4: rule__CorrVariablePattern__Group__0
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
    // InternalTGG.g:353:1: entryRuleObjectVariablePattern : ruleObjectVariablePattern EOF ;
    public final void entryRuleObjectVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:354:1: ( ruleObjectVariablePattern EOF )
            // InternalTGG.g:355:1: ruleObjectVariablePattern EOF
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
    // InternalTGG.g:362:1: ruleObjectVariablePattern : ( ( rule__ObjectVariablePattern__Group__0 ) ) ;
    public final void ruleObjectVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:366:2: ( ( ( rule__ObjectVariablePattern__Group__0 ) ) )
            // InternalTGG.g:367:2: ( ( rule__ObjectVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:367:2: ( ( rule__ObjectVariablePattern__Group__0 ) )
            // InternalTGG.g:368:3: ( rule__ObjectVariablePattern__Group__0 )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getGroup()); 
            // InternalTGG.g:369:3: ( rule__ObjectVariablePattern__Group__0 )
            // InternalTGG.g:369:4: rule__ObjectVariablePattern__Group__0
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
    // InternalTGG.g:378:1: entryRuleContextObjectVariablePattern : ruleContextObjectVariablePattern EOF ;
    public final void entryRuleContextObjectVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:379:1: ( ruleContextObjectVariablePattern EOF )
            // InternalTGG.g:380:1: ruleContextObjectVariablePattern EOF
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
    // InternalTGG.g:387:1: ruleContextObjectVariablePattern : ( ( rule__ContextObjectVariablePattern__Group__0 ) ) ;
    public final void ruleContextObjectVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:391:2: ( ( ( rule__ContextObjectVariablePattern__Group__0 ) ) )
            // InternalTGG.g:392:2: ( ( rule__ContextObjectVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:392:2: ( ( rule__ContextObjectVariablePattern__Group__0 ) )
            // InternalTGG.g:393:3: ( rule__ContextObjectVariablePattern__Group__0 )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getGroup()); 
            // InternalTGG.g:394:3: ( rule__ContextObjectVariablePattern__Group__0 )
            // InternalTGG.g:394:4: rule__ContextObjectVariablePattern__Group__0
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
    // InternalTGG.g:403:1: entryRuleAttributeConstraint : ruleAttributeConstraint EOF ;
    public final void entryRuleAttributeConstraint() throws RecognitionException {
        try {
            // InternalTGG.g:404:1: ( ruleAttributeConstraint EOF )
            // InternalTGG.g:405:1: ruleAttributeConstraint EOF
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
    // InternalTGG.g:412:1: ruleAttributeConstraint : ( ( rule__AttributeConstraint__Group__0 ) ) ;
    public final void ruleAttributeConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:416:2: ( ( ( rule__AttributeConstraint__Group__0 ) ) )
            // InternalTGG.g:417:2: ( ( rule__AttributeConstraint__Group__0 ) )
            {
            // InternalTGG.g:417:2: ( ( rule__AttributeConstraint__Group__0 ) )
            // InternalTGG.g:418:3: ( rule__AttributeConstraint__Group__0 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getGroup()); 
            // InternalTGG.g:419:3: ( rule__AttributeConstraint__Group__0 )
            // InternalTGG.g:419:4: rule__AttributeConstraint__Group__0
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
    // InternalTGG.g:428:1: entryRuleAttributeAssignment : ruleAttributeAssignment EOF ;
    public final void entryRuleAttributeAssignment() throws RecognitionException {
        try {
            // InternalTGG.g:429:1: ( ruleAttributeAssignment EOF )
            // InternalTGG.g:430:1: ruleAttributeAssignment EOF
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
    // InternalTGG.g:437:1: ruleAttributeAssignment : ( ( rule__AttributeAssignment__Group__0 ) ) ;
    public final void ruleAttributeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:441:2: ( ( ( rule__AttributeAssignment__Group__0 ) ) )
            // InternalTGG.g:442:2: ( ( rule__AttributeAssignment__Group__0 ) )
            {
            // InternalTGG.g:442:2: ( ( rule__AttributeAssignment__Group__0 ) )
            // InternalTGG.g:443:3: ( rule__AttributeAssignment__Group__0 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getGroup()); 
            // InternalTGG.g:444:3: ( rule__AttributeAssignment__Group__0 )
            // InternalTGG.g:444:4: rule__AttributeAssignment__Group__0
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
    // InternalTGG.g:453:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalTGG.g:454:1: ( ruleExpression EOF )
            // InternalTGG.g:455:1: ruleExpression EOF
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
    // InternalTGG.g:462:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:466:2: ( ( ( rule__Expression__Alternatives ) ) )
            // InternalTGG.g:467:2: ( ( rule__Expression__Alternatives ) )
            {
            // InternalTGG.g:467:2: ( ( rule__Expression__Alternatives ) )
            // InternalTGG.g:468:3: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // InternalTGG.g:469:3: ( rule__Expression__Alternatives )
            // InternalTGG.g:469:4: rule__Expression__Alternatives
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
    // InternalTGG.g:478:1: entryRuleEnumExpression : ruleEnumExpression EOF ;
    public final void entryRuleEnumExpression() throws RecognitionException {
        try {
            // InternalTGG.g:479:1: ( ruleEnumExpression EOF )
            // InternalTGG.g:480:1: ruleEnumExpression EOF
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
    // InternalTGG.g:487:1: ruleEnumExpression : ( ( rule__EnumExpression__Group__0 ) ) ;
    public final void ruleEnumExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:491:2: ( ( ( rule__EnumExpression__Group__0 ) ) )
            // InternalTGG.g:492:2: ( ( rule__EnumExpression__Group__0 ) )
            {
            // InternalTGG.g:492:2: ( ( rule__EnumExpression__Group__0 ) )
            // InternalTGG.g:493:3: ( rule__EnumExpression__Group__0 )
            {
             before(grammarAccess.getEnumExpressionAccess().getGroup()); 
            // InternalTGG.g:494:3: ( rule__EnumExpression__Group__0 )
            // InternalTGG.g:494:4: rule__EnumExpression__Group__0
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
    // InternalTGG.g:503:1: entryRuleAttributeExpression : ruleAttributeExpression EOF ;
    public final void entryRuleAttributeExpression() throws RecognitionException {
        try {
            // InternalTGG.g:504:1: ( ruleAttributeExpression EOF )
            // InternalTGG.g:505:1: ruleAttributeExpression EOF
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
    // InternalTGG.g:512:1: ruleAttributeExpression : ( ( rule__AttributeExpression__Group__0 ) ) ;
    public final void ruleAttributeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:516:2: ( ( ( rule__AttributeExpression__Group__0 ) ) )
            // InternalTGG.g:517:2: ( ( rule__AttributeExpression__Group__0 ) )
            {
            // InternalTGG.g:517:2: ( ( rule__AttributeExpression__Group__0 ) )
            // InternalTGG.g:518:3: ( rule__AttributeExpression__Group__0 )
            {
             before(grammarAccess.getAttributeExpressionAccess().getGroup()); 
            // InternalTGG.g:519:3: ( rule__AttributeExpression__Group__0 )
            // InternalTGG.g:519:4: rule__AttributeExpression__Group__0
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
    // InternalTGG.g:528:1: entryRuleLiteralExpression : ruleLiteralExpression EOF ;
    public final void entryRuleLiteralExpression() throws RecognitionException {
        try {
            // InternalTGG.g:529:1: ( ruleLiteralExpression EOF )
            // InternalTGG.g:530:1: ruleLiteralExpression EOF
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
    // InternalTGG.g:537:1: ruleLiteralExpression : ( ( rule__LiteralExpression__ValueAssignment ) ) ;
    public final void ruleLiteralExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:541:2: ( ( ( rule__LiteralExpression__ValueAssignment ) ) )
            // InternalTGG.g:542:2: ( ( rule__LiteralExpression__ValueAssignment ) )
            {
            // InternalTGG.g:542:2: ( ( rule__LiteralExpression__ValueAssignment ) )
            // InternalTGG.g:543:3: ( rule__LiteralExpression__ValueAssignment )
            {
             before(grammarAccess.getLiteralExpressionAccess().getValueAssignment()); 
            // InternalTGG.g:544:3: ( rule__LiteralExpression__ValueAssignment )
            // InternalTGG.g:544:4: rule__LiteralExpression__ValueAssignment
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
    // InternalTGG.g:553:1: entryRuleLinkVariablePattern : ruleLinkVariablePattern EOF ;
    public final void entryRuleLinkVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:554:1: ( ruleLinkVariablePattern EOF )
            // InternalTGG.g:555:1: ruleLinkVariablePattern EOF
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
    // InternalTGG.g:562:1: ruleLinkVariablePattern : ( ( rule__LinkVariablePattern__Group__0 ) ) ;
    public final void ruleLinkVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:566:2: ( ( ( rule__LinkVariablePattern__Group__0 ) ) )
            // InternalTGG.g:567:2: ( ( rule__LinkVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:567:2: ( ( rule__LinkVariablePattern__Group__0 ) )
            // InternalTGG.g:568:3: ( rule__LinkVariablePattern__Group__0 )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getGroup()); 
            // InternalTGG.g:569:3: ( rule__LinkVariablePattern__Group__0 )
            // InternalTGG.g:569:4: rule__LinkVariablePattern__Group__0
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
    // InternalTGG.g:578:1: entryRuleContextLinkVariablePattern : ruleContextLinkVariablePattern EOF ;
    public final void entryRuleContextLinkVariablePattern() throws RecognitionException {
        try {
            // InternalTGG.g:579:1: ( ruleContextLinkVariablePattern EOF )
            // InternalTGG.g:580:1: ruleContextLinkVariablePattern EOF
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
    // InternalTGG.g:587:1: ruleContextLinkVariablePattern : ( ( rule__ContextLinkVariablePattern__Group__0 ) ) ;
    public final void ruleContextLinkVariablePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:591:2: ( ( ( rule__ContextLinkVariablePattern__Group__0 ) ) )
            // InternalTGG.g:592:2: ( ( rule__ContextLinkVariablePattern__Group__0 ) )
            {
            // InternalTGG.g:592:2: ( ( rule__ContextLinkVariablePattern__Group__0 ) )
            // InternalTGG.g:593:3: ( rule__ContextLinkVariablePattern__Group__0 )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getGroup()); 
            // InternalTGG.g:594:3: ( rule__ContextLinkVariablePattern__Group__0 )
            // InternalTGG.g:594:4: rule__ContextLinkVariablePattern__Group__0
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
    // InternalTGG.g:603:1: entryRuleOperator : ruleOperator EOF ;
    public final void entryRuleOperator() throws RecognitionException {
        try {
            // InternalTGG.g:604:1: ( ruleOperator EOF )
            // InternalTGG.g:605:1: ruleOperator EOF
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
    // InternalTGG.g:612:1: ruleOperator : ( ( rule__Operator__ValueAssignment ) ) ;
    public final void ruleOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:616:2: ( ( ( rule__Operator__ValueAssignment ) ) )
            // InternalTGG.g:617:2: ( ( rule__Operator__ValueAssignment ) )
            {
            // InternalTGG.g:617:2: ( ( rule__Operator__ValueAssignment ) )
            // InternalTGG.g:618:3: ( rule__Operator__ValueAssignment )
            {
             before(grammarAccess.getOperatorAccess().getValueAssignment()); 
            // InternalTGG.g:619:3: ( rule__Operator__ValueAssignment )
            // InternalTGG.g:619:4: rule__Operator__ValueAssignment
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
    // InternalTGG.g:628:1: entryRuleNac : ruleNac EOF ;
    public final void entryRuleNac() throws RecognitionException {
        try {
            // InternalTGG.g:629:1: ( ruleNac EOF )
            // InternalTGG.g:630:1: ruleNac EOF
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
    // InternalTGG.g:637:1: ruleNac : ( ( rule__Nac__Group__0 ) ) ;
    public final void ruleNac() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:641:2: ( ( ( rule__Nac__Group__0 ) ) )
            // InternalTGG.g:642:2: ( ( rule__Nac__Group__0 ) )
            {
            // InternalTGG.g:642:2: ( ( rule__Nac__Group__0 ) )
            // InternalTGG.g:643:3: ( rule__Nac__Group__0 )
            {
             before(grammarAccess.getNacAccess().getGroup()); 
            // InternalTGG.g:644:3: ( rule__Nac__Group__0 )
            // InternalTGG.g:644:4: rule__Nac__Group__0
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
    // InternalTGG.g:653:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalTGG.g:654:1: ( ruleImport EOF )
            // InternalTGG.g:655:1: ruleImport EOF
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
    // InternalTGG.g:662:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:666:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalTGG.g:667:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalTGG.g:667:2: ( ( rule__Import__Group__0 ) )
            // InternalTGG.g:668:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalTGG.g:669:3: ( rule__Import__Group__0 )
            // InternalTGG.g:669:4: rule__Import__Group__0
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
    // InternalTGG.g:678:1: entryRuleUsing : ruleUsing EOF ;
    public final void entryRuleUsing() throws RecognitionException {
        try {
            // InternalTGG.g:679:1: ( ruleUsing EOF )
            // InternalTGG.g:680:1: ruleUsing EOF
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
    // InternalTGG.g:687:1: ruleUsing : ( ( rule__Using__Group__0 ) ) ;
    public final void ruleUsing() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:691:2: ( ( ( rule__Using__Group__0 ) ) )
            // InternalTGG.g:692:2: ( ( rule__Using__Group__0 ) )
            {
            // InternalTGG.g:692:2: ( ( rule__Using__Group__0 ) )
            // InternalTGG.g:693:3: ( rule__Using__Group__0 )
            {
             before(grammarAccess.getUsingAccess().getGroup()); 
            // InternalTGG.g:694:3: ( rule__Using__Group__0 )
            // InternalTGG.g:694:4: rule__Using__Group__0
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
    // InternalTGG.g:703:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {
        try {
            // InternalTGG.g:704:1: ( ruleLiteralValue EOF )
            // InternalTGG.g:705:1: ruleLiteralValue EOF
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
    // InternalTGG.g:712:1: ruleLiteralValue : ( ( rule__LiteralValue__Alternatives ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:716:2: ( ( ( rule__LiteralValue__Alternatives ) ) )
            // InternalTGG.g:717:2: ( ( rule__LiteralValue__Alternatives ) )
            {
            // InternalTGG.g:717:2: ( ( rule__LiteralValue__Alternatives ) )
            // InternalTGG.g:718:3: ( rule__LiteralValue__Alternatives )
            {
             before(grammarAccess.getLiteralValueAccess().getAlternatives()); 
            // InternalTGG.g:719:3: ( rule__LiteralValue__Alternatives )
            // InternalTGG.g:719:4: rule__LiteralValue__Alternatives
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
    // InternalTGG.g:728:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // InternalTGG.g:729:1: ( ruleQualifiedNameWithWildcard EOF )
            // InternalTGG.g:730:1: ruleQualifiedNameWithWildcard EOF
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
    // InternalTGG.g:737:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:741:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // InternalTGG.g:742:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // InternalTGG.g:742:2: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // InternalTGG.g:743:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // InternalTGG.g:744:3: ( rule__QualifiedNameWithWildcard__Group__0 )
            // InternalTGG.g:744:4: rule__QualifiedNameWithWildcard__Group__0
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
    // InternalTGG.g:753:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalTGG.g:754:1: ( ruleQualifiedName EOF )
            // InternalTGG.g:755:1: ruleQualifiedName EOF
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
    // InternalTGG.g:762:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:766:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalTGG.g:767:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalTGG.g:767:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalTGG.g:768:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalTGG.g:769:3: ( rule__QualifiedName__Group__0 )
            // InternalTGG.g:769:4: rule__QualifiedName__Group__0
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
    // InternalTGG.g:778:1: entryRuleNamePattern : ruleNamePattern EOF ;
    public final void entryRuleNamePattern() throws RecognitionException {
        try {
            // InternalTGG.g:779:1: ( ruleNamePattern EOF )
            // InternalTGG.g:780:1: ruleNamePattern EOF
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
    // InternalTGG.g:787:1: ruleNamePattern : ( ( rule__NamePattern__Alternatives ) ) ;
    public final void ruleNamePattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:791:2: ( ( ( rule__NamePattern__Alternatives ) ) )
            // InternalTGG.g:792:2: ( ( rule__NamePattern__Alternatives ) )
            {
            // InternalTGG.g:792:2: ( ( rule__NamePattern__Alternatives ) )
            // InternalTGG.g:793:3: ( rule__NamePattern__Alternatives )
            {
             before(grammarAccess.getNamePatternAccess().getAlternatives()); 
            // InternalTGG.g:794:3: ( rule__NamePattern__Alternatives )
            // InternalTGG.g:794:4: rule__NamePattern__Alternatives
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
    // InternalTGG.g:802:1: rule__CorrType__Alternatives_1 : ( ( ( rule__CorrType__Group_1_0__0 ) ) | ( ( rule__CorrType__Group_1_1__0 ) ) );
    public final void rule__CorrType__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:806:1: ( ( ( rule__CorrType__Group_1_0__0 ) ) | ( ( rule__CorrType__Group_1_1__0 ) ) )
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
                    // InternalTGG.g:807:2: ( ( rule__CorrType__Group_1_0__0 ) )
                    {
                    // InternalTGG.g:807:2: ( ( rule__CorrType__Group_1_0__0 ) )
                    // InternalTGG.g:808:3: ( rule__CorrType__Group_1_0__0 )
                    {
                     before(grammarAccess.getCorrTypeAccess().getGroup_1_0()); 
                    // InternalTGG.g:809:3: ( rule__CorrType__Group_1_0__0 )
                    // InternalTGG.g:809:4: rule__CorrType__Group_1_0__0
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
                    // InternalTGG.g:813:2: ( ( rule__CorrType__Group_1_1__0 ) )
                    {
                    // InternalTGG.g:813:2: ( ( rule__CorrType__Group_1_1__0 ) )
                    // InternalTGG.g:814:3: ( rule__CorrType__Group_1_1__0 )
                    {
                     before(grammarAccess.getCorrTypeAccess().getGroup_1_1()); 
                    // InternalTGG.g:815:3: ( rule__CorrType__Group_1_1__0 )
                    // InternalTGG.g:815:4: rule__CorrType__Group_1_1__0
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
    // InternalTGG.g:823:1: rule__Adornment__ValueAlternatives_1_0 : ( ( 'B' ) | ( 'F' ) );
    public final void rule__Adornment__ValueAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:827:1: ( ( 'B' ) | ( 'F' ) )
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
                    // InternalTGG.g:828:2: ( 'B' )
                    {
                    // InternalTGG.g:828:2: ( 'B' )
                    // InternalTGG.g:829:3: 'B'
                    {
                     before(grammarAccess.getAdornmentAccess().getValueBKeyword_1_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getAdornmentAccess().getValueBKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:834:2: ( 'F' )
                    {
                    // InternalTGG.g:834:2: ( 'F' )
                    // InternalTGG.g:835:3: 'F'
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
    // InternalTGG.g:844:1: rule__ParamValue__Alternatives : ( ( ruleLocalVariable ) | ( ruleExpression ) );
    public final void rule__ParamValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:848:1: ( ( ruleLocalVariable ) | ( ruleExpression ) )
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
                    // InternalTGG.g:849:2: ( ruleLocalVariable )
                    {
                    // InternalTGG.g:849:2: ( ruleLocalVariable )
                    // InternalTGG.g:850:3: ruleLocalVariable
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
                    // InternalTGG.g:855:2: ( ruleExpression )
                    {
                    // InternalTGG.g:855:2: ( ruleExpression )
                    // InternalTGG.g:856:3: ruleExpression
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
    // InternalTGG.g:865:1: rule__AttributeConstraint__OpAlternatives_1_0 : ( ( '==' ) | ( '!=' ) | ( '<=' ) | ( '>=' ) | ( '>' ) | ( '<' ) );
    public final void rule__AttributeConstraint__OpAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:869:1: ( ( '==' ) | ( '!=' ) | ( '<=' ) | ( '>=' ) | ( '>' ) | ( '<' ) )
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
                    // InternalTGG.g:870:2: ( '==' )
                    {
                    // InternalTGG.g:870:2: ( '==' )
                    // InternalTGG.g:871:3: '=='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpEqualsSignEqualsSignKeyword_1_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpEqualsSignEqualsSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:876:2: ( '!=' )
                    {
                    // InternalTGG.g:876:2: ( '!=' )
                    // InternalTGG.g:877:3: '!='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalTGG.g:882:2: ( '<=' )
                    {
                    // InternalTGG.g:882:2: ( '<=' )
                    // InternalTGG.g:883:3: '<='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpLessThanSignEqualsSignKeyword_1_0_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpLessThanSignEqualsSignKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalTGG.g:888:2: ( '>=' )
                    {
                    // InternalTGG.g:888:2: ( '>=' )
                    // InternalTGG.g:889:3: '>='
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_3()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalTGG.g:894:2: ( '>' )
                    {
                    // InternalTGG.g:894:2: ( '>' )
                    // InternalTGG.g:895:3: '>'
                    {
                     before(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignKeyword_1_0_4()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getAttributeConstraintAccess().getOpGreaterThanSignKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalTGG.g:900:2: ( '<' )
                    {
                    // InternalTGG.g:900:2: ( '<' )
                    // InternalTGG.g:901:3: '<'
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
    // InternalTGG.g:910:1: rule__Expression__Alternatives : ( ( ruleEnumExpression ) | ( ruleAttributeExpression ) | ( ruleLiteralExpression ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:914:1: ( ( ruleEnumExpression ) | ( ruleAttributeExpression ) | ( ruleLiteralExpression ) )
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
                    // InternalTGG.g:915:2: ( ruleEnumExpression )
                    {
                    // InternalTGG.g:915:2: ( ruleEnumExpression )
                    // InternalTGG.g:916:3: ruleEnumExpression
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
                    // InternalTGG.g:921:2: ( ruleAttributeExpression )
                    {
                    // InternalTGG.g:921:2: ( ruleAttributeExpression )
                    // InternalTGG.g:922:3: ruleAttributeExpression
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
                    // InternalTGG.g:927:2: ( ruleLiteralExpression )
                    {
                    // InternalTGG.g:927:2: ( ruleLiteralExpression )
                    // InternalTGG.g:928:3: ruleLiteralExpression
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
    // InternalTGG.g:937:1: rule__Nac__Alternatives_4 : ( ( ( rule__Nac__Group_4_0__0 ) ) | ( ( rule__Nac__Group_4_1__0 ) ) );
    public final void rule__Nac__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:941:1: ( ( ( rule__Nac__Group_4_0__0 ) ) | ( ( rule__Nac__Group_4_1__0 ) ) )
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
                    // InternalTGG.g:942:2: ( ( rule__Nac__Group_4_0__0 ) )
                    {
                    // InternalTGG.g:942:2: ( ( rule__Nac__Group_4_0__0 ) )
                    // InternalTGG.g:943:3: ( rule__Nac__Group_4_0__0 )
                    {
                     before(grammarAccess.getNacAccess().getGroup_4_0()); 
                    // InternalTGG.g:944:3: ( rule__Nac__Group_4_0__0 )
                    // InternalTGG.g:944:4: rule__Nac__Group_4_0__0
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
                    // InternalTGG.g:948:2: ( ( rule__Nac__Group_4_1__0 ) )
                    {
                    // InternalTGG.g:948:2: ( ( rule__Nac__Group_4_1__0 ) )
                    // InternalTGG.g:949:3: ( rule__Nac__Group_4_1__0 )
                    {
                     before(grammarAccess.getNacAccess().getGroup_4_1()); 
                    // InternalTGG.g:950:3: ( rule__Nac__Group_4_1__0 )
                    // InternalTGG.g:950:4: rule__Nac__Group_4_1__0
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
    // InternalTGG.g:958:1: rule__LiteralValue__Alternatives : ( ( RULE_STRING ) | ( ( rule__LiteralValue__Group_1__0 ) ) | ( ( rule__LiteralValue__Group_2__0 ) ) | ( RULE_BOOL ) );
    public final void rule__LiteralValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:962:1: ( ( RULE_STRING ) | ( ( rule__LiteralValue__Group_1__0 ) ) | ( ( rule__LiteralValue__Group_2__0 ) ) | ( RULE_BOOL ) )
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
                    // InternalTGG.g:963:2: ( RULE_STRING )
                    {
                    // InternalTGG.g:963:2: ( RULE_STRING )
                    // InternalTGG.g:964:3: RULE_STRING
                    {
                     before(grammarAccess.getLiteralValueAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getLiteralValueAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalTGG.g:969:2: ( ( rule__LiteralValue__Group_1__0 ) )
                    {
                    // InternalTGG.g:969:2: ( ( rule__LiteralValue__Group_1__0 ) )
                    // InternalTGG.g:970:3: ( rule__LiteralValue__Group_1__0 )
                    {
                     before(grammarAccess.getLiteralValueAccess().getGroup_1()); 
                    // InternalTGG.g:971:3: ( rule__LiteralValue__Group_1__0 )
                    // InternalTGG.g:971:4: rule__LiteralValue__Group_1__0
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
                    // InternalTGG.g:975:2: ( ( rule__LiteralValue__Group_2__0 ) )
                    {
                    // InternalTGG.g:975:2: ( ( rule__LiteralValue__Group_2__0 ) )
                    // InternalTGG.g:976:3: ( rule__LiteralValue__Group_2__0 )
                    {
                     before(grammarAccess.getLiteralValueAccess().getGroup_2()); 
                    // InternalTGG.g:977:3: ( rule__LiteralValue__Group_2__0 )
                    // InternalTGG.g:977:4: rule__LiteralValue__Group_2__0
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
                    // InternalTGG.g:981:2: ( RULE_BOOL )
                    {
                    // InternalTGG.g:981:2: ( RULE_BOOL )
                    // InternalTGG.g:982:3: RULE_BOOL
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
    // InternalTGG.g:991:1: rule__NamePattern__Alternatives : ( ( ruleCorrVariablePattern ) | ( ruleObjectVariablePattern ) );
    public final void rule__NamePattern__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:995:1: ( ( ruleCorrVariablePattern ) | ( ruleObjectVariablePattern ) )
            int alt8=2;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalTGG.g:996:2: ( ruleCorrVariablePattern )
                    {
                    // InternalTGG.g:996:2: ( ruleCorrVariablePattern )
                    // InternalTGG.g:997:3: ruleCorrVariablePattern
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
                    // InternalTGG.g:1002:2: ( ruleObjectVariablePattern )
                    {
                    // InternalTGG.g:1002:2: ( ruleObjectVariablePattern )
                    // InternalTGG.g:1003:3: ruleObjectVariablePattern
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
    // InternalTGG.g:1012:1: rule__TripleGraphGrammarFile__Group__0 : rule__TripleGraphGrammarFile__Group__0__Impl rule__TripleGraphGrammarFile__Group__1 ;
    public final void rule__TripleGraphGrammarFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1016:1: ( rule__TripleGraphGrammarFile__Group__0__Impl rule__TripleGraphGrammarFile__Group__1 )
            // InternalTGG.g:1017:2: rule__TripleGraphGrammarFile__Group__0__Impl rule__TripleGraphGrammarFile__Group__1
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
    // InternalTGG.g:1024:1: rule__TripleGraphGrammarFile__Group__0__Impl : ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* ) ;
    public final void rule__TripleGraphGrammarFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1028:1: ( ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* ) )
            // InternalTGG.g:1029:1: ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* )
            {
            // InternalTGG.g:1029:1: ( ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )* )
            // InternalTGG.g:1030:2: ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )*
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getImportsAssignment_0()); 
            // InternalTGG.g:1031:2: ( rule__TripleGraphGrammarFile__ImportsAssignment_0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==49) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalTGG.g:1031:3: rule__TripleGraphGrammarFile__ImportsAssignment_0
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
    // InternalTGG.g:1039:1: rule__TripleGraphGrammarFile__Group__1 : rule__TripleGraphGrammarFile__Group__1__Impl rule__TripleGraphGrammarFile__Group__2 ;
    public final void rule__TripleGraphGrammarFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1043:1: ( rule__TripleGraphGrammarFile__Group__1__Impl rule__TripleGraphGrammarFile__Group__2 )
            // InternalTGG.g:1044:2: rule__TripleGraphGrammarFile__Group__1__Impl rule__TripleGraphGrammarFile__Group__2
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
    // InternalTGG.g:1051:1: rule__TripleGraphGrammarFile__Group__1__Impl : ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* ) ;
    public final void rule__TripleGraphGrammarFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1055:1: ( ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* ) )
            // InternalTGG.g:1056:1: ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* )
            {
            // InternalTGG.g:1056:1: ( ( rule__TripleGraphGrammarFile__UsingAssignment_1 )* )
            // InternalTGG.g:1057:2: ( rule__TripleGraphGrammarFile__UsingAssignment_1 )*
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getUsingAssignment_1()); 
            // InternalTGG.g:1058:2: ( rule__TripleGraphGrammarFile__UsingAssignment_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==50) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalTGG.g:1058:3: rule__TripleGraphGrammarFile__UsingAssignment_1
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
    // InternalTGG.g:1066:1: rule__TripleGraphGrammarFile__Group__2 : rule__TripleGraphGrammarFile__Group__2__Impl rule__TripleGraphGrammarFile__Group__3 ;
    public final void rule__TripleGraphGrammarFile__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1070:1: ( rule__TripleGraphGrammarFile__Group__2__Impl rule__TripleGraphGrammarFile__Group__3 )
            // InternalTGG.g:1071:2: rule__TripleGraphGrammarFile__Group__2__Impl rule__TripleGraphGrammarFile__Group__3
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
    // InternalTGG.g:1078:1: rule__TripleGraphGrammarFile__Group__2__Impl : ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? ) ;
    public final void rule__TripleGraphGrammarFile__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1082:1: ( ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? ) )
            // InternalTGG.g:1083:1: ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? )
            {
            // InternalTGG.g:1083:1: ( ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )? )
            // InternalTGG.g:1084:2: ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )?
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getSchemaAssignment_2()); 
            // InternalTGG.g:1085:2: ( rule__TripleGraphGrammarFile__SchemaAssignment_2 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==21) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalTGG.g:1085:3: rule__TripleGraphGrammarFile__SchemaAssignment_2
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
    // InternalTGG.g:1093:1: rule__TripleGraphGrammarFile__Group__3 : rule__TripleGraphGrammarFile__Group__3__Impl rule__TripleGraphGrammarFile__Group__4 ;
    public final void rule__TripleGraphGrammarFile__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1097:1: ( rule__TripleGraphGrammarFile__Group__3__Impl rule__TripleGraphGrammarFile__Group__4 )
            // InternalTGG.g:1098:2: rule__TripleGraphGrammarFile__Group__3__Impl rule__TripleGraphGrammarFile__Group__4
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
    // InternalTGG.g:1105:1: rule__TripleGraphGrammarFile__Group__3__Impl : ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* ) ;
    public final void rule__TripleGraphGrammarFile__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1109:1: ( ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* ) )
            // InternalTGG.g:1110:1: ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* )
            {
            // InternalTGG.g:1110:1: ( ( rule__TripleGraphGrammarFile__RulesAssignment_3 )* )
            // InternalTGG.g:1111:2: ( rule__TripleGraphGrammarFile__RulesAssignment_3 )*
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getRulesAssignment_3()); 
            // InternalTGG.g:1112:2: ( rule__TripleGraphGrammarFile__RulesAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==37||LA12_0==53) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalTGG.g:1112:3: rule__TripleGraphGrammarFile__RulesAssignment_3
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
    // InternalTGG.g:1120:1: rule__TripleGraphGrammarFile__Group__4 : rule__TripleGraphGrammarFile__Group__4__Impl ;
    public final void rule__TripleGraphGrammarFile__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1124:1: ( rule__TripleGraphGrammarFile__Group__4__Impl )
            // InternalTGG.g:1125:2: rule__TripleGraphGrammarFile__Group__4__Impl
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
    // InternalTGG.g:1131:1: rule__TripleGraphGrammarFile__Group__4__Impl : ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? ) ;
    public final void rule__TripleGraphGrammarFile__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1135:1: ( ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? ) )
            // InternalTGG.g:1136:1: ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? )
            {
            // InternalTGG.g:1136:1: ( ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )? )
            // InternalTGG.g:1137:2: ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )?
            {
             before(grammarAccess.getTripleGraphGrammarFileAccess().getLibraryAssignment_4()); 
            // InternalTGG.g:1138:2: ( rule__TripleGraphGrammarFile__LibraryAssignment_4 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==39) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTGG.g:1138:3: rule__TripleGraphGrammarFile__LibraryAssignment_4
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
    // InternalTGG.g:1147:1: rule__Schema__Group__0 : rule__Schema__Group__0__Impl rule__Schema__Group__1 ;
    public final void rule__Schema__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1151:1: ( rule__Schema__Group__0__Impl rule__Schema__Group__1 )
            // InternalTGG.g:1152:2: rule__Schema__Group__0__Impl rule__Schema__Group__1
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
    // InternalTGG.g:1159:1: rule__Schema__Group__0__Impl : ( '#schema' ) ;
    public final void rule__Schema__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1163:1: ( ( '#schema' ) )
            // InternalTGG.g:1164:1: ( '#schema' )
            {
            // InternalTGG.g:1164:1: ( '#schema' )
            // InternalTGG.g:1165:2: '#schema'
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
    // InternalTGG.g:1174:1: rule__Schema__Group__1 : rule__Schema__Group__1__Impl rule__Schema__Group__2 ;
    public final void rule__Schema__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1178:1: ( rule__Schema__Group__1__Impl rule__Schema__Group__2 )
            // InternalTGG.g:1179:2: rule__Schema__Group__1__Impl rule__Schema__Group__2
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
    // InternalTGG.g:1186:1: rule__Schema__Group__1__Impl : ( ( rule__Schema__NameAssignment_1 ) ) ;
    public final void rule__Schema__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1190:1: ( ( ( rule__Schema__NameAssignment_1 ) ) )
            // InternalTGG.g:1191:1: ( ( rule__Schema__NameAssignment_1 ) )
            {
            // InternalTGG.g:1191:1: ( ( rule__Schema__NameAssignment_1 ) )
            // InternalTGG.g:1192:2: ( rule__Schema__NameAssignment_1 )
            {
             before(grammarAccess.getSchemaAccess().getNameAssignment_1()); 
            // InternalTGG.g:1193:2: ( rule__Schema__NameAssignment_1 )
            // InternalTGG.g:1193:3: rule__Schema__NameAssignment_1
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
    // InternalTGG.g:1201:1: rule__Schema__Group__2 : rule__Schema__Group__2__Impl rule__Schema__Group__3 ;
    public final void rule__Schema__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1205:1: ( rule__Schema__Group__2__Impl rule__Schema__Group__3 )
            // InternalTGG.g:1206:2: rule__Schema__Group__2__Impl rule__Schema__Group__3
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
    // InternalTGG.g:1213:1: rule__Schema__Group__2__Impl : ( ( rule__Schema__Group_2__0 )? ) ;
    public final void rule__Schema__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1217:1: ( ( ( rule__Schema__Group_2__0 )? ) )
            // InternalTGG.g:1218:1: ( ( rule__Schema__Group_2__0 )? )
            {
            // InternalTGG.g:1218:1: ( ( rule__Schema__Group_2__0 )? )
            // InternalTGG.g:1219:2: ( rule__Schema__Group_2__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_2()); 
            // InternalTGG.g:1220:2: ( rule__Schema__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalTGG.g:1220:3: rule__Schema__Group_2__0
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
    // InternalTGG.g:1228:1: rule__Schema__Group__3 : rule__Schema__Group__3__Impl rule__Schema__Group__4 ;
    public final void rule__Schema__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1232:1: ( rule__Schema__Group__3__Impl rule__Schema__Group__4 )
            // InternalTGG.g:1233:2: rule__Schema__Group__3__Impl rule__Schema__Group__4
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
    // InternalTGG.g:1240:1: rule__Schema__Group__3__Impl : ( ( rule__Schema__Group_3__0 )? ) ;
    public final void rule__Schema__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1244:1: ( ( ( rule__Schema__Group_3__0 )? ) )
            // InternalTGG.g:1245:1: ( ( rule__Schema__Group_3__0 )? )
            {
            // InternalTGG.g:1245:1: ( ( rule__Schema__Group_3__0 )? )
            // InternalTGG.g:1246:2: ( rule__Schema__Group_3__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_3()); 
            // InternalTGG.g:1247:2: ( rule__Schema__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalTGG.g:1247:3: rule__Schema__Group_3__0
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
    // InternalTGG.g:1255:1: rule__Schema__Group__4 : rule__Schema__Group__4__Impl rule__Schema__Group__5 ;
    public final void rule__Schema__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1259:1: ( rule__Schema__Group__4__Impl rule__Schema__Group__5 )
            // InternalTGG.g:1260:2: rule__Schema__Group__4__Impl rule__Schema__Group__5
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
    // InternalTGG.g:1267:1: rule__Schema__Group__4__Impl : ( ( rule__Schema__Group_4__0 )? ) ;
    public final void rule__Schema__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1271:1: ( ( ( rule__Schema__Group_4__0 )? ) )
            // InternalTGG.g:1272:1: ( ( rule__Schema__Group_4__0 )? )
            {
            // InternalTGG.g:1272:1: ( ( rule__Schema__Group_4__0 )? )
            // InternalTGG.g:1273:2: ( rule__Schema__Group_4__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_4()); 
            // InternalTGG.g:1274:2: ( rule__Schema__Group_4__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTGG.g:1274:3: rule__Schema__Group_4__0
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
    // InternalTGG.g:1282:1: rule__Schema__Group__5 : rule__Schema__Group__5__Impl ;
    public final void rule__Schema__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1286:1: ( rule__Schema__Group__5__Impl )
            // InternalTGG.g:1287:2: rule__Schema__Group__5__Impl
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
    // InternalTGG.g:1293:1: rule__Schema__Group__5__Impl : ( ( rule__Schema__Group_5__0 )? ) ;
    public final void rule__Schema__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1297:1: ( ( ( rule__Schema__Group_5__0 )? ) )
            // InternalTGG.g:1298:1: ( ( rule__Schema__Group_5__0 )? )
            {
            // InternalTGG.g:1298:1: ( ( rule__Schema__Group_5__0 )? )
            // InternalTGG.g:1299:2: ( rule__Schema__Group_5__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_5()); 
            // InternalTGG.g:1300:2: ( rule__Schema__Group_5__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTGG.g:1300:3: rule__Schema__Group_5__0
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
    // InternalTGG.g:1309:1: rule__Schema__Group_2__0 : rule__Schema__Group_2__0__Impl rule__Schema__Group_2__1 ;
    public final void rule__Schema__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1313:1: ( rule__Schema__Group_2__0__Impl rule__Schema__Group_2__1 )
            // InternalTGG.g:1314:2: rule__Schema__Group_2__0__Impl rule__Schema__Group_2__1
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
    // InternalTGG.g:1321:1: rule__Schema__Group_2__0__Impl : ( '#source' ) ;
    public final void rule__Schema__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1325:1: ( ( '#source' ) )
            // InternalTGG.g:1326:1: ( '#source' )
            {
            // InternalTGG.g:1326:1: ( '#source' )
            // InternalTGG.g:1327:2: '#source'
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
    // InternalTGG.g:1336:1: rule__Schema__Group_2__1 : rule__Schema__Group_2__1__Impl rule__Schema__Group_2__2 ;
    public final void rule__Schema__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1340:1: ( rule__Schema__Group_2__1__Impl rule__Schema__Group_2__2 )
            // InternalTGG.g:1341:2: rule__Schema__Group_2__1__Impl rule__Schema__Group_2__2
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
    // InternalTGG.g:1348:1: rule__Schema__Group_2__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1352:1: ( ( '{' ) )
            // InternalTGG.g:1353:1: ( '{' )
            {
            // InternalTGG.g:1353:1: ( '{' )
            // InternalTGG.g:1354:2: '{'
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
    // InternalTGG.g:1363:1: rule__Schema__Group_2__2 : rule__Schema__Group_2__2__Impl rule__Schema__Group_2__3 ;
    public final void rule__Schema__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1367:1: ( rule__Schema__Group_2__2__Impl rule__Schema__Group_2__3 )
            // InternalTGG.g:1368:2: rule__Schema__Group_2__2__Impl rule__Schema__Group_2__3
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
    // InternalTGG.g:1375:1: rule__Schema__Group_2__2__Impl : ( ( rule__Schema__SourceTypesAssignment_2_2 )* ) ;
    public final void rule__Schema__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1379:1: ( ( ( rule__Schema__SourceTypesAssignment_2_2 )* ) )
            // InternalTGG.g:1380:1: ( ( rule__Schema__SourceTypesAssignment_2_2 )* )
            {
            // InternalTGG.g:1380:1: ( ( rule__Schema__SourceTypesAssignment_2_2 )* )
            // InternalTGG.g:1381:2: ( rule__Schema__SourceTypesAssignment_2_2 )*
            {
             before(grammarAccess.getSchemaAccess().getSourceTypesAssignment_2_2()); 
            // InternalTGG.g:1382:2: ( rule__Schema__SourceTypesAssignment_2_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTGG.g:1382:3: rule__Schema__SourceTypesAssignment_2_2
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
    // InternalTGG.g:1390:1: rule__Schema__Group_2__3 : rule__Schema__Group_2__3__Impl ;
    public final void rule__Schema__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1394:1: ( rule__Schema__Group_2__3__Impl )
            // InternalTGG.g:1395:2: rule__Schema__Group_2__3__Impl
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
    // InternalTGG.g:1401:1: rule__Schema__Group_2__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1405:1: ( ( '}' ) )
            // InternalTGG.g:1406:1: ( '}' )
            {
            // InternalTGG.g:1406:1: ( '}' )
            // InternalTGG.g:1407:2: '}'
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
    // InternalTGG.g:1417:1: rule__Schema__Group_3__0 : rule__Schema__Group_3__0__Impl rule__Schema__Group_3__1 ;
    public final void rule__Schema__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1421:1: ( rule__Schema__Group_3__0__Impl rule__Schema__Group_3__1 )
            // InternalTGG.g:1422:2: rule__Schema__Group_3__0__Impl rule__Schema__Group_3__1
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
    // InternalTGG.g:1429:1: rule__Schema__Group_3__0__Impl : ( '#target' ) ;
    public final void rule__Schema__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1433:1: ( ( '#target' ) )
            // InternalTGG.g:1434:1: ( '#target' )
            {
            // InternalTGG.g:1434:1: ( '#target' )
            // InternalTGG.g:1435:2: '#target'
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
    // InternalTGG.g:1444:1: rule__Schema__Group_3__1 : rule__Schema__Group_3__1__Impl rule__Schema__Group_3__2 ;
    public final void rule__Schema__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1448:1: ( rule__Schema__Group_3__1__Impl rule__Schema__Group_3__2 )
            // InternalTGG.g:1449:2: rule__Schema__Group_3__1__Impl rule__Schema__Group_3__2
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
    // InternalTGG.g:1456:1: rule__Schema__Group_3__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1460:1: ( ( '{' ) )
            // InternalTGG.g:1461:1: ( '{' )
            {
            // InternalTGG.g:1461:1: ( '{' )
            // InternalTGG.g:1462:2: '{'
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
    // InternalTGG.g:1471:1: rule__Schema__Group_3__2 : rule__Schema__Group_3__2__Impl rule__Schema__Group_3__3 ;
    public final void rule__Schema__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1475:1: ( rule__Schema__Group_3__2__Impl rule__Schema__Group_3__3 )
            // InternalTGG.g:1476:2: rule__Schema__Group_3__2__Impl rule__Schema__Group_3__3
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
    // InternalTGG.g:1483:1: rule__Schema__Group_3__2__Impl : ( ( rule__Schema__TargetTypesAssignment_3_2 )* ) ;
    public final void rule__Schema__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1487:1: ( ( ( rule__Schema__TargetTypesAssignment_3_2 )* ) )
            // InternalTGG.g:1488:1: ( ( rule__Schema__TargetTypesAssignment_3_2 )* )
            {
            // InternalTGG.g:1488:1: ( ( rule__Schema__TargetTypesAssignment_3_2 )* )
            // InternalTGG.g:1489:2: ( rule__Schema__TargetTypesAssignment_3_2 )*
            {
             before(grammarAccess.getSchemaAccess().getTargetTypesAssignment_3_2()); 
            // InternalTGG.g:1490:2: ( rule__Schema__TargetTypesAssignment_3_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalTGG.g:1490:3: rule__Schema__TargetTypesAssignment_3_2
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
    // InternalTGG.g:1498:1: rule__Schema__Group_3__3 : rule__Schema__Group_3__3__Impl ;
    public final void rule__Schema__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1502:1: ( rule__Schema__Group_3__3__Impl )
            // InternalTGG.g:1503:2: rule__Schema__Group_3__3__Impl
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
    // InternalTGG.g:1509:1: rule__Schema__Group_3__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1513:1: ( ( '}' ) )
            // InternalTGG.g:1514:1: ( '}' )
            {
            // InternalTGG.g:1514:1: ( '}' )
            // InternalTGG.g:1515:2: '}'
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
    // InternalTGG.g:1525:1: rule__Schema__Group_4__0 : rule__Schema__Group_4__0__Impl rule__Schema__Group_4__1 ;
    public final void rule__Schema__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1529:1: ( rule__Schema__Group_4__0__Impl rule__Schema__Group_4__1 )
            // InternalTGG.g:1530:2: rule__Schema__Group_4__0__Impl rule__Schema__Group_4__1
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
    // InternalTGG.g:1537:1: rule__Schema__Group_4__0__Impl : ( '#correspondence' ) ;
    public final void rule__Schema__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1541:1: ( ( '#correspondence' ) )
            // InternalTGG.g:1542:1: ( '#correspondence' )
            {
            // InternalTGG.g:1542:1: ( '#correspondence' )
            // InternalTGG.g:1543:2: '#correspondence'
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
    // InternalTGG.g:1552:1: rule__Schema__Group_4__1 : rule__Schema__Group_4__1__Impl rule__Schema__Group_4__2 ;
    public final void rule__Schema__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1556:1: ( rule__Schema__Group_4__1__Impl rule__Schema__Group_4__2 )
            // InternalTGG.g:1557:2: rule__Schema__Group_4__1__Impl rule__Schema__Group_4__2
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
    // InternalTGG.g:1564:1: rule__Schema__Group_4__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1568:1: ( ( '{' ) )
            // InternalTGG.g:1569:1: ( '{' )
            {
            // InternalTGG.g:1569:1: ( '{' )
            // InternalTGG.g:1570:2: '{'
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
    // InternalTGG.g:1579:1: rule__Schema__Group_4__2 : rule__Schema__Group_4__2__Impl rule__Schema__Group_4__3 ;
    public final void rule__Schema__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1583:1: ( rule__Schema__Group_4__2__Impl rule__Schema__Group_4__3 )
            // InternalTGG.g:1584:2: rule__Schema__Group_4__2__Impl rule__Schema__Group_4__3
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
    // InternalTGG.g:1591:1: rule__Schema__Group_4__2__Impl : ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* ) ;
    public final void rule__Schema__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1595:1: ( ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* ) )
            // InternalTGG.g:1596:1: ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* )
            {
            // InternalTGG.g:1596:1: ( ( rule__Schema__CorrespondenceTypesAssignment_4_2 )* )
            // InternalTGG.g:1597:2: ( rule__Schema__CorrespondenceTypesAssignment_4_2 )*
            {
             before(grammarAccess.getSchemaAccess().getCorrespondenceTypesAssignment_4_2()); 
            // InternalTGG.g:1598:2: ( rule__Schema__CorrespondenceTypesAssignment_4_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalTGG.g:1598:3: rule__Schema__CorrespondenceTypesAssignment_4_2
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
    // InternalTGG.g:1606:1: rule__Schema__Group_4__3 : rule__Schema__Group_4__3__Impl ;
    public final void rule__Schema__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1610:1: ( rule__Schema__Group_4__3__Impl )
            // InternalTGG.g:1611:2: rule__Schema__Group_4__3__Impl
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
    // InternalTGG.g:1617:1: rule__Schema__Group_4__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1621:1: ( ( '}' ) )
            // InternalTGG.g:1622:1: ( '}' )
            {
            // InternalTGG.g:1622:1: ( '}' )
            // InternalTGG.g:1623:2: '}'
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
    // InternalTGG.g:1633:1: rule__Schema__Group_5__0 : rule__Schema__Group_5__0__Impl rule__Schema__Group_5__1 ;
    public final void rule__Schema__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1637:1: ( rule__Schema__Group_5__0__Impl rule__Schema__Group_5__1 )
            // InternalTGG.g:1638:2: rule__Schema__Group_5__0__Impl rule__Schema__Group_5__1
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
    // InternalTGG.g:1645:1: rule__Schema__Group_5__0__Impl : ( '#attributeConditions' ) ;
    public final void rule__Schema__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1649:1: ( ( '#attributeConditions' ) )
            // InternalTGG.g:1650:1: ( '#attributeConditions' )
            {
            // InternalTGG.g:1650:1: ( '#attributeConditions' )
            // InternalTGG.g:1651:2: '#attributeConditions'
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
    // InternalTGG.g:1660:1: rule__Schema__Group_5__1 : rule__Schema__Group_5__1__Impl rule__Schema__Group_5__2 ;
    public final void rule__Schema__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1664:1: ( rule__Schema__Group_5__1__Impl rule__Schema__Group_5__2 )
            // InternalTGG.g:1665:2: rule__Schema__Group_5__1__Impl rule__Schema__Group_5__2
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
    // InternalTGG.g:1672:1: rule__Schema__Group_5__1__Impl : ( '{' ) ;
    public final void rule__Schema__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1676:1: ( ( '{' ) )
            // InternalTGG.g:1677:1: ( '{' )
            {
            // InternalTGG.g:1677:1: ( '{' )
            // InternalTGG.g:1678:2: '{'
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
    // InternalTGG.g:1687:1: rule__Schema__Group_5__2 : rule__Schema__Group_5__2__Impl rule__Schema__Group_5__3 ;
    public final void rule__Schema__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1691:1: ( rule__Schema__Group_5__2__Impl rule__Schema__Group_5__3 )
            // InternalTGG.g:1692:2: rule__Schema__Group_5__2__Impl rule__Schema__Group_5__3
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
    // InternalTGG.g:1699:1: rule__Schema__Group_5__2__Impl : ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* ) ;
    public final void rule__Schema__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1703:1: ( ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* ) )
            // InternalTGG.g:1704:1: ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* )
            {
            // InternalTGG.g:1704:1: ( ( rule__Schema__AttributeCondDefsAssignment_5_2 )* )
            // InternalTGG.g:1705:2: ( rule__Schema__AttributeCondDefsAssignment_5_2 )*
            {
             before(grammarAccess.getSchemaAccess().getAttributeCondDefsAssignment_5_2()); 
            // InternalTGG.g:1706:2: ( rule__Schema__AttributeCondDefsAssignment_5_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID||LA21_0==52) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalTGG.g:1706:3: rule__Schema__AttributeCondDefsAssignment_5_2
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
    // InternalTGG.g:1714:1: rule__Schema__Group_5__3 : rule__Schema__Group_5__3__Impl ;
    public final void rule__Schema__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1718:1: ( rule__Schema__Group_5__3__Impl )
            // InternalTGG.g:1719:2: rule__Schema__Group_5__3__Impl
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
    // InternalTGG.g:1725:1: rule__Schema__Group_5__3__Impl : ( '}' ) ;
    public final void rule__Schema__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1729:1: ( ( '}' ) )
            // InternalTGG.g:1730:1: ( '}' )
            {
            // InternalTGG.g:1730:1: ( '}' )
            // InternalTGG.g:1731:2: '}'
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
    // InternalTGG.g:1741:1: rule__CorrType__Group__0 : rule__CorrType__Group__0__Impl rule__CorrType__Group__1 ;
    public final void rule__CorrType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1745:1: ( rule__CorrType__Group__0__Impl rule__CorrType__Group__1 )
            // InternalTGG.g:1746:2: rule__CorrType__Group__0__Impl rule__CorrType__Group__1
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
    // InternalTGG.g:1753:1: rule__CorrType__Group__0__Impl : ( ( rule__CorrType__NameAssignment_0 ) ) ;
    public final void rule__CorrType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1757:1: ( ( ( rule__CorrType__NameAssignment_0 ) ) )
            // InternalTGG.g:1758:1: ( ( rule__CorrType__NameAssignment_0 ) )
            {
            // InternalTGG.g:1758:1: ( ( rule__CorrType__NameAssignment_0 ) )
            // InternalTGG.g:1759:2: ( rule__CorrType__NameAssignment_0 )
            {
             before(grammarAccess.getCorrTypeAccess().getNameAssignment_0()); 
            // InternalTGG.g:1760:2: ( rule__CorrType__NameAssignment_0 )
            // InternalTGG.g:1760:3: rule__CorrType__NameAssignment_0
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
    // InternalTGG.g:1768:1: rule__CorrType__Group__1 : rule__CorrType__Group__1__Impl ;
    public final void rule__CorrType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1772:1: ( rule__CorrType__Group__1__Impl )
            // InternalTGG.g:1773:2: rule__CorrType__Group__1__Impl
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
    // InternalTGG.g:1779:1: rule__CorrType__Group__1__Impl : ( ( rule__CorrType__Alternatives_1 ) ) ;
    public final void rule__CorrType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1783:1: ( ( ( rule__CorrType__Alternatives_1 ) ) )
            // InternalTGG.g:1784:1: ( ( rule__CorrType__Alternatives_1 ) )
            {
            // InternalTGG.g:1784:1: ( ( rule__CorrType__Alternatives_1 ) )
            // InternalTGG.g:1785:2: ( rule__CorrType__Alternatives_1 )
            {
             before(grammarAccess.getCorrTypeAccess().getAlternatives_1()); 
            // InternalTGG.g:1786:2: ( rule__CorrType__Alternatives_1 )
            // InternalTGG.g:1786:3: rule__CorrType__Alternatives_1
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
    // InternalTGG.g:1795:1: rule__CorrType__Group_1_0__0 : rule__CorrType__Group_1_0__0__Impl rule__CorrType__Group_1_0__1 ;
    public final void rule__CorrType__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1799:1: ( rule__CorrType__Group_1_0__0__Impl rule__CorrType__Group_1_0__1 )
            // InternalTGG.g:1800:2: rule__CorrType__Group_1_0__0__Impl rule__CorrType__Group_1_0__1
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
    // InternalTGG.g:1807:1: rule__CorrType__Group_1_0__0__Impl : ( '#extends' ) ;
    public final void rule__CorrType__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1811:1: ( ( '#extends' ) )
            // InternalTGG.g:1812:1: ( '#extends' )
            {
            // InternalTGG.g:1812:1: ( '#extends' )
            // InternalTGG.g:1813:2: '#extends'
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
    // InternalTGG.g:1822:1: rule__CorrType__Group_1_0__1 : rule__CorrType__Group_1_0__1__Impl ;
    public final void rule__CorrType__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1826:1: ( rule__CorrType__Group_1_0__1__Impl )
            // InternalTGG.g:1827:2: rule__CorrType__Group_1_0__1__Impl
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
    // InternalTGG.g:1833:1: rule__CorrType__Group_1_0__1__Impl : ( ( rule__CorrType__SuperAssignment_1_0_1 ) ) ;
    public final void rule__CorrType__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1837:1: ( ( ( rule__CorrType__SuperAssignment_1_0_1 ) ) )
            // InternalTGG.g:1838:1: ( ( rule__CorrType__SuperAssignment_1_0_1 ) )
            {
            // InternalTGG.g:1838:1: ( ( rule__CorrType__SuperAssignment_1_0_1 ) )
            // InternalTGG.g:1839:2: ( rule__CorrType__SuperAssignment_1_0_1 )
            {
             before(grammarAccess.getCorrTypeAccess().getSuperAssignment_1_0_1()); 
            // InternalTGG.g:1840:2: ( rule__CorrType__SuperAssignment_1_0_1 )
            // InternalTGG.g:1840:3: rule__CorrType__SuperAssignment_1_0_1
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
    // InternalTGG.g:1849:1: rule__CorrType__Group_1_1__0 : rule__CorrType__Group_1_1__0__Impl rule__CorrType__Group_1_1__1 ;
    public final void rule__CorrType__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1853:1: ( rule__CorrType__Group_1_1__0__Impl rule__CorrType__Group_1_1__1 )
            // InternalTGG.g:1854:2: rule__CorrType__Group_1_1__0__Impl rule__CorrType__Group_1_1__1
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
    // InternalTGG.g:1861:1: rule__CorrType__Group_1_1__0__Impl : ( '{' ) ;
    public final void rule__CorrType__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1865:1: ( ( '{' ) )
            // InternalTGG.g:1866:1: ( '{' )
            {
            // InternalTGG.g:1866:1: ( '{' )
            // InternalTGG.g:1867:2: '{'
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
    // InternalTGG.g:1876:1: rule__CorrType__Group_1_1__1 : rule__CorrType__Group_1_1__1__Impl rule__CorrType__Group_1_1__2 ;
    public final void rule__CorrType__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1880:1: ( rule__CorrType__Group_1_1__1__Impl rule__CorrType__Group_1_1__2 )
            // InternalTGG.g:1881:2: rule__CorrType__Group_1_1__1__Impl rule__CorrType__Group_1_1__2
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
    // InternalTGG.g:1888:1: rule__CorrType__Group_1_1__1__Impl : ( '#src->' ) ;
    public final void rule__CorrType__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1892:1: ( ( '#src->' ) )
            // InternalTGG.g:1893:1: ( '#src->' )
            {
            // InternalTGG.g:1893:1: ( '#src->' )
            // InternalTGG.g:1894:2: '#src->'
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
    // InternalTGG.g:1903:1: rule__CorrType__Group_1_1__2 : rule__CorrType__Group_1_1__2__Impl rule__CorrType__Group_1_1__3 ;
    public final void rule__CorrType__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1907:1: ( rule__CorrType__Group_1_1__2__Impl rule__CorrType__Group_1_1__3 )
            // InternalTGG.g:1908:2: rule__CorrType__Group_1_1__2__Impl rule__CorrType__Group_1_1__3
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
    // InternalTGG.g:1915:1: rule__CorrType__Group_1_1__2__Impl : ( ( rule__CorrType__SourceAssignment_1_1_2 ) ) ;
    public final void rule__CorrType__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1919:1: ( ( ( rule__CorrType__SourceAssignment_1_1_2 ) ) )
            // InternalTGG.g:1920:1: ( ( rule__CorrType__SourceAssignment_1_1_2 ) )
            {
            // InternalTGG.g:1920:1: ( ( rule__CorrType__SourceAssignment_1_1_2 ) )
            // InternalTGG.g:1921:2: ( rule__CorrType__SourceAssignment_1_1_2 )
            {
             before(grammarAccess.getCorrTypeAccess().getSourceAssignment_1_1_2()); 
            // InternalTGG.g:1922:2: ( rule__CorrType__SourceAssignment_1_1_2 )
            // InternalTGG.g:1922:3: rule__CorrType__SourceAssignment_1_1_2
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
    // InternalTGG.g:1930:1: rule__CorrType__Group_1_1__3 : rule__CorrType__Group_1_1__3__Impl rule__CorrType__Group_1_1__4 ;
    public final void rule__CorrType__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1934:1: ( rule__CorrType__Group_1_1__3__Impl rule__CorrType__Group_1_1__4 )
            // InternalTGG.g:1935:2: rule__CorrType__Group_1_1__3__Impl rule__CorrType__Group_1_1__4
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
    // InternalTGG.g:1942:1: rule__CorrType__Group_1_1__3__Impl : ( '#trg->' ) ;
    public final void rule__CorrType__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1946:1: ( ( '#trg->' ) )
            // InternalTGG.g:1947:1: ( '#trg->' )
            {
            // InternalTGG.g:1947:1: ( '#trg->' )
            // InternalTGG.g:1948:2: '#trg->'
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
    // InternalTGG.g:1957:1: rule__CorrType__Group_1_1__4 : rule__CorrType__Group_1_1__4__Impl rule__CorrType__Group_1_1__5 ;
    public final void rule__CorrType__Group_1_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1961:1: ( rule__CorrType__Group_1_1__4__Impl rule__CorrType__Group_1_1__5 )
            // InternalTGG.g:1962:2: rule__CorrType__Group_1_1__4__Impl rule__CorrType__Group_1_1__5
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
    // InternalTGG.g:1969:1: rule__CorrType__Group_1_1__4__Impl : ( ( rule__CorrType__TargetAssignment_1_1_4 ) ) ;
    public final void rule__CorrType__Group_1_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1973:1: ( ( ( rule__CorrType__TargetAssignment_1_1_4 ) ) )
            // InternalTGG.g:1974:1: ( ( rule__CorrType__TargetAssignment_1_1_4 ) )
            {
            // InternalTGG.g:1974:1: ( ( rule__CorrType__TargetAssignment_1_1_4 ) )
            // InternalTGG.g:1975:2: ( rule__CorrType__TargetAssignment_1_1_4 )
            {
             before(grammarAccess.getCorrTypeAccess().getTargetAssignment_1_1_4()); 
            // InternalTGG.g:1976:2: ( rule__CorrType__TargetAssignment_1_1_4 )
            // InternalTGG.g:1976:3: rule__CorrType__TargetAssignment_1_1_4
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
    // InternalTGG.g:1984:1: rule__CorrType__Group_1_1__5 : rule__CorrType__Group_1_1__5__Impl ;
    public final void rule__CorrType__Group_1_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1988:1: ( rule__CorrType__Group_1_1__5__Impl )
            // InternalTGG.g:1989:2: rule__CorrType__Group_1_1__5__Impl
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
    // InternalTGG.g:1995:1: rule__CorrType__Group_1_1__5__Impl : ( '}' ) ;
    public final void rule__CorrType__Group_1_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:1999:1: ( ( '}' ) )
            // InternalTGG.g:2000:1: ( '}' )
            {
            // InternalTGG.g:2000:1: ( '}' )
            // InternalTGG.g:2001:2: '}'
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
    // InternalTGG.g:2011:1: rule__AttrCondDef__Group__0 : rule__AttrCondDef__Group__0__Impl rule__AttrCondDef__Group__1 ;
    public final void rule__AttrCondDef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2015:1: ( rule__AttrCondDef__Group__0__Impl rule__AttrCondDef__Group__1 )
            // InternalTGG.g:2016:2: rule__AttrCondDef__Group__0__Impl rule__AttrCondDef__Group__1
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
    // InternalTGG.g:2023:1: rule__AttrCondDef__Group__0__Impl : ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? ) ;
    public final void rule__AttrCondDef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2027:1: ( ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? ) )
            // InternalTGG.g:2028:1: ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? )
            {
            // InternalTGG.g:2028:1: ( ( rule__AttrCondDef__UserDefinedAssignment_0 )? )
            // InternalTGG.g:2029:2: ( rule__AttrCondDef__UserDefinedAssignment_0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getUserDefinedAssignment_0()); 
            // InternalTGG.g:2030:2: ( rule__AttrCondDef__UserDefinedAssignment_0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==52) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTGG.g:2030:3: rule__AttrCondDef__UserDefinedAssignment_0
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
    // InternalTGG.g:2038:1: rule__AttrCondDef__Group__1 : rule__AttrCondDef__Group__1__Impl rule__AttrCondDef__Group__2 ;
    public final void rule__AttrCondDef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2042:1: ( rule__AttrCondDef__Group__1__Impl rule__AttrCondDef__Group__2 )
            // InternalTGG.g:2043:2: rule__AttrCondDef__Group__1__Impl rule__AttrCondDef__Group__2
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
    // InternalTGG.g:2050:1: rule__AttrCondDef__Group__1__Impl : ( ( rule__AttrCondDef__NameAssignment_1 ) ) ;
    public final void rule__AttrCondDef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2054:1: ( ( ( rule__AttrCondDef__NameAssignment_1 ) ) )
            // InternalTGG.g:2055:1: ( ( rule__AttrCondDef__NameAssignment_1 ) )
            {
            // InternalTGG.g:2055:1: ( ( rule__AttrCondDef__NameAssignment_1 ) )
            // InternalTGG.g:2056:2: ( rule__AttrCondDef__NameAssignment_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getNameAssignment_1()); 
            // InternalTGG.g:2057:2: ( rule__AttrCondDef__NameAssignment_1 )
            // InternalTGG.g:2057:3: rule__AttrCondDef__NameAssignment_1
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
    // InternalTGG.g:2065:1: rule__AttrCondDef__Group__2 : rule__AttrCondDef__Group__2__Impl rule__AttrCondDef__Group__3 ;
    public final void rule__AttrCondDef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2069:1: ( rule__AttrCondDef__Group__2__Impl rule__AttrCondDef__Group__3 )
            // InternalTGG.g:2070:2: rule__AttrCondDef__Group__2__Impl rule__AttrCondDef__Group__3
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
    // InternalTGG.g:2077:1: rule__AttrCondDef__Group__2__Impl : ( '(' ) ;
    public final void rule__AttrCondDef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2081:1: ( ( '(' ) )
            // InternalTGG.g:2082:1: ( '(' )
            {
            // InternalTGG.g:2082:1: ( '(' )
            // InternalTGG.g:2083:2: '('
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
    // InternalTGG.g:2092:1: rule__AttrCondDef__Group__3 : rule__AttrCondDef__Group__3__Impl rule__AttrCondDef__Group__4 ;
    public final void rule__AttrCondDef__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2096:1: ( rule__AttrCondDef__Group__3__Impl rule__AttrCondDef__Group__4 )
            // InternalTGG.g:2097:2: rule__AttrCondDef__Group__3__Impl rule__AttrCondDef__Group__4
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
    // InternalTGG.g:2104:1: rule__AttrCondDef__Group__3__Impl : ( ( rule__AttrCondDef__Group_3__0 )? ) ;
    public final void rule__AttrCondDef__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2108:1: ( ( ( rule__AttrCondDef__Group_3__0 )? ) )
            // InternalTGG.g:2109:1: ( ( rule__AttrCondDef__Group_3__0 )? )
            {
            // InternalTGG.g:2109:1: ( ( rule__AttrCondDef__Group_3__0 )? )
            // InternalTGG.g:2110:2: ( rule__AttrCondDef__Group_3__0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_3()); 
            // InternalTGG.g:2111:2: ( rule__AttrCondDef__Group_3__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTGG.g:2111:3: rule__AttrCondDef__Group_3__0
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
    // InternalTGG.g:2119:1: rule__AttrCondDef__Group__4 : rule__AttrCondDef__Group__4__Impl rule__AttrCondDef__Group__5 ;
    public final void rule__AttrCondDef__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2123:1: ( rule__AttrCondDef__Group__4__Impl rule__AttrCondDef__Group__5 )
            // InternalTGG.g:2124:2: rule__AttrCondDef__Group__4__Impl rule__AttrCondDef__Group__5
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
    // InternalTGG.g:2131:1: rule__AttrCondDef__Group__4__Impl : ( ')' ) ;
    public final void rule__AttrCondDef__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2135:1: ( ( ')' ) )
            // InternalTGG.g:2136:1: ( ')' )
            {
            // InternalTGG.g:2136:1: ( ')' )
            // InternalTGG.g:2137:2: ')'
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
    // InternalTGG.g:2146:1: rule__AttrCondDef__Group__5 : rule__AttrCondDef__Group__5__Impl rule__AttrCondDef__Group__6 ;
    public final void rule__AttrCondDef__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2150:1: ( rule__AttrCondDef__Group__5__Impl rule__AttrCondDef__Group__6 )
            // InternalTGG.g:2151:2: rule__AttrCondDef__Group__5__Impl rule__AttrCondDef__Group__6
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
    // InternalTGG.g:2158:1: rule__AttrCondDef__Group__5__Impl : ( '{' ) ;
    public final void rule__AttrCondDef__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2162:1: ( ( '{' ) )
            // InternalTGG.g:2163:1: ( '{' )
            {
            // InternalTGG.g:2163:1: ( '{' )
            // InternalTGG.g:2164:2: '{'
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
    // InternalTGG.g:2173:1: rule__AttrCondDef__Group__6 : rule__AttrCondDef__Group__6__Impl rule__AttrCondDef__Group__7 ;
    public final void rule__AttrCondDef__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2177:1: ( rule__AttrCondDef__Group__6__Impl rule__AttrCondDef__Group__7 )
            // InternalTGG.g:2178:2: rule__AttrCondDef__Group__6__Impl rule__AttrCondDef__Group__7
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
    // InternalTGG.g:2185:1: rule__AttrCondDef__Group__6__Impl : ( '#sync:' ) ;
    public final void rule__AttrCondDef__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2189:1: ( ( '#sync:' ) )
            // InternalTGG.g:2190:1: ( '#sync:' )
            {
            // InternalTGG.g:2190:1: ( '#sync:' )
            // InternalTGG.g:2191:2: '#sync:'
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
    // InternalTGG.g:2200:1: rule__AttrCondDef__Group__7 : rule__AttrCondDef__Group__7__Impl rule__AttrCondDef__Group__8 ;
    public final void rule__AttrCondDef__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2204:1: ( rule__AttrCondDef__Group__7__Impl rule__AttrCondDef__Group__8 )
            // InternalTGG.g:2205:2: rule__AttrCondDef__Group__7__Impl rule__AttrCondDef__Group__8
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
    // InternalTGG.g:2212:1: rule__AttrCondDef__Group__7__Impl : ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) ) ;
    public final void rule__AttrCondDef__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2216:1: ( ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) ) )
            // InternalTGG.g:2217:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) )
            {
            // InternalTGG.g:2217:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 ) )
            // InternalTGG.g:2218:2: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_7()); 
            // InternalTGG.g:2219:2: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 )
            // InternalTGG.g:2219:3: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7
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
    // InternalTGG.g:2227:1: rule__AttrCondDef__Group__8 : rule__AttrCondDef__Group__8__Impl rule__AttrCondDef__Group__9 ;
    public final void rule__AttrCondDef__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2231:1: ( rule__AttrCondDef__Group__8__Impl rule__AttrCondDef__Group__9 )
            // InternalTGG.g:2232:2: rule__AttrCondDef__Group__8__Impl rule__AttrCondDef__Group__9
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
    // InternalTGG.g:2239:1: rule__AttrCondDef__Group__8__Impl : ( ( rule__AttrCondDef__Group_8__0 )* ) ;
    public final void rule__AttrCondDef__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2243:1: ( ( ( rule__AttrCondDef__Group_8__0 )* ) )
            // InternalTGG.g:2244:1: ( ( rule__AttrCondDef__Group_8__0 )* )
            {
            // InternalTGG.g:2244:1: ( ( rule__AttrCondDef__Group_8__0 )* )
            // InternalTGG.g:2245:2: ( rule__AttrCondDef__Group_8__0 )*
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_8()); 
            // InternalTGG.g:2246:2: ( rule__AttrCondDef__Group_8__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==34) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalTGG.g:2246:3: rule__AttrCondDef__Group_8__0
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
    // InternalTGG.g:2254:1: rule__AttrCondDef__Group__9 : rule__AttrCondDef__Group__9__Impl rule__AttrCondDef__Group__10 ;
    public final void rule__AttrCondDef__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2258:1: ( rule__AttrCondDef__Group__9__Impl rule__AttrCondDef__Group__10 )
            // InternalTGG.g:2259:2: rule__AttrCondDef__Group__9__Impl rule__AttrCondDef__Group__10
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
    // InternalTGG.g:2266:1: rule__AttrCondDef__Group__9__Impl : ( ( rule__AttrCondDef__Group_9__0 )? ) ;
    public final void rule__AttrCondDef__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2270:1: ( ( ( rule__AttrCondDef__Group_9__0 )? ) )
            // InternalTGG.g:2271:1: ( ( rule__AttrCondDef__Group_9__0 )? )
            {
            // InternalTGG.g:2271:1: ( ( rule__AttrCondDef__Group_9__0 )? )
            // InternalTGG.g:2272:2: ( rule__AttrCondDef__Group_9__0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_9()); 
            // InternalTGG.g:2273:2: ( rule__AttrCondDef__Group_9__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==35) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalTGG.g:2273:3: rule__AttrCondDef__Group_9__0
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
    // InternalTGG.g:2281:1: rule__AttrCondDef__Group__10 : rule__AttrCondDef__Group__10__Impl ;
    public final void rule__AttrCondDef__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2285:1: ( rule__AttrCondDef__Group__10__Impl )
            // InternalTGG.g:2286:2: rule__AttrCondDef__Group__10__Impl
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
    // InternalTGG.g:2292:1: rule__AttrCondDef__Group__10__Impl : ( '}' ) ;
    public final void rule__AttrCondDef__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2296:1: ( ( '}' ) )
            // InternalTGG.g:2297:1: ( '}' )
            {
            // InternalTGG.g:2297:1: ( '}' )
            // InternalTGG.g:2298:2: '}'
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
    // InternalTGG.g:2308:1: rule__AttrCondDef__Group_3__0 : rule__AttrCondDef__Group_3__0__Impl rule__AttrCondDef__Group_3__1 ;
    public final void rule__AttrCondDef__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2312:1: ( rule__AttrCondDef__Group_3__0__Impl rule__AttrCondDef__Group_3__1 )
            // InternalTGG.g:2313:2: rule__AttrCondDef__Group_3__0__Impl rule__AttrCondDef__Group_3__1
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
    // InternalTGG.g:2320:1: rule__AttrCondDef__Group_3__0__Impl : ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) ) ;
    public final void rule__AttrCondDef__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2324:1: ( ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) ) )
            // InternalTGG.g:2325:1: ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) )
            {
            // InternalTGG.g:2325:1: ( ( rule__AttrCondDef__ParamsAssignment_3_0 ) )
            // InternalTGG.g:2326:2: ( rule__AttrCondDef__ParamsAssignment_3_0 )
            {
             before(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_0()); 
            // InternalTGG.g:2327:2: ( rule__AttrCondDef__ParamsAssignment_3_0 )
            // InternalTGG.g:2327:3: rule__AttrCondDef__ParamsAssignment_3_0
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
    // InternalTGG.g:2335:1: rule__AttrCondDef__Group_3__1 : rule__AttrCondDef__Group_3__1__Impl ;
    public final void rule__AttrCondDef__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2339:1: ( rule__AttrCondDef__Group_3__1__Impl )
            // InternalTGG.g:2340:2: rule__AttrCondDef__Group_3__1__Impl
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
    // InternalTGG.g:2346:1: rule__AttrCondDef__Group_3__1__Impl : ( ( rule__AttrCondDef__Group_3_1__0 )* ) ;
    public final void rule__AttrCondDef__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2350:1: ( ( ( rule__AttrCondDef__Group_3_1__0 )* ) )
            // InternalTGG.g:2351:1: ( ( rule__AttrCondDef__Group_3_1__0 )* )
            {
            // InternalTGG.g:2351:1: ( ( rule__AttrCondDef__Group_3_1__0 )* )
            // InternalTGG.g:2352:2: ( rule__AttrCondDef__Group_3_1__0 )*
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_3_1()); 
            // InternalTGG.g:2353:2: ( rule__AttrCondDef__Group_3_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==34) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalTGG.g:2353:3: rule__AttrCondDef__Group_3_1__0
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
    // InternalTGG.g:2362:1: rule__AttrCondDef__Group_3_1__0 : rule__AttrCondDef__Group_3_1__0__Impl rule__AttrCondDef__Group_3_1__1 ;
    public final void rule__AttrCondDef__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2366:1: ( rule__AttrCondDef__Group_3_1__0__Impl rule__AttrCondDef__Group_3_1__1 )
            // InternalTGG.g:2367:2: rule__AttrCondDef__Group_3_1__0__Impl rule__AttrCondDef__Group_3_1__1
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
    // InternalTGG.g:2374:1: rule__AttrCondDef__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__AttrCondDef__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2378:1: ( ( ',' ) )
            // InternalTGG.g:2379:1: ( ',' )
            {
            // InternalTGG.g:2379:1: ( ',' )
            // InternalTGG.g:2380:2: ','
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
    // InternalTGG.g:2389:1: rule__AttrCondDef__Group_3_1__1 : rule__AttrCondDef__Group_3_1__1__Impl ;
    public final void rule__AttrCondDef__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2393:1: ( rule__AttrCondDef__Group_3_1__1__Impl )
            // InternalTGG.g:2394:2: rule__AttrCondDef__Group_3_1__1__Impl
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
    // InternalTGG.g:2400:1: rule__AttrCondDef__Group_3_1__1__Impl : ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) ) ;
    public final void rule__AttrCondDef__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2404:1: ( ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) ) )
            // InternalTGG.g:2405:1: ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) )
            {
            // InternalTGG.g:2405:1: ( ( rule__AttrCondDef__ParamsAssignment_3_1_1 ) )
            // InternalTGG.g:2406:2: ( rule__AttrCondDef__ParamsAssignment_3_1_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getParamsAssignment_3_1_1()); 
            // InternalTGG.g:2407:2: ( rule__AttrCondDef__ParamsAssignment_3_1_1 )
            // InternalTGG.g:2407:3: rule__AttrCondDef__ParamsAssignment_3_1_1
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
    // InternalTGG.g:2416:1: rule__AttrCondDef__Group_8__0 : rule__AttrCondDef__Group_8__0__Impl rule__AttrCondDef__Group_8__1 ;
    public final void rule__AttrCondDef__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2420:1: ( rule__AttrCondDef__Group_8__0__Impl rule__AttrCondDef__Group_8__1 )
            // InternalTGG.g:2421:2: rule__AttrCondDef__Group_8__0__Impl rule__AttrCondDef__Group_8__1
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
    // InternalTGG.g:2428:1: rule__AttrCondDef__Group_8__0__Impl : ( ',' ) ;
    public final void rule__AttrCondDef__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2432:1: ( ( ',' ) )
            // InternalTGG.g:2433:1: ( ',' )
            {
            // InternalTGG.g:2433:1: ( ',' )
            // InternalTGG.g:2434:2: ','
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
    // InternalTGG.g:2443:1: rule__AttrCondDef__Group_8__1 : rule__AttrCondDef__Group_8__1__Impl ;
    public final void rule__AttrCondDef__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2447:1: ( rule__AttrCondDef__Group_8__1__Impl )
            // InternalTGG.g:2448:2: rule__AttrCondDef__Group_8__1__Impl
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
    // InternalTGG.g:2454:1: rule__AttrCondDef__Group_8__1__Impl : ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) ) ;
    public final void rule__AttrCondDef__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2458:1: ( ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) ) )
            // InternalTGG.g:2459:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) )
            {
            // InternalTGG.g:2459:1: ( ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 ) )
            // InternalTGG.g:2460:2: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedSyncAdornmentsAssignment_8_1()); 
            // InternalTGG.g:2461:2: ( rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 )
            // InternalTGG.g:2461:3: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1
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
    // InternalTGG.g:2470:1: rule__AttrCondDef__Group_9__0 : rule__AttrCondDef__Group_9__0__Impl rule__AttrCondDef__Group_9__1 ;
    public final void rule__AttrCondDef__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2474:1: ( rule__AttrCondDef__Group_9__0__Impl rule__AttrCondDef__Group_9__1 )
            // InternalTGG.g:2475:2: rule__AttrCondDef__Group_9__0__Impl rule__AttrCondDef__Group_9__1
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
    // InternalTGG.g:2482:1: rule__AttrCondDef__Group_9__0__Impl : ( '#gen:' ) ;
    public final void rule__AttrCondDef__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2486:1: ( ( '#gen:' ) )
            // InternalTGG.g:2487:1: ( '#gen:' )
            {
            // InternalTGG.g:2487:1: ( '#gen:' )
            // InternalTGG.g:2488:2: '#gen:'
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
    // InternalTGG.g:2497:1: rule__AttrCondDef__Group_9__1 : rule__AttrCondDef__Group_9__1__Impl ;
    public final void rule__AttrCondDef__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2501:1: ( rule__AttrCondDef__Group_9__1__Impl )
            // InternalTGG.g:2502:2: rule__AttrCondDef__Group_9__1__Impl
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
    // InternalTGG.g:2508:1: rule__AttrCondDef__Group_9__1__Impl : ( ( rule__AttrCondDef__Group_9_1__0 )? ) ;
    public final void rule__AttrCondDef__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2512:1: ( ( ( rule__AttrCondDef__Group_9_1__0 )? ) )
            // InternalTGG.g:2513:1: ( ( rule__AttrCondDef__Group_9_1__0 )? )
            {
            // InternalTGG.g:2513:1: ( ( rule__AttrCondDef__Group_9_1__0 )? )
            // InternalTGG.g:2514:2: ( rule__AttrCondDef__Group_9_1__0 )?
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_9_1()); 
            // InternalTGG.g:2515:2: ( rule__AttrCondDef__Group_9_1__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==40) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTGG.g:2515:3: rule__AttrCondDef__Group_9_1__0
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
    // InternalTGG.g:2524:1: rule__AttrCondDef__Group_9_1__0 : rule__AttrCondDef__Group_9_1__0__Impl rule__AttrCondDef__Group_9_1__1 ;
    public final void rule__AttrCondDef__Group_9_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2528:1: ( rule__AttrCondDef__Group_9_1__0__Impl rule__AttrCondDef__Group_9_1__1 )
            // InternalTGG.g:2529:2: rule__AttrCondDef__Group_9_1__0__Impl rule__AttrCondDef__Group_9_1__1
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
    // InternalTGG.g:2536:1: rule__AttrCondDef__Group_9_1__0__Impl : ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) ) ;
    public final void rule__AttrCondDef__Group_9_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2540:1: ( ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) ) )
            // InternalTGG.g:2541:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) )
            {
            // InternalTGG.g:2541:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 ) )
            // InternalTGG.g:2542:2: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_0()); 
            // InternalTGG.g:2543:2: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 )
            // InternalTGG.g:2543:3: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0
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
    // InternalTGG.g:2551:1: rule__AttrCondDef__Group_9_1__1 : rule__AttrCondDef__Group_9_1__1__Impl ;
    public final void rule__AttrCondDef__Group_9_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2555:1: ( rule__AttrCondDef__Group_9_1__1__Impl )
            // InternalTGG.g:2556:2: rule__AttrCondDef__Group_9_1__1__Impl
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
    // InternalTGG.g:2562:1: rule__AttrCondDef__Group_9_1__1__Impl : ( ( rule__AttrCondDef__Group_9_1_1__0 )* ) ;
    public final void rule__AttrCondDef__Group_9_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2566:1: ( ( ( rule__AttrCondDef__Group_9_1_1__0 )* ) )
            // InternalTGG.g:2567:1: ( ( rule__AttrCondDef__Group_9_1_1__0 )* )
            {
            // InternalTGG.g:2567:1: ( ( rule__AttrCondDef__Group_9_1_1__0 )* )
            // InternalTGG.g:2568:2: ( rule__AttrCondDef__Group_9_1_1__0 )*
            {
             before(grammarAccess.getAttrCondDefAccess().getGroup_9_1_1()); 
            // InternalTGG.g:2569:2: ( rule__AttrCondDef__Group_9_1_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==34) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalTGG.g:2569:3: rule__AttrCondDef__Group_9_1_1__0
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
    // InternalTGG.g:2578:1: rule__AttrCondDef__Group_9_1_1__0 : rule__AttrCondDef__Group_9_1_1__0__Impl rule__AttrCondDef__Group_9_1_1__1 ;
    public final void rule__AttrCondDef__Group_9_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2582:1: ( rule__AttrCondDef__Group_9_1_1__0__Impl rule__AttrCondDef__Group_9_1_1__1 )
            // InternalTGG.g:2583:2: rule__AttrCondDef__Group_9_1_1__0__Impl rule__AttrCondDef__Group_9_1_1__1
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
    // InternalTGG.g:2590:1: rule__AttrCondDef__Group_9_1_1__0__Impl : ( ',' ) ;
    public final void rule__AttrCondDef__Group_9_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2594:1: ( ( ',' ) )
            // InternalTGG.g:2595:1: ( ',' )
            {
            // InternalTGG.g:2595:1: ( ',' )
            // InternalTGG.g:2596:2: ','
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
    // InternalTGG.g:2605:1: rule__AttrCondDef__Group_9_1_1__1 : rule__AttrCondDef__Group_9_1_1__1__Impl ;
    public final void rule__AttrCondDef__Group_9_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2609:1: ( rule__AttrCondDef__Group_9_1_1__1__Impl )
            // InternalTGG.g:2610:2: rule__AttrCondDef__Group_9_1_1__1__Impl
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
    // InternalTGG.g:2616:1: rule__AttrCondDef__Group_9_1_1__1__Impl : ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) ) ;
    public final void rule__AttrCondDef__Group_9_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2620:1: ( ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) ) )
            // InternalTGG.g:2621:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) )
            {
            // InternalTGG.g:2621:1: ( ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 ) )
            // InternalTGG.g:2622:2: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 )
            {
             before(grammarAccess.getAttrCondDefAccess().getAllowedGenAdornmentsAssignment_9_1_1_1()); 
            // InternalTGG.g:2623:2: ( rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 )
            // InternalTGG.g:2623:3: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1
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
    // InternalTGG.g:2632:1: rule__Param__Group__0 : rule__Param__Group__0__Impl rule__Param__Group__1 ;
    public final void rule__Param__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2636:1: ( rule__Param__Group__0__Impl rule__Param__Group__1 )
            // InternalTGG.g:2637:2: rule__Param__Group__0__Impl rule__Param__Group__1
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
    // InternalTGG.g:2644:1: rule__Param__Group__0__Impl : ( ( rule__Param__ParamNameAssignment_0 ) ) ;
    public final void rule__Param__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2648:1: ( ( ( rule__Param__ParamNameAssignment_0 ) ) )
            // InternalTGG.g:2649:1: ( ( rule__Param__ParamNameAssignment_0 ) )
            {
            // InternalTGG.g:2649:1: ( ( rule__Param__ParamNameAssignment_0 ) )
            // InternalTGG.g:2650:2: ( rule__Param__ParamNameAssignment_0 )
            {
             before(grammarAccess.getParamAccess().getParamNameAssignment_0()); 
            // InternalTGG.g:2651:2: ( rule__Param__ParamNameAssignment_0 )
            // InternalTGG.g:2651:3: rule__Param__ParamNameAssignment_0
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
    // InternalTGG.g:2659:1: rule__Param__Group__1 : rule__Param__Group__1__Impl rule__Param__Group__2 ;
    public final void rule__Param__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2663:1: ( rule__Param__Group__1__Impl rule__Param__Group__2 )
            // InternalTGG.g:2664:2: rule__Param__Group__1__Impl rule__Param__Group__2
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
    // InternalTGG.g:2671:1: rule__Param__Group__1__Impl : ( ':' ) ;
    public final void rule__Param__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2675:1: ( ( ':' ) )
            // InternalTGG.g:2676:1: ( ':' )
            {
            // InternalTGG.g:2676:1: ( ':' )
            // InternalTGG.g:2677:2: ':'
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
    // InternalTGG.g:2686:1: rule__Param__Group__2 : rule__Param__Group__2__Impl ;
    public final void rule__Param__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2690:1: ( rule__Param__Group__2__Impl )
            // InternalTGG.g:2691:2: rule__Param__Group__2__Impl
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
    // InternalTGG.g:2697:1: rule__Param__Group__2__Impl : ( ( rule__Param__TypeAssignment_2 ) ) ;
    public final void rule__Param__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2701:1: ( ( ( rule__Param__TypeAssignment_2 ) ) )
            // InternalTGG.g:2702:1: ( ( rule__Param__TypeAssignment_2 ) )
            {
            // InternalTGG.g:2702:1: ( ( rule__Param__TypeAssignment_2 ) )
            // InternalTGG.g:2703:2: ( rule__Param__TypeAssignment_2 )
            {
             before(grammarAccess.getParamAccess().getTypeAssignment_2()); 
            // InternalTGG.g:2704:2: ( rule__Param__TypeAssignment_2 )
            // InternalTGG.g:2704:3: rule__Param__TypeAssignment_2
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
    // InternalTGG.g:2713:1: rule__Rule__Group__0 : rule__Rule__Group__0__Impl rule__Rule__Group__1 ;
    public final void rule__Rule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2717:1: ( rule__Rule__Group__0__Impl rule__Rule__Group__1 )
            // InternalTGG.g:2718:2: rule__Rule__Group__0__Impl rule__Rule__Group__1
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
    // InternalTGG.g:2725:1: rule__Rule__Group__0__Impl : ( ( rule__Rule__AbstractRuleAssignment_0 )? ) ;
    public final void rule__Rule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2729:1: ( ( ( rule__Rule__AbstractRuleAssignment_0 )? ) )
            // InternalTGG.g:2730:1: ( ( rule__Rule__AbstractRuleAssignment_0 )? )
            {
            // InternalTGG.g:2730:1: ( ( rule__Rule__AbstractRuleAssignment_0 )? )
            // InternalTGG.g:2731:2: ( rule__Rule__AbstractRuleAssignment_0 )?
            {
             before(grammarAccess.getRuleAccess().getAbstractRuleAssignment_0()); 
            // InternalTGG.g:2732:2: ( rule__Rule__AbstractRuleAssignment_0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==53) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalTGG.g:2732:3: rule__Rule__AbstractRuleAssignment_0
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
    // InternalTGG.g:2740:1: rule__Rule__Group__1 : rule__Rule__Group__1__Impl rule__Rule__Group__2 ;
    public final void rule__Rule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2744:1: ( rule__Rule__Group__1__Impl rule__Rule__Group__2 )
            // InternalTGG.g:2745:2: rule__Rule__Group__1__Impl rule__Rule__Group__2
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
    // InternalTGG.g:2752:1: rule__Rule__Group__1__Impl : ( '#rule' ) ;
    public final void rule__Rule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2756:1: ( ( '#rule' ) )
            // InternalTGG.g:2757:1: ( '#rule' )
            {
            // InternalTGG.g:2757:1: ( '#rule' )
            // InternalTGG.g:2758:2: '#rule'
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
    // InternalTGG.g:2767:1: rule__Rule__Group__2 : rule__Rule__Group__2__Impl rule__Rule__Group__3 ;
    public final void rule__Rule__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2771:1: ( rule__Rule__Group__2__Impl rule__Rule__Group__3 )
            // InternalTGG.g:2772:2: rule__Rule__Group__2__Impl rule__Rule__Group__3
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
    // InternalTGG.g:2779:1: rule__Rule__Group__2__Impl : ( ( rule__Rule__NameAssignment_2 ) ) ;
    public final void rule__Rule__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2783:1: ( ( ( rule__Rule__NameAssignment_2 ) ) )
            // InternalTGG.g:2784:1: ( ( rule__Rule__NameAssignment_2 ) )
            {
            // InternalTGG.g:2784:1: ( ( rule__Rule__NameAssignment_2 ) )
            // InternalTGG.g:2785:2: ( rule__Rule__NameAssignment_2 )
            {
             before(grammarAccess.getRuleAccess().getNameAssignment_2()); 
            // InternalTGG.g:2786:2: ( rule__Rule__NameAssignment_2 )
            // InternalTGG.g:2786:3: rule__Rule__NameAssignment_2
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
    // InternalTGG.g:2794:1: rule__Rule__Group__3 : rule__Rule__Group__3__Impl rule__Rule__Group__4 ;
    public final void rule__Rule__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2798:1: ( rule__Rule__Group__3__Impl rule__Rule__Group__4 )
            // InternalTGG.g:2799:2: rule__Rule__Group__3__Impl rule__Rule__Group__4
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
    // InternalTGG.g:2806:1: rule__Rule__Group__3__Impl : ( ( rule__Rule__Group_3__0 )? ) ;
    public final void rule__Rule__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2810:1: ( ( ( rule__Rule__Group_3__0 )? ) )
            // InternalTGG.g:2811:1: ( ( rule__Rule__Group_3__0 )? )
            {
            // InternalTGG.g:2811:1: ( ( rule__Rule__Group_3__0 )? )
            // InternalTGG.g:2812:2: ( rule__Rule__Group_3__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_3()); 
            // InternalTGG.g:2813:2: ( rule__Rule__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==28) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTGG.g:2813:3: rule__Rule__Group_3__0
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
    // InternalTGG.g:2821:1: rule__Rule__Group__4 : rule__Rule__Group__4__Impl rule__Rule__Group__5 ;
    public final void rule__Rule__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2825:1: ( rule__Rule__Group__4__Impl rule__Rule__Group__5 )
            // InternalTGG.g:2826:2: rule__Rule__Group__4__Impl rule__Rule__Group__5
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
    // InternalTGG.g:2833:1: rule__Rule__Group__4__Impl : ( '#with' ) ;
    public final void rule__Rule__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2837:1: ( ( '#with' ) )
            // InternalTGG.g:2838:1: ( '#with' )
            {
            // InternalTGG.g:2838:1: ( '#with' )
            // InternalTGG.g:2839:2: '#with'
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
    // InternalTGG.g:2848:1: rule__Rule__Group__5 : rule__Rule__Group__5__Impl rule__Rule__Group__6 ;
    public final void rule__Rule__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2852:1: ( rule__Rule__Group__5__Impl rule__Rule__Group__6 )
            // InternalTGG.g:2853:2: rule__Rule__Group__5__Impl rule__Rule__Group__6
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
    // InternalTGG.g:2860:1: rule__Rule__Group__5__Impl : ( ( rule__Rule__SchemaAssignment_5 ) ) ;
    public final void rule__Rule__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2864:1: ( ( ( rule__Rule__SchemaAssignment_5 ) ) )
            // InternalTGG.g:2865:1: ( ( rule__Rule__SchemaAssignment_5 ) )
            {
            // InternalTGG.g:2865:1: ( ( rule__Rule__SchemaAssignment_5 ) )
            // InternalTGG.g:2866:2: ( rule__Rule__SchemaAssignment_5 )
            {
             before(grammarAccess.getRuleAccess().getSchemaAssignment_5()); 
            // InternalTGG.g:2867:2: ( rule__Rule__SchemaAssignment_5 )
            // InternalTGG.g:2867:3: rule__Rule__SchemaAssignment_5
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
    // InternalTGG.g:2875:1: rule__Rule__Group__6 : rule__Rule__Group__6__Impl rule__Rule__Group__7 ;
    public final void rule__Rule__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2879:1: ( rule__Rule__Group__6__Impl rule__Rule__Group__7 )
            // InternalTGG.g:2880:2: rule__Rule__Group__6__Impl rule__Rule__Group__7
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
    // InternalTGG.g:2887:1: rule__Rule__Group__6__Impl : ( ( rule__Rule__Group_6__0 )? ) ;
    public final void rule__Rule__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2891:1: ( ( ( rule__Rule__Group_6__0 )? ) )
            // InternalTGG.g:2892:1: ( ( rule__Rule__Group_6__0 )? )
            {
            // InternalTGG.g:2892:1: ( ( rule__Rule__Group_6__0 )? )
            // InternalTGG.g:2893:2: ( rule__Rule__Group_6__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_6()); 
            // InternalTGG.g:2894:2: ( rule__Rule__Group_6__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==22) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTGG.g:2894:3: rule__Rule__Group_6__0
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
    // InternalTGG.g:2902:1: rule__Rule__Group__7 : rule__Rule__Group__7__Impl rule__Rule__Group__8 ;
    public final void rule__Rule__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2906:1: ( rule__Rule__Group__7__Impl rule__Rule__Group__8 )
            // InternalTGG.g:2907:2: rule__Rule__Group__7__Impl rule__Rule__Group__8
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
    // InternalTGG.g:2914:1: rule__Rule__Group__7__Impl : ( ( rule__Rule__Group_7__0 )? ) ;
    public final void rule__Rule__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2918:1: ( ( ( rule__Rule__Group_7__0 )? ) )
            // InternalTGG.g:2919:1: ( ( rule__Rule__Group_7__0 )? )
            {
            // InternalTGG.g:2919:1: ( ( rule__Rule__Group_7__0 )? )
            // InternalTGG.g:2920:2: ( rule__Rule__Group_7__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_7()); 
            // InternalTGG.g:2921:2: ( rule__Rule__Group_7__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==25) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalTGG.g:2921:3: rule__Rule__Group_7__0
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
    // InternalTGG.g:2929:1: rule__Rule__Group__8 : rule__Rule__Group__8__Impl rule__Rule__Group__9 ;
    public final void rule__Rule__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2933:1: ( rule__Rule__Group__8__Impl rule__Rule__Group__9 )
            // InternalTGG.g:2934:2: rule__Rule__Group__8__Impl rule__Rule__Group__9
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
    // InternalTGG.g:2941:1: rule__Rule__Group__8__Impl : ( ( rule__Rule__Group_8__0 )? ) ;
    public final void rule__Rule__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2945:1: ( ( ( rule__Rule__Group_8__0 )? ) )
            // InternalTGG.g:2946:1: ( ( rule__Rule__Group_8__0 )? )
            {
            // InternalTGG.g:2946:1: ( ( rule__Rule__Group_8__0 )? )
            // InternalTGG.g:2947:2: ( rule__Rule__Group_8__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_8()); 
            // InternalTGG.g:2948:2: ( rule__Rule__Group_8__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==26) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalTGG.g:2948:3: rule__Rule__Group_8__0
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
    // InternalTGG.g:2956:1: rule__Rule__Group__9 : rule__Rule__Group__9__Impl ;
    public final void rule__Rule__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2960:1: ( rule__Rule__Group__9__Impl )
            // InternalTGG.g:2961:2: rule__Rule__Group__9__Impl
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
    // InternalTGG.g:2967:1: rule__Rule__Group__9__Impl : ( ( rule__Rule__Group_9__0 )? ) ;
    public final void rule__Rule__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2971:1: ( ( ( rule__Rule__Group_9__0 )? ) )
            // InternalTGG.g:2972:1: ( ( rule__Rule__Group_9__0 )? )
            {
            // InternalTGG.g:2972:1: ( ( rule__Rule__Group_9__0 )? )
            // InternalTGG.g:2973:2: ( rule__Rule__Group_9__0 )?
            {
             before(grammarAccess.getRuleAccess().getGroup_9()); 
            // InternalTGG.g:2974:2: ( rule__Rule__Group_9__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==27) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTGG.g:2974:3: rule__Rule__Group_9__0
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
    // InternalTGG.g:2983:1: rule__Rule__Group_3__0 : rule__Rule__Group_3__0__Impl rule__Rule__Group_3__1 ;
    public final void rule__Rule__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2987:1: ( rule__Rule__Group_3__0__Impl rule__Rule__Group_3__1 )
            // InternalTGG.g:2988:2: rule__Rule__Group_3__0__Impl rule__Rule__Group_3__1
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
    // InternalTGG.g:2995:1: rule__Rule__Group_3__0__Impl : ( '#extends' ) ;
    public final void rule__Rule__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:2999:1: ( ( '#extends' ) )
            // InternalTGG.g:3000:1: ( '#extends' )
            {
            // InternalTGG.g:3000:1: ( '#extends' )
            // InternalTGG.g:3001:2: '#extends'
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
    // InternalTGG.g:3010:1: rule__Rule__Group_3__1 : rule__Rule__Group_3__1__Impl rule__Rule__Group_3__2 ;
    public final void rule__Rule__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3014:1: ( rule__Rule__Group_3__1__Impl rule__Rule__Group_3__2 )
            // InternalTGG.g:3015:2: rule__Rule__Group_3__1__Impl rule__Rule__Group_3__2
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
    // InternalTGG.g:3022:1: rule__Rule__Group_3__1__Impl : ( ( rule__Rule__SupertypesAssignment_3_1 ) ) ;
    public final void rule__Rule__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3026:1: ( ( ( rule__Rule__SupertypesAssignment_3_1 ) ) )
            // InternalTGG.g:3027:1: ( ( rule__Rule__SupertypesAssignment_3_1 ) )
            {
            // InternalTGG.g:3027:1: ( ( rule__Rule__SupertypesAssignment_3_1 ) )
            // InternalTGG.g:3028:2: ( rule__Rule__SupertypesAssignment_3_1 )
            {
             before(grammarAccess.getRuleAccess().getSupertypesAssignment_3_1()); 
            // InternalTGG.g:3029:2: ( rule__Rule__SupertypesAssignment_3_1 )
            // InternalTGG.g:3029:3: rule__Rule__SupertypesAssignment_3_1
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
    // InternalTGG.g:3037:1: rule__Rule__Group_3__2 : rule__Rule__Group_3__2__Impl ;
    public final void rule__Rule__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3041:1: ( rule__Rule__Group_3__2__Impl )
            // InternalTGG.g:3042:2: rule__Rule__Group_3__2__Impl
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
    // InternalTGG.g:3048:1: rule__Rule__Group_3__2__Impl : ( ( rule__Rule__Group_3_2__0 )* ) ;
    public final void rule__Rule__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3052:1: ( ( ( rule__Rule__Group_3_2__0 )* ) )
            // InternalTGG.g:3053:1: ( ( rule__Rule__Group_3_2__0 )* )
            {
            // InternalTGG.g:3053:1: ( ( rule__Rule__Group_3_2__0 )* )
            // InternalTGG.g:3054:2: ( rule__Rule__Group_3_2__0 )*
            {
             before(grammarAccess.getRuleAccess().getGroup_3_2()); 
            // InternalTGG.g:3055:2: ( rule__Rule__Group_3_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==34) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalTGG.g:3055:3: rule__Rule__Group_3_2__0
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
    // InternalTGG.g:3064:1: rule__Rule__Group_3_2__0 : rule__Rule__Group_3_2__0__Impl rule__Rule__Group_3_2__1 ;
    public final void rule__Rule__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3068:1: ( rule__Rule__Group_3_2__0__Impl rule__Rule__Group_3_2__1 )
            // InternalTGG.g:3069:2: rule__Rule__Group_3_2__0__Impl rule__Rule__Group_3_2__1
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
    // InternalTGG.g:3076:1: rule__Rule__Group_3_2__0__Impl : ( ',' ) ;
    public final void rule__Rule__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3080:1: ( ( ',' ) )
            // InternalTGG.g:3081:1: ( ',' )
            {
            // InternalTGG.g:3081:1: ( ',' )
            // InternalTGG.g:3082:2: ','
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
    // InternalTGG.g:3091:1: rule__Rule__Group_3_2__1 : rule__Rule__Group_3_2__1__Impl ;
    public final void rule__Rule__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3095:1: ( rule__Rule__Group_3_2__1__Impl )
            // InternalTGG.g:3096:2: rule__Rule__Group_3_2__1__Impl
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
    // InternalTGG.g:3102:1: rule__Rule__Group_3_2__1__Impl : ( ( rule__Rule__SupertypesAssignment_3_2_1 ) ) ;
    public final void rule__Rule__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3106:1: ( ( ( rule__Rule__SupertypesAssignment_3_2_1 ) ) )
            // InternalTGG.g:3107:1: ( ( rule__Rule__SupertypesAssignment_3_2_1 ) )
            {
            // InternalTGG.g:3107:1: ( ( rule__Rule__SupertypesAssignment_3_2_1 ) )
            // InternalTGG.g:3108:2: ( rule__Rule__SupertypesAssignment_3_2_1 )
            {
             before(grammarAccess.getRuleAccess().getSupertypesAssignment_3_2_1()); 
            // InternalTGG.g:3109:2: ( rule__Rule__SupertypesAssignment_3_2_1 )
            // InternalTGG.g:3109:3: rule__Rule__SupertypesAssignment_3_2_1
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
    // InternalTGG.g:3118:1: rule__Rule__Group_6__0 : rule__Rule__Group_6__0__Impl rule__Rule__Group_6__1 ;
    public final void rule__Rule__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3122:1: ( rule__Rule__Group_6__0__Impl rule__Rule__Group_6__1 )
            // InternalTGG.g:3123:2: rule__Rule__Group_6__0__Impl rule__Rule__Group_6__1
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
    // InternalTGG.g:3130:1: rule__Rule__Group_6__0__Impl : ( '#source' ) ;
    public final void rule__Rule__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3134:1: ( ( '#source' ) )
            // InternalTGG.g:3135:1: ( '#source' )
            {
            // InternalTGG.g:3135:1: ( '#source' )
            // InternalTGG.g:3136:2: '#source'
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
    // InternalTGG.g:3145:1: rule__Rule__Group_6__1 : rule__Rule__Group_6__1__Impl rule__Rule__Group_6__2 ;
    public final void rule__Rule__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3149:1: ( rule__Rule__Group_6__1__Impl rule__Rule__Group_6__2 )
            // InternalTGG.g:3150:2: rule__Rule__Group_6__1__Impl rule__Rule__Group_6__2
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
    // InternalTGG.g:3157:1: rule__Rule__Group_6__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3161:1: ( ( '{' ) )
            // InternalTGG.g:3162:1: ( '{' )
            {
            // InternalTGG.g:3162:1: ( '{' )
            // InternalTGG.g:3163:2: '{'
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
    // InternalTGG.g:3172:1: rule__Rule__Group_6__2 : rule__Rule__Group_6__2__Impl rule__Rule__Group_6__3 ;
    public final void rule__Rule__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3176:1: ( rule__Rule__Group_6__2__Impl rule__Rule__Group_6__3 )
            // InternalTGG.g:3177:2: rule__Rule__Group_6__2__Impl rule__Rule__Group_6__3
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
    // InternalTGG.g:3184:1: rule__Rule__Group_6__2__Impl : ( ( rule__Rule__SourcePatternsAssignment_6_2 )* ) ;
    public final void rule__Rule__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3188:1: ( ( ( rule__Rule__SourcePatternsAssignment_6_2 )* ) )
            // InternalTGG.g:3189:1: ( ( rule__Rule__SourcePatternsAssignment_6_2 )* )
            {
            // InternalTGG.g:3189:1: ( ( rule__Rule__SourcePatternsAssignment_6_2 )* )
            // InternalTGG.g:3190:2: ( rule__Rule__SourcePatternsAssignment_6_2 )*
            {
             before(grammarAccess.getRuleAccess().getSourcePatternsAssignment_6_2()); 
            // InternalTGG.g:3191:2: ( rule__Rule__SourcePatternsAssignment_6_2 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID||LA36_0==56) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalTGG.g:3191:3: rule__Rule__SourcePatternsAssignment_6_2
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
    // InternalTGG.g:3199:1: rule__Rule__Group_6__3 : rule__Rule__Group_6__3__Impl ;
    public final void rule__Rule__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3203:1: ( rule__Rule__Group_6__3__Impl )
            // InternalTGG.g:3204:2: rule__Rule__Group_6__3__Impl
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
    // InternalTGG.g:3210:1: rule__Rule__Group_6__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3214:1: ( ( '}' ) )
            // InternalTGG.g:3215:1: ( '}' )
            {
            // InternalTGG.g:3215:1: ( '}' )
            // InternalTGG.g:3216:2: '}'
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
    // InternalTGG.g:3226:1: rule__Rule__Group_7__0 : rule__Rule__Group_7__0__Impl rule__Rule__Group_7__1 ;
    public final void rule__Rule__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3230:1: ( rule__Rule__Group_7__0__Impl rule__Rule__Group_7__1 )
            // InternalTGG.g:3231:2: rule__Rule__Group_7__0__Impl rule__Rule__Group_7__1
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
    // InternalTGG.g:3238:1: rule__Rule__Group_7__0__Impl : ( '#target' ) ;
    public final void rule__Rule__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3242:1: ( ( '#target' ) )
            // InternalTGG.g:3243:1: ( '#target' )
            {
            // InternalTGG.g:3243:1: ( '#target' )
            // InternalTGG.g:3244:2: '#target'
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
    // InternalTGG.g:3253:1: rule__Rule__Group_7__1 : rule__Rule__Group_7__1__Impl rule__Rule__Group_7__2 ;
    public final void rule__Rule__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3257:1: ( rule__Rule__Group_7__1__Impl rule__Rule__Group_7__2 )
            // InternalTGG.g:3258:2: rule__Rule__Group_7__1__Impl rule__Rule__Group_7__2
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
    // InternalTGG.g:3265:1: rule__Rule__Group_7__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3269:1: ( ( '{' ) )
            // InternalTGG.g:3270:1: ( '{' )
            {
            // InternalTGG.g:3270:1: ( '{' )
            // InternalTGG.g:3271:2: '{'
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
    // InternalTGG.g:3280:1: rule__Rule__Group_7__2 : rule__Rule__Group_7__2__Impl rule__Rule__Group_7__3 ;
    public final void rule__Rule__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3284:1: ( rule__Rule__Group_7__2__Impl rule__Rule__Group_7__3 )
            // InternalTGG.g:3285:2: rule__Rule__Group_7__2__Impl rule__Rule__Group_7__3
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
    // InternalTGG.g:3292:1: rule__Rule__Group_7__2__Impl : ( ( rule__Rule__TargetPatternsAssignment_7_2 )* ) ;
    public final void rule__Rule__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3296:1: ( ( ( rule__Rule__TargetPatternsAssignment_7_2 )* ) )
            // InternalTGG.g:3297:1: ( ( rule__Rule__TargetPatternsAssignment_7_2 )* )
            {
            // InternalTGG.g:3297:1: ( ( rule__Rule__TargetPatternsAssignment_7_2 )* )
            // InternalTGG.g:3298:2: ( rule__Rule__TargetPatternsAssignment_7_2 )*
            {
             before(grammarAccess.getRuleAccess().getTargetPatternsAssignment_7_2()); 
            // InternalTGG.g:3299:2: ( rule__Rule__TargetPatternsAssignment_7_2 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID||LA37_0==56) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalTGG.g:3299:3: rule__Rule__TargetPatternsAssignment_7_2
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
    // InternalTGG.g:3307:1: rule__Rule__Group_7__3 : rule__Rule__Group_7__3__Impl ;
    public final void rule__Rule__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3311:1: ( rule__Rule__Group_7__3__Impl )
            // InternalTGG.g:3312:2: rule__Rule__Group_7__3__Impl
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
    // InternalTGG.g:3318:1: rule__Rule__Group_7__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3322:1: ( ( '}' ) )
            // InternalTGG.g:3323:1: ( '}' )
            {
            // InternalTGG.g:3323:1: ( '}' )
            // InternalTGG.g:3324:2: '}'
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
    // InternalTGG.g:3334:1: rule__Rule__Group_8__0 : rule__Rule__Group_8__0__Impl rule__Rule__Group_8__1 ;
    public final void rule__Rule__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3338:1: ( rule__Rule__Group_8__0__Impl rule__Rule__Group_8__1 )
            // InternalTGG.g:3339:2: rule__Rule__Group_8__0__Impl rule__Rule__Group_8__1
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
    // InternalTGG.g:3346:1: rule__Rule__Group_8__0__Impl : ( '#correspondence' ) ;
    public final void rule__Rule__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3350:1: ( ( '#correspondence' ) )
            // InternalTGG.g:3351:1: ( '#correspondence' )
            {
            // InternalTGG.g:3351:1: ( '#correspondence' )
            // InternalTGG.g:3352:2: '#correspondence'
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
    // InternalTGG.g:3361:1: rule__Rule__Group_8__1 : rule__Rule__Group_8__1__Impl rule__Rule__Group_8__2 ;
    public final void rule__Rule__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3365:1: ( rule__Rule__Group_8__1__Impl rule__Rule__Group_8__2 )
            // InternalTGG.g:3366:2: rule__Rule__Group_8__1__Impl rule__Rule__Group_8__2
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
    // InternalTGG.g:3373:1: rule__Rule__Group_8__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3377:1: ( ( '{' ) )
            // InternalTGG.g:3378:1: ( '{' )
            {
            // InternalTGG.g:3378:1: ( '{' )
            // InternalTGG.g:3379:2: '{'
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
    // InternalTGG.g:3388:1: rule__Rule__Group_8__2 : rule__Rule__Group_8__2__Impl rule__Rule__Group_8__3 ;
    public final void rule__Rule__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3392:1: ( rule__Rule__Group_8__2__Impl rule__Rule__Group_8__3 )
            // InternalTGG.g:3393:2: rule__Rule__Group_8__2__Impl rule__Rule__Group_8__3
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
    // InternalTGG.g:3400:1: rule__Rule__Group_8__2__Impl : ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* ) ;
    public final void rule__Rule__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3404:1: ( ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* ) )
            // InternalTGG.g:3405:1: ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* )
            {
            // InternalTGG.g:3405:1: ( ( rule__Rule__CorrespondencePatternsAssignment_8_2 )* )
            // InternalTGG.g:3406:2: ( rule__Rule__CorrespondencePatternsAssignment_8_2 )*
            {
             before(grammarAccess.getRuleAccess().getCorrespondencePatternsAssignment_8_2()); 
            // InternalTGG.g:3407:2: ( rule__Rule__CorrespondencePatternsAssignment_8_2 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||LA38_0==56) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalTGG.g:3407:3: rule__Rule__CorrespondencePatternsAssignment_8_2
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
    // InternalTGG.g:3415:1: rule__Rule__Group_8__3 : rule__Rule__Group_8__3__Impl ;
    public final void rule__Rule__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3419:1: ( rule__Rule__Group_8__3__Impl )
            // InternalTGG.g:3420:2: rule__Rule__Group_8__3__Impl
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
    // InternalTGG.g:3426:1: rule__Rule__Group_8__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3430:1: ( ( '}' ) )
            // InternalTGG.g:3431:1: ( '}' )
            {
            // InternalTGG.g:3431:1: ( '}' )
            // InternalTGG.g:3432:2: '}'
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
    // InternalTGG.g:3442:1: rule__Rule__Group_9__0 : rule__Rule__Group_9__0__Impl rule__Rule__Group_9__1 ;
    public final void rule__Rule__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3446:1: ( rule__Rule__Group_9__0__Impl rule__Rule__Group_9__1 )
            // InternalTGG.g:3447:2: rule__Rule__Group_9__0__Impl rule__Rule__Group_9__1
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
    // InternalTGG.g:3454:1: rule__Rule__Group_9__0__Impl : ( '#attributeConditions' ) ;
    public final void rule__Rule__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3458:1: ( ( '#attributeConditions' ) )
            // InternalTGG.g:3459:1: ( '#attributeConditions' )
            {
            // InternalTGG.g:3459:1: ( '#attributeConditions' )
            // InternalTGG.g:3460:2: '#attributeConditions'
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
    // InternalTGG.g:3469:1: rule__Rule__Group_9__1 : rule__Rule__Group_9__1__Impl rule__Rule__Group_9__2 ;
    public final void rule__Rule__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3473:1: ( rule__Rule__Group_9__1__Impl rule__Rule__Group_9__2 )
            // InternalTGG.g:3474:2: rule__Rule__Group_9__1__Impl rule__Rule__Group_9__2
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
    // InternalTGG.g:3481:1: rule__Rule__Group_9__1__Impl : ( '{' ) ;
    public final void rule__Rule__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3485:1: ( ( '{' ) )
            // InternalTGG.g:3486:1: ( '{' )
            {
            // InternalTGG.g:3486:1: ( '{' )
            // InternalTGG.g:3487:2: '{'
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
    // InternalTGG.g:3496:1: rule__Rule__Group_9__2 : rule__Rule__Group_9__2__Impl rule__Rule__Group_9__3 ;
    public final void rule__Rule__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3500:1: ( rule__Rule__Group_9__2__Impl rule__Rule__Group_9__3 )
            // InternalTGG.g:3501:2: rule__Rule__Group_9__2__Impl rule__Rule__Group_9__3
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
    // InternalTGG.g:3508:1: rule__Rule__Group_9__2__Impl : ( ( rule__Rule__AttrConditionsAssignment_9_2 )* ) ;
    public final void rule__Rule__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3512:1: ( ( ( rule__Rule__AttrConditionsAssignment_9_2 )* ) )
            // InternalTGG.g:3513:1: ( ( rule__Rule__AttrConditionsAssignment_9_2 )* )
            {
            // InternalTGG.g:3513:1: ( ( rule__Rule__AttrConditionsAssignment_9_2 )* )
            // InternalTGG.g:3514:2: ( rule__Rule__AttrConditionsAssignment_9_2 )*
            {
             before(grammarAccess.getRuleAccess().getAttrConditionsAssignment_9_2()); 
            // InternalTGG.g:3515:2: ( rule__Rule__AttrConditionsAssignment_9_2 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalTGG.g:3515:3: rule__Rule__AttrConditionsAssignment_9_2
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
    // InternalTGG.g:3523:1: rule__Rule__Group_9__3 : rule__Rule__Group_9__3__Impl ;
    public final void rule__Rule__Group_9__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3527:1: ( rule__Rule__Group_9__3__Impl )
            // InternalTGG.g:3528:2: rule__Rule__Group_9__3__Impl
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
    // InternalTGG.g:3534:1: rule__Rule__Group_9__3__Impl : ( '}' ) ;
    public final void rule__Rule__Group_9__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3538:1: ( ( '}' ) )
            // InternalTGG.g:3539:1: ( '}' )
            {
            // InternalTGG.g:3539:1: ( '}' )
            // InternalTGG.g:3540:2: '}'
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
    // InternalTGG.g:3550:1: rule__AttrCond__Group__0 : rule__AttrCond__Group__0__Impl rule__AttrCond__Group__1 ;
    public final void rule__AttrCond__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3554:1: ( rule__AttrCond__Group__0__Impl rule__AttrCond__Group__1 )
            // InternalTGG.g:3555:2: rule__AttrCond__Group__0__Impl rule__AttrCond__Group__1
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
    // InternalTGG.g:3562:1: rule__AttrCond__Group__0__Impl : ( ( rule__AttrCond__NameAssignment_0 ) ) ;
    public final void rule__AttrCond__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3566:1: ( ( ( rule__AttrCond__NameAssignment_0 ) ) )
            // InternalTGG.g:3567:1: ( ( rule__AttrCond__NameAssignment_0 ) )
            {
            // InternalTGG.g:3567:1: ( ( rule__AttrCond__NameAssignment_0 ) )
            // InternalTGG.g:3568:2: ( rule__AttrCond__NameAssignment_0 )
            {
             before(grammarAccess.getAttrCondAccess().getNameAssignment_0()); 
            // InternalTGG.g:3569:2: ( rule__AttrCond__NameAssignment_0 )
            // InternalTGG.g:3569:3: rule__AttrCond__NameAssignment_0
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
    // InternalTGG.g:3577:1: rule__AttrCond__Group__1 : rule__AttrCond__Group__1__Impl rule__AttrCond__Group__2 ;
    public final void rule__AttrCond__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3581:1: ( rule__AttrCond__Group__1__Impl rule__AttrCond__Group__2 )
            // InternalTGG.g:3582:2: rule__AttrCond__Group__1__Impl rule__AttrCond__Group__2
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
    // InternalTGG.g:3589:1: rule__AttrCond__Group__1__Impl : ( '(' ) ;
    public final void rule__AttrCond__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3593:1: ( ( '(' ) )
            // InternalTGG.g:3594:1: ( '(' )
            {
            // InternalTGG.g:3594:1: ( '(' )
            // InternalTGG.g:3595:2: '('
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
    // InternalTGG.g:3604:1: rule__AttrCond__Group__2 : rule__AttrCond__Group__2__Impl rule__AttrCond__Group__3 ;
    public final void rule__AttrCond__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3608:1: ( rule__AttrCond__Group__2__Impl rule__AttrCond__Group__3 )
            // InternalTGG.g:3609:2: rule__AttrCond__Group__2__Impl rule__AttrCond__Group__3
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
    // InternalTGG.g:3616:1: rule__AttrCond__Group__2__Impl : ( ( rule__AttrCond__Group_2__0 )? ) ;
    public final void rule__AttrCond__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3620:1: ( ( ( rule__AttrCond__Group_2__0 )? ) )
            // InternalTGG.g:3621:1: ( ( rule__AttrCond__Group_2__0 )? )
            {
            // InternalTGG.g:3621:1: ( ( rule__AttrCond__Group_2__0 )? )
            // InternalTGG.g:3622:2: ( rule__AttrCond__Group_2__0 )?
            {
             before(grammarAccess.getAttrCondAccess().getGroup_2()); 
            // InternalTGG.g:3623:2: ( rule__AttrCond__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=RULE_STRING && LA40_0<=RULE_ID)||LA40_0==42||LA40_0==45||LA40_0==55) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTGG.g:3623:3: rule__AttrCond__Group_2__0
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
    // InternalTGG.g:3631:1: rule__AttrCond__Group__3 : rule__AttrCond__Group__3__Impl ;
    public final void rule__AttrCond__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3635:1: ( rule__AttrCond__Group__3__Impl )
            // InternalTGG.g:3636:2: rule__AttrCond__Group__3__Impl
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
    // InternalTGG.g:3642:1: rule__AttrCond__Group__3__Impl : ( ')' ) ;
    public final void rule__AttrCond__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3646:1: ( ( ')' ) )
            // InternalTGG.g:3647:1: ( ')' )
            {
            // InternalTGG.g:3647:1: ( ')' )
            // InternalTGG.g:3648:2: ')'
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
    // InternalTGG.g:3658:1: rule__AttrCond__Group_2__0 : rule__AttrCond__Group_2__0__Impl rule__AttrCond__Group_2__1 ;
    public final void rule__AttrCond__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3662:1: ( rule__AttrCond__Group_2__0__Impl rule__AttrCond__Group_2__1 )
            // InternalTGG.g:3663:2: rule__AttrCond__Group_2__0__Impl rule__AttrCond__Group_2__1
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
    // InternalTGG.g:3670:1: rule__AttrCond__Group_2__0__Impl : ( ( rule__AttrCond__ValuesAssignment_2_0 ) ) ;
    public final void rule__AttrCond__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3674:1: ( ( ( rule__AttrCond__ValuesAssignment_2_0 ) ) )
            // InternalTGG.g:3675:1: ( ( rule__AttrCond__ValuesAssignment_2_0 ) )
            {
            // InternalTGG.g:3675:1: ( ( rule__AttrCond__ValuesAssignment_2_0 ) )
            // InternalTGG.g:3676:2: ( rule__AttrCond__ValuesAssignment_2_0 )
            {
             before(grammarAccess.getAttrCondAccess().getValuesAssignment_2_0()); 
            // InternalTGG.g:3677:2: ( rule__AttrCond__ValuesAssignment_2_0 )
            // InternalTGG.g:3677:3: rule__AttrCond__ValuesAssignment_2_0
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
    // InternalTGG.g:3685:1: rule__AttrCond__Group_2__1 : rule__AttrCond__Group_2__1__Impl ;
    public final void rule__AttrCond__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3689:1: ( rule__AttrCond__Group_2__1__Impl )
            // InternalTGG.g:3690:2: rule__AttrCond__Group_2__1__Impl
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
    // InternalTGG.g:3696:1: rule__AttrCond__Group_2__1__Impl : ( ( rule__AttrCond__Group_2_1__0 )* ) ;
    public final void rule__AttrCond__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3700:1: ( ( ( rule__AttrCond__Group_2_1__0 )* ) )
            // InternalTGG.g:3701:1: ( ( rule__AttrCond__Group_2_1__0 )* )
            {
            // InternalTGG.g:3701:1: ( ( rule__AttrCond__Group_2_1__0 )* )
            // InternalTGG.g:3702:2: ( rule__AttrCond__Group_2_1__0 )*
            {
             before(grammarAccess.getAttrCondAccess().getGroup_2_1()); 
            // InternalTGG.g:3703:2: ( rule__AttrCond__Group_2_1__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==34) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalTGG.g:3703:3: rule__AttrCond__Group_2_1__0
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
    // InternalTGG.g:3712:1: rule__AttrCond__Group_2_1__0 : rule__AttrCond__Group_2_1__0__Impl rule__AttrCond__Group_2_1__1 ;
    public final void rule__AttrCond__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3716:1: ( rule__AttrCond__Group_2_1__0__Impl rule__AttrCond__Group_2_1__1 )
            // InternalTGG.g:3717:2: rule__AttrCond__Group_2_1__0__Impl rule__AttrCond__Group_2_1__1
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
    // InternalTGG.g:3724:1: rule__AttrCond__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__AttrCond__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3728:1: ( ( ',' ) )
            // InternalTGG.g:3729:1: ( ',' )
            {
            // InternalTGG.g:3729:1: ( ',' )
            // InternalTGG.g:3730:2: ','
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
    // InternalTGG.g:3739:1: rule__AttrCond__Group_2_1__1 : rule__AttrCond__Group_2_1__1__Impl ;
    public final void rule__AttrCond__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3743:1: ( rule__AttrCond__Group_2_1__1__Impl )
            // InternalTGG.g:3744:2: rule__AttrCond__Group_2_1__1__Impl
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
    // InternalTGG.g:3750:1: rule__AttrCond__Group_2_1__1__Impl : ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) ) ;
    public final void rule__AttrCond__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3754:1: ( ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) ) )
            // InternalTGG.g:3755:1: ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) )
            {
            // InternalTGG.g:3755:1: ( ( rule__AttrCond__ValuesAssignment_2_1_1 ) )
            // InternalTGG.g:3756:2: ( rule__AttrCond__ValuesAssignment_2_1_1 )
            {
             before(grammarAccess.getAttrCondAccess().getValuesAssignment_2_1_1()); 
            // InternalTGG.g:3757:2: ( rule__AttrCond__ValuesAssignment_2_1_1 )
            // InternalTGG.g:3757:3: rule__AttrCond__ValuesAssignment_2_1_1
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
    // InternalTGG.g:3766:1: rule__AttrCondDefLibrary__Group__0 : rule__AttrCondDefLibrary__Group__0__Impl rule__AttrCondDefLibrary__Group__1 ;
    public final void rule__AttrCondDefLibrary__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3770:1: ( rule__AttrCondDefLibrary__Group__0__Impl rule__AttrCondDefLibrary__Group__1 )
            // InternalTGG.g:3771:2: rule__AttrCondDefLibrary__Group__0__Impl rule__AttrCondDefLibrary__Group__1
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
    // InternalTGG.g:3778:1: rule__AttrCondDefLibrary__Group__0__Impl : ( '#library' ) ;
    public final void rule__AttrCondDefLibrary__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3782:1: ( ( '#library' ) )
            // InternalTGG.g:3783:1: ( '#library' )
            {
            // InternalTGG.g:3783:1: ( '#library' )
            // InternalTGG.g:3784:2: '#library'
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
    // InternalTGG.g:3793:1: rule__AttrCondDefLibrary__Group__1 : rule__AttrCondDefLibrary__Group__1__Impl rule__AttrCondDefLibrary__Group__2 ;
    public final void rule__AttrCondDefLibrary__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3797:1: ( rule__AttrCondDefLibrary__Group__1__Impl rule__AttrCondDefLibrary__Group__2 )
            // InternalTGG.g:3798:2: rule__AttrCondDefLibrary__Group__1__Impl rule__AttrCondDefLibrary__Group__2
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
    // InternalTGG.g:3805:1: rule__AttrCondDefLibrary__Group__1__Impl : ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) ) ;
    public final void rule__AttrCondDefLibrary__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3809:1: ( ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) ) )
            // InternalTGG.g:3810:1: ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) )
            {
            // InternalTGG.g:3810:1: ( ( rule__AttrCondDefLibrary__NameAssignment_1 ) )
            // InternalTGG.g:3811:2: ( rule__AttrCondDefLibrary__NameAssignment_1 )
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getNameAssignment_1()); 
            // InternalTGG.g:3812:2: ( rule__AttrCondDefLibrary__NameAssignment_1 )
            // InternalTGG.g:3812:3: rule__AttrCondDefLibrary__NameAssignment_1
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
    // InternalTGG.g:3820:1: rule__AttrCondDefLibrary__Group__2 : rule__AttrCondDefLibrary__Group__2__Impl ;
    public final void rule__AttrCondDefLibrary__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3824:1: ( rule__AttrCondDefLibrary__Group__2__Impl )
            // InternalTGG.g:3825:2: rule__AttrCondDefLibrary__Group__2__Impl
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
    // InternalTGG.g:3831:1: rule__AttrCondDefLibrary__Group__2__Impl : ( ( rule__AttrCondDefLibrary__Group_2__0 )? ) ;
    public final void rule__AttrCondDefLibrary__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3835:1: ( ( ( rule__AttrCondDefLibrary__Group_2__0 )? ) )
            // InternalTGG.g:3836:1: ( ( rule__AttrCondDefLibrary__Group_2__0 )? )
            {
            // InternalTGG.g:3836:1: ( ( rule__AttrCondDefLibrary__Group_2__0 )? )
            // InternalTGG.g:3837:2: ( rule__AttrCondDefLibrary__Group_2__0 )?
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getGroup_2()); 
            // InternalTGG.g:3838:2: ( rule__AttrCondDefLibrary__Group_2__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==23) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalTGG.g:3838:3: rule__AttrCondDefLibrary__Group_2__0
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
    // InternalTGG.g:3847:1: rule__AttrCondDefLibrary__Group_2__0 : rule__AttrCondDefLibrary__Group_2__0__Impl rule__AttrCondDefLibrary__Group_2__1 ;
    public final void rule__AttrCondDefLibrary__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3851:1: ( rule__AttrCondDefLibrary__Group_2__0__Impl rule__AttrCondDefLibrary__Group_2__1 )
            // InternalTGG.g:3852:2: rule__AttrCondDefLibrary__Group_2__0__Impl rule__AttrCondDefLibrary__Group_2__1
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
    // InternalTGG.g:3859:1: rule__AttrCondDefLibrary__Group_2__0__Impl : ( '{' ) ;
    public final void rule__AttrCondDefLibrary__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3863:1: ( ( '{' ) )
            // InternalTGG.g:3864:1: ( '{' )
            {
            // InternalTGG.g:3864:1: ( '{' )
            // InternalTGG.g:3865:2: '{'
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
    // InternalTGG.g:3874:1: rule__AttrCondDefLibrary__Group_2__1 : rule__AttrCondDefLibrary__Group_2__1__Impl rule__AttrCondDefLibrary__Group_2__2 ;
    public final void rule__AttrCondDefLibrary__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3878:1: ( rule__AttrCondDefLibrary__Group_2__1__Impl rule__AttrCondDefLibrary__Group_2__2 )
            // InternalTGG.g:3879:2: rule__AttrCondDefLibrary__Group_2__1__Impl rule__AttrCondDefLibrary__Group_2__2
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
    // InternalTGG.g:3886:1: rule__AttrCondDefLibrary__Group_2__1__Impl : ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* ) ;
    public final void rule__AttrCondDefLibrary__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3890:1: ( ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* ) )
            // InternalTGG.g:3891:1: ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* )
            {
            // InternalTGG.g:3891:1: ( ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )* )
            // InternalTGG.g:3892:2: ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )*
            {
             before(grammarAccess.getAttrCondDefLibraryAccess().getAttributeCondDefsAssignment_2_1()); 
            // InternalTGG.g:3893:2: ( rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==52) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalTGG.g:3893:3: rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1
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
    // InternalTGG.g:3901:1: rule__AttrCondDefLibrary__Group_2__2 : rule__AttrCondDefLibrary__Group_2__2__Impl ;
    public final void rule__AttrCondDefLibrary__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3905:1: ( rule__AttrCondDefLibrary__Group_2__2__Impl )
            // InternalTGG.g:3906:2: rule__AttrCondDefLibrary__Group_2__2__Impl
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
    // InternalTGG.g:3912:1: rule__AttrCondDefLibrary__Group_2__2__Impl : ( '}' ) ;
    public final void rule__AttrCondDefLibrary__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3916:1: ( ( '}' ) )
            // InternalTGG.g:3917:1: ( '}' )
            {
            // InternalTGG.g:3917:1: ( '}' )
            // InternalTGG.g:3918:2: '}'
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
    // InternalTGG.g:3928:1: rule__Adornment__Group__0 : rule__Adornment__Group__0__Impl rule__Adornment__Group__1 ;
    public final void rule__Adornment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3932:1: ( rule__Adornment__Group__0__Impl rule__Adornment__Group__1 )
            // InternalTGG.g:3933:2: rule__Adornment__Group__0__Impl rule__Adornment__Group__1
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
    // InternalTGG.g:3940:1: rule__Adornment__Group__0__Impl : ( '[' ) ;
    public final void rule__Adornment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3944:1: ( ( '[' ) )
            // InternalTGG.g:3945:1: ( '[' )
            {
            // InternalTGG.g:3945:1: ( '[' )
            // InternalTGG.g:3946:2: '['
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
    // InternalTGG.g:3955:1: rule__Adornment__Group__1 : rule__Adornment__Group__1__Impl rule__Adornment__Group__2 ;
    public final void rule__Adornment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3959:1: ( rule__Adornment__Group__1__Impl rule__Adornment__Group__2 )
            // InternalTGG.g:3960:2: rule__Adornment__Group__1__Impl rule__Adornment__Group__2
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
    // InternalTGG.g:3967:1: rule__Adornment__Group__1__Impl : ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) ) ;
    public final void rule__Adornment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3971:1: ( ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) ) )
            // InternalTGG.g:3972:1: ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) )
            {
            // InternalTGG.g:3972:1: ( ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* ) )
            // InternalTGG.g:3973:2: ( ( rule__Adornment__ValueAssignment_1 ) ) ( ( rule__Adornment__ValueAssignment_1 )* )
            {
            // InternalTGG.g:3973:2: ( ( rule__Adornment__ValueAssignment_1 ) )
            // InternalTGG.g:3974:3: ( rule__Adornment__ValueAssignment_1 )
            {
             before(grammarAccess.getAdornmentAccess().getValueAssignment_1()); 
            // InternalTGG.g:3975:3: ( rule__Adornment__ValueAssignment_1 )
            // InternalTGG.g:3975:4: rule__Adornment__ValueAssignment_1
            {
            pushFollow(FOLLOW_35);
            rule__Adornment__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getAdornmentAccess().getValueAssignment_1()); 

            }

            // InternalTGG.g:3978:2: ( ( rule__Adornment__ValueAssignment_1 )* )
            // InternalTGG.g:3979:3: ( rule__Adornment__ValueAssignment_1 )*
            {
             before(grammarAccess.getAdornmentAccess().getValueAssignment_1()); 
            // InternalTGG.g:3980:3: ( rule__Adornment__ValueAssignment_1 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( ((LA44_0>=13 && LA44_0<=14)) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalTGG.g:3980:4: rule__Adornment__ValueAssignment_1
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
    // InternalTGG.g:3989:1: rule__Adornment__Group__2 : rule__Adornment__Group__2__Impl ;
    public final void rule__Adornment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:3993:1: ( rule__Adornment__Group__2__Impl )
            // InternalTGG.g:3994:2: rule__Adornment__Group__2__Impl
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
    // InternalTGG.g:4000:1: rule__Adornment__Group__2__Impl : ( ']' ) ;
    public final void rule__Adornment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4004:1: ( ( ']' ) )
            // InternalTGG.g:4005:1: ( ']' )
            {
            // InternalTGG.g:4005:1: ( ']' )
            // InternalTGG.g:4006:2: ']'
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
    // InternalTGG.g:4016:1: rule__CorrVariablePattern__Group__0 : rule__CorrVariablePattern__Group__0__Impl rule__CorrVariablePattern__Group__1 ;
    public final void rule__CorrVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4020:1: ( rule__CorrVariablePattern__Group__0__Impl rule__CorrVariablePattern__Group__1 )
            // InternalTGG.g:4021:2: rule__CorrVariablePattern__Group__0__Impl rule__CorrVariablePattern__Group__1
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
    // InternalTGG.g:4028:1: rule__CorrVariablePattern__Group__0__Impl : ( ( rule__CorrVariablePattern__OpAssignment_0 )? ) ;
    public final void rule__CorrVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4032:1: ( ( ( rule__CorrVariablePattern__OpAssignment_0 )? ) )
            // InternalTGG.g:4033:1: ( ( rule__CorrVariablePattern__OpAssignment_0 )? )
            {
            // InternalTGG.g:4033:1: ( ( rule__CorrVariablePattern__OpAssignment_0 )? )
            // InternalTGG.g:4034:2: ( rule__CorrVariablePattern__OpAssignment_0 )?
            {
             before(grammarAccess.getCorrVariablePatternAccess().getOpAssignment_0()); 
            // InternalTGG.g:4035:2: ( rule__CorrVariablePattern__OpAssignment_0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==56) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTGG.g:4035:3: rule__CorrVariablePattern__OpAssignment_0
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
    // InternalTGG.g:4043:1: rule__CorrVariablePattern__Group__1 : rule__CorrVariablePattern__Group__1__Impl rule__CorrVariablePattern__Group__2 ;
    public final void rule__CorrVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4047:1: ( rule__CorrVariablePattern__Group__1__Impl rule__CorrVariablePattern__Group__2 )
            // InternalTGG.g:4048:2: rule__CorrVariablePattern__Group__1__Impl rule__CorrVariablePattern__Group__2
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
    // InternalTGG.g:4055:1: rule__CorrVariablePattern__Group__1__Impl : ( ( rule__CorrVariablePattern__NameAssignment_1 ) ) ;
    public final void rule__CorrVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4059:1: ( ( ( rule__CorrVariablePattern__NameAssignment_1 ) ) )
            // InternalTGG.g:4060:1: ( ( rule__CorrVariablePattern__NameAssignment_1 ) )
            {
            // InternalTGG.g:4060:1: ( ( rule__CorrVariablePattern__NameAssignment_1 ) )
            // InternalTGG.g:4061:2: ( rule__CorrVariablePattern__NameAssignment_1 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getNameAssignment_1()); 
            // InternalTGG.g:4062:2: ( rule__CorrVariablePattern__NameAssignment_1 )
            // InternalTGG.g:4062:3: rule__CorrVariablePattern__NameAssignment_1
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
    // InternalTGG.g:4070:1: rule__CorrVariablePattern__Group__2 : rule__CorrVariablePattern__Group__2__Impl rule__CorrVariablePattern__Group__3 ;
    public final void rule__CorrVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4074:1: ( rule__CorrVariablePattern__Group__2__Impl rule__CorrVariablePattern__Group__3 )
            // InternalTGG.g:4075:2: rule__CorrVariablePattern__Group__2__Impl rule__CorrVariablePattern__Group__3
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
    // InternalTGG.g:4082:1: rule__CorrVariablePattern__Group__2__Impl : ( ':' ) ;
    public final void rule__CorrVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4086:1: ( ( ':' ) )
            // InternalTGG.g:4087:1: ( ':' )
            {
            // InternalTGG.g:4087:1: ( ':' )
            // InternalTGG.g:4088:2: ':'
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
    // InternalTGG.g:4097:1: rule__CorrVariablePattern__Group__3 : rule__CorrVariablePattern__Group__3__Impl rule__CorrVariablePattern__Group__4 ;
    public final void rule__CorrVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4101:1: ( rule__CorrVariablePattern__Group__3__Impl rule__CorrVariablePattern__Group__4 )
            // InternalTGG.g:4102:2: rule__CorrVariablePattern__Group__3__Impl rule__CorrVariablePattern__Group__4
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
    // InternalTGG.g:4109:1: rule__CorrVariablePattern__Group__3__Impl : ( ( rule__CorrVariablePattern__TypeAssignment_3 ) ) ;
    public final void rule__CorrVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4113:1: ( ( ( rule__CorrVariablePattern__TypeAssignment_3 ) ) )
            // InternalTGG.g:4114:1: ( ( rule__CorrVariablePattern__TypeAssignment_3 ) )
            {
            // InternalTGG.g:4114:1: ( ( rule__CorrVariablePattern__TypeAssignment_3 ) )
            // InternalTGG.g:4115:2: ( rule__CorrVariablePattern__TypeAssignment_3 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTypeAssignment_3()); 
            // InternalTGG.g:4116:2: ( rule__CorrVariablePattern__TypeAssignment_3 )
            // InternalTGG.g:4116:3: rule__CorrVariablePattern__TypeAssignment_3
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
    // InternalTGG.g:4124:1: rule__CorrVariablePattern__Group__4 : rule__CorrVariablePattern__Group__4__Impl rule__CorrVariablePattern__Group__5 ;
    public final void rule__CorrVariablePattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4128:1: ( rule__CorrVariablePattern__Group__4__Impl rule__CorrVariablePattern__Group__5 )
            // InternalTGG.g:4129:2: rule__CorrVariablePattern__Group__4__Impl rule__CorrVariablePattern__Group__5
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
    // InternalTGG.g:4136:1: rule__CorrVariablePattern__Group__4__Impl : ( '{' ) ;
    public final void rule__CorrVariablePattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4140:1: ( ( '{' ) )
            // InternalTGG.g:4141:1: ( '{' )
            {
            // InternalTGG.g:4141:1: ( '{' )
            // InternalTGG.g:4142:2: '{'
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
    // InternalTGG.g:4151:1: rule__CorrVariablePattern__Group__5 : rule__CorrVariablePattern__Group__5__Impl rule__CorrVariablePattern__Group__6 ;
    public final void rule__CorrVariablePattern__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4155:1: ( rule__CorrVariablePattern__Group__5__Impl rule__CorrVariablePattern__Group__6 )
            // InternalTGG.g:4156:2: rule__CorrVariablePattern__Group__5__Impl rule__CorrVariablePattern__Group__6
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
    // InternalTGG.g:4163:1: rule__CorrVariablePattern__Group__5__Impl : ( '#src->' ) ;
    public final void rule__CorrVariablePattern__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4167:1: ( ( '#src->' ) )
            // InternalTGG.g:4168:1: ( '#src->' )
            {
            // InternalTGG.g:4168:1: ( '#src->' )
            // InternalTGG.g:4169:2: '#src->'
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
    // InternalTGG.g:4178:1: rule__CorrVariablePattern__Group__6 : rule__CorrVariablePattern__Group__6__Impl rule__CorrVariablePattern__Group__7 ;
    public final void rule__CorrVariablePattern__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4182:1: ( rule__CorrVariablePattern__Group__6__Impl rule__CorrVariablePattern__Group__7 )
            // InternalTGG.g:4183:2: rule__CorrVariablePattern__Group__6__Impl rule__CorrVariablePattern__Group__7
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
    // InternalTGG.g:4190:1: rule__CorrVariablePattern__Group__6__Impl : ( ( rule__CorrVariablePattern__SourceAssignment_6 ) ) ;
    public final void rule__CorrVariablePattern__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4194:1: ( ( ( rule__CorrVariablePattern__SourceAssignment_6 ) ) )
            // InternalTGG.g:4195:1: ( ( rule__CorrVariablePattern__SourceAssignment_6 ) )
            {
            // InternalTGG.g:4195:1: ( ( rule__CorrVariablePattern__SourceAssignment_6 ) )
            // InternalTGG.g:4196:2: ( rule__CorrVariablePattern__SourceAssignment_6 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getSourceAssignment_6()); 
            // InternalTGG.g:4197:2: ( rule__CorrVariablePattern__SourceAssignment_6 )
            // InternalTGG.g:4197:3: rule__CorrVariablePattern__SourceAssignment_6
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
    // InternalTGG.g:4205:1: rule__CorrVariablePattern__Group__7 : rule__CorrVariablePattern__Group__7__Impl rule__CorrVariablePattern__Group__8 ;
    public final void rule__CorrVariablePattern__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4209:1: ( rule__CorrVariablePattern__Group__7__Impl rule__CorrVariablePattern__Group__8 )
            // InternalTGG.g:4210:2: rule__CorrVariablePattern__Group__7__Impl rule__CorrVariablePattern__Group__8
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
    // InternalTGG.g:4217:1: rule__CorrVariablePattern__Group__7__Impl : ( '#trg->' ) ;
    public final void rule__CorrVariablePattern__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4221:1: ( ( '#trg->' ) )
            // InternalTGG.g:4222:1: ( '#trg->' )
            {
            // InternalTGG.g:4222:1: ( '#trg->' )
            // InternalTGG.g:4223:2: '#trg->'
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
    // InternalTGG.g:4232:1: rule__CorrVariablePattern__Group__8 : rule__CorrVariablePattern__Group__8__Impl rule__CorrVariablePattern__Group__9 ;
    public final void rule__CorrVariablePattern__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4236:1: ( rule__CorrVariablePattern__Group__8__Impl rule__CorrVariablePattern__Group__9 )
            // InternalTGG.g:4237:2: rule__CorrVariablePattern__Group__8__Impl rule__CorrVariablePattern__Group__9
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
    // InternalTGG.g:4244:1: rule__CorrVariablePattern__Group__8__Impl : ( ( rule__CorrVariablePattern__TargetAssignment_8 ) ) ;
    public final void rule__CorrVariablePattern__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4248:1: ( ( ( rule__CorrVariablePattern__TargetAssignment_8 ) ) )
            // InternalTGG.g:4249:1: ( ( rule__CorrVariablePattern__TargetAssignment_8 ) )
            {
            // InternalTGG.g:4249:1: ( ( rule__CorrVariablePattern__TargetAssignment_8 ) )
            // InternalTGG.g:4250:2: ( rule__CorrVariablePattern__TargetAssignment_8 )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTargetAssignment_8()); 
            // InternalTGG.g:4251:2: ( rule__CorrVariablePattern__TargetAssignment_8 )
            // InternalTGG.g:4251:3: rule__CorrVariablePattern__TargetAssignment_8
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
    // InternalTGG.g:4259:1: rule__CorrVariablePattern__Group__9 : rule__CorrVariablePattern__Group__9__Impl ;
    public final void rule__CorrVariablePattern__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4263:1: ( rule__CorrVariablePattern__Group__9__Impl )
            // InternalTGG.g:4264:2: rule__CorrVariablePattern__Group__9__Impl
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
    // InternalTGG.g:4270:1: rule__CorrVariablePattern__Group__9__Impl : ( '}' ) ;
    public final void rule__CorrVariablePattern__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4274:1: ( ( '}' ) )
            // InternalTGG.g:4275:1: ( '}' )
            {
            // InternalTGG.g:4275:1: ( '}' )
            // InternalTGG.g:4276:2: '}'
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
    // InternalTGG.g:4286:1: rule__ObjectVariablePattern__Group__0 : rule__ObjectVariablePattern__Group__0__Impl rule__ObjectVariablePattern__Group__1 ;
    public final void rule__ObjectVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4290:1: ( rule__ObjectVariablePattern__Group__0__Impl rule__ObjectVariablePattern__Group__1 )
            // InternalTGG.g:4291:2: rule__ObjectVariablePattern__Group__0__Impl rule__ObjectVariablePattern__Group__1
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
    // InternalTGG.g:4298:1: rule__ObjectVariablePattern__Group__0__Impl : ( ( rule__ObjectVariablePattern__OpAssignment_0 )? ) ;
    public final void rule__ObjectVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4302:1: ( ( ( rule__ObjectVariablePattern__OpAssignment_0 )? ) )
            // InternalTGG.g:4303:1: ( ( rule__ObjectVariablePattern__OpAssignment_0 )? )
            {
            // InternalTGG.g:4303:1: ( ( rule__ObjectVariablePattern__OpAssignment_0 )? )
            // InternalTGG.g:4304:2: ( rule__ObjectVariablePattern__OpAssignment_0 )?
            {
             before(grammarAccess.getObjectVariablePatternAccess().getOpAssignment_0()); 
            // InternalTGG.g:4305:2: ( rule__ObjectVariablePattern__OpAssignment_0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==56) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalTGG.g:4305:3: rule__ObjectVariablePattern__OpAssignment_0
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
    // InternalTGG.g:4313:1: rule__ObjectVariablePattern__Group__1 : rule__ObjectVariablePattern__Group__1__Impl rule__ObjectVariablePattern__Group__2 ;
    public final void rule__ObjectVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4317:1: ( rule__ObjectVariablePattern__Group__1__Impl rule__ObjectVariablePattern__Group__2 )
            // InternalTGG.g:4318:2: rule__ObjectVariablePattern__Group__1__Impl rule__ObjectVariablePattern__Group__2
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
    // InternalTGG.g:4325:1: rule__ObjectVariablePattern__Group__1__Impl : ( ( rule__ObjectVariablePattern__NameAssignment_1 ) ) ;
    public final void rule__ObjectVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4329:1: ( ( ( rule__ObjectVariablePattern__NameAssignment_1 ) ) )
            // InternalTGG.g:4330:1: ( ( rule__ObjectVariablePattern__NameAssignment_1 ) )
            {
            // InternalTGG.g:4330:1: ( ( rule__ObjectVariablePattern__NameAssignment_1 ) )
            // InternalTGG.g:4331:2: ( rule__ObjectVariablePattern__NameAssignment_1 )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getNameAssignment_1()); 
            // InternalTGG.g:4332:2: ( rule__ObjectVariablePattern__NameAssignment_1 )
            // InternalTGG.g:4332:3: rule__ObjectVariablePattern__NameAssignment_1
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
    // InternalTGG.g:4340:1: rule__ObjectVariablePattern__Group__2 : rule__ObjectVariablePattern__Group__2__Impl rule__ObjectVariablePattern__Group__3 ;
    public final void rule__ObjectVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4344:1: ( rule__ObjectVariablePattern__Group__2__Impl rule__ObjectVariablePattern__Group__3 )
            // InternalTGG.g:4345:2: rule__ObjectVariablePattern__Group__2__Impl rule__ObjectVariablePattern__Group__3
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
    // InternalTGG.g:4352:1: rule__ObjectVariablePattern__Group__2__Impl : ( ':' ) ;
    public final void rule__ObjectVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4356:1: ( ( ':' ) )
            // InternalTGG.g:4357:1: ( ':' )
            {
            // InternalTGG.g:4357:1: ( ':' )
            // InternalTGG.g:4358:2: ':'
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
    // InternalTGG.g:4367:1: rule__ObjectVariablePattern__Group__3 : rule__ObjectVariablePattern__Group__3__Impl rule__ObjectVariablePattern__Group__4 ;
    public final void rule__ObjectVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4371:1: ( rule__ObjectVariablePattern__Group__3__Impl rule__ObjectVariablePattern__Group__4 )
            // InternalTGG.g:4372:2: rule__ObjectVariablePattern__Group__3__Impl rule__ObjectVariablePattern__Group__4
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
    // InternalTGG.g:4379:1: rule__ObjectVariablePattern__Group__3__Impl : ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) ) ;
    public final void rule__ObjectVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4383:1: ( ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) ) )
            // InternalTGG.g:4384:1: ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) )
            {
            // InternalTGG.g:4384:1: ( ( rule__ObjectVariablePattern__TypeAssignment_3 ) )
            // InternalTGG.g:4385:2: ( rule__ObjectVariablePattern__TypeAssignment_3 )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getTypeAssignment_3()); 
            // InternalTGG.g:4386:2: ( rule__ObjectVariablePattern__TypeAssignment_3 )
            // InternalTGG.g:4386:3: rule__ObjectVariablePattern__TypeAssignment_3
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
    // InternalTGG.g:4394:1: rule__ObjectVariablePattern__Group__4 : rule__ObjectVariablePattern__Group__4__Impl ;
    public final void rule__ObjectVariablePattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4398:1: ( rule__ObjectVariablePattern__Group__4__Impl )
            // InternalTGG.g:4399:2: rule__ObjectVariablePattern__Group__4__Impl
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
    // InternalTGG.g:4405:1: rule__ObjectVariablePattern__Group__4__Impl : ( ( rule__ObjectVariablePattern__Group_4__0 )? ) ;
    public final void rule__ObjectVariablePattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4409:1: ( ( ( rule__ObjectVariablePattern__Group_4__0 )? ) )
            // InternalTGG.g:4410:1: ( ( rule__ObjectVariablePattern__Group_4__0 )? )
            {
            // InternalTGG.g:4410:1: ( ( rule__ObjectVariablePattern__Group_4__0 )? )
            // InternalTGG.g:4411:2: ( rule__ObjectVariablePattern__Group_4__0 )?
            {
             before(grammarAccess.getObjectVariablePatternAccess().getGroup_4()); 
            // InternalTGG.g:4412:2: ( rule__ObjectVariablePattern__Group_4__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==23) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTGG.g:4412:3: rule__ObjectVariablePattern__Group_4__0
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
    // InternalTGG.g:4421:1: rule__ObjectVariablePattern__Group_4__0 : rule__ObjectVariablePattern__Group_4__0__Impl rule__ObjectVariablePattern__Group_4__1 ;
    public final void rule__ObjectVariablePattern__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4425:1: ( rule__ObjectVariablePattern__Group_4__0__Impl rule__ObjectVariablePattern__Group_4__1 )
            // InternalTGG.g:4426:2: rule__ObjectVariablePattern__Group_4__0__Impl rule__ObjectVariablePattern__Group_4__1
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
    // InternalTGG.g:4433:1: rule__ObjectVariablePattern__Group_4__0__Impl : ( '{' ) ;
    public final void rule__ObjectVariablePattern__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4437:1: ( ( '{' ) )
            // InternalTGG.g:4438:1: ( '{' )
            {
            // InternalTGG.g:4438:1: ( '{' )
            // InternalTGG.g:4439:2: '{'
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
    // InternalTGG.g:4448:1: rule__ObjectVariablePattern__Group_4__1 : rule__ObjectVariablePattern__Group_4__1__Impl rule__ObjectVariablePattern__Group_4__2 ;
    public final void rule__ObjectVariablePattern__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4452:1: ( rule__ObjectVariablePattern__Group_4__1__Impl rule__ObjectVariablePattern__Group_4__2 )
            // InternalTGG.g:4453:2: rule__ObjectVariablePattern__Group_4__1__Impl rule__ObjectVariablePattern__Group_4__2
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
    // InternalTGG.g:4460:1: rule__ObjectVariablePattern__Group_4__1__Impl : ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* ) ;
    public final void rule__ObjectVariablePattern__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4464:1: ( ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* ) )
            // InternalTGG.g:4465:1: ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* )
            {
            // InternalTGG.g:4465:1: ( ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )* )
            // InternalTGG.g:4466:2: ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )*
            {
             before(grammarAccess.getObjectVariablePatternAccess().getAttributeAssignmentsAssignment_4_1()); 
            // InternalTGG.g:4467:2: ( rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 )*
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
            	    // InternalTGG.g:4467:3: rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1
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
    // InternalTGG.g:4475:1: rule__ObjectVariablePattern__Group_4__2 : rule__ObjectVariablePattern__Group_4__2__Impl rule__ObjectVariablePattern__Group_4__3 ;
    public final void rule__ObjectVariablePattern__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4479:1: ( rule__ObjectVariablePattern__Group_4__2__Impl rule__ObjectVariablePattern__Group_4__3 )
            // InternalTGG.g:4480:2: rule__ObjectVariablePattern__Group_4__2__Impl rule__ObjectVariablePattern__Group_4__3
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
    // InternalTGG.g:4487:1: rule__ObjectVariablePattern__Group_4__2__Impl : ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* ) ;
    public final void rule__ObjectVariablePattern__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4491:1: ( ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* ) )
            // InternalTGG.g:4492:1: ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* )
            {
            // InternalTGG.g:4492:1: ( ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )* )
            // InternalTGG.g:4493:2: ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )*
            {
             before(grammarAccess.getObjectVariablePatternAccess().getAttributeConstraintsAssignment_4_2()); 
            // InternalTGG.g:4494:2: ( rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalTGG.g:4494:3: rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2
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
    // InternalTGG.g:4502:1: rule__ObjectVariablePattern__Group_4__3 : rule__ObjectVariablePattern__Group_4__3__Impl rule__ObjectVariablePattern__Group_4__4 ;
    public final void rule__ObjectVariablePattern__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4506:1: ( rule__ObjectVariablePattern__Group_4__3__Impl rule__ObjectVariablePattern__Group_4__4 )
            // InternalTGG.g:4507:2: rule__ObjectVariablePattern__Group_4__3__Impl rule__ObjectVariablePattern__Group_4__4
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
    // InternalTGG.g:4514:1: rule__ObjectVariablePattern__Group_4__3__Impl : ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* ) ;
    public final void rule__ObjectVariablePattern__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4518:1: ( ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* ) )
            // InternalTGG.g:4519:1: ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* )
            {
            // InternalTGG.g:4519:1: ( ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )* )
            // InternalTGG.g:4520:2: ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )*
            {
             before(grammarAccess.getObjectVariablePatternAccess().getLinkVariablePatternsAssignment_4_3()); 
            // InternalTGG.g:4521:2: ( rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==45||LA50_0==56) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalTGG.g:4521:3: rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3
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
    // InternalTGG.g:4529:1: rule__ObjectVariablePattern__Group_4__4 : rule__ObjectVariablePattern__Group_4__4__Impl ;
    public final void rule__ObjectVariablePattern__Group_4__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4533:1: ( rule__ObjectVariablePattern__Group_4__4__Impl )
            // InternalTGG.g:4534:2: rule__ObjectVariablePattern__Group_4__4__Impl
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
    // InternalTGG.g:4540:1: rule__ObjectVariablePattern__Group_4__4__Impl : ( '}' ) ;
    public final void rule__ObjectVariablePattern__Group_4__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4544:1: ( ( '}' ) )
            // InternalTGG.g:4545:1: ( '}' )
            {
            // InternalTGG.g:4545:1: ( '}' )
            // InternalTGG.g:4546:2: '}'
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
    // InternalTGG.g:4556:1: rule__ContextObjectVariablePattern__Group__0 : rule__ContextObjectVariablePattern__Group__0__Impl rule__ContextObjectVariablePattern__Group__1 ;
    public final void rule__ContextObjectVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4560:1: ( rule__ContextObjectVariablePattern__Group__0__Impl rule__ContextObjectVariablePattern__Group__1 )
            // InternalTGG.g:4561:2: rule__ContextObjectVariablePattern__Group__0__Impl rule__ContextObjectVariablePattern__Group__1
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
    // InternalTGG.g:4568:1: rule__ContextObjectVariablePattern__Group__0__Impl : ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) ) ;
    public final void rule__ContextObjectVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4572:1: ( ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) ) )
            // InternalTGG.g:4573:1: ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) )
            {
            // InternalTGG.g:4573:1: ( ( rule__ContextObjectVariablePattern__NameAssignment_0 ) )
            // InternalTGG.g:4574:2: ( rule__ContextObjectVariablePattern__NameAssignment_0 )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getNameAssignment_0()); 
            // InternalTGG.g:4575:2: ( rule__ContextObjectVariablePattern__NameAssignment_0 )
            // InternalTGG.g:4575:3: rule__ContextObjectVariablePattern__NameAssignment_0
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
    // InternalTGG.g:4583:1: rule__ContextObjectVariablePattern__Group__1 : rule__ContextObjectVariablePattern__Group__1__Impl rule__ContextObjectVariablePattern__Group__2 ;
    public final void rule__ContextObjectVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4587:1: ( rule__ContextObjectVariablePattern__Group__1__Impl rule__ContextObjectVariablePattern__Group__2 )
            // InternalTGG.g:4588:2: rule__ContextObjectVariablePattern__Group__1__Impl rule__ContextObjectVariablePattern__Group__2
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
    // InternalTGG.g:4595:1: rule__ContextObjectVariablePattern__Group__1__Impl : ( ':' ) ;
    public final void rule__ContextObjectVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4599:1: ( ( ':' ) )
            // InternalTGG.g:4600:1: ( ':' )
            {
            // InternalTGG.g:4600:1: ( ':' )
            // InternalTGG.g:4601:2: ':'
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
    // InternalTGG.g:4610:1: rule__ContextObjectVariablePattern__Group__2 : rule__ContextObjectVariablePattern__Group__2__Impl rule__ContextObjectVariablePattern__Group__3 ;
    public final void rule__ContextObjectVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4614:1: ( rule__ContextObjectVariablePattern__Group__2__Impl rule__ContextObjectVariablePattern__Group__3 )
            // InternalTGG.g:4615:2: rule__ContextObjectVariablePattern__Group__2__Impl rule__ContextObjectVariablePattern__Group__3
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
    // InternalTGG.g:4622:1: rule__ContextObjectVariablePattern__Group__2__Impl : ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) ) ;
    public final void rule__ContextObjectVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4626:1: ( ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) ) )
            // InternalTGG.g:4627:1: ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) )
            {
            // InternalTGG.g:4627:1: ( ( rule__ContextObjectVariablePattern__TypeAssignment_2 ) )
            // InternalTGG.g:4628:2: ( rule__ContextObjectVariablePattern__TypeAssignment_2 )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getTypeAssignment_2()); 
            // InternalTGG.g:4629:2: ( rule__ContextObjectVariablePattern__TypeAssignment_2 )
            // InternalTGG.g:4629:3: rule__ContextObjectVariablePattern__TypeAssignment_2
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
    // InternalTGG.g:4637:1: rule__ContextObjectVariablePattern__Group__3 : rule__ContextObjectVariablePattern__Group__3__Impl ;
    public final void rule__ContextObjectVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4641:1: ( rule__ContextObjectVariablePattern__Group__3__Impl )
            // InternalTGG.g:4642:2: rule__ContextObjectVariablePattern__Group__3__Impl
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
    // InternalTGG.g:4648:1: rule__ContextObjectVariablePattern__Group__3__Impl : ( ( rule__ContextObjectVariablePattern__Group_3__0 )? ) ;
    public final void rule__ContextObjectVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4652:1: ( ( ( rule__ContextObjectVariablePattern__Group_3__0 )? ) )
            // InternalTGG.g:4653:1: ( ( rule__ContextObjectVariablePattern__Group_3__0 )? )
            {
            // InternalTGG.g:4653:1: ( ( rule__ContextObjectVariablePattern__Group_3__0 )? )
            // InternalTGG.g:4654:2: ( rule__ContextObjectVariablePattern__Group_3__0 )?
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getGroup_3()); 
            // InternalTGG.g:4655:2: ( rule__ContextObjectVariablePattern__Group_3__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==23) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalTGG.g:4655:3: rule__ContextObjectVariablePattern__Group_3__0
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
    // InternalTGG.g:4664:1: rule__ContextObjectVariablePattern__Group_3__0 : rule__ContextObjectVariablePattern__Group_3__0__Impl rule__ContextObjectVariablePattern__Group_3__1 ;
    public final void rule__ContextObjectVariablePattern__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4668:1: ( rule__ContextObjectVariablePattern__Group_3__0__Impl rule__ContextObjectVariablePattern__Group_3__1 )
            // InternalTGG.g:4669:2: rule__ContextObjectVariablePattern__Group_3__0__Impl rule__ContextObjectVariablePattern__Group_3__1
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
    // InternalTGG.g:4676:1: rule__ContextObjectVariablePattern__Group_3__0__Impl : ( '{' ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4680:1: ( ( '{' ) )
            // InternalTGG.g:4681:1: ( '{' )
            {
            // InternalTGG.g:4681:1: ( '{' )
            // InternalTGG.g:4682:2: '{'
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
    // InternalTGG.g:4691:1: rule__ContextObjectVariablePattern__Group_3__1 : rule__ContextObjectVariablePattern__Group_3__1__Impl rule__ContextObjectVariablePattern__Group_3__2 ;
    public final void rule__ContextObjectVariablePattern__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4695:1: ( rule__ContextObjectVariablePattern__Group_3__1__Impl rule__ContextObjectVariablePattern__Group_3__2 )
            // InternalTGG.g:4696:2: rule__ContextObjectVariablePattern__Group_3__1__Impl rule__ContextObjectVariablePattern__Group_3__2
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
    // InternalTGG.g:4703:1: rule__ContextObjectVariablePattern__Group_3__1__Impl : ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4707:1: ( ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* ) )
            // InternalTGG.g:4708:1: ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* )
            {
            // InternalTGG.g:4708:1: ( ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )* )
            // InternalTGG.g:4709:2: ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )*
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getAttributeConstraintsAssignment_3_1()); 
            // InternalTGG.g:4710:2: ( rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalTGG.g:4710:3: rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1
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
    // InternalTGG.g:4718:1: rule__ContextObjectVariablePattern__Group_3__2 : rule__ContextObjectVariablePattern__Group_3__2__Impl rule__ContextObjectVariablePattern__Group_3__3 ;
    public final void rule__ContextObjectVariablePattern__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4722:1: ( rule__ContextObjectVariablePattern__Group_3__2__Impl rule__ContextObjectVariablePattern__Group_3__3 )
            // InternalTGG.g:4723:2: rule__ContextObjectVariablePattern__Group_3__2__Impl rule__ContextObjectVariablePattern__Group_3__3
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
    // InternalTGG.g:4730:1: rule__ContextObjectVariablePattern__Group_3__2__Impl : ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4734:1: ( ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* ) )
            // InternalTGG.g:4735:1: ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* )
            {
            // InternalTGG.g:4735:1: ( ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )* )
            // InternalTGG.g:4736:2: ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )*
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getLinkVariablePatternsAssignment_3_2()); 
            // InternalTGG.g:4737:2: ( rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==45) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalTGG.g:4737:3: rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2
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
    // InternalTGG.g:4745:1: rule__ContextObjectVariablePattern__Group_3__3 : rule__ContextObjectVariablePattern__Group_3__3__Impl ;
    public final void rule__ContextObjectVariablePattern__Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4749:1: ( rule__ContextObjectVariablePattern__Group_3__3__Impl )
            // InternalTGG.g:4750:2: rule__ContextObjectVariablePattern__Group_3__3__Impl
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
    // InternalTGG.g:4756:1: rule__ContextObjectVariablePattern__Group_3__3__Impl : ( '}' ) ;
    public final void rule__ContextObjectVariablePattern__Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4760:1: ( ( '}' ) )
            // InternalTGG.g:4761:1: ( '}' )
            {
            // InternalTGG.g:4761:1: ( '}' )
            // InternalTGG.g:4762:2: '}'
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
    // InternalTGG.g:4772:1: rule__AttributeConstraint__Group__0 : rule__AttributeConstraint__Group__0__Impl rule__AttributeConstraint__Group__1 ;
    public final void rule__AttributeConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4776:1: ( rule__AttributeConstraint__Group__0__Impl rule__AttributeConstraint__Group__1 )
            // InternalTGG.g:4777:2: rule__AttributeConstraint__Group__0__Impl rule__AttributeConstraint__Group__1
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
    // InternalTGG.g:4784:1: rule__AttributeConstraint__Group__0__Impl : ( ( rule__AttributeConstraint__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4788:1: ( ( ( rule__AttributeConstraint__AttributeAssignment_0 ) ) )
            // InternalTGG.g:4789:1: ( ( rule__AttributeConstraint__AttributeAssignment_0 ) )
            {
            // InternalTGG.g:4789:1: ( ( rule__AttributeConstraint__AttributeAssignment_0 ) )
            // InternalTGG.g:4790:2: ( rule__AttributeConstraint__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getAttributeAssignment_0()); 
            // InternalTGG.g:4791:2: ( rule__AttributeConstraint__AttributeAssignment_0 )
            // InternalTGG.g:4791:3: rule__AttributeConstraint__AttributeAssignment_0
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
    // InternalTGG.g:4799:1: rule__AttributeConstraint__Group__1 : rule__AttributeConstraint__Group__1__Impl rule__AttributeConstraint__Group__2 ;
    public final void rule__AttributeConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4803:1: ( rule__AttributeConstraint__Group__1__Impl rule__AttributeConstraint__Group__2 )
            // InternalTGG.g:4804:2: rule__AttributeConstraint__Group__1__Impl rule__AttributeConstraint__Group__2
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
    // InternalTGG.g:4811:1: rule__AttributeConstraint__Group__1__Impl : ( ( rule__AttributeConstraint__OpAssignment_1 ) ) ;
    public final void rule__AttributeConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4815:1: ( ( ( rule__AttributeConstraint__OpAssignment_1 ) ) )
            // InternalTGG.g:4816:1: ( ( rule__AttributeConstraint__OpAssignment_1 ) )
            {
            // InternalTGG.g:4816:1: ( ( rule__AttributeConstraint__OpAssignment_1 ) )
            // InternalTGG.g:4817:2: ( rule__AttributeConstraint__OpAssignment_1 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getOpAssignment_1()); 
            // InternalTGG.g:4818:2: ( rule__AttributeConstraint__OpAssignment_1 )
            // InternalTGG.g:4818:3: rule__AttributeConstraint__OpAssignment_1
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
    // InternalTGG.g:4826:1: rule__AttributeConstraint__Group__2 : rule__AttributeConstraint__Group__2__Impl ;
    public final void rule__AttributeConstraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4830:1: ( rule__AttributeConstraint__Group__2__Impl )
            // InternalTGG.g:4831:2: rule__AttributeConstraint__Group__2__Impl
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
    // InternalTGG.g:4837:1: rule__AttributeConstraint__Group__2__Impl : ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) ) ;
    public final void rule__AttributeConstraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4841:1: ( ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) ) )
            // InternalTGG.g:4842:1: ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) )
            {
            // InternalTGG.g:4842:1: ( ( rule__AttributeConstraint__ValueExpAssignment_2 ) )
            // InternalTGG.g:4843:2: ( rule__AttributeConstraint__ValueExpAssignment_2 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getValueExpAssignment_2()); 
            // InternalTGG.g:4844:2: ( rule__AttributeConstraint__ValueExpAssignment_2 )
            // InternalTGG.g:4844:3: rule__AttributeConstraint__ValueExpAssignment_2
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
    // InternalTGG.g:4853:1: rule__AttributeAssignment__Group__0 : rule__AttributeAssignment__Group__0__Impl rule__AttributeAssignment__Group__1 ;
    public final void rule__AttributeAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4857:1: ( rule__AttributeAssignment__Group__0__Impl rule__AttributeAssignment__Group__1 )
            // InternalTGG.g:4858:2: rule__AttributeAssignment__Group__0__Impl rule__AttributeAssignment__Group__1
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
    // InternalTGG.g:4865:1: rule__AttributeAssignment__Group__0__Impl : ( ( rule__AttributeAssignment__AttributeAssignment_0 ) ) ;
    public final void rule__AttributeAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4869:1: ( ( ( rule__AttributeAssignment__AttributeAssignment_0 ) ) )
            // InternalTGG.g:4870:1: ( ( rule__AttributeAssignment__AttributeAssignment_0 ) )
            {
            // InternalTGG.g:4870:1: ( ( rule__AttributeAssignment__AttributeAssignment_0 ) )
            // InternalTGG.g:4871:2: ( rule__AttributeAssignment__AttributeAssignment_0 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getAttributeAssignment_0()); 
            // InternalTGG.g:4872:2: ( rule__AttributeAssignment__AttributeAssignment_0 )
            // InternalTGG.g:4872:3: rule__AttributeAssignment__AttributeAssignment_0
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
    // InternalTGG.g:4880:1: rule__AttributeAssignment__Group__1 : rule__AttributeAssignment__Group__1__Impl rule__AttributeAssignment__Group__2 ;
    public final void rule__AttributeAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4884:1: ( rule__AttributeAssignment__Group__1__Impl rule__AttributeAssignment__Group__2 )
            // InternalTGG.g:4885:2: rule__AttributeAssignment__Group__1__Impl rule__AttributeAssignment__Group__2
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
    // InternalTGG.g:4892:1: rule__AttributeAssignment__Group__1__Impl : ( ( rule__AttributeAssignment__OpAssignment_1 ) ) ;
    public final void rule__AttributeAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4896:1: ( ( ( rule__AttributeAssignment__OpAssignment_1 ) ) )
            // InternalTGG.g:4897:1: ( ( rule__AttributeAssignment__OpAssignment_1 ) )
            {
            // InternalTGG.g:4897:1: ( ( rule__AttributeAssignment__OpAssignment_1 ) )
            // InternalTGG.g:4898:2: ( rule__AttributeAssignment__OpAssignment_1 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getOpAssignment_1()); 
            // InternalTGG.g:4899:2: ( rule__AttributeAssignment__OpAssignment_1 )
            // InternalTGG.g:4899:3: rule__AttributeAssignment__OpAssignment_1
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
    // InternalTGG.g:4907:1: rule__AttributeAssignment__Group__2 : rule__AttributeAssignment__Group__2__Impl ;
    public final void rule__AttributeAssignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4911:1: ( rule__AttributeAssignment__Group__2__Impl )
            // InternalTGG.g:4912:2: rule__AttributeAssignment__Group__2__Impl
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
    // InternalTGG.g:4918:1: rule__AttributeAssignment__Group__2__Impl : ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) ) ;
    public final void rule__AttributeAssignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4922:1: ( ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) ) )
            // InternalTGG.g:4923:1: ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) )
            {
            // InternalTGG.g:4923:1: ( ( rule__AttributeAssignment__ValueExpAssignment_2 ) )
            // InternalTGG.g:4924:2: ( rule__AttributeAssignment__ValueExpAssignment_2 )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getValueExpAssignment_2()); 
            // InternalTGG.g:4925:2: ( rule__AttributeAssignment__ValueExpAssignment_2 )
            // InternalTGG.g:4925:3: rule__AttributeAssignment__ValueExpAssignment_2
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
    // InternalTGG.g:4934:1: rule__EnumExpression__Group__0 : rule__EnumExpression__Group__0__Impl rule__EnumExpression__Group__1 ;
    public final void rule__EnumExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4938:1: ( rule__EnumExpression__Group__0__Impl rule__EnumExpression__Group__1 )
            // InternalTGG.g:4939:2: rule__EnumExpression__Group__0__Impl rule__EnumExpression__Group__1
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
    // InternalTGG.g:4946:1: rule__EnumExpression__Group__0__Impl : ( 'enum::' ) ;
    public final void rule__EnumExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4950:1: ( ( 'enum::' ) )
            // InternalTGG.g:4951:1: ( 'enum::' )
            {
            // InternalTGG.g:4951:1: ( 'enum::' )
            // InternalTGG.g:4952:2: 'enum::'
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
    // InternalTGG.g:4961:1: rule__EnumExpression__Group__1 : rule__EnumExpression__Group__1__Impl rule__EnumExpression__Group__2 ;
    public final void rule__EnumExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4965:1: ( rule__EnumExpression__Group__1__Impl rule__EnumExpression__Group__2 )
            // InternalTGG.g:4966:2: rule__EnumExpression__Group__1__Impl rule__EnumExpression__Group__2
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
    // InternalTGG.g:4973:1: rule__EnumExpression__Group__1__Impl : ( ( rule__EnumExpression__EenumAssignment_1 ) ) ;
    public final void rule__EnumExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4977:1: ( ( ( rule__EnumExpression__EenumAssignment_1 ) ) )
            // InternalTGG.g:4978:1: ( ( rule__EnumExpression__EenumAssignment_1 ) )
            {
            // InternalTGG.g:4978:1: ( ( rule__EnumExpression__EenumAssignment_1 ) )
            // InternalTGG.g:4979:2: ( rule__EnumExpression__EenumAssignment_1 )
            {
             before(grammarAccess.getEnumExpressionAccess().getEenumAssignment_1()); 
            // InternalTGG.g:4980:2: ( rule__EnumExpression__EenumAssignment_1 )
            // InternalTGG.g:4980:3: rule__EnumExpression__EenumAssignment_1
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
    // InternalTGG.g:4988:1: rule__EnumExpression__Group__2 : rule__EnumExpression__Group__2__Impl rule__EnumExpression__Group__3 ;
    public final void rule__EnumExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:4992:1: ( rule__EnumExpression__Group__2__Impl rule__EnumExpression__Group__3 )
            // InternalTGG.g:4993:2: rule__EnumExpression__Group__2__Impl rule__EnumExpression__Group__3
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
    // InternalTGG.g:5000:1: rule__EnumExpression__Group__2__Impl : ( '::' ) ;
    public final void rule__EnumExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5004:1: ( ( '::' ) )
            // InternalTGG.g:5005:1: ( '::' )
            {
            // InternalTGG.g:5005:1: ( '::' )
            // InternalTGG.g:5006:2: '::'
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
    // InternalTGG.g:5015:1: rule__EnumExpression__Group__3 : rule__EnumExpression__Group__3__Impl ;
    public final void rule__EnumExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5019:1: ( rule__EnumExpression__Group__3__Impl )
            // InternalTGG.g:5020:2: rule__EnumExpression__Group__3__Impl
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
    // InternalTGG.g:5026:1: rule__EnumExpression__Group__3__Impl : ( ( rule__EnumExpression__LiteralAssignment_3 ) ) ;
    public final void rule__EnumExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5030:1: ( ( ( rule__EnumExpression__LiteralAssignment_3 ) ) )
            // InternalTGG.g:5031:1: ( ( rule__EnumExpression__LiteralAssignment_3 ) )
            {
            // InternalTGG.g:5031:1: ( ( rule__EnumExpression__LiteralAssignment_3 ) )
            // InternalTGG.g:5032:2: ( rule__EnumExpression__LiteralAssignment_3 )
            {
             before(grammarAccess.getEnumExpressionAccess().getLiteralAssignment_3()); 
            // InternalTGG.g:5033:2: ( rule__EnumExpression__LiteralAssignment_3 )
            // InternalTGG.g:5033:3: rule__EnumExpression__LiteralAssignment_3
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
    // InternalTGG.g:5042:1: rule__AttributeExpression__Group__0 : rule__AttributeExpression__Group__0__Impl rule__AttributeExpression__Group__1 ;
    public final void rule__AttributeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5046:1: ( rule__AttributeExpression__Group__0__Impl rule__AttributeExpression__Group__1 )
            // InternalTGG.g:5047:2: rule__AttributeExpression__Group__0__Impl rule__AttributeExpression__Group__1
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
    // InternalTGG.g:5054:1: rule__AttributeExpression__Group__0__Impl : ( ( rule__AttributeExpression__DerivedAssignment_0 )? ) ;
    public final void rule__AttributeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5058:1: ( ( ( rule__AttributeExpression__DerivedAssignment_0 )? ) )
            // InternalTGG.g:5059:1: ( ( rule__AttributeExpression__DerivedAssignment_0 )? )
            {
            // InternalTGG.g:5059:1: ( ( rule__AttributeExpression__DerivedAssignment_0 )? )
            // InternalTGG.g:5060:2: ( rule__AttributeExpression__DerivedAssignment_0 )?
            {
             before(grammarAccess.getAttributeExpressionAccess().getDerivedAssignment_0()); 
            // InternalTGG.g:5061:2: ( rule__AttributeExpression__DerivedAssignment_0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==55) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalTGG.g:5061:3: rule__AttributeExpression__DerivedAssignment_0
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
    // InternalTGG.g:5069:1: rule__AttributeExpression__Group__1 : rule__AttributeExpression__Group__1__Impl rule__AttributeExpression__Group__2 ;
    public final void rule__AttributeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5073:1: ( rule__AttributeExpression__Group__1__Impl rule__AttributeExpression__Group__2 )
            // InternalTGG.g:5074:2: rule__AttributeExpression__Group__1__Impl rule__AttributeExpression__Group__2
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
    // InternalTGG.g:5081:1: rule__AttributeExpression__Group__1__Impl : ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) ) ;
    public final void rule__AttributeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5085:1: ( ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) ) )
            // InternalTGG.g:5086:1: ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) )
            {
            // InternalTGG.g:5086:1: ( ( rule__AttributeExpression__ObjectVarAssignment_1 ) )
            // InternalTGG.g:5087:2: ( rule__AttributeExpression__ObjectVarAssignment_1 )
            {
             before(grammarAccess.getAttributeExpressionAccess().getObjectVarAssignment_1()); 
            // InternalTGG.g:5088:2: ( rule__AttributeExpression__ObjectVarAssignment_1 )
            // InternalTGG.g:5088:3: rule__AttributeExpression__ObjectVarAssignment_1
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
    // InternalTGG.g:5096:1: rule__AttributeExpression__Group__2 : rule__AttributeExpression__Group__2__Impl rule__AttributeExpression__Group__3 ;
    public final void rule__AttributeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5100:1: ( rule__AttributeExpression__Group__2__Impl rule__AttributeExpression__Group__3 )
            // InternalTGG.g:5101:2: rule__AttributeExpression__Group__2__Impl rule__AttributeExpression__Group__3
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
    // InternalTGG.g:5108:1: rule__AttributeExpression__Group__2__Impl : ( '.' ) ;
    public final void rule__AttributeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5112:1: ( ( '.' ) )
            // InternalTGG.g:5113:1: ( '.' )
            {
            // InternalTGG.g:5113:1: ( '.' )
            // InternalTGG.g:5114:2: '.'
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
    // InternalTGG.g:5123:1: rule__AttributeExpression__Group__3 : rule__AttributeExpression__Group__3__Impl ;
    public final void rule__AttributeExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5127:1: ( rule__AttributeExpression__Group__3__Impl )
            // InternalTGG.g:5128:2: rule__AttributeExpression__Group__3__Impl
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
    // InternalTGG.g:5134:1: rule__AttributeExpression__Group__3__Impl : ( ( rule__AttributeExpression__AttributeAssignment_3 ) ) ;
    public final void rule__AttributeExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5138:1: ( ( ( rule__AttributeExpression__AttributeAssignment_3 ) ) )
            // InternalTGG.g:5139:1: ( ( rule__AttributeExpression__AttributeAssignment_3 ) )
            {
            // InternalTGG.g:5139:1: ( ( rule__AttributeExpression__AttributeAssignment_3 ) )
            // InternalTGG.g:5140:2: ( rule__AttributeExpression__AttributeAssignment_3 )
            {
             before(grammarAccess.getAttributeExpressionAccess().getAttributeAssignment_3()); 
            // InternalTGG.g:5141:2: ( rule__AttributeExpression__AttributeAssignment_3 )
            // InternalTGG.g:5141:3: rule__AttributeExpression__AttributeAssignment_3
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
    // InternalTGG.g:5150:1: rule__LinkVariablePattern__Group__0 : rule__LinkVariablePattern__Group__0__Impl rule__LinkVariablePattern__Group__1 ;
    public final void rule__LinkVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5154:1: ( rule__LinkVariablePattern__Group__0__Impl rule__LinkVariablePattern__Group__1 )
            // InternalTGG.g:5155:2: rule__LinkVariablePattern__Group__0__Impl rule__LinkVariablePattern__Group__1
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
    // InternalTGG.g:5162:1: rule__LinkVariablePattern__Group__0__Impl : ( ( rule__LinkVariablePattern__OpAssignment_0 )? ) ;
    public final void rule__LinkVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5166:1: ( ( ( rule__LinkVariablePattern__OpAssignment_0 )? ) )
            // InternalTGG.g:5167:1: ( ( rule__LinkVariablePattern__OpAssignment_0 )? )
            {
            // InternalTGG.g:5167:1: ( ( rule__LinkVariablePattern__OpAssignment_0 )? )
            // InternalTGG.g:5168:2: ( rule__LinkVariablePattern__OpAssignment_0 )?
            {
             before(grammarAccess.getLinkVariablePatternAccess().getOpAssignment_0()); 
            // InternalTGG.g:5169:2: ( rule__LinkVariablePattern__OpAssignment_0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalTGG.g:5169:3: rule__LinkVariablePattern__OpAssignment_0
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
    // InternalTGG.g:5177:1: rule__LinkVariablePattern__Group__1 : rule__LinkVariablePattern__Group__1__Impl rule__LinkVariablePattern__Group__2 ;
    public final void rule__LinkVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5181:1: ( rule__LinkVariablePattern__Group__1__Impl rule__LinkVariablePattern__Group__2 )
            // InternalTGG.g:5182:2: rule__LinkVariablePattern__Group__1__Impl rule__LinkVariablePattern__Group__2
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
    // InternalTGG.g:5189:1: rule__LinkVariablePattern__Group__1__Impl : ( '-' ) ;
    public final void rule__LinkVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5193:1: ( ( '-' ) )
            // InternalTGG.g:5194:1: ( '-' )
            {
            // InternalTGG.g:5194:1: ( '-' )
            // InternalTGG.g:5195:2: '-'
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
    // InternalTGG.g:5204:1: rule__LinkVariablePattern__Group__2 : rule__LinkVariablePattern__Group__2__Impl rule__LinkVariablePattern__Group__3 ;
    public final void rule__LinkVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5208:1: ( rule__LinkVariablePattern__Group__2__Impl rule__LinkVariablePattern__Group__3 )
            // InternalTGG.g:5209:2: rule__LinkVariablePattern__Group__2__Impl rule__LinkVariablePattern__Group__3
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
    // InternalTGG.g:5216:1: rule__LinkVariablePattern__Group__2__Impl : ( ( rule__LinkVariablePattern__TypeAssignment_2 ) ) ;
    public final void rule__LinkVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5220:1: ( ( ( rule__LinkVariablePattern__TypeAssignment_2 ) ) )
            // InternalTGG.g:5221:1: ( ( rule__LinkVariablePattern__TypeAssignment_2 ) )
            {
            // InternalTGG.g:5221:1: ( ( rule__LinkVariablePattern__TypeAssignment_2 ) )
            // InternalTGG.g:5222:2: ( rule__LinkVariablePattern__TypeAssignment_2 )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTypeAssignment_2()); 
            // InternalTGG.g:5223:2: ( rule__LinkVariablePattern__TypeAssignment_2 )
            // InternalTGG.g:5223:3: rule__LinkVariablePattern__TypeAssignment_2
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
    // InternalTGG.g:5231:1: rule__LinkVariablePattern__Group__3 : rule__LinkVariablePattern__Group__3__Impl rule__LinkVariablePattern__Group__4 ;
    public final void rule__LinkVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5235:1: ( rule__LinkVariablePattern__Group__3__Impl rule__LinkVariablePattern__Group__4 )
            // InternalTGG.g:5236:2: rule__LinkVariablePattern__Group__3__Impl rule__LinkVariablePattern__Group__4
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
    // InternalTGG.g:5243:1: rule__LinkVariablePattern__Group__3__Impl : ( '->' ) ;
    public final void rule__LinkVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5247:1: ( ( '->' ) )
            // InternalTGG.g:5248:1: ( '->' )
            {
            // InternalTGG.g:5248:1: ( '->' )
            // InternalTGG.g:5249:2: '->'
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
    // InternalTGG.g:5258:1: rule__LinkVariablePattern__Group__4 : rule__LinkVariablePattern__Group__4__Impl ;
    public final void rule__LinkVariablePattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5262:1: ( rule__LinkVariablePattern__Group__4__Impl )
            // InternalTGG.g:5263:2: rule__LinkVariablePattern__Group__4__Impl
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
    // InternalTGG.g:5269:1: rule__LinkVariablePattern__Group__4__Impl : ( ( rule__LinkVariablePattern__TargetAssignment_4 ) ) ;
    public final void rule__LinkVariablePattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5273:1: ( ( ( rule__LinkVariablePattern__TargetAssignment_4 ) ) )
            // InternalTGG.g:5274:1: ( ( rule__LinkVariablePattern__TargetAssignment_4 ) )
            {
            // InternalTGG.g:5274:1: ( ( rule__LinkVariablePattern__TargetAssignment_4 ) )
            // InternalTGG.g:5275:2: ( rule__LinkVariablePattern__TargetAssignment_4 )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTargetAssignment_4()); 
            // InternalTGG.g:5276:2: ( rule__LinkVariablePattern__TargetAssignment_4 )
            // InternalTGG.g:5276:3: rule__LinkVariablePattern__TargetAssignment_4
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
    // InternalTGG.g:5285:1: rule__ContextLinkVariablePattern__Group__0 : rule__ContextLinkVariablePattern__Group__0__Impl rule__ContextLinkVariablePattern__Group__1 ;
    public final void rule__ContextLinkVariablePattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5289:1: ( rule__ContextLinkVariablePattern__Group__0__Impl rule__ContextLinkVariablePattern__Group__1 )
            // InternalTGG.g:5290:2: rule__ContextLinkVariablePattern__Group__0__Impl rule__ContextLinkVariablePattern__Group__1
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
    // InternalTGG.g:5297:1: rule__ContextLinkVariablePattern__Group__0__Impl : ( '-' ) ;
    public final void rule__ContextLinkVariablePattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5301:1: ( ( '-' ) )
            // InternalTGG.g:5302:1: ( '-' )
            {
            // InternalTGG.g:5302:1: ( '-' )
            // InternalTGG.g:5303:2: '-'
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
    // InternalTGG.g:5312:1: rule__ContextLinkVariablePattern__Group__1 : rule__ContextLinkVariablePattern__Group__1__Impl rule__ContextLinkVariablePattern__Group__2 ;
    public final void rule__ContextLinkVariablePattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5316:1: ( rule__ContextLinkVariablePattern__Group__1__Impl rule__ContextLinkVariablePattern__Group__2 )
            // InternalTGG.g:5317:2: rule__ContextLinkVariablePattern__Group__1__Impl rule__ContextLinkVariablePattern__Group__2
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
    // InternalTGG.g:5324:1: rule__ContextLinkVariablePattern__Group__1__Impl : ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) ) ;
    public final void rule__ContextLinkVariablePattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5328:1: ( ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) ) )
            // InternalTGG.g:5329:1: ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) )
            {
            // InternalTGG.g:5329:1: ( ( rule__ContextLinkVariablePattern__TypeAssignment_1 ) )
            // InternalTGG.g:5330:2: ( rule__ContextLinkVariablePattern__TypeAssignment_1 )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTypeAssignment_1()); 
            // InternalTGG.g:5331:2: ( rule__ContextLinkVariablePattern__TypeAssignment_1 )
            // InternalTGG.g:5331:3: rule__ContextLinkVariablePattern__TypeAssignment_1
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
    // InternalTGG.g:5339:1: rule__ContextLinkVariablePattern__Group__2 : rule__ContextLinkVariablePattern__Group__2__Impl rule__ContextLinkVariablePattern__Group__3 ;
    public final void rule__ContextLinkVariablePattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5343:1: ( rule__ContextLinkVariablePattern__Group__2__Impl rule__ContextLinkVariablePattern__Group__3 )
            // InternalTGG.g:5344:2: rule__ContextLinkVariablePattern__Group__2__Impl rule__ContextLinkVariablePattern__Group__3
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
    // InternalTGG.g:5351:1: rule__ContextLinkVariablePattern__Group__2__Impl : ( '->' ) ;
    public final void rule__ContextLinkVariablePattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5355:1: ( ( '->' ) )
            // InternalTGG.g:5356:1: ( '->' )
            {
            // InternalTGG.g:5356:1: ( '->' )
            // InternalTGG.g:5357:2: '->'
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
    // InternalTGG.g:5366:1: rule__ContextLinkVariablePattern__Group__3 : rule__ContextLinkVariablePattern__Group__3__Impl ;
    public final void rule__ContextLinkVariablePattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5370:1: ( rule__ContextLinkVariablePattern__Group__3__Impl )
            // InternalTGG.g:5371:2: rule__ContextLinkVariablePattern__Group__3__Impl
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
    // InternalTGG.g:5377:1: rule__ContextLinkVariablePattern__Group__3__Impl : ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) ) ;
    public final void rule__ContextLinkVariablePattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5381:1: ( ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) ) )
            // InternalTGG.g:5382:1: ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) )
            {
            // InternalTGG.g:5382:1: ( ( rule__ContextLinkVariablePattern__TargetAssignment_3 ) )
            // InternalTGG.g:5383:2: ( rule__ContextLinkVariablePattern__TargetAssignment_3 )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTargetAssignment_3()); 
            // InternalTGG.g:5384:2: ( rule__ContextLinkVariablePattern__TargetAssignment_3 )
            // InternalTGG.g:5384:3: rule__ContextLinkVariablePattern__TargetAssignment_3
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
    // InternalTGG.g:5393:1: rule__Nac__Group__0 : rule__Nac__Group__0__Impl rule__Nac__Group__1 ;
    public final void rule__Nac__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5397:1: ( rule__Nac__Group__0__Impl rule__Nac__Group__1 )
            // InternalTGG.g:5398:2: rule__Nac__Group__0__Impl rule__Nac__Group__1
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
    // InternalTGG.g:5405:1: rule__Nac__Group__0__Impl : ( '#nac' ) ;
    public final void rule__Nac__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5409:1: ( ( '#nac' ) )
            // InternalTGG.g:5410:1: ( '#nac' )
            {
            // InternalTGG.g:5410:1: ( '#nac' )
            // InternalTGG.g:5411:2: '#nac'
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
    // InternalTGG.g:5420:1: rule__Nac__Group__1 : rule__Nac__Group__1__Impl rule__Nac__Group__2 ;
    public final void rule__Nac__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5424:1: ( rule__Nac__Group__1__Impl rule__Nac__Group__2 )
            // InternalTGG.g:5425:2: rule__Nac__Group__1__Impl rule__Nac__Group__2
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
    // InternalTGG.g:5432:1: rule__Nac__Group__1__Impl : ( ( rule__Nac__NameAssignment_1 ) ) ;
    public final void rule__Nac__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5436:1: ( ( ( rule__Nac__NameAssignment_1 ) ) )
            // InternalTGG.g:5437:1: ( ( rule__Nac__NameAssignment_1 ) )
            {
            // InternalTGG.g:5437:1: ( ( rule__Nac__NameAssignment_1 ) )
            // InternalTGG.g:5438:2: ( rule__Nac__NameAssignment_1 )
            {
             before(grammarAccess.getNacAccess().getNameAssignment_1()); 
            // InternalTGG.g:5439:2: ( rule__Nac__NameAssignment_1 )
            // InternalTGG.g:5439:3: rule__Nac__NameAssignment_1
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
    // InternalTGG.g:5447:1: rule__Nac__Group__2 : rule__Nac__Group__2__Impl rule__Nac__Group__3 ;
    public final void rule__Nac__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5451:1: ( rule__Nac__Group__2__Impl rule__Nac__Group__3 )
            // InternalTGG.g:5452:2: rule__Nac__Group__2__Impl rule__Nac__Group__3
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
    // InternalTGG.g:5459:1: rule__Nac__Group__2__Impl : ( '#for' ) ;
    public final void rule__Nac__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5463:1: ( ( '#for' ) )
            // InternalTGG.g:5464:1: ( '#for' )
            {
            // InternalTGG.g:5464:1: ( '#for' )
            // InternalTGG.g:5465:2: '#for'
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
    // InternalTGG.g:5474:1: rule__Nac__Group__3 : rule__Nac__Group__3__Impl rule__Nac__Group__4 ;
    public final void rule__Nac__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5478:1: ( rule__Nac__Group__3__Impl rule__Nac__Group__4 )
            // InternalTGG.g:5479:2: rule__Nac__Group__3__Impl rule__Nac__Group__4
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
    // InternalTGG.g:5486:1: rule__Nac__Group__3__Impl : ( ( rule__Nac__RuleAssignment_3 ) ) ;
    public final void rule__Nac__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5490:1: ( ( ( rule__Nac__RuleAssignment_3 ) ) )
            // InternalTGG.g:5491:1: ( ( rule__Nac__RuleAssignment_3 ) )
            {
            // InternalTGG.g:5491:1: ( ( rule__Nac__RuleAssignment_3 ) )
            // InternalTGG.g:5492:2: ( rule__Nac__RuleAssignment_3 )
            {
             before(grammarAccess.getNacAccess().getRuleAssignment_3()); 
            // InternalTGG.g:5493:2: ( rule__Nac__RuleAssignment_3 )
            // InternalTGG.g:5493:3: rule__Nac__RuleAssignment_3
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
    // InternalTGG.g:5501:1: rule__Nac__Group__4 : rule__Nac__Group__4__Impl rule__Nac__Group__5 ;
    public final void rule__Nac__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5505:1: ( rule__Nac__Group__4__Impl rule__Nac__Group__5 )
            // InternalTGG.g:5506:2: rule__Nac__Group__4__Impl rule__Nac__Group__5
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
    // InternalTGG.g:5513:1: rule__Nac__Group__4__Impl : ( ( rule__Nac__Alternatives_4 ) ) ;
    public final void rule__Nac__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5517:1: ( ( ( rule__Nac__Alternatives_4 ) ) )
            // InternalTGG.g:5518:1: ( ( rule__Nac__Alternatives_4 ) )
            {
            // InternalTGG.g:5518:1: ( ( rule__Nac__Alternatives_4 ) )
            // InternalTGG.g:5519:2: ( rule__Nac__Alternatives_4 )
            {
             before(grammarAccess.getNacAccess().getAlternatives_4()); 
            // InternalTGG.g:5520:2: ( rule__Nac__Alternatives_4 )
            // InternalTGG.g:5520:3: rule__Nac__Alternatives_4
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
    // InternalTGG.g:5528:1: rule__Nac__Group__5 : rule__Nac__Group__5__Impl ;
    public final void rule__Nac__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5532:1: ( rule__Nac__Group__5__Impl )
            // InternalTGG.g:5533:2: rule__Nac__Group__5__Impl
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
    // InternalTGG.g:5539:1: rule__Nac__Group__5__Impl : ( ( rule__Nac__Group_5__0 )? ) ;
    public final void rule__Nac__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5543:1: ( ( ( rule__Nac__Group_5__0 )? ) )
            // InternalTGG.g:5544:1: ( ( rule__Nac__Group_5__0 )? )
            {
            // InternalTGG.g:5544:1: ( ( rule__Nac__Group_5__0 )? )
            // InternalTGG.g:5545:2: ( rule__Nac__Group_5__0 )?
            {
             before(grammarAccess.getNacAccess().getGroup_5()); 
            // InternalTGG.g:5546:2: ( rule__Nac__Group_5__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==27) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalTGG.g:5546:3: rule__Nac__Group_5__0
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
    // InternalTGG.g:5555:1: rule__Nac__Group_4_0__0 : rule__Nac__Group_4_0__0__Impl rule__Nac__Group_4_0__1 ;
    public final void rule__Nac__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5559:1: ( rule__Nac__Group_4_0__0__Impl rule__Nac__Group_4_0__1 )
            // InternalTGG.g:5560:2: rule__Nac__Group_4_0__0__Impl rule__Nac__Group_4_0__1
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
    // InternalTGG.g:5567:1: rule__Nac__Group_4_0__0__Impl : ( '#source' ) ;
    public final void rule__Nac__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5571:1: ( ( '#source' ) )
            // InternalTGG.g:5572:1: ( '#source' )
            {
            // InternalTGG.g:5572:1: ( '#source' )
            // InternalTGG.g:5573:2: '#source'
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
    // InternalTGG.g:5582:1: rule__Nac__Group_4_0__1 : rule__Nac__Group_4_0__1__Impl rule__Nac__Group_4_0__2 ;
    public final void rule__Nac__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5586:1: ( rule__Nac__Group_4_0__1__Impl rule__Nac__Group_4_0__2 )
            // InternalTGG.g:5587:2: rule__Nac__Group_4_0__1__Impl rule__Nac__Group_4_0__2
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
    // InternalTGG.g:5594:1: rule__Nac__Group_4_0__1__Impl : ( '{' ) ;
    public final void rule__Nac__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5598:1: ( ( '{' ) )
            // InternalTGG.g:5599:1: ( '{' )
            {
            // InternalTGG.g:5599:1: ( '{' )
            // InternalTGG.g:5600:2: '{'
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
    // InternalTGG.g:5609:1: rule__Nac__Group_4_0__2 : rule__Nac__Group_4_0__2__Impl rule__Nac__Group_4_0__3 ;
    public final void rule__Nac__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5613:1: ( rule__Nac__Group_4_0__2__Impl rule__Nac__Group_4_0__3 )
            // InternalTGG.g:5614:2: rule__Nac__Group_4_0__2__Impl rule__Nac__Group_4_0__3
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
    // InternalTGG.g:5621:1: rule__Nac__Group_4_0__2__Impl : ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* ) ;
    public final void rule__Nac__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5625:1: ( ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* ) )
            // InternalTGG.g:5626:1: ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* )
            {
            // InternalTGG.g:5626:1: ( ( rule__Nac__SourcePatternsAssignment_4_0_2 )* )
            // InternalTGG.g:5627:2: ( rule__Nac__SourcePatternsAssignment_4_0_2 )*
            {
             before(grammarAccess.getNacAccess().getSourcePatternsAssignment_4_0_2()); 
            // InternalTGG.g:5628:2: ( rule__Nac__SourcePatternsAssignment_4_0_2 )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==RULE_ID) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalTGG.g:5628:3: rule__Nac__SourcePatternsAssignment_4_0_2
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
    // InternalTGG.g:5636:1: rule__Nac__Group_4_0__3 : rule__Nac__Group_4_0__3__Impl ;
    public final void rule__Nac__Group_4_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5640:1: ( rule__Nac__Group_4_0__3__Impl )
            // InternalTGG.g:5641:2: rule__Nac__Group_4_0__3__Impl
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
    // InternalTGG.g:5647:1: rule__Nac__Group_4_0__3__Impl : ( '}' ) ;
    public final void rule__Nac__Group_4_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5651:1: ( ( '}' ) )
            // InternalTGG.g:5652:1: ( '}' )
            {
            // InternalTGG.g:5652:1: ( '}' )
            // InternalTGG.g:5653:2: '}'
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
    // InternalTGG.g:5663:1: rule__Nac__Group_4_1__0 : rule__Nac__Group_4_1__0__Impl rule__Nac__Group_4_1__1 ;
    public final void rule__Nac__Group_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5667:1: ( rule__Nac__Group_4_1__0__Impl rule__Nac__Group_4_1__1 )
            // InternalTGG.g:5668:2: rule__Nac__Group_4_1__0__Impl rule__Nac__Group_4_1__1
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
    // InternalTGG.g:5675:1: rule__Nac__Group_4_1__0__Impl : ( '#target' ) ;
    public final void rule__Nac__Group_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5679:1: ( ( '#target' ) )
            // InternalTGG.g:5680:1: ( '#target' )
            {
            // InternalTGG.g:5680:1: ( '#target' )
            // InternalTGG.g:5681:2: '#target'
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
    // InternalTGG.g:5690:1: rule__Nac__Group_4_1__1 : rule__Nac__Group_4_1__1__Impl rule__Nac__Group_4_1__2 ;
    public final void rule__Nac__Group_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5694:1: ( rule__Nac__Group_4_1__1__Impl rule__Nac__Group_4_1__2 )
            // InternalTGG.g:5695:2: rule__Nac__Group_4_1__1__Impl rule__Nac__Group_4_1__2
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
    // InternalTGG.g:5702:1: rule__Nac__Group_4_1__1__Impl : ( '{' ) ;
    public final void rule__Nac__Group_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5706:1: ( ( '{' ) )
            // InternalTGG.g:5707:1: ( '{' )
            {
            // InternalTGG.g:5707:1: ( '{' )
            // InternalTGG.g:5708:2: '{'
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
    // InternalTGG.g:5717:1: rule__Nac__Group_4_1__2 : rule__Nac__Group_4_1__2__Impl rule__Nac__Group_4_1__3 ;
    public final void rule__Nac__Group_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5721:1: ( rule__Nac__Group_4_1__2__Impl rule__Nac__Group_4_1__3 )
            // InternalTGG.g:5722:2: rule__Nac__Group_4_1__2__Impl rule__Nac__Group_4_1__3
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
    // InternalTGG.g:5729:1: rule__Nac__Group_4_1__2__Impl : ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* ) ;
    public final void rule__Nac__Group_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5733:1: ( ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* ) )
            // InternalTGG.g:5734:1: ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* )
            {
            // InternalTGG.g:5734:1: ( ( rule__Nac__TargetPatternsAssignment_4_1_2 )* )
            // InternalTGG.g:5735:2: ( rule__Nac__TargetPatternsAssignment_4_1_2 )*
            {
             before(grammarAccess.getNacAccess().getTargetPatternsAssignment_4_1_2()); 
            // InternalTGG.g:5736:2: ( rule__Nac__TargetPatternsAssignment_4_1_2 )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalTGG.g:5736:3: rule__Nac__TargetPatternsAssignment_4_1_2
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
    // InternalTGG.g:5744:1: rule__Nac__Group_4_1__3 : rule__Nac__Group_4_1__3__Impl ;
    public final void rule__Nac__Group_4_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5748:1: ( rule__Nac__Group_4_1__3__Impl )
            // InternalTGG.g:5749:2: rule__Nac__Group_4_1__3__Impl
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
    // InternalTGG.g:5755:1: rule__Nac__Group_4_1__3__Impl : ( '}' ) ;
    public final void rule__Nac__Group_4_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5759:1: ( ( '}' ) )
            // InternalTGG.g:5760:1: ( '}' )
            {
            // InternalTGG.g:5760:1: ( '}' )
            // InternalTGG.g:5761:2: '}'
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
    // InternalTGG.g:5771:1: rule__Nac__Group_5__0 : rule__Nac__Group_5__0__Impl rule__Nac__Group_5__1 ;
    public final void rule__Nac__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5775:1: ( rule__Nac__Group_5__0__Impl rule__Nac__Group_5__1 )
            // InternalTGG.g:5776:2: rule__Nac__Group_5__0__Impl rule__Nac__Group_5__1
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
    // InternalTGG.g:5783:1: rule__Nac__Group_5__0__Impl : ( '#attributeConditions' ) ;
    public final void rule__Nac__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5787:1: ( ( '#attributeConditions' ) )
            // InternalTGG.g:5788:1: ( '#attributeConditions' )
            {
            // InternalTGG.g:5788:1: ( '#attributeConditions' )
            // InternalTGG.g:5789:2: '#attributeConditions'
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
    // InternalTGG.g:5798:1: rule__Nac__Group_5__1 : rule__Nac__Group_5__1__Impl rule__Nac__Group_5__2 ;
    public final void rule__Nac__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5802:1: ( rule__Nac__Group_5__1__Impl rule__Nac__Group_5__2 )
            // InternalTGG.g:5803:2: rule__Nac__Group_5__1__Impl rule__Nac__Group_5__2
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
    // InternalTGG.g:5810:1: rule__Nac__Group_5__1__Impl : ( '{' ) ;
    public final void rule__Nac__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5814:1: ( ( '{' ) )
            // InternalTGG.g:5815:1: ( '{' )
            {
            // InternalTGG.g:5815:1: ( '{' )
            // InternalTGG.g:5816:2: '{'
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
    // InternalTGG.g:5825:1: rule__Nac__Group_5__2 : rule__Nac__Group_5__2__Impl rule__Nac__Group_5__3 ;
    public final void rule__Nac__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5829:1: ( rule__Nac__Group_5__2__Impl rule__Nac__Group_5__3 )
            // InternalTGG.g:5830:2: rule__Nac__Group_5__2__Impl rule__Nac__Group_5__3
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
    // InternalTGG.g:5837:1: rule__Nac__Group_5__2__Impl : ( ( rule__Nac__AttrConditionsAssignment_5_2 )* ) ;
    public final void rule__Nac__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5841:1: ( ( ( rule__Nac__AttrConditionsAssignment_5_2 )* ) )
            // InternalTGG.g:5842:1: ( ( rule__Nac__AttrConditionsAssignment_5_2 )* )
            {
            // InternalTGG.g:5842:1: ( ( rule__Nac__AttrConditionsAssignment_5_2 )* )
            // InternalTGG.g:5843:2: ( rule__Nac__AttrConditionsAssignment_5_2 )*
            {
             before(grammarAccess.getNacAccess().getAttrConditionsAssignment_5_2()); 
            // InternalTGG.g:5844:2: ( rule__Nac__AttrConditionsAssignment_5_2 )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==RULE_ID) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // InternalTGG.g:5844:3: rule__Nac__AttrConditionsAssignment_5_2
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
    // InternalTGG.g:5852:1: rule__Nac__Group_5__3 : rule__Nac__Group_5__3__Impl ;
    public final void rule__Nac__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5856:1: ( rule__Nac__Group_5__3__Impl )
            // InternalTGG.g:5857:2: rule__Nac__Group_5__3__Impl
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
    // InternalTGG.g:5863:1: rule__Nac__Group_5__3__Impl : ( '}' ) ;
    public final void rule__Nac__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5867:1: ( ( '}' ) )
            // InternalTGG.g:5868:1: ( '}' )
            {
            // InternalTGG.g:5868:1: ( '}' )
            // InternalTGG.g:5869:2: '}'
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
    // InternalTGG.g:5879:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5883:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalTGG.g:5884:2: rule__Import__Group__0__Impl rule__Import__Group__1
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
    // InternalTGG.g:5891:1: rule__Import__Group__0__Impl : ( '#import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5895:1: ( ( '#import' ) )
            // InternalTGG.g:5896:1: ( '#import' )
            {
            // InternalTGG.g:5896:1: ( '#import' )
            // InternalTGG.g:5897:2: '#import'
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
    // InternalTGG.g:5906:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5910:1: ( rule__Import__Group__1__Impl )
            // InternalTGG.g:5911:2: rule__Import__Group__1__Impl
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
    // InternalTGG.g:5917:1: rule__Import__Group__1__Impl : ( ( rule__Import__NameAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5921:1: ( ( ( rule__Import__NameAssignment_1 ) ) )
            // InternalTGG.g:5922:1: ( ( rule__Import__NameAssignment_1 ) )
            {
            // InternalTGG.g:5922:1: ( ( rule__Import__NameAssignment_1 ) )
            // InternalTGG.g:5923:2: ( rule__Import__NameAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getNameAssignment_1()); 
            // InternalTGG.g:5924:2: ( rule__Import__NameAssignment_1 )
            // InternalTGG.g:5924:3: rule__Import__NameAssignment_1
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
    // InternalTGG.g:5933:1: rule__Using__Group__0 : rule__Using__Group__0__Impl rule__Using__Group__1 ;
    public final void rule__Using__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5937:1: ( rule__Using__Group__0__Impl rule__Using__Group__1 )
            // InternalTGG.g:5938:2: rule__Using__Group__0__Impl rule__Using__Group__1
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
    // InternalTGG.g:5945:1: rule__Using__Group__0__Impl : ( '#using' ) ;
    public final void rule__Using__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5949:1: ( ( '#using' ) )
            // InternalTGG.g:5950:1: ( '#using' )
            {
            // InternalTGG.g:5950:1: ( '#using' )
            // InternalTGG.g:5951:2: '#using'
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
    // InternalTGG.g:5960:1: rule__Using__Group__1 : rule__Using__Group__1__Impl ;
    public final void rule__Using__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5964:1: ( rule__Using__Group__1__Impl )
            // InternalTGG.g:5965:2: rule__Using__Group__1__Impl
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
    // InternalTGG.g:5971:1: rule__Using__Group__1__Impl : ( ( rule__Using__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Using__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5975:1: ( ( ( rule__Using__ImportedNamespaceAssignment_1 ) ) )
            // InternalTGG.g:5976:1: ( ( rule__Using__ImportedNamespaceAssignment_1 ) )
            {
            // InternalTGG.g:5976:1: ( ( rule__Using__ImportedNamespaceAssignment_1 ) )
            // InternalTGG.g:5977:2: ( rule__Using__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getUsingAccess().getImportedNamespaceAssignment_1()); 
            // InternalTGG.g:5978:2: ( rule__Using__ImportedNamespaceAssignment_1 )
            // InternalTGG.g:5978:3: rule__Using__ImportedNamespaceAssignment_1
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
    // InternalTGG.g:5987:1: rule__LiteralValue__Group_1__0 : rule__LiteralValue__Group_1__0__Impl rule__LiteralValue__Group_1__1 ;
    public final void rule__LiteralValue__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:5991:1: ( rule__LiteralValue__Group_1__0__Impl rule__LiteralValue__Group_1__1 )
            // InternalTGG.g:5992:2: rule__LiteralValue__Group_1__0__Impl rule__LiteralValue__Group_1__1
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
    // InternalTGG.g:5999:1: rule__LiteralValue__Group_1__0__Impl : ( ( '-' )? ) ;
    public final void rule__LiteralValue__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6003:1: ( ( ( '-' )? ) )
            // InternalTGG.g:6004:1: ( ( '-' )? )
            {
            // InternalTGG.g:6004:1: ( ( '-' )? )
            // InternalTGG.g:6005:2: ( '-' )?
            {
             before(grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_1_0()); 
            // InternalTGG.g:6006:2: ( '-' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==45) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalTGG.g:6006:3: '-'
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
    // InternalTGG.g:6014:1: rule__LiteralValue__Group_1__1 : rule__LiteralValue__Group_1__1__Impl ;
    public final void rule__LiteralValue__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6018:1: ( rule__LiteralValue__Group_1__1__Impl )
            // InternalTGG.g:6019:2: rule__LiteralValue__Group_1__1__Impl
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
    // InternalTGG.g:6025:1: rule__LiteralValue__Group_1__1__Impl : ( RULE_INT ) ;
    public final void rule__LiteralValue__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6029:1: ( ( RULE_INT ) )
            // InternalTGG.g:6030:1: ( RULE_INT )
            {
            // InternalTGG.g:6030:1: ( RULE_INT )
            // InternalTGG.g:6031:2: RULE_INT
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
    // InternalTGG.g:6041:1: rule__LiteralValue__Group_2__0 : rule__LiteralValue__Group_2__0__Impl rule__LiteralValue__Group_2__1 ;
    public final void rule__LiteralValue__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6045:1: ( rule__LiteralValue__Group_2__0__Impl rule__LiteralValue__Group_2__1 )
            // InternalTGG.g:6046:2: rule__LiteralValue__Group_2__0__Impl rule__LiteralValue__Group_2__1
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
    // InternalTGG.g:6053:1: rule__LiteralValue__Group_2__0__Impl : ( ( '-' )? ) ;
    public final void rule__LiteralValue__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6057:1: ( ( ( '-' )? ) )
            // InternalTGG.g:6058:1: ( ( '-' )? )
            {
            // InternalTGG.g:6058:1: ( ( '-' )? )
            // InternalTGG.g:6059:2: ( '-' )?
            {
             before(grammarAccess.getLiteralValueAccess().getHyphenMinusKeyword_2_0()); 
            // InternalTGG.g:6060:2: ( '-' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==45) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalTGG.g:6060:3: '-'
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
    // InternalTGG.g:6068:1: rule__LiteralValue__Group_2__1 : rule__LiteralValue__Group_2__1__Impl ;
    public final void rule__LiteralValue__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6072:1: ( rule__LiteralValue__Group_2__1__Impl )
            // InternalTGG.g:6073:2: rule__LiteralValue__Group_2__1__Impl
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
    // InternalTGG.g:6079:1: rule__LiteralValue__Group_2__1__Impl : ( RULE_DECIMAL ) ;
    public final void rule__LiteralValue__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6083:1: ( ( RULE_DECIMAL ) )
            // InternalTGG.g:6084:1: ( RULE_DECIMAL )
            {
            // InternalTGG.g:6084:1: ( RULE_DECIMAL )
            // InternalTGG.g:6085:2: RULE_DECIMAL
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
    // InternalTGG.g:6095:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6099:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // InternalTGG.g:6100:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
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
    // InternalTGG.g:6107:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6111:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6112:1: ( ruleQualifiedName )
            {
            // InternalTGG.g:6112:1: ( ruleQualifiedName )
            // InternalTGG.g:6113:2: ruleQualifiedName
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
    // InternalTGG.g:6122:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6126:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // InternalTGG.g:6127:2: rule__QualifiedNameWithWildcard__Group__1__Impl
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
    // InternalTGG.g:6133:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( '.*' ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6137:1: ( ( '.*' ) )
            // InternalTGG.g:6138:1: ( '.*' )
            {
            // InternalTGG.g:6138:1: ( '.*' )
            // InternalTGG.g:6139:2: '.*'
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
    // InternalTGG.g:6149:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6153:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalTGG.g:6154:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
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
    // InternalTGG.g:6161:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6165:1: ( ( RULE_ID ) )
            // InternalTGG.g:6166:1: ( RULE_ID )
            {
            // InternalTGG.g:6166:1: ( RULE_ID )
            // InternalTGG.g:6167:2: RULE_ID
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
    // InternalTGG.g:6176:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6180:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalTGG.g:6181:2: rule__QualifiedName__Group__1__Impl
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
    // InternalTGG.g:6187:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6191:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalTGG.g:6192:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalTGG.g:6192:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalTGG.g:6193:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalTGG.g:6194:2: ( rule__QualifiedName__Group_1__0 )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==44) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalTGG.g:6194:3: rule__QualifiedName__Group_1__0
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
    // InternalTGG.g:6203:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6207:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalTGG.g:6208:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
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
    // InternalTGG.g:6215:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6219:1: ( ( '.' ) )
            // InternalTGG.g:6220:1: ( '.' )
            {
            // InternalTGG.g:6220:1: ( '.' )
            // InternalTGG.g:6221:2: '.'
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
    // InternalTGG.g:6230:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6234:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalTGG.g:6235:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalTGG.g:6241:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6245:1: ( ( RULE_ID ) )
            // InternalTGG.g:6246:1: ( RULE_ID )
            {
            // InternalTGG.g:6246:1: ( RULE_ID )
            // InternalTGG.g:6247:2: RULE_ID
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
    // InternalTGG.g:6257:1: rule__TripleGraphGrammarFile__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__TripleGraphGrammarFile__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6261:1: ( ( ruleImport ) )
            // InternalTGG.g:6262:2: ( ruleImport )
            {
            // InternalTGG.g:6262:2: ( ruleImport )
            // InternalTGG.g:6263:3: ruleImport
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
    // InternalTGG.g:6272:1: rule__TripleGraphGrammarFile__UsingAssignment_1 : ( ruleUsing ) ;
    public final void rule__TripleGraphGrammarFile__UsingAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6276:1: ( ( ruleUsing ) )
            // InternalTGG.g:6277:2: ( ruleUsing )
            {
            // InternalTGG.g:6277:2: ( ruleUsing )
            // InternalTGG.g:6278:3: ruleUsing
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
    // InternalTGG.g:6287:1: rule__TripleGraphGrammarFile__SchemaAssignment_2 : ( ruleSchema ) ;
    public final void rule__TripleGraphGrammarFile__SchemaAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6291:1: ( ( ruleSchema ) )
            // InternalTGG.g:6292:2: ( ruleSchema )
            {
            // InternalTGG.g:6292:2: ( ruleSchema )
            // InternalTGG.g:6293:3: ruleSchema
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
    // InternalTGG.g:6302:1: rule__TripleGraphGrammarFile__RulesAssignment_3 : ( ruleRule ) ;
    public final void rule__TripleGraphGrammarFile__RulesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6306:1: ( ( ruleRule ) )
            // InternalTGG.g:6307:2: ( ruleRule )
            {
            // InternalTGG.g:6307:2: ( ruleRule )
            // InternalTGG.g:6308:3: ruleRule
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
    // InternalTGG.g:6317:1: rule__TripleGraphGrammarFile__LibraryAssignment_4 : ( ruleAttrCondDefLibrary ) ;
    public final void rule__TripleGraphGrammarFile__LibraryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6321:1: ( ( ruleAttrCondDefLibrary ) )
            // InternalTGG.g:6322:2: ( ruleAttrCondDefLibrary )
            {
            // InternalTGG.g:6322:2: ( ruleAttrCondDefLibrary )
            // InternalTGG.g:6323:3: ruleAttrCondDefLibrary
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
    // InternalTGG.g:6332:1: rule__Schema__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Schema__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6336:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6337:2: ( ruleQualifiedName )
            {
            // InternalTGG.g:6337:2: ( ruleQualifiedName )
            // InternalTGG.g:6338:3: ruleQualifiedName
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
    // InternalTGG.g:6347:1: rule__Schema__SourceTypesAssignment_2_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Schema__SourceTypesAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6351:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:6352:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:6352:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6353:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getSchemaAccess().getSourceTypesEPackageCrossReference_2_2_0()); 
            // InternalTGG.g:6354:3: ( ruleQualifiedName )
            // InternalTGG.g:6355:4: ruleQualifiedName
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
    // InternalTGG.g:6366:1: rule__Schema__TargetTypesAssignment_3_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Schema__TargetTypesAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6370:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:6371:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:6371:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6372:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getSchemaAccess().getTargetTypesEPackageCrossReference_3_2_0()); 
            // InternalTGG.g:6373:3: ( ruleQualifiedName )
            // InternalTGG.g:6374:4: ruleQualifiedName
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
    // InternalTGG.g:6385:1: rule__Schema__CorrespondenceTypesAssignment_4_2 : ( ruleCorrType ) ;
    public final void rule__Schema__CorrespondenceTypesAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6389:1: ( ( ruleCorrType ) )
            // InternalTGG.g:6390:2: ( ruleCorrType )
            {
            // InternalTGG.g:6390:2: ( ruleCorrType )
            // InternalTGG.g:6391:3: ruleCorrType
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
    // InternalTGG.g:6400:1: rule__Schema__AttributeCondDefsAssignment_5_2 : ( ruleAttrCondDef ) ;
    public final void rule__Schema__AttributeCondDefsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6404:1: ( ( ruleAttrCondDef ) )
            // InternalTGG.g:6405:2: ( ruleAttrCondDef )
            {
            // InternalTGG.g:6405:2: ( ruleAttrCondDef )
            // InternalTGG.g:6406:3: ruleAttrCondDef
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
    // InternalTGG.g:6415:1: rule__CorrType__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__CorrType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6419:1: ( ( RULE_ID ) )
            // InternalTGG.g:6420:2: ( RULE_ID )
            {
            // InternalTGG.g:6420:2: ( RULE_ID )
            // InternalTGG.g:6421:3: RULE_ID
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
    // InternalTGG.g:6430:1: rule__CorrType__SuperAssignment_1_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__CorrType__SuperAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6434:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:6435:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:6435:2: ( ( RULE_ID ) )
            // InternalTGG.g:6436:3: ( RULE_ID )
            {
             before(grammarAccess.getCorrTypeAccess().getSuperCorrTypeCrossReference_1_0_1_0()); 
            // InternalTGG.g:6437:3: ( RULE_ID )
            // InternalTGG.g:6438:4: RULE_ID
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
    // InternalTGG.g:6449:1: rule__CorrType__SourceAssignment_1_1_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CorrType__SourceAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6453:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:6454:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:6454:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6455:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getCorrTypeAccess().getSourceEClassCrossReference_1_1_2_0()); 
            // InternalTGG.g:6456:3: ( ruleQualifiedName )
            // InternalTGG.g:6457:4: ruleQualifiedName
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
    // InternalTGG.g:6468:1: rule__CorrType__TargetAssignment_1_1_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CorrType__TargetAssignment_1_1_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6472:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:6473:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:6473:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6474:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getCorrTypeAccess().getTargetEClassCrossReference_1_1_4_0()); 
            // InternalTGG.g:6475:3: ( ruleQualifiedName )
            // InternalTGG.g:6476:4: ruleQualifiedName
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
    // InternalTGG.g:6487:1: rule__AttrCondDef__UserDefinedAssignment_0 : ( ( '#userDefined' ) ) ;
    public final void rule__AttrCondDef__UserDefinedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6491:1: ( ( ( '#userDefined' ) ) )
            // InternalTGG.g:6492:2: ( ( '#userDefined' ) )
            {
            // InternalTGG.g:6492:2: ( ( '#userDefined' ) )
            // InternalTGG.g:6493:3: ( '#userDefined' )
            {
             before(grammarAccess.getAttrCondDefAccess().getUserDefinedUserDefinedKeyword_0_0()); 
            // InternalTGG.g:6494:3: ( '#userDefined' )
            // InternalTGG.g:6495:4: '#userDefined'
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
    // InternalTGG.g:6506:1: rule__AttrCondDef__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__AttrCondDef__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6510:1: ( ( RULE_ID ) )
            // InternalTGG.g:6511:2: ( RULE_ID )
            {
            // InternalTGG.g:6511:2: ( RULE_ID )
            // InternalTGG.g:6512:3: RULE_ID
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
    // InternalTGG.g:6521:1: rule__AttrCondDef__ParamsAssignment_3_0 : ( ruleParam ) ;
    public final void rule__AttrCondDef__ParamsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6525:1: ( ( ruleParam ) )
            // InternalTGG.g:6526:2: ( ruleParam )
            {
            // InternalTGG.g:6526:2: ( ruleParam )
            // InternalTGG.g:6527:3: ruleParam
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
    // InternalTGG.g:6536:1: rule__AttrCondDef__ParamsAssignment_3_1_1 : ( ruleParam ) ;
    public final void rule__AttrCondDef__ParamsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6540:1: ( ( ruleParam ) )
            // InternalTGG.g:6541:2: ( ruleParam )
            {
            // InternalTGG.g:6541:2: ( ruleParam )
            // InternalTGG.g:6542:3: ruleParam
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
    // InternalTGG.g:6551:1: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedSyncAdornmentsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6555:1: ( ( ruleAdornment ) )
            // InternalTGG.g:6556:2: ( ruleAdornment )
            {
            // InternalTGG.g:6556:2: ( ruleAdornment )
            // InternalTGG.g:6557:3: ruleAdornment
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
    // InternalTGG.g:6566:1: rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedSyncAdornmentsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6570:1: ( ( ruleAdornment ) )
            // InternalTGG.g:6571:2: ( ruleAdornment )
            {
            // InternalTGG.g:6571:2: ( ruleAdornment )
            // InternalTGG.g:6572:3: ruleAdornment
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
    // InternalTGG.g:6581:1: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6585:1: ( ( ruleAdornment ) )
            // InternalTGG.g:6586:2: ( ruleAdornment )
            {
            // InternalTGG.g:6586:2: ( ruleAdornment )
            // InternalTGG.g:6587:3: ruleAdornment
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
    // InternalTGG.g:6596:1: rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1 : ( ruleAdornment ) ;
    public final void rule__AttrCondDef__AllowedGenAdornmentsAssignment_9_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6600:1: ( ( ruleAdornment ) )
            // InternalTGG.g:6601:2: ( ruleAdornment )
            {
            // InternalTGG.g:6601:2: ( ruleAdornment )
            // InternalTGG.g:6602:3: ruleAdornment
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
    // InternalTGG.g:6611:1: rule__Param__ParamNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Param__ParamNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6615:1: ( ( RULE_ID ) )
            // InternalTGG.g:6616:2: ( RULE_ID )
            {
            // InternalTGG.g:6616:2: ( RULE_ID )
            // InternalTGG.g:6617:3: RULE_ID
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
    // InternalTGG.g:6626:1: rule__Param__TypeAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Param__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6630:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:6631:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:6631:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6632:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getParamAccess().getTypeEDataTypeCrossReference_2_0()); 
            // InternalTGG.g:6633:3: ( ruleQualifiedName )
            // InternalTGG.g:6634:4: ruleQualifiedName
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
    // InternalTGG.g:6645:1: rule__Rule__AbstractRuleAssignment_0 : ( ( '#abstract' ) ) ;
    public final void rule__Rule__AbstractRuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6649:1: ( ( ( '#abstract' ) ) )
            // InternalTGG.g:6650:2: ( ( '#abstract' ) )
            {
            // InternalTGG.g:6650:2: ( ( '#abstract' ) )
            // InternalTGG.g:6651:3: ( '#abstract' )
            {
             before(grammarAccess.getRuleAccess().getAbstractRuleAbstractKeyword_0_0()); 
            // InternalTGG.g:6652:3: ( '#abstract' )
            // InternalTGG.g:6653:4: '#abstract'
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
    // InternalTGG.g:6664:1: rule__Rule__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Rule__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6668:1: ( ( RULE_ID ) )
            // InternalTGG.g:6669:2: ( RULE_ID )
            {
            // InternalTGG.g:6669:2: ( RULE_ID )
            // InternalTGG.g:6670:3: RULE_ID
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
    // InternalTGG.g:6679:1: rule__Rule__SupertypesAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Rule__SupertypesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6683:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:6684:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:6684:2: ( ( RULE_ID ) )
            // InternalTGG.g:6685:3: ( RULE_ID )
            {
             before(grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_1_0()); 
            // InternalTGG.g:6686:3: ( RULE_ID )
            // InternalTGG.g:6687:4: RULE_ID
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
    // InternalTGG.g:6698:1: rule__Rule__SupertypesAssignment_3_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Rule__SupertypesAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6702:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:6703:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:6703:2: ( ( RULE_ID ) )
            // InternalTGG.g:6704:3: ( RULE_ID )
            {
             before(grammarAccess.getRuleAccess().getSupertypesRuleCrossReference_3_2_1_0()); 
            // InternalTGG.g:6705:3: ( RULE_ID )
            // InternalTGG.g:6706:4: RULE_ID
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
    // InternalTGG.g:6717:1: rule__Rule__SchemaAssignment_5 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Rule__SchemaAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6721:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:6722:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:6722:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6723:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getRuleAccess().getSchemaSchemaCrossReference_5_0()); 
            // InternalTGG.g:6724:3: ( ruleQualifiedName )
            // InternalTGG.g:6725:4: ruleQualifiedName
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
    // InternalTGG.g:6736:1: rule__Rule__SourcePatternsAssignment_6_2 : ( ruleObjectVariablePattern ) ;
    public final void rule__Rule__SourcePatternsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6740:1: ( ( ruleObjectVariablePattern ) )
            // InternalTGG.g:6741:2: ( ruleObjectVariablePattern )
            {
            // InternalTGG.g:6741:2: ( ruleObjectVariablePattern )
            // InternalTGG.g:6742:3: ruleObjectVariablePattern
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
    // InternalTGG.g:6751:1: rule__Rule__TargetPatternsAssignment_7_2 : ( ruleObjectVariablePattern ) ;
    public final void rule__Rule__TargetPatternsAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6755:1: ( ( ruleObjectVariablePattern ) )
            // InternalTGG.g:6756:2: ( ruleObjectVariablePattern )
            {
            // InternalTGG.g:6756:2: ( ruleObjectVariablePattern )
            // InternalTGG.g:6757:3: ruleObjectVariablePattern
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
    // InternalTGG.g:6766:1: rule__Rule__CorrespondencePatternsAssignment_8_2 : ( ruleCorrVariablePattern ) ;
    public final void rule__Rule__CorrespondencePatternsAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6770:1: ( ( ruleCorrVariablePattern ) )
            // InternalTGG.g:6771:2: ( ruleCorrVariablePattern )
            {
            // InternalTGG.g:6771:2: ( ruleCorrVariablePattern )
            // InternalTGG.g:6772:3: ruleCorrVariablePattern
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
    // InternalTGG.g:6781:1: rule__Rule__AttrConditionsAssignment_9_2 : ( ruleAttrCond ) ;
    public final void rule__Rule__AttrConditionsAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6785:1: ( ( ruleAttrCond ) )
            // InternalTGG.g:6786:2: ( ruleAttrCond )
            {
            // InternalTGG.g:6786:2: ( ruleAttrCond )
            // InternalTGG.g:6787:3: ruleAttrCond
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
    // InternalTGG.g:6796:1: rule__AttrCond__NameAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AttrCond__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6800:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:6801:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:6801:2: ( ( RULE_ID ) )
            // InternalTGG.g:6802:3: ( RULE_ID )
            {
             before(grammarAccess.getAttrCondAccess().getNameAttrCondDefCrossReference_0_0()); 
            // InternalTGG.g:6803:3: ( RULE_ID )
            // InternalTGG.g:6804:4: RULE_ID
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
    // InternalTGG.g:6815:1: rule__AttrCond__ValuesAssignment_2_0 : ( ruleParamValue ) ;
    public final void rule__AttrCond__ValuesAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6819:1: ( ( ruleParamValue ) )
            // InternalTGG.g:6820:2: ( ruleParamValue )
            {
            // InternalTGG.g:6820:2: ( ruleParamValue )
            // InternalTGG.g:6821:3: ruleParamValue
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
    // InternalTGG.g:6830:1: rule__AttrCond__ValuesAssignment_2_1_1 : ( ruleParamValue ) ;
    public final void rule__AttrCond__ValuesAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6834:1: ( ( ruleParamValue ) )
            // InternalTGG.g:6835:2: ( ruleParamValue )
            {
            // InternalTGG.g:6835:2: ( ruleParamValue )
            // InternalTGG.g:6836:3: ruleParamValue
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
    // InternalTGG.g:6845:1: rule__AttrCondDefLibrary__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__AttrCondDefLibrary__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6849:1: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6850:2: ( ruleQualifiedName )
            {
            // InternalTGG.g:6850:2: ( ruleQualifiedName )
            // InternalTGG.g:6851:3: ruleQualifiedName
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
    // InternalTGG.g:6860:1: rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1 : ( ruleAttrCondDef ) ;
    public final void rule__AttrCondDefLibrary__AttributeCondDefsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6864:1: ( ( ruleAttrCondDef ) )
            // InternalTGG.g:6865:2: ( ruleAttrCondDef )
            {
            // InternalTGG.g:6865:2: ( ruleAttrCondDef )
            // InternalTGG.g:6866:3: ruleAttrCondDef
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
    // InternalTGG.g:6875:1: rule__Adornment__ValueAssignment_1 : ( ( rule__Adornment__ValueAlternatives_1_0 ) ) ;
    public final void rule__Adornment__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6879:1: ( ( ( rule__Adornment__ValueAlternatives_1_0 ) ) )
            // InternalTGG.g:6880:2: ( ( rule__Adornment__ValueAlternatives_1_0 ) )
            {
            // InternalTGG.g:6880:2: ( ( rule__Adornment__ValueAlternatives_1_0 ) )
            // InternalTGG.g:6881:3: ( rule__Adornment__ValueAlternatives_1_0 )
            {
             before(grammarAccess.getAdornmentAccess().getValueAlternatives_1_0()); 
            // InternalTGG.g:6882:3: ( rule__Adornment__ValueAlternatives_1_0 )
            // InternalTGG.g:6882:4: rule__Adornment__ValueAlternatives_1_0
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
    // InternalTGG.g:6890:1: rule__LocalVariable__NameAssignment : ( RULE_ID ) ;
    public final void rule__LocalVariable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6894:1: ( ( RULE_ID ) )
            // InternalTGG.g:6895:2: ( RULE_ID )
            {
            // InternalTGG.g:6895:2: ( RULE_ID )
            // InternalTGG.g:6896:3: RULE_ID
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
    // InternalTGG.g:6905:1: rule__CorrVariablePattern__OpAssignment_0 : ( ruleOperator ) ;
    public final void rule__CorrVariablePattern__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6909:1: ( ( ruleOperator ) )
            // InternalTGG.g:6910:2: ( ruleOperator )
            {
            // InternalTGG.g:6910:2: ( ruleOperator )
            // InternalTGG.g:6911:3: ruleOperator
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
    // InternalTGG.g:6920:1: rule__CorrVariablePattern__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CorrVariablePattern__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6924:1: ( ( RULE_ID ) )
            // InternalTGG.g:6925:2: ( RULE_ID )
            {
            // InternalTGG.g:6925:2: ( RULE_ID )
            // InternalTGG.g:6926:3: RULE_ID
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
    // InternalTGG.g:6935:1: rule__CorrVariablePattern__TypeAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__CorrVariablePattern__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6939:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:6940:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:6940:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:6941:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTypeCorrTypeCrossReference_3_0()); 
            // InternalTGG.g:6942:3: ( ruleQualifiedName )
            // InternalTGG.g:6943:4: ruleQualifiedName
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
    // InternalTGG.g:6954:1: rule__CorrVariablePattern__SourceAssignment_6 : ( ( RULE_ID ) ) ;
    public final void rule__CorrVariablePattern__SourceAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6958:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:6959:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:6959:2: ( ( RULE_ID ) )
            // InternalTGG.g:6960:3: ( RULE_ID )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getSourceObjectVariablePatternCrossReference_6_0()); 
            // InternalTGG.g:6961:3: ( RULE_ID )
            // InternalTGG.g:6962:4: RULE_ID
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
    // InternalTGG.g:6973:1: rule__CorrVariablePattern__TargetAssignment_8 : ( ( RULE_ID ) ) ;
    public final void rule__CorrVariablePattern__TargetAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6977:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:6978:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:6978:2: ( ( RULE_ID ) )
            // InternalTGG.g:6979:3: ( RULE_ID )
            {
             before(grammarAccess.getCorrVariablePatternAccess().getTargetObjectVariablePatternCrossReference_8_0()); 
            // InternalTGG.g:6980:3: ( RULE_ID )
            // InternalTGG.g:6981:4: RULE_ID
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
    // InternalTGG.g:6992:1: rule__ObjectVariablePattern__OpAssignment_0 : ( ruleOperator ) ;
    public final void rule__ObjectVariablePattern__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:6996:1: ( ( ruleOperator ) )
            // InternalTGG.g:6997:2: ( ruleOperator )
            {
            // InternalTGG.g:6997:2: ( ruleOperator )
            // InternalTGG.g:6998:3: ruleOperator
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
    // InternalTGG.g:7007:1: rule__ObjectVariablePattern__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__ObjectVariablePattern__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7011:1: ( ( RULE_ID ) )
            // InternalTGG.g:7012:2: ( RULE_ID )
            {
            // InternalTGG.g:7012:2: ( RULE_ID )
            // InternalTGG.g:7013:3: RULE_ID
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
    // InternalTGG.g:7022:1: rule__ObjectVariablePattern__TypeAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ObjectVariablePattern__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7026:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7027:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7027:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7028:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getObjectVariablePatternAccess().getTypeEClassCrossReference_3_0()); 
            // InternalTGG.g:7029:3: ( ruleQualifiedName )
            // InternalTGG.g:7030:4: ruleQualifiedName
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
    // InternalTGG.g:7041:1: rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1 : ( ruleAttributeAssignment ) ;
    public final void rule__ObjectVariablePattern__AttributeAssignmentsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7045:1: ( ( ruleAttributeAssignment ) )
            // InternalTGG.g:7046:2: ( ruleAttributeAssignment )
            {
            // InternalTGG.g:7046:2: ( ruleAttributeAssignment )
            // InternalTGG.g:7047:3: ruleAttributeAssignment
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
    // InternalTGG.g:7056:1: rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2 : ( ruleAttributeConstraint ) ;
    public final void rule__ObjectVariablePattern__AttributeConstraintsAssignment_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7060:1: ( ( ruleAttributeConstraint ) )
            // InternalTGG.g:7061:2: ( ruleAttributeConstraint )
            {
            // InternalTGG.g:7061:2: ( ruleAttributeConstraint )
            // InternalTGG.g:7062:3: ruleAttributeConstraint
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
    // InternalTGG.g:7071:1: rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3 : ( ruleLinkVariablePattern ) ;
    public final void rule__ObjectVariablePattern__LinkVariablePatternsAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7075:1: ( ( ruleLinkVariablePattern ) )
            // InternalTGG.g:7076:2: ( ruleLinkVariablePattern )
            {
            // InternalTGG.g:7076:2: ( ruleLinkVariablePattern )
            // InternalTGG.g:7077:3: ruleLinkVariablePattern
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
    // InternalTGG.g:7086:1: rule__ContextObjectVariablePattern__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ContextObjectVariablePattern__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7090:1: ( ( RULE_ID ) )
            // InternalTGG.g:7091:2: ( RULE_ID )
            {
            // InternalTGG.g:7091:2: ( RULE_ID )
            // InternalTGG.g:7092:3: RULE_ID
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
    // InternalTGG.g:7101:1: rule__ContextObjectVariablePattern__TypeAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ContextObjectVariablePattern__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7105:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7106:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7106:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7107:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getContextObjectVariablePatternAccess().getTypeEClassCrossReference_2_0()); 
            // InternalTGG.g:7108:3: ( ruleQualifiedName )
            // InternalTGG.g:7109:4: ruleQualifiedName
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
    // InternalTGG.g:7120:1: rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1 : ( ruleAttributeConstraint ) ;
    public final void rule__ContextObjectVariablePattern__AttributeConstraintsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7124:1: ( ( ruleAttributeConstraint ) )
            // InternalTGG.g:7125:2: ( ruleAttributeConstraint )
            {
            // InternalTGG.g:7125:2: ( ruleAttributeConstraint )
            // InternalTGG.g:7126:3: ruleAttributeConstraint
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
    // InternalTGG.g:7135:1: rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2 : ( ruleContextLinkVariablePattern ) ;
    public final void rule__ContextObjectVariablePattern__LinkVariablePatternsAssignment_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7139:1: ( ( ruleContextLinkVariablePattern ) )
            // InternalTGG.g:7140:2: ( ruleContextLinkVariablePattern )
            {
            // InternalTGG.g:7140:2: ( ruleContextLinkVariablePattern )
            // InternalTGG.g:7141:3: ruleContextLinkVariablePattern
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
    // InternalTGG.g:7150:1: rule__AttributeConstraint__AttributeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeConstraint__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7154:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7155:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7155:2: ( ( RULE_ID ) )
            // InternalTGG.g:7156:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeConstraintAccess().getAttributeEAttributeCrossReference_0_0()); 
            // InternalTGG.g:7157:3: ( RULE_ID )
            // InternalTGG.g:7158:4: RULE_ID
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
    // InternalTGG.g:7169:1: rule__AttributeConstraint__OpAssignment_1 : ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) ) ;
    public final void rule__AttributeConstraint__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7173:1: ( ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) ) )
            // InternalTGG.g:7174:2: ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) )
            {
            // InternalTGG.g:7174:2: ( ( rule__AttributeConstraint__OpAlternatives_1_0 ) )
            // InternalTGG.g:7175:3: ( rule__AttributeConstraint__OpAlternatives_1_0 )
            {
             before(grammarAccess.getAttributeConstraintAccess().getOpAlternatives_1_0()); 
            // InternalTGG.g:7176:3: ( rule__AttributeConstraint__OpAlternatives_1_0 )
            // InternalTGG.g:7176:4: rule__AttributeConstraint__OpAlternatives_1_0
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
    // InternalTGG.g:7184:1: rule__AttributeConstraint__ValueExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__AttributeConstraint__ValueExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7188:1: ( ( ruleExpression ) )
            // InternalTGG.g:7189:2: ( ruleExpression )
            {
            // InternalTGG.g:7189:2: ( ruleExpression )
            // InternalTGG.g:7190:3: ruleExpression
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
    // InternalTGG.g:7199:1: rule__AttributeAssignment__AttributeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeAssignment__AttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7203:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7204:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7204:2: ( ( RULE_ID ) )
            // InternalTGG.g:7205:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getAttributeEAttributeCrossReference_0_0()); 
            // InternalTGG.g:7206:3: ( RULE_ID )
            // InternalTGG.g:7207:4: RULE_ID
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
    // InternalTGG.g:7218:1: rule__AttributeAssignment__OpAssignment_1 : ( ( ':=' ) ) ;
    public final void rule__AttributeAssignment__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7222:1: ( ( ( ':=' ) ) )
            // InternalTGG.g:7223:2: ( ( ':=' ) )
            {
            // InternalTGG.g:7223:2: ( ( ':=' ) )
            // InternalTGG.g:7224:3: ( ':=' )
            {
             before(grammarAccess.getAttributeAssignmentAccess().getOpColonEqualsSignKeyword_1_0()); 
            // InternalTGG.g:7225:3: ( ':=' )
            // InternalTGG.g:7226:4: ':='
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
    // InternalTGG.g:7237:1: rule__AttributeAssignment__ValueExpAssignment_2 : ( ruleExpression ) ;
    public final void rule__AttributeAssignment__ValueExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7241:1: ( ( ruleExpression ) )
            // InternalTGG.g:7242:2: ( ruleExpression )
            {
            // InternalTGG.g:7242:2: ( ruleExpression )
            // InternalTGG.g:7243:3: ruleExpression
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
    // InternalTGG.g:7252:1: rule__EnumExpression__EenumAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumExpression__EenumAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7256:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7257:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7257:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7258:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getEnumExpressionAccess().getEenumEEnumCrossReference_1_0()); 
            // InternalTGG.g:7259:3: ( ruleQualifiedName )
            // InternalTGG.g:7260:4: ruleQualifiedName
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
    // InternalTGG.g:7271:1: rule__EnumExpression__LiteralAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__EnumExpression__LiteralAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7275:1: ( ( ( ruleQualifiedName ) ) )
            // InternalTGG.g:7276:2: ( ( ruleQualifiedName ) )
            {
            // InternalTGG.g:7276:2: ( ( ruleQualifiedName ) )
            // InternalTGG.g:7277:3: ( ruleQualifiedName )
            {
             before(grammarAccess.getEnumExpressionAccess().getLiteralEEnumLiteralCrossReference_3_0()); 
            // InternalTGG.g:7278:3: ( ruleQualifiedName )
            // InternalTGG.g:7279:4: ruleQualifiedName
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
    // InternalTGG.g:7290:1: rule__AttributeExpression__DerivedAssignment_0 : ( ( '#derived' ) ) ;
    public final void rule__AttributeExpression__DerivedAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7294:1: ( ( ( '#derived' ) ) )
            // InternalTGG.g:7295:2: ( ( '#derived' ) )
            {
            // InternalTGG.g:7295:2: ( ( '#derived' ) )
            // InternalTGG.g:7296:3: ( '#derived' )
            {
             before(grammarAccess.getAttributeExpressionAccess().getDerivedDerivedKeyword_0_0()); 
            // InternalTGG.g:7297:3: ( '#derived' )
            // InternalTGG.g:7298:4: '#derived'
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
    // InternalTGG.g:7309:1: rule__AttributeExpression__ObjectVarAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeExpression__ObjectVarAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7313:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7314:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7314:2: ( ( RULE_ID ) )
            // InternalTGG.g:7315:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeExpressionAccess().getObjectVarEObjectCrossReference_1_0()); 
            // InternalTGG.g:7316:3: ( RULE_ID )
            // InternalTGG.g:7317:4: RULE_ID
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
    // InternalTGG.g:7328:1: rule__AttributeExpression__AttributeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__AttributeExpression__AttributeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7332:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7333:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7333:2: ( ( RULE_ID ) )
            // InternalTGG.g:7334:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeExpressionAccess().getAttributeEAttributeCrossReference_3_0()); 
            // InternalTGG.g:7335:3: ( RULE_ID )
            // InternalTGG.g:7336:4: RULE_ID
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
    // InternalTGG.g:7347:1: rule__LiteralExpression__ValueAssignment : ( ruleLiteralValue ) ;
    public final void rule__LiteralExpression__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7351:1: ( ( ruleLiteralValue ) )
            // InternalTGG.g:7352:2: ( ruleLiteralValue )
            {
            // InternalTGG.g:7352:2: ( ruleLiteralValue )
            // InternalTGG.g:7353:3: ruleLiteralValue
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
    // InternalTGG.g:7362:1: rule__LinkVariablePattern__OpAssignment_0 : ( ruleOperator ) ;
    public final void rule__LinkVariablePattern__OpAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7366:1: ( ( ruleOperator ) )
            // InternalTGG.g:7367:2: ( ruleOperator )
            {
            // InternalTGG.g:7367:2: ( ruleOperator )
            // InternalTGG.g:7368:3: ruleOperator
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
    // InternalTGG.g:7377:1: rule__LinkVariablePattern__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__LinkVariablePattern__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7381:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7382:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7382:2: ( ( RULE_ID ) )
            // InternalTGG.g:7383:3: ( RULE_ID )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTypeEReferenceCrossReference_2_0()); 
            // InternalTGG.g:7384:3: ( RULE_ID )
            // InternalTGG.g:7385:4: RULE_ID
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
    // InternalTGG.g:7396:1: rule__LinkVariablePattern__TargetAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__LinkVariablePattern__TargetAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7400:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7401:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7401:2: ( ( RULE_ID ) )
            // InternalTGG.g:7402:3: ( RULE_ID )
            {
             before(grammarAccess.getLinkVariablePatternAccess().getTargetObjectVariablePatternCrossReference_4_0()); 
            // InternalTGG.g:7403:3: ( RULE_ID )
            // InternalTGG.g:7404:4: RULE_ID
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
    // InternalTGG.g:7415:1: rule__ContextLinkVariablePattern__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__ContextLinkVariablePattern__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7419:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7420:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7420:2: ( ( RULE_ID ) )
            // InternalTGG.g:7421:3: ( RULE_ID )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTypeEReferenceCrossReference_1_0()); 
            // InternalTGG.g:7422:3: ( RULE_ID )
            // InternalTGG.g:7423:4: RULE_ID
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
    // InternalTGG.g:7434:1: rule__ContextLinkVariablePattern__TargetAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ContextLinkVariablePattern__TargetAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7438:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7439:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7439:2: ( ( RULE_ID ) )
            // InternalTGG.g:7440:3: ( RULE_ID )
            {
             before(grammarAccess.getContextLinkVariablePatternAccess().getTargetContextObjectVariablePatternCrossReference_3_0()); 
            // InternalTGG.g:7441:3: ( RULE_ID )
            // InternalTGG.g:7442:4: RULE_ID
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
    // InternalTGG.g:7453:1: rule__Operator__ValueAssignment : ( ( '++' ) ) ;
    public final void rule__Operator__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7457:1: ( ( ( '++' ) ) )
            // InternalTGG.g:7458:2: ( ( '++' ) )
            {
            // InternalTGG.g:7458:2: ( ( '++' ) )
            // InternalTGG.g:7459:3: ( '++' )
            {
             before(grammarAccess.getOperatorAccess().getValuePlusSignPlusSignKeyword_0()); 
            // InternalTGG.g:7460:3: ( '++' )
            // InternalTGG.g:7461:4: '++'
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
    // InternalTGG.g:7472:1: rule__Nac__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Nac__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7476:1: ( ( RULE_ID ) )
            // InternalTGG.g:7477:2: ( RULE_ID )
            {
            // InternalTGG.g:7477:2: ( RULE_ID )
            // InternalTGG.g:7478:3: RULE_ID
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
    // InternalTGG.g:7487:1: rule__Nac__RuleAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Nac__RuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7491:1: ( ( ( RULE_ID ) ) )
            // InternalTGG.g:7492:2: ( ( RULE_ID ) )
            {
            // InternalTGG.g:7492:2: ( ( RULE_ID ) )
            // InternalTGG.g:7493:3: ( RULE_ID )
            {
             before(grammarAccess.getNacAccess().getRuleRuleCrossReference_3_0()); 
            // InternalTGG.g:7494:3: ( RULE_ID )
            // InternalTGG.g:7495:4: RULE_ID
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
    // InternalTGG.g:7506:1: rule__Nac__SourcePatternsAssignment_4_0_2 : ( ruleContextObjectVariablePattern ) ;
    public final void rule__Nac__SourcePatternsAssignment_4_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7510:1: ( ( ruleContextObjectVariablePattern ) )
            // InternalTGG.g:7511:2: ( ruleContextObjectVariablePattern )
            {
            // InternalTGG.g:7511:2: ( ruleContextObjectVariablePattern )
            // InternalTGG.g:7512:3: ruleContextObjectVariablePattern
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
    // InternalTGG.g:7521:1: rule__Nac__TargetPatternsAssignment_4_1_2 : ( ruleContextObjectVariablePattern ) ;
    public final void rule__Nac__TargetPatternsAssignment_4_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7525:1: ( ( ruleContextObjectVariablePattern ) )
            // InternalTGG.g:7526:2: ( ruleContextObjectVariablePattern )
            {
            // InternalTGG.g:7526:2: ( ruleContextObjectVariablePattern )
            // InternalTGG.g:7527:3: ruleContextObjectVariablePattern
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
    // InternalTGG.g:7536:1: rule__Nac__AttrConditionsAssignment_5_2 : ( ruleAttrCond ) ;
    public final void rule__Nac__AttrConditionsAssignment_5_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7540:1: ( ( ruleAttrCond ) )
            // InternalTGG.g:7541:2: ( ruleAttrCond )
            {
            // InternalTGG.g:7541:2: ( ruleAttrCond )
            // InternalTGG.g:7542:3: ruleAttrCond
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
    // InternalTGG.g:7551:1: rule__Import__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7555:1: ( ( RULE_STRING ) )
            // InternalTGG.g:7556:2: ( RULE_STRING )
            {
            // InternalTGG.g:7556:2: ( RULE_STRING )
            // InternalTGG.g:7557:3: RULE_STRING
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
    // InternalTGG.g:7566:1: rule__Using__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Using__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalTGG.g:7570:1: ( ( ruleQualifiedNameWithWildcard ) )
            // InternalTGG.g:7571:2: ( ruleQualifiedNameWithWildcard )
            {
            // InternalTGG.g:7571:2: ( ruleQualifiedNameWithWildcard )
            // InternalTGG.g:7572:3: ruleQualifiedNameWithWildcard
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
            return "991:1: rule__NamePattern__Alternatives : ( ( ruleCorrVariablePattern ) | ( ruleObjectVariablePattern ) );";
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