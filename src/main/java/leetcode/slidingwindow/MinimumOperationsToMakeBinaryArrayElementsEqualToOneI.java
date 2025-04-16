package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/?envType=problem-list-v2&envId=sliding-window
 */
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI().minOperations(new int[]{0, 1, 1, 1, 0, 0})); // 3
        System.out.println(new MinimumOperationsToMakeBinaryArrayElementsEqualToOneI().minOperations(new int[]{0, 1, 1, 1})); // - 1
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        int operation = 0;
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] != 1) {
                operation++;
                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
            }
        }
        if (nums[n - 2] == 0 || nums[n - 1] == 0) return -1;
        return operation;
    }

/*    public int minOperations(int[] nums) {

        int operation = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 1) {
                operation++;
                flip(nums, i);
            }
        }
        boolean ans = true;
        for (Integer i : nums) {
            if (i == 0) {
                operation = -1;
                break;
            }
        }
        return operation;
    }

    void flip(int[] nums, int idx) {
        int start =  Math.min(idx, nums.length - 3);
        int end = Math.min(idx + 3, nums.length);
        for (int i = start; i < end; i++) {
            nums[i] = nums[i] == 1 ? 0 : 1;
        }
    }*/
}
