package intewiew;

import com.google.common.base.Strings;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class UpWork {

    /**
     * Run-length encoding is a fast and simple method of encoding strings. The basic idea is to represent repeated
     * successive characters as a single count and character. For example, the string "111122233411" would be encoded as "4132231421".
     * Write a class that will implement the Iterator interface and would be able to iterate over the encoded string to produce a decoded result
     * (every call to next() method should produce one number at a time). However, for simplicity, we will only operate with numbers.
     * <p>
     * Example input sequence #1:
     * 1341
     * Example output sequence #1:
     * 31111
     * Example sequence #2:
     * 482714
     * Example output #2:
     * 8888774
     */

    public static void main(String[] args) {
        /**
         * decode 1341 -> 31111
         *
         * decode 482714 -> 8888774
         */
        Decode decode = new Decode("1341"); // 31111
        while (decode.hasNext()) {
            System.out.println(decode.next());
        }

        System.out.println("-------------------");

        decode = new Decode("482714"); // 31111
        while (decode.hasNext()) { // O(n) ->  O(9 * n)
            System.out.println(decode.next()); // O(1)
        }
    }

    static class Decode implements Iterator<Character> {

        private final String val;

        private int index = 0; // AtomicInteger incrementAndGet
        private int currentCount = 0; // Atomic
        private Character currentValue; // Atomic

        public Decode(String str) {
            if (Strings.isNullOrEmpty(str)){
                throw new RuntimeException();
            }
            if (str.length() % 2 != 0) {
                throw new RuntimeException();
            }
            this.val = str;
        }

        @Override
        public boolean hasNext() {
            return index < val.length() || currentCount > 0;
        }

        @Override
        public Character next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (currentCount == 0) {
                int count = Character.getNumericValue(val.charAt(index++));
                char value = val.charAt(index++);
                currentCount = count;
                currentValue = value;
            }
            currentCount--;
            return currentValue;
        }
    }
}
