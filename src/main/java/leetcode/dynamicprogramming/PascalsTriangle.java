package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(1));
        System.out.println(new PascalsTriangle().generate(5));
    }

    private List<List<Integer>> response = new ArrayList<>();

    {
        response.add(List.of(1));
        response.add(List.of(1, 1));
        response.add(List.of(1, 2, 1));
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < response.size()) {
            return response.subList(0, numRows);
        }
        for (int i = 3; i < numRows; i++) {
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
        return response;
    }
}
