package leetcode.string;

/**
 * https://leetcode.com/problems/rearrange-characters-to-make-target-string/description/
 */
public class RearrangeCharacterstoMakeTargetString {
    public static void main(String[] args) {
        System.out.println(new RearrangeCharacterstoMakeTargetString().rearrangeCharacters("ilovecodingonleetcode", "code")); // 2
        System.out.println(new RearrangeCharacterstoMakeTargetString().rearrangeCharacters("abcba", "abc")); // 1
        System.out.println(new RearrangeCharacterstoMakeTargetString().rearrangeCharacters("abbaccaddaeea", "aaaaa")); // 1
    }

    public int rearrangeCharacters(String s, String target) {

        int[] arr1 = new int[26], arr2 = new int[26];

        for (char c : s.toCharArray()) {
            arr1['z' - c]++;
        }
        for (char c : target.toCharArray()) {
            arr2['z' - c]++;
        }
        int ans = Integer.MAX_VALUE;
        for (char c : target.toCharArray()){
            ans = Math.min(ans, arr1['z' - c]/ arr2['z' - c]);
        }
        return ans;
    }

/*    public int rearrangeCharacters(String s, String target) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }

        boolean isExist = true;
        while (isExist) {
            for (int i = 0; i < target.length(); i++) {
                Integer integer = map.get(target.charAt(i));
                if (integer != null && integer > 0) {
                    map.put(target.charAt(i), --integer);
                } else {
                    isExist = false;
                    break;
                }
            }
            if (isExist) {
                ans++;
            }
        }
        return ans;
    }*/
}
