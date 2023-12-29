package string;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/?envType=daily-question&envId=2023-12-24
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations("0100")); // 1
        System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations("01")); // 0
        System.out.println(new MinimumChangesToMakeAlternatingBinaryString().minOperations("1111")); // 2
    }

    public int minOperations(String s) {
        int changesToZeroOne = 0;
        int changesToOneZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) { // четные и 0
                if (s.charAt(i) == '0') {
                    changesToZeroOne++;
                } else {
                    changesToOneZero++;
                }
            } else { // нечётный
                if (s.charAt(i) == '0') {
                    changesToOneZero++;
                } else {
                    changesToZeroOne++;
                }
            }
        }
        return Math.min(changesToZeroOne, changesToOneZero);
    }
}
