package App;

import java.io.File;
import java.io.IOException;

import Lexer.Lexer;
import Parser.Parser;

/* o código cria um analisador léxico e um analisador sintático
 * O analisador sintático é criado a partir da saída gerada pelo léxico.
 */
public class App {
    public static void main(String[] args) throws IOException {

        File file = new File(filepath);

        Lexer lex = new Lexer();
        Parser parse = new Parser(lex);
        parse.program();
        System.out.write('\n');
    }
}
