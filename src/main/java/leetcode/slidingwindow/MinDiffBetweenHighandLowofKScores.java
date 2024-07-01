package leetcode.slidingwindow;

import java.util.Arrays;

public class MinDiffBetweenHighandLowofKScores {
    public static void main(String[] args) {
        System.out.println("result:" + new MinDiffBetweenHighandLowofKScores().minimumDifference(new int[]{90}, 1));
        System.out.println("result:" + new MinDiffBetweenHighandLowofKScores().minimumDifference(new int[]{9, 4, 1, 7}, 2));
        System.out.println("result:" + new MinDiffBetweenHighandLowofKScores().minimumDifference(new int[]{87063,61094,44530,21297,95857,93551,9918}, 6));
    }

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minRes = -1;
        if (nums.length == 1) {
            return 0;
        }
        for (int i = 0; i < nums.length - k + 1 ; i++) {
            int r = nums[i + k - 1] - nums[i];
            if (minRes == -1 || r < minRes) {
                minRes = r;
            }
        }
        return minRes;
    }
}
