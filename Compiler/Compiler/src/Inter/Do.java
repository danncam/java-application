package Inter;

import Symbols.Type;

public class Do extends Stmt{
    Expr expr;
    Stmt stmt;
    public Do() {
        this.expr = null;
        this.stmt = null;
    }

    public void init(Expr x, Stmt s){
        this.expr = x;
        this.stmt = s;
        if(this.expr.type != Type.Bool){
            expr.error("Boolean Required in while statemet");
        }
    }

    public void gen(int b, int a){
        this.after = a;
        int label = newLabel();
        stmt.gen(b, label);
        emitLabel(label);
        expr.jumping(b, 0);
    }
}
