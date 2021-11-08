package Symbols;

import Lexer.Tag;

public class Array extends Type {
    public Type of; // arranjo "of" Type
    public int size = 1; // número de elementos
    
    public Array(int size, Type p) {
        super("[]", Tag.INDEX, size*p.width);
        of = p;
    }

    @Override
    public String toString() {
        return "Array [of= " + of + ", with size= " + size + "]";
    }
}
