package Inter;

import Lexer.Word;
import Symbols.Type;

public class Id extends Expr {
    public int offset; // endereco relativo
    public Id(Word id, Type p, int b) {
        super(id, p);
        offset = b;
    }
}
