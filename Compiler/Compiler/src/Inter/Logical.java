package Inter;

import Lexer.Token;
import Symbols.Type;

public class Logical extends Expr{
    public Expr expr1, expr2;
    
    Logical(Token tok, Expr x1, Expr x2){
        super(tok, null); // tipo nulo para começar
        this.expr1 = x1;
        this.expr1 = x2;
        type = check(expr1.type, expr2.type);
        if(type == null){
            error("Type Error");
        }
    }

    public Type check(Type p1, Type p2) {
        if(p1 == Type.Bool && p2 == Type.Bool){
            return Type.Bool;
        } else {
            return null;
        }
    }

    public Expr gen(){
        int f = newLabel();
        int a = newLabel();
        Temp temp = new Temp(type);
        this.jumping(0, f);
        emit(temp.toString() + " = true");
        emitLabel(f);
        emit(temp.toString() + " = false");
        emitLabel(a);
        return temp;
    }

    @Override
    public String toString() {
        return "Logical [expr1=" + expr1.toString() + "op= " + op.toString() +", expr2=" + expr2.toString() + "]";
    }

    
}
