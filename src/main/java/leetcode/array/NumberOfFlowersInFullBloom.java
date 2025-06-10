package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-flowers-in-full-bloom/description/
 */
public class NumberOfFlowersInFullBloom {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NumberOfFlowersInFullBloom().fullBloomFlowers(
                new int[][]{
                        new int[]{1, 6},
                        new int[]{3, 7},
                        new int[]{9, 12},
                        new int[]{4, 13}
                },
                new int[]{2, 3, 7, 11}
        ))); // [1,2,2,2]

        System.out.println(Arrays.toString(new NumberOfFlowersInFullBloom().fullBloomFlowers(
                new int[][]{
                        new int[]{1, 10},
                        new int[]{3, 3},
                },
                new int[]{3, 3, 2}
        ))); // [2,2,1]

        System.out.println(Arrays.toString(new NumberOfFlowersInFullBloom().fullBloomFlowers(
                new int[][]{
                        {36, 39}, {29, 49}, {32, 35}, {14, 43}, {42, 49},
                        {48, 48}, {32, 46}, {6, 41}, {14, 19}
                },
                new int[]{14, 4}
        ))); // [2,2,1]
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        int l = flowers.length;

        int[] start = new int[l + 1];
        int[] end = new int[l + 1];

        for (int i = 0; i < flowers.length; i++) {
            start[i + 1] = flowers[i][0];
            end[i + 1] = flowers[i][1] + 1;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] ans = new int[people.length];

        for (int i = 0; i < people.length; i++) {
            int curDay = people[i];
            int blooming = binarySearch(start, curDay);
            if (blooming < 0) {
                blooming = -blooming - 2;
            }
            int endBlooming = binarySearch(end, curDay);
            if (endBlooming < 0) {
                endBlooming = -endBlooming - 2;
            }
            ans[i] = blooming - endBlooming;
        }
        return ans;
    }

    int binarySearch(int[] arr, int target) {
        int ans = Arrays.binarySearch(arr, target);
        if (ans < arr.length - 1 && ans >= 0) {
            while (ans < arr.length - 1 && arr[ans + 1] == arr[ans]) {
                ans++;
            }
        }
        return ans;
    }
}
