package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
 */
public class BestTimeToBuyAndSellStockWithTransactionFee { // TODO

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2)); // 8
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3)); // 6
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(new int[]{4, 5, 2, 4, 3, 3, 1, 2, 5, 4}, 1)); // 4
    }

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[] bought = new int[len];
        int[] sold = new int[len];

        bought[0] = -prices[0];
        sold[0] = 0;

        for (int i = 1; i < len; i++) {
            bought[i] = Math.max(bought[i - 1], sold[i - 1] - prices[i]);
            sold[i] = Math.max(sold[i - 1], bought[i - 1] - fee + prices[i]);
        }
        return sold[len - 1];
    }

/*
    public int maxProfit(int[] prices, int fee) {
        return buy(prices, fee, 0);
    }

    private int buy(int[] prices, int fee, int day) {
        if (day == prices.length) return 0;

        int buyingNowSellNextDay = sell(prices, fee, day + 1) - fee - prices[day];
        int buyNextDay = buy(prices, fee, day + 1);
        return Math.max(buyingNowSellNextDay, buyNextDay);
    }

    private int sell(int[] prices, int fee, int day) {
        if (day == prices.length) return 0;

        int selling = buy(prices, fee, day + 1) + prices[day];
        int sellNextDay = sell(prices, fee, day + 1);
        return Math.max(selling, sellNextDay);
*/

}
