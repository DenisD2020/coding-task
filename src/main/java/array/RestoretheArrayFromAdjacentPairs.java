package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/
 */
public class RestoretheArrayFromAdjacentPairs { // TODO

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
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int ans[] = new int[adjacentPairs.length + 1];
        int[] edges = findEdges(adjacentPairs);
        ans[0] = edges[0];
        ans[ans.length - 1] = edges[1];

        build(adjacentPairs, ans, 1, ans.length - 1);
        return ans;
    }

    private void build(int[][] adjacentPairs, int[] ans, int left, int right) {


    }

    private int[] findEdges(int[][] adjacentPairs) {
        int[] edge = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] arr : adjacentPairs) {
            Integer k1 = map.getOrDefault(arr[0], 0);
            map.put(arr[0], ++k1);
            Integer k2 = map.getOrDefault(arr[1], 0);
            map.put(arr[1], ++k2);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (edge[0] == 0) {
                    edge[0] = entry.getKey();
                } else {
                    edge[1] = entry.getKey();
                }
            }
        }
        return edge;
    }
}
