package array;

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/?envType=daily-question&envId=2023-12-11
 */
public class ElementAppearingMoreThan25InSortedArray {

    public static void main(String[] args) {
        System.out.println(new ElementAppearingMoreThan25InSortedArray().findSpecialInteger(new int[]{1, 2, 3, 3})); // 3
        System.out.println(new ElementAppearingMoreThan25InSortedArray().findSpecialInteger(new int[]{1, 1, 2, 2, 3, 3, 3, 3})); // 3
        System.out.println(new ElementAppearingMoreThan25InSortedArray().findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10})); // 6
        System.out.println(new ElementAppearingMoreThan25InSortedArray().findSpecialInteger(new int[]{1, 1})); // 1
    }

    public int findSpecialInteger(int[] arr) {
        int threshold = arr.length / 4;
        for (int i = 0; i < arr.length - threshold; i++) {
            if (arr[i] == arr[i + threshold]){
                return arr[i];
            }

        }
        return -1;
    }

    public int findSpecialInteger2(int[] arr) {
        if (arr.length == 1) return arr[0];
        int ans = -1;
        int prev = arr[0];
        int threshold = arr.length / 4;
        int occurrence = 1;

        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                occurrence++;
            } else {
                occurrence = 1;
            }
            prev = arr[i];
            if (occurrence > threshold) {
                return arr[i];
            }
        }
        return ans;
    }
}
