package leetcode.backtracking;

/**
 * https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
 * <p>
 * https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 */
public class ConstructSmallestNumberFromDIString {
    public static void main(String[] args) {
        System.out.println(new ConstructSmallestNumberFromDIString().smallestNumber("IDI")); // 1324
//        System.out.println(new ConstructSmallestNumberFromDIString().smallestNumber("DDD")); //4321
//        System.out.println(new ConstructSmallestNumberFromDIString().smallestNumber("IIIDIDDD")); //123549876
    }

    // ID 132
    // IDD 1432
    // IDDD 15432
    // IIDDD 126543
    // DDIDDIID 321654798


    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder();
        traverse(pattern, ans, new StringBuilder(), new int[10]);
        return ans.toString();
    }

    private void traverse(String pattern, StringBuilder ans, StringBuilder sb, int[] track) {
        if (sb.length() == pattern.length()) {
            System.out.println(sb);
            // check
            // ans = sb;
            return;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (track[i] == 1) continue;
            track[i] = 1;
            if (i == 0) {
                if (pattern.charAt(0) == 'I') {
                    sb.append("1");
                    track[1] = 1;
                } else {
                    //sb.append();?
                }
            } else {
                if (pattern.charAt(i) == 'I') {
                    int v = (int) sb.charAt(i - 1);
                    sb.append(v + 1);
                } else {
                    int v = Integer.valueOf(sb.substring(i - 1, i));
                    sb.append(v - 1);
                }
            }
            traverse(pattern, ans, sb, track);
            track[i] = 0;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
