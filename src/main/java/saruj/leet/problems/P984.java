package saruj.leet.problems;

/**
 * Given two integers a and b, return any string s such that.
 * s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
 * The substring 'aaa' does not occur in s, and
 * The substring 'bbb' does not occur in s.
 */
public class P984 {
    public static void main(String[] args) {
        P984 p = new P984();
        System.out.println(p.strWithout3a3b(1,1));
        System.out.println(p.strWithout3a3b(2,1));
        System.out.println(p.strWithout3a3b(3,1));
        System.out.println(p.strWithout3a3b(2,0));
        System.out.println(p.strWithout3a3b(1,0));
        System.out.println(p.strWithout3a3b(2,2));
        System.out.println(p.strWithout3a3b(3,3));
        System.out.println(p.strWithout3a3b(4,4));
        System.out.println(p.strWithout3a3b(4,2));
        System.out.println(p.strWithout3a3b(5,2));
        System.out.println(p.strWithout3a3b(6,2));


    }

//    public String try3(int a, int b) {
//        int longerCount, shorterCount;
//        char charLonger, charShorter;
//        if(a > b) {
//            longerCount = a;
//            charLonger = 'a';
//            shorterCount = b;
//            charShorter = 'b';
//        } else {
//            longerCount = b;
//            charLonger = 'b';
//            shorterCount = a;
//            charShorter = 'a';
//        }
//        int c = longerCount - shorterCount - 1;
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < c; i++) {
//            sb.append(charLonger).append(charLonger).append(charShorter);
//        }
//        for(int i = 0; i < shorterCount; )
//    }

    public String strWithout3a3b(int a, int b) {
        int longerCount, shorterCount;
        char charLonger, charShorter;
        if(a > b) {
            longerCount = a;
            charLonger = 'a';
            shorterCount = b;
            charShorter = 'b';
        } else {
            longerCount = b;
            charLonger = 'b';
            shorterCount = a;
            charShorter = 'a';
        }
        StringBuilder sb = new StringBuilder();
        if(shorterCount == 0) {
            sb.append(String.valueOf(charLonger).repeat(longerCount));
            return sb.toString();
        }
        for(int i = 0; i < shorterCount; i++) {
            sb.append(charLonger).append(charShorter);
        }
        int diff = longerCount-shorterCount;
        int add = 0;
        for(int i = 1; i <= diff; i++) {
            sb.insert(i+add, charLonger);
            add = add == 0 ? 1 : add +2;
        }
        return sb.toString();
    }
    public String f(int a, int b) {
        int longerCount, shorterCount;
        char charLonger, charShorter;
        if(a > b) {
            longerCount = a;
            charLonger = 'a';
            shorterCount = b;
            charShorter = 'b';
        } else {
            longerCount = b;
            charLonger = 'b';
            shorterCount = a;
            charShorter = 'a';
        }
        String long2 = "" + charLonger + charLonger;
        StringBuilder sb = new StringBuilder();
        do {
            if(longerCount > 1 && longerCount > 2*shorterCount) {
                sb.append(long2);
                longerCount-=2;
            } else if (longerCount > 0) {
                sb.append(charLonger);
                longerCount--;
            }
            if(shorterCount > 0) {
                sb.append(charShorter);
                shorterCount--;
            }
        } while (longerCount > 0 || shorterCount > 0);
        return sb.toString();
    }
}
