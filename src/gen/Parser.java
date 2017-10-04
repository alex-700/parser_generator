package gen;

import java.util.*;
import gen.*;
import gen.Lexer.*;

public class Parser {

    private Lexer lex;

    public Parser(String input) {
        lex = new Lexer(input);
    }
    private static class Context {
        public String name;
        public List<Context> children;
		public String text;

        public Context(String name) {
            this.text = "";
			this.name = name;
        }

        public Context(Token token) {
            name = token.type.name();
            text = token.text;
        }
        void addChild(Context child) {
			if (children == null) {
				children = new ArrayList<>();
			}
			children.add(child);
			if (children.size() == 1) {
				text = child.text;
			} else {
				text += " " + child.text;
			}
        }
        void toEps() {
            children = new ArrayList<>();
			text = "";
        }
    }
	public static class Contexta extends Context {
		public Contexta() {
			super("a");
		}
	}

	public static class Contexteprime extends Context {
		public Contexteprime() {
			super("e'");
		}
	}

	public static class Contexte extends Context {
		public Contexte() {
			super("e");
		}
	}

	public static class Contextaprime extends Context {
		public Contextaprime() {
			super("a'");
		}
	}

	public static class Contextv extends Context {
		public Contextv() {
			super("v");
		}
	}

	public Contexta a() {
		Contexta _c = new Contexta();
		if (lex.cur == null) {
			throw new IllegalStateException("Unexpected end of input");
		}
		switch(lex.cur.type) {
			case NOT:
			case OB:
			case VAR:
			{
				Contextv child0 = v();
				_c.addChild(child0);
				Contextaprime child1 = aprime();
				_c.addChild(child1);
			}
				break;
			default:
				throw new IllegalStateException(lex.cur.toString());
		}
		return _c;
	}

	public Contexteprime eprime() {
		Contexteprime _c = new Contexteprime();
		if (lex.cur == null) {
			_c.toEps(); return _c;
		}
		switch(lex.cur.type) {
			case CB:
				break;
			case OR:
			{
				if (TokenType.OR != lex.cur.type) {
					throw new IllegalStateException(lex.cur.toString());
				}
				Context child0 = new Context(lex.cur);
				_c.addChild(child0);
				lex.nextToken();
				Contexta child1 = a();
				_c.addChild(child1);
				Contexteprime child2 = eprime();
				_c.addChild(child2);
			}
				break;
			case XOR:
			{
				if (TokenType.XOR != lex.cur.type) {
					throw new IllegalStateException(lex.cur.toString());
				}
				Context child0 = new Context(lex.cur);
				_c.addChild(child0);
				lex.nextToken();
				Contexta child1 = a();
				_c.addChild(child1);
				Contexteprime child2 = eprime();
				_c.addChild(child2);
			}
				break;
			default:
				throw new IllegalStateException(lex.cur.toString());
		}
		return _c;
	}

	public Contexte e() {
		Contexte _c = new Contexte();
		if (lex.cur == null) {
			throw new IllegalStateException("Unexpected end of input");
		}
		switch(lex.cur.type) {
			case NOT:
			case OB:
			case VAR:
			{
				Contexta child0 = a();
				_c.addChild(child0);
				Contexteprime child1 = eprime();
				_c.addChild(child1);
			}
				break;
			default:
				throw new IllegalStateException(lex.cur.toString());
		}
		return _c;
	}

	public Contextaprime aprime() {
		Contextaprime _c = new Contextaprime();
		if (lex.cur == null) {
			_c.toEps(); return _c;
		}
		switch(lex.cur.type) {
			case OR:
			case XOR:
			case CB:
				break;
			case AND:
			{
				if (TokenType.AND != lex.cur.type) {
					throw new IllegalStateException(lex.cur.toString());
				}
				Context child0 = new Context(lex.cur);
				_c.addChild(child0);
				lex.nextToken();
				Contextv child1 = v();
				_c.addChild(child1);
				Contextaprime child2 = aprime();
				_c.addChild(child2);
			}
				break;
			default:
				throw new IllegalStateException(lex.cur.toString());
		}
		return _c;
	}

	public Contextv v() {
		Contextv _c = new Contextv();
		if (lex.cur == null) {
			throw new IllegalStateException("Unexpected end of input");
		}
		switch(lex.cur.type) {
			case VAR:
			{
				if (TokenType.VAR != lex.cur.type) {
					throw new IllegalStateException(lex.cur.toString());
				}
				Context child0 = new Context(lex.cur);
				_c.addChild(child0);
				lex.nextToken();
			}
				break;
			case NOT:
			{
				if (TokenType.NOT != lex.cur.type) {
					throw new IllegalStateException(lex.cur.toString());
				}
				Context child0 = new Context(lex.cur);
				_c.addChild(child0);
				lex.nextToken();
				Contextv child1 = v();
				_c.addChild(child1);
			}
				break;
			case OB:
			{
				if (TokenType.OB != lex.cur.type) {
					throw new IllegalStateException(lex.cur.toString());
				}
				Context child0 = new Context(lex.cur);
				_c.addChild(child0);
				lex.nextToken();
				Contexte child1 = e();
				_c.addChild(child1);
				if (TokenType.CB != lex.cur.type) {
					throw new IllegalStateException(lex.cur.toString());
				}
				Context child2 = new Context(lex.cur);
				_c.addChild(child2);
				lex.nextToken();
			}
				break;
			default:
				throw new IllegalStateException(lex.cur.toString());
		}
		return _c;
	}


}
