package leetcode.binarytree;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {

    public static void main(String[] args) {
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5})); // [6,3,5,null,2,0,null,null,1]
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1})); // [3,null,2,null,1]
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int midle = findRootNode(nums, 0, nums.length);
        TreeNode node = new TreeNode(nums[midle]);
        node.left = buildNodes(nums, 0, midle);
        node.right = buildNodes(nums, midle + 1, nums.length);
        return node;
    }

    private TreeNode buildNodes(int[] nums, int from, int to) {
        if (from == to) {return null;}
        int midle = findRootNode(nums, from, to);
        TreeNode node = new TreeNode(nums[midle]);
        node.left = buildNodes(nums, from, midle);
        node.right = buildNodes(nums, midle + 1, to);
        return node;
    }


    private int findRootNode(int[] nums, int from, int to) {
        int index = from;
        for (int i = from ; i < to; i++){
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }
}
