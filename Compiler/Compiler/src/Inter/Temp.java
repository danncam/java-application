package Inter;

import Lexer.Word;
import Symbols.Type;

public class Temp extends Expr{
    static int count = 0;
    int number = 0;

    public Temp(Type p){
        super(Word.temp, p);
        number = ++count;
    }

    @Override
    public String toString() {
        return "Temp [number=" + number + "]";
    }

    
}
