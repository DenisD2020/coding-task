package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/?envType=problem-list-v2&envId=backtracking&difficulty=MEDIUM
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23")); //"ad","ae","af","bd","be","bf","cd","ce","cf"
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("")); //""
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("2")); // ["a","b","c"]
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("234")); //
    }

    static char[][] button = new char[][]{ // Beats 100.00%
            new char[0],
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[][] characters = new char[digits.length()][];
        for (int i = 0; i < digits.length(); i++) {
            characters[i] = button[Character.getNumericValue(digits.charAt(i)) - 1];
        }
        if (digits.isEmpty()) return List.of();
        backTrack(ans, characters, 0, new int[characters.length], new StringBuilder());
        return ans;
    }

    private void backTrack(List<String> ans, char[][] characters, int index, int[] track, StringBuilder sb) {
        if (sb.length() == characters.length) {
            ans.add(sb.toString());
            return;
        }

        for (int i = index; i < characters.length; i++) {
            char[] character = characters[i];
            for (char c : character) {
                if (track[i] == 1) break;
                track[i] = 1;
                sb.append(c);
                backTrack(ans, characters, index + 1, track, sb);
                sb.setLength(sb.length() - 1);
                track[i] = 0;
            }
        }
    }
}
