package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/description/
 */
public class DeleteOperationForTwoStrings {

    public static void main(String[] args) {
//        System.out.println(new DeleteOperationForTwoStrings().minDistance("a", "b")); // 2
        System.out.println(new DeleteOperationForTwoStrings().minDistance("dinitrophenylhydrazine", "benzalphenylhydrazone")); // 13
//        System.out.println(new DeleteOperationForTwoStrings().minDistance("mart", "karma")); // 3
//        System.out.println(new DeleteOperationForTwoStrings().minDistance("a", "ab")); // 1
//        System.out.println(new DeleteOperationForTwoStrings().minDistance("sea", "eat")); // 2
//        System.out.println(new DeleteOperationForTwoStrings().minDistance("leetcode", "etco")); // 4
    }

    int[][] dp;

    public int minDistance(String word1, String word2) {

        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return calc(word1, word2, word1.length(), word2.length());
    }

    private int calc(String word1, String word2, int idx1, int idx2) {
        if (idx1 == 0 || idx2 == 0) {
            dp[idx1][idx2] = Math.max(idx1, idx2);
            return dp[idx1][idx2];
        }

        if (dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if (word1.charAt(idx1 - 1) == word2.charAt(idx2 - 1)) {
            return calc(word1, word2, idx1 - 1, idx2 - 1);
        }

        int w1 = calc(word1, word2, idx1, idx2 - 1);
        int w2 = calc(word1, word2, idx1 - 1, idx2);

        dp[idx1][idx2] = Math.min(w1, w2) + 1;

        return dp[idx1][idx2];
    }
}
