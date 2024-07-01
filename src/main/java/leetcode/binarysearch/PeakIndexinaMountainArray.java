package leetcode.binarysearch;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * <p>
 * An array arr is a mountain if the following properties hold:
 * <p>
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 * <p>
 * You must solve it in O(log(arr.length)) time complexity.
 */
public class PeakIndexinaMountainArray {

    public static void main(String[] args) {
//        System.out.println(new PeakIndexinaMountainArray().peakIndexInMountainArray(new int[]{0, 1, 0})); //1
        System.out.println(new PeakIndexinaMountainArray().peakIndexInMountainArray(new int[]{0, 2, 1, 0})); //1
        System.out.println(new PeakIndexinaMountainArray().peakIndexInMountainArray(new int[]{0, 10, 5, 2})); //1
    }


    public int peakIndexInMountainArray(int[] arr) {
        int ans = 0;
        int l = 0, h = arr.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                h = m;
            }
            if (arr[ans] < arr[m]) {
                ans = m;
            }
        }
        return ans;
    }
}
