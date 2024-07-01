package leetcode.backtracking;

/**
 * https://leetcode.com/problems/path-with-maximum-gold/description/
 */
public class PathWithMaximumGold {

    public static void main(String[] args) {
        System.out.println(new PathWithMaximumGold().getMaximumGold(new int[][]{
                new int[]{0, 6, 0},
                new int[]{5, 8, 7},
                new int[]{0, 9, 0},
        })); // 24
    }

    int max = 0;

    public int getMaximumGold(int[][] grid) {
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (grid[m][n] != 0) {
                    dfs(grid, m, n, 0);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int m, int n, int sum) {
        if (grid[m][n] == 0) {
            max = Math.max(sum, max);
            return;
        }
        int val = grid[m][n];
        sum += val;
        grid[m][n] = 0;
        if (m + 1 < grid.length) {
            dfs(grid, m + 1, n, sum);
        }
        if (m - 1 >= 0) {
            dfs(grid, m - 1, n, sum);
        }
        if (n + 1 < grid[0].length) {
            dfs(grid, m, n + 1, sum);
        }
        if (n - 1 >= 0) {
            dfs(grid, m, n - 1, sum);
        }
        grid[m][n] = val;
    }
}
