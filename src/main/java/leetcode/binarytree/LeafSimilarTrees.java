package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {
        System.out.println(new LeafSimilarTrees().leafSimilar(Helper.formTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}),
                Helper.formTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}))); // true
        System.out.println(new LeafSimilarTrees().leafSimilar(Helper.formTree(new Integer[]{1, 2, 3}),
                Helper.formTree(new Integer[]{1, 3, 2}))); // false
        System.out.println(new LeafSimilarTrees().leafSimilar(Helper.formTree(new Integer[]{1, 2, null, 3}),
                Helper.formTree(new Integer[]{1, 3}))); // true
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> r1 = new ArrayList<>();
        List<Integer> r2 = new ArrayList<>();

        find(root1, r1);
        find(root2, r2);

        if (root1 == null && root2 == null) {
            return true;
        }
        return r1.equals(r2);
    }

    private void find(TreeNode root, List<Integer> r) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            r.add(root.val);
        } else {
            find(root.left, r);
            find(root.right, r);
        }
    }
}
