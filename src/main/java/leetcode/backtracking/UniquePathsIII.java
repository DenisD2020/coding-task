package leetcode.backtracking;


/**
 * https://leetcode.com/problems/unique-paths-iii/description/
 */
public class UniquePathsIII {

    public static void main(String[] args) {
        System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 2, -1}
        })); // 2
        System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 2}
        })); // 4
        System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{
                new int[]{0, 1},
                new int[]{2, 0}
        })); // 0
    }

    int ans = 0;

    public int uniquePathsIII(int[][] grid) { // 43%
        Pair start = null;
        Pair end = null;
        int obstacles = 0;

        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[m].length; n++) {
                if (grid[m][n] == 1) {
                    start = new Pair(m, n);
                } else if (grid[m][n] == 2) {
                    end = new Pair(m, n);
                } else if (grid[m][n] == -1) {
                    obstacles++;
                }
            }
        }

        int pathLength = grid.length * grid[0].length - obstacles - 1;
        backTrack(grid, 0, start.row, start.col, end, pathLength);
        return ans;
    }

    private void backTrack(int[][] grid, int curPath, int curRow, int curColl, Pair end, int pathLength) {

        if (curRow < 0 || curRow > grid.length - 1 ||
                curColl > grid[0].length - 1 || curColl < 0 ||
                grid[curRow][curColl] == 3 || grid[curRow][curColl] == -1) {
            return;
        }

        if (curPath == pathLength && end.col == curColl && end.row == curRow) {
            ans++;
            return;
        }

        grid[curRow][curColl] = 3; // mark as visited
        ++curPath;
        backTrack(grid, curPath, curRow + 1, curColl, end, pathLength);
        backTrack(grid, curPath, curRow - 1, curColl, end, pathLength);
        backTrack(grid, curPath, curRow, curColl + 1, end, pathLength);
        backTrack(grid, curPath, curRow, curColl - 1, end, pathLength);
        grid[curRow][curColl] = 0;
    }

    record Pair(Integer row, Integer col) {
    }
}
