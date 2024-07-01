package leetcode.string;

import java.util.HashSet;

/**
 * Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
 * Return the minimum number of substrings in such a partition.
 * Note that each character should belong to exactly one substring in a partition.
 * <p>
 * https://leetcode.com/problems/optimal-partition-of-string/description/
 */
public class OptimalPartitionofString {

    public static void main(String[] args) {
        System.out.println(new OptimalPartitionofString().partitionString("abacaba")); // 4
        System.out.println(new OptimalPartitionofString().partitionString("ssssss")); // 6
    }

    public int partitionString(String s) {
        int ans = 1;
        HashSet<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (!set.add(c)) {
                ans++;
                set.clear();
                set.add(c);
            }
        }
        return ans;
    }
}
