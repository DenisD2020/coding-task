package leetcode.matrix;

/**
 * https://leetcode.com/problems/rotate-image/?envType=problem-list-v2&envId=matrix
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        new RotateImage().rotate(
                matrix
        );
        System.out.println(matrix);

    }

    public void rotate(int[][] matrix) {
        int[][] tmp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            tmp[i] = matrix[i].clone();
        }

        for (int m = 0; m < matrix.length; m++) {
            int length = matrix[m].length;
            for (int n = 0; n < length; n++) {
                matrix[n][length - 1 - m] = tmp[m][n];
            }
        }
    }
}
