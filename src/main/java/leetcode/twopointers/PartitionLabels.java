package leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/partition-labels/description/
 * <p>
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 * <p>
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 * <p>
 * Return a list of integers representing the size of these parts.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 * <p>
 * Input: s = "eccbbbbdec"
 * Output: [10]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */
public class PartitionLabels {

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij")); // "ababcbaca", "defegde", "hijhklij" 9 7 8
        System.out.println(new PartitionLabels().partitionLabels("eccbbbbdec"));
        System.out.println(new PartitionLabels().partitionLabels("caedbdedda"));
    }

    public List<Integer> partitionLabels(String s) {

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.lastIndexOf(s.charAt(i));
            if (index <= right && i == right) {
                res.add(++right - left);
                left = right;
            } else if (index > right) {
                right = index;
            }
        }
        return res;
    }
}
