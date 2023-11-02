package depthfirstsearch;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/flood-fill/description/
 */
public class FloodFill {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new FloodFill().floodFill(new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}}, 1, 1, 2)));
//        System.out.println(Arrays.deepToString(new FloodFill().floodFill(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}}, 0, 0, 0)));
//        System.out.println(Arrays.deepToString(new FloodFill().floodFill(new int[][]{new int[]{0, 0, 0}, new int[]{0, 0, 0}}, 1, 0, 2)));
    }

/*    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int baseColor = image[sr][sc];
        if (baseColor == color) {
            return image;
        }
        return find(image, sr, sc, baseColor, color);
    }

    public int[][] find(int[][] image, int sr, int sc, int baseColor, int color) {

        if (image[sr][sc] == baseColor) {
            image[sr][sc] = color;
            if (sr - 1 >= 0) find(image, sr - 1, sc, baseColor, color);
            if (sr + 1 < image.length) find(image, sr + 1, sc, baseColor, color);
            if (sc - 1 >= 0) find(image, sr,  sc - 1, baseColor, color);
            if (sc + 1 < image[sr].length) find(image, sr,  sc + 1, baseColor, color);
        }
        return image;
    }*/


    public int[][] floodFill(int[][] image, int sr, int sc, int color) { // dfs
        Stack<Pair> stack = new Stack<>();
        int baseColor = image[sr][sc];
        stack.push(new Pair(sr, sc));
        if (baseColor == color) return image;
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            if (image[pair.x][pair.y] == baseColor) {
                image[pair.x][pair.y] = color;
                if (pair.x - 1 >= 0) {
                    stack.push(new Pair(pair.x - 1, pair.y));
                }
                if (pair.x + 1 < image.length) {
                    stack.push(new Pair(pair.x + 1, pair.y));
                }
                if (pair.y - 1 >= 0) {
                    stack.push(new Pair(pair.x, pair.y - 1));
                }
                if (pair.y + 1 < image[0].length) {
                    stack.push(new Pair(pair.x, pair.y + 1));
                }
            }
        }
        return image;
    }

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
