package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow(0)); // 0
        System.out.println(new PascalsTriangleII().getRow(1)); // [1,1]
        System.out.println(new PascalsTriangleII().getRow(3)); // [1,3,3,1]
    }

    private final List<List<Integer>> response = new ArrayList<>();
    {
        response.add(List.of(1));
        response.add(List.of(1, 1));
        response.add(List.of(1, 2, 1));
    }

    public List<Integer> getRow(int numRows) {
        if (numRows < response.size()) {
            return response.get(numRows);
        }
        for (int i = response.size(); i < numRows + 1; i++) {
            List<Integer> list = new ArrayList<>();
            for (int k = 0; k < i + 1; k++) {
                if (k == 0 || k == i) {
                    list.add(1);
                } else {
                    list.add(response.get(i - 1).get(k - 1) + response.get(i - 1).get(k));
                }
            }
            response.add(list);
        }
        return response.get(numRows);
    }
}
