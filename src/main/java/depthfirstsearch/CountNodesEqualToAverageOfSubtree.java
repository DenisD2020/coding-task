package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

/**
 * https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
 */
public class CountNodesEqualToAverageOfSubtree { // TODO

    public static void main(String[] args) {
        System.out.println(new CountNodesEqualToAverageOfSubtree().averageOfSubtree(Helper.formTree(new Integer[]{1, null, 3, null, 1, null, 3}))); // 1
        System.out.println(new CountNodesEqualToAverageOfSubtree().averageOfSubtree(Helper.formTree(new Integer[]{4, 8, 5, 0, 1, null, 6}))); // 5
    }

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return ans;
    }

    private Pair postOrder(TreeNode root) {
        if (root == null) return new Pair(0, 0);

        Pair pairLeft = postOrder(root.left);
        Pair pairRight = postOrder(root.right);

        int count = pairLeft.count + pairRight.count + 1;
        int sum = pairLeft.sum + pairRight.sum + root.val;

        if (sum / count == root.val) ans++;

        return new Pair(sum, count);
    }

    private static class Pair {
        int sum, count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
}
