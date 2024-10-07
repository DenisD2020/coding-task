package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 */
public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3)); // 12
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{2, 2, 2}, 2)); // 4
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7)); // 55
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{100, 40, 17, 9, 73, 75}, 3)); // 248
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{96, 90, 41, 82, 39, 74, 64, 50, 30}, 8)); // 536
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(new int[]{1, 1000, 1}, 1)); // 1
    }

    public int maxScore(int[] cardPoints, int k) { // 98.88 %

        int summ = 0, windSum = 0, ans = 0;

        int end = cardPoints.length - k - 1;
        for (int i = 0; i < cardPoints.length; i++) {
            summ += cardPoints[i];
            if (i <= end) {
                windSum += cardPoints[i];
            }
        }
        if (cardPoints.length == k) return summ;

        ans = summ - windSum;

        for (int i = 0, j = end + 1; j < cardPoints.length; i++, j++) {
            windSum -= cardPoints[i];
            windSum += cardPoints[j];
            ans = Math.max(ans, summ - windSum);
        }
        return ans;
    }

/*    public int maxScore(int[] cardPoints, int k) { // 4ms  6%
        int ans = 0, start = cardPoints.length - k, prevSum = 0;

        for (int i = 0; i < k + 1; i++) {
            prevSum = windowSum(cardPoints, start + i, k, prevSum);
            ans = Math.max(ans, prevSum);
            if (k >= cardPoints.length) break;
        }
        return ans;
    }

    private int windowSum(int[] cardPoints, int start, int k, int prevSum) {
        if (prevSum == 0) {
            for (int i = start; i < start + k; i++) prevSum += cardPoints[i];
            return prevSum;
        }
        int r = start + k;
        if (r >= cardPoints.length) {
            r = r - cardPoints.length - 1;
        }
        prevSum += cardPoints[r];

        int l = start - 1;
        if (l == 0) l = cardPoints.length - 1;

        prevSum -= cardPoints[l];
        return prevSum;
    }*/
}
