package leetcode.binarytree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class LowestCommonAncestorOfDeepestLeaves {
    public static void main(String[] args) {
        System.out.println(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(
                Helper.formTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}))); // 2 7 4
        System.out.println(new LowestCommonAncestorOfDeepestLeaves().lcaDeepestLeaves(
                Helper.formTree(new Integer[]{0, 1, 3, null, 2}))); // 2
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {

        return null;
    }
}
