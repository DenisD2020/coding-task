package hashtable;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 * <p>
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
public class FirstUniqueCharacterinaString {

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterinaString().firstUniqChar("leetcode")); // 0
        System.out.println(new FirstUniqueCharacterinaString().firstUniqChar("loveleetcode")); // 2
        System.out.println(new FirstUniqueCharacterinaString().firstUniqChar("aabb")); // -1
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer v = map.getOrDefault(c, 0);
            map.put(c, v + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
