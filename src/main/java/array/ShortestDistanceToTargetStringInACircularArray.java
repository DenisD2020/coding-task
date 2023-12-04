package array;

/**
 * https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/description/
 */
public class ShortestDistanceToTargetStringInACircularArray {

    public static void main(String[] args) {

        System.out.println(new ShortestDistanceToTargetStringInACircularArray().closetTarget(new String[]{
                        "hsdqinnoha", "mqhskgeqzr", "zemkwvqrww", "zemkwvqrww", "daljcrktje",
                        "fghofclnwp", "djwdworyka", "cxfpybanhd", "fghofclnwp", "fghofclnwp"},
                "zemkwvqrww", 8)); // 4

        System.out.println(new ShortestDistanceToTargetStringInACircularArray().closetTarget(new String[]{
                "hello", "i", "am", "leetcode", "hello"}, "hello", 1)); // 1

        System.out.println(new ShortestDistanceToTargetStringInACircularArray().closetTarget(new String[]{
                "a", "b", "leetcode"}, "leetcode", 0)); // 1

        System.out.println(new ShortestDistanceToTargetStringInACircularArray().closetTarget(new String[]{
                "i", "eat", "leetcode"}, "ate", 0)); // -1
    }


    public int closetTarget(String[] words, String target, int startIndex) { // TODO
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                if (i > startIndex) {
                    ans = Math.min(ans, i - startIndex);
                    ans = Math.min(ans, startIndex + words.length - i);
                } else {
                    ans = Math.min(ans, startIndex - i);
                    ans = Math.min(ans, words.length  - startIndex + i);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
