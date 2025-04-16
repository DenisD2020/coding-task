package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class HIndex {

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5})); // 3
        System.out.println(new HIndex().hIndex(new int[]{1, 3, 1})); // 1
    }

    public int hIndex(int[] citations) { // 71.62%
        int n = citations.length;
        Arrays.sort(citations);

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}
