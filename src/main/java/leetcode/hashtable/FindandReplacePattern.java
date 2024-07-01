package leetcode.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
 * <p>
 * https://leetcode.com/problems/find-and-replace-pattern/description/
 */
public class FindandReplacePattern {

    public static void main(String[] args) {
        System.out.println(new FindandReplacePattern().findAndReplacePattern(new String[]{"aac", "deq", "mee", "aqq", "dkd", "ccc"}, "abb")); // ["mee","aqq"]
        System.out.println(new FindandReplacePattern().findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb")); // ["mee","aqq"]
        System.out.println(new FindandReplacePattern().findAndReplacePattern(new String[]{"a", "b", "c"}, "a")); // ["a","b","c"]
        System.out.println(new FindandReplacePattern().findAndReplacePattern(new String[]{"abc","cba","xyx","yxx","yyx"}, "abc")); // ["abc","cba"]
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        var ans = new ArrayList<String>();
        for (String word : words) {
            if (compareWord(pattern, word)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean compareWord(String pattern, String word) {
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.indexOf(pattern.charAt(i)) != word.indexOf(word.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
