package saruj.leet.problems;

/**
 * String compression.
 */
public class P443 {
    public static void main(String[]args) {
        char[] chars1 = new char[]{'a','a','b','b','c','c','c'};
        char[] chars2 = new char[]{'a'};
        char[] chars3 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] chars4 = new char[]{'a','b','c','d','e','f','f','g','h','i'};
        char[] chars5 = new char[]{'a','a','a','b','b','a','a'};
        char[] chars6 = new char[]{'a','b','c'};
        P443 p = new P443();
        testMethod(p,chars6);
    }

    private static void testMethod(P443 p, char[] chars) {
        System.out.println(p.compress(chars));
        for(char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int index = 0;
        int count = 1;
        char c = chars[0];
        int limit = chars.length-1;
        boolean addToIndex = false;
        for(int i = 1 ; i <= limit; i++) {
            if(chars[i] == c && i < limit) {
                count++;
            } else {
                if(i == limit) {
                    if(chars[i] == c) {
                        count++;
                    } else {
                        addToIndex = true;
                    }
                }
                chars[index] = c;
                if(count > 1) {
                    String s = Integer.toString(count);
                    for(int j = 0; j < s.length(); j++) {
                        index++;
                        chars[index] = s.charAt(j);
                    }
                }
                index++;
                c = chars[i];
                count = 1;
            }
        }
        if(addToIndex) {
            chars[index] = c;
            index++;
        }
        return index;
    }
}
