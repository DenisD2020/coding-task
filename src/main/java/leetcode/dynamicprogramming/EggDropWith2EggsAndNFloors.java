package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 */
public class EggDropWith2EggsAndNFloors {

    public static void main(String[] args) { // TODO
        System.out.println(new EggDropWith2EggsAndNFloors().twoEggDrop(10)); //
        System.out.println(new EggDropWith2EggsAndNFloors().twoEggDrop(100)); // n = 14
//        System.out.println(new EggDropWith2EggsAndNFloors().twoEggDrop(2)); // n = 2
    }

    int[][] dp;

    public int twoEggDrop(int n) {
        return twoEggDrop2(n, 2);
    }

    public int twoEggDrop2(int n, int eggs) {
        dp = new int[1001][eggs + 1];
        return calc2(n, eggs);
    }

    private int calc2(int floors, int eggs) {
        if (floors <= 2 || eggs == 1) return floors;

        if (dp[floors][eggs] != 0) return dp[floors][eggs];

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= floors; i++) {
            int noEggBreake = 1 + calc(floors - i, eggs);
            int eggBreake = 1 + calc(i - 1, eggs - 1);
            int min = Math.max(noEggBreake, eggBreake);
            ans = Math.min(ans, min);
        }
        dp[floors][eggs] = ans;
        return ans;
    }

    private int calc(int floors, int eggs) {
        if (floors == 0 || floors == 1 || eggs == 1) return floors;

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i <= floors; i++) {
            if (dp[floors - i][eggs] == 0) dp[floors - i][eggs] = calc(floors - i, eggs);
            if (dp[i - 1][eggs - 1] == 0) dp[i - 1][eggs - 1] = calc(i - 1, eggs - 1);
            int min = Math.max(dp[floors - i][eggs], dp[i - 1][eggs - 1]);
            ans = Math.min(ans, min);
        }
        return ans + 1;
    }
}
