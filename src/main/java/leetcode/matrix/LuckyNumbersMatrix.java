package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 * <p>
 * Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 * A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
 */
public class LuckyNumbersMatrix {

    public static void main(String[] args) {
        System.out.println(new LuckyNumbersMatrix().luckyNumbers(new int[][]
                {
                        new int[]{3, 7, 8},
                        new int[]{9, 11, 13},
                        new int[]{15, 16, 17},
                }));// 15

        System.out.println(new LuckyNumbersMatrix().luckyNumbers(new int[][]
                {
                        new int[]{1, 10, 4, 2},
                        new int[]{9, 3, 8, 7},
                        new int[]{15, 16, 17, 12},
                }));// 12

        System.out.println(new LuckyNumbersMatrix().luckyNumbers(new int[][]
                {
                        new int[]{7, 8},
                        new int[]{1, 2},
                }));// 7
    }

    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int minIndex = findMin(matrix[i]);
            if (findMaxInColumn(matrix, minIndex) == matrix[i][minIndex]) {
                res.add(matrix[i][minIndex]);
            }
        }
        return res;
    }

    private int findMaxInColumn(int[][] matrix, int column) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] > max) {
                max = matrix[i][column];
            }
        }
        return max;
    }

    private int findMin(int arr[]) {
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

}
