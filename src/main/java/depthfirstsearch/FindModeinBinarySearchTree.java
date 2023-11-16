package depthfirstsearch;

import binarytree.Helper;
import binarytree.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/description/
 */
public class FindModeinBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindModeinBinarySearchTree().findMode(Helper.formTree(new Integer[]{1, null, 2, 2})))); // [2]
        System.out.println(Arrays.toString(new FindModeinBinarySearchTree().findMode(Helper.formTree(new Integer[]{0})))); // [0]
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        find(root);
        int maxFreq = 0;
        for (int freq : map.values()){
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == maxFreq) {
                ans.add(entry.getKey());
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    private void find(TreeNode root) { // dfs
        if (root == null) return;
        map.compute(root.val, (k, v) -> v == null ? 0 : ++v);
        find(root.left);
        find(root.right);
    }
}
