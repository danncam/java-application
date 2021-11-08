package Inter;

import Lexer.Token;
import Symbols.Type;

public class Arith extends Op{
    public Expr expr1, expr2;

    public Arith(Token tok, Expr x1, Expr x2){
        super(tok, null);
        this.expr1 = x1;
        this.expr2 = x2;
        this.type = Type.max(expr1.type, expr2.type);
        if(type == null){
            error("Type Error");
        }
    }

    public Expr gen(){
        return new Arith(op, expr1.reduce(), expr2.reduce());
    }

    @Override
    public String toString() {
        return "Arith [expr1=" + expr1 + ", expr2=" + expr2 + "]";
    }
}
