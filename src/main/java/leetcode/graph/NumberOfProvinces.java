package leetcode.graph;

import java.util.Stack;

/**
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {

    public static void main(String[] args) {
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        })); // 3
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{
                {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}
        })); // 1
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        })); // 2
    }

    public int findCircleNum(int[][] isConnected) { // dfs
        int[] visited = new int[isConnected.length];
        int ans = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 1) continue;
            ans++;
            visited[i] = 1;
            Stack<Integer> stack = new Stack<>();
            stack.add(i);

            while (!stack.isEmpty()) {
                Integer component = stack.pop();
                for (int j = 0; j < isConnected[component].length; j++) {
                    if (visited[j] == 1 || j == i || isConnected[component][j] == 0) continue;
                    visited[j] = 1;
                    stack.add(j);
                }
            }
        }
        return ans;
    }

/*    public int findCircleNum(int[][] isConnected) { // adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            ArrayList<Integer> comp = new ArrayList<>();
            adj.add(comp);
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i == j || isConnected[i][j] == 0) continue;
                comp.add(j);
            }
        }
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 1) continue;
            ans++;
            q.add(i);
            visited[i] = 1;
            while (!q.isEmpty()) {
                Integer component = q.poll();
                for (Integer connection : adj.get(component)) {
                    if (visited[connection] == 1) continue;
                    q.add(connection);
                    visited[connection] = 1;
                }
            }
        }
        return ans;
    }*/
}
