package binarytree;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
 */
public class BinarySearchTreeToGreaterSumTree {

    public static void main(String[] args) {
        new BinarySearchTreeToGreaterSumTree().bstToGst(Helper.formTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8})); // [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
    }

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return root;
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}
