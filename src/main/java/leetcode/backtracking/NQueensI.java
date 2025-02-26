package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode.com/problems/n-queens/description/
 */
public class NQueensI {

    public static void main(String[] args) {
        System.out.println(new NQueensI().solveNQueens(1)); // 1  "Q"
        System.out.println(new NQueensI().solveNQueens(4)); //
        System.out.println(new NQueensI().solveNQueens(5)); //
    }

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) { // 89%
        char[][] field = new char[n][n];
        for (char[] row : field) {
            Arrays.fill(row, '.');
        }

        backTrack(field, 0);
        return ans;
    }

    private void backTrack(char[][] field, int rowIdx) { // 15%
        if (rowIdx >= field.length) {
            ArrayList<String> tmp = new ArrayList<>();
            for (char[] s : field) {
                tmp.add(new String(s));
            }
            ans.add(tmp);
            return;
        }

        char [] row = field[rowIdx];
        for (int i = 0; i < row.length; i++) {
            if (isAvailable(field, rowIdx, i)) {
                row[i] = 'Q'; // put here
                backTrack(field, rowIdx + 1);
                row[i] = '.';
            }
        }
    }

    private boolean isAvailable(char [][] field, int rowIdx, int colIdx) {

        for (int row = 0; row < field.length; row++) {
            if (field[row][colIdx] == 'Q') {
                return false;
            }
        }

        // left diagonal
        for (int r = rowIdx, c = colIdx; r >= 0 && c >= 0; r--, c--) {
            if (field[r][c] == 'Q') {
                return false;
            }
        }

        // right diagonal
        for (int r = rowIdx, c = colIdx; r >= 0 && c < field[r].length; r--, c++) {
            if (field[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
















