package leetcode.backtracking;

/**
 * https://youtu.be/gbgiFVFhGkc?si=WHKUuWybqwSMSE59&t=2110
 */
public class TargetSum_youtube {

    public static void main(String[] args) {
        System.out.println(new TargetSum_youtube().findTargetSumWays2(new int[]{9, 3, 6}, 12)); // true
        System.out.println(new TargetSum_youtube().findTargetSumWays(new int[]{1, 2, 3}, 10)); // false
        System.out.println(new TargetSum_youtube().findTargetSumWays(new int[]{10, 20, 30}, 60)); // true
    }

    public boolean findTargetSumWays(int[] nums, int target) {
        return backTracking(nums, target, 0, 0);
    }

    private boolean backTracking(int[] nums, int target, int res, int idx) {
        if (idx == nums.length) return res == target;
        return backTracking(nums, target, res + nums[idx], idx + 1) || backTracking(nums, target, res - nums[idx], idx + 1);
    }

    public boolean findTargetSumWays2(int[] nums, int target) {
        return backTracking2(nums, target, 0, 0, new int[nums.length]);
    }

    private boolean backTracking2(int[] nums, int target, int res, int idx, int [] track) {
        if (idx == nums.length) return res == target;
        for (int i = 0; i < nums.length; i++) {
            if (track[i] == 1) continue;
            track[i] = 1;
            boolean b = backTracking2(nums, target, res + nums[i], i + 1, track) || backTracking2(nums, target, res - nums[i], i + 1, track);
            track[i] = 0;
            if (b) return true;
        }
        return false;
    }
}
