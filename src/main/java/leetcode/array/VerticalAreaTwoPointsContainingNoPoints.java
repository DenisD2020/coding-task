package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/description/
 */
public class VerticalAreaTwoPointsContainingNoPoints {

    public static void main(String[] args) {
        System.out.println(new VerticalAreaTwoPointsContainingNoPoints().maxWidthOfVerticalArea(new int[][]{
                new int[]{8, 7},
                new int[]{9, 9},
                new int[]{7, 4},
                new int[]{9, 7}})); // 3
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int ans = 0;
        int[] arr = new int[points.length];
        for (int i = 0; i < points.length; i++) arr[i] = points[i][0];
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            ans = Math.max(ans, arr[i + 1] - arr[i]);
        }
        return ans;
    }


/*    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a , b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0 ; i < points.length - 1; i++) {
            ans = Math.max(ans, points[i + 1][0] - points[i][0]);
        }
        return ans;
    }*/

/*    public int maxWidthOfVerticalArea(int[][] points) {
        TreeSet<Integer> set = new TreeSet<>();
        int ans = 0;
        for(int [] arr : points) {
            set.add(arr[0]);
        }
        int prev = Integer.MAX_VALUE;
        for (int i : set) {
            ans = Math.max(ans, i - prev);
            prev = i;
        }
        return ans;
    }*/
}
