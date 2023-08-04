package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/split-with-minimum-sum/description/
 * <p>
 * Given a positive integer num, split it into two non-negative integers num1 and num2 such that:
 * <p>
 * The concatenation of num1 and num2 is a permutation of num.
 * In other words, the sum of the number of occurrences of each digit in num1 and num2 is equal to the number of occurrences of that digit in num.
 * num1 and num2 can contain leading zeros.
 * Return the minimum possible sum of num1 and num2.
 */
public class SplitWithMinimumSum {
    public static void main(String[] args) {
        System.out.println(new SplitWithMinimumSum().splitNum(4325)); // 59
        System.out.println(new SplitWithMinimumSum().splitNum(687)); // 75
    }

    public int splitNum(int num) {
        char n[] = String.valueOf(num).toCharArray();
        Arrays.sort(n);
        StringBuilder n1 = new StringBuilder(n.length / 2), n2 = new StringBuilder(n.length / 2);

        for (int i = 0; i < n.length; i++) {
            if (i % 2 == 0) {
                n1.append(n[i]);
            } else {
                n2.append(n[i]);
            }
        }
        return Integer.parseInt(n1.toString()) + Integer.parseInt(n2.toString());
    }
}
