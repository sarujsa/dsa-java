package saruj.leet.problems;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Can Place Flowers
 */
public class P605 {

    static class Pair {
        int successiveZeroes = 0;
        int possiblePlants = 0;
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        Stream<Integer> start = Stream.concat(Stream.of(1, 0),
                Arrays.stream(flowerbed).boxed());
        Stream<Integer> stream = Stream.concat(start, Stream.of(0,1));
        final Pair p = new Pair();
        boolean containsOne = false;
        stream.forEach(i -> {
            if(i == 0) {
                p.successiveZeroes++;
            } else {
                if(p.successiveZeroes != 0) {
                    p.possiblePlants += (p.successiveZeroes - 1) / 2;
                    p.successiveZeroes = 0;
                }
            }
        });
        return p.possiblePlants >= n;
    }
}
