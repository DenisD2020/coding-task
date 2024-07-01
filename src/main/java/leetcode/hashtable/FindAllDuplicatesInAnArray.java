package leetcode.hashtable;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})); // 2,3
        System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(new int[]{1, 1, 2})); // 1
    }

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] ints = new int[nums.length + 1];
        for (int i : nums) if (++ints[i] > 1) ans.add(i);
        return ans;
    }
}
