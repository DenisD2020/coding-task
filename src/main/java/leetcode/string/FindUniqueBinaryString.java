package leetcode.string;

/**
 * https://leetcode.com/problems/find-unique-binary-string/
 */
public class FindUniqueBinaryString {

    public static void main(String[] args) {
        new FindUniqueBinaryString().findDifferentBinaryString(new String[]{
                "01",
                "10"
        }); // 11
        new FindUniqueBinaryString().findDifferentBinaryString(new String[]{
                "00",
                "01"
        }); // 11 or 10
        new FindUniqueBinaryString().findDifferentBinaryString(new String[]{
                "111",
                "011",
                "001"
        }); // "101" "000", "010", "100", and "110"
    }

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder(nums.length);
        for (int i = 0; i < nums.length; i++) {
            char c = nums[i].charAt(i);
            sb.append(c == '0' ? "1" : "0");
        }
        return sb.toString();
    }
}
