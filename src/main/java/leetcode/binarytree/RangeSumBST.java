package leetcode.binarytree;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return summ(root, low, high);
    }

    private int summ(TreeNode root, int low, int high) {
        int summ = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >= low && root.val <= high) {
            summ += root.val;
        }
        if (root.val > low) {
            summ += summ(root.left, low, high);
        }
        if (root.val < high) {
            summ += summ(root.right, low, high);
        }
        return summ;
    }

}
