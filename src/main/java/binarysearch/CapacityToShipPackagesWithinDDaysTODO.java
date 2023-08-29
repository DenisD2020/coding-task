package binarysearch;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * <p>
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p>
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days
 */
public class CapacityToShipPackagesWithinDDaysTODO {

    public static void main(String[] args) {
        System.out.println(new CapacityToShipPackagesWithinDDaysTODO().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // 15
        System.out.println(new CapacityToShipPackagesWithinDDaysTODO().shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)); // 6
        System.out.println(new CapacityToShipPackagesWithinDDaysTODO().shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)); // 3
    }

    public int shipWithinDays(int[] weights, int days) {
        int res = -1;

        int min = IntStream.of(weights).max().getAsInt();
        int max = 500;

/*        while (min <= max) {
            int mid = min  + ((max - min) / 2);
            if (sortedArray[mid] < key) {
                min = mid + 1;
            } else if (sortedArray[mid] > key) {
                max = mid - 1;
            } else if (sortedArray[mid] == key) {
                return min;
            }
        }*/


        return res;
    }
}
