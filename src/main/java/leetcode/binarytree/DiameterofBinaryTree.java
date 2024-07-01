package leetcode.binarytree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterofBinaryTree {
    public static void main(String[] args) {
        System.out.println(new DiameterofBinaryTree().diameterOfBinaryTree(Helper.formTree(new Integer[]{1, 2, 3, 4, 5}))); // 3
        System.out.println(new DiameterofBinaryTree().diameterOfBinaryTree(Helper.formTree(new Integer[]{1, 2}))); // 1
        System.out.println(new DiameterofBinaryTree().diameterOfBinaryTree(Helper.formTree(new Integer[]{4, -7, -3, null, null,
                -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2}))); // 8
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculate(root);
        return max;
    }

    private int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = calculate(root.left);
        int r = calculate(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
