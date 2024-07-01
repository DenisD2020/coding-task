package leetcode.graph;

/**
 * https://leetcode.com/problems/find-the-town-judge/description/
 */
public class FindTheTownJudge {

    public static void main(String[] args) {
        System.out.println(new FindTheTownJudge().findJudge(2, new int[][]{
                new int[]{1, 2},
        })); // 2
        System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{
                new int[]{1, 3},
                new int[]{2, 3},
        })); // 3
        System.out.println(new FindTheTownJudge().findJudge(3, new int[][]{
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 1}
        })); // -1

        System.out.println(new FindTheTownJudge().findJudge(4, new int[][]{
                new int[]{1, 3},
                new int[]{1, 4},
                new int[]{2, 3},
                new int[]{2, 4},
                new int[]{4, 3},
        })); // 3
    }

    public int findJudge(int n, int[][] trust) {
        int[] peoples = new int[n];
        for (int [] el : trust) {
            peoples[el[0] - 1] = 1;
        }
        int judge = -1;
        for (int i = 0 ; i < peoples.length; i++) {
            if (peoples[i] == 0) {
                judge = ++i;
                break;
            }
        }
        if (judge == -1) {
            return -1;
        }

        int[] trusts = new int[n];

        for (int elem[] : trust) {
            if (elem[1] == judge){
                trusts[elem[0] - 1] = 1;
            }
        }

        for (int i = 0 ; i < trusts.length; i++) {
            if (i  == judge - 1) continue;
            if (trusts[i] == 0) return -1;
        }
        return judge;
    }

    /* too slow
    public int findJudge(int n, int[][] trust) {
        Graph graph = new Graph();

        for (int i = 1; i < n + 1; i++) {
            graph.addNode(i);
        }
        for (int[] elem : trust) {
            graph.addEdge(elem[0], elem[1]);
        }
        int judge = graph.findJudge();

        for (int i = 1; i < n + 1; i++) {
            if (i == judge) continue;
            Set<Integer> edges = graph.getEdges(i);
            if (!edges.contains(judge)) return -1;
        }
        return judge;
    }

    static class Graph {
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();

        void addNode(Integer node) {
            adjMap.putIfAbsent(node, new HashSet<>());
        }

        void addEdge(Integer node, Integer edge) {
            adjMap.get(node).add(edge);
        }

        Set<Integer> getEdges(Integer node) {
            return adjMap.get(node);
        }

        Integer findJudge() {
            for (Map.Entry<Integer, Set<Integer>> entry : adjMap.entrySet()) {
                if (entry.getValue().isEmpty()) {
                    return entry.getKey();
                }
            }
            return -1;
        }
    }
     */
}
