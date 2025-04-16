package leetcode.array;

/**
 * https://leetcode.com/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GasStation {

    public static void main(String[] args) {
        System.out.println(new GasStation().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})); // 3
        System.out.println(new GasStation().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3})); // -1
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) return -1;

        int start = 0;
        int gasLeft = 0;
        for (int i = 0; i < length; i++) {
            gasLeft += gas[i] - cost[i];
            if (gasLeft < 0) {
                start = i + 1;
                gasLeft = 0;
            }
        }
        return start;
    }

/*    public int canCompleteCircuit(int[] gas, int[] cost) { // Time Limit Exceeded
        int ans = -1;
        for (int start = 0; start < gas.length; start++) {
            int gasCur = 0;
            for (int j = 0; j < gas.length; j++) {
                int cur = start + j;
                if (cur >= gas.length) {
                    cur = cur - gas.length;
                }
                gasCur = gasCur + gas[cur] - cost[cur];
                if (gasCur < 0) break;
            }
            if (gasCur >= 0) {
                ans = start;
                break;
            }
        }
        return ans;
    }*/
}
