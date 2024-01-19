package saruj.leet.problems;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Number of recent calls.
 */
public class P933 {
    class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>(3000);
        }

        public int ping(int t) {
            queue.add(t);
            int limit = t - 3000;
            while(queue.peek() < limit) {
                queue.poll();
            }
            return queue.size();
        }
    }
}
