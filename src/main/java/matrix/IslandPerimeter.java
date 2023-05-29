package matrix;

/**
 * https://leetcode.com/problems/island-perimeter/
 * <p>
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 */
public class IslandPerimeter {

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter().islandPerimeter(new int[][]
                {
                        new int[]{0, 1, 0, 0},
                        new int[]{1, 1, 1, 0},
                        new int[]{0, 1, 0, 0},
                        new int[]{1, 1, 0, 0},
                })); // 16

        System.out.println(new IslandPerimeter().islandPerimeter(new int[][]
                {
                        new int[]{1},
                })); // 4

        System.out.println(new IslandPerimeter().islandPerimeter(new int[][]
                {
                        new int[]{1, 0},
                })); // 4
    }

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        res -= 1;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        res -= 1;
                    }
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
                        res -= 1;
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        res -= 1;
                    }
                }
            }
        }
        return res;
    }
}
