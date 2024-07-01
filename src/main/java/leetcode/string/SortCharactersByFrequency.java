package leetcode.string;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree")); // eert
        System.out.println(new SortCharactersByFrequency().frequencySort("cccaaa")); // aaaccc
        System.out.println(new SortCharactersByFrequency().frequencySort("Aabb")); // bbAa
    }

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, entry.getValue())));
        }
        return sb.toString();
    }
}
