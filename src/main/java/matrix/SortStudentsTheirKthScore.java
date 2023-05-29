package matrix;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
public class SortStudentsTheirKthScore {

    public static void main(String[] args) {
        System.out.println(new SortStudentsTheirKthScore().sortTheStudents(new int[][]
                {
                        new int[]{10, 6, 9, 1},
                        new int[]{7, 5, 11, 2},
                        new int[]{4, 8, 3, 15}
                }, 2));

        System.out.println(new SortStudentsTheirKthScore().sortTheStudents(new int[][]
                {
                        new int[]{3, 4},
                        new int[]{5, 6},
                }, 0)); // 4

    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (o1, o2) -> o1[k] - o2[k]);
        return score;
    }

/*
    public int[][] sortTheStudents(int[][] score, int k) {

        int[][] res = new int[score.length][score[0].length];

        Map<Integer, Integer> val = new TreeMap<>();

        for (int i = 0; i < score.length; i++) {
            val.put(score[i][k], i);
        }

        int index = score.length - 1;
        for (Integer key : val.keySet()) {
            res[index--] = score[val.get(key)];
        }
        return res;
    }
 */
}
