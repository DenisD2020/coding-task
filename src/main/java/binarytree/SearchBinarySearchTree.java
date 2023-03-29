package binarytree;

import static binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * <p>
 * 700. Search in a Binary Search Tree
 * Easy
 * 4.7K
 * 164
 * Companies
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * Example 2:
 * <p>
 * <p>
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 */
public class SearchBinarySearchTree {
    public static void main(String[] args) {
        System.out.println(new SearchBinarySearchTree().searchBST(formTree(new Integer[]{2, 1, 3, null, null, 0, 1}), 5)); // [2,1,3]
        System.out.println(new SearchBinarySearchTree().searchBST(formTree(new Integer[]{2, 1, 3, null, null, 0, 1}), 5)); // null
    }

    public TreeNode searchBST(TreeNode root, int val) {

        return null;

    }

}
