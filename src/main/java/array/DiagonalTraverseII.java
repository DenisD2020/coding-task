package array;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/diagonal-traverse-ii/
 */
public class DiagonalTraverseII { // TODO bfs
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiagonalTraverseII().findDiagonalOrder(List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        )))); // [1,4,2,7,5,3,8,6,9]
        // ij   ij ij   ij ij ij   ij ij   ij
        // 00 - 10 02 - 20 11 02 - 21 13 - 22
        System.out.println(Arrays.toString(new DiagonalTraverseII().findDiagonalOrder(List.of(
                List.of(1, 2, 3, 4, 5),
                List.of(6, 7),
                List.of(8),
                List.of(9, 10, 11),
                List.of(12, 13, 14, 15, 16)
        )))); // [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {

        return null;

    }

}
