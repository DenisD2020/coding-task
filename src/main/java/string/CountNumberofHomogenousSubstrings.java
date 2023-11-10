package string;

/**
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/description/
 * <p>
 * a - 1
 * aa - 1 + 2
 * aaa - 1 + 2 + 3
 * aaaa - 1 + 2 + 3 + 4
 * aaaa - 10
 * aaaaa - 15
 */
public class CountNumberofHomogenousSubstrings {

    public static void main(String[] args) {
        System.out.println(new CountNumberofHomogenousSubstrings().countHomogenous("aa")); // 3
        System.out.println(new CountNumberofHomogenousSubstrings().countHomogenous("abbcccaa")); // 13
        System.out.println(new CountNumberofHomogenousSubstrings().countHomogenous("xy")); // 2
        System.out.println(new CountNumberofHomogenousSubstrings().countHomogenous("aaaaa")); // 15
    }

    public int countHomogenous(String s) {
        long ans = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(l) == s.charAt(r)) {
                ans += r - l + 1;
            } else {
                ans += 1;
                l = r;
            }
        }
        return (int) (ans % (Math.pow(10, 9) + 7));
    }

    // too slow
    public int countHomogenous2(String s) {
        if (s.length() == 1) return 1;
        long ans = 0;
        int l = 0, r = 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                int length = r - l;
                ans += calculate(length);
                l = r;
            }
            if (r == s.length() - 1) {
                int length = r - l + 1;
                ans += calculate(length);
                break;
            }
            r++;
        }
        return (int) (ans % (1000000007));
    }

    private long calculate(long length) {
        long res = 0;
        for (long i = 1; i < length + 1; i++) {
            res += i;
        }
        return res;
    }
}
