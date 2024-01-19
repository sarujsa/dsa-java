package saruj.leet.problems;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Asteroid collision.
 */
public class P735 {
    public static void main(String[] args) {
        int[] roids1 = new int[]{5,10,-5};
        int[] roids2 = new int[]{8,-8};
        int[] roids3 = new int[]{10,2,-5};
        P735 p = new P735();
        int[] ret = p.asteroidCollision(roids3);
        System.out.println(Arrays.stream(ret)
                .mapToObj(i -> i+"")
                .collect(Collectors.joining(",")));
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for(int i = 1; i < asteroids.length; i++) {
            boolean bothDestroyed = false;
            boolean continueLooping = true;
            while(!stack.isEmpty() && continueLooping) {
                continueLooping = false;
                int last = stack.peek();
                if(last > 0 && asteroids[i] < 0) {
                    int absAst = Math.abs(asteroids[i]);
                    if (last < absAst) {
                        stack.pop();
                        continueLooping = true;
                    } else if(last == absAst) {
                        stack.pop();
                        bothDestroyed = true;
                    }
                } else {
                    stack.push(asteroids[i]);
                }
            }
            if(stack.isEmpty() && !bothDestroyed) { // in case the while loop ended because stack is empty and this asteroid is the largest so far
                stack.push(asteroids[i]);
            }
        }
        int[] ret = new int[stack.size()];
        int index = 0;
        for(Integer i : stack) {
            ret[index] = i;
            index++;
        }
        return ret;
    }
}
