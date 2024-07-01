package leetcode.binarytree;

import static leetcode.binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        new MergeTwoBinaryTrees().mergeTrees(formTree(new Integer[]{1, 3, 2, 5}), formTree(new Integer[]{2, 1, 3, null, 4, null, 7}));
        new MergeTwoBinaryTrees().mergeTrees(new TreeNode(), new TreeNode());
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
