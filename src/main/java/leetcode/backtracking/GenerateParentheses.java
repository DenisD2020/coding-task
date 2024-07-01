package leetcode.backtracking;

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
        List<String> ans = new ArrayList<>();
        generate(n, ans, new StringBuilder(), 0, 0);
        return ans;
    }

    private void generate(int n, List<String> ans, StringBuilder sb, int open, int close) {
        if (n == close) {
            ans.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            generate(n, ans, sb, open + 1, close);
            sb.setLength(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            generate(n, ans, sb, open , close + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
