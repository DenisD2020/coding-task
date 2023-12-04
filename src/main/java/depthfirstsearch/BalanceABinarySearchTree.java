package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/description/
 */
public class BalanceABinarySearchTree {
    public static void main(String[] args) {
        System.out.println(new BalanceABinarySearchTree().balanceBST(Helper.formTree(new Integer[]{1, null, 2, null, 3, null, 4, null, null}))); // [2,1,3,null,null,null,4] or [3,1,4,null,2]
        System.out.println(new BalanceABinarySearchTree().balanceBST(Helper.formTree(new Integer[]{2, 1, 3}))); // 2,1,3
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> tree = new ArrayList<>();
        buildList(root, tree);
        return buildBalancedTree(tree, 0, tree.size() - 1);
    }

    private TreeNode buildBalancedTree(ArrayList<Integer> tree, int start, int finish) {
        int middle = (finish + start) / 2;
        if (start > finish) return null;
        TreeNode node = new TreeNode(tree.get(middle));
        node.left = buildBalancedTree(tree, start, middle - 1);
        node.right = buildBalancedTree(tree, middle + 1, finish);
        return node;
    }

    private void buildList(TreeNode root, ArrayList<Integer> tree) {
        if (root == null) return;
        buildList(root.left, tree);
        tree.add(root.val);
        buildList(root.right, tree);
    }
}
