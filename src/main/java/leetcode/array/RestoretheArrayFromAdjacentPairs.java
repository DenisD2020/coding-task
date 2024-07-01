package leetcode.array;

import java.util.*;

/**
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/
 */
public class RestoretheArrayFromAdjacentPairs {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RestoretheArrayFromAdjacentPairs().restoreArray(new int[][]{
                new int[]{2, 1},
                new int[]{3, 4},
                new int[]{3, 2}
        }))); // [1,2,3,4]

        System.out.println(Arrays.toString(new RestoretheArrayFromAdjacentPairs().restoreArray(new int[][]{
                new int[]{4, -2},
                new int[]{1, 4},
                new int[]{-3, 1}
        }))); // [-2,4,1,-3]

        System.out.println(Arrays.toString(new RestoretheArrayFromAdjacentPairs().restoreArray(new int[][]{
                new int[]{4, -10},
                new int[]{-1, 3},
                new int[]{4, -3},
                new int[]{-3, 3}
        }))); // [-10,4,-3,3,-1]  [-1,3,-3,4,-10]
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int[] ans = new int[adjacentPairs.length + 1];

        // build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] arr : adjacentPairs) {
            int key1 = arr[0];
            int key2 = arr[1];
            List<Integer> l1 = graph.computeIfAbsent(key1, k -> new ArrayList<>());
            l1.add(arr[1]);
            List<Integer> l2 = graph.computeIfAbsent(key2, k -> new ArrayList<>());
            l2.add(arr[0]);
        }

        // find Edge
        Map.Entry<Integer, List<Integer>> entryEdge = null;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                entryEdge = entry;
                break;
            }
        }
        ans[0] = entryEdge.getKey();
        ans[1] = entryEdge.getValue().get(0);
        graph.get(ans[1]).remove((Integer) ans[0]);
        graph.remove(entryEdge.getKey());

        // fill arr
        for (int i = 2; i < adjacentPairs.length + 1; i++) {
            List<Integer> list = graph.get(ans[i - 1]);
            ans[i] = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            graph.get(ans[i]).remove((Integer) ans[i - 1]);
        }
        return ans;
    }
}
