package hashtable;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConvertanArrayIntoa2DArrayWithConditions {
    public static void main(String[] args) {
        System.out.println(new ConvertanArrayIntoa2DArrayWithConditions().findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1})); //
    }


    public List<List<Integer>> findMatrix(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int [] count = new int[nums.length + 1];
        for (int a : nums) {
            if (res.size() < ++count[a]) {
                res.add(new ArrayList<>());
            }
            res.get(count[a] - 1).add(a);
        }
        return res;
    }

/*    public List<List<Integer>> findMatrix(int[] nums) {
        List<Set<Integer>> sets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean isAdded = false;
            for (Set set : sets) {
                if (isAdded = set.add(nums[i])) {
                    break;
                }
            }
            if (!isAdded) {
                HashSet<Integer> set = new HashSet<>();
                set.add(nums[i]);
                sets.add(set);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Set set : sets) {
            ans.add(new ArrayList<Integer>(set));
        }
        return ans;
    }*/
}
