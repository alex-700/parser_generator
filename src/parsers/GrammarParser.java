// Generated from D:/программирование/итмо/6 семестр/Методы трансляции/parser_generator/src/parsers\GrammarParser.g4 by ANTLR 4.5.1
package parsers;

import java.util.*;
import llgrammar.LLGrammar;
import llgrammar.Pair;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OSB=1, COLON=2, OR=3, SEMICOLON=4, EQUAL=5, OCB=6, SHARP_START=7, LOCALS=8, 
		RETURNS=9, INIT=10, MEMBERS=11, Nonterm=12, Term=13, Regular=14, WS=15, 
		CSB=16, COMMA=17, Word=18, WS2=19, CCB=20, TEXT=21, SHARP_FINISH=22, CODE=23;
	public static final int
		RULE_rules = 0, RULE_parser_multi_rule = 1, RULE_enumeration = 2, RULE_parser_single_rule = 3, 
		RULE_lexer_rule = 4;
	public static final String[] ruleNames = {
		"rules", "parser_multi_rule", "enumeration", "parser_single_rule", "lexer_rule"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "':'", "'|'", "';'", "'='", "'{'", null, "'locals'", "'returns'", 
		"'@init'", "'@members'", null, null, null, null, "']'", "','", null, null, 
		"'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OSB", "COLON", "OR", "SEMICOLON", "EQUAL", "OCB", "SHARP_START", 
		"LOCALS", "RETURNS", "INIT", "MEMBERS", "Nonterm", "Term", "Regular", 
		"WS", "CSB", "COMMA", "Word", "WS2", "CCB", "TEXT", "SHARP_FINISH", "CODE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GrammarParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RulesContext extends ParserRuleContext {
		public LLGrammar gram;
		public Map<String, String> lex;
		public List<String> orderLex;
		public String membersCode;
		public Map<String, String> init;
		public Token CODE;
		public Parser_multi_ruleContext p;
		public Lexer_ruleContext lexer_rule;
		public TerminalNode MEMBERS() { return getToken(GrammarParser.MEMBERS, 0); }
		public TerminalNode SHARP_START() { return getToken(GrammarParser.SHARP_START, 0); }
		public TerminalNode CODE() { return getToken(GrammarParser.CODE, 0); }
		public TerminalNode SHARP_FINISH() { return getToken(GrammarParser.SHARP_FINISH, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(GrammarParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(GrammarParser.SEMICOLON, i);
		}
		public List<Lexer_ruleContext> lexer_rule() {
			return getRuleContexts(Lexer_ruleContext.class);
		}
		public Lexer_ruleContext lexer_rule(int i) {
			return getRuleContext(Lexer_ruleContext.class,i);
		}
		public List<Parser_multi_ruleContext> parser_multi_rule() {
			return getRuleContexts(Parser_multi_ruleContext.class);
		}
		public Parser_multi_ruleContext parser_multi_rule(int i) {
			return getRuleContext(Parser_multi_ruleContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).exitRules(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rules);

		    ((RulesContext)_localctx).orderLex =  new ArrayList<>();
		    ((RulesContext)_localctx).lex =  new HashMap<>();
		    ((RulesContext)_localctx).gram =  new LLGrammar();
		    ((RulesContext)_localctx).membersCode =  "";
		    ((RulesContext)_localctx).init =  new HashMap<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_la = _input.LA(1);
			if (_la==MEMBERS) {
				{
				setState(10);
				match(MEMBERS);
				setState(11);
				match(SHARP_START);
				setState(12);
				((RulesContext)_localctx).CODE = match(CODE);
				setState(13);
				match(SHARP_FINISH);
				 ((RulesContext)_localctx).membersCode =  (((RulesContext)_localctx).CODE!=null?((RulesContext)_localctx).CODE.getText():null); 
				}
			}

			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				switch (_input.LA(1)) {
				case Nonterm:
					{
					{
					setState(17);
					((RulesContext)_localctx).p = parser_multi_rule();

					        _localctx.gram.addRules(((RulesContext)_localctx).p.nonterm, ((RulesContext)_localctx).p.multi_rule, ((RulesContext)_localctx).p.multi_args);
					        _localctx.gram.addEpsilon(((RulesContext)_localctx).p.epsilon);
					        _localctx.gram.addAttrs(((RulesContext)_localctx).p.nonterm, ((RulesContext)_localctx).p.args, ((RulesContext)_localctx).p.rets);
					        _localctx.init.put(((RulesContext)_localctx).p.nonterm, ((RulesContext)_localctx).p.initBlock);
					    
					}
					}
					break;
				case Term:
					{
					{
					setState(20);
					((RulesContext)_localctx).lexer_rule = lexer_rule();

					        _localctx.lex.put(((RulesContext)_localctx).lexer_rule.term, ((RulesContext)_localctx).lexer_rule.regexp);
					        _localctx.orderLex.add(((RulesContext)_localctx).lexer_rule.term);
					    
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(25);
				match(SEMICOLON);
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Nonterm || _la==Term );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parser_multi_ruleContext extends ParserRuleContext {
		public String nonterm;
		public List<List<String>> multi_rule;
		public List<List<String>> multi_args;
		public Set<String> epsilon;
		public List<Pair> args;
		public List<Pair> rets;
		public String initBlock;
		public Token Nonterm;
		public EnumerationContext e;
		public Token TEXT;
		public Parser_single_ruleContext p;
		public TerminalNode Nonterm() { return getToken(GrammarParser.Nonterm, 0); }
		public TerminalNode COLON() { return getToken(GrammarParser.COLON, 0); }
		public List<TerminalNode> OSB() { return getTokens(GrammarParser.OSB); }
		public TerminalNode OSB(int i) {
			return getToken(GrammarParser.OSB, i);
		}
		public List<TerminalNode> CSB() { return getTokens(GrammarParser.CSB); }
		public TerminalNode CSB(int i) {
			return getToken(GrammarParser.CSB, i);
		}
		public TerminalNode RETURNS() { return getToken(GrammarParser.RETURNS, 0); }
		public TerminalNode LOCALS() { return getToken(GrammarParser.LOCALS, 0); }
		public TerminalNode INIT() { return getToken(GrammarParser.INIT, 0); }
		public TerminalNode OCB() { return getToken(GrammarParser.OCB, 0); }
		public TerminalNode TEXT() { return getToken(GrammarParser.TEXT, 0); }
		public TerminalNode CCB() { return getToken(GrammarParser.CCB, 0); }
		public List<TerminalNode> OR() { return getTokens(GrammarParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(GrammarParser.OR, i);
		}
		public List<Parser_single_ruleContext> parser_single_rule() {
			return getRuleContexts(Parser_single_ruleContext.class);
		}
		public Parser_single_ruleContext parser_single_rule(int i) {
			return getRuleContext(Parser_single_ruleContext.class,i);
		}
		public List<EnumerationContext> enumeration() {
			return getRuleContexts(EnumerationContext.class);
		}
		public EnumerationContext enumeration(int i) {
			return getRuleContext(EnumerationContext.class,i);
		}
		public Parser_multi_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parser_multi_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).enterParser_multi_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).exitParser_multi_rule(this);
		}
	}

	public final Parser_multi_ruleContext parser_multi_rule() throws RecognitionException {
		Parser_multi_ruleContext _localctx = new Parser_multi_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parser_multi_rule);

		    ((Parser_multi_ruleContext)_localctx).multi_rule =  new ArrayList<>();
		    ((Parser_multi_ruleContext)_localctx).multi_args =  new ArrayList<>();
		    ((Parser_multi_ruleContext)_localctx).epsilon =  new HashSet<>();
		    ((Parser_multi_ruleContext)_localctx).args =  new ArrayList<>();
		    ((Parser_multi_ruleContext)_localctx).rets =  new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			((Parser_multi_ruleContext)_localctx).Nonterm = match(Nonterm);
			 ((Parser_multi_ruleContext)_localctx).nonterm =  (((Parser_multi_ruleContext)_localctx).Nonterm!=null?((Parser_multi_ruleContext)_localctx).Nonterm.getText():null); 
			setState(38);
			_la = _input.LA(1);
			if (_la==OSB) {
				{
				setState(33);
				match(OSB);
				{
				setState(34);
				((Parser_multi_ruleContext)_localctx).e = enumeration();
				}
				 ((Parser_multi_ruleContext)_localctx).args =  ((Parser_multi_ruleContext)_localctx).e.decl; 
				setState(36);
				match(CSB);
				}
			}

			setState(46);
			_la = _input.LA(1);
			if (_la==RETURNS) {
				{
				setState(40);
				match(RETURNS);
				setState(41);
				match(OSB);
				{
				setState(42);
				((Parser_multi_ruleContext)_localctx).e = enumeration();
				}
				 ((Parser_multi_ruleContext)_localctx).rets =  ((Parser_multi_ruleContext)_localctx).e.decl; 
				setState(44);
				match(CSB);
				}
			}

			setState(54);
			_la = _input.LA(1);
			if (_la==LOCALS) {
				{
				setState(48);
				match(LOCALS);
				setState(49);
				match(OSB);
				{
				setState(50);
				((Parser_multi_ruleContext)_localctx).e = enumeration();
				}
				 _localctx.rets.addAll(((Parser_multi_ruleContext)_localctx).e.decl); 
				setState(52);
				match(CSB);
				}
			}

			setState(61);
			_la = _input.LA(1);
			if (_la==INIT) {
				{
				setState(56);
				match(INIT);
				setState(57);
				match(OCB);
				setState(58);
				((Parser_multi_ruleContext)_localctx).TEXT = match(TEXT);
				setState(59);
				match(CCB);
				 ((Parser_multi_ruleContext)_localctx).initBlock =  (((Parser_multi_ruleContext)_localctx).TEXT!=null?((Parser_multi_ruleContext)_localctx).TEXT.getText():null); 
				}
			}

			setState(63);
			match(COLON);
			{
			{
			setState(64);
			((Parser_multi_ruleContext)_localctx).p = parser_single_rule(_localctx.args, _localctx.rets);
			}

			                if (((Parser_multi_ruleContext)_localctx).p.rule.size() == 0) {
			                    _localctx.epsilon.add(_localctx.nonterm);
			                }
			                _localctx.multi_rule.add(((Parser_multi_ruleContext)_localctx).p.rule);
			                _localctx.multi_args.add(((Parser_multi_ruleContext)_localctx).p.args);
			             
			}
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(67);
				match(OR);
				{
				setState(68);
				((Parser_multi_ruleContext)_localctx).p = parser_single_rule(_localctx.args, _localctx.rets);
				}

				                if (((Parser_multi_ruleContext)_localctx).p.rule.size() == 0) {
				                    _localctx.epsilon.add(_localctx.nonterm);
				                }
				                _localctx.multi_rule.add(((Parser_multi_ruleContext)_localctx).p.rule);
				                _localctx.multi_args.add(((Parser_multi_ruleContext)_localctx).p.args);
				             
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumerationContext extends ParserRuleContext {
		public List<Pair> decl;
		public Token type;
		public Token name;
		public List<TerminalNode> Word() { return getTokens(GrammarParser.Word); }
		public TerminalNode Word(int i) {
			return getToken(GrammarParser.Word, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public EnumerationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).enterEnumeration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).exitEnumeration(this);
		}
	}

	public final EnumerationContext enumeration() throws RecognitionException {
		EnumerationContext _localctx = new EnumerationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_enumeration);

		    ((EnumerationContext)_localctx).decl =  new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(76);
			((EnumerationContext)_localctx).type = match(Word);
			}
			{
			setState(77);
			((EnumerationContext)_localctx).name = match(Word);
			}
			 _localctx.decl.add(new Pair((((EnumerationContext)_localctx).type!=null?((EnumerationContext)_localctx).type.getText():null), (((EnumerationContext)_localctx).name!=null?((EnumerationContext)_localctx).name.getText():null))); 
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(79);
				match(COMMA);
				{
				setState(80);
				((EnumerationContext)_localctx).type = match(Word);
				}
				{
				setState(81);
				((EnumerationContext)_localctx).name = match(Word);
				}
				 _localctx.decl.add(new Pair((((EnumerationContext)_localctx).type!=null?((EnumerationContext)_localctx).type.getText():null), (((EnumerationContext)_localctx).name!=null?((EnumerationContext)_localctx).name.getText():null))); 
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parser_single_ruleContext extends ParserRuleContext {
		public List<Pair> ruleArgs;
		public List<Pair> ruleRets;
		public List<String> rule;
		public List<String> args;
		public int cnt;
		public Map<String, String> defines;
		public String code;
		public List<String> arguments;
		public Token def;
		public Token word;
		public Token Word;
		public Token TEXT;
		public List<TerminalNode> OCB() { return getTokens(GrammarParser.OCB); }
		public TerminalNode OCB(int i) {
			return getToken(GrammarParser.OCB, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(GrammarParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(GrammarParser.TEXT, i);
		}
		public List<TerminalNode> CCB() { return getTokens(GrammarParser.CCB); }
		public TerminalNode CCB(int i) {
			return getToken(GrammarParser.CCB, i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(GrammarParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(GrammarParser.EQUAL, i);
		}
		public List<TerminalNode> OSB() { return getTokens(GrammarParser.OSB); }
		public TerminalNode OSB(int i) {
			return getToken(GrammarParser.OSB, i);
		}
		public List<TerminalNode> CSB() { return getTokens(GrammarParser.CSB); }
		public TerminalNode CSB(int i) {
			return getToken(GrammarParser.CSB, i);
		}
		public List<TerminalNode> Nonterm() { return getTokens(GrammarParser.Nonterm); }
		public TerminalNode Nonterm(int i) {
			return getToken(GrammarParser.Nonterm, i);
		}
		public List<TerminalNode> Term() { return getTokens(GrammarParser.Term); }
		public TerminalNode Term(int i) {
			return getToken(GrammarParser.Term, i);
		}
		public List<TerminalNode> Word() { return getTokens(GrammarParser.Word); }
		public TerminalNode Word(int i) {
			return getToken(GrammarParser.Word, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarParser.COMMA, i);
		}
		public Parser_single_ruleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public Parser_single_ruleContext(ParserRuleContext parent, int invokingState, List<Pair> ruleArgs, List<Pair> ruleRets) {
			super(parent, invokingState);
			this.ruleArgs = ruleArgs;
			this.ruleRets = ruleRets;
		}
		@Override public int getRuleIndex() { return RULE_parser_single_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).enterParser_single_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).exitParser_single_rule(this);
		}
	}

	public final Parser_single_ruleContext parser_single_rule(List<Pair> ruleArgs,List<Pair> ruleRets) throws RecognitionException {
		Parser_single_ruleContext _localctx = new Parser_single_ruleContext(_ctx, getState(), ruleArgs, ruleRets);
		enterRule(_localctx, 6, RULE_parser_single_rule);

		    ((Parser_single_ruleContext)_localctx).rule =  new ArrayList<>();
		    ((Parser_single_ruleContext)_localctx).cnt =  0;
		    ((Parser_single_ruleContext)_localctx).defines =  new HashMap<>();
		    for (Pair p : _localctx.ruleArgs) {
		        _localctx.defines.put("$" + p.name, "_c." + p.name);
		    }
		    for (Pair p : _localctx.ruleRets) {
		        _localctx.defines.put("$" + p.name, "_c." + p.name);
		    }
		    ((Parser_single_ruleContext)_localctx).args =  new ArrayList<>();

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OCB) | (1L << Nonterm) | (1L << Term))) != 0)) {
				{
				setState(114);
				switch (_input.LA(1)) {
				case Nonterm:
				case Term:
					{
					{
					setState(90);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						{
						setState(88);
						((Parser_single_ruleContext)_localctx).def = match(Nonterm);
						}
						setState(89);
						match(EQUAL);
						}
						break;
					}
					{
					setState(92);
					((Parser_single_ruleContext)_localctx).word = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==Nonterm || _la==Term) ) {
						((Parser_single_ruleContext)_localctx).word = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}

					        _localctx.rule.add((((Parser_single_ruleContext)_localctx).word!=null?((Parser_single_ruleContext)_localctx).word.getText():null));
					        //System.err.println((((Parser_single_ruleContext)_localctx).def!=null?((Parser_single_ruleContext)_localctx).def.getText():null) + "-> child" + _localctx.cnt);
					        if (((Parser_single_ruleContext)_localctx).def != null) {
					            _localctx.defines.put("$" + (((Parser_single_ruleContext)_localctx).def!=null?((Parser_single_ruleContext)_localctx).def.getText():null), "child" + _localctx.cnt);
					        } else {
					            _localctx.defines.put("$" + (((Parser_single_ruleContext)_localctx).word!=null?((Parser_single_ruleContext)_localctx).word.getText():null), "child" + _localctx.cnt);
					        }
					        _localctx.cnt++;
					        ((Parser_single_ruleContext)_localctx).arguments =  new ArrayList<>();
					        _localctx.args.add("");
					    
					setState(108);
					_la = _input.LA(1);
					if (_la==OSB) {
						{
						setState(94);
						match(OSB);
						{
						setState(95);
						((Parser_single_ruleContext)_localctx).Word = match(Word);
						 _localctx.arguments.add((((Parser_single_ruleContext)_localctx).Word!=null?((Parser_single_ruleContext)_localctx).Word.getText():null)); 
						}
						setState(103);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(98);
							match(COMMA);
							setState(99);
							((Parser_single_ruleContext)_localctx).Word = match(Word);
							 _localctx.arguments.add((((Parser_single_ruleContext)_localctx).Word!=null?((Parser_single_ruleContext)_localctx).Word.getText():null)); 
							}
							}
							setState(105);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(106);
						match(CSB);

						        StringBuilder sb = new StringBuilder();
						        boolean first = true;
						        for (String arg : _localctx.arguments) {
						            for (Map.Entry<String, String> def : _localctx.defines.entrySet()) {
						                arg = arg.replace(def.getKey(), def.getValue());
						            }
						            if (first) {
						                first = false;
						                sb.append(arg);
						            } else {
						                sb.append(", ").append(arg);
						            }
						        }
						        //if (sb.length() != 0) {
						        //    System.err.println(sb);
						        //}
						        _localctx.args.set(_localctx.cnt - 1, sb.toString());
						    
						}
					}

					}
					}
					break;
				case OCB:
					{
					{
					setState(110);
					match(OCB);
					setState(111);
					((Parser_single_ruleContext)_localctx).TEXT = match(TEXT);
					setState(112);
					match(CCB);

					        ((Parser_single_ruleContext)_localctx).code =  (((Parser_single_ruleContext)_localctx).TEXT!=null?((Parser_single_ruleContext)_localctx).TEXT.getText():null);
					        //System.err.println(_localctx.code);
					        //System.err.println(_localctx.defines);
					        for (Map.Entry<String, String> def : _localctx.defines.entrySet()) {
					            ((Parser_single_ruleContext)_localctx).code =  _localctx.code.replace(def.getKey(), def.getValue());
					        }
					        _localctx.rule.add("@" + _localctx.code);
					        _localctx.args.add("");
					        _localctx.cnt++;
					    
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lexer_ruleContext extends ParserRuleContext {
		public String term;
		public String regexp;
		public Token Term;
		public Token Regular;
		public TerminalNode Term() { return getToken(GrammarParser.Term, 0); }
		public TerminalNode COLON() { return getToken(GrammarParser.COLON, 0); }
		public TerminalNode Regular() { return getToken(GrammarParser.Regular, 0); }
		public Lexer_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexer_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).enterLexer_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarParserListener ) ((GrammarParserListener)listener).exitLexer_rule(this);
		}
	}

	public final Lexer_ruleContext lexer_rule() throws RecognitionException {
		Lexer_ruleContext _localctx = new Lexer_ruleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lexer_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(119);
			((Lexer_ruleContext)_localctx).Term = match(Term);
			setState(120);
			match(COLON);
			setState(121);
			((Lexer_ruleContext)_localctx).Regular = match(Regular);
			}
			 ((Lexer_ruleContext)_localctx).term =  (((Lexer_ruleContext)_localctx).Term!=null?((Lexer_ruleContext)_localctx).Term.getText():null); ((Lexer_ruleContext)_localctx).regexp =  (((Lexer_ruleContext)_localctx).Regular!=null?((Lexer_ruleContext)_localctx).Regular.getText():null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u0080\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\5\2\22\n\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2\32\n\2\3\2\3\2\6\2\36\n\2\r\2\16\2\37\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3)\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\39\n\3\3\3\3\3\3\3\3\3\3\3\5\3@\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3J\n\3\f\3\16\3M\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7"+
		"\4V\n\4\f\4\16\4Y\13\4\3\5\3\5\5\5]\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5h\n\5\f\5\16\5k\13\5\3\5\3\5\5\5o\n\5\3\5\3\5\3\5\3\5\7\5u\n"+
		"\5\f\5\16\5x\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\3\3\2"+
		"\16\17\u0088\2\21\3\2\2\2\4!\3\2\2\2\6N\3\2\2\2\bv\3\2\2\2\ny\3\2\2\2"+
		"\f\r\7\r\2\2\r\16\7\t\2\2\16\17\7\31\2\2\17\20\7\30\2\2\20\22\b\2\1\2"+
		"\21\f\3\2\2\2\21\22\3\2\2\2\22\35\3\2\2\2\23\24\5\4\3\2\24\25\b\2\1\2"+
		"\25\32\3\2\2\2\26\27\5\n\6\2\27\30\b\2\1\2\30\32\3\2\2\2\31\23\3\2\2\2"+
		"\31\26\3\2\2\2\32\33\3\2\2\2\33\34\7\6\2\2\34\36\3\2\2\2\35\31\3\2\2\2"+
		"\36\37\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\"\7\16\2\2\"(\b\3"+
		"\1\2#$\7\3\2\2$%\5\6\4\2%&\b\3\1\2&\'\7\22\2\2\')\3\2\2\2(#\3\2\2\2()"+
		"\3\2\2\2)\60\3\2\2\2*+\7\13\2\2+,\7\3\2\2,-\5\6\4\2-.\b\3\1\2./\7\22\2"+
		"\2/\61\3\2\2\2\60*\3\2\2\2\60\61\3\2\2\2\618\3\2\2\2\62\63\7\n\2\2\63"+
		"\64\7\3\2\2\64\65\5\6\4\2\65\66\b\3\1\2\66\67\7\22\2\2\679\3\2\2\28\62"+
		"\3\2\2\289\3\2\2\29?\3\2\2\2:;\7\f\2\2;<\7\b\2\2<=\7\27\2\2=>\7\26\2\2"+
		">@\b\3\1\2?:\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\4\2\2BC\5\b\5\2CD\b\3\1\2"+
		"DK\3\2\2\2EF\7\5\2\2FG\5\b\5\2GH\b\3\1\2HJ\3\2\2\2IE\3\2\2\2JM\3\2\2\2"+
		"KI\3\2\2\2KL\3\2\2\2L\5\3\2\2\2MK\3\2\2\2NO\7\24\2\2OP\7\24\2\2PW\b\4"+
		"\1\2QR\7\23\2\2RS\7\24\2\2ST\7\24\2\2TV\b\4\1\2UQ\3\2\2\2VY\3\2\2\2WU"+
		"\3\2\2\2WX\3\2\2\2X\7\3\2\2\2YW\3\2\2\2Z[\7\16\2\2[]\7\7\2\2\\Z\3\2\2"+
		"\2\\]\3\2\2\2]^\3\2\2\2^_\t\2\2\2_n\b\5\1\2`a\7\3\2\2ab\7\24\2\2bc\b\5"+
		"\1\2ci\3\2\2\2de\7\23\2\2ef\7\24\2\2fh\b\5\1\2gd\3\2\2\2hk\3\2\2\2ig\3"+
		"\2\2\2ij\3\2\2\2jl\3\2\2\2ki\3\2\2\2lm\7\22\2\2mo\b\5\1\2n`\3\2\2\2no"+
		"\3\2\2\2ou\3\2\2\2pq\7\b\2\2qr\7\27\2\2rs\7\26\2\2su\b\5\1\2t\\\3\2\2"+
		"\2tp\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2w\t\3\2\2\2xv\3\2\2\2yz\7\17"+
		"\2\2z{\7\4\2\2{|\7\20\2\2|}\3\2\2\2}~\b\6\1\2~\13\3\2\2\2\20\21\31\37"+
		"(\608?KW\\intv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}