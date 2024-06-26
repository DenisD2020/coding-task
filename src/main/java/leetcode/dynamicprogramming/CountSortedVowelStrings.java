package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 * <p>
 * Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * <p>
 * A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: 5
 * Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: 15
 * Explanation: The 15 sorted strings that consist of vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 * Example 3:
 * <p>
 * Input: n = 33
 * Output: 66045
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 */
public class CountSortedVowelStrings {

    char vowels[] = new char[]{'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(1)); // 5
        System.out.println(new CountSortedVowelStrings().countVowelStrings(2)); // 15
        System.out.println(new CountSortedVowelStrings().countVowelStrings(3)); // 66045
    }


    public int countVowelStrings(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;

        for (int index = 1; index < n; index++) {
            a = a + e + i + o + u;
            e = e + i + o + u;
            i = i + o + u;
            o = o + u;
            u = u;
        }
        return a + e + i + o + u;
    }


}





