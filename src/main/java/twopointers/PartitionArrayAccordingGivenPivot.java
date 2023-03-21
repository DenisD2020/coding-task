package twopointers;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot/
 */
public class PartitionArrayAccordingGivenPivot {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PartitionArrayAccordingGivenPivot().pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10))); // [9,5,3,10,10,12,14]
    }

    public int[] pivotArray(int[] nums, int pivot) {

        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] middle = new int[length];
        int leftIndex = 0, rightIndex = 0, middleIndex = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] < pivot) {
                left[leftIndex++] = nums[i];
            } else if (nums[i] > pivot) {
                right[rightIndex++] = nums[i];
            } else {
                middle[middleIndex++] = nums[i];
            }
        }

        System.arraycopy(middle, 0, left, leftIndex, middleIndex);
        System.arraycopy(right, 0, left, leftIndex + middleIndex, rightIndex);
        return left;
    }
}
