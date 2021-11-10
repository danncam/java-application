package Lexer;

/**
 * Classe Num compõe o valor do Token
 */
public class Num extends Token {
    public final int value;

    public Num(int value) {
        super(Tag.NUM);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Num ["+ value + "]";
        
    }

    
}
