package string;

/**
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 */
public class RemoveAllOccurrencesOfASubstring {

    public static void main(String[] args) {
        System.out.println(new RemoveAllOccurrencesOfASubstring().removeOccurrences("aabababa", "aba")); // ba
        System.out.println(new RemoveAllOccurrencesOfASubstring().removeOccurrences("daabcbaabcbc", "abc")); // dab
        System.out.println(new RemoveAllOccurrencesOfASubstring().removeOccurrences("axxxxyyyyb", "xy")); // ab
    }

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
