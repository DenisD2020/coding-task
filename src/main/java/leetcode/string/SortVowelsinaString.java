package leetcode.string;

import java.util.*;

/**
 * Given a 0-indexed string s, permute s to get a new string t such that:
 * <p>
 * All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
 * The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
 * Return the resulting string.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
 */
public class SortVowelsinaString {

    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static void main(String[] args) {
        System.out.println(new SortVowelsinaString().sortVowels("lEetcOde")); // lEOtcede
        System.out.println(new SortVowelsinaString().sortVowels("lYmpH")); // lYmpH
    }

    public String sortVowels(String s) {
        StringBuilder ans = new StringBuilder(s.length());
        String[] split = s.split("");
        ArrayList<Character> characters = new ArrayList<>();

        for (Character a : s.toCharArray()) {
            if (vowels.contains(a)) {
                characters.add(a);
            }
        }
        Collections.sort(characters);
        int index = 0;

        for (Character a : s.toCharArray()) {
            if (vowels.contains(a)) {
                ans.append(characters.get(index++));
            } else {
                ans.append(a);
            }
        }
        return ans.toString();
    }
}
