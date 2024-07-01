package leetcode.backtracking;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/distribute-money-to-maximum-children/
 */
public class DistributeMoneyToMaximumChildren {

    public static void main(String[] args) {
        System.out.println(new DistributeMoneyToMaximumChildren().distMoney(20, 3)); // 1
//        System.out.println(new DistributeMoneyToMaximumChildren().distMoney(16, 2)); // 2
    }

    public int distMoney(int money, int children) {
        dfs(money, children, new int[children], 0, new int[money]);
        return -1;
    }

    private void dfs(int money, int numberOfChildren, int[] children, int distributed, int[] track) {
        if (distributed == money) {
            System.out.println(Arrays.toString(children));
            return;
        }

        if (track[distributed] == 1) {
            return;
        };
        track[distributed] = 1;
        for (int i = 0; i < numberOfChildren; i++) {
            children[i]++;
            dfs(money, numberOfChildren, children, distributed + 1, track);
            children[i]--;
        }
        track[distributed] = 0;
    }
}
