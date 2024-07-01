package leetcode.depthfirstsearch;

import leetcode.binarytree.Helper;
import leetcode.binarytree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-tilt/description/
 */

public class BinaryTreeTilt {


    public static void main(String[] args) {
        System.out.println(new BinaryTreeTilt().findTilt(Helper.formTree(new Integer[]{1, 2, 3}))); // 1
        System.out.println(new BinaryTreeTilt().findTilt(Helper.formTree(new Integer[]{4, 2, 9, 3, 5, null, 7}))); // 15
    }

    private int sum = 0;

    public int findTilt(TreeNode root) {
        sum = 0;
        calculate(root);
        return sum;

    }

    private int calculate(TreeNode root) {
        if (root == null) return 0;
        int left = calculate(root.left);
        int right = calculate(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
