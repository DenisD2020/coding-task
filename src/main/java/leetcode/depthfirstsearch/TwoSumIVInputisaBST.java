package leetcode.depthfirstsearch;

import leetcode.binarytree.Helper;
import leetcode.binarytree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class TwoSumIVInputisaBST {

    public static void main(String[] args) {
        System.out.println(new TwoSumIVInputisaBST().findTarget(Helper.formTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 9)); // true
        System.out.println(new TwoSumIVInputisaBST().findTarget(Helper.formTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 28)); // false
        System.out.println(new TwoSumIVInputisaBST().findTarget(Helper.formTree(new Integer[]{2, null, 3}), 6)); // false
        System.out.println(new TwoSumIVInputisaBST().findTarget(Helper.formTree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 9)); // true
    }

    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    /*
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (set.contains(k - node.val)) return true;
            set.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return false;
    }
     **/
}
