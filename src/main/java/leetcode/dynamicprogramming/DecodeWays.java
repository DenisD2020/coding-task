package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/decode-ways/description/?envType=daily-question&envId=2023-12-25
 */
public class DecodeWays {

    // A - 1
    // Z - 26
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226")); // 3
        System.out.println(new DecodeWays().numDecodings("27")); // 1
        System.out.println(new DecodeWays().numDecodings("10")); // 1
        System.out.println(new DecodeWays().numDecodings("12")); // 2
        System.out.println(new DecodeWays().numDecodings("06")); // 0
        System.out.println(new DecodeWays().numDecodings("2101")); // 1
    }

    public int numDecodings(String s) {


        return 0;
    }
}
