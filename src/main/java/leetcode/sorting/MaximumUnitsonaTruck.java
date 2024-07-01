package leetcode.sorting;

import java.util.Arrays;

/**
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 * Return the maximum total number of units that can be put on the truck.
 * <p>
 * https://leetcode.com/problems/maximum-units-on-a-truck/description/
 */
public class MaximumUnitsonaTruck {

    public static void main(String[] args) {
        System.out.println(new MaximumUnitsonaTruck().maximumUnits(new int[][]{new int[]{1, 3}, new int[]{2, 2}, new int[]{3, 1}}, 4)); // 8
        System.out.println(new MaximumUnitsonaTruck().maximumUnits(new int[][]{new int[]{5, 10}, new int[]{2, 5}, new int[]{4, 7}, new int[]{3, 9}}, 10)); // 91
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int currentSize = 0;
        int unit = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for (int[] t : boxTypes) {
            for (int i = 0; i < t[0]; i++) {
                if (currentSize < truckSize) {
                    unit += t[1];
                    currentSize++;
                } else {
                    break;
                }
            }
        }
        return unit;
    }
}
