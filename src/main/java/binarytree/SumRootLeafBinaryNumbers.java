package binarytree;

import static binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 * <p>
 * You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
 * <p>
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
 * For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
 * <p>
 * The test cases are generated so that the answer fits in a 32-bits integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,0,1,0,1,0,1]
 * Output: 22
 * Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * Example 2:
 * <p>
 * Input: root = [0]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000].
 * Node.val is 0 or 1.
 */
public class SumRootLeafBinaryNumbers {

    int res = 0;

    public static void main(String[] args) {
//        System.out.println(new SumRootLeafBinaryNumbers().sumRootToLeaf(formTree(new Integer[]{1, 0, 1, 0, 1, 0, 1}))); // 22
//        System.out.println(new SumRootLeafBinaryNumbers().sumRootToLeaf(formTree(new Integer[]{0}))); // 0
        System.out.println(new SumRootLeafBinaryNumbers().sumRootToLeaf(formTree(new Integer[]{1, 1}))); // 3
    }

    public int sumRootToLeaf(TreeNode root) {
        sumRootToLeafStr(root, "");
        return res;
    }

    public void sumRootToLeafStr(TreeNode root, String s) {
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(s + root.val, 2);
            return;
        }
        s = s + root.val;
        if (root.left != null) sumRootToLeafStr(root.left, s);
        if (root.right != null) sumRootToLeafStr(root.right, s);
    }
}
