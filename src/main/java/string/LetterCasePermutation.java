package string;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-case-permutation/description/
 */
public class LetterCasePermutation { // TODO
    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("ab")); //
        System.out.println(new LetterCasePermutation().letterCasePermutation("a1b2")); // "a1b2","a1B2","A1b2","A1B2"
        System.out.println(new LetterCasePermutation().letterCasePermutation("3z4")); // "3z4","3Z4"
    }

    /**
     * ab
     * Ab
     * AB
     * aB
     */
    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();

        list.add(new String(chars));
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) continue;
            for (int j = 0; j < s.length(); j++) {
                if (Character.isDigit(s.charAt(j))) continue;
                if (Character.isUpperCase(chars[j])) {
                    chars[j] = Character.toLowerCase(chars[j]);
                } else {
                    chars[j] = Character.toUpperCase(chars[j]);
                }
                list.add(new String(chars));
            }
        }
        return list;
    }
}
