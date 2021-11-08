package Inter;

import Symbols.Type;

public class If extends Stmt {
    Expr expr;
    Stmt stmt;

    public If(Expr x, Stmt s){
        this.expr = x;
        this.stmt = s;
        if(expr.type != Type.Bool){
            expr.error("Boolean Required in if statement");
        }
    }

    public void gen(int b, int a){
        int label = newLabel();
        expr.jumping(0, a);
        emitLabel(label);
        stmt.gen(label, a);
    }
}
