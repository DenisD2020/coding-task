package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{1, 2, 3, 4, 5})); // 4
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[]{7, 6, 4, 3, 1})); // 0
    }

    public int maxProfit(int[] prices) {
        int ans = 0;
        int prev = prices[0];

        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prev, 0);
            prev = prices[i];
        }
        return ans;
    }
}
