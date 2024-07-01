package leetcode.breadthfirstsearch;

import leetcode.binarytree.Helper;
import leetcode.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */
public class CountGoodNodesInBinaryTree {

    public static void main(String[] args) {
        System.out.println(new CountGoodNodesInBinaryTree().goodNodes(Helper.formTree(new Integer[]{3, 1, 4, 3, null, 1, 5}))); // 4
        System.out.println(new CountGoodNodesInBinaryTree().goodNodes(Helper.formTree(new Integer[]{3, 3, null, 4, 2}))); // 3
    }

    public int goodNodes(TreeNode root) { // recursion
        return count(root, root.val);
    }

    private int count(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int localMax = Math.max(root.val, max);
        return (root.val >= max ? 1 : 0) + count(root.left, localMax) + count(root.right, localMax);
    }

    public int goodNodes2(TreeNode root) { // to slow
        int ans = 0;

        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> maxVal = new LinkedList<>();
        nodes.offer(root);
        maxVal.add(root.val);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            int val = node.val;
            Integer max = Math.max(maxVal.poll(), val);

            if (val >= max) {
                ans++;
            }

            if (node.left != null) {
                nodes.offer(node.left);
                maxVal.offer(max);
            }
            if (node.right != null) {
                nodes.offer(node.right);
                maxVal.offer(max);
            }
        }
        return ans;
    }
}
