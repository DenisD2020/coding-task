package binarytree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
 */
public class MinimumDistanceBetweenBSTNodes {
    public static void main(String[] args) {
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST2(Helper.formTree(new Integer[]{4, 2, 6, 1, 3}))); // 1
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(Helper.formTree(new Integer[]{4, 2, 6, 1, 3}))); // 1
//        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(Helper.formTree(new Integer[]{1, 0, 48, null, null, 12, 49}))); // 1
//        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(Helper.formTree(new Integer[]{27, null, 34, null, 58, 50, null, 44}))); // 6
//        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(Helper.formTree(new Integer[]{90, 69, null, 49, 89, null, 52}))); // 1
    }


    int ans = Integer.MAX_VALUE;
    TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root != null) {
            minDiffInBST(root.left);
            if (pre != null) {
                ans = Math.min(ans, root.val - pre.val);
            }
            pre = root;
            minDiffInBST(root.right);
        }
        return ans;
    }

    public int minDiffInBST2(TreeNode root) { // dfs without recursion
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode top = stack.pop();
            if (pre != null) {
                ans = Math.min(ans, top.val - pre.val);
            }
            pre = top;
            current = top.right;
        }
        return ans;
    }


    // 2 ms too slow

/*    private Set<Integer> set = new TreeSet<>();

    public int minDiffInBST(TreeNode root) {
        int ans = Integer.MAX_VALUE;

        buildArr(root);

        int prev = Integer.MAX_VALUE;
        for(Integer i : set) {
            ans = Math.min(ans, Math.abs(prev - i));
            prev = i;
        }
        return ans;
    }

    private void buildArr(TreeNode root) {
        if (root == null) {
            return;
        }
        set.add(root.val);
        buildArr(root.left);
        buildArr(root.right);
    }*/


}
