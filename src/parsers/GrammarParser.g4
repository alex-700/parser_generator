parser grammar GrammarParser;

options {
    tokenVocab=GrammarLexer;
}

@header {
import java.util.*;
import llgrammar.LLGrammar;
import llgrammar.Pair;
}

rules returns [LLGrammar gram,
               Map<String, String> lex,
               List<String> orderLex,
               String membersCode,
               Map<String, String> init]
@init {
    $orderLex = new ArrayList<>();
    $lex = new HashMap<>();
    $gram = new LLGrammar();
    $membersCode = "";
    $init = new HashMap<>();
}
:   ( MEMBERS SHARP_START
        CODE
      SHARP_FINISH
      { $membersCode = $CODE.text; }
    )?

    (((p = parser_multi_rule {
        $gram.addRules($p.nonterm, $p.multi_rule, $p.multi_args);
        $gram.addEpsilon($p.epsilon);
        $gram.addAttrs($p.nonterm, $p.args, $p.rets);
        $init.put($p.nonterm, $p.initBlock);
    })
    | (lexer_rule {
        $lex.put($lexer_rule.term, $lexer_rule.regexp);
        $orderLex.add($lexer_rule.term);
    })) SEMICOLON)+;

parser_multi_rule returns [String nonterm,
                           List<List<String>> multi_rule,
                           List<List<String>> multi_args,
                           Set<String> epsilon,
                           List<Pair> args,
                           List<Pair> rets,
                           String initBlock]

@init {
    $multi_rule = new ArrayList<>();
    $multi_args = new ArrayList<>();
    $epsilon = new HashSet<>();
    $args = new ArrayList<>();
    $rets = new ArrayList<>();
}
: Nonterm { $nonterm = $Nonterm.text; }
             (OSB
                (e = enumeration) { $args = $e.decl; }
             CSB)?

             (RETURNS OSB
                (e = enumeration) { $rets = $e.decl; }
             CSB)?

             (LOCALS OSB
                (e = enumeration) { $rets.addAll($e.decl); }
             CSB)?

             (INIT OCB
                TEXT
             CCB
             { $initBlock = $TEXT.text; }
             )?

             COLON
             (    (p = parser_single_rule[$args, $rets]) {
                if ($p.rule.size() == 0) {
                    $epsilon.add($nonterm);
                }
                $multi_rule.add($p.rule);
                $multi_args.add($p.args);
             })
             (OR (p = parser_single_rule[$args, $rets]) {
                if ($p.rule.size() == 0) {
                    $epsilon.add($nonterm);
                }
                $multi_rule.add($p.rule);
                $multi_args.add($p.args);
             })*
             ;


enumeration returns [List<Pair> decl]
@init {
    $decl = new ArrayList<>();
}
:
(type = Word) (name = Word) { $decl.add(new Pair($type.text, $name.text)); }
(COMMA (type = Word) (name = Word) { $decl.add(new Pair($type.text, $name.text)); })*
;

parser_single_rule
[List<Pair> ruleArgs, List<Pair> ruleRets]
returns [List<String> rule, List<String> args]
locals [int cnt, Map<String, String> defines, String code, List<String> arguments]
@ init {
    $rule = new ArrayList<>();
    $cnt = 0;
    $defines = new HashMap<>();
    for (Pair p : $ruleArgs) {
        $defines.put("$" + p.name, "_c." + p.name);
    }
    for (Pair p : $ruleRets) {
        $defines.put("$" + p.name, "_c." + p.name);
    }
    $args = new ArrayList<>();
}
:
(
    (((def = Nonterm) EQUAL)? (word = (Nonterm | Term))  {
        $rule.add($word.text);
        //System.err.println($def.text + "-> child" + $cnt);
        if ($def != null) {
            $defines.put("$" + $def.text, "child" + $cnt);
        } else {
            $defines.put("$" + $word.text, "child" + $cnt);
        }
        $cnt++;
        $arguments = new ArrayList<>();
        $args.add("");
    } (OSB (Word { $arguments.add($Word.text); }) (COMMA Word { $arguments.add($Word.text); })* CSB {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String arg : $arguments) {
            for (Map.Entry<String, String> def : $defines.entrySet()) {
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
        $args.set($cnt - 1, sb.toString());
    })? )

    |

    (OCB TEXT CCB {
        $code = $TEXT.text;
        //System.err.println($code);
        //System.err.println($defines);
        for (Map.Entry<String, String> def : $defines.entrySet()) {
            $code = $code.replace(def.getKey(), def.getValue());
        }
        $rule.add("@" + $code);
        $args.add("");
        $cnt++;
    })
)*
;

lexer_rule returns [String term, String regexp]
: (Term COLON Regular) { $term = $Term.text; $regexp = $Regular.text; };
