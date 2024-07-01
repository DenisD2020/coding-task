package leetcode.twopointers;

/**
 * Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 * <p>
 * https://leetcode.com/problems/count-binary-substrings/
 */
public class CountBinarySubstrings {

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110011"));
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("10101"));
    }

    public int countBinarySubstrings(String s) {
        int ans = 0;
        int group[] = new int[s.length()];
        group[0] = 1;
        int index = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                ++group[index];
            } else {
                index++;
                ++group[index];
            }
        }
        for (int i = 1; i <= index; i++) {
            ans += Math.min(group[i-1], group[i]);
        }
        return ans;
    }
}
