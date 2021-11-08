package Inter;

import Lexer.Token;
import Symbols.Type;

public class Unary extends Op{
    public Expr expr;

    public Unary(Token tok, Expr x){
        super(tok, null);
        expr = x;
        type = Type.max(Type.Int, expr.type);
        if(type == null)
            error("Type Error");
    }

    public Expr gen(){
        return new Unary(op, expr.reduce());
    }

    @Override
    public String toString() {
        return "Unary [op= " + op.toString() + "expr= " + expr.toString() + "]";
    }
}
