package saruj.leet.problems;

/**
 * Visit array positions to maximize score.
 */
public class P2786 {

    public static void main(String[] args) {
        P2786 p = new P2786();
        int []nums;
        int x;

        nums = new int[]{2,3,6,1,9,2};
        x = 5;
        System.out.println(p.maxScore(nums, x));

        nums = new int[]{2,4,8,6};
        x = 3;
        System.out.println(p.maxScore(nums, x));
    }

    static class C {
        long change;
        long stay;

        @Override
        public String toString() {
            return "C{" +
                    "change=" + change +
                    ", stay=" + stay +
                    '}';
        }

        public C(long change, long stay) {
            this.change = change;
            this.stay = stay;

        }
    }
    public long maxScore(int[] nums, int x) {
        C odd = new C(0,0);
        C even = new C(0,0);
        C current = null;
        for(int i = nums.length-1; i >= 0; i--) {
            current = new C(nums[i]-x, nums[i]);
            boolean currentEven = nums[i] % 2 == 0;
            long diff;
            if(currentEven) {
                diff = Math.max(even.stay, odd.change);
                current.stay += diff;
                current.change += diff;
                even = current;
            } else {
                diff = Math.max(even.change, odd.stay);
                current.stay += diff;
                current.change += diff;
                odd = current;
            }
        }
        return Math.max(current.change, current.stay);
    }
}
