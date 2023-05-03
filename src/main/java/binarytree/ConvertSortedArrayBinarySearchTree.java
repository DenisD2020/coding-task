package binarytree;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * <p>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a
 * height-balanced
 * binary search tree.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class ConvertSortedArrayBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(new ConvertSortedArrayBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9})); // [0,-3,9,-10,null,5] is also accepted: [0,-10,5,null,-3,null,9]
        System.out.println(new ConvertSortedArrayBinarySearchTree().sortedArrayToBST(new int[]{1, 3})); // [3,1]
        System.out.println(new ConvertSortedArrayBinarySearchTree().sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5})); //
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length - 1);
    }

    private TreeNode convert(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = convert(nums, left, middle - 1);
        root.right = convert(nums, middle + 1, right);
        return root;
    }
}
