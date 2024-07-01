package leetcode.prefixsum;

public class FindPivotInteger {

    public static void main(String[] args) {
        System.out.println(new FindPivotInteger().pivotInteger(8));
        System.out.println(new FindPivotInteger().pivotInteger(1));
        System.out.println(new FindPivotInteger().pivotInteger(4));
    }

    public int pivotInteger(int n) {
        int res = -1;
        int summLeft = ((1 + n) * n) / 2;
        int summRight = 0;

        for (int i = n; i > 0; i--) {
            summRight += i;
            if (summRight == summLeft) {
                res = i;
                break;
            }
            summLeft -= i;
        }
        return res;
    }
}
