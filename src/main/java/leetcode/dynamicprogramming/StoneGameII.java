package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/stone-game-ii/editorial/
 */
public class StoneGameII {

    public static void main(String[] args) {
//        System.out.println(new StoneGameII().stoneGameII_6(new int[]{2, 7, 9, 4, 4})); // 2 + 4 + 4 = 10
//        System.out.println(new StoneGameII().stoneGameII_6(new int[]{1, 2, 3, 4, 5, 100})); // 104
//        System.out.println(new StoneGameII().stoneGameII_6(new int[]{2, 7, 9, 4, 4})); // 2 + 4 + 4 = 10
//        System.out.println(new StoneGameII().stoneGameII_6(new int[]{2, 7, 9, 4, 4})); // 2 + 4 + 4 = 10
        System.out.println(new StoneGameII().stoneGameII_5(new int[]{2, 7, 9, 4, 4})); // 2 + 4 + 4 = 10
    }

    // 2 solution
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n][n + 1]; //  dp[i][M] - represents the maximum stones Alice can collect starting from the i-th pile with the current value of M.
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        for (int i = n - 1; i >= 0; i--) { // i - number piles
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) { //  if Alice can take all the remaining piles
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) { //  all possible moves
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }
        return dp[0][1];
    }

    public int stoneGameII_2(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length + 1][length + 1];
        int[] sufsum = new int[length + 1];

        for (int i = length - 1; i >= 0; i--) {
            sufsum[i] = sufsum[i + 1] + piles[i];
        }

        int res = helper(dp, sufsum, 0, 1);
        return res;
    }

    private int helper(int[][] dp, int[] sufsum, int i, int M) {
        if (i == sufsum.length) return 0;
        if (2 * M >= sufsum.length - i) return sufsum[i];
        if (dp[i][M] != 0) return dp[i][M];

        int res = Integer.MAX_VALUE;
        for (int X = 1; X <= 2 * M; X++) {
            res = Math.min(res, helper(dp, sufsum, i + X, Math.max(X, M)));
        }

        dp[i][M] = sufsum[i] - res;
        return dp[i][M];
    }

    // 3 solution
    public int stoneGameII_3(int[] piles) {
        int totalPiles = piles.length;
        int[] suffixSums = new int[totalPiles + 1];
        for (int i = totalPiles - 1; i >= 0; i--) {
            suffixSums[i] = suffixSums[i + 1] + piles[i];
        }
        return maxStonesAliceCanGet(suffixSums, 1, 0, new int[totalPiles][totalPiles + 1]);
    }

    private int maxStonesAliceCanGet(int[] suffixSums, int m, int currentPile, int[][] memo) {
        int totalPiles = suffixSums.length - 1;

        if (currentPile >= totalPiles) return 0;

        if (currentPile + 2 * m >= totalPiles) {
            return suffixSums[currentPile];
        }

        if (memo[currentPile][m] != 0) return memo[currentPile][m];

        int maxStones = 0;

        for (int x = 1; x <= 2 * m; x++) {
            int currentStones = suffixSums[currentPile] - maxStonesAliceCanGet(suffixSums, Math.max(m, x), currentPile + x, memo);
            maxStones = Math.max(maxStones, currentStones);
        }

        System.out.println("pile:" + currentPile + ", M:" + m + ",result:" + maxStones);

        memo[currentPile][m] = maxStones;
        return maxStones;
    }


    public int stoneGameII_4(int[] piles) {
        int totalPiles = piles.length;
        int[] suffixSums = new int[totalPiles + 1];
        for (int i = totalPiles - 1; i >= 0; i--) {
            suffixSums[i] = suffixSums[i + 1] + piles[i];
        }
        int[][] memo = new int[totalPiles][totalPiles];
        int res = calc(suffixSums, 0, 1, memo);
        return res;
    }

    private int calc(int[] suffixSums, int currentPile, int M, int[][] memo) {
        int totalPiles = suffixSums.length - 1;
        if (currentPile > totalPiles) return 0;

        if (currentPile + M * 2 >= totalPiles) return suffixSums[currentPile];

        if (memo[currentPile][M] != 0) return memo[currentPile][M];

        int max = 0;

        for (int X = 1; X <= M * 2; X++) {
            int stoneTakenByBob = calc(suffixSums, currentPile + X, Math.max(X, M), memo);
            int idx = currentPile + X;
//            System.out.println("Bob take from index:" + idx + ", M:" + Math.max(X, M) + ", stoneTakenByBob:" + stoneTakenByBob);
            int stoneTakenByAlice = suffixSums[currentPile] - stoneTakenByBob;
            max = Math.max(stoneTakenByAlice, max);
        }
        // 2, 7, 9, 4, 4,


        memo[currentPile][M] = max;

        return memo[currentPile][M];
    }


    public int stoneGameII_5(int[] piles) {

        int length = piles.length;
        int[] suffixSum = new int[length + 1];

        for (int i = length - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        int[][] memo = new int[length][length];
        return calc5(suffixSum, 0, 1, memo);
    }

    private int calc5(int[] suffixSum, int pileIndex, int M, int[][] memo) {
        if (pileIndex >= suffixSum.length) return 0;

        if (pileIndex + M * 2 >= suffixSum.length) return suffixSum[pileIndex];

        if (memo[pileIndex][M] != 0) return memo[pileIndex][M];

        int max = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int stoneCollectedByBob = calc5(suffixSum, pileIndex + X, Math.max(M, X), memo);
            int stoneCollectedByAlice = suffixSum[pileIndex] - stoneCollectedByBob;
            max = Math.max(stoneCollectedByAlice, max);
        }
        memo[pileIndex][M] = max;
        return memo[pileIndex][M];
    }
}

