package saruj.leet.problems;

/**
 * Reverse Vowels of a String
 */
public class P345 {

    char[] vowel = new char[]{'a','e','i','o','u','A','E','I','O','U'};
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length()-1;
        while(start < end) {
            boolean isVowelStart = isVowel(chars[start]);
            boolean isVowelEnd = isVowel(chars[end]);
            if(isVowelStart && isVowelEnd) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
            if(!isVowelStart) {
                start++;
            }
            if(!isVowelEnd) {
                end--;
            }
        }
        return new String(chars);
    }

    boolean isVowel(char c) {
        for(char v : vowel) {
            if(c == v) return true;
        }
        return false;
    }
}
