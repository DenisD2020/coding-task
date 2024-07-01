package leetcode.binarytree;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RootEqualsSumChildren {

    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }

}
