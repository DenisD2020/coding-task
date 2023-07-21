package prefixsum;

public class MaximumSumHourglass {

    public static void main(String[] args) {
/*        System.out.println(new MaximumSumHourglass().maxSum(new int[][]{
                new int[]{6, 2, 1, 3},
                new int[]{4, 2, 1, 5},
                new int[]{9, 2, 8, 7},
                new int[]{4, 1, 2, 9}
        }));
        System.out.println(new MaximumSumHourglass().maxSum(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        }));*/
/*        System.out.println(new MaximumSumHourglass().maxSum(new int[][]{
                new int[]{6, 2, 1, 3},
                new int[]{4, 2, 1, 5},
                new int[]{9, 2, 8, 7},
                new int[]{4, 1, 2, 9}
        }));*/
        System.out.println(new MaximumSumHourglass().maxSum(new int[][]{
                new int[]{520626, 685427, 788912, 800638, 717251, 683428},
                new int[]{23602, 608915, 697585, 957500, 154778, 209236},
                new int[]{287585, 588801, 818234, 73530, 939116, 252369},
        }));
    }

    public int maxSum(int[][] grid) {
        int sum = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[i].length - 3; j++) {
                int first = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
                int second = grid[i + 1][j + 1];
                int three = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                sum = Math.max(sum, first + second + three);
            }
        }
        return sum;
    }
}
