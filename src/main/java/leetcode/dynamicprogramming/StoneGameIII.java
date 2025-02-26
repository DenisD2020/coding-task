package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/stone-game-iii/description/
 * Return "Alice" if Alice will win, "Bob" if Bob will win, or "Tie"
 */
public class StoneGameIII {

    public static void main(String[] args) {
        System.out.println(new StoneGameIII().stoneGameIII(new int[]{1, 2, 3, 7})); // Bob
        System.out.println(new StoneGameIII().stoneGameIII(new int[]{1, 2, 3, -9})); // Alice
        System.out.println(new StoneGameIII().stoneGameIII(new int[]{1, 2, 3, 6})); // Tie
    }

    public String stoneGameIII(int[] stoneValue) { // TODO

        int length = stoneValue.length;
        int[] dp = new int[length + 1];

        for (int i = length; i >= 0; i--) {



        }

        return "Tie";
    }

}

