package leetcode.string;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("the sky is blue")); //  blue is sky the
        System.out.println(new ReverseWordsInAString().reverseWords("  hello world  ")); //  world hello
        System.out.println(new ReverseWordsInAString().reverseWords(" a good   example")); //  example good a
    }

    public String reverseWords(String s) { // 85%
        int L = s.length();
        StringBuilder ans = new StringBuilder(L + 1);
        StringBuilder word = new StringBuilder(L + 1);

        for (int i = 0; i < L; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (!word.isEmpty()) {
                    ans.insert(0, " ");
                    ans.insert(0, word);
                    word.setLength(0);
                }
                continue;
            }
            word.append(c);
        }
        if (!word.isEmpty()) {
            ans.insert(0, " ");
            ans.insert(0, word);
        }
        ans.setLength(ans.length() - 1);
        return ans.toString();
    }

/*    public String reverseWords(String s) { // 85%
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (String item : s.trim().split(" ")) {
            if (item.isEmpty()) continue;
            ans.insert(0, " ");
            ans.insert(0, item);
        }
        ans.setLength(ans.length() - 1);
        return ans.toString();
    }*/
}
