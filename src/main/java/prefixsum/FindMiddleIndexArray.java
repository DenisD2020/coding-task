package prefixsum;

/**
 * https://leetcode.com/problems/find-the-middle-index-in-array/
 * <p>
 * Given a 0-indexed integer array nums, find the leftmost middleIndex (i.e., the smallest amongst all the possible ones).
 * A middleIndex is an index where nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1].
 * If middleIndex == 0, the left side sum is considered to be 0. Similarly, if middleIndex == nums.length - 1, the right side sum is considered to be 0.
 * Return the leftmost middleIndex that satisfies the condition, or -1 if there is no such index.
 */
public class FindMiddleIndexArray {

    public static void main(String[] args) {
//        System.out.println(new FindMiddleIndexArray().findMiddleIndex(new int[]{2, 3, -1, 8, 4})); //3
//        System.out.println(new FindMiddleIndexArray().findMiddleIndex(new int[]{1, -1, 4})); //2
//        System.out.println(new FindMiddleIndexArray().findMiddleIndex(new int[]{2, 5})); //-1
        System.out.println(new FindMiddleIndexArray().findMiddleIndex(new int[]{0, 0, 0})); //0
    }

    public int findMiddleIndex(int[] nums) {
        int res = -1;

        int prefixRight = 0;
        for (int num : nums) prefixRight += num;

        int prefixLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 > -1) {
                prefixLeft += nums[i - 1];
            }
            prefixRight -= nums[i];

            if (prefixLeft == prefixRight) {
                res = i;
                break;
            }
        }
        return res;
    }
}
