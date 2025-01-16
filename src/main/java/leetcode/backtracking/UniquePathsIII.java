package leetcode.backtracking;


/**
 * https://leetcode.com/problems/unique-paths-iii/description/
 */
public class UniquePathsIII { // TODO
    public static void main(String[] args) {
        System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 2, -1}
        })); // 2
        System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{
                new int[]{1, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 2}
        })); // 4
        System.out.println(new UniquePathsIII().uniquePathsIII(new int[][]{
                new int[]{0, 1},
                new int[]{2, 0}
        })); // 0
    }

    int ans = 0;

    public int uniquePathsIII(int[][] grid) {



        return -1;
    }
}
