package Inter;

import Symbols.Type;

public class While extends Stmt {
    Expr expr;
    Stmt stmt;

    public While(){
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
        expr.jumping(0, a);
        int label = newLabel();
        emitLabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
    }
}
