package leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 */
public class GetMaximumGeneratedArray {

    public static void main(String[] args) {
        System.out.println(new GetMaximumGeneratedArray().getMaximumGenerated(7));
        System.out.println(new GetMaximumGeneratedArray().getMaximumGenerated(2));
        System.out.println(new GetMaximumGeneratedArray().getMaximumGenerated(3));
    }

    public int getMaximumGenerated(int n) {

        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;



        return 0;
    }
}
