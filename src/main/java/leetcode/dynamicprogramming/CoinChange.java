package leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/?envType=problem-list-v2&envId=dynamic-programming
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 11)); // 3
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3)); // -1
        System.out.println(new CoinChange().coinChange(new int[]{1}, 0)); // 0
        System.out.println(new CoinChange().coinChange(new int[]{186, 419, 83, 408}, 6249)); // 20
        System.out.println(new CoinChange().coinChange(new int[]{2, 3, 5}, 11)); // 3

    }

    int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        solve(coins, amount, coins.length - 1, 0);
        return ans;
    }

    private void solve(int[] coins, int amount, int idx, int attempt) {

        if (idx < 0 || amount < 0) return;

        if (amount == 0) {
            ans = Math.min(ans, attempt);
            return;
        }

        if (amount - coins[idx] >= 0) {
            attempt++;
        }

        solve(coins, amount - coins[idx], idx, attempt);
        solve(coins, amount - coins[idx], idx - 1, attempt);
    }


/*    public int coinChange(int[] coins, int amount) {
        int ans = 0;
        Arrays.sort(coins);
        for (int i = coins.length - 1; i >= 0; i--) {
            while (true) {
                if (amount > coins[i]) {
                    ans++;
                    amount -= coins[i];
                } else if (amount == coins[i]) {
                    ans++;
                    amount -= coins[i];
                    break;
                } else {
                    break;
                }
            }
        }
        return amount == 0 ? ans : -1;
    }*/
}
