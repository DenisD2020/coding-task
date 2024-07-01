package leetcode.breadthfirstsearch;

import java.util.Stack;

/**
 * https://leetcode.com/problems/max-area-of-island/description/
 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                new int[]{0, 1},
                new int[]{1, 1},
        })); // 3
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        })); // 6
    }

    public int maxAreaOfIsland(int[][] grid) { // recursion
        int ans = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                ans = Math.max(area(row, column, grid, visited), ans);
            }
        }
        return ans;
    }

    private int area(int row, int column, int[][] grid, int[][] visited) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[row].length ||
                visited[row][column] == 1 || grid[row][column] == 0) {
            return 0;
        }
        visited[row][column] = 1;
        return 1
                + area(row - 1, column, grid, visited)
                + area(row + 1, column, grid, visited)
                + area(row, column + 1, grid, visited)
                + area(row, column - 1, grid, visited);
    }


    // dfs
    public int maxAreaOfIsland2(int[][] grid) { // dfs
        int ans = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (visited[row][column] == 1) continue;
                int elem = grid[row][column];
                if (elem == 1) {
                    // visit
                    ans = Math.max(visit(grid, visited, row, column), ans);
                }
            }
        }
        return ans;
    }

    private int visit(int[][] grid, int[][] visited, int row, int column) {
        int area = 0;
        Stack<Pair> islands = new Stack<>();
        islands.add(new Pair(row, column));
        while (!islands.isEmpty()) {
            Pair island = islands.pop();
            if (visited[island.row][island.column] == 1) continue;
            visited[island.row][island.column] = 1;
            area++;
            if (island.row - 1 >= 0 && grid[island.row - 1][island.column] == 1) {
                islands.push(new Pair(island.row - 1, island.column));
            }
            if (island.row + 1 < grid.length && grid[island.row + 1][island.column] == 1) {
                islands.push(new Pair(island.row + 1, island.column));
            }
            if (island.column - 1 >= 0 && grid[island.row][island.column - 1] == 1) {
                islands.push(new Pair(island.row, island.column - 1));
            }
            if (island.column + 1 < grid[row].length && grid[island.row][island.column + 1] == 1) {
                islands.push(new Pair(island.row, island.column + 1));
            }
        }
        return area;
    }

    static class Pair {
        int row;
        int column;

        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
