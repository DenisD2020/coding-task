package leetcode.twopointers;

/**
 * https://leetcode.com/problems/strictly-palindromic-number/
 * <p>
 * An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive), the string representation of the integer n in base b is palindromic.
 * <p>
 * Given an integer n, return true if n is strictly palindromic and false otherwise.
 * <p>
 * A string is palindromic if it reads the same forward and backward.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 9
 * Output: false
 * Explanation: In base 2: 9 = 1001 (base 2), which is palindromic.
 * In base 3: 9 = 100 (base 3), which is not palindromic.
 * Therefore, 9 is not strictly palindromic so we return false.
 * Note that in bases 4, 5, 6, and 7, n = 9 is also not palindromic.
 * Example 2:
 * <p>
 * Input: n = 4
 * Output: false
 * Explanation: We only consider base 2: 4 = 100 (base 2), which is not palindromic.
 * Therefore, we return false.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 4 <= n <= 105
 */
public class StrictlyPalindromicNumber {
    public static void main(String[] args) {
        //System.out.println(new StrictlyPalindromicNumber().isStrictlyPalindromic(9));
        System.out.println(new StrictlyPalindromicNumber().isStrictlyPalindromic(4));
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String s = Integer.toString(n, i);
            if (!s.equals(new StringBuilder(s).reverse().toString())) {
                return false;
            }
        }
        return true;
    }
}
