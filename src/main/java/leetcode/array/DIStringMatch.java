package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/di-string-match/
 * <p>
 * A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:
 * <p>
 * s[i] == 'I' if perm[i] < perm[i + 1], and
 * s[i] == 'D' if perm[i] > perm[i + 1].
 * Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.
 */
public class DIStringMatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DIStringMatch().diStringMatch("IDID"))); // [0,4,1,3,2]
        System.out.println(Arrays.toString(new DIStringMatch().diStringMatch("III"))); // [0,1,2,3]
        System.out.println(Arrays.toString(new DIStringMatch().diStringMatch("DDI"))); // [3,2,0,1]
    }

    public int[] diStringMatch(String s) {
        int length = s.length();
        int[] res = new int[length + 1];
        int min = 0, max = length;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }
        }
        res[length] = min;
        return res;
    }
}
