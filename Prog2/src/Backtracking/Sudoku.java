package Backtracking;

public class Sudoku {

    private boolean[][] rows = new boolean[9][9];
    private boolean[][] columns = new boolean[9][9];
    private boolean[][] squares = new boolean[9][9];
    private byte[][] board = new byte[9][9];

    private boolean possivelLocacao(byte i, byte j, byte val) {

        // posição invalida?
        if (rows[i][val] || columns[j][val] || squares[3 * (i / 3) + j / 3][val]) {
            return false;
        }

        // posição ij ocupada:        
        rows[i][val] = true;
        columns[j][val] = true;
        squares[3 * (i / 3) + j / 3][val] = true;

        board[i][j] = (byte) (val + 1);

        return true;
    }

    private void tiraDigito(byte i, byte j) {

        // ajustar 0 ... 8
        byte val = (byte) (board[i][j] - 1);

        board[i][j] = 0;

        // locação ij livre:        
        squares[3 * (i / 3) + j / 3][val] = false;
        columns[j][val] = false;
        rows[i][val] = false;
    }

    public boolean setVal(byte i, byte j, byte val) {
        return possivelLocacao(i, j, (byte) (val - 1));
    }

    public byte getVal(byte i, byte j) {
        return board[i][j];
    }

    public boolean testSolution() {
        return testSolution((byte) 0, (byte) 0);
    }

    private boolean testSolution(byte i, byte j) {
        for (;;) {
            if (j >= columns.length) {
                j = 0;
                i++;
            }

            if (i >= rows.length) {
                return true;
            }

            if (board[i][j] > 0) {
                j++;
            } else {
                break;
            }

        }
        for (byte val = 0; val < squares.length; val++) {
            if (possivelLocacao(i, j, val)) {
                if (!testSolution(i, (byte) (j + 1))) {
                    tiraDigito(i, j);
                } else {
                    return true;
                }
            }
        }

        return false;

    }
}
