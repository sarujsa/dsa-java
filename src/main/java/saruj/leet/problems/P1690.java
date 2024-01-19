package saruj.leet.problems;


import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Stone Game VII
 */
public class P1690 {
    public static void main(String[]args) {
        P1690 p = new P1690();
        int[] stones1 = new int[] {5,3,1,4,2};
        int[] stones2 = new int[]{7,90,5,1,100,10,10,2};
        int[] stones3 = new int[]{636,266,658,936,776,113,264,858,717,856,912,969,659,430,751,584,877,583,470,675,876,581,762,822,915,94,99,718,911,285,64,707,652,289,195,50,871,733,171,972,966,877,839,291,923,246,114,15,809,764,757,965,996,514,197,811,735,622,858,923,735,86,907,27,896,883,527,86,956,96,16,989,171,181,400,363,496,380,185,653,849,969,853,757,373,469,383,287,236,187,469,63,413,302,181,778,981,517,257,897,825,528,788,654,291,687,474,114,646,724,957,874,972,809,448,502,485,890,395,845,23,140,290,231,680,939,588,168,523,712,102,876,212,797,270,781,258,620,717,707,874,223,46,903,473,317,236,818,979,911,579,157,657,192,152,465,131,178,537,425,266,964,528,512,962,504,329,646,195,668,947,719,903,682,750,998,762,874,356,515,861,6,642,517,975,939,998,466,217,368,940,848,705,545,83,572,220,205,303,377,155,865,485,981,217,248,827,90,47,313,596,830,882,990,449,197,949,889,60,731,925,589,350,723,36,995,54,601,411,708,905,672,806,367,137,836,837,177,745,791,3,122,67,93,506,419,725,723,441,429,394,858,652,894,394,521,262,499,777,816,64,369,276,356,348,9,343,42,57,987,118,968,971,385,53,981,692,310,662,270,282,623,450,663,82,576,687,23,565,132,30,271,854,978,856,899,788,711,845,253,569,234,889,121,999,105,609,799,71,317,675,552,83,722,995,846,629,722,509,100,208,715,349,200,834,124,563,489,11,750,359,273,802,636,898,761,651,370,626,255,311,112,726,935,588,450,602,120,717,345,478,631,276,627,219,853,155,621,970,504,404,129,727,710,114,471,954,318,792,482,607,890,203,727,498,909,882,769,727,442,297,497,735,813,87,743,138,588,759,288,958,166,873,693,385,24,186,208,532,535,844,755,504,915,264,759,619,330,217,491,413,22,835,369,326,350,416,736,751,905,383,601,950,894,688,70,428,283,634,797,250,718,615,2,261,773,665,934,848,802,618,969,721,873,526,121,149,736,824,28,791,558,251,777,915,512,502,87,673,175,324,872,700,155,122,618,73,913,995,782,953,817,92,353,78,399,723,813,841,666,192,537,320,254,428,845,285,347,945,518,221,602,390,216,119,774,580,277,259,727,265,891,384,579,772,932,459,367,684,379,502,265,511,741,77,132,573,992,38,416,223,980,643,415,539,845,210,51,890,855,786,395,924,430,612,249,459,303,485,48,177,973,154,570,806,954,803,263,492,108,484,442,184,741,843,317,209,749,657,749,632,734,449,843,210,146,925,499,161,723,886,592,510,50,913,280,960,433,667,443,931,808,34,572,878,966,19,360,505,565,437,890,186,917,332,788,168,810,56,709,957,355,793,474,710,649,190,444,125,37,894,455,889,774,795,418,198,366,971,998,647,998,283,823,453,487,733,402,620,941,606,837,948,217,479,837,143,795,409,143,65,919,597,264,708,871,640,773,938,870,277,919,626,1,543,788,860,329,764,798,791,507,754,552,800,660,810,174,644,382,722,850,834,113,448,725,577,663,86,42,515,849,812,177,448,891,156,442,968,913,303,796,133,426,509,982,759,482,562,749,120,74,698,352,748,366,96,601,222,435,68,538,25,292,111,605,317,853,157,974,18,995,619,714,619,58,683,417,921,547,704,400,759,105,168,481,48,766,505,423,759,582,110,262,130,329,524,136,653,813,16,5,881,109,519,744,468,694,145,888,981,101,444,616,494,668,222,948,797,486,560,43,470,567,907,512,877,239,890,960,459,271,978,461,697,218,411,499,928,119,415,178,740,16,870,941,835,950,977,358,793,459,563,544,855,816,615,715,336,39,109,320,179,710,560,449,698,599,591,648,564,714,711,875,773,396,490,401,122,143,561,777,836,767,14,140,197,438,849,232,595,396,978,855,607,156,346,569,135,753,620,39,834,526,696,797,35,149,238,256,998,608,654,314,215,472,434,948,219,355,841,189,779,377,754,514,882,419,872,92,429,256,68,227,625,531,128,31,818,44,387,686,663,114,153,136,593,490,348};

        Instant start = Instant.now();
        int m = p.stoneGameVII(stones2);
        Instant end = Instant.now();
        System.out.println("DURATION = " + Duration.between(start,end).toMillis());
        System.out.println(m);
    }

    public int stoneGameVII(int[] stones) {
        int[][] M = new int[stones.length][stones.length];
        for(int i = stones.length - 1; i >= 0; i--) {
            int sum = stones[i];
            for(int j = i+1; j < stones.length; j++) {
                sum += stones[j];
                M[i][j] = Math.max(sum - stones[i] - M[i+1][j],
                                    sum - stones[j] - M[i][j-1]);
            }
        }
        return M[0][stones.length-1];
    }

    /// deprecated
    static class T {
        int a;
        int b;

        public T(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            T t = (T) o;
            return a == t.a && b == t.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    /** To slow */
    @Deprecated
    public int calculate(int[] stones) {
        if(stones.length < 2) return 0;
        int sum = 0;
        for(int i : stones) {
            sum+=i;
        }
        Map<T,Integer> memo = new HashMap<>();
        return calculate(stones, 0, stones.length-1, sum, memo);
    }

    /** To slow */
    @Deprecated
    private int calculate(int[] stones, int startIndex, int endIndex, int sum,
                          Map<T,Integer> memo) {
        if(startIndex == endIndex) {
            return 0; //stones[startIndex];
        }
        T memoKey = new T(startIndex,endIndex);
        if(memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }
        int diff1 = calculate(stones, startIndex+1, endIndex, sum - stones[startIndex], memo);
        diff1 = Math.abs(diff1 - (sum - stones[startIndex]));
        int diff2 = calculate(stones, startIndex, endIndex-1, sum - stones[endIndex], memo);
        diff2 = Math.abs(diff2 - (sum - stones[endIndex]));
        int max = Math.max(diff1, diff2);
        memo.put(memoKey,max);
        return max;
    }

    /**
     * Solving this I didn't realize what is meant by maximize and minimize.
     * @param stones
     * @return
     */
    public int misunderstoodVersion(int[] stones) {
        int sum = 0;
        for(int i : stones) {
            sum += i;
        }
        int index = 0;

        boolean alice = true;
        int aliceSum = 0;
        int bobSum = 0;
        for(int i = 0, j = stones.length-1; i < j; ) {
            if(stones[i] < stones[j]) {
                index = i;
                i++;
            } else {
                index = j;
                j--;
            }
            sum = sum - stones[index];
            if(alice) {
                aliceSum += sum;
            } else {
                bobSum += sum;
            }
            alice = !alice;
        }
        return aliceSum - bobSum;
    }

}