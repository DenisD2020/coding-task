package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SpiralMatrix {

    public static void main(String[] args) {
/*        System.out.println(new SpiralMatrix().spiralOrder(
                new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9}
                }
        )); // [1,2,3,6,9,8,7,4,5]

        System.out.println(new SpiralMatrix().spiralOrder(
                new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12}
                }
        )); // [1,2,3,4,8,12,11,10,9,5,6,7]*/

        System.out.println(new SpiralMatrix().spiralOrder(
                new int[][]{
                        new int[]{1, 2},
                }
        )); // [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    public List<Integer> spiralOrder(int[][] matrix) { // 100.00%

        if (matrix.length == 1 && matrix[0].length == 1) return List.of(matrix[0][0]);
        List<Integer> ans = new ArrayList<>();
        int row = 0;
        int coll = 0;
        ans.add(matrix[row][coll]);
        String direction = "right";

        // right -> down -> left -> up

        boolean isFinished = false;

        while (!isFinished) {

            matrix[row][coll] = 101;

            if (direction == "right") {
                if (coll >= matrix[0].length - 1 || matrix[row][coll + 1] == 101) {
                    direction = "down";
                } else {
                    coll++;
                }
            }

            if (direction == "down") {
                if (row >= matrix.length - 1 || matrix[row + 1][coll] == 101) {
                    direction = "left";
                } else {
                    row++;
                }
            }
            if (direction == "left") {
                if (coll <= 0 || matrix[row][coll - 1] == 101) {
                    direction = "up";
                } else {
                    coll--;
                }
            }

            if (direction == "up") {
                if (row <= 0 || matrix[row - 1][coll] == 101) {
                    direction = "right";
                    coll++;
                } else {
                    row--;
                }
            }
            if (coll >= matrix[0].length || matrix[row][coll] == 101) {
                break;
            }
            ans.add(matrix[row][coll]);
            matrix[row][coll] = 101;

        }
        return ans;
    }
}
