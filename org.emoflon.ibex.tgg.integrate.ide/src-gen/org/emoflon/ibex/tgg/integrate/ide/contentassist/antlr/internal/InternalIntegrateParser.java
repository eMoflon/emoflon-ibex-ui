package org.emoflon.ibex.tgg.integrate.ide.contentassist.antlr.internal;

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
import org.emoflon.ibex.tgg.integrate.services.IntegrateGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalIntegrateParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'>'", "'>='", "'<'", "'<='", "'actAndLetRepair'", "'mergeAndPreserve'", "'preferSource'", "'preferTarget'", "'revokeAddition'", "'revokeDeletion'", "'#import'", "'solve'", "'conflict'", "'for'", "'all'", "'{'", "'satisfies'", "'}'", "'with'", "'var'", "'='", "'|'", "'and'", "'or'", "'#src'", "'#trg'", "'created'", "'deleted'", "'type'", "'count'"
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

    	public void setGrammarAccess(IntegrateGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleIntegrate"
    // InternalIntegrate.g:53:1: entryRuleIntegrate : ruleIntegrate EOF ;
    public final void entryRuleIntegrate() throws RecognitionException {
        try {
            // InternalIntegrate.g:54:1: ( ruleIntegrate EOF )
            // InternalIntegrate.g:55:1: ruleIntegrate EOF
            {
             before(grammarAccess.getIntegrateRule()); 
            pushFollow(FOLLOW_1);
            ruleIntegrate();

            state._fsp--;

             after(grammarAccess.getIntegrateRule()); 
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
    // $ANTLR end "entryRuleIntegrate"


    // $ANTLR start "ruleIntegrate"
    // InternalIntegrate.g:62:1: ruleIntegrate : ( ( rule__Integrate__Group__0 ) ) ;
    public final void ruleIntegrate() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:66:2: ( ( ( rule__Integrate__Group__0 ) ) )
            // InternalIntegrate.g:67:2: ( ( rule__Integrate__Group__0 ) )
            {
            // InternalIntegrate.g:67:2: ( ( rule__Integrate__Group__0 ) )
            // InternalIntegrate.g:68:3: ( rule__Integrate__Group__0 )
            {
             before(grammarAccess.getIntegrateAccess().getGroup()); 
            // InternalIntegrate.g:69:3: ( rule__Integrate__Group__0 )
            // InternalIntegrate.g:69:4: rule__Integrate__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Integrate__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntegrateAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegrate"


    // $ANTLR start "entryRuleImport"
    // InternalIntegrate.g:78:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalIntegrate.g:79:1: ( ruleImport EOF )
            // InternalIntegrate.g:80:1: ruleImport EOF
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
    // InternalIntegrate.g:87:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:91:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalIntegrate.g:92:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalIntegrate.g:92:2: ( ( rule__Import__Group__0 ) )
            // InternalIntegrate.g:93:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalIntegrate.g:94:3: ( rule__Import__Group__0 )
            // InternalIntegrate.g:94:4: rule__Import__Group__0
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


    // $ANTLR start "entryRuleConflictResolutionStrategy"
    // InternalIntegrate.g:103:1: entryRuleConflictResolutionStrategy : ruleConflictResolutionStrategy EOF ;
    public final void entryRuleConflictResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:104:1: ( ruleConflictResolutionStrategy EOF )
            // InternalIntegrate.g:105:1: ruleConflictResolutionStrategy EOF
            {
             before(grammarAccess.getConflictResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleConflictResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getConflictResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleConflictResolutionStrategy"


    // $ANTLR start "ruleConflictResolutionStrategy"
    // InternalIntegrate.g:112:1: ruleConflictResolutionStrategy : ( ( rule__ConflictResolutionStrategy__Group__0 ) ) ;
    public final void ruleConflictResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:116:2: ( ( ( rule__ConflictResolutionStrategy__Group__0 ) ) )
            // InternalIntegrate.g:117:2: ( ( rule__ConflictResolutionStrategy__Group__0 ) )
            {
            // InternalIntegrate.g:117:2: ( ( rule__ConflictResolutionStrategy__Group__0 ) )
            // InternalIntegrate.g:118:3: ( rule__ConflictResolutionStrategy__Group__0 )
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getGroup()); 
            // InternalIntegrate.g:119:3: ( rule__ConflictResolutionStrategy__Group__0 )
            // InternalIntegrate.g:119:4: rule__ConflictResolutionStrategy__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionStrategyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConflictResolutionStrategy"


    // $ANTLR start "entryRuleVariable"
    // InternalIntegrate.g:128:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalIntegrate.g:129:1: ( ruleVariable EOF )
            // InternalIntegrate.g:130:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
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
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalIntegrate.g:137:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:141:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalIntegrate.g:142:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalIntegrate.g:142:2: ( ( rule__Variable__Group__0 ) )
            // InternalIntegrate.g:143:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalIntegrate.g:144:3: ( rule__Variable__Group__0 )
            // InternalIntegrate.g:144:4: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRulePipeline"
    // InternalIntegrate.g:153:1: entryRulePipeline : rulePipeline EOF ;
    public final void entryRulePipeline() throws RecognitionException {
        try {
            // InternalIntegrate.g:154:1: ( rulePipeline EOF )
            // InternalIntegrate.g:155:1: rulePipeline EOF
            {
             before(grammarAccess.getPipelineRule()); 
            pushFollow(FOLLOW_1);
            rulePipeline();

            state._fsp--;

             after(grammarAccess.getPipelineRule()); 
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
    // $ANTLR end "entryRulePipeline"


    // $ANTLR start "rulePipeline"
    // InternalIntegrate.g:162:1: rulePipeline : ( ( rule__Pipeline__Group__0 ) ) ;
    public final void rulePipeline() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:166:2: ( ( ( rule__Pipeline__Group__0 ) ) )
            // InternalIntegrate.g:167:2: ( ( rule__Pipeline__Group__0 ) )
            {
            // InternalIntegrate.g:167:2: ( ( rule__Pipeline__Group__0 ) )
            // InternalIntegrate.g:168:3: ( rule__Pipeline__Group__0 )
            {
             before(grammarAccess.getPipelineAccess().getGroup()); 
            // InternalIntegrate.g:169:3: ( rule__Pipeline__Group__0 )
            // InternalIntegrate.g:169:4: rule__Pipeline__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Pipeline__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipeline"


    // $ANTLR start "entryRulePipelineStageSrc"
    // InternalIntegrate.g:178:1: entryRulePipelineStageSrc : rulePipelineStageSrc EOF ;
    public final void entryRulePipelineStageSrc() throws RecognitionException {
        try {
            // InternalIntegrate.g:179:1: ( rulePipelineStageSrc EOF )
            // InternalIntegrate.g:180:1: rulePipelineStageSrc EOF
            {
             before(grammarAccess.getPipelineStageSrcRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageSrc();

            state._fsp--;

             after(grammarAccess.getPipelineStageSrcRule()); 
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
    // $ANTLR end "entryRulePipelineStageSrc"


    // $ANTLR start "rulePipelineStageSrc"
    // InternalIntegrate.g:187:1: rulePipelineStageSrc : ( ( rule__PipelineStageSrc__NameAssignment ) ) ;
    public final void rulePipelineStageSrc() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:191:2: ( ( ( rule__PipelineStageSrc__NameAssignment ) ) )
            // InternalIntegrate.g:192:2: ( ( rule__PipelineStageSrc__NameAssignment ) )
            {
            // InternalIntegrate.g:192:2: ( ( rule__PipelineStageSrc__NameAssignment ) )
            // InternalIntegrate.g:193:3: ( rule__PipelineStageSrc__NameAssignment )
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNameAssignment()); 
            // InternalIntegrate.g:194:3: ( rule__PipelineStageSrc__NameAssignment )
            // InternalIntegrate.g:194:4: rule__PipelineStageSrc__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageSrcAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageSrc"


    // $ANTLR start "entryRulePipelineStageTrg"
    // InternalIntegrate.g:203:1: entryRulePipelineStageTrg : rulePipelineStageTrg EOF ;
    public final void entryRulePipelineStageTrg() throws RecognitionException {
        try {
            // InternalIntegrate.g:204:1: ( rulePipelineStageTrg EOF )
            // InternalIntegrate.g:205:1: rulePipelineStageTrg EOF
            {
             before(grammarAccess.getPipelineStageTrgRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageTrg();

            state._fsp--;

             after(grammarAccess.getPipelineStageTrgRule()); 
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
    // $ANTLR end "entryRulePipelineStageTrg"


    // $ANTLR start "rulePipelineStageTrg"
    // InternalIntegrate.g:212:1: rulePipelineStageTrg : ( ( rule__PipelineStageTrg__NameAssignment ) ) ;
    public final void rulePipelineStageTrg() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:216:2: ( ( ( rule__PipelineStageTrg__NameAssignment ) ) )
            // InternalIntegrate.g:217:2: ( ( rule__PipelineStageTrg__NameAssignment ) )
            {
            // InternalIntegrate.g:217:2: ( ( rule__PipelineStageTrg__NameAssignment ) )
            // InternalIntegrate.g:218:3: ( rule__PipelineStageTrg__NameAssignment )
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNameAssignment()); 
            // InternalIntegrate.g:219:3: ( rule__PipelineStageTrg__NameAssignment )
            // InternalIntegrate.g:219:4: rule__PipelineStageTrg__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTrgAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageTrg"


    // $ANTLR start "entryRulePipelineStage"
    // InternalIntegrate.g:228:1: entryRulePipelineStage : rulePipelineStage EOF ;
    public final void entryRulePipelineStage() throws RecognitionException {
        try {
            // InternalIntegrate.g:229:1: ( rulePipelineStage EOF )
            // InternalIntegrate.g:230:1: rulePipelineStage EOF
            {
             before(grammarAccess.getPipelineStageRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStage();

            state._fsp--;

             after(grammarAccess.getPipelineStageRule()); 
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
    // $ANTLR end "entryRulePipelineStage"


    // $ANTLR start "rulePipelineStage"
    // InternalIntegrate.g:237:1: rulePipelineStage : ( ( rule__PipelineStage__Alternatives ) ) ;
    public final void rulePipelineStage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:241:2: ( ( ( rule__PipelineStage__Alternatives ) ) )
            // InternalIntegrate.g:242:2: ( ( rule__PipelineStage__Alternatives ) )
            {
            // InternalIntegrate.g:242:2: ( ( rule__PipelineStage__Alternatives ) )
            // InternalIntegrate.g:243:3: ( rule__PipelineStage__Alternatives )
            {
             before(grammarAccess.getPipelineStageAccess().getAlternatives()); 
            // InternalIntegrate.g:244:3: ( rule__PipelineStage__Alternatives )
            // InternalIntegrate.g:244:4: rule__PipelineStage__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStage__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStage"


    // $ANTLR start "entryRulePipelineFilterStage"
    // InternalIntegrate.g:253:1: entryRulePipelineFilterStage : rulePipelineFilterStage EOF ;
    public final void entryRulePipelineFilterStage() throws RecognitionException {
        try {
            // InternalIntegrate.g:254:1: ( rulePipelineFilterStage EOF )
            // InternalIntegrate.g:255:1: rulePipelineFilterStage EOF
            {
             before(grammarAccess.getPipelineFilterStageRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineFilterStage();

            state._fsp--;

             after(grammarAccess.getPipelineFilterStageRule()); 
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
    // $ANTLR end "entryRulePipelineFilterStage"


    // $ANTLR start "rulePipelineFilterStage"
    // InternalIntegrate.g:262:1: rulePipelineFilterStage : ( ( rule__PipelineFilterStage__Alternatives ) ) ;
    public final void rulePipelineFilterStage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:266:2: ( ( ( rule__PipelineFilterStage__Alternatives ) ) )
            // InternalIntegrate.g:267:2: ( ( rule__PipelineFilterStage__Alternatives ) )
            {
            // InternalIntegrate.g:267:2: ( ( rule__PipelineFilterStage__Alternatives ) )
            // InternalIntegrate.g:268:3: ( rule__PipelineFilterStage__Alternatives )
            {
             before(grammarAccess.getPipelineFilterStageAccess().getAlternatives()); 
            // InternalIntegrate.g:269:3: ( rule__PipelineFilterStage__Alternatives )
            // InternalIntegrate.g:269:4: rule__PipelineFilterStage__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PipelineFilterStage__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPipelineFilterStageAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineFilterStage"


    // $ANTLR start "entryRulePipelineCreatedFilterStage"
    // InternalIntegrate.g:278:1: entryRulePipelineCreatedFilterStage : rulePipelineCreatedFilterStage EOF ;
    public final void entryRulePipelineCreatedFilterStage() throws RecognitionException {
        try {
            // InternalIntegrate.g:279:1: ( rulePipelineCreatedFilterStage EOF )
            // InternalIntegrate.g:280:1: rulePipelineCreatedFilterStage EOF
            {
             before(grammarAccess.getPipelineCreatedFilterStageRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineCreatedFilterStage();

            state._fsp--;

             after(grammarAccess.getPipelineCreatedFilterStageRule()); 
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
    // $ANTLR end "entryRulePipelineCreatedFilterStage"


    // $ANTLR start "rulePipelineCreatedFilterStage"
    // InternalIntegrate.g:287:1: rulePipelineCreatedFilterStage : ( ( rule__PipelineCreatedFilterStage__NameAssignment ) ) ;
    public final void rulePipelineCreatedFilterStage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:291:2: ( ( ( rule__PipelineCreatedFilterStage__NameAssignment ) ) )
            // InternalIntegrate.g:292:2: ( ( rule__PipelineCreatedFilterStage__NameAssignment ) )
            {
            // InternalIntegrate.g:292:2: ( ( rule__PipelineCreatedFilterStage__NameAssignment ) )
            // InternalIntegrate.g:293:3: ( rule__PipelineCreatedFilterStage__NameAssignment )
            {
             before(grammarAccess.getPipelineCreatedFilterStageAccess().getNameAssignment()); 
            // InternalIntegrate.g:294:3: ( rule__PipelineCreatedFilterStage__NameAssignment )
            // InternalIntegrate.g:294:4: rule__PipelineCreatedFilterStage__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PipelineCreatedFilterStage__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineCreatedFilterStageAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineCreatedFilterStage"


    // $ANTLR start "entryRulePipelineDeletedFilterStage"
    // InternalIntegrate.g:303:1: entryRulePipelineDeletedFilterStage : rulePipelineDeletedFilterStage EOF ;
    public final void entryRulePipelineDeletedFilterStage() throws RecognitionException {
        try {
            // InternalIntegrate.g:304:1: ( rulePipelineDeletedFilterStage EOF )
            // InternalIntegrate.g:305:1: rulePipelineDeletedFilterStage EOF
            {
             before(grammarAccess.getPipelineDeletedFilterStageRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineDeletedFilterStage();

            state._fsp--;

             after(grammarAccess.getPipelineDeletedFilterStageRule()); 
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
    // $ANTLR end "entryRulePipelineDeletedFilterStage"


    // $ANTLR start "rulePipelineDeletedFilterStage"
    // InternalIntegrate.g:312:1: rulePipelineDeletedFilterStage : ( ( rule__PipelineDeletedFilterStage__NameAssignment ) ) ;
    public final void rulePipelineDeletedFilterStage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:316:2: ( ( ( rule__PipelineDeletedFilterStage__NameAssignment ) ) )
            // InternalIntegrate.g:317:2: ( ( rule__PipelineDeletedFilterStage__NameAssignment ) )
            {
            // InternalIntegrate.g:317:2: ( ( rule__PipelineDeletedFilterStage__NameAssignment ) )
            // InternalIntegrate.g:318:3: ( rule__PipelineDeletedFilterStage__NameAssignment )
            {
             before(grammarAccess.getPipelineDeletedFilterStageAccess().getNameAssignment()); 
            // InternalIntegrate.g:319:3: ( rule__PipelineDeletedFilterStage__NameAssignment )
            // InternalIntegrate.g:319:4: rule__PipelineDeletedFilterStage__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PipelineDeletedFilterStage__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineDeletedFilterStageAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineDeletedFilterStage"


    // $ANTLR start "entryRulePipelineTypeFilterStage"
    // InternalIntegrate.g:328:1: entryRulePipelineTypeFilterStage : rulePipelineTypeFilterStage EOF ;
    public final void entryRulePipelineTypeFilterStage() throws RecognitionException {
        try {
            // InternalIntegrate.g:329:1: ( rulePipelineTypeFilterStage EOF )
            // InternalIntegrate.g:330:1: rulePipelineTypeFilterStage EOF
            {
             before(grammarAccess.getPipelineTypeFilterStageRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineTypeFilterStage();

            state._fsp--;

             after(grammarAccess.getPipelineTypeFilterStageRule()); 
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
    // $ANTLR end "entryRulePipelineTypeFilterStage"


    // $ANTLR start "rulePipelineTypeFilterStage"
    // InternalIntegrate.g:337:1: rulePipelineTypeFilterStage : ( ( rule__PipelineTypeFilterStage__Group__0 ) ) ;
    public final void rulePipelineTypeFilterStage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:341:2: ( ( ( rule__PipelineTypeFilterStage__Group__0 ) ) )
            // InternalIntegrate.g:342:2: ( ( rule__PipelineTypeFilterStage__Group__0 ) )
            {
            // InternalIntegrate.g:342:2: ( ( rule__PipelineTypeFilterStage__Group__0 ) )
            // InternalIntegrate.g:343:3: ( rule__PipelineTypeFilterStage__Group__0 )
            {
             before(grammarAccess.getPipelineTypeFilterStageAccess().getGroup()); 
            // InternalIntegrate.g:344:3: ( rule__PipelineTypeFilterStage__Group__0 )
            // InternalIntegrate.g:344:4: rule__PipelineTypeFilterStage__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineTypeFilterStage__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineTypeFilterStageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineTypeFilterStage"


    // $ANTLR start "entryRulePipelineCountStage"
    // InternalIntegrate.g:353:1: entryRulePipelineCountStage : rulePipelineCountStage EOF ;
    public final void entryRulePipelineCountStage() throws RecognitionException {
        try {
            // InternalIntegrate.g:354:1: ( rulePipelineCountStage EOF )
            // InternalIntegrate.g:355:1: rulePipelineCountStage EOF
            {
             before(grammarAccess.getPipelineCountStageRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineCountStage();

            state._fsp--;

             after(grammarAccess.getPipelineCountStageRule()); 
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
    // $ANTLR end "entryRulePipelineCountStage"


    // $ANTLR start "rulePipelineCountStage"
    // InternalIntegrate.g:362:1: rulePipelineCountStage : ( ( rule__PipelineCountStage__NameAssignment ) ) ;
    public final void rulePipelineCountStage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:366:2: ( ( ( rule__PipelineCountStage__NameAssignment ) ) )
            // InternalIntegrate.g:367:2: ( ( rule__PipelineCountStage__NameAssignment ) )
            {
            // InternalIntegrate.g:367:2: ( ( rule__PipelineCountStage__NameAssignment ) )
            // InternalIntegrate.g:368:3: ( rule__PipelineCountStage__NameAssignment )
            {
             before(grammarAccess.getPipelineCountStageAccess().getNameAssignment()); 
            // InternalIntegrate.g:369:3: ( rule__PipelineCountStage__NameAssignment )
            // InternalIntegrate.g:369:4: rule__PipelineCountStage__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PipelineCountStage__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineCountStageAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineCountStage"


    // $ANTLR start "entryRuleSatisfactionRule"
    // InternalIntegrate.g:378:1: entryRuleSatisfactionRule : ruleSatisfactionRule EOF ;
    public final void entryRuleSatisfactionRule() throws RecognitionException {
        try {
            // InternalIntegrate.g:379:1: ( ruleSatisfactionRule EOF )
            // InternalIntegrate.g:380:1: ruleSatisfactionRule EOF
            {
             before(grammarAccess.getSatisfactionRuleRule()); 
            pushFollow(FOLLOW_1);
            ruleSatisfactionRule();

            state._fsp--;

             after(grammarAccess.getSatisfactionRuleRule()); 
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
    // $ANTLR end "entryRuleSatisfactionRule"


    // $ANTLR start "ruleSatisfactionRule"
    // InternalIntegrate.g:387:1: ruleSatisfactionRule : ( ( rule__SatisfactionRule__Group__0 ) ) ;
    public final void ruleSatisfactionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:391:2: ( ( ( rule__SatisfactionRule__Group__0 ) ) )
            // InternalIntegrate.g:392:2: ( ( rule__SatisfactionRule__Group__0 ) )
            {
            // InternalIntegrate.g:392:2: ( ( rule__SatisfactionRule__Group__0 ) )
            // InternalIntegrate.g:393:3: ( rule__SatisfactionRule__Group__0 )
            {
             before(grammarAccess.getSatisfactionRuleAccess().getGroup()); 
            // InternalIntegrate.g:394:3: ( rule__SatisfactionRule__Group__0 )
            // InternalIntegrate.g:394:4: rule__SatisfactionRule__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SatisfactionRule__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSatisfactionRuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSatisfactionRule"


    // $ANTLR start "entryRuleAnd"
    // InternalIntegrate.g:403:1: entryRuleAnd : ruleAnd EOF ;
    public final void entryRuleAnd() throws RecognitionException {
        try {
            // InternalIntegrate.g:404:1: ( ruleAnd EOF )
            // InternalIntegrate.g:405:1: ruleAnd EOF
            {
             before(grammarAccess.getAndRule()); 
            pushFollow(FOLLOW_1);
            ruleAnd();

            state._fsp--;

             after(grammarAccess.getAndRule()); 
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
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalIntegrate.g:412:1: ruleAnd : ( ( rule__And__Group__0 ) ) ;
    public final void ruleAnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:416:2: ( ( ( rule__And__Group__0 ) ) )
            // InternalIntegrate.g:417:2: ( ( rule__And__Group__0 ) )
            {
            // InternalIntegrate.g:417:2: ( ( rule__And__Group__0 ) )
            // InternalIntegrate.g:418:3: ( rule__And__Group__0 )
            {
             before(grammarAccess.getAndAccess().getGroup()); 
            // InternalIntegrate.g:419:3: ( rule__And__Group__0 )
            // InternalIntegrate.g:419:4: rule__And__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleOr"
    // InternalIntegrate.g:428:1: entryRuleOr : ruleOr EOF ;
    public final void entryRuleOr() throws RecognitionException {
        try {
            // InternalIntegrate.g:429:1: ( ruleOr EOF )
            // InternalIntegrate.g:430:1: ruleOr EOF
            {
             before(grammarAccess.getOrRule()); 
            pushFollow(FOLLOW_1);
            ruleOr();

            state._fsp--;

             after(grammarAccess.getOrRule()); 
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
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalIntegrate.g:437:1: ruleOr : ( ( rule__Or__Group__0 ) ) ;
    public final void ruleOr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:441:2: ( ( ( rule__Or__Group__0 ) ) )
            // InternalIntegrate.g:442:2: ( ( rule__Or__Group__0 ) )
            {
            // InternalIntegrate.g:442:2: ( ( rule__Or__Group__0 ) )
            // InternalIntegrate.g:443:3: ( rule__Or__Group__0 )
            {
             before(grammarAccess.getOrAccess().getGroup()); 
            // InternalIntegrate.g:444:3: ( rule__Or__Group__0 )
            // InternalIntegrate.g:444:4: rule__Or__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleComparison"
    // InternalIntegrate.g:453:1: entryRuleComparison : ruleComparison EOF ;
    public final void entryRuleComparison() throws RecognitionException {
        try {
            // InternalIntegrate.g:454:1: ( ruleComparison EOF )
            // InternalIntegrate.g:455:1: ruleComparison EOF
            {
             before(grammarAccess.getComparisonRule()); 
            pushFollow(FOLLOW_1);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getComparisonRule()); 
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
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalIntegrate.g:462:1: ruleComparison : ( ( rule__Comparison__Group__0 ) ) ;
    public final void ruleComparison() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:466:2: ( ( ( rule__Comparison__Group__0 ) ) )
            // InternalIntegrate.g:467:2: ( ( rule__Comparison__Group__0 ) )
            {
            // InternalIntegrate.g:467:2: ( ( rule__Comparison__Group__0 ) )
            // InternalIntegrate.g:468:3: ( rule__Comparison__Group__0 )
            {
             before(grammarAccess.getComparisonAccess().getGroup()); 
            // InternalIntegrate.g:469:3: ( rule__Comparison__Group__0 )
            // InternalIntegrate.g:469:4: rule__Comparison__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRuleResolutionStrategy"
    // InternalIntegrate.g:478:1: entryRuleResolutionStrategy : ruleResolutionStrategy EOF ;
    public final void entryRuleResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:479:1: ( ruleResolutionStrategy EOF )
            // InternalIntegrate.g:480:1: ruleResolutionStrategy EOF
            {
             before(grammarAccess.getResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleResolutionStrategy"


    // $ANTLR start "ruleResolutionStrategy"
    // InternalIntegrate.g:487:1: ruleResolutionStrategy : ( ( rule__ResolutionStrategy__NameAssignment ) ) ;
    public final void ruleResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:491:2: ( ( ( rule__ResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:492:2: ( ( rule__ResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:492:2: ( ( rule__ResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:493:3: ( rule__ResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:494:3: ( rule__ResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:494:4: rule__ResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResolutionStrategy"


    // $ANTLR start "rule__Pipeline__FirstAlternatives_0_0"
    // InternalIntegrate.g:502:1: rule__Pipeline__FirstAlternatives_0_0 : ( ( rulePipelineStageSrc ) | ( rulePipelineStageTrg ) );
    public final void rule__Pipeline__FirstAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:506:1: ( ( rulePipelineStageSrc ) | ( rulePipelineStageTrg ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==35) ) {
                alt1=1;
            }
            else if ( (LA1_0==36) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalIntegrate.g:507:2: ( rulePipelineStageSrc )
                    {
                    // InternalIntegrate.g:507:2: ( rulePipelineStageSrc )
                    // InternalIntegrate.g:508:3: rulePipelineStageSrc
                    {
                     before(grammarAccess.getPipelineAccess().getFirstPipelineStageSrcParserRuleCall_0_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageSrc();

                    state._fsp--;

                     after(grammarAccess.getPipelineAccess().getFirstPipelineStageSrcParserRuleCall_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:513:2: ( rulePipelineStageTrg )
                    {
                    // InternalIntegrate.g:513:2: ( rulePipelineStageTrg )
                    // InternalIntegrate.g:514:3: rulePipelineStageTrg
                    {
                     before(grammarAccess.getPipelineAccess().getFirstPipelineStageTrgParserRuleCall_0_0_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageTrg();

                    state._fsp--;

                     after(grammarAccess.getPipelineAccess().getFirstPipelineStageTrgParserRuleCall_0_0_1()); 

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
    // $ANTLR end "rule__Pipeline__FirstAlternatives_0_0"


    // $ANTLR start "rule__PipelineStage__Alternatives"
    // InternalIntegrate.g:523:1: rule__PipelineStage__Alternatives : ( ( rulePipelineFilterStage ) | ( rulePipelineCountStage ) );
    public final void rule__PipelineStage__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:527:1: ( ( rulePipelineFilterStage ) | ( rulePipelineCountStage ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=37 && LA2_0<=39)) ) {
                alt2=1;
            }
            else if ( (LA2_0==40) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalIntegrate.g:528:2: ( rulePipelineFilterStage )
                    {
                    // InternalIntegrate.g:528:2: ( rulePipelineFilterStage )
                    // InternalIntegrate.g:529:3: rulePipelineFilterStage
                    {
                     before(grammarAccess.getPipelineStageAccess().getPipelineFilterStageParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineFilterStage();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageAccess().getPipelineFilterStageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:534:2: ( rulePipelineCountStage )
                    {
                    // InternalIntegrate.g:534:2: ( rulePipelineCountStage )
                    // InternalIntegrate.g:535:3: rulePipelineCountStage
                    {
                     before(grammarAccess.getPipelineStageAccess().getPipelineCountStageParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineCountStage();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageAccess().getPipelineCountStageParserRuleCall_1()); 

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
    // $ANTLR end "rule__PipelineStage__Alternatives"


    // $ANTLR start "rule__PipelineFilterStage__Alternatives"
    // InternalIntegrate.g:544:1: rule__PipelineFilterStage__Alternatives : ( ( rulePipelineCreatedFilterStage ) | ( rulePipelineDeletedFilterStage ) | ( rulePipelineTypeFilterStage ) );
    public final void rule__PipelineFilterStage__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:548:1: ( ( rulePipelineCreatedFilterStage ) | ( rulePipelineDeletedFilterStage ) | ( rulePipelineTypeFilterStage ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt3=1;
                }
                break;
            case 38:
                {
                alt3=2;
                }
                break;
            case 39:
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalIntegrate.g:549:2: ( rulePipelineCreatedFilterStage )
                    {
                    // InternalIntegrate.g:549:2: ( rulePipelineCreatedFilterStage )
                    // InternalIntegrate.g:550:3: rulePipelineCreatedFilterStage
                    {
                     before(grammarAccess.getPipelineFilterStageAccess().getPipelineCreatedFilterStageParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineCreatedFilterStage();

                    state._fsp--;

                     after(grammarAccess.getPipelineFilterStageAccess().getPipelineCreatedFilterStageParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:555:2: ( rulePipelineDeletedFilterStage )
                    {
                    // InternalIntegrate.g:555:2: ( rulePipelineDeletedFilterStage )
                    // InternalIntegrate.g:556:3: rulePipelineDeletedFilterStage
                    {
                     before(grammarAccess.getPipelineFilterStageAccess().getPipelineDeletedFilterStageParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineDeletedFilterStage();

                    state._fsp--;

                     after(grammarAccess.getPipelineFilterStageAccess().getPipelineDeletedFilterStageParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:561:2: ( rulePipelineTypeFilterStage )
                    {
                    // InternalIntegrate.g:561:2: ( rulePipelineTypeFilterStage )
                    // InternalIntegrate.g:562:3: rulePipelineTypeFilterStage
                    {
                     before(grammarAccess.getPipelineFilterStageAccess().getPipelineTypeFilterStageParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineTypeFilterStage();

                    state._fsp--;

                     after(grammarAccess.getPipelineFilterStageAccess().getPipelineTypeFilterStageParserRuleCall_2()); 

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
    // $ANTLR end "rule__PipelineFilterStage__Alternatives"


    // $ANTLR start "rule__SatisfactionRule__OtherRulesAlternatives_1_0"
    // InternalIntegrate.g:571:1: rule__SatisfactionRule__OtherRulesAlternatives_1_0 : ( ( ruleAnd ) | ( ruleOr ) );
    public final void rule__SatisfactionRule__OtherRulesAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:575:1: ( ( ruleAnd ) | ( ruleOr ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==33) ) {
                alt4=1;
            }
            else if ( (LA4_0==34) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalIntegrate.g:576:2: ( ruleAnd )
                    {
                    // InternalIntegrate.g:576:2: ( ruleAnd )
                    // InternalIntegrate.g:577:3: ruleAnd
                    {
                     before(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAndParserRuleCall_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAnd();

                    state._fsp--;

                     after(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAndParserRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:582:2: ( ruleOr )
                    {
                    // InternalIntegrate.g:582:2: ( ruleOr )
                    // InternalIntegrate.g:583:3: ruleOr
                    {
                     before(grammarAccess.getSatisfactionRuleAccess().getOtherRulesOrParserRuleCall_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOr();

                    state._fsp--;

                     after(grammarAccess.getSatisfactionRuleAccess().getOtherRulesOrParserRuleCall_1_0_1()); 

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
    // $ANTLR end "rule__SatisfactionRule__OtherRulesAlternatives_1_0"


    // $ANTLR start "rule__Comparison__Alternatives_0"
    // InternalIntegrate.g:592:1: rule__Comparison__Alternatives_0 : ( ( ( rule__Comparison__V1Assignment_0_0 ) ) | ( ( rule__Comparison__N1Assignment_0_1 ) ) );
    public final void rule__Comparison__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:596:1: ( ( ( rule__Comparison__V1Assignment_0_0 ) ) | ( ( rule__Comparison__N1Assignment_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_INT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalIntegrate.g:597:2: ( ( rule__Comparison__V1Assignment_0_0 ) )
                    {
                    // InternalIntegrate.g:597:2: ( ( rule__Comparison__V1Assignment_0_0 ) )
                    // InternalIntegrate.g:598:3: ( rule__Comparison__V1Assignment_0_0 )
                    {
                     before(grammarAccess.getComparisonAccess().getV1Assignment_0_0()); 
                    // InternalIntegrate.g:599:3: ( rule__Comparison__V1Assignment_0_0 )
                    // InternalIntegrate.g:599:4: rule__Comparison__V1Assignment_0_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__V1Assignment_0_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getV1Assignment_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:603:2: ( ( rule__Comparison__N1Assignment_0_1 ) )
                    {
                    // InternalIntegrate.g:603:2: ( ( rule__Comparison__N1Assignment_0_1 ) )
                    // InternalIntegrate.g:604:3: ( rule__Comparison__N1Assignment_0_1 )
                    {
                     before(grammarAccess.getComparisonAccess().getN1Assignment_0_1()); 
                    // InternalIntegrate.g:605:3: ( rule__Comparison__N1Assignment_0_1 )
                    // InternalIntegrate.g:605:4: rule__Comparison__N1Assignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__N1Assignment_0_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getN1Assignment_0_1()); 

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
    // $ANTLR end "rule__Comparison__Alternatives_0"


    // $ANTLR start "rule__Comparison__C1Alternatives_1_0"
    // InternalIntegrate.g:613:1: rule__Comparison__C1Alternatives_1_0 : ( ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) );
    public final void rule__Comparison__C1Alternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:617:1: ( ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) )
            int alt6=4;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt6=1;
                }
                break;
            case 12:
                {
                alt6=2;
                }
                break;
            case 13:
                {
                alt6=3;
                }
                break;
            case 14:
                {
                alt6=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalIntegrate.g:618:2: ( '>' )
                    {
                    // InternalIntegrate.g:618:2: ( '>' )
                    // InternalIntegrate.g:619:3: '>'
                    {
                     before(grammarAccess.getComparisonAccess().getC1GreaterThanSignKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getC1GreaterThanSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:624:2: ( '>=' )
                    {
                    // InternalIntegrate.g:624:2: ( '>=' )
                    // InternalIntegrate.g:625:3: '>='
                    {
                     before(grammarAccess.getComparisonAccess().getC1GreaterThanSignEqualsSignKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getC1GreaterThanSignEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:630:2: ( '<' )
                    {
                    // InternalIntegrate.g:630:2: ( '<' )
                    // InternalIntegrate.g:631:3: '<'
                    {
                     before(grammarAccess.getComparisonAccess().getC1LessThanSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getC1LessThanSignKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:636:2: ( '<=' )
                    {
                    // InternalIntegrate.g:636:2: ( '<=' )
                    // InternalIntegrate.g:637:3: '<='
                    {
                     before(grammarAccess.getComparisonAccess().getC1LessThanSignEqualsSignKeyword_1_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getComparisonAccess().getC1LessThanSignEqualsSignKeyword_1_0_3()); 

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
    // $ANTLR end "rule__Comparison__C1Alternatives_1_0"


    // $ANTLR start "rule__Comparison__Alternatives_2"
    // InternalIntegrate.g:646:1: rule__Comparison__Alternatives_2 : ( ( ( rule__Comparison__V2Assignment_2_0 ) ) | ( ( rule__Comparison__N2Assignment_2_1 ) ) );
    public final void rule__Comparison__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:650:1: ( ( ( rule__Comparison__V2Assignment_2_0 ) ) | ( ( rule__Comparison__N2Assignment_2_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_INT) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalIntegrate.g:651:2: ( ( rule__Comparison__V2Assignment_2_0 ) )
                    {
                    // InternalIntegrate.g:651:2: ( ( rule__Comparison__V2Assignment_2_0 ) )
                    // InternalIntegrate.g:652:3: ( rule__Comparison__V2Assignment_2_0 )
                    {
                     before(grammarAccess.getComparisonAccess().getV2Assignment_2_0()); 
                    // InternalIntegrate.g:653:3: ( rule__Comparison__V2Assignment_2_0 )
                    // InternalIntegrate.g:653:4: rule__Comparison__V2Assignment_2_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__V2Assignment_2_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getV2Assignment_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:657:2: ( ( rule__Comparison__N2Assignment_2_1 ) )
                    {
                    // InternalIntegrate.g:657:2: ( ( rule__Comparison__N2Assignment_2_1 ) )
                    // InternalIntegrate.g:658:3: ( rule__Comparison__N2Assignment_2_1 )
                    {
                     before(grammarAccess.getComparisonAccess().getN2Assignment_2_1()); 
                    // InternalIntegrate.g:659:3: ( rule__Comparison__N2Assignment_2_1 )
                    // InternalIntegrate.g:659:4: rule__Comparison__N2Assignment_2_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Comparison__N2Assignment_2_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getComparisonAccess().getN2Assignment_2_1()); 

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
    // $ANTLR end "rule__Comparison__Alternatives_2"


    // $ANTLR start "rule__ResolutionStrategy__NameAlternatives_0"
    // InternalIntegrate.g:667:1: rule__ResolutionStrategy__NameAlternatives_0 : ( ( 'actAndLetRepair' ) | ( 'mergeAndPreserve' ) | ( 'preferSource' ) | ( 'preferTarget' ) | ( 'revokeAddition' ) | ( 'revokeDeletion' ) );
    public final void rule__ResolutionStrategy__NameAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:671:1: ( ( 'actAndLetRepair' ) | ( 'mergeAndPreserve' ) | ( 'preferSource' ) | ( 'preferTarget' ) | ( 'revokeAddition' ) | ( 'revokeDeletion' ) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt8=1;
                }
                break;
            case 16:
                {
                alt8=2;
                }
                break;
            case 17:
                {
                alt8=3;
                }
                break;
            case 18:
                {
                alt8=4;
                }
                break;
            case 19:
                {
                alt8=5;
                }
                break;
            case 20:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalIntegrate.g:672:2: ( 'actAndLetRepair' )
                    {
                    // InternalIntegrate.g:672:2: ( 'actAndLetRepair' )
                    // InternalIntegrate.g:673:3: 'actAndLetRepair'
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getNameActAndLetRepairKeyword_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getResolutionStrategyAccess().getNameActAndLetRepairKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:678:2: ( 'mergeAndPreserve' )
                    {
                    // InternalIntegrate.g:678:2: ( 'mergeAndPreserve' )
                    // InternalIntegrate.g:679:3: 'mergeAndPreserve'
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:684:2: ( 'preferSource' )
                    {
                    // InternalIntegrate.g:684:2: ( 'preferSource' )
                    // InternalIntegrate.g:685:3: 'preferSource'
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getNamePreferSourceKeyword_0_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getResolutionStrategyAccess().getNamePreferSourceKeyword_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:690:2: ( 'preferTarget' )
                    {
                    // InternalIntegrate.g:690:2: ( 'preferTarget' )
                    // InternalIntegrate.g:691:3: 'preferTarget'
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getNamePreferTargetKeyword_0_3()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getResolutionStrategyAccess().getNamePreferTargetKeyword_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalIntegrate.g:696:2: ( 'revokeAddition' )
                    {
                    // InternalIntegrate.g:696:2: ( 'revokeAddition' )
                    // InternalIntegrate.g:697:3: 'revokeAddition'
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getNameRevokeAdditionKeyword_0_4()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getResolutionStrategyAccess().getNameRevokeAdditionKeyword_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalIntegrate.g:702:2: ( 'revokeDeletion' )
                    {
                    // InternalIntegrate.g:702:2: ( 'revokeDeletion' )
                    // InternalIntegrate.g:703:3: 'revokeDeletion'
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getNameRevokeDeletionKeyword_0_5()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getResolutionStrategyAccess().getNameRevokeDeletionKeyword_0_5()); 

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
    // $ANTLR end "rule__ResolutionStrategy__NameAlternatives_0"


    // $ANTLR start "rule__Integrate__Group__0"
    // InternalIntegrate.g:712:1: rule__Integrate__Group__0 : rule__Integrate__Group__0__Impl rule__Integrate__Group__1 ;
    public final void rule__Integrate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:716:1: ( rule__Integrate__Group__0__Impl rule__Integrate__Group__1 )
            // InternalIntegrate.g:717:2: rule__Integrate__Group__0__Impl rule__Integrate__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Integrate__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Integrate__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__Group__0"


    // $ANTLR start "rule__Integrate__Group__0__Impl"
    // InternalIntegrate.g:724:1: rule__Integrate__Group__0__Impl : ( ( rule__Integrate__ImportsAssignment_0 )* ) ;
    public final void rule__Integrate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:728:1: ( ( ( rule__Integrate__ImportsAssignment_0 )* ) )
            // InternalIntegrate.g:729:1: ( ( rule__Integrate__ImportsAssignment_0 )* )
            {
            // InternalIntegrate.g:729:1: ( ( rule__Integrate__ImportsAssignment_0 )* )
            // InternalIntegrate.g:730:2: ( rule__Integrate__ImportsAssignment_0 )*
            {
             before(grammarAccess.getIntegrateAccess().getImportsAssignment_0()); 
            // InternalIntegrate.g:731:2: ( rule__Integrate__ImportsAssignment_0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalIntegrate.g:731:3: rule__Integrate__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Integrate__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getIntegrateAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__Group__0__Impl"


    // $ANTLR start "rule__Integrate__Group__1"
    // InternalIntegrate.g:739:1: rule__Integrate__Group__1 : rule__Integrate__Group__1__Impl ;
    public final void rule__Integrate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:743:1: ( rule__Integrate__Group__1__Impl )
            // InternalIntegrate.g:744:2: rule__Integrate__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Integrate__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__Group__1"


    // $ANTLR start "rule__Integrate__Group__1__Impl"
    // InternalIntegrate.g:750:1: rule__Integrate__Group__1__Impl : ( ( rule__Integrate__ConflictResolutionStrategiesAssignment_1 )* ) ;
    public final void rule__Integrate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:754:1: ( ( ( rule__Integrate__ConflictResolutionStrategiesAssignment_1 )* ) )
            // InternalIntegrate.g:755:1: ( ( rule__Integrate__ConflictResolutionStrategiesAssignment_1 )* )
            {
            // InternalIntegrate.g:755:1: ( ( rule__Integrate__ConflictResolutionStrategiesAssignment_1 )* )
            // InternalIntegrate.g:756:2: ( rule__Integrate__ConflictResolutionStrategiesAssignment_1 )*
            {
             before(grammarAccess.getIntegrateAccess().getConflictResolutionStrategiesAssignment_1()); 
            // InternalIntegrate.g:757:2: ( rule__Integrate__ConflictResolutionStrategiesAssignment_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalIntegrate.g:757:3: rule__Integrate__ConflictResolutionStrategiesAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Integrate__ConflictResolutionStrategiesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getIntegrateAccess().getConflictResolutionStrategiesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalIntegrate.g:766:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:770:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalIntegrate.g:771:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalIntegrate.g:778:1: rule__Import__Group__0__Impl : ( '#import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:782:1: ( ( '#import' ) )
            // InternalIntegrate.g:783:1: ( '#import' )
            {
            // InternalIntegrate.g:783:1: ( '#import' )
            // InternalIntegrate.g:784:2: '#import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,21,FOLLOW_2); 
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
    // InternalIntegrate.g:793:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:797:1: ( rule__Import__Group__1__Impl )
            // InternalIntegrate.g:798:2: rule__Import__Group__1__Impl
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
    // InternalIntegrate.g:804:1: rule__Import__Group__1__Impl : ( ( rule__Import__RuleAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:808:1: ( ( ( rule__Import__RuleAssignment_1 ) ) )
            // InternalIntegrate.g:809:1: ( ( rule__Import__RuleAssignment_1 ) )
            {
            // InternalIntegrate.g:809:1: ( ( rule__Import__RuleAssignment_1 ) )
            // InternalIntegrate.g:810:2: ( rule__Import__RuleAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getRuleAssignment_1()); 
            // InternalIntegrate.g:811:2: ( rule__Import__RuleAssignment_1 )
            // InternalIntegrate.g:811:3: rule__Import__RuleAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__RuleAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getRuleAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__0"
    // InternalIntegrate.g:820:1: rule__ConflictResolutionStrategy__Group__0 : rule__ConflictResolutionStrategy__Group__0__Impl rule__ConflictResolutionStrategy__Group__1 ;
    public final void rule__ConflictResolutionStrategy__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:824:1: ( rule__ConflictResolutionStrategy__Group__0__Impl rule__ConflictResolutionStrategy__Group__1 )
            // InternalIntegrate.g:825:2: rule__ConflictResolutionStrategy__Group__0__Impl rule__ConflictResolutionStrategy__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__ConflictResolutionStrategy__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__0"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__0__Impl"
    // InternalIntegrate.g:832:1: rule__ConflictResolutionStrategy__Group__0__Impl : ( () ) ;
    public final void rule__ConflictResolutionStrategy__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:836:1: ( ( () ) )
            // InternalIntegrate.g:837:1: ( () )
            {
            // InternalIntegrate.g:837:1: ( () )
            // InternalIntegrate.g:838:2: ()
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getConflictResolutionStrategyAction_0()); 
            // InternalIntegrate.g:839:2: ()
            // InternalIntegrate.g:839:3: 
            {
            }

             after(grammarAccess.getConflictResolutionStrategyAccess().getConflictResolutionStrategyAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__0__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__1"
    // InternalIntegrate.g:847:1: rule__ConflictResolutionStrategy__Group__1 : rule__ConflictResolutionStrategy__Group__1__Impl rule__ConflictResolutionStrategy__Group__2 ;
    public final void rule__ConflictResolutionStrategy__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:851:1: ( rule__ConflictResolutionStrategy__Group__1__Impl rule__ConflictResolutionStrategy__Group__2 )
            // InternalIntegrate.g:852:2: rule__ConflictResolutionStrategy__Group__1__Impl rule__ConflictResolutionStrategy__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__ConflictResolutionStrategy__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__1"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__1__Impl"
    // InternalIntegrate.g:859:1: rule__ConflictResolutionStrategy__Group__1__Impl : ( 'solve' ) ;
    public final void rule__ConflictResolutionStrategy__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:863:1: ( ( 'solve' ) )
            // InternalIntegrate.g:864:1: ( 'solve' )
            {
            // InternalIntegrate.g:864:1: ( 'solve' )
            // InternalIntegrate.g:865:2: 'solve'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getSolveKeyword_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getSolveKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__1__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__2"
    // InternalIntegrate.g:874:1: rule__ConflictResolutionStrategy__Group__2 : rule__ConflictResolutionStrategy__Group__2__Impl rule__ConflictResolutionStrategy__Group__3 ;
    public final void rule__ConflictResolutionStrategy__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:878:1: ( rule__ConflictResolutionStrategy__Group__2__Impl rule__ConflictResolutionStrategy__Group__3 )
            // InternalIntegrate.g:879:2: rule__ConflictResolutionStrategy__Group__2__Impl rule__ConflictResolutionStrategy__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__ConflictResolutionStrategy__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__2"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__2__Impl"
    // InternalIntegrate.g:886:1: rule__ConflictResolutionStrategy__Group__2__Impl : ( 'conflict' ) ;
    public final void rule__ConflictResolutionStrategy__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:890:1: ( ( 'conflict' ) )
            // InternalIntegrate.g:891:1: ( 'conflict' )
            {
            // InternalIntegrate.g:891:1: ( 'conflict' )
            // InternalIntegrate.g:892:2: 'conflict'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getConflictKeyword_2()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getConflictKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__2__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__3"
    // InternalIntegrate.g:901:1: rule__ConflictResolutionStrategy__Group__3 : rule__ConflictResolutionStrategy__Group__3__Impl rule__ConflictResolutionStrategy__Group__4 ;
    public final void rule__ConflictResolutionStrategy__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:905:1: ( rule__ConflictResolutionStrategy__Group__3__Impl rule__ConflictResolutionStrategy__Group__4 )
            // InternalIntegrate.g:906:2: rule__ConflictResolutionStrategy__Group__3__Impl rule__ConflictResolutionStrategy__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__ConflictResolutionStrategy__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__3"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__3__Impl"
    // InternalIntegrate.g:913:1: rule__ConflictResolutionStrategy__Group__3__Impl : ( 'for' ) ;
    public final void rule__ConflictResolutionStrategy__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:917:1: ( ( 'for' ) )
            // InternalIntegrate.g:918:1: ( 'for' )
            {
            // InternalIntegrate.g:918:1: ( 'for' )
            // InternalIntegrate.g:919:2: 'for'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getForKeyword_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getForKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__3__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__4"
    // InternalIntegrate.g:928:1: rule__ConflictResolutionStrategy__Group__4 : rule__ConflictResolutionStrategy__Group__4__Impl rule__ConflictResolutionStrategy__Group__5 ;
    public final void rule__ConflictResolutionStrategy__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:932:1: ( rule__ConflictResolutionStrategy__Group__4__Impl rule__ConflictResolutionStrategy__Group__5 )
            // InternalIntegrate.g:933:2: rule__ConflictResolutionStrategy__Group__4__Impl rule__ConflictResolutionStrategy__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__ConflictResolutionStrategy__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__4"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__4__Impl"
    // InternalIntegrate.g:940:1: rule__ConflictResolutionStrategy__Group__4__Impl : ( 'all' ) ;
    public final void rule__ConflictResolutionStrategy__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:944:1: ( ( 'all' ) )
            // InternalIntegrate.g:945:1: ( 'all' )
            {
            // InternalIntegrate.g:945:1: ( 'all' )
            // InternalIntegrate.g:946:2: 'all'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getAllKeyword_4()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getAllKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__4__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__5"
    // InternalIntegrate.g:955:1: rule__ConflictResolutionStrategy__Group__5 : rule__ConflictResolutionStrategy__Group__5__Impl rule__ConflictResolutionStrategy__Group__6 ;
    public final void rule__ConflictResolutionStrategy__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:959:1: ( rule__ConflictResolutionStrategy__Group__5__Impl rule__ConflictResolutionStrategy__Group__6 )
            // InternalIntegrate.g:960:2: rule__ConflictResolutionStrategy__Group__5__Impl rule__ConflictResolutionStrategy__Group__6
            {
            pushFollow(FOLLOW_11);
            rule__ConflictResolutionStrategy__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__5"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__5__Impl"
    // InternalIntegrate.g:967:1: rule__ConflictResolutionStrategy__Group__5__Impl : ( '{' ) ;
    public final void rule__ConflictResolutionStrategy__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:971:1: ( ( '{' ) )
            // InternalIntegrate.g:972:1: ( '{' )
            {
            // InternalIntegrate.g:972:1: ( '{' )
            // InternalIntegrate.g:973:2: '{'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__5__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__6"
    // InternalIntegrate.g:982:1: rule__ConflictResolutionStrategy__Group__6 : rule__ConflictResolutionStrategy__Group__6__Impl rule__ConflictResolutionStrategy__Group__7 ;
    public final void rule__ConflictResolutionStrategy__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:986:1: ( rule__ConflictResolutionStrategy__Group__6__Impl rule__ConflictResolutionStrategy__Group__7 )
            // InternalIntegrate.g:987:2: rule__ConflictResolutionStrategy__Group__6__Impl rule__ConflictResolutionStrategy__Group__7
            {
            pushFollow(FOLLOW_12);
            rule__ConflictResolutionStrategy__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__6"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__6__Impl"
    // InternalIntegrate.g:994:1: rule__ConflictResolutionStrategy__Group__6__Impl : ( ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 ) ) ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )* ) ) ;
    public final void rule__ConflictResolutionStrategy__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:998:1: ( ( ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 ) ) ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )* ) ) )
            // InternalIntegrate.g:999:1: ( ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 ) ) ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )* ) )
            {
            // InternalIntegrate.g:999:1: ( ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 ) ) ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )* ) )
            // InternalIntegrate.g:1000:2: ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 ) ) ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )* )
            {
            // InternalIntegrate.g:1000:2: ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 ) )
            // InternalIntegrate.g:1001:3: ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getVariablesAssignment_6()); 
            // InternalIntegrate.g:1002:3: ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )
            // InternalIntegrate.g:1002:4: rule__ConflictResolutionStrategy__VariablesAssignment_6
            {
            pushFollow(FOLLOW_13);
            rule__ConflictResolutionStrategy__VariablesAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionStrategyAccess().getVariablesAssignment_6()); 

            }

            // InternalIntegrate.g:1005:2: ( ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )* )
            // InternalIntegrate.g:1006:3: ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )*
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getVariablesAssignment_6()); 
            // InternalIntegrate.g:1007:3: ( rule__ConflictResolutionStrategy__VariablesAssignment_6 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==30) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalIntegrate.g:1007:4: rule__ConflictResolutionStrategy__VariablesAssignment_6
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__ConflictResolutionStrategy__VariablesAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getConflictResolutionStrategyAccess().getVariablesAssignment_6()); 

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
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__6__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__7"
    // InternalIntegrate.g:1016:1: rule__ConflictResolutionStrategy__Group__7 : rule__ConflictResolutionStrategy__Group__7__Impl rule__ConflictResolutionStrategy__Group__8 ;
    public final void rule__ConflictResolutionStrategy__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1020:1: ( rule__ConflictResolutionStrategy__Group__7__Impl rule__ConflictResolutionStrategy__Group__8 )
            // InternalIntegrate.g:1021:2: rule__ConflictResolutionStrategy__Group__7__Impl rule__ConflictResolutionStrategy__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__ConflictResolutionStrategy__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__7"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__7__Impl"
    // InternalIntegrate.g:1028:1: rule__ConflictResolutionStrategy__Group__7__Impl : ( 'satisfies' ) ;
    public final void rule__ConflictResolutionStrategy__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1032:1: ( ( 'satisfies' ) )
            // InternalIntegrate.g:1033:1: ( 'satisfies' )
            {
            // InternalIntegrate.g:1033:1: ( 'satisfies' )
            // InternalIntegrate.g:1034:2: 'satisfies'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getSatisfiesKeyword_7()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getSatisfiesKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__7__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__8"
    // InternalIntegrate.g:1043:1: rule__ConflictResolutionStrategy__Group__8 : rule__ConflictResolutionStrategy__Group__8__Impl rule__ConflictResolutionStrategy__Group__9 ;
    public final void rule__ConflictResolutionStrategy__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1047:1: ( rule__ConflictResolutionStrategy__Group__8__Impl rule__ConflictResolutionStrategy__Group__9 )
            // InternalIntegrate.g:1048:2: rule__ConflictResolutionStrategy__Group__8__Impl rule__ConflictResolutionStrategy__Group__9
            {
            pushFollow(FOLLOW_14);
            rule__ConflictResolutionStrategy__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__8"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__8__Impl"
    // InternalIntegrate.g:1055:1: rule__ConflictResolutionStrategy__Group__8__Impl : ( '{' ) ;
    public final void rule__ConflictResolutionStrategy__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1059:1: ( ( '{' ) )
            // InternalIntegrate.g:1060:1: ( '{' )
            {
            // InternalIntegrate.g:1060:1: ( '{' )
            // InternalIntegrate.g:1061:2: '{'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getLeftCurlyBracketKeyword_8()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getLeftCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__8__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__9"
    // InternalIntegrate.g:1070:1: rule__ConflictResolutionStrategy__Group__9 : rule__ConflictResolutionStrategy__Group__9__Impl rule__ConflictResolutionStrategy__Group__10 ;
    public final void rule__ConflictResolutionStrategy__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1074:1: ( rule__ConflictResolutionStrategy__Group__9__Impl rule__ConflictResolutionStrategy__Group__10 )
            // InternalIntegrate.g:1075:2: rule__ConflictResolutionStrategy__Group__9__Impl rule__ConflictResolutionStrategy__Group__10
            {
            pushFollow(FOLLOW_15);
            rule__ConflictResolutionStrategy__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__9"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__9__Impl"
    // InternalIntegrate.g:1082:1: rule__ConflictResolutionStrategy__Group__9__Impl : ( ( rule__ConflictResolutionStrategy__RuleAssignment_9 ) ) ;
    public final void rule__ConflictResolutionStrategy__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1086:1: ( ( ( rule__ConflictResolutionStrategy__RuleAssignment_9 ) ) )
            // InternalIntegrate.g:1087:1: ( ( rule__ConflictResolutionStrategy__RuleAssignment_9 ) )
            {
            // InternalIntegrate.g:1087:1: ( ( rule__ConflictResolutionStrategy__RuleAssignment_9 ) )
            // InternalIntegrate.g:1088:2: ( rule__ConflictResolutionStrategy__RuleAssignment_9 )
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getRuleAssignment_9()); 
            // InternalIntegrate.g:1089:2: ( rule__ConflictResolutionStrategy__RuleAssignment_9 )
            // InternalIntegrate.g:1089:3: rule__ConflictResolutionStrategy__RuleAssignment_9
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__RuleAssignment_9();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionStrategyAccess().getRuleAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__9__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__10"
    // InternalIntegrate.g:1097:1: rule__ConflictResolutionStrategy__Group__10 : rule__ConflictResolutionStrategy__Group__10__Impl rule__ConflictResolutionStrategy__Group__11 ;
    public final void rule__ConflictResolutionStrategy__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1101:1: ( rule__ConflictResolutionStrategy__Group__10__Impl rule__ConflictResolutionStrategy__Group__11 )
            // InternalIntegrate.g:1102:2: rule__ConflictResolutionStrategy__Group__10__Impl rule__ConflictResolutionStrategy__Group__11
            {
            pushFollow(FOLLOW_15);
            rule__ConflictResolutionStrategy__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__10"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__10__Impl"
    // InternalIntegrate.g:1109:1: rule__ConflictResolutionStrategy__Group__10__Impl : ( '}' ) ;
    public final void rule__ConflictResolutionStrategy__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1113:1: ( ( '}' ) )
            // InternalIntegrate.g:1114:1: ( '}' )
            {
            // InternalIntegrate.g:1114:1: ( '}' )
            // InternalIntegrate.g:1115:2: '}'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getRightCurlyBracketKeyword_10()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__10__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__11"
    // InternalIntegrate.g:1124:1: rule__ConflictResolutionStrategy__Group__11 : rule__ConflictResolutionStrategy__Group__11__Impl rule__ConflictResolutionStrategy__Group__12 ;
    public final void rule__ConflictResolutionStrategy__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1128:1: ( rule__ConflictResolutionStrategy__Group__11__Impl rule__ConflictResolutionStrategy__Group__12 )
            // InternalIntegrate.g:1129:2: rule__ConflictResolutionStrategy__Group__11__Impl rule__ConflictResolutionStrategy__Group__12
            {
            pushFollow(FOLLOW_16);
            rule__ConflictResolutionStrategy__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__12();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__11"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__11__Impl"
    // InternalIntegrate.g:1136:1: rule__ConflictResolutionStrategy__Group__11__Impl : ( '}' ) ;
    public final void rule__ConflictResolutionStrategy__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1140:1: ( ( '}' ) )
            // InternalIntegrate.g:1141:1: ( '}' )
            {
            // InternalIntegrate.g:1141:1: ( '}' )
            // InternalIntegrate.g:1142:2: '}'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getRightCurlyBracketKeyword_11()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getRightCurlyBracketKeyword_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__11__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__12"
    // InternalIntegrate.g:1151:1: rule__ConflictResolutionStrategy__Group__12 : rule__ConflictResolutionStrategy__Group__12__Impl rule__ConflictResolutionStrategy__Group__13 ;
    public final void rule__ConflictResolutionStrategy__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1155:1: ( rule__ConflictResolutionStrategy__Group__12__Impl rule__ConflictResolutionStrategy__Group__13 )
            // InternalIntegrate.g:1156:2: rule__ConflictResolutionStrategy__Group__12__Impl rule__ConflictResolutionStrategy__Group__13
            {
            pushFollow(FOLLOW_17);
            rule__ConflictResolutionStrategy__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__12"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__12__Impl"
    // InternalIntegrate.g:1163:1: rule__ConflictResolutionStrategy__Group__12__Impl : ( 'with' ) ;
    public final void rule__ConflictResolutionStrategy__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1167:1: ( ( 'with' ) )
            // InternalIntegrate.g:1168:1: ( 'with' )
            {
            // InternalIntegrate.g:1168:1: ( 'with' )
            // InternalIntegrate.g:1169:2: 'with'
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getWithKeyword_12()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionStrategyAccess().getWithKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__12__Impl"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__13"
    // InternalIntegrate.g:1178:1: rule__ConflictResolutionStrategy__Group__13 : rule__ConflictResolutionStrategy__Group__13__Impl ;
    public final void rule__ConflictResolutionStrategy__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1182:1: ( rule__ConflictResolutionStrategy__Group__13__Impl )
            // InternalIntegrate.g:1183:2: rule__ConflictResolutionStrategy__Group__13__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__Group__13__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__13"


    // $ANTLR start "rule__ConflictResolutionStrategy__Group__13__Impl"
    // InternalIntegrate.g:1189:1: rule__ConflictResolutionStrategy__Group__13__Impl : ( ( rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13 ) ) ;
    public final void rule__ConflictResolutionStrategy__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1193:1: ( ( ( rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13 ) ) )
            // InternalIntegrate.g:1194:1: ( ( rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13 ) )
            {
            // InternalIntegrate.g:1194:1: ( ( rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13 ) )
            // InternalIntegrate.g:1195:2: ( rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13 )
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getResolutionStrategyAssignment_13()); 
            // InternalIntegrate.g:1196:2: ( rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13 )
            // InternalIntegrate.g:1196:3: rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionStrategyAccess().getResolutionStrategyAssignment_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__Group__13__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalIntegrate.g:1205:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1209:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalIntegrate.g:1210:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0"


    // $ANTLR start "rule__Variable__Group__0__Impl"
    // InternalIntegrate.g:1217:1: rule__Variable__Group__0__Impl : ( 'var' ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1221:1: ( ( 'var' ) )
            // InternalIntegrate.g:1222:1: ( 'var' )
            {
            // InternalIntegrate.g:1222:1: ( 'var' )
            // InternalIntegrate.g:1223:2: 'var'
            {
             before(grammarAccess.getVariableAccess().getVarKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getVarKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0__Impl"


    // $ANTLR start "rule__Variable__Group__1"
    // InternalIntegrate.g:1232:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1236:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalIntegrate.g:1237:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Variable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1"


    // $ANTLR start "rule__Variable__Group__1__Impl"
    // InternalIntegrate.g:1244:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1248:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalIntegrate.g:1249:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalIntegrate.g:1249:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalIntegrate.g:1250:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalIntegrate.g:1251:2: ( rule__Variable__NameAssignment_1 )
            // InternalIntegrate.g:1251:3: rule__Variable__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Variable__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1__Impl"


    // $ANTLR start "rule__Variable__Group__2"
    // InternalIntegrate.g:1259:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1263:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalIntegrate.g:1264:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_19);
            rule__Variable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2"


    // $ANTLR start "rule__Variable__Group__2__Impl"
    // InternalIntegrate.g:1271:1: rule__Variable__Group__2__Impl : ( '=' ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1275:1: ( ( '=' ) )
            // InternalIntegrate.g:1276:1: ( '=' )
            {
            // InternalIntegrate.g:1276:1: ( '=' )
            // InternalIntegrate.g:1277:2: '='
            {
             before(grammarAccess.getVariableAccess().getEqualsSignKeyword_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2__Impl"


    // $ANTLR start "rule__Variable__Group__3"
    // InternalIntegrate.g:1286:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1290:1: ( rule__Variable__Group__3__Impl )
            // InternalIntegrate.g:1291:2: rule__Variable__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__3"


    // $ANTLR start "rule__Variable__Group__3__Impl"
    // InternalIntegrate.g:1297:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__PipelineAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1301:1: ( ( ( rule__Variable__PipelineAssignment_3 ) ) )
            // InternalIntegrate.g:1302:1: ( ( rule__Variable__PipelineAssignment_3 ) )
            {
            // InternalIntegrate.g:1302:1: ( ( rule__Variable__PipelineAssignment_3 ) )
            // InternalIntegrate.g:1303:2: ( rule__Variable__PipelineAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getPipelineAssignment_3()); 
            // InternalIntegrate.g:1304:2: ( rule__Variable__PipelineAssignment_3 )
            // InternalIntegrate.g:1304:3: rule__Variable__PipelineAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Variable__PipelineAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getPipelineAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__3__Impl"


    // $ANTLR start "rule__Pipeline__Group__0"
    // InternalIntegrate.g:1313:1: rule__Pipeline__Group__0 : rule__Pipeline__Group__0__Impl rule__Pipeline__Group__1 ;
    public final void rule__Pipeline__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1317:1: ( rule__Pipeline__Group__0__Impl rule__Pipeline__Group__1 )
            // InternalIntegrate.g:1318:2: rule__Pipeline__Group__0__Impl rule__Pipeline__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__Pipeline__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Pipeline__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group__0"


    // $ANTLR start "rule__Pipeline__Group__0__Impl"
    // InternalIntegrate.g:1325:1: rule__Pipeline__Group__0__Impl : ( ( rule__Pipeline__FirstAssignment_0 ) ) ;
    public final void rule__Pipeline__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1329:1: ( ( ( rule__Pipeline__FirstAssignment_0 ) ) )
            // InternalIntegrate.g:1330:1: ( ( rule__Pipeline__FirstAssignment_0 ) )
            {
            // InternalIntegrate.g:1330:1: ( ( rule__Pipeline__FirstAssignment_0 ) )
            // InternalIntegrate.g:1331:2: ( rule__Pipeline__FirstAssignment_0 )
            {
             before(grammarAccess.getPipelineAccess().getFirstAssignment_0()); 
            // InternalIntegrate.g:1332:2: ( rule__Pipeline__FirstAssignment_0 )
            // InternalIntegrate.g:1332:3: rule__Pipeline__FirstAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Pipeline__FirstAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineAccess().getFirstAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group__0__Impl"


    // $ANTLR start "rule__Pipeline__Group__1"
    // InternalIntegrate.g:1340:1: rule__Pipeline__Group__1 : rule__Pipeline__Group__1__Impl ;
    public final void rule__Pipeline__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1344:1: ( rule__Pipeline__Group__1__Impl )
            // InternalIntegrate.g:1345:2: rule__Pipeline__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Pipeline__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group__1"


    // $ANTLR start "rule__Pipeline__Group__1__Impl"
    // InternalIntegrate.g:1351:1: rule__Pipeline__Group__1__Impl : ( ( rule__Pipeline__Group_1__0 )* ) ;
    public final void rule__Pipeline__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1355:1: ( ( ( rule__Pipeline__Group_1__0 )* ) )
            // InternalIntegrate.g:1356:1: ( ( rule__Pipeline__Group_1__0 )* )
            {
            // InternalIntegrate.g:1356:1: ( ( rule__Pipeline__Group_1__0 )* )
            // InternalIntegrate.g:1357:2: ( rule__Pipeline__Group_1__0 )*
            {
             before(grammarAccess.getPipelineAccess().getGroup_1()); 
            // InternalIntegrate.g:1358:2: ( rule__Pipeline__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==32) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalIntegrate.g:1358:3: rule__Pipeline__Group_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__Pipeline__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getPipelineAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group__1__Impl"


    // $ANTLR start "rule__Pipeline__Group_1__0"
    // InternalIntegrate.g:1367:1: rule__Pipeline__Group_1__0 : rule__Pipeline__Group_1__0__Impl rule__Pipeline__Group_1__1 ;
    public final void rule__Pipeline__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1371:1: ( rule__Pipeline__Group_1__0__Impl rule__Pipeline__Group_1__1 )
            // InternalIntegrate.g:1372:2: rule__Pipeline__Group_1__0__Impl rule__Pipeline__Group_1__1
            {
            pushFollow(FOLLOW_22);
            rule__Pipeline__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Pipeline__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group_1__0"


    // $ANTLR start "rule__Pipeline__Group_1__0__Impl"
    // InternalIntegrate.g:1379:1: rule__Pipeline__Group_1__0__Impl : ( '|' ) ;
    public final void rule__Pipeline__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1383:1: ( ( '|' ) )
            // InternalIntegrate.g:1384:1: ( '|' )
            {
            // InternalIntegrate.g:1384:1: ( '|' )
            // InternalIntegrate.g:1385:2: '|'
            {
             before(grammarAccess.getPipelineAccess().getVerticalLineKeyword_1_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getPipelineAccess().getVerticalLineKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group_1__0__Impl"


    // $ANTLR start "rule__Pipeline__Group_1__1"
    // InternalIntegrate.g:1394:1: rule__Pipeline__Group_1__1 : rule__Pipeline__Group_1__1__Impl ;
    public final void rule__Pipeline__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1398:1: ( rule__Pipeline__Group_1__1__Impl )
            // InternalIntegrate.g:1399:2: rule__Pipeline__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Pipeline__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group_1__1"


    // $ANTLR start "rule__Pipeline__Group_1__1__Impl"
    // InternalIntegrate.g:1405:1: rule__Pipeline__Group_1__1__Impl : ( ( rule__Pipeline__NextAssignment_1_1 ) ) ;
    public final void rule__Pipeline__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1409:1: ( ( ( rule__Pipeline__NextAssignment_1_1 ) ) )
            // InternalIntegrate.g:1410:1: ( ( rule__Pipeline__NextAssignment_1_1 ) )
            {
            // InternalIntegrate.g:1410:1: ( ( rule__Pipeline__NextAssignment_1_1 ) )
            // InternalIntegrate.g:1411:2: ( rule__Pipeline__NextAssignment_1_1 )
            {
             before(grammarAccess.getPipelineAccess().getNextAssignment_1_1()); 
            // InternalIntegrate.g:1412:2: ( rule__Pipeline__NextAssignment_1_1 )
            // InternalIntegrate.g:1412:3: rule__Pipeline__NextAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Pipeline__NextAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getPipelineAccess().getNextAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__Group_1__1__Impl"


    // $ANTLR start "rule__PipelineTypeFilterStage__Group__0"
    // InternalIntegrate.g:1421:1: rule__PipelineTypeFilterStage__Group__0 : rule__PipelineTypeFilterStage__Group__0__Impl rule__PipelineTypeFilterStage__Group__1 ;
    public final void rule__PipelineTypeFilterStage__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1425:1: ( rule__PipelineTypeFilterStage__Group__0__Impl rule__PipelineTypeFilterStage__Group__1 )
            // InternalIntegrate.g:1426:2: rule__PipelineTypeFilterStage__Group__0__Impl rule__PipelineTypeFilterStage__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__PipelineTypeFilterStage__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineTypeFilterStage__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineTypeFilterStage__Group__0"


    // $ANTLR start "rule__PipelineTypeFilterStage__Group__0__Impl"
    // InternalIntegrate.g:1433:1: rule__PipelineTypeFilterStage__Group__0__Impl : ( ( rule__PipelineTypeFilterStage__NameAssignment_0 ) ) ;
    public final void rule__PipelineTypeFilterStage__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1437:1: ( ( ( rule__PipelineTypeFilterStage__NameAssignment_0 ) ) )
            // InternalIntegrate.g:1438:1: ( ( rule__PipelineTypeFilterStage__NameAssignment_0 ) )
            {
            // InternalIntegrate.g:1438:1: ( ( rule__PipelineTypeFilterStage__NameAssignment_0 ) )
            // InternalIntegrate.g:1439:2: ( rule__PipelineTypeFilterStage__NameAssignment_0 )
            {
             before(grammarAccess.getPipelineTypeFilterStageAccess().getNameAssignment_0()); 
            // InternalIntegrate.g:1440:2: ( rule__PipelineTypeFilterStage__NameAssignment_0 )
            // InternalIntegrate.g:1440:3: rule__PipelineTypeFilterStage__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineTypeFilterStage__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineTypeFilterStageAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineTypeFilterStage__Group__0__Impl"


    // $ANTLR start "rule__PipelineTypeFilterStage__Group__1"
    // InternalIntegrate.g:1448:1: rule__PipelineTypeFilterStage__Group__1 : rule__PipelineTypeFilterStage__Group__1__Impl ;
    public final void rule__PipelineTypeFilterStage__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1452:1: ( rule__PipelineTypeFilterStage__Group__1__Impl )
            // InternalIntegrate.g:1453:2: rule__PipelineTypeFilterStage__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PipelineTypeFilterStage__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineTypeFilterStage__Group__1"


    // $ANTLR start "rule__PipelineTypeFilterStage__Group__1__Impl"
    // InternalIntegrate.g:1459:1: rule__PipelineTypeFilterStage__Group__1__Impl : ( ( rule__PipelineTypeFilterStage__TypeAssignment_1 ) ) ;
    public final void rule__PipelineTypeFilterStage__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1463:1: ( ( ( rule__PipelineTypeFilterStage__TypeAssignment_1 ) ) )
            // InternalIntegrate.g:1464:1: ( ( rule__PipelineTypeFilterStage__TypeAssignment_1 ) )
            {
            // InternalIntegrate.g:1464:1: ( ( rule__PipelineTypeFilterStage__TypeAssignment_1 ) )
            // InternalIntegrate.g:1465:2: ( rule__PipelineTypeFilterStage__TypeAssignment_1 )
            {
             before(grammarAccess.getPipelineTypeFilterStageAccess().getTypeAssignment_1()); 
            // InternalIntegrate.g:1466:2: ( rule__PipelineTypeFilterStage__TypeAssignment_1 )
            // InternalIntegrate.g:1466:3: rule__PipelineTypeFilterStage__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PipelineTypeFilterStage__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPipelineTypeFilterStageAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineTypeFilterStage__Group__1__Impl"


    // $ANTLR start "rule__SatisfactionRule__Group__0"
    // InternalIntegrate.g:1475:1: rule__SatisfactionRule__Group__0 : rule__SatisfactionRule__Group__0__Impl rule__SatisfactionRule__Group__1 ;
    public final void rule__SatisfactionRule__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1479:1: ( rule__SatisfactionRule__Group__0__Impl rule__SatisfactionRule__Group__1 )
            // InternalIntegrate.g:1480:2: rule__SatisfactionRule__Group__0__Impl rule__SatisfactionRule__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__SatisfactionRule__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SatisfactionRule__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SatisfactionRule__Group__0"


    // $ANTLR start "rule__SatisfactionRule__Group__0__Impl"
    // InternalIntegrate.g:1487:1: rule__SatisfactionRule__Group__0__Impl : ( ( rule__SatisfactionRule__FirstRuleAssignment_0 ) ) ;
    public final void rule__SatisfactionRule__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1491:1: ( ( ( rule__SatisfactionRule__FirstRuleAssignment_0 ) ) )
            // InternalIntegrate.g:1492:1: ( ( rule__SatisfactionRule__FirstRuleAssignment_0 ) )
            {
            // InternalIntegrate.g:1492:1: ( ( rule__SatisfactionRule__FirstRuleAssignment_0 ) )
            // InternalIntegrate.g:1493:2: ( rule__SatisfactionRule__FirstRuleAssignment_0 )
            {
             before(grammarAccess.getSatisfactionRuleAccess().getFirstRuleAssignment_0()); 
            // InternalIntegrate.g:1494:2: ( rule__SatisfactionRule__FirstRuleAssignment_0 )
            // InternalIntegrate.g:1494:3: rule__SatisfactionRule__FirstRuleAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SatisfactionRule__FirstRuleAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSatisfactionRuleAccess().getFirstRuleAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SatisfactionRule__Group__0__Impl"


    // $ANTLR start "rule__SatisfactionRule__Group__1"
    // InternalIntegrate.g:1502:1: rule__SatisfactionRule__Group__1 : rule__SatisfactionRule__Group__1__Impl ;
    public final void rule__SatisfactionRule__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1506:1: ( rule__SatisfactionRule__Group__1__Impl )
            // InternalIntegrate.g:1507:2: rule__SatisfactionRule__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SatisfactionRule__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SatisfactionRule__Group__1"


    // $ANTLR start "rule__SatisfactionRule__Group__1__Impl"
    // InternalIntegrate.g:1513:1: rule__SatisfactionRule__Group__1__Impl : ( ( rule__SatisfactionRule__OtherRulesAssignment_1 )* ) ;
    public final void rule__SatisfactionRule__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1517:1: ( ( ( rule__SatisfactionRule__OtherRulesAssignment_1 )* ) )
            // InternalIntegrate.g:1518:1: ( ( rule__SatisfactionRule__OtherRulesAssignment_1 )* )
            {
            // InternalIntegrate.g:1518:1: ( ( rule__SatisfactionRule__OtherRulesAssignment_1 )* )
            // InternalIntegrate.g:1519:2: ( rule__SatisfactionRule__OtherRulesAssignment_1 )*
            {
             before(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAssignment_1()); 
            // InternalIntegrate.g:1520:2: ( rule__SatisfactionRule__OtherRulesAssignment_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=33 && LA13_0<=34)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalIntegrate.g:1520:3: rule__SatisfactionRule__OtherRulesAssignment_1
            	    {
            	    pushFollow(FOLLOW_24);
            	    rule__SatisfactionRule__OtherRulesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SatisfactionRule__Group__1__Impl"


    // $ANTLR start "rule__And__Group__0"
    // InternalIntegrate.g:1529:1: rule__And__Group__0 : rule__And__Group__0__Impl rule__And__Group__1 ;
    public final void rule__And__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1533:1: ( rule__And__Group__0__Impl rule__And__Group__1 )
            // InternalIntegrate.g:1534:2: rule__And__Group__0__Impl rule__And__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__And__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__And__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0"


    // $ANTLR start "rule__And__Group__0__Impl"
    // InternalIntegrate.g:1541:1: rule__And__Group__0__Impl : ( 'and' ) ;
    public final void rule__And__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1545:1: ( ( 'and' ) )
            // InternalIntegrate.g:1546:1: ( 'and' )
            {
            // InternalIntegrate.g:1546:1: ( 'and' )
            // InternalIntegrate.g:1547:2: 'and'
            {
             before(grammarAccess.getAndAccess().getAndKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getAndAccess().getAndKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__0__Impl"


    // $ANTLR start "rule__And__Group__1"
    // InternalIntegrate.g:1556:1: rule__And__Group__1 : rule__And__Group__1__Impl ;
    public final void rule__And__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1560:1: ( rule__And__Group__1__Impl )
            // InternalIntegrate.g:1561:2: rule__And__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__And__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1"


    // $ANTLR start "rule__And__Group__1__Impl"
    // InternalIntegrate.g:1567:1: rule__And__Group__1__Impl : ( ruleComparison ) ;
    public final void rule__And__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1571:1: ( ( ruleComparison ) )
            // InternalIntegrate.g:1572:1: ( ruleComparison )
            {
            // InternalIntegrate.g:1572:1: ( ruleComparison )
            // InternalIntegrate.g:1573:2: ruleComparison
            {
             before(grammarAccess.getAndAccess().getComparisonParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getAndAccess().getComparisonParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__And__Group__1__Impl"


    // $ANTLR start "rule__Or__Group__0"
    // InternalIntegrate.g:1583:1: rule__Or__Group__0 : rule__Or__Group__0__Impl rule__Or__Group__1 ;
    public final void rule__Or__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1587:1: ( rule__Or__Group__0__Impl rule__Or__Group__1 )
            // InternalIntegrate.g:1588:2: rule__Or__Group__0__Impl rule__Or__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Or__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Or__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0"


    // $ANTLR start "rule__Or__Group__0__Impl"
    // InternalIntegrate.g:1595:1: rule__Or__Group__0__Impl : ( 'or' ) ;
    public final void rule__Or__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1599:1: ( ( 'or' ) )
            // InternalIntegrate.g:1600:1: ( 'or' )
            {
            // InternalIntegrate.g:1600:1: ( 'or' )
            // InternalIntegrate.g:1601:2: 'or'
            {
             before(grammarAccess.getOrAccess().getOrKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getOrAccess().getOrKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__0__Impl"


    // $ANTLR start "rule__Or__Group__1"
    // InternalIntegrate.g:1610:1: rule__Or__Group__1 : rule__Or__Group__1__Impl ;
    public final void rule__Or__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1614:1: ( rule__Or__Group__1__Impl )
            // InternalIntegrate.g:1615:2: rule__Or__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Or__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1"


    // $ANTLR start "rule__Or__Group__1__Impl"
    // InternalIntegrate.g:1621:1: rule__Or__Group__1__Impl : ( ruleComparison ) ;
    public final void rule__Or__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1625:1: ( ( ruleComparison ) )
            // InternalIntegrate.g:1626:1: ( ruleComparison )
            {
            // InternalIntegrate.g:1626:1: ( ruleComparison )
            // InternalIntegrate.g:1627:2: ruleComparison
            {
             before(grammarAccess.getOrAccess().getComparisonParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getOrAccess().getComparisonParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Or__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group__0"
    // InternalIntegrate.g:1637:1: rule__Comparison__Group__0 : rule__Comparison__Group__0__Impl rule__Comparison__Group__1 ;
    public final void rule__Comparison__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1641:1: ( rule__Comparison__Group__0__Impl rule__Comparison__Group__1 )
            // InternalIntegrate.g:1642:2: rule__Comparison__Group__0__Impl rule__Comparison__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__Comparison__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0"


    // $ANTLR start "rule__Comparison__Group__0__Impl"
    // InternalIntegrate.g:1649:1: rule__Comparison__Group__0__Impl : ( ( rule__Comparison__Alternatives_0 ) ) ;
    public final void rule__Comparison__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1653:1: ( ( ( rule__Comparison__Alternatives_0 ) ) )
            // InternalIntegrate.g:1654:1: ( ( rule__Comparison__Alternatives_0 ) )
            {
            // InternalIntegrate.g:1654:1: ( ( rule__Comparison__Alternatives_0 ) )
            // InternalIntegrate.g:1655:2: ( rule__Comparison__Alternatives_0 )
            {
             before(grammarAccess.getComparisonAccess().getAlternatives_0()); 
            // InternalIntegrate.g:1656:2: ( rule__Comparison__Alternatives_0 )
            // InternalIntegrate.g:1656:3: rule__Comparison__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__0__Impl"


    // $ANTLR start "rule__Comparison__Group__1"
    // InternalIntegrate.g:1664:1: rule__Comparison__Group__1 : rule__Comparison__Group__1__Impl rule__Comparison__Group__2 ;
    public final void rule__Comparison__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1668:1: ( rule__Comparison__Group__1__Impl rule__Comparison__Group__2 )
            // InternalIntegrate.g:1669:2: rule__Comparison__Group__1__Impl rule__Comparison__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__Comparison__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Comparison__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1"


    // $ANTLR start "rule__Comparison__Group__1__Impl"
    // InternalIntegrate.g:1676:1: rule__Comparison__Group__1__Impl : ( ( rule__Comparison__C1Assignment_1 ) ) ;
    public final void rule__Comparison__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1680:1: ( ( ( rule__Comparison__C1Assignment_1 ) ) )
            // InternalIntegrate.g:1681:1: ( ( rule__Comparison__C1Assignment_1 ) )
            {
            // InternalIntegrate.g:1681:1: ( ( rule__Comparison__C1Assignment_1 ) )
            // InternalIntegrate.g:1682:2: ( rule__Comparison__C1Assignment_1 )
            {
             before(grammarAccess.getComparisonAccess().getC1Assignment_1()); 
            // InternalIntegrate.g:1683:2: ( rule__Comparison__C1Assignment_1 )
            // InternalIntegrate.g:1683:3: rule__Comparison__C1Assignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__C1Assignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getC1Assignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__1__Impl"


    // $ANTLR start "rule__Comparison__Group__2"
    // InternalIntegrate.g:1691:1: rule__Comparison__Group__2 : rule__Comparison__Group__2__Impl ;
    public final void rule__Comparison__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1695:1: ( rule__Comparison__Group__2__Impl )
            // InternalIntegrate.g:1696:2: rule__Comparison__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__2"


    // $ANTLR start "rule__Comparison__Group__2__Impl"
    // InternalIntegrate.g:1702:1: rule__Comparison__Group__2__Impl : ( ( rule__Comparison__Alternatives_2 ) ) ;
    public final void rule__Comparison__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1706:1: ( ( ( rule__Comparison__Alternatives_2 ) ) )
            // InternalIntegrate.g:1707:1: ( ( rule__Comparison__Alternatives_2 ) )
            {
            // InternalIntegrate.g:1707:1: ( ( rule__Comparison__Alternatives_2 ) )
            // InternalIntegrate.g:1708:2: ( rule__Comparison__Alternatives_2 )
            {
             before(grammarAccess.getComparisonAccess().getAlternatives_2()); 
            // InternalIntegrate.g:1709:2: ( rule__Comparison__Alternatives_2 )
            // InternalIntegrate.g:1709:3: rule__Comparison__Alternatives_2
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getAlternatives_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__Group__2__Impl"


    // $ANTLR start "rule__Integrate__ImportsAssignment_0"
    // InternalIntegrate.g:1718:1: rule__Integrate__ImportsAssignment_0 : ( ruleImport ) ;
    public final void rule__Integrate__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1722:1: ( ( ruleImport ) )
            // InternalIntegrate.g:1723:2: ( ruleImport )
            {
            // InternalIntegrate.g:1723:2: ( ruleImport )
            // InternalIntegrate.g:1724:3: ruleImport
            {
             before(grammarAccess.getIntegrateAccess().getImportsImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getIntegrateAccess().getImportsImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__ImportsAssignment_0"


    // $ANTLR start "rule__Integrate__ConflictResolutionStrategiesAssignment_1"
    // InternalIntegrate.g:1733:1: rule__Integrate__ConflictResolutionStrategiesAssignment_1 : ( ruleConflictResolutionStrategy ) ;
    public final void rule__Integrate__ConflictResolutionStrategiesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1737:1: ( ( ruleConflictResolutionStrategy ) )
            // InternalIntegrate.g:1738:2: ( ruleConflictResolutionStrategy )
            {
            // InternalIntegrate.g:1738:2: ( ruleConflictResolutionStrategy )
            // InternalIntegrate.g:1739:3: ruleConflictResolutionStrategy
            {
             before(grammarAccess.getIntegrateAccess().getConflictResolutionStrategiesConflictResolutionStrategyParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleConflictResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getIntegrateAccess().getConflictResolutionStrategiesConflictResolutionStrategyParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__ConflictResolutionStrategiesAssignment_1"


    // $ANTLR start "rule__Import__RuleAssignment_1"
    // InternalIntegrate.g:1748:1: rule__Import__RuleAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Import__RuleAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1752:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:1753:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:1753:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:1754:3: ( RULE_ID )
            {
             before(grammarAccess.getImportAccess().getRuleRuleCrossReference_1_0()); 
            // InternalIntegrate.g:1755:3: ( RULE_ID )
            // InternalIntegrate.g:1756:4: RULE_ID
            {
             before(grammarAccess.getImportAccess().getRuleRuleIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getRuleRuleIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getImportAccess().getRuleRuleCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__RuleAssignment_1"


    // $ANTLR start "rule__ConflictResolutionStrategy__VariablesAssignment_6"
    // InternalIntegrate.g:1767:1: rule__ConflictResolutionStrategy__VariablesAssignment_6 : ( ruleVariable ) ;
    public final void rule__ConflictResolutionStrategy__VariablesAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1771:1: ( ( ruleVariable ) )
            // InternalIntegrate.g:1772:2: ( ruleVariable )
            {
            // InternalIntegrate.g:1772:2: ( ruleVariable )
            // InternalIntegrate.g:1773:3: ruleVariable
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getVariablesVariableParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getConflictResolutionStrategyAccess().getVariablesVariableParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__VariablesAssignment_6"


    // $ANTLR start "rule__ConflictResolutionStrategy__RuleAssignment_9"
    // InternalIntegrate.g:1782:1: rule__ConflictResolutionStrategy__RuleAssignment_9 : ( ruleSatisfactionRule ) ;
    public final void rule__ConflictResolutionStrategy__RuleAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1786:1: ( ( ruleSatisfactionRule ) )
            // InternalIntegrate.g:1787:2: ( ruleSatisfactionRule )
            {
            // InternalIntegrate.g:1787:2: ( ruleSatisfactionRule )
            // InternalIntegrate.g:1788:3: ruleSatisfactionRule
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getRuleSatisfactionRuleParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleSatisfactionRule();

            state._fsp--;

             after(grammarAccess.getConflictResolutionStrategyAccess().getRuleSatisfactionRuleParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__RuleAssignment_9"


    // $ANTLR start "rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13"
    // InternalIntegrate.g:1797:1: rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13 : ( ruleResolutionStrategy ) ;
    public final void rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1801:1: ( ( ruleResolutionStrategy ) )
            // InternalIntegrate.g:1802:2: ( ruleResolutionStrategy )
            {
            // InternalIntegrate.g:1802:2: ( ruleResolutionStrategy )
            // InternalIntegrate.g:1803:3: ruleResolutionStrategy
            {
             before(grammarAccess.getConflictResolutionStrategyAccess().getResolutionStrategyResolutionStrategyParserRuleCall_13_0()); 
            pushFollow(FOLLOW_2);
            ruleResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getConflictResolutionStrategyAccess().getResolutionStrategyResolutionStrategyParserRuleCall_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionStrategy__ResolutionStrategyAssignment_13"


    // $ANTLR start "rule__Variable__NameAssignment_1"
    // InternalIntegrate.g:1812:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1816:1: ( ( RULE_ID ) )
            // InternalIntegrate.g:1817:2: ( RULE_ID )
            {
            // InternalIntegrate.g:1817:2: ( RULE_ID )
            // InternalIntegrate.g:1818:3: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment_1"


    // $ANTLR start "rule__Variable__PipelineAssignment_3"
    // InternalIntegrate.g:1827:1: rule__Variable__PipelineAssignment_3 : ( rulePipeline ) ;
    public final void rule__Variable__PipelineAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1831:1: ( ( rulePipeline ) )
            // InternalIntegrate.g:1832:2: ( rulePipeline )
            {
            // InternalIntegrate.g:1832:2: ( rulePipeline )
            // InternalIntegrate.g:1833:3: rulePipeline
            {
             before(grammarAccess.getVariableAccess().getPipelinePipelineParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            rulePipeline();

            state._fsp--;

             after(grammarAccess.getVariableAccess().getPipelinePipelineParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__PipelineAssignment_3"


    // $ANTLR start "rule__Pipeline__FirstAssignment_0"
    // InternalIntegrate.g:1842:1: rule__Pipeline__FirstAssignment_0 : ( ( rule__Pipeline__FirstAlternatives_0_0 ) ) ;
    public final void rule__Pipeline__FirstAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1846:1: ( ( ( rule__Pipeline__FirstAlternatives_0_0 ) ) )
            // InternalIntegrate.g:1847:2: ( ( rule__Pipeline__FirstAlternatives_0_0 ) )
            {
            // InternalIntegrate.g:1847:2: ( ( rule__Pipeline__FirstAlternatives_0_0 ) )
            // InternalIntegrate.g:1848:3: ( rule__Pipeline__FirstAlternatives_0_0 )
            {
             before(grammarAccess.getPipelineAccess().getFirstAlternatives_0_0()); 
            // InternalIntegrate.g:1849:3: ( rule__Pipeline__FirstAlternatives_0_0 )
            // InternalIntegrate.g:1849:4: rule__Pipeline__FirstAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Pipeline__FirstAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineAccess().getFirstAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__FirstAssignment_0"


    // $ANTLR start "rule__Pipeline__NextAssignment_1_1"
    // InternalIntegrate.g:1857:1: rule__Pipeline__NextAssignment_1_1 : ( rulePipelineStage ) ;
    public final void rule__Pipeline__NextAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1861:1: ( ( rulePipelineStage ) )
            // InternalIntegrate.g:1862:2: ( rulePipelineStage )
            {
            // InternalIntegrate.g:1862:2: ( rulePipelineStage )
            // InternalIntegrate.g:1863:3: rulePipelineStage
            {
             before(grammarAccess.getPipelineAccess().getNextPipelineStageParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            rulePipelineStage();

            state._fsp--;

             after(grammarAccess.getPipelineAccess().getNextPipelineStageParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__NextAssignment_1_1"


    // $ANTLR start "rule__PipelineStageSrc__NameAssignment"
    // InternalIntegrate.g:1872:1: rule__PipelineStageSrc__NameAssignment : ( ( '#src' ) ) ;
    public final void rule__PipelineStageSrc__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1876:1: ( ( ( '#src' ) ) )
            // InternalIntegrate.g:1877:2: ( ( '#src' ) )
            {
            // InternalIntegrate.g:1877:2: ( ( '#src' ) )
            // InternalIntegrate.g:1878:3: ( '#src' )
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0()); 
            // InternalIntegrate.g:1879:3: ( '#src' )
            // InternalIntegrate.g:1880:4: '#src'
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0()); 

            }

             after(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__NameAssignment"


    // $ANTLR start "rule__PipelineStageTrg__NameAssignment"
    // InternalIntegrate.g:1891:1: rule__PipelineStageTrg__NameAssignment : ( ( '#trg' ) ) ;
    public final void rule__PipelineStageTrg__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1895:1: ( ( ( '#trg' ) ) )
            // InternalIntegrate.g:1896:2: ( ( '#trg' ) )
            {
            // InternalIntegrate.g:1896:2: ( ( '#trg' ) )
            // InternalIntegrate.g:1897:3: ( '#trg' )
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0()); 
            // InternalIntegrate.g:1898:3: ( '#trg' )
            // InternalIntegrate.g:1899:4: '#trg'
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0()); 

            }

             after(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__NameAssignment"


    // $ANTLR start "rule__PipelineCreatedFilterStage__NameAssignment"
    // InternalIntegrate.g:1910:1: rule__PipelineCreatedFilterStage__NameAssignment : ( ( 'created' ) ) ;
    public final void rule__PipelineCreatedFilterStage__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1914:1: ( ( ( 'created' ) ) )
            // InternalIntegrate.g:1915:2: ( ( 'created' ) )
            {
            // InternalIntegrate.g:1915:2: ( ( 'created' ) )
            // InternalIntegrate.g:1916:3: ( 'created' )
            {
             before(grammarAccess.getPipelineCreatedFilterStageAccess().getNameCreatedKeyword_0()); 
            // InternalIntegrate.g:1917:3: ( 'created' )
            // InternalIntegrate.g:1918:4: 'created'
            {
             before(grammarAccess.getPipelineCreatedFilterStageAccess().getNameCreatedKeyword_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPipelineCreatedFilterStageAccess().getNameCreatedKeyword_0()); 

            }

             after(grammarAccess.getPipelineCreatedFilterStageAccess().getNameCreatedKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineCreatedFilterStage__NameAssignment"


    // $ANTLR start "rule__PipelineDeletedFilterStage__NameAssignment"
    // InternalIntegrate.g:1929:1: rule__PipelineDeletedFilterStage__NameAssignment : ( ( 'deleted' ) ) ;
    public final void rule__PipelineDeletedFilterStage__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1933:1: ( ( ( 'deleted' ) ) )
            // InternalIntegrate.g:1934:2: ( ( 'deleted' ) )
            {
            // InternalIntegrate.g:1934:2: ( ( 'deleted' ) )
            // InternalIntegrate.g:1935:3: ( 'deleted' )
            {
             before(grammarAccess.getPipelineDeletedFilterStageAccess().getNameDeletedKeyword_0()); 
            // InternalIntegrate.g:1936:3: ( 'deleted' )
            // InternalIntegrate.g:1937:4: 'deleted'
            {
             before(grammarAccess.getPipelineDeletedFilterStageAccess().getNameDeletedKeyword_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPipelineDeletedFilterStageAccess().getNameDeletedKeyword_0()); 

            }

             after(grammarAccess.getPipelineDeletedFilterStageAccess().getNameDeletedKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineDeletedFilterStage__NameAssignment"


    // $ANTLR start "rule__PipelineTypeFilterStage__NameAssignment_0"
    // InternalIntegrate.g:1948:1: rule__PipelineTypeFilterStage__NameAssignment_0 : ( ( 'type' ) ) ;
    public final void rule__PipelineTypeFilterStage__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1952:1: ( ( ( 'type' ) ) )
            // InternalIntegrate.g:1953:2: ( ( 'type' ) )
            {
            // InternalIntegrate.g:1953:2: ( ( 'type' ) )
            // InternalIntegrate.g:1954:3: ( 'type' )
            {
             before(grammarAccess.getPipelineTypeFilterStageAccess().getNameTypeKeyword_0_0()); 
            // InternalIntegrate.g:1955:3: ( 'type' )
            // InternalIntegrate.g:1956:4: 'type'
            {
             before(grammarAccess.getPipelineTypeFilterStageAccess().getNameTypeKeyword_0_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getPipelineTypeFilterStageAccess().getNameTypeKeyword_0_0()); 

            }

             after(grammarAccess.getPipelineTypeFilterStageAccess().getNameTypeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineTypeFilterStage__NameAssignment_0"


    // $ANTLR start "rule__PipelineTypeFilterStage__TypeAssignment_1"
    // InternalIntegrate.g:1967:1: rule__PipelineTypeFilterStage__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PipelineTypeFilterStage__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1971:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:1972:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:1972:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:1973:3: ( RULE_ID )
            {
             before(grammarAccess.getPipelineTypeFilterStageAccess().getTypeEClassifierCrossReference_1_0()); 
            // InternalIntegrate.g:1974:3: ( RULE_ID )
            // InternalIntegrate.g:1975:4: RULE_ID
            {
             before(grammarAccess.getPipelineTypeFilterStageAccess().getTypeEClassifierIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPipelineTypeFilterStageAccess().getTypeEClassifierIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPipelineTypeFilterStageAccess().getTypeEClassifierCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineTypeFilterStage__TypeAssignment_1"


    // $ANTLR start "rule__PipelineCountStage__NameAssignment"
    // InternalIntegrate.g:1986:1: rule__PipelineCountStage__NameAssignment : ( ( 'count' ) ) ;
    public final void rule__PipelineCountStage__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1990:1: ( ( ( 'count' ) ) )
            // InternalIntegrate.g:1991:2: ( ( 'count' ) )
            {
            // InternalIntegrate.g:1991:2: ( ( 'count' ) )
            // InternalIntegrate.g:1992:3: ( 'count' )
            {
             before(grammarAccess.getPipelineCountStageAccess().getNameCountKeyword_0()); 
            // InternalIntegrate.g:1993:3: ( 'count' )
            // InternalIntegrate.g:1994:4: 'count'
            {
             before(grammarAccess.getPipelineCountStageAccess().getNameCountKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getPipelineCountStageAccess().getNameCountKeyword_0()); 

            }

             after(grammarAccess.getPipelineCountStageAccess().getNameCountKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineCountStage__NameAssignment"


    // $ANTLR start "rule__SatisfactionRule__FirstRuleAssignment_0"
    // InternalIntegrate.g:2005:1: rule__SatisfactionRule__FirstRuleAssignment_0 : ( ruleComparison ) ;
    public final void rule__SatisfactionRule__FirstRuleAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2009:1: ( ( ruleComparison ) )
            // InternalIntegrate.g:2010:2: ( ruleComparison )
            {
            // InternalIntegrate.g:2010:2: ( ruleComparison )
            // InternalIntegrate.g:2011:3: ruleComparison
            {
             before(grammarAccess.getSatisfactionRuleAccess().getFirstRuleComparisonParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleComparison();

            state._fsp--;

             after(grammarAccess.getSatisfactionRuleAccess().getFirstRuleComparisonParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SatisfactionRule__FirstRuleAssignment_0"


    // $ANTLR start "rule__SatisfactionRule__OtherRulesAssignment_1"
    // InternalIntegrate.g:2020:1: rule__SatisfactionRule__OtherRulesAssignment_1 : ( ( rule__SatisfactionRule__OtherRulesAlternatives_1_0 ) ) ;
    public final void rule__SatisfactionRule__OtherRulesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2024:1: ( ( ( rule__SatisfactionRule__OtherRulesAlternatives_1_0 ) ) )
            // InternalIntegrate.g:2025:2: ( ( rule__SatisfactionRule__OtherRulesAlternatives_1_0 ) )
            {
            // InternalIntegrate.g:2025:2: ( ( rule__SatisfactionRule__OtherRulesAlternatives_1_0 ) )
            // InternalIntegrate.g:2026:3: ( rule__SatisfactionRule__OtherRulesAlternatives_1_0 )
            {
             before(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAlternatives_1_0()); 
            // InternalIntegrate.g:2027:3: ( rule__SatisfactionRule__OtherRulesAlternatives_1_0 )
            // InternalIntegrate.g:2027:4: rule__SatisfactionRule__OtherRulesAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__SatisfactionRule__OtherRulesAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getSatisfactionRuleAccess().getOtherRulesAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SatisfactionRule__OtherRulesAssignment_1"


    // $ANTLR start "rule__Comparison__V1Assignment_0_0"
    // InternalIntegrate.g:2035:1: rule__Comparison__V1Assignment_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Comparison__V1Assignment_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2039:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:2040:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:2040:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:2041:3: ( RULE_ID )
            {
             before(grammarAccess.getComparisonAccess().getV1VariableCrossReference_0_0_0()); 
            // InternalIntegrate.g:2042:3: ( RULE_ID )
            // InternalIntegrate.g:2043:4: RULE_ID
            {
             before(grammarAccess.getComparisonAccess().getV1VariableIDTerminalRuleCall_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComparisonAccess().getV1VariableIDTerminalRuleCall_0_0_0_1()); 

            }

             after(grammarAccess.getComparisonAccess().getV1VariableCrossReference_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__V1Assignment_0_0"


    // $ANTLR start "rule__Comparison__N1Assignment_0_1"
    // InternalIntegrate.g:2054:1: rule__Comparison__N1Assignment_0_1 : ( RULE_INT ) ;
    public final void rule__Comparison__N1Assignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2058:1: ( ( RULE_INT ) )
            // InternalIntegrate.g:2059:2: ( RULE_INT )
            {
            // InternalIntegrate.g:2059:2: ( RULE_INT )
            // InternalIntegrate.g:2060:3: RULE_INT
            {
             before(grammarAccess.getComparisonAccess().getN1INTTerminalRuleCall_0_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getComparisonAccess().getN1INTTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__N1Assignment_0_1"


    // $ANTLR start "rule__Comparison__C1Assignment_1"
    // InternalIntegrate.g:2069:1: rule__Comparison__C1Assignment_1 : ( ( rule__Comparison__C1Alternatives_1_0 ) ) ;
    public final void rule__Comparison__C1Assignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2073:1: ( ( ( rule__Comparison__C1Alternatives_1_0 ) ) )
            // InternalIntegrate.g:2074:2: ( ( rule__Comparison__C1Alternatives_1_0 ) )
            {
            // InternalIntegrate.g:2074:2: ( ( rule__Comparison__C1Alternatives_1_0 ) )
            // InternalIntegrate.g:2075:3: ( rule__Comparison__C1Alternatives_1_0 )
            {
             before(grammarAccess.getComparisonAccess().getC1Alternatives_1_0()); 
            // InternalIntegrate.g:2076:3: ( rule__Comparison__C1Alternatives_1_0 )
            // InternalIntegrate.g:2076:4: rule__Comparison__C1Alternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Comparison__C1Alternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonAccess().getC1Alternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__C1Assignment_1"


    // $ANTLR start "rule__Comparison__V2Assignment_2_0"
    // InternalIntegrate.g:2084:1: rule__Comparison__V2Assignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Comparison__V2Assignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2088:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:2089:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:2089:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:2090:3: ( RULE_ID )
            {
             before(grammarAccess.getComparisonAccess().getV2VariableCrossReference_2_0_0()); 
            // InternalIntegrate.g:2091:3: ( RULE_ID )
            // InternalIntegrate.g:2092:4: RULE_ID
            {
             before(grammarAccess.getComparisonAccess().getV2VariableIDTerminalRuleCall_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getComparisonAccess().getV2VariableIDTerminalRuleCall_2_0_0_1()); 

            }

             after(grammarAccess.getComparisonAccess().getV2VariableCrossReference_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__V2Assignment_2_0"


    // $ANTLR start "rule__Comparison__N2Assignment_2_1"
    // InternalIntegrate.g:2103:1: rule__Comparison__N2Assignment_2_1 : ( RULE_INT ) ;
    public final void rule__Comparison__N2Assignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2107:1: ( ( RULE_INT ) )
            // InternalIntegrate.g:2108:2: ( RULE_INT )
            {
            // InternalIntegrate.g:2108:2: ( RULE_INT )
            // InternalIntegrate.g:2109:3: RULE_INT
            {
             before(grammarAccess.getComparisonAccess().getN2INTTerminalRuleCall_2_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getComparisonAccess().getN2INTTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Comparison__N2Assignment_2_1"


    // $ANTLR start "rule__ResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:2118:1: rule__ResolutionStrategy__NameAssignment : ( ( rule__ResolutionStrategy__NameAlternatives_0 ) ) ;
    public final void rule__ResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2122:1: ( ( ( rule__ResolutionStrategy__NameAlternatives_0 ) ) )
            // InternalIntegrate.g:2123:2: ( ( rule__ResolutionStrategy__NameAlternatives_0 ) )
            {
            // InternalIntegrate.g:2123:2: ( ( rule__ResolutionStrategy__NameAlternatives_0 ) )
            // InternalIntegrate.g:2124:3: ( rule__ResolutionStrategy__NameAlternatives_0 )
            {
             before(grammarAccess.getResolutionStrategyAccess().getNameAlternatives_0()); 
            // InternalIntegrate.g:2125:3: ( rule__ResolutionStrategy__NameAlternatives_0 )
            // InternalIntegrate.g:2125:4: rule__ResolutionStrategy__NameAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategy__NameAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getResolutionStrategyAccess().getNameAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategy__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000001F8000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x000001E000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000007800L});

}