package leetcode.graph;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/min-cost-to-connect-all-points/description/
 */
public class MinCostToConnectAllPoints {

    public static void main(String[] args) {
        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(
                new int[][]{
                        new int[]{0, 0}, new int[]{2, 2}, new int[]{3, 10}, new int[]{5, 2}, new int[]{7, 0}
                }
        )); // 20

        System.out.println(new MinCostToConnectAllPoints().minCostConnectPoints(
                new int[][]{
                        new int[]{3, 12}, new int[]{-2, 5}, new int[]{-4, 1}
                }
        )); // 18
    }

    public int minCostConnectPoints(int[][] points) {

        boolean[] visited = new boolean[points.length];

        Queue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        for (int i = 1; i < points.length; i++) {
            int[] edge2 = points[i];
            int cost = Math.abs(points[0][0] - edge2[0]) + Math.abs(points[0][1] - edge2[1]);
            minHeap.add(new Edge(0, i, cost));
        }

        visited[0] = true;
        int requiredEdges = points.length - 1;
        int ans = 0;

        while (!minHeap.isEmpty() && requiredEdges > 0) {
            Edge e = minHeap.poll();
            int vertex1 = e.vertex1;
            int vertex2 = e.vertex2;
            if (visited[vertex2]) continue;
            visited[vertex2] = true;
            ans += e.cost;
            for (int i = 0; i < points.length; i++) {
                if (visited[i]) continue;
                int cost = Math.abs(points[vertex2][0] - points[i][0]) + Math.abs(points[vertex2][1] - points[i][1]);
                minHeap.add(new Edge(vertex2, i, cost));
            }
            requiredEdges--;
        }
        return ans;
    }

    static class Edge {
        int vertex1;
        int vertex2;
        int cost;

        public Edge(int vertex1, int vertex2, int cost) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.cost = cost;
        }
    }
}
