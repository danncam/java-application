package Computador;

import com.sun.jndi.cosnaming.IiopUrl;

public class Memory {
    public final static int MINWORD = -9999;
    public final static int MAXWORD = 9999;
    public final static int MAXMEMORY = 100;
    private int [] words;

    public Memory() {
        words = new int[MAXMEMORY];

        
    }
    public void setWord(int address, int value)
    {
        words[address] = value;
    }
    
    public int getWord(int address)
    {
        return words[address];
    }
    
    
}
