package leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/description/?envType=problem-list-v2&envId=two-pointers
 */
public class IntervalListIntersections {

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(new IntervalListIntersections().intervalIntersection(
                new int[][]{
                        new int[]{5, 10},
                },
                new int[][]{
                        new int[]{5, 6},
                }
        ))); // [5,6]

        System.out.println(Arrays.deepToString(new IntervalListIntersections().intervalIntersection(
                new int[][]{
                        new int[]{0, 2},
                        new int[]{5, 10},
                        new int[]{13, 23},
                        new int[]{24, 25},
                },
                new int[][]{
                        new int[]{1, 5},
                        new int[]{8, 12},
                        new int[]{15, 24},
                        new int[]{25, 26},
                }
        ))); // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) { // 99.16%
        List<int[]> ans = new ArrayList<>();

        int firstIdx = 0, secondIdx = 0;

        for (int i = 0; i < firstList.length + secondList.length; i++) {

            if (firstIdx > firstList.length - 1
                    || secondIdx > secondList.length - 1) break;

            int[] first = firstList[firstIdx];
            int[] second = secondList[secondIdx];

            int leftIntersection = Math.max(first[0], second[0]);
            int rightIntersection = Math.min(first[1], second[1]);

            if (leftIntersection <= rightIntersection) {
                ans.add(new int[]{leftIntersection, rightIntersection});
            }

            if (rightIntersection == first[1]) {
                firstIdx++;
            } else {
                secondIdx++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
