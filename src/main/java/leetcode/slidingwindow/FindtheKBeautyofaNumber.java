package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/find-the-k-beauty-of-a-number/
 * <p>
 * The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:
 * <p>
 * It has a length of k.
 * It is a divisor of num.
 * Given integers num and k, return the k-beauty of num.
 * <p>
 * Note:
 * <p>
 * Leading zeros are allowed.
 * 0 is not a divisor of any value.
 * A substring is a contiguous sequence of characters in a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 240, k = 2
 * Output: 2
 * Explanation: The following are the substrings of num of length k:
 * - "24" from "240": 24 is a divisor of 240.
 * - "40" from "240": 40 is a divisor of 240.
 * Therefore, the k-beauty is 2.
 * Example 2:
 * <p>
 * Input: num = 430043, k = 2
 * Output: 2
 * Explanation: The following are the substrings of num of length k:
 * - "43" from "430043": 43 is a divisor of 430043.
 * - "30" from "430043": 30 is not a divisor of 430043.
 * - "00" from "430043": 0 is not a divisor of 430043.
 * - "04" from "430043": 4 is not a divisor of 430043.
 * - "43" from "430043": 43 is a divisor of 430043.
 * Therefore, the k-beauty is 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 109
 * 1 <= k <= num.length (taking num as a string)
 */
public class FindtheKBeautyofaNumber {
    public static void main(String[] args) {
        System.out.println("result:" + new FindtheKBeautyofaNumber().divisorSubstrings(240, 2));
        System.out.println("result:" + new FindtheKBeautyofaNumber().divisorSubstrings(430043, 2));
    }

    public int divisorSubstrings(int num, int k) {
        int result = 0;
        String numStr = String.valueOf(num);
        String substringNum = "";

        for (int j = 0; j < numStr.length(); j++) {
            substringNum = numStr.substring(j);
            String numberWindow = "";
            for (int i = 0; i < substringNum.length(); i++) {
                numberWindow += substringNum.charAt(i);
                if (numberWindow.length() == k && isDivider(num, numberWindow)) {
                    result++;
                }
            }
        }
        return result;
    }
    private boolean isDivider(int num, String numberWindow) {
        int parseInt = Integer.parseInt(numberWindow);
        return parseInt != 0 && num % parseInt == 0;
    }
}
