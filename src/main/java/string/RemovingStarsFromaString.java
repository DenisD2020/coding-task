package string;

/**
 * https://leetcode.com/problems/removing-stars-from-a-string/description/
 */
public class RemovingStarsFromaString {

    public static void main(String[] args) {
        System.out.println(new RemovingStarsFromaString().removeStars("leet**cod*e")); // lecoe
        System.out.println(new RemovingStarsFromaString().removeStars("erase*****")); // ""

    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if(c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
