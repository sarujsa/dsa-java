package saruj.leet.problems;

/**
 * Removing Stars From a String.
 */
public class P2390 {
    public static void main(String[] args) {
        P2390 p = new P2390();
        System.out.println(p.removeStars("leet**cod*e"));
        System.out.println(p.removeStars("erase*****"));
    }
    public String removeStars(String s) {
        int limit = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < limit; i++) {
            if(s.charAt(i) == '*') {
                sb.deleteCharAt(sb.length()-1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
