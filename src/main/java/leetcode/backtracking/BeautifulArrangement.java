package leetcode.backtracking;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/beautiful-arrangement/description/
 */
public class BeautifulArrangement {

    public static void main(String[] args) {
//        System.out.println(new BeautifulArrangement().countArrangement(1)); // 1
//        System.out.println(new BeautifulArrangement().countArrangement(2)); // 2
//        System.out.println(new BeautifulArrangement().countArrangement(3)); // 3
        System.out.println(new BeautifulArrangement().countArrangement(4)); // 8
    }

    public int countArrangement(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        int[] ans = new int[1];
        backTrack(arr, ans, new ArrayList<>(), new int[n]);
        return ans[0];
    }

    private void backTrack(int[] arr, int[] ans, ArrayList<Integer> temp, int[] track) {
        if (temp.size() == arr.length) {
            // check
            ans[0]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (track[i] == 1) continue;
            int index = temp.size() + 1;
            if (arr[i] % index == 0 || index % arr[i] == 0) {
                track[i] = 1;
                temp.add(arr[i]);
                backTrack(arr, ans, temp, track);
                track[i] = 0;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
