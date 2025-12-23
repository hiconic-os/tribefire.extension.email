// Generated from res/SearchTerm.g4 by ANTLR 4.13.2

package com.braintribe.model.processing.email.search;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SearchTermParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NOT=14, AND=15, OR=16, EQ=17, LT=18, 
		LE=19, GT=20, GE=21, NE=22, STRING=23, DIGIT=24, SPACE=25;
	public static final int
		RULE_searchTerm = 0, RULE_negation = 1, RULE_conjunction = 2, RULE_disjunction = 3, 
		RULE_from = 4, RULE_to = 5, RULE_cc = 6, RULE_bcc = 7, RULE_unread = 8, 
		RULE_older = 9, RULE_younger = 10, RULE_recvdate = 11, RULE_sentdate = 12, 
		RULE_body = 13, RULE_subject = 14, RULE_expression = 15, RULE_decimal = 16, 
		RULE_operator = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"searchTerm", "negation", "conjunction", "disjunction", "from", "to", 
			"cc", "bcc", "unread", "older", "younger", "recvdate", "sentdate", "body", 
			"subject", "expression", "decimal", "operator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'from'", "'to'", "'cc'", "'bcc'", "'unread'", "'older'", 
			"'younger'", "'recvdate'", "'sentdate'", "'body'", "'subject'", "'not'", 
			"'and'", "'or'", "'='", "'<'", "'<='", "'>'", "'>='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "NOT", "AND", "OR", "EQ", "LT", "LE", "GT", "GE", "NE", "STRING", 
			"DIGIT", "SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "SearchTerm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SearchTermParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SearchTermContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public ConjunctionContext conjunction() {
			return getRuleContext(ConjunctionContext.class,0);
		}
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public ToContext to() {
			return getRuleContext(ToContext.class,0);
		}
		public CcContext cc() {
			return getRuleContext(CcContext.class,0);
		}
		public BccContext bcc() {
			return getRuleContext(BccContext.class,0);
		}
		public UnreadContext unread() {
			return getRuleContext(UnreadContext.class,0);
		}
		public OlderContext older() {
			return getRuleContext(OlderContext.class,0);
		}
		public YoungerContext younger() {
			return getRuleContext(YoungerContext.class,0);
		}
		public RecvdateContext recvdate() {
			return getRuleContext(RecvdateContext.class,0);
		}
		public SentdateContext sentdate() {
			return getRuleContext(SentdateContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public SubjectContext subject() {
			return getRuleContext(SubjectContext.class,0);
		}
		public SearchTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchTerm; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitSearchTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchTermContext searchTerm() throws RecognitionException {
		SearchTermContext _localctx = new SearchTermContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_searchTerm);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				negation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				conjunction();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				disjunction();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				from();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				to();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
				cc();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(42);
				bcc();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(43);
				unread();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(44);
				older();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(45);
				younger();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(46);
				recvdate();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(47);
				sentdate();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(48);
				body();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(49);
				subject();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class NegationContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SearchTermParser.NOT, 0); }
		public SearchTermContext searchTerm() {
			return getRuleContext(SearchTermContext.class,0);
		}
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_negation);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(NOT);
				setState(53);
				match(T__0);
				setState(54);
				searchTerm();
				setState(55);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(NOT);
				setState(58);
				searchTerm();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConjunctionContext extends ParserRuleContext {
		public List<SearchTermContext> searchTerm() {
			return getRuleContexts(SearchTermContext.class);
		}
		public SearchTermContext searchTerm(int i) {
			return getRuleContext(SearchTermContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SearchTermParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SearchTermParser.AND, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(T__0);
			setState(62);
			searchTerm();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(63);
				match(AND);
				setState(64);
				searchTerm();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DisjunctionContext extends ParserRuleContext {
		public List<SearchTermContext> searchTerm() {
			return getRuleContexts(SearchTermContext.class);
		}
		public SearchTermContext searchTerm(int i) {
			return getRuleContext(SearchTermContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SearchTermParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SearchTermParser.OR, i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__0);
			setState(73);
			searchTerm();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(74);
				match(OR);
				setState(75);
				searchTerm();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(81);
			match(T__1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FromContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SearchTermParser.EQ, 0); }
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitFrom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_from);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(T__2);
				setState(84);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(T__2);
				setState(86);
				match(EQ);
				setState(87);
				expression();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ToContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SearchTermParser.EQ, 0); }
		public ToContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_to; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitTo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ToContext to() throws RecognitionException {
		ToContext _localctx = new ToContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_to);
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__3);
				setState(91);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__3);
				setState(93);
				match(EQ);
				setState(94);
				expression();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class CcContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SearchTermParser.EQ, 0); }
		public CcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitCc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CcContext cc() throws RecognitionException {
		CcContext _localctx = new CcContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cc);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				match(T__4);
				setState(98);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(T__4);
				setState(100);
				match(EQ);
				setState(101);
				expression();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class BccContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SearchTermParser.EQ, 0); }
		public BccContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bcc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitBcc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BccContext bcc() throws RecognitionException {
		BccContext _localctx = new BccContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bcc);
		try {
			setState(109);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(T__5);
				setState(105);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(T__5);
				setState(107);
				match(EQ);
				setState(108);
				expression();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnreadContext extends ParserRuleContext {
		public UnreadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unread; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitUnread(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnreadContext unread() throws RecognitionException {
		UnreadContext _localctx = new UnreadContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unread);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__6);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OlderContext extends ParserRuleContext {
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public OlderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_older; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitOlder(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OlderContext older() throws RecognitionException {
		OlderContext _localctx = new OlderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_older);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__7);
			setState(114);
			decimal();
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

	@SuppressWarnings("CheckReturnValue")
	public static class YoungerContext extends ParserRuleContext {
		public DecimalContext decimal() {
			return getRuleContext(DecimalContext.class,0);
		}
		public YoungerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_younger; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitYounger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final YoungerContext younger() throws RecognitionException {
		YoungerContext _localctx = new YoungerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_younger);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__8);
			setState(117);
			decimal();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RecvdateContext extends ParserRuleContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RecvdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recvdate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitRecvdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RecvdateContext recvdate() throws RecognitionException {
		RecvdateContext _localctx = new RecvdateContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_recvdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__9);
			setState(120);
			operator();
			setState(121);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentdateContext extends ParserRuleContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SentdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentdate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitSentdate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SentdateContext sentdate() throws RecognitionException {
		SentdateContext _localctx = new SentdateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sentdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__10);
			setState(124);
			operator();
			setState(125);
			expression();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SearchTermParser.EQ, 0); }
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_body);
		try {
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(T__11);
				setState(128);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__11);
				setState(130);
				match(EQ);
				setState(131);
				expression();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class SubjectContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EQ() { return getToken(SearchTermParser.EQ, 0); }
		public SubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubjectContext subject() throws RecognitionException {
		SubjectContext _localctx = new SubjectContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_subject);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(T__12);
				setState(135);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(T__12);
				setState(137);
				match(EQ);
				setState(138);
				expression();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SearchTermParser.STRING, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DecimalContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(SearchTermParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(SearchTermParser.DIGIT, i);
		}
		public DecimalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decimal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecimalContext decimal() throws RecognitionException {
		DecimalContext _localctx = new DecimalContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_decimal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				match(DIGIT);
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SearchTermParser.EQ, 0); }
		public TerminalNode LT() { return getToken(SearchTermParser.LT, 0); }
		public TerminalNode LE() { return getToken(SearchTermParser.LE, 0); }
		public TerminalNode GT() { return getToken(SearchTermParser.GT, 0); }
		public TerminalNode GE() { return getToken(SearchTermParser.GE, 0); }
		public TerminalNode NE() { return getToken(SearchTermParser.NE, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SearchTermVisitor ) return ((SearchTermVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8257536L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u0097\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0003\u00003\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001<\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002B\b\u0002\n\u0002"+
		"\f\u0002E\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004Y\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005`\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006g\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007n\b\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0085\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u008c\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0004\u0010\u0091\b\u0010\u000b\u0010\f"+
		"\u0010\u0092\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"\u0000\u0001\u0001\u0000\u0011\u0016\u009b\u00002\u0001\u0000"+
		"\u0000\u0000\u0002;\u0001\u0000\u0000\u0000\u0004=\u0001\u0000\u0000\u0000"+
		"\u0006H\u0001\u0000\u0000\u0000\bX\u0001\u0000\u0000\u0000\n_\u0001\u0000"+
		"\u0000\u0000\ff\u0001\u0000\u0000\u0000\u000em\u0001\u0000\u0000\u0000"+
		"\u0010o\u0001\u0000\u0000\u0000\u0012q\u0001\u0000\u0000\u0000\u0014t"+
		"\u0001\u0000\u0000\u0000\u0016w\u0001\u0000\u0000\u0000\u0018{\u0001\u0000"+
		"\u0000\u0000\u001a\u0084\u0001\u0000\u0000\u0000\u001c\u008b\u0001\u0000"+
		"\u0000\u0000\u001e\u008d\u0001\u0000\u0000\u0000 \u0090\u0001\u0000\u0000"+
		"\u0000\"\u0094\u0001\u0000\u0000\u0000$3\u0003\u0002\u0001\u0000%3\u0003"+
		"\u0004\u0002\u0000&3\u0003\u0006\u0003\u0000\'3\u0003\b\u0004\u0000(3"+
		"\u0003\n\u0005\u0000)3\u0003\f\u0006\u0000*3\u0003\u000e\u0007\u0000+"+
		"3\u0003\u0010\b\u0000,3\u0003\u0012\t\u0000-3\u0003\u0014\n\u0000.3\u0003"+
		"\u0016\u000b\u0000/3\u0003\u0018\f\u000003\u0003\u001a\r\u000013\u0003"+
		"\u001c\u000e\u00002$\u0001\u0000\u0000\u00002%\u0001\u0000\u0000\u0000"+
		"2&\u0001\u0000\u0000\u00002\'\u0001\u0000\u0000\u00002(\u0001\u0000\u0000"+
		"\u00002)\u0001\u0000\u0000\u00002*\u0001\u0000\u0000\u00002+\u0001\u0000"+
		"\u0000\u00002,\u0001\u0000\u0000\u00002-\u0001\u0000\u0000\u00002.\u0001"+
		"\u0000\u0000\u00002/\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"21\u0001\u0000\u0000\u00003\u0001\u0001\u0000\u0000\u000045\u0005\u000e"+
		"\u0000\u000056\u0005\u0001\u0000\u000067\u0003\u0000\u0000\u000078\u0005"+
		"\u0002\u0000\u00008<\u0001\u0000\u0000\u00009:\u0005\u000e\u0000\u0000"+
		":<\u0003\u0000\u0000\u0000;4\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000<\u0003\u0001\u0000\u0000\u0000=>\u0005\u0001\u0000\u0000>C\u0003"+
		"\u0000\u0000\u0000?@\u0005\u000f\u0000\u0000@B\u0003\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000"+
		"\u0000CD\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0002\u0000\u0000G\u0005\u0001\u0000\u0000\u0000"+
		"HI\u0005\u0001\u0000\u0000IN\u0003\u0000\u0000\u0000JK\u0005\u0010\u0000"+
		"\u0000KM\u0003\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MP\u0001\u0000"+
		"\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OQ\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0005\u0002\u0000\u0000"+
		"R\u0007\u0001\u0000\u0000\u0000ST\u0005\u0003\u0000\u0000TY\u0003\u001e"+
		"\u000f\u0000UV\u0005\u0003\u0000\u0000VW\u0005\u0011\u0000\u0000WY\u0003"+
		"\u001e\u000f\u0000XS\u0001\u0000\u0000\u0000XU\u0001\u0000\u0000\u0000"+
		"Y\t\u0001\u0000\u0000\u0000Z[\u0005\u0004\u0000\u0000[`\u0003\u001e\u000f"+
		"\u0000\\]\u0005\u0004\u0000\u0000]^\u0005\u0011\u0000\u0000^`\u0003\u001e"+
		"\u000f\u0000_Z\u0001\u0000\u0000\u0000_\\\u0001\u0000\u0000\u0000`\u000b"+
		"\u0001\u0000\u0000\u0000ab\u0005\u0005\u0000\u0000bg\u0003\u001e\u000f"+
		"\u0000cd\u0005\u0005\u0000\u0000de\u0005\u0011\u0000\u0000eg\u0003\u001e"+
		"\u000f\u0000fa\u0001\u0000\u0000\u0000fc\u0001\u0000\u0000\u0000g\r\u0001"+
		"\u0000\u0000\u0000hi\u0005\u0006\u0000\u0000in\u0003\u001e\u000f\u0000"+
		"jk\u0005\u0006\u0000\u0000kl\u0005\u0011\u0000\u0000ln\u0003\u001e\u000f"+
		"\u0000mh\u0001\u0000\u0000\u0000mj\u0001\u0000\u0000\u0000n\u000f\u0001"+
		"\u0000\u0000\u0000op\u0005\u0007\u0000\u0000p\u0011\u0001\u0000\u0000"+
		"\u0000qr\u0005\b\u0000\u0000rs\u0003 \u0010\u0000s\u0013\u0001\u0000\u0000"+
		"\u0000tu\u0005\t\u0000\u0000uv\u0003 \u0010\u0000v\u0015\u0001\u0000\u0000"+
		"\u0000wx\u0005\n\u0000\u0000xy\u0003\"\u0011\u0000yz\u0003\u001e\u000f"+
		"\u0000z\u0017\u0001\u0000\u0000\u0000{|\u0005\u000b\u0000\u0000|}\u0003"+
		"\"\u0011\u0000}~\u0003\u001e\u000f\u0000~\u0019\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005\f\u0000\u0000\u0080\u0085\u0003\u001e\u000f\u0000\u0081"+
		"\u0082\u0005\f\u0000\u0000\u0082\u0083\u0005\u0011\u0000\u0000\u0083\u0085"+
		"\u0003\u001e\u000f\u0000\u0084\u007f\u0001\u0000\u0000\u0000\u0084\u0081"+
		"\u0001\u0000\u0000\u0000\u0085\u001b\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0005\r\u0000\u0000\u0087\u008c\u0003\u001e\u000f\u0000\u0088\u0089\u0005"+
		"\r\u0000\u0000\u0089\u008a\u0005\u0011\u0000\u0000\u008a\u008c\u0003\u001e"+
		"\u000f\u0000\u008b\u0086\u0001\u0000\u0000\u0000\u008b\u0088\u0001\u0000"+
		"\u0000\u0000\u008c\u001d\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0017"+
		"\u0000\u0000\u008e\u001f\u0001\u0000\u0000\u0000\u008f\u0091\u0005\u0018"+
		"\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093!\u0001\u0000\u0000\u0000\u0094\u0095\u0007\u0000\u0000"+
		"\u0000\u0095#\u0001\u0000\u0000\u0000\u000b2;CNX_fm\u0084\u008b\u0092";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}