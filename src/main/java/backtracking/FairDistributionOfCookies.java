package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fair-distribution-of-cookies/description/
 */
public class FairDistributionOfCookies { // TODO

    public static void main(String[] args) {
        System.out.println(new FairDistributionOfCookies().distributeCookies(new int[]{8, 15, 10, 20, 8}, 2));
//        System.out.println(new FairDistributionOfCookies().distributeCookies(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3));
    }

    public int distributeCookies(int[] cookies, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(cookies, k, ans, new ArrayList<>(), new int[cookies.length], 0);
        return -1;
    }

    private void solve(int[] cookies, int k, List<List<Integer>> ans, List<List<Integer>> temp, int[] track, int index) {
        if (temp.size() == k) {

        }



        for (int i = 0 ; i < cookies.length; i++ ){

        }

    }
}
