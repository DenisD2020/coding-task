package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGameII {

    public static void main(String[] args) {
//        System.out.println(new JumpGameII().jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3})); // 3
//        System.out.println(new JumpGameII().jump(new int[]{1, 2, 3})); // 2
//        System.out.println(new JumpGameII().jump(new int[]{1, 0})); // 1
        System.out.println(new JumpGameII().jump(new int[]{2, 3, 1, 1, 4})); // 2
//        System.out.println(new JumpGameII().jump(new int[]{2, 3, 0, 1, 4})); // 2
//        System.out.println(new JumpGameII().jump(new int[]{2, 3, 1})); // 1
    }

    public int jump(int[] nums) { // 98.63
        int f = 0;
        int current = 0;
        int jumps = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            f = Math.max(f, nums[i] + i);

            if (current == i) {
                current = f;
                jumps++;
            }
            if (current >= nums.length) break;
        }
        return jumps;
    }

/*    public int jump(int[] nums) { // 27.40%
        int[] dp = new int[nums.length];
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = prev + 1; j < i + nums[i] + 1; j++) {
                if (j >= nums.length) break;
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                }
            }
            prev = Math.max(prev, i + nums[i]);
            if (dp[dp.length - 1] != 0) break;
        }
        return dp[dp.length - 1];
    }*/


/*    public int jump(int[] nums) { // 21.20%
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < i + nums[i] + 1; j++) {
                if (j >= nums.length) break;
                if (dp[j] == 0) {
                    dp[j] = dp[i] + 1;
                }
            }
        }
        return dp[dp.length - 1];
    }*/
}
