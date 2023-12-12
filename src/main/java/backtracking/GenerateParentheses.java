package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3)); // ["((()))","(()())","(())()","()(())","()()()"]
        System.out.println(new GenerateParentheses().generateParenthesis(1)); // ["()"]
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        generate(n, ans, new StringBuilder(), new int[n * 2]);
        return ans;

    }

    private void generate(int n, ArrayList<String> ans, StringBuilder sb, int[] track) {
        if (sb.length() == n * 2) {
            ans.add(sb.toString());
            System.out.println(sb);
            return;
        }

        for (int i = 0 ; i < n * 2 ; i ++) {




        }

    }
}
