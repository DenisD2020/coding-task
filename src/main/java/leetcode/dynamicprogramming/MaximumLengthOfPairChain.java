package leetcode.dynamicprogramming;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/description/
 */
public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
/*        System.out.println(new MaximumLengthOfPairChain().findLongestChain(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4}
        })); // [1,2] -> [3,4].

        System.out.println(new MaximumLengthOfPairChain().findLongestChain(new int[][]{
                new int[]{1, 2},
                new int[]{7, 8},
                new int[]{4, 5}
        })); // [1,2] -> [4,5] -> [7,8].*/

        System.out.println(new MaximumLengthOfPairChain().findLongestChain(new int[][]{
                new int[]{7, 9},
                new int[]{4, 5},
                new int[]{7, 9},
                new int[]{-7, -1},
                new int[]{0, 10},
                new int[]{3, 10},
                new int[]{3, 6},
                new int[]{2, 3}
        })); // 4  (-7,-1) -> (2,3) -> (4,5) -> (7,9)
    }

    public int findLongestChain(int[][] pairs) { // 57.22%
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        Deque<Integer> queue = new LinkedList<>();
        queue.add(pairs[0][1]);
        for (int i = 1; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if (queue.getLast() < pair[0]) {
                queue.add(pair[1]);
            }
        }
        return queue.size();
    }
}
