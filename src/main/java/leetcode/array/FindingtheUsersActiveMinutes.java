package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindingtheUsersActiveMinutes {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindingtheUsersActiveMinutes().findingUsersActiveMinutes(
                new int[][]{
                        new int[]{0, 5},
                        new int[]{1, 2},
                        new int[]{0, 2},
                        new int[]{0, 5},
                        new int[]{1, 3}}, 5))); // [0,2,0,0,0]

        System.out.println(Arrays.toString(new FindingtheUsersActiveMinutes().findingUsersActiveMinutes(
                new int[][]{
                        new int[]{1, 1},
                        new int[]{2, 2},
                        new int[]{2, 3}}, 4))); // [1,1,0,0]
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) { // work, but too slow
        int[] res = new int[k];

        Map<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < logs.length; i++) {
            int user = logs[i][0];
            if (!map.containsKey(user)) {
                map.put(user, new HashSet<>());
            }
            map.get(user).add(logs[i][1]);
        }

        for (Integer id : map.keySet()) {
            int uam = map.get(id).size();
            res[uam - 1]++;
        }
        return res;
    }
}
