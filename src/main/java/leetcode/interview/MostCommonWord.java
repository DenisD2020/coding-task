package leetcode.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonWord {

    public static void main(String[] args) {
//        System.out.println(new MostCommonWord().mostCommonWord(
//                "Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"})); //  ball

        System.out.println(new MostCommonWord().mostCommonWord(
                "a, a, a, a, b,b,b,c, c", new String[]{"a"})); //  b
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] str = paragraph
                .replace(",", " ")
                .replace(".", "")
                .replace("!", "")
                .split(" ");
        HashSet<String> ban = new HashSet<>();
        ban.addAll(Arrays.asList(banned));

        Map<String, Integer> map = new HashMap<>();
        for (String s : str) {
            if (s.isEmpty()) continue;
            if (ban.contains(s)) continue;
            map.merge(s.toLowerCase(), 1, Integer::sum);
        }
        int max = 0;
        String val = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                val = key;
            }
        }
        return val;
    }
}
