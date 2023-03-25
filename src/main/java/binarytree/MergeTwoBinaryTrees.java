package binarytree;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {
        new MergeTwoBinaryTrees().mergeTrees(form(new TreeNode(1), 0, new Integer[]{1, 3, 2, 5}), form(new TreeNode(2), 0, new Integer[]{2, 1, 3, null, 4, null, 7}));
        new MergeTwoBinaryTrees().mergeTrees(new TreeNode(), new TreeNode());
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode formTree(Integer[] data) {
        TreeNode root = new TreeNode(data[0]);
        form(root, 0, data);
        return root;
    }

    private static TreeNode form(TreeNode root, int rootIndex, Integer[] data) {
        int n = data.length;

        int leftIndex = 2 * rootIndex + 1;
        if (leftIndex < n && data[leftIndex] != null) {
            root.left = new TreeNode(data[leftIndex]);
            form(root.left, leftIndex, data);
        }

        int rightIndex = 2 * rootIndex + 2;
        if (rightIndex < n && data[rightIndex] != null) {
            root.right = new TreeNode(data[rightIndex]);
            form(root.right, rightIndex, data);
        }
        return root;
    }

}
