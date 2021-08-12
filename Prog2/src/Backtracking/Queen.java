package Backtracking;

import java.util.ArrayList;

public class Queen {
    
    private boolean finished;
    private int[] a; // total steps
    private int k; // recursion level
    private boolean[][] chessboard;
    
    
    public Queen() {
        a = new int[8];
        chessboard = new boolean[8][8];
        
    }
    
    
    
    
    public void queen (int [] steps, int lev, int[][] board, int i, int j)
    {
        
    }
    private boolean resoulution()
    {
        return k + 1 == a.length;
    }
    private ArrayList<Integer> nextSteps ()
    {
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard.length; j++) {
                
                
            }
            
            
        }
        return null;
    }
    
    
}
