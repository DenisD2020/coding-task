package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal(Helper.formTree(new Integer[]{1,null,2,3}))); // 1,2,3
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal(Helper.formTree(new Integer[]{}))); // []
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal(Helper.formTree(new Integer[]{1}))); // [1]
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal(Helper.formTree(new Integer[]{3,1,2}))); // 3,1,2
    }

    public List<Integer> preorderTraversal(TreeNode root) { // bfs
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<TreeNode> toVisit = new Stack<TreeNode>();
        toVisit.push(root);
        while (!toVisit.isEmpty()) {
            TreeNode node = toVisit.pop();
            if (node == null) continue;
            ans.add(node.val);
            toVisit.push(node.right);
            toVisit.push(node.left);
        }
        return ans;
    }

/*    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        visit(root, ans);
        return ans;
    }

    private void visit(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        visit(root.left, ans);
        visit(root.right, ans);
    }*/
}
