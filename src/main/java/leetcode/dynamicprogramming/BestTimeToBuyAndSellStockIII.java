package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4})); // 6
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int prev = prices[0];
        List<Integer> transaction = new ArrayList<>();

        for (int i = 1; i < prices.length; i++) {


        }

        return 0;
    }
}
