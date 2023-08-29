package array;

/**
 * https://leetcode.com/problems/richest-customer-wealth/description/
 * <p>
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.
 * <p>
 * A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.
 */
public class RichestCustomerWealth {

    public static void main(String[] args) {
        System.out.println(new RichestCustomerWealth().maximumWealth(
                new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{3, 2, 1},
                }
        ));//6

        System.out.println(new RichestCustomerWealth().maximumWealth(
                new int[][]{
                        new int[]{1, 5},
                        new int[]{7, 3},
                        new int[]{3, 5},
                }
        ));//10
    }

    public int maximumWealth(int[][] accounts) {
        int res = 0;

        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                wealth+= accounts[i][j];
            }
            res = Math.max(res,wealth);
        }
        return res;
    }
}
