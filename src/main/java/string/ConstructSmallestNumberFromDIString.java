package string;

/**
 * https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
 *
 * https://www.geeksforgeeks.org/form-minimum-number-from-given-sequence/
 */
public class ConstructSmallestNumberFromDIString {
    public static void main(String[] args) {
        System.out.println(new ConstructSmallestNumberFromDIString().smallestNumber("IDI")); // 1324
        System.out.println(new ConstructSmallestNumberFromDIString().smallestNumber("DDD")); //4321
        System.out.println(new ConstructSmallestNumberFromDIString().smallestNumber("IIIDIDDD")); //123549876
    }

    // ID 132
    // IDD 1432
    // IDDD 15432
    // IIDDD 126543
    // DDIDDIID 321654798


    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < pattern.length() + 1; i++) {
            ans.append(i + 1);
        }

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == 'D') {

            } else {

            }
        }


        return ans.toString();
    }
}
