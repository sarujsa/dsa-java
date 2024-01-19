package saruj.leet.problems;

/**
 * Is subsequence
 */
public class P392 {
    public static void main(String[]args) {
        P392 p = new P392();
        System.out.println(p.isSubsequence("abc", "ahbgdc"));
        System.out.println(p.isSubsequence("axc", "ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        if(s.isEmpty()) return true;
        int tLimit = t.length();
        int sLimit = s.length()-1;
        int index = 0;
        for(int i = 0; i < tLimit; i++) {
            if(s.charAt(index) == t.charAt(i)) {
                if(index == sLimit) {
                    return true;
                } else {
                    index++;
                }
            }
        }
        return false;
    }
}
