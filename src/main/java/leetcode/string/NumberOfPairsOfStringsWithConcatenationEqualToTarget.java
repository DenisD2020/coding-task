package leetcode.string;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 */
public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {

    public static void main(String[] args) {
        System.out.println(new NumberOfPairsOfStringsWithConcatenationEqualToTarget().numOfPairs(new String[]{"88760205", "88", "8", "7602058"}, "887602058")); // 0
        System.out.println(new NumberOfPairsOfStringsWithConcatenationEqualToTarget().numOfPairs(new String[]{"1", "111"}, "11")); // 0
        System.out.println(new NumberOfPairsOfStringsWithConcatenationEqualToTarget().numOfPairs(new String[]{"777", "7", "77", "77"}, "7777")); // 4
        System.out.println(new NumberOfPairsOfStringsWithConcatenationEqualToTarget().numOfPairs(new String[]{"123", "4", "12", "34"}, "1234")); // 2
        System.out.println(new NumberOfPairsOfStringsWithConcatenationEqualToTarget().numOfPairs(new String[]{"1", "1", "1"}, "11")); // 6
    }

    public int numOfPairs(String[] nums, String target) {
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : nums) {
            map.merge(s, 1, Integer::sum);
        }
        for (String s : nums) {
            if (target.startsWith(s)) {
                String substring = target.substring(s.length());
                Integer val = map.get(substring);
                if (val != null) {
                    int prefix = 0;
                    if (val != 0 && substring.equals(s)) {
                        prefix--;
                    }
                    ans += val + prefix;
                }
            }
        }
        return ans;
    }
}
