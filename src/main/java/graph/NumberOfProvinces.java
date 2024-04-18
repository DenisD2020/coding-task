package graph;

import java.util.*;

/**
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        })); // 2
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        })); // 3
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{
                {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}
        })); // 1
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        int connection = 0;
        // bfs
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < adj.size(); i++) {
            if (!visited.add(i)) continue;
            bfs.add(i);
            connection++;

            while (!bfs.isEmpty()) {
                Integer component = bfs.poll();
                List<Integer> connections = adj.get(component);
                for (Integer con : connections) {
                    if (!visited.add(con)) continue;
                    bfs.add(con);
                }
            }
        }
        return connection;
    }
}
