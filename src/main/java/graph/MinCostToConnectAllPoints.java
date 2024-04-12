package graph;

import java.util.ArrayList;
import java.util.List;

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
        List<Vertex> verticesTo = new ArrayList<>();
        int[][] paths = new int[points.length][points.length];
        for (int[] point : points) {
            verticesTo.add(new Vertex(point[0], point[1]));
        }
        List<Vertex> verticesFrom = new ArrayList<>();
        verticesFrom.add(verticesTo.get(verticesTo.size() - 1));
        verticesTo.remove(verticesTo.size() - 1);
        int ans = 0;
        while (verticesFrom.size() != points.length) {
            Integer minIndex = null;
            int minCoast = Integer.MAX_VALUE;
            for (int j = 0; j < verticesFrom.size(); j++) {
                Vertex vertexFrom = verticesFrom.get(j);
                for (int i = 0; i < verticesTo.size(); i++) {
                    Vertex vertexTo = verticesTo.get(i);
                    int cost = paths[j][i];
                    if (cost == 0) {
                        cost = Math.abs(vertexFrom.x - vertexTo.x) + Math.abs(vertexFrom.y - vertexTo.y);
                        paths[j][i] = cost;
                    }
                    if (minCoast > cost) {
                        minCoast = cost;
                        minIndex = i;
                    }
                }
            }
            verticesFrom.add(verticesTo.get(minIndex));
            verticesTo.remove((int) minIndex);
            ans += minCoast;
        }
        return ans;
    }

    static class Vertex {
        int x;
        int y;

        public Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
