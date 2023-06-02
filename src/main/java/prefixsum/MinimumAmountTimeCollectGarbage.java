package prefixsum;

import java.util.List;

/**
 * https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
 * <p>
 * You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
 * You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
 * There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
 * Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
 * Return the minimum number of minutes needed to pick up all the garbage.
 */
public class MinimumAmountTimeCollectGarbage {

    public static void main(String[] args) {
        System.out.println(new MinimumAmountTimeCollectGarbage().garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3})); // 21
        System.out.println(new MinimumAmountTimeCollectGarbage().garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10})); // 37
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        int[] position = new int[]{0, 0, 0};

        for (int i = 0; i < garbage.length; i++) {
            res += garbage[i].length();
            for (String s : List.of("M", "P", "G")) {
                if (garbage[i].contains(s)) {
                    int index = getIndex(s);
                    int p = position[index];
                    res += calculateRoad(travel, p, i);
                    position[index] = i;
                }
            }
        }
        return res;
    }

    private int getIndex(String s) {
        if (s == "M") {
            return 0;
        } else if (s == "P") {
            return 1;
        }
        return 2;
    }

    private int calculateRoad(int[] travel, int n1, int n2) {
        int sum = 0;
        for (int i = n1; i < n2; i++) {
            sum += travel[i];
        }
        return sum;
    }
}
