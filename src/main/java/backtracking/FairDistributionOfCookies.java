package backtracking;

/**
 * https://leetcode.com/problems/fair-distribution-of-cookies/description/
 */
public class FairDistributionOfCookies { // TODO

    public static void main(String[] args) {
        System.out.println(new FairDistributionOfCookies().distributeCookies(new int[]{8, 15, 10, 20, 8}, 2)); // 31
//        System.out.println(new FairDistributionOfCookies().distributeCookies(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3)); // 7
    }

    public int distributeCookies(int[] cookies, int k) {
        return dfs(cookies, new int[k], k, 0, 0);
    }

    private int dfs(int[] cookies, int[] distribute, int k, int kk, int distributed) {

        if (k - distributed > cookies.length -  kk) {
            return Integer.MAX_VALUE;
        }

        if (kk == cookies.length) {
            int unf = -1;
            for (int item : distribute) {
                unf = Math.max(unf, item);
            }
            return unf;
        }


        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            if (distribute[i] == 0) {
                distributed++;
            }
            distribute[i] += cookies[kk];
            ans = Math.min(ans, dfs(cookies, distribute, k, kk + 1, distributed));
            distribute[i] -= cookies[kk];
            if (distribute[i] == 0) {
                distributed--;
            }
        }
        return ans;
    }
}
