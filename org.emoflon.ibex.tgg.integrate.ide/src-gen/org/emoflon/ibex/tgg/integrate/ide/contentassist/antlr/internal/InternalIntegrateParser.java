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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'package'", "'.'", "'import'", "':'", "'solve'", "'{'", "'satisfies'", "'}'", "'with'", "'var'", "'='", "'|'", "','", "'or'", "'and'", "'('", "')'", "'when'", "'src'", "'trg'", "'created'", "'deleted'", "'type'", "'count'", "'exists'", "'not'", "'mergeAndPreserve'", "'revokeAddition'", "'revokeDeletion'", "'preferSource'", "'preferTarget'", "'deleteCorrespondences'", "'continue'"
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


    // $ANTLR start "entryRulePackage"
    // InternalIntegrate.g:78:1: entryRulePackage : rulePackage EOF ;
    public final void entryRulePackage() throws RecognitionException {
        try {
            // InternalIntegrate.g:79:1: ( rulePackage EOF )
            // InternalIntegrate.g:80:1: rulePackage EOF
            {
             before(grammarAccess.getPackageRule()); 
            pushFollow(FOLLOW_1);
            rulePackage();

            state._fsp--;

             after(grammarAccess.getPackageRule()); 
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
    // $ANTLR end "entryRulePackage"


    // $ANTLR start "rulePackage"
    // InternalIntegrate.g:87:1: rulePackage : ( ( rule__Package__Group__0 ) ) ;
    public final void rulePackage() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:91:2: ( ( ( rule__Package__Group__0 ) ) )
            // InternalIntegrate.g:92:2: ( ( rule__Package__Group__0 ) )
            {
            // InternalIntegrate.g:92:2: ( ( rule__Package__Group__0 ) )
            // InternalIntegrate.g:93:3: ( rule__Package__Group__0 )
            {
             before(grammarAccess.getPackageAccess().getGroup()); 
            // InternalIntegrate.g:94:3: ( rule__Package__Group__0 )
            // InternalIntegrate.g:94:4: rule__Package__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Package__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackage"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalIntegrate.g:103:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // InternalIntegrate.g:104:1: ( ruleQualifiedName EOF )
            // InternalIntegrate.g:105:1: ruleQualifiedName EOF
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
    // InternalIntegrate.g:112:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:116:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // InternalIntegrate.g:117:2: ( ( rule__QualifiedName__Group__0 ) )
            {
            // InternalIntegrate.g:117:2: ( ( rule__QualifiedName__Group__0 ) )
            // InternalIntegrate.g:118:3: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // InternalIntegrate.g:119:3: ( rule__QualifiedName__Group__0 )
            // InternalIntegrate.g:119:4: rule__QualifiedName__Group__0
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


    // $ANTLR start "entryRuleImport"
    // InternalIntegrate.g:128:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalIntegrate.g:129:1: ( ruleImport EOF )
            // InternalIntegrate.g:130:1: ruleImport EOF
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
    // InternalIntegrate.g:137:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:141:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalIntegrate.g:142:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalIntegrate.g:142:2: ( ( rule__Import__Group__0 ) )
            // InternalIntegrate.g:143:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalIntegrate.g:144:3: ( rule__Import__Group__0 )
            // InternalIntegrate.g:144:4: rule__Import__Group__0
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


    // $ANTLR start "entryRuleConflictResolutionSpecification"
    // InternalIntegrate.g:153:1: entryRuleConflictResolutionSpecification : ruleConflictResolutionSpecification EOF ;
    public final void entryRuleConflictResolutionSpecification() throws RecognitionException {
        try {
            // InternalIntegrate.g:154:1: ( ruleConflictResolutionSpecification EOF )
            // InternalIntegrate.g:155:1: ruleConflictResolutionSpecification EOF
            {
             before(grammarAccess.getConflictResolutionSpecificationRule()); 
            pushFollow(FOLLOW_1);
            ruleConflictResolutionSpecification();

            state._fsp--;

             after(grammarAccess.getConflictResolutionSpecificationRule()); 
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
    // $ANTLR end "entryRuleConflictResolutionSpecification"


    // $ANTLR start "ruleConflictResolutionSpecification"
    // InternalIntegrate.g:162:1: ruleConflictResolutionSpecification : ( ( rule__ConflictResolutionSpecification__Group__0 ) ) ;
    public final void ruleConflictResolutionSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:166:2: ( ( ( rule__ConflictResolutionSpecification__Group__0 ) ) )
            // InternalIntegrate.g:167:2: ( ( rule__ConflictResolutionSpecification__Group__0 ) )
            {
            // InternalIntegrate.g:167:2: ( ( rule__ConflictResolutionSpecification__Group__0 ) )
            // InternalIntegrate.g:168:3: ( rule__ConflictResolutionSpecification__Group__0 )
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getGroup()); 
            // InternalIntegrate.g:169:3: ( rule__ConflictResolutionSpecification__Group__0 )
            // InternalIntegrate.g:169:4: rule__ConflictResolutionSpecification__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionSpecificationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConflictResolutionSpecification"


    // $ANTLR start "entryRuleVariable"
    // InternalIntegrate.g:178:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalIntegrate.g:179:1: ( ruleVariable EOF )
            // InternalIntegrate.g:180:1: ruleVariable EOF
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
    // InternalIntegrate.g:187:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:191:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalIntegrate.g:192:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalIntegrate.g:192:2: ( ( rule__Variable__Group__0 ) )
            // InternalIntegrate.g:193:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalIntegrate.g:194:3: ( rule__Variable__Group__0 )
            // InternalIntegrate.g:194:4: rule__Variable__Group__0
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


    // $ANTLR start "entryRuleVariableReference"
    // InternalIntegrate.g:203:1: entryRuleVariableReference : ruleVariableReference EOF ;
    public final void entryRuleVariableReference() throws RecognitionException {
        try {
            // InternalIntegrate.g:204:1: ( ruleVariableReference EOF )
            // InternalIntegrate.g:205:1: ruleVariableReference EOF
            {
             before(grammarAccess.getVariableReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleVariableReference();

            state._fsp--;

             after(grammarAccess.getVariableReferenceRule()); 
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
    // $ANTLR end "entryRuleVariableReference"


    // $ANTLR start "ruleVariableReference"
    // InternalIntegrate.g:212:1: ruleVariableReference : ( ( rule__VariableReference__RefAssignment ) ) ;
    public final void ruleVariableReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:216:2: ( ( ( rule__VariableReference__RefAssignment ) ) )
            // InternalIntegrate.g:217:2: ( ( rule__VariableReference__RefAssignment ) )
            {
            // InternalIntegrate.g:217:2: ( ( rule__VariableReference__RefAssignment ) )
            // InternalIntegrate.g:218:3: ( rule__VariableReference__RefAssignment )
            {
             before(grammarAccess.getVariableReferenceAccess().getRefAssignment()); 
            // InternalIntegrate.g:219:3: ( rule__VariableReference__RefAssignment )
            // InternalIntegrate.g:219:4: rule__VariableReference__RefAssignment
            {
            pushFollow(FOLLOW_2);
            rule__VariableReference__RefAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVariableReferenceAccess().getRefAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableReference"


    // $ANTLR start "entryRulePipeline"
    // InternalIntegrate.g:228:1: entryRulePipeline : rulePipeline EOF ;
    public final void entryRulePipeline() throws RecognitionException {
        try {
            // InternalIntegrate.g:229:1: ( rulePipeline EOF )
            // InternalIntegrate.g:230:1: rulePipeline EOF
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
    // InternalIntegrate.g:237:1: rulePipeline : ( ( rule__Pipeline__StartAssignment ) ) ;
    public final void rulePipeline() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:241:2: ( ( ( rule__Pipeline__StartAssignment ) ) )
            // InternalIntegrate.g:242:2: ( ( rule__Pipeline__StartAssignment ) )
            {
            // InternalIntegrate.g:242:2: ( ( rule__Pipeline__StartAssignment ) )
            // InternalIntegrate.g:243:3: ( rule__Pipeline__StartAssignment )
            {
             before(grammarAccess.getPipelineAccess().getStartAssignment()); 
            // InternalIntegrate.g:244:3: ( rule__Pipeline__StartAssignment )
            // InternalIntegrate.g:244:4: rule__Pipeline__StartAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Pipeline__StartAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineAccess().getStartAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRulePipelineStageStart"
    // InternalIntegrate.g:253:1: entryRulePipelineStageStart : rulePipelineStageStart EOF ;
    public final void entryRulePipelineStageStart() throws RecognitionException {
        try {
            // InternalIntegrate.g:254:1: ( rulePipelineStageStart EOF )
            // InternalIntegrate.g:255:1: rulePipelineStageStart EOF
            {
             before(grammarAccess.getPipelineStageStartRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageStart();

            state._fsp--;

             after(grammarAccess.getPipelineStageStartRule()); 
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
    // $ANTLR end "entryRulePipelineStageStart"


    // $ANTLR start "rulePipelineStageStart"
    // InternalIntegrate.g:262:1: rulePipelineStageStart : ( ( rule__PipelineStageStart__Alternatives ) ) ;
    public final void rulePipelineStageStart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:266:2: ( ( ( rule__PipelineStageStart__Alternatives ) ) )
            // InternalIntegrate.g:267:2: ( ( rule__PipelineStageStart__Alternatives ) )
            {
            // InternalIntegrate.g:267:2: ( ( rule__PipelineStageStart__Alternatives ) )
            // InternalIntegrate.g:268:3: ( rule__PipelineStageStart__Alternatives )
            {
             before(grammarAccess.getPipelineStageStartAccess().getAlternatives()); 
            // InternalIntegrate.g:269:3: ( rule__PipelineStageStart__Alternatives )
            // InternalIntegrate.g:269:4: rule__PipelineStageStart__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageStart__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageStartAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageStart"


    // $ANTLR start "entryRulePipelineStageSrc"
    // InternalIntegrate.g:278:1: entryRulePipelineStageSrc : rulePipelineStageSrc EOF ;
    public final void entryRulePipelineStageSrc() throws RecognitionException {
        try {
            // InternalIntegrate.g:279:1: ( rulePipelineStageSrc EOF )
            // InternalIntegrate.g:280:1: rulePipelineStageSrc EOF
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
    // InternalIntegrate.g:287:1: rulePipelineStageSrc : ( ( rule__PipelineStageSrc__Group__0 ) ) ;
    public final void rulePipelineStageSrc() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:291:2: ( ( ( rule__PipelineStageSrc__Group__0 ) ) )
            // InternalIntegrate.g:292:2: ( ( rule__PipelineStageSrc__Group__0 ) )
            {
            // InternalIntegrate.g:292:2: ( ( rule__PipelineStageSrc__Group__0 ) )
            // InternalIntegrate.g:293:3: ( rule__PipelineStageSrc__Group__0 )
            {
             before(grammarAccess.getPipelineStageSrcAccess().getGroup()); 
            // InternalIntegrate.g:294:3: ( rule__PipelineStageSrc__Group__0 )
            // InternalIntegrate.g:294:4: rule__PipelineStageSrc__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageSrcAccess().getGroup()); 

            }


            }

        }
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
    // InternalIntegrate.g:303:1: entryRulePipelineStageTrg : rulePipelineStageTrg EOF ;
    public final void entryRulePipelineStageTrg() throws RecognitionException {
        try {
            // InternalIntegrate.g:304:1: ( rulePipelineStageTrg EOF )
            // InternalIntegrate.g:305:1: rulePipelineStageTrg EOF
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
    // InternalIntegrate.g:312:1: rulePipelineStageTrg : ( ( rule__PipelineStageTrg__Group__0 ) ) ;
    public final void rulePipelineStageTrg() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:316:2: ( ( ( rule__PipelineStageTrg__Group__0 ) ) )
            // InternalIntegrate.g:317:2: ( ( rule__PipelineStageTrg__Group__0 ) )
            {
            // InternalIntegrate.g:317:2: ( ( rule__PipelineStageTrg__Group__0 ) )
            // InternalIntegrate.g:318:3: ( rule__PipelineStageTrg__Group__0 )
            {
             before(grammarAccess.getPipelineStageTrgAccess().getGroup()); 
            // InternalIntegrate.g:319:3: ( rule__PipelineStageTrg__Group__0 )
            // InternalIntegrate.g:319:4: rule__PipelineStageTrg__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTrgAccess().getGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRulePipelineStageFilter"
    // InternalIntegrate.g:328:1: entryRulePipelineStageFilter : rulePipelineStageFilter EOF ;
    public final void entryRulePipelineStageFilter() throws RecognitionException {
        try {
            // InternalIntegrate.g:329:1: ( rulePipelineStageFilter EOF )
            // InternalIntegrate.g:330:1: rulePipelineStageFilter EOF
            {
             before(grammarAccess.getPipelineStageFilterRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageFilter();

            state._fsp--;

             after(grammarAccess.getPipelineStageFilterRule()); 
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
    // $ANTLR end "entryRulePipelineStageFilter"


    // $ANTLR start "rulePipelineStageFilter"
    // InternalIntegrate.g:337:1: rulePipelineStageFilter : ( ( rule__PipelineStageFilter__Alternatives ) ) ;
    public final void rulePipelineStageFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:341:2: ( ( ( rule__PipelineStageFilter__Alternatives ) ) )
            // InternalIntegrate.g:342:2: ( ( rule__PipelineStageFilter__Alternatives ) )
            {
            // InternalIntegrate.g:342:2: ( ( rule__PipelineStageFilter__Alternatives ) )
            // InternalIntegrate.g:343:3: ( rule__PipelineStageFilter__Alternatives )
            {
             before(grammarAccess.getPipelineStageFilterAccess().getAlternatives()); 
            // InternalIntegrate.g:344:3: ( rule__PipelineStageFilter__Alternatives )
            // InternalIntegrate.g:344:4: rule__PipelineStageFilter__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageFilter__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageFilterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageFilter"


    // $ANTLR start "entryRulePipelineStageModification"
    // InternalIntegrate.g:353:1: entryRulePipelineStageModification : rulePipelineStageModification EOF ;
    public final void entryRulePipelineStageModification() throws RecognitionException {
        try {
            // InternalIntegrate.g:354:1: ( rulePipelineStageModification EOF )
            // InternalIntegrate.g:355:1: rulePipelineStageModification EOF
            {
             before(grammarAccess.getPipelineStageModificationRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageModification();

            state._fsp--;

             after(grammarAccess.getPipelineStageModificationRule()); 
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
    // $ANTLR end "entryRulePipelineStageModification"


    // $ANTLR start "rulePipelineStageModification"
    // InternalIntegrate.g:362:1: rulePipelineStageModification : ( ( rule__PipelineStageModification__Alternatives ) ) ;
    public final void rulePipelineStageModification() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:366:2: ( ( ( rule__PipelineStageModification__Alternatives ) ) )
            // InternalIntegrate.g:367:2: ( ( rule__PipelineStageModification__Alternatives ) )
            {
            // InternalIntegrate.g:367:2: ( ( rule__PipelineStageModification__Alternatives ) )
            // InternalIntegrate.g:368:3: ( rule__PipelineStageModification__Alternatives )
            {
             before(grammarAccess.getPipelineStageModificationAccess().getAlternatives()); 
            // InternalIntegrate.g:369:3: ( rule__PipelineStageModification__Alternatives )
            // InternalIntegrate.g:369:4: rule__PipelineStageModification__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageModification__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageModificationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageModification"


    // $ANTLR start "entryRulePipelineStageCreated"
    // InternalIntegrate.g:378:1: entryRulePipelineStageCreated : rulePipelineStageCreated EOF ;
    public final void entryRulePipelineStageCreated() throws RecognitionException {
        try {
            // InternalIntegrate.g:379:1: ( rulePipelineStageCreated EOF )
            // InternalIntegrate.g:380:1: rulePipelineStageCreated EOF
            {
             before(grammarAccess.getPipelineStageCreatedRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageCreated();

            state._fsp--;

             after(grammarAccess.getPipelineStageCreatedRule()); 
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
    // $ANTLR end "entryRulePipelineStageCreated"


    // $ANTLR start "rulePipelineStageCreated"
    // InternalIntegrate.g:387:1: rulePipelineStageCreated : ( ( rule__PipelineStageCreated__Group__0 ) ) ;
    public final void rulePipelineStageCreated() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:391:2: ( ( ( rule__PipelineStageCreated__Group__0 ) ) )
            // InternalIntegrate.g:392:2: ( ( rule__PipelineStageCreated__Group__0 ) )
            {
            // InternalIntegrate.g:392:2: ( ( rule__PipelineStageCreated__Group__0 ) )
            // InternalIntegrate.g:393:3: ( rule__PipelineStageCreated__Group__0 )
            {
             before(grammarAccess.getPipelineStageCreatedAccess().getGroup()); 
            // InternalIntegrate.g:394:3: ( rule__PipelineStageCreated__Group__0 )
            // InternalIntegrate.g:394:4: rule__PipelineStageCreated__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageCreated__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageCreatedAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageCreated"


    // $ANTLR start "entryRulePipelineStageDeleted"
    // InternalIntegrate.g:403:1: entryRulePipelineStageDeleted : rulePipelineStageDeleted EOF ;
    public final void entryRulePipelineStageDeleted() throws RecognitionException {
        try {
            // InternalIntegrate.g:404:1: ( rulePipelineStageDeleted EOF )
            // InternalIntegrate.g:405:1: rulePipelineStageDeleted EOF
            {
             before(grammarAccess.getPipelineStageDeletedRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageDeleted();

            state._fsp--;

             after(grammarAccess.getPipelineStageDeletedRule()); 
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
    // $ANTLR end "entryRulePipelineStageDeleted"


    // $ANTLR start "rulePipelineStageDeleted"
    // InternalIntegrate.g:412:1: rulePipelineStageDeleted : ( ( rule__PipelineStageDeleted__Group__0 ) ) ;
    public final void rulePipelineStageDeleted() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:416:2: ( ( ( rule__PipelineStageDeleted__Group__0 ) ) )
            // InternalIntegrate.g:417:2: ( ( rule__PipelineStageDeleted__Group__0 ) )
            {
            // InternalIntegrate.g:417:2: ( ( rule__PipelineStageDeleted__Group__0 ) )
            // InternalIntegrate.g:418:3: ( rule__PipelineStageDeleted__Group__0 )
            {
             before(grammarAccess.getPipelineStageDeletedAccess().getGroup()); 
            // InternalIntegrate.g:419:3: ( rule__PipelineStageDeleted__Group__0 )
            // InternalIntegrate.g:419:4: rule__PipelineStageDeleted__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageDeleted__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageDeletedAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageDeleted"


    // $ANTLR start "entryRulePipelineStageType"
    // InternalIntegrate.g:428:1: entryRulePipelineStageType : rulePipelineStageType EOF ;
    public final void entryRulePipelineStageType() throws RecognitionException {
        try {
            // InternalIntegrate.g:429:1: ( rulePipelineStageType EOF )
            // InternalIntegrate.g:430:1: rulePipelineStageType EOF
            {
             before(grammarAccess.getPipelineStageTypeRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageType();

            state._fsp--;

             after(grammarAccess.getPipelineStageTypeRule()); 
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
    // $ANTLR end "entryRulePipelineStageType"


    // $ANTLR start "rulePipelineStageType"
    // InternalIntegrate.g:437:1: rulePipelineStageType : ( ( rule__PipelineStageType__Group__0 ) ) ;
    public final void rulePipelineStageType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:441:2: ( ( ( rule__PipelineStageType__Group__0 ) ) )
            // InternalIntegrate.g:442:2: ( ( rule__PipelineStageType__Group__0 ) )
            {
            // InternalIntegrate.g:442:2: ( ( rule__PipelineStageType__Group__0 ) )
            // InternalIntegrate.g:443:3: ( rule__PipelineStageType__Group__0 )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getGroup()); 
            // InternalIntegrate.g:444:3: ( rule__PipelineStageType__Group__0 )
            // InternalIntegrate.g:444:4: rule__PipelineStageType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageType"


    // $ANTLR start "entryRulePipelineStageEnd"
    // InternalIntegrate.g:453:1: entryRulePipelineStageEnd : rulePipelineStageEnd EOF ;
    public final void entryRulePipelineStageEnd() throws RecognitionException {
        try {
            // InternalIntegrate.g:454:1: ( rulePipelineStageEnd EOF )
            // InternalIntegrate.g:455:1: rulePipelineStageEnd EOF
            {
             before(grammarAccess.getPipelineStageEndRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageEnd();

            state._fsp--;

             after(grammarAccess.getPipelineStageEndRule()); 
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
    // $ANTLR end "entryRulePipelineStageEnd"


    // $ANTLR start "rulePipelineStageEnd"
    // InternalIntegrate.g:462:1: rulePipelineStageEnd : ( ( rule__PipelineStageEnd__Alternatives ) ) ;
    public final void rulePipelineStageEnd() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:466:2: ( ( ( rule__PipelineStageEnd__Alternatives ) ) )
            // InternalIntegrate.g:467:2: ( ( rule__PipelineStageEnd__Alternatives ) )
            {
            // InternalIntegrate.g:467:2: ( ( rule__PipelineStageEnd__Alternatives ) )
            // InternalIntegrate.g:468:3: ( rule__PipelineStageEnd__Alternatives )
            {
             before(grammarAccess.getPipelineStageEndAccess().getAlternatives()); 
            // InternalIntegrate.g:469:3: ( rule__PipelineStageEnd__Alternatives )
            // InternalIntegrate.g:469:4: rule__PipelineStageEnd__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageEnd__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageEndAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageEnd"


    // $ANTLR start "entryRulePipelineStageCount"
    // InternalIntegrate.g:478:1: entryRulePipelineStageCount : rulePipelineStageCount EOF ;
    public final void entryRulePipelineStageCount() throws RecognitionException {
        try {
            // InternalIntegrate.g:479:1: ( rulePipelineStageCount EOF )
            // InternalIntegrate.g:480:1: rulePipelineStageCount EOF
            {
             before(grammarAccess.getPipelineStageCountRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageCount();

            state._fsp--;

             after(grammarAccess.getPipelineStageCountRule()); 
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
    // $ANTLR end "entryRulePipelineStageCount"


    // $ANTLR start "rulePipelineStageCount"
    // InternalIntegrate.g:487:1: rulePipelineStageCount : ( ( rule__PipelineStageCount__NameAssignment ) ) ;
    public final void rulePipelineStageCount() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:491:2: ( ( ( rule__PipelineStageCount__NameAssignment ) ) )
            // InternalIntegrate.g:492:2: ( ( rule__PipelineStageCount__NameAssignment ) )
            {
            // InternalIntegrate.g:492:2: ( ( rule__PipelineStageCount__NameAssignment ) )
            // InternalIntegrate.g:493:3: ( rule__PipelineStageCount__NameAssignment )
            {
             before(grammarAccess.getPipelineStageCountAccess().getNameAssignment()); 
            // InternalIntegrate.g:494:3: ( rule__PipelineStageCount__NameAssignment )
            // InternalIntegrate.g:494:4: rule__PipelineStageCount__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageCount__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageCountAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageCount"


    // $ANTLR start "entryRulePipelineStageExists"
    // InternalIntegrate.g:503:1: entryRulePipelineStageExists : rulePipelineStageExists EOF ;
    public final void entryRulePipelineStageExists() throws RecognitionException {
        try {
            // InternalIntegrate.g:504:1: ( rulePipelineStageExists EOF )
            // InternalIntegrate.g:505:1: rulePipelineStageExists EOF
            {
             before(grammarAccess.getPipelineStageExistsRule()); 
            pushFollow(FOLLOW_1);
            rulePipelineStageExists();

            state._fsp--;

             after(grammarAccess.getPipelineStageExistsRule()); 
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
    // $ANTLR end "entryRulePipelineStageExists"


    // $ANTLR start "rulePipelineStageExists"
    // InternalIntegrate.g:512:1: rulePipelineStageExists : ( ( rule__PipelineStageExists__NameAssignment ) ) ;
    public final void rulePipelineStageExists() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:516:2: ( ( ( rule__PipelineStageExists__NameAssignment ) ) )
            // InternalIntegrate.g:517:2: ( ( rule__PipelineStageExists__NameAssignment ) )
            {
            // InternalIntegrate.g:517:2: ( ( rule__PipelineStageExists__NameAssignment ) )
            // InternalIntegrate.g:518:3: ( rule__PipelineStageExists__NameAssignment )
            {
             before(grammarAccess.getPipelineStageExistsAccess().getNameAssignment()); 
            // InternalIntegrate.g:519:3: ( rule__PipelineStageExists__NameAssignment )
            // InternalIntegrate.g:519:4: rule__PipelineStageExists__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageExists__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageExistsAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePipelineStageExists"


    // $ANTLR start "entryRuleSatisfactionRule"
    // InternalIntegrate.g:528:1: entryRuleSatisfactionRule : ruleSatisfactionRule EOF ;
    public final void entryRuleSatisfactionRule() throws RecognitionException {
        try {
            // InternalIntegrate.g:529:1: ( ruleSatisfactionRule EOF )
            // InternalIntegrate.g:530:1: ruleSatisfactionRule EOF
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
    // InternalIntegrate.g:537:1: ruleSatisfactionRule : ( ( rule__SatisfactionRule__ExpressionAssignment ) ) ;
    public final void ruleSatisfactionRule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:541:2: ( ( ( rule__SatisfactionRule__ExpressionAssignment ) ) )
            // InternalIntegrate.g:542:2: ( ( rule__SatisfactionRule__ExpressionAssignment ) )
            {
            // InternalIntegrate.g:542:2: ( ( rule__SatisfactionRule__ExpressionAssignment ) )
            // InternalIntegrate.g:543:3: ( rule__SatisfactionRule__ExpressionAssignment )
            {
             before(grammarAccess.getSatisfactionRuleAccess().getExpressionAssignment()); 
            // InternalIntegrate.g:544:3: ( rule__SatisfactionRule__ExpressionAssignment )
            // InternalIntegrate.g:544:4: rule__SatisfactionRule__ExpressionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__SatisfactionRule__ExpressionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getSatisfactionRuleAccess().getExpressionAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleOrExpression"
    // InternalIntegrate.g:553:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // InternalIntegrate.g:554:1: ( ruleOrExpression EOF )
            // InternalIntegrate.g:555:1: ruleOrExpression EOF
            {
             before(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionRule()); 
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
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalIntegrate.g:562:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:566:2: ( ( ( rule__OrExpression__Group__0 ) ) )
            // InternalIntegrate.g:567:2: ( ( rule__OrExpression__Group__0 ) )
            {
            // InternalIntegrate.g:567:2: ( ( rule__OrExpression__Group__0 ) )
            // InternalIntegrate.g:568:3: ( rule__OrExpression__Group__0 )
            {
             before(grammarAccess.getOrExpressionAccess().getGroup()); 
            // InternalIntegrate.g:569:3: ( rule__OrExpression__Group__0 )
            // InternalIntegrate.g:569:4: rule__OrExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalIntegrate.g:578:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // InternalIntegrate.g:579:1: ( ruleAndExpression EOF )
            // InternalIntegrate.g:580:1: ruleAndExpression EOF
            {
             before(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionRule()); 
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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalIntegrate.g:587:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:591:2: ( ( ( rule__AndExpression__Group__0 ) ) )
            // InternalIntegrate.g:592:2: ( ( rule__AndExpression__Group__0 ) )
            {
            // InternalIntegrate.g:592:2: ( ( rule__AndExpression__Group__0 ) )
            // InternalIntegrate.g:593:3: ( rule__AndExpression__Group__0 )
            {
             before(grammarAccess.getAndExpressionAccess().getGroup()); 
            // InternalIntegrate.g:594:3: ( rule__AndExpression__Group__0 )
            // InternalIntegrate.g:594:4: rule__AndExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalIntegrate.g:603:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // InternalIntegrate.g:604:1: ( ruleBooleanExpression EOF )
            // InternalIntegrate.g:605:1: ruleBooleanExpression EOF
            {
             before(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getBooleanExpressionRule()); 
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
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalIntegrate.g:612:1: ruleBooleanExpression : ( ( rule__BooleanExpression__Group__0 ) ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:616:2: ( ( ( rule__BooleanExpression__Group__0 ) ) )
            // InternalIntegrate.g:617:2: ( ( rule__BooleanExpression__Group__0 ) )
            {
            // InternalIntegrate.g:617:2: ( ( rule__BooleanExpression__Group__0 ) )
            // InternalIntegrate.g:618:3: ( rule__BooleanExpression__Group__0 )
            {
             before(grammarAccess.getBooleanExpressionAccess().getGroup()); 
            // InternalIntegrate.g:619:3: ( rule__BooleanExpression__Group__0 )
            // InternalIntegrate.g:619:4: rule__BooleanExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleWrappedOrExpression"
    // InternalIntegrate.g:628:1: entryRuleWrappedOrExpression : ruleWrappedOrExpression EOF ;
    public final void entryRuleWrappedOrExpression() throws RecognitionException {
        try {
            // InternalIntegrate.g:629:1: ( ruleWrappedOrExpression EOF )
            // InternalIntegrate.g:630:1: ruleWrappedOrExpression EOF
            {
             before(grammarAccess.getWrappedOrExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleWrappedOrExpression();

            state._fsp--;

             after(grammarAccess.getWrappedOrExpressionRule()); 
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
    // $ANTLR end "entryRuleWrappedOrExpression"


    // $ANTLR start "ruleWrappedOrExpression"
    // InternalIntegrate.g:637:1: ruleWrappedOrExpression : ( ( rule__WrappedOrExpression__Group__0 ) ) ;
    public final void ruleWrappedOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:641:2: ( ( ( rule__WrappedOrExpression__Group__0 ) ) )
            // InternalIntegrate.g:642:2: ( ( rule__WrappedOrExpression__Group__0 ) )
            {
            // InternalIntegrate.g:642:2: ( ( rule__WrappedOrExpression__Group__0 ) )
            // InternalIntegrate.g:643:3: ( rule__WrappedOrExpression__Group__0 )
            {
             before(grammarAccess.getWrappedOrExpressionAccess().getGroup()); 
            // InternalIntegrate.g:644:3: ( rule__WrappedOrExpression__Group__0 )
            // InternalIntegrate.g:644:4: rule__WrappedOrExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WrappedOrExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWrappedOrExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWrappedOrExpression"


    // $ANTLR start "entryRuleComparisonExpression"
    // InternalIntegrate.g:653:1: entryRuleComparisonExpression : ruleComparisonExpression EOF ;
    public final void entryRuleComparisonExpression() throws RecognitionException {
        try {
            // InternalIntegrate.g:654:1: ( ruleComparisonExpression EOF )
            // InternalIntegrate.g:655:1: ruleComparisonExpression EOF
            {
             before(grammarAccess.getComparisonExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleComparisonExpression();

            state._fsp--;

             after(grammarAccess.getComparisonExpressionRule()); 
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
    // $ANTLR end "entryRuleComparisonExpression"


    // $ANTLR start "ruleComparisonExpression"
    // InternalIntegrate.g:662:1: ruleComparisonExpression : ( ( rule__ComparisonExpression__Group__0 ) ) ;
    public final void ruleComparisonExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:666:2: ( ( ( rule__ComparisonExpression__Group__0 ) ) )
            // InternalIntegrate.g:667:2: ( ( rule__ComparisonExpression__Group__0 ) )
            {
            // InternalIntegrate.g:667:2: ( ( rule__ComparisonExpression__Group__0 ) )
            // InternalIntegrate.g:668:3: ( rule__ComparisonExpression__Group__0 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getGroup()); 
            // InternalIntegrate.g:669:3: ( rule__ComparisonExpression__Group__0 )
            // InternalIntegrate.g:669:4: rule__ComparisonExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonExpression"


    // $ANTLR start "entryRuleComparisonParameter"
    // InternalIntegrate.g:678:1: entryRuleComparisonParameter : ruleComparisonParameter EOF ;
    public final void entryRuleComparisonParameter() throws RecognitionException {
        try {
            // InternalIntegrate.g:679:1: ( ruleComparisonParameter EOF )
            // InternalIntegrate.g:680:1: ruleComparisonParameter EOF
            {
             before(grammarAccess.getComparisonParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleComparisonParameter();

            state._fsp--;

             after(grammarAccess.getComparisonParameterRule()); 
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
    // $ANTLR end "entryRuleComparisonParameter"


    // $ANTLR start "ruleComparisonParameter"
    // InternalIntegrate.g:687:1: ruleComparisonParameter : ( ( rule__ComparisonParameter__Alternatives ) ) ;
    public final void ruleComparisonParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:691:2: ( ( ( rule__ComparisonParameter__Alternatives ) ) )
            // InternalIntegrate.g:692:2: ( ( rule__ComparisonParameter__Alternatives ) )
            {
            // InternalIntegrate.g:692:2: ( ( rule__ComparisonParameter__Alternatives ) )
            // InternalIntegrate.g:693:3: ( rule__ComparisonParameter__Alternatives )
            {
             before(grammarAccess.getComparisonParameterAccess().getAlternatives()); 
            // InternalIntegrate.g:694:3: ( rule__ComparisonParameter__Alternatives )
            // InternalIntegrate.g:694:4: rule__ComparisonParameter__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonParameter__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getComparisonParameterAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonParameter"


    // $ANTLR start "entryRuleLiteralValue"
    // InternalIntegrate.g:703:1: entryRuleLiteralValue : ruleLiteralValue EOF ;
    public final void entryRuleLiteralValue() throws RecognitionException {
        try {
            // InternalIntegrate.g:704:1: ( ruleLiteralValue EOF )
            // InternalIntegrate.g:705:1: ruleLiteralValue EOF
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
    // InternalIntegrate.g:712:1: ruleLiteralValue : ( ( rule__LiteralValue__ValueAssignment ) ) ;
    public final void ruleLiteralValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:716:2: ( ( ( rule__LiteralValue__ValueAssignment ) ) )
            // InternalIntegrate.g:717:2: ( ( rule__LiteralValue__ValueAssignment ) )
            {
            // InternalIntegrate.g:717:2: ( ( rule__LiteralValue__ValueAssignment ) )
            // InternalIntegrate.g:718:3: ( rule__LiteralValue__ValueAssignment )
            {
             before(grammarAccess.getLiteralValueAccess().getValueAssignment()); 
            // InternalIntegrate.g:719:3: ( rule__LiteralValue__ValueAssignment )
            // InternalIntegrate.g:719:4: rule__LiteralValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__LiteralValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getLiteralValueAccess().getValueAssignment()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleResolution"
    // InternalIntegrate.g:728:1: entryRuleResolution : ruleResolution EOF ;
    public final void entryRuleResolution() throws RecognitionException {
        try {
            // InternalIntegrate.g:729:1: ( ruleResolution EOF )
            // InternalIntegrate.g:730:1: ruleResolution EOF
            {
             before(grammarAccess.getResolutionRule()); 
            pushFollow(FOLLOW_1);
            ruleResolution();

            state._fsp--;

             after(grammarAccess.getResolutionRule()); 
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
    // $ANTLR end "entryRuleResolution"


    // $ANTLR start "ruleResolution"
    // InternalIntegrate.g:737:1: ruleResolution : ( ( rule__Resolution__Group__0 ) ) ;
    public final void ruleResolution() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:741:2: ( ( ( rule__Resolution__Group__0 ) ) )
            // InternalIntegrate.g:742:2: ( ( rule__Resolution__Group__0 ) )
            {
            // InternalIntegrate.g:742:2: ( ( rule__Resolution__Group__0 ) )
            // InternalIntegrate.g:743:3: ( rule__Resolution__Group__0 )
            {
             before(grammarAccess.getResolutionAccess().getGroup()); 
            // InternalIntegrate.g:744:3: ( rule__Resolution__Group__0 )
            // InternalIntegrate.g:744:4: rule__Resolution__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Resolution__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResolutionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResolution"


    // $ANTLR start "entryRuleResolutionStrategyWithOperationalDelta"
    // InternalIntegrate.g:753:1: entryRuleResolutionStrategyWithOperationalDelta : ruleResolutionStrategyWithOperationalDelta EOF ;
    public final void entryRuleResolutionStrategyWithOperationalDelta() throws RecognitionException {
        try {
            // InternalIntegrate.g:754:1: ( ruleResolutionStrategyWithOperationalDelta EOF )
            // InternalIntegrate.g:755:1: ruleResolutionStrategyWithOperationalDelta EOF
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaRule()); 
            pushFollow(FOLLOW_1);
            ruleResolutionStrategyWithOperationalDelta();

            state._fsp--;

             after(grammarAccess.getResolutionStrategyWithOperationalDeltaRule()); 
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
    // $ANTLR end "entryRuleResolutionStrategyWithOperationalDelta"


    // $ANTLR start "ruleResolutionStrategyWithOperationalDelta"
    // InternalIntegrate.g:762:1: ruleResolutionStrategyWithOperationalDelta : ( ( rule__ResolutionStrategyWithOperationalDelta__Group__0 ) ) ;
    public final void ruleResolutionStrategyWithOperationalDelta() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:766:2: ( ( ( rule__ResolutionStrategyWithOperationalDelta__Group__0 ) ) )
            // InternalIntegrate.g:767:2: ( ( rule__ResolutionStrategyWithOperationalDelta__Group__0 ) )
            {
            // InternalIntegrate.g:767:2: ( ( rule__ResolutionStrategyWithOperationalDelta__Group__0 ) )
            // InternalIntegrate.g:768:3: ( rule__ResolutionStrategyWithOperationalDelta__Group__0 )
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getGroup()); 
            // InternalIntegrate.g:769:3: ( rule__ResolutionStrategyWithOperationalDelta__Group__0 )
            // InternalIntegrate.g:769:4: rule__ResolutionStrategyWithOperationalDelta__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResolutionStrategyWithOperationalDelta"


    // $ANTLR start "entryRuleResolutionStrategy"
    // InternalIntegrate.g:778:1: entryRuleResolutionStrategy : ruleResolutionStrategy EOF ;
    public final void entryRuleResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:779:1: ( ruleResolutionStrategy EOF )
            // InternalIntegrate.g:780:1: ruleResolutionStrategy EOF
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
    // InternalIntegrate.g:787:1: ruleResolutionStrategy : ( ( rule__ResolutionStrategy__Alternatives ) ) ;
    public final void ruleResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:791:2: ( ( ( rule__ResolutionStrategy__Alternatives ) ) )
            // InternalIntegrate.g:792:2: ( ( rule__ResolutionStrategy__Alternatives ) )
            {
            // InternalIntegrate.g:792:2: ( ( rule__ResolutionStrategy__Alternatives ) )
            // InternalIntegrate.g:793:3: ( rule__ResolutionStrategy__Alternatives )
            {
             before(grammarAccess.getResolutionStrategyAccess().getAlternatives()); 
            // InternalIntegrate.g:794:3: ( rule__ResolutionStrategy__Alternatives )
            // InternalIntegrate.g:794:4: rule__ResolutionStrategy__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategy__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getResolutionStrategyAccess().getAlternatives()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleFallbackResolutionStrategy"
    // InternalIntegrate.g:803:1: entryRuleFallbackResolutionStrategy : ruleFallbackResolutionStrategy EOF ;
    public final void entryRuleFallbackResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:804:1: ( ruleFallbackResolutionStrategy EOF )
            // InternalIntegrate.g:805:1: ruleFallbackResolutionStrategy EOF
            {
             before(grammarAccess.getFallbackResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleFallbackResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getFallbackResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleFallbackResolutionStrategy"


    // $ANTLR start "ruleFallbackResolutionStrategy"
    // InternalIntegrate.g:812:1: ruleFallbackResolutionStrategy : ( ( rule__FallbackResolutionStrategy__Alternatives ) ) ;
    public final void ruleFallbackResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:816:2: ( ( ( rule__FallbackResolutionStrategy__Alternatives ) ) )
            // InternalIntegrate.g:817:2: ( ( rule__FallbackResolutionStrategy__Alternatives ) )
            {
            // InternalIntegrate.g:817:2: ( ( rule__FallbackResolutionStrategy__Alternatives ) )
            // InternalIntegrate.g:818:3: ( rule__FallbackResolutionStrategy__Alternatives )
            {
             before(grammarAccess.getFallbackResolutionStrategyAccess().getAlternatives()); 
            // InternalIntegrate.g:819:3: ( rule__FallbackResolutionStrategy__Alternatives )
            // InternalIntegrate.g:819:4: rule__FallbackResolutionStrategy__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FallbackResolutionStrategy__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFallbackResolutionStrategyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFallbackResolutionStrategy"


    // $ANTLR start "entryRuleMergeAndPreserveResolutionStrategy"
    // InternalIntegrate.g:828:1: entryRuleMergeAndPreserveResolutionStrategy : ruleMergeAndPreserveResolutionStrategy EOF ;
    public final void entryRuleMergeAndPreserveResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:829:1: ( ruleMergeAndPreserveResolutionStrategy EOF )
            // InternalIntegrate.g:830:1: ruleMergeAndPreserveResolutionStrategy EOF
            {
             before(grammarAccess.getMergeAndPreserveResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleMergeAndPreserveResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getMergeAndPreserveResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleMergeAndPreserveResolutionStrategy"


    // $ANTLR start "ruleMergeAndPreserveResolutionStrategy"
    // InternalIntegrate.g:837:1: ruleMergeAndPreserveResolutionStrategy : ( ( rule__MergeAndPreserveResolutionStrategy__NameAssignment ) ) ;
    public final void ruleMergeAndPreserveResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:841:2: ( ( ( rule__MergeAndPreserveResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:842:2: ( ( rule__MergeAndPreserveResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:842:2: ( ( rule__MergeAndPreserveResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:843:3: ( rule__MergeAndPreserveResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:844:3: ( rule__MergeAndPreserveResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:844:4: rule__MergeAndPreserveResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__MergeAndPreserveResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMergeAndPreserveResolutionStrategy"


    // $ANTLR start "entryRuleRevokeAdditionResolutionStrategy"
    // InternalIntegrate.g:853:1: entryRuleRevokeAdditionResolutionStrategy : ruleRevokeAdditionResolutionStrategy EOF ;
    public final void entryRuleRevokeAdditionResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:854:1: ( ruleRevokeAdditionResolutionStrategy EOF )
            // InternalIntegrate.g:855:1: ruleRevokeAdditionResolutionStrategy EOF
            {
             before(grammarAccess.getRevokeAdditionResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleRevokeAdditionResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getRevokeAdditionResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleRevokeAdditionResolutionStrategy"


    // $ANTLR start "ruleRevokeAdditionResolutionStrategy"
    // InternalIntegrate.g:862:1: ruleRevokeAdditionResolutionStrategy : ( ( rule__RevokeAdditionResolutionStrategy__NameAssignment ) ) ;
    public final void ruleRevokeAdditionResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:866:2: ( ( ( rule__RevokeAdditionResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:867:2: ( ( rule__RevokeAdditionResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:867:2: ( ( rule__RevokeAdditionResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:868:3: ( rule__RevokeAdditionResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:869:3: ( rule__RevokeAdditionResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:869:4: rule__RevokeAdditionResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__RevokeAdditionResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRevokeAdditionResolutionStrategy"


    // $ANTLR start "entryRuleRevokeDeletionResolutionStrategy"
    // InternalIntegrate.g:878:1: entryRuleRevokeDeletionResolutionStrategy : ruleRevokeDeletionResolutionStrategy EOF ;
    public final void entryRuleRevokeDeletionResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:879:1: ( ruleRevokeDeletionResolutionStrategy EOF )
            // InternalIntegrate.g:880:1: ruleRevokeDeletionResolutionStrategy EOF
            {
             before(grammarAccess.getRevokeDeletionResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleRevokeDeletionResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getRevokeDeletionResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleRevokeDeletionResolutionStrategy"


    // $ANTLR start "ruleRevokeDeletionResolutionStrategy"
    // InternalIntegrate.g:887:1: ruleRevokeDeletionResolutionStrategy : ( ( rule__RevokeDeletionResolutionStrategy__NameAssignment ) ) ;
    public final void ruleRevokeDeletionResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:891:2: ( ( ( rule__RevokeDeletionResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:892:2: ( ( rule__RevokeDeletionResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:892:2: ( ( rule__RevokeDeletionResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:893:3: ( rule__RevokeDeletionResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:894:3: ( rule__RevokeDeletionResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:894:4: rule__RevokeDeletionResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__RevokeDeletionResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRevokeDeletionResolutionStrategy"


    // $ANTLR start "entryRulePreferSourceResolutionStrategy"
    // InternalIntegrate.g:903:1: entryRulePreferSourceResolutionStrategy : rulePreferSourceResolutionStrategy EOF ;
    public final void entryRulePreferSourceResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:904:1: ( rulePreferSourceResolutionStrategy EOF )
            // InternalIntegrate.g:905:1: rulePreferSourceResolutionStrategy EOF
            {
             before(grammarAccess.getPreferSourceResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            rulePreferSourceResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getPreferSourceResolutionStrategyRule()); 
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
    // $ANTLR end "entryRulePreferSourceResolutionStrategy"


    // $ANTLR start "rulePreferSourceResolutionStrategy"
    // InternalIntegrate.g:912:1: rulePreferSourceResolutionStrategy : ( ( rule__PreferSourceResolutionStrategy__NameAssignment ) ) ;
    public final void rulePreferSourceResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:916:2: ( ( ( rule__PreferSourceResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:917:2: ( ( rule__PreferSourceResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:917:2: ( ( rule__PreferSourceResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:918:3: ( rule__PreferSourceResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getPreferSourceResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:919:3: ( rule__PreferSourceResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:919:4: rule__PreferSourceResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PreferSourceResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPreferSourceResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePreferSourceResolutionStrategy"


    // $ANTLR start "entryRulePreferTargetResolutionStrategy"
    // InternalIntegrate.g:928:1: entryRulePreferTargetResolutionStrategy : rulePreferTargetResolutionStrategy EOF ;
    public final void entryRulePreferTargetResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:929:1: ( rulePreferTargetResolutionStrategy EOF )
            // InternalIntegrate.g:930:1: rulePreferTargetResolutionStrategy EOF
            {
             before(grammarAccess.getPreferTargetResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            rulePreferTargetResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getPreferTargetResolutionStrategyRule()); 
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
    // $ANTLR end "entryRulePreferTargetResolutionStrategy"


    // $ANTLR start "rulePreferTargetResolutionStrategy"
    // InternalIntegrate.g:937:1: rulePreferTargetResolutionStrategy : ( ( rule__PreferTargetResolutionStrategy__NameAssignment ) ) ;
    public final void rulePreferTargetResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:941:2: ( ( ( rule__PreferTargetResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:942:2: ( ( rule__PreferTargetResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:942:2: ( ( rule__PreferTargetResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:943:3: ( rule__PreferTargetResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getPreferTargetResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:944:3: ( rule__PreferTargetResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:944:4: rule__PreferTargetResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__PreferTargetResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getPreferTargetResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePreferTargetResolutionStrategy"


    // $ANTLR start "entryRuleDeleteCorrespondencesResolutionStrategy"
    // InternalIntegrate.g:953:1: entryRuleDeleteCorrespondencesResolutionStrategy : ruleDeleteCorrespondencesResolutionStrategy EOF ;
    public final void entryRuleDeleteCorrespondencesResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:954:1: ( ruleDeleteCorrespondencesResolutionStrategy EOF )
            // InternalIntegrate.g:955:1: ruleDeleteCorrespondencesResolutionStrategy EOF
            {
             before(grammarAccess.getDeleteCorrespondencesResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleDeleteCorrespondencesResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getDeleteCorrespondencesResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleDeleteCorrespondencesResolutionStrategy"


    // $ANTLR start "ruleDeleteCorrespondencesResolutionStrategy"
    // InternalIntegrate.g:962:1: ruleDeleteCorrespondencesResolutionStrategy : ( ( rule__DeleteCorrespondencesResolutionStrategy__NameAssignment ) ) ;
    public final void ruleDeleteCorrespondencesResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:966:2: ( ( ( rule__DeleteCorrespondencesResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:967:2: ( ( rule__DeleteCorrespondencesResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:967:2: ( ( rule__DeleteCorrespondencesResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:968:3: ( rule__DeleteCorrespondencesResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:969:3: ( rule__DeleteCorrespondencesResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:969:4: rule__DeleteCorrespondencesResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DeleteCorrespondencesResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeleteCorrespondencesResolutionStrategy"


    // $ANTLR start "entryRuleContinueResolutionStrategy"
    // InternalIntegrate.g:978:1: entryRuleContinueResolutionStrategy : ruleContinueResolutionStrategy EOF ;
    public final void entryRuleContinueResolutionStrategy() throws RecognitionException {
        try {
            // InternalIntegrate.g:979:1: ( ruleContinueResolutionStrategy EOF )
            // InternalIntegrate.g:980:1: ruleContinueResolutionStrategy EOF
            {
             before(grammarAccess.getContinueResolutionStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleContinueResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getContinueResolutionStrategyRule()); 
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
    // $ANTLR end "entryRuleContinueResolutionStrategy"


    // $ANTLR start "ruleContinueResolutionStrategy"
    // InternalIntegrate.g:987:1: ruleContinueResolutionStrategy : ( ( rule__ContinueResolutionStrategy__NameAssignment ) ) ;
    public final void ruleContinueResolutionStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:991:2: ( ( ( rule__ContinueResolutionStrategy__NameAssignment ) ) )
            // InternalIntegrate.g:992:2: ( ( rule__ContinueResolutionStrategy__NameAssignment ) )
            {
            // InternalIntegrate.g:992:2: ( ( rule__ContinueResolutionStrategy__NameAssignment ) )
            // InternalIntegrate.g:993:3: ( rule__ContinueResolutionStrategy__NameAssignment )
            {
             before(grammarAccess.getContinueResolutionStrategyAccess().getNameAssignment()); 
            // InternalIntegrate.g:994:3: ( rule__ContinueResolutionStrategy__NameAssignment )
            // InternalIntegrate.g:994:4: rule__ContinueResolutionStrategy__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ContinueResolutionStrategy__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getContinueResolutionStrategyAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContinueResolutionStrategy"


    // $ANTLR start "entryRuleOperationalDelta"
    // InternalIntegrate.g:1003:1: entryRuleOperationalDelta : ruleOperationalDelta EOF ;
    public final void entryRuleOperationalDelta() throws RecognitionException {
        try {
            // InternalIntegrate.g:1004:1: ( ruleOperationalDelta EOF )
            // InternalIntegrate.g:1005:1: ruleOperationalDelta EOF
            {
             before(grammarAccess.getOperationalDeltaRule()); 
            pushFollow(FOLLOW_1);
            ruleOperationalDelta();

            state._fsp--;

             after(grammarAccess.getOperationalDeltaRule()); 
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
    // $ANTLR end "entryRuleOperationalDelta"


    // $ANTLR start "ruleOperationalDelta"
    // InternalIntegrate.g:1012:1: ruleOperationalDelta : ( ( rule__OperationalDelta__Group__0 ) ) ;
    public final void ruleOperationalDelta() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1016:2: ( ( ( rule__OperationalDelta__Group__0 ) ) )
            // InternalIntegrate.g:1017:2: ( ( rule__OperationalDelta__Group__0 ) )
            {
            // InternalIntegrate.g:1017:2: ( ( rule__OperationalDelta__Group__0 ) )
            // InternalIntegrate.g:1018:3: ( rule__OperationalDelta__Group__0 )
            {
             before(grammarAccess.getOperationalDeltaAccess().getGroup()); 
            // InternalIntegrate.g:1019:3: ( rule__OperationalDelta__Group__0 )
            // InternalIntegrate.g:1019:4: rule__OperationalDelta__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OperationalDelta__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperationalDeltaAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperationalDelta"


    // $ANTLR start "rule__PipelineStageStart__Alternatives"
    // InternalIntegrate.g:1027:1: rule__PipelineStageStart__Alternatives : ( ( rulePipelineStageSrc ) | ( rulePipelineStageTrg ) );
    public final void rule__PipelineStageStart__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1031:1: ( ( rulePipelineStageSrc ) | ( rulePipelineStageTrg ) )
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
                    // InternalIntegrate.g:1032:2: ( rulePipelineStageSrc )
                    {
                    // InternalIntegrate.g:1032:2: ( rulePipelineStageSrc )
                    // InternalIntegrate.g:1033:3: rulePipelineStageSrc
                    {
                     before(grammarAccess.getPipelineStageStartAccess().getPipelineStageSrcParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageSrc();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageStartAccess().getPipelineStageSrcParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1038:2: ( rulePipelineStageTrg )
                    {
                    // InternalIntegrate.g:1038:2: ( rulePipelineStageTrg )
                    // InternalIntegrate.g:1039:3: rulePipelineStageTrg
                    {
                     before(grammarAccess.getPipelineStageStartAccess().getPipelineStageTrgParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageTrg();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageStartAccess().getPipelineStageTrgParserRuleCall_1()); 

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
    // $ANTLR end "rule__PipelineStageStart__Alternatives"


    // $ANTLR start "rule__PipelineStageSrc__NextAlternatives_2_0"
    // InternalIntegrate.g:1048:1: rule__PipelineStageSrc__NextAlternatives_2_0 : ( ( rulePipelineStageFilter ) | ( rulePipelineStageEnd ) );
    public final void rule__PipelineStageSrc__NextAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1052:1: ( ( rulePipelineStageFilter ) | ( rulePipelineStageEnd ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=37 && LA2_0<=39)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=40 && LA2_0<=41)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalIntegrate.g:1053:2: ( rulePipelineStageFilter )
                    {
                    // InternalIntegrate.g:1053:2: ( rulePipelineStageFilter )
                    // InternalIntegrate.g:1054:3: rulePipelineStageFilter
                    {
                     before(grammarAccess.getPipelineStageSrcAccess().getNextPipelineStageFilterParserRuleCall_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageFilter();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageSrcAccess().getNextPipelineStageFilterParserRuleCall_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1059:2: ( rulePipelineStageEnd )
                    {
                    // InternalIntegrate.g:1059:2: ( rulePipelineStageEnd )
                    // InternalIntegrate.g:1060:3: rulePipelineStageEnd
                    {
                     before(grammarAccess.getPipelineStageSrcAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageEnd();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageSrcAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 

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
    // $ANTLR end "rule__PipelineStageSrc__NextAlternatives_2_0"


    // $ANTLR start "rule__PipelineStageTrg__NextAlternatives_2_0"
    // InternalIntegrate.g:1069:1: rule__PipelineStageTrg__NextAlternatives_2_0 : ( ( rulePipelineStageFilter ) | ( rulePipelineStageEnd ) );
    public final void rule__PipelineStageTrg__NextAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1073:1: ( ( rulePipelineStageFilter ) | ( rulePipelineStageEnd ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=37 && LA3_0<=39)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=40 && LA3_0<=41)) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalIntegrate.g:1074:2: ( rulePipelineStageFilter )
                    {
                    // InternalIntegrate.g:1074:2: ( rulePipelineStageFilter )
                    // InternalIntegrate.g:1075:3: rulePipelineStageFilter
                    {
                     before(grammarAccess.getPipelineStageTrgAccess().getNextPipelineStageFilterParserRuleCall_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageFilter();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageTrgAccess().getNextPipelineStageFilterParserRuleCall_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1080:2: ( rulePipelineStageEnd )
                    {
                    // InternalIntegrate.g:1080:2: ( rulePipelineStageEnd )
                    // InternalIntegrate.g:1081:3: rulePipelineStageEnd
                    {
                     before(grammarAccess.getPipelineStageTrgAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageEnd();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageTrgAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 

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
    // $ANTLR end "rule__PipelineStageTrg__NextAlternatives_2_0"


    // $ANTLR start "rule__PipelineStageFilter__Alternatives"
    // InternalIntegrate.g:1090:1: rule__PipelineStageFilter__Alternatives : ( ( rulePipelineStageModification ) | ( rulePipelineStageType ) );
    public final void rule__PipelineStageFilter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1094:1: ( ( rulePipelineStageModification ) | ( rulePipelineStageType ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=37 && LA4_0<=38)) ) {
                alt4=1;
            }
            else if ( (LA4_0==39) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalIntegrate.g:1095:2: ( rulePipelineStageModification )
                    {
                    // InternalIntegrate.g:1095:2: ( rulePipelineStageModification )
                    // InternalIntegrate.g:1096:3: rulePipelineStageModification
                    {
                     before(grammarAccess.getPipelineStageFilterAccess().getPipelineStageModificationParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageModification();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageFilterAccess().getPipelineStageModificationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1101:2: ( rulePipelineStageType )
                    {
                    // InternalIntegrate.g:1101:2: ( rulePipelineStageType )
                    // InternalIntegrate.g:1102:3: rulePipelineStageType
                    {
                     before(grammarAccess.getPipelineStageFilterAccess().getPipelineStageTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageType();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageFilterAccess().getPipelineStageTypeParserRuleCall_1()); 

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
    // $ANTLR end "rule__PipelineStageFilter__Alternatives"


    // $ANTLR start "rule__PipelineStageModification__Alternatives"
    // InternalIntegrate.g:1111:1: rule__PipelineStageModification__Alternatives : ( ( rulePipelineStageCreated ) | ( rulePipelineStageDeleted ) );
    public final void rule__PipelineStageModification__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1115:1: ( ( rulePipelineStageCreated ) | ( rulePipelineStageDeleted ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==37) ) {
                alt5=1;
            }
            else if ( (LA5_0==38) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalIntegrate.g:1116:2: ( rulePipelineStageCreated )
                    {
                    // InternalIntegrate.g:1116:2: ( rulePipelineStageCreated )
                    // InternalIntegrate.g:1117:3: rulePipelineStageCreated
                    {
                     before(grammarAccess.getPipelineStageModificationAccess().getPipelineStageCreatedParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageCreated();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageModificationAccess().getPipelineStageCreatedParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1122:2: ( rulePipelineStageDeleted )
                    {
                    // InternalIntegrate.g:1122:2: ( rulePipelineStageDeleted )
                    // InternalIntegrate.g:1123:3: rulePipelineStageDeleted
                    {
                     before(grammarAccess.getPipelineStageModificationAccess().getPipelineStageDeletedParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageDeleted();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageModificationAccess().getPipelineStageDeletedParserRuleCall_1()); 

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
    // $ANTLR end "rule__PipelineStageModification__Alternatives"


    // $ANTLR start "rule__PipelineStageCreated__NextAlternatives_2_0"
    // InternalIntegrate.g:1132:1: rule__PipelineStageCreated__NextAlternatives_2_0 : ( ( rulePipelineStageType ) | ( rulePipelineStageEnd ) );
    public final void rule__PipelineStageCreated__NextAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1136:1: ( ( rulePipelineStageType ) | ( rulePipelineStageEnd ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==39) ) {
                alt6=1;
            }
            else if ( ((LA6_0>=40 && LA6_0<=41)) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalIntegrate.g:1137:2: ( rulePipelineStageType )
                    {
                    // InternalIntegrate.g:1137:2: ( rulePipelineStageType )
                    // InternalIntegrate.g:1138:3: rulePipelineStageType
                    {
                     before(grammarAccess.getPipelineStageCreatedAccess().getNextPipelineStageTypeParserRuleCall_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageType();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageCreatedAccess().getNextPipelineStageTypeParserRuleCall_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1143:2: ( rulePipelineStageEnd )
                    {
                    // InternalIntegrate.g:1143:2: ( rulePipelineStageEnd )
                    // InternalIntegrate.g:1144:3: rulePipelineStageEnd
                    {
                     before(grammarAccess.getPipelineStageCreatedAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageEnd();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageCreatedAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 

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
    // $ANTLR end "rule__PipelineStageCreated__NextAlternatives_2_0"


    // $ANTLR start "rule__PipelineStageDeleted__NextAlternatives_2_0"
    // InternalIntegrate.g:1153:1: rule__PipelineStageDeleted__NextAlternatives_2_0 : ( ( rulePipelineStageType ) | ( rulePipelineStageEnd ) );
    public final void rule__PipelineStageDeleted__NextAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1157:1: ( ( rulePipelineStageType ) | ( rulePipelineStageEnd ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==39) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=40 && LA7_0<=41)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalIntegrate.g:1158:2: ( rulePipelineStageType )
                    {
                    // InternalIntegrate.g:1158:2: ( rulePipelineStageType )
                    // InternalIntegrate.g:1159:3: rulePipelineStageType
                    {
                     before(grammarAccess.getPipelineStageDeletedAccess().getNextPipelineStageTypeParserRuleCall_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageType();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageDeletedAccess().getNextPipelineStageTypeParserRuleCall_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1164:2: ( rulePipelineStageEnd )
                    {
                    // InternalIntegrate.g:1164:2: ( rulePipelineStageEnd )
                    // InternalIntegrate.g:1165:3: rulePipelineStageEnd
                    {
                     before(grammarAccess.getPipelineStageDeletedAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageEnd();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageDeletedAccess().getNextPipelineStageEndParserRuleCall_2_0_1()); 

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
    // $ANTLR end "rule__PipelineStageDeleted__NextAlternatives_2_0"


    // $ANTLR start "rule__PipelineStageEnd__Alternatives"
    // InternalIntegrate.g:1174:1: rule__PipelineStageEnd__Alternatives : ( ( rulePipelineStageCount ) | ( rulePipelineStageExists ) );
    public final void rule__PipelineStageEnd__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1178:1: ( ( rulePipelineStageCount ) | ( rulePipelineStageExists ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==40) ) {
                alt8=1;
            }
            else if ( (LA8_0==41) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalIntegrate.g:1179:2: ( rulePipelineStageCount )
                    {
                    // InternalIntegrate.g:1179:2: ( rulePipelineStageCount )
                    // InternalIntegrate.g:1180:3: rulePipelineStageCount
                    {
                     before(grammarAccess.getPipelineStageEndAccess().getPipelineStageCountParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageCount();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageEndAccess().getPipelineStageCountParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1185:2: ( rulePipelineStageExists )
                    {
                    // InternalIntegrate.g:1185:2: ( rulePipelineStageExists )
                    // InternalIntegrate.g:1186:3: rulePipelineStageExists
                    {
                     before(grammarAccess.getPipelineStageEndAccess().getPipelineStageExistsParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePipelineStageExists();

                    state._fsp--;

                     after(grammarAccess.getPipelineStageEndAccess().getPipelineStageExistsParserRuleCall_1()); 

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
    // $ANTLR end "rule__PipelineStageEnd__Alternatives"


    // $ANTLR start "rule__BooleanExpression__ExpressionAlternatives_1_0"
    // InternalIntegrate.g:1195:1: rule__BooleanExpression__ExpressionAlternatives_1_0 : ( ( ruleComparisonExpression ) | ( ruleVariableReference ) | ( ruleWrappedOrExpression ) );
    public final void rule__BooleanExpression__ExpressionAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1199:1: ( ( ruleComparisonExpression ) | ( ruleVariableReference ) | ( ruleWrappedOrExpression ) )
            int alt9=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==EOF||LA9_1==24||(LA9_1>=30 && LA9_1<=31)||LA9_1==33) ) {
                    alt9=2;
                }
                else if ( ((LA9_1>=11 && LA9_1<=16)) ) {
                    alt9=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                alt9=1;
                }
                break;
            case 32:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalIntegrate.g:1200:2: ( ruleComparisonExpression )
                    {
                    // InternalIntegrate.g:1200:2: ( ruleComparisonExpression )
                    // InternalIntegrate.g:1201:3: ruleComparisonExpression
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getExpressionComparisonExpressionParserRuleCall_1_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleComparisonExpression();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getExpressionComparisonExpressionParserRuleCall_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1206:2: ( ruleVariableReference )
                    {
                    // InternalIntegrate.g:1206:2: ( ruleVariableReference )
                    // InternalIntegrate.g:1207:3: ruleVariableReference
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getExpressionVariableReferenceParserRuleCall_1_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVariableReference();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getExpressionVariableReferenceParserRuleCall_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1212:2: ( ruleWrappedOrExpression )
                    {
                    // InternalIntegrate.g:1212:2: ( ruleWrappedOrExpression )
                    // InternalIntegrate.g:1213:3: ruleWrappedOrExpression
                    {
                     before(grammarAccess.getBooleanExpressionAccess().getExpressionWrappedOrExpressionParserRuleCall_1_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleWrappedOrExpression();

                    state._fsp--;

                     after(grammarAccess.getBooleanExpressionAccess().getExpressionWrappedOrExpressionParserRuleCall_1_0_2()); 

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
    // $ANTLR end "rule__BooleanExpression__ExpressionAlternatives_1_0"


    // $ANTLR start "rule__ComparisonExpression__OpAlternatives_1_0"
    // InternalIntegrate.g:1222:1: rule__ComparisonExpression__OpAlternatives_1_0 : ( ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) );
    public final void rule__ComparisonExpression__OpAlternatives_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1226:1: ( ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) | ( '==' ) | ( '!=' ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt10=1;
                }
                break;
            case 12:
                {
                alt10=2;
                }
                break;
            case 13:
                {
                alt10=3;
                }
                break;
            case 14:
                {
                alt10=4;
                }
                break;
            case 15:
                {
                alt10=5;
                }
                break;
            case 16:
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalIntegrate.g:1227:2: ( '>' )
                    {
                    // InternalIntegrate.g:1227:2: ( '>' )
                    // InternalIntegrate.g:1228:3: '>'
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignKeyword_1_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignKeyword_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1233:2: ( '>=' )
                    {
                    // InternalIntegrate.g:1233:2: ( '>=' )
                    // InternalIntegrate.g:1234:3: '>='
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1239:2: ( '<' )
                    {
                    // InternalIntegrate.g:1239:2: ( '<' )
                    // InternalIntegrate.g:1240:3: '<'
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getOpLessThanSignKeyword_1_0_2()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getComparisonExpressionAccess().getOpLessThanSignKeyword_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:1245:2: ( '<=' )
                    {
                    // InternalIntegrate.g:1245:2: ( '<=' )
                    // InternalIntegrate.g:1246:3: '<='
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_3()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getComparisonExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalIntegrate.g:1251:2: ( '==' )
                    {
                    // InternalIntegrate.g:1251:2: ( '==' )
                    // InternalIntegrate.g:1252:3: '=='
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_4()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getComparisonExpressionAccess().getOpEqualsSignEqualsSignKeyword_1_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalIntegrate.g:1257:2: ( '!=' )
                    {
                    // InternalIntegrate.g:1257:2: ( '!=' )
                    // InternalIntegrate.g:1258:3: '!='
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_5()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getComparisonExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_5()); 

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
    // $ANTLR end "rule__ComparisonExpression__OpAlternatives_1_0"


    // $ANTLR start "rule__ComparisonParameter__Alternatives"
    // InternalIntegrate.g:1267:1: rule__ComparisonParameter__Alternatives : ( ( ruleVariableReference ) | ( ruleLiteralValue ) );
    public final void rule__ComparisonParameter__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1271:1: ( ( ruleVariableReference ) | ( ruleLiteralValue ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_INT) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalIntegrate.g:1272:2: ( ruleVariableReference )
                    {
                    // InternalIntegrate.g:1272:2: ( ruleVariableReference )
                    // InternalIntegrate.g:1273:3: ruleVariableReference
                    {
                     before(grammarAccess.getComparisonParameterAccess().getVariableReferenceParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleVariableReference();

                    state._fsp--;

                     after(grammarAccess.getComparisonParameterAccess().getVariableReferenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1278:2: ( ruleLiteralValue )
                    {
                    // InternalIntegrate.g:1278:2: ( ruleLiteralValue )
                    // InternalIntegrate.g:1279:3: ruleLiteralValue
                    {
                     before(grammarAccess.getComparisonParameterAccess().getLiteralValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteralValue();

                    state._fsp--;

                     after(grammarAccess.getComparisonParameterAccess().getLiteralValueParserRuleCall_1()); 

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
    // $ANTLR end "rule__ComparisonParameter__Alternatives"


    // $ANTLR start "rule__ResolutionStrategy__Alternatives"
    // InternalIntegrate.g:1288:1: rule__ResolutionStrategy__Alternatives : ( ( ruleMergeAndPreserveResolutionStrategy ) | ( ruleRevokeAdditionResolutionStrategy ) | ( ruleRevokeDeletionResolutionStrategy ) | ( ruleFallbackResolutionStrategy ) );
    public final void rule__ResolutionStrategy__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1292:1: ( ( ruleMergeAndPreserveResolutionStrategy ) | ( ruleRevokeAdditionResolutionStrategy ) | ( ruleRevokeDeletionResolutionStrategy ) | ( ruleFallbackResolutionStrategy ) )
            int alt12=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt12=1;
                }
                break;
            case 44:
                {
                alt12=2;
                }
                break;
            case 45:
                {
                alt12=3;
                }
                break;
            case 46:
            case 47:
            case 48:
            case 49:
                {
                alt12=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalIntegrate.g:1293:2: ( ruleMergeAndPreserveResolutionStrategy )
                    {
                    // InternalIntegrate.g:1293:2: ( ruleMergeAndPreserveResolutionStrategy )
                    // InternalIntegrate.g:1294:3: ruleMergeAndPreserveResolutionStrategy
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getMergeAndPreserveResolutionStrategyParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMergeAndPreserveResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getResolutionStrategyAccess().getMergeAndPreserveResolutionStrategyParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1299:2: ( ruleRevokeAdditionResolutionStrategy )
                    {
                    // InternalIntegrate.g:1299:2: ( ruleRevokeAdditionResolutionStrategy )
                    // InternalIntegrate.g:1300:3: ruleRevokeAdditionResolutionStrategy
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getRevokeAdditionResolutionStrategyParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleRevokeAdditionResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getResolutionStrategyAccess().getRevokeAdditionResolutionStrategyParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1305:2: ( ruleRevokeDeletionResolutionStrategy )
                    {
                    // InternalIntegrate.g:1305:2: ( ruleRevokeDeletionResolutionStrategy )
                    // InternalIntegrate.g:1306:3: ruleRevokeDeletionResolutionStrategy
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getRevokeDeletionResolutionStrategyParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleRevokeDeletionResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getResolutionStrategyAccess().getRevokeDeletionResolutionStrategyParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:1311:2: ( ruleFallbackResolutionStrategy )
                    {
                    // InternalIntegrate.g:1311:2: ( ruleFallbackResolutionStrategy )
                    // InternalIntegrate.g:1312:3: ruleFallbackResolutionStrategy
                    {
                     before(grammarAccess.getResolutionStrategyAccess().getFallbackResolutionStrategyParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleFallbackResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getResolutionStrategyAccess().getFallbackResolutionStrategyParserRuleCall_3()); 

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
    // $ANTLR end "rule__ResolutionStrategy__Alternatives"


    // $ANTLR start "rule__FallbackResolutionStrategy__Alternatives"
    // InternalIntegrate.g:1321:1: rule__FallbackResolutionStrategy__Alternatives : ( ( rulePreferSourceResolutionStrategy ) | ( rulePreferTargetResolutionStrategy ) | ( ruleDeleteCorrespondencesResolutionStrategy ) | ( ruleContinueResolutionStrategy ) );
    public final void rule__FallbackResolutionStrategy__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1325:1: ( ( rulePreferSourceResolutionStrategy ) | ( rulePreferTargetResolutionStrategy ) | ( ruleDeleteCorrespondencesResolutionStrategy ) | ( ruleContinueResolutionStrategy ) )
            int alt13=4;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt13=1;
                }
                break;
            case 47:
                {
                alt13=2;
                }
                break;
            case 48:
                {
                alt13=3;
                }
                break;
            case 49:
                {
                alt13=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalIntegrate.g:1326:2: ( rulePreferSourceResolutionStrategy )
                    {
                    // InternalIntegrate.g:1326:2: ( rulePreferSourceResolutionStrategy )
                    // InternalIntegrate.g:1327:3: rulePreferSourceResolutionStrategy
                    {
                     before(grammarAccess.getFallbackResolutionStrategyAccess().getPreferSourceResolutionStrategyParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePreferSourceResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getFallbackResolutionStrategyAccess().getPreferSourceResolutionStrategyParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalIntegrate.g:1332:2: ( rulePreferTargetResolutionStrategy )
                    {
                    // InternalIntegrate.g:1332:2: ( rulePreferTargetResolutionStrategy )
                    // InternalIntegrate.g:1333:3: rulePreferTargetResolutionStrategy
                    {
                     before(grammarAccess.getFallbackResolutionStrategyAccess().getPreferTargetResolutionStrategyParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    rulePreferTargetResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getFallbackResolutionStrategyAccess().getPreferTargetResolutionStrategyParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalIntegrate.g:1338:2: ( ruleDeleteCorrespondencesResolutionStrategy )
                    {
                    // InternalIntegrate.g:1338:2: ( ruleDeleteCorrespondencesResolutionStrategy )
                    // InternalIntegrate.g:1339:3: ruleDeleteCorrespondencesResolutionStrategy
                    {
                     before(grammarAccess.getFallbackResolutionStrategyAccess().getDeleteCorrespondencesResolutionStrategyParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleDeleteCorrespondencesResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getFallbackResolutionStrategyAccess().getDeleteCorrespondencesResolutionStrategyParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalIntegrate.g:1344:2: ( ruleContinueResolutionStrategy )
                    {
                    // InternalIntegrate.g:1344:2: ( ruleContinueResolutionStrategy )
                    // InternalIntegrate.g:1345:3: ruleContinueResolutionStrategy
                    {
                     before(grammarAccess.getFallbackResolutionStrategyAccess().getContinueResolutionStrategyParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleContinueResolutionStrategy();

                    state._fsp--;

                     after(grammarAccess.getFallbackResolutionStrategyAccess().getContinueResolutionStrategyParserRuleCall_3()); 

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
    // $ANTLR end "rule__FallbackResolutionStrategy__Alternatives"


    // $ANTLR start "rule__Integrate__Group__0"
    // InternalIntegrate.g:1354:1: rule__Integrate__Group__0 : rule__Integrate__Group__0__Impl rule__Integrate__Group__1 ;
    public final void rule__Integrate__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1358:1: ( rule__Integrate__Group__0__Impl rule__Integrate__Group__1 )
            // InternalIntegrate.g:1359:2: rule__Integrate__Group__0__Impl rule__Integrate__Group__1
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
    // InternalIntegrate.g:1366:1: rule__Integrate__Group__0__Impl : ( ( rule__Integrate__PackageAssignment_0 )? ) ;
    public final void rule__Integrate__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1370:1: ( ( ( rule__Integrate__PackageAssignment_0 )? ) )
            // InternalIntegrate.g:1371:1: ( ( rule__Integrate__PackageAssignment_0 )? )
            {
            // InternalIntegrate.g:1371:1: ( ( rule__Integrate__PackageAssignment_0 )? )
            // InternalIntegrate.g:1372:2: ( rule__Integrate__PackageAssignment_0 )?
            {
             before(grammarAccess.getIntegrateAccess().getPackageAssignment_0()); 
            // InternalIntegrate.g:1373:2: ( rule__Integrate__PackageAssignment_0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==17) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalIntegrate.g:1373:3: rule__Integrate__PackageAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Integrate__PackageAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIntegrateAccess().getPackageAssignment_0()); 

            }


            }

        }
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
    // InternalIntegrate.g:1381:1: rule__Integrate__Group__1 : rule__Integrate__Group__1__Impl rule__Integrate__Group__2 ;
    public final void rule__Integrate__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1385:1: ( rule__Integrate__Group__1__Impl rule__Integrate__Group__2 )
            // InternalIntegrate.g:1386:2: rule__Integrate__Group__1__Impl rule__Integrate__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Integrate__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Integrate__Group__2();

            state._fsp--;


            }

        }
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
    // InternalIntegrate.g:1393:1: rule__Integrate__Group__1__Impl : ( ( rule__Integrate__ImportsAssignment_1 ) ) ;
    public final void rule__Integrate__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1397:1: ( ( ( rule__Integrate__ImportsAssignment_1 ) ) )
            // InternalIntegrate.g:1398:1: ( ( rule__Integrate__ImportsAssignment_1 ) )
            {
            // InternalIntegrate.g:1398:1: ( ( rule__Integrate__ImportsAssignment_1 ) )
            // InternalIntegrate.g:1399:2: ( rule__Integrate__ImportsAssignment_1 )
            {
             before(grammarAccess.getIntegrateAccess().getImportsAssignment_1()); 
            // InternalIntegrate.g:1400:2: ( rule__Integrate__ImportsAssignment_1 )
            // InternalIntegrate.g:1400:3: rule__Integrate__ImportsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Integrate__ImportsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntegrateAccess().getImportsAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Integrate__Group__2"
    // InternalIntegrate.g:1408:1: rule__Integrate__Group__2 : rule__Integrate__Group__2__Impl ;
    public final void rule__Integrate__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1412:1: ( rule__Integrate__Group__2__Impl )
            // InternalIntegrate.g:1413:2: rule__Integrate__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Integrate__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__Group__2"


    // $ANTLR start "rule__Integrate__Group__2__Impl"
    // InternalIntegrate.g:1419:1: rule__Integrate__Group__2__Impl : ( ( rule__Integrate__ConflictResolutionSpecificationsAssignment_2 )* ) ;
    public final void rule__Integrate__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1423:1: ( ( ( rule__Integrate__ConflictResolutionSpecificationsAssignment_2 )* ) )
            // InternalIntegrate.g:1424:1: ( ( rule__Integrate__ConflictResolutionSpecificationsAssignment_2 )* )
            {
            // InternalIntegrate.g:1424:1: ( ( rule__Integrate__ConflictResolutionSpecificationsAssignment_2 )* )
            // InternalIntegrate.g:1425:2: ( rule__Integrate__ConflictResolutionSpecificationsAssignment_2 )*
            {
             before(grammarAccess.getIntegrateAccess().getConflictResolutionSpecificationsAssignment_2()); 
            // InternalIntegrate.g:1426:2: ( rule__Integrate__ConflictResolutionSpecificationsAssignment_2 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalIntegrate.g:1426:3: rule__Integrate__ConflictResolutionSpecificationsAssignment_2
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Integrate__ConflictResolutionSpecificationsAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getIntegrateAccess().getConflictResolutionSpecificationsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__Group__2__Impl"


    // $ANTLR start "rule__Package__Group__0"
    // InternalIntegrate.g:1435:1: rule__Package__Group__0 : rule__Package__Group__0__Impl rule__Package__Group__1 ;
    public final void rule__Package__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1439:1: ( rule__Package__Group__0__Impl rule__Package__Group__1 )
            // InternalIntegrate.g:1440:2: rule__Package__Group__0__Impl rule__Package__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Package__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Package__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Package__Group__0"


    // $ANTLR start "rule__Package__Group__0__Impl"
    // InternalIntegrate.g:1447:1: rule__Package__Group__0__Impl : ( 'package' ) ;
    public final void rule__Package__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1451:1: ( ( 'package' ) )
            // InternalIntegrate.g:1452:1: ( 'package' )
            {
            // InternalIntegrate.g:1452:1: ( 'package' )
            // InternalIntegrate.g:1453:2: 'package'
            {
             before(grammarAccess.getPackageAccess().getPackageKeyword_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getPackageAccess().getPackageKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Package__Group__0__Impl"


    // $ANTLR start "rule__Package__Group__1"
    // InternalIntegrate.g:1462:1: rule__Package__Group__1 : rule__Package__Group__1__Impl ;
    public final void rule__Package__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1466:1: ( rule__Package__Group__1__Impl )
            // InternalIntegrate.g:1467:2: rule__Package__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Package__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Package__Group__1"


    // $ANTLR start "rule__Package__Group__1__Impl"
    // InternalIntegrate.g:1473:1: rule__Package__Group__1__Impl : ( ( rule__Package__NameAssignment_1 ) ) ;
    public final void rule__Package__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1477:1: ( ( ( rule__Package__NameAssignment_1 ) ) )
            // InternalIntegrate.g:1478:1: ( ( rule__Package__NameAssignment_1 ) )
            {
            // InternalIntegrate.g:1478:1: ( ( rule__Package__NameAssignment_1 ) )
            // InternalIntegrate.g:1479:2: ( rule__Package__NameAssignment_1 )
            {
             before(grammarAccess.getPackageAccess().getNameAssignment_1()); 
            // InternalIntegrate.g:1480:2: ( rule__Package__NameAssignment_1 )
            // InternalIntegrate.g:1480:3: rule__Package__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Package__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Package__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // InternalIntegrate.g:1489:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1493:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // InternalIntegrate.g:1494:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalIntegrate.g:1501:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1505:1: ( ( RULE_ID ) )
            // InternalIntegrate.g:1506:1: ( RULE_ID )
            {
            // InternalIntegrate.g:1506:1: ( RULE_ID )
            // InternalIntegrate.g:1507:2: RULE_ID
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
    // InternalIntegrate.g:1516:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1520:1: ( rule__QualifiedName__Group__1__Impl )
            // InternalIntegrate.g:1521:2: rule__QualifiedName__Group__1__Impl
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
    // InternalIntegrate.g:1527:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1531:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // InternalIntegrate.g:1532:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // InternalIntegrate.g:1532:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // InternalIntegrate.g:1533:2: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // InternalIntegrate.g:1534:2: ( rule__QualifiedName__Group_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==18) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalIntegrate.g:1534:3: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_7);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalIntegrate.g:1543:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1547:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // InternalIntegrate.g:1548:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalIntegrate.g:1555:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1559:1: ( ( '.' ) )
            // InternalIntegrate.g:1560:1: ( '.' )
            {
            // InternalIntegrate.g:1560:1: ( '.' )
            // InternalIntegrate.g:1561:2: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalIntegrate.g:1570:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1574:1: ( rule__QualifiedName__Group_1__1__Impl )
            // InternalIntegrate.g:1575:2: rule__QualifiedName__Group_1__1__Impl
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
    // InternalIntegrate.g:1581:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1585:1: ( ( RULE_ID ) )
            // InternalIntegrate.g:1586:1: ( RULE_ID )
            {
            // InternalIntegrate.g:1586:1: ( RULE_ID )
            // InternalIntegrate.g:1587:2: RULE_ID
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


    // $ANTLR start "rule__Import__Group__0"
    // InternalIntegrate.g:1597:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1601:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalIntegrate.g:1602:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalIntegrate.g:1609:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1613:1: ( ( 'import' ) )
            // InternalIntegrate.g:1614:1: ( 'import' )
            {
            // InternalIntegrate.g:1614:1: ( 'import' )
            // InternalIntegrate.g:1615:2: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalIntegrate.g:1624:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1628:1: ( rule__Import__Group__1__Impl )
            // InternalIntegrate.g:1629:2: rule__Import__Group__1__Impl
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
    // InternalIntegrate.g:1635:1: rule__Import__Group__1__Impl : ( ( rule__Import__SchemaAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1639:1: ( ( ( rule__Import__SchemaAssignment_1 ) ) )
            // InternalIntegrate.g:1640:1: ( ( rule__Import__SchemaAssignment_1 ) )
            {
            // InternalIntegrate.g:1640:1: ( ( rule__Import__SchemaAssignment_1 ) )
            // InternalIntegrate.g:1641:2: ( rule__Import__SchemaAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getSchemaAssignment_1()); 
            // InternalIntegrate.g:1642:2: ( rule__Import__SchemaAssignment_1 )
            // InternalIntegrate.g:1642:3: rule__Import__SchemaAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Import__SchemaAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getSchemaAssignment_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__0"
    // InternalIntegrate.g:1651:1: rule__ConflictResolutionSpecification__Group__0 : rule__ConflictResolutionSpecification__Group__0__Impl rule__ConflictResolutionSpecification__Group__1 ;
    public final void rule__ConflictResolutionSpecification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1655:1: ( rule__ConflictResolutionSpecification__Group__0__Impl rule__ConflictResolutionSpecification__Group__1 )
            // InternalIntegrate.g:1656:2: rule__ConflictResolutionSpecification__Group__0__Impl rule__ConflictResolutionSpecification__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__ConflictResolutionSpecification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__0"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__0__Impl"
    // InternalIntegrate.g:1663:1: rule__ConflictResolutionSpecification__Group__0__Impl : ( ( rule__ConflictResolutionSpecification__NameAssignment_0 ) ) ;
    public final void rule__ConflictResolutionSpecification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1667:1: ( ( ( rule__ConflictResolutionSpecification__NameAssignment_0 ) ) )
            // InternalIntegrate.g:1668:1: ( ( rule__ConflictResolutionSpecification__NameAssignment_0 ) )
            {
            // InternalIntegrate.g:1668:1: ( ( rule__ConflictResolutionSpecification__NameAssignment_0 ) )
            // InternalIntegrate.g:1669:2: ( rule__ConflictResolutionSpecification__NameAssignment_0 )
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getNameAssignment_0()); 
            // InternalIntegrate.g:1670:2: ( rule__ConflictResolutionSpecification__NameAssignment_0 )
            // InternalIntegrate.g:1670:3: rule__ConflictResolutionSpecification__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionSpecificationAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__0__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__1"
    // InternalIntegrate.g:1678:1: rule__ConflictResolutionSpecification__Group__1 : rule__ConflictResolutionSpecification__Group__1__Impl rule__ConflictResolutionSpecification__Group__2 ;
    public final void rule__ConflictResolutionSpecification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1682:1: ( rule__ConflictResolutionSpecification__Group__1__Impl rule__ConflictResolutionSpecification__Group__2 )
            // InternalIntegrate.g:1683:2: rule__ConflictResolutionSpecification__Group__1__Impl rule__ConflictResolutionSpecification__Group__2
            {
            pushFollow(FOLLOW_9);
            rule__ConflictResolutionSpecification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__1"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__1__Impl"
    // InternalIntegrate.g:1690:1: rule__ConflictResolutionSpecification__Group__1__Impl : ( ':' ) ;
    public final void rule__ConflictResolutionSpecification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1694:1: ( ( ':' ) )
            // InternalIntegrate.g:1695:1: ( ':' )
            {
            // InternalIntegrate.g:1695:1: ( ':' )
            // InternalIntegrate.g:1696:2: ':'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getColonKeyword_1()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__1__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__2"
    // InternalIntegrate.g:1705:1: rule__ConflictResolutionSpecification__Group__2 : rule__ConflictResolutionSpecification__Group__2__Impl rule__ConflictResolutionSpecification__Group__3 ;
    public final void rule__ConflictResolutionSpecification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1709:1: ( rule__ConflictResolutionSpecification__Group__2__Impl rule__ConflictResolutionSpecification__Group__3 )
            // InternalIntegrate.g:1710:2: rule__ConflictResolutionSpecification__Group__2__Impl rule__ConflictResolutionSpecification__Group__3
            {
            pushFollow(FOLLOW_10);
            rule__ConflictResolutionSpecification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__2"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__2__Impl"
    // InternalIntegrate.g:1717:1: rule__ConflictResolutionSpecification__Group__2__Impl : ( 'solve' ) ;
    public final void rule__ConflictResolutionSpecification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1721:1: ( ( 'solve' ) )
            // InternalIntegrate.g:1722:1: ( 'solve' )
            {
            // InternalIntegrate.g:1722:1: ( 'solve' )
            // InternalIntegrate.g:1723:2: 'solve'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getSolveKeyword_2()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getSolveKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__2__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__3"
    // InternalIntegrate.g:1732:1: rule__ConflictResolutionSpecification__Group__3 : rule__ConflictResolutionSpecification__Group__3__Impl rule__ConflictResolutionSpecification__Group__4 ;
    public final void rule__ConflictResolutionSpecification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1736:1: ( rule__ConflictResolutionSpecification__Group__3__Impl rule__ConflictResolutionSpecification__Group__4 )
            // InternalIntegrate.g:1737:2: rule__ConflictResolutionSpecification__Group__3__Impl rule__ConflictResolutionSpecification__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__ConflictResolutionSpecification__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__3"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__3__Impl"
    // InternalIntegrate.g:1744:1: rule__ConflictResolutionSpecification__Group__3__Impl : ( '{' ) ;
    public final void rule__ConflictResolutionSpecification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1748:1: ( ( '{' ) )
            // InternalIntegrate.g:1749:1: ( '{' )
            {
            // InternalIntegrate.g:1749:1: ( '{' )
            // InternalIntegrate.g:1750:2: '{'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getLeftCurlyBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__3__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__4"
    // InternalIntegrate.g:1759:1: rule__ConflictResolutionSpecification__Group__4 : rule__ConflictResolutionSpecification__Group__4__Impl rule__ConflictResolutionSpecification__Group__5 ;
    public final void rule__ConflictResolutionSpecification__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1763:1: ( rule__ConflictResolutionSpecification__Group__4__Impl rule__ConflictResolutionSpecification__Group__5 )
            // InternalIntegrate.g:1764:2: rule__ConflictResolutionSpecification__Group__4__Impl rule__ConflictResolutionSpecification__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__ConflictResolutionSpecification__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__4"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__4__Impl"
    // InternalIntegrate.g:1771:1: rule__ConflictResolutionSpecification__Group__4__Impl : ( ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 ) ) ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )* ) ) ;
    public final void rule__ConflictResolutionSpecification__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1775:1: ( ( ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 ) ) ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )* ) ) )
            // InternalIntegrate.g:1776:1: ( ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 ) ) ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )* ) )
            {
            // InternalIntegrate.g:1776:1: ( ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 ) ) ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )* ) )
            // InternalIntegrate.g:1777:2: ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 ) ) ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )* )
            {
            // InternalIntegrate.g:1777:2: ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 ) )
            // InternalIntegrate.g:1778:3: ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getVariablesAssignment_4()); 
            // InternalIntegrate.g:1779:3: ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )
            // InternalIntegrate.g:1779:4: rule__ConflictResolutionSpecification__VariablesAssignment_4
            {
            pushFollow(FOLLOW_13);
            rule__ConflictResolutionSpecification__VariablesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionSpecificationAccess().getVariablesAssignment_4()); 

            }

            // InternalIntegrate.g:1782:2: ( ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )* )
            // InternalIntegrate.g:1783:3: ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )*
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getVariablesAssignment_4()); 
            // InternalIntegrate.g:1784:3: ( rule__ConflictResolutionSpecification__VariablesAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalIntegrate.g:1784:4: rule__ConflictResolutionSpecification__VariablesAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__ConflictResolutionSpecification__VariablesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getConflictResolutionSpecificationAccess().getVariablesAssignment_4()); 

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
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__4__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__5"
    // InternalIntegrate.g:1793:1: rule__ConflictResolutionSpecification__Group__5 : rule__ConflictResolutionSpecification__Group__5__Impl rule__ConflictResolutionSpecification__Group__6 ;
    public final void rule__ConflictResolutionSpecification__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1797:1: ( rule__ConflictResolutionSpecification__Group__5__Impl rule__ConflictResolutionSpecification__Group__6 )
            // InternalIntegrate.g:1798:2: rule__ConflictResolutionSpecification__Group__5__Impl rule__ConflictResolutionSpecification__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__ConflictResolutionSpecification__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__5"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__5__Impl"
    // InternalIntegrate.g:1805:1: rule__ConflictResolutionSpecification__Group__5__Impl : ( 'satisfies' ) ;
    public final void rule__ConflictResolutionSpecification__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1809:1: ( ( 'satisfies' ) )
            // InternalIntegrate.g:1810:1: ( 'satisfies' )
            {
            // InternalIntegrate.g:1810:1: ( 'satisfies' )
            // InternalIntegrate.g:1811:2: 'satisfies'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getSatisfiesKeyword_5()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getSatisfiesKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__5__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__6"
    // InternalIntegrate.g:1820:1: rule__ConflictResolutionSpecification__Group__6 : rule__ConflictResolutionSpecification__Group__6__Impl rule__ConflictResolutionSpecification__Group__7 ;
    public final void rule__ConflictResolutionSpecification__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1824:1: ( rule__ConflictResolutionSpecification__Group__6__Impl rule__ConflictResolutionSpecification__Group__7 )
            // InternalIntegrate.g:1825:2: rule__ConflictResolutionSpecification__Group__6__Impl rule__ConflictResolutionSpecification__Group__7
            {
            pushFollow(FOLLOW_14);
            rule__ConflictResolutionSpecification__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__6"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__6__Impl"
    // InternalIntegrate.g:1832:1: rule__ConflictResolutionSpecification__Group__6__Impl : ( '{' ) ;
    public final void rule__ConflictResolutionSpecification__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1836:1: ( ( '{' ) )
            // InternalIntegrate.g:1837:1: ( '{' )
            {
            // InternalIntegrate.g:1837:1: ( '{' )
            // InternalIntegrate.g:1838:2: '{'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__6__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__7"
    // InternalIntegrate.g:1847:1: rule__ConflictResolutionSpecification__Group__7 : rule__ConflictResolutionSpecification__Group__7__Impl rule__ConflictResolutionSpecification__Group__8 ;
    public final void rule__ConflictResolutionSpecification__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1851:1: ( rule__ConflictResolutionSpecification__Group__7__Impl rule__ConflictResolutionSpecification__Group__8 )
            // InternalIntegrate.g:1852:2: rule__ConflictResolutionSpecification__Group__7__Impl rule__ConflictResolutionSpecification__Group__8
            {
            pushFollow(FOLLOW_15);
            rule__ConflictResolutionSpecification__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__7"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__7__Impl"
    // InternalIntegrate.g:1859:1: rule__ConflictResolutionSpecification__Group__7__Impl : ( ( rule__ConflictResolutionSpecification__RuleAssignment_7 ) ) ;
    public final void rule__ConflictResolutionSpecification__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1863:1: ( ( ( rule__ConflictResolutionSpecification__RuleAssignment_7 ) ) )
            // InternalIntegrate.g:1864:1: ( ( rule__ConflictResolutionSpecification__RuleAssignment_7 ) )
            {
            // InternalIntegrate.g:1864:1: ( ( rule__ConflictResolutionSpecification__RuleAssignment_7 ) )
            // InternalIntegrate.g:1865:2: ( rule__ConflictResolutionSpecification__RuleAssignment_7 )
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getRuleAssignment_7()); 
            // InternalIntegrate.g:1866:2: ( rule__ConflictResolutionSpecification__RuleAssignment_7 )
            // InternalIntegrate.g:1866:3: rule__ConflictResolutionSpecification__RuleAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__RuleAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionSpecificationAccess().getRuleAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__7__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__8"
    // InternalIntegrate.g:1874:1: rule__ConflictResolutionSpecification__Group__8 : rule__ConflictResolutionSpecification__Group__8__Impl rule__ConflictResolutionSpecification__Group__9 ;
    public final void rule__ConflictResolutionSpecification__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1878:1: ( rule__ConflictResolutionSpecification__Group__8__Impl rule__ConflictResolutionSpecification__Group__9 )
            // InternalIntegrate.g:1879:2: rule__ConflictResolutionSpecification__Group__8__Impl rule__ConflictResolutionSpecification__Group__9
            {
            pushFollow(FOLLOW_15);
            rule__ConflictResolutionSpecification__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__8"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__8__Impl"
    // InternalIntegrate.g:1886:1: rule__ConflictResolutionSpecification__Group__8__Impl : ( '}' ) ;
    public final void rule__ConflictResolutionSpecification__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1890:1: ( ( '}' ) )
            // InternalIntegrate.g:1891:1: ( '}' )
            {
            // InternalIntegrate.g:1891:1: ( '}' )
            // InternalIntegrate.g:1892:2: '}'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getRightCurlyBracketKeyword_8()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__8__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__9"
    // InternalIntegrate.g:1901:1: rule__ConflictResolutionSpecification__Group__9 : rule__ConflictResolutionSpecification__Group__9__Impl rule__ConflictResolutionSpecification__Group__10 ;
    public final void rule__ConflictResolutionSpecification__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1905:1: ( rule__ConflictResolutionSpecification__Group__9__Impl rule__ConflictResolutionSpecification__Group__10 )
            // InternalIntegrate.g:1906:2: rule__ConflictResolutionSpecification__Group__9__Impl rule__ConflictResolutionSpecification__Group__10
            {
            pushFollow(FOLLOW_16);
            rule__ConflictResolutionSpecification__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__9"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__9__Impl"
    // InternalIntegrate.g:1913:1: rule__ConflictResolutionSpecification__Group__9__Impl : ( '}' ) ;
    public final void rule__ConflictResolutionSpecification__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1917:1: ( ( '}' ) )
            // InternalIntegrate.g:1918:1: ( '}' )
            {
            // InternalIntegrate.g:1918:1: ( '}' )
            // InternalIntegrate.g:1919:2: '}'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getRightCurlyBracketKeyword_9()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__9__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__10"
    // InternalIntegrate.g:1928:1: rule__ConflictResolutionSpecification__Group__10 : rule__ConflictResolutionSpecification__Group__10__Impl rule__ConflictResolutionSpecification__Group__11 ;
    public final void rule__ConflictResolutionSpecification__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1932:1: ( rule__ConflictResolutionSpecification__Group__10__Impl rule__ConflictResolutionSpecification__Group__11 )
            // InternalIntegrate.g:1933:2: rule__ConflictResolutionSpecification__Group__10__Impl rule__ConflictResolutionSpecification__Group__11
            {
            pushFollow(FOLLOW_17);
            rule__ConflictResolutionSpecification__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__10"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__10__Impl"
    // InternalIntegrate.g:1940:1: rule__ConflictResolutionSpecification__Group__10__Impl : ( 'with' ) ;
    public final void rule__ConflictResolutionSpecification__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1944:1: ( ( 'with' ) )
            // InternalIntegrate.g:1945:1: ( 'with' )
            {
            // InternalIntegrate.g:1945:1: ( 'with' )
            // InternalIntegrate.g:1946:2: 'with'
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getWithKeyword_10()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getWithKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__10__Impl"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__11"
    // InternalIntegrate.g:1955:1: rule__ConflictResolutionSpecification__Group__11 : rule__ConflictResolutionSpecification__Group__11__Impl ;
    public final void rule__ConflictResolutionSpecification__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1959:1: ( rule__ConflictResolutionSpecification__Group__11__Impl )
            // InternalIntegrate.g:1960:2: rule__ConflictResolutionSpecification__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__11"


    // $ANTLR start "rule__ConflictResolutionSpecification__Group__11__Impl"
    // InternalIntegrate.g:1966:1: rule__ConflictResolutionSpecification__Group__11__Impl : ( ( rule__ConflictResolutionSpecification__ResolutionAssignment_11 ) ) ;
    public final void rule__ConflictResolutionSpecification__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1970:1: ( ( ( rule__ConflictResolutionSpecification__ResolutionAssignment_11 ) ) )
            // InternalIntegrate.g:1971:1: ( ( rule__ConflictResolutionSpecification__ResolutionAssignment_11 ) )
            {
            // InternalIntegrate.g:1971:1: ( ( rule__ConflictResolutionSpecification__ResolutionAssignment_11 ) )
            // InternalIntegrate.g:1972:2: ( rule__ConflictResolutionSpecification__ResolutionAssignment_11 )
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getResolutionAssignment_11()); 
            // InternalIntegrate.g:1973:2: ( rule__ConflictResolutionSpecification__ResolutionAssignment_11 )
            // InternalIntegrate.g:1973:3: rule__ConflictResolutionSpecification__ResolutionAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__ConflictResolutionSpecification__ResolutionAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getConflictResolutionSpecificationAccess().getResolutionAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__Group__11__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalIntegrate.g:1982:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1986:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalIntegrate.g:1987:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalIntegrate.g:1994:1: rule__Variable__Group__0__Impl : ( 'var' ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:1998:1: ( ( 'var' ) )
            // InternalIntegrate.g:1999:1: ( 'var' )
            {
            // InternalIntegrate.g:1999:1: ( 'var' )
            // InternalIntegrate.g:2000:2: 'var'
            {
             before(grammarAccess.getVariableAccess().getVarKeyword_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalIntegrate.g:2009:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2013:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalIntegrate.g:2014:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
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
    // InternalIntegrate.g:2021:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__NameAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2025:1: ( ( ( rule__Variable__NameAssignment_1 ) ) )
            // InternalIntegrate.g:2026:1: ( ( rule__Variable__NameAssignment_1 ) )
            {
            // InternalIntegrate.g:2026:1: ( ( rule__Variable__NameAssignment_1 ) )
            // InternalIntegrate.g:2027:2: ( rule__Variable__NameAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment_1()); 
            // InternalIntegrate.g:2028:2: ( rule__Variable__NameAssignment_1 )
            // InternalIntegrate.g:2028:3: rule__Variable__NameAssignment_1
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
    // InternalIntegrate.g:2036:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2040:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalIntegrate.g:2041:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
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
    // InternalIntegrate.g:2048:1: rule__Variable__Group__2__Impl : ( '=' ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2052:1: ( ( '=' ) )
            // InternalIntegrate.g:2053:1: ( '=' )
            {
            // InternalIntegrate.g:2053:1: ( '=' )
            // InternalIntegrate.g:2054:2: '='
            {
             before(grammarAccess.getVariableAccess().getEqualsSignKeyword_2()); 
            match(input,27,FOLLOW_2); 
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
    // InternalIntegrate.g:2063:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2067:1: ( rule__Variable__Group__3__Impl )
            // InternalIntegrate.g:2068:2: rule__Variable__Group__3__Impl
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
    // InternalIntegrate.g:2074:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__PipelineAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2078:1: ( ( ( rule__Variable__PipelineAssignment_3 ) ) )
            // InternalIntegrate.g:2079:1: ( ( rule__Variable__PipelineAssignment_3 ) )
            {
            // InternalIntegrate.g:2079:1: ( ( rule__Variable__PipelineAssignment_3 ) )
            // InternalIntegrate.g:2080:2: ( rule__Variable__PipelineAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getPipelineAssignment_3()); 
            // InternalIntegrate.g:2081:2: ( rule__Variable__PipelineAssignment_3 )
            // InternalIntegrate.g:2081:3: rule__Variable__PipelineAssignment_3
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


    // $ANTLR start "rule__PipelineStageSrc__Group__0"
    // InternalIntegrate.g:2090:1: rule__PipelineStageSrc__Group__0 : rule__PipelineStageSrc__Group__0__Impl rule__PipelineStageSrc__Group__1 ;
    public final void rule__PipelineStageSrc__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2094:1: ( rule__PipelineStageSrc__Group__0__Impl rule__PipelineStageSrc__Group__1 )
            // InternalIntegrate.g:2095:2: rule__PipelineStageSrc__Group__0__Impl rule__PipelineStageSrc__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__PipelineStageSrc__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__Group__0"


    // $ANTLR start "rule__PipelineStageSrc__Group__0__Impl"
    // InternalIntegrate.g:2102:1: rule__PipelineStageSrc__Group__0__Impl : ( ( rule__PipelineStageSrc__NameAssignment_0 ) ) ;
    public final void rule__PipelineStageSrc__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2106:1: ( ( ( rule__PipelineStageSrc__NameAssignment_0 ) ) )
            // InternalIntegrate.g:2107:1: ( ( rule__PipelineStageSrc__NameAssignment_0 ) )
            {
            // InternalIntegrate.g:2107:1: ( ( rule__PipelineStageSrc__NameAssignment_0 ) )
            // InternalIntegrate.g:2108:2: ( rule__PipelineStageSrc__NameAssignment_0 )
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNameAssignment_0()); 
            // InternalIntegrate.g:2109:2: ( rule__PipelineStageSrc__NameAssignment_0 )
            // InternalIntegrate.g:2109:3: rule__PipelineStageSrc__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageSrcAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__Group__0__Impl"


    // $ANTLR start "rule__PipelineStageSrc__Group__1"
    // InternalIntegrate.g:2117:1: rule__PipelineStageSrc__Group__1 : rule__PipelineStageSrc__Group__1__Impl rule__PipelineStageSrc__Group__2 ;
    public final void rule__PipelineStageSrc__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2121:1: ( rule__PipelineStageSrc__Group__1__Impl rule__PipelineStageSrc__Group__2 )
            // InternalIntegrate.g:2122:2: rule__PipelineStageSrc__Group__1__Impl rule__PipelineStageSrc__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__PipelineStageSrc__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__Group__1"


    // $ANTLR start "rule__PipelineStageSrc__Group__1__Impl"
    // InternalIntegrate.g:2129:1: rule__PipelineStageSrc__Group__1__Impl : ( '|' ) ;
    public final void rule__PipelineStageSrc__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2133:1: ( ( '|' ) )
            // InternalIntegrate.g:2134:1: ( '|' )
            {
            // InternalIntegrate.g:2134:1: ( '|' )
            // InternalIntegrate.g:2135:2: '|'
            {
             before(grammarAccess.getPipelineStageSrcAccess().getVerticalLineKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getPipelineStageSrcAccess().getVerticalLineKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__Group__1__Impl"


    // $ANTLR start "rule__PipelineStageSrc__Group__2"
    // InternalIntegrate.g:2144:1: rule__PipelineStageSrc__Group__2 : rule__PipelineStageSrc__Group__2__Impl ;
    public final void rule__PipelineStageSrc__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2148:1: ( rule__PipelineStageSrc__Group__2__Impl )
            // InternalIntegrate.g:2149:2: rule__PipelineStageSrc__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__Group__2"


    // $ANTLR start "rule__PipelineStageSrc__Group__2__Impl"
    // InternalIntegrate.g:2155:1: rule__PipelineStageSrc__Group__2__Impl : ( ( rule__PipelineStageSrc__NextAssignment_2 ) ) ;
    public final void rule__PipelineStageSrc__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2159:1: ( ( ( rule__PipelineStageSrc__NextAssignment_2 ) ) )
            // InternalIntegrate.g:2160:1: ( ( rule__PipelineStageSrc__NextAssignment_2 ) )
            {
            // InternalIntegrate.g:2160:1: ( ( rule__PipelineStageSrc__NextAssignment_2 ) )
            // InternalIntegrate.g:2161:2: ( rule__PipelineStageSrc__NextAssignment_2 )
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNextAssignment_2()); 
            // InternalIntegrate.g:2162:2: ( rule__PipelineStageSrc__NextAssignment_2 )
            // InternalIntegrate.g:2162:3: rule__PipelineStageSrc__NextAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__NextAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageSrcAccess().getNextAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__Group__2__Impl"


    // $ANTLR start "rule__PipelineStageTrg__Group__0"
    // InternalIntegrate.g:2171:1: rule__PipelineStageTrg__Group__0 : rule__PipelineStageTrg__Group__0__Impl rule__PipelineStageTrg__Group__1 ;
    public final void rule__PipelineStageTrg__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2175:1: ( rule__PipelineStageTrg__Group__0__Impl rule__PipelineStageTrg__Group__1 )
            // InternalIntegrate.g:2176:2: rule__PipelineStageTrg__Group__0__Impl rule__PipelineStageTrg__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__PipelineStageTrg__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__Group__0"


    // $ANTLR start "rule__PipelineStageTrg__Group__0__Impl"
    // InternalIntegrate.g:2183:1: rule__PipelineStageTrg__Group__0__Impl : ( ( rule__PipelineStageTrg__NameAssignment_0 ) ) ;
    public final void rule__PipelineStageTrg__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2187:1: ( ( ( rule__PipelineStageTrg__NameAssignment_0 ) ) )
            // InternalIntegrate.g:2188:1: ( ( rule__PipelineStageTrg__NameAssignment_0 ) )
            {
            // InternalIntegrate.g:2188:1: ( ( rule__PipelineStageTrg__NameAssignment_0 ) )
            // InternalIntegrate.g:2189:2: ( rule__PipelineStageTrg__NameAssignment_0 )
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNameAssignment_0()); 
            // InternalIntegrate.g:2190:2: ( rule__PipelineStageTrg__NameAssignment_0 )
            // InternalIntegrate.g:2190:3: rule__PipelineStageTrg__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTrgAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__Group__0__Impl"


    // $ANTLR start "rule__PipelineStageTrg__Group__1"
    // InternalIntegrate.g:2198:1: rule__PipelineStageTrg__Group__1 : rule__PipelineStageTrg__Group__1__Impl rule__PipelineStageTrg__Group__2 ;
    public final void rule__PipelineStageTrg__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2202:1: ( rule__PipelineStageTrg__Group__1__Impl rule__PipelineStageTrg__Group__2 )
            // InternalIntegrate.g:2203:2: rule__PipelineStageTrg__Group__1__Impl rule__PipelineStageTrg__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__PipelineStageTrg__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__Group__1"


    // $ANTLR start "rule__PipelineStageTrg__Group__1__Impl"
    // InternalIntegrate.g:2210:1: rule__PipelineStageTrg__Group__1__Impl : ( '|' ) ;
    public final void rule__PipelineStageTrg__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2214:1: ( ( '|' ) )
            // InternalIntegrate.g:2215:1: ( '|' )
            {
            // InternalIntegrate.g:2215:1: ( '|' )
            // InternalIntegrate.g:2216:2: '|'
            {
             before(grammarAccess.getPipelineStageTrgAccess().getVerticalLineKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTrgAccess().getVerticalLineKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__Group__1__Impl"


    // $ANTLR start "rule__PipelineStageTrg__Group__2"
    // InternalIntegrate.g:2225:1: rule__PipelineStageTrg__Group__2 : rule__PipelineStageTrg__Group__2__Impl ;
    public final void rule__PipelineStageTrg__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2229:1: ( rule__PipelineStageTrg__Group__2__Impl )
            // InternalIntegrate.g:2230:2: rule__PipelineStageTrg__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__Group__2"


    // $ANTLR start "rule__PipelineStageTrg__Group__2__Impl"
    // InternalIntegrate.g:2236:1: rule__PipelineStageTrg__Group__2__Impl : ( ( rule__PipelineStageTrg__NextAssignment_2 ) ) ;
    public final void rule__PipelineStageTrg__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2240:1: ( ( ( rule__PipelineStageTrg__NextAssignment_2 ) ) )
            // InternalIntegrate.g:2241:1: ( ( rule__PipelineStageTrg__NextAssignment_2 ) )
            {
            // InternalIntegrate.g:2241:1: ( ( rule__PipelineStageTrg__NextAssignment_2 ) )
            // InternalIntegrate.g:2242:2: ( rule__PipelineStageTrg__NextAssignment_2 )
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNextAssignment_2()); 
            // InternalIntegrate.g:2243:2: ( rule__PipelineStageTrg__NextAssignment_2 )
            // InternalIntegrate.g:2243:3: rule__PipelineStageTrg__NextAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__NextAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTrgAccess().getNextAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__Group__2__Impl"


    // $ANTLR start "rule__PipelineStageCreated__Group__0"
    // InternalIntegrate.g:2252:1: rule__PipelineStageCreated__Group__0 : rule__PipelineStageCreated__Group__0__Impl rule__PipelineStageCreated__Group__1 ;
    public final void rule__PipelineStageCreated__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2256:1: ( rule__PipelineStageCreated__Group__0__Impl rule__PipelineStageCreated__Group__1 )
            // InternalIntegrate.g:2257:2: rule__PipelineStageCreated__Group__0__Impl rule__PipelineStageCreated__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__PipelineStageCreated__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageCreated__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__Group__0"


    // $ANTLR start "rule__PipelineStageCreated__Group__0__Impl"
    // InternalIntegrate.g:2264:1: rule__PipelineStageCreated__Group__0__Impl : ( ( rule__PipelineStageCreated__NameAssignment_0 ) ) ;
    public final void rule__PipelineStageCreated__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2268:1: ( ( ( rule__PipelineStageCreated__NameAssignment_0 ) ) )
            // InternalIntegrate.g:2269:1: ( ( rule__PipelineStageCreated__NameAssignment_0 ) )
            {
            // InternalIntegrate.g:2269:1: ( ( rule__PipelineStageCreated__NameAssignment_0 ) )
            // InternalIntegrate.g:2270:2: ( rule__PipelineStageCreated__NameAssignment_0 )
            {
             before(grammarAccess.getPipelineStageCreatedAccess().getNameAssignment_0()); 
            // InternalIntegrate.g:2271:2: ( rule__PipelineStageCreated__NameAssignment_0 )
            // InternalIntegrate.g:2271:3: rule__PipelineStageCreated__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageCreated__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageCreatedAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__Group__0__Impl"


    // $ANTLR start "rule__PipelineStageCreated__Group__1"
    // InternalIntegrate.g:2279:1: rule__PipelineStageCreated__Group__1 : rule__PipelineStageCreated__Group__1__Impl rule__PipelineStageCreated__Group__2 ;
    public final void rule__PipelineStageCreated__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2283:1: ( rule__PipelineStageCreated__Group__1__Impl rule__PipelineStageCreated__Group__2 )
            // InternalIntegrate.g:2284:2: rule__PipelineStageCreated__Group__1__Impl rule__PipelineStageCreated__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__PipelineStageCreated__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageCreated__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__Group__1"


    // $ANTLR start "rule__PipelineStageCreated__Group__1__Impl"
    // InternalIntegrate.g:2291:1: rule__PipelineStageCreated__Group__1__Impl : ( '|' ) ;
    public final void rule__PipelineStageCreated__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2295:1: ( ( '|' ) )
            // InternalIntegrate.g:2296:1: ( '|' )
            {
            // InternalIntegrate.g:2296:1: ( '|' )
            // InternalIntegrate.g:2297:2: '|'
            {
             before(grammarAccess.getPipelineStageCreatedAccess().getVerticalLineKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getPipelineStageCreatedAccess().getVerticalLineKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__Group__1__Impl"


    // $ANTLR start "rule__PipelineStageCreated__Group__2"
    // InternalIntegrate.g:2306:1: rule__PipelineStageCreated__Group__2 : rule__PipelineStageCreated__Group__2__Impl ;
    public final void rule__PipelineStageCreated__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2310:1: ( rule__PipelineStageCreated__Group__2__Impl )
            // InternalIntegrate.g:2311:2: rule__PipelineStageCreated__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageCreated__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__Group__2"


    // $ANTLR start "rule__PipelineStageCreated__Group__2__Impl"
    // InternalIntegrate.g:2317:1: rule__PipelineStageCreated__Group__2__Impl : ( ( rule__PipelineStageCreated__NextAssignment_2 ) ) ;
    public final void rule__PipelineStageCreated__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2321:1: ( ( ( rule__PipelineStageCreated__NextAssignment_2 ) ) )
            // InternalIntegrate.g:2322:1: ( ( rule__PipelineStageCreated__NextAssignment_2 ) )
            {
            // InternalIntegrate.g:2322:1: ( ( rule__PipelineStageCreated__NextAssignment_2 ) )
            // InternalIntegrate.g:2323:2: ( rule__PipelineStageCreated__NextAssignment_2 )
            {
             before(grammarAccess.getPipelineStageCreatedAccess().getNextAssignment_2()); 
            // InternalIntegrate.g:2324:2: ( rule__PipelineStageCreated__NextAssignment_2 )
            // InternalIntegrate.g:2324:3: rule__PipelineStageCreated__NextAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageCreated__NextAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageCreatedAccess().getNextAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__Group__2__Impl"


    // $ANTLR start "rule__PipelineStageDeleted__Group__0"
    // InternalIntegrate.g:2333:1: rule__PipelineStageDeleted__Group__0 : rule__PipelineStageDeleted__Group__0__Impl rule__PipelineStageDeleted__Group__1 ;
    public final void rule__PipelineStageDeleted__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2337:1: ( rule__PipelineStageDeleted__Group__0__Impl rule__PipelineStageDeleted__Group__1 )
            // InternalIntegrate.g:2338:2: rule__PipelineStageDeleted__Group__0__Impl rule__PipelineStageDeleted__Group__1
            {
            pushFollow(FOLLOW_20);
            rule__PipelineStageDeleted__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageDeleted__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__Group__0"


    // $ANTLR start "rule__PipelineStageDeleted__Group__0__Impl"
    // InternalIntegrate.g:2345:1: rule__PipelineStageDeleted__Group__0__Impl : ( ( rule__PipelineStageDeleted__NameAssignment_0 ) ) ;
    public final void rule__PipelineStageDeleted__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2349:1: ( ( ( rule__PipelineStageDeleted__NameAssignment_0 ) ) )
            // InternalIntegrate.g:2350:1: ( ( rule__PipelineStageDeleted__NameAssignment_0 ) )
            {
            // InternalIntegrate.g:2350:1: ( ( rule__PipelineStageDeleted__NameAssignment_0 ) )
            // InternalIntegrate.g:2351:2: ( rule__PipelineStageDeleted__NameAssignment_0 )
            {
             before(grammarAccess.getPipelineStageDeletedAccess().getNameAssignment_0()); 
            // InternalIntegrate.g:2352:2: ( rule__PipelineStageDeleted__NameAssignment_0 )
            // InternalIntegrate.g:2352:3: rule__PipelineStageDeleted__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageDeleted__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageDeletedAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__Group__0__Impl"


    // $ANTLR start "rule__PipelineStageDeleted__Group__1"
    // InternalIntegrate.g:2360:1: rule__PipelineStageDeleted__Group__1 : rule__PipelineStageDeleted__Group__1__Impl rule__PipelineStageDeleted__Group__2 ;
    public final void rule__PipelineStageDeleted__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2364:1: ( rule__PipelineStageDeleted__Group__1__Impl rule__PipelineStageDeleted__Group__2 )
            // InternalIntegrate.g:2365:2: rule__PipelineStageDeleted__Group__1__Impl rule__PipelineStageDeleted__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__PipelineStageDeleted__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageDeleted__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__Group__1"


    // $ANTLR start "rule__PipelineStageDeleted__Group__1__Impl"
    // InternalIntegrate.g:2372:1: rule__PipelineStageDeleted__Group__1__Impl : ( '|' ) ;
    public final void rule__PipelineStageDeleted__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2376:1: ( ( '|' ) )
            // InternalIntegrate.g:2377:1: ( '|' )
            {
            // InternalIntegrate.g:2377:1: ( '|' )
            // InternalIntegrate.g:2378:2: '|'
            {
             before(grammarAccess.getPipelineStageDeletedAccess().getVerticalLineKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getPipelineStageDeletedAccess().getVerticalLineKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__Group__1__Impl"


    // $ANTLR start "rule__PipelineStageDeleted__Group__2"
    // InternalIntegrate.g:2387:1: rule__PipelineStageDeleted__Group__2 : rule__PipelineStageDeleted__Group__2__Impl ;
    public final void rule__PipelineStageDeleted__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2391:1: ( rule__PipelineStageDeleted__Group__2__Impl )
            // InternalIntegrate.g:2392:2: rule__PipelineStageDeleted__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageDeleted__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__Group__2"


    // $ANTLR start "rule__PipelineStageDeleted__Group__2__Impl"
    // InternalIntegrate.g:2398:1: rule__PipelineStageDeleted__Group__2__Impl : ( ( rule__PipelineStageDeleted__NextAssignment_2 ) ) ;
    public final void rule__PipelineStageDeleted__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2402:1: ( ( ( rule__PipelineStageDeleted__NextAssignment_2 ) ) )
            // InternalIntegrate.g:2403:1: ( ( rule__PipelineStageDeleted__NextAssignment_2 ) )
            {
            // InternalIntegrate.g:2403:1: ( ( rule__PipelineStageDeleted__NextAssignment_2 ) )
            // InternalIntegrate.g:2404:2: ( rule__PipelineStageDeleted__NextAssignment_2 )
            {
             before(grammarAccess.getPipelineStageDeletedAccess().getNextAssignment_2()); 
            // InternalIntegrate.g:2405:2: ( rule__PipelineStageDeleted__NextAssignment_2 )
            // InternalIntegrate.g:2405:3: rule__PipelineStageDeleted__NextAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageDeleted__NextAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageDeletedAccess().getNextAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__Group__2__Impl"


    // $ANTLR start "rule__PipelineStageType__Group__0"
    // InternalIntegrate.g:2414:1: rule__PipelineStageType__Group__0 : rule__PipelineStageType__Group__0__Impl rule__PipelineStageType__Group__1 ;
    public final void rule__PipelineStageType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2418:1: ( rule__PipelineStageType__Group__0__Impl rule__PipelineStageType__Group__1 )
            // InternalIntegrate.g:2419:2: rule__PipelineStageType__Group__0__Impl rule__PipelineStageType__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__PipelineStageType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__0"


    // $ANTLR start "rule__PipelineStageType__Group__0__Impl"
    // InternalIntegrate.g:2426:1: rule__PipelineStageType__Group__0__Impl : ( ( rule__PipelineStageType__NameAssignment_0 ) ) ;
    public final void rule__PipelineStageType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2430:1: ( ( ( rule__PipelineStageType__NameAssignment_0 ) ) )
            // InternalIntegrate.g:2431:1: ( ( rule__PipelineStageType__NameAssignment_0 ) )
            {
            // InternalIntegrate.g:2431:1: ( ( rule__PipelineStageType__NameAssignment_0 ) )
            // InternalIntegrate.g:2432:2: ( rule__PipelineStageType__NameAssignment_0 )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getNameAssignment_0()); 
            // InternalIntegrate.g:2433:2: ( rule__PipelineStageType__NameAssignment_0 )
            // InternalIntegrate.g:2433:3: rule__PipelineStageType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__0__Impl"


    // $ANTLR start "rule__PipelineStageType__Group__1"
    // InternalIntegrate.g:2441:1: rule__PipelineStageType__Group__1 : rule__PipelineStageType__Group__1__Impl rule__PipelineStageType__Group__2 ;
    public final void rule__PipelineStageType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2445:1: ( rule__PipelineStageType__Group__1__Impl rule__PipelineStageType__Group__2 )
            // InternalIntegrate.g:2446:2: rule__PipelineStageType__Group__1__Impl rule__PipelineStageType__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__PipelineStageType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__1"


    // $ANTLR start "rule__PipelineStageType__Group__1__Impl"
    // InternalIntegrate.g:2453:1: rule__PipelineStageType__Group__1__Impl : ( ( rule__PipelineStageType__TypesAssignment_1 ) ) ;
    public final void rule__PipelineStageType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2457:1: ( ( ( rule__PipelineStageType__TypesAssignment_1 ) ) )
            // InternalIntegrate.g:2458:1: ( ( rule__PipelineStageType__TypesAssignment_1 ) )
            {
            // InternalIntegrate.g:2458:1: ( ( rule__PipelineStageType__TypesAssignment_1 ) )
            // InternalIntegrate.g:2459:2: ( rule__PipelineStageType__TypesAssignment_1 )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getTypesAssignment_1()); 
            // InternalIntegrate.g:2460:2: ( rule__PipelineStageType__TypesAssignment_1 )
            // InternalIntegrate.g:2460:3: rule__PipelineStageType__TypesAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageType__TypesAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTypeAccess().getTypesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__1__Impl"


    // $ANTLR start "rule__PipelineStageType__Group__2"
    // InternalIntegrate.g:2468:1: rule__PipelineStageType__Group__2 : rule__PipelineStageType__Group__2__Impl rule__PipelineStageType__Group__3 ;
    public final void rule__PipelineStageType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2472:1: ( rule__PipelineStageType__Group__2__Impl rule__PipelineStageType__Group__3 )
            // InternalIntegrate.g:2473:2: rule__PipelineStageType__Group__2__Impl rule__PipelineStageType__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__PipelineStageType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__2"


    // $ANTLR start "rule__PipelineStageType__Group__2__Impl"
    // InternalIntegrate.g:2480:1: rule__PipelineStageType__Group__2__Impl : ( ( rule__PipelineStageType__Group_2__0 )* ) ;
    public final void rule__PipelineStageType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2484:1: ( ( ( rule__PipelineStageType__Group_2__0 )* ) )
            // InternalIntegrate.g:2485:1: ( ( rule__PipelineStageType__Group_2__0 )* )
            {
            // InternalIntegrate.g:2485:1: ( ( rule__PipelineStageType__Group_2__0 )* )
            // InternalIntegrate.g:2486:2: ( rule__PipelineStageType__Group_2__0 )*
            {
             before(grammarAccess.getPipelineStageTypeAccess().getGroup_2()); 
            // InternalIntegrate.g:2487:2: ( rule__PipelineStageType__Group_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==29) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalIntegrate.g:2487:3: rule__PipelineStageType__Group_2__0
            	    {
            	    pushFollow(FOLLOW_23);
            	    rule__PipelineStageType__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getPipelineStageTypeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__2__Impl"


    // $ANTLR start "rule__PipelineStageType__Group__3"
    // InternalIntegrate.g:2495:1: rule__PipelineStageType__Group__3 : rule__PipelineStageType__Group__3__Impl rule__PipelineStageType__Group__4 ;
    public final void rule__PipelineStageType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2499:1: ( rule__PipelineStageType__Group__3__Impl rule__PipelineStageType__Group__4 )
            // InternalIntegrate.g:2500:2: rule__PipelineStageType__Group__3__Impl rule__PipelineStageType__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__PipelineStageType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__3"


    // $ANTLR start "rule__PipelineStageType__Group__3__Impl"
    // InternalIntegrate.g:2507:1: rule__PipelineStageType__Group__3__Impl : ( '|' ) ;
    public final void rule__PipelineStageType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2511:1: ( ( '|' ) )
            // InternalIntegrate.g:2512:1: ( '|' )
            {
            // InternalIntegrate.g:2512:1: ( '|' )
            // InternalIntegrate.g:2513:2: '|'
            {
             before(grammarAccess.getPipelineStageTypeAccess().getVerticalLineKeyword_3()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTypeAccess().getVerticalLineKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__3__Impl"


    // $ANTLR start "rule__PipelineStageType__Group__4"
    // InternalIntegrate.g:2522:1: rule__PipelineStageType__Group__4 : rule__PipelineStageType__Group__4__Impl ;
    public final void rule__PipelineStageType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2526:1: ( rule__PipelineStageType__Group__4__Impl )
            // InternalIntegrate.g:2527:2: rule__PipelineStageType__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__4"


    // $ANTLR start "rule__PipelineStageType__Group__4__Impl"
    // InternalIntegrate.g:2533:1: rule__PipelineStageType__Group__4__Impl : ( ( rule__PipelineStageType__NextAssignment_4 ) ) ;
    public final void rule__PipelineStageType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2537:1: ( ( ( rule__PipelineStageType__NextAssignment_4 ) ) )
            // InternalIntegrate.g:2538:1: ( ( rule__PipelineStageType__NextAssignment_4 ) )
            {
            // InternalIntegrate.g:2538:1: ( ( rule__PipelineStageType__NextAssignment_4 ) )
            // InternalIntegrate.g:2539:2: ( rule__PipelineStageType__NextAssignment_4 )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getNextAssignment_4()); 
            // InternalIntegrate.g:2540:2: ( rule__PipelineStageType__NextAssignment_4 )
            // InternalIntegrate.g:2540:3: rule__PipelineStageType__NextAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageType__NextAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTypeAccess().getNextAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group__4__Impl"


    // $ANTLR start "rule__PipelineStageType__Group_2__0"
    // InternalIntegrate.g:2549:1: rule__PipelineStageType__Group_2__0 : rule__PipelineStageType__Group_2__0__Impl rule__PipelineStageType__Group_2__1 ;
    public final void rule__PipelineStageType__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2553:1: ( rule__PipelineStageType__Group_2__0__Impl rule__PipelineStageType__Group_2__1 )
            // InternalIntegrate.g:2554:2: rule__PipelineStageType__Group_2__0__Impl rule__PipelineStageType__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__PipelineStageType__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group_2__0"


    // $ANTLR start "rule__PipelineStageType__Group_2__0__Impl"
    // InternalIntegrate.g:2561:1: rule__PipelineStageType__Group_2__0__Impl : ( ',' ) ;
    public final void rule__PipelineStageType__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2565:1: ( ( ',' ) )
            // InternalIntegrate.g:2566:1: ( ',' )
            {
            // InternalIntegrate.g:2566:1: ( ',' )
            // InternalIntegrate.g:2567:2: ','
            {
             before(grammarAccess.getPipelineStageTypeAccess().getCommaKeyword_2_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTypeAccess().getCommaKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group_2__0__Impl"


    // $ANTLR start "rule__PipelineStageType__Group_2__1"
    // InternalIntegrate.g:2576:1: rule__PipelineStageType__Group_2__1 : rule__PipelineStageType__Group_2__1__Impl ;
    public final void rule__PipelineStageType__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2580:1: ( rule__PipelineStageType__Group_2__1__Impl )
            // InternalIntegrate.g:2581:2: rule__PipelineStageType__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageType__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group_2__1"


    // $ANTLR start "rule__PipelineStageType__Group_2__1__Impl"
    // InternalIntegrate.g:2587:1: rule__PipelineStageType__Group_2__1__Impl : ( ( rule__PipelineStageType__TypesAssignment_2_1 ) ) ;
    public final void rule__PipelineStageType__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2591:1: ( ( ( rule__PipelineStageType__TypesAssignment_2_1 ) ) )
            // InternalIntegrate.g:2592:1: ( ( rule__PipelineStageType__TypesAssignment_2_1 ) )
            {
            // InternalIntegrate.g:2592:1: ( ( rule__PipelineStageType__TypesAssignment_2_1 ) )
            // InternalIntegrate.g:2593:2: ( rule__PipelineStageType__TypesAssignment_2_1 )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getTypesAssignment_2_1()); 
            // InternalIntegrate.g:2594:2: ( rule__PipelineStageType__TypesAssignment_2_1 )
            // InternalIntegrate.g:2594:3: rule__PipelineStageType__TypesAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageType__TypesAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTypeAccess().getTypesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__Group_2__1__Impl"


    // $ANTLR start "rule__OrExpression__Group__0"
    // InternalIntegrate.g:2603:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2607:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // InternalIntegrate.g:2608:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_24);
            rule__OrExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0"


    // $ANTLR start "rule__OrExpression__Group__0__Impl"
    // InternalIntegrate.g:2615:1: rule__OrExpression__Group__0__Impl : ( ruleAndExpression ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2619:1: ( ( ruleAndExpression ) )
            // InternalIntegrate.g:2620:1: ( ruleAndExpression )
            {
            // InternalIntegrate.g:2620:1: ( ruleAndExpression )
            // InternalIntegrate.g:2621:2: ruleAndExpression
            {
             before(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__0__Impl"


    // $ANTLR start "rule__OrExpression__Group__1"
    // InternalIntegrate.g:2630:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2634:1: ( rule__OrExpression__Group__1__Impl )
            // InternalIntegrate.g:2635:2: rule__OrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1"


    // $ANTLR start "rule__OrExpression__Group__1__Impl"
    // InternalIntegrate.g:2641:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2645:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // InternalIntegrate.g:2646:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // InternalIntegrate.g:2646:1: ( ( rule__OrExpression__Group_1__0 )* )
            // InternalIntegrate.g:2647:2: ( rule__OrExpression__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            // InternalIntegrate.g:2648:2: ( rule__OrExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==30) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalIntegrate.g:2648:3: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__OrExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getOrExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__0"
    // InternalIntegrate.g:2657:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2661:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // InternalIntegrate.g:2662:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_24);
            rule__OrExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0"


    // $ANTLR start "rule__OrExpression__Group_1__0__Impl"
    // InternalIntegrate.g:2669:1: rule__OrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2673:1: ( ( () ) )
            // InternalIntegrate.g:2674:1: ( () )
            {
            // InternalIntegrate.g:2674:1: ( () )
            // InternalIntegrate.g:2675:2: ()
            {
             before(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()); 
            // InternalIntegrate.g:2676:2: ()
            // InternalIntegrate.g:2676:3: 
            {
            }

             after(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__0__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__1"
    // InternalIntegrate.g:2684:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2688:1: ( rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 )
            // InternalIntegrate.g:2689:2: rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2
            {
            pushFollow(FOLLOW_14);
            rule__OrExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1"


    // $ANTLR start "rule__OrExpression__Group_1__1__Impl"
    // InternalIntegrate.g:2696:1: rule__OrExpression__Group_1__1__Impl : ( 'or' ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2700:1: ( ( 'or' ) )
            // InternalIntegrate.g:2701:1: ( 'or' )
            {
            // InternalIntegrate.g:2701:1: ( 'or' )
            // InternalIntegrate.g:2702:2: 'or'
            {
             before(grammarAccess.getOrExpressionAccess().getOrKeyword_1_1()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getOrExpressionAccess().getOrKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__1__Impl"


    // $ANTLR start "rule__OrExpression__Group_1__2"
    // InternalIntegrate.g:2711:1: rule__OrExpression__Group_1__2 : rule__OrExpression__Group_1__2__Impl ;
    public final void rule__OrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2715:1: ( rule__OrExpression__Group_1__2__Impl )
            // InternalIntegrate.g:2716:2: rule__OrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__2"


    // $ANTLR start "rule__OrExpression__Group_1__2__Impl"
    // InternalIntegrate.g:2722:1: rule__OrExpression__Group_1__2__Impl : ( ( rule__OrExpression__RightAssignment_1_2 ) ) ;
    public final void rule__OrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2726:1: ( ( ( rule__OrExpression__RightAssignment_1_2 ) ) )
            // InternalIntegrate.g:2727:1: ( ( rule__OrExpression__RightAssignment_1_2 ) )
            {
            // InternalIntegrate.g:2727:1: ( ( rule__OrExpression__RightAssignment_1_2 ) )
            // InternalIntegrate.g:2728:2: ( rule__OrExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2()); 
            // InternalIntegrate.g:2729:2: ( rule__OrExpression__RightAssignment_1_2 )
            // InternalIntegrate.g:2729:3: rule__OrExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__OrExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__Group_1__2__Impl"


    // $ANTLR start "rule__AndExpression__Group__0"
    // InternalIntegrate.g:2738:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2742:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // InternalIntegrate.g:2743:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__AndExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0"


    // $ANTLR start "rule__AndExpression__Group__0__Impl"
    // InternalIntegrate.g:2750:1: rule__AndExpression__Group__0__Impl : ( ruleBooleanExpression ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2754:1: ( ( ruleBooleanExpression ) )
            // InternalIntegrate.g:2755:1: ( ruleBooleanExpression )
            {
            // InternalIntegrate.g:2755:1: ( ruleBooleanExpression )
            // InternalIntegrate.g:2756:2: ruleBooleanExpression
            {
             before(grammarAccess.getAndExpressionAccess().getBooleanExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getBooleanExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__0__Impl"


    // $ANTLR start "rule__AndExpression__Group__1"
    // InternalIntegrate.g:2765:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2769:1: ( rule__AndExpression__Group__1__Impl )
            // InternalIntegrate.g:2770:2: rule__AndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1"


    // $ANTLR start "rule__AndExpression__Group__1__Impl"
    // InternalIntegrate.g:2776:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2780:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // InternalIntegrate.g:2781:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // InternalIntegrate.g:2781:1: ( ( rule__AndExpression__Group_1__0 )* )
            // InternalIntegrate.g:2782:2: ( rule__AndExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            // InternalIntegrate.g:2783:2: ( rule__AndExpression__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==31) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalIntegrate.g:2783:3: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_27);
            	    rule__AndExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getAndExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__0"
    // InternalIntegrate.g:2792:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2796:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // InternalIntegrate.g:2797:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_26);
            rule__AndExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0"


    // $ANTLR start "rule__AndExpression__Group_1__0__Impl"
    // InternalIntegrate.g:2804:1: rule__AndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2808:1: ( ( () ) )
            // InternalIntegrate.g:2809:1: ( () )
            {
            // InternalIntegrate.g:2809:1: ( () )
            // InternalIntegrate.g:2810:2: ()
            {
             before(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); 
            // InternalIntegrate.g:2811:2: ()
            // InternalIntegrate.g:2811:3: 
            {
            }

             after(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__1"
    // InternalIntegrate.g:2819:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2823:1: ( rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 )
            // InternalIntegrate.g:2824:2: rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2
            {
            pushFollow(FOLLOW_14);
            rule__AndExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1"


    // $ANTLR start "rule__AndExpression__Group_1__1__Impl"
    // InternalIntegrate.g:2831:1: rule__AndExpression__Group_1__1__Impl : ( 'and' ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2835:1: ( ( 'and' ) )
            // InternalIntegrate.g:2836:1: ( 'and' )
            {
            // InternalIntegrate.g:2836:1: ( 'and' )
            // InternalIntegrate.g:2837:2: 'and'
            {
             before(grammarAccess.getAndExpressionAccess().getAndKeyword_1_1()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getAndExpressionAccess().getAndKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AndExpression__Group_1__2"
    // InternalIntegrate.g:2846:1: rule__AndExpression__Group_1__2 : rule__AndExpression__Group_1__2__Impl ;
    public final void rule__AndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2850:1: ( rule__AndExpression__Group_1__2__Impl )
            // InternalIntegrate.g:2851:2: rule__AndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__2"


    // $ANTLR start "rule__AndExpression__Group_1__2__Impl"
    // InternalIntegrate.g:2857:1: rule__AndExpression__Group_1__2__Impl : ( ( rule__AndExpression__RightAssignment_1_2 ) ) ;
    public final void rule__AndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2861:1: ( ( ( rule__AndExpression__RightAssignment_1_2 ) ) )
            // InternalIntegrate.g:2862:1: ( ( rule__AndExpression__RightAssignment_1_2 ) )
            {
            // InternalIntegrate.g:2862:1: ( ( rule__AndExpression__RightAssignment_1_2 ) )
            // InternalIntegrate.g:2863:2: ( rule__AndExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); 
            // InternalIntegrate.g:2864:2: ( rule__AndExpression__RightAssignment_1_2 )
            // InternalIntegrate.g:2864:3: rule__AndExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AndExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__Group_1__2__Impl"


    // $ANTLR start "rule__BooleanExpression__Group__0"
    // InternalIntegrate.g:2873:1: rule__BooleanExpression__Group__0 : rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 ;
    public final void rule__BooleanExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2877:1: ( rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1 )
            // InternalIntegrate.g:2878:2: rule__BooleanExpression__Group__0__Impl rule__BooleanExpression__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__BooleanExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__0"


    // $ANTLR start "rule__BooleanExpression__Group__0__Impl"
    // InternalIntegrate.g:2885:1: rule__BooleanExpression__Group__0__Impl : ( ( rule__BooleanExpression__InvertAssignment_0 )? ) ;
    public final void rule__BooleanExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2889:1: ( ( ( rule__BooleanExpression__InvertAssignment_0 )? ) )
            // InternalIntegrate.g:2890:1: ( ( rule__BooleanExpression__InvertAssignment_0 )? )
            {
            // InternalIntegrate.g:2890:1: ( ( rule__BooleanExpression__InvertAssignment_0 )? )
            // InternalIntegrate.g:2891:2: ( rule__BooleanExpression__InvertAssignment_0 )?
            {
             before(grammarAccess.getBooleanExpressionAccess().getInvertAssignment_0()); 
            // InternalIntegrate.g:2892:2: ( rule__BooleanExpression__InvertAssignment_0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==42) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalIntegrate.g:2892:3: rule__BooleanExpression__InvertAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanExpression__InvertAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBooleanExpressionAccess().getInvertAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__0__Impl"


    // $ANTLR start "rule__BooleanExpression__Group__1"
    // InternalIntegrate.g:2900:1: rule__BooleanExpression__Group__1 : rule__BooleanExpression__Group__1__Impl ;
    public final void rule__BooleanExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2904:1: ( rule__BooleanExpression__Group__1__Impl )
            // InternalIntegrate.g:2905:2: rule__BooleanExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__1"


    // $ANTLR start "rule__BooleanExpression__Group__1__Impl"
    // InternalIntegrate.g:2911:1: rule__BooleanExpression__Group__1__Impl : ( ( rule__BooleanExpression__ExpressionAssignment_1 ) ) ;
    public final void rule__BooleanExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2915:1: ( ( ( rule__BooleanExpression__ExpressionAssignment_1 ) ) )
            // InternalIntegrate.g:2916:1: ( ( rule__BooleanExpression__ExpressionAssignment_1 ) )
            {
            // InternalIntegrate.g:2916:1: ( ( rule__BooleanExpression__ExpressionAssignment_1 ) )
            // InternalIntegrate.g:2917:2: ( rule__BooleanExpression__ExpressionAssignment_1 )
            {
             before(grammarAccess.getBooleanExpressionAccess().getExpressionAssignment_1()); 
            // InternalIntegrate.g:2918:2: ( rule__BooleanExpression__ExpressionAssignment_1 )
            // InternalIntegrate.g:2918:3: rule__BooleanExpression__ExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__ExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBooleanExpressionAccess().getExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__Group__1__Impl"


    // $ANTLR start "rule__WrappedOrExpression__Group__0"
    // InternalIntegrate.g:2927:1: rule__WrappedOrExpression__Group__0 : rule__WrappedOrExpression__Group__0__Impl rule__WrappedOrExpression__Group__1 ;
    public final void rule__WrappedOrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2931:1: ( rule__WrappedOrExpression__Group__0__Impl rule__WrappedOrExpression__Group__1 )
            // InternalIntegrate.g:2932:2: rule__WrappedOrExpression__Group__0__Impl rule__WrappedOrExpression__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__WrappedOrExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WrappedOrExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WrappedOrExpression__Group__0"


    // $ANTLR start "rule__WrappedOrExpression__Group__0__Impl"
    // InternalIntegrate.g:2939:1: rule__WrappedOrExpression__Group__0__Impl : ( '(' ) ;
    public final void rule__WrappedOrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2943:1: ( ( '(' ) )
            // InternalIntegrate.g:2944:1: ( '(' )
            {
            // InternalIntegrate.g:2944:1: ( '(' )
            // InternalIntegrate.g:2945:2: '('
            {
             before(grammarAccess.getWrappedOrExpressionAccess().getLeftParenthesisKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getWrappedOrExpressionAccess().getLeftParenthesisKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WrappedOrExpression__Group__0__Impl"


    // $ANTLR start "rule__WrappedOrExpression__Group__1"
    // InternalIntegrate.g:2954:1: rule__WrappedOrExpression__Group__1 : rule__WrappedOrExpression__Group__1__Impl rule__WrappedOrExpression__Group__2 ;
    public final void rule__WrappedOrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2958:1: ( rule__WrappedOrExpression__Group__1__Impl rule__WrappedOrExpression__Group__2 )
            // InternalIntegrate.g:2959:2: rule__WrappedOrExpression__Group__1__Impl rule__WrappedOrExpression__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__WrappedOrExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WrappedOrExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WrappedOrExpression__Group__1"


    // $ANTLR start "rule__WrappedOrExpression__Group__1__Impl"
    // InternalIntegrate.g:2966:1: rule__WrappedOrExpression__Group__1__Impl : ( ( rule__WrappedOrExpression__ExpressionAssignment_1 ) ) ;
    public final void rule__WrappedOrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2970:1: ( ( ( rule__WrappedOrExpression__ExpressionAssignment_1 ) ) )
            // InternalIntegrate.g:2971:1: ( ( rule__WrappedOrExpression__ExpressionAssignment_1 ) )
            {
            // InternalIntegrate.g:2971:1: ( ( rule__WrappedOrExpression__ExpressionAssignment_1 ) )
            // InternalIntegrate.g:2972:2: ( rule__WrappedOrExpression__ExpressionAssignment_1 )
            {
             before(grammarAccess.getWrappedOrExpressionAccess().getExpressionAssignment_1()); 
            // InternalIntegrate.g:2973:2: ( rule__WrappedOrExpression__ExpressionAssignment_1 )
            // InternalIntegrate.g:2973:3: rule__WrappedOrExpression__ExpressionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WrappedOrExpression__ExpressionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWrappedOrExpressionAccess().getExpressionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WrappedOrExpression__Group__1__Impl"


    // $ANTLR start "rule__WrappedOrExpression__Group__2"
    // InternalIntegrate.g:2981:1: rule__WrappedOrExpression__Group__2 : rule__WrappedOrExpression__Group__2__Impl ;
    public final void rule__WrappedOrExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2985:1: ( rule__WrappedOrExpression__Group__2__Impl )
            // InternalIntegrate.g:2986:2: rule__WrappedOrExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WrappedOrExpression__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WrappedOrExpression__Group__2"


    // $ANTLR start "rule__WrappedOrExpression__Group__2__Impl"
    // InternalIntegrate.g:2992:1: rule__WrappedOrExpression__Group__2__Impl : ( ')' ) ;
    public final void rule__WrappedOrExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:2996:1: ( ( ')' ) )
            // InternalIntegrate.g:2997:1: ( ')' )
            {
            // InternalIntegrate.g:2997:1: ( ')' )
            // InternalIntegrate.g:2998:2: ')'
            {
             before(grammarAccess.getWrappedOrExpressionAccess().getRightParenthesisKeyword_2()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getWrappedOrExpressionAccess().getRightParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WrappedOrExpression__Group__2__Impl"


    // $ANTLR start "rule__ComparisonExpression__Group__0"
    // InternalIntegrate.g:3008:1: rule__ComparisonExpression__Group__0 : rule__ComparisonExpression__Group__0__Impl rule__ComparisonExpression__Group__1 ;
    public final void rule__ComparisonExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3012:1: ( rule__ComparisonExpression__Group__0__Impl rule__ComparisonExpression__Group__1 )
            // InternalIntegrate.g:3013:2: rule__ComparisonExpression__Group__0__Impl rule__ComparisonExpression__Group__1
            {
            pushFollow(FOLLOW_29);
            rule__ComparisonExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__Group__0"


    // $ANTLR start "rule__ComparisonExpression__Group__0__Impl"
    // InternalIntegrate.g:3020:1: rule__ComparisonExpression__Group__0__Impl : ( ( rule__ComparisonExpression__LhsAssignment_0 ) ) ;
    public final void rule__ComparisonExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3024:1: ( ( ( rule__ComparisonExpression__LhsAssignment_0 ) ) )
            // InternalIntegrate.g:3025:1: ( ( rule__ComparisonExpression__LhsAssignment_0 ) )
            {
            // InternalIntegrate.g:3025:1: ( ( rule__ComparisonExpression__LhsAssignment_0 ) )
            // InternalIntegrate.g:3026:2: ( rule__ComparisonExpression__LhsAssignment_0 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getLhsAssignment_0()); 
            // InternalIntegrate.g:3027:2: ( rule__ComparisonExpression__LhsAssignment_0 )
            // InternalIntegrate.g:3027:3: rule__ComparisonExpression__LhsAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__LhsAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getLhsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__Group__0__Impl"


    // $ANTLR start "rule__ComparisonExpression__Group__1"
    // InternalIntegrate.g:3035:1: rule__ComparisonExpression__Group__1 : rule__ComparisonExpression__Group__1__Impl rule__ComparisonExpression__Group__2 ;
    public final void rule__ComparisonExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3039:1: ( rule__ComparisonExpression__Group__1__Impl rule__ComparisonExpression__Group__2 )
            // InternalIntegrate.g:3040:2: rule__ComparisonExpression__Group__1__Impl rule__ComparisonExpression__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__ComparisonExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__Group__1"


    // $ANTLR start "rule__ComparisonExpression__Group__1__Impl"
    // InternalIntegrate.g:3047:1: rule__ComparisonExpression__Group__1__Impl : ( ( rule__ComparisonExpression__OpAssignment_1 ) ) ;
    public final void rule__ComparisonExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3051:1: ( ( ( rule__ComparisonExpression__OpAssignment_1 ) ) )
            // InternalIntegrate.g:3052:1: ( ( rule__ComparisonExpression__OpAssignment_1 ) )
            {
            // InternalIntegrate.g:3052:1: ( ( rule__ComparisonExpression__OpAssignment_1 ) )
            // InternalIntegrate.g:3053:2: ( rule__ComparisonExpression__OpAssignment_1 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getOpAssignment_1()); 
            // InternalIntegrate.g:3054:2: ( rule__ComparisonExpression__OpAssignment_1 )
            // InternalIntegrate.g:3054:3: rule__ComparisonExpression__OpAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__OpAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getOpAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__Group__1__Impl"


    // $ANTLR start "rule__ComparisonExpression__Group__2"
    // InternalIntegrate.g:3062:1: rule__ComparisonExpression__Group__2 : rule__ComparisonExpression__Group__2__Impl ;
    public final void rule__ComparisonExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3066:1: ( rule__ComparisonExpression__Group__2__Impl )
            // InternalIntegrate.g:3067:2: rule__ComparisonExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__Group__2"


    // $ANTLR start "rule__ComparisonExpression__Group__2__Impl"
    // InternalIntegrate.g:3073:1: rule__ComparisonExpression__Group__2__Impl : ( ( rule__ComparisonExpression__RhsAssignment_2 ) ) ;
    public final void rule__ComparisonExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3077:1: ( ( ( rule__ComparisonExpression__RhsAssignment_2 ) ) )
            // InternalIntegrate.g:3078:1: ( ( rule__ComparisonExpression__RhsAssignment_2 ) )
            {
            // InternalIntegrate.g:3078:1: ( ( rule__ComparisonExpression__RhsAssignment_2 ) )
            // InternalIntegrate.g:3079:2: ( rule__ComparisonExpression__RhsAssignment_2 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getRhsAssignment_2()); 
            // InternalIntegrate.g:3080:2: ( rule__ComparisonExpression__RhsAssignment_2 )
            // InternalIntegrate.g:3080:3: rule__ComparisonExpression__RhsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__RhsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getRhsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__Group__2__Impl"


    // $ANTLR start "rule__Resolution__Group__0"
    // InternalIntegrate.g:3089:1: rule__Resolution__Group__0 : rule__Resolution__Group__0__Impl rule__Resolution__Group__1 ;
    public final void rule__Resolution__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3093:1: ( rule__Resolution__Group__0__Impl rule__Resolution__Group__1 )
            // InternalIntegrate.g:3094:2: rule__Resolution__Group__0__Impl rule__Resolution__Group__1
            {
            pushFollow(FOLLOW_31);
            rule__Resolution__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Resolution__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group__0"


    // $ANTLR start "rule__Resolution__Group__0__Impl"
    // InternalIntegrate.g:3101:1: rule__Resolution__Group__0__Impl : ( ( rule__Resolution__StrategiesAssignment_0 ) ) ;
    public final void rule__Resolution__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3105:1: ( ( ( rule__Resolution__StrategiesAssignment_0 ) ) )
            // InternalIntegrate.g:3106:1: ( ( rule__Resolution__StrategiesAssignment_0 ) )
            {
            // InternalIntegrate.g:3106:1: ( ( rule__Resolution__StrategiesAssignment_0 ) )
            // InternalIntegrate.g:3107:2: ( rule__Resolution__StrategiesAssignment_0 )
            {
             before(grammarAccess.getResolutionAccess().getStrategiesAssignment_0()); 
            // InternalIntegrate.g:3108:2: ( rule__Resolution__StrategiesAssignment_0 )
            // InternalIntegrate.g:3108:3: rule__Resolution__StrategiesAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Resolution__StrategiesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getResolutionAccess().getStrategiesAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group__0__Impl"


    // $ANTLR start "rule__Resolution__Group__1"
    // InternalIntegrate.g:3116:1: rule__Resolution__Group__1 : rule__Resolution__Group__1__Impl rule__Resolution__Group__2 ;
    public final void rule__Resolution__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3120:1: ( rule__Resolution__Group__1__Impl rule__Resolution__Group__2 )
            // InternalIntegrate.g:3121:2: rule__Resolution__Group__1__Impl rule__Resolution__Group__2
            {
            pushFollow(FOLLOW_31);
            rule__Resolution__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Resolution__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group__1"


    // $ANTLR start "rule__Resolution__Group__1__Impl"
    // InternalIntegrate.g:3128:1: rule__Resolution__Group__1__Impl : ( ( rule__Resolution__Group_1__0 )* ) ;
    public final void rule__Resolution__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3132:1: ( ( ( rule__Resolution__Group_1__0 )* ) )
            // InternalIntegrate.g:3133:1: ( ( rule__Resolution__Group_1__0 )* )
            {
            // InternalIntegrate.g:3133:1: ( ( rule__Resolution__Group_1__0 )* )
            // InternalIntegrate.g:3134:2: ( rule__Resolution__Group_1__0 )*
            {
             before(grammarAccess.getResolutionAccess().getGroup_1()); 
            // InternalIntegrate.g:3135:2: ( rule__Resolution__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==30) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalIntegrate.g:3135:3: rule__Resolution__Group_1__0
            	    {
            	    pushFollow(FOLLOW_25);
            	    rule__Resolution__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getResolutionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group__1__Impl"


    // $ANTLR start "rule__Resolution__Group__2"
    // InternalIntegrate.g:3143:1: rule__Resolution__Group__2 : rule__Resolution__Group__2__Impl ;
    public final void rule__Resolution__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3147:1: ( rule__Resolution__Group__2__Impl )
            // InternalIntegrate.g:3148:2: rule__Resolution__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Resolution__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group__2"


    // $ANTLR start "rule__Resolution__Group__2__Impl"
    // InternalIntegrate.g:3154:1: rule__Resolution__Group__2__Impl : ( ( rule__Resolution__FallbackAssignment_2 )? ) ;
    public final void rule__Resolution__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3158:1: ( ( ( rule__Resolution__FallbackAssignment_2 )? ) )
            // InternalIntegrate.g:3159:1: ( ( rule__Resolution__FallbackAssignment_2 )? )
            {
            // InternalIntegrate.g:3159:1: ( ( rule__Resolution__FallbackAssignment_2 )? )
            // InternalIntegrate.g:3160:2: ( rule__Resolution__FallbackAssignment_2 )?
            {
             before(grammarAccess.getResolutionAccess().getFallbackAssignment_2()); 
            // InternalIntegrate.g:3161:2: ( rule__Resolution__FallbackAssignment_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=46 && LA23_0<=49)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalIntegrate.g:3161:3: rule__Resolution__FallbackAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Resolution__FallbackAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResolutionAccess().getFallbackAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group__2__Impl"


    // $ANTLR start "rule__Resolution__Group_1__0"
    // InternalIntegrate.g:3170:1: rule__Resolution__Group_1__0 : rule__Resolution__Group_1__0__Impl rule__Resolution__Group_1__1 ;
    public final void rule__Resolution__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3174:1: ( rule__Resolution__Group_1__0__Impl rule__Resolution__Group_1__1 )
            // InternalIntegrate.g:3175:2: rule__Resolution__Group_1__0__Impl rule__Resolution__Group_1__1
            {
            pushFollow(FOLLOW_17);
            rule__Resolution__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Resolution__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group_1__0"


    // $ANTLR start "rule__Resolution__Group_1__0__Impl"
    // InternalIntegrate.g:3182:1: rule__Resolution__Group_1__0__Impl : ( 'or' ) ;
    public final void rule__Resolution__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3186:1: ( ( 'or' ) )
            // InternalIntegrate.g:3187:1: ( 'or' )
            {
            // InternalIntegrate.g:3187:1: ( 'or' )
            // InternalIntegrate.g:3188:2: 'or'
            {
             before(grammarAccess.getResolutionAccess().getOrKeyword_1_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getResolutionAccess().getOrKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group_1__0__Impl"


    // $ANTLR start "rule__Resolution__Group_1__1"
    // InternalIntegrate.g:3197:1: rule__Resolution__Group_1__1 : rule__Resolution__Group_1__1__Impl ;
    public final void rule__Resolution__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3201:1: ( rule__Resolution__Group_1__1__Impl )
            // InternalIntegrate.g:3202:2: rule__Resolution__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Resolution__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group_1__1"


    // $ANTLR start "rule__Resolution__Group_1__1__Impl"
    // InternalIntegrate.g:3208:1: rule__Resolution__Group_1__1__Impl : ( ( rule__Resolution__StrategiesAssignment_1_1 ) ) ;
    public final void rule__Resolution__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3212:1: ( ( ( rule__Resolution__StrategiesAssignment_1_1 ) ) )
            // InternalIntegrate.g:3213:1: ( ( rule__Resolution__StrategiesAssignment_1_1 ) )
            {
            // InternalIntegrate.g:3213:1: ( ( rule__Resolution__StrategiesAssignment_1_1 ) )
            // InternalIntegrate.g:3214:2: ( rule__Resolution__StrategiesAssignment_1_1 )
            {
             before(grammarAccess.getResolutionAccess().getStrategiesAssignment_1_1()); 
            // InternalIntegrate.g:3215:2: ( rule__Resolution__StrategiesAssignment_1_1 )
            // InternalIntegrate.g:3215:3: rule__Resolution__StrategiesAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Resolution__StrategiesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getResolutionAccess().getStrategiesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__Group_1__1__Impl"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group__0"
    // InternalIntegrate.g:3224:1: rule__ResolutionStrategyWithOperationalDelta__Group__0 : rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl rule__ResolutionStrategyWithOperationalDelta__Group__1 ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3228:1: ( rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl rule__ResolutionStrategyWithOperationalDelta__Group__1 )
            // InternalIntegrate.g:3229:2: rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl rule__ResolutionStrategyWithOperationalDelta__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group__0"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl"
    // InternalIntegrate.g:3236:1: rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl : ( ( rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0 ) ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3240:1: ( ( ( rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0 ) ) )
            // InternalIntegrate.g:3241:1: ( ( rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0 ) )
            {
            // InternalIntegrate.g:3241:1: ( ( rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0 ) )
            // InternalIntegrate.g:3242:2: ( rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0 )
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getStrategyAssignment_0()); 
            // InternalIntegrate.g:3243:2: ( rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0 )
            // InternalIntegrate.g:3243:3: rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getStrategyAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group__0__Impl"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group__1"
    // InternalIntegrate.g:3251:1: rule__ResolutionStrategyWithOperationalDelta__Group__1 : rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3255:1: ( rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl )
            // InternalIntegrate.g:3256:2: rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group__1"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl"
    // InternalIntegrate.g:3262:1: rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl : ( ( rule__ResolutionStrategyWithOperationalDelta__Group_1__0 )? ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3266:1: ( ( ( rule__ResolutionStrategyWithOperationalDelta__Group_1__0 )? ) )
            // InternalIntegrate.g:3267:1: ( ( rule__ResolutionStrategyWithOperationalDelta__Group_1__0 )? )
            {
            // InternalIntegrate.g:3267:1: ( ( rule__ResolutionStrategyWithOperationalDelta__Group_1__0 )? )
            // InternalIntegrate.g:3268:2: ( rule__ResolutionStrategyWithOperationalDelta__Group_1__0 )?
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getGroup_1()); 
            // InternalIntegrate.g:3269:2: ( rule__ResolutionStrategyWithOperationalDelta__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalIntegrate.g:3269:3: rule__ResolutionStrategyWithOperationalDelta__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ResolutionStrategyWithOperationalDelta__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group__1__Impl"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__0"
    // InternalIntegrate.g:3278:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__0 : rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__1 ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3282:1: ( rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__1 )
            // InternalIntegrate.g:3283:2: rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__1
            {
            pushFollow(FOLLOW_10);
            rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__0"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl"
    // InternalIntegrate.g:3290:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl : ( 'when' ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3294:1: ( ( 'when' ) )
            // InternalIntegrate.g:3295:1: ( 'when' )
            {
            // InternalIntegrate.g:3295:1: ( 'when' )
            // InternalIntegrate.g:3296:2: 'when'
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getWhenKeyword_1_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getWhenKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__0__Impl"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__1"
    // InternalIntegrate.g:3305:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__1 : rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__2 ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3309:1: ( rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__2 )
            // InternalIntegrate.g:3310:2: rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__2
            {
            pushFollow(FOLLOW_11);
            rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__1"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl"
    // InternalIntegrate.g:3317:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl : ( '{' ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3321:1: ( ( '{' ) )
            // InternalIntegrate.g:3322:1: ( '{' )
            {
            // InternalIntegrate.g:3322:1: ( '{' )
            // InternalIntegrate.g:3323:2: '{'
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getLeftCurlyBracketKeyword_1_1()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getLeftCurlyBracketKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__1__Impl"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__2"
    // InternalIntegrate.g:3332:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__2 : rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__3 ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3336:1: ( rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__3 )
            // InternalIntegrate.g:3337:2: rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl rule__ResolutionStrategyWithOperationalDelta__Group_1__3
            {
            pushFollow(FOLLOW_15);
            rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__2"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl"
    // InternalIntegrate.g:3344:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl : ( ( rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2 ) ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3348:1: ( ( ( rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2 ) ) )
            // InternalIntegrate.g:3349:1: ( ( rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2 ) )
            {
            // InternalIntegrate.g:3349:1: ( ( rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2 ) )
            // InternalIntegrate.g:3350:2: ( rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2 )
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getOperationalDeltaAssignment_1_2()); 
            // InternalIntegrate.g:3351:2: ( rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2 )
            // InternalIntegrate.g:3351:3: rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getOperationalDeltaAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__2__Impl"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__3"
    // InternalIntegrate.g:3359:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__3 : rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3363:1: ( rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl )
            // InternalIntegrate.g:3364:2: rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__3"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl"
    // InternalIntegrate.g:3370:1: rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl : ( '}' ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3374:1: ( ( '}' ) )
            // InternalIntegrate.g:3375:1: ( '}' )
            {
            // InternalIntegrate.g:3375:1: ( '}' )
            // InternalIntegrate.g:3376:2: '}'
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getRightCurlyBracketKeyword_1_3()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getRightCurlyBracketKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__Group_1__3__Impl"


    // $ANTLR start "rule__OperationalDelta__Group__0"
    // InternalIntegrate.g:3386:1: rule__OperationalDelta__Group__0 : rule__OperationalDelta__Group__0__Impl rule__OperationalDelta__Group__1 ;
    public final void rule__OperationalDelta__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3390:1: ( rule__OperationalDelta__Group__0__Impl rule__OperationalDelta__Group__1 )
            // InternalIntegrate.g:3391:2: rule__OperationalDelta__Group__0__Impl rule__OperationalDelta__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__OperationalDelta__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationalDelta__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__0"


    // $ANTLR start "rule__OperationalDelta__Group__0__Impl"
    // InternalIntegrate.g:3398:1: rule__OperationalDelta__Group__0__Impl : ( ( ( rule__OperationalDelta__VariablesAssignment_0 ) ) ( ( rule__OperationalDelta__VariablesAssignment_0 )* ) ) ;
    public final void rule__OperationalDelta__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3402:1: ( ( ( ( rule__OperationalDelta__VariablesAssignment_0 ) ) ( ( rule__OperationalDelta__VariablesAssignment_0 )* ) ) )
            // InternalIntegrate.g:3403:1: ( ( ( rule__OperationalDelta__VariablesAssignment_0 ) ) ( ( rule__OperationalDelta__VariablesAssignment_0 )* ) )
            {
            // InternalIntegrate.g:3403:1: ( ( ( rule__OperationalDelta__VariablesAssignment_0 ) ) ( ( rule__OperationalDelta__VariablesAssignment_0 )* ) )
            // InternalIntegrate.g:3404:2: ( ( rule__OperationalDelta__VariablesAssignment_0 ) ) ( ( rule__OperationalDelta__VariablesAssignment_0 )* )
            {
            // InternalIntegrate.g:3404:2: ( ( rule__OperationalDelta__VariablesAssignment_0 ) )
            // InternalIntegrate.g:3405:3: ( rule__OperationalDelta__VariablesAssignment_0 )
            {
             before(grammarAccess.getOperationalDeltaAccess().getVariablesAssignment_0()); 
            // InternalIntegrate.g:3406:3: ( rule__OperationalDelta__VariablesAssignment_0 )
            // InternalIntegrate.g:3406:4: rule__OperationalDelta__VariablesAssignment_0
            {
            pushFollow(FOLLOW_13);
            rule__OperationalDelta__VariablesAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOperationalDeltaAccess().getVariablesAssignment_0()); 

            }

            // InternalIntegrate.g:3409:2: ( ( rule__OperationalDelta__VariablesAssignment_0 )* )
            // InternalIntegrate.g:3410:3: ( rule__OperationalDelta__VariablesAssignment_0 )*
            {
             before(grammarAccess.getOperationalDeltaAccess().getVariablesAssignment_0()); 
            // InternalIntegrate.g:3411:3: ( rule__OperationalDelta__VariablesAssignment_0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==26) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalIntegrate.g:3411:4: rule__OperationalDelta__VariablesAssignment_0
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__OperationalDelta__VariablesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getOperationalDeltaAccess().getVariablesAssignment_0()); 

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
    // $ANTLR end "rule__OperationalDelta__Group__0__Impl"


    // $ANTLR start "rule__OperationalDelta__Group__1"
    // InternalIntegrate.g:3420:1: rule__OperationalDelta__Group__1 : rule__OperationalDelta__Group__1__Impl rule__OperationalDelta__Group__2 ;
    public final void rule__OperationalDelta__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3424:1: ( rule__OperationalDelta__Group__1__Impl rule__OperationalDelta__Group__2 )
            // InternalIntegrate.g:3425:2: rule__OperationalDelta__Group__1__Impl rule__OperationalDelta__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__OperationalDelta__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationalDelta__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__1"


    // $ANTLR start "rule__OperationalDelta__Group__1__Impl"
    // InternalIntegrate.g:3432:1: rule__OperationalDelta__Group__1__Impl : ( 'satisfies' ) ;
    public final void rule__OperationalDelta__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3436:1: ( ( 'satisfies' ) )
            // InternalIntegrate.g:3437:1: ( 'satisfies' )
            {
            // InternalIntegrate.g:3437:1: ( 'satisfies' )
            // InternalIntegrate.g:3438:2: 'satisfies'
            {
             before(grammarAccess.getOperationalDeltaAccess().getSatisfiesKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getOperationalDeltaAccess().getSatisfiesKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__1__Impl"


    // $ANTLR start "rule__OperationalDelta__Group__2"
    // InternalIntegrate.g:3447:1: rule__OperationalDelta__Group__2 : rule__OperationalDelta__Group__2__Impl rule__OperationalDelta__Group__3 ;
    public final void rule__OperationalDelta__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3451:1: ( rule__OperationalDelta__Group__2__Impl rule__OperationalDelta__Group__3 )
            // InternalIntegrate.g:3452:2: rule__OperationalDelta__Group__2__Impl rule__OperationalDelta__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__OperationalDelta__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationalDelta__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__2"


    // $ANTLR start "rule__OperationalDelta__Group__2__Impl"
    // InternalIntegrate.g:3459:1: rule__OperationalDelta__Group__2__Impl : ( '{' ) ;
    public final void rule__OperationalDelta__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3463:1: ( ( '{' ) )
            // InternalIntegrate.g:3464:1: ( '{' )
            {
            // InternalIntegrate.g:3464:1: ( '{' )
            // InternalIntegrate.g:3465:2: '{'
            {
             before(grammarAccess.getOperationalDeltaAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getOperationalDeltaAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__2__Impl"


    // $ANTLR start "rule__OperationalDelta__Group__3"
    // InternalIntegrate.g:3474:1: rule__OperationalDelta__Group__3 : rule__OperationalDelta__Group__3__Impl rule__OperationalDelta__Group__4 ;
    public final void rule__OperationalDelta__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3478:1: ( rule__OperationalDelta__Group__3__Impl rule__OperationalDelta__Group__4 )
            // InternalIntegrate.g:3479:2: rule__OperationalDelta__Group__3__Impl rule__OperationalDelta__Group__4
            {
            pushFollow(FOLLOW_15);
            rule__OperationalDelta__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationalDelta__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__3"


    // $ANTLR start "rule__OperationalDelta__Group__3__Impl"
    // InternalIntegrate.g:3486:1: rule__OperationalDelta__Group__3__Impl : ( ( rule__OperationalDelta__RuleAssignment_3 ) ) ;
    public final void rule__OperationalDelta__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3490:1: ( ( ( rule__OperationalDelta__RuleAssignment_3 ) ) )
            // InternalIntegrate.g:3491:1: ( ( rule__OperationalDelta__RuleAssignment_3 ) )
            {
            // InternalIntegrate.g:3491:1: ( ( rule__OperationalDelta__RuleAssignment_3 ) )
            // InternalIntegrate.g:3492:2: ( rule__OperationalDelta__RuleAssignment_3 )
            {
             before(grammarAccess.getOperationalDeltaAccess().getRuleAssignment_3()); 
            // InternalIntegrate.g:3493:2: ( rule__OperationalDelta__RuleAssignment_3 )
            // InternalIntegrate.g:3493:3: rule__OperationalDelta__RuleAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__OperationalDelta__RuleAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getOperationalDeltaAccess().getRuleAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__3__Impl"


    // $ANTLR start "rule__OperationalDelta__Group__4"
    // InternalIntegrate.g:3501:1: rule__OperationalDelta__Group__4 : rule__OperationalDelta__Group__4__Impl ;
    public final void rule__OperationalDelta__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3505:1: ( rule__OperationalDelta__Group__4__Impl )
            // InternalIntegrate.g:3506:2: rule__OperationalDelta__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationalDelta__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__4"


    // $ANTLR start "rule__OperationalDelta__Group__4__Impl"
    // InternalIntegrate.g:3512:1: rule__OperationalDelta__Group__4__Impl : ( '}' ) ;
    public final void rule__OperationalDelta__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3516:1: ( ( '}' ) )
            // InternalIntegrate.g:3517:1: ( '}' )
            {
            // InternalIntegrate.g:3517:1: ( '}' )
            // InternalIntegrate.g:3518:2: '}'
            {
             before(grammarAccess.getOperationalDeltaAccess().getRightCurlyBracketKeyword_4()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getOperationalDeltaAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__Group__4__Impl"


    // $ANTLR start "rule__Integrate__PackageAssignment_0"
    // InternalIntegrate.g:3528:1: rule__Integrate__PackageAssignment_0 : ( rulePackage ) ;
    public final void rule__Integrate__PackageAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3532:1: ( ( rulePackage ) )
            // InternalIntegrate.g:3533:2: ( rulePackage )
            {
            // InternalIntegrate.g:3533:2: ( rulePackage )
            // InternalIntegrate.g:3534:3: rulePackage
            {
             before(grammarAccess.getIntegrateAccess().getPackagePackageParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            rulePackage();

            state._fsp--;

             after(grammarAccess.getIntegrateAccess().getPackagePackageParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__PackageAssignment_0"


    // $ANTLR start "rule__Integrate__ImportsAssignment_1"
    // InternalIntegrate.g:3543:1: rule__Integrate__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Integrate__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3547:1: ( ( ruleImport ) )
            // InternalIntegrate.g:3548:2: ( ruleImport )
            {
            // InternalIntegrate.g:3548:2: ( ruleImport )
            // InternalIntegrate.g:3549:3: ruleImport
            {
             before(grammarAccess.getIntegrateAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getIntegrateAccess().getImportsImportParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__ImportsAssignment_1"


    // $ANTLR start "rule__Integrate__ConflictResolutionSpecificationsAssignment_2"
    // InternalIntegrate.g:3558:1: rule__Integrate__ConflictResolutionSpecificationsAssignment_2 : ( ruleConflictResolutionSpecification ) ;
    public final void rule__Integrate__ConflictResolutionSpecificationsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3562:1: ( ( ruleConflictResolutionSpecification ) )
            // InternalIntegrate.g:3563:2: ( ruleConflictResolutionSpecification )
            {
            // InternalIntegrate.g:3563:2: ( ruleConflictResolutionSpecification )
            // InternalIntegrate.g:3564:3: ruleConflictResolutionSpecification
            {
             before(grammarAccess.getIntegrateAccess().getConflictResolutionSpecificationsConflictResolutionSpecificationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleConflictResolutionSpecification();

            state._fsp--;

             after(grammarAccess.getIntegrateAccess().getConflictResolutionSpecificationsConflictResolutionSpecificationParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integrate__ConflictResolutionSpecificationsAssignment_2"


    // $ANTLR start "rule__Package__NameAssignment_1"
    // InternalIntegrate.g:3573:1: rule__Package__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__Package__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3577:1: ( ( ruleQualifiedName ) )
            // InternalIntegrate.g:3578:2: ( ruleQualifiedName )
            {
            // InternalIntegrate.g:3578:2: ( ruleQualifiedName )
            // InternalIntegrate.g:3579:3: ruleQualifiedName
            {
             before(grammarAccess.getPackageAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Package__NameAssignment_1"


    // $ANTLR start "rule__Import__SchemaAssignment_1"
    // InternalIntegrate.g:3588:1: rule__Import__SchemaAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Import__SchemaAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3592:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:3593:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:3593:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:3594:3: ( RULE_ID )
            {
             before(grammarAccess.getImportAccess().getSchemaSchemaCrossReference_1_0()); 
            // InternalIntegrate.g:3595:3: ( RULE_ID )
            // InternalIntegrate.g:3596:4: RULE_ID
            {
             before(grammarAccess.getImportAccess().getSchemaSchemaIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getSchemaSchemaIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getImportAccess().getSchemaSchemaCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__SchemaAssignment_1"


    // $ANTLR start "rule__ConflictResolutionSpecification__NameAssignment_0"
    // InternalIntegrate.g:3607:1: rule__ConflictResolutionSpecification__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ConflictResolutionSpecification__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3611:1: ( ( RULE_ID ) )
            // InternalIntegrate.g:3612:2: ( RULE_ID )
            {
            // InternalIntegrate.g:3612:2: ( RULE_ID )
            // InternalIntegrate.g:3613:3: RULE_ID
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getConflictResolutionSpecificationAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__NameAssignment_0"


    // $ANTLR start "rule__ConflictResolutionSpecification__VariablesAssignment_4"
    // InternalIntegrate.g:3622:1: rule__ConflictResolutionSpecification__VariablesAssignment_4 : ( ruleVariable ) ;
    public final void rule__ConflictResolutionSpecification__VariablesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3626:1: ( ( ruleVariable ) )
            // InternalIntegrate.g:3627:2: ( ruleVariable )
            {
            // InternalIntegrate.g:3627:2: ( ruleVariable )
            // InternalIntegrate.g:3628:3: ruleVariable
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getVariablesVariableParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getConflictResolutionSpecificationAccess().getVariablesVariableParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__VariablesAssignment_4"


    // $ANTLR start "rule__ConflictResolutionSpecification__RuleAssignment_7"
    // InternalIntegrate.g:3637:1: rule__ConflictResolutionSpecification__RuleAssignment_7 : ( ruleSatisfactionRule ) ;
    public final void rule__ConflictResolutionSpecification__RuleAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3641:1: ( ( ruleSatisfactionRule ) )
            // InternalIntegrate.g:3642:2: ( ruleSatisfactionRule )
            {
            // InternalIntegrate.g:3642:2: ( ruleSatisfactionRule )
            // InternalIntegrate.g:3643:3: ruleSatisfactionRule
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getRuleSatisfactionRuleParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleSatisfactionRule();

            state._fsp--;

             after(grammarAccess.getConflictResolutionSpecificationAccess().getRuleSatisfactionRuleParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__RuleAssignment_7"


    // $ANTLR start "rule__ConflictResolutionSpecification__ResolutionAssignment_11"
    // InternalIntegrate.g:3652:1: rule__ConflictResolutionSpecification__ResolutionAssignment_11 : ( ruleResolution ) ;
    public final void rule__ConflictResolutionSpecification__ResolutionAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3656:1: ( ( ruleResolution ) )
            // InternalIntegrate.g:3657:2: ( ruleResolution )
            {
            // InternalIntegrate.g:3657:2: ( ruleResolution )
            // InternalIntegrate.g:3658:3: ruleResolution
            {
             before(grammarAccess.getConflictResolutionSpecificationAccess().getResolutionResolutionParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleResolution();

            state._fsp--;

             after(grammarAccess.getConflictResolutionSpecificationAccess().getResolutionResolutionParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConflictResolutionSpecification__ResolutionAssignment_11"


    // $ANTLR start "rule__Variable__NameAssignment_1"
    // InternalIntegrate.g:3667:1: rule__Variable__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Variable__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3671:1: ( ( RULE_ID ) )
            // InternalIntegrate.g:3672:2: ( RULE_ID )
            {
            // InternalIntegrate.g:3672:2: ( RULE_ID )
            // InternalIntegrate.g:3673:3: RULE_ID
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
    // InternalIntegrate.g:3682:1: rule__Variable__PipelineAssignment_3 : ( rulePipeline ) ;
    public final void rule__Variable__PipelineAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3686:1: ( ( rulePipeline ) )
            // InternalIntegrate.g:3687:2: ( rulePipeline )
            {
            // InternalIntegrate.g:3687:2: ( rulePipeline )
            // InternalIntegrate.g:3688:3: rulePipeline
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


    // $ANTLR start "rule__VariableReference__RefAssignment"
    // InternalIntegrate.g:3697:1: rule__VariableReference__RefAssignment : ( ( RULE_ID ) ) ;
    public final void rule__VariableReference__RefAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3701:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:3702:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:3702:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:3703:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableReferenceAccess().getRefVariableCrossReference_0()); 
            // InternalIntegrate.g:3704:3: ( RULE_ID )
            // InternalIntegrate.g:3705:4: RULE_ID
            {
             before(grammarAccess.getVariableReferenceAccess().getRefVariableIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableReferenceAccess().getRefVariableIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getVariableReferenceAccess().getRefVariableCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableReference__RefAssignment"


    // $ANTLR start "rule__Pipeline__StartAssignment"
    // InternalIntegrate.g:3716:1: rule__Pipeline__StartAssignment : ( rulePipelineStageStart ) ;
    public final void rule__Pipeline__StartAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3720:1: ( ( rulePipelineStageStart ) )
            // InternalIntegrate.g:3721:2: ( rulePipelineStageStart )
            {
            // InternalIntegrate.g:3721:2: ( rulePipelineStageStart )
            // InternalIntegrate.g:3722:3: rulePipelineStageStart
            {
             before(grammarAccess.getPipelineAccess().getStartPipelineStageStartParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePipelineStageStart();

            state._fsp--;

             after(grammarAccess.getPipelineAccess().getStartPipelineStageStartParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Pipeline__StartAssignment"


    // $ANTLR start "rule__PipelineStageSrc__NameAssignment_0"
    // InternalIntegrate.g:3731:1: rule__PipelineStageSrc__NameAssignment_0 : ( ( 'src' ) ) ;
    public final void rule__PipelineStageSrc__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3735:1: ( ( ( 'src' ) ) )
            // InternalIntegrate.g:3736:2: ( ( 'src' ) )
            {
            // InternalIntegrate.g:3736:2: ( ( 'src' ) )
            // InternalIntegrate.g:3737:3: ( 'src' )
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0_0()); 
            // InternalIntegrate.g:3738:3: ( 'src' )
            // InternalIntegrate.g:3739:4: 'src'
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0_0()); 

            }

             after(grammarAccess.getPipelineStageSrcAccess().getNameSrcKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__NameAssignment_0"


    // $ANTLR start "rule__PipelineStageSrc__NextAssignment_2"
    // InternalIntegrate.g:3750:1: rule__PipelineStageSrc__NextAssignment_2 : ( ( rule__PipelineStageSrc__NextAlternatives_2_0 ) ) ;
    public final void rule__PipelineStageSrc__NextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3754:1: ( ( ( rule__PipelineStageSrc__NextAlternatives_2_0 ) ) )
            // InternalIntegrate.g:3755:2: ( ( rule__PipelineStageSrc__NextAlternatives_2_0 ) )
            {
            // InternalIntegrate.g:3755:2: ( ( rule__PipelineStageSrc__NextAlternatives_2_0 ) )
            // InternalIntegrate.g:3756:3: ( rule__PipelineStageSrc__NextAlternatives_2_0 )
            {
             before(grammarAccess.getPipelineStageSrcAccess().getNextAlternatives_2_0()); 
            // InternalIntegrate.g:3757:3: ( rule__PipelineStageSrc__NextAlternatives_2_0 )
            // InternalIntegrate.g:3757:4: rule__PipelineStageSrc__NextAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageSrc__NextAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageSrcAccess().getNextAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageSrc__NextAssignment_2"


    // $ANTLR start "rule__PipelineStageTrg__NameAssignment_0"
    // InternalIntegrate.g:3765:1: rule__PipelineStageTrg__NameAssignment_0 : ( ( 'trg' ) ) ;
    public final void rule__PipelineStageTrg__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3769:1: ( ( ( 'trg' ) ) )
            // InternalIntegrate.g:3770:2: ( ( 'trg' ) )
            {
            // InternalIntegrate.g:3770:2: ( ( 'trg' ) )
            // InternalIntegrate.g:3771:3: ( 'trg' )
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0_0()); 
            // InternalIntegrate.g:3772:3: ( 'trg' )
            // InternalIntegrate.g:3773:4: 'trg'
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0_0()); 

            }

             after(grammarAccess.getPipelineStageTrgAccess().getNameTrgKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__NameAssignment_0"


    // $ANTLR start "rule__PipelineStageTrg__NextAssignment_2"
    // InternalIntegrate.g:3784:1: rule__PipelineStageTrg__NextAssignment_2 : ( ( rule__PipelineStageTrg__NextAlternatives_2_0 ) ) ;
    public final void rule__PipelineStageTrg__NextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3788:1: ( ( ( rule__PipelineStageTrg__NextAlternatives_2_0 ) ) )
            // InternalIntegrate.g:3789:2: ( ( rule__PipelineStageTrg__NextAlternatives_2_0 ) )
            {
            // InternalIntegrate.g:3789:2: ( ( rule__PipelineStageTrg__NextAlternatives_2_0 ) )
            // InternalIntegrate.g:3790:3: ( rule__PipelineStageTrg__NextAlternatives_2_0 )
            {
             before(grammarAccess.getPipelineStageTrgAccess().getNextAlternatives_2_0()); 
            // InternalIntegrate.g:3791:3: ( rule__PipelineStageTrg__NextAlternatives_2_0 )
            // InternalIntegrate.g:3791:4: rule__PipelineStageTrg__NextAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageTrg__NextAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageTrgAccess().getNextAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageTrg__NextAssignment_2"


    // $ANTLR start "rule__PipelineStageCreated__NameAssignment_0"
    // InternalIntegrate.g:3799:1: rule__PipelineStageCreated__NameAssignment_0 : ( ( 'created' ) ) ;
    public final void rule__PipelineStageCreated__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3803:1: ( ( ( 'created' ) ) )
            // InternalIntegrate.g:3804:2: ( ( 'created' ) )
            {
            // InternalIntegrate.g:3804:2: ( ( 'created' ) )
            // InternalIntegrate.g:3805:3: ( 'created' )
            {
             before(grammarAccess.getPipelineStageCreatedAccess().getNameCreatedKeyword_0_0()); 
            // InternalIntegrate.g:3806:3: ( 'created' )
            // InternalIntegrate.g:3807:4: 'created'
            {
             before(grammarAccess.getPipelineStageCreatedAccess().getNameCreatedKeyword_0_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getPipelineStageCreatedAccess().getNameCreatedKeyword_0_0()); 

            }

             after(grammarAccess.getPipelineStageCreatedAccess().getNameCreatedKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__NameAssignment_0"


    // $ANTLR start "rule__PipelineStageCreated__NextAssignment_2"
    // InternalIntegrate.g:3818:1: rule__PipelineStageCreated__NextAssignment_2 : ( ( rule__PipelineStageCreated__NextAlternatives_2_0 ) ) ;
    public final void rule__PipelineStageCreated__NextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3822:1: ( ( ( rule__PipelineStageCreated__NextAlternatives_2_0 ) ) )
            // InternalIntegrate.g:3823:2: ( ( rule__PipelineStageCreated__NextAlternatives_2_0 ) )
            {
            // InternalIntegrate.g:3823:2: ( ( rule__PipelineStageCreated__NextAlternatives_2_0 ) )
            // InternalIntegrate.g:3824:3: ( rule__PipelineStageCreated__NextAlternatives_2_0 )
            {
             before(grammarAccess.getPipelineStageCreatedAccess().getNextAlternatives_2_0()); 
            // InternalIntegrate.g:3825:3: ( rule__PipelineStageCreated__NextAlternatives_2_0 )
            // InternalIntegrate.g:3825:4: rule__PipelineStageCreated__NextAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageCreated__NextAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageCreatedAccess().getNextAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCreated__NextAssignment_2"


    // $ANTLR start "rule__PipelineStageDeleted__NameAssignment_0"
    // InternalIntegrate.g:3833:1: rule__PipelineStageDeleted__NameAssignment_0 : ( ( 'deleted' ) ) ;
    public final void rule__PipelineStageDeleted__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3837:1: ( ( ( 'deleted' ) ) )
            // InternalIntegrate.g:3838:2: ( ( 'deleted' ) )
            {
            // InternalIntegrate.g:3838:2: ( ( 'deleted' ) )
            // InternalIntegrate.g:3839:3: ( 'deleted' )
            {
             before(grammarAccess.getPipelineStageDeletedAccess().getNameDeletedKeyword_0_0()); 
            // InternalIntegrate.g:3840:3: ( 'deleted' )
            // InternalIntegrate.g:3841:4: 'deleted'
            {
             before(grammarAccess.getPipelineStageDeletedAccess().getNameDeletedKeyword_0_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getPipelineStageDeletedAccess().getNameDeletedKeyword_0_0()); 

            }

             after(grammarAccess.getPipelineStageDeletedAccess().getNameDeletedKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__NameAssignment_0"


    // $ANTLR start "rule__PipelineStageDeleted__NextAssignment_2"
    // InternalIntegrate.g:3852:1: rule__PipelineStageDeleted__NextAssignment_2 : ( ( rule__PipelineStageDeleted__NextAlternatives_2_0 ) ) ;
    public final void rule__PipelineStageDeleted__NextAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3856:1: ( ( ( rule__PipelineStageDeleted__NextAlternatives_2_0 ) ) )
            // InternalIntegrate.g:3857:2: ( ( rule__PipelineStageDeleted__NextAlternatives_2_0 ) )
            {
            // InternalIntegrate.g:3857:2: ( ( rule__PipelineStageDeleted__NextAlternatives_2_0 ) )
            // InternalIntegrate.g:3858:3: ( rule__PipelineStageDeleted__NextAlternatives_2_0 )
            {
             before(grammarAccess.getPipelineStageDeletedAccess().getNextAlternatives_2_0()); 
            // InternalIntegrate.g:3859:3: ( rule__PipelineStageDeleted__NextAlternatives_2_0 )
            // InternalIntegrate.g:3859:4: rule__PipelineStageDeleted__NextAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__PipelineStageDeleted__NextAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getPipelineStageDeletedAccess().getNextAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageDeleted__NextAssignment_2"


    // $ANTLR start "rule__PipelineStageType__NameAssignment_0"
    // InternalIntegrate.g:3867:1: rule__PipelineStageType__NameAssignment_0 : ( ( 'type' ) ) ;
    public final void rule__PipelineStageType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3871:1: ( ( ( 'type' ) ) )
            // InternalIntegrate.g:3872:2: ( ( 'type' ) )
            {
            // InternalIntegrate.g:3872:2: ( ( 'type' ) )
            // InternalIntegrate.g:3873:3: ( 'type' )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getNameTypeKeyword_0_0()); 
            // InternalIntegrate.g:3874:3: ( 'type' )
            // InternalIntegrate.g:3875:4: 'type'
            {
             before(grammarAccess.getPipelineStageTypeAccess().getNameTypeKeyword_0_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTypeAccess().getNameTypeKeyword_0_0()); 

            }

             after(grammarAccess.getPipelineStageTypeAccess().getNameTypeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__NameAssignment_0"


    // $ANTLR start "rule__PipelineStageType__TypesAssignment_1"
    // InternalIntegrate.g:3886:1: rule__PipelineStageType__TypesAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__PipelineStageType__TypesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3890:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:3891:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:3891:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:3892:3: ( RULE_ID )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getTypesEClassCrossReference_1_0()); 
            // InternalIntegrate.g:3893:3: ( RULE_ID )
            // InternalIntegrate.g:3894:4: RULE_ID
            {
             before(grammarAccess.getPipelineStageTypeAccess().getTypesEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTypeAccess().getTypesEClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getPipelineStageTypeAccess().getTypesEClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__TypesAssignment_1"


    // $ANTLR start "rule__PipelineStageType__TypesAssignment_2_1"
    // InternalIntegrate.g:3905:1: rule__PipelineStageType__TypesAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__PipelineStageType__TypesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3909:1: ( ( ( RULE_ID ) ) )
            // InternalIntegrate.g:3910:2: ( ( RULE_ID ) )
            {
            // InternalIntegrate.g:3910:2: ( ( RULE_ID ) )
            // InternalIntegrate.g:3911:3: ( RULE_ID )
            {
             before(grammarAccess.getPipelineStageTypeAccess().getTypesEClassCrossReference_2_1_0()); 
            // InternalIntegrate.g:3912:3: ( RULE_ID )
            // InternalIntegrate.g:3913:4: RULE_ID
            {
             before(grammarAccess.getPipelineStageTypeAccess().getTypesEClassIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getPipelineStageTypeAccess().getTypesEClassIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getPipelineStageTypeAccess().getTypesEClassCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__TypesAssignment_2_1"


    // $ANTLR start "rule__PipelineStageType__NextAssignment_4"
    // InternalIntegrate.g:3924:1: rule__PipelineStageType__NextAssignment_4 : ( rulePipelineStageEnd ) ;
    public final void rule__PipelineStageType__NextAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3928:1: ( ( rulePipelineStageEnd ) )
            // InternalIntegrate.g:3929:2: ( rulePipelineStageEnd )
            {
            // InternalIntegrate.g:3929:2: ( rulePipelineStageEnd )
            // InternalIntegrate.g:3930:3: rulePipelineStageEnd
            {
             before(grammarAccess.getPipelineStageTypeAccess().getNextPipelineStageEndParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            rulePipelineStageEnd();

            state._fsp--;

             after(grammarAccess.getPipelineStageTypeAccess().getNextPipelineStageEndParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageType__NextAssignment_4"


    // $ANTLR start "rule__PipelineStageCount__NameAssignment"
    // InternalIntegrate.g:3939:1: rule__PipelineStageCount__NameAssignment : ( ( 'count' ) ) ;
    public final void rule__PipelineStageCount__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3943:1: ( ( ( 'count' ) ) )
            // InternalIntegrate.g:3944:2: ( ( 'count' ) )
            {
            // InternalIntegrate.g:3944:2: ( ( 'count' ) )
            // InternalIntegrate.g:3945:3: ( 'count' )
            {
             before(grammarAccess.getPipelineStageCountAccess().getNameCountKeyword_0()); 
            // InternalIntegrate.g:3946:3: ( 'count' )
            // InternalIntegrate.g:3947:4: 'count'
            {
             before(grammarAccess.getPipelineStageCountAccess().getNameCountKeyword_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getPipelineStageCountAccess().getNameCountKeyword_0()); 

            }

             after(grammarAccess.getPipelineStageCountAccess().getNameCountKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageCount__NameAssignment"


    // $ANTLR start "rule__PipelineStageExists__NameAssignment"
    // InternalIntegrate.g:3958:1: rule__PipelineStageExists__NameAssignment : ( ( 'exists' ) ) ;
    public final void rule__PipelineStageExists__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3962:1: ( ( ( 'exists' ) ) )
            // InternalIntegrate.g:3963:2: ( ( 'exists' ) )
            {
            // InternalIntegrate.g:3963:2: ( ( 'exists' ) )
            // InternalIntegrate.g:3964:3: ( 'exists' )
            {
             before(grammarAccess.getPipelineStageExistsAccess().getNameExistsKeyword_0()); 
            // InternalIntegrate.g:3965:3: ( 'exists' )
            // InternalIntegrate.g:3966:4: 'exists'
            {
             before(grammarAccess.getPipelineStageExistsAccess().getNameExistsKeyword_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getPipelineStageExistsAccess().getNameExistsKeyword_0()); 

            }

             after(grammarAccess.getPipelineStageExistsAccess().getNameExistsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PipelineStageExists__NameAssignment"


    // $ANTLR start "rule__SatisfactionRule__ExpressionAssignment"
    // InternalIntegrate.g:3977:1: rule__SatisfactionRule__ExpressionAssignment : ( ruleOrExpression ) ;
    public final void rule__SatisfactionRule__ExpressionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3981:1: ( ( ruleOrExpression ) )
            // InternalIntegrate.g:3982:2: ( ruleOrExpression )
            {
            // InternalIntegrate.g:3982:2: ( ruleOrExpression )
            // InternalIntegrate.g:3983:3: ruleOrExpression
            {
             before(grammarAccess.getSatisfactionRuleAccess().getExpressionOrExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getSatisfactionRuleAccess().getExpressionOrExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SatisfactionRule__ExpressionAssignment"


    // $ANTLR start "rule__OrExpression__RightAssignment_1_2"
    // InternalIntegrate.g:3992:1: rule__OrExpression__RightAssignment_1_2 : ( ruleAndExpression ) ;
    public final void rule__OrExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:3996:1: ( ( ruleAndExpression ) )
            // InternalIntegrate.g:3997:2: ( ruleAndExpression )
            {
            // InternalIntegrate.g:3997:2: ( ruleAndExpression )
            // InternalIntegrate.g:3998:3: ruleAndExpression
            {
             before(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAndExpression();

            state._fsp--;

             after(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrExpression__RightAssignment_1_2"


    // $ANTLR start "rule__AndExpression__RightAssignment_1_2"
    // InternalIntegrate.g:4007:1: rule__AndExpression__RightAssignment_1_2 : ( ruleBooleanExpression ) ;
    public final void rule__AndExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4011:1: ( ( ruleBooleanExpression ) )
            // InternalIntegrate.g:4012:2: ( ruleBooleanExpression )
            {
            // InternalIntegrate.g:4012:2: ( ruleBooleanExpression )
            // InternalIntegrate.g:4013:3: ruleBooleanExpression
            {
             before(grammarAccess.getAndExpressionAccess().getRightBooleanExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanExpression();

            state._fsp--;

             after(grammarAccess.getAndExpressionAccess().getRightBooleanExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndExpression__RightAssignment_1_2"


    // $ANTLR start "rule__BooleanExpression__InvertAssignment_0"
    // InternalIntegrate.g:4022:1: rule__BooleanExpression__InvertAssignment_0 : ( ( 'not' ) ) ;
    public final void rule__BooleanExpression__InvertAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4026:1: ( ( ( 'not' ) ) )
            // InternalIntegrate.g:4027:2: ( ( 'not' ) )
            {
            // InternalIntegrate.g:4027:2: ( ( 'not' ) )
            // InternalIntegrate.g:4028:3: ( 'not' )
            {
             before(grammarAccess.getBooleanExpressionAccess().getInvertNotKeyword_0_0()); 
            // InternalIntegrate.g:4029:3: ( 'not' )
            // InternalIntegrate.g:4030:4: 'not'
            {
             before(grammarAccess.getBooleanExpressionAccess().getInvertNotKeyword_0_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getBooleanExpressionAccess().getInvertNotKeyword_0_0()); 

            }

             after(grammarAccess.getBooleanExpressionAccess().getInvertNotKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__InvertAssignment_0"


    // $ANTLR start "rule__BooleanExpression__ExpressionAssignment_1"
    // InternalIntegrate.g:4041:1: rule__BooleanExpression__ExpressionAssignment_1 : ( ( rule__BooleanExpression__ExpressionAlternatives_1_0 ) ) ;
    public final void rule__BooleanExpression__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4045:1: ( ( ( rule__BooleanExpression__ExpressionAlternatives_1_0 ) ) )
            // InternalIntegrate.g:4046:2: ( ( rule__BooleanExpression__ExpressionAlternatives_1_0 ) )
            {
            // InternalIntegrate.g:4046:2: ( ( rule__BooleanExpression__ExpressionAlternatives_1_0 ) )
            // InternalIntegrate.g:4047:3: ( rule__BooleanExpression__ExpressionAlternatives_1_0 )
            {
             before(grammarAccess.getBooleanExpressionAccess().getExpressionAlternatives_1_0()); 
            // InternalIntegrate.g:4048:3: ( rule__BooleanExpression__ExpressionAlternatives_1_0 )
            // InternalIntegrate.g:4048:4: rule__BooleanExpression__ExpressionAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExpression__ExpressionAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanExpressionAccess().getExpressionAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExpression__ExpressionAssignment_1"


    // $ANTLR start "rule__WrappedOrExpression__ExpressionAssignment_1"
    // InternalIntegrate.g:4056:1: rule__WrappedOrExpression__ExpressionAssignment_1 : ( ruleOrExpression ) ;
    public final void rule__WrappedOrExpression__ExpressionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4060:1: ( ( ruleOrExpression ) )
            // InternalIntegrate.g:4061:2: ( ruleOrExpression )
            {
            // InternalIntegrate.g:4061:2: ( ruleOrExpression )
            // InternalIntegrate.g:4062:3: ruleOrExpression
            {
             before(grammarAccess.getWrappedOrExpressionAccess().getExpressionOrExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOrExpression();

            state._fsp--;

             after(grammarAccess.getWrappedOrExpressionAccess().getExpressionOrExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WrappedOrExpression__ExpressionAssignment_1"


    // $ANTLR start "rule__ComparisonExpression__LhsAssignment_0"
    // InternalIntegrate.g:4071:1: rule__ComparisonExpression__LhsAssignment_0 : ( ruleComparisonParameter ) ;
    public final void rule__ComparisonExpression__LhsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4075:1: ( ( ruleComparisonParameter ) )
            // InternalIntegrate.g:4076:2: ( ruleComparisonParameter )
            {
            // InternalIntegrate.g:4076:2: ( ruleComparisonParameter )
            // InternalIntegrate.g:4077:3: ruleComparisonParameter
            {
             before(grammarAccess.getComparisonExpressionAccess().getLhsComparisonParameterParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonParameter();

            state._fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getLhsComparisonParameterParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__LhsAssignment_0"


    // $ANTLR start "rule__ComparisonExpression__OpAssignment_1"
    // InternalIntegrate.g:4086:1: rule__ComparisonExpression__OpAssignment_1 : ( ( rule__ComparisonExpression__OpAlternatives_1_0 ) ) ;
    public final void rule__ComparisonExpression__OpAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4090:1: ( ( ( rule__ComparisonExpression__OpAlternatives_1_0 ) ) )
            // InternalIntegrate.g:4091:2: ( ( rule__ComparisonExpression__OpAlternatives_1_0 ) )
            {
            // InternalIntegrate.g:4091:2: ( ( rule__ComparisonExpression__OpAlternatives_1_0 ) )
            // InternalIntegrate.g:4092:3: ( rule__ComparisonExpression__OpAlternatives_1_0 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getOpAlternatives_1_0()); 
            // InternalIntegrate.g:4093:3: ( rule__ComparisonExpression__OpAlternatives_1_0 )
            // InternalIntegrate.g:4093:4: rule__ComparisonExpression__OpAlternatives_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonExpression__OpAlternatives_1_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getOpAlternatives_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__OpAssignment_1"


    // $ANTLR start "rule__ComparisonExpression__RhsAssignment_2"
    // InternalIntegrate.g:4101:1: rule__ComparisonExpression__RhsAssignment_2 : ( ruleComparisonParameter ) ;
    public final void rule__ComparisonExpression__RhsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4105:1: ( ( ruleComparisonParameter ) )
            // InternalIntegrate.g:4106:2: ( ruleComparisonParameter )
            {
            // InternalIntegrate.g:4106:2: ( ruleComparisonParameter )
            // InternalIntegrate.g:4107:3: ruleComparisonParameter
            {
             before(grammarAccess.getComparisonExpressionAccess().getRhsComparisonParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonParameter();

            state._fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getRhsComparisonParameterParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonExpression__RhsAssignment_2"


    // $ANTLR start "rule__LiteralValue__ValueAssignment"
    // InternalIntegrate.g:4116:1: rule__LiteralValue__ValueAssignment : ( RULE_INT ) ;
    public final void rule__LiteralValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4120:1: ( ( RULE_INT ) )
            // InternalIntegrate.g:4121:2: ( RULE_INT )
            {
            // InternalIntegrate.g:4121:2: ( RULE_INT )
            // InternalIntegrate.g:4122:3: RULE_INT
            {
             before(grammarAccess.getLiteralValueAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getLiteralValueAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LiteralValue__ValueAssignment"


    // $ANTLR start "rule__Resolution__StrategiesAssignment_0"
    // InternalIntegrate.g:4131:1: rule__Resolution__StrategiesAssignment_0 : ( ruleResolutionStrategyWithOperationalDelta ) ;
    public final void rule__Resolution__StrategiesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4135:1: ( ( ruleResolutionStrategyWithOperationalDelta ) )
            // InternalIntegrate.g:4136:2: ( ruleResolutionStrategyWithOperationalDelta )
            {
            // InternalIntegrate.g:4136:2: ( ruleResolutionStrategyWithOperationalDelta )
            // InternalIntegrate.g:4137:3: ruleResolutionStrategyWithOperationalDelta
            {
             before(grammarAccess.getResolutionAccess().getStrategiesResolutionStrategyWithOperationalDeltaParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleResolutionStrategyWithOperationalDelta();

            state._fsp--;

             after(grammarAccess.getResolutionAccess().getStrategiesResolutionStrategyWithOperationalDeltaParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__StrategiesAssignment_0"


    // $ANTLR start "rule__Resolution__StrategiesAssignment_1_1"
    // InternalIntegrate.g:4146:1: rule__Resolution__StrategiesAssignment_1_1 : ( ruleResolutionStrategyWithOperationalDelta ) ;
    public final void rule__Resolution__StrategiesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4150:1: ( ( ruleResolutionStrategyWithOperationalDelta ) )
            // InternalIntegrate.g:4151:2: ( ruleResolutionStrategyWithOperationalDelta )
            {
            // InternalIntegrate.g:4151:2: ( ruleResolutionStrategyWithOperationalDelta )
            // InternalIntegrate.g:4152:3: ruleResolutionStrategyWithOperationalDelta
            {
             before(grammarAccess.getResolutionAccess().getStrategiesResolutionStrategyWithOperationalDeltaParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleResolutionStrategyWithOperationalDelta();

            state._fsp--;

             after(grammarAccess.getResolutionAccess().getStrategiesResolutionStrategyWithOperationalDeltaParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__StrategiesAssignment_1_1"


    // $ANTLR start "rule__Resolution__FallbackAssignment_2"
    // InternalIntegrate.g:4161:1: rule__Resolution__FallbackAssignment_2 : ( ruleFallbackResolutionStrategy ) ;
    public final void rule__Resolution__FallbackAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4165:1: ( ( ruleFallbackResolutionStrategy ) )
            // InternalIntegrate.g:4166:2: ( ruleFallbackResolutionStrategy )
            {
            // InternalIntegrate.g:4166:2: ( ruleFallbackResolutionStrategy )
            // InternalIntegrate.g:4167:3: ruleFallbackResolutionStrategy
            {
             before(grammarAccess.getResolutionAccess().getFallbackFallbackResolutionStrategyParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleFallbackResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getResolutionAccess().getFallbackFallbackResolutionStrategyParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Resolution__FallbackAssignment_2"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0"
    // InternalIntegrate.g:4176:1: rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0 : ( ruleResolutionStrategy ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4180:1: ( ( ruleResolutionStrategy ) )
            // InternalIntegrate.g:4181:2: ( ruleResolutionStrategy )
            {
            // InternalIntegrate.g:4181:2: ( ruleResolutionStrategy )
            // InternalIntegrate.g:4182:3: ruleResolutionStrategy
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getStrategyResolutionStrategyParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleResolutionStrategy();

            state._fsp--;

             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getStrategyResolutionStrategyParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__StrategyAssignment_0"


    // $ANTLR start "rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2"
    // InternalIntegrate.g:4191:1: rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2 : ( ruleOperationalDelta ) ;
    public final void rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4195:1: ( ( ruleOperationalDelta ) )
            // InternalIntegrate.g:4196:2: ( ruleOperationalDelta )
            {
            // InternalIntegrate.g:4196:2: ( ruleOperationalDelta )
            // InternalIntegrate.g:4197:3: ruleOperationalDelta
            {
             before(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getOperationalDeltaOperationalDeltaParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOperationalDelta();

            state._fsp--;

             after(grammarAccess.getResolutionStrategyWithOperationalDeltaAccess().getOperationalDeltaOperationalDeltaParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResolutionStrategyWithOperationalDelta__OperationalDeltaAssignment_1_2"


    // $ANTLR start "rule__MergeAndPreserveResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:4206:1: rule__MergeAndPreserveResolutionStrategy__NameAssignment : ( ( 'mergeAndPreserve' ) ) ;
    public final void rule__MergeAndPreserveResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4210:1: ( ( ( 'mergeAndPreserve' ) ) )
            // InternalIntegrate.g:4211:2: ( ( 'mergeAndPreserve' ) )
            {
            // InternalIntegrate.g:4211:2: ( ( 'mergeAndPreserve' ) )
            // InternalIntegrate.g:4212:3: ( 'mergeAndPreserve' )
            {
             before(grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0()); 
            // InternalIntegrate.g:4213:3: ( 'mergeAndPreserve' )
            // InternalIntegrate.g:4214:4: 'mergeAndPreserve'
            {
             before(grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0()); 

            }

             after(grammarAccess.getMergeAndPreserveResolutionStrategyAccess().getNameMergeAndPreserveKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MergeAndPreserveResolutionStrategy__NameAssignment"


    // $ANTLR start "rule__RevokeAdditionResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:4225:1: rule__RevokeAdditionResolutionStrategy__NameAssignment : ( ( 'revokeAddition' ) ) ;
    public final void rule__RevokeAdditionResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4229:1: ( ( ( 'revokeAddition' ) ) )
            // InternalIntegrate.g:4230:2: ( ( 'revokeAddition' ) )
            {
            // InternalIntegrate.g:4230:2: ( ( 'revokeAddition' ) )
            // InternalIntegrate.g:4231:3: ( 'revokeAddition' )
            {
             before(grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameRevokeAdditionKeyword_0()); 
            // InternalIntegrate.g:4232:3: ( 'revokeAddition' )
            // InternalIntegrate.g:4233:4: 'revokeAddition'
            {
             before(grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameRevokeAdditionKeyword_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameRevokeAdditionKeyword_0()); 

            }

             after(grammarAccess.getRevokeAdditionResolutionStrategyAccess().getNameRevokeAdditionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RevokeAdditionResolutionStrategy__NameAssignment"


    // $ANTLR start "rule__RevokeDeletionResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:4244:1: rule__RevokeDeletionResolutionStrategy__NameAssignment : ( ( 'revokeDeletion' ) ) ;
    public final void rule__RevokeDeletionResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4248:1: ( ( ( 'revokeDeletion' ) ) )
            // InternalIntegrate.g:4249:2: ( ( 'revokeDeletion' ) )
            {
            // InternalIntegrate.g:4249:2: ( ( 'revokeDeletion' ) )
            // InternalIntegrate.g:4250:3: ( 'revokeDeletion' )
            {
             before(grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameRevokeDeletionKeyword_0()); 
            // InternalIntegrate.g:4251:3: ( 'revokeDeletion' )
            // InternalIntegrate.g:4252:4: 'revokeDeletion'
            {
             before(grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameRevokeDeletionKeyword_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameRevokeDeletionKeyword_0()); 

            }

             after(grammarAccess.getRevokeDeletionResolutionStrategyAccess().getNameRevokeDeletionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RevokeDeletionResolutionStrategy__NameAssignment"


    // $ANTLR start "rule__PreferSourceResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:4263:1: rule__PreferSourceResolutionStrategy__NameAssignment : ( ( 'preferSource' ) ) ;
    public final void rule__PreferSourceResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4267:1: ( ( ( 'preferSource' ) ) )
            // InternalIntegrate.g:4268:2: ( ( 'preferSource' ) )
            {
            // InternalIntegrate.g:4268:2: ( ( 'preferSource' ) )
            // InternalIntegrate.g:4269:3: ( 'preferSource' )
            {
             before(grammarAccess.getPreferSourceResolutionStrategyAccess().getNamePreferSourceKeyword_0()); 
            // InternalIntegrate.g:4270:3: ( 'preferSource' )
            // InternalIntegrate.g:4271:4: 'preferSource'
            {
             before(grammarAccess.getPreferSourceResolutionStrategyAccess().getNamePreferSourceKeyword_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getPreferSourceResolutionStrategyAccess().getNamePreferSourceKeyword_0()); 

            }

             after(grammarAccess.getPreferSourceResolutionStrategyAccess().getNamePreferSourceKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PreferSourceResolutionStrategy__NameAssignment"


    // $ANTLR start "rule__PreferTargetResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:4282:1: rule__PreferTargetResolutionStrategy__NameAssignment : ( ( 'preferTarget' ) ) ;
    public final void rule__PreferTargetResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4286:1: ( ( ( 'preferTarget' ) ) )
            // InternalIntegrate.g:4287:2: ( ( 'preferTarget' ) )
            {
            // InternalIntegrate.g:4287:2: ( ( 'preferTarget' ) )
            // InternalIntegrate.g:4288:3: ( 'preferTarget' )
            {
             before(grammarAccess.getPreferTargetResolutionStrategyAccess().getNamePreferTargetKeyword_0()); 
            // InternalIntegrate.g:4289:3: ( 'preferTarget' )
            // InternalIntegrate.g:4290:4: 'preferTarget'
            {
             before(grammarAccess.getPreferTargetResolutionStrategyAccess().getNamePreferTargetKeyword_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getPreferTargetResolutionStrategyAccess().getNamePreferTargetKeyword_0()); 

            }

             after(grammarAccess.getPreferTargetResolutionStrategyAccess().getNamePreferTargetKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PreferTargetResolutionStrategy__NameAssignment"


    // $ANTLR start "rule__DeleteCorrespondencesResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:4301:1: rule__DeleteCorrespondencesResolutionStrategy__NameAssignment : ( ( 'deleteCorrespondences' ) ) ;
    public final void rule__DeleteCorrespondencesResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4305:1: ( ( ( 'deleteCorrespondences' ) ) )
            // InternalIntegrate.g:4306:2: ( ( 'deleteCorrespondences' ) )
            {
            // InternalIntegrate.g:4306:2: ( ( 'deleteCorrespondences' ) )
            // InternalIntegrate.g:4307:3: ( 'deleteCorrespondences' )
            {
             before(grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameDeleteCorrespondencesKeyword_0()); 
            // InternalIntegrate.g:4308:3: ( 'deleteCorrespondences' )
            // InternalIntegrate.g:4309:4: 'deleteCorrespondences'
            {
             before(grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameDeleteCorrespondencesKeyword_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameDeleteCorrespondencesKeyword_0()); 

            }

             after(grammarAccess.getDeleteCorrespondencesResolutionStrategyAccess().getNameDeleteCorrespondencesKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DeleteCorrespondencesResolutionStrategy__NameAssignment"


    // $ANTLR start "rule__ContinueResolutionStrategy__NameAssignment"
    // InternalIntegrate.g:4320:1: rule__ContinueResolutionStrategy__NameAssignment : ( ( 'continue' ) ) ;
    public final void rule__ContinueResolutionStrategy__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4324:1: ( ( ( 'continue' ) ) )
            // InternalIntegrate.g:4325:2: ( ( 'continue' ) )
            {
            // InternalIntegrate.g:4325:2: ( ( 'continue' ) )
            // InternalIntegrate.g:4326:3: ( 'continue' )
            {
             before(grammarAccess.getContinueResolutionStrategyAccess().getNameContinueKeyword_0()); 
            // InternalIntegrate.g:4327:3: ( 'continue' )
            // InternalIntegrate.g:4328:4: 'continue'
            {
             before(grammarAccess.getContinueResolutionStrategyAccess().getNameContinueKeyword_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getContinueResolutionStrategyAccess().getNameContinueKeyword_0()); 

            }

             after(grammarAccess.getContinueResolutionStrategyAccess().getNameContinueKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ContinueResolutionStrategy__NameAssignment"


    // $ANTLR start "rule__OperationalDelta__VariablesAssignment_0"
    // InternalIntegrate.g:4339:1: rule__OperationalDelta__VariablesAssignment_0 : ( ruleVariable ) ;
    public final void rule__OperationalDelta__VariablesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4343:1: ( ( ruleVariable ) )
            // InternalIntegrate.g:4344:2: ( ruleVariable )
            {
            // InternalIntegrate.g:4344:2: ( ruleVariable )
            // InternalIntegrate.g:4345:3: ruleVariable
            {
             before(grammarAccess.getOperationalDeltaAccess().getVariablesVariableParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getOperationalDeltaAccess().getVariablesVariableParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__VariablesAssignment_0"


    // $ANTLR start "rule__OperationalDelta__RuleAssignment_3"
    // InternalIntegrate.g:4354:1: rule__OperationalDelta__RuleAssignment_3 : ( ruleSatisfactionRule ) ;
    public final void rule__OperationalDelta__RuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalIntegrate.g:4358:1: ( ( ruleSatisfactionRule ) )
            // InternalIntegrate.g:4359:2: ( ruleSatisfactionRule )
            {
            // InternalIntegrate.g:4359:2: ( ruleSatisfactionRule )
            // InternalIntegrate.g:4360:3: ruleSatisfactionRule
            {
             before(grammarAccess.getOperationalDeltaAccess().getRuleSatisfactionRuleParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleSatisfactionRule();

            state._fsp--;

             after(grammarAccess.getOperationalDeltaAccess().getRuleSatisfactionRuleParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationalDelta__RuleAssignment_3"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000040100000030L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0003F80000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000001800000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000003E000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x000000000001F800L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0003F80040000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000400000000L});

}