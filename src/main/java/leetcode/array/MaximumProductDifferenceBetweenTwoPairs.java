package leetcode.array;

/**
 * https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/?envType=daily-question&envId=2023-12-18
 */
public class MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {
        System.out.println(new MaximumProductDifferenceBetweenTwoPairs().maxProductDifference(new int[]{5, 6, 2, 7, 4})); // 34
        System.out.println(new MaximumProductDifferenceBetweenTwoPairs().maxProductDifference(new int[]{4, 2, 5, 9, 7, 4, 8})); // 64
    }

    public int maxProductDifference(int[] nums) {
        int a = 0, b = 0, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
            if (nums[i] < c) {
                d = c;
                c = nums[i];
            } else if (nums[i] < d) {
                d = nums[i];
            }
        }
        return a * b - c * d;
    }


/*    public int maxProductDifference(int[] nums) { O(n logN)
        Arrays.sort(nums);
        int l = nums.length;
        return nums[l - 2] * nums[l - 1] - nums[0] * nums[1];
    }*/
}
