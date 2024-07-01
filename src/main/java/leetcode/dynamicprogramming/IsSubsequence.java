package leetcode.dynamicprogramming;

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for (int i = 0 ; i < t.length(); i++) {
            if (index == s.length()) {
                break;
            }
            if (index < s.length() && s.charAt(index) == t.charAt(i)) {
                index++;
            }
        }
        return index == s.length();
    }
}
