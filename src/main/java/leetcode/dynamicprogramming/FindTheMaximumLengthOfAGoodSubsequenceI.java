package leetcode.dynamicprogramming;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/find-the-maximum-length-of-a-good-subsequence-i/
 *
 *
 * я не понимаю условия этой задачи
 * почему {13, 9, 13}, 1 ответ 2
 * а
 * {1, 2, 3, 4, 5, 1}, 0 ответ тоже 2
 * в чем логика, не ясно.
 */
public class FindTheMaximumLengthOfAGoodSubsequenceI {

    public static void main(String[] args) {
        System.out.println(new FindTheMaximumLengthOfAGoodSubsequenceI().maximumLength(new int[]{13, 9, 13}, 1)); // 2
        System.out.println(new FindTheMaximumLengthOfAGoodSubsequenceI().maximumLength(new int[]{4, 4}, 0)); // 2
        System.out.println(new FindTheMaximumLengthOfAGoodSubsequenceI().maximumLength(new int[]{1, 17}, 0)); // 1
        System.out.println(new FindTheMaximumLengthOfAGoodSubsequenceI().maximumLength(new int[]{1, 2, 1, 1, 3}, 2)); // 4
        System.out.println(new FindTheMaximumLengthOfAGoodSubsequenceI().maximumLength(new int[]{1, 2, 3, 4, 5, 1}, 0)); // 2
        System.out.println(new FindTheMaximumLengthOfAGoodSubsequenceI().maximumLength(new int[]{2}, 0)); // 1
    }

    public int maximumLength(int[] nums, int k) {

        if (nums.length == 1) return 1;

        Deque<Integer> diffIdx = new LinkedList<>();

        int l = 0, ans = 0;

        for (int r = 0; r < nums.length - 1; r++) {

            if (nums[r] != nums[r + 1]) {
                diffIdx.add(r + 1);
                ans = Math.max(1, ans);
            }

            if (diffIdx.size() <= k) {
                ans = Math.max(ans, r + 1 - l + 1);
            } else if (diffIdx.size() > k) {
                l = diffIdx.poll();
            }
        }

        if (nums[0] == nums[nums.length - 1]) {
            //ans++;
        }
        return ans;
    }
}
