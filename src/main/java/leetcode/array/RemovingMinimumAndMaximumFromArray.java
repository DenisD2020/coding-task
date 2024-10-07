package leetcode.array;

/**
 * https://leetcode.com/problems/removing-minimum-and-maximum-from-array/description/
 */
public class RemovingMinimumAndMaximumFromArray {

    public static void main(String[] args) {
//        System.out.println(new RemovingMinimumAndMaximumFromArray().minimumDeletions(new int[]{2, 10, 7, 5, 4, 1, 8, 6})); // 5
//        System.out.println(new RemovingMinimumAndMaximumFromArray().minimumDeletions(new int[]{0, -4, 19, 1, 8, -2, -3, 5})); // 3
//        System.out.println(new RemovingMinimumAndMaximumFromArray().minimumDeletions(new int[]{101})); // 1
//        System.out.println(new RemovingMinimumAndMaximumFromArray().minimumDeletions(new int[]{1, 0, 1})); // 1
        System.out.println(new RemovingMinimumAndMaximumFromArray().minimumDeletions(new int[]{-100000,-99999})); // 2
    }

    public int minimumDeletions(int[] nums) {
        if (nums.length == 1) return 1;
        int indexMax = -1, indexMin = -1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                max = num;
                indexMax = i;
            }
            if (num < min) {
                min = num;
                indexMin = i;
            }
        }
        int s1 = Math.max(indexMax, indexMin) + 1;
        int s2 = nums.length - Math.min(indexMax, indexMin);
        int s3 = Math.min(indexMax, indexMin) + 1 + nums.length - Math.max(indexMax, indexMin);
        return Math.min(Math.min(s1, s2), s3);
    }
}
