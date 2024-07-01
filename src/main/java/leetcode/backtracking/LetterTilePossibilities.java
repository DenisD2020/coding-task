package leetcode.backtracking;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/letter-tile-possibilities/description/
 */
public class LetterTilePossibilities { // TODO repeat

    public static void main(String[] args) {
        System.out.println(new LetterTilePossibilities().numTilePossibilities("AAB")); // 8
        System.out.println(new LetterTilePossibilities().numTilePossibilities("AAABBC")); // 188
        System.out.println(new LetterTilePossibilities().numTilePossibilities("V")); // 1
    }

    int count = 0;

    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        backTracking(chars, new StringBuilder(), new int[tiles.length()]);
        return count - 1;
    }

    private void backTracking(char[] chars, StringBuilder sb, int[] track) {
        if (sb.length() <= chars.length) {
            count++;
        } else {
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (track[i] == 1) continue;
            if (i > 0 && chars[i] == chars[i - 1] && track[i-1] != 1) continue;
            track[i] = 1;
            sb.append(chars[i]);
            backTracking(chars, new StringBuilder(sb), track);
            track[i] = 0;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
