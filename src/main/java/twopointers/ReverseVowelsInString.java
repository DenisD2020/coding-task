package twopointers;

import java.util.Set;

/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * <p>
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: "leotcede"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 */
public class ReverseVowelsInString {

    public static void main(String[] args) {
        //System.out.println(new ReverseVowelsInString().reverseVowels("hello"));
        //System.out.println(new ReverseVowelsInString().reverseVowels("leetcode"));
        //System.out.println(new ReverseVowelsInString().reverseVowels("Marge, let's \"went.\" I await news telegram."));
        //System.out.println(new ReverseVowelsInString().reverseVowels("ai"));
        System.out.println(new ReverseVowelsInString().reverseVowels("a."));
    }

    private final Set<Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U');

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        char tmp;
        int right = chars.length;

        for (int left = 0; left < right; left++) {
            if (vowels.contains(chars[left])) {
                tmp = chars[left];
                right = findFromRight(chars, right - 1);
                chars[left] = chars[right];
                chars[right] = tmp;
            }
        }
        return String.valueOf(chars);
    }

    private int findFromRight(char[] chars, int right) {
        while (right >= 0) {
            if (vowels.contains(chars[right])) {
                return right;
            }
            right--;
        }
        return right;
    }
}
