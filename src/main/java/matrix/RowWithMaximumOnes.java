package matrix;

/**
 * https://leetcode.com/problems/row-with-maximum-ones/
 * <p>
 * Given a m x n binary matrix mat, find the 0-indexed position of the row that contains the maximum count of ones, and the number of ones in that row.
 * In case there are multiple rows that have the maximum count of ones, the row with the smallest row number should be selected.
 * Return an array containing the index of the row, and the number of ones in it.
 */
public class RowWithMaximumOnes {

    public static void main(String[] args) {
        System.out.println(new RowWithMaximumOnes().rowAndMaximumOnes(new int[][]
                {
                        new int[]{0, 1},
                        new int[]{1, 0},
                }));

        System.out.println(new RowWithMaximumOnes().rowAndMaximumOnes(new int[][]
                {
                        new int[]{0, 0, 0,},
                        new int[]{1, 1, 0},
                }));
    }

    public int[] rowAndMaximumOnes(int[][] mat) {

        int[] res = new int[2];

        for (int i = 0; i < mat.length; i++) {
            int count = count(mat[i]);
            if (count > res[1]) {
                res[0] = i;
                res[1] = count;
            }
        }
        return res;
    }

    private int count(int[] ints) {
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                count++;
            }
        }
        return count;
    }

}
