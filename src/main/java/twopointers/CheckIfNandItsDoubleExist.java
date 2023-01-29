package twopointers;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * <p>
 * Given an array arr of integers, check if there exist two indices i and j such that :
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 * Example 2:
 * <p>
 * Input: arr = [3,1,7,11]
 * Output: false
 * Explanation: There is no i and j that satisfy the conditions.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 500
 * -103 <= arr[i] <= 103
 */
public class CheckIfNandItsDoubleExist {

    public static void main(String[] args) {
        System.out.println(new CheckIfNandItsDoubleExist().checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(new CheckIfNandItsDoubleExist().checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(new CheckIfNandItsDoubleExist().checkIfExist(new int[]{7, 1, 14, 11}));
        System.out.println(new CheckIfNandItsDoubleExist().checkIfExist(new int[]{3, 1, 7, 11}));
    }


    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2) || i % 2 == 0 && set.contains(i / 2)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
