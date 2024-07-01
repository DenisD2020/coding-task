package leetcode.binarysearch;

/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/editorial/
 */
public class CountNegativeNumbersinaSortedMatrix {

    public static void main(String[] args) {
        System.out.println(new CountNegativeNumbersinaSortedMatrix().countNegatives(new int[][]{
                new int[]{4, 3, 2, -1},
                new int[]{3, 2, 1, -1},
                new int[]{1, 1, -1, -2},
                new int[]{-1, -1, -2, -3},
        }));
        System.out.println(new CountNegativeNumbersinaSortedMatrix().countNegatives(new int[][]{
                new int[]{3, 2},
                new int[]{1, 0}
        }));
    }

    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int[] arr : grid) {
            ans += count(arr);
        }
        return ans;
    }

    private int count(int[] arr) {
        int ans = 0;
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= 0) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return arr.length - r;
    }
}
