package leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public static void main(String[] args) {
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique().minDeletions("aab")); // 0
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique().minDeletions("aaabbbcc")); // 2
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique().minDeletions("ceabaacb")); // 2
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique().minDeletions("bbcebab")); // 2
    }

    public int minDeletions(String s) { //  51.61%
        int[] frequency = new int[26];
        for (Character c : s.toCharArray()) frequency[c - 'a']++;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : frequency) {
            while (i > 0 && set.contains(i)) {
                i--;
                ans++;
            }
            set.add(i);
        }
        return ans;
    }

/*    public int minDeletions(String s) { // 51.61%
        int[] frequency = new int[26];
        for (Character c : s.toCharArray()) frequency[c - 'a']++;
        int ans = 0;
        Arrays.sort(frequency);

        for (int i = 24; i >= 0; i--) {
            if (frequency[i] == 0) break;

            if (frequency[i] >= frequency[i + 1]) {
                int prevFreq = frequency[i];
                frequency[i] = Math.max(0, frequency[i + 1] - 1);
                ans += prevFreq - frequency[i];
            }
        }
        return ans;
    }*/

    /*public int minDeletions(String s) { //  49%
        int[] frequency = new int[26];
        for (Character c : s.toCharArray()) frequency[c - 'a']++;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : frequency) {
            if (i == 0) continue;
            boolean isAdded = set.add(i);
            if (!isAdded) {
                while (!set.add(i)) {
                    i -= 1;
                    ans++;
                    if (i == 0) break;
                }
            }
        }
        return ans;
    }*/
}
