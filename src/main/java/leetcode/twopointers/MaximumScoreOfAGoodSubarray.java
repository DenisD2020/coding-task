package leetcode.twopointers;

/**
 * https://leetcode.com/problems/maximum-score-of-a-good-subarray/description/?envType=problem-list-v2&envId=two-pointers
 * <p>
 * min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1)
 */
public class MaximumScoreOfAGoodSubarray {

    public static void main(String[] args) {
        System.out.println(new MaximumScoreOfAGoodSubarray().maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3)); //15
        System.out.println(new MaximumScoreOfAGoodSubarray().maximumScore(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0)); //20
        System.out.println(new MaximumScoreOfAGoodSubarray().maximumScore(new int[]{6569, 9667, 3148, 7698, 1622, 2194, 793, 9041, 1670, 1872}, 5)); //9732
    }

    public int maximumScore(int[] nums, int k) { // 40.84
        int i = k;
        int j = k;
        int ans = nums[k];
        int minVal = Integer.MAX_VALUE;

        while (i > 0 || j < nums.length - 1) {

            int l = i > 0 ? nums[i - 1] : 0;
            int r = j < nums.length - 1 ? nums[j + 1] : 0;

            if (r > l) {
                j++;
            } else {
                i--;
            }
            minVal = Math.min(minVal, Math.min(nums[i], nums[j]));
            ans = Math.max(ans, minVal * (j - i + 1));
        }
        return ans;
    }


    /*
    public int maximumScore(int[] nums, int k) { // 25.84%
        int i = k;
        int j = k;
        int ans = 0;
        int minVal = Integer.MAX_VALUE;

        while (i >= 0 && j <= nums.length - 1) {
            minVal = Math.min(minVal, Math.min(nums[i], nums[j]));
            int localMax = check(nums, i, j, minVal, ans);
            ans = Math.max(localMax, ans);

            int jNext = check(nums, i, j + 1, minVal, ans);
            int iNext = check(nums, i - 1, j, minVal, ans);

            if (jNext > iNext) {
                j++;
            } else {
                i--;
            }
        }
        return ans;
    }

    private int check(int[] nums, int i, int j, int minVal, int ans) {
        if (j == nums.length) return 0;
        if (i < 0) return 0;
        int l = nums[i];
        int r = nums[j];
        minVal = Math.min(minVal, Math.min(nums[i], nums[j]));
        int lMin = minVal * i;
        int rMin = minVal * j;
        int localMax = rMin - lMin + minVal;
        return localMax;
    }
    *
    * */
}
