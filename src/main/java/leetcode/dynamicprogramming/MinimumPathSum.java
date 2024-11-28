package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/minimum-path-sum/description/?envType=problem-list-v2&envId=dynamic-programming&favoriteSlug=&difficulty=MEDIUM
 * <p>
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1},
        })); // 7

        System.out.println(new MinimumPathSum().minPathSum(new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 4, 6}
        })); // 12
    }

    public int minPathSum(int[][] grid) {
        // i x j
        int m = grid.length;
        int n = grid[0].length;


        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

/*    int ans = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        dp(grid, 0, 0, 0);
        return ans;
    }

    private void dp(int[][] grid, int sum, int x, int y) {
        if (x == grid.length - 1 && y == grid[0].length) {
            ans = Math.min(sum, ans);
        }
        if (x < 0 || y < 0 || x > grid.length - 1 || y > grid[0].length - 1 || grid[x][y] == -1) return;

        sum += grid[x][y];

        int prev = grid[x][y];
        grid[x][y] = -1;
        dp(grid, sum, x + 1, y);
//        dp(grid, sum, x - 1, y);
        dp(grid, sum, x, y + 1);
//        dp(grid, sum, x, y - 1);
        grid[x][y] = prev;
    }*/
}
