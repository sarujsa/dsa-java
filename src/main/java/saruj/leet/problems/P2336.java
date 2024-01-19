package saruj.leet.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.IntStream;

public class P2336 {

    static class SmallestInfiniteSet {

        private final PriorityQueue<Integer> pq;
        private final Iterator<Integer> iterator;
        private final Set<Integer> popped;

        public SmallestInfiniteSet() {
            pq = new PriorityQueue<>();
            IntStream infiniteStream = IntStream.iterate(1, x -> x + 1);
            iterator = infiniteStream.iterator();
            popped = new HashSet<>();
        }

        public int popSmallest() {
            int ret;
            if(!pq.isEmpty()) {
                ret = pq.poll();
            } else {
                ret = iterator.next();
            }
            popped.add(ret);
            return ret;
        }

        public void addBack(int num) {
            if(popped.contains(num)) {
                pq.add(num);
                popped.remove(num);
            }
        }
    }

}
