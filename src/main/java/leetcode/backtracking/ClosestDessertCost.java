package leetcode.backtracking;

/**
 * https://leetcode.com/problems/closest-dessert-cost/description/
 */
public class ClosestDessertCost {

    public static void main(String[] args) {
        System.out.println(new ClosestDessertCost().closestCost(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1000)); // 120
        System.out.println(new ClosestDessertCost().closestCost(new int[]{139, 9187, 622}, new int[]{9677, 3566, 9344, 7551}, 2811)); // 3705  3566+139
        System.out.println(new ClosestDessertCost().closestCost(new int[]{3738, 5646, 197, 7652}, new int[]{5056}, 9853)); // 10309  197 + 5056 + 5056
        System.out.println(new ClosestDessertCost().closestCost(new int[]{8, 4, 4, 5, 8}, new int[]{3, 10, 9, 10, 8, 10, 10, 9, 3}, 6)); // 5
        System.out.println(new ClosestDessertCost().closestCost(new int[]{10}, new int[]{1}, 1)); // 10
        System.out.println(new ClosestDessertCost().closestCost(new int[]{1, 7}, new int[]{3, 4}, 10)); // 10
        System.out.println(new ClosestDessertCost().closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18)); // 17
        System.out.println(new ClosestDessertCost().closestCost(new int[]{3, 10}, new int[]{2, 5}, 9)); // 8
        System.out.println(new ClosestDessertCost().closestCost(new int[]{4}, new int[]{9}, 9)); // 13
    }

    int ans = Integer.MAX_VALUE;
    int dif = Integer.MAX_VALUE;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) { // Beats 96.45%


        for (int baseCoast : baseCosts) {
            dfs(baseCoast, toppingCosts, target, 0);
        }
        return ans;
    }

    private void dfs(int coast, int[] toppingCosts, int target, int idx) {

        int difCurrent = Math.abs(coast - target);

        if (difCurrent < dif || ((dif == difCurrent) && coast > ans)) {
            dif = difCurrent;
            ans = coast;
        }

        if (idx >= toppingCosts.length || coast > target) return;


        dfs(coast, toppingCosts, target, idx + 1);
        dfs(coast + toppingCosts[idx], toppingCosts, target, idx + 1);
        dfs(coast + 2 * toppingCosts[idx], toppingCosts, target, idx + 1);

    }

/*
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) { // 8 ms Beats 45.09%
        int ans = Integer.MAX_VALUE;

        TreeSet<Integer> options = new TreeSet<>();

        backTrack(options, toppingCosts, target, 0, new int[toppingCosts.length], 0);
        options.add(0);

        for (int baseCoast : baseCosts) {
            for (int possibleToppingsCoast : options.descendingSet()) {
                int price = baseCoast + possibleToppingsCoast;
                int diff = Math.abs(target - price);
                if (diff < Math.abs(target - ans)) {
                    ans = price;
                } else if (diff == Math.abs(target - ans)) {
                    ans = Math.min(ans, price);
                }
                if (price < target) break;
            }
        }
        return ans;
    }

    private void backTrack(Set<Integer> options, int[] toppingCosts, int target, int summ, int[] track, int index) {
        if (summ > target) {
            options.add(summ);
            return;
        }
        if (summ != 0) {
            options.add(summ);
        }

        for (int i = index; i < toppingCosts.length; i++) {
            if (track[i] == 2) continue;
            track[i] += 1;
            summ += toppingCosts[i];
            backTrack(options, toppingCosts, target, summ, track, i);
            summ -= toppingCosts[i];
            track[i] -= 1;
        }
    }*/
}
