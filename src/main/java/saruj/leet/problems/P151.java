package saruj.leet.problems;

import java.util.Stack;

/**
 * Reverse Words in a String
 */
public class P151 {
    public static void main(String[]args) {
        var s = "       asdf             rr\n\n\nf";
        P151 p = new P151();
        System.out.println(p.reverseWords(s));
    }
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for(String w : words) stack.push(w);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(' ');
        }
        if(!sb.isEmpty()) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
