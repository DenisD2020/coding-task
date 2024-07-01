package leetcode.hashtable;

/**
 * You  are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 * Return the minimum number of steps to make t an anagram of s.
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 * <p>
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/description/
 */
public class MinimumNumberofStepstoMakeTwoStringsAnagram {

    public static void main(String[] args) {
//        System.out.println(new MinimumNumberofStepstoMakeTwoStringsAnagram().minSteps("bab", "aba")); // 1
        System.out.println(new MinimumNumberofStepstoMakeTwoStringsAnagram().minSteps("leetcode", "practice")); // 5
//        System.out.println(new MinimumNumberofStepstoMakeTwoStringsAnagram().minSteps("anagram", "mangaar")); // 0
    }

    public int minSteps(String s, String t) {
        int ans = 0;
        int length = s.length();
        int[] arrS = new int[26];
        int[] arrT = new int[26];
        for (int i = 0; i < length; i++) {
            arrS[s.charAt(i) - 'a']++;
            arrT[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arrS[i] - arrT[i] > 0) {
                ans += arrS[i] - arrT[i];
            }
        }
        return ans;
    }
}
