package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/assign-cookies/
 * <p>
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 * <p>
 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 */
public class AssignCookies {

    public static void main(String[] args) {
//        System.out.println(new AssignCookies().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1})); //1
//        System.out.println(new AssignCookies().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3})); // 2
        System.out.println(new AssignCookies().findContentChildren(new int[]{10, 9, 8, 7, 10, 9, 8, 7}, new int[]{10, 9, 8, 7})); // 4

    }

    public int findContentChildren(int[] g, int[] s) {
        int res = 0, gg = 0 , ss = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (gg < g.length && ss < s.length) {
            if (g[gg] <= s[ss]) {
                res++;
                gg++;
            }
            ss++;
        }
        return res;
    }
}
