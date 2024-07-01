package leetcode.array;

public class MinimumCosttoMoveChipstoTheSamePosition {

    public static void main(String[] args) {
        System.out.println(new MinimumCosttoMoveChipstoTheSamePosition().minCostToMoveChips(new int[]{1, 2, 3})); // 1
        System.out.println(new MinimumCosttoMoveChipstoTheSamePosition().minCostToMoveChips(new int[]{2, 2, 2, 3, 3})); // 2
        System.out.println(new MinimumCosttoMoveChipstoTheSamePosition().minCostToMoveChips(new int[]{1, 1000000000})); // 1
    }

    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;

        for (Integer i : position)
            if (i % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        return Math.min(odd, even);
    }
}
