package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
public class PartitionArrayForMaximumSum {

    public static void main(String[] args) { // TODO
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)); // [15,15,15,9,10,10,10] 84
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)); // 83
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(new int[]{1}, 1)); // 1
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int length = arr.length;
        int[] dp = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            int curMax = 0;
            int border = Math.min(i + k, length);
            for (int j = i; j < border; j++) {
                curMax = Math.max(curMax, arr[j]);
                dp[i] = Math.max(dp[i], dp[j + 1] + curMax * (j - i + 1));
            }
        }
        return dp[0];
    }



/*    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;

        int[] dp = new int[N + 1];

        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }*/

/*        public int maxSumAfterPartitioning2 ( int[] arr, int k){
            int dp[] = new int[arr.length];
            Arrays.fill(dp, -1);
            return findMax(arr, k, dp, 0);
        }

        private int findMax ( int[] arr, int k, int[] dp, int start){
            if (start >= arr.length) return 0;
            if (dp[start] != -1) return dp[start];
            int currMax = 0;
            int ans = 0;
            int end = Math.min(arr.length, start + k);
            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                ans = Math.max(ans, currMax * (i - start + 1) + findMax(arr, k, dp, i + 1));
            }
            dp[start] = ans;
            return dp[start];
        }*/

}
