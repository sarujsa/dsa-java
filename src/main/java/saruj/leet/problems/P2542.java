package saruj.leet.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Maximum Subsequence Score.
 */
public class P2542 {
    public static void main(String[] args) {
        P2542 p = new P2542();
        int[] nums1, nums2;
        int k;
        nums1 = new int[]{1,3,3,2};
        nums2 = new int[]{2,1,3,4};
        k = 3;
        System.out.println(p.maxScore(nums1, nums2, k));

        nums1 = new int[]{4,2,3,1,1};
        nums2 = new int[]{7,5,10,9,6};
        k = 1;
        System.out.println(p.maxScore(nums1, nums2, k));
    }
    public long maxScore(int[] nums1, int[] nums2, final int k) {
        S2[] array = createArray(nums1, nums2);
        Arrays.sort(array, (s1, s2) -> -Integer.compare(s1.num1, s2.num1));
        PriorityQueue<S2> pq = new PriorityQueue<>(Comparator.comparingInt(s -> s.num2));
        pq.addAll(Arrays.asList(array).subList(0, k));
        long sum = 0;
        for(int i = 0; i < k; i++) {
            sum += array[i].num1;
        }
        long score = sum * pq.peek().num2;
        long max = score;
        for(int i = k; i < nums1.length; i++) {
            if(pq.peek().num2 < array[i].num2) {
                sum -= pq.poll().num1;
                sum += array[i].num1;
                pq.add(array[i]);
                score = sum * pq.peek().num2;
                max = Math.max(score, max);
            }
        }
        return max;
    }

    private S2[] createArray(int[] nums1, int[] nums2) {
        S2[] s2s = new S2[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            s2s[i] = new S2(nums1[i], nums2[i]);
        }
        return s2s;
    }

    static class S2 {
        public S2(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        int num1;
        int num2;

        @Override
        public String toString() {
            return "S2{" +
                    "num1=" + num1 +
                    ", num2=" + num2 +
                    '}';
        }
    }
}
