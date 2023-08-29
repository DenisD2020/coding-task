package array;


/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 * <p>
 * Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.
 * <p>
 * There is one laser beam between any two security devices if both conditions are met:
 * <p>
 * The two devices are located on two different rows: r1 and r2, where r1 < r2.
 * For each row i where r1 < i < r2, there are no security devices in the ith row.
 * Laser beams are independent, i.e., one beam does not interfere nor join with another.
 * <p>
 * Return the total number of laser beams in the bank.
 */
public class NumberofLaserBeamsinaBank {

    public static void main(String[] args) {
        System.out.println(new NumberofLaserBeamsinaBank().numberOfBeams(new String[]{
                "011001",
                "000000",
                "010100",
                "001000"})); // 8

        System.out.println(new NumberofLaserBeamsinaBank().numberOfBeams(new String[]{
                "000",
                "111",
                "000"})); // 0
    }

    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = 0;
        for (String level : bank) {
            int current = count(level);
            if (current != 0) {
                res += prev * current;
                prev = current;
            }
        }
        return res;
    }

    private int count(String level) {
        int count = 0;
        for (int i = 0; i < level.length(); i++) {
            if (level.charAt(i) == '1') count++;
        }
        return count;
    }
}
