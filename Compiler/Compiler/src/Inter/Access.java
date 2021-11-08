package Inter;

import Lexer.Tag;
import Lexer.Word;
import Symbols.Type;

public class Access extends Op {
    public Id array;
    public Expr index;

    public Access(Id a, Expr i, Type p){
        super(new Word("[]", Tag.INDEX), p);
        array = a;
        index = i;
    }

    public Expr gen(){
        return new Access(array, index.reduce(), type);
    }

    public void jumping(int t, int f){
        emitJumps(reduce().toString(), t, f);
    }

    @Override
    public String toString() {
        return "Access [array=" + array.toString() + ", index=" + index.toString() + "]";
    }

    
}
