// Generated from C:/Users/Silvia/OneDrive - Universidad de Oviedo/Escritorio/Universidad/QUINTO AÑO/DLP/Laboratorio/DLP-PROJECT/src/parser/Cmm.g4 by ANTLR 4.13.1
package parser;

	import ast.*;
	import ast.definitions.*;
	import ast.expressions.*;
	import ast.expressions.literals.*;
	import ast.statements.*;
	import ast.types.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, INT_CONSTANT=37, REAL_CONSTANT=38, 
		REAL_FLOATING=39, REAL_MANTISSA=40, CHAR_CONSTANT=41, ONE_LINE_COMMENT=42, 
		MULTIPLE_LINE_COMMENTS=43, ID=44, WHITE_SPACES=45;
	public static final int
		RULE_program = 0, RULE_definitions = 1, RULE_variable_definition = 2, 
		RULE_function_definition = 3, RULE_function_parameters = 4, RULE_function_body = 5, 
		RULE_function_return_type = 6, RULE_main_function = 7, RULE_expression = 8, 
		RULE_optional_arguments = 9, RULE_statement = 10, RULE_block = 11, RULE_built_in_type = 12, 
		RULE_type = 13, RULE_field_definition = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definitions", "variable_definition", "function_definition", 
			"function_parameters", "function_body", "function_return_type", "main_function", 
			"expression", "optional_arguments", "statement", "block", "built_in_type", 
			"type", "field_definition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "';'", "'('", "')'", "'{'", "'}'", "'void'", "'main'", "'['", 
			"']'", "'.'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", 
			"'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", "'='", "'while'", "'if'", 
			"'else'", "'write'", "'read'", "'return'", "'int'", "'double'", "'char'", 
			"'struct'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT_CONSTANT", "REAL_CONSTANT", "REAL_FLOATING", "REAL_MANTISSA", 
			"CHAR_CONSTANT", "ONE_LINE_COMMENT", "MULTIPLE_LINE_COMMENTS", "ID", 
			"WHITE_SPACES"
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
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public List<Definition> defs = new ArrayList<Definition>();
		public DefinitionsContext d;
		public Main_functionContext m;
		public Main_functionContext main_function() {
			return getRuleContext(Main_functionContext.class,0);
		}
		public List<DefinitionsContext> definitions() {
			return getRuleContexts(DefinitionsContext.class);
		}
		public DefinitionsContext definitions(int i) {
			return getRuleContext(DefinitionsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(30);
					((ProgramContext)_localctx).d = definitions();
					 _localctx.defs.addAll(((ProgramContext)_localctx).d.ast); 
					}
					} 
				}
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(38);
			((ProgramContext)_localctx).m = main_function();
			 _localctx.defs.add(((ProgramContext)_localctx).m.ast); 
			 ((ProgramContext)_localctx).ast =  new Program(_localctx.defs.get(0).getLine(),_localctx.defs.get(0).getColumn(), _localctx.defs); 
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
	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Variable_definitionContext v;
		public Function_definitionContext f;
		public Variable_definitionContext variable_definition() {
			return getRuleContext(Variable_definitionContext.class,0);
		}
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definitions; }
	}

	public final DefinitionsContext definitions() throws RecognitionException {
		DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definitions);
		try {
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				((DefinitionsContext)_localctx).v = variable_definition();
				 _localctx.ast.addAll(((DefinitionsContext)_localctx).v.ast); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((DefinitionsContext)_localctx).f = function_definition();
				 _localctx.ast.add(((DefinitionsContext)_localctx).f.ast); 
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
	public static class Variable_definitionContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();;
		public TypeContext t;
		public Token ID1;
		public Token ID2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_definition; }
	}

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((Variable_definitionContext)_localctx).t = type(0);
			setState(51);
			((Variable_definitionContext)_localctx).ID1 = match(ID);
			 _localctx.ast.add(new VarDefinition(((Variable_definitionContext)_localctx).t.ast.getLine(), ((Variable_definitionContext)_localctx).t.ast.getColumn(), ((Variable_definitionContext)_localctx).t.ast, (((Variable_definitionContext)_localctx).ID1!=null?((Variable_definitionContext)_localctx).ID1.getText():null))); 
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(53);
				match(T__0);
				setState(54);
				((Variable_definitionContext)_localctx).ID2 = match(ID);
				 _localctx.ast.add(new VarDefinition(((Variable_definitionContext)_localctx).t.ast.getLine(), ((Variable_definitionContext)_localctx).t.ast.getColumn(), ((Variable_definitionContext)_localctx).t.ast, (((Variable_definitionContext)_localctx).ID2!=null?((Variable_definitionContext)_localctx).ID2.getText():null))); 
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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
	public static class Function_definitionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Function_return_typeContext frt;
		public Token ID;
		public Function_parametersContext fp;
		public Function_bodyContext fb;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public Function_return_typeContext function_return_type() {
			return getRuleContext(Function_return_typeContext.class,0);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			((Function_definitionContext)_localctx).frt = function_return_type();
			setState(64);
			((Function_definitionContext)_localctx).ID = match(ID);
			setState(65);
			match(T__2);
			setState(66);
			((Function_definitionContext)_localctx).fp = function_parameters();
			setState(67);
			match(T__3);
			setState(68);
			((Function_definitionContext)_localctx).fb = function_body();
			 ((Function_definitionContext)_localctx).ast =  new FunctionDefinition(((Function_definitionContext)_localctx).frt.ast.getLine(), ((Function_definitionContext)_localctx).frt.ast.getColumn(),
			                            new FunctionType(((Function_definitionContext)_localctx).frt.ast.getLine(), ((Function_definitionContext)_localctx).frt.ast.getColumn(), ((Function_definitionContext)_localctx).frt.ast, ((Function_definitionContext)_localctx).fp.ast), (((Function_definitionContext)_localctx).ID!=null?((Function_definitionContext)_localctx).ID.getText():null), ((Function_definitionContext)_localctx).fb.ast); 
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
	public static class Function_parametersContext extends ParserRuleContext {
		public List<VarDefinition> ast = new ArrayList<VarDefinition>();;
		public Built_in_typeContext t1;
		public Token ID1;
		public Built_in_typeContext t2;
		public Token ID2;
		public List<Built_in_typeContext> built_in_type() {
			return getRuleContexts(Built_in_typeContext.class);
		}
		public Built_in_typeContext built_in_type(int i) {
			return getRuleContext(Built_in_typeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Function_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameters; }
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_parameters);
		int _la;
		try {
			setState(85);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__32:
			case T__33:
			case T__34:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				((Function_parametersContext)_localctx).t1 = built_in_type();
				setState(73);
				((Function_parametersContext)_localctx).ID1 = match(ID);
				 _localctx.ast.add(new VarDefinition(((Function_parametersContext)_localctx).t1.ast.getLine(), ((Function_parametersContext)_localctx).t1.ast.getColumn(), ((Function_parametersContext)_localctx).t1.ast, (((Function_parametersContext)_localctx).ID1!=null?((Function_parametersContext)_localctx).ID1.getText():null))); 
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(75);
					match(T__0);
					setState(76);
					((Function_parametersContext)_localctx).t2 = built_in_type();
					setState(77);
					((Function_parametersContext)_localctx).ID2 = match(ID);
					 _localctx.ast.add(new VarDefinition(((Function_parametersContext)_localctx).t2.ast.getLine(), ((Function_parametersContext)_localctx).t2.ast.getColumn(), ((Function_parametersContext)_localctx).t2.ast, (((Function_parametersContext)_localctx).ID2!=null?((Function_parametersContext)_localctx).ID2.getText():null))); 
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class Function_bodyContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();;
		public Variable_definitionContext vd;
		public StatementContext st;
		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}
		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__4);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0)) {
				{
				{
				setState(88);
				((Function_bodyContext)_localctx).vd = variable_definition();
				 _localctx.ast.addAll(((Function_bodyContext)_localctx).vd.ast); 
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20211445018632L) != 0)) {
				{
				{
				setState(96);
				((Function_bodyContext)_localctx).st = statement();
				 _localctx.ast.addAll(((Function_bodyContext)_localctx).st.ast); 
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(T__5);
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
	public static class Function_return_typeContext extends ParserRuleContext {
		public Type ast;
		public Built_in_typeContext t;
		public Token T;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public Function_return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_return_type; }
	}

	public final Function_return_typeContext function_return_type() throws RecognitionException {
		Function_return_typeContext _localctx = new Function_return_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_return_type);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
			case T__33:
			case T__34:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				((Function_return_typeContext)_localctx).t = built_in_type();
				 ((Function_return_typeContext)_localctx).ast =  ((Function_return_typeContext)_localctx).t.ast; 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				((Function_return_typeContext)_localctx).T = match(T__6);
				 ((Function_return_typeContext)_localctx).ast =  new VoidType(((Function_return_typeContext)_localctx).T.getLine(), ((Function_return_typeContext)_localctx).T.getCharPositionInLine()+1); 
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
	public static class Main_functionContext extends ParserRuleContext {
		public FunctionDefinition ast;
		public Token T;
		public Function_bodyContext fb;
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Main_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_function; }
	}

	public final Main_functionContext main_function() throws RecognitionException {
		Main_functionContext _localctx = new Main_functionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_main_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			((Main_functionContext)_localctx).T = match(T__6);
			setState(114);
			match(T__7);
			setState(115);
			match(T__2);
			setState(116);
			match(T__3);
			setState(117);
			((Main_functionContext)_localctx).fb = function_body();
			setState(118);
			match(EOF);
			 ((Main_functionContext)_localctx).ast =  new FunctionDefinition(((Main_functionContext)_localctx).T.getLine(), ((Main_functionContext)_localctx).T.getCharPositionInLine()+1,
			                            new FunctionType(((Main_functionContext)_localctx).T.getLine(), ((Main_functionContext)_localctx).T.getCharPositionInLine()+1,
			                                new VoidType(((Main_functionContext)_localctx).T.getLine(), ((Main_functionContext)_localctx).T.getCharPositionInLine()+1), new ArrayList<VarDefinition>()), "main", ((Main_functionContext)_localctx).fb.ast); 
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
		public Expression ast;
		public ExpressionContext e1;
		public ExpressionContext e;
		public Token ID;
		public Token IC;
		public Token RC;
		public Token CC;
		public TypeContext t;
		public Optional_argumentsContext oa;
		public Token OP;
		public ExpressionContext e2;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Optional_argumentsContext optional_arguments() {
			return getRuleContext(Optional_argumentsContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(122);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 2:
				{
				setState(124);
				((ExpressionContext)_localctx).IC = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).IC.getLine(), ((ExpressionContext)_localctx).IC.getCharPositionInLine()+1, LexerHelper.lexemeToInt((((ExpressionContext)_localctx).IC!=null?((ExpressionContext)_localctx).IC.getText():null))); 
				}
				break;
			case 3:
				{
				setState(126);
				((ExpressionContext)_localctx).RC = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new DoubleLiteral(((ExpressionContext)_localctx).RC.getLine(), ((ExpressionContext)_localctx).RC.getCharPositionInLine()+1, LexerHelper.lexemeToReal((((ExpressionContext)_localctx).RC!=null?((ExpressionContext)_localctx).RC.getText():null))); 
				}
				break;
			case 4:
				{
				setState(128);
				((ExpressionContext)_localctx).CC = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).CC.getLine(), ((ExpressionContext)_localctx).CC.getCharPositionInLine()+1, LexerHelper.lexemeToChar((((ExpressionContext)_localctx).CC!=null?((ExpressionContext)_localctx).CC.getText():null))); 
				}
				break;
			case 5:
				{
				setState(130);
				match(T__2);
				setState(131);
				((ExpressionContext)_localctx).e = expression(0);
				setState(132);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e.ast; 
				}
				break;
			case 6:
				{
				setState(135);
				match(T__2);
				setState(136);
				((ExpressionContext)_localctx).t = type(0);
				setState(137);
				match(T__3);
				setState(138);
				((ExpressionContext)_localctx).e = expression(8);
				 ((ExpressionContext)_localctx).ast =  new Cast(((ExpressionContext)_localctx).t.ast.getLine(), ((ExpressionContext)_localctx).t.ast.getColumn(), ((ExpressionContext)_localctx).t.ast, ((ExpressionContext)_localctx).e.ast); 
				}
				break;
			case 7:
				{
				setState(141);
				match(T__11);
				setState(142);
				((ExpressionContext)_localctx).e = expression(7);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast); 
				}
				break;
			case 8:
				{
				setState(145);
				match(T__12);
				setState(146);
				((ExpressionContext)_localctx).e = expression(6);
				 ((ExpressionContext)_localctx).ast =  new UnaryNot(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast); 
				}
				break;
			case 9:
				{
				setState(149);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(150);
				match(T__2);
				setState(151);
				((ExpressionContext)_localctx).oa = optional_arguments();
				setState(152);
				match(T__3);
				 ((ExpressionContext)_localctx).ast =  new FunctionInvocation(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine()+1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null), ((ExpressionContext)_localctx).oa.ast); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(187);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(157);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(158);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						((ExpressionContext)_localctx).e2 = expression(6);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(163);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__16) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						((ExpressionContext)_localctx).e2 = expression(5);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(168);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16515072L) != 0)) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(169);
						((ExpressionContext)_localctx).e2 = expression(4);
						 ((ExpressionContext)_localctx).ast =  new Comparison(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(172);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(173);
						((ExpressionContext)_localctx).OP = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((ExpressionContext)_localctx).OP = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(174);
						((ExpressionContext)_localctx).e2 = expression(3);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn()+1, ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).OP!=null?((ExpressionContext)_localctx).OP.getText():null), ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(177);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(178);
						match(T__8);
						setState(179);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(180);
						match(T__9);
						 ((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(184);
						match(T__10);
						setState(185);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).e.ast.getLine(), ((ExpressionContext)_localctx).e.ast.getColumn(), ((ExpressionContext)_localctx).e.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Optional_argumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Optional_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_arguments; }
	}

	public final Optional_argumentsContext optional_arguments() throws RecognitionException {
		Optional_argumentsContext _localctx = new Optional_argumentsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_optional_arguments);
		int _la;
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__2:
			case T__11:
			case T__12:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				((Optional_argumentsContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(((Optional_argumentsContext)_localctx).e1.ast); 
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(195);
					match(T__0);
					setState(196);
					((Optional_argumentsContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(((Optional_argumentsContext)_localctx).e2.ast); 
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		public List<Statement> ast = new ArrayList<Statement>();;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ExpressionContext e;
		public BlockContext b;
		public BlockContext b1;
		public BlockContext b2;
		public Token ID;
		public Optional_argumentsContext oa;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public Optional_argumentsContext optional_arguments() {
			return getRuleContext(Optional_argumentsContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				((StatementContext)_localctx).e1 = expression(0);
				setState(207);
				match(T__25);
				setState(208);
				((StatementContext)_localctx).e2 = expression(0);
				setState(209);
				match(T__1);
				 _localctx.ast.add(new Assignment(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(T__26);
				setState(213);
				match(T__2);
				setState(214);
				((StatementContext)_localctx).e = expression(0);
				setState(215);
				match(T__3);
				setState(216);
				((StatementContext)_localctx).b = block();
				 _localctx.ast.add(new While(((StatementContext)_localctx).e.ast.getLine(), ((StatementContext)_localctx).e.ast.getColumn(), ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b.ast)); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(T__27);
				setState(220);
				match(T__2);
				setState(221);
				((StatementContext)_localctx).e = expression(0);
				setState(222);
				match(T__3);
				setState(223);
				((StatementContext)_localctx).b = block();
				 _localctx.ast.add(new IfElse(((StatementContext)_localctx).e.ast.getLine(), ((StatementContext)_localctx).e.ast.getColumn(), ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b.ast)); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				match(T__27);
				setState(227);
				match(T__2);
				setState(228);
				((StatementContext)_localctx).e = expression(0);
				setState(229);
				match(T__3);
				setState(230);
				((StatementContext)_localctx).b1 = block();
				setState(231);
				match(T__28);
				setState(232);
				((StatementContext)_localctx).b2 = block();
				 _localctx.ast.add(new IfElse(((StatementContext)_localctx).e.ast.getLine(), ((StatementContext)_localctx).e.ast.getColumn(), ((StatementContext)_localctx).e.ast, ((StatementContext)_localctx).b1.ast, ((StatementContext)_localctx).b2.ast)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(235);
				match(T__29);
				setState(236);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(new Write(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast));  
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(238);
					match(T__0);
					setState(239);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(new Write(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast));  
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				match(T__1);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(249);
				match(T__30);
				setState(250);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(new Read(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast));  
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(252);
					match(T__0);
					setState(253);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(new Read(((StatementContext)_localctx).e2.ast.getLine(), ((StatementContext)_localctx).e2.ast.getColumn(), ((StatementContext)_localctx).e2.ast));  
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261);
				match(T__1);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(263);
				match(T__31);
				setState(264);
				((StatementContext)_localctx).e = expression(0);
				setState(265);
				match(T__1);
				 _localctx.ast.add(new Return(((StatementContext)_localctx).e.ast.getLine(), ((StatementContext)_localctx).e.ast.getColumn(), ((StatementContext)_localctx).e.ast));  
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(268);
				((StatementContext)_localctx).ID = match(ID);
				setState(269);
				match(T__2);
				setState(270);
				((StatementContext)_localctx).oa = optional_arguments();
				setState(271);
				match(T__3);
				setState(272);
				match(T__1);
				 _localctx.ast.add(new FunctionInvocation(((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine()+1, (((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null), ((StatementContext)_localctx).oa.ast)); 
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
	public static class BlockContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();;
		public StatementContext s1;
		public StatementContext s2;
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
		int _la;
		try {
			setState(290);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__11:
			case T__12:
			case T__26:
			case T__27:
			case T__29:
			case T__30:
			case T__31:
			case INT_CONSTANT:
			case REAL_CONSTANT:
			case CHAR_CONSTANT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				((BlockContext)_localctx).s1 = statement();
				 _localctx.ast.addAll(((BlockContext)_localctx).s1.ast); 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				match(T__4);
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20211445018632L) != 0)) {
					{
					{
					setState(281);
					((BlockContext)_localctx).s2 = statement();
					 _localctx.ast.addAll(((BlockContext)_localctx).s2.ast); 
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(289);
				match(T__5);
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
	public static class Built_in_typeContext extends ParserRuleContext {
		public Type ast;
		public Token T;
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_built_in_type);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				((Built_in_typeContext)_localctx).T = match(T__32);
				 ((Built_in_typeContext)_localctx).ast =  new IntType(((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1); 
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				((Built_in_typeContext)_localctx).T = match(T__33);
				 ((Built_in_typeContext)_localctx).ast =  new DoubleType(((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1); 
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
				((Built_in_typeContext)_localctx).T = match(T__34);
				 ((Built_in_typeContext)_localctx).ast =  new CharType(((Built_in_typeContext)_localctx).T.getLine(), ((Built_in_typeContext)_localctx).T.getCharPositionInLine()+1); 
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
	public static class TypeContext extends ParserRuleContext {
		public Type ast;
		public TypeContext t;
		public Built_in_typeContext b;
		public Token S;
		public Field_definitionContext fd;
		public Token IC;
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public List<Field_definitionContext> field_definition() {
			return getRuleContexts(Field_definitionContext.class);
		}
		public Field_definitionContext field_definition(int i) {
			return getRuleContext(Field_definitionContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
			case T__33:
			case T__34:
				{
				setState(301);
				((TypeContext)_localctx).b = built_in_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).b.ast; 
				}
				break;
			case T__35:
				{
				setState(304);
				((TypeContext)_localctx).S = match(T__35);
				setState(305);
				match(T__4);
				setState(307); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(306);
					((TypeContext)_localctx).fd = field_definition();
					}
					}
					setState(309); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 128849018880L) != 0) );
				setState(311);
				match(T__5);
				 ((TypeContext)_localctx).ast =  new Struct(((TypeContext)_localctx).S.getLine(), ((TypeContext)_localctx).S.getCharPositionInLine()+1, ((TypeContext)_localctx).fd.ast); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(316);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(317);
					match(T__8);
					setState(318);
					((TypeContext)_localctx).IC = match(INT_CONSTANT);
					setState(319);
					match(T__9);
					 ((TypeContext)_localctx).ast =  ArrayType.createArray(((TypeContext)_localctx).t.ast.getLine(), ((TypeContext)_localctx).t.ast.getColumn(), ((TypeContext)_localctx).t.ast, LexerHelper.lexemeToInt((((TypeContext)_localctx).IC!=null?((TypeContext)_localctx).IC.getText():null))); 
					}
					} 
				}
				setState(325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_definitionContext extends ParserRuleContext {
		public List<RecordFieldType> ast = new ArrayList<RecordFieldType>();;
		public TypeContext t;
		public Token ID1;
		public Token ID2;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Field_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_definition; }
	}

	public final Field_definitionContext field_definition() throws RecognitionException {
		Field_definitionContext _localctx = new Field_definitionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_field_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			((Field_definitionContext)_localctx).t = type(0);
			setState(327);
			((Field_definitionContext)_localctx).ID1 = match(ID);
			 _localctx.ast.add(new RecordFieldType(((Field_definitionContext)_localctx).t.ast.getLine(), ((Field_definitionContext)_localctx).t.ast.getColumn(), ((Field_definitionContext)_localctx).t.ast, (((Field_definitionContext)_localctx).ID1!=null?((Field_definitionContext)_localctx).ID1.getText():null))); 
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==T__1) {
				{
				{
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(329);
					match(T__0);
					setState(330);
					((Field_definitionContext)_localctx).ID2 = match(ID);
					 _localctx.ast.add(new RecordFieldType(((Field_definitionContext)_localctx).t.ast.getLine(), ((Field_definitionContext)_localctx).t.ast.getColumn(), ((Field_definitionContext)_localctx).t.ast, (((Field_definitionContext)_localctx).ID2!=null?((Field_definitionContext)_localctx).ID2.getText():null))); 
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(337);
				match(T__1);
				}
				}
				setState(342);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 13:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0158\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"9\b\u0002\n\u0002\f\u0002<\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004Q\b\u0004"+
		"\n\u0004\f\u0004T\t\u0004\u0003\u0004V\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\\\b\u0005\n\u0005\f\u0005_\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005d\b\u0005\n\u0005\f\u0005"+
		"g\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006p\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u009c"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u00bc\b\b\n\b\f\b\u00bf\t\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00c8\b\t\n\t"+
		"\f\t\u00cb\t\t\u0003\t\u00cd\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00f3\b\n\n\n\f\n\u00f6\t\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u0101\b\n\n\n\f\n\u0104\t\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u0114\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u011d\b\u000b\n"+
		"\u000b\f\u000b\u0120\t\u000b\u0001\u000b\u0003\u000b\u0123\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u012b\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0004\r\u0134\b\r\u000b\r\f"+
		"\r\u0135\u0001\r\u0001\r\u0001\r\u0003\r\u013b\b\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0142\b\r\n\r\f\r\u0145\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u014d"+
		"\b\u000e\n\u000e\f\u000e\u0150\t\u000e\u0001\u000e\u0005\u000e\u0153\b"+
		"\u000e\n\u000e\f\u000e\u0156\t\u000e\u0001\u000e\u0000\u0002\u0010\u001a"+
		"\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u0000\u0004\u0001\u0000\u000e\u0010\u0002\u0000\f\f\u0011"+
		"\u0011\u0001\u0000\u0012\u0017\u0001\u0000\u0018\u0019\u0172\u0000#\u0001"+
		"\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u00042\u0001\u0000\u0000"+
		"\u0000\u0006?\u0001\u0000\u0000\u0000\bU\u0001\u0000\u0000\u0000\nW\u0001"+
		"\u0000\u0000\u0000\fo\u0001\u0000\u0000\u0000\u000eq\u0001\u0000\u0000"+
		"\u0000\u0010\u009b\u0001\u0000\u0000\u0000\u0012\u00cc\u0001\u0000\u0000"+
		"\u0000\u0014\u0113\u0001\u0000\u0000\u0000\u0016\u0122\u0001\u0000\u0000"+
		"\u0000\u0018\u012a\u0001\u0000\u0000\u0000\u001a\u013a\u0001\u0000\u0000"+
		"\u0000\u001c\u0146\u0001\u0000\u0000\u0000\u001e\u001f\u0003\u0002\u0001"+
		"\u0000\u001f \u0006\u0000\uffff\uffff\u0000 \"\u0001\u0000\u0000\u0000"+
		"!\u001e\u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000"+
		"\u0000\u0000#$\u0001\u0000\u0000\u0000$&\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000&\'\u0003\u000e\u0007\u0000\'(\u0006\u0000\uffff\uffff"+
		"\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001\u0000\u0000\u0000"+
		"*+\u0003\u0004\u0002\u0000+,\u0006\u0001\uffff\uffff\u0000,1\u0001\u0000"+
		"\u0000\u0000-.\u0003\u0006\u0003\u0000./\u0006\u0001\uffff\uffff\u0000"+
		"/1\u0001\u0000\u0000\u00000*\u0001\u0000\u0000\u00000-\u0001\u0000\u0000"+
		"\u00001\u0003\u0001\u0000\u0000\u000023\u0003\u001a\r\u000034\u0005,\u0000"+
		"\u00004:\u0006\u0002\uffff\uffff\u000056\u0005\u0001\u0000\u000067\u0005"+
		",\u0000\u000079\u0006\u0002\uffff\uffff\u000085\u0001\u0000\u0000\u0000"+
		"9<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;=\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000=>\u0005\u0002"+
		"\u0000\u0000>\u0005\u0001\u0000\u0000\u0000?@\u0003\f\u0006\u0000@A\u0005"+
		",\u0000\u0000AB\u0005\u0003\u0000\u0000BC\u0003\b\u0004\u0000CD\u0005"+
		"\u0004\u0000\u0000DE\u0003\n\u0005\u0000EF\u0006\u0003\uffff\uffff\u0000"+
		"F\u0007\u0001\u0000\u0000\u0000GV\u0001\u0000\u0000\u0000HI\u0003\u0018"+
		"\f\u0000IJ\u0005,\u0000\u0000JR\u0006\u0004\uffff\uffff\u0000KL\u0005"+
		"\u0001\u0000\u0000LM\u0003\u0018\f\u0000MN\u0005,\u0000\u0000NO\u0006"+
		"\u0004\uffff\uffff\u0000OQ\u0001\u0000\u0000\u0000PK\u0001\u0000\u0000"+
		"\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UG\u0001"+
		"\u0000\u0000\u0000UH\u0001\u0000\u0000\u0000V\t\u0001\u0000\u0000\u0000"+
		"W]\u0005\u0005\u0000\u0000XY\u0003\u0004\u0002\u0000YZ\u0006\u0005\uffff"+
		"\uffff\u0000Z\\\u0001\u0000\u0000\u0000[X\u0001\u0000\u0000\u0000\\_\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000"+
		"^e\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0003\u0014\n\u0000"+
		"ab\u0006\u0005\uffff\uffff\u0000bd\u0001\u0000\u0000\u0000c`\u0001\u0000"+
		"\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001"+
		"\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"hi\u0005\u0006\u0000\u0000i\u000b\u0001\u0000\u0000\u0000jk\u0003\u0018"+
		"\f\u0000kl\u0006\u0006\uffff\uffff\u0000lp\u0001\u0000\u0000\u0000mn\u0005"+
		"\u0007\u0000\u0000np\u0006\u0006\uffff\uffff\u0000oj\u0001\u0000\u0000"+
		"\u0000om\u0001\u0000\u0000\u0000p\r\u0001\u0000\u0000\u0000qr\u0005\u0007"+
		"\u0000\u0000rs\u0005\b\u0000\u0000st\u0005\u0003\u0000\u0000tu\u0005\u0004"+
		"\u0000\u0000uv\u0003\n\u0005\u0000vw\u0005\u0000\u0000\u0001wx\u0006\u0007"+
		"\uffff\uffff\u0000x\u000f\u0001\u0000\u0000\u0000yz\u0006\b\uffff\uffff"+
		"\u0000z{\u0005,\u0000\u0000{\u009c\u0006\b\uffff\uffff\u0000|}\u0005%"+
		"\u0000\u0000}\u009c\u0006\b\uffff\uffff\u0000~\u007f\u0005&\u0000\u0000"+
		"\u007f\u009c\u0006\b\uffff\uffff\u0000\u0080\u0081\u0005)\u0000\u0000"+
		"\u0081\u009c\u0006\b\uffff\uffff\u0000\u0082\u0083\u0005\u0003\u0000\u0000"+
		"\u0083\u0084\u0003\u0010\b\u0000\u0084\u0085\u0005\u0004\u0000\u0000\u0085"+
		"\u0086\u0006\b\uffff\uffff\u0000\u0086\u009c\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005\u0003\u0000\u0000\u0088\u0089\u0003\u001a\r\u0000\u0089\u008a"+
		"\u0005\u0004\u0000\u0000\u008a\u008b\u0003\u0010\b\b\u008b\u008c\u0006"+
		"\b\uffff\uffff\u0000\u008c\u009c\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"\f\u0000\u0000\u008e\u008f\u0003\u0010\b\u0007\u008f\u0090\u0006\b\uffff"+
		"\uffff\u0000\u0090\u009c\u0001\u0000\u0000\u0000\u0091\u0092\u0005\r\u0000"+
		"\u0000\u0092\u0093\u0003\u0010\b\u0006\u0093\u0094\u0006\b\uffff\uffff"+
		"\u0000\u0094\u009c\u0001\u0000\u0000\u0000\u0095\u0096\u0005,\u0000\u0000"+
		"\u0096\u0097\u0005\u0003\u0000\u0000\u0097\u0098\u0003\u0012\t\u0000\u0098"+
		"\u0099\u0005\u0004\u0000\u0000\u0099\u009a\u0006\b\uffff\uffff\u0000\u009a"+
		"\u009c\u0001\u0000\u0000\u0000\u009by\u0001\u0000\u0000\u0000\u009b|\u0001"+
		"\u0000\u0000\u0000\u009b~\u0001\u0000\u0000\u0000\u009b\u0080\u0001\u0000"+
		"\u0000\u0000\u009b\u0082\u0001\u0000\u0000\u0000\u009b\u0087\u0001\u0000"+
		"\u0000\u0000\u009b\u008d\u0001\u0000\u0000\u0000\u009b\u0091\u0001\u0000"+
		"\u0000\u0000\u009b\u0095\u0001\u0000\u0000\u0000\u009c\u00bd\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\n\u0005\u0000\u0000\u009e\u009f\u0007\u0000\u0000"+
		"\u0000\u009f\u00a0\u0003\u0010\b\u0006\u00a0\u00a1\u0006\b\uffff\uffff"+
		"\u0000\u00a1\u00bc\u0001\u0000\u0000\u0000\u00a2\u00a3\n\u0004\u0000\u0000"+
		"\u00a3\u00a4\u0007\u0001\u0000\u0000\u00a4\u00a5\u0003\u0010\b\u0005\u00a5"+
		"\u00a6\u0006\b\uffff\uffff\u0000\u00a6\u00bc\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\n\u0003\u0000\u0000\u00a8\u00a9\u0007\u0002\u0000\u0000\u00a9\u00aa"+
		"\u0003\u0010\b\u0004\u00aa\u00ab\u0006\b\uffff\uffff\u0000\u00ab\u00bc"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\n\u0002\u0000\u0000\u00ad\u00ae\u0007"+
		"\u0003\u0000\u0000\u00ae\u00af\u0003\u0010\b\u0003\u00af\u00b0\u0006\b"+
		"\uffff\uffff\u0000\u00b0\u00bc\u0001\u0000\u0000\u0000\u00b1\u00b2\n\n"+
		"\u0000\u0000\u00b2\u00b3\u0005\t\u0000\u0000\u00b3\u00b4\u0003\u0010\b"+
		"\u0000\u00b4\u00b5\u0005\n\u0000\u0000\u00b5\u00b6\u0006\b\uffff\uffff"+
		"\u0000\u00b6\u00bc\u0001\u0000\u0000\u0000\u00b7\u00b8\n\t\u0000\u0000"+
		"\u00b8\u00b9\u0005\u000b\u0000\u0000\u00b9\u00ba\u0005,\u0000\u0000\u00ba"+
		"\u00bc\u0006\b\uffff\uffff\u0000\u00bb\u009d\u0001\u0000\u0000\u0000\u00bb"+
		"\u00a2\u0001\u0000\u0000\u0000\u00bb\u00a7\u0001\u0000\u0000\u0000\u00bb"+
		"\u00ac\u0001\u0000\u0000\u0000\u00bb\u00b1\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b7\u0001\u0000\u0000\u0000\u00bc\u00bf\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be"+
		"\u0011\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0"+
		"\u00cd\u0001\u0000\u0000\u0000\u00c1\u00c2\u0003\u0010\b\u0000\u00c2\u00c9"+
		"\u0006\t\uffff\uffff\u0000\u00c3\u00c4\u0005\u0001\u0000\u0000\u00c4\u00c5"+
		"\u0003\u0010\b\u0000\u00c5\u00c6\u0006\t\uffff\uffff\u0000\u00c6\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c3\u0001\u0000\u0000\u0000\u00c8\u00cb"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cc\u00c0\u0001\u0000\u0000\u0000\u00cc\u00c1"+
		"\u0001\u0000\u0000\u0000\u00cd\u0013\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0003\u0010\b\u0000\u00cf\u00d0\u0005\u001a\u0000\u0000\u00d0\u00d1\u0003"+
		"\u0010\b\u0000\u00d1\u00d2\u0005\u0002\u0000\u0000\u00d2\u00d3\u0006\n"+
		"\uffff\uffff\u0000\u00d3\u0114\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005"+
		"\u001b\u0000\u0000\u00d5\u00d6\u0005\u0003\u0000\u0000\u00d6\u00d7\u0003"+
		"\u0010\b\u0000\u00d7\u00d8\u0005\u0004\u0000\u0000\u00d8\u00d9\u0003\u0016"+
		"\u000b\u0000\u00d9\u00da\u0006\n\uffff\uffff\u0000\u00da\u0114\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0005\u001c\u0000\u0000\u00dc\u00dd\u0005\u0003"+
		"\u0000\u0000\u00dd\u00de\u0003\u0010\b\u0000\u00de\u00df\u0005\u0004\u0000"+
		"\u0000\u00df\u00e0\u0003\u0016\u000b\u0000\u00e0\u00e1\u0006\n\uffff\uffff"+
		"\u0000\u00e1\u0114\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u001c\u0000"+
		"\u0000\u00e3\u00e4\u0005\u0003\u0000\u0000\u00e4\u00e5\u0003\u0010\b\u0000"+
		"\u00e5\u00e6\u0005\u0004\u0000\u0000\u00e6\u00e7\u0003\u0016\u000b\u0000"+
		"\u00e7\u00e8\u0005\u001d\u0000\u0000\u00e8\u00e9\u0003\u0016\u000b\u0000"+
		"\u00e9\u00ea\u0006\n\uffff\uffff\u0000\u00ea\u0114\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0005\u001e\u0000\u0000\u00ec\u00ed\u0003\u0010\b\u0000\u00ed"+
		"\u00f4\u0006\n\uffff\uffff\u0000\u00ee\u00ef\u0005\u0001\u0000\u0000\u00ef"+
		"\u00f0\u0003\u0010\b\u0000\u00f0\u00f1\u0006\n\uffff\uffff\u0000\u00f1"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f2\u00ee\u0001\u0000\u0000\u0000\u00f3"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f4\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0002\u0000\u0000\u00f8"+
		"\u0114\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005\u001f\u0000\u0000\u00fa"+
		"\u00fb\u0003\u0010\b\u0000\u00fb\u0102\u0006\n\uffff\uffff\u0000\u00fc"+
		"\u00fd\u0005\u0001\u0000\u0000\u00fd\u00fe\u0003\u0010\b\u0000\u00fe\u00ff"+
		"\u0006\n\uffff\uffff\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00fc"+
		"\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105"+
		"\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0106"+
		"\u0005\u0002\u0000\u0000\u0106\u0114\u0001\u0000\u0000\u0000\u0107\u0108"+
		"\u0005 \u0000\u0000\u0108\u0109\u0003\u0010\b\u0000\u0109\u010a\u0005"+
		"\u0002\u0000\u0000\u010a\u010b\u0006\n\uffff\uffff\u0000\u010b\u0114\u0001"+
		"\u0000\u0000\u0000\u010c\u010d\u0005,\u0000\u0000\u010d\u010e\u0005\u0003"+
		"\u0000\u0000\u010e\u010f\u0003\u0012\t\u0000\u010f\u0110\u0005\u0004\u0000"+
		"\u0000\u0110\u0111\u0005\u0002\u0000\u0000\u0111\u0112\u0006\n\uffff\uffff"+
		"\u0000\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u00ce\u0001\u0000\u0000"+
		"\u0000\u0113\u00d4\u0001\u0000\u0000\u0000\u0113\u00db\u0001\u0000\u0000"+
		"\u0000\u0113\u00e2\u0001\u0000\u0000\u0000\u0113\u00eb\u0001\u0000\u0000"+
		"\u0000\u0113\u00f9\u0001\u0000\u0000\u0000\u0113\u0107\u0001\u0000\u0000"+
		"\u0000\u0113\u010c\u0001\u0000\u0000\u0000\u0114\u0015\u0001\u0000\u0000"+
		"\u0000\u0115\u0116\u0003\u0014\n\u0000\u0116\u0117\u0006\u000b\uffff\uffff"+
		"\u0000\u0117\u0123\u0001\u0000\u0000\u0000\u0118\u011e\u0005\u0005\u0000"+
		"\u0000\u0119\u011a\u0003\u0014\n\u0000\u011a\u011b\u0006\u000b\uffff\uffff"+
		"\u0000\u011b\u011d\u0001\u0000\u0000\u0000\u011c\u0119\u0001\u0000\u0000"+
		"\u0000\u011d\u0120\u0001\u0000\u0000\u0000\u011e\u011c\u0001\u0000\u0000"+
		"\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0121\u0001\u0000\u0000"+
		"\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0121\u0123\u0005\u0006\u0000"+
		"\u0000\u0122\u0115\u0001\u0000\u0000\u0000\u0122\u0118\u0001\u0000\u0000"+
		"\u0000\u0123\u0017\u0001\u0000\u0000\u0000\u0124\u0125\u0005!\u0000\u0000"+
		"\u0125\u012b\u0006\f\uffff\uffff\u0000\u0126\u0127\u0005\"\u0000\u0000"+
		"\u0127\u012b\u0006\f\uffff\uffff\u0000\u0128\u0129\u0005#\u0000\u0000"+
		"\u0129\u012b\u0006\f\uffff\uffff\u0000\u012a\u0124\u0001\u0000\u0000\u0000"+
		"\u012a\u0126\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000"+
		"\u012b\u0019\u0001\u0000\u0000\u0000\u012c\u012d\u0006\r\uffff\uffff\u0000"+
		"\u012d\u012e\u0003\u0018\f\u0000\u012e\u012f\u0006\r\uffff\uffff\u0000"+
		"\u012f\u013b\u0001\u0000\u0000\u0000\u0130\u0131\u0005$\u0000\u0000\u0131"+
		"\u0133\u0005\u0005\u0000\u0000\u0132\u0134\u0003\u001c\u000e\u0000\u0133"+
		"\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135"+
		"\u0133\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0001\u0000\u0000\u0000\u0137\u0138\u0005\u0006\u0000\u0000\u0138"+
		"\u0139\u0006\r\uffff\uffff\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a"+
		"\u012c\u0001\u0000\u0000\u0000\u013a\u0130\u0001\u0000\u0000\u0000\u013b"+
		"\u0143\u0001\u0000\u0000\u0000\u013c\u013d\n\u0002\u0000\u0000\u013d\u013e"+
		"\u0005\t\u0000\u0000\u013e\u013f\u0005%\u0000\u0000\u013f\u0140\u0005"+
		"\n\u0000\u0000\u0140\u0142\u0006\r\uffff\uffff\u0000\u0141\u013c\u0001"+
		"\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0141\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u001b\u0001"+
		"\u0000\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0147\u0003"+
		"\u001a\r\u0000\u0147\u0148\u0005,\u0000\u0000\u0148\u0154\u0006\u000e"+
		"\uffff\uffff\u0000\u0149\u014a\u0005\u0001\u0000\u0000\u014a\u014b\u0005"+
		",\u0000\u0000\u014b\u014d\u0006\u000e\uffff\uffff\u0000\u014c\u0149\u0001"+
		"\u0000\u0000\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001"+
		"\u0000\u0000\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f\u0151\u0001"+
		"\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0151\u0153\u0005"+
		"\u0002\u0000\u0000\u0152\u014e\u0001\u0000\u0000\u0000\u0153\u0156\u0001"+
		"\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0155\u0001"+
		"\u0000\u0000\u0000\u0155\u001d\u0001\u0000\u0000\u0000\u0156\u0154\u0001"+
		"\u0000\u0000\u0000\u0018#0:RU]eo\u009b\u00bb\u00bd\u00c9\u00cc\u00f4\u0102"+
		"\u0113\u011e\u0122\u012a\u0135\u013a\u0143\u014e\u0154";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}