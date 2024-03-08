package string;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram-ii/
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagramII {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfStepsToMakeTwoStringsAnagramII().minSteps("leetcode", "coats")); // 7
        System.out.println(new MinimumNumberOfStepsToMakeTwoStringsAnagramII().minSteps("night", "thing")); // 0
    }

    public int minSteps(String s, String t) {
        int[] s1 = new int[26];
        int[] t1 = new int[26];

        for (Character c : s.toCharArray()) {
            s1[c - 'a']++;
        }

        for (Character c : t.toCharArray()) {
            t1[c - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < s1.length; i++) {
            ans += Math.abs(s1[i] - t1[i]);
        }
        return ans;
    }

    public int minSteps2(String s, String t) {
        int[] s1 = new int[26];
        int[] t1 = new int[26];

        for (Character c : s.toCharArray()) {
            s1[c - 'a']++;
        }

        for (Character c : t.toCharArray()) {
            t1[c - 'a']++;
        }
        int ans = 0;
        for (int i = 0; i < s1.length; i++) {
            ans += Math.abs(s1[i] - t1[i]);
        }
        return ans;
    }
}
