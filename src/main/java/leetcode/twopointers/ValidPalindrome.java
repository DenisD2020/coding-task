package leetcode.twopointers;

/**
 * https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(new ValidPalindrome().isPalindrome("race a car")); // false
        System.out.println(new ValidPalindrome().isPalindrome(" ")); // true
        System.out.println(new ValidPalindrome().isPalindrome(".,")); // true
        System.out.println(new ValidPalindrome().isPalindrome("0P")); // false
    }

    public boolean isPalindrome(String s) { // 72.77%
        int l = 0, r = s.length() - 1;
        int lC = 0, rC = 0;

        while (l < r) {
            while (!isAlphabeticOrNumeric(s, l) && l < s.length() - 1) {
                l++;
            }
            while (!isAlphabeticOrNumeric(s, r) && r > 0) {
                r--;
            }

            char leftChar = Character.toLowerCase(s.charAt(l));
            char rightChar = Character.toLowerCase(s.charAt(r));

            if (leftChar == rightChar) {
                l++;
                r--;
                lC++;
                rC++;
            } else {
                return (!isAlphabeticOrNumeric(s, l) || !isAlphabeticOrNumeric(s, r)) &&
                        lC == rC;
            }
        }
        return true;
    }

    private static boolean isAlphabeticOrNumeric(String s, int idx) {
        return Character.isAlphabetic(s.charAt(idx)) || Character.isDigit(s.charAt(idx));
    }
}
