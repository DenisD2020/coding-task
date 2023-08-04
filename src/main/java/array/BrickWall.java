package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/brick-wall/description/
 * <p>
 * There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the same.
 * <p>
 * Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * <p>
 * Given the 2D array wall that contains the information about the wall, return the minimum number of crossed bricks after drawing such a vertical line.
 */
public class BrickWall {
    public static void main(String[] args) {
        System.out.println(new BrickWall().leastBricks(
                        List.of(
                                List.of(1, 2, 2, 1),
                                List.of(1, 3, 1, 1),
                                List.of(1, 3, 2),
                                List.of(3, 1, 2),
                                List.of(2, 4),
                                List.of(3, 1, 2)
                        )
                )
        ); // 2

        System.out.println(new BrickWall().leastBricks(
                        List.of(
                                List.of(1),
                                List.of(1),
                                List.of(1)
                        )
                )
        ); // 3


/*        System.out.println(new BrickWall().leastBricks(
                        List.of(
                                List.of(100000000),
                                List.of(100000000),
                                List.of(100000000)
                        )
                )
        ); // 3 timeout*/

/*        System.out.println(new BrickWall().leastBricks(
                        List.of(
                                List.of(100000000, 100000000),
                                List.of(100000000, 100000000)
                        )
                )
        ); // 0*/
    }

    public int leastBricks(List<List<Integer>> wall) {
        int res = wall.size();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (List<Integer> level : wall) {
            int prefixSum = 0;
            for (int i = 0; i < level.size() - 1; i++) {
                prefixSum += level.get(i);
                map.merge(prefixSum, 1, (k, v) -> k + v);
            }
            prefixSum = 0;
        }
        int asInt = map.size() > 0 ? Collections.max(map.values()) : 0;
        return res - asInt;
    }

/*    public int leastBricks(List<List<Integer>> wall) { / Time Limit Exceeded
        int res = wall.size();
        int wallLength = wall.get(0).stream().mapToInt(Integer::intValue).sum();
        int step = wall.stream().flatMap(Collection::stream).mapToInt(Integer::intValue).min().getAsInt();

        if (step > 1) {
            step--;
        }

        for (int i = 1; i <= wallLength - 1; i = i + step) {
            int crossedBricks = wall.size();
            for (List<Integer> level : wall) {
                int summ = 0;
                for (int j = 0; j < level.size(); j++) {
                    summ += level.get(j);
                    if (summ == i) {
                        crossedBricks--;
                        break;
                    } else if (summ > i) {
                        break;
                    }
                }
            }
            res = Math.min(res, crossedBricks);
        }
        return res;
    }*/
}
