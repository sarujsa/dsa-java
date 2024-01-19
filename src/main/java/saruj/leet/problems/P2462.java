package saruj.leet.problems;

import java.util.PriorityQueue;

public class P2462 {

    public static void main(String[] args) {
        P2462 p = new P2462();
        int k, candidates;
        int[] costs;
        long res;
        costs = new int[]
                {18,64,12,21,21,78,36,58,88,58,
                        99,26,92,91,53,10,24,25,20,92,
                        73,63,51,65,87,6,17,32,14,42,
                        46,65,43,9,75};
        k = 13;
        candidates = 23;
        res = p.totalCost(costs, k, candidates);
        System.out.println(res);
    }
    public long totalCost(int[] costs, int k, int candidates) {
        int leftIndex = -1;
        int rightIndex = costs.length;
        PriorityQueue<S3> pq = new PriorityQueue<>();
        for(int i = 0; i < candidates; i++) {
            leftIndex++;
            if(leftIndex < rightIndex) {
                pq.add(new S3(costs[leftIndex], leftIndex, Side.LEFT));
            }
            rightIndex--;
            if(rightIndex > leftIndex) {
                pq.add(new S3(costs[rightIndex], rightIndex, Side.RIGHT));
            }
        }
        long totalCost = 0;
        for(int i = 0; i < k; i++) {
            S3 chosen = pq.poll();
            totalCost += chosen.cost;
            if(rightIndex - 1 > leftIndex) {
                switch(chosen.side) {
                    case LEFT:
                        leftIndex++;
                        pq.add(new S3(costs[leftIndex], leftIndex, Side.LEFT));
                        break;
                    case RIGHT:
                        rightIndex--;
                        pq.add(new S3(costs[rightIndex], rightIndex, Side.RIGHT));
                        break;
                }
            }
        }
        return totalCost;
    }

    enum Side {
        LEFT,
        RIGHT
    }

    public static class S3 implements Comparable<S3> {
        public S3(int cost, int index, Side side) {
            this.cost = cost;
            this.index = index;
            this.side = side;
        }

        final int cost;
        final int index;
        final Side side;

        @Override
        public int compareTo(S3 o) {
            if(this.cost < o.cost) {
                return -1;
            } else if (this.cost > o.cost) {
                return 1;
            } else if (this.index < o.index) {
                return -1;
            } else if (this.index > o.index) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
