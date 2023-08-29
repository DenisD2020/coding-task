package array;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 * <p>
 * You are given an integer array bloomDay, an integer m and an integer k.
 * <p>
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * <p>
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * <p>
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 */
public class MinimumNumberofDaystoMakemBouquets {

    public static void main(String[] args) {
        System.out.println(new MinimumNumberofDaystoMakemBouquets().minDays(new int[]{1, 10, 3, 10, 2}, 3, 1)); // 3
        System.out.println(new MinimumNumberofDaystoMakemBouquets().minDays(new int[]{1, 10, 3, 10, 2}, 3, 2)); // -1
        System.out.println(new MinimumNumberofDaystoMakemBouquets().minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3)); // 12
    }

    public int minDays(int[] bloomDay, int m, int k) { // Time Limit Exceeded
        if (m * k > bloomDay.length) return -1;
        int res = -1;

        TreeSet<Integer> setDays = new TreeSet<>();
        for (int j : bloomDay) {
            setDays.add(j);
        }
        List<Integer> listDays = new ArrayList<>(setDays);
        int low = 0, high = listDays.size() - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            Integer days = getResult(bloomDay, m, k, listDays.get(mid));
            if (days != -1) {
                res = days > 0 && res > 0 ? Math.min(res, days) : days;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private Integer getResult(int[] bloomDay, int m, int k, Integer days) {
        int bouquets = 0;
        int adjacentFlowers = 0;
        for (int j : bloomDay) {
            if (j <= days) { // flower is blooming
                adjacentFlowers++;
                if (adjacentFlowers == k) {
                    bouquets++;
                    adjacentFlowers = 0;
                }
            } else {
                adjacentFlowers = 0;
            }
            if (bouquets == m) {
                return days;
            }
        }
        return -1;
    }
}











