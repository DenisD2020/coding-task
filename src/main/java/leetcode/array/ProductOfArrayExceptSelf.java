package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/?envType=study-plan-v2&envId=top-interview-150
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4}))); // 24,12,8,6
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // 0,0,9,0,0
    }

    public int[] productExceptSelf(int[] nums) { // 99.66%
        int totalProduct = 1;
        int zeroCount = 0;
        for (int i : nums) {
            if (i == 0) {
                zeroCount++;
                if (zeroCount > 1) break;
            } else {
                totalProduct *= i;
            }
        }

        int[] ans = new int[nums.length];
        if (zeroCount > 1) return ans;

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1) {
                if (nums[i] == 0) {
                    ans[i] = totalProduct;
                }
            } else {
                ans[i] = totalProduct / nums[i];
            }
        }
        return ans;
    }
}
