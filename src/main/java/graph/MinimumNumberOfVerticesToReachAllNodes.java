package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class MinimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(
                6, List.of(
                        List.of(0, 1),
                        List.of(0, 2),
                        List.of(2, 5),
                        List.of(3, 4),
                        List.of(4, 2)
                )
        )); // 0,3
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] nodes = new int[n];
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> edge : edges) {
            nodes[edge.get(1)] = 1;
        }

        for(int i =0; i < nodes.length; i++){
            if (nodes[i] == 0) ans.add(i);
        }
        return ans;
    }
}
