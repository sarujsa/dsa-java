package saruj.algies.dp;

import java.util.*;

/**
 * Given a grid of size n*m, how many paths are there to
 * traverse from top left corner to bottom right corner.
 * There are also some walls on the way.
 * You can only move down or right.
 */
public class CountPaths {

    private static final Dimension dimensions = new Dimension(50,50);
    private static final List<Position> walls;
    static {
        walls = Arrays.asList(new Position(1,3));
    }

    public static void main(String ... args) {
        CountPaths cpa = new CountPaths();
        int result = cpa.countPaths(new Position(1,1), new Position(dimensions.x, dimensions.y));
        System.out.println(result);
    }

    public int countPaths(Position start, Position end) {
        return countPaths(start,end, new HashMap<>());
    }

    public int countPaths(Position start, Position end, Map<Position,Integer> memo) {
        if(start.equals(end)) {
            return 1;
        } else if (memo.containsKey(start)) {
            return memo.get(start);
        }
        int right = 0;
        int down = 0;
        if (canGoRight(start)) {
            right = countPaths(start.right(), end, memo);
        }
        if (canGoDown(start)) {
            down = countPaths(start.down(), end, memo);
        }
        memo.put(start, right + down);
        return right + down;
    }

    private boolean canGoRight(Position start) {
        return start.x < dimensions.x &&
                !walls.contains(start.right());
    }

    private boolean canGoDown(Position start) {
        return start.y < dimensions.y &&
                !walls.contains(start.down());
    }

    public static class Dimension {
        int x;
        int y;

        public Dimension(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Position {
        int x;
        int y;

        public Position right() {
            return new Position(x+1, y);
        }

        public Position down() {
            return new Position(x,y+1);
        }

        public Position() {

        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
