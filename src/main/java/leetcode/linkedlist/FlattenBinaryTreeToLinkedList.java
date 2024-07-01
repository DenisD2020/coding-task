package leetcode.linkedlist;

import leetcode.binarytree.Helper;
import leetcode.binarytree.TreeNode;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 */
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        new FlattenBinaryTreeToLinkedList().flatten(leetcode.binarytree.Helper.formTree(new Integer[]{1, 2, 5, 3, 4, null, 6})); // 1,null,2,null,3,null,4,null,5,null,6
        new FlattenBinaryTreeToLinkedList().flatten(Helper.formTree(new Integer[]{0})); // 0
    }

    public void flatten(TreeNode root) {

        TreeNode right = root.right;
        solve(root, root);
    }

    private void solve(TreeNode src, TreeNode dest) {


    }

/*    public void flatten(TreeNode root) {
        if (root == null) return;
        ArrayList<Integer> list = new ArrayList<>();
        visit(root, list);
        root.left = null;
        TreeNode current = root;
        for (int i = 0; i < list.size() - 1; i++) {
            current.right = new TreeNode(list.get(i + 1));
            current = current.right;
        }
    }

    private void visit(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        visit(root.left, list);
        visit(root.right, list);
    }*/
}
