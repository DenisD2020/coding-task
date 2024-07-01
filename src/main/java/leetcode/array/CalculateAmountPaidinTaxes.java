package leetcode.array;

public class CalculateAmountPaidinTaxes {
    public static void main(String[] args) {
       System.out.println(new CalculateAmountPaidinTaxes().calculateTax(new int[][]{
                new int[]{3, 50},
                new int[]{7, 10},
                new int[]{12, 25}}, 10)); // 2.65
        System.out.println(new CalculateAmountPaidinTaxes().calculateTax(new int[][]{
                new int[]{1, 0},
                new int[]{4, 25},
                new int[]{5, 50}}, 2)); // 0.25

        System.out.println(new CalculateAmountPaidinTaxes().calculateTax(new int[][]{
                new int[]{10, 10}}, 5)); // 0.5
    }

    public double calculateTax(int[][] brackets, int income) {
        double res = 0d;
        int prevIncome = 0;
        for (int i = 0; i < brackets.length; i++) {
            if (income - brackets[i][0] >= 0) {
                res = res + ((((double) brackets[i][0] - prevIncome) * (double) brackets[i][1]) / 100);
            } else if (income - prevIncome > 0){
                res = res + ((((double) income - prevIncome) * (double) brackets[i][1]) / 100);
            } else {
                break;
            }
            prevIncome = brackets[i][0];
        }
        return res;
    }
}
