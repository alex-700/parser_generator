package llgrammar;

import java.util.*;

public class LLGrammar {
    public Map<String, List<List<String>>> grammar;
    public Map<String, List<List<String>>> grammarArgs;
    public Set<String> epsilon;
    public Map<String, Set<String>> first;
    public Map<String, Set<String>> follow;
    public Set<String> nonTerminals;
    public Map<String, List<Pair>> args;
    public Map<String, List<Pair>> rets;

    public LLGrammar() {
        grammar = new HashMap<>();
        grammarArgs = new HashMap<>();
        epsilon = new HashSet<>();
        args = new HashMap<>();
        rets = new HashMap<>();
    }

    public void addRules(String nonTerminal, List<List<String>> rules, List<List<String>> args) {
        if (grammar.containsKey(nonTerminal)) {
            grammar.get(nonTerminal).addAll(rules);
            grammarArgs.get(nonTerminal).addAll(args);
        } else {
            grammar.put(nonTerminal, rules);
            grammarArgs.put(nonTerminal, args);
        }
    }

    public void addEpsilon(Collection<String> nonTerminal) {
        epsilon.addAll(nonTerminal);
    }

    public void addAttrs(String nonTerminal, List<Pair> arguments, List<Pair> returns) {
        args.put(nonTerminal, arguments);
        rets.put(nonTerminal, returns);
    }

    public void build() {
        constructEpsilon();

        nonTerminals = new HashSet<>(grammar.keySet());
        nonTerminals.addAll(epsilon);

        first = new HashMap<>();
        constructFirst();
        follow = new HashMap<>();
        constructFollow();
        for (String a : epsilon) {
            first.get(a).add("EPS");
        }
    }

    public boolean isTerminal(String a) {
        return Character.isUpperCase(a.charAt(0));
    }

    public boolean isNonTerminal(String a) { return Character.isLowerCase(a.charAt(0)); }

    public boolean isBlockOfCode(String a) { return a.charAt(0) == '@'; }

    public Set<String> first(String a) {
        if (isBlockOfCode(a)) {
            throw new IllegalStateException("first from BlockOfCode");
        }
        if (isTerminal(a)) {
            return Collections.singleton(a);
        } else {
            return first.get(a);
        }
    }

    public Set<String> first(List<String> rule) {
        Set<String> ans = new HashSet<>();
        for (String a : rule) {
            if (!isBlockOfCode(a)) {
                ans.addAll(first(a));
                if (!epsilon.contains(a)) {
                    break;
                }
            }
        }
        if (isCanBeEpsilon(rule)) {
            ans.add("EPS");
        }
        return ans;
    }

    private void constructEpsilon() {
        boolean was = true;
        while (was) {
            was = false;
            for (String a : grammar.keySet()) {
                for (List<String> rule : grammar.get(a)) {
                    boolean can = true;
                    for (String b : rule) {
                        if (!epsilon.contains(b)) {
                            can = false;
                            break;
                        }
                    }
                    if (can) was |= epsilon.add(a);
                }
            }
        }
    }

    private void constructFirst() {
        for (String nonTerminal : nonTerminals) {
            first.put(nonTerminal, new HashSet<>());
        }
        boolean was = true;
        while (was) {
            was = false;
            for (String nonTerminal : grammar.keySet()) {
                for (List<String> rule : grammar.get(nonTerminal)) {
                    was |= first.get(nonTerminal).addAll(first(rule));
                }
            }
        }
    }

    private boolean isCanBeEpsilon(List<String> rule) {
        for (String a : rule) {
            if (!isBlockOfCode(a)) {
                if (!epsilon.contains(a)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void constructFollow() {
        for (String a : nonTerminals) {
            follow.put(a, new HashSet<>());
        }
//        kostyli
        follow.get("e").add("$");

        boolean was = true;
        while (was) {
            was = false;
            for (String a : grammar.keySet()) {
                for (List<String> rule : grammar.get(a)) {
                    for (int i = 0; i < rule.size(); i++) {
                        String b = rule.get(i);
                        if (isNonTerminal(b)) {
                            Set<String> upd = first(rule.subList(i + 1, rule.size()));
                            upd.remove("EPS");
                            was |= follow.get(b).addAll(upd);
                            if (isCanBeEpsilon(rule.subList(i + 1, rule.size()))) {
                                was |= follow.get(b).addAll(follow.get(a));
                            }
                        }
                    }
                }
            }
        }
    }
}