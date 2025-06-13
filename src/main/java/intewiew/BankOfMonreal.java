package intewiew;

import java.util.*;

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
        System.out.println(BankOfMonreal.processArray(new int[]{0, -1, 1, -2, 3, 2, -5})); // -2, -5
        // Expected [-2, -5]
        System.out.println(BankOfMonreal.processArray(new int[]{-1, -2, -3, -1, -2, -3, -1, -2, -3, -1, -2, -3, -1, -2, -3, -5, 1, 1, 1})); // -1, -2, -3, -1, -2, -3, -1, -2, -3, -1, -2, -3, -5
         // Expected[-1, -2, -3, -1, -2, -3, -1, -2, -3, -1, -2, -3, -5]

        int[] bigInput = new int[1_000_000];
        for (int i = 0; i < bigInput.length; i++) {
            if (i % 2 == 0) {
                bigInput[i] = -i;
            } else {
                bigInput[i] = (i % 100) + 1;
            }
        }

        long startTime = System.currentTimeMillis();
        List<Integer> result = processArray(bigInput);
        long endTime = System.currentTimeMillis();

        System.out.println("Result size: " + result.size());
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    public static List<Integer> processArray(int[] input) {
        int[] tempArray = new int[input.length / 2];
        int size = 0;

        for (int num : input) {
            if (num < 0) {
                if (size == tempArray.length) {
                    int[] newArray = new int[tempArray.length * 2];
                    System.arraycopy(tempArray, 0, newArray, 0, size);
                    tempArray = newArray;
                }
                tempArray[size++] = num;
            } else if (num > 0) {
                int indexToRemove = num - 1;
                if (indexToRemove < size) {
                    System.arraycopy(
                            tempArray,
                            indexToRemove + 1,
                            tempArray,
                            indexToRemove,
                            size - indexToRemove - 1
                    );
                    size--;
                }
            }
        }

        List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(tempArray[i]);
        }

        return result;
    }

    public static List<Integer> processArray2(int[] input) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int value : input) {
            if (value < 0) {
                deque.add(value);
            } else if (value > 0) {
                if (value - 1 < deque.size()) {
                    List<Integer> tempList = new ArrayList<>(deque);
                    tempList.remove(value - 1);
                    deque.clear();
                    deque.addAll(tempList);
                }
            }
        }

        return new ArrayList<>(deque);
    }
}
