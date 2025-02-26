package leetcode.dynamicprogramming;

/**
 * TODO
 * https://leetcode.com/problems/count-number-of-teams/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class CountNumberOfTeams {

    public static void main(String[] args) {
        System.out.println(new CountNumberOfTeams().numTeams(new int[]{2, 5, 3, 4, 1})); // 3
        System.out.println(new CountNumberOfTeams().numTeams(new int[]{2, 1, 3})); // 0
        System.out.println(new CountNumberOfTeams().numTeams(new int[]{1, 2, 3, 4})); // 4
    }


    public int numTeams(int[] rating) {
        int n = rating.length;
        int ans = 0;

        for (int j = 1; j < n - 1; j++) {
            int leftLess = 0, leftGreater = 0;
            int rightLess = 0, rightGreater = 0;

            // Подсчет элементов слева от j
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftLess++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }

            // Подсчет элементов справа от j
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightLess++;
                } else if (rating[k] > rating[j]) {
                    rightGreater++;
                }
            }

            // Подсчет возрастающих и убывающих троек
            ans += leftLess * rightGreater; // Возрастающие тройки
            ans += leftGreater * rightLess; // Убывающие тройки
        }

        return ans;
    }

    public int numTeams2(int[] rating) { // 13% TODO
        int length = rating.length;
        int ans = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    // Проверка на возрастание
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        ans++;
                    }
                    // Проверка на убывание
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
