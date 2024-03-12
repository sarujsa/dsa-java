package saruj.leet.problems;

import java.util.*;

/**
 * Powerful integers.
 */
public class P970 {

    public static void main(String[] args) {
        P970 p = new P970();
        int x, y, bound;

        x = 2;
        y = 3;
        bound = 10;
        System.out.println(p.powerfulIntegers(x, y, bound));

        x = 3;
        y = 5;
        bound = 15;
        System.out.println(p.powerfulIntegers(x, y, bound));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> xpowers = getPowers(x, bound);
        List<Integer> ypowers = getPowers(y, bound);
        Set<Integer> result = new HashSet<>();
        outer: for(var xp : xpowers) {
            for(var yp : ypowers) {
                if(xp + yp <= bound) {
                    result.add(xp + yp);
                } else {
                    continue outer;
                }
            }
        }
        return new ArrayList<>(result);
    }

    private List<Integer> getPowers(int base, int bound) {
        if(base == 1) {
            return Arrays.asList(1);
        }
        int power = 1;
        List<Integer> powers = new ArrayList<>();
        while(power < bound) {
            powers.add(power);
            power *= base;
        }
        return powers;
    }

}
