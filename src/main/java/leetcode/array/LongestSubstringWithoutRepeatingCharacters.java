package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
//        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb")); // abc
//        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"); // b
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"); // wke 3
//        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(" "); // 1
//        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("au"); // 1
//        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf")); // 3
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0, fast = 0, slow = 0;
        Set<Character> set = new HashSet<>();

        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(slow++));
            }
        }
        return res;
    }

/*    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                res = Math.max(res, map.size());
                i = map.get(s.charAt(i));
                map.clear();
            }
        }
        return Math.max(res, map.size());
    }*/
}
