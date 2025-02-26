package leetcode.dynamicprogramming;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/stone-game-vi/
 */
public class StoneGameVI {

    public static void main(String[] args) {
        System.out.println(new StoneGameVI().stoneGameVI(
                new int[]{1, 3},
                new int[]{2, 1}
        )); // 1

        System.out.println(new StoneGameVI().stoneGameVI(
                new int[]{1, 2},
                new int[]{3, 1}
        )); // 0

        System.out.println(new StoneGameVI().stoneGameVI(
                new int[]{2, 4, 3},
                new int[]{1, 6, 7}
        )); // -1
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) { // 21%
        int aliceScore = 0;
        int bobScore = 0;

        Queue<Elem> elems = new PriorityQueue<>(aliceValues.length + 2, (o1, o2) -> o2.value - o1.value);

        for (int i = 0; i < aliceValues.length; i++) {
            elems.add(new Elem(i, bobValues[i] + aliceValues[i]));
        }

        for (int i = 0; i < aliceValues.length; i++) {
            int idx = elems.poll().idx();
            if (i % 2 == 0) {
                // Alice move
                aliceScore += aliceValues[idx];
            } else {
                // Bob move
                bobScore += bobValues[idx];
            }
        }
        return Integer.compare(aliceScore, bobScore);
    }

    record Elem(int idx, int value) {
    }
}
