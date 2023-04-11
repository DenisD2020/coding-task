package binarytree;

import java.util.ArrayList;
import java.util.List;

import static binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 * 897. Increasing Order Search Tree
 * Easy
 * 3.9K
 * 647
 * Companies
 * Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [5,1,7]
 * Output: [1,null,5,null,7]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 100].
 * 0 <= Node.val <= 1000
 */
public class IncreasingOrderSearchTree {

    private TreeNode node = new TreeNode();

    public static void main(String[] args) {
        System.out.println(new IncreasingOrderSearchTree().increasingBST(formTree(new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9}))); // 1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9
        System.out.println(new IncreasingOrderSearchTree().increasingBST(formTree(new Integer[]{5, 1, 7}))); // 1,null,5,null,7
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        getValue(root, values);

        TreeNode rootRes = new TreeNode(values.get(0));
        var temp = rootRes;
        for (int i = 1; i < values.size(); i++) {
            temp.right = new TreeNode(values.get(i));
            temp = temp.right;
        }
        return rootRes;
    }

    private void getValue(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        getValue(root.left, values);
        values.add(root.val);
        getValue(root.right, values);
    }
}
