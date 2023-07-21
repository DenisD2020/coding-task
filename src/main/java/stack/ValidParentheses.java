package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
//        System.out.println(new ValidParentheses().isValid("()")); // true
//        System.out.println(new ValidParentheses().isValid("()[]{}"));// true
//        System.out.println(new ValidParentheses().isValid("([){]}")); // true
//        System.out.println(new ValidParentheses().isValid("(]")); // false
        System.out.println(new ValidParentheses().isValid("){")); // false
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (c == ')' && stack.peekFirst() != null && stack.peekFirst().equals('(')) {
                    stack.pollFirst();
                } else if (c == '}' && stack.peekFirst() != null && stack.peekFirst().equals('{')) {
                    stack.pollFirst();
                } else if (c == ']' && stack.peekFirst() != null && stack.peekFirst().equals('[')) {
                    stack.pollFirst();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
