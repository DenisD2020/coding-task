package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 * <p>
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 * <p>
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 * <p>
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 * <p>
 * Each answer[i] is calculated considering the initial state of the boxes.
 */
public class MinimumNumberofOperationstoMoveAllBallstoEachBox {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MinimumNumberofOperationstoMoveAllBallstoEachBox().minOperations("110"))); // [1,1,3]
        System.out.println(Arrays.toString(new MinimumNumberofOperationstoMoveAllBallstoEachBox().minOperations("001011"))); // [11,8,5,4,3,4]
    }

    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        int[] forward = new int[len];
        int[] back = new int[len];

        int prev = (boxes.charAt(0) == '0' ? 0 : 1);
        for (int i = 1; i < boxes.length(); i++) {
            forward[i] += forward[i - 1] + prev;
            prev += (boxes.charAt(i) == '0' ? 0 : 1);
        }

        prev = (boxes.charAt(len - 1) == '0' ? 0 : 1);
        for (int i = len - 2; i >= 0; i--) {
            back[i] += back[i + 1] + prev;
            prev += (boxes.charAt(i) == '0' ? 0 : 1);
        }

        for(int i=0;i<len;i++) res[i] = forward[i]+back[i];

        return res;
    }

/*    public int[] minOperations(String boxes) { // O(n^2)
        int[] res = new int[boxes.length()];
        for (int start = 0; start < boxes.length(); start++) {
            for (int r = 0; r < boxes.length(); r++) {
                if (start != r && boxes.charAt(r) == '1') {
                    int len = Math.abs(r - start);
                    res[start] = res[start] + len;
                }
            }
        }
        return res;
    }*/
}
