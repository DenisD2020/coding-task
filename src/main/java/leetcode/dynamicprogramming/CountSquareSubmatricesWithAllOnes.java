package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {

        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(new int[][]{
                new int[]{1, 1},
                new int[]{1, 0}
        })); // 3


        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(new int[][]{
                new int[]{0, 1, 1, 1},
                new int[]{1, 1, 1, 1},
                new int[]{0, 1, 1, 1}
        })); // 15

        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(new int[][]{
                new int[]{1, 0, 1},
                new int[]{1, 1, 0},
                new int[]{1, 1, 0}
        })); // 7


        System.out.println(new CountSquareSubmatricesWithAllOnes().countSquares(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 1, 0},
                new int[]{1, 1, 1},
                new int[]{1, 1, 0}
        })); // 8
    }

    int[][] dp;

    public int countSquares(int[][] matrix) { // 81%
        dp = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 1) {
                    dp[row][col] = 1;
                    if (row >= 1 && col >= 1) {
                        if (matrix[row - 1][col - 1] >= 1
                                && matrix[row][col - 1] >= 1
                                && matrix[row - 1][col] >= 1) {
                            dp[row][col] = Math.min(
                                    Math.min(dp[row - 1][col - 1], dp[row - 1][col]), dp[row][col - 1]) + 1;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[row].length; col++) {
                ans += dp[row][col];
            }
        }
        return ans;
    }

/*    public int countSquares(int[][] matrix) { // 22%
        int l = matrix.length;
        dp = new int[l][l];
        int ans = 0;

        for (int row = 0; row < l; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) continue;
                int calc = calc(matrix, row, col);
//                System.out.println(row + "-" + col + ":" + calc);
                ans += calc;
            }
        }
        return ans;
    }

    private int calc(int[][] matrix, int r, int c) {
        int ans = 0;
        int startR = r;
        int startC = c;
        int endR = r;
        int endC = c;


        while (endR < matrix.length && endC < matrix[0].length) {
            boolean isSquare = true;
            for (int row = r; row <= endR; row++) {
                if (matrix[row][startC] != 1) {
                    isSquare = false;
                    break;
                }

            }
            for (int col = c; col <= endC; col++) {
                if (matrix[startR][col] != 1) {
                    isSquare = false;
                    break;
                }
            }
            if (!isSquare) break;

            ans++;
            endR++;
            endC++;
            startR++;
            startC++;
        }
        return ans;
    }*/
}
