package binarytree;

import java.util.ArrayList;
import java.util.List;

import static binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 */
public class BinaryTreePostorderTraversal {

    List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(formTree(new Integer[]{1, null, 2, 3}))); // 3,2,1
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(formTree(new Integer[]{1}))); // [1]
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal(new TreeNode())); // []
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
