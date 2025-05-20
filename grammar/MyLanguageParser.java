// Generated from grammar/MyLanguage.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, TYPE=2, BOOL=3, FUNCTION=4, IF=5, ELSE=6, WHILE=7, READ=8, WRITE=9, 
		RETURN=10, STRING=11, CHARACTER=12, ID=13, FLOAT=14, DIGITO=15, COMPARISON_OP=16, 
		EQUALS=17, NOT_EQUALS=18, LESS_EQUALS=19, GREATER_EQUALS=20, LESS_THAN=21, 
		GREATER_THAN=22, SYMBOL=23, PLUS=24, PERCENT=25, MINUS=26, MULT=27, DIV=28, 
		ASSIGN=29, LPAREN=30, RPAREN=31, COMMA=32, SEMICOLON=33, LBRACE=34, RBRACE=35, 
		WS=36, COMMENT=37, MULTILINE_COMMENT=38, MULTI_CHARACTER_ERROR=39;
	public static final int
		RULE_program = 0, RULE_statementList = 1, RULE_main = 2, RULE_statementListTail = 3, 
		RULE_statement = 4, RULE_variableDeclarationEmpty = 5, RULE_variableAssigment = 6, 
		RULE_variableDeclarationValue = 7, RULE_functionCallExpr = 8, RULE_argumentList = 9, 
		RULE_functionVariableDeclaration = 10, RULE_variable = 11, RULE_figure = 12, 
		RULE_aritmetica = 13, RULE_whichCondition = 14, RULE_condition = 15, RULE_numbersCondition = 16, 
		RULE_expression1 = 17, RULE_expression2 = 18, RULE_expression3 = 19, RULE_relationOperator2 = 20, 
		RULE_ifStatement = 21, RULE_elsePart = 22, RULE_whileStatement = 23, RULE_functionCall = 24, 
		RULE_functionDeclaration = 25, RULE_parameterList = 26, RULE_parameterListTail = 27, 
		RULE_inputStatement = 28, RULE_outputStatement = 29, RULE_operator = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statementList", "main", "statementListTail", "statement", 
			"variableDeclarationEmpty", "variableAssigment", "variableDeclarationValue", 
			"functionCallExpr", "argumentList", "functionVariableDeclaration", "variable", 
			"figure", "aritmetica", "whichCondition", "condition", "numbersCondition", 
			"expression1", "expression2", "expression3", "relationOperator2", "ifStatement", 
			"elsePart", "whileStatement", "functionCall", "functionDeclaration", 
			"parameterList", "parameterListTail", "inputStatement", "outputStatement", 
			"operator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", null, null, null, null, null, null, null, null, "'return'", 
			null, null, null, null, null, null, "'=='", "'!='", "'<='", "'>='", "'<'", 
			"'>'", null, "'+'", "'mod'", "'-'", "'*'", "'/'", "'='", "'('", "')'", 
			"','", "';'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "TYPE", "BOOL", "FUNCTION", "IF", "ELSE", "WHILE", "READ", 
			"WRITE", "RETURN", "STRING", "CHARACTER", "ID", "FLOAT", "DIGITO", "COMPARISON_OP", 
			"EQUALS", "NOT_EQUALS", "LESS_EQUALS", "GREATER_EQUALS", "LESS_THAN", 
			"GREATER_THAN", "SYMBOL", "PLUS", "PERCENT", "MINUS", "MULT", "DIV", 
			"ASSIGN", "LPAREN", "RPAREN", "COMMA", "SEMICOLON", "LBRACE", "RBRACE", 
			"WS", "COMMENT", "MULTILINE_COMMENT", "MULTI_CHARACTER_ERROR"
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
	public String getGrammarFileName() { return "MyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			statementList();
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
	public static class StatementListContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementList);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				main();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				functionDeclaration();
				setState(66);
				statementList();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class MainContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MyLanguageParser.LBRACE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementListTailContext statementListTail() {
			return getRuleContext(StatementListTailContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MyLanguageParser.RBRACE, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__0);
			setState(71);
			match(LPAREN);
			setState(72);
			match(RPAREN);
			setState(73);
			match(LBRACE);
			setState(74);
			statement();
			setState(75);
			statementListTail();
			setState(76);
			match(RBRACE);
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
	public static class StatementListTailContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementListTailContext statementListTail() {
			return getRuleContext(StatementListTailContext.class,0);
		}
		public StatementListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterStatementListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitStatementListTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitStatementListTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListTailContext statementListTail() throws RecognitionException {
		StatementListTailContext _localctx = new StatementListTailContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statementListTail);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
			case IF:
			case WHILE:
			case READ:
			case WRITE:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				statement();
				setState(79);
				statementListTail();
				}
				break;
			case RETURN:
			case RBRACE:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationEmptyContext variableDeclarationEmpty() {
			return getRuleContext(VariableDeclarationEmptyContext.class,0);
		}
		public VariableAssigmentContext variableAssigment() {
			return getRuleContext(VariableAssigmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public InputStatementContext inputStatement() {
			return getRuleContext(InputStatementContext.class,0);
		}
		public OutputStatementContext outputStatement() {
			return getRuleContext(OutputStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statement);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				variableDeclarationEmpty();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				variableAssigment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				functionCall();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
				inputStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(90);
				outputStatement();
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
	public static class VariableDeclarationEmptyContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(MyLanguageParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public VariableDeclarationValueContext variableDeclarationValue() {
			return getRuleContext(VariableDeclarationValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MyLanguageParser.SEMICOLON, 0); }
		public VariableDeclarationEmptyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationEmpty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterVariableDeclarationEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitVariableDeclarationEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitVariableDeclarationEmpty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationEmptyContext variableDeclarationEmpty() throws RecognitionException {
		VariableDeclarationEmptyContext _localctx = new VariableDeclarationEmptyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableDeclarationEmpty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(TYPE);
			setState(94);
			match(ID);
			setState(95);
			variableDeclarationValue();
			setState(96);
			match(SEMICOLON);
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
	public static class VariableAssigmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MyLanguageParser.ASSIGN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MyLanguageParser.SEMICOLON, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionCallExprContext functionCallExpr() {
			return getRuleContext(FunctionCallExprContext.class,0);
		}
		public VariableAssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterVariableAssigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitVariableAssigment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitVariableAssigment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssigmentContext variableAssigment() throws RecognitionException {
		VariableAssigmentContext _localctx = new VariableAssigmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(ID);
			setState(99);
			match(ASSIGN);
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(100);
				variable();
				}
				break;
			case 2:
				{
				setState(101);
				functionCallExpr();
				}
				break;
			}
			setState(104);
			match(SEMICOLON);
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
	public static class VariableDeclarationValueContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(MyLanguageParser.ASSIGN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public FunctionCallExprContext functionCallExpr() {
			return getRuleContext(FunctionCallExprContext.class,0);
		}
		public VariableDeclarationValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarationValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterVariableDeclarationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitVariableDeclarationValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitVariableDeclarationValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationValueContext variableDeclarationValue() throws RecognitionException {
		VariableDeclarationValueContext _localctx = new VariableDeclarationValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variableDeclarationValue);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(ASSIGN);
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(107);
					variable();
					}
					break;
				case 2:
					{
					setState(108);
					functionCallExpr();
					}
					break;
				}
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class FunctionCallExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public FunctionCallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFunctionCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFunctionCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallExprContext functionCallExpr() throws RecognitionException {
		FunctionCallExprContext _localctx = new FunctionCallExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCallExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
			setState(115);
			match(LPAREN);
			setState(116);
			argumentList();
			setState(117);
			match(RPAREN);
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
	public static class ArgumentListContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MyLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MyLanguageParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_argumentList);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case STRING:
			case ID:
			case FLOAT:
			case DIGITO:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(119);
				variable();
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(120);
					match(COMMA);
					setState(121);
					variable();
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class FunctionVariableDeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(MyLanguageParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public FunctionVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFunctionVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFunctionVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFunctionVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionVariableDeclarationContext functionVariableDeclaration() throws RecognitionException {
		FunctionVariableDeclarationContext _localctx = new FunctionVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionVariableDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(TYPE);
			setState(131);
			match(ID);
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
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(MyLanguageParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(MyLanguageParser.BOOL, 0); }
		public FigureContext figure() {
			return getRuleContext(FigureContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(MyLanguageParser.FLOAT, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public AritmeticaContext aritmetica() {
			return getRuleContext(AritmeticaContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variable);
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				match(STRING);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(BOOL);
				}
				break;
			case DIGITO:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				figure();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(136);
				match(FLOAT);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(137);
				match(ID);
				setState(138);
				aritmetica();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class FigureContext extends ParserRuleContext {
		public TerminalNode DIGITO() { return getToken(MyLanguageParser.DIGITO, 0); }
		public AritmeticaContext aritmetica() {
			return getRuleContext(AritmeticaContext.class,0);
		}
		public FigureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_figure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFigure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFigure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFigure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FigureContext figure() throws RecognitionException {
		FigureContext _localctx = new FigureContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_figure);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(DIGITO);
			setState(142);
			aritmetica();
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
	public static class AritmeticaContext extends ParserRuleContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public AritmeticaContext aritmetica() {
			return getRuleContext(AritmeticaContext.class,0);
		}
		public TerminalNode DIGITO() { return getToken(MyLanguageParser.DIGITO, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public AritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterAritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitAritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitAritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AritmeticaContext aritmetica() throws RecognitionException {
		AritmeticaContext _localctx = new AritmeticaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_aritmetica);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case DIGITO:
			case PLUS:
			case PERCENT:
			case MINUS:
			case MULT:
			case DIV:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				operator();
				setState(145);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==DIGITO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(146);
				aritmetica();
				}
				break;
			case COMPARISON_OP:
			case EQUALS:
			case NOT_EQUALS:
			case RPAREN:
			case COMMA:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class WhichConditionContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(MyLanguageParser.BOOL, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhichConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whichCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterWhichCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitWhichCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitWhichCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhichConditionContext whichCondition() throws RecognitionException {
		WhichConditionContext _localctx = new WhichConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whichCondition);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(BOOL);
				}
				break;
			case STRING:
			case ID:
			case FLOAT:
			case DIGITO:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				condition();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ConditionContext extends ParserRuleContext {
		public NumbersConditionContext numbersCondition() {
			return getRuleContext(NumbersConditionContext.class,0);
		}
		public Expression1Context expression1() {
			return getRuleContext(Expression1Context.class,0);
		}
		public TerminalNode STRING() { return getToken(MyLanguageParser.STRING, 0); }
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condition);
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case DIGITO:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				numbersCondition();
				setState(156);
				expression1();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				match(STRING);
				setState(159);
				expression3();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(ID);
				setState(161);
				expression2();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class NumbersConditionContext extends ParserRuleContext {
		public TerminalNode DIGITO() { return getToken(MyLanguageParser.DIGITO, 0); }
		public TerminalNode FLOAT() { return getToken(MyLanguageParser.FLOAT, 0); }
		public NumbersConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbersCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterNumbersCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitNumbersCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitNumbersCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumbersConditionContext numbersCondition() throws RecognitionException {
		NumbersConditionContext _localctx = new NumbersConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_numbersCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==DIGITO) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expression1Context extends ParserRuleContext {
		public TerminalNode COMPARISON_OP() { return getToken(MyLanguageParser.COMPARISON_OP, 0); }
		public NumbersConditionContext numbersCondition() {
			return getRuleContext(NumbersConditionContext.class,0);
		}
		public Expression1Context expression1() {
			return getRuleContext(Expression1Context.class,0);
		}
		public Expression1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterExpression1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitExpression1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitExpression1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression1Context expression1() throws RecognitionException {
		Expression1Context _localctx = new Expression1Context(_ctx, getState());
		enterRule(_localctx, 34, RULE_expression1);
		try {
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPARISON_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(COMPARISON_OP);
				setState(167);
				numbersCondition();
				setState(168);
				expression1();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Expression2Context extends ParserRuleContext {
		public TerminalNode COMPARISON_OP() { return getToken(MyLanguageParser.COMPARISON_OP, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Expression2Context expression2() {
			return getRuleContext(Expression2Context.class,0);
		}
		public RelationOperator2Context relationOperator2() {
			return getRuleContext(RelationOperator2Context.class,0);
		}
		public Expression2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterExpression2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitExpression2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitExpression2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression2Context expression2() throws RecognitionException {
		Expression2Context _localctx = new Expression2Context(_ctx, getState());
		enterRule(_localctx, 36, RULE_expression2);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPARISON_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(COMPARISON_OP);
				setState(174);
				variable();
				setState(175);
				expression2();
				}
				break;
			case EQUALS:
			case NOT_EQUALS:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				relationOperator2();
				setState(178);
				variable();
				setState(179);
				expression2();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Expression3Context extends ParserRuleContext {
		public RelationOperator2Context relationOperator2() {
			return getRuleContext(RelationOperator2Context.class,0);
		}
		public TerminalNode STRING() { return getToken(MyLanguageParser.STRING, 0); }
		public Expression3Context expression3() {
			return getRuleContext(Expression3Context.class,0);
		}
		public Expression3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterExpression3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitExpression3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitExpression3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression3Context expression3() throws RecognitionException {
		Expression3Context _localctx = new Expression3Context(_ctx, getState());
		enterRule(_localctx, 38, RULE_expression3);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQUALS:
			case NOT_EQUALS:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				relationOperator2();
				setState(185);
				match(STRING);
				setState(186);
				expression3();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class RelationOperator2Context extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(MyLanguageParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(MyLanguageParser.NOT_EQUALS, 0); }
		public RelationOperator2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationOperator2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterRelationOperator2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitRelationOperator2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitRelationOperator2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationOperator2Context relationOperator2() throws RecognitionException {
		RelationOperator2Context _localctx = new RelationOperator2Context(_ctx, getState());
		enterRule(_localctx, 40, RULE_relationOperator2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_la = _input.LA(1);
			if ( !(_la==EQUALS || _la==NOT_EQUALS) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MyLanguageParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public WhichConditionContext whichCondition() {
			return getRuleContext(WhichConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MyLanguageParser.LBRACE, 0); }
		public StatementListTailContext statementListTail() {
			return getRuleContext(StatementListTailContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MyLanguageParser.RBRACE, 0); }
		public ElsePartContext elsePart() {
			return getRuleContext(ElsePartContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(IF);
			setState(194);
			match(LPAREN);
			setState(195);
			whichCondition();
			setState(196);
			match(RPAREN);
			setState(197);
			match(LBRACE);
			setState(198);
			statementListTail();
			setState(199);
			match(RBRACE);
			setState(200);
			elsePart();
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
	public static class ElsePartContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MyLanguageParser.ELSE, 0); }
		public TerminalNode LBRACE() { return getToken(MyLanguageParser.LBRACE, 0); }
		public StatementListTailContext statementListTail() {
			return getRuleContext(StatementListTailContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MyLanguageParser.RBRACE, 0); }
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ElsePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsePart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterElsePart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitElsePart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitElsePart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElsePartContext elsePart() throws RecognitionException {
		ElsePartContext _localctx = new ElsePartContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_elsePart);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(ELSE);
				setState(203);
				match(LBRACE);
				setState(204);
				statementListTail();
				setState(205);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(ELSE);
				setState(208);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MyLanguageParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public WhichConditionContext whichCondition() {
			return getRuleContext(WhichConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MyLanguageParser.LBRACE, 0); }
		public StatementListTailContext statementListTail() {
			return getRuleContext(StatementListTailContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(MyLanguageParser.RBRACE, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(WHILE);
			setState(213);
			match(LPAREN);
			setState(214);
			whichCondition();
			setState(215);
			match(RPAREN);
			setState(216);
			match(LBRACE);
			setState(217);
			statementListTail();
			setState(218);
			match(RBRACE);
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
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MyLanguageParser.SEMICOLON, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(ID);
			setState(221);
			match(LPAREN);
			setState(222);
			parameterList();
			setState(223);
			match(RPAREN);
			setState(224);
			match(SEMICOLON);
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
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(MyLanguageParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MyLanguageParser.LBRACE, 0); }
		public StatementListTailContext statementListTail() {
			return getRuleContext(StatementListTailContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(MyLanguageParser.RETURN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MyLanguageParser.SEMICOLON, 0); }
		public TerminalNode RBRACE() { return getToken(MyLanguageParser.RBRACE, 0); }
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_functionDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(FUNCTION);
			setState(227);
			match(ID);
			setState(228);
			match(LPAREN);
			setState(229);
			parameterList();
			setState(230);
			match(RPAREN);
			setState(231);
			match(LBRACE);
			setState(232);
			statementListTail();
			setState(233);
			match(RETURN);
			setState(234);
			variable();
			setState(235);
			match(SEMICOLON);
			setState(236);
			match(RBRACE);
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
	public static class ParameterListContext extends ParserRuleContext {
		public FunctionVariableDeclarationContext functionVariableDeclaration() {
			return getRuleContext(FunctionVariableDeclarationContext.class,0);
		}
		public ParameterListTailContext parameterListTail() {
			return getRuleContext(ParameterListTailContext.class,0);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parameterList);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				functionVariableDeclaration();
				setState(239);
				parameterListTail();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ParameterListTailContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(MyLanguageParser.COMMA, 0); }
		public FunctionVariableDeclarationContext functionVariableDeclaration() {
			return getRuleContext(FunctionVariableDeclarationContext.class,0);
		}
		public ParameterListTailContext parameterListTail() {
			return getRuleContext(ParameterListTailContext.class,0);
		}
		public ParameterListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterParameterListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitParameterListTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitParameterListTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListTailContext parameterListTail() throws RecognitionException {
		ParameterListTailContext _localctx = new ParameterListTailContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_parameterListTail);
		try {
			setState(249);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(COMMA);
				setState(245);
				functionVariableDeclaration();
				setState(246);
				parameterListTail();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class InputStatementContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(MyLanguageParser.READ, 0); }
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MyLanguageParser.SEMICOLON, 0); }
		public InputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterInputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitInputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitInputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputStatementContext inputStatement() throws RecognitionException {
		InputStatementContext _localctx = new InputStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_inputStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(READ);
			setState(252);
			match(LPAREN);
			setState(253);
			match(ID);
			setState(254);
			match(RPAREN);
			setState(255);
			match(SEMICOLON);
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
	public static class OutputStatementContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(MyLanguageParser.WRITE, 0); }
		public TerminalNode LPAREN() { return getToken(MyLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MyLanguageParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MyLanguageParser.SEMICOLON, 0); }
		public TerminalNode STRING() { return getToken(MyLanguageParser.STRING, 0); }
		public TerminalNode ID() { return getToken(MyLanguageParser.ID, 0); }
		public OutputStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterOutputStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitOutputStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitOutputStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputStatementContext outputStatement() throws RecognitionException {
		OutputStatementContext _localctx = new OutputStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_outputStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(WRITE);
			setState(258);
			match(LPAREN);
			setState(259);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(260);
			match(RPAREN);
			setState(261);
			match(SEMICOLON);
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
		public TerminalNode PLUS() { return getToken(MyLanguageParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MyLanguageParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(MyLanguageParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(MyLanguageParser.DIV, 0); }
		public TerminalNode PERCENT() { return getToken(MyLanguageParser.PERCENT, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MyLanguageListener ) ((MyLanguageListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MyLanguageVisitor ) return ((MyLanguageVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_operator);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				match(PLUS);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(MINUS);
				}
				break;
			case MULT:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				match(MULT);
				}
				break;
			case DIV:
				enterOuterAlt(_localctx, 4);
				{
				setState(266);
				match(DIV);
				}
				break;
			case PERCENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(267);
				match(PERCENT);
				}
				break;
			case ID:
			case DIGITO:
				enterOuterAlt(_localctx, 6);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\u0004\u0001\'\u0110\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001E\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003S\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\\\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006g\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"n\b\u0007\u0001\u0007\u0003\u0007q\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t{\b\t\n\t\f\t~\t\t\u0001\t\u0003"+
		"\t\u0081\b\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u008c\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0096"+
		"\b\r\u0001\u000e\u0001\u000e\u0003\u000e\u009a\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00a3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00ac\b\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u00b7\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00be\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u00d3\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u00f3\b\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u00fa\b\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u010e"+
		"\b\u001e\u0001\u001e\u0000\u0000\u001f\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<\u0000"+
		"\u0004\u0002\u0000\r\r\u000f\u000f\u0001\u0000\u000e\u000f\u0001\u0000"+
		"\u0011\u0012\u0002\u0000\u000b\u000b\r\r\u0112\u0000>\u0001\u0000\u0000"+
		"\u0000\u0002D\u0001\u0000\u0000\u0000\u0004F\u0001\u0000\u0000\u0000\u0006"+
		"R\u0001\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000\n]\u0001\u0000\u0000"+
		"\u0000\fb\u0001\u0000\u0000\u0000\u000ep\u0001\u0000\u0000\u0000\u0010"+
		"r\u0001\u0000\u0000\u0000\u0012\u0080\u0001\u0000\u0000\u0000\u0014\u0082"+
		"\u0001\u0000\u0000\u0000\u0016\u008b\u0001\u0000\u0000\u0000\u0018\u008d"+
		"\u0001\u0000\u0000\u0000\u001a\u0095\u0001\u0000\u0000\u0000\u001c\u0099"+
		"\u0001\u0000\u0000\u0000\u001e\u00a2\u0001\u0000\u0000\u0000 \u00a4\u0001"+
		"\u0000\u0000\u0000\"\u00ab\u0001\u0000\u0000\u0000$\u00b6\u0001\u0000"+
		"\u0000\u0000&\u00bd\u0001\u0000\u0000\u0000(\u00bf\u0001\u0000\u0000\u0000"+
		"*\u00c1\u0001\u0000\u0000\u0000,\u00d2\u0001\u0000\u0000\u0000.\u00d4"+
		"\u0001\u0000\u0000\u00000\u00dc\u0001\u0000\u0000\u00002\u00e2\u0001\u0000"+
		"\u0000\u00004\u00f2\u0001\u0000\u0000\u00006\u00f9\u0001\u0000\u0000\u0000"+
		"8\u00fb\u0001\u0000\u0000\u0000:\u0101\u0001\u0000\u0000\u0000<\u010d"+
		"\u0001\u0000\u0000\u0000>?\u0003\u0002\u0001\u0000?\u0001\u0001\u0000"+
		"\u0000\u0000@E\u0003\u0004\u0002\u0000AB\u00032\u0019\u0000BC\u0003\u0002"+
		"\u0001\u0000CE\u0001\u0000\u0000\u0000D@\u0001\u0000\u0000\u0000DA\u0001"+
		"\u0000\u0000\u0000E\u0003\u0001\u0000\u0000\u0000FG\u0005\u0001\u0000"+
		"\u0000GH\u0005\u001e\u0000\u0000HI\u0005\u001f\u0000\u0000IJ\u0005\"\u0000"+
		"\u0000JK\u0003\b\u0004\u0000KL\u0003\u0006\u0003\u0000LM\u0005#\u0000"+
		"\u0000M\u0005\u0001\u0000\u0000\u0000NO\u0003\b\u0004\u0000OP\u0003\u0006"+
		"\u0003\u0000PS\u0001\u0000\u0000\u0000QS\u0001\u0000\u0000\u0000RN\u0001"+
		"\u0000\u0000\u0000RQ\u0001\u0000\u0000\u0000S\u0007\u0001\u0000\u0000"+
		"\u0000T\\\u0003\n\u0005\u0000U\\\u0003\f\u0006\u0000V\\\u0003*\u0015\u0000"+
		"W\\\u0003.\u0017\u0000X\\\u00030\u0018\u0000Y\\\u00038\u001c\u0000Z\\"+
		"\u0003:\u001d\u0000[T\u0001\u0000\u0000\u0000[U\u0001\u0000\u0000\u0000"+
		"[V\u0001\u0000\u0000\u0000[W\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000[Z\u0001\u0000\u0000\u0000\\\t\u0001\u0000"+
		"\u0000\u0000]^\u0005\u0002\u0000\u0000^_\u0005\r\u0000\u0000_`\u0003\u000e"+
		"\u0007\u0000`a\u0005!\u0000\u0000a\u000b\u0001\u0000\u0000\u0000bc\u0005"+
		"\r\u0000\u0000cf\u0005\u001d\u0000\u0000dg\u0003\u0016\u000b\u0000eg\u0003"+
		"\u0010\b\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000gh\u0001"+
		"\u0000\u0000\u0000hi\u0005!\u0000\u0000i\r\u0001\u0000\u0000\u0000jm\u0005"+
		"\u001d\u0000\u0000kn\u0003\u0016\u000b\u0000ln\u0003\u0010\b\u0000mk\u0001"+
		"\u0000\u0000\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000"+
		"oq\u0001\u0000\u0000\u0000pj\u0001\u0000\u0000\u0000po\u0001\u0000\u0000"+
		"\u0000q\u000f\u0001\u0000\u0000\u0000rs\u0005\r\u0000\u0000st\u0005\u001e"+
		"\u0000\u0000tu\u0003\u0012\t\u0000uv\u0005\u001f\u0000\u0000v\u0011\u0001"+
		"\u0000\u0000\u0000w|\u0003\u0016\u000b\u0000xy\u0005 \u0000\u0000y{\u0003"+
		"\u0016\u000b\u0000zx\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0081\u0001\u0000"+
		"\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080w\u0001\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081"+
		"\u0013\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0002\u0000\u0000\u0083"+
		"\u0084\u0005\r\u0000\u0000\u0084\u0015\u0001\u0000\u0000\u0000\u0085\u008c"+
		"\u0005\u000b\u0000\u0000\u0086\u008c\u0005\u0003\u0000\u0000\u0087\u008c"+
		"\u0003\u0018\f\u0000\u0088\u008c\u0005\u000e\u0000\u0000\u0089\u008a\u0005"+
		"\r\u0000\u0000\u008a\u008c\u0003\u001a\r\u0000\u008b\u0085\u0001\u0000"+
		"\u0000\u0000\u008b\u0086\u0001\u0000\u0000\u0000\u008b\u0087\u0001\u0000"+
		"\u0000\u0000\u008b\u0088\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000"+
		"\u0000\u0000\u008c\u0017\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u000f"+
		"\u0000\u0000\u008e\u008f\u0003\u001a\r\u0000\u008f\u0019\u0001\u0000\u0000"+
		"\u0000\u0090\u0091\u0003<\u001e\u0000\u0091\u0092\u0007\u0000\u0000\u0000"+
		"\u0092\u0093\u0003\u001a\r\u0000\u0093\u0096\u0001\u0000\u0000\u0000\u0094"+
		"\u0096\u0001\u0000\u0000\u0000\u0095\u0090\u0001\u0000\u0000\u0000\u0095"+
		"\u0094\u0001\u0000\u0000\u0000\u0096\u001b\u0001\u0000\u0000\u0000\u0097"+
		"\u009a\u0005\u0003\u0000\u0000\u0098\u009a\u0003\u001e\u000f\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\u001d\u0001\u0000\u0000\u0000\u009b\u009c\u0003 \u0010\u0000\u009c\u009d"+
		"\u0003\"\u0011\u0000\u009d\u00a3\u0001\u0000\u0000\u0000\u009e\u009f\u0005"+
		"\u000b\u0000\u0000\u009f\u00a3\u0003&\u0013\u0000\u00a0\u00a1\u0005\r"+
		"\u0000\u0000\u00a1\u00a3\u0003$\u0012\u0000\u00a2\u009b\u0001\u0000\u0000"+
		"\u0000\u00a2\u009e\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a3\u001f\u0001\u0000\u0000\u0000\u00a4\u00a5\u0007\u0001\u0000"+
		"\u0000\u00a5!\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0010\u0000\u0000"+
		"\u00a7\u00a8\u0003 \u0010\u0000\u00a8\u00a9\u0003\"\u0011\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a6\u0001\u0000\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac"+
		"#\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u0010\u0000\u0000\u00ae\u00af"+
		"\u0003\u0016\u000b\u0000\u00af\u00b0\u0003$\u0012\u0000\u00b0\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0003(\u0014\u0000\u00b2\u00b3\u0003\u0016"+
		"\u000b\u0000\u00b3\u00b4\u0003$\u0012\u0000\u00b4\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00ad\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b7%\u0001\u0000\u0000\u0000\u00b8\u00b9\u0003(\u0014\u0000\u00b9"+
		"\u00ba\u0005\u000b\u0000\u0000\u00ba\u00bb\u0003&\u0013\u0000\u00bb\u00be"+
		"\u0001\u0000\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00b8"+
		"\u0001\u0000\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\'\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c0\u0007\u0002\u0000\u0000\u00c0)\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0005\u0005\u0000\u0000\u00c2\u00c3\u0005\u001e"+
		"\u0000\u0000\u00c3\u00c4\u0003\u001c\u000e\u0000\u00c4\u00c5\u0005\u001f"+
		"\u0000\u0000\u00c5\u00c6\u0005\"\u0000\u0000\u00c6\u00c7\u0003\u0006\u0003"+
		"\u0000\u00c7\u00c8\u0005#\u0000\u0000\u00c8\u00c9\u0003,\u0016\u0000\u00c9"+
		"+\u0001\u0000\u0000\u0000\u00ca\u00cb\u0005\u0006\u0000\u0000\u00cb\u00cc"+
		"\u0005\"\u0000\u0000\u00cc\u00cd\u0003\u0006\u0003\u0000\u00cd\u00ce\u0005"+
		"#\u0000\u0000\u00ce\u00d3\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u0006"+
		"\u0000\u0000\u00d0\u00d3\u0003*\u0015\u0000\u00d1\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d2\u00ca\u0001\u0000\u0000\u0000\u00d2\u00cf\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3-\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0005\u0007\u0000\u0000\u00d5\u00d6\u0005\u001e\u0000\u0000"+
		"\u00d6\u00d7\u0003\u001c\u000e\u0000\u00d7\u00d8\u0005\u001f\u0000\u0000"+
		"\u00d8\u00d9\u0005\"\u0000\u0000\u00d9\u00da\u0003\u0006\u0003\u0000\u00da"+
		"\u00db\u0005#\u0000\u0000\u00db/\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005"+
		"\r\u0000\u0000\u00dd\u00de\u0005\u001e\u0000\u0000\u00de\u00df\u00034"+
		"\u001a\u0000\u00df\u00e0\u0005\u001f\u0000\u0000\u00e0\u00e1\u0005!\u0000"+
		"\u0000\u00e11\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0004\u0000\u0000"+
		"\u00e3\u00e4\u0005\r\u0000\u0000\u00e4\u00e5\u0005\u001e\u0000\u0000\u00e5"+
		"\u00e6\u00034\u001a\u0000\u00e6\u00e7\u0005\u001f\u0000\u0000\u00e7\u00e8"+
		"\u0005\"\u0000\u0000\u00e8\u00e9\u0003\u0006\u0003\u0000\u00e9\u00ea\u0005"+
		"\n\u0000\u0000\u00ea\u00eb\u0003\u0016\u000b\u0000\u00eb\u00ec\u0005!"+
		"\u0000\u0000\u00ec\u00ed\u0005#\u0000\u0000\u00ed3\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ef\u0003\u0014\n\u0000\u00ef\u00f0\u00036\u001b\u0000\u00f0"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3"+
		"5\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005 \u0000\u0000\u00f5\u00f6\u0003"+
		"\u0014\n\u0000\u00f6\u00f7\u00036\u001b\u0000\u00f7\u00fa\u0001\u0000"+
		"\u0000\u0000\u00f8\u00fa\u0001\u0000\u0000\u0000\u00f9\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f9\u00f8\u0001\u0000\u0000\u0000\u00fa7\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0005\b\u0000\u0000\u00fc\u00fd\u0005\u001e\u0000\u0000"+
		"\u00fd\u00fe\u0005\r\u0000\u0000\u00fe\u00ff\u0005\u001f\u0000\u0000\u00ff"+
		"\u0100\u0005!\u0000\u0000\u01009\u0001\u0000\u0000\u0000\u0101\u0102\u0005"+
		"\t\u0000\u0000\u0102\u0103\u0005\u001e\u0000\u0000\u0103\u0104\u0007\u0003"+
		"\u0000\u0000\u0104\u0105\u0005\u001f\u0000\u0000\u0105\u0106\u0005!\u0000"+
		"\u0000\u0106;\u0001\u0000\u0000\u0000\u0107\u010e\u0005\u0018\u0000\u0000"+
		"\u0108\u010e\u0005\u001a\u0000\u0000\u0109\u010e\u0005\u001b\u0000\u0000"+
		"\u010a\u010e\u0005\u001c\u0000\u0000\u010b\u010e\u0005\u0019\u0000\u0000"+
		"\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u0107\u0001\u0000\u0000\u0000"+
		"\u010d\u0108\u0001\u0000\u0000\u0000\u010d\u0109\u0001\u0000\u0000\u0000"+
		"\u010d\u010a\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000"+
		"\u010d\u010c\u0001\u0000\u0000\u0000\u010e=\u0001\u0000\u0000\u0000\u0013"+
		"DR[fmp|\u0080\u008b\u0095\u0099\u00a2\u00ab\u00b6\u00bd\u00d2\u00f2\u00f9"+
		"\u010d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}