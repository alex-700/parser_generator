import llgrammar.LLGrammar;
import llgrammar.Pair;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parsers.GrammarLexer;
import parsers.GrammarParser;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void genLexer(Map<String, String> lexer, List<String> orderLex) throws IOException {
        System.out.println(lexer.size());
        BufferedReader br = new BufferedReader(new FileReader(new File("./src/LexerTemplate.java")));
        StringBuilder sb = new StringBuilder("package gen;\n\n");
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }
        br.close();


        String lexerText = sb.toString();
        lexerText = lexerText.replace("Template", "");
        StringBuilder tokenTypes = new StringBuilder();
        for (String key : orderLex) {
            tokenTypes.append(key).append('(').append(lexer.get(key)).append("), ");
        }
        System.out.println(tokenTypes);
        lexerText = lexerText.replace("/*#1#*/", tokenTypes);

        File f = new File("./src/gen/Lexer.java");
        f.getParentFile().mkdirs();
        try (PrintWriter pw = new PrintWriter(f)) {
            pw.println(lexerText);
        }
    }

    public static String goodName(String a) {
        return a.replace("'", "prime");
    }

    public static String shift(int depth) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            ans.append('\t');
        }
        return ans.toString();
    }

    public static void genCodeToThisFuckingRule(StringBuilder code, LLGrammar grammar,
                                                List<String> rule, List<String> args) {
        if (rule.size() != 0) code.append(shift(3)).append("{\n");
        for (int i = 0; i < rule.size(); i++) {
            String a = rule.get(i);
            if (grammar.isBlockOfCode(a)) {
                code.append(shift(4)).append(a.substring(1, a.length()).replace("\n", "\n" + shift(4))).append('\n');
            } else if (grammar.isTerminal(a)) {
                code.append(String.format("%sif (TokenType.%s != lex.cur.type) {\n", shift(4), a));
                code.append(String.format("%sthrow new IllegalStateException(lex.cur.toString());\n", shift(5)));
                code.append(String.format("%s}\n", shift(4)));
                code.append(String.format("%sContext child%d = new Context(lex.cur);\n", shift(4), i));
                code.append(String.format("%s_c.addChild(child%d);\n", shift(4), i));
                code.append(String.format("%slex.nextToken();\n", shift(4)));
            } else {
                code.append(String.format("%sContext%s child%d = %s(%s);\n", shift(4), goodName(a), i, goodName(a), args.get(i)));
                code.append(String.format("%s_c.addChild(child%d);\n", shift(4), i));
            }
        }
        if (rule.size() != 0) code.append(shift(3)).append("}\n");
    }

    public static String getAllDecl(LLGrammar grammar, String nonTerminal) {
        StringBuilder sb = new StringBuilder();
        List<Pair> list = grammar.args.get(nonTerminal);
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) sb.append(", ");
            sb.append(String.format("%s %s", list.get(i).type, list.get(i).name));
        }
        return sb.toString();
    }

    public static String getAllArgsNames(LLGrammar grammar, String nonTerminal) {
        StringBuilder sb = new StringBuilder();
        List<Pair> list = grammar.args.get(nonTerminal);
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) sb.append(", ");
            sb.append(list.get(i).name);
        }
        return sb.toString();
    }

    public static void genParser(LLGrammar grammar, String membersCode, Map<String, String> init) {
        StringBuilder code = new StringBuilder();
        for (String a : grammar.nonTerminals) {

            code.append(String.format("%spublic %s %s(%s) {\n", shift(1), getContextName(a),
                    goodName(a), getAllDecl(grammar, a)));
//            code.append(String.format("%sfinal List<Tree> ch = new ArrayList<>();\n", shift(2)));

            code.append(String.format("%s%s %s = new %s(%s);\n", shift(2), getContextName(a), "_c", getContextName(a),
                    getAllArgsNames(grammar, a)));
            code.append(String.format("%sif (lex.cur == null) {\n", shift(2)));
            if (grammar.epsilon.contains(a) && grammar.follow.get(a).contains("$")) {
                code.append(String.format("%s_c.toEps(); return _c;\n", shift(3)));
            } else {
                code.append(String.format("%sthrow new IllegalStateException(\"Unexpected end of input\");\n", shift(3)));
            }
            code.append(String.format("%s}\n", shift(2)));
            code.append(String.format("%sswitch(%s) {\n", shift(2), "lex.cur.type"));
            List<List<String>> get = grammar.grammar.get(a);
            for (int i = 0; i < get.size(); i++) {
                List<String> rule = get.get(i);
                Set<String> f = grammar.first(rule);
                for (String b : f) {
                    if (b.equals("EPS")) {
                        for (String c : grammar.follow.get(a)) {
                            if (!c.equals("$")) {
                                code.append(String.format("%scase %s:\n", shift(3), c));
                            }
                        }
                    } else {
                        code.append(String.format("%scase %s:\n", shift(3), b));
                    }
                }
                genCodeToThisFuckingRule(code, grammar, rule, grammar.grammarArgs.get(a).get(i));
                code.append(String.format("%sbreak;\n", shift(4)));
            }
            code.append(String.format("%sdefault:\n", shift(3)));
            code.append(String.format("%sthrow new IllegalStateException(lex.cur.toString());\n", shift(4)));
            code.append(String.format("%s}\n", shift(2)));
//            code.append(String.format("%sreturn new Tree(\"%s\", ch);\n", shift(2), a));
            code.append(String.format("%sreturn _c;\n", shift(2)));
            code.append(String.format("%s}\n\n", shift(1)));
        }

        File file = new File("./src/gen/Parser.java");
        file.getParentFile().mkdirs();
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("package gen;\n");
            pw.println("import java.util.*;");
            pw.println("import gen.*;");
            pw.println("import gen.Lexer.*;\n");
            pw.println("public class Parser {\n" +
                    membersCode + "\n" +
                    "    private Lexer lex;\n" +
                    "\n" +
                    "    public Parser(String input) {\n" +
                    "        lex = new Lexer(input);\n" +
                    "    }");
            pw.println("    private static class Context {\n" +
                    "        public String name;\n" +
                    "        public List<Context> children;\n" +
                    "\t\tpublic String text;\n" +
                    "\n" +
                    "        public Context(String name) {\n" +
                    "            this.text = \"\";\n" +
                    "\t\t\tthis.name = name;\n" +
                    "        }\n" +
                    "\n" +
                    "        public Context(Token token) {\n" +
                    "            name = token.type.name();\n" +
                    "            text = token.text;\n" +
                    "        }\n" +
                    "        void addChild(Context child) {\n" +
                    "\t\t\tif (children == null) {\n" +
                    "\t\t\t\tchildren = new ArrayList<>();\n" +
                    "\t\t\t}\n" +
                    "\t\t\tchildren.add(child);\n" +
                    "\t\t\tif (children.size() == 1) {\n" +
                    "\t\t\t\ttext = child.text;\n" +
                    "\t\t\t} else {\n" +
                    "\t\t\t\ttext += \" \" + child.text;\n" +
                    "\t\t\t}\n" +
                    "        }\n" +
                    "        void toEps() {\n" +
                    "            children = new ArrayList<>();\n" +
                    "\t\t\ttext = \"\";\n" +
                    "        }\n" +
                    "    }");
            for (String a : grammar.nonTerminals) {
                pw.println(genContext(grammar, a, init.get(a)));
            }
            pw.println(code);
            pw.println("}");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addDecl(StringBuilder code, Pair decl) {
        code.append(String.format("%spublic %s %s;\n", shift(2), decl.type, decl.name));
    }

    public static String genContext(LLGrammar grammar, String nonTerminal, String initBlock) {
        String className = getContextName(nonTerminal);
        StringBuilder code = new StringBuilder();
        code.append(String.format("%spublic static class %s extends Context {\n", shift(1), className));
        List<Pair> args = grammar.args.get(nonTerminal);
        List<Pair> rets = grammar.rets.get(nonTerminal);
        for (Pair decl : args) {
            addDecl(code, decl);
        }
        for (Pair decl : rets) {
            addDecl(code, decl);
        }
        code.append(String.format("%spublic %s(", shift(2), className));
        for (int i = 0; i < args.size(); i++) {
            if (i != 0) code.append(", ");
            code.append(String.format("%s %s", args.get(i).type, args.get(i).name));
        }
        code.append(") {\n");
        code.append(String.format("%ssuper(\"%s\");\n", shift(3), nonTerminal));
        for (Pair d : args) {
            code.append(String.format("%sthis.%s = %s;\n", shift(3), d.name, d.name));
        }
        if (initBlock != null)
            code.append(shift(3)).append(initBlock.replace("$", "").trim().replace("\n", "\n" + shift(3))).append('\n');

        code.append(String.format("%s}\n", shift(2)));
        code.append(String.format("%s}\n", shift(1)));
        return code.toString();
    }

    private static String getContextName(String nonTerminal) {
        return "Context" + goodName(nonTerminal);
    }

    public static void main(String[] args) throws IOException {
        ANTLRInputStream inputStream = new ANTLRInputStream(new FileInputStream(new File("grammar2.in")));
        GrammarLexer lexer = new GrammarLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokens);
//        System.out.println(parser.rules().lex);
        GrammarParser.RulesContext context = parser.rules();
        System.out.println("Generate lexer");
        genLexer(context.lex, context.orderLex);
        System.out.println("Done");
        LLGrammar grammar = context.gram;
        System.out.println("Calculate first and follow");
        grammar.build();
        System.out.println("-----first------");
        for (Map.Entry<String, Set<String>> p : grammar.first.entrySet()) {
            System.out.println(p.getKey() + " -> " + p.getValue());
        }
        System.out.println("-----follow-----");
        for (Map.Entry<String, Set<String>> p : grammar.follow.entrySet()) {
            System.out.println(p.getKey() + " -> " + p.getValue());
        }
        System.out.println("----------------");
        System.out.println("Generate parser");
        genParser(grammar, context.membersCode, context.init);
        System.out.println("Done");
    }

}