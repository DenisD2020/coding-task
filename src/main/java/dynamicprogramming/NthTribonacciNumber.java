package dynamicprogramming;

public class NthTribonacciNumber {

    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber().tribonacci(3));
    }
    private int[] cache = new int[38];
    {
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return cache[n];
    }
}
