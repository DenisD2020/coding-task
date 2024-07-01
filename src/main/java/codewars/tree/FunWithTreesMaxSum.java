package codewars.tree;


/**
 * https://www.codewars.com/kata/57e5279b7cf1aea5cf000359/train/java
 */
public class FunWithTreesMaxSum {

    public static void main(String[] args) {
        /*
         *         5
         *      /      \
         *     4        10
         *   /   \      /
         * -80  -60  -90
         */
        System.out.println(maxSum(Helper.formTree(new Integer[]{5, 4, 10, -80, -60, -90}))); // -51
        System.out.println(maxSum(Helper.formTree(new Integer[]{17}))); // 17
        System.out.println(maxSum(Helper.formTree(new Integer[]{1, 2}))); // 3
    }

    static Integer ans;

    static int maxSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) {
            return root.value + maxSum(root.right);
        }
        if (root.right == null) {
            return root.value + maxSum(root.left);
        }
        return root.value + Math.max(maxSum(root.left), maxSum(root.right));
    }


/*    static int maxSum(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int ans = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            System.out.println(node.value);
        }
        return ans;
    }*/
}
