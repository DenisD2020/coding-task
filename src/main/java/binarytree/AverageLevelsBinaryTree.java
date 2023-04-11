package binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static binarytree.Helper.formTree;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * <p>
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 * Example 2:
 * <p>
 * Input: root = [3,9,20,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class AverageLevelsBinaryTree {
    double[] res = new double[100];

    Map<Integer, List<Integer>> answerMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new AverageLevelsBinaryTree().averageOfLevels(formTree(new Integer[]{3, 9, 20, 15, 7}))); // [3, 14.5, 11]
        System.out.println(new AverageLevelsBinaryTree().averageOfLevels(formTree(new Integer[]{3, 9, 20, null, null, 15, 7}))); // [3, 14.5, 11]
    }

    public List<Double> averageOfLevels(TreeNode root) {
        calculate(root, 0);
        List<Double> answer = new ArrayList<>();
        for (Integer key : answerMap.keySet()) {
            answer.add(answerMap.get(key).stream()
                    .mapToDouble(a -> a)
                    .average()
                    .getAsDouble());
        }
        return answer;
    }

    private void calculate(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        List<Integer> values = answerMap.getOrDefault(level, new ArrayList<>());
        values.add(root.val);
        answerMap.put(level, values);

        calculate(root.left, level + 1);
        calculate(root.right, level + 1);
    }
}
