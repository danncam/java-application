package App;

import Lexer.Lexer;
import Parser.Parser;

public class App {
    public static void main(String[] args) throws Exception {
        Lexer lex = new Lexer();
        Parser parse = new Parser(lex);
        parse.program();
        System.out.write('\n');
    }
}
