package saruj.leet.problems;

import java.util.*;

/**
 * Combination Sum II.
 */
public class P40 {

    public static void main(String[] args) {
        P40 p = new P40();
        int[] candidates;
        int target;

        candidates = new int[]{10,1,2,7,6,1,5};
        target = 8;
        System.out.println(p.combinationSum2(candidates, target));

        candidates = new int[]{2,5,2,1,2};
        target = 5;
        System.out.println(p.combinationSum2(candidates, target));
    }

    private int target;
    private int[] candidates;
    private Set<List<Integer>> combinations;
    private Set<S2> set;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinations = new HashSet<>();
        this.candidates = candidates;
        this.target = target;
        this.set = new HashSet<>();
        findCombinations(new S2(new ArrayList<>(), -1), 0);
        return combinations.stream().toList();
    }

    private void findCombinations(S2 s2, int sum) {
        if(set.contains(s2)) {
            return;
        } else {
            set.add(s2);
        }
        if (sum == target) {
            s2.elems.sort(Comparator.naturalOrder());
            combinations.add(s2.elems);
        } else if (sum < target) {
            for (int i = s2.index+1; i < candidates.length; i++) {
                if(sum + candidates[i] <= target) {
                    List<Integer> newList = new ArrayList<>(s2.elems);
                    newList.add(candidates[i]);
                    findCombinations(new S2(newList, i), sum + candidates[i]);
                }
                if(!s2.elems.isEmpty()) {
                    findCombinations(new S2(new ArrayList<>(s2.elems), i), sum);
                }
            }
        }

    }

    static class S2 {
        private final List<Integer> elems;
        private final Integer index;

        public S2(List<Integer> elems, Integer index) {
            this.elems = elems;
            this.index = index;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            S2 s2 = (S2) o;
            return Objects.equals(elems, s2.elems) && Objects.equals(index, s2.index);
        }
        @Override
        public int hashCode() {
            return Objects.hash(elems, index);
        }
    }

}
