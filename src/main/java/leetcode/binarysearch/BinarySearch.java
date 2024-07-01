package leetcode.binarysearch;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

    public static void main(String[] args) {
//        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9)); // 4
//        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 2)); // -1
        System.out.println(new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 13)); // -1
    }

    public int search(int[] nums, int target) {
        int ans = -1;
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (nums[mid] > target) {
                h = --mid;
            } else if (nums[mid] < target) {
                l = ++mid;
            } else {
                ans = mid;
                break;
            }
        }
        return ans;
    }
}
