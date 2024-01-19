package saruj.leet.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Insert Delete GetRandom O(1)
 */
public class P380 {

    public static void main(String[]args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(3);
        rs.insert(-2);
        rs.remove(2);
        rs.insert(1);
        rs.insert(-3);
        rs.insert(-2);
        rs.remove(-2);
        rs.remove(3);
        rs.insert(-1);
        rs.remove(-3);
        rs.insert(1);
        rs.insert(-2);
        rs.insert(-2);
        rs.insert(-2);
        rs.insert(1);
        rs.getRandom();
        rs.insert(-2);
        rs.remove(0);
        rs.insert(-3);
        rs.insert(1);
    }

    static class RandomizedSet {
        private HashMap<Integer,Integer> map;
        private List<Integer> list;
        private Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>(200_001);
            random = new Random();
        }

        public boolean insert(int val) {
            Integer previous = map.put(val,list.size());
            if(previous == null) {
                list.add(val);
                return true;
            } else {
                map.put(val, previous);
                return false;
            }
        }

        public boolean remove(int val) {
            Integer pos = map.remove(val);
            int lastIndex = list.size()-1;
            if(pos != null) {
                if(pos == lastIndex) {
                    list.remove(pos);
                } else {
                    Integer newVal = list.get(lastIndex);
                    map.put(newVal, pos);
                    try {
                        list.set(pos, newVal);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println();
                    }
                    list.remove(lastIndex);
                }
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            int i = nextRandom();
            Integer val = list.get(i);
            while(val == null) {
                i++;
                if(i == list.size()) {
                    i = 0;
                }
                val = list.get(i);
            }
            return val;
        }

        private int nextRandom() {
            return random.nextInt(list.size());
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
