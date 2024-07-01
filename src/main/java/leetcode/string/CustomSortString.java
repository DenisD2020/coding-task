package leetcode.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/custom-sort-string/description/
 */
public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(new CustomSortString().customSortString("cba", "abcd")); // cbad
        System.out.println(new CustomSortString().customSortString("bcafg", "abcd")); // bcad
    }

    public String customSortString(String order, String s) {
        Character[] sArr = s.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        Arrays.sort(sArr, Comparator.comparingInt(order::indexOf));
        return Arrays.stream(sArr).map(String::valueOf).collect(Collectors.joining());
    }

}
