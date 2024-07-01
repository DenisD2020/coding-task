package leetcode.matrix;

/**
 * https://leetcode.com/problems/flipping-an-image/
 * <p>
 * Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
 * <p>
 * To flip an image horizontally means that each row of the image is reversed.
 * <p>
 * For example, flipping [1,1,0] horizontally results in [0,1,1].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * <p>
 * For example, inverting [0,1,1] results in [1,0,0].
 */
public class FlippingAnImage {

    public static void main(String[] args) {
        System.out.println(new FlippingAnImage().flipAndInvertImage(new int[][]
                {
                        new int[]{1, 1, 0},
                        new int[]{1, 0, 1},
                        new int[]{0, 0, 0},
                }));

        System.out.println(new FlippingAnImage().flipAndInvertImage(new int[][]
                {
                        new int[]{1, 1, 0, 0},
                        new int[]{1, 0, 0, 1},
                        new int[]{0, 1, 1, 1},
                        new int[]{1, 0, 1, 0}
                }));
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int[][] res = new int[image.length][image.length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                int value = image[i][j] == 0 ? 1 : 0;
                res[i][image.length - j - 1] = value;
            }
        }
        return res;
    }
}
