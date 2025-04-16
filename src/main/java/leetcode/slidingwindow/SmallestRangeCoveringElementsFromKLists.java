package leetcode.slidingwindow;

import java.util.*;

/**
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/?envType=problem-list-v2&envId=sliding-window
 */
public class SmallestRangeCoveringElementsFromKLists { // TODO

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallestRangeCoveringElementsFromKLists().smallestRange(List.of(
                List.of(4, 10, 15, 24, 26),
                List.of(0, 9, 12, 20),
                List.of(5, 18, 22, 30)
        ))));
    }

    public int[] smallestRange(List<List<Integer>> nums) {

        int leftBorder = 0, rightBorder = nums.getFirst().getLast();

        for (List<Integer> l : nums) {
            leftBorder = Math.max(l.getFirst(), leftBorder);
            rightBorder = Math.min(l.getLast(), rightBorder);
        }

        List<Integer> collect = nums.stream().flatMap(Collection::stream).sorted(Comparator.naturalOrder()).toList();

        Integer l = null;
        Integer r = null;

        LinkedList<Integer> stack = new LinkedList<>();

        for (Integer item : collect) {
            if (item > rightBorder || item < leftBorder) continue;

            if (stack.size() < 2) {
                stack.add(item);
                continue;
            }
            int dif = stack.peekLast() - stack.peekFirst();
            int dif1 = stack.peekLast() - item;
            int dif2 = item - stack.peekFirst();

            if (dif1 < dif2 && dif1 < dif) {
                stack.pollFirst();
                stack.push(item);
            } else if (dif2 < dif1 && dif2 < dif) {
                stack.pollLast();
                stack.add(item);
            }
        }
        return new int[]{stack.pollFirst(), stack.pollLast()};
    }
}
