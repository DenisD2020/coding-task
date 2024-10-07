package leetcode.backtracking;

/**
 * https://leetcode.com/problems/word-search/description/?envType=problem-list-v2&envId=backtracking&difficulty=MEDIUM
 */
public class WordSearch {

    public static void main(String[] args) { // 93.58%

        System.out.println(new WordSearch().exist(
                new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'}
                }, "ABCCED")); // true


        System.out.println(new WordSearch().exist(
                new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'}
                }, "SEE")); // true

        System.out.println(new WordSearch().exist(
                new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'}
                }, "ABCB")); // false
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (find(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int wordIndex, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return false;

        if (word.charAt(wordIndex) != board[i][j]) {
            return false;
        } else {
            if (wordIndex == word.length() - 1) return true;
            wordIndex++;
            char tmp = board[i][j];
            board[i][j] = 0;
            boolean ans = find(board, word, wordIndex, i + 1, j) ||
                    find(board, word, wordIndex, i, j + 1) ||
                    find(board, word, wordIndex, i - 1, j) ||
                    find(board, word, wordIndex, i, j - 1);
            board[i][j] = tmp;
            return ans;
        }
    }
}
