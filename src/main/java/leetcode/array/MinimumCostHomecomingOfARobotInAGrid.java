package leetcode.array;

/**
 * https://leetcode.com/problems/minimum-cost-homecoming-of-a-robot-in-a-grid/description/
 */
public class MinimumCostHomecomingOfARobotInAGrid {

    public static void main(String[] args) {
        System.out.println(new MinimumCostHomecomingOfARobotInAGrid().minCost(
                new int[]{5, 5},
                new int[]{5, 2},
                new int[]{7, 1, 3, 3, 5, 3, 22, 10, 23},
                new int[]{5, 5, 6, 2, 0, 16}
        )); // 8

        System.out.println(new MinimumCostHomecomingOfARobotInAGrid().minCost(
                new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}
        )); // 18
        System.out.println(new MinimumCostHomecomingOfARobotInAGrid().minCost(
                new int[]{1, 2}, new int[]{3, 3}, new int[]{10, 1, 2, 3}, new int[]{10, 7, 8, 9}
        )); // 14

        System.out.println(new MinimumCostHomecomingOfARobotInAGrid().minCost(
                new int[]{0, 0}, new int[]{0, 0}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}
        )); // 0
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int rowCost = 0;
        int colCost = 0;

        if (startPos[0] < homePos[0]) {
            for (int row = startPos[0]; row < homePos[0]; row++) {
                rowCost += rowCosts[row + 1];
            }
        } else {
            for (int row = startPos[0]; row > homePos[0]; row--) {
                rowCost += rowCosts[row - 1];
            }
        }

        if (startPos[1] < homePos[1]) {
            for (int coll = startPos[1]; coll < homePos[1]; coll++) {
                colCost += colCosts[coll + 1];
            }
        } else {
            for (int coll = startPos[1]; coll > homePos[1]; coll--) {
                colCost += colCosts[coll - 1];
            }
        }
        return rowCost + colCost;
    }
}
