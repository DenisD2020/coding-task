package leetcode.string;

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2023-12-22
 */
public class MaximumScoreAfterSplittingAString {

    public static void main(String[] args) {
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("00")); // 2
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("011101")); // 5
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("00111")); // 5
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("1111")); // 3
    }

    public int maxScore(String s) {
        int oneRight = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                oneRight++;
            }
        }
        int ans = 0;
        int zeroLeft = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroLeft++;
            } else {
                oneRight--;
            }
            ans = Math.max(ans, zeroLeft + oneRight);
        }
        return ans;
    }
}
