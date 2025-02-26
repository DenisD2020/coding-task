package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/best-sightseeing-pair/description/
 * <p>
 * values[i] + values[j] + i - j
 * the sum of the values of the sightseeing spots, minus the distance between them.
 * Return the maximum score of a pair of sightseeing spots
 */
public class BestSightseeingPair {

    public static void main(String[] args) {
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(new int[]{4, 7, 5, 8})); // 13
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6})); // 11
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(new int[]{7, 2, 6, 6, 9, 4, 3})); // 14
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(new int[]{7, 8, 8, 10})); // 17
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(new int[]{1, 3, 5})); // 7
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(new int[]{3, 7, 2, 3})); // 9
        System.out.println(new BestSightseeingPair().maxScoreSightseeingPair(new int[]{1, 2})); // 2
    }

    public int maxScoreSightseeingPair(int[] values) { // 65.59%
        int length = values.length;
        int maxScore = 0;
        int maxLeftScore = values[0];

        for (int i = 1; i < length; i++) {
            int rightScore = values[i] - i;
            maxScore = Math.max(maxScore, maxLeftScore + rightScore);
            maxLeftScore = Math.max(maxLeftScore, values[i] + i);
        }
        return maxScore;
    }

/*    public int maxScoreSightseeingPair(int[] values) { // 16.60%
        int length = values.length;
        int maxScore = 0;
        int[] maxLeftScore = new int[length];
        maxLeftScore[0] = values[0];

        for (int i = 1; i < length; i++) {
            int rightScore = values[i] - i;
            maxScore = Math.max(maxScore, maxLeftScore[i - 1] + rightScore);
            maxLeftScore[i] = Math.max(maxLeftScore[i - 1], values[i] + i);
        }
        return maxScore;
    }*/

/*    public int maxScoreSightseeingPair(int[] values) { // 65.59%
        int ans = 0;
        int left = values[0];
        int oldMax = 0;
        int curMax = 0;

        for (int i = 1; i < values.length; i++) {
            curMax = values[i - 1] + values[i] - 1;
            oldMax = left + values[i] - i;
            if (curMax >= oldMax) {
                left = values[i - 1] + i - 1;
                oldMax = curMax;
            }
            ans = Math.max(ans, oldMax);
        }
        return ans;
    }*/
}
