package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/?envType=problem-list-v2&envId=backtracking
 */
public class GenerateBinaryStringsWithoutAdjacentZeros {

    public static void main(String[] args) {
        System.out.println(new GenerateBinaryStringsWithoutAdjacentZeros().validStrings(1)); // ["1", "0"]
        System.out.println(new GenerateBinaryStringsWithoutAdjacentZeros().validStrings(2)); // ["01", "10", "11"]
        System.out.println(new GenerateBinaryStringsWithoutAdjacentZeros().validStrings(3)); // ["010","011","101","110","111"]
        System.out.println(new GenerateBinaryStringsWithoutAdjacentZeros().validStrings(4));
        System.out.println(new GenerateBinaryStringsWithoutAdjacentZeros().validStrings(5));
    }

    static List<List<String>> dp = new ArrayList<>();

    static {
        dp.add(List.of("1", "0"));
        dp.add(List.of("01", "10", "11"));
    }

    public List<String> validStrings(int n) { // 31%
        int size = dp.size();
        if (n <= size) return dp.get(n - 1);
        solve(n);
        return dp.get(n - 1);
    }

    private void solve(int n) {
        for (int i = dp.size() - 1; i < n; i++) {
            List<String> curr = new ArrayList<>();
            for (String s : dp.get(i)) {
                curr.add(s + "1");
                if (s.charAt(s.length() - 1) != 48) { // != 0
                    curr.add(s + "0");
                }
            }
            dp.add(curr);
        }
    }


/*    public List<String> validStrings(int n) { // 5%
        List<String> ans = new ArrayList<>();
        backtracking(ans, n, new StringBuilder(), new int[]{0, 1}, 0);
        return ans;
    }

    private void backtracking(List<String> ans, int n, StringBuilder sb, int[] ints, int idx) {
        if (sb.length() >= n) {
            ans.add(sb.toString());
            return;
        }

        for (int i = idx; i < n; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == 48 && j == 0) continue;
                sb.append(ints[j]);
                backtracking(ans, n, sb, ints, i + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }*/
}









