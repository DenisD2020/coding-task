package leetcode.matrix;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/delete-greatest-value-in-each-row/
 * <p>
 * You are given an m x n matrix grid consisting of positive integers.
 * <p>
 * Perform the following operation until grid becomes empty:
 * <p>
 * Delete the element with the greatest value from each row. If multiple such elements exist, delete any of them.
 * Add the maximum of deleted elements to the answer.
 * Note that the number of columns decreases by one after each operation.
 * <p>
 * Return the answer after performing the operations described above.
 */
public class DeleteGreatestValueEachRow {

    public static void main(String[] args) {
        System.out.println(new DeleteGreatestValueEachRow().deleteGreatestValue(new int[][]
                {
                        new int[]{1, 2, 4}, //1 2 4
                        new int[]{3, 3, 1}, //1 3 3
                })); // 8

        System.out.println(new DeleteGreatestValueEachRow().deleteGreatestValue(new int[][]
                {
                        new int[]{10}
                })); // 10
    }

    public int deleteGreatestValue(int[][] grid) {
        int length = grid[0].length;
        int res = 0;
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }

        for (int i = length - 1; i >= 0; i--) {
            for (int j = grid.length - 1; j >= 0; j--) {
                max = Math.max(grid[j][i], max);
            }
            res += max;
            max = 0;
        }
        return res;
    }
}
