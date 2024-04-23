package dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
public class PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)); // [15,15,15,9,10,10,10] 84
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)); // 83
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1}, 1)); // 1
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);

        for (int i = 0; i < arr.length; i++) {
            dp[i] = findMax(arr,k, dp, 0);
        }
        return -1;
    }

    private int findMax(int[] arr, int k, int[] dp, int start) {
        if (start >= arr.length) return 0;
        if (dp[start] != -1) return dp[start];

        /**
         * Iterate over the elements from start to start+k, or the end of the array if there are fewer than k elements left, for each index i:
         *
         * Store the maximum we have seen so far in the variable currMax.
         * Find the sum with the current index as the ending point of the subarray; this will be equal to currMax * (i - start + 1) + maxSum(arr, k, dp, I + 1). The term i - start + 1 is the length of the subarray from index start to i inclusive.
         * Since we need the maximum sum of all our options, we take the max of all the possible sums and store them as ans.
         * After iterating over all possible subarrays, return ans and also store it in the variable dp[start].
         *
         */

        return 0;
    }

}
