package breadthfirstsearch;

import java.util.*;

/**
 * https://leetcode.com/problems/keys-and-rooms/description/
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        System.out.println(new KeysAndRooms().canVisitAllRooms(
                List.of(
                        List.of(2),
                        List.of(0),
                        List.of(1)
                )
        )); // true

        System.out.println(new KeysAndRooms().canVisitAllRooms(
                List.of(
                        List.of(1),
                        List.of(2),
                        List.of(3),
                        List.of()
                )
        )); // true

        System.out.println(new KeysAndRooms().canVisitAllRooms(
                List.of(
                        List.of(1, 3),
                        List.of(3, 0, 1),
                        List.of(2),
                        List.of(0)
                )
        )); // false
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) { // dfs 2ms
        boolean ans = true;

        int[] visited = new int[rooms.size()];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            Integer room = stack.pop();
            visited[room] = 1;
            for (int r : rooms.get(room)) {
                if (visited[r] == 0) {
                    stack.add(r);
                }
            }
        }

        for (int isVisited: visited) {
            if (isVisited == 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    // bfs with graph
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) { // too slow
        Graph graph = new Graph();
        for (int i = 0; i < rooms.size(); i++) {
            graph.addEdge(i, rooms.get(i));
        }

        Set<Integer> visited = new HashSet<>();

        Set<Integer> keys = new HashSet<>();
        keys.add(0);

        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(0);

        while (!nodes.isEmpty()) {
            Integer node = nodes.poll();
            visited.add(node);
            if (!keys.contains(node)) {
                return false;
            }
            List<Integer> nextNode = graph.getNode(node);
            nextNode.removeAll(visited);
            keys.addAll(nextNode);
            nodes.addAll(nextNode);
        }
        return visited.size() == rooms.size();
    }

    static class Graph {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        void addEdge(Integer node, List<Integer> value) {
            List<Integer> edges = graph.get(node);
            if (edges == null) {
                edges = new ArrayList<>();
            }
            edges.addAll(value);
            graph.put(node, edges);
        }

        List<Integer> getNode(Integer node) {
            return graph.get(node);
        }
    }
}
