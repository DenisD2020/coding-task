package leetcode.breadthfirstsearch;

import leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Info {

    public void breadth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); // queue follows a FIFO (First In First Out)
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val + " "); // visit
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
