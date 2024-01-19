package saruj.algies.dp;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class MinimalSummingSquares {

    private Map<Integer,List<Integer>> mapOfSmallerSquares;

    public MinimalSummingSquares() {
        mapOfSmallerSquares = new HashMap<>();
    }

    public static void main(String ... args) {
        var m = new MinimalSummingSquares();
        System.out.println(m.mss(59));
    }

    List<Integer> mss(int n) {
        List<Integer> squares = getSquaresLowerThanN(n);
        Map<Integer,List<Integer>> memo = new HashMap<>();
        return mss(n, squares, memo);
    }

    private List<Integer> mss(int n, List<Integer> squares, Map<Integer, List<Integer>> memo) {
        if (n == 0) {
            return new ArrayList<>();
        } else if (memo.containsKey(n)) {
            return new ArrayList<>(memo.get(n));
        }
        List<Pair<Integer,List<Integer>>> optionsList = new ArrayList<>();
        for(int sq : squares) {
            optionsList.add(Pair.of(sq, new ArrayList<>(mss(n-sq, getSquaresLowerThanN(n-sq), memo))));
        }
        int minLength  = n;
        Pair<Integer,List<Integer>> min = null;
        for(var opt : optionsList) {
            if(opt.getRight().size() < minLength) {
                minLength = opt.getRight().size();
                min = opt;
            }
        }
        Integer newVal = min.getLeft();
        List<Integer> list = min.getRight();
        list.add(newVal);
        memo.put(n, list);
        return list;
    }

    private List<Integer> getSquaresLowerThanN(int n) {
        if(mapOfSmallerSquares.containsKey(n)) {
            return mapOfSmallerSquares.get(n);
        } else {
            List<Integer> squares = new ArrayList<>();
            for(int i = 1 ; i*i <= n; i++) {
                squares.add(i*i);
            }
            mapOfSmallerSquares.put(n, squares);
            return squares;
        }
    }

}
