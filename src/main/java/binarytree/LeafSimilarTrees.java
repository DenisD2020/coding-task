package binarytree;

import java.util.ArrayList;
import java.util.List;

import static binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {

    List<Integer> r1 = new ArrayList<>();
    List<Integer> r2 = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(new LeafSimilarTrees().leafSimilar(formTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}),
                formTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8}))); // true
        System.out.println(new LeafSimilarTrees().leafSimilar(formTree(new Integer[]{1, 2, 3}),
                formTree(new Integer[]{1, 3, 2}))); // false
        System.out.println(new LeafSimilarTrees().leafSimilar(formTree(new Integer[]{1, 2, null, 3}),
                formTree(new Integer[]{1, 3}))); // true
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }


        if (root1 != null) {
            if (isLeaf(root1)) {
                r1.add(root1.val);
            }
            leafSimilar(root1.left, root2.left);
        }

        if (root2 != null) {
            if (isLeaf(root2)) {
                r2.add(root2.val);
                leafSimilar(root2.left, root2.right);
            }
        }
        return r1.equals(r2);
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
