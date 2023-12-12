package breadthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;


/**
 * https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
 */
public class ReverseOddLevelsOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(new ReverseOddLevelsOfBinaryTree().reverseOddLevels(Helper.formTree(new Integer[]{2, 3, 5, 8, 13, 21, 34})));
        System.out.println(new ReverseOddLevelsOfBinaryTree().reverseOddLevels(Helper.formTree(new Integer[]{7, 13, 11})));
        System.out.println(new ReverseOddLevelsOfBinaryTree().reverseOddLevels(Helper.formTree(new Integer[]{0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2})));
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, 1);
        return root;
    }

    private void reverse(TreeNode left, TreeNode right, Integer level) {
        if (left == null) return;
        if (level % 2 != 0 ){
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
        }
        reverse(left.left, right.right, level + 1);
        reverse(left.right, right.left, level + 1);
    }
}