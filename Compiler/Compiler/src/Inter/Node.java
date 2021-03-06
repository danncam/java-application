package Inter;

import Lexer.Lexer;

public class Node {
    int lexline = 0;
    Node(){
        lexline = Lexer.line;
    }

    void error(String s) {
        throw new Error("near line " + lexline + ": " + s);
    }

    static int labels = 0;
    public int newLabel(){
        return ++labels;
    }

    public void emitLabel(int i){
        System.out.print("L" + i + ":");
    }

    public void emit(String s){
        System.out.print("\t" + s);
    }
}
