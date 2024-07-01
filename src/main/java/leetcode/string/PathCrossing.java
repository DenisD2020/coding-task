package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {

    public static void main(String[] args) {
//        System.out.println(new PathCrossing().isPathCrossing("ENNNNNNNNNNNEEEEEEEEEESSSSSSSSSS")); // false
//        System.out.println(new PathCrossing().isPathCrossing("NNSWWEWSSESSWENNW")); // true
//        System.out.println(new PathCrossing().isPathCrossing("NES")); // false
        System.out.println(new PathCrossing().isPathCrossing("NESWW")); // true
    }

    public boolean isPathCrossing(String path) { // with set
        boolean ans = false;

        int x = 0, y = 0;

        Set<String> visited = new HashSet<>();
        visited.add("0-0");
        StringBuilder sb = new StringBuilder(6);

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'W') {
                x -= 1;
            }
            sb.append(x).append("-").append(y);
            if (!visited.add(sb.toString())) {
                return true;
            }
            sb.setLength(0);
        }
        return ans;
    }

/*    public boolean isPathCrossing(String path) { // with set
        boolean ans = false;
        int x = 0, y = 0;

        Set<Pair> visited = new HashSet<>();
        visited.add(new Pair(0,0));

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'W') {
                x -= 1;
            }
            if (!visited.add(new Pair(x, y))) {
                return true;
            }
        }
        return ans;
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }*/
}
