package matrix;

/**
 * https://leetcode.com/problems/largest-local-values-in-a-matrix/
 * <p>
 * You are given an n x n integer matrix grid.
 * <p>
 * Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
 * <p>
 * maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
 * In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
 * <p>
 * Return the generated matrix.
 */
public class LargestLocalValuesMatrix {


    public static void main(String[] args) {
/*        System.out.println(new LargestLocalValuesMatrix().largestLocal(new int[][]
                {
                        new int[]{9, 9, 8, 1},
                        new int[]{5, 6, 2, 6},
                        new int[]{8, 2, 6, 4},
                        new int[]{6, 2, 2, 2}
                }));*/

        System.out.println(new LargestLocalValuesMatrix().largestLocal(new int[][]
                {
                        new int[]{1, 1, 1, 1, 1},
                        new int[]{1, 1, 1, 1, 1},
                        new int[]{1, 1, 2, 1, 1},
                        new int[]{1, 1, 1, 1, 1},
                        new int[]{1, 1, 1, 1, 1}
                }));
    }


    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = findMax(grid, i, j);
            }
        }
        return res;
    }

    private int findMax(int[][] grid, int i, int j) {
        int max = 0;
        for (int ii = i; ii <= i + 2; ii++) {
            for (int jj = j; jj <= j + 2; jj++) {
                max = Math.max(max, grid[ii][jj]);
            }
        }
        return max;
    }
}
