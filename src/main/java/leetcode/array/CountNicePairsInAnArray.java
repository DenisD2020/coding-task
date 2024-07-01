package leetcode.array;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/count-nice-pairs-in-an-array/description/
 */
public class CountNicePairsInAnArray { // TODO time limit exceeded

    public static void main(String[] args) {
//        System.out.println(new CountNicePairsInAnArray().countNicePairs(new int[]{42, 11, 1, 97})); // 2
//        System.out.println(new CountNicePairsInAnArray().countNicePairs(new int[]{13, 10, 35, 24, 76})); // 4

        System.out.println(new CountNicePairsInAnArray().countNicePairs(new int[]{8047408,192867140,497837845,279787822,151999002,168514912,193424242,399636844,132424231,476736524,267958611,493350382,476382727,232939232,197000791,295291645,126313621,374645524,7956597,1376731,496463745,234481430,359130803,287625836,250572050,42311324,477434624,493231448,493231244,150494051,184645534,365252413,495764582,335976531,384564332,377151623,198736741,335161533,245552540,194897341,83911938,220562020,496645745,287151782,374635526,372483324,485101584,271797172,244949442,254333303,251635002,459181805,472392123,241350140,256121502,336895621,354635302,358909704,194525491,3606063,194150341,63477436,341936141,60299206,69811896,369928813,229926920,435310522,299542980,463777364,164534512,305885501,437181734,74288247,487281835,171161022,423966312,496989544,452633252,252433101,141565141,315895501,478897927,232532230,472451262,160504114,476666674,6179716,251483002,474777474,443532332,475808424,457514604,400936002,384878483,172616122,283292232,165645615,392000144,378636873}));
    }

    public int countNicePairs(int[] nums) {
        long ans[] = new long[1];
        backTracking(nums, new ArrayList<>(), new ArrayList<>(), new int[nums.length], 0, ans);
        return (int)ans[0];

    }

    private void backTracking(int[] nums, ArrayList<Integer> res, ArrayList<Integer> temp, int[] track, int index, long ans[]) {
        if (temp.size() == 2 && isNice(temp)) {
            System.out.println(temp);
            ans[0]++;
        }
        for (int i = index; i < nums.length; i++) {
            if (track[i] == 1) continue;
            track[i] = 1;
            temp.add(nums[i]);
            backTracking(nums, res, temp, track, i, ans);
            track[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isNice(ArrayList<Integer> temp) {
        int i1 = temp.get(0);
        int i2 = temp.get(1);
        int i1rev = reverse(i1);
        int i2rev = reverse(i2);
        return (i1 + i2rev) == (i2 + i1rev);
    }

    private int reverse(int i) {
        String ans = new StringBuilder()
                .append(i)
                .reverse()
                .toString();
        return Integer.parseInt(ans);
    }
}
