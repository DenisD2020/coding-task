package leetcode.twopointers;

/**
 * https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/?envType=problem-list-v2&envId=two-pointers
 */
public class AppendCharactersToStringToMakeSubsequence {
    public static void main(String[] args) {
        System.out.println(new AppendCharactersToStringToMakeSubsequence().appendCharacters("coaching", "coding")); // 4
        System.out.println(new AppendCharactersToStringToMakeSubsequence().appendCharacters("abcde", "a")); // 0
        System.out.println(new AppendCharactersToStringToMakeSubsequence().appendCharacters("z", "abcde")); // 5
    }

    public int appendCharacters(String s, String t) { // 62%
        int i = 0 , j = 0;
        int length = t.length();
        while (i < s.length() && j < length) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
                if (j == length) break;
            }
            i++;
        }
        return length - j;
    }
}
