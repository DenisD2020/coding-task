package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/make-three-strings-equal/
 */
public class MakeThreeStringsEqual {

    public static void main(String[] args) {
        System.out.println(new MakeThreeStringsEqual().findMinimumOperations("abc", "abb", "ab")); // 2
        System.out.println(new MakeThreeStringsEqual().findMinimumOperations("dac", "bac", "cac")); // -1
        System.out.println(new MakeThreeStringsEqual().findMinimumOperations("xx", "phe", "xie")); // -1
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int ans = -1;
        int s1L = s1.length();
        int s2L = s2.length();
        int s3L = s3.length();

        int minLength = Math.min(s1L, Math.min(s2L, s3L));

        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i) || s2.charAt(i) != s3.charAt(i)) {
                ans = s1L - i + s2L - i + s3L - i;
                break;
            }
        }
        if (ans == -1) ans = s1L - minLength + s2L - minLength + s3L - minLength;
        if (ans == s1L + s2L + s3L) ans = -1;
        return ans;
    }
}

