// Generated from D:/программирование/итмо/6 семестр/Методы трансляции/parser_generator/src/parsers\GrammarParser.g4 by ANTLR 4.5.1
package parsers;

import java.util.*;
import llgrammar.LLGrammar;
import llgrammar.Pair;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(GrammarParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(GrammarParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parser_multi_rule}.
	 * @param ctx the parse tree
	 */
	void enterParser_multi_rule(GrammarParser.Parser_multi_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parser_multi_rule}.
	 * @param ctx the parse tree
	 */
	void exitParser_multi_rule(GrammarParser.Parser_multi_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void enterEnumeration(GrammarParser.EnumerationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#enumeration}.
	 * @param ctx the parse tree
	 */
	void exitEnumeration(GrammarParser.EnumerationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#parser_single_rule}.
	 * @param ctx the parse tree
	 */
	void enterParser_single_rule(GrammarParser.Parser_single_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#parser_single_rule}.
	 * @param ctx the parse tree
	 */
	void exitParser_single_rule(GrammarParser.Parser_single_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void enterLexer_rule(GrammarParser.Lexer_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void exitLexer_rule(GrammarParser.Lexer_ruleContext ctx);
}