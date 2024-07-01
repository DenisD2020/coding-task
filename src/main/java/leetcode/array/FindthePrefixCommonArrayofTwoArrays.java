package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

public class FindthePrefixCommonArrayofTwoArrays {

    public static void main(String[] args) {
        /*System.out.println(Arrays.toString(
                new FindthePrefixCommonArrayofTwoArrays().findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4}))); // 0,2,3,4*/
        System.out.println(Arrays.toString(
                new FindthePrefixCommonArrayofTwoArrays().findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2}))); // 0,1,3
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            res[i] = i > 0 ? res[i - 1] : 0;
            if (!set.add(A[i])) {
                res[i] = res[i] + 1;
            }
            if (!set.add(B[i])) {
                res[i] = res[i] + 1;
            }
        }
        return res;
    }
}
