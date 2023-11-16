package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{
                new int[]{1, 2},
                new int[]{3},
                new int[]{3},
                new int[]{}
        })); // [[0,1,3],[0,2,3]]

        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{
                new int[]{4, 3, 1},
                new int[]{3, 2, 4},
                new int[]{3},
                new int[]{4},
                new int[]{},
        })); // [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]*/
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] data) {
        int length = data.length;
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Stack<List<Integer>> lists = new Stack<>();
        lists.push(new ArrayList<>());

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            List<Integer> list = lists.pop();
            list.add(node);
            if (node == length - 1) {
                ans.add(list);
            }
            int[] nodes = data[node];
            for (int i : nodes) {
                stack.push(i);
                lists.push(new ArrayList<>(list));
            }
        }
        return ans;
    }

    /**
    public List<List<Integer>> allPathsSourceTarget(int[][] data) {
        Graph graph = new Graph();
        int length = data.length;
        for (int i = 0; i < length; i++) {
            graph.addNode(i);
            graph.addEdges(i, data[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Stack<List<Integer>> lists = new Stack<>();
        lists.push(new ArrayList<>());

        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            List<Integer> list = lists.pop();
            list.add(node);
            if (node == length - 1) {
                res.add(list);
            }
            List<Integer> nodes = graph.getNodes(node);
            for (Integer i : nodes) {
                stack.push(i);
                lists.push(new ArrayList<>(list));
            }
        }
        return res;
    }

    static class Graph {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        void addNode(Integer node) {
            adjList.putIfAbsent(node, new ArrayList<>());
        }

        void addEdges(Integer node, int[] edges) {
            List<Integer> _node = adjList.get(node);
            _node.addAll(Arrays.stream(edges).boxed().collect(Collectors.toList()));
        }

        List<Integer> getNodes(Integer node) {
            return adjList.get(node);
        }
    }
     **/
}
