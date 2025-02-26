package leetcode.array;

import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // true

        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })); // false

        System.out.println(new ValidSudoku().isValidSudoku(new char[][]{
                {'.', '2', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '5', '.', '1'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '3'},
                {'4', '.', '9', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '2', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '4', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        })); // false
    }

    public boolean isValidSudoku(char[][] board) { // 100%

        for (int row = 0; row < board.length; row++) {
            int[] rowCheck = new int[10];
            int[] colCheck = new int[10];
            for (int col = 0; col < board[row].length; col++) {
                char charInRow = board[row][col];
                if (charInRow != '.') {
                    int valRow = charInRow - '0';
                    if (rowCheck[valRow] == 1) return false;
                    rowCheck[valRow] = 1;
                }

                char charInCol = board[col][row];
                if (charInCol != '.') {
                    int valCol = charInCol - '0';
                    if (colCheck[valCol] == 1) return false;
                    colCheck[valCol] = 1;
                }
            }
        }
        for (int row = 0; row <= board.length - 2; row = row + 3) {
            for (int col = 0; col < board[row].length - 2; col = col + 3) {
                if (!checkSquare(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkSquare(char[][] board, int startRow, int startCol) {
        int[] squareCheck = new int[10];
        for (int row = startRow; row < startRow + 3; row++) {
            for (int col = startCol; col < startCol + 3; col++) {
                char charInSquare = board[row][col];
                if (charInSquare != '.') {
                    int valSquare = charInSquare - '0';
                    if (squareCheck[valSquare] == 1) return false;
                    squareCheck[valSquare] = 1;
                }
            }
        }
        return true;
    }
}
