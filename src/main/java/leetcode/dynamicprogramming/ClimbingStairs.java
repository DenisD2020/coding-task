package leetcode.dynamicprogramming;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2)); // 2
        System.out.println(new ClimbingStairs().climbStairs(3)); // 3
        System.out.println(new ClimbingStairs().climbStairs(4)); // 5
    }

    static int[] dp = new int[51];

    {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
    }

    public int climbStairs(int n) {

        if (dp[n] != 0) return dp[n];

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


}
