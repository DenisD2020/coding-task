package slidingwindow;

public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static void main(String[] args) {
        System.out.println(new MaximumNumberofVowelsinaSubstringofGivenLength().maxVowels("abciiidef", 3)); // 3
        System.out.println(new MaximumNumberofVowelsinaSubstringofGivenLength().maxVowels("aeiou", 2)); // 2
        System.out.println(new MaximumNumberofVowelsinaSubstringofGivenLength().maxVowels("leetcode", 3)); // 2
    }

    public int maxVowels(String s, int k) {
        int ans = 0, l = 0, vowels = 0;
        for (int r = 0; r < s.length(); r++) {
            if (isVowel(s.charAt(r))) {
                vowels++;
            }
            if (r - l >= k) {
                if (isVowel(s.charAt(l))) {
                    vowels--;
                }
                l++;
            }
            ans = Math.max(ans,vowels);
        }
        return ans;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
