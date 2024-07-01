package leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public static void main(String[] args) {
        //System.out.println(new PancakeSorting().pancakeSort(new int[]{3, 2, 1, 4}));
        System.out.println(new PancakeSorting().pancakeSort(new int[]{3, 2, 4, 1}));
        //System.out.println(new PancakeSorting().pancakeSort(new int[]{1, 2, 3}));
    }

    public List<Integer> pancakeSort(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = arr.length; i > 0; i--) {
            int maxIndex = findMax(arr, i);
            if (maxIndex != i - 1) {
                if (maxIndex != 0) {
                    flip(arr, maxIndex);
                    res.add(maxIndex + 1);
                }
                flip(arr, i - 1);
                res.add(i );
            }
        }
        return res;
    }

    public void flip(int[] arr, int index) {
        int i = 0;
        while (i < index) {
            int temp = arr[i];
            arr[i++] = arr[index];
            arr[index--] = temp;
        }
    }

    public int findMax(int[] arr, int rightIndex) {
        int res = 0;
        for (int i = 0; i < rightIndex; i++) {
            if (arr[res] < arr[i]) {
                res = i;
            }
        }
        return res;
    }
}
