package leetcode.binarytree;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 * <p>
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
public class DeepestLeavesSum { 
    public static void main(String[] args) {
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(Helper.formTree(new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8}))); // 15
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(Helper.formTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5}))); // 19
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(Helper.formTree(new Integer[]{2}))); //
    }

    private int maxDepth = 0;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        sum = root.val;
        findLeaves(root.left, 1);
        findLeaves(root.right, 1);
        return sum;
    }

    private void findLeaves(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > maxDepth) {
            sum = root.val;
            maxDepth = depth;
        } else if (depth == maxDepth) {
            sum += root.val;
        }
        findLeaves(root.left, depth + 1);
        findLeaves(root.right, depth + 1);
    }
}
