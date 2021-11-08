package Inter;

import Lexer.Token;
import Symbols.Type;

public class Op extends Expr{
    
    public Op(Token tok, Type p){
        super(tok, p);
    }

    public Expr reduce(){
        Expr x = gen();
        Temp t = new Temp(type);
        emit(toString() + " = " + x.toString());
        return t;
    }
}
