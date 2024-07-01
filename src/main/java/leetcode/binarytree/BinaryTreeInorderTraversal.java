package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: [1]
 */
public class BinaryTreeInorderTraversal {

    List<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(Helper.formTree(new Integer[]{1, null, 2, 3}))); // 1,3,2
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(Helper.formTree(new Integer[]{}))); // []
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(Helper.formTree(new Integer[]{1}))); // [1]
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
