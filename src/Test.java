//import gen.Parser;

import gen.Parser;

import java.util.*;
import java.io.*;

public class Test {
    FastScanner in;
    PrintWriter out;

    public void solve() throws IOException {
        /*Lexer lexer = new Lexer("a || b || > a b\n");
        while (lexer.cur != null) {
            System.out.println(lexer.cur);
            lexer.nextToken();
        }*/
        Parser parser = new Parser("(a or b) and (x xor c)");
        Parser.Contexte contexte = parser.e();
        System.out.println(contexte);
    }

    public void run() {
        try {
            in = new FastScanner(System.in);
            out = new PrintWriter(System.out);
            Locale.setDefault(Locale.US);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] arg) {
        new Test().run();
    }
}