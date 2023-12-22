package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
 */
public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    public static void main(String[] args) {
        System.out.println(new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(1, 3)); // c
        System.out.println(new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(1, 4)); // ""
        System.out.println(new TheKthLexicographicalStringOfAllHappyStringsOfLengthN().getHappyString(3, 9)); // cab
    }

    public String getHappyString(int n, int k) {
        ArrayList<String> res = new ArrayList<>();
        backTracking(n, k, new StringBuilder(), res, k);
        if (res.size() < k) return "";
        return res.get(k - 1);
    }

    private void backTracking(int n, int k, StringBuilder sb, List<String> res, int index) {
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (res.size() == k) return;
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) continue;
            sb.append(c);
            backTracking(n, k, sb, res, index);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
