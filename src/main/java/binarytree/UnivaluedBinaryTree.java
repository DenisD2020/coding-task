package binarytree;

import static binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/univalued-binary-tree/
 * <p>
 * A binary tree is uni-valued if every node in the tree has the same value.
 * <p>
 * Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.
 */
public class UnivaluedBinaryTree {

    public static void main(String[] args) {
        System.out.println(new UnivaluedBinaryTree().isUnivalTree(formTree(new Integer[]{1, 1, 1, 1, 1, null, 1}))); // true
        System.out.println(new UnivaluedBinaryTree().isUnivalTree(formTree(new Integer[]{2, 2, 2, 5, 2}))); // false
    }

    int val = -1;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (val == -1) {
            val = root.val;
        }
        if (root.val != val) {
            return false;
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
