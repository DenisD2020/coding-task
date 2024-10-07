package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-search-ii/description/
 */
public class WordSearchII {

    public static void main(String[] args) {

        System.out.println(new WordSearchII().findWords(
                new char[][]{
                        new char[]{'o', 'a', 'a', 'n'},
                        new char[]{'e', 't', 'a', 'e'},
                        new char[]{'i', 'h', 'k', 'r'},
                        new char[]{'i', 'f', 'l', 'v'},
                }, new String[]{"oath", "pea", "eat", "rain"})); // "eat","oath"


        System.out.println(new WordSearchII().findWords(
                new char[][]{
                        new char[]{'a', 'b'},
                        new char[]{'c', 'd'},
                }, new String[]{"abcb"})); //

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = build(words);
        Set<String> ans = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(ans, board, trie, i, j);
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(Set<String> ans, char[][] board, Trie trie, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0'
                || trie.next[board[i][j] - 'a'] == null) {
            return;
        }

        char c = board[i][j];

        if (trie.next[c - 'a'].word != null) {
            ans.add(trie.next[c - 'a'].word);
        }

        trie = trie.next[c - 'a'];
        board[i][j] = '0';
        dfs(ans, board, trie, i + 1, j);
        dfs(ans, board, trie, i + -1, j);
        dfs(ans, board, trie, i, j + 1);
        dfs(ans, board, trie, i, j - 1);
        board[i][j] = c;
    }


    private Trie build(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie p = root;
            for (char c : word.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    p.next[c - 'a'] = new Trie();
                }
                p = p.next[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }

    static class Trie {
        String word = null;
        Trie[] next = new Trie[26];
    }
}
