package array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/build-an-array-with-stack-operations/
 * <p>
 * You are given an integer array target and an integer n.
 * <p>
 * You have an empty stack with the two following operations:
 * <p>
 * "Push": pushes an integer to the top of the stack.
 * "Pop": removes the integer on the top of the stack.
 * You also have a stream of the integers in the range [1, n].
 * <p>
 * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:
 * <p>
 * If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
 * If the stack is not empty, pop the integer at the top of the stack.
 * If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
 * Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
 */
public class BuildanArrayWithStackOperations {

    public static void main(String[] args) {
        System.out.println(new BuildanArrayWithStackOperations().buildArray(new int[]{1, 3}, 3));
        System.out.println(new BuildanArrayWithStackOperations().buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(new BuildanArrayWithStackOperations().buildArray(new int[]{1, 2}, 4));
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        var push = "Push";
        var pop = "Pop";
        int i = 0;
        int elem = 1;
        while (i < target.length) {
            if (target[i] == elem) {
                res.add(push);
                i++;
            } else {
                res.add(push);
                res.add(pop);
            }
            elem++;
        }
        return res;
    }
}
