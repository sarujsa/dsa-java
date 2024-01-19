package saruj.algies.dp.brute;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimalSummingSquares_BruteForce {

    public static void main(String ... args) {
        var m = new MinimalSummingSquares_BruteForce();
        System.out.println(m.mss(59));
    }

    List<Integer> mss(int n) {
        List<Integer> squares = getSquaresLowerThanN(n);
        return mss(n, squares);
    }

    private List<Integer> mss(int n, List<Integer> squares) {
        if(n == 1) {
            List<Integer> ret = new ArrayList<>();
            ret.add(1);
            return ret;
        } else if (n <= 0) { // TODO is this needed?
            return new ArrayList<>();
        }
        List<Pair<Integer,List<Integer>>> optionsList = new ArrayList<>();
        for(int sq : squares) {
            optionsList.add(Pair.of(sq, mss(n-sq)));
        }
        var min = optionsList.stream()
                .min(Comparator.comparing(p -> p.getRight().size()));
        Integer newVal = min.get().getLeft();
        List<Integer> list = min.get().getRight();
        list.add(newVal);
        return list;
    }

    private List<Integer> getSquaresLowerThanN(int n) {
        List<Integer> squares = new ArrayList<>();
        for(int i = 1 ; i*i <= n; i++) {
            squares.add(i*i);
        }
        return squares;
    }

}
