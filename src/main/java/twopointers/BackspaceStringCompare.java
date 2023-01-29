package twopointers;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 * Example 2:
 * <p>
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 * Example 3:
 * <p>
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 * <p>
 * <p>
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        //System.out.println(new BackspaceStringCompare().backspaceCompare("ab#c", "ad#c"));
        //System.out.println(new BackspaceStringCompare().backspaceCompare("a#c", "b"));
        //System.out.println(new BackspaceStringCompare().backspaceCompare("a##c", "#a#c"));
        System.out.println(new BackspaceStringCompare().backspaceCompare("xywrrmp", "xywrrmu#p"));
    }

    public boolean backspaceCompare(String s, String t) {

        StringBuilder bs = new StringBuilder();
        StringBuilder bt = new StringBuilder();

        for (int i = 0; i < s.length() || i < t.length(); i++) {

            if (i < s.length()) {
                if (s.charAt(i) == '#') {
                    if (s.charAt(i) > 0 && bs.length() > 0)
                        bs.setLength(bs.length() - 1);
                } else {
                    bs.append(s.charAt(i));
                }
            }

            if (i < t.length()) {
                if (t.charAt(i) == '#') {
                    if (t.charAt(i) > 0 && bt.length() > 0)
                        bt.setLength(bt.length() - 1);
                } else {
                    bt.append(t.charAt(i));
                }
            }
        }
        return bs.compareTo(bt) == 0;
    }

}
