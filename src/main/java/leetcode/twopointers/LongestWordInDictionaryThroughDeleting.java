package leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/description/?envType=problem-list-v2&envId=two-pointers
 */
public class LongestWordInDictionaryThroughDeleting {

    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord(
                "abpcplea", new ArrayList<>(List.of("ale", "apple", "monkey", "plea")))); // apple

        System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord(
                "abpcplea", new ArrayList<>(List.of("a", "b", "c")))); // a

        System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord(
                "abce", new ArrayList<>(List.of("abe", "abc")))); // abe
    }

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });
        for (String dictElem : dictionary) {
            if (isUncommon(s, dictElem)) {
                return dictElem;
            }
        }
        return "";
    }

    private boolean isUncommon(String s1, String dictElem) {
        int i = 0, j = 0;
        while (i < s1.length() && j < dictElem.length()) {
            if (s1.charAt(i) == dictElem.charAt(j)) {
                j++;
            }
            i++;
        }
        return dictElem.length() == j;
    }
}
