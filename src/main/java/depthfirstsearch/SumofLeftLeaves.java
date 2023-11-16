package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 */
public class SumofLeftLeaves {

    public static void main(String[] args) {
        System.out.println(new SumofLeftLeaves().sumOfLeftLeaves(Helper.formTree(new Integer[]{3, 9, 20, null, null, 15, 7}))); // 9+15=24
        System.out.println(new SumofLeftLeaves().sumOfLeftLeaves(Helper.formTree(new Integer[]{1}))); // 0
        System.out.println(new SumofLeftLeaves().sumOfLeftLeaves(Helper.formTree(new Integer[]{1, 2, 3, 4, 5}))); // 4
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    int summ = 0;

/*    public int sumOfLeftLeaves(TreeNode root) {
        visit(root);
        return summ;
    }

    private void visit(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            summ += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
    }*/
}
