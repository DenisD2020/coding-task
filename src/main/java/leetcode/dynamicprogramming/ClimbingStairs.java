package leetcode.dynamicprogramming;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs(4));
    }

    public int climbStairs(int n) {

        int[] arr = new int[n];

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
