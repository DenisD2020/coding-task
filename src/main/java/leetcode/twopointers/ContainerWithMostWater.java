package leetcode.twopointers;

/**
 * https://leetcode.com/problems/container-with-most-water/?envType=problem-list-v2&envId=two-pointers
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 1})); // 1
    }

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, ans = 0;
        while (l < r) {
            int min = Math.min(height[l],height[r]);
            ans = Math.max(ans, min * (r - l));

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return ans;
    }
}
