import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexerTemplate {
    public enum TokenType {
        /*#1#*/WHITESPACE("[ \t\f\r\n]+");
        public final String pattern;

        private TokenType(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class Token {
        public TokenType type;
        public String text;

        public Token(TokenType type, String text) {
            this.type = type;
            this.text = text;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", type.name(), text);
        }
    }

    public Token cur;
    private Matcher matcher;

    public LexerTemplate(String input) {
        StringBuilder sb = new StringBuilder();
        for (TokenType type : TokenType.values()) {
            sb.append(String.format("|(?<%s>%s)", type.name(), type.pattern));
        }
        matcher = Pattern.compile(sb.substring(1)).matcher(input);
        nextToken();
    }

    public void nextToken() {
        do {
            if (!matcher.find()) {
                cur = null;
                return;
            }
        } while (matcher.group(TokenType.WHITESPACE.name()) != null);
        for (TokenType type : TokenType.values()) {
            if (matcher.group(type.name()) != null) {
                cur = new Token(type, matcher.group(type.name()));
                return;
            }
        }
    }
}