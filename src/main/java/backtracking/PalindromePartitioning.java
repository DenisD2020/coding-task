package backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class PalindromePartitioning { // TODO repeat

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab")); // [["a","a","b"],["aa","b"]]
//        System.out.println(new PalindromePartitioning().partition("a")); // [["a"]]
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        solve(s, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void solve(String s, List<List<String>> ans, List<String> temp, int index) {
        if (s.length() == index) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (checkIfPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                solve(s, ans, temp, i + 1);
                temp.remove(temp.size() - 1);
            }

        }
    }

    private boolean checkIfPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
