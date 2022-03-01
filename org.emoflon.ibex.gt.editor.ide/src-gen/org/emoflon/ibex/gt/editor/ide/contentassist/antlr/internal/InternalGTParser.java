package org.emoflon.ibex.gt.editor.ide.contentassist.antlr.internal;

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
import org.emoflon.ibex.gt.editor.services.GTGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGTParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_INT", "RULE_STRING", "RULE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'pattern'", "'rule'", "'$context'", "'++'", "'--'", "'>'", "'>='", "'=='", "'!='", "'<='", "'<'", "'enforce'", "'forbid'", "'+'", "'-'", "'N'", "'U'", "'Exp'", "'*'", "'/'", "'%'", "'min'", "'max'", "'sqrt'", "'abs'", "'sin'", "'cos'", "'tan'", "'exp'", "'log'", "'ln'", "'import'", "'('", "')'", "','", "'refines'", "'{'", "'}'", "'when'", "'||'", "':'", "'#'", "'.'", "':='", "'count'", "'enum::'", "'param::'", "'->'", "'forEach'", "'iterator::'", "'condition'", "'='", "'&&'", "'^'", "'abstract'", "'@'", "'local'"
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
    public static final int RULE_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=4;
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
    public static final int RULE_STRING=5;
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

    	public void setGrammarAccess(GTGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleEditorGTFile"
    // InternalGT.g:53:1: entryRuleEditorGTFile : ruleEditorGTFile EOF ;
    public final void entryRuleEditorGTFile() throws RecognitionException {
        try {
            // InternalGT.g:54:1: ( ruleEditorGTFile EOF )
            // InternalGT.g:55:1: ruleEditorGTFile EOF
            {
             before(grammarAccess.getEditorGTFileRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorGTFile();

            state._fsp--;

             after(grammarAccess.getEditorGTFileRule()); 
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
    // $ANTLR end "entryRuleEditorGTFile"


    // $ANTLR start "ruleEditorGTFile"
    // InternalGT.g:62:1: ruleEditorGTFile : ( ( rule__EditorGTFile__Group__0 ) ) ;
    public final void ruleEditorGTFile() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:66:2: ( ( ( rule__EditorGTFile__Group__0 ) ) )
            // InternalGT.g:67:2: ( ( rule__EditorGTFile__Group__0 ) )
            {
            // InternalGT.g:67:2: ( ( rule__EditorGTFile__Group__0 ) )
            // InternalGT.g:68:3: ( rule__EditorGTFile__Group__0 )
            {
             before(grammarAccess.getEditorGTFileAccess().getGroup()); 
            // InternalGT.g:69:3: ( rule__EditorGTFile__Group__0 )
            // InternalGT.g:69:4: rule__EditorGTFile__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorGTFile__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorGTFileAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorGTFile"


    // $ANTLR start "entryRuleEditorImport"
    // InternalGT.g:78:1: entryRuleEditorImport : ruleEditorImport EOF ;
    public final void entryRuleEditorImport() throws RecognitionException {
        try {
            // InternalGT.g:79:1: ( ruleEditorImport EOF )
            // InternalGT.g:80:1: ruleEditorImport EOF
            {
             before(grammarAccess.getEditorImportRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorImport();

            state._fsp--;

             after(grammarAccess.getEditorImportRule()); 
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
    // $ANTLR end "entryRuleEditorImport"


    // $ANTLR start "ruleEditorImport"
    // InternalGT.g:87:1: ruleEditorImport : ( ( rule__EditorImport__Group__0 ) ) ;
    public final void ruleEditorImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:91:2: ( ( ( rule__EditorImport__Group__0 ) ) )
            // InternalGT.g:92:2: ( ( rule__EditorImport__Group__0 ) )
            {
            // InternalGT.g:92:2: ( ( rule__EditorImport__Group__0 ) )
            // InternalGT.g:93:3: ( rule__EditorImport__Group__0 )
            {
             before(grammarAccess.getEditorImportAccess().getGroup()); 
            // InternalGT.g:94:3: ( rule__EditorImport__Group__0 )
            // InternalGT.g:94:4: rule__EditorImport__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorImport__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorImport"


    // $ANTLR start "entryRuleEditorPattern"
    // InternalGT.g:103:1: entryRuleEditorPattern : ruleEditorPattern EOF ;
    public final void entryRuleEditorPattern() throws RecognitionException {
        try {
            // InternalGT.g:104:1: ( ruleEditorPattern EOF )
            // InternalGT.g:105:1: ruleEditorPattern EOF
            {
             before(grammarAccess.getEditorPatternRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorPattern();

            state._fsp--;

             after(grammarAccess.getEditorPatternRule()); 
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
    // $ANTLR end "entryRuleEditorPattern"


    // $ANTLR start "ruleEditorPattern"
    // InternalGT.g:112:1: ruleEditorPattern : ( ( rule__EditorPattern__Group__0 ) ) ;
    public final void ruleEditorPattern() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:116:2: ( ( ( rule__EditorPattern__Group__0 ) ) )
            // InternalGT.g:117:2: ( ( rule__EditorPattern__Group__0 ) )
            {
            // InternalGT.g:117:2: ( ( rule__EditorPattern__Group__0 ) )
            // InternalGT.g:118:3: ( rule__EditorPattern__Group__0 )
            {
             before(grammarAccess.getEditorPatternAccess().getGroup()); 
            // InternalGT.g:119:3: ( rule__EditorPattern__Group__0 )
            // InternalGT.g:119:4: rule__EditorPattern__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorPattern"


    // $ANTLR start "entryRuleEditorParameter"
    // InternalGT.g:128:1: entryRuleEditorParameter : ruleEditorParameter EOF ;
    public final void entryRuleEditorParameter() throws RecognitionException {
        try {
            // InternalGT.g:129:1: ( ruleEditorParameter EOF )
            // InternalGT.g:130:1: ruleEditorParameter EOF
            {
             before(grammarAccess.getEditorParameterRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorParameter();

            state._fsp--;

             after(grammarAccess.getEditorParameterRule()); 
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
    // $ANTLR end "entryRuleEditorParameter"


    // $ANTLR start "ruleEditorParameter"
    // InternalGT.g:137:1: ruleEditorParameter : ( ( rule__EditorParameter__Group__0 ) ) ;
    public final void ruleEditorParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:141:2: ( ( ( rule__EditorParameter__Group__0 ) ) )
            // InternalGT.g:142:2: ( ( rule__EditorParameter__Group__0 ) )
            {
            // InternalGT.g:142:2: ( ( rule__EditorParameter__Group__0 ) )
            // InternalGT.g:143:3: ( rule__EditorParameter__Group__0 )
            {
             before(grammarAccess.getEditorParameterAccess().getGroup()); 
            // InternalGT.g:144:3: ( rule__EditorParameter__Group__0 )
            // InternalGT.g:144:4: rule__EditorParameter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorParameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorParameter"


    // $ANTLR start "entryRuleEditorNode"
    // InternalGT.g:153:1: entryRuleEditorNode : ruleEditorNode EOF ;
    public final void entryRuleEditorNode() throws RecognitionException {
        try {
            // InternalGT.g:154:1: ( ruleEditorNode EOF )
            // InternalGT.g:155:1: ruleEditorNode EOF
            {
             before(grammarAccess.getEditorNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorNode();

            state._fsp--;

             after(grammarAccess.getEditorNodeRule()); 
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
    // $ANTLR end "entryRuleEditorNode"


    // $ANTLR start "ruleEditorNode"
    // InternalGT.g:162:1: ruleEditorNode : ( ( rule__EditorNode__Group__0 ) ) ;
    public final void ruleEditorNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:166:2: ( ( ( rule__EditorNode__Group__0 ) ) )
            // InternalGT.g:167:2: ( ( rule__EditorNode__Group__0 ) )
            {
            // InternalGT.g:167:2: ( ( rule__EditorNode__Group__0 ) )
            // InternalGT.g:168:3: ( rule__EditorNode__Group__0 )
            {
             before(grammarAccess.getEditorNodeAccess().getGroup()); 
            // InternalGT.g:169:3: ( rule__EditorNode__Group__0 )
            // InternalGT.g:169:4: rule__EditorNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorNode"


    // $ANTLR start "entryRuleEditorAttributeConstraint"
    // InternalGT.g:178:1: entryRuleEditorAttributeConstraint : ruleEditorAttributeConstraint EOF ;
    public final void entryRuleEditorAttributeConstraint() throws RecognitionException {
        try {
            // InternalGT.g:179:1: ( ruleEditorAttributeConstraint EOF )
            // InternalGT.g:180:1: ruleEditorAttributeConstraint EOF
            {
             before(grammarAccess.getEditorAttributeConstraintRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorAttributeConstraint();

            state._fsp--;

             after(grammarAccess.getEditorAttributeConstraintRule()); 
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
    // $ANTLR end "entryRuleEditorAttributeConstraint"


    // $ANTLR start "ruleEditorAttributeConstraint"
    // InternalGT.g:187:1: ruleEditorAttributeConstraint : ( ( rule__EditorAttributeConstraint__Group__0 ) ) ;
    public final void ruleEditorAttributeConstraint() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:191:2: ( ( ( rule__EditorAttributeConstraint__Group__0 ) ) )
            // InternalGT.g:192:2: ( ( rule__EditorAttributeConstraint__Group__0 ) )
            {
            // InternalGT.g:192:2: ( ( rule__EditorAttributeConstraint__Group__0 ) )
            // InternalGT.g:193:3: ( rule__EditorAttributeConstraint__Group__0 )
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getGroup()); 
            // InternalGT.g:194:3: ( rule__EditorAttributeConstraint__Group__0 )
            // InternalGT.g:194:4: rule__EditorAttributeConstraint__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeConstraintAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorAttributeConstraint"


    // $ANTLR start "entryRuleEditorAttributeAssignment"
    // InternalGT.g:203:1: entryRuleEditorAttributeAssignment : ruleEditorAttributeAssignment EOF ;
    public final void entryRuleEditorAttributeAssignment() throws RecognitionException {
        try {
            // InternalGT.g:204:1: ( ruleEditorAttributeAssignment EOF )
            // InternalGT.g:205:1: ruleEditorAttributeAssignment EOF
            {
             before(grammarAccess.getEditorAttributeAssignmentRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorAttributeAssignment();

            state._fsp--;

             after(grammarAccess.getEditorAttributeAssignmentRule()); 
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
    // $ANTLR end "entryRuleEditorAttributeAssignment"


    // $ANTLR start "ruleEditorAttributeAssignment"
    // InternalGT.g:212:1: ruleEditorAttributeAssignment : ( ( rule__EditorAttributeAssignment__Group__0 ) ) ;
    public final void ruleEditorAttributeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:216:2: ( ( ( rule__EditorAttributeAssignment__Group__0 ) ) )
            // InternalGT.g:217:2: ( ( rule__EditorAttributeAssignment__Group__0 ) )
            {
            // InternalGT.g:217:2: ( ( rule__EditorAttributeAssignment__Group__0 ) )
            // InternalGT.g:218:3: ( rule__EditorAttributeAssignment__Group__0 )
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getGroup()); 
            // InternalGT.g:219:3: ( rule__EditorAttributeAssignment__Group__0 )
            // InternalGT.g:219:4: rule__EditorAttributeAssignment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeAssignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorAttributeAssignment"


    // $ANTLR start "entryRuleEditorExpression"
    // InternalGT.g:228:1: entryRuleEditorExpression : ruleEditorExpression EOF ;
    public final void entryRuleEditorExpression() throws RecognitionException {
        try {
            // InternalGT.g:229:1: ( ruleEditorExpression EOF )
            // InternalGT.g:230:1: ruleEditorExpression EOF
            {
             before(grammarAccess.getEditorExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorExpression();

            state._fsp--;

             after(grammarAccess.getEditorExpressionRule()); 
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
    // $ANTLR end "entryRuleEditorExpression"


    // $ANTLR start "ruleEditorExpression"
    // InternalGT.g:237:1: ruleEditorExpression : ( ( rule__EditorExpression__Alternatives ) ) ;
    public final void ruleEditorExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:241:2: ( ( ( rule__EditorExpression__Alternatives ) ) )
            // InternalGT.g:242:2: ( ( rule__EditorExpression__Alternatives ) )
            {
            // InternalGT.g:242:2: ( ( rule__EditorExpression__Alternatives ) )
            // InternalGT.g:243:3: ( rule__EditorExpression__Alternatives )
            {
             before(grammarAccess.getEditorExpressionAccess().getAlternatives()); 
            // InternalGT.g:244:3: ( rule__EditorExpression__Alternatives )
            // InternalGT.g:244:4: rule__EditorExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorExpression"


    // $ANTLR start "entryRuleEditorAttributeExpression"
    // InternalGT.g:253:1: entryRuleEditorAttributeExpression : ruleEditorAttributeExpression EOF ;
    public final void entryRuleEditorAttributeExpression() throws RecognitionException {
        try {
            // InternalGT.g:254:1: ( ruleEditorAttributeExpression EOF )
            // InternalGT.g:255:1: ruleEditorAttributeExpression EOF
            {
             before(grammarAccess.getEditorAttributeExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorAttributeExpression();

            state._fsp--;

             after(grammarAccess.getEditorAttributeExpressionRule()); 
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
    // $ANTLR end "entryRuleEditorAttributeExpression"


    // $ANTLR start "ruleEditorAttributeExpression"
    // InternalGT.g:262:1: ruleEditorAttributeExpression : ( ( rule__EditorAttributeExpression__Group__0 ) ) ;
    public final void ruleEditorAttributeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:266:2: ( ( ( rule__EditorAttributeExpression__Group__0 ) ) )
            // InternalGT.g:267:2: ( ( rule__EditorAttributeExpression__Group__0 ) )
            {
            // InternalGT.g:267:2: ( ( rule__EditorAttributeExpression__Group__0 ) )
            // InternalGT.g:268:3: ( rule__EditorAttributeExpression__Group__0 )
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getGroup()); 
            // InternalGT.g:269:3: ( rule__EditorAttributeExpression__Group__0 )
            // InternalGT.g:269:4: rule__EditorAttributeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorAttributeExpression"


    // $ANTLR start "entryRuleEditorCountExpression"
    // InternalGT.g:278:1: entryRuleEditorCountExpression : ruleEditorCountExpression EOF ;
    public final void entryRuleEditorCountExpression() throws RecognitionException {
        try {
            // InternalGT.g:279:1: ( ruleEditorCountExpression EOF )
            // InternalGT.g:280:1: ruleEditorCountExpression EOF
            {
             before(grammarAccess.getEditorCountExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorCountExpression();

            state._fsp--;

             after(grammarAccess.getEditorCountExpressionRule()); 
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
    // $ANTLR end "entryRuleEditorCountExpression"


    // $ANTLR start "ruleEditorCountExpression"
    // InternalGT.g:287:1: ruleEditorCountExpression : ( ( rule__EditorCountExpression__Group__0 ) ) ;
    public final void ruleEditorCountExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:291:2: ( ( ( rule__EditorCountExpression__Group__0 ) ) )
            // InternalGT.g:292:2: ( ( rule__EditorCountExpression__Group__0 ) )
            {
            // InternalGT.g:292:2: ( ( rule__EditorCountExpression__Group__0 ) )
            // InternalGT.g:293:3: ( rule__EditorCountExpression__Group__0 )
            {
             before(grammarAccess.getEditorCountExpressionAccess().getGroup()); 
            // InternalGT.g:294:3: ( rule__EditorCountExpression__Group__0 )
            // InternalGT.g:294:4: rule__EditorCountExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorCountExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorCountExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorCountExpression"


    // $ANTLR start "entryRuleEditorLiteralExpression"
    // InternalGT.g:303:1: entryRuleEditorLiteralExpression : ruleEditorLiteralExpression EOF ;
    public final void entryRuleEditorLiteralExpression() throws RecognitionException {
        try {
            // InternalGT.g:304:1: ( ruleEditorLiteralExpression EOF )
            // InternalGT.g:305:1: ruleEditorLiteralExpression EOF
            {
             before(grammarAccess.getEditorLiteralExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorLiteralExpression();

            state._fsp--;

             after(grammarAccess.getEditorLiteralExpressionRule()); 
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
    // $ANTLR end "entryRuleEditorLiteralExpression"


    // $ANTLR start "ruleEditorLiteralExpression"
    // InternalGT.g:312:1: ruleEditorLiteralExpression : ( ( rule__EditorLiteralExpression__Alternatives ) ) ;
    public final void ruleEditorLiteralExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:316:2: ( ( ( rule__EditorLiteralExpression__Alternatives ) ) )
            // InternalGT.g:317:2: ( ( rule__EditorLiteralExpression__Alternatives ) )
            {
            // InternalGT.g:317:2: ( ( rule__EditorLiteralExpression__Alternatives ) )
            // InternalGT.g:318:3: ( rule__EditorLiteralExpression__Alternatives )
            {
             before(grammarAccess.getEditorLiteralExpressionAccess().getAlternatives()); 
            // InternalGT.g:319:3: ( rule__EditorLiteralExpression__Alternatives )
            // InternalGT.g:319:4: rule__EditorLiteralExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorLiteralExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorLiteralExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorLiteralExpression"


    // $ANTLR start "entryRuleNumber"
    // InternalGT.g:328:1: entryRuleNumber : ruleNumber EOF ;
    public final void entryRuleNumber() throws RecognitionException {
        try {
            // InternalGT.g:329:1: ( ruleNumber EOF )
            // InternalGT.g:330:1: ruleNumber EOF
            {
             before(grammarAccess.getNumberRule()); 
            pushFollow(FOLLOW_1);
            ruleNumber();

            state._fsp--;

             after(grammarAccess.getNumberRule()); 
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
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalGT.g:337:1: ruleNumber : ( ( rule__Number__Group__0 ) ) ;
    public final void ruleNumber() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:341:2: ( ( ( rule__Number__Group__0 ) ) )
            // InternalGT.g:342:2: ( ( rule__Number__Group__0 ) )
            {
            // InternalGT.g:342:2: ( ( rule__Number__Group__0 ) )
            // InternalGT.g:343:3: ( rule__Number__Group__0 )
            {
             before(grammarAccess.getNumberAccess().getGroup()); 
            // InternalGT.g:344:3: ( rule__Number__Group__0 )
            // InternalGT.g:344:4: rule__Number__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNumberAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleEditorEnumExpression"
    // InternalGT.g:353:1: entryRuleEditorEnumExpression : ruleEditorEnumExpression EOF ;
    public final void entryRuleEditorEnumExpression() throws RecognitionException {
        try {
            // InternalGT.g:354:1: ( ruleEditorEnumExpression EOF )
            // InternalGT.g:355:1: ruleEditorEnumExpression EOF
            {
             before(grammarAccess.getEditorEnumExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorEnumExpression();

            state._fsp--;

             after(grammarAccess.getEditorEnumExpressionRule()); 
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
    // $ANTLR end "entryRuleEditorEnumExpression"


    // $ANTLR start "ruleEditorEnumExpression"
    // InternalGT.g:362:1: ruleEditorEnumExpression : ( ( rule__EditorEnumExpression__Group__0 ) ) ;
    public final void ruleEditorEnumExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:366:2: ( ( ( rule__EditorEnumExpression__Group__0 ) ) )
            // InternalGT.g:367:2: ( ( rule__EditorEnumExpression__Group__0 ) )
            {
            // InternalGT.g:367:2: ( ( rule__EditorEnumExpression__Group__0 ) )
            // InternalGT.g:368:3: ( rule__EditorEnumExpression__Group__0 )
            {
             before(grammarAccess.getEditorEnumExpressionAccess().getGroup()); 
            // InternalGT.g:369:3: ( rule__EditorEnumExpression__Group__0 )
            // InternalGT.g:369:4: rule__EditorEnumExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorEnumExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorEnumExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorEnumExpression"


    // $ANTLR start "entryRuleEditorParameterExpression"
    // InternalGT.g:378:1: entryRuleEditorParameterExpression : ruleEditorParameterExpression EOF ;
    public final void entryRuleEditorParameterExpression() throws RecognitionException {
        try {
            // InternalGT.g:379:1: ( ruleEditorParameterExpression EOF )
            // InternalGT.g:380:1: ruleEditorParameterExpression EOF
            {
             before(grammarAccess.getEditorParameterExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorParameterExpression();

            state._fsp--;

             after(grammarAccess.getEditorParameterExpressionRule()); 
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
    // $ANTLR end "entryRuleEditorParameterExpression"


    // $ANTLR start "ruleEditorParameterExpression"
    // InternalGT.g:387:1: ruleEditorParameterExpression : ( ( rule__EditorParameterExpression__Group__0 ) ) ;
    public final void ruleEditorParameterExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:391:2: ( ( ( rule__EditorParameterExpression__Group__0 ) ) )
            // InternalGT.g:392:2: ( ( rule__EditorParameterExpression__Group__0 ) )
            {
            // InternalGT.g:392:2: ( ( rule__EditorParameterExpression__Group__0 ) )
            // InternalGT.g:393:3: ( rule__EditorParameterExpression__Group__0 )
            {
             before(grammarAccess.getEditorParameterExpressionAccess().getGroup()); 
            // InternalGT.g:394:3: ( rule__EditorParameterExpression__Group__0 )
            // InternalGT.g:394:4: rule__EditorParameterExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorParameterExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorParameterExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorParameterExpression"


    // $ANTLR start "entryRuleEditorReference"
    // InternalGT.g:403:1: entryRuleEditorReference : ruleEditorReference EOF ;
    public final void entryRuleEditorReference() throws RecognitionException {
        try {
            // InternalGT.g:404:1: ( ruleEditorReference EOF )
            // InternalGT.g:405:1: ruleEditorReference EOF
            {
             before(grammarAccess.getEditorReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorReference();

            state._fsp--;

             after(grammarAccess.getEditorReferenceRule()); 
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
    // $ANTLR end "entryRuleEditorReference"


    // $ANTLR start "ruleEditorReference"
    // InternalGT.g:412:1: ruleEditorReference : ( ( rule__EditorReference__Group__0 ) ) ;
    public final void ruleEditorReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:416:2: ( ( ( rule__EditorReference__Group__0 ) ) )
            // InternalGT.g:417:2: ( ( rule__EditorReference__Group__0 ) )
            {
            // InternalGT.g:417:2: ( ( rule__EditorReference__Group__0 ) )
            // InternalGT.g:418:3: ( rule__EditorReference__Group__0 )
            {
             before(grammarAccess.getEditorReferenceAccess().getGroup()); 
            // InternalGT.g:419:3: ( rule__EditorReference__Group__0 )
            // InternalGT.g:419:4: rule__EditorReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorReference"


    // $ANTLR start "entryRuleEditorReferenceIterator"
    // InternalGT.g:428:1: entryRuleEditorReferenceIterator : ruleEditorReferenceIterator EOF ;
    public final void entryRuleEditorReferenceIterator() throws RecognitionException {
        try {
            // InternalGT.g:429:1: ( ruleEditorReferenceIterator EOF )
            // InternalGT.g:430:1: ruleEditorReferenceIterator EOF
            {
             before(grammarAccess.getEditorReferenceIteratorRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorReferenceIterator();

            state._fsp--;

             after(grammarAccess.getEditorReferenceIteratorRule()); 
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
    // $ANTLR end "entryRuleEditorReferenceIterator"


    // $ANTLR start "ruleEditorReferenceIterator"
    // InternalGT.g:437:1: ruleEditorReferenceIterator : ( ( rule__EditorReferenceIterator__Group__0 ) ) ;
    public final void ruleEditorReferenceIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:441:2: ( ( ( rule__EditorReferenceIterator__Group__0 ) ) )
            // InternalGT.g:442:2: ( ( rule__EditorReferenceIterator__Group__0 ) )
            {
            // InternalGT.g:442:2: ( ( rule__EditorReferenceIterator__Group__0 ) )
            // InternalGT.g:443:3: ( rule__EditorReferenceIterator__Group__0 )
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getGroup()); 
            // InternalGT.g:444:3: ( rule__EditorReferenceIterator__Group__0 )
            // InternalGT.g:444:4: rule__EditorReferenceIterator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorReferenceIterator"


    // $ANTLR start "entryRuleEditorIteratorAttributeExpression"
    // InternalGT.g:453:1: entryRuleEditorIteratorAttributeExpression : ruleEditorIteratorAttributeExpression EOF ;
    public final void entryRuleEditorIteratorAttributeExpression() throws RecognitionException {
        try {
            // InternalGT.g:454:1: ( ruleEditorIteratorAttributeExpression EOF )
            // InternalGT.g:455:1: ruleEditorIteratorAttributeExpression EOF
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorIteratorAttributeExpression();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeExpressionRule()); 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeExpression"


    // $ANTLR start "ruleEditorIteratorAttributeExpression"
    // InternalGT.g:462:1: ruleEditorIteratorAttributeExpression : ( ( rule__EditorIteratorAttributeExpression__Group__0 ) ) ;
    public final void ruleEditorIteratorAttributeExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:466:2: ( ( ( rule__EditorIteratorAttributeExpression__Group__0 ) ) )
            // InternalGT.g:467:2: ( ( rule__EditorIteratorAttributeExpression__Group__0 ) )
            {
            // InternalGT.g:467:2: ( ( rule__EditorIteratorAttributeExpression__Group__0 ) )
            // InternalGT.g:468:3: ( rule__EditorIteratorAttributeExpression__Group__0 )
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getGroup()); 
            // InternalGT.g:469:3: ( rule__EditorIteratorAttributeExpression__Group__0 )
            // InternalGT.g:469:4: rule__EditorIteratorAttributeExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorIteratorAttributeExpression"


    // $ANTLR start "entryRuleEditorIteratorAttributeAssignment"
    // InternalGT.g:478:1: entryRuleEditorIteratorAttributeAssignment : ruleEditorIteratorAttributeAssignment EOF ;
    public final void entryRuleEditorIteratorAttributeAssignment() throws RecognitionException {
        try {
            // InternalGT.g:479:1: ( ruleEditorIteratorAttributeAssignment EOF )
            // InternalGT.g:480:1: ruleEditorIteratorAttributeAssignment EOF
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorIteratorAttributeAssignment();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeAssignmentRule()); 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeAssignment"


    // $ANTLR start "ruleEditorIteratorAttributeAssignment"
    // InternalGT.g:487:1: ruleEditorIteratorAttributeAssignment : ( ( rule__EditorIteratorAttributeAssignment__Alternatives ) ) ;
    public final void ruleEditorIteratorAttributeAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:491:2: ( ( ( rule__EditorIteratorAttributeAssignment__Alternatives ) ) )
            // InternalGT.g:492:2: ( ( rule__EditorIteratorAttributeAssignment__Alternatives ) )
            {
            // InternalGT.g:492:2: ( ( rule__EditorIteratorAttributeAssignment__Alternatives ) )
            // InternalGT.g:493:3: ( rule__EditorIteratorAttributeAssignment__Alternatives )
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getAlternatives()); 
            // InternalGT.g:494:3: ( rule__EditorIteratorAttributeAssignment__Alternatives )
            // InternalGT.g:494:4: rule__EditorIteratorAttributeAssignment__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignment__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorIteratorAttributeAssignment"


    // $ANTLR start "entryRuleEditorIteratorAttributeAssignmentItr"
    // InternalGT.g:503:1: entryRuleEditorIteratorAttributeAssignmentItr : ruleEditorIteratorAttributeAssignmentItr EOF ;
    public final void entryRuleEditorIteratorAttributeAssignmentItr() throws RecognitionException {
        try {
            // InternalGT.g:504:1: ( ruleEditorIteratorAttributeAssignmentItr EOF )
            // InternalGT.g:505:1: ruleEditorIteratorAttributeAssignmentItr EOF
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentItrRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorIteratorAttributeAssignmentItr();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeAssignmentItrRule()); 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeAssignmentItr"


    // $ANTLR start "ruleEditorIteratorAttributeAssignmentItr"
    // InternalGT.g:512:1: ruleEditorIteratorAttributeAssignmentItr : ( ( rule__EditorIteratorAttributeAssignmentItr__Group__0 ) ) ;
    public final void ruleEditorIteratorAttributeAssignmentItr() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:516:2: ( ( ( rule__EditorIteratorAttributeAssignmentItr__Group__0 ) ) )
            // InternalGT.g:517:2: ( ( rule__EditorIteratorAttributeAssignmentItr__Group__0 ) )
            {
            // InternalGT.g:517:2: ( ( rule__EditorIteratorAttributeAssignmentItr__Group__0 ) )
            // InternalGT.g:518:3: ( rule__EditorIteratorAttributeAssignmentItr__Group__0 )
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getGroup()); 
            // InternalGT.g:519:3: ( rule__EditorIteratorAttributeAssignmentItr__Group__0 )
            // InternalGT.g:519:4: rule__EditorIteratorAttributeAssignmentItr__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentItr__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorIteratorAttributeAssignmentItr"


    // $ANTLR start "entryRuleEditorIteratorAttributeAssignmentNode"
    // InternalGT.g:528:1: entryRuleEditorIteratorAttributeAssignmentNode : ruleEditorIteratorAttributeAssignmentNode EOF ;
    public final void entryRuleEditorIteratorAttributeAssignmentNode() throws RecognitionException {
        try {
            // InternalGT.g:529:1: ( ruleEditorIteratorAttributeAssignmentNode EOF )
            // InternalGT.g:530:1: ruleEditorIteratorAttributeAssignmentNode EOF
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorIteratorAttributeAssignmentNode();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeAssignmentNodeRule()); 
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
    // $ANTLR end "entryRuleEditorIteratorAttributeAssignmentNode"


    // $ANTLR start "ruleEditorIteratorAttributeAssignmentNode"
    // InternalGT.g:537:1: ruleEditorIteratorAttributeAssignmentNode : ( ( rule__EditorIteratorAttributeAssignmentNode__Group__0 ) ) ;
    public final void ruleEditorIteratorAttributeAssignmentNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:541:2: ( ( ( rule__EditorIteratorAttributeAssignmentNode__Group__0 ) ) )
            // InternalGT.g:542:2: ( ( rule__EditorIteratorAttributeAssignmentNode__Group__0 ) )
            {
            // InternalGT.g:542:2: ( ( rule__EditorIteratorAttributeAssignmentNode__Group__0 ) )
            // InternalGT.g:543:3: ( rule__EditorIteratorAttributeAssignmentNode__Group__0 )
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getGroup()); 
            // InternalGT.g:544:3: ( rule__EditorIteratorAttributeAssignmentNode__Group__0 )
            // InternalGT.g:544:4: rule__EditorIteratorAttributeAssignmentNode__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentNode__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorIteratorAttributeAssignmentNode"


    // $ANTLR start "entryRuleEditorIteratorReference"
    // InternalGT.g:553:1: entryRuleEditorIteratorReference : ruleEditorIteratorReference EOF ;
    public final void entryRuleEditorIteratorReference() throws RecognitionException {
        try {
            // InternalGT.g:554:1: ( ruleEditorIteratorReference EOF )
            // InternalGT.g:555:1: ruleEditorIteratorReference EOF
            {
             before(grammarAccess.getEditorIteratorReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorIteratorReference();

            state._fsp--;

             after(grammarAccess.getEditorIteratorReferenceRule()); 
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
    // $ANTLR end "entryRuleEditorIteratorReference"


    // $ANTLR start "ruleEditorIteratorReference"
    // InternalGT.g:562:1: ruleEditorIteratorReference : ( ( rule__EditorIteratorReference__Group__0 ) ) ;
    public final void ruleEditorIteratorReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:566:2: ( ( ( rule__EditorIteratorReference__Group__0 ) ) )
            // InternalGT.g:567:2: ( ( rule__EditorIteratorReference__Group__0 ) )
            {
            // InternalGT.g:567:2: ( ( rule__EditorIteratorReference__Group__0 ) )
            // InternalGT.g:568:3: ( rule__EditorIteratorReference__Group__0 )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getGroup()); 
            // InternalGT.g:569:3: ( rule__EditorIteratorReference__Group__0 )
            // InternalGT.g:569:4: rule__EditorIteratorReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorIteratorReference"


    // $ANTLR start "entryRuleEditorCondition"
    // InternalGT.g:578:1: entryRuleEditorCondition : ruleEditorCondition EOF ;
    public final void entryRuleEditorCondition() throws RecognitionException {
        try {
            // InternalGT.g:579:1: ( ruleEditorCondition EOF )
            // InternalGT.g:580:1: ruleEditorCondition EOF
            {
             before(grammarAccess.getEditorConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorCondition();

            state._fsp--;

             after(grammarAccess.getEditorConditionRule()); 
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
    // $ANTLR end "entryRuleEditorCondition"


    // $ANTLR start "ruleEditorCondition"
    // InternalGT.g:587:1: ruleEditorCondition : ( ( rule__EditorCondition__Group__0 ) ) ;
    public final void ruleEditorCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:591:2: ( ( ( rule__EditorCondition__Group__0 ) ) )
            // InternalGT.g:592:2: ( ( rule__EditorCondition__Group__0 ) )
            {
            // InternalGT.g:592:2: ( ( rule__EditorCondition__Group__0 ) )
            // InternalGT.g:593:3: ( rule__EditorCondition__Group__0 )
            {
             before(grammarAccess.getEditorConditionAccess().getGroup()); 
            // InternalGT.g:594:3: ( rule__EditorCondition__Group__0 )
            // InternalGT.g:594:4: rule__EditorCondition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEditorConditionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorCondition"


    // $ANTLR start "entryRuleEditorSimpleCondition"
    // InternalGT.g:603:1: entryRuleEditorSimpleCondition : ruleEditorSimpleCondition EOF ;
    public final void entryRuleEditorSimpleCondition() throws RecognitionException {
        try {
            // InternalGT.g:604:1: ( ruleEditorSimpleCondition EOF )
            // InternalGT.g:605:1: ruleEditorSimpleCondition EOF
            {
             before(grammarAccess.getEditorSimpleConditionRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorSimpleCondition();

            state._fsp--;

             after(grammarAccess.getEditorSimpleConditionRule()); 
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
    // $ANTLR end "entryRuleEditorSimpleCondition"


    // $ANTLR start "ruleEditorSimpleCondition"
    // InternalGT.g:612:1: ruleEditorSimpleCondition : ( ( rule__EditorSimpleCondition__Alternatives ) ) ;
    public final void ruleEditorSimpleCondition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:616:2: ( ( ( rule__EditorSimpleCondition__Alternatives ) ) )
            // InternalGT.g:617:2: ( ( rule__EditorSimpleCondition__Alternatives ) )
            {
            // InternalGT.g:617:2: ( ( rule__EditorSimpleCondition__Alternatives ) )
            // InternalGT.g:618:3: ( rule__EditorSimpleCondition__Alternatives )
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getAlternatives()); 
            // InternalGT.g:619:3: ( rule__EditorSimpleCondition__Alternatives )
            // InternalGT.g:619:4: rule__EditorSimpleCondition__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorSimpleConditionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorSimpleCondition"


    // $ANTLR start "entryRuleEditorProbability"
    // InternalGT.g:628:1: entryRuleEditorProbability : ruleEditorProbability EOF ;
    public final void entryRuleEditorProbability() throws RecognitionException {
        try {
            // InternalGT.g:629:1: ( ruleEditorProbability EOF )
            // InternalGT.g:630:1: ruleEditorProbability EOF
            {
             before(grammarAccess.getEditorProbabilityRule()); 
            pushFollow(FOLLOW_1);
            ruleEditorProbability();

            state._fsp--;

             after(grammarAccess.getEditorProbabilityRule()); 
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
    // $ANTLR end "entryRuleEditorProbability"


    // $ANTLR start "ruleEditorProbability"
    // InternalGT.g:637:1: ruleEditorProbability : ( ( rule__EditorProbability__Alternatives ) ) ;
    public final void ruleEditorProbability() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:641:2: ( ( ( rule__EditorProbability__Alternatives ) ) )
            // InternalGT.g:642:2: ( ( rule__EditorProbability__Alternatives ) )
            {
            // InternalGT.g:642:2: ( ( rule__EditorProbability__Alternatives ) )
            // InternalGT.g:643:3: ( rule__EditorProbability__Alternatives )
            {
             before(grammarAccess.getEditorProbabilityAccess().getAlternatives()); 
            // InternalGT.g:644:3: ( rule__EditorProbability__Alternatives )
            // InternalGT.g:644:4: rule__EditorProbability__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorProbability__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorProbabilityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorProbability"


    // $ANTLR start "entryRuleStochasticFunction"
    // InternalGT.g:653:1: entryRuleStochasticFunction : ruleStochasticFunction EOF ;
    public final void entryRuleStochasticFunction() throws RecognitionException {
        try {
            // InternalGT.g:654:1: ( ruleStochasticFunction EOF )
            // InternalGT.g:655:1: ruleStochasticFunction EOF
            {
             before(grammarAccess.getStochasticFunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleStochasticFunction();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionRule()); 
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
    // $ANTLR end "entryRuleStochasticFunction"


    // $ANTLR start "ruleStochasticFunction"
    // InternalGT.g:662:1: ruleStochasticFunction : ( ( rule__StochasticFunction__Group__0 ) ) ;
    public final void ruleStochasticFunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:666:2: ( ( ( rule__StochasticFunction__Group__0 ) ) )
            // InternalGT.g:667:2: ( ( rule__StochasticFunction__Group__0 ) )
            {
            // InternalGT.g:667:2: ( ( rule__StochasticFunction__Group__0 ) )
            // InternalGT.g:668:3: ( rule__StochasticFunction__Group__0 )
            {
             before(grammarAccess.getStochasticFunctionAccess().getGroup()); 
            // InternalGT.g:669:3: ( rule__StochasticFunction__Group__0 )
            // InternalGT.g:669:4: rule__StochasticFunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStochasticFunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStochasticFunction"


    // $ANTLR start "entryRuleStochasticFunctionExpression"
    // InternalGT.g:678:1: entryRuleStochasticFunctionExpression : ruleStochasticFunctionExpression EOF ;
    public final void entryRuleStochasticFunctionExpression() throws RecognitionException {
        try {
            // InternalGT.g:679:1: ( ruleStochasticFunctionExpression EOF )
            // InternalGT.g:680:1: ruleStochasticFunctionExpression EOF
            {
             before(grammarAccess.getStochasticFunctionExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleStochasticFunctionExpression();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionExpressionRule()); 
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
    // $ANTLR end "entryRuleStochasticFunctionExpression"


    // $ANTLR start "ruleStochasticFunctionExpression"
    // InternalGT.g:687:1: ruleStochasticFunctionExpression : ( ( rule__StochasticFunctionExpression__Group__0 ) ) ;
    public final void ruleStochasticFunctionExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:691:2: ( ( ( rule__StochasticFunctionExpression__Group__0 ) ) )
            // InternalGT.g:692:2: ( ( rule__StochasticFunctionExpression__Group__0 ) )
            {
            // InternalGT.g:692:2: ( ( rule__StochasticFunctionExpression__Group__0 ) )
            // InternalGT.g:693:3: ( rule__StochasticFunctionExpression__Group__0 )
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getGroup()); 
            // InternalGT.g:694:3: ( rule__StochasticFunctionExpression__Group__0 )
            // InternalGT.g:694:4: rule__StochasticFunctionExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStochasticFunctionExpression"


    // $ANTLR start "entryRuleArithmeticCalculationExpression"
    // InternalGT.g:703:1: entryRuleArithmeticCalculationExpression : ruleArithmeticCalculationExpression EOF ;
    public final void entryRuleArithmeticCalculationExpression() throws RecognitionException {
        try {
            // InternalGT.g:704:1: ( ruleArithmeticCalculationExpression EOF )
            // InternalGT.g:705:1: ruleArithmeticCalculationExpression EOF
            {
             before(grammarAccess.getArithmeticCalculationExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleArithmeticCalculationExpression();

            state._fsp--;

             after(grammarAccess.getArithmeticCalculationExpressionRule()); 
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
    // $ANTLR end "entryRuleArithmeticCalculationExpression"


    // $ANTLR start "ruleArithmeticCalculationExpression"
    // InternalGT.g:712:1: ruleArithmeticCalculationExpression : ( ( rule__ArithmeticCalculationExpression__ExpressionAssignment ) ) ;
    public final void ruleArithmeticCalculationExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:716:2: ( ( ( rule__ArithmeticCalculationExpression__ExpressionAssignment ) ) )
            // InternalGT.g:717:2: ( ( rule__ArithmeticCalculationExpression__ExpressionAssignment ) )
            {
            // InternalGT.g:717:2: ( ( rule__ArithmeticCalculationExpression__ExpressionAssignment ) )
            // InternalGT.g:718:3: ( rule__ArithmeticCalculationExpression__ExpressionAssignment )
            {
             before(grammarAccess.getArithmeticCalculationExpressionAccess().getExpressionAssignment()); 
            // InternalGT.g:719:3: ( rule__ArithmeticCalculationExpression__ExpressionAssignment )
            // InternalGT.g:719:4: rule__ArithmeticCalculationExpression__ExpressionAssignment
            {
            pushFollow(FOLLOW_2);
            rule__ArithmeticCalculationExpression__ExpressionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getArithmeticCalculationExpressionAccess().getExpressionAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArithmeticCalculationExpression"


    // $ANTLR start "entryRuleArithmeticExpression"
    // InternalGT.g:728:1: entryRuleArithmeticExpression : ruleArithmeticExpression EOF ;
    public final void entryRuleArithmeticExpression() throws RecognitionException {
        try {
            // InternalGT.g:729:1: ( ruleArithmeticExpression EOF )
            // InternalGT.g:730:1: ruleArithmeticExpression EOF
            {
             before(grammarAccess.getArithmeticExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getArithmeticExpressionRule()); 
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
    // $ANTLR end "entryRuleArithmeticExpression"


    // $ANTLR start "ruleArithmeticExpression"
    // InternalGT.g:737:1: ruleArithmeticExpression : ( ruleAddExpression ) ;
    public final void ruleArithmeticExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:741:2: ( ( ruleAddExpression ) )
            // InternalGT.g:742:2: ( ruleAddExpression )
            {
            // InternalGT.g:742:2: ( ruleAddExpression )
            // InternalGT.g:743:3: ruleAddExpression
            {
             before(grammarAccess.getArithmeticExpressionAccess().getAddExpressionParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleAddExpression();

            state._fsp--;

             after(grammarAccess.getArithmeticExpressionAccess().getAddExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArithmeticExpression"


    // $ANTLR start "entryRuleAddExpression"
    // InternalGT.g:753:1: entryRuleAddExpression : ruleAddExpression EOF ;
    public final void entryRuleAddExpression() throws RecognitionException {
        try {
            // InternalGT.g:754:1: ( ruleAddExpression EOF )
            // InternalGT.g:755:1: ruleAddExpression EOF
            {
             before(grammarAccess.getAddExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleAddExpression();

            state._fsp--;

             after(grammarAccess.getAddExpressionRule()); 
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
    // $ANTLR end "entryRuleAddExpression"


    // $ANTLR start "ruleAddExpression"
    // InternalGT.g:762:1: ruleAddExpression : ( ( rule__AddExpression__Group__0 ) ) ;
    public final void ruleAddExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:766:2: ( ( ( rule__AddExpression__Group__0 ) ) )
            // InternalGT.g:767:2: ( ( rule__AddExpression__Group__0 ) )
            {
            // InternalGT.g:767:2: ( ( rule__AddExpression__Group__0 ) )
            // InternalGT.g:768:3: ( rule__AddExpression__Group__0 )
            {
             before(grammarAccess.getAddExpressionAccess().getGroup()); 
            // InternalGT.g:769:3: ( rule__AddExpression__Group__0 )
            // InternalGT.g:769:4: rule__AddExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AddExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAddExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddExpression"


    // $ANTLR start "entryRuleMultExpression"
    // InternalGT.g:778:1: entryRuleMultExpression : ruleMultExpression EOF ;
    public final void entryRuleMultExpression() throws RecognitionException {
        try {
            // InternalGT.g:779:1: ( ruleMultExpression EOF )
            // InternalGT.g:780:1: ruleMultExpression EOF
            {
             before(grammarAccess.getMultExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleMultExpression();

            state._fsp--;

             after(grammarAccess.getMultExpressionRule()); 
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
    // $ANTLR end "entryRuleMultExpression"


    // $ANTLR start "ruleMultExpression"
    // InternalGT.g:787:1: ruleMultExpression : ( ( rule__MultExpression__Group__0 ) ) ;
    public final void ruleMultExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:791:2: ( ( ( rule__MultExpression__Group__0 ) ) )
            // InternalGT.g:792:2: ( ( rule__MultExpression__Group__0 ) )
            {
            // InternalGT.g:792:2: ( ( rule__MultExpression__Group__0 ) )
            // InternalGT.g:793:3: ( rule__MultExpression__Group__0 )
            {
             before(grammarAccess.getMultExpressionAccess().getGroup()); 
            // InternalGT.g:794:3: ( rule__MultExpression__Group__0 )
            // InternalGT.g:794:4: rule__MultExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultExpression"


    // $ANTLR start "entryRuleExpExpression"
    // InternalGT.g:803:1: entryRuleExpExpression : ruleExpExpression EOF ;
    public final void entryRuleExpExpression() throws RecognitionException {
        try {
            // InternalGT.g:804:1: ( ruleExpExpression EOF )
            // InternalGT.g:805:1: ruleExpExpression EOF
            {
             before(grammarAccess.getExpExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpExpression();

            state._fsp--;

             after(grammarAccess.getExpExpressionRule()); 
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
    // $ANTLR end "entryRuleExpExpression"


    // $ANTLR start "ruleExpExpression"
    // InternalGT.g:812:1: ruleExpExpression : ( ( rule__ExpExpression__Group__0 ) ) ;
    public final void ruleExpExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:816:2: ( ( ( rule__ExpExpression__Group__0 ) ) )
            // InternalGT.g:817:2: ( ( rule__ExpExpression__Group__0 ) )
            {
            // InternalGT.g:817:2: ( ( rule__ExpExpression__Group__0 ) )
            // InternalGT.g:818:3: ( rule__ExpExpression__Group__0 )
            {
             before(grammarAccess.getExpExpressionAccess().getGroup()); 
            // InternalGT.g:819:3: ( rule__ExpExpression__Group__0 )
            // InternalGT.g:819:4: rule__ExpExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ExpExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExpExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpExpression"


    // $ANTLR start "entryRuleMinMaxExpression"
    // InternalGT.g:828:1: entryRuleMinMaxExpression : ruleMinMaxExpression EOF ;
    public final void entryRuleMinMaxExpression() throws RecognitionException {
        try {
            // InternalGT.g:829:1: ( ruleMinMaxExpression EOF )
            // InternalGT.g:830:1: ruleMinMaxExpression EOF
            {
             before(grammarAccess.getMinMaxExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleMinMaxExpression();

            state._fsp--;

             after(grammarAccess.getMinMaxExpressionRule()); 
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
    // $ANTLR end "entryRuleMinMaxExpression"


    // $ANTLR start "ruleMinMaxExpression"
    // InternalGT.g:837:1: ruleMinMaxExpression : ( ( rule__MinMaxExpression__Group__0 ) ) ;
    public final void ruleMinMaxExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:841:2: ( ( ( rule__MinMaxExpression__Group__0 ) ) )
            // InternalGT.g:842:2: ( ( rule__MinMaxExpression__Group__0 ) )
            {
            // InternalGT.g:842:2: ( ( rule__MinMaxExpression__Group__0 ) )
            // InternalGT.g:843:3: ( rule__MinMaxExpression__Group__0 )
            {
             before(grammarAccess.getMinMaxExpressionAccess().getGroup()); 
            // InternalGT.g:844:3: ( rule__MinMaxExpression__Group__0 )
            // InternalGT.g:844:4: rule__MinMaxExpression__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMinMaxExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMinMaxExpression"


    // $ANTLR start "entryRuleOneParameterArithmetics"
    // InternalGT.g:853:1: entryRuleOneParameterArithmetics : ruleOneParameterArithmetics EOF ;
    public final void entryRuleOneParameterArithmetics() throws RecognitionException {
        try {
            // InternalGT.g:854:1: ( ruleOneParameterArithmetics EOF )
            // InternalGT.g:855:1: ruleOneParameterArithmetics EOF
            {
             before(grammarAccess.getOneParameterArithmeticsRule()); 
            pushFollow(FOLLOW_1);
            ruleOneParameterArithmetics();

            state._fsp--;

             after(grammarAccess.getOneParameterArithmeticsRule()); 
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
    // $ANTLR end "entryRuleOneParameterArithmetics"


    // $ANTLR start "ruleOneParameterArithmetics"
    // InternalGT.g:862:1: ruleOneParameterArithmetics : ( ( rule__OneParameterArithmetics__Alternatives ) ) ;
    public final void ruleOneParameterArithmetics() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:866:2: ( ( ( rule__OneParameterArithmetics__Alternatives ) ) )
            // InternalGT.g:867:2: ( ( rule__OneParameterArithmetics__Alternatives ) )
            {
            // InternalGT.g:867:2: ( ( rule__OneParameterArithmetics__Alternatives ) )
            // InternalGT.g:868:3: ( rule__OneParameterArithmetics__Alternatives )
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getAlternatives()); 
            // InternalGT.g:869:3: ( rule__OneParameterArithmetics__Alternatives )
            // InternalGT.g:869:4: rule__OneParameterArithmetics__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOneParameterArithmeticsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOneParameterArithmetics"


    // $ANTLR start "entryRuleArithmeticAttribute"
    // InternalGT.g:878:1: entryRuleArithmeticAttribute : ruleArithmeticAttribute EOF ;
    public final void entryRuleArithmeticAttribute() throws RecognitionException {
        try {
            // InternalGT.g:879:1: ( ruleArithmeticAttribute EOF )
            // InternalGT.g:880:1: ruleArithmeticAttribute EOF
            {
             before(grammarAccess.getArithmeticAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleArithmeticAttribute();

            state._fsp--;

             after(grammarAccess.getArithmeticAttributeRule()); 
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
    // $ANTLR end "entryRuleArithmeticAttribute"


    // $ANTLR start "ruleArithmeticAttribute"
    // InternalGT.g:887:1: ruleArithmeticAttribute : ( ( rule__ArithmeticAttribute__Alternatives ) ) ;
    public final void ruleArithmeticAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:891:2: ( ( ( rule__ArithmeticAttribute__Alternatives ) ) )
            // InternalGT.g:892:2: ( ( rule__ArithmeticAttribute__Alternatives ) )
            {
            // InternalGT.g:892:2: ( ( rule__ArithmeticAttribute__Alternatives ) )
            // InternalGT.g:893:3: ( rule__ArithmeticAttribute__Alternatives )
            {
             before(grammarAccess.getArithmeticAttributeAccess().getAlternatives()); 
            // InternalGT.g:894:3: ( rule__ArithmeticAttribute__Alternatives )
            // InternalGT.g:894:4: rule__ArithmeticAttribute__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__ArithmeticAttribute__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getArithmeticAttributeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArithmeticAttribute"


    // $ANTLR start "ruleEditorPatternType"
    // InternalGT.g:903:1: ruleEditorPatternType : ( ( rule__EditorPatternType__Alternatives ) ) ;
    public final void ruleEditorPatternType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:907:1: ( ( ( rule__EditorPatternType__Alternatives ) ) )
            // InternalGT.g:908:2: ( ( rule__EditorPatternType__Alternatives ) )
            {
            // InternalGT.g:908:2: ( ( rule__EditorPatternType__Alternatives ) )
            // InternalGT.g:909:3: ( rule__EditorPatternType__Alternatives )
            {
             before(grammarAccess.getEditorPatternTypeAccess().getAlternatives()); 
            // InternalGT.g:910:3: ( rule__EditorPatternType__Alternatives )
            // InternalGT.g:910:4: rule__EditorPatternType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorPatternType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorPatternType"


    // $ANTLR start "ruleEditorOperator"
    // InternalGT.g:919:1: ruleEditorOperator : ( ( rule__EditorOperator__Alternatives ) ) ;
    public final void ruleEditorOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:923:1: ( ( ( rule__EditorOperator__Alternatives ) ) )
            // InternalGT.g:924:2: ( ( rule__EditorOperator__Alternatives ) )
            {
            // InternalGT.g:924:2: ( ( rule__EditorOperator__Alternatives ) )
            // InternalGT.g:925:3: ( rule__EditorOperator__Alternatives )
            {
             before(grammarAccess.getEditorOperatorAccess().getAlternatives()); 
            // InternalGT.g:926:3: ( rule__EditorOperator__Alternatives )
            // InternalGT.g:926:4: rule__EditorOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorOperator"


    // $ANTLR start "ruleEditorRelation"
    // InternalGT.g:935:1: ruleEditorRelation : ( ( rule__EditorRelation__Alternatives ) ) ;
    public final void ruleEditorRelation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:939:1: ( ( ( rule__EditorRelation__Alternatives ) ) )
            // InternalGT.g:940:2: ( ( rule__EditorRelation__Alternatives ) )
            {
            // InternalGT.g:940:2: ( ( rule__EditorRelation__Alternatives ) )
            // InternalGT.g:941:3: ( rule__EditorRelation__Alternatives )
            {
             before(grammarAccess.getEditorRelationAccess().getAlternatives()); 
            // InternalGT.g:942:3: ( rule__EditorRelation__Alternatives )
            // InternalGT.g:942:4: rule__EditorRelation__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorRelation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorRelationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorRelation"


    // $ANTLR start "ruleEditorApplicationConditionType"
    // InternalGT.g:951:1: ruleEditorApplicationConditionType : ( ( rule__EditorApplicationConditionType__Alternatives ) ) ;
    public final void ruleEditorApplicationConditionType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:955:1: ( ( ( rule__EditorApplicationConditionType__Alternatives ) ) )
            // InternalGT.g:956:2: ( ( rule__EditorApplicationConditionType__Alternatives ) )
            {
            // InternalGT.g:956:2: ( ( rule__EditorApplicationConditionType__Alternatives ) )
            // InternalGT.g:957:3: ( rule__EditorApplicationConditionType__Alternatives )
            {
             before(grammarAccess.getEditorApplicationConditionTypeAccess().getAlternatives()); 
            // InternalGT.g:958:3: ( rule__EditorApplicationConditionType__Alternatives )
            // InternalGT.g:958:4: rule__EditorApplicationConditionType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EditorApplicationConditionType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEditorApplicationConditionTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEditorApplicationConditionType"


    // $ANTLR start "ruleStochasticRange"
    // InternalGT.g:967:1: ruleStochasticRange : ( ( rule__StochasticRange__Alternatives ) ) ;
    public final void ruleStochasticRange() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:971:1: ( ( ( rule__StochasticRange__Alternatives ) ) )
            // InternalGT.g:972:2: ( ( rule__StochasticRange__Alternatives ) )
            {
            // InternalGT.g:972:2: ( ( rule__StochasticRange__Alternatives ) )
            // InternalGT.g:973:3: ( rule__StochasticRange__Alternatives )
            {
             before(grammarAccess.getStochasticRangeAccess().getAlternatives()); 
            // InternalGT.g:974:3: ( rule__StochasticRange__Alternatives )
            // InternalGT.g:974:4: rule__StochasticRange__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__StochasticRange__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStochasticRangeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStochasticRange"


    // $ANTLR start "ruleStochasticDistribution"
    // InternalGT.g:983:1: ruleStochasticDistribution : ( ( rule__StochasticDistribution__Alternatives ) ) ;
    public final void ruleStochasticDistribution() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:987:1: ( ( ( rule__StochasticDistribution__Alternatives ) ) )
            // InternalGT.g:988:2: ( ( rule__StochasticDistribution__Alternatives ) )
            {
            // InternalGT.g:988:2: ( ( rule__StochasticDistribution__Alternatives ) )
            // InternalGT.g:989:3: ( rule__StochasticDistribution__Alternatives )
            {
             before(grammarAccess.getStochasticDistributionAccess().getAlternatives()); 
            // InternalGT.g:990:3: ( rule__StochasticDistribution__Alternatives )
            // InternalGT.g:990:4: rule__StochasticDistribution__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__StochasticDistribution__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStochasticDistributionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStochasticDistribution"


    // $ANTLR start "ruleMultOperator"
    // InternalGT.g:999:1: ruleMultOperator : ( ( rule__MultOperator__Alternatives ) ) ;
    public final void ruleMultOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1003:1: ( ( ( rule__MultOperator__Alternatives ) ) )
            // InternalGT.g:1004:2: ( ( rule__MultOperator__Alternatives ) )
            {
            // InternalGT.g:1004:2: ( ( rule__MultOperator__Alternatives ) )
            // InternalGT.g:1005:3: ( rule__MultOperator__Alternatives )
            {
             before(grammarAccess.getMultOperatorAccess().getAlternatives()); 
            // InternalGT.g:1006:3: ( rule__MultOperator__Alternatives )
            // InternalGT.g:1006:4: rule__MultOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MultOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMultOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultOperator"


    // $ANTLR start "ruleMinMaxOperator"
    // InternalGT.g:1015:1: ruleMinMaxOperator : ( ( rule__MinMaxOperator__Alternatives ) ) ;
    public final void ruleMinMaxOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1019:1: ( ( ( rule__MinMaxOperator__Alternatives ) ) )
            // InternalGT.g:1020:2: ( ( rule__MinMaxOperator__Alternatives ) )
            {
            // InternalGT.g:1020:2: ( ( rule__MinMaxOperator__Alternatives ) )
            // InternalGT.g:1021:3: ( rule__MinMaxOperator__Alternatives )
            {
             before(grammarAccess.getMinMaxOperatorAccess().getAlternatives()); 
            // InternalGT.g:1022:3: ( rule__MinMaxOperator__Alternatives )
            // InternalGT.g:1022:4: rule__MinMaxOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MinMaxOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMinMaxOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMinMaxOperator"


    // $ANTLR start "ruleAddOperator"
    // InternalGT.g:1031:1: ruleAddOperator : ( ( rule__AddOperator__Alternatives ) ) ;
    public final void ruleAddOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1035:1: ( ( ( rule__AddOperator__Alternatives ) ) )
            // InternalGT.g:1036:2: ( ( rule__AddOperator__Alternatives ) )
            {
            // InternalGT.g:1036:2: ( ( rule__AddOperator__Alternatives ) )
            // InternalGT.g:1037:3: ( rule__AddOperator__Alternatives )
            {
             before(grammarAccess.getAddOperatorAccess().getAlternatives()); 
            // InternalGT.g:1038:3: ( rule__AddOperator__Alternatives )
            // InternalGT.g:1038:4: rule__AddOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__AddOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getAddOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAddOperator"


    // $ANTLR start "ruleOneParameterOperator"
    // InternalGT.g:1047:1: ruleOneParameterOperator : ( ( rule__OneParameterOperator__Alternatives ) ) ;
    public final void ruleOneParameterOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1051:1: ( ( ( rule__OneParameterOperator__Alternatives ) ) )
            // InternalGT.g:1052:2: ( ( rule__OneParameterOperator__Alternatives ) )
            {
            // InternalGT.g:1052:2: ( ( rule__OneParameterOperator__Alternatives ) )
            // InternalGT.g:1053:3: ( rule__OneParameterOperator__Alternatives )
            {
             before(grammarAccess.getOneParameterOperatorAccess().getAlternatives()); 
            // InternalGT.g:1054:3: ( rule__OneParameterOperator__Alternatives )
            // InternalGT.g:1054:4: rule__OneParameterOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OneParameterOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOneParameterOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOneParameterOperator"


    // $ANTLR start "rule__EditorGTFile__Alternatives_1"
    // InternalGT.g:1062:1: rule__EditorGTFile__Alternatives_1 : ( ( ( rule__EditorGTFile__PatternsAssignment_1_0 ) ) | ( ( rule__EditorGTFile__ConditionsAssignment_1_1 ) ) );
    public final void rule__EditorGTFile__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1066:1: ( ( ( rule__EditorGTFile__PatternsAssignment_1_0 ) ) | ( ( rule__EditorGTFile__ConditionsAssignment_1_1 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=13 && LA1_0<=14)||LA1_0==67) ) {
                alt1=1;
            }
            else if ( (LA1_0==63) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalGT.g:1067:2: ( ( rule__EditorGTFile__PatternsAssignment_1_0 ) )
                    {
                    // InternalGT.g:1067:2: ( ( rule__EditorGTFile__PatternsAssignment_1_0 ) )
                    // InternalGT.g:1068:3: ( rule__EditorGTFile__PatternsAssignment_1_0 )
                    {
                     before(grammarAccess.getEditorGTFileAccess().getPatternsAssignment_1_0()); 
                    // InternalGT.g:1069:3: ( rule__EditorGTFile__PatternsAssignment_1_0 )
                    // InternalGT.g:1069:4: rule__EditorGTFile__PatternsAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorGTFile__PatternsAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorGTFileAccess().getPatternsAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1073:2: ( ( rule__EditorGTFile__ConditionsAssignment_1_1 ) )
                    {
                    // InternalGT.g:1073:2: ( ( rule__EditorGTFile__ConditionsAssignment_1_1 ) )
                    // InternalGT.g:1074:3: ( rule__EditorGTFile__ConditionsAssignment_1_1 )
                    {
                     before(grammarAccess.getEditorGTFileAccess().getConditionsAssignment_1_1()); 
                    // InternalGT.g:1075:3: ( rule__EditorGTFile__ConditionsAssignment_1_1 )
                    // InternalGT.g:1075:4: rule__EditorGTFile__ConditionsAssignment_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorGTFile__ConditionsAssignment_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorGTFileAccess().getConditionsAssignment_1_1()); 

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
    // $ANTLR end "rule__EditorGTFile__Alternatives_1"


    // $ANTLR start "rule__EditorPattern__Alternatives_5_1"
    // InternalGT.g:1083:1: rule__EditorPattern__Alternatives_5_1 : ( ( ( rule__EditorPattern__NodesAssignment_5_1_0 ) ) | ( ( rule__EditorPattern__AttributeConstraintsAssignment_5_1_1 ) ) );
    public final void rule__EditorPattern__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1087:1: ( ( ( rule__EditorPattern__NodesAssignment_5_1_0 ) ) | ( ( rule__EditorPattern__AttributeConstraintsAssignment_5_1_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||(LA2_0>=15 && LA2_0<=17)||LA2_0==69) ) {
                alt2=1;
            }
            else if ( (LA2_0==54) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalGT.g:1088:2: ( ( rule__EditorPattern__NodesAssignment_5_1_0 ) )
                    {
                    // InternalGT.g:1088:2: ( ( rule__EditorPattern__NodesAssignment_5_1_0 ) )
                    // InternalGT.g:1089:3: ( rule__EditorPattern__NodesAssignment_5_1_0 )
                    {
                     before(grammarAccess.getEditorPatternAccess().getNodesAssignment_5_1_0()); 
                    // InternalGT.g:1090:3: ( rule__EditorPattern__NodesAssignment_5_1_0 )
                    // InternalGT.g:1090:4: rule__EditorPattern__NodesAssignment_5_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__NodesAssignment_5_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorPatternAccess().getNodesAssignment_5_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1094:2: ( ( rule__EditorPattern__AttributeConstraintsAssignment_5_1_1 ) )
                    {
                    // InternalGT.g:1094:2: ( ( rule__EditorPattern__AttributeConstraintsAssignment_5_1_1 ) )
                    // InternalGT.g:1095:3: ( rule__EditorPattern__AttributeConstraintsAssignment_5_1_1 )
                    {
                     before(grammarAccess.getEditorPatternAccess().getAttributeConstraintsAssignment_5_1_1()); 
                    // InternalGT.g:1096:3: ( rule__EditorPattern__AttributeConstraintsAssignment_5_1_1 )
                    // InternalGT.g:1096:4: rule__EditorPattern__AttributeConstraintsAssignment_5_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__AttributeConstraintsAssignment_5_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorPatternAccess().getAttributeConstraintsAssignment_5_1_1()); 

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
    // $ANTLR end "rule__EditorPattern__Alternatives_5_1"


    // $ANTLR start "rule__EditorNode__Alternatives_5_1"
    // InternalGT.g:1104:1: rule__EditorNode__Alternatives_5_1 : ( ( ( rule__EditorNode__AttributesAssignment_5_1_0 ) ) | ( ( rule__EditorNode__ReferencesAssignment_5_1_1 ) ) | ( ( rule__EditorNode__IteratorsAssignment_5_1_2 ) ) );
    public final void rule__EditorNode__Alternatives_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1108:1: ( ( ( rule__EditorNode__AttributesAssignment_5_1_0 ) ) | ( ( rule__EditorNode__ReferencesAssignment_5_1_1 ) ) | ( ( rule__EditorNode__IteratorsAssignment_5_1_2 ) ) )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt3=1;
                }
                break;
            case 15:
            case 16:
            case 17:
            case 27:
                {
                alt3=2;
                }
                break;
            case 61:
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
                    // InternalGT.g:1109:2: ( ( rule__EditorNode__AttributesAssignment_5_1_0 ) )
                    {
                    // InternalGT.g:1109:2: ( ( rule__EditorNode__AttributesAssignment_5_1_0 ) )
                    // InternalGT.g:1110:3: ( rule__EditorNode__AttributesAssignment_5_1_0 )
                    {
                     before(grammarAccess.getEditorNodeAccess().getAttributesAssignment_5_1_0()); 
                    // InternalGT.g:1111:3: ( rule__EditorNode__AttributesAssignment_5_1_0 )
                    // InternalGT.g:1111:4: rule__EditorNode__AttributesAssignment_5_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorNode__AttributesAssignment_5_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorNodeAccess().getAttributesAssignment_5_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1115:2: ( ( rule__EditorNode__ReferencesAssignment_5_1_1 ) )
                    {
                    // InternalGT.g:1115:2: ( ( rule__EditorNode__ReferencesAssignment_5_1_1 ) )
                    // InternalGT.g:1116:3: ( rule__EditorNode__ReferencesAssignment_5_1_1 )
                    {
                     before(grammarAccess.getEditorNodeAccess().getReferencesAssignment_5_1_1()); 
                    // InternalGT.g:1117:3: ( rule__EditorNode__ReferencesAssignment_5_1_1 )
                    // InternalGT.g:1117:4: rule__EditorNode__ReferencesAssignment_5_1_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorNode__ReferencesAssignment_5_1_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorNodeAccess().getReferencesAssignment_5_1_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1121:2: ( ( rule__EditorNode__IteratorsAssignment_5_1_2 ) )
                    {
                    // InternalGT.g:1121:2: ( ( rule__EditorNode__IteratorsAssignment_5_1_2 ) )
                    // InternalGT.g:1122:3: ( rule__EditorNode__IteratorsAssignment_5_1_2 )
                    {
                     before(grammarAccess.getEditorNodeAccess().getIteratorsAssignment_5_1_2()); 
                    // InternalGT.g:1123:3: ( rule__EditorNode__IteratorsAssignment_5_1_2 )
                    // InternalGT.g:1123:4: rule__EditorNode__IteratorsAssignment_5_1_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorNode__IteratorsAssignment_5_1_2();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorNodeAccess().getIteratorsAssignment_5_1_2()); 

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
    // $ANTLR end "rule__EditorNode__Alternatives_5_1"


    // $ANTLR start "rule__EditorExpression__Alternatives"
    // InternalGT.g:1131:1: rule__EditorExpression__Alternatives : ( ( ruleEditorEnumExpression ) | ( ruleEditorParameterExpression ) | ( ruleStochasticFunctionExpression ) | ( ruleArithmeticCalculationExpression ) );
    public final void rule__EditorExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1135:1: ( ( ruleEditorEnumExpression ) | ( ruleEditorParameterExpression ) | ( ruleStochasticFunctionExpression ) | ( ruleArithmeticCalculationExpression ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt4=1;
                }
                break;
            case 59:
                {
                alt4=2;
                }
                break;
            case 26:
            case 28:
            case 29:
            case 30:
                {
                alt4=3;
                }
                break;
            case 27:
                {
                int LA4_4 = input.LA(2);

                if ( ((LA4_4>=28 && LA4_4<=30)) ) {
                    alt4=3;
                }
                else if ( (LA4_4==RULE_INT||(LA4_4>=36 && LA4_4<=43)||LA4_4==45) ) {
                    alt4=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_ID:
            case 11:
            case 12:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
            case 57:
            case 62:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalGT.g:1136:2: ( ruleEditorEnumExpression )
                    {
                    // InternalGT.g:1136:2: ( ruleEditorEnumExpression )
                    // InternalGT.g:1137:3: ruleEditorEnumExpression
                    {
                     before(grammarAccess.getEditorExpressionAccess().getEditorEnumExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorEnumExpression();

                    state._fsp--;

                     after(grammarAccess.getEditorExpressionAccess().getEditorEnumExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1142:2: ( ruleEditorParameterExpression )
                    {
                    // InternalGT.g:1142:2: ( ruleEditorParameterExpression )
                    // InternalGT.g:1143:3: ruleEditorParameterExpression
                    {
                     before(grammarAccess.getEditorExpressionAccess().getEditorParameterExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorParameterExpression();

                    state._fsp--;

                     after(grammarAccess.getEditorExpressionAccess().getEditorParameterExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1148:2: ( ruleStochasticFunctionExpression )
                    {
                    // InternalGT.g:1148:2: ( ruleStochasticFunctionExpression )
                    // InternalGT.g:1149:3: ruleStochasticFunctionExpression
                    {
                     before(grammarAccess.getEditorExpressionAccess().getStochasticFunctionExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleStochasticFunctionExpression();

                    state._fsp--;

                     after(grammarAccess.getEditorExpressionAccess().getStochasticFunctionExpressionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalGT.g:1154:2: ( ruleArithmeticCalculationExpression )
                    {
                    // InternalGT.g:1154:2: ( ruleArithmeticCalculationExpression )
                    // InternalGT.g:1155:3: ruleArithmeticCalculationExpression
                    {
                     before(grammarAccess.getEditorExpressionAccess().getArithmeticCalculationExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleArithmeticCalculationExpression();

                    state._fsp--;

                     after(grammarAccess.getEditorExpressionAccess().getArithmeticCalculationExpressionParserRuleCall_3()); 

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
    // $ANTLR end "rule__EditorExpression__Alternatives"


    // $ANTLR start "rule__EditorLiteralExpression__Alternatives"
    // InternalGT.g:1164:1: rule__EditorLiteralExpression__Alternatives : ( ( ( rule__EditorLiteralExpression__ValueAssignment_0 ) ) | ( ( rule__EditorLiteralExpression__Group_1__0 ) ) );
    public final void rule__EditorLiteralExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1168:1: ( ( ( rule__EditorLiteralExpression__ValueAssignment_0 ) ) | ( ( rule__EditorLiteralExpression__Group_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_INT||(LA5_0>=11 && LA5_0<=12)||LA5_0==27) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_STRING) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalGT.g:1169:2: ( ( rule__EditorLiteralExpression__ValueAssignment_0 ) )
                    {
                    // InternalGT.g:1169:2: ( ( rule__EditorLiteralExpression__ValueAssignment_0 ) )
                    // InternalGT.g:1170:3: ( rule__EditorLiteralExpression__ValueAssignment_0 )
                    {
                     before(grammarAccess.getEditorLiteralExpressionAccess().getValueAssignment_0()); 
                    // InternalGT.g:1171:3: ( rule__EditorLiteralExpression__ValueAssignment_0 )
                    // InternalGT.g:1171:4: rule__EditorLiteralExpression__ValueAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorLiteralExpression__ValueAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorLiteralExpressionAccess().getValueAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1175:2: ( ( rule__EditorLiteralExpression__Group_1__0 ) )
                    {
                    // InternalGT.g:1175:2: ( ( rule__EditorLiteralExpression__Group_1__0 ) )
                    // InternalGT.g:1176:3: ( rule__EditorLiteralExpression__Group_1__0 )
                    {
                     before(grammarAccess.getEditorLiteralExpressionAccess().getGroup_1()); 
                    // InternalGT.g:1177:3: ( rule__EditorLiteralExpression__Group_1__0 )
                    // InternalGT.g:1177:4: rule__EditorLiteralExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorLiteralExpression__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorLiteralExpressionAccess().getGroup_1()); 

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
    // $ANTLR end "rule__EditorLiteralExpression__Alternatives"


    // $ANTLR start "rule__EditorLiteralExpression__ValueAlternatives_0_0"
    // InternalGT.g:1185:1: rule__EditorLiteralExpression__ValueAlternatives_0_0 : ( ( 'true' ) | ( 'false' ) | ( ruleNumber ) );
    public final void rule__EditorLiteralExpression__ValueAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1189:1: ( ( 'true' ) | ( 'false' ) | ( ruleNumber ) )
            int alt6=3;
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
            case RULE_INT:
            case 27:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalGT.g:1190:2: ( 'true' )
                    {
                    // InternalGT.g:1190:2: ( 'true' )
                    // InternalGT.g:1191:3: 'true'
                    {
                     before(grammarAccess.getEditorLiteralExpressionAccess().getValueTrueKeyword_0_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEditorLiteralExpressionAccess().getValueTrueKeyword_0_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1196:2: ( 'false' )
                    {
                    // InternalGT.g:1196:2: ( 'false' )
                    // InternalGT.g:1197:3: 'false'
                    {
                     before(grammarAccess.getEditorLiteralExpressionAccess().getValueFalseKeyword_0_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEditorLiteralExpressionAccess().getValueFalseKeyword_0_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1202:2: ( ruleNumber )
                    {
                    // InternalGT.g:1202:2: ( ruleNumber )
                    // InternalGT.g:1203:3: ruleNumber
                    {
                     before(grammarAccess.getEditorLiteralExpressionAccess().getValueNumberParserRuleCall_0_0_2()); 
                    pushFollow(FOLLOW_2);
                    ruleNumber();

                    state._fsp--;

                     after(grammarAccess.getEditorLiteralExpressionAccess().getValueNumberParserRuleCall_0_0_2()); 

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
    // $ANTLR end "rule__EditorLiteralExpression__ValueAlternatives_0_0"


    // $ANTLR start "rule__EditorReferenceIterator__Alternatives_6"
    // InternalGT.g:1212:1: rule__EditorReferenceIterator__Alternatives_6 : ( ( ( rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0 ) ) | ( ( rule__EditorReferenceIterator__ReferencesAssignment_6_1 ) ) );
    public final void rule__EditorReferenceIterator__Alternatives_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1216:1: ( ( ( rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0 ) ) | ( ( rule__EditorReferenceIterator__ReferencesAssignment_6_1 ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID||LA7_0==62) ) {
                alt7=1;
            }
            else if ( ((LA7_0>=15 && LA7_0<=17)) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalGT.g:1217:2: ( ( rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0 ) )
                    {
                    // InternalGT.g:1217:2: ( ( rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0 ) )
                    // InternalGT.g:1218:3: ( rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0 )
                    {
                     before(grammarAccess.getEditorReferenceIteratorAccess().getIteratorAttributesAssignment_6_0()); 
                    // InternalGT.g:1219:3: ( rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0 )
                    // InternalGT.g:1219:4: rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorReferenceIteratorAccess().getIteratorAttributesAssignment_6_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1223:2: ( ( rule__EditorReferenceIterator__ReferencesAssignment_6_1 ) )
                    {
                    // InternalGT.g:1223:2: ( ( rule__EditorReferenceIterator__ReferencesAssignment_6_1 ) )
                    // InternalGT.g:1224:3: ( rule__EditorReferenceIterator__ReferencesAssignment_6_1 )
                    {
                     before(grammarAccess.getEditorReferenceIteratorAccess().getReferencesAssignment_6_1()); 
                    // InternalGT.g:1225:3: ( rule__EditorReferenceIterator__ReferencesAssignment_6_1 )
                    // InternalGT.g:1225:4: rule__EditorReferenceIterator__ReferencesAssignment_6_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorReferenceIterator__ReferencesAssignment_6_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorReferenceIteratorAccess().getReferencesAssignment_6_1()); 

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
    // $ANTLR end "rule__EditorReferenceIterator__Alternatives_6"


    // $ANTLR start "rule__EditorIteratorAttributeAssignment__Alternatives"
    // InternalGT.g:1233:1: rule__EditorIteratorAttributeAssignment__Alternatives : ( ( ruleEditorIteratorAttributeAssignmentItr ) | ( ruleEditorIteratorAttributeAssignmentNode ) );
    public final void rule__EditorIteratorAttributeAssignment__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1237:1: ( ( ruleEditorIteratorAttributeAssignmentItr ) | ( ruleEditorIteratorAttributeAssignmentNode ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==62) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalGT.g:1238:2: ( ruleEditorIteratorAttributeAssignmentItr )
                    {
                    // InternalGT.g:1238:2: ( ruleEditorIteratorAttributeAssignmentItr )
                    // InternalGT.g:1239:3: ruleEditorIteratorAttributeAssignmentItr
                    {
                     before(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getEditorIteratorAttributeAssignmentItrParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorIteratorAttributeAssignmentItr();

                    state._fsp--;

                     after(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getEditorIteratorAttributeAssignmentItrParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1244:2: ( ruleEditorIteratorAttributeAssignmentNode )
                    {
                    // InternalGT.g:1244:2: ( ruleEditorIteratorAttributeAssignmentNode )
                    // InternalGT.g:1245:3: ruleEditorIteratorAttributeAssignmentNode
                    {
                     before(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getEditorIteratorAttributeAssignmentNodeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorIteratorAttributeAssignmentNode();

                    state._fsp--;

                     after(grammarAccess.getEditorIteratorAttributeAssignmentAccess().getEditorIteratorAttributeAssignmentNodeParserRuleCall_1()); 

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
    // $ANTLR end "rule__EditorIteratorAttributeAssignment__Alternatives"


    // $ANTLR start "rule__EditorSimpleCondition__Alternatives"
    // InternalGT.g:1254:1: rule__EditorSimpleCondition__Alternatives : ( ( ( rule__EditorSimpleCondition__Group_0__0 ) ) | ( ( rule__EditorSimpleCondition__Group_1__0 ) ) );
    public final void rule__EditorSimpleCondition__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1258:1: ( ( ( rule__EditorSimpleCondition__Group_0__0 ) ) | ( ( rule__EditorSimpleCondition__Group_1__0 ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=24 && LA9_0<=25)) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalGT.g:1259:2: ( ( rule__EditorSimpleCondition__Group_0__0 ) )
                    {
                    // InternalGT.g:1259:2: ( ( rule__EditorSimpleCondition__Group_0__0 ) )
                    // InternalGT.g:1260:3: ( rule__EditorSimpleCondition__Group_0__0 )
                    {
                     before(grammarAccess.getEditorSimpleConditionAccess().getGroup_0()); 
                    // InternalGT.g:1261:3: ( rule__EditorSimpleCondition__Group_0__0 )
                    // InternalGT.g:1261:4: rule__EditorSimpleCondition__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorSimpleCondition__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorSimpleConditionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1265:2: ( ( rule__EditorSimpleCondition__Group_1__0 ) )
                    {
                    // InternalGT.g:1265:2: ( ( rule__EditorSimpleCondition__Group_1__0 ) )
                    // InternalGT.g:1266:3: ( rule__EditorSimpleCondition__Group_1__0 )
                    {
                     before(grammarAccess.getEditorSimpleConditionAccess().getGroup_1()); 
                    // InternalGT.g:1267:3: ( rule__EditorSimpleCondition__Group_1__0 )
                    // InternalGT.g:1267:4: rule__EditorSimpleCondition__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorSimpleCondition__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEditorSimpleConditionAccess().getGroup_1()); 

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
    // $ANTLR end "rule__EditorSimpleCondition__Alternatives"


    // $ANTLR start "rule__EditorProbability__Alternatives"
    // InternalGT.g:1275:1: rule__EditorProbability__Alternatives : ( ( ruleStochasticFunction ) | ( ruleArithmeticExpression ) );
    public final void rule__EditorProbability__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1279:1: ( ( ruleStochasticFunction ) | ( ruleArithmeticExpression ) )
            int alt10=2;
            switch ( input.LA(1) ) {
            case 26:
            case 28:
            case 29:
            case 30:
                {
                alt10=1;
                }
                break;
            case 27:
                {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==RULE_INT||(LA10_2>=36 && LA10_2<=43)||LA10_2==45) ) {
                    alt10=2;
                }
                else if ( ((LA10_2>=28 && LA10_2<=30)) ) {
                    alt10=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_ID:
            case 11:
            case 12:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
            case 57:
            case 62:
                {
                alt10=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalGT.g:1280:2: ( ruleStochasticFunction )
                    {
                    // InternalGT.g:1280:2: ( ruleStochasticFunction )
                    // InternalGT.g:1281:3: ruleStochasticFunction
                    {
                     before(grammarAccess.getEditorProbabilityAccess().getStochasticFunctionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleStochasticFunction();

                    state._fsp--;

                     after(grammarAccess.getEditorProbabilityAccess().getStochasticFunctionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1286:2: ( ruleArithmeticExpression )
                    {
                    // InternalGT.g:1286:2: ( ruleArithmeticExpression )
                    // InternalGT.g:1287:3: ruleArithmeticExpression
                    {
                     before(grammarAccess.getEditorProbabilityAccess().getArithmeticExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleArithmeticExpression();

                    state._fsp--;

                     after(grammarAccess.getEditorProbabilityAccess().getArithmeticExpressionParserRuleCall_1()); 

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
    // $ANTLR end "rule__EditorProbability__Alternatives"


    // $ANTLR start "rule__ExpExpression__Alternatives_0"
    // InternalGT.g:1296:1: rule__ExpExpression__Alternatives_0 : ( ( ruleMinMaxExpression ) | ( ruleOneParameterArithmetics ) );
    public final void rule__ExpExpression__Alternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1300:1: ( ( ruleMinMaxExpression ) | ( ruleOneParameterArithmetics ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=34 && LA11_0<=35)) ) {
                alt11=1;
            }
            else if ( ((LA11_0>=RULE_INT && LA11_0<=RULE_ID)||(LA11_0>=11 && LA11_0<=12)||LA11_0==27||(LA11_0>=36 && LA11_0<=43)||LA11_0==45||LA11_0==57||LA11_0==62) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalGT.g:1301:2: ( ruleMinMaxExpression )
                    {
                    // InternalGT.g:1301:2: ( ruleMinMaxExpression )
                    // InternalGT.g:1302:3: ruleMinMaxExpression
                    {
                     before(grammarAccess.getExpExpressionAccess().getMinMaxExpressionParserRuleCall_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMinMaxExpression();

                    state._fsp--;

                     after(grammarAccess.getExpExpressionAccess().getMinMaxExpressionParserRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1307:2: ( ruleOneParameterArithmetics )
                    {
                    // InternalGT.g:1307:2: ( ruleOneParameterArithmetics )
                    // InternalGT.g:1308:3: ruleOneParameterArithmetics
                    {
                     before(grammarAccess.getExpExpressionAccess().getOneParameterArithmeticsParserRuleCall_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOneParameterArithmetics();

                    state._fsp--;

                     after(grammarAccess.getExpExpressionAccess().getOneParameterArithmeticsParserRuleCall_0_1()); 

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
    // $ANTLR end "rule__ExpExpression__Alternatives_0"


    // $ANTLR start "rule__ExpExpression__RightAlternatives_1_2_0"
    // InternalGT.g:1317:1: rule__ExpExpression__RightAlternatives_1_2_0 : ( ( ruleMinMaxExpression ) | ( ruleOneParameterArithmetics ) );
    public final void rule__ExpExpression__RightAlternatives_1_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1321:1: ( ( ruleMinMaxExpression ) | ( ruleOneParameterArithmetics ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=34 && LA12_0<=35)) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=RULE_INT && LA12_0<=RULE_ID)||(LA12_0>=11 && LA12_0<=12)||LA12_0==27||(LA12_0>=36 && LA12_0<=43)||LA12_0==45||LA12_0==57||LA12_0==62) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalGT.g:1322:2: ( ruleMinMaxExpression )
                    {
                    // InternalGT.g:1322:2: ( ruleMinMaxExpression )
                    // InternalGT.g:1323:3: ruleMinMaxExpression
                    {
                     before(grammarAccess.getExpExpressionAccess().getRightMinMaxExpressionParserRuleCall_1_2_0_0()); 
                    pushFollow(FOLLOW_2);
                    ruleMinMaxExpression();

                    state._fsp--;

                     after(grammarAccess.getExpExpressionAccess().getRightMinMaxExpressionParserRuleCall_1_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1328:2: ( ruleOneParameterArithmetics )
                    {
                    // InternalGT.g:1328:2: ( ruleOneParameterArithmetics )
                    // InternalGT.g:1329:3: ruleOneParameterArithmetics
                    {
                     before(grammarAccess.getExpExpressionAccess().getRightOneParameterArithmeticsParserRuleCall_1_2_0_1()); 
                    pushFollow(FOLLOW_2);
                    ruleOneParameterArithmetics();

                    state._fsp--;

                     after(grammarAccess.getExpExpressionAccess().getRightOneParameterArithmeticsParserRuleCall_1_2_0_1()); 

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
    // $ANTLR end "rule__ExpExpression__RightAlternatives_1_2_0"


    // $ANTLR start "rule__OneParameterArithmetics__Alternatives"
    // InternalGT.g:1338:1: rule__OneParameterArithmetics__Alternatives : ( ( ( rule__OneParameterArithmetics__Group_0__0 ) ) | ( ruleArithmeticAttribute ) );
    public final void rule__OneParameterArithmetics__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1342:1: ( ( ( rule__OneParameterArithmetics__Group_0__0 ) ) | ( ruleArithmeticAttribute ) )
            int alt13=2;
            switch ( input.LA(1) ) {
            case 27:
                {
                int LA13_1 = input.LA(2);

                if ( ((LA13_1>=36 && LA13_1<=43)||LA13_1==45) ) {
                    alt13=1;
                }
                else if ( (LA13_1==RULE_INT) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
                }
                break;
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 45:
                {
                alt13=1;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case RULE_ID:
            case 11:
            case 12:
            case 57:
            case 62:
                {
                alt13=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalGT.g:1343:2: ( ( rule__OneParameterArithmetics__Group_0__0 ) )
                    {
                    // InternalGT.g:1343:2: ( ( rule__OneParameterArithmetics__Group_0__0 ) )
                    // InternalGT.g:1344:3: ( rule__OneParameterArithmetics__Group_0__0 )
                    {
                     before(grammarAccess.getOneParameterArithmeticsAccess().getGroup_0()); 
                    // InternalGT.g:1345:3: ( rule__OneParameterArithmetics__Group_0__0 )
                    // InternalGT.g:1345:4: rule__OneParameterArithmetics__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OneParameterArithmetics__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getOneParameterArithmeticsAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1349:2: ( ruleArithmeticAttribute )
                    {
                    // InternalGT.g:1349:2: ( ruleArithmeticAttribute )
                    // InternalGT.g:1350:3: ruleArithmeticAttribute
                    {
                     before(grammarAccess.getOneParameterArithmeticsAccess().getArithmeticAttributeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleArithmeticAttribute();

                    state._fsp--;

                     after(grammarAccess.getOneParameterArithmeticsAccess().getArithmeticAttributeParserRuleCall_1()); 

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
    // $ANTLR end "rule__OneParameterArithmetics__Alternatives"


    // $ANTLR start "rule__ArithmeticAttribute__Alternatives"
    // InternalGT.g:1359:1: rule__ArithmeticAttribute__Alternatives : ( ( ruleEditorLiteralExpression ) | ( ruleEditorAttributeExpression ) | ( ruleEditorIteratorAttributeExpression ) | ( ruleEditorCountExpression ) );
    public final void rule__ArithmeticAttribute__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1363:1: ( ( ruleEditorLiteralExpression ) | ( ruleEditorAttributeExpression ) | ( ruleEditorIteratorAttributeExpression ) | ( ruleEditorCountExpression ) )
            int alt14=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
            case RULE_STRING:
            case 11:
            case 12:
            case 27:
                {
                alt14=1;
                }
                break;
            case RULE_ID:
                {
                alt14=2;
                }
                break;
            case 62:
                {
                alt14=3;
                }
                break;
            case 57:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // InternalGT.g:1364:2: ( ruleEditorLiteralExpression )
                    {
                    // InternalGT.g:1364:2: ( ruleEditorLiteralExpression )
                    // InternalGT.g:1365:3: ruleEditorLiteralExpression
                    {
                     before(grammarAccess.getArithmeticAttributeAccess().getEditorLiteralExpressionParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorLiteralExpression();

                    state._fsp--;

                     after(grammarAccess.getArithmeticAttributeAccess().getEditorLiteralExpressionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1370:2: ( ruleEditorAttributeExpression )
                    {
                    // InternalGT.g:1370:2: ( ruleEditorAttributeExpression )
                    // InternalGT.g:1371:3: ruleEditorAttributeExpression
                    {
                     before(grammarAccess.getArithmeticAttributeAccess().getEditorAttributeExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorAttributeExpression();

                    state._fsp--;

                     after(grammarAccess.getArithmeticAttributeAccess().getEditorAttributeExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1376:2: ( ruleEditorIteratorAttributeExpression )
                    {
                    // InternalGT.g:1376:2: ( ruleEditorIteratorAttributeExpression )
                    // InternalGT.g:1377:3: ruleEditorIteratorAttributeExpression
                    {
                     before(grammarAccess.getArithmeticAttributeAccess().getEditorIteratorAttributeExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorIteratorAttributeExpression();

                    state._fsp--;

                     after(grammarAccess.getArithmeticAttributeAccess().getEditorIteratorAttributeExpressionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalGT.g:1382:2: ( ruleEditorCountExpression )
                    {
                    // InternalGT.g:1382:2: ( ruleEditorCountExpression )
                    // InternalGT.g:1383:3: ruleEditorCountExpression
                    {
                     before(grammarAccess.getArithmeticAttributeAccess().getEditorCountExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleEditorCountExpression();

                    state._fsp--;

                     after(grammarAccess.getArithmeticAttributeAccess().getEditorCountExpressionParserRuleCall_3()); 

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
    // $ANTLR end "rule__ArithmeticAttribute__Alternatives"


    // $ANTLR start "rule__EditorPatternType__Alternatives"
    // InternalGT.g:1392:1: rule__EditorPatternType__Alternatives : ( ( ( 'pattern' ) ) | ( ( 'rule' ) ) );
    public final void rule__EditorPatternType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1396:1: ( ( ( 'pattern' ) ) | ( ( 'rule' ) ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            else if ( (LA15_0==14) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalGT.g:1397:2: ( ( 'pattern' ) )
                    {
                    // InternalGT.g:1397:2: ( ( 'pattern' ) )
                    // InternalGT.g:1398:3: ( 'pattern' )
                    {
                     before(grammarAccess.getEditorPatternTypeAccess().getPATTERNEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1399:3: ( 'pattern' )
                    // InternalGT.g:1399:4: 'pattern'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorPatternTypeAccess().getPATTERNEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1403:2: ( ( 'rule' ) )
                    {
                    // InternalGT.g:1403:2: ( ( 'rule' ) )
                    // InternalGT.g:1404:3: ( 'rule' )
                    {
                     before(grammarAccess.getEditorPatternTypeAccess().getRULEEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1405:3: ( 'rule' )
                    // InternalGT.g:1405:4: 'rule'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorPatternTypeAccess().getRULEEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__EditorPatternType__Alternatives"


    // $ANTLR start "rule__EditorOperator__Alternatives"
    // InternalGT.g:1413:1: rule__EditorOperator__Alternatives : ( ( ( '$context' ) ) | ( ( '++' ) ) | ( ( '--' ) ) );
    public final void rule__EditorOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1417:1: ( ( ( '$context' ) ) | ( ( '++' ) ) | ( ( '--' ) ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt16=1;
                }
                break;
            case 16:
                {
                alt16=2;
                }
                break;
            case 17:
                {
                alt16=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalGT.g:1418:2: ( ( '$context' ) )
                    {
                    // InternalGT.g:1418:2: ( ( '$context' ) )
                    // InternalGT.g:1419:3: ( '$context' )
                    {
                     before(grammarAccess.getEditorOperatorAccess().getCONTEXTEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1420:3: ( '$context' )
                    // InternalGT.g:1420:4: '$context'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorOperatorAccess().getCONTEXTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1424:2: ( ( '++' ) )
                    {
                    // InternalGT.g:1424:2: ( ( '++' ) )
                    // InternalGT.g:1425:3: ( '++' )
                    {
                     before(grammarAccess.getEditorOperatorAccess().getCREATEEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1426:3: ( '++' )
                    // InternalGT.g:1426:4: '++'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorOperatorAccess().getCREATEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1430:2: ( ( '--' ) )
                    {
                    // InternalGT.g:1430:2: ( ( '--' ) )
                    // InternalGT.g:1431:3: ( '--' )
                    {
                     before(grammarAccess.getEditorOperatorAccess().getDELETEEnumLiteralDeclaration_2()); 
                    // InternalGT.g:1432:3: ( '--' )
                    // InternalGT.g:1432:4: '--'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorOperatorAccess().getDELETEEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__EditorOperator__Alternatives"


    // $ANTLR start "rule__EditorRelation__Alternatives"
    // InternalGT.g:1440:1: rule__EditorRelation__Alternatives : ( ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<=' ) ) | ( ( '<' ) ) );
    public final void rule__EditorRelation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1444:1: ( ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<=' ) ) | ( ( '<' ) ) )
            int alt17=6;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt17=1;
                }
                break;
            case 19:
                {
                alt17=2;
                }
                break;
            case 20:
                {
                alt17=3;
                }
                break;
            case 21:
                {
                alt17=4;
                }
                break;
            case 22:
                {
                alt17=5;
                }
                break;
            case 23:
                {
                alt17=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalGT.g:1445:2: ( ( '>' ) )
                    {
                    // InternalGT.g:1445:2: ( ( '>' ) )
                    // InternalGT.g:1446:3: ( '>' )
                    {
                     before(grammarAccess.getEditorRelationAccess().getGREATEREnumLiteralDeclaration_0()); 
                    // InternalGT.g:1447:3: ( '>' )
                    // InternalGT.g:1447:4: '>'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorRelationAccess().getGREATEREnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1451:2: ( ( '>=' ) )
                    {
                    // InternalGT.g:1451:2: ( ( '>=' ) )
                    // InternalGT.g:1452:3: ( '>=' )
                    {
                     before(grammarAccess.getEditorRelationAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1453:3: ( '>=' )
                    // InternalGT.g:1453:4: '>='
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorRelationAccess().getGREATER_OR_EQUALEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1457:2: ( ( '==' ) )
                    {
                    // InternalGT.g:1457:2: ( ( '==' ) )
                    // InternalGT.g:1458:3: ( '==' )
                    {
                     before(grammarAccess.getEditorRelationAccess().getEQUALEnumLiteralDeclaration_2()); 
                    // InternalGT.g:1459:3: ( '==' )
                    // InternalGT.g:1459:4: '=='
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorRelationAccess().getEQUALEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalGT.g:1463:2: ( ( '!=' ) )
                    {
                    // InternalGT.g:1463:2: ( ( '!=' ) )
                    // InternalGT.g:1464:3: ( '!=' )
                    {
                     before(grammarAccess.getEditorRelationAccess().getUNEQUALEnumLiteralDeclaration_3()); 
                    // InternalGT.g:1465:3: ( '!=' )
                    // InternalGT.g:1465:4: '!='
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorRelationAccess().getUNEQUALEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalGT.g:1469:2: ( ( '<=' ) )
                    {
                    // InternalGT.g:1469:2: ( ( '<=' ) )
                    // InternalGT.g:1470:3: ( '<=' )
                    {
                     before(grammarAccess.getEditorRelationAccess().getSMALLER_OR_EQUALEnumLiteralDeclaration_4()); 
                    // InternalGT.g:1471:3: ( '<=' )
                    // InternalGT.g:1471:4: '<='
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorRelationAccess().getSMALLER_OR_EQUALEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalGT.g:1475:2: ( ( '<' ) )
                    {
                    // InternalGT.g:1475:2: ( ( '<' ) )
                    // InternalGT.g:1476:3: ( '<' )
                    {
                     before(grammarAccess.getEditorRelationAccess().getSMALLEREnumLiteralDeclaration_5()); 
                    // InternalGT.g:1477:3: ( '<' )
                    // InternalGT.g:1477:4: '<'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorRelationAccess().getSMALLEREnumLiteralDeclaration_5()); 

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
    // $ANTLR end "rule__EditorRelation__Alternatives"


    // $ANTLR start "rule__EditorApplicationConditionType__Alternatives"
    // InternalGT.g:1485:1: rule__EditorApplicationConditionType__Alternatives : ( ( ( 'enforce' ) ) | ( ( 'forbid' ) ) );
    public final void rule__EditorApplicationConditionType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1489:1: ( ( ( 'enforce' ) ) | ( ( 'forbid' ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            else if ( (LA18_0==25) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalGT.g:1490:2: ( ( 'enforce' ) )
                    {
                    // InternalGT.g:1490:2: ( ( 'enforce' ) )
                    // InternalGT.g:1491:3: ( 'enforce' )
                    {
                     before(grammarAccess.getEditorApplicationConditionTypeAccess().getPOSITIVEEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1492:3: ( 'enforce' )
                    // InternalGT.g:1492:4: 'enforce'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorApplicationConditionTypeAccess().getPOSITIVEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1496:2: ( ( 'forbid' ) )
                    {
                    // InternalGT.g:1496:2: ( ( 'forbid' ) )
                    // InternalGT.g:1497:3: ( 'forbid' )
                    {
                     before(grammarAccess.getEditorApplicationConditionTypeAccess().getNEGATIVEEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1498:3: ( 'forbid' )
                    // InternalGT.g:1498:4: 'forbid'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getEditorApplicationConditionTypeAccess().getNEGATIVEEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__EditorApplicationConditionType__Alternatives"


    // $ANTLR start "rule__StochasticRange__Alternatives"
    // InternalGT.g:1506:1: rule__StochasticRange__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__StochasticRange__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1510:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==26) ) {
                alt19=1;
            }
            else if ( (LA19_0==27) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalGT.g:1511:2: ( ( '+' ) )
                    {
                    // InternalGT.g:1511:2: ( ( '+' ) )
                    // InternalGT.g:1512:3: ( '+' )
                    {
                     before(grammarAccess.getStochasticRangeAccess().getPOSITIVEEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1513:3: ( '+' )
                    // InternalGT.g:1513:4: '+'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getStochasticRangeAccess().getPOSITIVEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1517:2: ( ( '-' ) )
                    {
                    // InternalGT.g:1517:2: ( ( '-' ) )
                    // InternalGT.g:1518:3: ( '-' )
                    {
                     before(grammarAccess.getStochasticRangeAccess().getNEGATIVEEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1519:3: ( '-' )
                    // InternalGT.g:1519:4: '-'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getStochasticRangeAccess().getNEGATIVEEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__StochasticRange__Alternatives"


    // $ANTLR start "rule__StochasticDistribution__Alternatives"
    // InternalGT.g:1527:1: rule__StochasticDistribution__Alternatives : ( ( ( 'N' ) ) | ( ( 'U' ) ) | ( ( 'Exp' ) ) );
    public final void rule__StochasticDistribution__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1531:1: ( ( ( 'N' ) ) | ( ( 'U' ) ) | ( ( 'Exp' ) ) )
            int alt20=3;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt20=1;
                }
                break;
            case 29:
                {
                alt20=2;
                }
                break;
            case 30:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalGT.g:1532:2: ( ( 'N' ) )
                    {
                    // InternalGT.g:1532:2: ( ( 'N' ) )
                    // InternalGT.g:1533:3: ( 'N' )
                    {
                     before(grammarAccess.getStochasticDistributionAccess().getNORMALEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1534:3: ( 'N' )
                    // InternalGT.g:1534:4: 'N'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getStochasticDistributionAccess().getNORMALEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1538:2: ( ( 'U' ) )
                    {
                    // InternalGT.g:1538:2: ( ( 'U' ) )
                    // InternalGT.g:1539:3: ( 'U' )
                    {
                     before(grammarAccess.getStochasticDistributionAccess().getUNIFORMEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1540:3: ( 'U' )
                    // InternalGT.g:1540:4: 'U'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getStochasticDistributionAccess().getUNIFORMEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1544:2: ( ( 'Exp' ) )
                    {
                    // InternalGT.g:1544:2: ( ( 'Exp' ) )
                    // InternalGT.g:1545:3: ( 'Exp' )
                    {
                     before(grammarAccess.getStochasticDistributionAccess().getEXPONENTIALEnumLiteralDeclaration_2()); 
                    // InternalGT.g:1546:3: ( 'Exp' )
                    // InternalGT.g:1546:4: 'Exp'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getStochasticDistributionAccess().getEXPONENTIALEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__StochasticDistribution__Alternatives"


    // $ANTLR start "rule__MultOperator__Alternatives"
    // InternalGT.g:1554:1: rule__MultOperator__Alternatives : ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) );
    public final void rule__MultOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1558:1: ( ( ( '*' ) ) | ( ( '/' ) ) | ( ( '%' ) ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case 31:
                {
                alt21=1;
                }
                break;
            case 32:
                {
                alt21=2;
                }
                break;
            case 33:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // InternalGT.g:1559:2: ( ( '*' ) )
                    {
                    // InternalGT.g:1559:2: ( ( '*' ) )
                    // InternalGT.g:1560:3: ( '*' )
                    {
                     before(grammarAccess.getMultOperatorAccess().getMULTIPLICATIONEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1561:3: ( '*' )
                    // InternalGT.g:1561:4: '*'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultOperatorAccess().getMULTIPLICATIONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1565:2: ( ( '/' ) )
                    {
                    // InternalGT.g:1565:2: ( ( '/' ) )
                    // InternalGT.g:1566:3: ( '/' )
                    {
                     before(grammarAccess.getMultOperatorAccess().getDIVISIONEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1567:3: ( '/' )
                    // InternalGT.g:1567:4: '/'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultOperatorAccess().getDIVISIONEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1571:2: ( ( '%' ) )
                    {
                    // InternalGT.g:1571:2: ( ( '%' ) )
                    // InternalGT.g:1572:3: ( '%' )
                    {
                     before(grammarAccess.getMultOperatorAccess().getMODULOEnumLiteralDeclaration_2()); 
                    // InternalGT.g:1573:3: ( '%' )
                    // InternalGT.g:1573:4: '%'
                    {
                    match(input,33,FOLLOW_2); 

                    }

                     after(grammarAccess.getMultOperatorAccess().getMODULOEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__MultOperator__Alternatives"


    // $ANTLR start "rule__MinMaxOperator__Alternatives"
    // InternalGT.g:1581:1: rule__MinMaxOperator__Alternatives : ( ( ( 'min' ) ) | ( ( 'max' ) ) );
    public final void rule__MinMaxOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1585:1: ( ( ( 'min' ) ) | ( ( 'max' ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                alt22=1;
            }
            else if ( (LA22_0==35) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalGT.g:1586:2: ( ( 'min' ) )
                    {
                    // InternalGT.g:1586:2: ( ( 'min' ) )
                    // InternalGT.g:1587:3: ( 'min' )
                    {
                     before(grammarAccess.getMinMaxOperatorAccess().getMINEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1588:3: ( 'min' )
                    // InternalGT.g:1588:4: 'min'
                    {
                    match(input,34,FOLLOW_2); 

                    }

                     after(grammarAccess.getMinMaxOperatorAccess().getMINEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1592:2: ( ( 'max' ) )
                    {
                    // InternalGT.g:1592:2: ( ( 'max' ) )
                    // InternalGT.g:1593:3: ( 'max' )
                    {
                     before(grammarAccess.getMinMaxOperatorAccess().getMAXEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1594:3: ( 'max' )
                    // InternalGT.g:1594:4: 'max'
                    {
                    match(input,35,FOLLOW_2); 

                    }

                     after(grammarAccess.getMinMaxOperatorAccess().getMAXEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__MinMaxOperator__Alternatives"


    // $ANTLR start "rule__AddOperator__Alternatives"
    // InternalGT.g:1602:1: rule__AddOperator__Alternatives : ( ( ( '+' ) ) | ( ( '-' ) ) );
    public final void rule__AddOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1606:1: ( ( ( '+' ) ) | ( ( '-' ) ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==26) ) {
                alt23=1;
            }
            else if ( (LA23_0==27) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalGT.g:1607:2: ( ( '+' ) )
                    {
                    // InternalGT.g:1607:2: ( ( '+' ) )
                    // InternalGT.g:1608:3: ( '+' )
                    {
                     before(grammarAccess.getAddOperatorAccess().getADDITIONEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1609:3: ( '+' )
                    // InternalGT.g:1609:4: '+'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOperatorAccess().getADDITIONEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1613:2: ( ( '-' ) )
                    {
                    // InternalGT.g:1613:2: ( ( '-' ) )
                    // InternalGT.g:1614:3: ( '-' )
                    {
                     before(grammarAccess.getAddOperatorAccess().getSUBTRACTIONEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1615:3: ( '-' )
                    // InternalGT.g:1615:4: '-'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getAddOperatorAccess().getSUBTRACTIONEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__AddOperator__Alternatives"


    // $ANTLR start "rule__OneParameterOperator__Alternatives"
    // InternalGT.g:1623:1: rule__OneParameterOperator__Alternatives : ( ( ( 'sqrt' ) ) | ( ( 'abs' ) ) | ( ( 'sin' ) ) | ( ( 'cos' ) ) | ( ( 'tan' ) ) | ( ( 'exp' ) ) | ( ( 'log' ) ) | ( ( 'ln' ) ) );
    public final void rule__OneParameterOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1627:1: ( ( ( 'sqrt' ) ) | ( ( 'abs' ) ) | ( ( 'sin' ) ) | ( ( 'cos' ) ) | ( ( 'tan' ) ) | ( ( 'exp' ) ) | ( ( 'log' ) ) | ( ( 'ln' ) ) )
            int alt24=8;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt24=1;
                }
                break;
            case 37:
                {
                alt24=2;
                }
                break;
            case 38:
                {
                alt24=3;
                }
                break;
            case 39:
                {
                alt24=4;
                }
                break;
            case 40:
                {
                alt24=5;
                }
                break;
            case 41:
                {
                alt24=6;
                }
                break;
            case 42:
                {
                alt24=7;
                }
                break;
            case 43:
                {
                alt24=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalGT.g:1628:2: ( ( 'sqrt' ) )
                    {
                    // InternalGT.g:1628:2: ( ( 'sqrt' ) )
                    // InternalGT.g:1629:3: ( 'sqrt' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getROOTEnumLiteralDeclaration_0()); 
                    // InternalGT.g:1630:3: ( 'sqrt' )
                    // InternalGT.g:1630:4: 'sqrt'
                    {
                    match(input,36,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getROOTEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalGT.g:1634:2: ( ( 'abs' ) )
                    {
                    // InternalGT.g:1634:2: ( ( 'abs' ) )
                    // InternalGT.g:1635:3: ( 'abs' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getABSOLUTEEnumLiteralDeclaration_1()); 
                    // InternalGT.g:1636:3: ( 'abs' )
                    // InternalGT.g:1636:4: 'abs'
                    {
                    match(input,37,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getABSOLUTEEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalGT.g:1640:2: ( ( 'sin' ) )
                    {
                    // InternalGT.g:1640:2: ( ( 'sin' ) )
                    // InternalGT.g:1641:3: ( 'sin' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getSINEnumLiteralDeclaration_2()); 
                    // InternalGT.g:1642:3: ( 'sin' )
                    // InternalGT.g:1642:4: 'sin'
                    {
                    match(input,38,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getSINEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalGT.g:1646:2: ( ( 'cos' ) )
                    {
                    // InternalGT.g:1646:2: ( ( 'cos' ) )
                    // InternalGT.g:1647:3: ( 'cos' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getCOSEnumLiteralDeclaration_3()); 
                    // InternalGT.g:1648:3: ( 'cos' )
                    // InternalGT.g:1648:4: 'cos'
                    {
                    match(input,39,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getCOSEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalGT.g:1652:2: ( ( 'tan' ) )
                    {
                    // InternalGT.g:1652:2: ( ( 'tan' ) )
                    // InternalGT.g:1653:3: ( 'tan' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getTANEnumLiteralDeclaration_4()); 
                    // InternalGT.g:1654:3: ( 'tan' )
                    // InternalGT.g:1654:4: 'tan'
                    {
                    match(input,40,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getTANEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalGT.g:1658:2: ( ( 'exp' ) )
                    {
                    // InternalGT.g:1658:2: ( ( 'exp' ) )
                    // InternalGT.g:1659:3: ( 'exp' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getE_EXPONENTIALEnumLiteralDeclaration_5()); 
                    // InternalGT.g:1660:3: ( 'exp' )
                    // InternalGT.g:1660:4: 'exp'
                    {
                    match(input,41,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getE_EXPONENTIALEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalGT.g:1664:2: ( ( 'log' ) )
                    {
                    // InternalGT.g:1664:2: ( ( 'log' ) )
                    // InternalGT.g:1665:3: ( 'log' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getLOGARITHMUSEnumLiteralDeclaration_6()); 
                    // InternalGT.g:1666:3: ( 'log' )
                    // InternalGT.g:1666:4: 'log'
                    {
                    match(input,42,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getLOGARITHMUSEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalGT.g:1670:2: ( ( 'ln' ) )
                    {
                    // InternalGT.g:1670:2: ( ( 'ln' ) )
                    // InternalGT.g:1671:3: ( 'ln' )
                    {
                     before(grammarAccess.getOneParameterOperatorAccess().getNAT_LOGEnumLiteralDeclaration_7()); 
                    // InternalGT.g:1672:3: ( 'ln' )
                    // InternalGT.g:1672:4: 'ln'
                    {
                    match(input,43,FOLLOW_2); 

                    }

                     after(grammarAccess.getOneParameterOperatorAccess().getNAT_LOGEnumLiteralDeclaration_7()); 

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
    // $ANTLR end "rule__OneParameterOperator__Alternatives"


    // $ANTLR start "rule__EditorGTFile__Group__0"
    // InternalGT.g:1680:1: rule__EditorGTFile__Group__0 : rule__EditorGTFile__Group__0__Impl rule__EditorGTFile__Group__1 ;
    public final void rule__EditorGTFile__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1684:1: ( rule__EditorGTFile__Group__0__Impl rule__EditorGTFile__Group__1 )
            // InternalGT.g:1685:2: rule__EditorGTFile__Group__0__Impl rule__EditorGTFile__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__EditorGTFile__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorGTFile__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorGTFile__Group__0"


    // $ANTLR start "rule__EditorGTFile__Group__0__Impl"
    // InternalGT.g:1692:1: rule__EditorGTFile__Group__0__Impl : ( ( rule__EditorGTFile__ImportsAssignment_0 )* ) ;
    public final void rule__EditorGTFile__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1696:1: ( ( ( rule__EditorGTFile__ImportsAssignment_0 )* ) )
            // InternalGT.g:1697:1: ( ( rule__EditorGTFile__ImportsAssignment_0 )* )
            {
            // InternalGT.g:1697:1: ( ( rule__EditorGTFile__ImportsAssignment_0 )* )
            // InternalGT.g:1698:2: ( rule__EditorGTFile__ImportsAssignment_0 )*
            {
             before(grammarAccess.getEditorGTFileAccess().getImportsAssignment_0()); 
            // InternalGT.g:1699:2: ( rule__EditorGTFile__ImportsAssignment_0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==44) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalGT.g:1699:3: rule__EditorGTFile__ImportsAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__EditorGTFile__ImportsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getEditorGTFileAccess().getImportsAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorGTFile__Group__0__Impl"


    // $ANTLR start "rule__EditorGTFile__Group__1"
    // InternalGT.g:1707:1: rule__EditorGTFile__Group__1 : rule__EditorGTFile__Group__1__Impl ;
    public final void rule__EditorGTFile__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1711:1: ( rule__EditorGTFile__Group__1__Impl )
            // InternalGT.g:1712:2: rule__EditorGTFile__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorGTFile__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorGTFile__Group__1"


    // $ANTLR start "rule__EditorGTFile__Group__1__Impl"
    // InternalGT.g:1718:1: rule__EditorGTFile__Group__1__Impl : ( ( rule__EditorGTFile__Alternatives_1 )* ) ;
    public final void rule__EditorGTFile__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1722:1: ( ( ( rule__EditorGTFile__Alternatives_1 )* ) )
            // InternalGT.g:1723:1: ( ( rule__EditorGTFile__Alternatives_1 )* )
            {
            // InternalGT.g:1723:1: ( ( rule__EditorGTFile__Alternatives_1 )* )
            // InternalGT.g:1724:2: ( rule__EditorGTFile__Alternatives_1 )*
            {
             before(grammarAccess.getEditorGTFileAccess().getAlternatives_1()); 
            // InternalGT.g:1725:2: ( rule__EditorGTFile__Alternatives_1 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=13 && LA26_0<=14)||LA26_0==63||LA26_0==67) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalGT.g:1725:3: rule__EditorGTFile__Alternatives_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__EditorGTFile__Alternatives_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getEditorGTFileAccess().getAlternatives_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorGTFile__Group__1__Impl"


    // $ANTLR start "rule__EditorImport__Group__0"
    // InternalGT.g:1734:1: rule__EditorImport__Group__0 : rule__EditorImport__Group__0__Impl rule__EditorImport__Group__1 ;
    public final void rule__EditorImport__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1738:1: ( rule__EditorImport__Group__0__Impl rule__EditorImport__Group__1 )
            // InternalGT.g:1739:2: rule__EditorImport__Group__0__Impl rule__EditorImport__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__EditorImport__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorImport__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorImport__Group__0"


    // $ANTLR start "rule__EditorImport__Group__0__Impl"
    // InternalGT.g:1746:1: rule__EditorImport__Group__0__Impl : ( 'import' ) ;
    public final void rule__EditorImport__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1750:1: ( ( 'import' ) )
            // InternalGT.g:1751:1: ( 'import' )
            {
            // InternalGT.g:1751:1: ( 'import' )
            // InternalGT.g:1752:2: 'import'
            {
             before(grammarAccess.getEditorImportAccess().getImportKeyword_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEditorImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorImport__Group__0__Impl"


    // $ANTLR start "rule__EditorImport__Group__1"
    // InternalGT.g:1761:1: rule__EditorImport__Group__1 : rule__EditorImport__Group__1__Impl ;
    public final void rule__EditorImport__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1765:1: ( rule__EditorImport__Group__1__Impl )
            // InternalGT.g:1766:2: rule__EditorImport__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorImport__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorImport__Group__1"


    // $ANTLR start "rule__EditorImport__Group__1__Impl"
    // InternalGT.g:1772:1: rule__EditorImport__Group__1__Impl : ( ( rule__EditorImport__NameAssignment_1 ) ) ;
    public final void rule__EditorImport__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1776:1: ( ( ( rule__EditorImport__NameAssignment_1 ) ) )
            // InternalGT.g:1777:1: ( ( rule__EditorImport__NameAssignment_1 ) )
            {
            // InternalGT.g:1777:1: ( ( rule__EditorImport__NameAssignment_1 ) )
            // InternalGT.g:1778:2: ( rule__EditorImport__NameAssignment_1 )
            {
             before(grammarAccess.getEditorImportAccess().getNameAssignment_1()); 
            // InternalGT.g:1779:2: ( rule__EditorImport__NameAssignment_1 )
            // InternalGT.g:1779:3: rule__EditorImport__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorImport__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorImportAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorImport__Group__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group__0"
    // InternalGT.g:1788:1: rule__EditorPattern__Group__0 : rule__EditorPattern__Group__0__Impl rule__EditorPattern__Group__1 ;
    public final void rule__EditorPattern__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1792:1: ( rule__EditorPattern__Group__0__Impl rule__EditorPattern__Group__1 )
            // InternalGT.g:1793:2: rule__EditorPattern__Group__0__Impl rule__EditorPattern__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__EditorPattern__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__0"


    // $ANTLR start "rule__EditorPattern__Group__0__Impl"
    // InternalGT.g:1800:1: rule__EditorPattern__Group__0__Impl : ( ( rule__EditorPattern__AbstractAssignment_0 )? ) ;
    public final void rule__EditorPattern__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1804:1: ( ( ( rule__EditorPattern__AbstractAssignment_0 )? ) )
            // InternalGT.g:1805:1: ( ( rule__EditorPattern__AbstractAssignment_0 )? )
            {
            // InternalGT.g:1805:1: ( ( rule__EditorPattern__AbstractAssignment_0 )? )
            // InternalGT.g:1806:2: ( rule__EditorPattern__AbstractAssignment_0 )?
            {
             before(grammarAccess.getEditorPatternAccess().getAbstractAssignment_0()); 
            // InternalGT.g:1807:2: ( rule__EditorPattern__AbstractAssignment_0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==67) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalGT.g:1807:3: rule__EditorPattern__AbstractAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__AbstractAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorPatternAccess().getAbstractAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group__1"
    // InternalGT.g:1815:1: rule__EditorPattern__Group__1 : rule__EditorPattern__Group__1__Impl rule__EditorPattern__Group__2 ;
    public final void rule__EditorPattern__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1819:1: ( rule__EditorPattern__Group__1__Impl rule__EditorPattern__Group__2 )
            // InternalGT.g:1820:2: rule__EditorPattern__Group__1__Impl rule__EditorPattern__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__EditorPattern__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__1"


    // $ANTLR start "rule__EditorPattern__Group__1__Impl"
    // InternalGT.g:1827:1: rule__EditorPattern__Group__1__Impl : ( ( rule__EditorPattern__TypeAssignment_1 ) ) ;
    public final void rule__EditorPattern__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1831:1: ( ( ( rule__EditorPattern__TypeAssignment_1 ) ) )
            // InternalGT.g:1832:1: ( ( rule__EditorPattern__TypeAssignment_1 ) )
            {
            // InternalGT.g:1832:1: ( ( rule__EditorPattern__TypeAssignment_1 ) )
            // InternalGT.g:1833:2: ( rule__EditorPattern__TypeAssignment_1 )
            {
             before(grammarAccess.getEditorPatternAccess().getTypeAssignment_1()); 
            // InternalGT.g:1834:2: ( rule__EditorPattern__TypeAssignment_1 )
            // InternalGT.g:1834:3: rule__EditorPattern__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group__2"
    // InternalGT.g:1842:1: rule__EditorPattern__Group__2 : rule__EditorPattern__Group__2__Impl rule__EditorPattern__Group__3 ;
    public final void rule__EditorPattern__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1846:1: ( rule__EditorPattern__Group__2__Impl rule__EditorPattern__Group__3 )
            // InternalGT.g:1847:2: rule__EditorPattern__Group__2__Impl rule__EditorPattern__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__EditorPattern__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__2"


    // $ANTLR start "rule__EditorPattern__Group__2__Impl"
    // InternalGT.g:1854:1: rule__EditorPattern__Group__2__Impl : ( ( rule__EditorPattern__NameAssignment_2 ) ) ;
    public final void rule__EditorPattern__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1858:1: ( ( ( rule__EditorPattern__NameAssignment_2 ) ) )
            // InternalGT.g:1859:1: ( ( rule__EditorPattern__NameAssignment_2 ) )
            {
            // InternalGT.g:1859:1: ( ( rule__EditorPattern__NameAssignment_2 ) )
            // InternalGT.g:1860:2: ( rule__EditorPattern__NameAssignment_2 )
            {
             before(grammarAccess.getEditorPatternAccess().getNameAssignment_2()); 
            // InternalGT.g:1861:2: ( rule__EditorPattern__NameAssignment_2 )
            // InternalGT.g:1861:3: rule__EditorPattern__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__2__Impl"


    // $ANTLR start "rule__EditorPattern__Group__3"
    // InternalGT.g:1869:1: rule__EditorPattern__Group__3 : rule__EditorPattern__Group__3__Impl rule__EditorPattern__Group__4 ;
    public final void rule__EditorPattern__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1873:1: ( rule__EditorPattern__Group__3__Impl rule__EditorPattern__Group__4 )
            // InternalGT.g:1874:2: rule__EditorPattern__Group__3__Impl rule__EditorPattern__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__EditorPattern__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__3"


    // $ANTLR start "rule__EditorPattern__Group__3__Impl"
    // InternalGT.g:1881:1: rule__EditorPattern__Group__3__Impl : ( ( rule__EditorPattern__Group_3__0 )? ) ;
    public final void rule__EditorPattern__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1885:1: ( ( ( rule__EditorPattern__Group_3__0 )? ) )
            // InternalGT.g:1886:1: ( ( rule__EditorPattern__Group_3__0 )? )
            {
            // InternalGT.g:1886:1: ( ( rule__EditorPattern__Group_3__0 )? )
            // InternalGT.g:1887:2: ( rule__EditorPattern__Group_3__0 )?
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_3()); 
            // InternalGT.g:1888:2: ( rule__EditorPattern__Group_3__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==45) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalGT.g:1888:3: rule__EditorPattern__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorPatternAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__3__Impl"


    // $ANTLR start "rule__EditorPattern__Group__4"
    // InternalGT.g:1896:1: rule__EditorPattern__Group__4 : rule__EditorPattern__Group__4__Impl rule__EditorPattern__Group__5 ;
    public final void rule__EditorPattern__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1900:1: ( rule__EditorPattern__Group__4__Impl rule__EditorPattern__Group__5 )
            // InternalGT.g:1901:2: rule__EditorPattern__Group__4__Impl rule__EditorPattern__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__EditorPattern__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__4"


    // $ANTLR start "rule__EditorPattern__Group__4__Impl"
    // InternalGT.g:1908:1: rule__EditorPattern__Group__4__Impl : ( ( rule__EditorPattern__Group_4__0 )? ) ;
    public final void rule__EditorPattern__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1912:1: ( ( ( rule__EditorPattern__Group_4__0 )? ) )
            // InternalGT.g:1913:1: ( ( rule__EditorPattern__Group_4__0 )? )
            {
            // InternalGT.g:1913:1: ( ( rule__EditorPattern__Group_4__0 )? )
            // InternalGT.g:1914:2: ( rule__EditorPattern__Group_4__0 )?
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_4()); 
            // InternalGT.g:1915:2: ( rule__EditorPattern__Group_4__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==48) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalGT.g:1915:3: rule__EditorPattern__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorPatternAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__4__Impl"


    // $ANTLR start "rule__EditorPattern__Group__5"
    // InternalGT.g:1923:1: rule__EditorPattern__Group__5 : rule__EditorPattern__Group__5__Impl rule__EditorPattern__Group__6 ;
    public final void rule__EditorPattern__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1927:1: ( rule__EditorPattern__Group__5__Impl rule__EditorPattern__Group__6 )
            // InternalGT.g:1928:2: rule__EditorPattern__Group__5__Impl rule__EditorPattern__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__EditorPattern__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__5"


    // $ANTLR start "rule__EditorPattern__Group__5__Impl"
    // InternalGT.g:1935:1: rule__EditorPattern__Group__5__Impl : ( ( rule__EditorPattern__Group_5__0 )? ) ;
    public final void rule__EditorPattern__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1939:1: ( ( ( rule__EditorPattern__Group_5__0 )? ) )
            // InternalGT.g:1940:1: ( ( rule__EditorPattern__Group_5__0 )? )
            {
            // InternalGT.g:1940:1: ( ( rule__EditorPattern__Group_5__0 )? )
            // InternalGT.g:1941:2: ( rule__EditorPattern__Group_5__0 )?
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_5()); 
            // InternalGT.g:1942:2: ( rule__EditorPattern__Group_5__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==49) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalGT.g:1942:3: rule__EditorPattern__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorPatternAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__5__Impl"


    // $ANTLR start "rule__EditorPattern__Group__6"
    // InternalGT.g:1950:1: rule__EditorPattern__Group__6 : rule__EditorPattern__Group__6__Impl rule__EditorPattern__Group__7 ;
    public final void rule__EditorPattern__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1954:1: ( rule__EditorPattern__Group__6__Impl rule__EditorPattern__Group__7 )
            // InternalGT.g:1955:2: rule__EditorPattern__Group__6__Impl rule__EditorPattern__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__EditorPattern__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__6"


    // $ANTLR start "rule__EditorPattern__Group__6__Impl"
    // InternalGT.g:1962:1: rule__EditorPattern__Group__6__Impl : ( ( rule__EditorPattern__Group_6__0 )? ) ;
    public final void rule__EditorPattern__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1966:1: ( ( ( rule__EditorPattern__Group_6__0 )? ) )
            // InternalGT.g:1967:1: ( ( rule__EditorPattern__Group_6__0 )? )
            {
            // InternalGT.g:1967:1: ( ( rule__EditorPattern__Group_6__0 )? )
            // InternalGT.g:1968:2: ( rule__EditorPattern__Group_6__0 )?
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_6()); 
            // InternalGT.g:1969:2: ( rule__EditorPattern__Group_6__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==51) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalGT.g:1969:3: rule__EditorPattern__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorPatternAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__6__Impl"


    // $ANTLR start "rule__EditorPattern__Group__7"
    // InternalGT.g:1977:1: rule__EditorPattern__Group__7 : rule__EditorPattern__Group__7__Impl ;
    public final void rule__EditorPattern__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1981:1: ( rule__EditorPattern__Group__7__Impl )
            // InternalGT.g:1982:2: rule__EditorPattern__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__7"


    // $ANTLR start "rule__EditorPattern__Group__7__Impl"
    // InternalGT.g:1988:1: rule__EditorPattern__Group__7__Impl : ( ( rule__EditorPattern__Group_7__0 )? ) ;
    public final void rule__EditorPattern__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:1992:1: ( ( ( rule__EditorPattern__Group_7__0 )? ) )
            // InternalGT.g:1993:1: ( ( rule__EditorPattern__Group_7__0 )? )
            {
            // InternalGT.g:1993:1: ( ( rule__EditorPattern__Group_7__0 )? )
            // InternalGT.g:1994:2: ( rule__EditorPattern__Group_7__0 )?
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_7()); 
            // InternalGT.g:1995:2: ( rule__EditorPattern__Group_7__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==68) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalGT.g:1995:3: rule__EditorPattern__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorPatternAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group__7__Impl"


    // $ANTLR start "rule__EditorPattern__Group_3__0"
    // InternalGT.g:2004:1: rule__EditorPattern__Group_3__0 : rule__EditorPattern__Group_3__0__Impl rule__EditorPattern__Group_3__1 ;
    public final void rule__EditorPattern__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2008:1: ( rule__EditorPattern__Group_3__0__Impl rule__EditorPattern__Group_3__1 )
            // InternalGT.g:2009:2: rule__EditorPattern__Group_3__0__Impl rule__EditorPattern__Group_3__1
            {
            pushFollow(FOLLOW_10);
            rule__EditorPattern__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3__0"


    // $ANTLR start "rule__EditorPattern__Group_3__0__Impl"
    // InternalGT.g:2016:1: rule__EditorPattern__Group_3__0__Impl : ( '(' ) ;
    public final void rule__EditorPattern__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2020:1: ( ( '(' ) )
            // InternalGT.g:2021:1: ( '(' )
            {
            // InternalGT.g:2021:1: ( '(' )
            // InternalGT.g:2022:2: '('
            {
             before(grammarAccess.getEditorPatternAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getLeftParenthesisKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_3__1"
    // InternalGT.g:2031:1: rule__EditorPattern__Group_3__1 : rule__EditorPattern__Group_3__1__Impl rule__EditorPattern__Group_3__2 ;
    public final void rule__EditorPattern__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2035:1: ( rule__EditorPattern__Group_3__1__Impl rule__EditorPattern__Group_3__2 )
            // InternalGT.g:2036:2: rule__EditorPattern__Group_3__1__Impl rule__EditorPattern__Group_3__2
            {
            pushFollow(FOLLOW_10);
            rule__EditorPattern__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3__1"


    // $ANTLR start "rule__EditorPattern__Group_3__1__Impl"
    // InternalGT.g:2043:1: rule__EditorPattern__Group_3__1__Impl : ( ( rule__EditorPattern__Group_3_1__0 )? ) ;
    public final void rule__EditorPattern__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2047:1: ( ( ( rule__EditorPattern__Group_3_1__0 )? ) )
            // InternalGT.g:2048:1: ( ( rule__EditorPattern__Group_3_1__0 )? )
            {
            // InternalGT.g:2048:1: ( ( rule__EditorPattern__Group_3_1__0 )? )
            // InternalGT.g:2049:2: ( rule__EditorPattern__Group_3_1__0 )?
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_3_1()); 
            // InternalGT.g:2050:2: ( rule__EditorPattern__Group_3_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalGT.g:2050:3: rule__EditorPattern__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorPattern__Group_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorPatternAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_3__2"
    // InternalGT.g:2058:1: rule__EditorPattern__Group_3__2 : rule__EditorPattern__Group_3__2__Impl ;
    public final void rule__EditorPattern__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2062:1: ( rule__EditorPattern__Group_3__2__Impl )
            // InternalGT.g:2063:2: rule__EditorPattern__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3__2"


    // $ANTLR start "rule__EditorPattern__Group_3__2__Impl"
    // InternalGT.g:2069:1: rule__EditorPattern__Group_3__2__Impl : ( ')' ) ;
    public final void rule__EditorPattern__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2073:1: ( ( ')' ) )
            // InternalGT.g:2074:1: ( ')' )
            {
            // InternalGT.g:2074:1: ( ')' )
            // InternalGT.g:2075:2: ')'
            {
             before(grammarAccess.getEditorPatternAccess().getRightParenthesisKeyword_3_2()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getRightParenthesisKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3__2__Impl"


    // $ANTLR start "rule__EditorPattern__Group_3_1__0"
    // InternalGT.g:2085:1: rule__EditorPattern__Group_3_1__0 : rule__EditorPattern__Group_3_1__0__Impl rule__EditorPattern__Group_3_1__1 ;
    public final void rule__EditorPattern__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2089:1: ( rule__EditorPattern__Group_3_1__0__Impl rule__EditorPattern__Group_3_1__1 )
            // InternalGT.g:2090:2: rule__EditorPattern__Group_3_1__0__Impl rule__EditorPattern__Group_3_1__1
            {
            pushFollow(FOLLOW_11);
            rule__EditorPattern__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1__0"


    // $ANTLR start "rule__EditorPattern__Group_3_1__0__Impl"
    // InternalGT.g:2097:1: rule__EditorPattern__Group_3_1__0__Impl : ( ( rule__EditorPattern__ParametersAssignment_3_1_0 ) ) ;
    public final void rule__EditorPattern__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2101:1: ( ( ( rule__EditorPattern__ParametersAssignment_3_1_0 ) ) )
            // InternalGT.g:2102:1: ( ( rule__EditorPattern__ParametersAssignment_3_1_0 ) )
            {
            // InternalGT.g:2102:1: ( ( rule__EditorPattern__ParametersAssignment_3_1_0 ) )
            // InternalGT.g:2103:2: ( rule__EditorPattern__ParametersAssignment_3_1_0 )
            {
             before(grammarAccess.getEditorPatternAccess().getParametersAssignment_3_1_0()); 
            // InternalGT.g:2104:2: ( rule__EditorPattern__ParametersAssignment_3_1_0 )
            // InternalGT.g:2104:3: rule__EditorPattern__ParametersAssignment_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__ParametersAssignment_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getParametersAssignment_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_3_1__1"
    // InternalGT.g:2112:1: rule__EditorPattern__Group_3_1__1 : rule__EditorPattern__Group_3_1__1__Impl ;
    public final void rule__EditorPattern__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2116:1: ( rule__EditorPattern__Group_3_1__1__Impl )
            // InternalGT.g:2117:2: rule__EditorPattern__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1__1"


    // $ANTLR start "rule__EditorPattern__Group_3_1__1__Impl"
    // InternalGT.g:2123:1: rule__EditorPattern__Group_3_1__1__Impl : ( ( rule__EditorPattern__Group_3_1_1__0 )* ) ;
    public final void rule__EditorPattern__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2127:1: ( ( ( rule__EditorPattern__Group_3_1_1__0 )* ) )
            // InternalGT.g:2128:1: ( ( rule__EditorPattern__Group_3_1_1__0 )* )
            {
            // InternalGT.g:2128:1: ( ( rule__EditorPattern__Group_3_1_1__0 )* )
            // InternalGT.g:2129:2: ( rule__EditorPattern__Group_3_1_1__0 )*
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_3_1_1()); 
            // InternalGT.g:2130:2: ( rule__EditorPattern__Group_3_1_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==47) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalGT.g:2130:3: rule__EditorPattern__Group_3_1_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__EditorPattern__Group_3_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getEditorPatternAccess().getGroup_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_3_1_1__0"
    // InternalGT.g:2139:1: rule__EditorPattern__Group_3_1_1__0 : rule__EditorPattern__Group_3_1_1__0__Impl rule__EditorPattern__Group_3_1_1__1 ;
    public final void rule__EditorPattern__Group_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2143:1: ( rule__EditorPattern__Group_3_1_1__0__Impl rule__EditorPattern__Group_3_1_1__1 )
            // InternalGT.g:2144:2: rule__EditorPattern__Group_3_1_1__0__Impl rule__EditorPattern__Group_3_1_1__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorPattern__Group_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1_1__0"


    // $ANTLR start "rule__EditorPattern__Group_3_1_1__0__Impl"
    // InternalGT.g:2151:1: rule__EditorPattern__Group_3_1_1__0__Impl : ( ',' ) ;
    public final void rule__EditorPattern__Group_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2155:1: ( ( ',' ) )
            // InternalGT.g:2156:1: ( ',' )
            {
            // InternalGT.g:2156:1: ( ',' )
            // InternalGT.g:2157:2: ','
            {
             before(grammarAccess.getEditorPatternAccess().getCommaKeyword_3_1_1_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getCommaKeyword_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1_1__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_3_1_1__1"
    // InternalGT.g:2166:1: rule__EditorPattern__Group_3_1_1__1 : rule__EditorPattern__Group_3_1_1__1__Impl ;
    public final void rule__EditorPattern__Group_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2170:1: ( rule__EditorPattern__Group_3_1_1__1__Impl )
            // InternalGT.g:2171:2: rule__EditorPattern__Group_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1_1__1"


    // $ANTLR start "rule__EditorPattern__Group_3_1_1__1__Impl"
    // InternalGT.g:2177:1: rule__EditorPattern__Group_3_1_1__1__Impl : ( ( rule__EditorPattern__ParametersAssignment_3_1_1_1 ) ) ;
    public final void rule__EditorPattern__Group_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2181:1: ( ( ( rule__EditorPattern__ParametersAssignment_3_1_1_1 ) ) )
            // InternalGT.g:2182:1: ( ( rule__EditorPattern__ParametersAssignment_3_1_1_1 ) )
            {
            // InternalGT.g:2182:1: ( ( rule__EditorPattern__ParametersAssignment_3_1_1_1 ) )
            // InternalGT.g:2183:2: ( rule__EditorPattern__ParametersAssignment_3_1_1_1 )
            {
             before(grammarAccess.getEditorPatternAccess().getParametersAssignment_3_1_1_1()); 
            // InternalGT.g:2184:2: ( rule__EditorPattern__ParametersAssignment_3_1_1_1 )
            // InternalGT.g:2184:3: rule__EditorPattern__ParametersAssignment_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__ParametersAssignment_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getParametersAssignment_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_3_1_1__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_4__0"
    // InternalGT.g:2193:1: rule__EditorPattern__Group_4__0 : rule__EditorPattern__Group_4__0__Impl rule__EditorPattern__Group_4__1 ;
    public final void rule__EditorPattern__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2197:1: ( rule__EditorPattern__Group_4__0__Impl rule__EditorPattern__Group_4__1 )
            // InternalGT.g:2198:2: rule__EditorPattern__Group_4__0__Impl rule__EditorPattern__Group_4__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorPattern__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4__0"


    // $ANTLR start "rule__EditorPattern__Group_4__0__Impl"
    // InternalGT.g:2205:1: rule__EditorPattern__Group_4__0__Impl : ( 'refines' ) ;
    public final void rule__EditorPattern__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2209:1: ( ( 'refines' ) )
            // InternalGT.g:2210:1: ( 'refines' )
            {
            // InternalGT.g:2210:1: ( 'refines' )
            // InternalGT.g:2211:2: 'refines'
            {
             before(grammarAccess.getEditorPatternAccess().getRefinesKeyword_4_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getRefinesKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_4__1"
    // InternalGT.g:2220:1: rule__EditorPattern__Group_4__1 : rule__EditorPattern__Group_4__1__Impl rule__EditorPattern__Group_4__2 ;
    public final void rule__EditorPattern__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2224:1: ( rule__EditorPattern__Group_4__1__Impl rule__EditorPattern__Group_4__2 )
            // InternalGT.g:2225:2: rule__EditorPattern__Group_4__1__Impl rule__EditorPattern__Group_4__2
            {
            pushFollow(FOLLOW_11);
            rule__EditorPattern__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4__1"


    // $ANTLR start "rule__EditorPattern__Group_4__1__Impl"
    // InternalGT.g:2232:1: rule__EditorPattern__Group_4__1__Impl : ( ( rule__EditorPattern__SuperPatternsAssignment_4_1 ) ) ;
    public final void rule__EditorPattern__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2236:1: ( ( ( rule__EditorPattern__SuperPatternsAssignment_4_1 ) ) )
            // InternalGT.g:2237:1: ( ( rule__EditorPattern__SuperPatternsAssignment_4_1 ) )
            {
            // InternalGT.g:2237:1: ( ( rule__EditorPattern__SuperPatternsAssignment_4_1 ) )
            // InternalGT.g:2238:2: ( rule__EditorPattern__SuperPatternsAssignment_4_1 )
            {
             before(grammarAccess.getEditorPatternAccess().getSuperPatternsAssignment_4_1()); 
            // InternalGT.g:2239:2: ( rule__EditorPattern__SuperPatternsAssignment_4_1 )
            // InternalGT.g:2239:3: rule__EditorPattern__SuperPatternsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__SuperPatternsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getSuperPatternsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_4__2"
    // InternalGT.g:2247:1: rule__EditorPattern__Group_4__2 : rule__EditorPattern__Group_4__2__Impl ;
    public final void rule__EditorPattern__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2251:1: ( rule__EditorPattern__Group_4__2__Impl )
            // InternalGT.g:2252:2: rule__EditorPattern__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4__2"


    // $ANTLR start "rule__EditorPattern__Group_4__2__Impl"
    // InternalGT.g:2258:1: rule__EditorPattern__Group_4__2__Impl : ( ( rule__EditorPattern__Group_4_2__0 )* ) ;
    public final void rule__EditorPattern__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2262:1: ( ( ( rule__EditorPattern__Group_4_2__0 )* ) )
            // InternalGT.g:2263:1: ( ( rule__EditorPattern__Group_4_2__0 )* )
            {
            // InternalGT.g:2263:1: ( ( rule__EditorPattern__Group_4_2__0 )* )
            // InternalGT.g:2264:2: ( rule__EditorPattern__Group_4_2__0 )*
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_4_2()); 
            // InternalGT.g:2265:2: ( rule__EditorPattern__Group_4_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==47) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalGT.g:2265:3: rule__EditorPattern__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__EditorPattern__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getEditorPatternAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4__2__Impl"


    // $ANTLR start "rule__EditorPattern__Group_4_2__0"
    // InternalGT.g:2274:1: rule__EditorPattern__Group_4_2__0 : rule__EditorPattern__Group_4_2__0__Impl rule__EditorPattern__Group_4_2__1 ;
    public final void rule__EditorPattern__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2278:1: ( rule__EditorPattern__Group_4_2__0__Impl rule__EditorPattern__Group_4_2__1 )
            // InternalGT.g:2279:2: rule__EditorPattern__Group_4_2__0__Impl rule__EditorPattern__Group_4_2__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorPattern__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4_2__0"


    // $ANTLR start "rule__EditorPattern__Group_4_2__0__Impl"
    // InternalGT.g:2286:1: rule__EditorPattern__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__EditorPattern__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2290:1: ( ( ',' ) )
            // InternalGT.g:2291:1: ( ',' )
            {
            // InternalGT.g:2291:1: ( ',' )
            // InternalGT.g:2292:2: ','
            {
             before(grammarAccess.getEditorPatternAccess().getCommaKeyword_4_2_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4_2__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_4_2__1"
    // InternalGT.g:2301:1: rule__EditorPattern__Group_4_2__1 : rule__EditorPattern__Group_4_2__1__Impl ;
    public final void rule__EditorPattern__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2305:1: ( rule__EditorPattern__Group_4_2__1__Impl )
            // InternalGT.g:2306:2: rule__EditorPattern__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4_2__1"


    // $ANTLR start "rule__EditorPattern__Group_4_2__1__Impl"
    // InternalGT.g:2312:1: rule__EditorPattern__Group_4_2__1__Impl : ( ( rule__EditorPattern__SuperPatternsAssignment_4_2_1 ) ) ;
    public final void rule__EditorPattern__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2316:1: ( ( ( rule__EditorPattern__SuperPatternsAssignment_4_2_1 ) ) )
            // InternalGT.g:2317:1: ( ( rule__EditorPattern__SuperPatternsAssignment_4_2_1 ) )
            {
            // InternalGT.g:2317:1: ( ( rule__EditorPattern__SuperPatternsAssignment_4_2_1 ) )
            // InternalGT.g:2318:2: ( rule__EditorPattern__SuperPatternsAssignment_4_2_1 )
            {
             before(grammarAccess.getEditorPatternAccess().getSuperPatternsAssignment_4_2_1()); 
            // InternalGT.g:2319:2: ( rule__EditorPattern__SuperPatternsAssignment_4_2_1 )
            // InternalGT.g:2319:3: rule__EditorPattern__SuperPatternsAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__SuperPatternsAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getSuperPatternsAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_4_2__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_5__0"
    // InternalGT.g:2328:1: rule__EditorPattern__Group_5__0 : rule__EditorPattern__Group_5__0__Impl rule__EditorPattern__Group_5__1 ;
    public final void rule__EditorPattern__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2332:1: ( rule__EditorPattern__Group_5__0__Impl rule__EditorPattern__Group_5__1 )
            // InternalGT.g:2333:2: rule__EditorPattern__Group_5__0__Impl rule__EditorPattern__Group_5__1
            {
            pushFollow(FOLLOW_13);
            rule__EditorPattern__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_5__0"


    // $ANTLR start "rule__EditorPattern__Group_5__0__Impl"
    // InternalGT.g:2340:1: rule__EditorPattern__Group_5__0__Impl : ( '{' ) ;
    public final void rule__EditorPattern__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2344:1: ( ( '{' ) )
            // InternalGT.g:2345:1: ( '{' )
            {
            // InternalGT.g:2345:1: ( '{' )
            // InternalGT.g:2346:2: '{'
            {
             before(grammarAccess.getEditorPatternAccess().getLeftCurlyBracketKeyword_5_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getLeftCurlyBracketKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_5__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_5__1"
    // InternalGT.g:2355:1: rule__EditorPattern__Group_5__1 : rule__EditorPattern__Group_5__1__Impl rule__EditorPattern__Group_5__2 ;
    public final void rule__EditorPattern__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2359:1: ( rule__EditorPattern__Group_5__1__Impl rule__EditorPattern__Group_5__2 )
            // InternalGT.g:2360:2: rule__EditorPattern__Group_5__1__Impl rule__EditorPattern__Group_5__2
            {
            pushFollow(FOLLOW_13);
            rule__EditorPattern__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_5__1"


    // $ANTLR start "rule__EditorPattern__Group_5__1__Impl"
    // InternalGT.g:2367:1: rule__EditorPattern__Group_5__1__Impl : ( ( rule__EditorPattern__Alternatives_5_1 )* ) ;
    public final void rule__EditorPattern__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2371:1: ( ( ( rule__EditorPattern__Alternatives_5_1 )* ) )
            // InternalGT.g:2372:1: ( ( rule__EditorPattern__Alternatives_5_1 )* )
            {
            // InternalGT.g:2372:1: ( ( rule__EditorPattern__Alternatives_5_1 )* )
            // InternalGT.g:2373:2: ( rule__EditorPattern__Alternatives_5_1 )*
            {
             before(grammarAccess.getEditorPatternAccess().getAlternatives_5_1()); 
            // InternalGT.g:2374:2: ( rule__EditorPattern__Alternatives_5_1 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID||(LA36_0>=15 && LA36_0<=17)||LA36_0==54||LA36_0==69) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalGT.g:2374:3: rule__EditorPattern__Alternatives_5_1
            	    {
            	    pushFollow(FOLLOW_14);
            	    rule__EditorPattern__Alternatives_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getEditorPatternAccess().getAlternatives_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_5__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_5__2"
    // InternalGT.g:2382:1: rule__EditorPattern__Group_5__2 : rule__EditorPattern__Group_5__2__Impl ;
    public final void rule__EditorPattern__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2386:1: ( rule__EditorPattern__Group_5__2__Impl )
            // InternalGT.g:2387:2: rule__EditorPattern__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_5__2"


    // $ANTLR start "rule__EditorPattern__Group_5__2__Impl"
    // InternalGT.g:2393:1: rule__EditorPattern__Group_5__2__Impl : ( '}' ) ;
    public final void rule__EditorPattern__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2397:1: ( ( '}' ) )
            // InternalGT.g:2398:1: ( '}' )
            {
            // InternalGT.g:2398:1: ( '}' )
            // InternalGT.g:2399:2: '}'
            {
             before(grammarAccess.getEditorPatternAccess().getRightCurlyBracketKeyword_5_2()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getRightCurlyBracketKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_5__2__Impl"


    // $ANTLR start "rule__EditorPattern__Group_6__0"
    // InternalGT.g:2409:1: rule__EditorPattern__Group_6__0 : rule__EditorPattern__Group_6__0__Impl rule__EditorPattern__Group_6__1 ;
    public final void rule__EditorPattern__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2413:1: ( rule__EditorPattern__Group_6__0__Impl rule__EditorPattern__Group_6__1 )
            // InternalGT.g:2414:2: rule__EditorPattern__Group_6__0__Impl rule__EditorPattern__Group_6__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorPattern__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6__0"


    // $ANTLR start "rule__EditorPattern__Group_6__0__Impl"
    // InternalGT.g:2421:1: rule__EditorPattern__Group_6__0__Impl : ( 'when' ) ;
    public final void rule__EditorPattern__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2425:1: ( ( 'when' ) )
            // InternalGT.g:2426:1: ( 'when' )
            {
            // InternalGT.g:2426:1: ( 'when' )
            // InternalGT.g:2427:2: 'when'
            {
             before(grammarAccess.getEditorPatternAccess().getWhenKeyword_6_0()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getWhenKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_6__1"
    // InternalGT.g:2436:1: rule__EditorPattern__Group_6__1 : rule__EditorPattern__Group_6__1__Impl rule__EditorPattern__Group_6__2 ;
    public final void rule__EditorPattern__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2440:1: ( rule__EditorPattern__Group_6__1__Impl rule__EditorPattern__Group_6__2 )
            // InternalGT.g:2441:2: rule__EditorPattern__Group_6__1__Impl rule__EditorPattern__Group_6__2
            {
            pushFollow(FOLLOW_15);
            rule__EditorPattern__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6__1"


    // $ANTLR start "rule__EditorPattern__Group_6__1__Impl"
    // InternalGT.g:2448:1: rule__EditorPattern__Group_6__1__Impl : ( ( rule__EditorPattern__ConditionsAssignment_6_1 ) ) ;
    public final void rule__EditorPattern__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2452:1: ( ( ( rule__EditorPattern__ConditionsAssignment_6_1 ) ) )
            // InternalGT.g:2453:1: ( ( rule__EditorPattern__ConditionsAssignment_6_1 ) )
            {
            // InternalGT.g:2453:1: ( ( rule__EditorPattern__ConditionsAssignment_6_1 ) )
            // InternalGT.g:2454:2: ( rule__EditorPattern__ConditionsAssignment_6_1 )
            {
             before(grammarAccess.getEditorPatternAccess().getConditionsAssignment_6_1()); 
            // InternalGT.g:2455:2: ( rule__EditorPattern__ConditionsAssignment_6_1 )
            // InternalGT.g:2455:3: rule__EditorPattern__ConditionsAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__ConditionsAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getConditionsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_6__2"
    // InternalGT.g:2463:1: rule__EditorPattern__Group_6__2 : rule__EditorPattern__Group_6__2__Impl ;
    public final void rule__EditorPattern__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2467:1: ( rule__EditorPattern__Group_6__2__Impl )
            // InternalGT.g:2468:2: rule__EditorPattern__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6__2"


    // $ANTLR start "rule__EditorPattern__Group_6__2__Impl"
    // InternalGT.g:2474:1: rule__EditorPattern__Group_6__2__Impl : ( ( rule__EditorPattern__Group_6_2__0 )* ) ;
    public final void rule__EditorPattern__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2478:1: ( ( ( rule__EditorPattern__Group_6_2__0 )* ) )
            // InternalGT.g:2479:1: ( ( rule__EditorPattern__Group_6_2__0 )* )
            {
            // InternalGT.g:2479:1: ( ( rule__EditorPattern__Group_6_2__0 )* )
            // InternalGT.g:2480:2: ( rule__EditorPattern__Group_6_2__0 )*
            {
             before(grammarAccess.getEditorPatternAccess().getGroup_6_2()); 
            // InternalGT.g:2481:2: ( rule__EditorPattern__Group_6_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==52) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalGT.g:2481:3: rule__EditorPattern__Group_6_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__EditorPattern__Group_6_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getEditorPatternAccess().getGroup_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6__2__Impl"


    // $ANTLR start "rule__EditorPattern__Group_6_2__0"
    // InternalGT.g:2490:1: rule__EditorPattern__Group_6_2__0 : rule__EditorPattern__Group_6_2__0__Impl rule__EditorPattern__Group_6_2__1 ;
    public final void rule__EditorPattern__Group_6_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2494:1: ( rule__EditorPattern__Group_6_2__0__Impl rule__EditorPattern__Group_6_2__1 )
            // InternalGT.g:2495:2: rule__EditorPattern__Group_6_2__0__Impl rule__EditorPattern__Group_6_2__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorPattern__Group_6_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_6_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6_2__0"


    // $ANTLR start "rule__EditorPattern__Group_6_2__0__Impl"
    // InternalGT.g:2502:1: rule__EditorPattern__Group_6_2__0__Impl : ( '||' ) ;
    public final void rule__EditorPattern__Group_6_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2506:1: ( ( '||' ) )
            // InternalGT.g:2507:1: ( '||' )
            {
            // InternalGT.g:2507:1: ( '||' )
            // InternalGT.g:2508:2: '||'
            {
             before(grammarAccess.getEditorPatternAccess().getVerticalLineVerticalLineKeyword_6_2_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getVerticalLineVerticalLineKeyword_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6_2__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_6_2__1"
    // InternalGT.g:2517:1: rule__EditorPattern__Group_6_2__1 : rule__EditorPattern__Group_6_2__1__Impl ;
    public final void rule__EditorPattern__Group_6_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2521:1: ( rule__EditorPattern__Group_6_2__1__Impl )
            // InternalGT.g:2522:2: rule__EditorPattern__Group_6_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_6_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6_2__1"


    // $ANTLR start "rule__EditorPattern__Group_6_2__1__Impl"
    // InternalGT.g:2528:1: rule__EditorPattern__Group_6_2__1__Impl : ( ( rule__EditorPattern__ConditionsAssignment_6_2_1 ) ) ;
    public final void rule__EditorPattern__Group_6_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2532:1: ( ( ( rule__EditorPattern__ConditionsAssignment_6_2_1 ) ) )
            // InternalGT.g:2533:1: ( ( rule__EditorPattern__ConditionsAssignment_6_2_1 ) )
            {
            // InternalGT.g:2533:1: ( ( rule__EditorPattern__ConditionsAssignment_6_2_1 ) )
            // InternalGT.g:2534:2: ( rule__EditorPattern__ConditionsAssignment_6_2_1 )
            {
             before(grammarAccess.getEditorPatternAccess().getConditionsAssignment_6_2_1()); 
            // InternalGT.g:2535:2: ( rule__EditorPattern__ConditionsAssignment_6_2_1 )
            // InternalGT.g:2535:3: rule__EditorPattern__ConditionsAssignment_6_2_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__ConditionsAssignment_6_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getConditionsAssignment_6_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_6_2__1__Impl"


    // $ANTLR start "rule__EditorPattern__Group_7__0"
    // InternalGT.g:2544:1: rule__EditorPattern__Group_7__0 : rule__EditorPattern__Group_7__0__Impl rule__EditorPattern__Group_7__1 ;
    public final void rule__EditorPattern__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2548:1: ( rule__EditorPattern__Group_7__0__Impl rule__EditorPattern__Group_7__1 )
            // InternalGT.g:2549:2: rule__EditorPattern__Group_7__0__Impl rule__EditorPattern__Group_7__1
            {
            pushFollow(FOLLOW_17);
            rule__EditorPattern__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_7__0"


    // $ANTLR start "rule__EditorPattern__Group_7__0__Impl"
    // InternalGT.g:2556:1: rule__EditorPattern__Group_7__0__Impl : ( ( rule__EditorPattern__StochasticAssignment_7_0 ) ) ;
    public final void rule__EditorPattern__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2560:1: ( ( ( rule__EditorPattern__StochasticAssignment_7_0 ) ) )
            // InternalGT.g:2561:1: ( ( rule__EditorPattern__StochasticAssignment_7_0 ) )
            {
            // InternalGT.g:2561:1: ( ( rule__EditorPattern__StochasticAssignment_7_0 ) )
            // InternalGT.g:2562:2: ( rule__EditorPattern__StochasticAssignment_7_0 )
            {
             before(grammarAccess.getEditorPatternAccess().getStochasticAssignment_7_0()); 
            // InternalGT.g:2563:2: ( rule__EditorPattern__StochasticAssignment_7_0 )
            // InternalGT.g:2563:3: rule__EditorPattern__StochasticAssignment_7_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__StochasticAssignment_7_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getStochasticAssignment_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_7__0__Impl"


    // $ANTLR start "rule__EditorPattern__Group_7__1"
    // InternalGT.g:2571:1: rule__EditorPattern__Group_7__1 : rule__EditorPattern__Group_7__1__Impl ;
    public final void rule__EditorPattern__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2575:1: ( rule__EditorPattern__Group_7__1__Impl )
            // InternalGT.g:2576:2: rule__EditorPattern__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_7__1"


    // $ANTLR start "rule__EditorPattern__Group_7__1__Impl"
    // InternalGT.g:2582:1: rule__EditorPattern__Group_7__1__Impl : ( ( rule__EditorPattern__ProbabilityAssignment_7_1 ) ) ;
    public final void rule__EditorPattern__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2586:1: ( ( ( rule__EditorPattern__ProbabilityAssignment_7_1 ) ) )
            // InternalGT.g:2587:1: ( ( rule__EditorPattern__ProbabilityAssignment_7_1 ) )
            {
            // InternalGT.g:2587:1: ( ( rule__EditorPattern__ProbabilityAssignment_7_1 ) )
            // InternalGT.g:2588:2: ( rule__EditorPattern__ProbabilityAssignment_7_1 )
            {
             before(grammarAccess.getEditorPatternAccess().getProbabilityAssignment_7_1()); 
            // InternalGT.g:2589:2: ( rule__EditorPattern__ProbabilityAssignment_7_1 )
            // InternalGT.g:2589:3: rule__EditorPattern__ProbabilityAssignment_7_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorPattern__ProbabilityAssignment_7_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorPatternAccess().getProbabilityAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__Group_7__1__Impl"


    // $ANTLR start "rule__EditorParameter__Group__0"
    // InternalGT.g:2598:1: rule__EditorParameter__Group__0 : rule__EditorParameter__Group__0__Impl rule__EditorParameter__Group__1 ;
    public final void rule__EditorParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2602:1: ( rule__EditorParameter__Group__0__Impl rule__EditorParameter__Group__1 )
            // InternalGT.g:2603:2: rule__EditorParameter__Group__0__Impl rule__EditorParameter__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__EditorParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorParameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__Group__0"


    // $ANTLR start "rule__EditorParameter__Group__0__Impl"
    // InternalGT.g:2610:1: rule__EditorParameter__Group__0__Impl : ( ( rule__EditorParameter__NameAssignment_0 ) ) ;
    public final void rule__EditorParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2614:1: ( ( ( rule__EditorParameter__NameAssignment_0 ) ) )
            // InternalGT.g:2615:1: ( ( rule__EditorParameter__NameAssignment_0 ) )
            {
            // InternalGT.g:2615:1: ( ( rule__EditorParameter__NameAssignment_0 ) )
            // InternalGT.g:2616:2: ( rule__EditorParameter__NameAssignment_0 )
            {
             before(grammarAccess.getEditorParameterAccess().getNameAssignment_0()); 
            // InternalGT.g:2617:2: ( rule__EditorParameter__NameAssignment_0 )
            // InternalGT.g:2617:3: rule__EditorParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorParameter__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorParameterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__Group__0__Impl"


    // $ANTLR start "rule__EditorParameter__Group__1"
    // InternalGT.g:2625:1: rule__EditorParameter__Group__1 : rule__EditorParameter__Group__1__Impl rule__EditorParameter__Group__2 ;
    public final void rule__EditorParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2629:1: ( rule__EditorParameter__Group__1__Impl rule__EditorParameter__Group__2 )
            // InternalGT.g:2630:2: rule__EditorParameter__Group__1__Impl rule__EditorParameter__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__EditorParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorParameter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__Group__1"


    // $ANTLR start "rule__EditorParameter__Group__1__Impl"
    // InternalGT.g:2637:1: rule__EditorParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__EditorParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2641:1: ( ( ':' ) )
            // InternalGT.g:2642:1: ( ':' )
            {
            // InternalGT.g:2642:1: ( ':' )
            // InternalGT.g:2643:2: ':'
            {
             before(grammarAccess.getEditorParameterAccess().getColonKeyword_1()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getEditorParameterAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__Group__1__Impl"


    // $ANTLR start "rule__EditorParameter__Group__2"
    // InternalGT.g:2652:1: rule__EditorParameter__Group__2 : rule__EditorParameter__Group__2__Impl ;
    public final void rule__EditorParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2656:1: ( rule__EditorParameter__Group__2__Impl )
            // InternalGT.g:2657:2: rule__EditorParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorParameter__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__Group__2"


    // $ANTLR start "rule__EditorParameter__Group__2__Impl"
    // InternalGT.g:2663:1: rule__EditorParameter__Group__2__Impl : ( ( rule__EditorParameter__TypeAssignment_2 ) ) ;
    public final void rule__EditorParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2667:1: ( ( ( rule__EditorParameter__TypeAssignment_2 ) ) )
            // InternalGT.g:2668:1: ( ( rule__EditorParameter__TypeAssignment_2 ) )
            {
            // InternalGT.g:2668:1: ( ( rule__EditorParameter__TypeAssignment_2 ) )
            // InternalGT.g:2669:2: ( rule__EditorParameter__TypeAssignment_2 )
            {
             before(grammarAccess.getEditorParameterAccess().getTypeAssignment_2()); 
            // InternalGT.g:2670:2: ( rule__EditorParameter__TypeAssignment_2 )
            // InternalGT.g:2670:3: rule__EditorParameter__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorParameter__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorParameterAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__Group__2__Impl"


    // $ANTLR start "rule__EditorNode__Group__0"
    // InternalGT.g:2679:1: rule__EditorNode__Group__0 : rule__EditorNode__Group__0__Impl rule__EditorNode__Group__1 ;
    public final void rule__EditorNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2683:1: ( rule__EditorNode__Group__0__Impl rule__EditorNode__Group__1 )
            // InternalGT.g:2684:2: rule__EditorNode__Group__0__Impl rule__EditorNode__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__EditorNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__0"


    // $ANTLR start "rule__EditorNode__Group__0__Impl"
    // InternalGT.g:2691:1: rule__EditorNode__Group__0__Impl : ( ( rule__EditorNode__OperatorAssignment_0 )? ) ;
    public final void rule__EditorNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2695:1: ( ( ( rule__EditorNode__OperatorAssignment_0 )? ) )
            // InternalGT.g:2696:1: ( ( rule__EditorNode__OperatorAssignment_0 )? )
            {
            // InternalGT.g:2696:1: ( ( rule__EditorNode__OperatorAssignment_0 )? )
            // InternalGT.g:2697:2: ( rule__EditorNode__OperatorAssignment_0 )?
            {
             before(grammarAccess.getEditorNodeAccess().getOperatorAssignment_0()); 
            // InternalGT.g:2698:2: ( rule__EditorNode__OperatorAssignment_0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=15 && LA38_0<=17)) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalGT.g:2698:3: rule__EditorNode__OperatorAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorNode__OperatorAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorNodeAccess().getOperatorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__0__Impl"


    // $ANTLR start "rule__EditorNode__Group__1"
    // InternalGT.g:2706:1: rule__EditorNode__Group__1 : rule__EditorNode__Group__1__Impl rule__EditorNode__Group__2 ;
    public final void rule__EditorNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2710:1: ( rule__EditorNode__Group__1__Impl rule__EditorNode__Group__2 )
            // InternalGT.g:2711:2: rule__EditorNode__Group__1__Impl rule__EditorNode__Group__2
            {
            pushFollow(FOLLOW_19);
            rule__EditorNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__1"


    // $ANTLR start "rule__EditorNode__Group__1__Impl"
    // InternalGT.g:2718:1: rule__EditorNode__Group__1__Impl : ( ( rule__EditorNode__LocalAssignment_1 )? ) ;
    public final void rule__EditorNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2722:1: ( ( ( rule__EditorNode__LocalAssignment_1 )? ) )
            // InternalGT.g:2723:1: ( ( rule__EditorNode__LocalAssignment_1 )? )
            {
            // InternalGT.g:2723:1: ( ( rule__EditorNode__LocalAssignment_1 )? )
            // InternalGT.g:2724:2: ( rule__EditorNode__LocalAssignment_1 )?
            {
             before(grammarAccess.getEditorNodeAccess().getLocalAssignment_1()); 
            // InternalGT.g:2725:2: ( rule__EditorNode__LocalAssignment_1 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==69) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalGT.g:2725:3: rule__EditorNode__LocalAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorNode__LocalAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorNodeAccess().getLocalAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__1__Impl"


    // $ANTLR start "rule__EditorNode__Group__2"
    // InternalGT.g:2733:1: rule__EditorNode__Group__2 : rule__EditorNode__Group__2__Impl rule__EditorNode__Group__3 ;
    public final void rule__EditorNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2737:1: ( rule__EditorNode__Group__2__Impl rule__EditorNode__Group__3 )
            // InternalGT.g:2738:2: rule__EditorNode__Group__2__Impl rule__EditorNode__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__EditorNode__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorNode__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__2"


    // $ANTLR start "rule__EditorNode__Group__2__Impl"
    // InternalGT.g:2745:1: rule__EditorNode__Group__2__Impl : ( ( rule__EditorNode__NameAssignment_2 ) ) ;
    public final void rule__EditorNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2749:1: ( ( ( rule__EditorNode__NameAssignment_2 ) ) )
            // InternalGT.g:2750:1: ( ( rule__EditorNode__NameAssignment_2 ) )
            {
            // InternalGT.g:2750:1: ( ( rule__EditorNode__NameAssignment_2 ) )
            // InternalGT.g:2751:2: ( rule__EditorNode__NameAssignment_2 )
            {
             before(grammarAccess.getEditorNodeAccess().getNameAssignment_2()); 
            // InternalGT.g:2752:2: ( rule__EditorNode__NameAssignment_2 )
            // InternalGT.g:2752:3: rule__EditorNode__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorNode__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorNodeAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__2__Impl"


    // $ANTLR start "rule__EditorNode__Group__3"
    // InternalGT.g:2760:1: rule__EditorNode__Group__3 : rule__EditorNode__Group__3__Impl rule__EditorNode__Group__4 ;
    public final void rule__EditorNode__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2764:1: ( rule__EditorNode__Group__3__Impl rule__EditorNode__Group__4 )
            // InternalGT.g:2765:2: rule__EditorNode__Group__3__Impl rule__EditorNode__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__EditorNode__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorNode__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__3"


    // $ANTLR start "rule__EditorNode__Group__3__Impl"
    // InternalGT.g:2772:1: rule__EditorNode__Group__3__Impl : ( ':' ) ;
    public final void rule__EditorNode__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2776:1: ( ( ':' ) )
            // InternalGT.g:2777:1: ( ':' )
            {
            // InternalGT.g:2777:1: ( ':' )
            // InternalGT.g:2778:2: ':'
            {
             before(grammarAccess.getEditorNodeAccess().getColonKeyword_3()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getEditorNodeAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__3__Impl"


    // $ANTLR start "rule__EditorNode__Group__4"
    // InternalGT.g:2787:1: rule__EditorNode__Group__4 : rule__EditorNode__Group__4__Impl rule__EditorNode__Group__5 ;
    public final void rule__EditorNode__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2791:1: ( rule__EditorNode__Group__4__Impl rule__EditorNode__Group__5 )
            // InternalGT.g:2792:2: rule__EditorNode__Group__4__Impl rule__EditorNode__Group__5
            {
            pushFollow(FOLLOW_20);
            rule__EditorNode__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorNode__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__4"


    // $ANTLR start "rule__EditorNode__Group__4__Impl"
    // InternalGT.g:2799:1: rule__EditorNode__Group__4__Impl : ( ( rule__EditorNode__TypeAssignment_4 ) ) ;
    public final void rule__EditorNode__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2803:1: ( ( ( rule__EditorNode__TypeAssignment_4 ) ) )
            // InternalGT.g:2804:1: ( ( rule__EditorNode__TypeAssignment_4 ) )
            {
            // InternalGT.g:2804:1: ( ( rule__EditorNode__TypeAssignment_4 ) )
            // InternalGT.g:2805:2: ( rule__EditorNode__TypeAssignment_4 )
            {
             before(grammarAccess.getEditorNodeAccess().getTypeAssignment_4()); 
            // InternalGT.g:2806:2: ( rule__EditorNode__TypeAssignment_4 )
            // InternalGT.g:2806:3: rule__EditorNode__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__EditorNode__TypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEditorNodeAccess().getTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__4__Impl"


    // $ANTLR start "rule__EditorNode__Group__5"
    // InternalGT.g:2814:1: rule__EditorNode__Group__5 : rule__EditorNode__Group__5__Impl ;
    public final void rule__EditorNode__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2818:1: ( rule__EditorNode__Group__5__Impl )
            // InternalGT.g:2819:2: rule__EditorNode__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorNode__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__5"


    // $ANTLR start "rule__EditorNode__Group__5__Impl"
    // InternalGT.g:2825:1: rule__EditorNode__Group__5__Impl : ( ( rule__EditorNode__Group_5__0 )? ) ;
    public final void rule__EditorNode__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2829:1: ( ( ( rule__EditorNode__Group_5__0 )? ) )
            // InternalGT.g:2830:1: ( ( rule__EditorNode__Group_5__0 )? )
            {
            // InternalGT.g:2830:1: ( ( rule__EditorNode__Group_5__0 )? )
            // InternalGT.g:2831:2: ( rule__EditorNode__Group_5__0 )?
            {
             before(grammarAccess.getEditorNodeAccess().getGroup_5()); 
            // InternalGT.g:2832:2: ( rule__EditorNode__Group_5__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==49) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalGT.g:2832:3: rule__EditorNode__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorNode__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorNodeAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group__5__Impl"


    // $ANTLR start "rule__EditorNode__Group_5__0"
    // InternalGT.g:2841:1: rule__EditorNode__Group_5__0 : rule__EditorNode__Group_5__0__Impl rule__EditorNode__Group_5__1 ;
    public final void rule__EditorNode__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2845:1: ( rule__EditorNode__Group_5__0__Impl rule__EditorNode__Group_5__1 )
            // InternalGT.g:2846:2: rule__EditorNode__Group_5__0__Impl rule__EditorNode__Group_5__1
            {
            pushFollow(FOLLOW_21);
            rule__EditorNode__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorNode__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group_5__0"


    // $ANTLR start "rule__EditorNode__Group_5__0__Impl"
    // InternalGT.g:2853:1: rule__EditorNode__Group_5__0__Impl : ( '{' ) ;
    public final void rule__EditorNode__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2857:1: ( ( '{' ) )
            // InternalGT.g:2858:1: ( '{' )
            {
            // InternalGT.g:2858:1: ( '{' )
            // InternalGT.g:2859:2: '{'
            {
             before(grammarAccess.getEditorNodeAccess().getLeftCurlyBracketKeyword_5_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getEditorNodeAccess().getLeftCurlyBracketKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group_5__0__Impl"


    // $ANTLR start "rule__EditorNode__Group_5__1"
    // InternalGT.g:2868:1: rule__EditorNode__Group_5__1 : rule__EditorNode__Group_5__1__Impl rule__EditorNode__Group_5__2 ;
    public final void rule__EditorNode__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2872:1: ( rule__EditorNode__Group_5__1__Impl rule__EditorNode__Group_5__2 )
            // InternalGT.g:2873:2: rule__EditorNode__Group_5__1__Impl rule__EditorNode__Group_5__2
            {
            pushFollow(FOLLOW_21);
            rule__EditorNode__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorNode__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group_5__1"


    // $ANTLR start "rule__EditorNode__Group_5__1__Impl"
    // InternalGT.g:2880:1: rule__EditorNode__Group_5__1__Impl : ( ( rule__EditorNode__Alternatives_5_1 )* ) ;
    public final void rule__EditorNode__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2884:1: ( ( ( rule__EditorNode__Alternatives_5_1 )* ) )
            // InternalGT.g:2885:1: ( ( rule__EditorNode__Alternatives_5_1 )* )
            {
            // InternalGT.g:2885:1: ( ( rule__EditorNode__Alternatives_5_1 )* )
            // InternalGT.g:2886:2: ( rule__EditorNode__Alternatives_5_1 )*
            {
             before(grammarAccess.getEditorNodeAccess().getAlternatives_5_1()); 
            // InternalGT.g:2887:2: ( rule__EditorNode__Alternatives_5_1 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( ((LA41_0>=15 && LA41_0<=17)||LA41_0==27||LA41_0==55||LA41_0==61) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalGT.g:2887:3: rule__EditorNode__Alternatives_5_1
            	    {
            	    pushFollow(FOLLOW_22);
            	    rule__EditorNode__Alternatives_5_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getEditorNodeAccess().getAlternatives_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group_5__1__Impl"


    // $ANTLR start "rule__EditorNode__Group_5__2"
    // InternalGT.g:2895:1: rule__EditorNode__Group_5__2 : rule__EditorNode__Group_5__2__Impl ;
    public final void rule__EditorNode__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2899:1: ( rule__EditorNode__Group_5__2__Impl )
            // InternalGT.g:2900:2: rule__EditorNode__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorNode__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group_5__2"


    // $ANTLR start "rule__EditorNode__Group_5__2__Impl"
    // InternalGT.g:2906:1: rule__EditorNode__Group_5__2__Impl : ( '}' ) ;
    public final void rule__EditorNode__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2910:1: ( ( '}' ) )
            // InternalGT.g:2911:1: ( '}' )
            {
            // InternalGT.g:2911:1: ( '}' )
            // InternalGT.g:2912:2: '}'
            {
             before(grammarAccess.getEditorNodeAccess().getRightCurlyBracketKeyword_5_2()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getEditorNodeAccess().getRightCurlyBracketKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__Group_5__2__Impl"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__0"
    // InternalGT.g:2922:1: rule__EditorAttributeConstraint__Group__0 : rule__EditorAttributeConstraint__Group__0__Impl rule__EditorAttributeConstraint__Group__1 ;
    public final void rule__EditorAttributeConstraint__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2926:1: ( rule__EditorAttributeConstraint__Group__0__Impl rule__EditorAttributeConstraint__Group__1 )
            // InternalGT.g:2927:2: rule__EditorAttributeConstraint__Group__0__Impl rule__EditorAttributeConstraint__Group__1
            {
            pushFollow(FOLLOW_23);
            rule__EditorAttributeConstraint__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__0"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__0__Impl"
    // InternalGT.g:2934:1: rule__EditorAttributeConstraint__Group__0__Impl : ( '#' ) ;
    public final void rule__EditorAttributeConstraint__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2938:1: ( ( '#' ) )
            // InternalGT.g:2939:1: ( '#' )
            {
            // InternalGT.g:2939:1: ( '#' )
            // InternalGT.g:2940:2: '#'
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getNumberSignKeyword_0()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getEditorAttributeConstraintAccess().getNumberSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__0__Impl"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__1"
    // InternalGT.g:2949:1: rule__EditorAttributeConstraint__Group__1 : rule__EditorAttributeConstraint__Group__1__Impl rule__EditorAttributeConstraint__Group__2 ;
    public final void rule__EditorAttributeConstraint__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2953:1: ( rule__EditorAttributeConstraint__Group__1__Impl rule__EditorAttributeConstraint__Group__2 )
            // InternalGT.g:2954:2: rule__EditorAttributeConstraint__Group__1__Impl rule__EditorAttributeConstraint__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__EditorAttributeConstraint__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__1"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__1__Impl"
    // InternalGT.g:2961:1: rule__EditorAttributeConstraint__Group__1__Impl : ( ( rule__EditorAttributeConstraint__LhsAssignment_1 ) ) ;
    public final void rule__EditorAttributeConstraint__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2965:1: ( ( ( rule__EditorAttributeConstraint__LhsAssignment_1 ) ) )
            // InternalGT.g:2966:1: ( ( rule__EditorAttributeConstraint__LhsAssignment_1 ) )
            {
            // InternalGT.g:2966:1: ( ( rule__EditorAttributeConstraint__LhsAssignment_1 ) )
            // InternalGT.g:2967:2: ( rule__EditorAttributeConstraint__LhsAssignment_1 )
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getLhsAssignment_1()); 
            // InternalGT.g:2968:2: ( rule__EditorAttributeConstraint__LhsAssignment_1 )
            // InternalGT.g:2968:3: rule__EditorAttributeConstraint__LhsAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__LhsAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeConstraintAccess().getLhsAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__1__Impl"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__2"
    // InternalGT.g:2976:1: rule__EditorAttributeConstraint__Group__2 : rule__EditorAttributeConstraint__Group__2__Impl rule__EditorAttributeConstraint__Group__3 ;
    public final void rule__EditorAttributeConstraint__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2980:1: ( rule__EditorAttributeConstraint__Group__2__Impl rule__EditorAttributeConstraint__Group__3 )
            // InternalGT.g:2981:2: rule__EditorAttributeConstraint__Group__2__Impl rule__EditorAttributeConstraint__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__EditorAttributeConstraint__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__2"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__2__Impl"
    // InternalGT.g:2988:1: rule__EditorAttributeConstraint__Group__2__Impl : ( ( rule__EditorAttributeConstraint__RelationAssignment_2 ) ) ;
    public final void rule__EditorAttributeConstraint__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:2992:1: ( ( ( rule__EditorAttributeConstraint__RelationAssignment_2 ) ) )
            // InternalGT.g:2993:1: ( ( rule__EditorAttributeConstraint__RelationAssignment_2 ) )
            {
            // InternalGT.g:2993:1: ( ( rule__EditorAttributeConstraint__RelationAssignment_2 ) )
            // InternalGT.g:2994:2: ( rule__EditorAttributeConstraint__RelationAssignment_2 )
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getRelationAssignment_2()); 
            // InternalGT.g:2995:2: ( rule__EditorAttributeConstraint__RelationAssignment_2 )
            // InternalGT.g:2995:3: rule__EditorAttributeConstraint__RelationAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__RelationAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeConstraintAccess().getRelationAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__2__Impl"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__3"
    // InternalGT.g:3003:1: rule__EditorAttributeConstraint__Group__3 : rule__EditorAttributeConstraint__Group__3__Impl ;
    public final void rule__EditorAttributeConstraint__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3007:1: ( rule__EditorAttributeConstraint__Group__3__Impl )
            // InternalGT.g:3008:2: rule__EditorAttributeConstraint__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__3"


    // $ANTLR start "rule__EditorAttributeConstraint__Group__3__Impl"
    // InternalGT.g:3014:1: rule__EditorAttributeConstraint__Group__3__Impl : ( ( rule__EditorAttributeConstraint__RhsAssignment_3 ) ) ;
    public final void rule__EditorAttributeConstraint__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3018:1: ( ( ( rule__EditorAttributeConstraint__RhsAssignment_3 ) ) )
            // InternalGT.g:3019:1: ( ( rule__EditorAttributeConstraint__RhsAssignment_3 ) )
            {
            // InternalGT.g:3019:1: ( ( rule__EditorAttributeConstraint__RhsAssignment_3 ) )
            // InternalGT.g:3020:2: ( rule__EditorAttributeConstraint__RhsAssignment_3 )
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getRhsAssignment_3()); 
            // InternalGT.g:3021:2: ( rule__EditorAttributeConstraint__RhsAssignment_3 )
            // InternalGT.g:3021:3: rule__EditorAttributeConstraint__RhsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeConstraint__RhsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeConstraintAccess().getRhsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__Group__3__Impl"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__0"
    // InternalGT.g:3030:1: rule__EditorAttributeAssignment__Group__0 : rule__EditorAttributeAssignment__Group__0__Impl rule__EditorAttributeAssignment__Group__1 ;
    public final void rule__EditorAttributeAssignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3034:1: ( rule__EditorAttributeAssignment__Group__0__Impl rule__EditorAttributeAssignment__Group__1 )
            // InternalGT.g:3035:2: rule__EditorAttributeAssignment__Group__0__Impl rule__EditorAttributeAssignment__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorAttributeAssignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeAssignment__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__0"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__0__Impl"
    // InternalGT.g:3042:1: rule__EditorAttributeAssignment__Group__0__Impl : ( '.' ) ;
    public final void rule__EditorAttributeAssignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3046:1: ( ( '.' ) )
            // InternalGT.g:3047:1: ( '.' )
            {
            // InternalGT.g:3047:1: ( '.' )
            // InternalGT.g:3048:2: '.'
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getFullStopKeyword_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getEditorAttributeAssignmentAccess().getFullStopKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__0__Impl"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__1"
    // InternalGT.g:3057:1: rule__EditorAttributeAssignment__Group__1 : rule__EditorAttributeAssignment__Group__1__Impl rule__EditorAttributeAssignment__Group__2 ;
    public final void rule__EditorAttributeAssignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3061:1: ( rule__EditorAttributeAssignment__Group__1__Impl rule__EditorAttributeAssignment__Group__2 )
            // InternalGT.g:3062:2: rule__EditorAttributeAssignment__Group__1__Impl rule__EditorAttributeAssignment__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__EditorAttributeAssignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeAssignment__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__1"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__1__Impl"
    // InternalGT.g:3069:1: rule__EditorAttributeAssignment__Group__1__Impl : ( ( rule__EditorAttributeAssignment__AttributeAssignment_1 ) ) ;
    public final void rule__EditorAttributeAssignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3073:1: ( ( ( rule__EditorAttributeAssignment__AttributeAssignment_1 ) ) )
            // InternalGT.g:3074:1: ( ( rule__EditorAttributeAssignment__AttributeAssignment_1 ) )
            {
            // InternalGT.g:3074:1: ( ( rule__EditorAttributeAssignment__AttributeAssignment_1 ) )
            // InternalGT.g:3075:2: ( rule__EditorAttributeAssignment__AttributeAssignment_1 )
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getAttributeAssignment_1()); 
            // InternalGT.g:3076:2: ( rule__EditorAttributeAssignment__AttributeAssignment_1 )
            // InternalGT.g:3076:3: rule__EditorAttributeAssignment__AttributeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeAssignment__AttributeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeAssignmentAccess().getAttributeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__1__Impl"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__2"
    // InternalGT.g:3084:1: rule__EditorAttributeAssignment__Group__2 : rule__EditorAttributeAssignment__Group__2__Impl rule__EditorAttributeAssignment__Group__3 ;
    public final void rule__EditorAttributeAssignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3088:1: ( rule__EditorAttributeAssignment__Group__2__Impl rule__EditorAttributeAssignment__Group__3 )
            // InternalGT.g:3089:2: rule__EditorAttributeAssignment__Group__2__Impl rule__EditorAttributeAssignment__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__EditorAttributeAssignment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeAssignment__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__2"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__2__Impl"
    // InternalGT.g:3096:1: rule__EditorAttributeAssignment__Group__2__Impl : ( ':=' ) ;
    public final void rule__EditorAttributeAssignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3100:1: ( ( ':=' ) )
            // InternalGT.g:3101:1: ( ':=' )
            {
            // InternalGT.g:3101:1: ( ':=' )
            // InternalGT.g:3102:2: ':='
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getColonEqualsSignKeyword_2()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getEditorAttributeAssignmentAccess().getColonEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__2__Impl"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__3"
    // InternalGT.g:3111:1: rule__EditorAttributeAssignment__Group__3 : rule__EditorAttributeAssignment__Group__3__Impl ;
    public final void rule__EditorAttributeAssignment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3115:1: ( rule__EditorAttributeAssignment__Group__3__Impl )
            // InternalGT.g:3116:2: rule__EditorAttributeAssignment__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeAssignment__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__3"


    // $ANTLR start "rule__EditorAttributeAssignment__Group__3__Impl"
    // InternalGT.g:3122:1: rule__EditorAttributeAssignment__Group__3__Impl : ( ( rule__EditorAttributeAssignment__ValueAssignment_3 ) ) ;
    public final void rule__EditorAttributeAssignment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3126:1: ( ( ( rule__EditorAttributeAssignment__ValueAssignment_3 ) ) )
            // InternalGT.g:3127:1: ( ( rule__EditorAttributeAssignment__ValueAssignment_3 ) )
            {
            // InternalGT.g:3127:1: ( ( rule__EditorAttributeAssignment__ValueAssignment_3 ) )
            // InternalGT.g:3128:2: ( rule__EditorAttributeAssignment__ValueAssignment_3 )
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getValueAssignment_3()); 
            // InternalGT.g:3129:2: ( rule__EditorAttributeAssignment__ValueAssignment_3 )
            // InternalGT.g:3129:3: rule__EditorAttributeAssignment__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeAssignment__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeAssignmentAccess().getValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__Group__3__Impl"


    // $ANTLR start "rule__EditorAttributeExpression__Group__0"
    // InternalGT.g:3138:1: rule__EditorAttributeExpression__Group__0 : rule__EditorAttributeExpression__Group__0__Impl rule__EditorAttributeExpression__Group__1 ;
    public final void rule__EditorAttributeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3142:1: ( rule__EditorAttributeExpression__Group__0__Impl rule__EditorAttributeExpression__Group__1 )
            // InternalGT.g:3143:2: rule__EditorAttributeExpression__Group__0__Impl rule__EditorAttributeExpression__Group__1
            {
            pushFollow(FOLLOW_26);
            rule__EditorAttributeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__Group__0"


    // $ANTLR start "rule__EditorAttributeExpression__Group__0__Impl"
    // InternalGT.g:3150:1: rule__EditorAttributeExpression__Group__0__Impl : ( ( rule__EditorAttributeExpression__NodeAssignment_0 ) ) ;
    public final void rule__EditorAttributeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3154:1: ( ( ( rule__EditorAttributeExpression__NodeAssignment_0 ) ) )
            // InternalGT.g:3155:1: ( ( rule__EditorAttributeExpression__NodeAssignment_0 ) )
            {
            // InternalGT.g:3155:1: ( ( rule__EditorAttributeExpression__NodeAssignment_0 ) )
            // InternalGT.g:3156:2: ( rule__EditorAttributeExpression__NodeAssignment_0 )
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getNodeAssignment_0()); 
            // InternalGT.g:3157:2: ( rule__EditorAttributeExpression__NodeAssignment_0 )
            // InternalGT.g:3157:3: rule__EditorAttributeExpression__NodeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeExpression__NodeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeExpressionAccess().getNodeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__Group__0__Impl"


    // $ANTLR start "rule__EditorAttributeExpression__Group__1"
    // InternalGT.g:3165:1: rule__EditorAttributeExpression__Group__1 : rule__EditorAttributeExpression__Group__1__Impl rule__EditorAttributeExpression__Group__2 ;
    public final void rule__EditorAttributeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3169:1: ( rule__EditorAttributeExpression__Group__1__Impl rule__EditorAttributeExpression__Group__2 )
            // InternalGT.g:3170:2: rule__EditorAttributeExpression__Group__1__Impl rule__EditorAttributeExpression__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__EditorAttributeExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorAttributeExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__Group__1"


    // $ANTLR start "rule__EditorAttributeExpression__Group__1__Impl"
    // InternalGT.g:3177:1: rule__EditorAttributeExpression__Group__1__Impl : ( '.' ) ;
    public final void rule__EditorAttributeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3181:1: ( ( '.' ) )
            // InternalGT.g:3182:1: ( '.' )
            {
            // InternalGT.g:3182:1: ( '.' )
            // InternalGT.g:3183:2: '.'
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getFullStopKeyword_1()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getEditorAttributeExpressionAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__Group__1__Impl"


    // $ANTLR start "rule__EditorAttributeExpression__Group__2"
    // InternalGT.g:3192:1: rule__EditorAttributeExpression__Group__2 : rule__EditorAttributeExpression__Group__2__Impl ;
    public final void rule__EditorAttributeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3196:1: ( rule__EditorAttributeExpression__Group__2__Impl )
            // InternalGT.g:3197:2: rule__EditorAttributeExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeExpression__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__Group__2"


    // $ANTLR start "rule__EditorAttributeExpression__Group__2__Impl"
    // InternalGT.g:3203:1: rule__EditorAttributeExpression__Group__2__Impl : ( ( rule__EditorAttributeExpression__AttributeAssignment_2 ) ) ;
    public final void rule__EditorAttributeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3207:1: ( ( ( rule__EditorAttributeExpression__AttributeAssignment_2 ) ) )
            // InternalGT.g:3208:1: ( ( rule__EditorAttributeExpression__AttributeAssignment_2 ) )
            {
            // InternalGT.g:3208:1: ( ( rule__EditorAttributeExpression__AttributeAssignment_2 ) )
            // InternalGT.g:3209:2: ( rule__EditorAttributeExpression__AttributeAssignment_2 )
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getAttributeAssignment_2()); 
            // InternalGT.g:3210:2: ( rule__EditorAttributeExpression__AttributeAssignment_2 )
            // InternalGT.g:3210:3: rule__EditorAttributeExpression__AttributeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorAttributeExpression__AttributeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorAttributeExpressionAccess().getAttributeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__Group__2__Impl"


    // $ANTLR start "rule__EditorCountExpression__Group__0"
    // InternalGT.g:3219:1: rule__EditorCountExpression__Group__0 : rule__EditorCountExpression__Group__0__Impl rule__EditorCountExpression__Group__1 ;
    public final void rule__EditorCountExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3223:1: ( rule__EditorCountExpression__Group__0__Impl rule__EditorCountExpression__Group__1 )
            // InternalGT.g:3224:2: rule__EditorCountExpression__Group__0__Impl rule__EditorCountExpression__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__EditorCountExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCountExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__0"


    // $ANTLR start "rule__EditorCountExpression__Group__0__Impl"
    // InternalGT.g:3231:1: rule__EditorCountExpression__Group__0__Impl : ( 'count' ) ;
    public final void rule__EditorCountExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3235:1: ( ( 'count' ) )
            // InternalGT.g:3236:1: ( 'count' )
            {
            // InternalGT.g:3236:1: ( 'count' )
            // InternalGT.g:3237:2: 'count'
            {
             before(grammarAccess.getEditorCountExpressionAccess().getCountKeyword_0()); 
            match(input,57,FOLLOW_2); 
             after(grammarAccess.getEditorCountExpressionAccess().getCountKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__0__Impl"


    // $ANTLR start "rule__EditorCountExpression__Group__1"
    // InternalGT.g:3246:1: rule__EditorCountExpression__Group__1 : rule__EditorCountExpression__Group__1__Impl rule__EditorCountExpression__Group__2 ;
    public final void rule__EditorCountExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3250:1: ( rule__EditorCountExpression__Group__1__Impl rule__EditorCountExpression__Group__2 )
            // InternalGT.g:3251:2: rule__EditorCountExpression__Group__1__Impl rule__EditorCountExpression__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__EditorCountExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCountExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__1"


    // $ANTLR start "rule__EditorCountExpression__Group__1__Impl"
    // InternalGT.g:3258:1: rule__EditorCountExpression__Group__1__Impl : ( '(' ) ;
    public final void rule__EditorCountExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3262:1: ( ( '(' ) )
            // InternalGT.g:3263:1: ( '(' )
            {
            // InternalGT.g:3263:1: ( '(' )
            // InternalGT.g:3264:2: '('
            {
             before(grammarAccess.getEditorCountExpressionAccess().getLeftParenthesisKeyword_1()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getEditorCountExpressionAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__1__Impl"


    // $ANTLR start "rule__EditorCountExpression__Group__2"
    // InternalGT.g:3273:1: rule__EditorCountExpression__Group__2 : rule__EditorCountExpression__Group__2__Impl rule__EditorCountExpression__Group__3 ;
    public final void rule__EditorCountExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3277:1: ( rule__EditorCountExpression__Group__2__Impl rule__EditorCountExpression__Group__3 )
            // InternalGT.g:3278:2: rule__EditorCountExpression__Group__2__Impl rule__EditorCountExpression__Group__3
            {
            pushFollow(FOLLOW_28);
            rule__EditorCountExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCountExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__2"


    // $ANTLR start "rule__EditorCountExpression__Group__2__Impl"
    // InternalGT.g:3285:1: rule__EditorCountExpression__Group__2__Impl : ( ( rule__EditorCountExpression__InvokedPattenAssignment_2 ) ) ;
    public final void rule__EditorCountExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3289:1: ( ( ( rule__EditorCountExpression__InvokedPattenAssignment_2 ) ) )
            // InternalGT.g:3290:1: ( ( rule__EditorCountExpression__InvokedPattenAssignment_2 ) )
            {
            // InternalGT.g:3290:1: ( ( rule__EditorCountExpression__InvokedPattenAssignment_2 ) )
            // InternalGT.g:3291:2: ( rule__EditorCountExpression__InvokedPattenAssignment_2 )
            {
             before(grammarAccess.getEditorCountExpressionAccess().getInvokedPattenAssignment_2()); 
            // InternalGT.g:3292:2: ( rule__EditorCountExpression__InvokedPattenAssignment_2 )
            // InternalGT.g:3292:3: rule__EditorCountExpression__InvokedPattenAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorCountExpression__InvokedPattenAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorCountExpressionAccess().getInvokedPattenAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__2__Impl"


    // $ANTLR start "rule__EditorCountExpression__Group__3"
    // InternalGT.g:3300:1: rule__EditorCountExpression__Group__3 : rule__EditorCountExpression__Group__3__Impl ;
    public final void rule__EditorCountExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3304:1: ( rule__EditorCountExpression__Group__3__Impl )
            // InternalGT.g:3305:2: rule__EditorCountExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorCountExpression__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__3"


    // $ANTLR start "rule__EditorCountExpression__Group__3__Impl"
    // InternalGT.g:3311:1: rule__EditorCountExpression__Group__3__Impl : ( ')' ) ;
    public final void rule__EditorCountExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3315:1: ( ( ')' ) )
            // InternalGT.g:3316:1: ( ')' )
            {
            // InternalGT.g:3316:1: ( ')' )
            // InternalGT.g:3317:2: ')'
            {
             before(grammarAccess.getEditorCountExpressionAccess().getRightParenthesisKeyword_3()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getEditorCountExpressionAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__Group__3__Impl"


    // $ANTLR start "rule__EditorLiteralExpression__Group_1__0"
    // InternalGT.g:3327:1: rule__EditorLiteralExpression__Group_1__0 : rule__EditorLiteralExpression__Group_1__0__Impl rule__EditorLiteralExpression__Group_1__1 ;
    public final void rule__EditorLiteralExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3331:1: ( rule__EditorLiteralExpression__Group_1__0__Impl rule__EditorLiteralExpression__Group_1__1 )
            // InternalGT.g:3332:2: rule__EditorLiteralExpression__Group_1__0__Impl rule__EditorLiteralExpression__Group_1__1
            {
            pushFollow(FOLLOW_29);
            rule__EditorLiteralExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorLiteralExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorLiteralExpression__Group_1__0"


    // $ANTLR start "rule__EditorLiteralExpression__Group_1__0__Impl"
    // InternalGT.g:3339:1: rule__EditorLiteralExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__EditorLiteralExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3343:1: ( ( () ) )
            // InternalGT.g:3344:1: ( () )
            {
            // InternalGT.g:3344:1: ( () )
            // InternalGT.g:3345:2: ()
            {
             before(grammarAccess.getEditorLiteralExpressionAccess().getStringConstantAction_1_0()); 
            // InternalGT.g:3346:2: ()
            // InternalGT.g:3346:3: 
            {
            }

             after(grammarAccess.getEditorLiteralExpressionAccess().getStringConstantAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorLiteralExpression__Group_1__0__Impl"


    // $ANTLR start "rule__EditorLiteralExpression__Group_1__1"
    // InternalGT.g:3354:1: rule__EditorLiteralExpression__Group_1__1 : rule__EditorLiteralExpression__Group_1__1__Impl ;
    public final void rule__EditorLiteralExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3358:1: ( rule__EditorLiteralExpression__Group_1__1__Impl )
            // InternalGT.g:3359:2: rule__EditorLiteralExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorLiteralExpression__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorLiteralExpression__Group_1__1"


    // $ANTLR start "rule__EditorLiteralExpression__Group_1__1__Impl"
    // InternalGT.g:3365:1: rule__EditorLiteralExpression__Group_1__1__Impl : ( ( rule__EditorLiteralExpression__ValueAssignment_1_1 ) ) ;
    public final void rule__EditorLiteralExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3369:1: ( ( ( rule__EditorLiteralExpression__ValueAssignment_1_1 ) ) )
            // InternalGT.g:3370:1: ( ( rule__EditorLiteralExpression__ValueAssignment_1_1 ) )
            {
            // InternalGT.g:3370:1: ( ( rule__EditorLiteralExpression__ValueAssignment_1_1 ) )
            // InternalGT.g:3371:2: ( rule__EditorLiteralExpression__ValueAssignment_1_1 )
            {
             before(grammarAccess.getEditorLiteralExpressionAccess().getValueAssignment_1_1()); 
            // InternalGT.g:3372:2: ( rule__EditorLiteralExpression__ValueAssignment_1_1 )
            // InternalGT.g:3372:3: rule__EditorLiteralExpression__ValueAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorLiteralExpression__ValueAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorLiteralExpressionAccess().getValueAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorLiteralExpression__Group_1__1__Impl"


    // $ANTLR start "rule__Number__Group__0"
    // InternalGT.g:3381:1: rule__Number__Group__0 : rule__Number__Group__0__Impl rule__Number__Group__1 ;
    public final void rule__Number__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3385:1: ( rule__Number__Group__0__Impl rule__Number__Group__1 )
            // InternalGT.g:3386:2: rule__Number__Group__0__Impl rule__Number__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__Number__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Number__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__0"


    // $ANTLR start "rule__Number__Group__0__Impl"
    // InternalGT.g:3393:1: rule__Number__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__Number__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3397:1: ( ( ( '-' )? ) )
            // InternalGT.g:3398:1: ( ( '-' )? )
            {
            // InternalGT.g:3398:1: ( ( '-' )? )
            // InternalGT.g:3399:2: ( '-' )?
            {
             before(grammarAccess.getNumberAccess().getHyphenMinusKeyword_0()); 
            // InternalGT.g:3400:2: ( '-' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==27) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalGT.g:3400:3: '-'
                    {
                    match(input,27,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getNumberAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__0__Impl"


    // $ANTLR start "rule__Number__Group__1"
    // InternalGT.g:3408:1: rule__Number__Group__1 : rule__Number__Group__1__Impl rule__Number__Group__2 ;
    public final void rule__Number__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3412:1: ( rule__Number__Group__1__Impl rule__Number__Group__2 )
            // InternalGT.g:3413:2: rule__Number__Group__1__Impl rule__Number__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__Number__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Number__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__1"


    // $ANTLR start "rule__Number__Group__1__Impl"
    // InternalGT.g:3420:1: rule__Number__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__Number__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3424:1: ( ( RULE_INT ) )
            // InternalGT.g:3425:1: ( RULE_INT )
            {
            // InternalGT.g:3425:1: ( RULE_INT )
            // InternalGT.g:3426:2: RULE_INT
            {
             before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__1__Impl"


    // $ANTLR start "rule__Number__Group__2"
    // InternalGT.g:3435:1: rule__Number__Group__2 : rule__Number__Group__2__Impl ;
    public final void rule__Number__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3439:1: ( rule__Number__Group__2__Impl )
            // InternalGT.g:3440:2: rule__Number__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__2"


    // $ANTLR start "rule__Number__Group__2__Impl"
    // InternalGT.g:3446:1: rule__Number__Group__2__Impl : ( ( rule__Number__Group_2__0 )? ) ;
    public final void rule__Number__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3450:1: ( ( ( rule__Number__Group_2__0 )? ) )
            // InternalGT.g:3451:1: ( ( rule__Number__Group_2__0 )? )
            {
            // InternalGT.g:3451:1: ( ( rule__Number__Group_2__0 )? )
            // InternalGT.g:3452:2: ( rule__Number__Group_2__0 )?
            {
             before(grammarAccess.getNumberAccess().getGroup_2()); 
            // InternalGT.g:3453:2: ( rule__Number__Group_2__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==55) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==RULE_INT) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalGT.g:3453:3: rule__Number__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Number__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNumberAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group__2__Impl"


    // $ANTLR start "rule__Number__Group_2__0"
    // InternalGT.g:3462:1: rule__Number__Group_2__0 : rule__Number__Group_2__0__Impl rule__Number__Group_2__1 ;
    public final void rule__Number__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3466:1: ( rule__Number__Group_2__0__Impl rule__Number__Group_2__1 )
            // InternalGT.g:3467:2: rule__Number__Group_2__0__Impl rule__Number__Group_2__1
            {
            pushFollow(FOLLOW_31);
            rule__Number__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Number__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_2__0"


    // $ANTLR start "rule__Number__Group_2__0__Impl"
    // InternalGT.g:3474:1: rule__Number__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Number__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3478:1: ( ( '.' ) )
            // InternalGT.g:3479:1: ( '.' )
            {
            // InternalGT.g:3479:1: ( '.' )
            // InternalGT.g:3480:2: '.'
            {
             before(grammarAccess.getNumberAccess().getFullStopKeyword_2_0()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getNumberAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_2__0__Impl"


    // $ANTLR start "rule__Number__Group_2__1"
    // InternalGT.g:3489:1: rule__Number__Group_2__1 : rule__Number__Group_2__1__Impl ;
    public final void rule__Number__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3493:1: ( rule__Number__Group_2__1__Impl )
            // InternalGT.g:3494:2: rule__Number__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Number__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_2__1"


    // $ANTLR start "rule__Number__Group_2__1__Impl"
    // InternalGT.g:3500:1: rule__Number__Group_2__1__Impl : ( RULE_INT ) ;
    public final void rule__Number__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3504:1: ( ( RULE_INT ) )
            // InternalGT.g:3505:1: ( RULE_INT )
            {
            // InternalGT.g:3505:1: ( RULE_INT )
            // InternalGT.g:3506:2: RULE_INT
            {
             before(grammarAccess.getNumberAccess().getINTTerminalRuleCall_2_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getNumberAccess().getINTTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Number__Group_2__1__Impl"


    // $ANTLR start "rule__EditorEnumExpression__Group__0"
    // InternalGT.g:3516:1: rule__EditorEnumExpression__Group__0 : rule__EditorEnumExpression__Group__0__Impl rule__EditorEnumExpression__Group__1 ;
    public final void rule__EditorEnumExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3520:1: ( rule__EditorEnumExpression__Group__0__Impl rule__EditorEnumExpression__Group__1 )
            // InternalGT.g:3521:2: rule__EditorEnumExpression__Group__0__Impl rule__EditorEnumExpression__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorEnumExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorEnumExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorEnumExpression__Group__0"


    // $ANTLR start "rule__EditorEnumExpression__Group__0__Impl"
    // InternalGT.g:3528:1: rule__EditorEnumExpression__Group__0__Impl : ( 'enum::' ) ;
    public final void rule__EditorEnumExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3532:1: ( ( 'enum::' ) )
            // InternalGT.g:3533:1: ( 'enum::' )
            {
            // InternalGT.g:3533:1: ( 'enum::' )
            // InternalGT.g:3534:2: 'enum::'
            {
             before(grammarAccess.getEditorEnumExpressionAccess().getEnumKeyword_0()); 
            match(input,58,FOLLOW_2); 
             after(grammarAccess.getEditorEnumExpressionAccess().getEnumKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorEnumExpression__Group__0__Impl"


    // $ANTLR start "rule__EditorEnumExpression__Group__1"
    // InternalGT.g:3543:1: rule__EditorEnumExpression__Group__1 : rule__EditorEnumExpression__Group__1__Impl ;
    public final void rule__EditorEnumExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3547:1: ( rule__EditorEnumExpression__Group__1__Impl )
            // InternalGT.g:3548:2: rule__EditorEnumExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorEnumExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorEnumExpression__Group__1"


    // $ANTLR start "rule__EditorEnumExpression__Group__1__Impl"
    // InternalGT.g:3554:1: rule__EditorEnumExpression__Group__1__Impl : ( ( rule__EditorEnumExpression__LiteralAssignment_1 ) ) ;
    public final void rule__EditorEnumExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3558:1: ( ( ( rule__EditorEnumExpression__LiteralAssignment_1 ) ) )
            // InternalGT.g:3559:1: ( ( rule__EditorEnumExpression__LiteralAssignment_1 ) )
            {
            // InternalGT.g:3559:1: ( ( rule__EditorEnumExpression__LiteralAssignment_1 ) )
            // InternalGT.g:3560:2: ( rule__EditorEnumExpression__LiteralAssignment_1 )
            {
             before(grammarAccess.getEditorEnumExpressionAccess().getLiteralAssignment_1()); 
            // InternalGT.g:3561:2: ( rule__EditorEnumExpression__LiteralAssignment_1 )
            // InternalGT.g:3561:3: rule__EditorEnumExpression__LiteralAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorEnumExpression__LiteralAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorEnumExpressionAccess().getLiteralAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorEnumExpression__Group__1__Impl"


    // $ANTLR start "rule__EditorParameterExpression__Group__0"
    // InternalGT.g:3570:1: rule__EditorParameterExpression__Group__0 : rule__EditorParameterExpression__Group__0__Impl rule__EditorParameterExpression__Group__1 ;
    public final void rule__EditorParameterExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3574:1: ( rule__EditorParameterExpression__Group__0__Impl rule__EditorParameterExpression__Group__1 )
            // InternalGT.g:3575:2: rule__EditorParameterExpression__Group__0__Impl rule__EditorParameterExpression__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorParameterExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorParameterExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameterExpression__Group__0"


    // $ANTLR start "rule__EditorParameterExpression__Group__0__Impl"
    // InternalGT.g:3582:1: rule__EditorParameterExpression__Group__0__Impl : ( 'param::' ) ;
    public final void rule__EditorParameterExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3586:1: ( ( 'param::' ) )
            // InternalGT.g:3587:1: ( 'param::' )
            {
            // InternalGT.g:3587:1: ( 'param::' )
            // InternalGT.g:3588:2: 'param::'
            {
             before(grammarAccess.getEditorParameterExpressionAccess().getParamKeyword_0()); 
            match(input,59,FOLLOW_2); 
             after(grammarAccess.getEditorParameterExpressionAccess().getParamKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameterExpression__Group__0__Impl"


    // $ANTLR start "rule__EditorParameterExpression__Group__1"
    // InternalGT.g:3597:1: rule__EditorParameterExpression__Group__1 : rule__EditorParameterExpression__Group__1__Impl ;
    public final void rule__EditorParameterExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3601:1: ( rule__EditorParameterExpression__Group__1__Impl )
            // InternalGT.g:3602:2: rule__EditorParameterExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorParameterExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameterExpression__Group__1"


    // $ANTLR start "rule__EditorParameterExpression__Group__1__Impl"
    // InternalGT.g:3608:1: rule__EditorParameterExpression__Group__1__Impl : ( ( rule__EditorParameterExpression__ParameterAssignment_1 ) ) ;
    public final void rule__EditorParameterExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3612:1: ( ( ( rule__EditorParameterExpression__ParameterAssignment_1 ) ) )
            // InternalGT.g:3613:1: ( ( rule__EditorParameterExpression__ParameterAssignment_1 ) )
            {
            // InternalGT.g:3613:1: ( ( rule__EditorParameterExpression__ParameterAssignment_1 ) )
            // InternalGT.g:3614:2: ( rule__EditorParameterExpression__ParameterAssignment_1 )
            {
             before(grammarAccess.getEditorParameterExpressionAccess().getParameterAssignment_1()); 
            // InternalGT.g:3615:2: ( rule__EditorParameterExpression__ParameterAssignment_1 )
            // InternalGT.g:3615:3: rule__EditorParameterExpression__ParameterAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorParameterExpression__ParameterAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorParameterExpressionAccess().getParameterAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameterExpression__Group__1__Impl"


    // $ANTLR start "rule__EditorReference__Group__0"
    // InternalGT.g:3624:1: rule__EditorReference__Group__0 : rule__EditorReference__Group__0__Impl rule__EditorReference__Group__1 ;
    public final void rule__EditorReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3628:1: ( rule__EditorReference__Group__0__Impl rule__EditorReference__Group__1 )
            // InternalGT.g:3629:2: rule__EditorReference__Group__0__Impl rule__EditorReference__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__EditorReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__0"


    // $ANTLR start "rule__EditorReference__Group__0__Impl"
    // InternalGT.g:3636:1: rule__EditorReference__Group__0__Impl : ( ( rule__EditorReference__OperatorAssignment_0 )? ) ;
    public final void rule__EditorReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3640:1: ( ( ( rule__EditorReference__OperatorAssignment_0 )? ) )
            // InternalGT.g:3641:1: ( ( rule__EditorReference__OperatorAssignment_0 )? )
            {
            // InternalGT.g:3641:1: ( ( rule__EditorReference__OperatorAssignment_0 )? )
            // InternalGT.g:3642:2: ( rule__EditorReference__OperatorAssignment_0 )?
            {
             before(grammarAccess.getEditorReferenceAccess().getOperatorAssignment_0()); 
            // InternalGT.g:3643:2: ( rule__EditorReference__OperatorAssignment_0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=15 && LA44_0<=17)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalGT.g:3643:3: rule__EditorReference__OperatorAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorReference__OperatorAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorReferenceAccess().getOperatorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__0__Impl"


    // $ANTLR start "rule__EditorReference__Group__1"
    // InternalGT.g:3651:1: rule__EditorReference__Group__1 : rule__EditorReference__Group__1__Impl rule__EditorReference__Group__2 ;
    public final void rule__EditorReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3655:1: ( rule__EditorReference__Group__1__Impl rule__EditorReference__Group__2 )
            // InternalGT.g:3656:2: rule__EditorReference__Group__1__Impl rule__EditorReference__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__EditorReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__1"


    // $ANTLR start "rule__EditorReference__Group__1__Impl"
    // InternalGT.g:3663:1: rule__EditorReference__Group__1__Impl : ( '-' ) ;
    public final void rule__EditorReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3667:1: ( ( '-' ) )
            // InternalGT.g:3668:1: ( '-' )
            {
            // InternalGT.g:3668:1: ( '-' )
            // InternalGT.g:3669:2: '-'
            {
             before(grammarAccess.getEditorReferenceAccess().getHyphenMinusKeyword_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceAccess().getHyphenMinusKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__1__Impl"


    // $ANTLR start "rule__EditorReference__Group__2"
    // InternalGT.g:3678:1: rule__EditorReference__Group__2 : rule__EditorReference__Group__2__Impl rule__EditorReference__Group__3 ;
    public final void rule__EditorReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3682:1: ( rule__EditorReference__Group__2__Impl rule__EditorReference__Group__3 )
            // InternalGT.g:3683:2: rule__EditorReference__Group__2__Impl rule__EditorReference__Group__3
            {
            pushFollow(FOLLOW_33);
            rule__EditorReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__2"


    // $ANTLR start "rule__EditorReference__Group__2__Impl"
    // InternalGT.g:3690:1: rule__EditorReference__Group__2__Impl : ( ( rule__EditorReference__TypeAssignment_2 ) ) ;
    public final void rule__EditorReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3694:1: ( ( ( rule__EditorReference__TypeAssignment_2 ) ) )
            // InternalGT.g:3695:1: ( ( rule__EditorReference__TypeAssignment_2 ) )
            {
            // InternalGT.g:3695:1: ( ( rule__EditorReference__TypeAssignment_2 ) )
            // InternalGT.g:3696:2: ( rule__EditorReference__TypeAssignment_2 )
            {
             before(grammarAccess.getEditorReferenceAccess().getTypeAssignment_2()); 
            // InternalGT.g:3697:2: ( rule__EditorReference__TypeAssignment_2 )
            // InternalGT.g:3697:3: rule__EditorReference__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorReference__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__2__Impl"


    // $ANTLR start "rule__EditorReference__Group__3"
    // InternalGT.g:3705:1: rule__EditorReference__Group__3 : rule__EditorReference__Group__3__Impl rule__EditorReference__Group__4 ;
    public final void rule__EditorReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3709:1: ( rule__EditorReference__Group__3__Impl rule__EditorReference__Group__4 )
            // InternalGT.g:3710:2: rule__EditorReference__Group__3__Impl rule__EditorReference__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__EditorReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__3"


    // $ANTLR start "rule__EditorReference__Group__3__Impl"
    // InternalGT.g:3717:1: rule__EditorReference__Group__3__Impl : ( '->' ) ;
    public final void rule__EditorReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3721:1: ( ( '->' ) )
            // InternalGT.g:3722:1: ( '->' )
            {
            // InternalGT.g:3722:1: ( '->' )
            // InternalGT.g:3723:2: '->'
            {
             before(grammarAccess.getEditorReferenceAccess().getHyphenMinusGreaterThanSignKeyword_3()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceAccess().getHyphenMinusGreaterThanSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__3__Impl"


    // $ANTLR start "rule__EditorReference__Group__4"
    // InternalGT.g:3732:1: rule__EditorReference__Group__4 : rule__EditorReference__Group__4__Impl ;
    public final void rule__EditorReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3736:1: ( rule__EditorReference__Group__4__Impl )
            // InternalGT.g:3737:2: rule__EditorReference__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorReference__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__4"


    // $ANTLR start "rule__EditorReference__Group__4__Impl"
    // InternalGT.g:3743:1: rule__EditorReference__Group__4__Impl : ( ( rule__EditorReference__TargetAssignment_4 ) ) ;
    public final void rule__EditorReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3747:1: ( ( ( rule__EditorReference__TargetAssignment_4 ) ) )
            // InternalGT.g:3748:1: ( ( rule__EditorReference__TargetAssignment_4 ) )
            {
            // InternalGT.g:3748:1: ( ( rule__EditorReference__TargetAssignment_4 ) )
            // InternalGT.g:3749:2: ( rule__EditorReference__TargetAssignment_4 )
            {
             before(grammarAccess.getEditorReferenceAccess().getTargetAssignment_4()); 
            // InternalGT.g:3750:2: ( rule__EditorReference__TargetAssignment_4 )
            // InternalGT.g:3750:3: rule__EditorReference__TargetAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__EditorReference__TargetAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceAccess().getTargetAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__Group__4__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__0"
    // InternalGT.g:3759:1: rule__EditorReferenceIterator__Group__0 : rule__EditorReferenceIterator__Group__0__Impl rule__EditorReferenceIterator__Group__1 ;
    public final void rule__EditorReferenceIterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3763:1: ( rule__EditorReferenceIterator__Group__0__Impl rule__EditorReferenceIterator__Group__1 )
            // InternalGT.g:3764:2: rule__EditorReferenceIterator__Group__0__Impl rule__EditorReferenceIterator__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorReferenceIterator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__0"


    // $ANTLR start "rule__EditorReferenceIterator__Group__0__Impl"
    // InternalGT.g:3771:1: rule__EditorReferenceIterator__Group__0__Impl : ( 'forEach' ) ;
    public final void rule__EditorReferenceIterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3775:1: ( ( 'forEach' ) )
            // InternalGT.g:3776:1: ( 'forEach' )
            {
            // InternalGT.g:3776:1: ( 'forEach' )
            // InternalGT.g:3777:2: 'forEach'
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getForEachKeyword_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getForEachKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__0__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__1"
    // InternalGT.g:3786:1: rule__EditorReferenceIterator__Group__1 : rule__EditorReferenceIterator__Group__1__Impl rule__EditorReferenceIterator__Group__2 ;
    public final void rule__EditorReferenceIterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3790:1: ( rule__EditorReferenceIterator__Group__1__Impl rule__EditorReferenceIterator__Group__2 )
            // InternalGT.g:3791:2: rule__EditorReferenceIterator__Group__1__Impl rule__EditorReferenceIterator__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__EditorReferenceIterator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__1"


    // $ANTLR start "rule__EditorReferenceIterator__Group__1__Impl"
    // InternalGT.g:3798:1: rule__EditorReferenceIterator__Group__1__Impl : ( ( rule__EditorReferenceIterator__TypeAssignment_1 ) ) ;
    public final void rule__EditorReferenceIterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3802:1: ( ( ( rule__EditorReferenceIterator__TypeAssignment_1 ) ) )
            // InternalGT.g:3803:1: ( ( rule__EditorReferenceIterator__TypeAssignment_1 ) )
            {
            // InternalGT.g:3803:1: ( ( rule__EditorReferenceIterator__TypeAssignment_1 ) )
            // InternalGT.g:3804:2: ( rule__EditorReferenceIterator__TypeAssignment_1 )
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getTypeAssignment_1()); 
            // InternalGT.g:3805:2: ( rule__EditorReferenceIterator__TypeAssignment_1 )
            // InternalGT.g:3805:3: rule__EditorReferenceIterator__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__1__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__2"
    // InternalGT.g:3813:1: rule__EditorReferenceIterator__Group__2 : rule__EditorReferenceIterator__Group__2__Impl rule__EditorReferenceIterator__Group__3 ;
    public final void rule__EditorReferenceIterator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3817:1: ( rule__EditorReferenceIterator__Group__2__Impl rule__EditorReferenceIterator__Group__3 )
            // InternalGT.g:3818:2: rule__EditorReferenceIterator__Group__2__Impl rule__EditorReferenceIterator__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__EditorReferenceIterator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__2"


    // $ANTLR start "rule__EditorReferenceIterator__Group__2__Impl"
    // InternalGT.g:3825:1: rule__EditorReferenceIterator__Group__2__Impl : ( '->' ) ;
    public final void rule__EditorReferenceIterator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3829:1: ( ( '->' ) )
            // InternalGT.g:3830:1: ( '->' )
            {
            // InternalGT.g:3830:1: ( '->' )
            // InternalGT.g:3831:2: '->'
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getHyphenMinusGreaterThanSignKeyword_2()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getHyphenMinusGreaterThanSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__2__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__3"
    // InternalGT.g:3840:1: rule__EditorReferenceIterator__Group__3 : rule__EditorReferenceIterator__Group__3__Impl rule__EditorReferenceIterator__Group__4 ;
    public final void rule__EditorReferenceIterator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3844:1: ( rule__EditorReferenceIterator__Group__3__Impl rule__EditorReferenceIterator__Group__4 )
            // InternalGT.g:3845:2: rule__EditorReferenceIterator__Group__3__Impl rule__EditorReferenceIterator__Group__4
            {
            pushFollow(FOLLOW_34);
            rule__EditorReferenceIterator__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__3"


    // $ANTLR start "rule__EditorReferenceIterator__Group__3__Impl"
    // InternalGT.g:3852:1: rule__EditorReferenceIterator__Group__3__Impl : ( ( rule__EditorReferenceIterator__NameAssignment_3 ) ) ;
    public final void rule__EditorReferenceIterator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3856:1: ( ( ( rule__EditorReferenceIterator__NameAssignment_3 ) ) )
            // InternalGT.g:3857:1: ( ( rule__EditorReferenceIterator__NameAssignment_3 ) )
            {
            // InternalGT.g:3857:1: ( ( rule__EditorReferenceIterator__NameAssignment_3 ) )
            // InternalGT.g:3858:2: ( rule__EditorReferenceIterator__NameAssignment_3 )
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getNameAssignment_3()); 
            // InternalGT.g:3859:2: ( rule__EditorReferenceIterator__NameAssignment_3 )
            // InternalGT.g:3859:3: rule__EditorReferenceIterator__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__3__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__4"
    // InternalGT.g:3867:1: rule__EditorReferenceIterator__Group__4 : rule__EditorReferenceIterator__Group__4__Impl rule__EditorReferenceIterator__Group__5 ;
    public final void rule__EditorReferenceIterator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3871:1: ( rule__EditorReferenceIterator__Group__4__Impl rule__EditorReferenceIterator__Group__5 )
            // InternalGT.g:3872:2: rule__EditorReferenceIterator__Group__4__Impl rule__EditorReferenceIterator__Group__5
            {
            pushFollow(FOLLOW_34);
            rule__EditorReferenceIterator__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__4"


    // $ANTLR start "rule__EditorReferenceIterator__Group__4__Impl"
    // InternalGT.g:3879:1: rule__EditorReferenceIterator__Group__4__Impl : ( ( rule__EditorReferenceIterator__Group_4__0 )? ) ;
    public final void rule__EditorReferenceIterator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3883:1: ( ( ( rule__EditorReferenceIterator__Group_4__0 )? ) )
            // InternalGT.g:3884:1: ( ( rule__EditorReferenceIterator__Group_4__0 )? )
            {
            // InternalGT.g:3884:1: ( ( rule__EditorReferenceIterator__Group_4__0 )? )
            // InternalGT.g:3885:2: ( rule__EditorReferenceIterator__Group_4__0 )?
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getGroup_4()); 
            // InternalGT.g:3886:2: ( rule__EditorReferenceIterator__Group_4__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==23) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalGT.g:3886:3: rule__EditorReferenceIterator__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EditorReferenceIterator__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__4__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__5"
    // InternalGT.g:3894:1: rule__EditorReferenceIterator__Group__5 : rule__EditorReferenceIterator__Group__5__Impl rule__EditorReferenceIterator__Group__6 ;
    public final void rule__EditorReferenceIterator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3898:1: ( rule__EditorReferenceIterator__Group__5__Impl rule__EditorReferenceIterator__Group__6 )
            // InternalGT.g:3899:2: rule__EditorReferenceIterator__Group__5__Impl rule__EditorReferenceIterator__Group__6
            {
            pushFollow(FOLLOW_35);
            rule__EditorReferenceIterator__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__5"


    // $ANTLR start "rule__EditorReferenceIterator__Group__5__Impl"
    // InternalGT.g:3906:1: rule__EditorReferenceIterator__Group__5__Impl : ( '{' ) ;
    public final void rule__EditorReferenceIterator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3910:1: ( ( '{' ) )
            // InternalGT.g:3911:1: ( '{' )
            {
            // InternalGT.g:3911:1: ( '{' )
            // InternalGT.g:3912:2: '{'
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__5__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__6"
    // InternalGT.g:3921:1: rule__EditorReferenceIterator__Group__6 : rule__EditorReferenceIterator__Group__6__Impl rule__EditorReferenceIterator__Group__7 ;
    public final void rule__EditorReferenceIterator__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3925:1: ( rule__EditorReferenceIterator__Group__6__Impl rule__EditorReferenceIterator__Group__7 )
            // InternalGT.g:3926:2: rule__EditorReferenceIterator__Group__6__Impl rule__EditorReferenceIterator__Group__7
            {
            pushFollow(FOLLOW_36);
            rule__EditorReferenceIterator__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__6"


    // $ANTLR start "rule__EditorReferenceIterator__Group__6__Impl"
    // InternalGT.g:3933:1: rule__EditorReferenceIterator__Group__6__Impl : ( ( ( rule__EditorReferenceIterator__Alternatives_6 ) ) ( ( rule__EditorReferenceIterator__Alternatives_6 )* ) ) ;
    public final void rule__EditorReferenceIterator__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3937:1: ( ( ( ( rule__EditorReferenceIterator__Alternatives_6 ) ) ( ( rule__EditorReferenceIterator__Alternatives_6 )* ) ) )
            // InternalGT.g:3938:1: ( ( ( rule__EditorReferenceIterator__Alternatives_6 ) ) ( ( rule__EditorReferenceIterator__Alternatives_6 )* ) )
            {
            // InternalGT.g:3938:1: ( ( ( rule__EditorReferenceIterator__Alternatives_6 ) ) ( ( rule__EditorReferenceIterator__Alternatives_6 )* ) )
            // InternalGT.g:3939:2: ( ( rule__EditorReferenceIterator__Alternatives_6 ) ) ( ( rule__EditorReferenceIterator__Alternatives_6 )* )
            {
            // InternalGT.g:3939:2: ( ( rule__EditorReferenceIterator__Alternatives_6 ) )
            // InternalGT.g:3940:3: ( rule__EditorReferenceIterator__Alternatives_6 )
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getAlternatives_6()); 
            // InternalGT.g:3941:3: ( rule__EditorReferenceIterator__Alternatives_6 )
            // InternalGT.g:3941:4: rule__EditorReferenceIterator__Alternatives_6
            {
            pushFollow(FOLLOW_37);
            rule__EditorReferenceIterator__Alternatives_6();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getAlternatives_6()); 

            }

            // InternalGT.g:3944:2: ( ( rule__EditorReferenceIterator__Alternatives_6 )* )
            // InternalGT.g:3945:3: ( rule__EditorReferenceIterator__Alternatives_6 )*
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getAlternatives_6()); 
            // InternalGT.g:3946:3: ( rule__EditorReferenceIterator__Alternatives_6 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID||(LA46_0>=15 && LA46_0<=17)||LA46_0==62) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalGT.g:3946:4: rule__EditorReferenceIterator__Alternatives_6
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__EditorReferenceIterator__Alternatives_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getEditorReferenceIteratorAccess().getAlternatives_6()); 

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
    // $ANTLR end "rule__EditorReferenceIterator__Group__6__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group__7"
    // InternalGT.g:3955:1: rule__EditorReferenceIterator__Group__7 : rule__EditorReferenceIterator__Group__7__Impl ;
    public final void rule__EditorReferenceIterator__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3959:1: ( rule__EditorReferenceIterator__Group__7__Impl )
            // InternalGT.g:3960:2: rule__EditorReferenceIterator__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__7"


    // $ANTLR start "rule__EditorReferenceIterator__Group__7__Impl"
    // InternalGT.g:3966:1: rule__EditorReferenceIterator__Group__7__Impl : ( '}' ) ;
    public final void rule__EditorReferenceIterator__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3970:1: ( ( '}' ) )
            // InternalGT.g:3971:1: ( '}' )
            {
            // InternalGT.g:3971:1: ( '}' )
            // InternalGT.g:3972:2: '}'
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getRightCurlyBracketKeyword_7()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group__7__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group_4__0"
    // InternalGT.g:3982:1: rule__EditorReferenceIterator__Group_4__0 : rule__EditorReferenceIterator__Group_4__0__Impl rule__EditorReferenceIterator__Group_4__1 ;
    public final void rule__EditorReferenceIterator__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3986:1: ( rule__EditorReferenceIterator__Group_4__0__Impl rule__EditorReferenceIterator__Group_4__1 )
            // InternalGT.g:3987:2: rule__EditorReferenceIterator__Group_4__0__Impl rule__EditorReferenceIterator__Group_4__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorReferenceIterator__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group_4__0"


    // $ANTLR start "rule__EditorReferenceIterator__Group_4__0__Impl"
    // InternalGT.g:3994:1: rule__EditorReferenceIterator__Group_4__0__Impl : ( '<' ) ;
    public final void rule__EditorReferenceIterator__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:3998:1: ( ( '<' ) )
            // InternalGT.g:3999:1: ( '<' )
            {
            // InternalGT.g:3999:1: ( '<' )
            // InternalGT.g:4000:2: '<'
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getLessThanSignKeyword_4_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getLessThanSignKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group_4__0__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group_4__1"
    // InternalGT.g:4009:1: rule__EditorReferenceIterator__Group_4__1 : rule__EditorReferenceIterator__Group_4__1__Impl rule__EditorReferenceIterator__Group_4__2 ;
    public final void rule__EditorReferenceIterator__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4013:1: ( rule__EditorReferenceIterator__Group_4__1__Impl rule__EditorReferenceIterator__Group_4__2 )
            // InternalGT.g:4014:2: rule__EditorReferenceIterator__Group_4__1__Impl rule__EditorReferenceIterator__Group_4__2
            {
            pushFollow(FOLLOW_38);
            rule__EditorReferenceIterator__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group_4__1"


    // $ANTLR start "rule__EditorReferenceIterator__Group_4__1__Impl"
    // InternalGT.g:4021:1: rule__EditorReferenceIterator__Group_4__1__Impl : ( ( rule__EditorReferenceIterator__SubTypeAssignment_4_1 ) ) ;
    public final void rule__EditorReferenceIterator__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4025:1: ( ( ( rule__EditorReferenceIterator__SubTypeAssignment_4_1 ) ) )
            // InternalGT.g:4026:1: ( ( rule__EditorReferenceIterator__SubTypeAssignment_4_1 ) )
            {
            // InternalGT.g:4026:1: ( ( rule__EditorReferenceIterator__SubTypeAssignment_4_1 ) )
            // InternalGT.g:4027:2: ( rule__EditorReferenceIterator__SubTypeAssignment_4_1 )
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getSubTypeAssignment_4_1()); 
            // InternalGT.g:4028:2: ( rule__EditorReferenceIterator__SubTypeAssignment_4_1 )
            // InternalGT.g:4028:3: rule__EditorReferenceIterator__SubTypeAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__SubTypeAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getSubTypeAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group_4__1__Impl"


    // $ANTLR start "rule__EditorReferenceIterator__Group_4__2"
    // InternalGT.g:4036:1: rule__EditorReferenceIterator__Group_4__2 : rule__EditorReferenceIterator__Group_4__2__Impl ;
    public final void rule__EditorReferenceIterator__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4040:1: ( rule__EditorReferenceIterator__Group_4__2__Impl )
            // InternalGT.g:4041:2: rule__EditorReferenceIterator__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorReferenceIterator__Group_4__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group_4__2"


    // $ANTLR start "rule__EditorReferenceIterator__Group_4__2__Impl"
    // InternalGT.g:4047:1: rule__EditorReferenceIterator__Group_4__2__Impl : ( '>' ) ;
    public final void rule__EditorReferenceIterator__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4051:1: ( ( '>' ) )
            // InternalGT.g:4052:1: ( '>' )
            {
            // InternalGT.g:4052:1: ( '>' )
            // InternalGT.g:4053:2: '>'
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getGreaterThanSignKeyword_4_2()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getGreaterThanSignKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__Group_4__2__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__0"
    // InternalGT.g:4063:1: rule__EditorIteratorAttributeExpression__Group__0 : rule__EditorIteratorAttributeExpression__Group__0__Impl rule__EditorIteratorAttributeExpression__Group__1 ;
    public final void rule__EditorIteratorAttributeExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4067:1: ( rule__EditorIteratorAttributeExpression__Group__0__Impl rule__EditorIteratorAttributeExpression__Group__1 )
            // InternalGT.g:4068:2: rule__EditorIteratorAttributeExpression__Group__0__Impl rule__EditorIteratorAttributeExpression__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorIteratorAttributeExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__0"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__0__Impl"
    // InternalGT.g:4075:1: rule__EditorIteratorAttributeExpression__Group__0__Impl : ( 'iterator::' ) ;
    public final void rule__EditorIteratorAttributeExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4079:1: ( ( 'iterator::' ) )
            // InternalGT.g:4080:1: ( 'iterator::' )
            {
            // InternalGT.g:4080:1: ( 'iterator::' )
            // InternalGT.g:4081:2: 'iterator::'
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorKeyword_0()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__0__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__1"
    // InternalGT.g:4090:1: rule__EditorIteratorAttributeExpression__Group__1 : rule__EditorIteratorAttributeExpression__Group__1__Impl rule__EditorIteratorAttributeExpression__Group__2 ;
    public final void rule__EditorIteratorAttributeExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4094:1: ( rule__EditorIteratorAttributeExpression__Group__1__Impl rule__EditorIteratorAttributeExpression__Group__2 )
            // InternalGT.g:4095:2: rule__EditorIteratorAttributeExpression__Group__1__Impl rule__EditorIteratorAttributeExpression__Group__2
            {
            pushFollow(FOLLOW_26);
            rule__EditorIteratorAttributeExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__1"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__1__Impl"
    // InternalGT.g:4102:1: rule__EditorIteratorAttributeExpression__Group__1__Impl : ( ( rule__EditorIteratorAttributeExpression__IteratorAssignment_1 ) ) ;
    public final void rule__EditorIteratorAttributeExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4106:1: ( ( ( rule__EditorIteratorAttributeExpression__IteratorAssignment_1 ) ) )
            // InternalGT.g:4107:1: ( ( rule__EditorIteratorAttributeExpression__IteratorAssignment_1 ) )
            {
            // InternalGT.g:4107:1: ( ( rule__EditorIteratorAttributeExpression__IteratorAssignment_1 ) )
            // InternalGT.g:4108:2: ( rule__EditorIteratorAttributeExpression__IteratorAssignment_1 )
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorAssignment_1()); 
            // InternalGT.g:4109:2: ( rule__EditorIteratorAttributeExpression__IteratorAssignment_1 )
            // InternalGT.g:4109:3: rule__EditorIteratorAttributeExpression__IteratorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeExpression__IteratorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__1__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__2"
    // InternalGT.g:4117:1: rule__EditorIteratorAttributeExpression__Group__2 : rule__EditorIteratorAttributeExpression__Group__2__Impl rule__EditorIteratorAttributeExpression__Group__3 ;
    public final void rule__EditorIteratorAttributeExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4121:1: ( rule__EditorIteratorAttributeExpression__Group__2__Impl rule__EditorIteratorAttributeExpression__Group__3 )
            // InternalGT.g:4122:2: rule__EditorIteratorAttributeExpression__Group__2__Impl rule__EditorIteratorAttributeExpression__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__EditorIteratorAttributeExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__2"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__2__Impl"
    // InternalGT.g:4129:1: rule__EditorIteratorAttributeExpression__Group__2__Impl : ( '.' ) ;
    public final void rule__EditorIteratorAttributeExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4133:1: ( ( '.' ) )
            // InternalGT.g:4134:1: ( '.' )
            {
            // InternalGT.g:4134:1: ( '.' )
            // InternalGT.g:4135:2: '.'
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getFullStopKeyword_2()); 
            match(input,55,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__2__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__3"
    // InternalGT.g:4144:1: rule__EditorIteratorAttributeExpression__Group__3 : rule__EditorIteratorAttributeExpression__Group__3__Impl ;
    public final void rule__EditorIteratorAttributeExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4148:1: ( rule__EditorIteratorAttributeExpression__Group__3__Impl )
            // InternalGT.g:4149:2: rule__EditorIteratorAttributeExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeExpression__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__3"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__Group__3__Impl"
    // InternalGT.g:4155:1: rule__EditorIteratorAttributeExpression__Group__3__Impl : ( ( rule__EditorIteratorAttributeExpression__AttributeAssignment_3 ) ) ;
    public final void rule__EditorIteratorAttributeExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4159:1: ( ( ( rule__EditorIteratorAttributeExpression__AttributeAssignment_3 ) ) )
            // InternalGT.g:4160:1: ( ( rule__EditorIteratorAttributeExpression__AttributeAssignment_3 ) )
            {
            // InternalGT.g:4160:1: ( ( rule__EditorIteratorAttributeExpression__AttributeAssignment_3 ) )
            // InternalGT.g:4161:2: ( rule__EditorIteratorAttributeExpression__AttributeAssignment_3 )
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeAssignment_3()); 
            // InternalGT.g:4162:2: ( rule__EditorIteratorAttributeExpression__AttributeAssignment_3 )
            // InternalGT.g:4162:3: rule__EditorIteratorAttributeExpression__AttributeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeExpression__AttributeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__Group__3__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__Group__0"
    // InternalGT.g:4171:1: rule__EditorIteratorAttributeAssignmentItr__Group__0 : rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl rule__EditorIteratorAttributeAssignmentItr__Group__1 ;
    public final void rule__EditorIteratorAttributeAssignmentItr__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4175:1: ( rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl rule__EditorIteratorAttributeAssignmentItr__Group__1 )
            // InternalGT.g:4176:2: rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl rule__EditorIteratorAttributeAssignmentItr__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentItr__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__Group__0"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl"
    // InternalGT.g:4183:1: rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl : ( ( rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0 ) ) ;
    public final void rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4187:1: ( ( ( rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0 ) ) )
            // InternalGT.g:4188:1: ( ( rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0 ) )
            {
            // InternalGT.g:4188:1: ( ( rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0 ) )
            // InternalGT.g:4189:2: ( rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0 )
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getIteratorAttributeAssignment_0()); 
            // InternalGT.g:4190:2: ( rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0 )
            // InternalGT.g:4190:3: rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getIteratorAttributeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__Group__0__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__Group__1"
    // InternalGT.g:4198:1: rule__EditorIteratorAttributeAssignmentItr__Group__1 : rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl rule__EditorIteratorAttributeAssignmentItr__Group__2 ;
    public final void rule__EditorIteratorAttributeAssignmentItr__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4202:1: ( rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl rule__EditorIteratorAttributeAssignmentItr__Group__2 )
            // InternalGT.g:4203:2: rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl rule__EditorIteratorAttributeAssignmentItr__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentItr__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__Group__1"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl"
    // InternalGT.g:4210:1: rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl : ( ':=' ) ;
    public final void rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4214:1: ( ( ':=' ) )
            // InternalGT.g:4215:1: ( ':=' )
            {
            // InternalGT.g:4215:1: ( ':=' )
            // InternalGT.g:4216:2: ':='
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getColonEqualsSignKeyword_1()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__Group__1__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__Group__2"
    // InternalGT.g:4225:1: rule__EditorIteratorAttributeAssignmentItr__Group__2 : rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl ;
    public final void rule__EditorIteratorAttributeAssignmentItr__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4229:1: ( rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl )
            // InternalGT.g:4230:2: rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__Group__2"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl"
    // InternalGT.g:4236:1: rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl : ( ( rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2 ) ) ;
    public final void rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4240:1: ( ( ( rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2 ) ) )
            // InternalGT.g:4241:1: ( ( rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2 ) )
            {
            // InternalGT.g:4241:1: ( ( rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2 ) )
            // InternalGT.g:4242:2: ( rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2 )
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getValueAssignment_2()); 
            // InternalGT.g:4243:2: ( rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2 )
            // InternalGT.g:4243:3: rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__Group__2__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__Group__0"
    // InternalGT.g:4252:1: rule__EditorIteratorAttributeAssignmentNode__Group__0 : rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl rule__EditorIteratorAttributeAssignmentNode__Group__1 ;
    public final void rule__EditorIteratorAttributeAssignmentNode__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4256:1: ( rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl rule__EditorIteratorAttributeAssignmentNode__Group__1 )
            // InternalGT.g:4257:2: rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl rule__EditorIteratorAttributeAssignmentNode__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentNode__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__Group__0"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl"
    // InternalGT.g:4264:1: rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl : ( ( rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0 ) ) ;
    public final void rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4268:1: ( ( ( rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0 ) ) )
            // InternalGT.g:4269:1: ( ( rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0 ) )
            {
            // InternalGT.g:4269:1: ( ( rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0 ) )
            // InternalGT.g:4270:2: ( rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0 )
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getNodeAttributeAssignment_0()); 
            // InternalGT.g:4271:2: ( rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0 )
            // InternalGT.g:4271:3: rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getNodeAttributeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__Group__0__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__Group__1"
    // InternalGT.g:4279:1: rule__EditorIteratorAttributeAssignmentNode__Group__1 : rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl rule__EditorIteratorAttributeAssignmentNode__Group__2 ;
    public final void rule__EditorIteratorAttributeAssignmentNode__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4283:1: ( rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl rule__EditorIteratorAttributeAssignmentNode__Group__2 )
            // InternalGT.g:4284:2: rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl rule__EditorIteratorAttributeAssignmentNode__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentNode__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__Group__1"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl"
    // InternalGT.g:4291:1: rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl : ( ':=' ) ;
    public final void rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4295:1: ( ( ':=' ) )
            // InternalGT.g:4296:1: ( ':=' )
            {
            // InternalGT.g:4296:1: ( ':=' )
            // InternalGT.g:4297:2: ':='
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getColonEqualsSignKeyword_1()); 
            match(input,56,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getColonEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__Group__1__Impl"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__Group__2"
    // InternalGT.g:4306:1: rule__EditorIteratorAttributeAssignmentNode__Group__2 : rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl ;
    public final void rule__EditorIteratorAttributeAssignmentNode__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4310:1: ( rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl )
            // InternalGT.g:4311:2: rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__Group__2"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl"
    // InternalGT.g:4317:1: rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl : ( ( rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2 ) ) ;
    public final void rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4321:1: ( ( ( rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2 ) ) )
            // InternalGT.g:4322:1: ( ( rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2 ) )
            {
            // InternalGT.g:4322:1: ( ( rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2 ) )
            // InternalGT.g:4323:2: ( rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2 )
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getValueAssignment_2()); 
            // InternalGT.g:4324:2: ( rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2 )
            // InternalGT.g:4324:3: rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__Group__2__Impl"


    // $ANTLR start "rule__EditorIteratorReference__Group__0"
    // InternalGT.g:4333:1: rule__EditorIteratorReference__Group__0 : rule__EditorIteratorReference__Group__0__Impl rule__EditorIteratorReference__Group__1 ;
    public final void rule__EditorIteratorReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4337:1: ( rule__EditorIteratorReference__Group__0__Impl rule__EditorIteratorReference__Group__1 )
            // InternalGT.g:4338:2: rule__EditorIteratorReference__Group__0__Impl rule__EditorIteratorReference__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorIteratorReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__0"


    // $ANTLR start "rule__EditorIteratorReference__Group__0__Impl"
    // InternalGT.g:4345:1: rule__EditorIteratorReference__Group__0__Impl : ( ( rule__EditorIteratorReference__OperatorAssignment_0 ) ) ;
    public final void rule__EditorIteratorReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4349:1: ( ( ( rule__EditorIteratorReference__OperatorAssignment_0 ) ) )
            // InternalGT.g:4350:1: ( ( rule__EditorIteratorReference__OperatorAssignment_0 ) )
            {
            // InternalGT.g:4350:1: ( ( rule__EditorIteratorReference__OperatorAssignment_0 ) )
            // InternalGT.g:4351:2: ( rule__EditorIteratorReference__OperatorAssignment_0 )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getOperatorAssignment_0()); 
            // InternalGT.g:4352:2: ( rule__EditorIteratorReference__OperatorAssignment_0 )
            // InternalGT.g:4352:3: rule__EditorIteratorReference__OperatorAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__OperatorAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getOperatorAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__0__Impl"


    // $ANTLR start "rule__EditorIteratorReference__Group__1"
    // InternalGT.g:4360:1: rule__EditorIteratorReference__Group__1 : rule__EditorIteratorReference__Group__1__Impl rule__EditorIteratorReference__Group__2 ;
    public final void rule__EditorIteratorReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4364:1: ( rule__EditorIteratorReference__Group__1__Impl rule__EditorIteratorReference__Group__2 )
            // InternalGT.g:4365:2: rule__EditorIteratorReference__Group__1__Impl rule__EditorIteratorReference__Group__2
            {
            pushFollow(FOLLOW_39);
            rule__EditorIteratorReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__1"


    // $ANTLR start "rule__EditorIteratorReference__Group__1__Impl"
    // InternalGT.g:4372:1: rule__EditorIteratorReference__Group__1__Impl : ( ( rule__EditorIteratorReference__SourceAssignment_1 ) ) ;
    public final void rule__EditorIteratorReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4376:1: ( ( ( rule__EditorIteratorReference__SourceAssignment_1 ) ) )
            // InternalGT.g:4377:1: ( ( rule__EditorIteratorReference__SourceAssignment_1 ) )
            {
            // InternalGT.g:4377:1: ( ( rule__EditorIteratorReference__SourceAssignment_1 ) )
            // InternalGT.g:4378:2: ( rule__EditorIteratorReference__SourceAssignment_1 )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getSourceAssignment_1()); 
            // InternalGT.g:4379:2: ( rule__EditorIteratorReference__SourceAssignment_1 )
            // InternalGT.g:4379:3: rule__EditorIteratorReference__SourceAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__SourceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getSourceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__1__Impl"


    // $ANTLR start "rule__EditorIteratorReference__Group__2"
    // InternalGT.g:4387:1: rule__EditorIteratorReference__Group__2 : rule__EditorIteratorReference__Group__2__Impl rule__EditorIteratorReference__Group__3 ;
    public final void rule__EditorIteratorReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4391:1: ( rule__EditorIteratorReference__Group__2__Impl rule__EditorIteratorReference__Group__3 )
            // InternalGT.g:4392:2: rule__EditorIteratorReference__Group__2__Impl rule__EditorIteratorReference__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__EditorIteratorReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__2"


    // $ANTLR start "rule__EditorIteratorReference__Group__2__Impl"
    // InternalGT.g:4399:1: rule__EditorIteratorReference__Group__2__Impl : ( '-' ) ;
    public final void rule__EditorIteratorReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4403:1: ( ( '-' ) )
            // InternalGT.g:4404:1: ( '-' )
            {
            // InternalGT.g:4404:1: ( '-' )
            // InternalGT.g:4405:2: '-'
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getHyphenMinusKeyword_2()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorReferenceAccess().getHyphenMinusKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__2__Impl"


    // $ANTLR start "rule__EditorIteratorReference__Group__3"
    // InternalGT.g:4414:1: rule__EditorIteratorReference__Group__3 : rule__EditorIteratorReference__Group__3__Impl rule__EditorIteratorReference__Group__4 ;
    public final void rule__EditorIteratorReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4418:1: ( rule__EditorIteratorReference__Group__3__Impl rule__EditorIteratorReference__Group__4 )
            // InternalGT.g:4419:2: rule__EditorIteratorReference__Group__3__Impl rule__EditorIteratorReference__Group__4
            {
            pushFollow(FOLLOW_33);
            rule__EditorIteratorReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__3"


    // $ANTLR start "rule__EditorIteratorReference__Group__3__Impl"
    // InternalGT.g:4426:1: rule__EditorIteratorReference__Group__3__Impl : ( ( rule__EditorIteratorReference__TypeAssignment_3 ) ) ;
    public final void rule__EditorIteratorReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4430:1: ( ( ( rule__EditorIteratorReference__TypeAssignment_3 ) ) )
            // InternalGT.g:4431:1: ( ( rule__EditorIteratorReference__TypeAssignment_3 ) )
            {
            // InternalGT.g:4431:1: ( ( rule__EditorIteratorReference__TypeAssignment_3 ) )
            // InternalGT.g:4432:2: ( rule__EditorIteratorReference__TypeAssignment_3 )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getTypeAssignment_3()); 
            // InternalGT.g:4433:2: ( rule__EditorIteratorReference__TypeAssignment_3 )
            // InternalGT.g:4433:3: rule__EditorIteratorReference__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__3__Impl"


    // $ANTLR start "rule__EditorIteratorReference__Group__4"
    // InternalGT.g:4441:1: rule__EditorIteratorReference__Group__4 : rule__EditorIteratorReference__Group__4__Impl rule__EditorIteratorReference__Group__5 ;
    public final void rule__EditorIteratorReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4445:1: ( rule__EditorIteratorReference__Group__4__Impl rule__EditorIteratorReference__Group__5 )
            // InternalGT.g:4446:2: rule__EditorIteratorReference__Group__4__Impl rule__EditorIteratorReference__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__EditorIteratorReference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__4"


    // $ANTLR start "rule__EditorIteratorReference__Group__4__Impl"
    // InternalGT.g:4453:1: rule__EditorIteratorReference__Group__4__Impl : ( '->' ) ;
    public final void rule__EditorIteratorReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4457:1: ( ( '->' ) )
            // InternalGT.g:4458:1: ( '->' )
            {
            // InternalGT.g:4458:1: ( '->' )
            // InternalGT.g:4459:2: '->'
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorReferenceAccess().getHyphenMinusGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__4__Impl"


    // $ANTLR start "rule__EditorIteratorReference__Group__5"
    // InternalGT.g:4468:1: rule__EditorIteratorReference__Group__5 : rule__EditorIteratorReference__Group__5__Impl ;
    public final void rule__EditorIteratorReference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4472:1: ( rule__EditorIteratorReference__Group__5__Impl )
            // InternalGT.g:4473:2: rule__EditorIteratorReference__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__5"


    // $ANTLR start "rule__EditorIteratorReference__Group__5__Impl"
    // InternalGT.g:4479:1: rule__EditorIteratorReference__Group__5__Impl : ( ( rule__EditorIteratorReference__TargetAssignment_5 ) ) ;
    public final void rule__EditorIteratorReference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4483:1: ( ( ( rule__EditorIteratorReference__TargetAssignment_5 ) ) )
            // InternalGT.g:4484:1: ( ( rule__EditorIteratorReference__TargetAssignment_5 ) )
            {
            // InternalGT.g:4484:1: ( ( rule__EditorIteratorReference__TargetAssignment_5 ) )
            // InternalGT.g:4485:2: ( rule__EditorIteratorReference__TargetAssignment_5 )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getTargetAssignment_5()); 
            // InternalGT.g:4486:2: ( rule__EditorIteratorReference__TargetAssignment_5 )
            // InternalGT.g:4486:3: rule__EditorIteratorReference__TargetAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__EditorIteratorReference__TargetAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getTargetAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__Group__5__Impl"


    // $ANTLR start "rule__EditorCondition__Group__0"
    // InternalGT.g:4495:1: rule__EditorCondition__Group__0 : rule__EditorCondition__Group__0__Impl rule__EditorCondition__Group__1 ;
    public final void rule__EditorCondition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4499:1: ( rule__EditorCondition__Group__0__Impl rule__EditorCondition__Group__1 )
            // InternalGT.g:4500:2: rule__EditorCondition__Group__0__Impl rule__EditorCondition__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorCondition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__0"


    // $ANTLR start "rule__EditorCondition__Group__0__Impl"
    // InternalGT.g:4507:1: rule__EditorCondition__Group__0__Impl : ( 'condition' ) ;
    public final void rule__EditorCondition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4511:1: ( ( 'condition' ) )
            // InternalGT.g:4512:1: ( 'condition' )
            {
            // InternalGT.g:4512:1: ( 'condition' )
            // InternalGT.g:4513:2: 'condition'
            {
             before(grammarAccess.getEditorConditionAccess().getConditionKeyword_0()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getEditorConditionAccess().getConditionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__0__Impl"


    // $ANTLR start "rule__EditorCondition__Group__1"
    // InternalGT.g:4522:1: rule__EditorCondition__Group__1 : rule__EditorCondition__Group__1__Impl rule__EditorCondition__Group__2 ;
    public final void rule__EditorCondition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4526:1: ( rule__EditorCondition__Group__1__Impl rule__EditorCondition__Group__2 )
            // InternalGT.g:4527:2: rule__EditorCondition__Group__1__Impl rule__EditorCondition__Group__2
            {
            pushFollow(FOLLOW_40);
            rule__EditorCondition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__1"


    // $ANTLR start "rule__EditorCondition__Group__1__Impl"
    // InternalGT.g:4534:1: rule__EditorCondition__Group__1__Impl : ( ( rule__EditorCondition__NameAssignment_1 ) ) ;
    public final void rule__EditorCondition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4538:1: ( ( ( rule__EditorCondition__NameAssignment_1 ) ) )
            // InternalGT.g:4539:1: ( ( rule__EditorCondition__NameAssignment_1 ) )
            {
            // InternalGT.g:4539:1: ( ( rule__EditorCondition__NameAssignment_1 ) )
            // InternalGT.g:4540:2: ( rule__EditorCondition__NameAssignment_1 )
            {
             before(grammarAccess.getEditorConditionAccess().getNameAssignment_1()); 
            // InternalGT.g:4541:2: ( rule__EditorCondition__NameAssignment_1 )
            // InternalGT.g:4541:3: rule__EditorCondition__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorCondition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorConditionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__1__Impl"


    // $ANTLR start "rule__EditorCondition__Group__2"
    // InternalGT.g:4549:1: rule__EditorCondition__Group__2 : rule__EditorCondition__Group__2__Impl rule__EditorCondition__Group__3 ;
    public final void rule__EditorCondition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4553:1: ( rule__EditorCondition__Group__2__Impl rule__EditorCondition__Group__3 )
            // InternalGT.g:4554:2: rule__EditorCondition__Group__2__Impl rule__EditorCondition__Group__3
            {
            pushFollow(FOLLOW_41);
            rule__EditorCondition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__2"


    // $ANTLR start "rule__EditorCondition__Group__2__Impl"
    // InternalGT.g:4561:1: rule__EditorCondition__Group__2__Impl : ( '=' ) ;
    public final void rule__EditorCondition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4565:1: ( ( '=' ) )
            // InternalGT.g:4566:1: ( '=' )
            {
            // InternalGT.g:4566:1: ( '=' )
            // InternalGT.g:4567:2: '='
            {
             before(grammarAccess.getEditorConditionAccess().getEqualsSignKeyword_2()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getEditorConditionAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__2__Impl"


    // $ANTLR start "rule__EditorCondition__Group__3"
    // InternalGT.g:4576:1: rule__EditorCondition__Group__3 : rule__EditorCondition__Group__3__Impl rule__EditorCondition__Group__4 ;
    public final void rule__EditorCondition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4580:1: ( rule__EditorCondition__Group__3__Impl rule__EditorCondition__Group__4 )
            // InternalGT.g:4581:2: rule__EditorCondition__Group__3__Impl rule__EditorCondition__Group__4
            {
            pushFollow(FOLLOW_42);
            rule__EditorCondition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__3"


    // $ANTLR start "rule__EditorCondition__Group__3__Impl"
    // InternalGT.g:4588:1: rule__EditorCondition__Group__3__Impl : ( ( rule__EditorCondition__ConditionsAssignment_3 ) ) ;
    public final void rule__EditorCondition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4592:1: ( ( ( rule__EditorCondition__ConditionsAssignment_3 ) ) )
            // InternalGT.g:4593:1: ( ( rule__EditorCondition__ConditionsAssignment_3 ) )
            {
            // InternalGT.g:4593:1: ( ( rule__EditorCondition__ConditionsAssignment_3 ) )
            // InternalGT.g:4594:2: ( rule__EditorCondition__ConditionsAssignment_3 )
            {
             before(grammarAccess.getEditorConditionAccess().getConditionsAssignment_3()); 
            // InternalGT.g:4595:2: ( rule__EditorCondition__ConditionsAssignment_3 )
            // InternalGT.g:4595:3: rule__EditorCondition__ConditionsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__EditorCondition__ConditionsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEditorConditionAccess().getConditionsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__3__Impl"


    // $ANTLR start "rule__EditorCondition__Group__4"
    // InternalGT.g:4603:1: rule__EditorCondition__Group__4 : rule__EditorCondition__Group__4__Impl ;
    public final void rule__EditorCondition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4607:1: ( rule__EditorCondition__Group__4__Impl )
            // InternalGT.g:4608:2: rule__EditorCondition__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__4"


    // $ANTLR start "rule__EditorCondition__Group__4__Impl"
    // InternalGT.g:4614:1: rule__EditorCondition__Group__4__Impl : ( ( rule__EditorCondition__Group_4__0 )* ) ;
    public final void rule__EditorCondition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4618:1: ( ( ( rule__EditorCondition__Group_4__0 )* ) )
            // InternalGT.g:4619:1: ( ( rule__EditorCondition__Group_4__0 )* )
            {
            // InternalGT.g:4619:1: ( ( rule__EditorCondition__Group_4__0 )* )
            // InternalGT.g:4620:2: ( rule__EditorCondition__Group_4__0 )*
            {
             before(grammarAccess.getEditorConditionAccess().getGroup_4()); 
            // InternalGT.g:4621:2: ( rule__EditorCondition__Group_4__0 )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==65) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalGT.g:4621:3: rule__EditorCondition__Group_4__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__EditorCondition__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

             after(grammarAccess.getEditorConditionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group__4__Impl"


    // $ANTLR start "rule__EditorCondition__Group_4__0"
    // InternalGT.g:4630:1: rule__EditorCondition__Group_4__0 : rule__EditorCondition__Group_4__0__Impl rule__EditorCondition__Group_4__1 ;
    public final void rule__EditorCondition__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4634:1: ( rule__EditorCondition__Group_4__0__Impl rule__EditorCondition__Group_4__1 )
            // InternalGT.g:4635:2: rule__EditorCondition__Group_4__0__Impl rule__EditorCondition__Group_4__1
            {
            pushFollow(FOLLOW_41);
            rule__EditorCondition__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group_4__0"


    // $ANTLR start "rule__EditorCondition__Group_4__0__Impl"
    // InternalGT.g:4642:1: rule__EditorCondition__Group_4__0__Impl : ( '&&' ) ;
    public final void rule__EditorCondition__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4646:1: ( ( '&&' ) )
            // InternalGT.g:4647:1: ( '&&' )
            {
            // InternalGT.g:4647:1: ( '&&' )
            // InternalGT.g:4648:2: '&&'
            {
             before(grammarAccess.getEditorConditionAccess().getAmpersandAmpersandKeyword_4_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getEditorConditionAccess().getAmpersandAmpersandKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group_4__0__Impl"


    // $ANTLR start "rule__EditorCondition__Group_4__1"
    // InternalGT.g:4657:1: rule__EditorCondition__Group_4__1 : rule__EditorCondition__Group_4__1__Impl ;
    public final void rule__EditorCondition__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4661:1: ( rule__EditorCondition__Group_4__1__Impl )
            // InternalGT.g:4662:2: rule__EditorCondition__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorCondition__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group_4__1"


    // $ANTLR start "rule__EditorCondition__Group_4__1__Impl"
    // InternalGT.g:4668:1: rule__EditorCondition__Group_4__1__Impl : ( ( rule__EditorCondition__ConditionsAssignment_4_1 ) ) ;
    public final void rule__EditorCondition__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4672:1: ( ( ( rule__EditorCondition__ConditionsAssignment_4_1 ) ) )
            // InternalGT.g:4673:1: ( ( rule__EditorCondition__ConditionsAssignment_4_1 ) )
            {
            // InternalGT.g:4673:1: ( ( rule__EditorCondition__ConditionsAssignment_4_1 ) )
            // InternalGT.g:4674:2: ( rule__EditorCondition__ConditionsAssignment_4_1 )
            {
             before(grammarAccess.getEditorConditionAccess().getConditionsAssignment_4_1()); 
            // InternalGT.g:4675:2: ( rule__EditorCondition__ConditionsAssignment_4_1 )
            // InternalGT.g:4675:3: rule__EditorCondition__ConditionsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorCondition__ConditionsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorConditionAccess().getConditionsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__Group_4__1__Impl"


    // $ANTLR start "rule__EditorSimpleCondition__Group_0__0"
    // InternalGT.g:4684:1: rule__EditorSimpleCondition__Group_0__0 : rule__EditorSimpleCondition__Group_0__0__Impl rule__EditorSimpleCondition__Group_0__1 ;
    public final void rule__EditorSimpleCondition__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4688:1: ( rule__EditorSimpleCondition__Group_0__0__Impl rule__EditorSimpleCondition__Group_0__1 )
            // InternalGT.g:4689:2: rule__EditorSimpleCondition__Group_0__0__Impl rule__EditorSimpleCondition__Group_0__1
            {
            pushFollow(FOLLOW_8);
            rule__EditorSimpleCondition__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_0__0"


    // $ANTLR start "rule__EditorSimpleCondition__Group_0__0__Impl"
    // InternalGT.g:4696:1: rule__EditorSimpleCondition__Group_0__0__Impl : ( () ) ;
    public final void rule__EditorSimpleCondition__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4700:1: ( ( () ) )
            // InternalGT.g:4701:1: ( () )
            {
            // InternalGT.g:4701:1: ( () )
            // InternalGT.g:4702:2: ()
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getEditorConditionReferenceAction_0_0()); 
            // InternalGT.g:4703:2: ()
            // InternalGT.g:4703:3: 
            {
            }

             after(grammarAccess.getEditorSimpleConditionAccess().getEditorConditionReferenceAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_0__0__Impl"


    // $ANTLR start "rule__EditorSimpleCondition__Group_0__1"
    // InternalGT.g:4711:1: rule__EditorSimpleCondition__Group_0__1 : rule__EditorSimpleCondition__Group_0__1__Impl ;
    public final void rule__EditorSimpleCondition__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4715:1: ( rule__EditorSimpleCondition__Group_0__1__Impl )
            // InternalGT.g:4716:2: rule__EditorSimpleCondition__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_0__1"


    // $ANTLR start "rule__EditorSimpleCondition__Group_0__1__Impl"
    // InternalGT.g:4722:1: rule__EditorSimpleCondition__Group_0__1__Impl : ( ( rule__EditorSimpleCondition__ConditionAssignment_0_1 ) ) ;
    public final void rule__EditorSimpleCondition__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4726:1: ( ( ( rule__EditorSimpleCondition__ConditionAssignment_0_1 ) ) )
            // InternalGT.g:4727:1: ( ( rule__EditorSimpleCondition__ConditionAssignment_0_1 ) )
            {
            // InternalGT.g:4727:1: ( ( rule__EditorSimpleCondition__ConditionAssignment_0_1 ) )
            // InternalGT.g:4728:2: ( rule__EditorSimpleCondition__ConditionAssignment_0_1 )
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getConditionAssignment_0_1()); 
            // InternalGT.g:4729:2: ( rule__EditorSimpleCondition__ConditionAssignment_0_1 )
            // InternalGT.g:4729:3: rule__EditorSimpleCondition__ConditionAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__ConditionAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorSimpleConditionAccess().getConditionAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_0__1__Impl"


    // $ANTLR start "rule__EditorSimpleCondition__Group_1__0"
    // InternalGT.g:4738:1: rule__EditorSimpleCondition__Group_1__0 : rule__EditorSimpleCondition__Group_1__0__Impl rule__EditorSimpleCondition__Group_1__1 ;
    public final void rule__EditorSimpleCondition__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4742:1: ( rule__EditorSimpleCondition__Group_1__0__Impl rule__EditorSimpleCondition__Group_1__1 )
            // InternalGT.g:4743:2: rule__EditorSimpleCondition__Group_1__0__Impl rule__EditorSimpleCondition__Group_1__1
            {
            pushFollow(FOLLOW_41);
            rule__EditorSimpleCondition__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_1__0"


    // $ANTLR start "rule__EditorSimpleCondition__Group_1__0__Impl"
    // InternalGT.g:4750:1: rule__EditorSimpleCondition__Group_1__0__Impl : ( () ) ;
    public final void rule__EditorSimpleCondition__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4754:1: ( ( () ) )
            // InternalGT.g:4755:1: ( () )
            {
            // InternalGT.g:4755:1: ( () )
            // InternalGT.g:4756:2: ()
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getEditorApplicationConditionAction_1_0()); 
            // InternalGT.g:4757:2: ()
            // InternalGT.g:4757:3: 
            {
            }

             after(grammarAccess.getEditorSimpleConditionAccess().getEditorApplicationConditionAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_1__0__Impl"


    // $ANTLR start "rule__EditorSimpleCondition__Group_1__1"
    // InternalGT.g:4765:1: rule__EditorSimpleCondition__Group_1__1 : rule__EditorSimpleCondition__Group_1__1__Impl rule__EditorSimpleCondition__Group_1__2 ;
    public final void rule__EditorSimpleCondition__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4769:1: ( rule__EditorSimpleCondition__Group_1__1__Impl rule__EditorSimpleCondition__Group_1__2 )
            // InternalGT.g:4770:2: rule__EditorSimpleCondition__Group_1__1__Impl rule__EditorSimpleCondition__Group_1__2
            {
            pushFollow(FOLLOW_8);
            rule__EditorSimpleCondition__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_1__1"


    // $ANTLR start "rule__EditorSimpleCondition__Group_1__1__Impl"
    // InternalGT.g:4777:1: rule__EditorSimpleCondition__Group_1__1__Impl : ( ( rule__EditorSimpleCondition__TypeAssignment_1_1 ) ) ;
    public final void rule__EditorSimpleCondition__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4781:1: ( ( ( rule__EditorSimpleCondition__TypeAssignment_1_1 ) ) )
            // InternalGT.g:4782:1: ( ( rule__EditorSimpleCondition__TypeAssignment_1_1 ) )
            {
            // InternalGT.g:4782:1: ( ( rule__EditorSimpleCondition__TypeAssignment_1_1 ) )
            // InternalGT.g:4783:2: ( rule__EditorSimpleCondition__TypeAssignment_1_1 )
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getTypeAssignment_1_1()); 
            // InternalGT.g:4784:2: ( rule__EditorSimpleCondition__TypeAssignment_1_1 )
            // InternalGT.g:4784:3: rule__EditorSimpleCondition__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__TypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEditorSimpleConditionAccess().getTypeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_1__1__Impl"


    // $ANTLR start "rule__EditorSimpleCondition__Group_1__2"
    // InternalGT.g:4792:1: rule__EditorSimpleCondition__Group_1__2 : rule__EditorSimpleCondition__Group_1__2__Impl ;
    public final void rule__EditorSimpleCondition__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4796:1: ( rule__EditorSimpleCondition__Group_1__2__Impl )
            // InternalGT.g:4797:2: rule__EditorSimpleCondition__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_1__2"


    // $ANTLR start "rule__EditorSimpleCondition__Group_1__2__Impl"
    // InternalGT.g:4803:1: rule__EditorSimpleCondition__Group_1__2__Impl : ( ( rule__EditorSimpleCondition__PatternAssignment_1_2 ) ) ;
    public final void rule__EditorSimpleCondition__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4807:1: ( ( ( rule__EditorSimpleCondition__PatternAssignment_1_2 ) ) )
            // InternalGT.g:4808:1: ( ( rule__EditorSimpleCondition__PatternAssignment_1_2 ) )
            {
            // InternalGT.g:4808:1: ( ( rule__EditorSimpleCondition__PatternAssignment_1_2 ) )
            // InternalGT.g:4809:2: ( rule__EditorSimpleCondition__PatternAssignment_1_2 )
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getPatternAssignment_1_2()); 
            // InternalGT.g:4810:2: ( rule__EditorSimpleCondition__PatternAssignment_1_2 )
            // InternalGT.g:4810:3: rule__EditorSimpleCondition__PatternAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__EditorSimpleCondition__PatternAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEditorSimpleConditionAccess().getPatternAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__Group_1__2__Impl"


    // $ANTLR start "rule__StochasticFunction__Group__0"
    // InternalGT.g:4819:1: rule__StochasticFunction__Group__0 : rule__StochasticFunction__Group__0__Impl rule__StochasticFunction__Group__1 ;
    public final void rule__StochasticFunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4823:1: ( rule__StochasticFunction__Group__0__Impl rule__StochasticFunction__Group__1 )
            // InternalGT.g:4824:2: rule__StochasticFunction__Group__0__Impl rule__StochasticFunction__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__StochasticFunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StochasticFunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunction__Group__0"


    // $ANTLR start "rule__StochasticFunction__Group__0__Impl"
    // InternalGT.g:4831:1: rule__StochasticFunction__Group__0__Impl : ( ( rule__StochasticFunction__FunctionExpressionAssignment_0 ) ) ;
    public final void rule__StochasticFunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4835:1: ( ( ( rule__StochasticFunction__FunctionExpressionAssignment_0 ) ) )
            // InternalGT.g:4836:1: ( ( rule__StochasticFunction__FunctionExpressionAssignment_0 ) )
            {
            // InternalGT.g:4836:1: ( ( rule__StochasticFunction__FunctionExpressionAssignment_0 ) )
            // InternalGT.g:4837:2: ( rule__StochasticFunction__FunctionExpressionAssignment_0 )
            {
             before(grammarAccess.getStochasticFunctionAccess().getFunctionExpressionAssignment_0()); 
            // InternalGT.g:4838:2: ( rule__StochasticFunction__FunctionExpressionAssignment_0 )
            // InternalGT.g:4838:3: rule__StochasticFunction__FunctionExpressionAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunction__FunctionExpressionAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getStochasticFunctionAccess().getFunctionExpressionAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunction__Group__0__Impl"


    // $ANTLR start "rule__StochasticFunction__Group__1"
    // InternalGT.g:4846:1: rule__StochasticFunction__Group__1 : rule__StochasticFunction__Group__1__Impl ;
    public final void rule__StochasticFunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4850:1: ( rule__StochasticFunction__Group__1__Impl )
            // InternalGT.g:4851:2: rule__StochasticFunction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunction__Group__1"


    // $ANTLR start "rule__StochasticFunction__Group__1__Impl"
    // InternalGT.g:4857:1: rule__StochasticFunction__Group__1__Impl : ( ( rule__StochasticFunction__ParameterAssignment_1 )? ) ;
    public final void rule__StochasticFunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4861:1: ( ( ( rule__StochasticFunction__ParameterAssignment_1 )? ) )
            // InternalGT.g:4862:1: ( ( rule__StochasticFunction__ParameterAssignment_1 )? )
            {
            // InternalGT.g:4862:1: ( ( rule__StochasticFunction__ParameterAssignment_1 )? )
            // InternalGT.g:4863:2: ( rule__StochasticFunction__ParameterAssignment_1 )?
            {
             before(grammarAccess.getStochasticFunctionAccess().getParameterAssignment_1()); 
            // InternalGT.g:4864:2: ( rule__StochasticFunction__ParameterAssignment_1 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=RULE_INT && LA48_0<=RULE_ID)||(LA48_0>=11 && LA48_0<=12)||LA48_0==27||(LA48_0>=34 && LA48_0<=43)||LA48_0==45||LA48_0==57||LA48_0==62) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalGT.g:4864:3: rule__StochasticFunction__ParameterAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__StochasticFunction__ParameterAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStochasticFunctionAccess().getParameterAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunction__Group__1__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__0"
    // InternalGT.g:4873:1: rule__StochasticFunctionExpression__Group__0 : rule__StochasticFunctionExpression__Group__0__Impl rule__StochasticFunctionExpression__Group__1 ;
    public final void rule__StochasticFunctionExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4877:1: ( rule__StochasticFunctionExpression__Group__0__Impl rule__StochasticFunctionExpression__Group__1 )
            // InternalGT.g:4878:2: rule__StochasticFunctionExpression__Group__0__Impl rule__StochasticFunctionExpression__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__StochasticFunctionExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__0"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__0__Impl"
    // InternalGT.g:4885:1: rule__StochasticFunctionExpression__Group__0__Impl : ( ( rule__StochasticFunctionExpression__OperatorRangeAssignment_0 )? ) ;
    public final void rule__StochasticFunctionExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4889:1: ( ( ( rule__StochasticFunctionExpression__OperatorRangeAssignment_0 )? ) )
            // InternalGT.g:4890:1: ( ( rule__StochasticFunctionExpression__OperatorRangeAssignment_0 )? )
            {
            // InternalGT.g:4890:1: ( ( rule__StochasticFunctionExpression__OperatorRangeAssignment_0 )? )
            // InternalGT.g:4891:2: ( rule__StochasticFunctionExpression__OperatorRangeAssignment_0 )?
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getOperatorRangeAssignment_0()); 
            // InternalGT.g:4892:2: ( rule__StochasticFunctionExpression__OperatorRangeAssignment_0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=26 && LA49_0<=27)) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalGT.g:4892:3: rule__StochasticFunctionExpression__OperatorRangeAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__StochasticFunctionExpression__OperatorRangeAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getOperatorRangeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__0__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__1"
    // InternalGT.g:4900:1: rule__StochasticFunctionExpression__Group__1 : rule__StochasticFunctionExpression__Group__1__Impl rule__StochasticFunctionExpression__Group__2 ;
    public final void rule__StochasticFunctionExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4904:1: ( rule__StochasticFunctionExpression__Group__1__Impl rule__StochasticFunctionExpression__Group__2 )
            // InternalGT.g:4905:2: rule__StochasticFunctionExpression__Group__1__Impl rule__StochasticFunctionExpression__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__StochasticFunctionExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__1"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__1__Impl"
    // InternalGT.g:4912:1: rule__StochasticFunctionExpression__Group__1__Impl : ( ( rule__StochasticFunctionExpression__DistributionAssignment_1 ) ) ;
    public final void rule__StochasticFunctionExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4916:1: ( ( ( rule__StochasticFunctionExpression__DistributionAssignment_1 ) ) )
            // InternalGT.g:4917:1: ( ( rule__StochasticFunctionExpression__DistributionAssignment_1 ) )
            {
            // InternalGT.g:4917:1: ( ( rule__StochasticFunctionExpression__DistributionAssignment_1 ) )
            // InternalGT.g:4918:2: ( rule__StochasticFunctionExpression__DistributionAssignment_1 )
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getDistributionAssignment_1()); 
            // InternalGT.g:4919:2: ( rule__StochasticFunctionExpression__DistributionAssignment_1 )
            // InternalGT.g:4919:3: rule__StochasticFunctionExpression__DistributionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__DistributionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getDistributionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__1__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__2"
    // InternalGT.g:4927:1: rule__StochasticFunctionExpression__Group__2 : rule__StochasticFunctionExpression__Group__2__Impl rule__StochasticFunctionExpression__Group__3 ;
    public final void rule__StochasticFunctionExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4931:1: ( rule__StochasticFunctionExpression__Group__2__Impl rule__StochasticFunctionExpression__Group__3 )
            // InternalGT.g:4932:2: rule__StochasticFunctionExpression__Group__2__Impl rule__StochasticFunctionExpression__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__StochasticFunctionExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__2"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__2__Impl"
    // InternalGT.g:4939:1: rule__StochasticFunctionExpression__Group__2__Impl : ( '(' ) ;
    public final void rule__StochasticFunctionExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4943:1: ( ( '(' ) )
            // InternalGT.g:4944:1: ( '(' )
            {
            // InternalGT.g:4944:1: ( '(' )
            // InternalGT.g:4945:2: '('
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getLeftParenthesisKeyword_2()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getStochasticFunctionExpressionAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__2__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__3"
    // InternalGT.g:4954:1: rule__StochasticFunctionExpression__Group__3 : rule__StochasticFunctionExpression__Group__3__Impl rule__StochasticFunctionExpression__Group__4 ;
    public final void rule__StochasticFunctionExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4958:1: ( rule__StochasticFunctionExpression__Group__3__Impl rule__StochasticFunctionExpression__Group__4 )
            // InternalGT.g:4959:2: rule__StochasticFunctionExpression__Group__3__Impl rule__StochasticFunctionExpression__Group__4
            {
            pushFollow(FOLLOW_45);
            rule__StochasticFunctionExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__3"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__3__Impl"
    // InternalGT.g:4966:1: rule__StochasticFunctionExpression__Group__3__Impl : ( ( rule__StochasticFunctionExpression__MeanAssignment_3 ) ) ;
    public final void rule__StochasticFunctionExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4970:1: ( ( ( rule__StochasticFunctionExpression__MeanAssignment_3 ) ) )
            // InternalGT.g:4971:1: ( ( rule__StochasticFunctionExpression__MeanAssignment_3 ) )
            {
            // InternalGT.g:4971:1: ( ( rule__StochasticFunctionExpression__MeanAssignment_3 ) )
            // InternalGT.g:4972:2: ( rule__StochasticFunctionExpression__MeanAssignment_3 )
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getMeanAssignment_3()); 
            // InternalGT.g:4973:2: ( rule__StochasticFunctionExpression__MeanAssignment_3 )
            // InternalGT.g:4973:3: rule__StochasticFunctionExpression__MeanAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__MeanAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getMeanAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__3__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__4"
    // InternalGT.g:4981:1: rule__StochasticFunctionExpression__Group__4 : rule__StochasticFunctionExpression__Group__4__Impl rule__StochasticFunctionExpression__Group__5 ;
    public final void rule__StochasticFunctionExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4985:1: ( rule__StochasticFunctionExpression__Group__4__Impl rule__StochasticFunctionExpression__Group__5 )
            // InternalGT.g:4986:2: rule__StochasticFunctionExpression__Group__4__Impl rule__StochasticFunctionExpression__Group__5
            {
            pushFollow(FOLLOW_45);
            rule__StochasticFunctionExpression__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__4"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__4__Impl"
    // InternalGT.g:4993:1: rule__StochasticFunctionExpression__Group__4__Impl : ( ( rule__StochasticFunctionExpression__Group_4__0 )? ) ;
    public final void rule__StochasticFunctionExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:4997:1: ( ( ( rule__StochasticFunctionExpression__Group_4__0 )? ) )
            // InternalGT.g:4998:1: ( ( rule__StochasticFunctionExpression__Group_4__0 )? )
            {
            // InternalGT.g:4998:1: ( ( rule__StochasticFunctionExpression__Group_4__0 )? )
            // InternalGT.g:4999:2: ( rule__StochasticFunctionExpression__Group_4__0 )?
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getGroup_4()); 
            // InternalGT.g:5000:2: ( rule__StochasticFunctionExpression__Group_4__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==47) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalGT.g:5000:3: rule__StochasticFunctionExpression__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__StochasticFunctionExpression__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__4__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__5"
    // InternalGT.g:5008:1: rule__StochasticFunctionExpression__Group__5 : rule__StochasticFunctionExpression__Group__5__Impl ;
    public final void rule__StochasticFunctionExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5012:1: ( rule__StochasticFunctionExpression__Group__5__Impl )
            // InternalGT.g:5013:2: rule__StochasticFunctionExpression__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__5"


    // $ANTLR start "rule__StochasticFunctionExpression__Group__5__Impl"
    // InternalGT.g:5019:1: rule__StochasticFunctionExpression__Group__5__Impl : ( ')' ) ;
    public final void rule__StochasticFunctionExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5023:1: ( ( ')' ) )
            // InternalGT.g:5024:1: ( ')' )
            {
            // InternalGT.g:5024:1: ( ')' )
            // InternalGT.g:5025:2: ')'
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getRightParenthesisKeyword_5()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getStochasticFunctionExpressionAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group__5__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group_4__0"
    // InternalGT.g:5035:1: rule__StochasticFunctionExpression__Group_4__0 : rule__StochasticFunctionExpression__Group_4__0__Impl rule__StochasticFunctionExpression__Group_4__1 ;
    public final void rule__StochasticFunctionExpression__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5039:1: ( rule__StochasticFunctionExpression__Group_4__0__Impl rule__StochasticFunctionExpression__Group_4__1 )
            // InternalGT.g:5040:2: rule__StochasticFunctionExpression__Group_4__0__Impl rule__StochasticFunctionExpression__Group_4__1
            {
            pushFollow(FOLLOW_17);
            rule__StochasticFunctionExpression__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group_4__0"


    // $ANTLR start "rule__StochasticFunctionExpression__Group_4__0__Impl"
    // InternalGT.g:5047:1: rule__StochasticFunctionExpression__Group_4__0__Impl : ( ( rule__StochasticFunctionExpression__HasSdAssignment_4_0 ) ) ;
    public final void rule__StochasticFunctionExpression__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5051:1: ( ( ( rule__StochasticFunctionExpression__HasSdAssignment_4_0 ) ) )
            // InternalGT.g:5052:1: ( ( rule__StochasticFunctionExpression__HasSdAssignment_4_0 ) )
            {
            // InternalGT.g:5052:1: ( ( rule__StochasticFunctionExpression__HasSdAssignment_4_0 ) )
            // InternalGT.g:5053:2: ( rule__StochasticFunctionExpression__HasSdAssignment_4_0 )
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getHasSdAssignment_4_0()); 
            // InternalGT.g:5054:2: ( rule__StochasticFunctionExpression__HasSdAssignment_4_0 )
            // InternalGT.g:5054:3: rule__StochasticFunctionExpression__HasSdAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__HasSdAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getHasSdAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group_4__0__Impl"


    // $ANTLR start "rule__StochasticFunctionExpression__Group_4__1"
    // InternalGT.g:5062:1: rule__StochasticFunctionExpression__Group_4__1 : rule__StochasticFunctionExpression__Group_4__1__Impl ;
    public final void rule__StochasticFunctionExpression__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5066:1: ( rule__StochasticFunctionExpression__Group_4__1__Impl )
            // InternalGT.g:5067:2: rule__StochasticFunctionExpression__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group_4__1"


    // $ANTLR start "rule__StochasticFunctionExpression__Group_4__1__Impl"
    // InternalGT.g:5073:1: rule__StochasticFunctionExpression__Group_4__1__Impl : ( ( rule__StochasticFunctionExpression__SdAssignment_4_1 ) ) ;
    public final void rule__StochasticFunctionExpression__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5077:1: ( ( ( rule__StochasticFunctionExpression__SdAssignment_4_1 ) ) )
            // InternalGT.g:5078:1: ( ( rule__StochasticFunctionExpression__SdAssignment_4_1 ) )
            {
            // InternalGT.g:5078:1: ( ( rule__StochasticFunctionExpression__SdAssignment_4_1 ) )
            // InternalGT.g:5079:2: ( rule__StochasticFunctionExpression__SdAssignment_4_1 )
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getSdAssignment_4_1()); 
            // InternalGT.g:5080:2: ( rule__StochasticFunctionExpression__SdAssignment_4_1 )
            // InternalGT.g:5080:3: rule__StochasticFunctionExpression__SdAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__StochasticFunctionExpression__SdAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getSdAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__Group_4__1__Impl"


    // $ANTLR start "rule__AddExpression__Group__0"
    // InternalGT.g:5089:1: rule__AddExpression__Group__0 : rule__AddExpression__Group__0__Impl rule__AddExpression__Group__1 ;
    public final void rule__AddExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5093:1: ( rule__AddExpression__Group__0__Impl rule__AddExpression__Group__1 )
            // InternalGT.g:5094:2: rule__AddExpression__Group__0__Impl rule__AddExpression__Group__1
            {
            pushFollow(FOLLOW_46);
            rule__AddExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AddExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group__0"


    // $ANTLR start "rule__AddExpression__Group__0__Impl"
    // InternalGT.g:5101:1: rule__AddExpression__Group__0__Impl : ( ruleMultExpression ) ;
    public final void rule__AddExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5105:1: ( ( ruleMultExpression ) )
            // InternalGT.g:5106:1: ( ruleMultExpression )
            {
            // InternalGT.g:5106:1: ( ruleMultExpression )
            // InternalGT.g:5107:2: ruleMultExpression
            {
             before(grammarAccess.getAddExpressionAccess().getMultExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMultExpression();

            state._fsp--;

             after(grammarAccess.getAddExpressionAccess().getMultExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group__0__Impl"


    // $ANTLR start "rule__AddExpression__Group__1"
    // InternalGT.g:5116:1: rule__AddExpression__Group__1 : rule__AddExpression__Group__1__Impl ;
    public final void rule__AddExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5120:1: ( rule__AddExpression__Group__1__Impl )
            // InternalGT.g:5121:2: rule__AddExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AddExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group__1"


    // $ANTLR start "rule__AddExpression__Group__1__Impl"
    // InternalGT.g:5127:1: rule__AddExpression__Group__1__Impl : ( ( rule__AddExpression__Group_1__0 )* ) ;
    public final void rule__AddExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5131:1: ( ( ( rule__AddExpression__Group_1__0 )* ) )
            // InternalGT.g:5132:1: ( ( rule__AddExpression__Group_1__0 )* )
            {
            // InternalGT.g:5132:1: ( ( rule__AddExpression__Group_1__0 )* )
            // InternalGT.g:5133:2: ( rule__AddExpression__Group_1__0 )*
            {
             before(grammarAccess.getAddExpressionAccess().getGroup_1()); 
            // InternalGT.g:5134:2: ( rule__AddExpression__Group_1__0 )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==27) ) {
                    int LA51_2 = input.LA(2);

                    if ( (LA51_2==RULE_ID) ) {
                        int LA51_4 = input.LA(3);

                        if ( (LA51_4==55) ) {
                            alt51=1;
                        }


                    }
                    else if ( ((LA51_2>=RULE_INT && LA51_2<=RULE_STRING)||(LA51_2>=11 && LA51_2<=12)||LA51_2==27||(LA51_2>=34 && LA51_2<=43)||LA51_2==45||LA51_2==57||LA51_2==62) ) {
                        alt51=1;
                    }


                }
                else if ( (LA51_0==26) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalGT.g:5134:3: rule__AddExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_47);
            	    rule__AddExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

             after(grammarAccess.getAddExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group__1__Impl"


    // $ANTLR start "rule__AddExpression__Group_1__0"
    // InternalGT.g:5143:1: rule__AddExpression__Group_1__0 : rule__AddExpression__Group_1__0__Impl rule__AddExpression__Group_1__1 ;
    public final void rule__AddExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5147:1: ( rule__AddExpression__Group_1__0__Impl rule__AddExpression__Group_1__1 )
            // InternalGT.g:5148:2: rule__AddExpression__Group_1__0__Impl rule__AddExpression__Group_1__1
            {
            pushFollow(FOLLOW_46);
            rule__AddExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AddExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group_1__0"


    // $ANTLR start "rule__AddExpression__Group_1__0__Impl"
    // InternalGT.g:5155:1: rule__AddExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__AddExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5159:1: ( ( () ) )
            // InternalGT.g:5160:1: ( () )
            {
            // InternalGT.g:5160:1: ( () )
            // InternalGT.g:5161:2: ()
            {
             before(grammarAccess.getAddExpressionAccess().getAddExpressionLeftAction_1_0()); 
            // InternalGT.g:5162:2: ()
            // InternalGT.g:5162:3: 
            {
            }

             after(grammarAccess.getAddExpressionAccess().getAddExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group_1__0__Impl"


    // $ANTLR start "rule__AddExpression__Group_1__1"
    // InternalGT.g:5170:1: rule__AddExpression__Group_1__1 : rule__AddExpression__Group_1__1__Impl rule__AddExpression__Group_1__2 ;
    public final void rule__AddExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5174:1: ( rule__AddExpression__Group_1__1__Impl rule__AddExpression__Group_1__2 )
            // InternalGT.g:5175:2: rule__AddExpression__Group_1__1__Impl rule__AddExpression__Group_1__2
            {
            pushFollow(FOLLOW_17);
            rule__AddExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AddExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group_1__1"


    // $ANTLR start "rule__AddExpression__Group_1__1__Impl"
    // InternalGT.g:5182:1: rule__AddExpression__Group_1__1__Impl : ( ( rule__AddExpression__AddOperatorAssignment_1_1 ) ) ;
    public final void rule__AddExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5186:1: ( ( ( rule__AddExpression__AddOperatorAssignment_1_1 ) ) )
            // InternalGT.g:5187:1: ( ( rule__AddExpression__AddOperatorAssignment_1_1 ) )
            {
            // InternalGT.g:5187:1: ( ( rule__AddExpression__AddOperatorAssignment_1_1 ) )
            // InternalGT.g:5188:2: ( rule__AddExpression__AddOperatorAssignment_1_1 )
            {
             before(grammarAccess.getAddExpressionAccess().getAddOperatorAssignment_1_1()); 
            // InternalGT.g:5189:2: ( rule__AddExpression__AddOperatorAssignment_1_1 )
            // InternalGT.g:5189:3: rule__AddExpression__AddOperatorAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AddExpression__AddOperatorAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAddExpressionAccess().getAddOperatorAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group_1__1__Impl"


    // $ANTLR start "rule__AddExpression__Group_1__2"
    // InternalGT.g:5197:1: rule__AddExpression__Group_1__2 : rule__AddExpression__Group_1__2__Impl ;
    public final void rule__AddExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5201:1: ( rule__AddExpression__Group_1__2__Impl )
            // InternalGT.g:5202:2: rule__AddExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AddExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group_1__2"


    // $ANTLR start "rule__AddExpression__Group_1__2__Impl"
    // InternalGT.g:5208:1: rule__AddExpression__Group_1__2__Impl : ( ( rule__AddExpression__RightAssignment_1_2 ) ) ;
    public final void rule__AddExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5212:1: ( ( ( rule__AddExpression__RightAssignment_1_2 ) ) )
            // InternalGT.g:5213:1: ( ( rule__AddExpression__RightAssignment_1_2 ) )
            {
            // InternalGT.g:5213:1: ( ( rule__AddExpression__RightAssignment_1_2 ) )
            // InternalGT.g:5214:2: ( rule__AddExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getAddExpressionAccess().getRightAssignment_1_2()); 
            // InternalGT.g:5215:2: ( rule__AddExpression__RightAssignment_1_2 )
            // InternalGT.g:5215:3: rule__AddExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AddExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAddExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__Group_1__2__Impl"


    // $ANTLR start "rule__MultExpression__Group__0"
    // InternalGT.g:5224:1: rule__MultExpression__Group__0 : rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1 ;
    public final void rule__MultExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5228:1: ( rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1 )
            // InternalGT.g:5229:2: rule__MultExpression__Group__0__Impl rule__MultExpression__Group__1
            {
            pushFollow(FOLLOW_48);
            rule__MultExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__0"


    // $ANTLR start "rule__MultExpression__Group__0__Impl"
    // InternalGT.g:5236:1: rule__MultExpression__Group__0__Impl : ( ruleExpExpression ) ;
    public final void rule__MultExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5240:1: ( ( ruleExpExpression ) )
            // InternalGT.g:5241:1: ( ruleExpExpression )
            {
            // InternalGT.g:5241:1: ( ruleExpExpression )
            // InternalGT.g:5242:2: ruleExpExpression
            {
             before(grammarAccess.getMultExpressionAccess().getExpExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleExpExpression();

            state._fsp--;

             after(grammarAccess.getMultExpressionAccess().getExpExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__0__Impl"


    // $ANTLR start "rule__MultExpression__Group__1"
    // InternalGT.g:5251:1: rule__MultExpression__Group__1 : rule__MultExpression__Group__1__Impl ;
    public final void rule__MultExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5255:1: ( rule__MultExpression__Group__1__Impl )
            // InternalGT.g:5256:2: rule__MultExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__1"


    // $ANTLR start "rule__MultExpression__Group__1__Impl"
    // InternalGT.g:5262:1: rule__MultExpression__Group__1__Impl : ( ( rule__MultExpression__Group_1__0 )* ) ;
    public final void rule__MultExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5266:1: ( ( ( rule__MultExpression__Group_1__0 )* ) )
            // InternalGT.g:5267:1: ( ( rule__MultExpression__Group_1__0 )* )
            {
            // InternalGT.g:5267:1: ( ( rule__MultExpression__Group_1__0 )* )
            // InternalGT.g:5268:2: ( rule__MultExpression__Group_1__0 )*
            {
             before(grammarAccess.getMultExpressionAccess().getGroup_1()); 
            // InternalGT.g:5269:2: ( rule__MultExpression__Group_1__0 )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( ((LA52_0>=31 && LA52_0<=33)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalGT.g:5269:3: rule__MultExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_49);
            	    rule__MultExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

             after(grammarAccess.getMultExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group__1__Impl"


    // $ANTLR start "rule__MultExpression__Group_1__0"
    // InternalGT.g:5278:1: rule__MultExpression__Group_1__0 : rule__MultExpression__Group_1__0__Impl rule__MultExpression__Group_1__1 ;
    public final void rule__MultExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5282:1: ( rule__MultExpression__Group_1__0__Impl rule__MultExpression__Group_1__1 )
            // InternalGT.g:5283:2: rule__MultExpression__Group_1__0__Impl rule__MultExpression__Group_1__1
            {
            pushFollow(FOLLOW_48);
            rule__MultExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1__0"


    // $ANTLR start "rule__MultExpression__Group_1__0__Impl"
    // InternalGT.g:5290:1: rule__MultExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__MultExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5294:1: ( ( () ) )
            // InternalGT.g:5295:1: ( () )
            {
            // InternalGT.g:5295:1: ( () )
            // InternalGT.g:5296:2: ()
            {
             before(grammarAccess.getMultExpressionAccess().getMultExpressionLeftAction_1_0()); 
            // InternalGT.g:5297:2: ()
            // InternalGT.g:5297:3: 
            {
            }

             after(grammarAccess.getMultExpressionAccess().getMultExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1__0__Impl"


    // $ANTLR start "rule__MultExpression__Group_1__1"
    // InternalGT.g:5305:1: rule__MultExpression__Group_1__1 : rule__MultExpression__Group_1__1__Impl rule__MultExpression__Group_1__2 ;
    public final void rule__MultExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5309:1: ( rule__MultExpression__Group_1__1__Impl rule__MultExpression__Group_1__2 )
            // InternalGT.g:5310:2: rule__MultExpression__Group_1__1__Impl rule__MultExpression__Group_1__2
            {
            pushFollow(FOLLOW_17);
            rule__MultExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1__1"


    // $ANTLR start "rule__MultExpression__Group_1__1__Impl"
    // InternalGT.g:5317:1: rule__MultExpression__Group_1__1__Impl : ( ( rule__MultExpression__MultOperatorAssignment_1_1 ) ) ;
    public final void rule__MultExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5321:1: ( ( ( rule__MultExpression__MultOperatorAssignment_1_1 ) ) )
            // InternalGT.g:5322:1: ( ( rule__MultExpression__MultOperatorAssignment_1_1 ) )
            {
            // InternalGT.g:5322:1: ( ( rule__MultExpression__MultOperatorAssignment_1_1 ) )
            // InternalGT.g:5323:2: ( rule__MultExpression__MultOperatorAssignment_1_1 )
            {
             before(grammarAccess.getMultExpressionAccess().getMultOperatorAssignment_1_1()); 
            // InternalGT.g:5324:2: ( rule__MultExpression__MultOperatorAssignment_1_1 )
            // InternalGT.g:5324:3: rule__MultExpression__MultOperatorAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultExpression__MultOperatorAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultExpressionAccess().getMultOperatorAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1__1__Impl"


    // $ANTLR start "rule__MultExpression__Group_1__2"
    // InternalGT.g:5332:1: rule__MultExpression__Group_1__2 : rule__MultExpression__Group_1__2__Impl ;
    public final void rule__MultExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5336:1: ( rule__MultExpression__Group_1__2__Impl )
            // InternalGT.g:5337:2: rule__MultExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1__2"


    // $ANTLR start "rule__MultExpression__Group_1__2__Impl"
    // InternalGT.g:5343:1: rule__MultExpression__Group_1__2__Impl : ( ( rule__MultExpression__RightAssignment_1_2 ) ) ;
    public final void rule__MultExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5347:1: ( ( ( rule__MultExpression__RightAssignment_1_2 ) ) )
            // InternalGT.g:5348:1: ( ( rule__MultExpression__RightAssignment_1_2 ) )
            {
            // InternalGT.g:5348:1: ( ( rule__MultExpression__RightAssignment_1_2 ) )
            // InternalGT.g:5349:2: ( rule__MultExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getMultExpressionAccess().getRightAssignment_1_2()); 
            // InternalGT.g:5350:2: ( rule__MultExpression__RightAssignment_1_2 )
            // InternalGT.g:5350:3: rule__MultExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__MultExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMultExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__Group_1__2__Impl"


    // $ANTLR start "rule__ExpExpression__Group__0"
    // InternalGT.g:5359:1: rule__ExpExpression__Group__0 : rule__ExpExpression__Group__0__Impl rule__ExpExpression__Group__1 ;
    public final void rule__ExpExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5363:1: ( rule__ExpExpression__Group__0__Impl rule__ExpExpression__Group__1 )
            // InternalGT.g:5364:2: rule__ExpExpression__Group__0__Impl rule__ExpExpression__Group__1
            {
            pushFollow(FOLLOW_50);
            rule__ExpExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group__0"


    // $ANTLR start "rule__ExpExpression__Group__0__Impl"
    // InternalGT.g:5371:1: rule__ExpExpression__Group__0__Impl : ( ( rule__ExpExpression__Alternatives_0 ) ) ;
    public final void rule__ExpExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5375:1: ( ( ( rule__ExpExpression__Alternatives_0 ) ) )
            // InternalGT.g:5376:1: ( ( rule__ExpExpression__Alternatives_0 ) )
            {
            // InternalGT.g:5376:1: ( ( rule__ExpExpression__Alternatives_0 ) )
            // InternalGT.g:5377:2: ( rule__ExpExpression__Alternatives_0 )
            {
             before(grammarAccess.getExpExpressionAccess().getAlternatives_0()); 
            // InternalGT.g:5378:2: ( rule__ExpExpression__Alternatives_0 )
            // InternalGT.g:5378:3: rule__ExpExpression__Alternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__ExpExpression__Alternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getExpExpressionAccess().getAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group__0__Impl"


    // $ANTLR start "rule__ExpExpression__Group__1"
    // InternalGT.g:5386:1: rule__ExpExpression__Group__1 : rule__ExpExpression__Group__1__Impl ;
    public final void rule__ExpExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5390:1: ( rule__ExpExpression__Group__1__Impl )
            // InternalGT.g:5391:2: rule__ExpExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpExpression__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group__1"


    // $ANTLR start "rule__ExpExpression__Group__1__Impl"
    // InternalGT.g:5397:1: rule__ExpExpression__Group__1__Impl : ( ( rule__ExpExpression__Group_1__0 )* ) ;
    public final void rule__ExpExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5401:1: ( ( ( rule__ExpExpression__Group_1__0 )* ) )
            // InternalGT.g:5402:1: ( ( rule__ExpExpression__Group_1__0 )* )
            {
            // InternalGT.g:5402:1: ( ( rule__ExpExpression__Group_1__0 )* )
            // InternalGT.g:5403:2: ( rule__ExpExpression__Group_1__0 )*
            {
             before(grammarAccess.getExpExpressionAccess().getGroup_1()); 
            // InternalGT.g:5404:2: ( rule__ExpExpression__Group_1__0 )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==66) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalGT.g:5404:3: rule__ExpExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_51);
            	    rule__ExpExpression__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

             after(grammarAccess.getExpExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group__1__Impl"


    // $ANTLR start "rule__ExpExpression__Group_1__0"
    // InternalGT.g:5413:1: rule__ExpExpression__Group_1__0 : rule__ExpExpression__Group_1__0__Impl rule__ExpExpression__Group_1__1 ;
    public final void rule__ExpExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5417:1: ( rule__ExpExpression__Group_1__0__Impl rule__ExpExpression__Group_1__1 )
            // InternalGT.g:5418:2: rule__ExpExpression__Group_1__0__Impl rule__ExpExpression__Group_1__1
            {
            pushFollow(FOLLOW_50);
            rule__ExpExpression__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpExpression__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group_1__0"


    // $ANTLR start "rule__ExpExpression__Group_1__0__Impl"
    // InternalGT.g:5425:1: rule__ExpExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__ExpExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5429:1: ( ( () ) )
            // InternalGT.g:5430:1: ( () )
            {
            // InternalGT.g:5430:1: ( () )
            // InternalGT.g:5431:2: ()
            {
             before(grammarAccess.getExpExpressionAccess().getExpExpressionLeftAction_1_0()); 
            // InternalGT.g:5432:2: ()
            // InternalGT.g:5432:3: 
            {
            }

             after(grammarAccess.getExpExpressionAccess().getExpExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group_1__0__Impl"


    // $ANTLR start "rule__ExpExpression__Group_1__1"
    // InternalGT.g:5440:1: rule__ExpExpression__Group_1__1 : rule__ExpExpression__Group_1__1__Impl rule__ExpExpression__Group_1__2 ;
    public final void rule__ExpExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5444:1: ( rule__ExpExpression__Group_1__1__Impl rule__ExpExpression__Group_1__2 )
            // InternalGT.g:5445:2: rule__ExpExpression__Group_1__1__Impl rule__ExpExpression__Group_1__2
            {
            pushFollow(FOLLOW_17);
            rule__ExpExpression__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ExpExpression__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group_1__1"


    // $ANTLR start "rule__ExpExpression__Group_1__1__Impl"
    // InternalGT.g:5452:1: rule__ExpExpression__Group_1__1__Impl : ( '^' ) ;
    public final void rule__ExpExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5456:1: ( ( '^' ) )
            // InternalGT.g:5457:1: ( '^' )
            {
            // InternalGT.g:5457:1: ( '^' )
            // InternalGT.g:5458:2: '^'
            {
             before(grammarAccess.getExpExpressionAccess().getCircumflexAccentKeyword_1_1()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getExpExpressionAccess().getCircumflexAccentKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group_1__1__Impl"


    // $ANTLR start "rule__ExpExpression__Group_1__2"
    // InternalGT.g:5467:1: rule__ExpExpression__Group_1__2 : rule__ExpExpression__Group_1__2__Impl ;
    public final void rule__ExpExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5471:1: ( rule__ExpExpression__Group_1__2__Impl )
            // InternalGT.g:5472:2: rule__ExpExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ExpExpression__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group_1__2"


    // $ANTLR start "rule__ExpExpression__Group_1__2__Impl"
    // InternalGT.g:5478:1: rule__ExpExpression__Group_1__2__Impl : ( ( rule__ExpExpression__RightAssignment_1_2 ) ) ;
    public final void rule__ExpExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5482:1: ( ( ( rule__ExpExpression__RightAssignment_1_2 ) ) )
            // InternalGT.g:5483:1: ( ( rule__ExpExpression__RightAssignment_1_2 ) )
            {
            // InternalGT.g:5483:1: ( ( rule__ExpExpression__RightAssignment_1_2 ) )
            // InternalGT.g:5484:2: ( rule__ExpExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getExpExpressionAccess().getRightAssignment_1_2()); 
            // InternalGT.g:5485:2: ( rule__ExpExpression__RightAssignment_1_2 )
            // InternalGT.g:5485:3: rule__ExpExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ExpExpression__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getExpExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__Group_1__2__Impl"


    // $ANTLR start "rule__MinMaxExpression__Group__0"
    // InternalGT.g:5494:1: rule__MinMaxExpression__Group__0 : rule__MinMaxExpression__Group__0__Impl rule__MinMaxExpression__Group__1 ;
    public final void rule__MinMaxExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5498:1: ( rule__MinMaxExpression__Group__0__Impl rule__MinMaxExpression__Group__1 )
            // InternalGT.g:5499:2: rule__MinMaxExpression__Group__0__Impl rule__MinMaxExpression__Group__1
            {
            pushFollow(FOLLOW_52);
            rule__MinMaxExpression__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__0"


    // $ANTLR start "rule__MinMaxExpression__Group__0__Impl"
    // InternalGT.g:5506:1: rule__MinMaxExpression__Group__0__Impl : ( () ) ;
    public final void rule__MinMaxExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5510:1: ( ( () ) )
            // InternalGT.g:5511:1: ( () )
            {
            // InternalGT.g:5511:1: ( () )
            // InternalGT.g:5512:2: ()
            {
             before(grammarAccess.getMinMaxExpressionAccess().getMinMaxExpressionAction_0()); 
            // InternalGT.g:5513:2: ()
            // InternalGT.g:5513:3: 
            {
            }

             after(grammarAccess.getMinMaxExpressionAccess().getMinMaxExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__0__Impl"


    // $ANTLR start "rule__MinMaxExpression__Group__1"
    // InternalGT.g:5521:1: rule__MinMaxExpression__Group__1 : rule__MinMaxExpression__Group__1__Impl rule__MinMaxExpression__Group__2 ;
    public final void rule__MinMaxExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5525:1: ( rule__MinMaxExpression__Group__1__Impl rule__MinMaxExpression__Group__2 )
            // InternalGT.g:5526:2: rule__MinMaxExpression__Group__1__Impl rule__MinMaxExpression__Group__2
            {
            pushFollow(FOLLOW_27);
            rule__MinMaxExpression__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__1"


    // $ANTLR start "rule__MinMaxExpression__Group__1__Impl"
    // InternalGT.g:5533:1: rule__MinMaxExpression__Group__1__Impl : ( ( rule__MinMaxExpression__MinMaxOperatorAssignment_1 ) ) ;
    public final void rule__MinMaxExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5537:1: ( ( ( rule__MinMaxExpression__MinMaxOperatorAssignment_1 ) ) )
            // InternalGT.g:5538:1: ( ( rule__MinMaxExpression__MinMaxOperatorAssignment_1 ) )
            {
            // InternalGT.g:5538:1: ( ( rule__MinMaxExpression__MinMaxOperatorAssignment_1 ) )
            // InternalGT.g:5539:2: ( rule__MinMaxExpression__MinMaxOperatorAssignment_1 )
            {
             before(grammarAccess.getMinMaxExpressionAccess().getMinMaxOperatorAssignment_1()); 
            // InternalGT.g:5540:2: ( rule__MinMaxExpression__MinMaxOperatorAssignment_1 )
            // InternalGT.g:5540:3: rule__MinMaxExpression__MinMaxOperatorAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__MinMaxOperatorAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMinMaxExpressionAccess().getMinMaxOperatorAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__1__Impl"


    // $ANTLR start "rule__MinMaxExpression__Group__2"
    // InternalGT.g:5548:1: rule__MinMaxExpression__Group__2 : rule__MinMaxExpression__Group__2__Impl rule__MinMaxExpression__Group__3 ;
    public final void rule__MinMaxExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5552:1: ( rule__MinMaxExpression__Group__2__Impl rule__MinMaxExpression__Group__3 )
            // InternalGT.g:5553:2: rule__MinMaxExpression__Group__2__Impl rule__MinMaxExpression__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__MinMaxExpression__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__2"


    // $ANTLR start "rule__MinMaxExpression__Group__2__Impl"
    // InternalGT.g:5560:1: rule__MinMaxExpression__Group__2__Impl : ( '(' ) ;
    public final void rule__MinMaxExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5564:1: ( ( '(' ) )
            // InternalGT.g:5565:1: ( '(' )
            {
            // InternalGT.g:5565:1: ( '(' )
            // InternalGT.g:5566:2: '('
            {
             before(grammarAccess.getMinMaxExpressionAccess().getLeftParenthesisKeyword_2()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getMinMaxExpressionAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__2__Impl"


    // $ANTLR start "rule__MinMaxExpression__Group__3"
    // InternalGT.g:5575:1: rule__MinMaxExpression__Group__3 : rule__MinMaxExpression__Group__3__Impl rule__MinMaxExpression__Group__4 ;
    public final void rule__MinMaxExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5579:1: ( rule__MinMaxExpression__Group__3__Impl rule__MinMaxExpression__Group__4 )
            // InternalGT.g:5580:2: rule__MinMaxExpression__Group__3__Impl rule__MinMaxExpression__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__MinMaxExpression__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__3"


    // $ANTLR start "rule__MinMaxExpression__Group__3__Impl"
    // InternalGT.g:5587:1: rule__MinMaxExpression__Group__3__Impl : ( ( rule__MinMaxExpression__LeftAssignment_3 ) ) ;
    public final void rule__MinMaxExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5591:1: ( ( ( rule__MinMaxExpression__LeftAssignment_3 ) ) )
            // InternalGT.g:5592:1: ( ( rule__MinMaxExpression__LeftAssignment_3 ) )
            {
            // InternalGT.g:5592:1: ( ( rule__MinMaxExpression__LeftAssignment_3 ) )
            // InternalGT.g:5593:2: ( rule__MinMaxExpression__LeftAssignment_3 )
            {
             before(grammarAccess.getMinMaxExpressionAccess().getLeftAssignment_3()); 
            // InternalGT.g:5594:2: ( rule__MinMaxExpression__LeftAssignment_3 )
            // InternalGT.g:5594:3: rule__MinMaxExpression__LeftAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__LeftAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMinMaxExpressionAccess().getLeftAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__3__Impl"


    // $ANTLR start "rule__MinMaxExpression__Group__4"
    // InternalGT.g:5602:1: rule__MinMaxExpression__Group__4 : rule__MinMaxExpression__Group__4__Impl rule__MinMaxExpression__Group__5 ;
    public final void rule__MinMaxExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5606:1: ( rule__MinMaxExpression__Group__4__Impl rule__MinMaxExpression__Group__5 )
            // InternalGT.g:5607:2: rule__MinMaxExpression__Group__4__Impl rule__MinMaxExpression__Group__5
            {
            pushFollow(FOLLOW_17);
            rule__MinMaxExpression__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__4"


    // $ANTLR start "rule__MinMaxExpression__Group__4__Impl"
    // InternalGT.g:5614:1: rule__MinMaxExpression__Group__4__Impl : ( ',' ) ;
    public final void rule__MinMaxExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5618:1: ( ( ',' ) )
            // InternalGT.g:5619:1: ( ',' )
            {
            // InternalGT.g:5619:1: ( ',' )
            // InternalGT.g:5620:2: ','
            {
             before(grammarAccess.getMinMaxExpressionAccess().getCommaKeyword_4()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getMinMaxExpressionAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__4__Impl"


    // $ANTLR start "rule__MinMaxExpression__Group__5"
    // InternalGT.g:5629:1: rule__MinMaxExpression__Group__5 : rule__MinMaxExpression__Group__5__Impl rule__MinMaxExpression__Group__6 ;
    public final void rule__MinMaxExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5633:1: ( rule__MinMaxExpression__Group__5__Impl rule__MinMaxExpression__Group__6 )
            // InternalGT.g:5634:2: rule__MinMaxExpression__Group__5__Impl rule__MinMaxExpression__Group__6
            {
            pushFollow(FOLLOW_28);
            rule__MinMaxExpression__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__5"


    // $ANTLR start "rule__MinMaxExpression__Group__5__Impl"
    // InternalGT.g:5641:1: rule__MinMaxExpression__Group__5__Impl : ( ( rule__MinMaxExpression__RightAssignment_5 ) ) ;
    public final void rule__MinMaxExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5645:1: ( ( ( rule__MinMaxExpression__RightAssignment_5 ) ) )
            // InternalGT.g:5646:1: ( ( rule__MinMaxExpression__RightAssignment_5 ) )
            {
            // InternalGT.g:5646:1: ( ( rule__MinMaxExpression__RightAssignment_5 ) )
            // InternalGT.g:5647:2: ( rule__MinMaxExpression__RightAssignment_5 )
            {
             before(grammarAccess.getMinMaxExpressionAccess().getRightAssignment_5()); 
            // InternalGT.g:5648:2: ( rule__MinMaxExpression__RightAssignment_5 )
            // InternalGT.g:5648:3: rule__MinMaxExpression__RightAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__RightAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMinMaxExpressionAccess().getRightAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__5__Impl"


    // $ANTLR start "rule__MinMaxExpression__Group__6"
    // InternalGT.g:5656:1: rule__MinMaxExpression__Group__6 : rule__MinMaxExpression__Group__6__Impl ;
    public final void rule__MinMaxExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5660:1: ( rule__MinMaxExpression__Group__6__Impl )
            // InternalGT.g:5661:2: rule__MinMaxExpression__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MinMaxExpression__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__6"


    // $ANTLR start "rule__MinMaxExpression__Group__6__Impl"
    // InternalGT.g:5667:1: rule__MinMaxExpression__Group__6__Impl : ( ')' ) ;
    public final void rule__MinMaxExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5671:1: ( ( ')' ) )
            // InternalGT.g:5672:1: ( ')' )
            {
            // InternalGT.g:5672:1: ( ')' )
            // InternalGT.g:5673:2: ')'
            {
             before(grammarAccess.getMinMaxExpressionAccess().getRightParenthesisKeyword_6()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getMinMaxExpressionAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__Group__6__Impl"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__0"
    // InternalGT.g:5683:1: rule__OneParameterArithmetics__Group_0__0 : rule__OneParameterArithmetics__Group_0__0__Impl rule__OneParameterArithmetics__Group_0__1 ;
    public final void rule__OneParameterArithmetics__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5687:1: ( rule__OneParameterArithmetics__Group_0__0__Impl rule__OneParameterArithmetics__Group_0__1 )
            // InternalGT.g:5688:2: rule__OneParameterArithmetics__Group_0__0__Impl rule__OneParameterArithmetics__Group_0__1
            {
            pushFollow(FOLLOW_53);
            rule__OneParameterArithmetics__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__0"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__0__Impl"
    // InternalGT.g:5695:1: rule__OneParameterArithmetics__Group_0__0__Impl : ( () ) ;
    public final void rule__OneParameterArithmetics__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5699:1: ( ( () ) )
            // InternalGT.g:5700:1: ( () )
            {
            // InternalGT.g:5700:1: ( () )
            // InternalGT.g:5701:2: ()
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getOneParameterArithmeticsAction_0_0()); 
            // InternalGT.g:5702:2: ()
            // InternalGT.g:5702:3: 
            {
            }

             after(grammarAccess.getOneParameterArithmeticsAccess().getOneParameterArithmeticsAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__0__Impl"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__1"
    // InternalGT.g:5710:1: rule__OneParameterArithmetics__Group_0__1 : rule__OneParameterArithmetics__Group_0__1__Impl rule__OneParameterArithmetics__Group_0__2 ;
    public final void rule__OneParameterArithmetics__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5714:1: ( rule__OneParameterArithmetics__Group_0__1__Impl rule__OneParameterArithmetics__Group_0__2 )
            // InternalGT.g:5715:2: rule__OneParameterArithmetics__Group_0__1__Impl rule__OneParameterArithmetics__Group_0__2
            {
            pushFollow(FOLLOW_53);
            rule__OneParameterArithmetics__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__1"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__1__Impl"
    // InternalGT.g:5722:1: rule__OneParameterArithmetics__Group_0__1__Impl : ( ( rule__OneParameterArithmetics__NegativeAssignment_0_1 )? ) ;
    public final void rule__OneParameterArithmetics__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5726:1: ( ( ( rule__OneParameterArithmetics__NegativeAssignment_0_1 )? ) )
            // InternalGT.g:5727:1: ( ( rule__OneParameterArithmetics__NegativeAssignment_0_1 )? )
            {
            // InternalGT.g:5727:1: ( ( rule__OneParameterArithmetics__NegativeAssignment_0_1 )? )
            // InternalGT.g:5728:2: ( rule__OneParameterArithmetics__NegativeAssignment_0_1 )?
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getNegativeAssignment_0_1()); 
            // InternalGT.g:5729:2: ( rule__OneParameterArithmetics__NegativeAssignment_0_1 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==27) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalGT.g:5729:3: rule__OneParameterArithmetics__NegativeAssignment_0_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__OneParameterArithmetics__NegativeAssignment_0_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOneParameterArithmeticsAccess().getNegativeAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__1__Impl"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__2"
    // InternalGT.g:5737:1: rule__OneParameterArithmetics__Group_0__2 : rule__OneParameterArithmetics__Group_0__2__Impl rule__OneParameterArithmetics__Group_0__3 ;
    public final void rule__OneParameterArithmetics__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5741:1: ( rule__OneParameterArithmetics__Group_0__2__Impl rule__OneParameterArithmetics__Group_0__3 )
            // InternalGT.g:5742:2: rule__OneParameterArithmetics__Group_0__2__Impl rule__OneParameterArithmetics__Group_0__3
            {
            pushFollow(FOLLOW_53);
            rule__OneParameterArithmetics__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__2"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__2__Impl"
    // InternalGT.g:5749:1: rule__OneParameterArithmetics__Group_0__2__Impl : ( ( rule__OneParameterArithmetics__OperatorAssignment_0_2 )? ) ;
    public final void rule__OneParameterArithmetics__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5753:1: ( ( ( rule__OneParameterArithmetics__OperatorAssignment_0_2 )? ) )
            // InternalGT.g:5754:1: ( ( rule__OneParameterArithmetics__OperatorAssignment_0_2 )? )
            {
            // InternalGT.g:5754:1: ( ( rule__OneParameterArithmetics__OperatorAssignment_0_2 )? )
            // InternalGT.g:5755:2: ( rule__OneParameterArithmetics__OperatorAssignment_0_2 )?
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getOperatorAssignment_0_2()); 
            // InternalGT.g:5756:2: ( rule__OneParameterArithmetics__OperatorAssignment_0_2 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=36 && LA55_0<=43)) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalGT.g:5756:3: rule__OneParameterArithmetics__OperatorAssignment_0_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__OneParameterArithmetics__OperatorAssignment_0_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOneParameterArithmeticsAccess().getOperatorAssignment_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__2__Impl"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__3"
    // InternalGT.g:5764:1: rule__OneParameterArithmetics__Group_0__3 : rule__OneParameterArithmetics__Group_0__3__Impl rule__OneParameterArithmetics__Group_0__4 ;
    public final void rule__OneParameterArithmetics__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5768:1: ( rule__OneParameterArithmetics__Group_0__3__Impl rule__OneParameterArithmetics__Group_0__4 )
            // InternalGT.g:5769:2: rule__OneParameterArithmetics__Group_0__3__Impl rule__OneParameterArithmetics__Group_0__4
            {
            pushFollow(FOLLOW_17);
            rule__OneParameterArithmetics__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__Group_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__3"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__3__Impl"
    // InternalGT.g:5776:1: rule__OneParameterArithmetics__Group_0__3__Impl : ( '(' ) ;
    public final void rule__OneParameterArithmetics__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5780:1: ( ( '(' ) )
            // InternalGT.g:5781:1: ( '(' )
            {
            // InternalGT.g:5781:1: ( '(' )
            // InternalGT.g:5782:2: '('
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getLeftParenthesisKeyword_0_3()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getOneParameterArithmeticsAccess().getLeftParenthesisKeyword_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__3__Impl"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__4"
    // InternalGT.g:5791:1: rule__OneParameterArithmetics__Group_0__4 : rule__OneParameterArithmetics__Group_0__4__Impl rule__OneParameterArithmetics__Group_0__5 ;
    public final void rule__OneParameterArithmetics__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5795:1: ( rule__OneParameterArithmetics__Group_0__4__Impl rule__OneParameterArithmetics__Group_0__5 )
            // InternalGT.g:5796:2: rule__OneParameterArithmetics__Group_0__4__Impl rule__OneParameterArithmetics__Group_0__5
            {
            pushFollow(FOLLOW_28);
            rule__OneParameterArithmetics__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__Group_0__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__4"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__4__Impl"
    // InternalGT.g:5803:1: rule__OneParameterArithmetics__Group_0__4__Impl : ( ( rule__OneParameterArithmetics__ExpressionAssignment_0_4 ) ) ;
    public final void rule__OneParameterArithmetics__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5807:1: ( ( ( rule__OneParameterArithmetics__ExpressionAssignment_0_4 ) ) )
            // InternalGT.g:5808:1: ( ( rule__OneParameterArithmetics__ExpressionAssignment_0_4 ) )
            {
            // InternalGT.g:5808:1: ( ( rule__OneParameterArithmetics__ExpressionAssignment_0_4 ) )
            // InternalGT.g:5809:2: ( rule__OneParameterArithmetics__ExpressionAssignment_0_4 )
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getExpressionAssignment_0_4()); 
            // InternalGT.g:5810:2: ( rule__OneParameterArithmetics__ExpressionAssignment_0_4 )
            // InternalGT.g:5810:3: rule__OneParameterArithmetics__ExpressionAssignment_0_4
            {
            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__ExpressionAssignment_0_4();

            state._fsp--;


            }

             after(grammarAccess.getOneParameterArithmeticsAccess().getExpressionAssignment_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__4__Impl"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__5"
    // InternalGT.g:5818:1: rule__OneParameterArithmetics__Group_0__5 : rule__OneParameterArithmetics__Group_0__5__Impl ;
    public final void rule__OneParameterArithmetics__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5822:1: ( rule__OneParameterArithmetics__Group_0__5__Impl )
            // InternalGT.g:5823:2: rule__OneParameterArithmetics__Group_0__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OneParameterArithmetics__Group_0__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__5"


    // $ANTLR start "rule__OneParameterArithmetics__Group_0__5__Impl"
    // InternalGT.g:5829:1: rule__OneParameterArithmetics__Group_0__5__Impl : ( ')' ) ;
    public final void rule__OneParameterArithmetics__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5833:1: ( ( ')' ) )
            // InternalGT.g:5834:1: ( ')' )
            {
            // InternalGT.g:5834:1: ( ')' )
            // InternalGT.g:5835:2: ')'
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getRightParenthesisKeyword_0_5()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getOneParameterArithmeticsAccess().getRightParenthesisKeyword_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__Group_0__5__Impl"


    // $ANTLR start "rule__EditorGTFile__ImportsAssignment_0"
    // InternalGT.g:5845:1: rule__EditorGTFile__ImportsAssignment_0 : ( ruleEditorImport ) ;
    public final void rule__EditorGTFile__ImportsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5849:1: ( ( ruleEditorImport ) )
            // InternalGT.g:5850:2: ( ruleEditorImport )
            {
            // InternalGT.g:5850:2: ( ruleEditorImport )
            // InternalGT.g:5851:3: ruleEditorImport
            {
             before(grammarAccess.getEditorGTFileAccess().getImportsEditorImportParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorImport();

            state._fsp--;

             after(grammarAccess.getEditorGTFileAccess().getImportsEditorImportParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorGTFile__ImportsAssignment_0"


    // $ANTLR start "rule__EditorGTFile__PatternsAssignment_1_0"
    // InternalGT.g:5860:1: rule__EditorGTFile__PatternsAssignment_1_0 : ( ruleEditorPattern ) ;
    public final void rule__EditorGTFile__PatternsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5864:1: ( ( ruleEditorPattern ) )
            // InternalGT.g:5865:2: ( ruleEditorPattern )
            {
            // InternalGT.g:5865:2: ( ruleEditorPattern )
            // InternalGT.g:5866:3: ruleEditorPattern
            {
             before(grammarAccess.getEditorGTFileAccess().getPatternsEditorPatternParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorPattern();

            state._fsp--;

             after(grammarAccess.getEditorGTFileAccess().getPatternsEditorPatternParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorGTFile__PatternsAssignment_1_0"


    // $ANTLR start "rule__EditorGTFile__ConditionsAssignment_1_1"
    // InternalGT.g:5875:1: rule__EditorGTFile__ConditionsAssignment_1_1 : ( ruleEditorCondition ) ;
    public final void rule__EditorGTFile__ConditionsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5879:1: ( ( ruleEditorCondition ) )
            // InternalGT.g:5880:2: ( ruleEditorCondition )
            {
            // InternalGT.g:5880:2: ( ruleEditorCondition )
            // InternalGT.g:5881:3: ruleEditorCondition
            {
             before(grammarAccess.getEditorGTFileAccess().getConditionsEditorConditionParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorCondition();

            state._fsp--;

             after(grammarAccess.getEditorGTFileAccess().getConditionsEditorConditionParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorGTFile__ConditionsAssignment_1_1"


    // $ANTLR start "rule__EditorImport__NameAssignment_1"
    // InternalGT.g:5890:1: rule__EditorImport__NameAssignment_1 : ( RULE_STRING ) ;
    public final void rule__EditorImport__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5894:1: ( ( RULE_STRING ) )
            // InternalGT.g:5895:2: ( RULE_STRING )
            {
            // InternalGT.g:5895:2: ( RULE_STRING )
            // InternalGT.g:5896:3: RULE_STRING
            {
             before(grammarAccess.getEditorImportAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEditorImportAccess().getNameSTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorImport__NameAssignment_1"


    // $ANTLR start "rule__EditorPattern__AbstractAssignment_0"
    // InternalGT.g:5905:1: rule__EditorPattern__AbstractAssignment_0 : ( ( 'abstract' ) ) ;
    public final void rule__EditorPattern__AbstractAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5909:1: ( ( ( 'abstract' ) ) )
            // InternalGT.g:5910:2: ( ( 'abstract' ) )
            {
            // InternalGT.g:5910:2: ( ( 'abstract' ) )
            // InternalGT.g:5911:3: ( 'abstract' )
            {
             before(grammarAccess.getEditorPatternAccess().getAbstractAbstractKeyword_0_0()); 
            // InternalGT.g:5912:3: ( 'abstract' )
            // InternalGT.g:5913:4: 'abstract'
            {
             before(grammarAccess.getEditorPatternAccess().getAbstractAbstractKeyword_0_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getAbstractAbstractKeyword_0_0()); 

            }

             after(grammarAccess.getEditorPatternAccess().getAbstractAbstractKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__AbstractAssignment_0"


    // $ANTLR start "rule__EditorPattern__TypeAssignment_1"
    // InternalGT.g:5924:1: rule__EditorPattern__TypeAssignment_1 : ( ruleEditorPatternType ) ;
    public final void rule__EditorPattern__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5928:1: ( ( ruleEditorPatternType ) )
            // InternalGT.g:5929:2: ( ruleEditorPatternType )
            {
            // InternalGT.g:5929:2: ( ruleEditorPatternType )
            // InternalGT.g:5930:3: ruleEditorPatternType
            {
             before(grammarAccess.getEditorPatternAccess().getTypeEditorPatternTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorPatternType();

            state._fsp--;

             after(grammarAccess.getEditorPatternAccess().getTypeEditorPatternTypeEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__TypeAssignment_1"


    // $ANTLR start "rule__EditorPattern__NameAssignment_2"
    // InternalGT.g:5939:1: rule__EditorPattern__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EditorPattern__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5943:1: ( ( RULE_ID ) )
            // InternalGT.g:5944:2: ( RULE_ID )
            {
            // InternalGT.g:5944:2: ( RULE_ID )
            // InternalGT.g:5945:3: RULE_ID
            {
             before(grammarAccess.getEditorPatternAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__NameAssignment_2"


    // $ANTLR start "rule__EditorPattern__ParametersAssignment_3_1_0"
    // InternalGT.g:5954:1: rule__EditorPattern__ParametersAssignment_3_1_0 : ( ruleEditorParameter ) ;
    public final void rule__EditorPattern__ParametersAssignment_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5958:1: ( ( ruleEditorParameter ) )
            // InternalGT.g:5959:2: ( ruleEditorParameter )
            {
            // InternalGT.g:5959:2: ( ruleEditorParameter )
            // InternalGT.g:5960:3: ruleEditorParameter
            {
             before(grammarAccess.getEditorPatternAccess().getParametersEditorParameterParserRuleCall_3_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorParameter();

            state._fsp--;

             after(grammarAccess.getEditorPatternAccess().getParametersEditorParameterParserRuleCall_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__ParametersAssignment_3_1_0"


    // $ANTLR start "rule__EditorPattern__ParametersAssignment_3_1_1_1"
    // InternalGT.g:5969:1: rule__EditorPattern__ParametersAssignment_3_1_1_1 : ( ruleEditorParameter ) ;
    public final void rule__EditorPattern__ParametersAssignment_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5973:1: ( ( ruleEditorParameter ) )
            // InternalGT.g:5974:2: ( ruleEditorParameter )
            {
            // InternalGT.g:5974:2: ( ruleEditorParameter )
            // InternalGT.g:5975:3: ruleEditorParameter
            {
             before(grammarAccess.getEditorPatternAccess().getParametersEditorParameterParserRuleCall_3_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorParameter();

            state._fsp--;

             after(grammarAccess.getEditorPatternAccess().getParametersEditorParameterParserRuleCall_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__ParametersAssignment_3_1_1_1"


    // $ANTLR start "rule__EditorPattern__SuperPatternsAssignment_4_1"
    // InternalGT.g:5984:1: rule__EditorPattern__SuperPatternsAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorPattern__SuperPatternsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:5988:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:5989:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:5989:2: ( ( RULE_ID ) )
            // InternalGT.g:5990:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternCrossReference_4_1_0()); 
            // InternalGT.g:5991:3: ( RULE_ID )
            // InternalGT.g:5992:4: RULE_ID
            {
             before(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__SuperPatternsAssignment_4_1"


    // $ANTLR start "rule__EditorPattern__SuperPatternsAssignment_4_2_1"
    // InternalGT.g:6003:1: rule__EditorPattern__SuperPatternsAssignment_4_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorPattern__SuperPatternsAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6007:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6008:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6008:2: ( ( RULE_ID ) )
            // InternalGT.g:6009:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternCrossReference_4_2_1_0()); 
            // InternalGT.g:6010:3: ( RULE_ID )
            // InternalGT.g:6011:4: RULE_ID
            {
             before(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternIDTerminalRuleCall_4_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternIDTerminalRuleCall_4_2_1_0_1()); 

            }

             after(grammarAccess.getEditorPatternAccess().getSuperPatternsEditorPatternCrossReference_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__SuperPatternsAssignment_4_2_1"


    // $ANTLR start "rule__EditorPattern__NodesAssignment_5_1_0"
    // InternalGT.g:6022:1: rule__EditorPattern__NodesAssignment_5_1_0 : ( ruleEditorNode ) ;
    public final void rule__EditorPattern__NodesAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6026:1: ( ( ruleEditorNode ) )
            // InternalGT.g:6027:2: ( ruleEditorNode )
            {
            // InternalGT.g:6027:2: ( ruleEditorNode )
            // InternalGT.g:6028:3: ruleEditorNode
            {
             before(grammarAccess.getEditorPatternAccess().getNodesEditorNodeParserRuleCall_5_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorNode();

            state._fsp--;

             after(grammarAccess.getEditorPatternAccess().getNodesEditorNodeParserRuleCall_5_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__NodesAssignment_5_1_0"


    // $ANTLR start "rule__EditorPattern__AttributeConstraintsAssignment_5_1_1"
    // InternalGT.g:6037:1: rule__EditorPattern__AttributeConstraintsAssignment_5_1_1 : ( ruleEditorAttributeConstraint ) ;
    public final void rule__EditorPattern__AttributeConstraintsAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6041:1: ( ( ruleEditorAttributeConstraint ) )
            // InternalGT.g:6042:2: ( ruleEditorAttributeConstraint )
            {
            // InternalGT.g:6042:2: ( ruleEditorAttributeConstraint )
            // InternalGT.g:6043:3: ruleEditorAttributeConstraint
            {
             before(grammarAccess.getEditorPatternAccess().getAttributeConstraintsEditorAttributeConstraintParserRuleCall_5_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorAttributeConstraint();

            state._fsp--;

             after(grammarAccess.getEditorPatternAccess().getAttributeConstraintsEditorAttributeConstraintParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__AttributeConstraintsAssignment_5_1_1"


    // $ANTLR start "rule__EditorPattern__ConditionsAssignment_6_1"
    // InternalGT.g:6052:1: rule__EditorPattern__ConditionsAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorPattern__ConditionsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6056:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6057:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6057:2: ( ( RULE_ID ) )
            // InternalGT.g:6058:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionCrossReference_6_1_0()); 
            // InternalGT.g:6059:3: ( RULE_ID )
            // InternalGT.g:6060:4: RULE_ID
            {
             before(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__ConditionsAssignment_6_1"


    // $ANTLR start "rule__EditorPattern__ConditionsAssignment_6_2_1"
    // InternalGT.g:6071:1: rule__EditorPattern__ConditionsAssignment_6_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorPattern__ConditionsAssignment_6_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6075:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6076:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6076:2: ( ( RULE_ID ) )
            // InternalGT.g:6077:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionCrossReference_6_2_1_0()); 
            // InternalGT.g:6078:3: ( RULE_ID )
            // InternalGT.g:6079:4: RULE_ID
            {
             before(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionIDTerminalRuleCall_6_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionIDTerminalRuleCall_6_2_1_0_1()); 

            }

             after(grammarAccess.getEditorPatternAccess().getConditionsEditorConditionCrossReference_6_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__ConditionsAssignment_6_2_1"


    // $ANTLR start "rule__EditorPattern__StochasticAssignment_7_0"
    // InternalGT.g:6090:1: rule__EditorPattern__StochasticAssignment_7_0 : ( ( '@' ) ) ;
    public final void rule__EditorPattern__StochasticAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6094:1: ( ( ( '@' ) ) )
            // InternalGT.g:6095:2: ( ( '@' ) )
            {
            // InternalGT.g:6095:2: ( ( '@' ) )
            // InternalGT.g:6096:3: ( '@' )
            {
             before(grammarAccess.getEditorPatternAccess().getStochasticCommercialAtKeyword_7_0_0()); 
            // InternalGT.g:6097:3: ( '@' )
            // InternalGT.g:6098:4: '@'
            {
             before(grammarAccess.getEditorPatternAccess().getStochasticCommercialAtKeyword_7_0_0()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getEditorPatternAccess().getStochasticCommercialAtKeyword_7_0_0()); 

            }

             after(grammarAccess.getEditorPatternAccess().getStochasticCommercialAtKeyword_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__StochasticAssignment_7_0"


    // $ANTLR start "rule__EditorPattern__ProbabilityAssignment_7_1"
    // InternalGT.g:6109:1: rule__EditorPattern__ProbabilityAssignment_7_1 : ( ruleEditorProbability ) ;
    public final void rule__EditorPattern__ProbabilityAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6113:1: ( ( ruleEditorProbability ) )
            // InternalGT.g:6114:2: ( ruleEditorProbability )
            {
            // InternalGT.g:6114:2: ( ruleEditorProbability )
            // InternalGT.g:6115:3: ruleEditorProbability
            {
             before(grammarAccess.getEditorPatternAccess().getProbabilityEditorProbabilityParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorProbability();

            state._fsp--;

             after(grammarAccess.getEditorPatternAccess().getProbabilityEditorProbabilityParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorPattern__ProbabilityAssignment_7_1"


    // $ANTLR start "rule__EditorParameter__NameAssignment_0"
    // InternalGT.g:6124:1: rule__EditorParameter__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__EditorParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6128:1: ( ( RULE_ID ) )
            // InternalGT.g:6129:2: ( RULE_ID )
            {
            // InternalGT.g:6129:2: ( RULE_ID )
            // InternalGT.g:6130:3: RULE_ID
            {
             before(grammarAccess.getEditorParameterAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorParameterAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__NameAssignment_0"


    // $ANTLR start "rule__EditorParameter__TypeAssignment_2"
    // InternalGT.g:6139:1: rule__EditorParameter__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EditorParameter__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6143:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6144:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6144:2: ( ( RULE_ID ) )
            // InternalGT.g:6145:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorParameterAccess().getTypeEDataTypeCrossReference_2_0()); 
            // InternalGT.g:6146:3: ( RULE_ID )
            // InternalGT.g:6147:4: RULE_ID
            {
             before(grammarAccess.getEditorParameterAccess().getTypeEDataTypeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorParameterAccess().getTypeEDataTypeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getEditorParameterAccess().getTypeEDataTypeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameter__TypeAssignment_2"


    // $ANTLR start "rule__EditorNode__OperatorAssignment_0"
    // InternalGT.g:6158:1: rule__EditorNode__OperatorAssignment_0 : ( ruleEditorOperator ) ;
    public final void rule__EditorNode__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6162:1: ( ( ruleEditorOperator ) )
            // InternalGT.g:6163:2: ( ruleEditorOperator )
            {
            // InternalGT.g:6163:2: ( ruleEditorOperator )
            // InternalGT.g:6164:3: ruleEditorOperator
            {
             before(grammarAccess.getEditorNodeAccess().getOperatorEditorOperatorEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorOperator();

            state._fsp--;

             after(grammarAccess.getEditorNodeAccess().getOperatorEditorOperatorEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__OperatorAssignment_0"


    // $ANTLR start "rule__EditorNode__LocalAssignment_1"
    // InternalGT.g:6173:1: rule__EditorNode__LocalAssignment_1 : ( ( 'local' ) ) ;
    public final void rule__EditorNode__LocalAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6177:1: ( ( ( 'local' ) ) )
            // InternalGT.g:6178:2: ( ( 'local' ) )
            {
            // InternalGT.g:6178:2: ( ( 'local' ) )
            // InternalGT.g:6179:3: ( 'local' )
            {
             before(grammarAccess.getEditorNodeAccess().getLocalLocalKeyword_1_0()); 
            // InternalGT.g:6180:3: ( 'local' )
            // InternalGT.g:6181:4: 'local'
            {
             before(grammarAccess.getEditorNodeAccess().getLocalLocalKeyword_1_0()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getEditorNodeAccess().getLocalLocalKeyword_1_0()); 

            }

             after(grammarAccess.getEditorNodeAccess().getLocalLocalKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__LocalAssignment_1"


    // $ANTLR start "rule__EditorNode__NameAssignment_2"
    // InternalGT.g:6192:1: rule__EditorNode__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__EditorNode__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6196:1: ( ( RULE_ID ) )
            // InternalGT.g:6197:2: ( RULE_ID )
            {
            // InternalGT.g:6197:2: ( RULE_ID )
            // InternalGT.g:6198:3: RULE_ID
            {
             before(grammarAccess.getEditorNodeAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorNodeAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__NameAssignment_2"


    // $ANTLR start "rule__EditorNode__TypeAssignment_4"
    // InternalGT.g:6207:1: rule__EditorNode__TypeAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__EditorNode__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6211:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6212:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6212:2: ( ( RULE_ID ) )
            // InternalGT.g:6213:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorNodeAccess().getTypeEClassCrossReference_4_0()); 
            // InternalGT.g:6214:3: ( RULE_ID )
            // InternalGT.g:6215:4: RULE_ID
            {
             before(grammarAccess.getEditorNodeAccess().getTypeEClassIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorNodeAccess().getTypeEClassIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getEditorNodeAccess().getTypeEClassCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__TypeAssignment_4"


    // $ANTLR start "rule__EditorNode__AttributesAssignment_5_1_0"
    // InternalGT.g:6226:1: rule__EditorNode__AttributesAssignment_5_1_0 : ( ruleEditorAttributeAssignment ) ;
    public final void rule__EditorNode__AttributesAssignment_5_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6230:1: ( ( ruleEditorAttributeAssignment ) )
            // InternalGT.g:6231:2: ( ruleEditorAttributeAssignment )
            {
            // InternalGT.g:6231:2: ( ruleEditorAttributeAssignment )
            // InternalGT.g:6232:3: ruleEditorAttributeAssignment
            {
             before(grammarAccess.getEditorNodeAccess().getAttributesEditorAttributeAssignmentParserRuleCall_5_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorAttributeAssignment();

            state._fsp--;

             after(grammarAccess.getEditorNodeAccess().getAttributesEditorAttributeAssignmentParserRuleCall_5_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__AttributesAssignment_5_1_0"


    // $ANTLR start "rule__EditorNode__ReferencesAssignment_5_1_1"
    // InternalGT.g:6241:1: rule__EditorNode__ReferencesAssignment_5_1_1 : ( ruleEditorReference ) ;
    public final void rule__EditorNode__ReferencesAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6245:1: ( ( ruleEditorReference ) )
            // InternalGT.g:6246:2: ( ruleEditorReference )
            {
            // InternalGT.g:6246:2: ( ruleEditorReference )
            // InternalGT.g:6247:3: ruleEditorReference
            {
             before(grammarAccess.getEditorNodeAccess().getReferencesEditorReferenceParserRuleCall_5_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorReference();

            state._fsp--;

             after(grammarAccess.getEditorNodeAccess().getReferencesEditorReferenceParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__ReferencesAssignment_5_1_1"


    // $ANTLR start "rule__EditorNode__IteratorsAssignment_5_1_2"
    // InternalGT.g:6256:1: rule__EditorNode__IteratorsAssignment_5_1_2 : ( ruleEditorReferenceIterator ) ;
    public final void rule__EditorNode__IteratorsAssignment_5_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6260:1: ( ( ruleEditorReferenceIterator ) )
            // InternalGT.g:6261:2: ( ruleEditorReferenceIterator )
            {
            // InternalGT.g:6261:2: ( ruleEditorReferenceIterator )
            // InternalGT.g:6262:3: ruleEditorReferenceIterator
            {
             before(grammarAccess.getEditorNodeAccess().getIteratorsEditorReferenceIteratorParserRuleCall_5_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorReferenceIterator();

            state._fsp--;

             after(grammarAccess.getEditorNodeAccess().getIteratorsEditorReferenceIteratorParserRuleCall_5_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorNode__IteratorsAssignment_5_1_2"


    // $ANTLR start "rule__EditorAttributeConstraint__LhsAssignment_1"
    // InternalGT.g:6271:1: rule__EditorAttributeConstraint__LhsAssignment_1 : ( ruleEditorExpression ) ;
    public final void rule__EditorAttributeConstraint__LhsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6275:1: ( ( ruleEditorExpression ) )
            // InternalGT.g:6276:2: ( ruleEditorExpression )
            {
            // InternalGT.g:6276:2: ( ruleEditorExpression )
            // InternalGT.g:6277:3: ruleEditorExpression
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getLhsEditorExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorExpression();

            state._fsp--;

             after(grammarAccess.getEditorAttributeConstraintAccess().getLhsEditorExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__LhsAssignment_1"


    // $ANTLR start "rule__EditorAttributeConstraint__RelationAssignment_2"
    // InternalGT.g:6286:1: rule__EditorAttributeConstraint__RelationAssignment_2 : ( ruleEditorRelation ) ;
    public final void rule__EditorAttributeConstraint__RelationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6290:1: ( ( ruleEditorRelation ) )
            // InternalGT.g:6291:2: ( ruleEditorRelation )
            {
            // InternalGT.g:6291:2: ( ruleEditorRelation )
            // InternalGT.g:6292:3: ruleEditorRelation
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getRelationEditorRelationEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorRelation();

            state._fsp--;

             after(grammarAccess.getEditorAttributeConstraintAccess().getRelationEditorRelationEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__RelationAssignment_2"


    // $ANTLR start "rule__EditorAttributeConstraint__RhsAssignment_3"
    // InternalGT.g:6301:1: rule__EditorAttributeConstraint__RhsAssignment_3 : ( ruleEditorExpression ) ;
    public final void rule__EditorAttributeConstraint__RhsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6305:1: ( ( ruleEditorExpression ) )
            // InternalGT.g:6306:2: ( ruleEditorExpression )
            {
            // InternalGT.g:6306:2: ( ruleEditorExpression )
            // InternalGT.g:6307:3: ruleEditorExpression
            {
             before(grammarAccess.getEditorAttributeConstraintAccess().getRhsEditorExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorExpression();

            state._fsp--;

             after(grammarAccess.getEditorAttributeConstraintAccess().getRhsEditorExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeConstraint__RhsAssignment_3"


    // $ANTLR start "rule__EditorAttributeAssignment__AttributeAssignment_1"
    // InternalGT.g:6316:1: rule__EditorAttributeAssignment__AttributeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorAttributeAssignment__AttributeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6320:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6321:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6321:2: ( ( RULE_ID ) )
            // InternalGT.g:6322:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getAttributeEAttributeCrossReference_1_0()); 
            // InternalGT.g:6323:3: ( RULE_ID )
            // InternalGT.g:6324:4: RULE_ID
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getAttributeEAttributeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorAttributeAssignmentAccess().getAttributeEAttributeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEditorAttributeAssignmentAccess().getAttributeEAttributeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__AttributeAssignment_1"


    // $ANTLR start "rule__EditorAttributeAssignment__ValueAssignment_3"
    // InternalGT.g:6335:1: rule__EditorAttributeAssignment__ValueAssignment_3 : ( ruleEditorExpression ) ;
    public final void rule__EditorAttributeAssignment__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6339:1: ( ( ruleEditorExpression ) )
            // InternalGT.g:6340:2: ( ruleEditorExpression )
            {
            // InternalGT.g:6340:2: ( ruleEditorExpression )
            // InternalGT.g:6341:3: ruleEditorExpression
            {
             before(grammarAccess.getEditorAttributeAssignmentAccess().getValueEditorExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorExpression();

            state._fsp--;

             after(grammarAccess.getEditorAttributeAssignmentAccess().getValueEditorExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeAssignment__ValueAssignment_3"


    // $ANTLR start "rule__EditorAttributeExpression__NodeAssignment_0"
    // InternalGT.g:6350:1: rule__EditorAttributeExpression__NodeAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__EditorAttributeExpression__NodeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6354:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6355:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6355:2: ( ( RULE_ID ) )
            // InternalGT.g:6356:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getNodeEditorNodeCrossReference_0_0()); 
            // InternalGT.g:6357:3: ( RULE_ID )
            // InternalGT.g:6358:4: RULE_ID
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getNodeEditorNodeIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorAttributeExpressionAccess().getNodeEditorNodeIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getEditorAttributeExpressionAccess().getNodeEditorNodeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__NodeAssignment_0"


    // $ANTLR start "rule__EditorAttributeExpression__AttributeAssignment_2"
    // InternalGT.g:6369:1: rule__EditorAttributeExpression__AttributeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EditorAttributeExpression__AttributeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6373:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6374:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6374:2: ( ( RULE_ID ) )
            // InternalGT.g:6375:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getAttributeEAttributeCrossReference_2_0()); 
            // InternalGT.g:6376:3: ( RULE_ID )
            // InternalGT.g:6377:4: RULE_ID
            {
             before(grammarAccess.getEditorAttributeExpressionAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorAttributeExpressionAccess().getAttributeEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getEditorAttributeExpressionAccess().getAttributeEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorAttributeExpression__AttributeAssignment_2"


    // $ANTLR start "rule__EditorCountExpression__InvokedPattenAssignment_2"
    // InternalGT.g:6388:1: rule__EditorCountExpression__InvokedPattenAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EditorCountExpression__InvokedPattenAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6392:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6393:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6393:2: ( ( RULE_ID ) )
            // InternalGT.g:6394:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorCountExpressionAccess().getInvokedPattenEditorPatternCrossReference_2_0()); 
            // InternalGT.g:6395:3: ( RULE_ID )
            // InternalGT.g:6396:4: RULE_ID
            {
             before(grammarAccess.getEditorCountExpressionAccess().getInvokedPattenEditorPatternIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorCountExpressionAccess().getInvokedPattenEditorPatternIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getEditorCountExpressionAccess().getInvokedPattenEditorPatternCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCountExpression__InvokedPattenAssignment_2"


    // $ANTLR start "rule__EditorLiteralExpression__ValueAssignment_0"
    // InternalGT.g:6407:1: rule__EditorLiteralExpression__ValueAssignment_0 : ( ( rule__EditorLiteralExpression__ValueAlternatives_0_0 ) ) ;
    public final void rule__EditorLiteralExpression__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6411:1: ( ( ( rule__EditorLiteralExpression__ValueAlternatives_0_0 ) ) )
            // InternalGT.g:6412:2: ( ( rule__EditorLiteralExpression__ValueAlternatives_0_0 ) )
            {
            // InternalGT.g:6412:2: ( ( rule__EditorLiteralExpression__ValueAlternatives_0_0 ) )
            // InternalGT.g:6413:3: ( rule__EditorLiteralExpression__ValueAlternatives_0_0 )
            {
             before(grammarAccess.getEditorLiteralExpressionAccess().getValueAlternatives_0_0()); 
            // InternalGT.g:6414:3: ( rule__EditorLiteralExpression__ValueAlternatives_0_0 )
            // InternalGT.g:6414:4: rule__EditorLiteralExpression__ValueAlternatives_0_0
            {
            pushFollow(FOLLOW_2);
            rule__EditorLiteralExpression__ValueAlternatives_0_0();

            state._fsp--;


            }

             after(grammarAccess.getEditorLiteralExpressionAccess().getValueAlternatives_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorLiteralExpression__ValueAssignment_0"


    // $ANTLR start "rule__EditorLiteralExpression__ValueAssignment_1_1"
    // InternalGT.g:6422:1: rule__EditorLiteralExpression__ValueAssignment_1_1 : ( RULE_STRING ) ;
    public final void rule__EditorLiteralExpression__ValueAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6426:1: ( ( RULE_STRING ) )
            // InternalGT.g:6427:2: ( RULE_STRING )
            {
            // InternalGT.g:6427:2: ( RULE_STRING )
            // InternalGT.g:6428:3: RULE_STRING
            {
             before(grammarAccess.getEditorLiteralExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getEditorLiteralExpressionAccess().getValueSTRINGTerminalRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorLiteralExpression__ValueAssignment_1_1"


    // $ANTLR start "rule__EditorEnumExpression__LiteralAssignment_1"
    // InternalGT.g:6437:1: rule__EditorEnumExpression__LiteralAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorEnumExpression__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6441:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6442:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6442:2: ( ( RULE_ID ) )
            // InternalGT.g:6443:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorEnumExpressionAccess().getLiteralEEnumLiteralCrossReference_1_0()); 
            // InternalGT.g:6444:3: ( RULE_ID )
            // InternalGT.g:6445:4: RULE_ID
            {
             before(grammarAccess.getEditorEnumExpressionAccess().getLiteralEEnumLiteralIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorEnumExpressionAccess().getLiteralEEnumLiteralIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEditorEnumExpressionAccess().getLiteralEEnumLiteralCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorEnumExpression__LiteralAssignment_1"


    // $ANTLR start "rule__EditorParameterExpression__ParameterAssignment_1"
    // InternalGT.g:6456:1: rule__EditorParameterExpression__ParameterAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorParameterExpression__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6460:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6461:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6461:2: ( ( RULE_ID ) )
            // InternalGT.g:6462:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorParameterExpressionAccess().getParameterEditorParameterCrossReference_1_0()); 
            // InternalGT.g:6463:3: ( RULE_ID )
            // InternalGT.g:6464:4: RULE_ID
            {
             before(grammarAccess.getEditorParameterExpressionAccess().getParameterEditorParameterIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorParameterExpressionAccess().getParameterEditorParameterIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEditorParameterExpressionAccess().getParameterEditorParameterCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorParameterExpression__ParameterAssignment_1"


    // $ANTLR start "rule__EditorReference__OperatorAssignment_0"
    // InternalGT.g:6475:1: rule__EditorReference__OperatorAssignment_0 : ( ruleEditorOperator ) ;
    public final void rule__EditorReference__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6479:1: ( ( ruleEditorOperator ) )
            // InternalGT.g:6480:2: ( ruleEditorOperator )
            {
            // InternalGT.g:6480:2: ( ruleEditorOperator )
            // InternalGT.g:6481:3: ruleEditorOperator
            {
             before(grammarAccess.getEditorReferenceAccess().getOperatorEditorOperatorEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorOperator();

            state._fsp--;

             after(grammarAccess.getEditorReferenceAccess().getOperatorEditorOperatorEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__OperatorAssignment_0"


    // $ANTLR start "rule__EditorReference__TypeAssignment_2"
    // InternalGT.g:6490:1: rule__EditorReference__TypeAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__EditorReference__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6494:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6495:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6495:2: ( ( RULE_ID ) )
            // InternalGT.g:6496:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorReferenceAccess().getTypeEReferenceCrossReference_2_0()); 
            // InternalGT.g:6497:3: ( RULE_ID )
            // InternalGT.g:6498:4: RULE_ID
            {
             before(grammarAccess.getEditorReferenceAccess().getTypeEReferenceIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceAccess().getTypeEReferenceIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getEditorReferenceAccess().getTypeEReferenceCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__TypeAssignment_2"


    // $ANTLR start "rule__EditorReference__TargetAssignment_4"
    // InternalGT.g:6509:1: rule__EditorReference__TargetAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__EditorReference__TargetAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6513:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6514:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6514:2: ( ( RULE_ID ) )
            // InternalGT.g:6515:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorReferenceAccess().getTargetEditorNodeCrossReference_4_0()); 
            // InternalGT.g:6516:3: ( RULE_ID )
            // InternalGT.g:6517:4: RULE_ID
            {
             before(grammarAccess.getEditorReferenceAccess().getTargetEditorNodeIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceAccess().getTargetEditorNodeIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getEditorReferenceAccess().getTargetEditorNodeCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReference__TargetAssignment_4"


    // $ANTLR start "rule__EditorReferenceIterator__TypeAssignment_1"
    // InternalGT.g:6528:1: rule__EditorReferenceIterator__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorReferenceIterator__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6532:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6533:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6533:2: ( ( RULE_ID ) )
            // InternalGT.g:6534:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getTypeEReferenceCrossReference_1_0()); 
            // InternalGT.g:6535:3: ( RULE_ID )
            // InternalGT.g:6536:4: RULE_ID
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getTypeEReferenceIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getTypeEReferenceIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getTypeEReferenceCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__TypeAssignment_1"


    // $ANTLR start "rule__EditorReferenceIterator__NameAssignment_3"
    // InternalGT.g:6547:1: rule__EditorReferenceIterator__NameAssignment_3 : ( RULE_ID ) ;
    public final void rule__EditorReferenceIterator__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6551:1: ( ( RULE_ID ) )
            // InternalGT.g:6552:2: ( RULE_ID )
            {
            // InternalGT.g:6552:2: ( RULE_ID )
            // InternalGT.g:6553:3: RULE_ID
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getNameIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getNameIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__NameAssignment_3"


    // $ANTLR start "rule__EditorReferenceIterator__SubTypeAssignment_4_1"
    // InternalGT.g:6562:1: rule__EditorReferenceIterator__SubTypeAssignment_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorReferenceIterator__SubTypeAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6566:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6567:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6567:2: ( ( RULE_ID ) )
            // InternalGT.g:6568:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getSubTypeEClassCrossReference_4_1_0()); 
            // InternalGT.g:6569:3: ( RULE_ID )
            // InternalGT.g:6570:4: RULE_ID
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getSubTypeEClassIDTerminalRuleCall_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorReferenceIteratorAccess().getSubTypeEClassIDTerminalRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getEditorReferenceIteratorAccess().getSubTypeEClassCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__SubTypeAssignment_4_1"


    // $ANTLR start "rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0"
    // InternalGT.g:6581:1: rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0 : ( ruleEditorIteratorAttributeAssignment ) ;
    public final void rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6585:1: ( ( ruleEditorIteratorAttributeAssignment ) )
            // InternalGT.g:6586:2: ( ruleEditorIteratorAttributeAssignment )
            {
            // InternalGT.g:6586:2: ( ruleEditorIteratorAttributeAssignment )
            // InternalGT.g:6587:3: ruleEditorIteratorAttributeAssignment
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getIteratorAttributesEditorIteratorAttributeAssignmentParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorIteratorAttributeAssignment();

            state._fsp--;

             after(grammarAccess.getEditorReferenceIteratorAccess().getIteratorAttributesEditorIteratorAttributeAssignmentParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__IteratorAttributesAssignment_6_0"


    // $ANTLR start "rule__EditorReferenceIterator__ReferencesAssignment_6_1"
    // InternalGT.g:6596:1: rule__EditorReferenceIterator__ReferencesAssignment_6_1 : ( ruleEditorIteratorReference ) ;
    public final void rule__EditorReferenceIterator__ReferencesAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6600:1: ( ( ruleEditorIteratorReference ) )
            // InternalGT.g:6601:2: ( ruleEditorIteratorReference )
            {
            // InternalGT.g:6601:2: ( ruleEditorIteratorReference )
            // InternalGT.g:6602:3: ruleEditorIteratorReference
            {
             before(grammarAccess.getEditorReferenceIteratorAccess().getReferencesEditorIteratorReferenceParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorIteratorReference();

            state._fsp--;

             after(grammarAccess.getEditorReferenceIteratorAccess().getReferencesEditorIteratorReferenceParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorReferenceIterator__ReferencesAssignment_6_1"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__IteratorAssignment_1"
    // InternalGT.g:6611:1: rule__EditorIteratorAttributeExpression__IteratorAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorIteratorAttributeExpression__IteratorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6615:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6616:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6616:2: ( ( RULE_ID ) )
            // InternalGT.g:6617:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorEditorReferenceIteratorCrossReference_1_0()); 
            // InternalGT.g:6618:3: ( RULE_ID )
            // InternalGT.g:6619:4: RULE_ID
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorEditorReferenceIteratorIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorEditorReferenceIteratorIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getIteratorEditorReferenceIteratorCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__IteratorAssignment_1"


    // $ANTLR start "rule__EditorIteratorAttributeExpression__AttributeAssignment_3"
    // InternalGT.g:6630:1: rule__EditorIteratorAttributeExpression__AttributeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__EditorIteratorAttributeExpression__AttributeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6634:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6635:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6635:2: ( ( RULE_ID ) )
            // InternalGT.g:6636:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeEAttributeCrossReference_3_0()); 
            // InternalGT.g:6637:3: ( RULE_ID )
            // InternalGT.g:6638:4: RULE_ID
            {
             before(grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeEAttributeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeEAttributeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getEditorIteratorAttributeExpressionAccess().getAttributeEAttributeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeExpression__AttributeAssignment_3"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0"
    // InternalGT.g:6649:1: rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0 : ( ruleEditorIteratorAttributeExpression ) ;
    public final void rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6653:1: ( ( ruleEditorIteratorAttributeExpression ) )
            // InternalGT.g:6654:2: ( ruleEditorIteratorAttributeExpression )
            {
            // InternalGT.g:6654:2: ( ruleEditorIteratorAttributeExpression )
            // InternalGT.g:6655:3: ruleEditorIteratorAttributeExpression
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getIteratorAttributeEditorIteratorAttributeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorIteratorAttributeExpression();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getIteratorAttributeEditorIteratorAttributeExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__IteratorAttributeAssignment_0"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2"
    // InternalGT.g:6664:1: rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2 : ( ruleEditorExpression ) ;
    public final void rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6668:1: ( ( ruleEditorExpression ) )
            // InternalGT.g:6669:2: ( ruleEditorExpression )
            {
            // InternalGT.g:6669:2: ( ruleEditorExpression )
            // InternalGT.g:6670:3: ruleEditorExpression
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getValueEditorExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorExpression();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeAssignmentItrAccess().getValueEditorExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentItr__ValueAssignment_2"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0"
    // InternalGT.g:6679:1: rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0 : ( ruleEditorAttributeExpression ) ;
    public final void rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6683:1: ( ( ruleEditorAttributeExpression ) )
            // InternalGT.g:6684:2: ( ruleEditorAttributeExpression )
            {
            // InternalGT.g:6684:2: ( ruleEditorAttributeExpression )
            // InternalGT.g:6685:3: ruleEditorAttributeExpression
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getNodeAttributeEditorAttributeExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorAttributeExpression();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getNodeAttributeEditorAttributeExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__NodeAttributeAssignment_0"


    // $ANTLR start "rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2"
    // InternalGT.g:6694:1: rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2 : ( ruleEditorExpression ) ;
    public final void rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6698:1: ( ( ruleEditorExpression ) )
            // InternalGT.g:6699:2: ( ruleEditorExpression )
            {
            // InternalGT.g:6699:2: ( ruleEditorExpression )
            // InternalGT.g:6700:3: ruleEditorExpression
            {
             before(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getValueEditorExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorExpression();

            state._fsp--;

             after(grammarAccess.getEditorIteratorAttributeAssignmentNodeAccess().getValueEditorExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorAttributeAssignmentNode__ValueAssignment_2"


    // $ANTLR start "rule__EditorIteratorReference__OperatorAssignment_0"
    // InternalGT.g:6709:1: rule__EditorIteratorReference__OperatorAssignment_0 : ( ruleEditorOperator ) ;
    public final void rule__EditorIteratorReference__OperatorAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6713:1: ( ( ruleEditorOperator ) )
            // InternalGT.g:6714:2: ( ruleEditorOperator )
            {
            // InternalGT.g:6714:2: ( ruleEditorOperator )
            // InternalGT.g:6715:3: ruleEditorOperator
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getOperatorEditorOperatorEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorOperator();

            state._fsp--;

             after(grammarAccess.getEditorIteratorReferenceAccess().getOperatorEditorOperatorEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__OperatorAssignment_0"


    // $ANTLR start "rule__EditorIteratorReference__SourceAssignment_1"
    // InternalGT.g:6724:1: rule__EditorIteratorReference__SourceAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorIteratorReference__SourceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6728:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6729:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6729:2: ( ( RULE_ID ) )
            // InternalGT.g:6730:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getSourceEditorNodeCrossReference_1_0()); 
            // InternalGT.g:6731:3: ( RULE_ID )
            // InternalGT.g:6732:4: RULE_ID
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getSourceEditorNodeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorReferenceAccess().getSourceEditorNodeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getSourceEditorNodeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__SourceAssignment_1"


    // $ANTLR start "rule__EditorIteratorReference__TypeAssignment_3"
    // InternalGT.g:6743:1: rule__EditorIteratorReference__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__EditorIteratorReference__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6747:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6748:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6748:2: ( ( RULE_ID ) )
            // InternalGT.g:6749:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getTypeEReferenceCrossReference_3_0()); 
            // InternalGT.g:6750:3: ( RULE_ID )
            // InternalGT.g:6751:4: RULE_ID
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getTypeEReferenceIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorReferenceAccess().getTypeEReferenceIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getTypeEReferenceCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__TypeAssignment_3"


    // $ANTLR start "rule__EditorIteratorReference__TargetAssignment_5"
    // InternalGT.g:6762:1: rule__EditorIteratorReference__TargetAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__EditorIteratorReference__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6766:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6767:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6767:2: ( ( RULE_ID ) )
            // InternalGT.g:6768:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getTargetEditorReferenceIteratorCrossReference_5_0()); 
            // InternalGT.g:6769:3: ( RULE_ID )
            // InternalGT.g:6770:4: RULE_ID
            {
             before(grammarAccess.getEditorIteratorReferenceAccess().getTargetEditorReferenceIteratorIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorIteratorReferenceAccess().getTargetEditorReferenceIteratorIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getEditorIteratorReferenceAccess().getTargetEditorReferenceIteratorCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorIteratorReference__TargetAssignment_5"


    // $ANTLR start "rule__EditorCondition__NameAssignment_1"
    // InternalGT.g:6781:1: rule__EditorCondition__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__EditorCondition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6785:1: ( ( RULE_ID ) )
            // InternalGT.g:6786:2: ( RULE_ID )
            {
            // InternalGT.g:6786:2: ( RULE_ID )
            // InternalGT.g:6787:3: RULE_ID
            {
             before(grammarAccess.getEditorConditionAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorConditionAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__NameAssignment_1"


    // $ANTLR start "rule__EditorCondition__ConditionsAssignment_3"
    // InternalGT.g:6796:1: rule__EditorCondition__ConditionsAssignment_3 : ( ruleEditorSimpleCondition ) ;
    public final void rule__EditorCondition__ConditionsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6800:1: ( ( ruleEditorSimpleCondition ) )
            // InternalGT.g:6801:2: ( ruleEditorSimpleCondition )
            {
            // InternalGT.g:6801:2: ( ruleEditorSimpleCondition )
            // InternalGT.g:6802:3: ruleEditorSimpleCondition
            {
             before(grammarAccess.getEditorConditionAccess().getConditionsEditorSimpleConditionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorSimpleCondition();

            state._fsp--;

             after(grammarAccess.getEditorConditionAccess().getConditionsEditorSimpleConditionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__ConditionsAssignment_3"


    // $ANTLR start "rule__EditorCondition__ConditionsAssignment_4_1"
    // InternalGT.g:6811:1: rule__EditorCondition__ConditionsAssignment_4_1 : ( ruleEditorSimpleCondition ) ;
    public final void rule__EditorCondition__ConditionsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6815:1: ( ( ruleEditorSimpleCondition ) )
            // InternalGT.g:6816:2: ( ruleEditorSimpleCondition )
            {
            // InternalGT.g:6816:2: ( ruleEditorSimpleCondition )
            // InternalGT.g:6817:3: ruleEditorSimpleCondition
            {
             before(grammarAccess.getEditorConditionAccess().getConditionsEditorSimpleConditionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorSimpleCondition();

            state._fsp--;

             after(grammarAccess.getEditorConditionAccess().getConditionsEditorSimpleConditionParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorCondition__ConditionsAssignment_4_1"


    // $ANTLR start "rule__EditorSimpleCondition__ConditionAssignment_0_1"
    // InternalGT.g:6826:1: rule__EditorSimpleCondition__ConditionAssignment_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__EditorSimpleCondition__ConditionAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6830:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6831:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6831:2: ( ( RULE_ID ) )
            // InternalGT.g:6832:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getConditionEditorConditionCrossReference_0_1_0()); 
            // InternalGT.g:6833:3: ( RULE_ID )
            // InternalGT.g:6834:4: RULE_ID
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getConditionEditorConditionIDTerminalRuleCall_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorSimpleConditionAccess().getConditionEditorConditionIDTerminalRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getEditorSimpleConditionAccess().getConditionEditorConditionCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__ConditionAssignment_0_1"


    // $ANTLR start "rule__EditorSimpleCondition__TypeAssignment_1_1"
    // InternalGT.g:6845:1: rule__EditorSimpleCondition__TypeAssignment_1_1 : ( ruleEditorApplicationConditionType ) ;
    public final void rule__EditorSimpleCondition__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6849:1: ( ( ruleEditorApplicationConditionType ) )
            // InternalGT.g:6850:2: ( ruleEditorApplicationConditionType )
            {
            // InternalGT.g:6850:2: ( ruleEditorApplicationConditionType )
            // InternalGT.g:6851:3: ruleEditorApplicationConditionType
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getTypeEditorApplicationConditionTypeEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEditorApplicationConditionType();

            state._fsp--;

             after(grammarAccess.getEditorSimpleConditionAccess().getTypeEditorApplicationConditionTypeEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__TypeAssignment_1_1"


    // $ANTLR start "rule__EditorSimpleCondition__PatternAssignment_1_2"
    // InternalGT.g:6860:1: rule__EditorSimpleCondition__PatternAssignment_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__EditorSimpleCondition__PatternAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6864:1: ( ( ( RULE_ID ) ) )
            // InternalGT.g:6865:2: ( ( RULE_ID ) )
            {
            // InternalGT.g:6865:2: ( ( RULE_ID ) )
            // InternalGT.g:6866:3: ( RULE_ID )
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getPatternEditorPatternCrossReference_1_2_0()); 
            // InternalGT.g:6867:3: ( RULE_ID )
            // InternalGT.g:6868:4: RULE_ID
            {
             before(grammarAccess.getEditorSimpleConditionAccess().getPatternEditorPatternIDTerminalRuleCall_1_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEditorSimpleConditionAccess().getPatternEditorPatternIDTerminalRuleCall_1_2_0_1()); 

            }

             after(grammarAccess.getEditorSimpleConditionAccess().getPatternEditorPatternCrossReference_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EditorSimpleCondition__PatternAssignment_1_2"


    // $ANTLR start "rule__StochasticFunction__FunctionExpressionAssignment_0"
    // InternalGT.g:6879:1: rule__StochasticFunction__FunctionExpressionAssignment_0 : ( ruleStochasticFunctionExpression ) ;
    public final void rule__StochasticFunction__FunctionExpressionAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6883:1: ( ( ruleStochasticFunctionExpression ) )
            // InternalGT.g:6884:2: ( ruleStochasticFunctionExpression )
            {
            // InternalGT.g:6884:2: ( ruleStochasticFunctionExpression )
            // InternalGT.g:6885:3: ruleStochasticFunctionExpression
            {
             before(grammarAccess.getStochasticFunctionAccess().getFunctionExpressionStochasticFunctionExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleStochasticFunctionExpression();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionAccess().getFunctionExpressionStochasticFunctionExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunction__FunctionExpressionAssignment_0"


    // $ANTLR start "rule__StochasticFunction__ParameterAssignment_1"
    // InternalGT.g:6894:1: rule__StochasticFunction__ParameterAssignment_1 : ( ruleArithmeticExpression ) ;
    public final void rule__StochasticFunction__ParameterAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6898:1: ( ( ruleArithmeticExpression ) )
            // InternalGT.g:6899:2: ( ruleArithmeticExpression )
            {
            // InternalGT.g:6899:2: ( ruleArithmeticExpression )
            // InternalGT.g:6900:3: ruleArithmeticExpression
            {
             before(grammarAccess.getStochasticFunctionAccess().getParameterArithmeticExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionAccess().getParameterArithmeticExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunction__ParameterAssignment_1"


    // $ANTLR start "rule__StochasticFunctionExpression__OperatorRangeAssignment_0"
    // InternalGT.g:6909:1: rule__StochasticFunctionExpression__OperatorRangeAssignment_0 : ( ruleStochasticRange ) ;
    public final void rule__StochasticFunctionExpression__OperatorRangeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6913:1: ( ( ruleStochasticRange ) )
            // InternalGT.g:6914:2: ( ruleStochasticRange )
            {
            // InternalGT.g:6914:2: ( ruleStochasticRange )
            // InternalGT.g:6915:3: ruleStochasticRange
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getOperatorRangeStochasticRangeEnumRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleStochasticRange();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionExpressionAccess().getOperatorRangeStochasticRangeEnumRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__OperatorRangeAssignment_0"


    // $ANTLR start "rule__StochasticFunctionExpression__DistributionAssignment_1"
    // InternalGT.g:6924:1: rule__StochasticFunctionExpression__DistributionAssignment_1 : ( ruleStochasticDistribution ) ;
    public final void rule__StochasticFunctionExpression__DistributionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6928:1: ( ( ruleStochasticDistribution ) )
            // InternalGT.g:6929:2: ( ruleStochasticDistribution )
            {
            // InternalGT.g:6929:2: ( ruleStochasticDistribution )
            // InternalGT.g:6930:3: ruleStochasticDistribution
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getDistributionStochasticDistributionEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleStochasticDistribution();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionExpressionAccess().getDistributionStochasticDistributionEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__DistributionAssignment_1"


    // $ANTLR start "rule__StochasticFunctionExpression__MeanAssignment_3"
    // InternalGT.g:6939:1: rule__StochasticFunctionExpression__MeanAssignment_3 : ( ruleArithmeticExpression ) ;
    public final void rule__StochasticFunctionExpression__MeanAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6943:1: ( ( ruleArithmeticExpression ) )
            // InternalGT.g:6944:2: ( ruleArithmeticExpression )
            {
            // InternalGT.g:6944:2: ( ruleArithmeticExpression )
            // InternalGT.g:6945:3: ruleArithmeticExpression
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getMeanArithmeticExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionExpressionAccess().getMeanArithmeticExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__MeanAssignment_3"


    // $ANTLR start "rule__StochasticFunctionExpression__HasSdAssignment_4_0"
    // InternalGT.g:6954:1: rule__StochasticFunctionExpression__HasSdAssignment_4_0 : ( ( ',' ) ) ;
    public final void rule__StochasticFunctionExpression__HasSdAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6958:1: ( ( ( ',' ) ) )
            // InternalGT.g:6959:2: ( ( ',' ) )
            {
            // InternalGT.g:6959:2: ( ( ',' ) )
            // InternalGT.g:6960:3: ( ',' )
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getHasSdCommaKeyword_4_0_0()); 
            // InternalGT.g:6961:3: ( ',' )
            // InternalGT.g:6962:4: ','
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getHasSdCommaKeyword_4_0_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getStochasticFunctionExpressionAccess().getHasSdCommaKeyword_4_0_0()); 

            }

             after(grammarAccess.getStochasticFunctionExpressionAccess().getHasSdCommaKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__HasSdAssignment_4_0"


    // $ANTLR start "rule__StochasticFunctionExpression__SdAssignment_4_1"
    // InternalGT.g:6973:1: rule__StochasticFunctionExpression__SdAssignment_4_1 : ( ruleArithmeticExpression ) ;
    public final void rule__StochasticFunctionExpression__SdAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6977:1: ( ( ruleArithmeticExpression ) )
            // InternalGT.g:6978:2: ( ruleArithmeticExpression )
            {
            // InternalGT.g:6978:2: ( ruleArithmeticExpression )
            // InternalGT.g:6979:3: ruleArithmeticExpression
            {
             before(grammarAccess.getStochasticFunctionExpressionAccess().getSdArithmeticExpressionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getStochasticFunctionExpressionAccess().getSdArithmeticExpressionParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StochasticFunctionExpression__SdAssignment_4_1"


    // $ANTLR start "rule__ArithmeticCalculationExpression__ExpressionAssignment"
    // InternalGT.g:6988:1: rule__ArithmeticCalculationExpression__ExpressionAssignment : ( ruleArithmeticExpression ) ;
    public final void rule__ArithmeticCalculationExpression__ExpressionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:6992:1: ( ( ruleArithmeticExpression ) )
            // InternalGT.g:6993:2: ( ruleArithmeticExpression )
            {
            // InternalGT.g:6993:2: ( ruleArithmeticExpression )
            // InternalGT.g:6994:3: ruleArithmeticExpression
            {
             before(grammarAccess.getArithmeticCalculationExpressionAccess().getExpressionArithmeticExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getArithmeticCalculationExpressionAccess().getExpressionArithmeticExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArithmeticCalculationExpression__ExpressionAssignment"


    // $ANTLR start "rule__AddExpression__AddOperatorAssignment_1_1"
    // InternalGT.g:7003:1: rule__AddExpression__AddOperatorAssignment_1_1 : ( ruleAddOperator ) ;
    public final void rule__AddExpression__AddOperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7007:1: ( ( ruleAddOperator ) )
            // InternalGT.g:7008:2: ( ruleAddOperator )
            {
            // InternalGT.g:7008:2: ( ruleAddOperator )
            // InternalGT.g:7009:3: ruleAddOperator
            {
             before(grammarAccess.getAddExpressionAccess().getAddOperatorAddOperatorEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAddOperator();

            state._fsp--;

             after(grammarAccess.getAddExpressionAccess().getAddOperatorAddOperatorEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__AddOperatorAssignment_1_1"


    // $ANTLR start "rule__AddExpression__RightAssignment_1_2"
    // InternalGT.g:7018:1: rule__AddExpression__RightAssignment_1_2 : ( ruleMultExpression ) ;
    public final void rule__AddExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7022:1: ( ( ruleMultExpression ) )
            // InternalGT.g:7023:2: ( ruleMultExpression )
            {
            // InternalGT.g:7023:2: ( ruleMultExpression )
            // InternalGT.g:7024:3: ruleMultExpression
            {
             before(grammarAccess.getAddExpressionAccess().getRightMultExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMultExpression();

            state._fsp--;

             after(grammarAccess.getAddExpressionAccess().getRightMultExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AddExpression__RightAssignment_1_2"


    // $ANTLR start "rule__MultExpression__MultOperatorAssignment_1_1"
    // InternalGT.g:7033:1: rule__MultExpression__MultOperatorAssignment_1_1 : ( ruleMultOperator ) ;
    public final void rule__MultExpression__MultOperatorAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7037:1: ( ( ruleMultOperator ) )
            // InternalGT.g:7038:2: ( ruleMultOperator )
            {
            // InternalGT.g:7038:2: ( ruleMultOperator )
            // InternalGT.g:7039:3: ruleMultOperator
            {
             before(grammarAccess.getMultExpressionAccess().getMultOperatorMultOperatorEnumRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMultOperator();

            state._fsp--;

             after(grammarAccess.getMultExpressionAccess().getMultOperatorMultOperatorEnumRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__MultOperatorAssignment_1_1"


    // $ANTLR start "rule__MultExpression__RightAssignment_1_2"
    // InternalGT.g:7048:1: rule__MultExpression__RightAssignment_1_2 : ( ruleExpExpression ) ;
    public final void rule__MultExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7052:1: ( ( ruleExpExpression ) )
            // InternalGT.g:7053:2: ( ruleExpExpression )
            {
            // InternalGT.g:7053:2: ( ruleExpExpression )
            // InternalGT.g:7054:3: ruleExpExpression
            {
             before(grammarAccess.getMultExpressionAccess().getRightExpExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpExpression();

            state._fsp--;

             after(grammarAccess.getMultExpressionAccess().getRightExpExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultExpression__RightAssignment_1_2"


    // $ANTLR start "rule__ExpExpression__RightAssignment_1_2"
    // InternalGT.g:7063:1: rule__ExpExpression__RightAssignment_1_2 : ( ( rule__ExpExpression__RightAlternatives_1_2_0 ) ) ;
    public final void rule__ExpExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7067:1: ( ( ( rule__ExpExpression__RightAlternatives_1_2_0 ) ) )
            // InternalGT.g:7068:2: ( ( rule__ExpExpression__RightAlternatives_1_2_0 ) )
            {
            // InternalGT.g:7068:2: ( ( rule__ExpExpression__RightAlternatives_1_2_0 ) )
            // InternalGT.g:7069:3: ( rule__ExpExpression__RightAlternatives_1_2_0 )
            {
             before(grammarAccess.getExpExpressionAccess().getRightAlternatives_1_2_0()); 
            // InternalGT.g:7070:3: ( rule__ExpExpression__RightAlternatives_1_2_0 )
            // InternalGT.g:7070:4: rule__ExpExpression__RightAlternatives_1_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ExpExpression__RightAlternatives_1_2_0();

            state._fsp--;


            }

             after(grammarAccess.getExpExpressionAccess().getRightAlternatives_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExpExpression__RightAssignment_1_2"


    // $ANTLR start "rule__MinMaxExpression__MinMaxOperatorAssignment_1"
    // InternalGT.g:7078:1: rule__MinMaxExpression__MinMaxOperatorAssignment_1 : ( ruleMinMaxOperator ) ;
    public final void rule__MinMaxExpression__MinMaxOperatorAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7082:1: ( ( ruleMinMaxOperator ) )
            // InternalGT.g:7083:2: ( ruleMinMaxOperator )
            {
            // InternalGT.g:7083:2: ( ruleMinMaxOperator )
            // InternalGT.g:7084:3: ruleMinMaxOperator
            {
             before(grammarAccess.getMinMaxExpressionAccess().getMinMaxOperatorMinMaxOperatorEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMinMaxOperator();

            state._fsp--;

             after(grammarAccess.getMinMaxExpressionAccess().getMinMaxOperatorMinMaxOperatorEnumRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__MinMaxOperatorAssignment_1"


    // $ANTLR start "rule__MinMaxExpression__LeftAssignment_3"
    // InternalGT.g:7093:1: rule__MinMaxExpression__LeftAssignment_3 : ( ruleArithmeticExpression ) ;
    public final void rule__MinMaxExpression__LeftAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7097:1: ( ( ruleArithmeticExpression ) )
            // InternalGT.g:7098:2: ( ruleArithmeticExpression )
            {
            // InternalGT.g:7098:2: ( ruleArithmeticExpression )
            // InternalGT.g:7099:3: ruleArithmeticExpression
            {
             before(grammarAccess.getMinMaxExpressionAccess().getLeftArithmeticExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getMinMaxExpressionAccess().getLeftArithmeticExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__LeftAssignment_3"


    // $ANTLR start "rule__MinMaxExpression__RightAssignment_5"
    // InternalGT.g:7108:1: rule__MinMaxExpression__RightAssignment_5 : ( ruleArithmeticExpression ) ;
    public final void rule__MinMaxExpression__RightAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7112:1: ( ( ruleArithmeticExpression ) )
            // InternalGT.g:7113:2: ( ruleArithmeticExpression )
            {
            // InternalGT.g:7113:2: ( ruleArithmeticExpression )
            // InternalGT.g:7114:3: ruleArithmeticExpression
            {
             before(grammarAccess.getMinMaxExpressionAccess().getRightArithmeticExpressionParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getMinMaxExpressionAccess().getRightArithmeticExpressionParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MinMaxExpression__RightAssignment_5"


    // $ANTLR start "rule__OneParameterArithmetics__NegativeAssignment_0_1"
    // InternalGT.g:7123:1: rule__OneParameterArithmetics__NegativeAssignment_0_1 : ( ( '-' ) ) ;
    public final void rule__OneParameterArithmetics__NegativeAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7127:1: ( ( ( '-' ) ) )
            // InternalGT.g:7128:2: ( ( '-' ) )
            {
            // InternalGT.g:7128:2: ( ( '-' ) )
            // InternalGT.g:7129:3: ( '-' )
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getNegativeHyphenMinusKeyword_0_1_0()); 
            // InternalGT.g:7130:3: ( '-' )
            // InternalGT.g:7131:4: '-'
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getNegativeHyphenMinusKeyword_0_1_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getOneParameterArithmeticsAccess().getNegativeHyphenMinusKeyword_0_1_0()); 

            }

             after(grammarAccess.getOneParameterArithmeticsAccess().getNegativeHyphenMinusKeyword_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__NegativeAssignment_0_1"


    // $ANTLR start "rule__OneParameterArithmetics__OperatorAssignment_0_2"
    // InternalGT.g:7142:1: rule__OneParameterArithmetics__OperatorAssignment_0_2 : ( ruleOneParameterOperator ) ;
    public final void rule__OneParameterArithmetics__OperatorAssignment_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7146:1: ( ( ruleOneParameterOperator ) )
            // InternalGT.g:7147:2: ( ruleOneParameterOperator )
            {
            // InternalGT.g:7147:2: ( ruleOneParameterOperator )
            // InternalGT.g:7148:3: ruleOneParameterOperator
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getOperatorOneParameterOperatorEnumRuleCall_0_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOneParameterOperator();

            state._fsp--;

             after(grammarAccess.getOneParameterArithmeticsAccess().getOperatorOneParameterOperatorEnumRuleCall_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__OperatorAssignment_0_2"


    // $ANTLR start "rule__OneParameterArithmetics__ExpressionAssignment_0_4"
    // InternalGT.g:7157:1: rule__OneParameterArithmetics__ExpressionAssignment_0_4 : ( ruleArithmeticExpression ) ;
    public final void rule__OneParameterArithmetics__ExpressionAssignment_0_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalGT.g:7161:1: ( ( ruleArithmeticExpression ) )
            // InternalGT.g:7162:2: ( ruleArithmeticExpression )
            {
            // InternalGT.g:7162:2: ( ruleArithmeticExpression )
            // InternalGT.g:7163:3: ruleArithmeticExpression
            {
             before(grammarAccess.getOneParameterArithmeticsAccess().getExpressionArithmeticExpressionParserRuleCall_0_4_0()); 
            pushFollow(FOLLOW_2);
            ruleArithmeticExpression();

            state._fsp--;

             after(grammarAccess.getOneParameterArithmeticsAccess().getExpressionArithmeticExpressionParserRuleCall_0_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OneParameterArithmetics__ExpressionAssignment_0_4"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x8000000000006000L,0x0000000000000008L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x8000000000006002L,0x0000000000000008L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000006000L,0x0000000000000008L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x000B200000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000400000000040L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0044000000038040L,0x0000000000000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0040000000038042L,0x0000000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x42002FFC7C001870L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000038040L,0x0000000000000020L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x2084000008038000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x2080000008038002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x4E002FFC7C001870L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000FC0000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000008001830L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000008001810L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000008038000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0002000000800000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x4000000000038040L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x4000000000038042L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000003000040L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x000000007C000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x000000000C000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000380000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000380000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x00002FF008000000L});

}