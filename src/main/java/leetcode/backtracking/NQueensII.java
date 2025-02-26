package leetcode.backtracking;

/**
 * https://leetcode.com/problems/n-queens-ii/?envType=problem-list-v2&envId=backtracking
 */
public class NQueensII {

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(1)); // 1
        System.out.println(new NQueensII().totalNQueens(4)); // 2
        System.out.println(new NQueensII().totalNQueens(5)); // 10
    }

    int ans = 0;

    public int totalNQueens(int n) { // 62%
        int[][] field = new int[n][n];
        backTrack(field, 0);
        return ans;
    }

    private void backTrack(int[][] field, int rowIdx) {
        if (rowIdx >= field.length) {
            ans++;
            return;
        }

        int[] row = field[rowIdx];
        for (int i = 0; i < row.length; i++) {
            if (isAvailable(field, rowIdx, i)) {
                row[i] = 9; // put here
                backTrack(field, rowIdx + 1);
                row[i] = 0;
            }
        }
    }

    private boolean isAvailable(int[][] field, int rowIdx, int colIdx) {

        for (int row = 0; row < field.length; row++) {
            if (field[row][colIdx] == 9) {
                return false;
            }
        }

        // left diagonal
        for (int r = rowIdx, c = colIdx; r >= 0 && c >= 0; r--, c--) {
            if (field[r][c] == 9) {
                return false;
            }
        }

        // right diagonal
        for (int r = rowIdx, c = colIdx; r >= 0 && c < field[r].length; r--, c++) {
            if (field[r][c] == 9) {
                return false;
            }
        }
        return true;
    }
}
















