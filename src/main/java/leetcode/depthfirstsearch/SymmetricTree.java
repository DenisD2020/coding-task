package leetcode.depthfirstsearch;

import leetcode.binarytree.Helper;
import leetcode.binarytree.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class SymmetricTree {
    public static void main(String[] args) {
        System.out.println(new SymmetricTree().isSymmetric(Helper.formTree(new Integer[]{1, 2, 2, 3, 4, 4, 3}))); // true
        System.out.println(new SymmetricTree().isSymmetric(Helper.formTree(new Integer[]{1, 2, 2, null, 3, null, 3}))); // false
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
