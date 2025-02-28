package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * https://leetcode.com/problems/stone-game/description/
 */
public class StoneGame {

    public static void main(String[] args) {
        System.out.println(new StoneGame().stoneGame5(new int[]{5, 1, 4})); // true
//        System.out.println(new StoneGame().stoneGame5(new int[]{3, 2, 10, 4})); // true
//        System.out.println(new StoneGame().stoneGame5(new int[]{5, 3, 4, 5})); // true
//        System.out.println(new StoneGame().stoneGame5(new int[]{3, 7, 2, 3})); // true
//        System.out.println(new StoneGame().stoneGame3(new int[]{5, 1, 4})); // true
//        System.out.println(new StoneGame().stoneGame5(new int[]{3, 2, 10, 4})); // true
    }

    public boolean stoneGame5(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length - 1][length];
        int ans = solve(piles, dp, 0,   length - 1);
        return ans > 0;
    }

    private int solve(int[] piles, int[][] dp, int left, int right) {
        if (left == right) {
            return piles[left];
        }
        if (dp[left][right] != 0) return dp[left][right];
        int choseLeft = piles[left] - solve(piles, dp, left + 1, right);
        int choseRight = piles[right] - solve(piles, dp, left, right - 1);
        dp[left][right] = Math.max(choseLeft, choseRight);
        return dp[left][right];
    }

    public boolean stoneGame(int[] piles) {
        int ans = dfs(piles, 0, piles.length - 1, true);
        return false;
    }

    public int dfs(int[] piles, int l, int r, boolean turn) {
        if (l > r) {
            return 0;
        }
        int left = 0, right = 0;
        if (turn) {
            left = piles[l];
            right = piles[r];
        }
        int ll = left + dfs(piles, l + 1, r, !turn);
        int rr = right + dfs(piles, l, r - 1, !turn);
        return Math.max(ll, rr);
    }

/*    public int dfs(int[] piles, int l, int r, boolean turn) {
        if (l > r) {
            return 0;
        }
        int left = 0, right = 0;
        if (turn) {
            left = piles[l];
            right = piles[r];
        }
        int ll = left + dfs(piles, l + 1, r, !turn);
        int rr = right + dfs(piles, l, r - 1, !turn);
        return Math.max(ll, rr);
    }*/


    private boolean stoneGame2(int[] piles) {

        int length = piles.length;
        int[][] memo = new int[length][length];
        int aliseScore = Math.max(
                calc(piles, memo, 1, length - 1, piles[0], 0),
                calc(piles, memo, 0, length - 2, piles[piles.length - 1], 0)
        );
        System.out.println(aliseScore);
        return false;
    }

    private int calc(int[] piles, int[][] memo, int left, int right, int sum, int prefixSum) {
        if (left == right) return piles[left];

        if (memo[left][right] != 0) return memo[left][right];

        int bobScore = Math.min(
                calc(piles, memo, left + 1, right, sum + piles[left], 0),
                calc(piles, memo, left, right - 1, sum + piles[right], 0)
        );
        return sum - bobScore;
    }

    public boolean stoneGame3(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                System.out.printf("dp[%s][%s]:%s%n", i, j, dp[i][j]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public boolean stoneGame4(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int length = n; length >= 2; length--) {
            for (int l = 0; l <= n - length; l++) {
                int r = l + length - 1;
                // Текущий игрок выбирает либо левую кучу, либо правую
                dp[l][r] = Math.max(piles[l] - dp[l + 1][r], piles[r] - dp[l][r - 1]);
                System.out.printf("dp[%s][%s]:%s%n", l, r, dp[l][r]);
            }
        }
        return dp[0][n - 1] > 0;
    }


}

