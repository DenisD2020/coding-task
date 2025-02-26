package leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * https://leetcode.com/problems/different-ways-to-add-parentheses/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2-1-1")); // [0,2]
        //((2-1)-1) = 0
        //(2-(1-1)) = 2
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5")); // [-34,-14,-10,-10,10]
        //(2*(3-(4*5))) = -34
        //((2*3)-(4*5)) = -14
        //((2*(3-4))*5) = -10
        //(2*((3-4)*5)) = -10
        //(((2*3)-4)*5) = 10
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char expChar = expression.charAt(i);
            if (expChar == '+' || expChar == '-' || expChar == '*') {
                List<Integer> leftExpr = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightExpr = diffWaysToCompute(expression.substring(i + 1));
                for (Integer left : leftExpr) {
                    for (Integer right : rightExpr) {
                        switch (expChar) {
                            case '+':
                                res.add(left + right);
                                break;
                            case '-':
                                res.add(left - right);
                                break;
                            case '*':
                                res.add(left * right);
                                break;
                        }
                    }
                }
            }
        }
        if (res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}
