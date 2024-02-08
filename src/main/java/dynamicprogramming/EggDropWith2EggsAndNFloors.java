package dynamicprogramming;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/
 */
public class EggDropWith2EggsAndNFloors {

    public static void main(String[] args) { // TODO
        System.out.println(new EggDropWith2EggsAndNFloors().twoEggDrop(100)); // n = 14

        HashMap<String, String> map = new HashMap<>();

        map.put("a", "b");
        map.put("c", "b");
        map.put("c", "b");
    }

    int arr[] = new int[1001];

    public int twoEggDrop(int n) {

        for (int i = 1; i <= n; i++) {
            int dp = dp(n, i);
            arr[i] = dp;
            System.out.println(dp);
        }
        return 0;
    }

    private int dp(int n, int i) {
        return Math.max(n - i, i - 1);
    }
}
