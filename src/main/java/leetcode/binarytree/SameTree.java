package leetcode.binarytree;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree(Helper.formTree(new Integer[]{1, 2, 3}), Helper.formTree(new Integer[]{1, 2, 3}))); // true
        System.out.println(new SameTree().isSameTree(Helper.formTree(new Integer[]{1, 2}), Helper.formTree(new Integer[]{1, null, 2}))); // false
    }

/*    public boolean isSameTree(TreeNode p, TreeNode q) { // dfs
        Stack<TreeNode> ps = new Stack<>();
        ps.add(p);
        Stack<TreeNode> qs = new Stack<>();
        qs.add(q);

        while (!ps.isEmpty()) {
            TreeNode psNode = ps.pop();
            TreeNode qsNode = qs.pop();

            if (psNode == null && qsNode != null || psNode != null && qsNode == null) {
                return false;
            } else if (psNode == null){
                continue;
            } else if (psNode.val != qsNode.val) {
                return false;
            }
            ps.add(psNode.left);
            ps.add(psNode.right);
            qs.add(qsNode.left);
            qs.add(qsNode.right);
        }
        return true;
    }*/

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        } else if (p == null) {
            return true;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
