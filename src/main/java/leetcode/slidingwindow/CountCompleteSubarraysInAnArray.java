package leetcode.slidingwindow;

import java.util.*;

/**
 * https://leetcode.com/problems/count-complete-subarrays-in-an-array/
 */
public class CountCompleteSubarraysInAnArray {

    public static void main(String[] args) {
        System.out.println(new CountCompleteSubarraysInAnArray().countCompleteSubarrays(new int[]{1, 3, 1, 2, 2})); // 4
        System.out.println(new CountCompleteSubarraysInAnArray().countCompleteSubarrays(new int[]{5, 5, 5, 5})); // 10
    }

    public int countCompleteSubarrays(int[] nums) {

        Set<Object> set = new HashSet<>();
        for (Integer i : nums) set.add(i);

        int distinct = set.size();

        Map<Integer, Integer> map = new HashMap<>();

        int l = 0, r = 0, ans = 0;

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() == distinct) {
                ans += nums.length - r;
                map.compute(nums[l], (k, v) -> --v);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
                map.put(nums[l], map.getOrDefault(nums[l], 0) + 1);
            }
            r++;
        }
        return ans;
    }


/*    public int countCompleteSubarrays(int[] nums) {
        //step-1
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int distinct = set.size();

        int ans = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() == distinct) {
                ans += nums.length - right;
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;
        }
        return ans;
    }

 */

/*    public int countCompleteSubarrays(int[] nums) {
        if (nums.length == 0) return 0;

        int ans = 1;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> copy;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (int i = 0; i < nums.length; i++) {
            copy = new HashMap<>(map);
            for (int j = nums.length - 2; j >= i; j--) {
                Integer val = copy.compute(nums[j + 1], (k, v) -> --v);
                if (val < 1) {
                    break;
                } else {
                    ans++;
                }
            }
            Integer val = map.compute(nums[i], (k, v) -> --v);
            if (val < 1){
                break;
            } else {
                ans++;
            }
        }
        return ans;
    }*/
}
