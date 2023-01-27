package dynamicprogramming;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        //System.out.println(new FibonacciNumber().fib(2));
        System.out.println(new FibonacciNumber().fib(3));
        //System.out.println(new FibonacciNumber().fib(4));
    }

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
