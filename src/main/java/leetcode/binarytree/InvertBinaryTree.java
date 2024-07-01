package leetcode.binarytree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * <p>
 * 226. Invert Binary Tree
 * Easy
 * 11.9K
 * 168
 * Companies
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class InvertBinaryTree {

    private TreeNode tmp = null;


    public static void main(String[] args) {
        System.out.println(new InvertBinaryTree().invertTree(Helper.formTree(new Integer[]{4, 2, 7, 1, 3, 6, 9}))); // 4,7,2,9,6,3,1
        System.out.println(new InvertBinaryTree().invertTree(Helper.formTree(new Integer[]{2, 1, 3}))); // 2,3,1
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        var left = invertTree(root.left);
        var right = invertTree(root.right);
        root.left = right;
        root.right = left;
/*        if (root != null) {

            if (root.left != null) {
                invertTree(root.left);
            }

            if (root.right != null) {
                invertTree(root.right);
            }
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }*/
        return root;
    }
}
