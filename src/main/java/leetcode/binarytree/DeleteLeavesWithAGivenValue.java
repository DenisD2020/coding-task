package leetcode.binarytree;

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/description/
 */
public class DeleteLeavesWithAGivenValue {

    public static void main(String[] args) {
        System.out.println(new DeleteLeavesWithAGivenValue().removeLeafNodes(Helper.formTree(new Integer[]{1, 2, 3, 2, null, 2, 4}), 2)); // [1,null,3,null,4]
        System.out.println(new DeleteLeavesWithAGivenValue().removeLeafNodes(Helper.formTree(new Integer[]{1, 3, 3, 3, 2}), 3)); // [1,3,null,null,2]
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) { // Postorder Traversal
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}