package Inter;

public class Seq extends Stmt {
    Stmt stmt1;
    Stmt stmt2;

    public Seq(Stmt s1, Stmt s2){
        this.stmt1 = s1;
        this.stmt2 = s2;
    }

    public void gen(int b, int a){
        if(this.stmt1 == Stmt.Null){
            this.stmt2.gen(b, a);
        } else {
            if(this.stmt2 == Stmt.Null){
                this.stmt1.gen(b, a);
            } else {
                int label = newLabel();
                this.stmt1.gen(b, label);
                emitLabel(label);
                this.stmt2.gen(label, a);
            }
        }
    }
}
