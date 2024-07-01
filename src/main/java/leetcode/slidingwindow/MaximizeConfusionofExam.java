package leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
 * <p>
 * A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
 * <p>
 * You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
 * <p>
 * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
 * Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: answerKey = "TTFF", k = 2
 * Output: 4
 * Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
 * There are four consecutive 'T's.
 * Example 2:
 * <p>
 * Input: answerKey = "TFFT", k = 1
 * Output: 3
 * Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
 * Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
 * In both cases, there are three consecutive 'F's.
 * Example 3:
 * <p>
 * Input: answerKey = "TTFTTFTT", k = 1
 * Output: 5
 * Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
 * Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT".
 * In both cases, there are five consecutive 'T's.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == answerKey.length
 * 1 <= n <= 5 * 104
 * answerKey[i] is either 'T' or 'F'
 * 1 <= k <= n
 */
public class MaximizeConfusionofExam {

    public static void main(String[] args) {
//        System.out.println(new MaximizeConfusionofExam().maxConsecutiveAnswers("TTFF", 2));// 4
//        System.out.println(new MaximizeConfusionofExam().maxConsecutiveAnswers("TFFT", 1));// 3
//        System.out.println(new MaximizeConfusionofExam().maxConsecutiveAnswers("TTFTTFTT", 1));// 3
//        System.out.println(new MaximizeConfusionofExam().maxConsecutiveAnswers("FFFTTFTTFT", 3));// 8
        System.out.println(new MaximizeConfusionofExam().maxConsecutiveAnswers("TTFTTFTT", 1));// 5
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMaxLength(answerKey, k, 'T'), getMaxLength(answerKey, k, 'F'));
    }

    private static int getMaxLength(String answerKey, int k, char c) {
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < answerKey.length(); i++) {
            if (answerKey.charAt(i) != c) {
                if (k > 0) {
                    k--;
                } else {
                    if (answerKey.charAt(left) != c) {
                        left++;
                    } else {
                        while (answerKey.charAt(left++) == c) {
                        }
                    }
                }
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
