package leetcode.backtracking;

/**
 * https://leetcode.com/problems/maximum-compatibility-score-sum/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MaximumCompatibilityScoreSum {

    public static void main(String[] args) {
        System.out.println(new MaximumCompatibilityScoreSum().maxCompatibilitySum(new int[][]{
                new int[]{1, 1, 0},
                new int[]{1, 0, 1},
                new int[]{0, 0, 1}
        }, new int[][]{
                new int[]{1, 0, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 0}
        })); // 8


        System.out.println(new MaximumCompatibilityScoreSum().maxCompatibilitySum(new int[][]{
                new int[]{0, 0},
                new int[]{0, 0},
                new int[]{0, 0}
        }, new int[][]{
                new int[]{1, 1},
                new int[]{1, 1},
                new int[]{1, 1}
        })); // 0
    }

    int ans = 0;
    int[][] memo;

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int length = students.length;
        boolean[] isUsed = new boolean[length];
        memo = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                memo[i][j] = -1;
            }
        }
        backTrack(students, mentors, isUsed, 0, 0, 0);
        return ans;
    }

    private void backTrack(int[][] students, int[][] mentors, boolean[] isUsed, int idx, int sum, int elem) {
        if (elem >= students.length) {
            ans = Math.max(ans, sum);
            return;
        }

        if (idx >= mentors.length) return;

        for (int i = 0; i < students.length; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            int s1;
            if (memo[i][idx] != 0) {
                s1 = memo[i][idx];
            } else {
                s1 = calcScore(students[i], mentors[idx]);
                memo[i][idx] = s1;
            }
            backTrack(students, mentors, isUsed, idx + 1, sum + s1, elem + 1);
            isUsed[i] = false;
        }
    }

    private int calcScore(int[] student, int[] mentor) {
        int ans = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i] == mentor[i]) ++ans;
        }
        return ans;
    }
}
