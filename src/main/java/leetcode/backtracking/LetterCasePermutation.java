package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/description/
 */
public class LetterCasePermutation { // TODO repeat
    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2")); // "a1b2","a1B2","A1b2","A1B2"
        System.out.println(new LetterCasePermutation().letterCasePermutation("3z4")); // "3z4","3Z4"
        System.out.println(new LetterCasePermutation().letterCasePermutation("ab")); //
    }

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        backTracking(list, new StringBuilder(s), 0);
        return list;
    }

    private void backTracking(List<String> list, StringBuilder s, int index) {
        list.add(s.toString());
        for (int i = index; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) continue;
            StringBuilder sb = new StringBuilder(s);
            char character = sb.charAt(i);
            if (Character.isLowerCase(character)) {
                sb.setCharAt(i, Character.toUpperCase(character));
            } else {
                sb.setCharAt(i, Character.toLowerCase(character));
            }
            backTracking(list, sb, i + 1);
        }
    }
}
