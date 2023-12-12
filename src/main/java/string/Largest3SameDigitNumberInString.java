package string;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/?envType=daily-question&envId=2023-12-04
 */
public class Largest3SameDigitNumberInString {

    public static void main(String[] args) {
        System.out.println(new Largest3SameDigitNumberInString().largestGoodInteger("6777133339")); // 777
        System.out.println(new Largest3SameDigitNumberInString().largestGoodInteger("2300019")); // 000
        System.out.println(new Largest3SameDigitNumberInString().largestGoodInteger("42352338")); // ""
    }

    public String largestGoodInteger(String num) {
        String ans = "";
        int count = 0;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i - 1) == num.charAt(i)) {
                count++;
            } else {
                count = 0;
            }
            if (count == 2) {
                String sub = num.substring(i - 2, i + 1);
                if (ans.length() == 0 || sub.charAt(0) > ans.charAt(0)) {
                    ans = sub;
                    if (ans.charAt(0) == '9') break;
                }
            }
        }
        return ans;
    }
}
