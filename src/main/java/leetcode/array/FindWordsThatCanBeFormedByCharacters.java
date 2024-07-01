package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/
 */
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
//        System.out.println(new FindWordsThatCanBeFormedByCharacters().countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach")); // 6
//        System.out.println(new FindWordsThatCanBeFormedByCharacters().countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr")); // 10
        System.out.println(new FindWordsThatCanBeFormedByCharacters().countCharacters(new String[]{"skwgxuuuumkfurejmqrbipvlavdrozjyxhagbwetabjwevfsegqfpllgafm", "ufvpzzgpswnk", "tcouxmlrnfyoxvkeglchhryykmdvgvdxpookbtiyhuthoqsnqbowewpfgbcy", "qwpttmxzazkkfqqtrnkaejifligdvgnyvtmppjbkeuqryxzqyegttvhzolpztvigxygzvsppurijaekb", "vbtvbheurzbglzljczmziitkbmtoybiwhoyfrsxvfveaxchebjdzdnnispzwbrgrbcdaistps"}, "avyteswqppomeojxoybotzriuvxolmllevluauwb")); // 10
    }

    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] charsArr = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charsArr[chars.charAt(i) - 'a']++;
        }
        for (String w : words) {
            int[] temp = Arrays.copyOfRange(charsArr, 0, charsArr.length);
            boolean isGood = true;
            for (char c : w.toCharArray()) {
                temp[c - 'a']--;
                if (temp[c - 'a'] < 0) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) ans += w.length();
        }
        return ans;
    }
}
