package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths2(3, 2)); // 3
        System.out.println(new UniquePaths().uniquePaths2(3, 7)); // 28
    }

    public int uniquePaths2(int m, int n) { // iterative approach
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[m -1][n - 1];
    }

    public int uniquePaths(int m, int n) { // recursion approach
        return helper(m, n, new int[m + 1][n + 1]);
    }

    private int helper(int m, int n, int[][] memo) {
        if (m == 1 && n == 1) {
            memo[m][n] = 1;
            return 1;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        if (m < 1 || n < 1) {
            memo[m][n] = 0;
            return 0;
        }
        memo[m][n] = helper(m - 1, n, memo) + helper(m, n - 1, memo);

        return memo[m][n];
    }

}