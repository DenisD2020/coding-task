package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/description/?envType=daily-question&envId=2023-12-08
 */
public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        System.out.println(new ConstructStringFromBinaryTree().tree2str(Helper.formTree(new Integer[]{1, 2, 3, 4}))); // 1(2(4))(3)
        System.out.println(new ConstructStringFromBinaryTree().tree2str(Helper.formTree(new Integer[]{1, 2, 3, null, 4}))); // 1(2(4))(3)
    }

    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        helper(root, ans);
        return ans.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            helper(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            helper(root.right, sb);
            sb.append(")");
        }
    }
}
