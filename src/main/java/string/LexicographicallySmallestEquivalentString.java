package string;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/solutions/3047979/2-solutions-1ms-4ms-with-explanation-java/
 * <p>
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 * We say s1[i] and s2[i] are equivalent characters.
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
 * Equivalent characters follow the usual rules of any equivalence relation:
 * Reflexivity: 'a' == 'a'.
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 * For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
 * Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
 */
public class LexicographicallySmallestEquivalentString {
    public static void main(String[] args) {
//        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString("parker", "morris", "parser")); // makkek
//        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString("hello", "world", "hold")); // hdld
//        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString("leetcode", "programs", "sourcecode")); // aauaaaaada
        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString("cgokcgerolkgksgbhgmaaealacnsshofjinidiigbjerdnkolc",
                "rjjlkbmnprkslilqmbnlasardrossiogrcboomrbcmgmglsrsj",
                "bxbwjlbdazfejdsaacsjgrlxqhiddwaeguxhqoupicyzfeupcn")); // axawaaaaazaaaaaaaaaaaaaxaaaaawaaauxaaauaaayzaauaaa
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Set<TreeSet<Character>> graph = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            TreeSet<Character> found = null;
            for (TreeSet<Character> s : graph) {
                if (s.contains(c1) || s.contains(c2)) {
                    found = s;
                    break;
                }
            }
            if (found == null) {
                found = new TreeSet<>();
                graph.add(found);
            }
            found.add(c1);
            found.add(c2);
        }

        StringBuilder ans = new StringBuilder(baseStr.length());
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            TreeSet found = null;
            for (TreeSet<Character> s : graph) {
                if (s.contains(c)) {
                    found = s;
                    break;
                }
            }
            if (found != null) {
                ans.append(found.first());
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
