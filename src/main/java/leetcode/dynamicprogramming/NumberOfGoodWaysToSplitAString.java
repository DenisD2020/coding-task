package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/
 */
public class NumberOfGoodWaysToSplitAString {

    public static void main(String[] args) {
        System.out.println(new NumberOfGoodWaysToSplitAString().numSplits("aacaba")); // 2
        System.out.println(new NumberOfGoodWaysToSplitAString().numSplits("abcd")); // 1
    }

    public int numSplits(String s) {

        int[] left = new int[24];
        int[] right = new int[24];

        int leftDistinct = 0;
        int rightDistinct = 0;

        for (Character c : s.toCharArray()) {
            int index = c - 'a';
            left[index]++;
            if (left[index] == 1) leftDistinct++;
        }

        int ans = 0;

        for (Character c : s.toCharArray()) {
            int index = c - 'a';
            if (left[index] == 1) leftDistinct--;
            left[index]--;
            if (right[index] == 0) rightDistinct++;
            right[index]++;
            if (leftDistinct == rightDistinct) ans++;
        }
        return ans;
    }
}
