package dynamicprogramming;

/**
 * https://leetcode.com/problems/divisor-game/description/
 */
public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(2));
        System.out.println(new DivisorGame().divisorGame(3));
        System.out.println(new DivisorGame().divisorGame(4));
    }

    private boolean result = false;

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    private boolean div(int n, int x) {
        if (n == 1) {
            return result;
        } else if (n % x == 0) {
            result = !result;
            return div(n - x, 1);
        } else {
            return div(n, 1);
        }
    }
}
