package dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reducing-dishes/description/
 * <p>
 * A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.
 * <p>
 * Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].
 * <p>
 * Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.
 * <p>
 * Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.
 */
public class ReducingDishes {

    public static void main(String[] args) {
        System.out.println(new ReducingDishes().maxSatisfaction(new int[]{-1, -8, 0, 5, -9})); // -9 -8 -1 0 5 -> 14
        System.out.println(new ReducingDishes().maxSatisfaction(new int[]{4, 3, 2})); // 2 3 4 -> 20
        System.out.println(new ReducingDishes().maxSatisfaction(new int[]{-1, -4, -5})); // -> 0
    }

    public int maxSatisfaction(int[] satisfaction) {
        int suf = 0;
        int res = 0;
        Arrays.sort(satisfaction);

        for (int i = satisfaction.length - 1; i >= 0 && suf >= 0; i--) {
            suf += satisfaction[i];
            if (suf > 0) {
                res += suf;
            }
        }
        return res;
    }
}
