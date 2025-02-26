package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MaximumNumberOfPointsWithCost {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfPointsWithCost().maxPoints(new int[][]{
                new int[]{1, 2, 3},
                new int[]{1, 5, 1},
                new int[]{3, 1, 1}
        })); // 9

        System.out.println(new MaximumNumberOfPointsWithCost().maxPoints(new int[][]{
                new int[]{1, 5},
                new int[]{2, 3},
                new int[]{4, 2}
        })); // 11
    }

    public long maxPoints(int[][] points) { // 72%

        int cols = points[0].length;
        long[] prevRow = new long[cols];

        for (int i = 0; i < cols; i++) {
            prevRow[i] = points[0][i];
        }

        for (int m = 1; m < points.length; m++) {
            long[] leftMax = new long[cols];
            long[] rightMax = new long[cols];
            long[] currentRow = new long[cols];

            leftMax[0] = prevRow[0];
            for (int n = 1; n < cols; n++) {
                leftMax[n] = Math.max(leftMax[n - 1] - 1, prevRow[n]);
            }

            rightMax[cols - 1] = prevRow[cols - 1];
            for (int n = cols - 2; n >= 0; n--) {
                rightMax[n] = Math.max(rightMax[n + 1] - 1, prevRow[n]);
            }

            for (int n = 0; n < cols; n++) {
                currentRow[n] = points[m][n] + Math.max(leftMax[n], rightMax[n]);
            }
            prevRow = currentRow;
        }

        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, prevRow[col]);
        }

        return maxPoints;
    }

   /* public long maxPoints(int[][] points) { // 5%

        long[][] dp = new long[points.length][points[0].length];

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = points[0][i];
        }

        long ans = 0;
        for (int m = 1; m < points.length; m++) {
            for (int n = 0; n < points[m].length; n++) {
                long max = 0;
                for (int elem = 0; elem < points[m].length; elem++) {
                    long curScore = points[m][n] - Math.abs(n - elem) + dp[m - 1][elem];
                    max = Math.max(max, curScore);
                }
                dp[m][n] = max;
                if (m == dp.length - 1) {
                    ans = Math.max(ans, max);
                }
            }
        }
        if (ans == 0) {
            for (int i = 0; i < dp[dp.length - 1].length; i++) {
                ans = Math.max(ans, dp[dp.length - 1][i]);
            }
        }
        return ans;
    }*/
}
