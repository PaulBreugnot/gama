package msi.gama.lang.gaml.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalGamlLexer extends Lexer {
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__93=93;
    public static final int T__19=19;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__16=16;
    public static final int T__90=90;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_KEYWORD=10;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int RULE_ML_COMMENT=11;
    public static final int RULE_STRING=5;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int RULE_INTEGER=6;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int T__68=68;
    public static final int RULE_BOOLEAN=9;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__118=118;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int T__115=115;
    public static final int T__123=123;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int T__61=61;
    public static final int RULE_COLOR=8;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int T__103=103;
    public static final int T__59=59;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int T__100=100;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_DOUBLE=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=13;

    // delegates
    // delegators

    public InternalGamlLexer() {;} 
    public InternalGamlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalGamlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g"; }

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:11:7: ( 'model' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:11:9: 'model'
            {
            match("model"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:12:7: ( '<-' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:12:9: '<-'
            {
            match("<-"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:13:7: ( 'import' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:13:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:14:7: ( ';' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:14:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:15:7: ( 'action:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:15:9: 'action:'
            {
            match("action:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:16:7: ( 'loop' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:16:9: 'loop'
            {
            match("loop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:17:7: ( 'if' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:17:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:18:7: ( 'condition:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:18:9: 'condition:'
            {
            match("condition:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:19:7: ( 'else' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:19:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:20:7: ( 'return' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:20:9: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:21:7: ( 'value:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:21:9: 'value:'
            {
            match("value:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:22:7: ( 'name:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:22:9: 'name:'
            {
            match("name:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:23:7: ( 'experiment' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:23:9: 'experiment'
            {
            match("experiment"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:24:7: ( 'when:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:24:9: 'when:'
            {
            match("when:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:25:7: ( '(' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:25:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:26:7: ( ')' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:26:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:27:7: ( 'action' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:27:9: 'action'
            {
            match("action"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:28:7: ( 'set' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:28:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:29:7: ( 'var:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:29:9: 'var:'
            {
            match("var:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:30:7: ( '{' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:30:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:31:7: ( '}' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:31:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:32:7: ( '=' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:32:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:33:7: ( 'equation:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:33:9: 'equation:'
            {
            match("equation:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:34:7: ( 'equation' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:34:9: 'equation'
            {
            match("equation"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:35:7: ( 'solve' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:35:9: 'solve'
            {
            match("solve"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:36:7: ( 'species' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:36:9: 'species'
            {
            match("species"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:37:7: ( 'grid' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:37:9: 'grid'
            {
            match("grid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:38:7: ( 'ask' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:38:9: 'ask'
            {
            match("ask"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:39:7: ( 'release' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:39:9: 'release'
            {
            match("release"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:40:7: ( 'capture' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:40:9: 'capture'
            {
            match("capture"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:41:7: ( 'create' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:41:9: 'create'
            {
            match("create"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:42:7: ( 'write' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:42:9: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:43:7: ( 'error' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:43:9: 'error'
            {
            match("error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:44:7: ( 'warn' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:44:9: 'warn'
            {
            match("warn"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:45:7: ( 'exception' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:45:9: 'exception'
            {
            match("exception"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:46:7: ( 'save' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:46:9: 'save'
            {
            match("save"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:47:7: ( 'assert' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:47:9: 'assert'
            {
            match("assert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:48:7: ( 'draw' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:48:9: 'draw'
            {
            match("draw"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:49:7: ( 'display_population' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:49:9: 'display_population'
            {
            match("display_population"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:50:7: ( 'display_grid' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:50:9: 'display_grid'
            {
            match("display_grid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:51:7: ( 'using' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:51:9: 'using'
            {
            match("using"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:52:7: ( 'switch' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:52:9: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:53:7: ( 'put' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:53:9: 'put'
            {
            match("put"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:54:7: ( 'add' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:54:9: 'add'
            {
            match("add"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:55:7: ( 'remove' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:55:9: 'remove'
            {
            match("remove"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:56:7: ( 'match' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:56:9: 'match'
            {
            match("match"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:57:7: ( 'match_between' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:57:9: 'match_between'
            {
            match("match_between"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:58:7: ( 'match_one' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:58:9: 'match_one'
            {
            match("match_one"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:59:7: ( 'text' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:59:9: 'text'
            {
            match("text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:60:7: ( 'image' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:60:9: 'image'
            {
            match("image"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:61:7: ( 'data' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:61:9: 'data'
            {
            match("data"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:62:7: ( 'chart' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:62:9: 'chart'
            {
            match("chart"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:63:7: ( 'do' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:63:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:64:7: ( 'var' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:64:9: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:65:7: ( 'const' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:65:9: 'const'
            {
            match("const"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:66:7: ( 'let' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:66:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:67:7: ( 'arg' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:67:9: 'arg'
            {
            match("arg"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:68:7: ( 'init' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:68:9: 'init'
            {
            match("init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:69:7: ( 'reflex' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:69:9: 'reflex'
            {
            match("reflex"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:70:7: ( '<<' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:70:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:71:7: ( '>' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:71:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:72:7: ( ',' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:72:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:73:7: ( ':' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:73:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:74:7: ( 'returns:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:74:9: 'returns:'
            {
            match("returns:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:75:7: ( 'as:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:75:9: 'as:'
            {
            match("as:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:76:7: ( 'parent:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:76:9: 'parent:'
            {
            match("parent:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:77:7: ( 'of:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:77:9: 'of:'
            {
            match("of:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:78:7: ( 'species:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:78:9: 'species:'
            {
            match("species:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:79:7: ( 'type:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:79:9: 'type:'
            {
            match("type:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:80:7: ( 'data:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:80:9: 'data:'
            {
            match("data:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:81:7: ( 'const:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:81:9: 'const:'
            {
            match("const:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:82:7: ( 'topology:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:82:9: 'topology:'
            {
            match("topology:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:83:7: ( 'item:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:83:9: 'item:'
            {
            match("item:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:84:7: ( 'init:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:84:9: 'init:'
            {
            match("init:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:85:7: ( 'message:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:85:9: 'message:'
            {
            match("message:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:86:7: ( 'control:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:86:9: 'control:'
            {
            match("control:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:87:7: ( 'environment:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:87:9: 'environment:'
            {
            match("environment:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:88:7: ( 'text:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:88:9: 'text:'
            {
            match("text:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:89:7: ( 'image:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:89:9: 'image:'
            {
            match("image:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:90:7: ( 'using:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:90:9: 'using:'
            {
            match("using:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:91:7: ( 'function:' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:91:9: 'function:'
            {
            match("function:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:92:7: ( '->' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:92:9: '->'
            {
            match("->"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:93:7: ( '::' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:93:9: '::'
            {
            match("::"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:94:7: ( '?' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:94:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:95:7: ( 'or' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:95:9: 'or'
            {
            match("or"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:96:8: ( 'and' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:96:10: 'and'
            {
            match("and"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:97:8: ( '!=' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:97:10: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:98:8: ( '>=' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:98:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:99:8: ( '<=' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:99:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:100:8: ( '<' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:100:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:101:8: ( '+' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:101:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:102:8: ( '-' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:102:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:103:8: ( '*' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:103:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:104:8: ( '/' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:104:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:105:8: ( '^' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:105:10: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "T__110"
    public final void mT__110() throws RecognitionException {
        try {
            int _type = T__110;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:106:8: ( '\\u00B0' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:106:10: '\\u00B0'
            {
            match('\u00B0'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__110"

    // $ANTLR start "T__111"
    public final void mT__111() throws RecognitionException {
        try {
            int _type = T__111;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:107:8: ( '!' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:107:10: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__111"

    // $ANTLR start "T__112"
    public final void mT__112() throws RecognitionException {
        try {
            int _type = T__112;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:108:8: ( 'my' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:108:10: 'my'
            {
            match("my"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__112"

    // $ANTLR start "T__113"
    public final void mT__113() throws RecognitionException {
        try {
            int _type = T__113;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:109:8: ( 'the' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:109:10: 'the'
            {
            match("the"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__113"

    // $ANTLR start "T__114"
    public final void mT__114() throws RecognitionException {
        try {
            int _type = T__114;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:110:8: ( 'not' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:110:10: 'not'
            {
            match("not"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__114"

    // $ANTLR start "T__115"
    public final void mT__115() throws RecognitionException {
        try {
            int _type = T__115;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:111:8: ( '[' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:111:10: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__115"

    // $ANTLR start "T__116"
    public final void mT__116() throws RecognitionException {
        try {
            int _type = T__116;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:112:8: ( ']' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:112:10: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__116"

    // $ANTLR start "T__117"
    public final void mT__117() throws RecognitionException {
        try {
            int _type = T__117;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:113:8: ( '.' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:113:10: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__117"

    // $ANTLR start "T__118"
    public final void mT__118() throws RecognitionException {
        try {
            int _type = T__118;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:114:8: ( '**unit*' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:114:10: '**unit*'
            {
            match("**unit*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__118"

    // $ANTLR start "T__119"
    public final void mT__119() throws RecognitionException {
        try {
            int _type = T__119;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:115:8: ( '**type*' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:115:10: '**type*'
            {
            match("**type*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__119"

    // $ANTLR start "T__120"
    public final void mT__120() throws RecognitionException {
        try {
            int _type = T__120;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:116:8: ( '**action*' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:116:10: '**action*'
            {
            match("**action*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__120"

    // $ANTLR start "T__121"
    public final void mT__121() throws RecognitionException {
        try {
            int _type = T__121;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:117:8: ( '**skill*' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:117:10: '**skill*'
            {
            match("**skill*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__121"

    // $ANTLR start "T__122"
    public final void mT__122() throws RecognitionException {
        try {
            int _type = T__122;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:118:8: ( '**var*' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:118:10: '**var*'
            {
            match("**var*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__122"

    // $ANTLR start "T__123"
    public final void mT__123() throws RecognitionException {
        try {
            int _type = T__123;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:119:8: ( '**equation*' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:119:10: '**equation*'
            {
            match("**equation*"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__123"

    // $ANTLR start "RULE_KEYWORD"
    public final void mRULE_KEYWORD() throws RecognitionException {
        try {
            int _type = RULE_KEYWORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:14: ( ( 'each' | 'self' | 'myself' | 'nil' | 'world' ) )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:16: ( 'each' | 'self' | 'myself' | 'nil' | 'world' )
            {
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:16: ( 'each' | 'self' | 'myself' | 'nil' | 'world' )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 'e':
                {
                alt1=1;
                }
                break;
            case 's':
                {
                alt1=2;
                }
                break;
            case 'm':
                {
                alt1=3;
                }
                break;
            case 'n':
                {
                alt1=4;
                }
                break;
            case 'w':
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:17: 'each'
                    {
                    match("each"); 


                    }
                    break;
                case 2 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:24: 'self'
                    {
                    match("self"); 


                    }
                    break;
                case 3 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:31: 'myself'
                    {
                    match("myself"); 


                    }
                    break;
                case 4 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:40: 'nil'
                    {
                    match("nil"); 


                    }
                    break;
                case 5 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6669:46: 'world'
                    {
                    match("world"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_KEYWORD"

    // $ANTLR start "RULE_INTEGER"
    public final void mRULE_INTEGER() throws RecognitionException {
        try {
            int _type = RULE_INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6671:14: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6671:16: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6671:16: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='0') ) {
                alt3=1;
            }
            else if ( ((LA3_0>='1' && LA3_0<='9')) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6671:17: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6671:21: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6671:30: ( '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6671:31: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTEGER"

    // $ANTLR start "RULE_BOOLEAN"
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6673:14: ( ( 'true' | 'false' ) )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6673:16: ( 'true' | 'false' )
            {
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6673:16: ( 'true' | 'false' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='t') ) {
                alt4=1;
            }
            else if ( (LA4_0=='f') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6673:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6673:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOLEAN"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6675:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '0' .. '9' )* )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6675:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '0' .. '9' )*
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6675:39: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' | '0' .. '9' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='$'||(LA5_0>='0' && LA5_0<='9')||(LA5_0>='A' && LA5_0<='Z')||LA5_0=='_'||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_COLOR"
    public final void mRULE_COLOR() throws RecognitionException {
        try {
            int _type = RULE_COLOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6677:12: ( '#' ( '0' .. '9' | 'A' .. 'F' )+ )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6677:14: '#' ( '0' .. '9' | 'A' .. 'F' )+
            {
            match('#'); 
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6677:18: ( '0' .. '9' | 'A' .. 'F' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='F')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COLOR"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:13: ( ( '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )? | '0' ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )? ) )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:15: ( '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )? | '0' ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )? )
            {
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:15: ( '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )? | '0' ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )? )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>='1' && LA18_0<='9')) ) {
                alt18=1;
            }
            else if ( (LA18_0=='0') ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:16: '1' .. '9' ( '0' .. '9' )* ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    {
                    matchRange('1','9'); 
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:25: ( '0' .. '9' )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:26: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:37: ( '.' ( '0' .. '9' )+ )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='.') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:38: '.' ( '0' .. '9' )+
                            {
                            match('.'); 
                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:42: ( '0' .. '9' )+
                            int cnt8=0;
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:43: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt8 >= 1 ) break loop8;
                                        EarlyExitException eee =
                                            new EarlyExitException(8, input);
                                        throw eee;
                                }
                                cnt8++;
                            } while (true);


                            }
                            break;

                    }

                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:56: ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='E'||LA12_0=='e') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:57: ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:67: ( '+' | '-' )?
                            int alt10=2;
                            int LA10_0 = input.LA(1);

                            if ( (LA10_0=='+'||LA10_0=='-') ) {
                                alt10=1;
                            }
                            switch (alt10) {
                                case 1 :
                                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:78: ( '0' .. '9' )+
                            int cnt11=0;
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:79: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt11 >= 1 ) break loop11;
                                        EarlyExitException eee =
                                            new EarlyExitException(11, input);
                                        throw eee;
                                }
                                cnt11++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:92: '0' ( '.' ( '0' .. '9' )+ )? ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    {
                    match('0'); 
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:96: ( '.' ( '0' .. '9' )+ )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0=='.') ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:97: '.' ( '0' .. '9' )+
                            {
                            match('.'); 
                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:101: ( '0' .. '9' )+
                            int cnt13=0;
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:102: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt13 >= 1 ) break loop13;
                                        EarlyExitException eee =
                                            new EarlyExitException(13, input);
                                        throw eee;
                                }
                                cnt13++;
                            } while (true);


                            }
                            break;

                    }

                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:115: ( ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+ )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0=='E'||LA17_0=='e') ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:116: ( 'E' | 'e' ) ( '+' | '-' )? ( '0' .. '9' )+
                            {
                            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                                input.consume();

                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                recover(mse);
                                throw mse;}

                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:126: ( '+' | '-' )?
                            int alt15=2;
                            int LA15_0 = input.LA(1);

                            if ( (LA15_0=='+'||LA15_0=='-') ) {
                                alt15=1;
                            }
                            switch (alt15) {
                                case 1 :
                                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:
                                    {
                                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                                        input.consume();

                                    }
                                    else {
                                        MismatchedSetException mse = new MismatchedSetException(null,input);
                                        recover(mse);
                                        throw mse;}


                                    }
                                    break;

                            }

                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:137: ( '0' .. '9' )+
                            int cnt16=0;
                            loop16:
                            do {
                                int alt16=2;
                                int LA16_0 = input.LA(1);

                                if ( ((LA16_0>='0' && LA16_0<='9')) ) {
                                    alt16=1;
                                }


                                switch (alt16) {
                            	case 1 :
                            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6679:138: '0' .. '9'
                            	    {
                            	    matchRange('0','9'); 

                            	    }
                            	    break;

                            	default :
                            	    if ( cnt16 >= 1 ) break loop16;
                                        EarlyExitException eee =
                                            new EarlyExitException(16, input);
                                        throw eee;
                                }
                                cnt16++;
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='\"') ) {
                alt21=1;
            }
            else if ( (LA21_0=='\'') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop19:
                    do {
                        int alt19=3;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0=='\\') ) {
                            alt19=1;
                        }
                        else if ( ((LA19_0>='\u0000' && LA19_0<='!')||(LA19_0>='#' && LA19_0<='[')||(LA19_0>=']' && LA19_0<='\uFFFF')) ) {
                            alt19=2;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:61: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:81: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:86: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\\') ) {
                            alt20=1;
                        }
                        else if ( ((LA20_0>='\u0000' && LA20_0<='&')||(LA20_0>='(' && LA20_0<='[')||(LA20_0>=']' && LA20_0<='\uFFFF')) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:87: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6681:128: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6683:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6683:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6683:24: ( options {greedy=false; } : . )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0=='*') ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1=='/') ) {
                        alt22=2;
                    }
                    else if ( ((LA22_1>='\u0000' && LA22_1<='.')||(LA22_1>='0' && LA22_1<='\uFFFF')) ) {
                        alt22=1;
                    }


                }
                else if ( ((LA22_0>='\u0000' && LA22_0<=')')||(LA22_0>='+' && LA22_0<='\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6683:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>='\u0000' && LA23_0<='\t')||(LA23_0>='\u000B' && LA23_0<='\f')||(LA23_0>='\u000E' && LA23_0<='\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:40: ( ( '\\r' )? '\\n' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\n'||LA25_0=='\r') ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:41: ( '\\r' )? '\\n'
                    {
                    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:41: ( '\\r' )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0=='\r') ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6685:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6687:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6687:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6687:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>='\t' && LA26_0<='\n')||LA26_0=='\r'||LA26_0==' ') ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6689:16: ( . )
            // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:6689:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:8: ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | RULE_KEYWORD | RULE_INTEGER | RULE_BOOLEAN | RULE_ID | RULE_COLOR | RULE_DOUBLE | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt27=120;
        alt27 = dfa27.predict(input);
        switch (alt27) {
            case 1 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:10: T__15
                {
                mT__15(); 

                }
                break;
            case 2 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:16: T__16
                {
                mT__16(); 

                }
                break;
            case 3 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:22: T__17
                {
                mT__17(); 

                }
                break;
            case 4 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:28: T__18
                {
                mT__18(); 

                }
                break;
            case 5 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:34: T__19
                {
                mT__19(); 

                }
                break;
            case 6 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:40: T__20
                {
                mT__20(); 

                }
                break;
            case 7 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:46: T__21
                {
                mT__21(); 

                }
                break;
            case 8 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:52: T__22
                {
                mT__22(); 

                }
                break;
            case 9 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:58: T__23
                {
                mT__23(); 

                }
                break;
            case 10 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:64: T__24
                {
                mT__24(); 

                }
                break;
            case 11 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:70: T__25
                {
                mT__25(); 

                }
                break;
            case 12 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:76: T__26
                {
                mT__26(); 

                }
                break;
            case 13 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:82: T__27
                {
                mT__27(); 

                }
                break;
            case 14 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:88: T__28
                {
                mT__28(); 

                }
                break;
            case 15 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:94: T__29
                {
                mT__29(); 

                }
                break;
            case 16 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:100: T__30
                {
                mT__30(); 

                }
                break;
            case 17 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:106: T__31
                {
                mT__31(); 

                }
                break;
            case 18 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:112: T__32
                {
                mT__32(); 

                }
                break;
            case 19 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:118: T__33
                {
                mT__33(); 

                }
                break;
            case 20 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:124: T__34
                {
                mT__34(); 

                }
                break;
            case 21 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:130: T__35
                {
                mT__35(); 

                }
                break;
            case 22 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:136: T__36
                {
                mT__36(); 

                }
                break;
            case 23 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:142: T__37
                {
                mT__37(); 

                }
                break;
            case 24 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:148: T__38
                {
                mT__38(); 

                }
                break;
            case 25 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:154: T__39
                {
                mT__39(); 

                }
                break;
            case 26 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:160: T__40
                {
                mT__40(); 

                }
                break;
            case 27 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:166: T__41
                {
                mT__41(); 

                }
                break;
            case 28 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:172: T__42
                {
                mT__42(); 

                }
                break;
            case 29 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:178: T__43
                {
                mT__43(); 

                }
                break;
            case 30 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:184: T__44
                {
                mT__44(); 

                }
                break;
            case 31 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:190: T__45
                {
                mT__45(); 

                }
                break;
            case 32 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:196: T__46
                {
                mT__46(); 

                }
                break;
            case 33 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:202: T__47
                {
                mT__47(); 

                }
                break;
            case 34 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:208: T__48
                {
                mT__48(); 

                }
                break;
            case 35 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:214: T__49
                {
                mT__49(); 

                }
                break;
            case 36 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:220: T__50
                {
                mT__50(); 

                }
                break;
            case 37 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:226: T__51
                {
                mT__51(); 

                }
                break;
            case 38 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:232: T__52
                {
                mT__52(); 

                }
                break;
            case 39 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:238: T__53
                {
                mT__53(); 

                }
                break;
            case 40 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:244: T__54
                {
                mT__54(); 

                }
                break;
            case 41 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:250: T__55
                {
                mT__55(); 

                }
                break;
            case 42 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:256: T__56
                {
                mT__56(); 

                }
                break;
            case 43 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:262: T__57
                {
                mT__57(); 

                }
                break;
            case 44 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:268: T__58
                {
                mT__58(); 

                }
                break;
            case 45 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:274: T__59
                {
                mT__59(); 

                }
                break;
            case 46 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:280: T__60
                {
                mT__60(); 

                }
                break;
            case 47 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:286: T__61
                {
                mT__61(); 

                }
                break;
            case 48 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:292: T__62
                {
                mT__62(); 

                }
                break;
            case 49 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:298: T__63
                {
                mT__63(); 

                }
                break;
            case 50 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:304: T__64
                {
                mT__64(); 

                }
                break;
            case 51 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:310: T__65
                {
                mT__65(); 

                }
                break;
            case 52 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:316: T__66
                {
                mT__66(); 

                }
                break;
            case 53 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:322: T__67
                {
                mT__67(); 

                }
                break;
            case 54 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:328: T__68
                {
                mT__68(); 

                }
                break;
            case 55 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:334: T__69
                {
                mT__69(); 

                }
                break;
            case 56 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:340: T__70
                {
                mT__70(); 

                }
                break;
            case 57 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:346: T__71
                {
                mT__71(); 

                }
                break;
            case 58 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:352: T__72
                {
                mT__72(); 

                }
                break;
            case 59 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:358: T__73
                {
                mT__73(); 

                }
                break;
            case 60 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:364: T__74
                {
                mT__74(); 

                }
                break;
            case 61 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:370: T__75
                {
                mT__75(); 

                }
                break;
            case 62 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:376: T__76
                {
                mT__76(); 

                }
                break;
            case 63 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:382: T__77
                {
                mT__77(); 

                }
                break;
            case 64 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:388: T__78
                {
                mT__78(); 

                }
                break;
            case 65 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:394: T__79
                {
                mT__79(); 

                }
                break;
            case 66 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:400: T__80
                {
                mT__80(); 

                }
                break;
            case 67 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:406: T__81
                {
                mT__81(); 

                }
                break;
            case 68 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:412: T__82
                {
                mT__82(); 

                }
                break;
            case 69 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:418: T__83
                {
                mT__83(); 

                }
                break;
            case 70 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:424: T__84
                {
                mT__84(); 

                }
                break;
            case 71 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:430: T__85
                {
                mT__85(); 

                }
                break;
            case 72 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:436: T__86
                {
                mT__86(); 

                }
                break;
            case 73 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:442: T__87
                {
                mT__87(); 

                }
                break;
            case 74 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:448: T__88
                {
                mT__88(); 

                }
                break;
            case 75 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:454: T__89
                {
                mT__89(); 

                }
                break;
            case 76 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:460: T__90
                {
                mT__90(); 

                }
                break;
            case 77 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:466: T__91
                {
                mT__91(); 

                }
                break;
            case 78 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:472: T__92
                {
                mT__92(); 

                }
                break;
            case 79 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:478: T__93
                {
                mT__93(); 

                }
                break;
            case 80 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:484: T__94
                {
                mT__94(); 

                }
                break;
            case 81 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:490: T__95
                {
                mT__95(); 

                }
                break;
            case 82 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:496: T__96
                {
                mT__96(); 

                }
                break;
            case 83 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:502: T__97
                {
                mT__97(); 

                }
                break;
            case 84 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:508: T__98
                {
                mT__98(); 

                }
                break;
            case 85 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:514: T__99
                {
                mT__99(); 

                }
                break;
            case 86 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:520: T__100
                {
                mT__100(); 

                }
                break;
            case 87 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:527: T__101
                {
                mT__101(); 

                }
                break;
            case 88 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:534: T__102
                {
                mT__102(); 

                }
                break;
            case 89 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:541: T__103
                {
                mT__103(); 

                }
                break;
            case 90 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:548: T__104
                {
                mT__104(); 

                }
                break;
            case 91 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:555: T__105
                {
                mT__105(); 

                }
                break;
            case 92 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:562: T__106
                {
                mT__106(); 

                }
                break;
            case 93 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:569: T__107
                {
                mT__107(); 

                }
                break;
            case 94 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:576: T__108
                {
                mT__108(); 

                }
                break;
            case 95 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:583: T__109
                {
                mT__109(); 

                }
                break;
            case 96 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:590: T__110
                {
                mT__110(); 

                }
                break;
            case 97 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:597: T__111
                {
                mT__111(); 

                }
                break;
            case 98 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:604: T__112
                {
                mT__112(); 

                }
                break;
            case 99 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:611: T__113
                {
                mT__113(); 

                }
                break;
            case 100 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:618: T__114
                {
                mT__114(); 

                }
                break;
            case 101 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:625: T__115
                {
                mT__115(); 

                }
                break;
            case 102 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:632: T__116
                {
                mT__116(); 

                }
                break;
            case 103 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:639: T__117
                {
                mT__117(); 

                }
                break;
            case 104 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:646: T__118
                {
                mT__118(); 

                }
                break;
            case 105 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:653: T__119
                {
                mT__119(); 

                }
                break;
            case 106 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:660: T__120
                {
                mT__120(); 

                }
                break;
            case 107 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:667: T__121
                {
                mT__121(); 

                }
                break;
            case 108 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:674: T__122
                {
                mT__122(); 

                }
                break;
            case 109 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:681: T__123
                {
                mT__123(); 

                }
                break;
            case 110 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:688: RULE_KEYWORD
                {
                mRULE_KEYWORD(); 

                }
                break;
            case 111 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:701: RULE_INTEGER
                {
                mRULE_INTEGER(); 

                }
                break;
            case 112 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:714: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 113 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:727: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 114 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:735: RULE_COLOR
                {
                mRULE_COLOR(); 

                }
                break;
            case 115 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:746: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 116 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:758: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 117 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:770: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 118 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:786: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 119 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:802: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 120 :
                // ../msi.gama.lang.gaml/src-gen/msi/gama/lang/gaml/parser/antlr/internal/InternalGaml.g:1:810: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\1\uffff\1\64\1\70\1\64\1\uffff\10\64\2\uffff\1\64\3\uffff\5\64"+
        "\1\160\1\uffff\1\163\2\64\1\171\1\uffff\1\174\1\uffff\1\177\1\u0082"+
        "\5\uffff\2\u0088\1\uffff\3\57\2\uffff\3\64\1\u0092\5\uffff\1\64"+
        "\1\u0095\2\64\1\uffff\32\64\2\uffff\5\64\3\uffff\4\64\1\u00c3\10"+
        "\64\5\uffff\1\64\1\u00cd\2\64\22\uffff\1\u0088\3\uffff\4\64\1\uffff"+
        "\2\64\1\uffff\3\64\1\u00df\1\64\1\uffff\1\u00e1\1\u00e2\1\u00e3"+
        "\1\64\1\u00e5\20\64\1\u00f9\1\64\1\u00fb\1\u00fc\4\64\1\u0101\11"+
        "\64\1\uffff\1\64\1\u010c\4\64\1\u0111\1\64\2\uffff\2\64\6\uffff"+
        "\6\64\1\u011c\2\64\1\uffff\1\64\3\uffff\1\u0120\1\uffff\6\64\1\u0127"+
        "\5\64\1\u00fc\5\64\2\uffff\1\64\2\uffff\2\64\1\u0135\1\64\1\uffff"+
        "\1\u00fc\2\64\1\u0139\1\64\1\u013b\1\u013c\1\64\1\u013f\1\64\1\uffff"+
        "\1\64\1\u0143\2\64\1\uffff\1\u0146\2\64\1\u0149\1\u014b\3\64\1\u0150"+
        "\3\uffff\2\64\1\uffff\1\64\1\u0155\3\64\1\u0159\1\uffff\3\64\1\u015d"+
        "\6\64\2\uffff\1\u0164\1\uffff\1\u00fc\1\u0165\1\64\1\uffff\1\64"+
        "\2\uffff\1\64\2\uffff\1\u016a\1\64\3\uffff\1\64\1\uffff\1\64\1\u0146"+
        "\1\uffff\1\64\1\uffff\1\64\1\u00fc\1\u0171\2\uffff\1\u0173\1\u0174"+
        "\1\64\2\uffff\2\64\1\u0178\1\uffff\3\64\1\uffff\1\64\1\u017e\1\64"+
        "\1\u0180\1\u0181\3\uffff\1\64\1\u0183\1\64\2\uffff\6\64\4\uffff"+
        "\2\64\1\u018d\1\uffff\5\64\1\uffff\1\u0193\2\uffff\1\u0195\1\uffff"+
        "\1\64\1\uffff\4\64\1\uffff\1\64\2\uffff\2\64\1\u019f\1\64\4\uffff"+
        "\4\64\1\u01a6\2\64\1\u01a9\2\uffff\3\64\2\uffff\1\64\2\uffff\1\u01ae"+
        "\1\uffff\4\64\1\uffff\4\64\1\uffff\1\64\1\u01b8\1\u01b9\1\64\2\uffff"+
        "\4\64\1\u01bf\1\uffff";
    static final String DFA27_eofS =
        "\u01c0\uffff";
    static final String DFA27_minS =
        "\1\0\1\141\1\55\1\146\1\uffff\1\143\1\145\2\141\1\145\3\141\2\uffff"+
        "\1\141\3\uffff\1\162\1\141\1\163\1\141\1\145\1\75\1\uffff\1\72\1"+
        "\146\1\141\1\76\1\uffff\1\75\1\uffff\2\52\5\uffff\2\56\1\uffff\1"+
        "\60\2\0\2\uffff\1\144\1\164\1\163\1\44\5\uffff\1\141\1\44\1\151"+
        "\1\145\1\uffff\1\164\1\72\1\144\1\147\1\144\1\157\1\164\1\156\1"+
        "\160\1\145\1\141\1\163\1\143\1\165\1\162\1\166\1\143\1\146\1\154"+
        "\1\155\1\164\1\154\1\145\1\151\2\162\2\uffff\2\154\1\145\1\166\1"+
        "\151\3\uffff\1\151\1\141\1\163\1\164\1\44\1\151\1\164\1\162\1\170"+
        "\2\160\1\145\1\165\5\uffff\1\72\1\44\1\156\1\154\6\uffff\1\141\13"+
        "\uffff\1\56\3\uffff\1\145\1\143\1\163\1\145\1\uffff\1\157\1\147"+
        "\1\uffff\1\164\1\155\1\151\1\44\1\145\1\uffff\3\44\1\160\1\44\1"+
        "\144\1\164\1\141\1\162\3\145\1\141\1\157\1\151\1\150\1\165\1\145"+
        "\1\157\1\154\1\165\1\44\1\145\2\44\1\156\1\164\1\156\1\154\1\44"+
        "\1\146\1\166\1\143\1\145\1\164\1\144\1\167\1\160\1\141\1\uffff\1"+
        "\156\1\44\1\145\1\164\1\145\1\157\1\44\1\145\2\uffff\1\143\1\163"+
        "\6\uffff\1\154\1\150\1\141\1\154\1\162\1\145\1\44\1\72\1\157\1\uffff"+
        "\1\162\3\uffff\1\44\1\uffff\1\151\1\164\1\162\1\165\2\164\1\44\1"+
        "\162\1\160\1\164\2\162\1\44\1\162\1\141\1\166\2\145\2\uffff\1\72"+
        "\2\uffff\1\72\1\145\1\44\1\144\1\uffff\1\44\1\145\1\151\1\44\1\143"+
        "\2\44\1\154\1\44\1\147\1\uffff\1\156\1\44\1\72\1\154\1\uffff\1\44"+
        "\1\164\1\145\2\44\1\147\1\146\1\164\1\44\3\uffff\1\156\1\164\1\uffff"+
        "\1\164\1\44\1\157\1\162\1\145\1\44\1\uffff\1\151\1\164\1\151\1\44"+
        "\1\157\1\156\1\163\1\145\1\170\1\72\2\uffff\1\44\1\uffff\2\44\1"+
        "\145\1\uffff\1\150\2\uffff\1\141\2\uffff\1\44\1\164\3\uffff\1\157"+
        "\1\uffff\1\151\1\44\1\uffff\1\142\1\uffff\1\145\2\44\2\uffff\2\44"+
        "\1\151\2\uffff\1\154\1\145\1\44\1\uffff\1\155\1\151\1\157\1\uffff"+
        "\1\156\1\44\1\145\2\44\3\uffff\1\163\1\44\1\171\2\uffff\1\72\1\147"+
        "\1\157\1\145\1\156\1\72\4\uffff\1\157\1\72\1\44\1\uffff\1\145\1"+
        "\157\1\156\1\155\1\72\1\uffff\1\44\2\uffff\1\44\1\uffff\1\137\1"+
        "\uffff\1\171\1\156\1\164\1\145\1\uffff\1\156\2\uffff\2\156\1\44"+
        "\1\145\4\uffff\1\147\2\72\1\167\1\44\1\72\1\164\1\44\2\uffff\1\156"+
        "\1\157\1\162\2\uffff\1\145\2\uffff\1\44\1\uffff\1\164\1\160\1\151"+
        "\1\145\1\uffff\1\72\1\165\1\144\1\156\1\uffff\1\154\2\44\1\141\2"+
        "\uffff\1\164\1\151\1\157\1\156\1\44\1\uffff";
    static final String DFA27_maxS =
        "\1\uffff\1\171\1\75\1\164\1\uffff\1\163\1\157\1\162\1\170\1\145"+
        "\1\141\1\157\1\162\2\uffff\1\167\3\uffff\2\162\1\163\1\165\1\171"+
        "\1\75\1\uffff\1\72\1\162\1\165\1\76\1\uffff\1\75\1\uffff\1\52\1"+
        "\57\5\uffff\2\145\1\uffff\1\106\2\uffff\2\uffff\1\144\1\164\1\163"+
        "\1\172\5\uffff\1\160\1\172\1\151\1\145\1\uffff\1\164\1\163\1\144"+
        "\1\147\1\144\1\157\1\164\1\156\1\160\1\145\1\141\1\163\1\160\1\165"+
        "\1\162\1\166\1\143\1\164\1\162\1\155\1\164\1\154\1\145\1\151\2\162"+
        "\2\uffff\1\164\1\154\1\145\1\166\1\151\3\uffff\1\151\1\141\1\163"+
        "\1\164\1\172\1\151\1\164\1\162\1\170\2\160\1\145\1\165\5\uffff\1"+
        "\72\1\172\1\156\1\154\6\uffff\1\166\13\uffff\1\145\3\uffff\1\145"+
        "\1\143\1\163\1\145\1\uffff\1\157\1\147\1\uffff\1\164\1\155\1\151"+
        "\1\172\1\145\1\uffff\3\172\1\160\1\172\2\164\1\141\1\162\3\145\1"+
        "\141\1\157\1\151\1\150\1\165\1\145\1\157\1\154\1\165\1\172\1\145"+
        "\2\172\1\156\1\164\1\156\1\154\1\172\1\146\1\166\1\143\1\145\1\164"+
        "\1\144\1\167\1\160\1\141\1\uffff\1\156\1\172\1\145\1\164\1\145\1"+
        "\157\1\172\1\145\2\uffff\1\143\1\163\6\uffff\1\154\1\150\1\141\1"+
        "\154\1\162\1\145\1\172\1\72\1\157\1\uffff\1\162\3\uffff\1\172\1"+
        "\uffff\1\151\1\164\1\162\1\165\2\164\1\172\1\162\1\160\1\164\2\162"+
        "\1\172\1\162\1\141\1\166\2\145\2\uffff\1\72\2\uffff\1\72\1\145\1"+
        "\172\1\144\1\uffff\1\172\1\145\1\151\1\172\1\143\2\172\1\154\1\172"+
        "\1\147\1\uffff\1\156\1\172\1\72\1\154\1\uffff\1\172\1\164\1\145"+
        "\2\172\1\147\1\146\1\164\1\172\3\uffff\1\156\1\164\1\uffff\1\164"+
        "\1\172\1\157\1\162\1\145\1\172\1\uffff\1\151\1\164\1\151\1\172\1"+
        "\157\1\156\1\163\1\145\1\170\1\72\2\uffff\1\172\1\uffff\2\172\1"+
        "\145\1\uffff\1\150\2\uffff\1\141\2\uffff\1\172\1\164\3\uffff\1\157"+
        "\1\uffff\1\151\1\172\1\uffff\1\157\1\uffff\1\145\2\172\2\uffff\2"+
        "\172\1\151\2\uffff\1\154\1\145\1\172\1\uffff\1\155\1\151\1\157\1"+
        "\uffff\1\156\1\172\1\145\2\172\3\uffff\1\163\1\172\1\171\2\uffff"+
        "\1\72\1\147\1\157\1\145\1\156\1\72\4\uffff\1\157\1\72\1\172\1\uffff"+
        "\1\145\1\157\1\156\1\155\1\72\1\uffff\1\172\2\uffff\1\172\1\uffff"+
        "\1\137\1\uffff\1\171\1\156\1\164\1\145\1\uffff\1\156\2\uffff\2\156"+
        "\1\172\1\145\4\uffff\1\160\2\72\1\167\1\172\1\72\1\164\1\172\2\uffff"+
        "\1\156\1\157\1\162\2\uffff\1\145\2\uffff\1\172\1\uffff\1\164\1\160"+
        "\1\151\1\145\1\uffff\1\72\1\165\1\144\1\156\1\uffff\1\154\2\172"+
        "\1\141\2\uffff\1\164\1\151\1\157\1\156\1\172\1\uffff";
    static final String DFA27_acceptS =
        "\4\uffff\1\4\10\uffff\1\17\1\20\1\uffff\1\24\1\25\1\26\6\uffff\1"+
        "\76\4\uffff\1\124\1\uffff\1\133\2\uffff\1\137\1\140\1\145\1\146"+
        "\1\147\2\uffff\1\161\3\uffff\1\167\1\170\4\uffff\1\161\1\2\1\74"+
        "\1\131\1\132\4\uffff\1\4\32\uffff\1\17\1\20\5\uffff\1\24\1\25\1"+
        "\26\15\uffff\1\130\1\75\1\76\1\123\1\77\4\uffff\1\122\1\134\1\124"+
        "\1\127\1\141\1\133\1\uffff\1\135\1\165\1\166\1\136\1\137\1\140\1"+
        "\145\1\146\1\147\1\157\1\163\1\uffff\1\162\1\164\1\167\4\uffff\1"+
        "\142\2\uffff\1\7\5\uffff\1\101\47\uffff\1\65\10\uffff\1\103\1\125"+
        "\2\uffff\1\150\1\151\1\152\1\153\1\154\1\155\11\uffff\1\34\1\uffff"+
        "\1\54\1\71\1\126\1\uffff\1\70\22\uffff\1\23\1\66\1\uffff\1\144\1"+
        "\156\4\uffff\1\22\12\uffff\1\53\4\uffff\1\143\11\uffff\1\112\1\72"+
        "\1\111\2\uffff\1\6\6\uffff\1\11\12\uffff\1\14\1\16\1\uffff\1\42"+
        "\3\uffff\1\44\1\uffff\1\33\1\46\1\uffff\1\106\1\63\2\uffff\1\116"+
        "\1\61\1\105\1\uffff\1\160\2\uffff\1\1\1\uffff\1\56\3\uffff\1\117"+
        "\1\62\3\uffff\1\107\1\67\3\uffff\1\64\3\uffff\1\41\5\uffff\1\13"+
        "\1\40\1\31\3\uffff\1\120\1\51\6\uffff\1\3\1\5\1\21\1\45\3\uffff"+
        "\1\37\5\uffff\1\12\1\uffff\1\55\1\73\1\uffff\1\52\1\uffff\1\102"+
        "\4\uffff\1\113\1\uffff\1\114\1\36\4\uffff\1\100\1\35\1\104\1\32"+
        "\10\uffff\1\27\1\30\3\uffff\1\110\1\121\1\uffff\1\60\1\10\1\uffff"+
        "\1\43\4\uffff\1\15\4\uffff\1\115\4\uffff\1\50\1\57\5\uffff\1\47";
    static final String DFA27_specialS =
        "\1\2\53\uffff\1\1\1\0\u0192\uffff}>";
    static final String[] DFA27_transitionS = {
            "\11\57\2\56\2\57\1\56\22\57\1\56\1\37\1\54\1\53\1\52\2\57\1"+
            "\55\1\15\1\16\1\41\1\40\1\31\1\35\1\47\1\42\1\50\11\51\1\32"+
            "\1\4\1\2\1\22\1\30\1\36\1\57\32\52\1\45\1\57\1\46\1\43\1\52"+
            "\1\57\1\5\1\52\1\7\1\24\1\10\1\34\1\23\1\52\1\3\2\52\1\6\1\1"+
            "\1\13\1\33\1\26\1\52\1\11\1\17\1\27\1\25\1\12\1\14\3\52\1\20"+
            "\1\57\1\21\62\57\1\44\uff4f\57",
            "\1\61\3\uffff\1\62\11\uffff\1\60\11\uffff\1\63",
            "\1\65\16\uffff\1\66\1\67",
            "\1\72\6\uffff\1\71\1\73\5\uffff\1\74",
            "",
            "\1\76\1\100\11\uffff\1\102\3\uffff\1\101\1\77",
            "\1\104\11\uffff\1\103",
            "\1\106\6\uffff\1\110\6\uffff\1\105\2\uffff\1\107",
            "\1\116\12\uffff\1\111\1\uffff\1\115\2\uffff\1\113\1\114\5\uffff"+
            "\1\112",
            "\1\117",
            "\1\120",
            "\1\121\7\uffff\1\123\5\uffff\1\122",
            "\1\126\6\uffff\1\124\6\uffff\1\127\2\uffff\1\125",
            "",
            "",
            "\1\135\3\uffff\1\132\11\uffff\1\133\1\134\6\uffff\1\136",
            "",
            "",
            "",
            "\1\142",
            "\1\145\7\uffff\1\144\5\uffff\1\146\2\uffff\1\143",
            "\1\147",
            "\1\151\23\uffff\1\150",
            "\1\152\2\uffff\1\155\6\uffff\1\154\2\uffff\1\156\6\uffff\1"+
            "\153",
            "\1\157",
            "",
            "\1\162",
            "\1\164\13\uffff\1\165",
            "\1\167\23\uffff\1\166",
            "\1\170",
            "",
            "\1\173",
            "",
            "\1\176",
            "\1\u0080\4\uffff\1\u0081",
            "",
            "",
            "",
            "",
            "",
            "\1\u0089\26\uffff\1\u0089\37\uffff\1\u0089",
            "\1\u0089\1\uffff\12\u008a\13\uffff\1\u0089\37\uffff\1\u0089",
            "",
            "\12\u008b\7\uffff\6\u008b",
            "\0\u008c",
            "\0\u008c",
            "",
            "",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22"+
            "\64\1\u0091\7\64",
            "",
            "",
            "",
            "",
            "",
            "\1\u0094\16\uffff\1\u0093",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0096",
            "\1\u0097",
            "",
            "\1\u0098",
            "\1\u009b\60\uffff\1\u0099\7\uffff\1\u009a",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a7\14\uffff\1\u00a6",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00af\5\uffff\1\u00ad\1\u00ae\6\uffff\1\u00ac",
            "\1\u00b0\5\uffff\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "",
            "\1\u00ba\7\uffff\1\u00b9",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "",
            "",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "",
            "",
            "",
            "",
            "",
            "\1\u00cc",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00ce",
            "\1\u00cf",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00d2\3\uffff\1\u00d5\15\uffff\1\u00d3\1\u00d1\1\u00d0\1"+
            "\u00d4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0089\1\uffff\12\u008a\13\uffff\1\u0089\37\uffff\1\u0089",
            "",
            "",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00e0",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00e4",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00e6\16\uffff\1\u00e7\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\64\13\uffff\12\64\1\u00f8\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\u00fa",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "",
            "\1\u010b",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0112",
            "",
            "",
            "\1\u0113",
            "\1\u0114",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\64\13\uffff\12\64\1\u011b\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\u011d",
            "\1\u011e",
            "",
            "\1\u011f",
            "",
            "",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "\1\u012c",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "",
            "",
            "\1\u0132",
            "",
            "",
            "\1\u0133",
            "\1\u0134",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0136",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0137",
            "\1\u0138",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u013a",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u013d",
            "\1\64\13\uffff\12\64\1\u013e\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\u0140",
            "",
            "\1\u0141",
            "\1\64\13\uffff\12\64\1\u0142\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\u0144",
            "\1\u0145",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0147",
            "\1\u0148",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\u014a\1\uffff"+
            "\32\64",
            "\1\u014c",
            "\1\u014d",
            "\1\u014e",
            "\1\64\13\uffff\12\64\1\u014f\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "",
            "",
            "",
            "\1\u0151",
            "\1\u0152",
            "",
            "\1\u0153",
            "\1\64\13\uffff\12\64\1\u0154\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\u0156",
            "\1\u0157",
            "\1\u0158",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u015e",
            "\1\u015f",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0166",
            "",
            "\1\u0167",
            "",
            "",
            "\1\u0168",
            "",
            "",
            "\1\64\13\uffff\12\64\1\u0169\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\u016b",
            "",
            "",
            "",
            "\1\u016c",
            "",
            "\1\u016d",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u016e\14\uffff\1\u016f",
            "",
            "\1\u0170",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "\1\64\13\uffff\12\64\1\u0172\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0175",
            "",
            "",
            "\1\u0176",
            "\1\u0177",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "",
            "\1\u017c",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\22"+
            "\64\1\u017d\7\64",
            "\1\u017f",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "",
            "\1\u0182",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u0184",
            "",
            "",
            "\1\u0185",
            "\1\u0186",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "",
            "",
            "",
            "",
            "\1\u018b",
            "\1\u018c",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "\1\64\13\uffff\12\64\1\u0194\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "",
            "\1\u0196",
            "",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "",
            "\1\u019b",
            "",
            "",
            "\1\u019c",
            "\1\u019d",
            "\1\64\13\uffff\12\64\1\u019e\6\uffff\32\64\4\uffff\1\64\1\uffff"+
            "\32\64",
            "\1\u01a0",
            "",
            "",
            "",
            "",
            "\1\u01a2\10\uffff\1\u01a1",
            "\1\u01a3",
            "\1\u01a4",
            "\1\u01a5",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u01a7",
            "\1\u01a8",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "",
            "\1\u01aa",
            "\1\u01ab",
            "\1\u01ac",
            "",
            "",
            "\1\u01ad",
            "",
            "",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "\1\u01b6",
            "",
            "\1\u01b7",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            "\1\u01ba",
            "",
            "",
            "\1\u01bb",
            "\1\u01bc",
            "\1\u01bd",
            "\1\u01be",
            "\1\64\13\uffff\12\64\7\uffff\32\64\4\uffff\1\64\1\uffff\32"+
            "\64",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | T__110 | T__111 | T__112 | T__113 | T__114 | T__115 | T__116 | T__117 | T__118 | T__119 | T__120 | T__121 | T__122 | T__123 | RULE_KEYWORD | RULE_INTEGER | RULE_BOOLEAN | RULE_ID | RULE_COLOR | RULE_DOUBLE | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_45 = input.LA(1);

                        s = -1;
                        if ( ((LA27_45>='\u0000' && LA27_45<='\uFFFF')) ) {s = 140;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_44 = input.LA(1);

                        s = -1;
                        if ( ((LA27_44>='\u0000' && LA27_44<='\uFFFF')) ) {s = 140;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_0 = input.LA(1);

                        s = -1;
                        if ( (LA27_0=='m') ) {s = 1;}

                        else if ( (LA27_0=='<') ) {s = 2;}

                        else if ( (LA27_0=='i') ) {s = 3;}

                        else if ( (LA27_0==';') ) {s = 4;}

                        else if ( (LA27_0=='a') ) {s = 5;}

                        else if ( (LA27_0=='l') ) {s = 6;}

                        else if ( (LA27_0=='c') ) {s = 7;}

                        else if ( (LA27_0=='e') ) {s = 8;}

                        else if ( (LA27_0=='r') ) {s = 9;}

                        else if ( (LA27_0=='v') ) {s = 10;}

                        else if ( (LA27_0=='n') ) {s = 11;}

                        else if ( (LA27_0=='w') ) {s = 12;}

                        else if ( (LA27_0=='(') ) {s = 13;}

                        else if ( (LA27_0==')') ) {s = 14;}

                        else if ( (LA27_0=='s') ) {s = 15;}

                        else if ( (LA27_0=='{') ) {s = 16;}

                        else if ( (LA27_0=='}') ) {s = 17;}

                        else if ( (LA27_0=='=') ) {s = 18;}

                        else if ( (LA27_0=='g') ) {s = 19;}

                        else if ( (LA27_0=='d') ) {s = 20;}

                        else if ( (LA27_0=='u') ) {s = 21;}

                        else if ( (LA27_0=='p') ) {s = 22;}

                        else if ( (LA27_0=='t') ) {s = 23;}

                        else if ( (LA27_0=='>') ) {s = 24;}

                        else if ( (LA27_0==',') ) {s = 25;}

                        else if ( (LA27_0==':') ) {s = 26;}

                        else if ( (LA27_0=='o') ) {s = 27;}

                        else if ( (LA27_0=='f') ) {s = 28;}

                        else if ( (LA27_0=='-') ) {s = 29;}

                        else if ( (LA27_0=='?') ) {s = 30;}

                        else if ( (LA27_0=='!') ) {s = 31;}

                        else if ( (LA27_0=='+') ) {s = 32;}

                        else if ( (LA27_0=='*') ) {s = 33;}

                        else if ( (LA27_0=='/') ) {s = 34;}

                        else if ( (LA27_0=='^') ) {s = 35;}

                        else if ( (LA27_0=='\u00B0') ) {s = 36;}

                        else if ( (LA27_0=='[') ) {s = 37;}

                        else if ( (LA27_0==']') ) {s = 38;}

                        else if ( (LA27_0=='.') ) {s = 39;}

                        else if ( (LA27_0=='0') ) {s = 40;}

                        else if ( ((LA27_0>='1' && LA27_0<='9')) ) {s = 41;}

                        else if ( (LA27_0=='$'||(LA27_0>='A' && LA27_0<='Z')||LA27_0=='_'||LA27_0=='b'||LA27_0=='h'||(LA27_0>='j' && LA27_0<='k')||LA27_0=='q'||(LA27_0>='x' && LA27_0<='z')) ) {s = 42;}

                        else if ( (LA27_0=='#') ) {s = 43;}

                        else if ( (LA27_0=='\"') ) {s = 44;}

                        else if ( (LA27_0=='\'') ) {s = 45;}

                        else if ( ((LA27_0>='\t' && LA27_0<='\n')||LA27_0=='\r'||LA27_0==' ') ) {s = 46;}

                        else if ( ((LA27_0>='\u0000' && LA27_0<='\b')||(LA27_0>='\u000B' && LA27_0<='\f')||(LA27_0>='\u000E' && LA27_0<='\u001F')||(LA27_0>='%' && LA27_0<='&')||LA27_0=='@'||LA27_0=='\\'||LA27_0=='`'||LA27_0=='|'||(LA27_0>='~' && LA27_0<='\u00AF')||(LA27_0>='\u00B1' && LA27_0<='\uFFFF')) ) {s = 47;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}