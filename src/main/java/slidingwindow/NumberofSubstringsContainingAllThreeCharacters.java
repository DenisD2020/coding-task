package slidingwindow;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
 * <p>
 * Given a string s consisting only of characters a, b and c.
 * <p>
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabc"
 * Output: 10
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
 * Example 2:
 * <p>
 * Input: s = "aaacb"
 * Output: 3
 * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
 * Example 3:
 * <p>
 * Input: s = "abc"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= s.length <= 5 x 10^4
 * s only consists of a, b or c characters.
 */
public class NumberofSubstringsContainingAllThreeCharacters {

    public static void main(String[] args) {
        System.out.println(new NumberofSubstringsContainingAllThreeCharacters().numberOfSubstrings("abcabc")); // 10
        System.out.println(new NumberofSubstringsContainingAllThreeCharacters().numberOfSubstrings("aaacb")); // 3
        System.out.println(new NumberofSubstringsContainingAllThreeCharacters().numberOfSubstrings("ababbbc")); // 3
    }

    public int numberOfSubstrings(String s) {
        int result = 0, start = 0, end = 0;
        int[] arr = new int[3];

        while (start < s.length()) {
            if (arr[0] != 0 && arr[1] != 0 && arr[2] != 0) {
                result += s.length() - end + 1;
                arr[s.charAt(start) - 'a']--;
                start++;
            } else if (end == s.length()) {
                return result;
            } else {
                arr[s.charAt(end) - 'a']++;
                end++;
            }
        }
        return result;
    }

    /*
    public int numberOfSubstrings(String s) {
        int result = 0, l = 0;
        int[] arr = new int[3];
        for (int r = 0; r < s.length(); r++) {
            char rr = s.charAt(r);
            arr[rr - 'a']++;
            while (arr[0] != 0 && arr[1] != 0 && arr[2] != 0) {
                char ll = s.charAt(l);
                arr[ll - 'a']--;
                l++;
            }
            result +=l;
        }
        return result;
    }
     */
}
