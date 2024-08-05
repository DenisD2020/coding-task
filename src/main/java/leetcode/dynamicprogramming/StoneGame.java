package leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/stone-game/description/
 */
public class StoneGame {

    public static void main(String[] args) {
        System.out.println(new StoneGame().stoneGame(new int[]{5, 1, 4})); // true
//        System.out.println(new StoneGame().stoneGame(new int[]{5, 3, 4, 5})); // true
//        System.out.println(new StoneGame().stoneGame(new int[]{3, 7, 2, 3})); // true
//        System.out.println(new StoneGame().stoneGame(new int[]{3, 2, 10, 4})); // true
    }

    private Map<String, Integer> dp = new HashMap<>();

    public boolean stoneGame(int[] piles) {

        int ans = dfs(piles, 0, piles.length - 1, true);
        System.out.println(ans);

        return false;
    }

    public int dfs(int[] piles, int l, int r, boolean turn) {
        if (l > r) {
            return 0;
        }
        int left = 0, right = 0;
        if (turn) {
            left = piles[l];
            right = piles[r];
        }
        int ll = left + dfs(piles, l + 1, r, !turn);
        int rr = right + dfs(piles, l, r - 1, !turn);
        return Math.max(ll, rr);
    }

/*    public int dfs(int[] piles, int l, int r, boolean turn) {
        if (l > r) {
            return 0;
        }
        int left = 0, right = 0;
        if (turn) {
            left = piles[l];
            right = piles[r];
        }
        int ll = left + dfs(piles, l + 1, r, !turn);
        int rr = right + dfs(piles, l, r - 1, !turn);
        return Math.max(ll, rr);
    }*/
}

