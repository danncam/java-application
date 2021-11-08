package Lexer;

import java.io.IOException;
import java.util.Hashtable;

import Symbols.Type;

public class Lexer {
    public static int line = 1;
    char peek;
    Hashtable<String, Word> words = new Hashtable<String, Word>();
    void reserve(Word word){
        words.put(word.lexeme, word);
    }

    public Lexer(){
        reserve( new Word("if", Tag.IF) );
        reserve( new Word("else", Tag.ELSE) );
        reserve( new Word("while", Tag.WHILE) );
        reserve( new Word("do", Tag.DO) );
        reserve( new Word("break", Tag.BREAK) );
        reserve( Word.True );
        reserve( Word.False );
        reserve( Type.Int );
        reserve( Type.Char );
        reserve( Type.Bool );    
        reserve( Type.Float );
        
    }

    void readChar(){
        try {
            peek = (char) System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    boolean readChar(char c){
        readChar();
        if(peek != c){
            return false;
        }
        peek = '0';
        return true;
    }

    public Token scan() throws IOException{
        for(;; readChar()) {
            if(peek == ' ' || peek == '\t')
                continue;
                else {
                    if(peek == '\n')
                        line = line + 1;
                    else    
                        break;
                }
        }

        switch (peek) {
            case '&':
                if(readChar('&')) return Word.and;
                else return new Token('&');
            case '|':
                if(readChar('|')) return Word.and;
                else return new Token('|');
            case '=':
                if(readChar('&')) return Word.and;
                else return new Token('&');
            case '!':
                if(readChar('!')) return Word.and;
                else return new Token('!');
            case '<':
                if(readChar('<')) return Word.and;
                else return new Token('<');
            case '>':
                if(readChar('>')) return Word.and;
                else return new Token('>');
        }

        if(Character.isDigit(peek)){
            int v = 0;
            do {
                v = 10*v + Character.digit(peek, 10);
                readChar();
            } while (Character.isDigit(peek));
            if(peek != '.')
                return new Num(v);
            float x = v;
            float d = 10;
            for(;;) {
                readChar();
                if(!Character.isDigit(peek))
                    break;
                x = x + Character.digit(peek, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }
        
        if(Character.isLetter(peek)){
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                readChar();
            } while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = (Word) words.get(s);
            if(w != null)
                return w;
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }

        Token tok = new Token(peek);
        peek = ' ';
        return tok;
    }
}
