package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/unique-paths-ii/description/
 */
public class UniquePathsII { // TODO

    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0},
                new int[]{1, 1},
                new int[]{0, 0}
        })); // 0
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                new int[]{1, 0}
        })); // 0
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0}
        })); // 1
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{0, 0, 0},
        })); // 2
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                new int[]{0, 1},
                new int[]{0, 0},
        })); // 1
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    map[i][j] = 0;
                } else if (i == 0 || j == 0) {
                    if (i == 0 && j > 0 && map[i][j - 1] == 0) { // there is a block, path is closed
                        continue;
                    } else if (j == 0 && i > 0 && map[i - 1][j] == 0) { // there is a block, path is closed
                        continue;
                    }
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }
        }
        return map[m - 1][n - 1];
    }
}