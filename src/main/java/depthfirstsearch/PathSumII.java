package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSumII {
    public static void main(String[] args) {
        System.out.println(new PathSumII().pathSum2(Helper.formTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22)); // [[5,4,11,2],[5,8,4,5]]
        System.out.println(new PathSumII().pathSum(Helper.formTree(new Integer[]{1, 2, 3}), 5)); // []
        System.out.println(new PathSumII().pathSum(Helper.formTree(new Integer[]{1, 2}), 0)); // []
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<List<Integer>> queuePath = new LinkedList<>();
        List<Integer> rootList = new ArrayList<>();
        queuePath.add(rootList);
        Queue<Integer> queueSum = new LinkedList<>();
        queueSum.add(0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            List<Integer> path = queuePath.poll();
            int val = node.val;
            path.add(val);
            Integer sum = queueSum.poll();
            sum += val;
            if (node.left == null && node.right == null && sum == targetSum) {
                ans.add(new ArrayList<>(path));
                continue;
            }
            if (node.left != null) {
                queue.add(node.left);
                queueSum.add(sum);
                queuePath.add(new ArrayList<>(path));
            }
            if (node.right != null) {
                queue.add(node.right);
                queueSum.add(sum);
                queuePath.add(new ArrayList<>(path));
            }
        }
        return ans;
    }

    public List<List<Integer>> pathSum3(TreeNode root, int targetSum) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> lst= new ArrayList<>();
        FindPath(root,targetSum,lst,result);
        return result;
    }
    private static void FindPath(TreeNode root, int targetSum,List<Integer> lst,List<List<Integer>> result){
        if(root==null ) return;
        lst.add(root.val);
        if(root.left==null && root.right==null && targetSum==root.val)
            result.add(new ArrayList<>(lst));
        FindPath(root.left,targetSum-root.val,lst,result);
        FindPath(root.right,targetSum-root.val,lst,result);
        lst.remove(lst.size()-1);
    }


    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) { // recursion
        helper(root, targetSum, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            ans.add(new ArrayList<>(path));
        }
        helper(root.left, targetSum - root.val, path);
        helper(root.right, targetSum - root.val, path);
        path.remove(path.size() - 1);
    }
}
