package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/jump-game/description/
 */
public class JumpGame {

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{3, 0, 8, 2, 0, 0, 1})); // true
        System.out.println(new JumpGame().canJump(new int[]{2, 0, 0})); // true
        System.out.println(new JumpGame().canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(new JumpGame().canJump(new int[]{3, 2, 1, 0, 4})); // false
    }

    public boolean canJump(int[] nums) { // 79.27%
        if (nums.length == 1) return true;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r = Math.max(nums[i] + i, r);
            if (r >= nums.length - 1) return true;
            if (r <= i) return false;
        }
        return false;
    }

/*    public boolean canJump(int[] nums) { // 16.89%
        if (nums.length == 1) return true;
        int[] dp = new int[nums.length];
        int rR = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == 0 && i != 0) break;
            int l = i, r = i + nums[i];
            if (r >= nums.length) return true;
            if (r < rR) continue;
            while (l <= r) {
                dp[l] = 1;
                l++;
            }
            rR = r;
        }
        return dp[dp.length - 1] == 1;
    }*/


/*    public boolean canJump(int[] nums) { // 6.84%
        if (nums.length == 1) return true;
        int[] track = new int[nums.length];
        return dp(nums, 0, track);
    }

    private boolean dp(int[] nums, int idx, int[] track) {
        if (idx >= nums.length - 1) {
            return true;
        }
        if (track[idx] == 1) return false;
        track[idx] = 1;
        boolean res = false;
        for (int i = 1; i <= nums[idx]; i++) {
            if (dp(nums, idx + i, track)) {
                res = true;
                break;
            }
        }
        return res;
    }*/
}
