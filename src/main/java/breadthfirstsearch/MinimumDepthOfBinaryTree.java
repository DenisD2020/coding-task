package breadthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(Helper.formTree(new Integer[]{1, 2, 3, 4, 5}))); // 2
//        System.out.println(new MinimumDepthOfBinaryTree().minDepth(Helper.formTree(new Integer[]{3, 9, 20, null, null, 15, 7}))); // 2
//        System.out.println(new MinimumDepthOfBinaryTree().minDepth(Helper.formTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6}))); // 5
    }

    public int minDepth(TreeNode root) {
        int ans = Integer.MAX_VALUE;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();
        depthQ.offer(1);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer depth = depthQ.poll();
            if (node.left == null && node.right == null) {
                ans = depth;
                break;
            }
            if (node.left != null) {
                queue.offer(node.left);
                depthQ.offer(depth + 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                depthQ.offer(depth + 1);
            }
        }
        return ans;
    }
}
