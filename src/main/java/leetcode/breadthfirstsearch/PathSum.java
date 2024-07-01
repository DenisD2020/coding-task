package leetcode.breadthfirstsearch;

import leetcode.binarytree.Helper;
import leetcode.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/path-sum/description/
 */
public class PathSum {
    public static void main(String[] args) {
        System.out.println(new PathSum().hasPathSum2(Helper.formTree(new Integer[]{0, 2, 8, 1, -2}), 0)); // true
        System.out.println(new PathSum().hasPathSum(Helper.formTree(new Integer[]{1}), 1)); // true
        System.out.println(new PathSum().hasPathSum(Helper.formTree(new Integer[]{1, 2}), 1)); // false
        System.out.println(new PathSum().hasPathSum(Helper.formTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22)); // true
        System.out.println(new PathSum().hasPathSum(Helper.formTree(new Integer[]{1, 2, 3}), 5)); // false
        System.out.println(new PathSum().hasPathSum(Helper.formTree(new Integer[]{}), 0)); // false
    }

    public boolean hasPathSum(TreeNode root, int targetSum) { // TODO add recursion solution
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<Integer> queueSum = new LinkedList<>();
        queueSum.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            Integer sum = queueSum.poll();
            sum += node.val;
            if (node.left == null && node.right == null && sum == targetSum) return true;

            if (node.left != null) {
                queue.add(node.left);
                queueSum.add(sum);
            }

            if (node.right != null) {
                queue.add(node.right);
                queueSum.add(sum);
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) { // recursion
        if (root == null) {
            return false;
        }
        if (targetSum - root.val == 0) {
            return true;
        }
        return hasPathSum2(root.left, targetSum - root.val) || hasPathSum2(root.right, targetSum - root.val);
    }

}
