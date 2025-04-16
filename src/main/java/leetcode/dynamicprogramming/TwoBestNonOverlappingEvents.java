package leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/two-best-non-overlapping-events/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class TwoBestNonOverlappingEvents { // TODO

    public static void main(String[] args) {
        System.out.println(new TwoBestNonOverlappingEvents().maxTwoEvents(
                new int[][]{
                        new int[]{1, 3, 2}, new int[]{4, 5, 2}, new int[]{2, 4, 3}
                }
        )); // 4

/*        System.out.println(new TwoBestNonOverlappingEvents().maxTwoEvents(
                new int[][]{
                        new int[]{1, 3, 2}, new int[]{4, 5, 2}, new int[]{1, 5, 5}
                }
        )); // 5

        System.out.println(new TwoBestNonOverlappingEvents().maxTwoEvents(
                new int[][]{
                        new int[]{1, 5, 3}, new int[]{1, 5, 1}, new int[]{6, 6, 5}
                }
        )); // 8*/

    }

    public int maxTwoEvents(int[][] events) {
        //Create a PriorityQueue to store the pair ending time and value.
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                Comparator.comparingInt(Pair::getKey)
        );

        //Sort the array in ascending order
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

        int maxVal = 0, maxSum = 0;

        for (int[] event : events) {
            // Poll all valid events from queue and take their maximum.
            while (!pq.isEmpty() && pq.peek().getKey() < event[0]) {
                maxVal = Math.max(maxVal, pq.peek().getValue());
                pq.poll();
            }

            maxSum = Math.max(maxSum, maxVal + event[2]);
            pq.add(new Pair(event[1], event[2]));
        }

        return maxSum;
    }

    private record Pair(Integer key, Integer value) {
        Integer getKey() {
            return key;
        }

        Integer getValue() {
            return value;
        }
    }
}


/*
public int maxTwoEvents(int[][] events) { // Time Limit Exceeded

    Arrays.sort(events, (arr1, arr2) -> {
        if (arr1[0] == arr2[0]) {
            return arr1[2] - arr2[2];
        }
        return arr1[0] - arr2[0];
    });

    int ans = 0;
    for (int i = 0; i < events.length; i++) {
        int[] startEvent = events[i];
        for (int j = events.length - 1; j > i; j--) {
            int[] endEvent = events[j];
            if (startEvent[1] < endEvent[0]) {
                ans = Math.max(ans, startEvent[2] + endEvent[2]);
            }
        }
        ans = Math.max(ans, startEvent[2]);
    }
    return ans;

*/

