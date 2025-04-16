package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/?envType=problem-list-v2&envId=dynamic-programming
 */
public class Triangle {

    public static void main(String[] args) {
        System.out.println(new Triangle().minimumTotal(
                List.of(
                        new ArrayList<>(List.of(2)),
                        new ArrayList<>(List.of(3, 4)),
                        new ArrayList<>(List.of(6, 5, 7)),
                        new ArrayList<>(List.of(4, 1, 8, 3))
                )
        )); // 11
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prevRow = triangle.getFirst();
        List<Integer> row = null;
        for (int i = 1; i < triangle.size(); i++) {
            row = triangle.get(i);
            row.set(0, row.getFirst() + prevRow.getFirst());
            row.set(row.size() - 1, row.getLast() + prevRow.getLast());
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
            }
            prevRow = row;
        }

        int ans = Integer.MAX_VALUE;
        for (Integer item : triangle.getLast()) {
            ans = Math.min(ans, item);
        }
        return ans;
    }

/*    public int minimumTotal(List<List<Integer>> triangle) { // 22%

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                List<Integer> prevRow = triangle.get(i - 1);
                if (j == 0) {
                    row.set(0, row.getFirst() + prevRow.getFirst());
                } else if (j == row.size() - 1) {
                    row.set(row.size() - 1, row.getLast() + prevRow.getLast());
                } else {
                    row.set(j, row.get(j) + Math.min(prevRow.get(j - 1), prevRow.get(j)));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (Integer item : triangle.getLast()) {
            ans = Math.min(ans, item);
        }
        return ans;
    }*/
}
