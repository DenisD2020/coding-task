package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/buy-two-chocolates/
 */
public class BuyTwoChocolates {

    public static void main(String[] args) {
        //System.out.println(new BuyTwoChocolates().buyChoco(new int[]{1, 2, 2}, 3));
        System.out.println(new BuyTwoChocolates().buyChoco(new int[]{69, 91, 78, 19, 40, 13}, 94));
    }


    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return (prices[0] + prices[1]) > money ? money : money - (prices[0] + prices[1]);
    }
}
