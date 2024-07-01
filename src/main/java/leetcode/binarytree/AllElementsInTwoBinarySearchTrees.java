package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-elements-in-two-binary-search-trees/description/
 */
public class AllElementsInTwoBinarySearchTrees {
    public static void main(String[] args) {

        System.out.println(new AllElementsInTwoBinarySearchTrees().getAllElements(
                Helper.formTree(new Integer[]{2, 1, 4}),
                Helper.formTree(new Integer[]{1, 0, 3}))); // [0,1,1,2,3,4]

        System.out.println(new AllElementsInTwoBinarySearchTrees().getAllElements(
                Helper.formTree(new Integer[]{1, null, 8}),
                Helper.formTree(new Integer[]{8, 1}))); // 1,1,8,8
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) { // Postorder
        Deque<Integer> qRoot1 = new LinkedList<>();
        postorder(root1, qRoot1);

        Deque<Integer> qRoot2 = new LinkedList<>();
        postorder(root2, qRoot2);

        ArrayList<Integer> ans = new ArrayList<>();

        while (!qRoot1.isEmpty() || !qRoot2.isEmpty()) {

            Integer peek1 = qRoot1.peek();
            Integer peek2 = qRoot2.peek();

            if (peek1 == null) {
                ans.add(qRoot2.pop());
            } else if (peek2 == null) {
                ans.add(qRoot1.pop());
            } else if (peek1 > peek2) {
                ans.add(qRoot2.pop());
            } else {
                ans.add(qRoot1.pop());
            }
        }
        return ans;
    }

    private void postorder(TreeNode root, Deque<Integer> qRoot) {
        if (root == null) return;
        postorder(root.left, qRoot);
        qRoot.add(root.val);
        postorder(root.right, qRoot);
    }
}
