package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/2-keys-keyboard/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=MEDIUM
 * Initially, we have one character 'A'.
 * In step 1, we use Copy All operation.
 * In step 2, we use Paste operation to get 'AA'.
 * In step 3, we use Paste operation to get 'AAA'.
 * <p>
 * 1 <= n <= 1000
 */
public class TwoKeysKeyboard {
    public static void main(String[] args) {
//        System.out.println(new TwoKeysKeyboard().minSteps(1)); // 0
//        System.out.println(new TwoKeysKeyboard().minSteps(3)); // 3
//        System.out.println(new TwoKeysKeyboard().minSteps(4)); // 4
//        System.out.println(new TwoKeysKeyboard().minSteps(5)); // 5
//        System.out.println(new TwoKeysKeyboard().minSteps(6)); // 5
//        System.out.println(new TwoKeysKeyboard().minSteps(7)); // 7
//        System.out.println(new TwoKeysKeyboard().minSteps(8)); // 6
//        System.out.println(new TwoKeysKeyboard().minSteps(9)); // 6
        System.out.println(new TwoKeysKeyboard().minSteps(27)); // 9
    }

    int[][] dp;

    public int minSteps(int n) { // with memo
        if (n == 1) return 0;
        dp = new int[n][n];
        return 1 + solve(n, 1, 1);
    }

    private int solve(int n, int curLength, int pastLength) {
        if (curLength > n) {
            return 1000;
        }
        if (curLength == n) {
            return 0;
        }

        if (dp[curLength][pastLength] != 0) {
            return dp[curLength][pastLength];
        }

        int paste = 1 + solve(n, curLength + pastLength, pastLength);
        int copyAndPaste = 2 + solve(n, curLength * 2, curLength);
        dp[curLength][pastLength] = Math.min(paste, copyAndPaste);
        return Math.min(paste, copyAndPaste);
    }

/*    public int minSteps(int n) { // Beats 34.11%
        if (n == 1) return 0;
        return solve(n, 1, 1, 1);
    }

    private int solve(int n, int operation, int curLength, int pastLength) {
        if (curLength > n) {
            return 1000;
        }
        if (curLength == n) {
            return operation;
        }

        int paste = solve(n, operation + 1, curLength + pastLength, pastLength);
        int copyAndPaste = solve(n, operation + 2, curLength * 2, curLength );

        return Math.min(paste, copyAndPaste);
    }*/
}
