package leetcode.array;

/**
 * https://leetcode.com/problems/verifying-an-alien-dictionary/description/
 */
public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {

        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[]{
                "hello", "hello"}, "abcdefghijklmnopqrstuvwxyz")); // true

/*        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[]{
                "hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")); // true

        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[]{
                "word", "world", "row"}, "worldabcefghijkmnpqstuvxyz")); // false

        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[]{
                "apple", "app"}, "abcdefghijklmnopqrstuvwxyz")); // false

        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[]{
                "kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz")); // true*/

        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(new String[]{
                        "zirqhpfscx", "zrmvtxgelh", "vokopzrtc", "nugfyso", "rzdmvyf",
                        "vhvqzkfqis", "dvbkppw", "ttfwryy", "dodpbbkp", "akycwwcdog"},
                "khjzlicrmunogwbpqdetasyfvx")); // false
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.equals(s2)) continue;
            for (int j = 0; j < s1.length(); j++) {
                int i1 = order.indexOf(s1.charAt(j));
                int i2 = order.indexOf(s2.charAt(j));
                if (i1 > i2) {
                    return false;
                } else if (i1 < i2) {
                    break;
                }
                if (j + 1 > s2.length() - 1) return false;
            }
        }
        return true;
    }
}
