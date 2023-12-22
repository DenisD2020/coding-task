package backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning { // TODO

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab")); // [["a","a","b"],["aa","b"]]
//        System.out.println(new PalindromePartitioning().partition("a")); // [["a"]]
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, ans, new ArrayList<>(), new int[s.length()], 0, new StringBuilder());
        return ans;
    }

    private void solve(String s, List<List<String>> ans, List<String> temp, int[] track, int index, StringBuilder sb) {
        if (s.length() == index) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (!checkIfPalindrome(sb)) {
                sb.delete(sb.length() - 1, sb.length());
                continue;
            }
            temp.add(sb.toString());
            solve(s, ans, temp, track, i + 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    private boolean checkIfPalindrome(StringBuilder sb) {
        return new StringBuilder(sb).reverse().toString().equals(sb.toString());
    }
}
