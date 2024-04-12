package string;

import java.util.*;

/**
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/description/
 */
public class GroupsOfSpecialEquivalentStrings {
    public static void main(String[] args) {
        System.out.println(new GroupsOfSpecialEquivalentStrings().numSpecialEquivGroups(new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"})); // 3
        System.out.println(new GroupsOfSpecialEquivalentStrings().numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"})); // 3
    }

    public int numSpecialEquivGroups(String[] words) {
        HashSet<Group> groups = new HashSet<>();
        for (String word : words) {
            Group group = new Group();
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    group.even[word.charAt(i) - 'a']++;
                } else {
                    group.odd[word.charAt(i) - 'a']++;
                }
            }
            groups.add(group);
        }
        return groups.size();
    }

    static class Group {
        int[] odd = new int[26];
        int[] even = new int[26];

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Group group = (Group) o;
            return Arrays.equals(odd, group.odd) && Arrays.equals(even, group.even);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(odd);
            result = 31 * result + Arrays.hashCode(even);
            return result;
        }
    }
}
