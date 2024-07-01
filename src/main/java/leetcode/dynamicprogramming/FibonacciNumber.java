package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(2)); // 1
        System.out.println(new FibonacciNumber().fib(3)); // 2
        System.out.println(new FibonacciNumber().fib(6)); // 3
    }

    public int fib(int n) { // with memo
        int[] memo = new int[31];
        memo[0] = 0;
        memo[1] = 1;
        return helper(n, memo);
    }

    private int helper(int n, int memo[]) {
        if (n == 0) return 0;
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }
}
