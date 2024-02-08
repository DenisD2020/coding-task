package string;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/?envType=daily-question&envId=2023-12-31
 */
public class LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {
        System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("scayofdzca")); // 6
        System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("aa")); // 0
        System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("abca")); // 2
        System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("cbzxy")); // -1
    }

    public int maxLengthBetweenEqualCharacters(String s) { // with Array
        int ans = -1;
        int[] map = new int[26];
        Arrays.fill(map, -1);
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            int occurrence = map[symbol - 'a'];
            if (occurrence == -1) {
                map[symbol - 'a'] = i;
            } else {
                ans = Math.max(ans, i - occurrence - 1);
            }
        }
        return ans;
    }

/*    public int maxLengthBetweenEqualCharacters(String s) { // with HashMap
        int ans = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            Integer val = map.get(c);
            if (val == null) {
                map.put(c, i);
            } else {
                ans = Math.max(ans, i - val - 1);
            }
        }
        return ans;
    }*/
}
