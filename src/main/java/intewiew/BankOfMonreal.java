package intewiew;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * public static List<Integer> processArray(int[] input)
 * The input array will be big (about one million ints), so pay attention to efficiency. Most of the numbers will range from -255 to 255, but once in a while they will be bigger.
 * The method should return a list of integers that is constructed according to the following instructions:
 * Process the values in the input array sequentially. If the value is negative, add it to the list that you will return. If the value is positive, do not add it.
 * Instead, remove the n-th element in the list to be returned, where n = value. For example, if the value is 2, remove the 2nd element.
 * If the removal index is out of bounds, do nothing. Also do nothing when the value is zero. The ratio of positive to negative ints will be roughly equal.
 * Example: for the input [-1, -2, -3, 2] the result is [-1, -3].
 */

/**
 * Describe the algorithmic complexity of your solution in a few sentences. Use big-O notation,
 * such as O(ո), whenever it makes sense.
 * Also, explain why you chose your particular approach and data structure(s),
 * and how that affects the performance of your program.
 */
public class BankOfMonreal {

    public static void main(String[] args) {
        System.out.println(BankOfMonreal.processArray(new int[]{-1, -2, -3, 2})); // -1, -3
    }

    public static List<Integer> processArray(int[] input) {
        int initialCapacity = input.length / 3;
        List<Integer> tmp = new ArrayList<>(initialCapacity);
        BitSet removeIndices = new BitSet(initialCapacity);

        for (int num : input) {
            if (num < 0) {
                tmp.add(num);
            } else if (num > 0 && !tmp.isEmpty()) {
                int index = num - 1;
                if (index < tmp.size()) {
                    removeIndices.set(index);
                }
            }
        }

        List<Integer> result = new ArrayList<>(tmp.size() - removeIndices.cardinality());
        for (int i = 0; i < tmp.size(); i++) {
            if (!removeIndices.get(i)) {
                result.add(tmp.get(i));
            }
        }
        return result;
    }
}
