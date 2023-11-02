package string;

import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
 */
public class MinimumAddtoMakeParenthesesValid {
    public static void main(String[] args) {
        System.out.println(new MinimumAddtoMakeParenthesesValid().minAddToMakeValid("())")); // 1
        System.out.println(new MinimumAddtoMakeParenthesesValid().minAddToMakeValid("(((")); // 3
        System.out.println(new MinimumAddtoMakeParenthesesValid().minAddToMakeValid(")()")); // 1
    }
/*    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    ans++;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() + ans;
    }*/

    public int minAddToMakeValid(String s) {
        int stack = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack++;
            } else {
                if (stack == 0) {
                    ans++;
                } else {
                    stack--;
                }
            }
        }
        return stack + ans;
    }
}
