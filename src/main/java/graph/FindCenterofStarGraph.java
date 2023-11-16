package graph;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/find-center-of-star-graph/description/
 */
public class FindCenterofStarGraph {

    public static void main(String[] args) {
        System.out.println(new FindCenterofStarGraph().findCenter(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{4, 2},
        })); // 2

        System.out.println(new FindCenterofStarGraph().findCenter(new int[][]{
                new int[]{1, 2},
                new int[]{5, 1},
                new int[]{1, 3},
                new int[]{1, 4}, // 1
        }));
    }

    public int findCenter(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
