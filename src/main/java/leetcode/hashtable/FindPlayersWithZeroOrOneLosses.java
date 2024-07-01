package leetcode.hashtable;

import java.util.*;

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
 * <p>
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 */
public class FindPlayersWithZeroOrOneLosses {

    public static void main(String[] args) {
        System.out.println(new FindPlayersWithZeroOrOneLosses().findWinners(new int[][]{
                new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 6}, new int[]{5, 6}, new int[]{5, 7},
                new int[]{4, 5}, new int[]{4, 8}, new int[]{4, 9}, new int[]{10, 4}, new int[]{10, 9}
        })); //[[1,2,10],[4,5,7,8]]

    }

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> stat = new HashMap<>();
        for (int[] arr : matches) {
            int winner = arr[0];
            int loser = arr[1];
            stat.putIfAbsent(winner, 0);
            stat.merge(loser, 1, Integer::sum);
        }

        List<Integer> winner1 = new ArrayList<>();
        List<Integer> winner2 = new ArrayList<>();

        for (var entry : stat.entrySet()) {
            if (entry.getValue() == 0) {
                winner1.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                winner2.add(entry.getKey());
            }
        }
        Collections.sort(winner1);
        Collections.sort(winner2);
        return List.of(winner1, winner2);
    }
}
