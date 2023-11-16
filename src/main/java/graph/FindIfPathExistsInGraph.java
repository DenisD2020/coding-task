package graph;

import java.util.*;

/**
 * https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */
public class FindIfPathExistsInGraph {
    public static void main(String[] args) {
        System.out.println(new FindIfPathExistsInGraph().validPath(3, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 0}
        }, 0, 2));

        System.out.println(new FindIfPathExistsInGraph().validPath(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{3, 5},
                new int[]{5, 4},
                new int[]{4, 3},
        }, 0, 5));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1) return true;
        Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            graph.addNode(i);
        }
        for (int[] edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }
        return depthFirstTraversal(graph, source, destination);
    }

    boolean depthFirstTraversal(Graph graph, Integer source, Integer destination) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Integer v : graph.getAdjNodes(node)) {
                    if (v.equals(destination)) return true;
                    stack.push(v);
                }
            }
        }
        return false;
    }

    static class Graph {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        void addNode(Integer node) {
            adjList.putIfAbsent(node, new ArrayList<>());
        }

        void addEdge(Integer node1, Integer node2) {
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }

        List<Integer> getAdjNodes(Integer node) {
            return adjList.get(node);
        }
    }
}
