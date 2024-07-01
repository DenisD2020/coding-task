package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */
public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        System.out.println(new UniqueMorseCodeWords().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(new UniqueMorseCodeWords().uniqueMorseRepresentations(new String[]{"a"}));
    }

    String[] morse = new String[]{
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder(120);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                sb.append(morse[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
            sb.setLength(0);
        }
        return set.size();
    }
}
