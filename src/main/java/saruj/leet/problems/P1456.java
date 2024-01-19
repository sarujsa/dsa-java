package saruj.leet.problems;

/**
 * Maximum Number of Vowels in a Substring of Given Length.
 */
public class P1456 {
    public static void main(String[]args) {
        P1456 p = new P1456();
        System.out.println(p.maxVowels("abciiidef",3));
        System.out.println(p.maxVowels("aeiou", 2));
        System.out.println(p.maxVowels("leetcode",3));
    }

    public int maxVowels(String s, int k) {
        boolean[] vowels = new boolean[128];
        vowels['a'] = true;
        vowels['e'] = true;
        vowels['i'] = true;
        vowels['o'] = true;
        vowels['u'] = true;
        int limit = Math.min(k, s.length());
        int count = 0;
        for(int i = 0; i < limit; i++) {
            if(vowels[s.charAt(i)]) {
                count++;
            }
        }
        int max = count;
        limit = s.length();
        for(int i = k; i < limit; i++) {
            if(vowels[s.charAt(i)]) {
                count++;
            }
            if(vowels[s.charAt(i-k)]) {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
