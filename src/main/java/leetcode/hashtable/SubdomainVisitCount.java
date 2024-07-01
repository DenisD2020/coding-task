package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        System.out.println(new SubdomainVisitCount().subdomainVisits(new String[]{"9001 discuss.leetcode.com"})); // "9001 leetcode.com","9001 discuss.leetcode.com","9001 com"
        System.out.println(new SubdomainVisitCount().subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"})); // "901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        var ans = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            String split[] = s.split(" ");
            Integer num = Integer.valueOf(split[0]);
            String[] domains = split[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int i = domains.length - 1; i >= 0; i--) {
                sb.insert(0, domains[i]);
                Integer integer = map.getOrDefault(sb.toString(), 0);
                map.put(sb.toString(), integer + num);
                if (i > 0) sb.insert(0, ".");
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())        {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
