package leetcode.hashtable;

/**
 * https://leetcode.com/problems/integer-to-roman/description/
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(9)); // IX
        System.out.println(new IntegerToRoman().intToRoman(13)); // XIII
        System.out.println(new IntegerToRoman().intToRoman(14)); // XIV
        System.out.println(new IntegerToRoman().intToRoman(3749)); // MMMDCCXLIX
        System.out.println(new IntegerToRoman().intToRoman(58)); // LVIII
        System.out.println(new IntegerToRoman().intToRoman(1994)); // MCMXCIV
    }

    final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (num == 0) break;

            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }
}
