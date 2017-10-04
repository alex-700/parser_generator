import java.util.ArrayList;
import java.util.List;

public class ParserTemplate {
    private static class Context {
        public String text;
        public List<Context> children;

        public Context(String text) {
            this.text = text;
        }

        void addChild(Context child) {
            children.add(child);
        }
        void toEps() {
            children = new ArrayList<>();
        }
    }

}