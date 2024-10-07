package leetcode.array;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/description/
 */
public class MinimumDeletionsToMakeArrayBeautiful {

    public static void main(String[] args) {
        System.out.println(new MinimumDeletionsToMakeArrayBeautiful().minDeletion(new int[]{100000, 100000})); // 2
//        System.out.println(new MinimumDeletionsToMakeArrayBeautiful().minDeletion(new int[]{1, 1, 2, 3, 5})); // 1
//        System.out.println(new MinimumDeletionsToMakeArrayBeautiful().minDeletion(new int[]{1, 1, 2, 2, 3, 3})); // 2
//        System.out.println(new MinimumDeletionsToMakeArrayBeautiful().minDeletion(new int[]{3, 4, 4, 4})); // 2
//        System.out.println(new MinimumDeletionsToMakeArrayBeautiful().minDeletion(new int[]{2, 6, 2, 5, 8, 9, 7, 2, 2, 5, 6, 2, 2, 0, 6, 8, 7, 3, 9, 2, 1, 1, 3, 2, 6, 2, 4, 6, 5, 8, 4, 8, 7, 0, 4, 8, 7, 8, 4, 1, 1, 4, 0, 1, 5, 7, 7, 5, 9, 7, 5, 5, 8, 6, 4, 3, 6, 5, 1, 6, 7, 6, 9, 9, 6, 8, 6, 0, 9, 5, 6, 7, 6, 9, 5, 5, 7, 3, 0, 0, 5, 5, 4, 8, 3, 9, 3, 4, 1, 7, 9, 3, 1, 8, 8, 9, 1, 6, 0, 0})); // 6
    }

    public int minDeletion(int[] nums) {
        int ans = 0, prev = -1;
        for (int i : nums) {
            if (i == prev) {
                ans++;
            } else {
                prev = prev < 0 ? i : -1;
            }
        }
        return prev < 0 ? ans : ans + 1;
    }

//    public int minDeletion(int[] nums) { // 22.80%
//        int ans = 0;
//
//        Deque<Integer> list = new LinkedList<>();
//
//        boolean isEven = false;
//
//        for (int i = 0; i < nums.length; i++) {
//            int curr = nums[i];
//            if (!isEven) {
//                list.add(curr);
//                isEven = true;
//                if (i == nums.length - 1) ans++;
//            } else {
//                Integer prev = list.getLast();
//                if (prev == curr) {
//                    ans++;
//                    if (i == nums.length - 1) ans++;
//                } else {
//                    isEven = false;
//                }
//            }
//        }
//        return ans;
//    }

/*    public int minDeletion(int[] nums) { // 77.20%  difficult to understand
        if (nums.length == 1) return 1;
        int ans = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (prev == current) {
                ans++;
            } else {
                i++;
                if (i >= nums.length) break;
                prev = nums[i];
            }
            if (i + 1 >= nums.length) {ans++;}
        }
        return ans;
    }*/
}
