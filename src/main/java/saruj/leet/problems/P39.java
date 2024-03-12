package saruj.leet.problems;

import java.util.*;
import java.util.function.Consumer;

/**
 * Combination Sum.
 */
public class P39 {

    public static void main(String[] args) {
        P39 p = new P39();
        int[] combinations;
        int target;

        combinations = new int[]{2,3,5};
        target = 8;
        System.out.println(p.combinationSum(combinations, target));
    }

    /**
     * Enhanced stack.
     */
    static class EStack {

        Stack<S2> elems = new Stack<>();
        int sum;

        boolean isEmpty() {
            return elems.isEmpty();
        }

        S2 pop() {
            S2 s2 = elems.pop();
            sum -= s2.elem;
            return s2;
        }

        void push(int elem) {
            S2 s2 = new S2(elem);
            elems.push(s2);
            sum += elem;
        }

        void push(int elem, int index) {
            S2 s2 = new S2(elem, index);
            elems.push(s2);
            sum += elem;
        }

        S2 peek() {
            return elems.peek();
        }

    }

    static class S2 {
        int elem;
        int incrementIndex;

        public S2(int elem) {
            this.elem = elem;
        }

        public S2(int elem, int index) {
            this.elem = elem;
            this.incrementIndex = index;
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int[] indices = getIndices(candidates);
        EStack stack = new EStack();
        List<List<Integer>> combinations = new ArrayList<>();
        for(int elem : candidates) {
            assert stack.isEmpty() : "Stack must be empty at start of for loop";
            stack.push(elem);
            while(!stack.isEmpty()) {
                if(stack.sum < target) {
                    S2 top = stack.peek();
                    int nextIndex = indices[top.elem] + top.incrementIndex;
                    stack.push(candidates[nextIndex]);
                } else if (stack.sum == target) {
                    combinations.add(stack.elems.stream()
                                    .map(s2 -> s2.elem)
                                            .toList());
                    removeFromTop(stack, candidates, indices);
                } else {
                    removeFromTop(stack, candidates, indices);
                }
            }
        }
        return combinations;
    }

    private static void removeFromTop(EStack stack, int[] candidates, int[] indices) {
        stack.pop(); // first pop the element that was over the sum
        if(!stack.isEmpty()) {
            stack.pop(); // the top element here will get swapped with the next one, in next iteration
            while(!stack.isEmpty()) { // if stack is empty, leave it to the for loop
                S2 s2 = stack.peek();
                s2.incrementIndex++;
                if(indices[s2.elem] + s2.incrementIndex >= candidates.length) {
                    stack.pop();
                } else {
                    break;
                }
            }
        }
    }

    private int[] getIndices(int[] candidates) {
        int[] indices = new int[41];
        for(int i = 0; i < candidates.length; i++) {
            indices[candidates[i]] = i;
        }
        return indices;
    }
}
