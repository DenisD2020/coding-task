package leetcode.twopointers;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumIIInputArrayIsSorted().twoSum(new int[]{2, 7, 11, 15}, 9))); // [1,2]
        System.out.println(Arrays.toString(new TwoSumIIInputArrayIsSorted().twoSum(new int[]{2, 3, 4}, 6))); // [1,3]
        System.out.println(Arrays.toString(new TwoSumIIInputArrayIsSorted().twoSum(new int[]{-1, 0}, -1))); // [1,2]
    }

    public int[] twoSum(int[] numbers, int target) { // 93.05%
        int l = 0, r = numbers.length - 1;
        int[] ans = new int[2];
        while (l < r) {
            int leftVal = numbers[l];
            int rightVal = numbers[r];
            int dif = leftVal + rightVal - target;
            if (target == leftVal + rightVal) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                break;
            } else if (dif > 0) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
