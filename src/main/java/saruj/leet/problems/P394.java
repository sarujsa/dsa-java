package saruj.leet.problems;

import java.util.Stack;

/**
 * Decode String.
 */
public class P394 {
    public static void main(String[] args) {
        P394 p = new P394();
        p.decodeString("3[a]2[bc]");
        System.out.println(p.decodeString("3[a2[c]]"));
        System.out.println(p.decodeString("2[abc]3[cd]ef"));
    }

    String PARENTH_START_CHAR = "[";
    String PARENTH_END_CHAR = "]";

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int position = 0;
        final String result;
        while(true) {
            int parenthStart = s.indexOf(PARENTH_START_CHAR, position);
            int parenthEnd = s.indexOf(PARENTH_END_CHAR, position);
            if (parenthStart < parenthEnd && parenthStart != -1) {
                stack.push(s.substring(position, parenthStart));
                stack.push(PARENTH_START_CHAR);
                position = parenthStart + 1;
            } else if (parenthEnd < parenthStart || parenthStart == -1 && parenthEnd != -1) {
                mergeAndSwapTop(stack, s.substring(position, parenthEnd));
                position = parenthEnd + 1;
            } else { // both are -1
                stack.push(s.substring(position));
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty()) {
                    sb.insert(0, stack.pop());
                }
                result = sb.toString();
                break;
            }
        }
        return result;
    }

    private void mergeAndSwapTop(Stack<String> stack, String substring) {
        StringBuilder sb = new StringBuilder(substring);
        while(!stack.peek().equals(PARENTH_START_CHAR)) {
            sb.insert(0, stack.pop());
        }
        stack.pop(); // this was PARENTH_START_CHAR
        swapTop(stack, sb.toString());
    }

    private void swapTop(Stack<String> stack, String forSwapping) {
        if(stack.isEmpty()) {
            return;
        }
        String stackTop = stack.pop();
        int i = stackTop.length() - 1;
        int number = 0;
        int tens = 1;
        int len = 0;
        while (i >=0 && Character.isDigit(stackTop.charAt(i))) {
            number += tens * (stackTop.charAt(i) - '0');
            tens *= 10;
            len++;
            i--;
        }
        String withoutNumber = stackTop.substring(0, stackTop.length() - len);
        StringBuilder sb = new StringBuilder(withoutNumber);
        sb.append(String.valueOf(forSwapping).repeat(Math.max(0, number)));
        stack.push(sb.toString());
    }

    public String decodeString_wrong(String s) {
        Stack<String> stack = new Stack<>();
        int position = 0;
        String result = null;
        boolean justClosed = false;
        while(true) {
            int parenthStart = s.indexOf("[", position);
            int parenthEnd = s.indexOf("]", position);
            if(parenthStart < parenthEnd && parenthStart != -1) {
                stack.push(s.substring(position, parenthStart));
                position = parenthStart+1;
                justClosed = false;
            } else if(parenthEnd < parenthStart || parenthStart == -1 && parenthEnd != -1) {
                String forSwapping = s.substring(position, parenthEnd);
                if(forSwapping.isEmpty()) {
                    forSwapping = stack.pop();
                }
                swapTop(stack, forSwapping);
                position = parenthEnd+1;
                justClosed = true;
            } else { // both are -1
                if(position < s.length()-1) {
                    stack.push(s.substring(position));
                }
                String forSwapping = null;
                while(!stack.isEmpty()) {
                    forSwapping = stack.pop();
                    swapTop(stack, forSwapping);
                }
                result = forSwapping;
                break;
            }
        }
        return result;
    }
}
