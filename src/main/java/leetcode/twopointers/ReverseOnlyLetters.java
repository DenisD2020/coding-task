package leetcode.twopointers;

/**
 * https://leetcode.com/problems/reverse-only-letters/description/
 * <p>
 * Given a string s, reverse the string according to the following rules:
 * <p>
 * All the characters that are not English letters remain in the same position.
 * All the English letters (lowercase or uppercase) should be reversed.
 * Return s after reversing it.
 * <p>
 * <p>
 * s consists of characters with ASCII values in the range [33, 122].
 */
public class ReverseOnlyLetters {

    public static void main(String[] args) {
//        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("ab-cd")); // dc-ba
//        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj")); // j-Ih-gfE-dCba
//        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("Test1ng-Leet=code-Q!")); // Qedo1ct-eeLg=ntse-T!
        System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("a-bC-dEf-ghIj")); // j-Ih-gfE-dCba
    }

    public String reverseOnlyLetters(String s) {
        StringBuilder ans = new StringBuilder(s);

        int l = 0, r = s.length() - 1;

        while (l <= r) {
            int charL = s.charAt(l);
            int charR = s.charAt(r);
            if (!Character.isAlphabetic(charL)) {
                l++;
            } else if (!Character.isAlphabetic(charR)) {
                r--;
            } else {
                ans.setCharAt(l, s.charAt(r));
                ans.setCharAt(r, s.charAt(l));
                r--;
                l++;
            }
        }
        return ans.toString();
    }
}
