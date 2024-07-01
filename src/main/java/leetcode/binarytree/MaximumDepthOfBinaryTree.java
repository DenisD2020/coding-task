package leetcode.binarytree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * <p>
 * 104. Maximum Depth of Binary Tree
 * Easy
 * 10.5K
 * 167
 * Companies
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 * <p>
 * Input: root = [1,null,2]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class MaximumDepthOfBinaryTree {

    private int max = 0;


    public static void main(String[] args) {
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(Helper.formTree(new Integer[]{3, 9, 20, null, null, 15, 7}))); // 3
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(Helper.formTree(new Integer[]{1, null, 2}))); // 2
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
