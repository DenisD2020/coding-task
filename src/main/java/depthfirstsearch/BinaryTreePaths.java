package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        System.out.println(new BinaryTreePaths().binaryTreePaths(Helper.formTree(new Integer[]{1, 2, 3, null, 5})));
        System.out.println(new BinaryTreePaths().binaryTreePaths(Helper.formTree(new Integer[]{1})));
    }

    public List<String> binaryTreePaths(TreeNode root) { // dfs
        ArrayList<String> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<StringBuilder> pathStack = new Stack<>();
        pathStack.push(new StringBuilder());

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            StringBuilder builder = pathStack.pop();
            builder.append(node.val);

            if (node.left == null && node.right == null) {
                ans.add(builder.toString());
            }
            builder.append("->");

            if (node.left != null) {
                pathStack.push(new StringBuilder(builder.toString()));
                stack.push(node.left);
            }
            if (node.right != null) {
                pathStack.push(new StringBuilder(builder.toString()));
                stack.push(node.right);
            }
        }
        return ans;
    }

    /*
   public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        visit(root, new StringBuilder(), ans);
        return ans;
    }

    void visit(TreeNode root, StringBuilder path, List<String> ans) {
        path.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(path.toString());
            return;
        }
        path.append("->");
        if (root.left != null) {
            visit(root.left, new StringBuilder(path), ans);
        }
        if (root.right != null) {
            visit(root.right, new StringBuilder(path), ans);
        }
    }
     */
}
