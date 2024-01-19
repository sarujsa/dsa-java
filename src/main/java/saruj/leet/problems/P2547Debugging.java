package saruj.leet.problems;

import org.apache.commons.lang3.tuple.Pair;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Minimum Cost to Split an Array.
 * You are given an integer array nums and an integer k.
 * Split the array into some number of non-empty subarrays. The cost of a split is the sum of the importance value of each subarray in the split.
 * Let trimmed(subarray) be the version of the subarray where all numbers which appear only once are removed.
 * For example, trimmed([3,1,2,4,3,4]) = [3,4,3,4].
 * The importance value of a subarray is k + trimmed(subarray).length.
 * For example, if a subarray is [1,2,3,3,3,4,4], then trimmed([1,2,3,3,3,4,4]) = [3,3,3,4,4].The importance value of this subarray will be k + 5.
 * Return the minimum possible cost of a split of nums.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class P2547Debugging {

    public static void main(String[]args) throws FileNotFoundException {
        int[] nums = new int[]{2,3,3,3,1,5,5,0,5,3,4,2,1,2,5,1,2,0};
//        int[] nums = new int[]{1,2,1,2,1,3,3};
//        int[] nums = new int[]{1,2,1,2,1};
        int k = 5;
        var ret = new Solution().minCost(nums, k);
        printResult(nums, ret);
    }

    private static void printResult(int[] nums, Pair<Integer, List<Integer>> ret) {
        printResult(nums, ret, new PrintWriter(System.out));
    }

    private static void printResult(int[] nums, Pair<Integer, List<Integer>> ret, PrintWriter pw) {
        List<Integer> indices = ret.getRight();
        pw.print(ret.getLeft() + " | " + indices + " | ");
        if(indices.isEmpty()) {
            pw.println(Arrays.stream(nums)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(", ", "[", "]")));
        } else {
            int startIndex = 0;
            for(int endIndex : indices) {
                int[] ar = Arrays.copyOfRange(nums, startIndex, endIndex);
                pw.print(Arrays.stream(ar)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(", ", "[", "]")));
                startIndex = endIndex;
            }
            if(startIndex < nums.length) {
                int[] ar = Arrays.copyOfRange(nums, startIndex, nums.length);
                pw.print(Arrays.stream(ar)
                        .mapToObj(Integer::toString)
                        .collect(Collectors.joining(", ", "[", "]")));
            }
            pw.println();
        }
        pw.flush();
    }

    static class Solution {

        private PrintWriter pw = new PrintWriter("src/main/resources/leetcode/2547/out.txt");

        Solution() throws FileNotFoundException {
        }

        public Pair<Integer,List<Integer>> minCost(int[] nums, int k) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int whole = importance(nums, k, 0, nums.length);
            var rest = minCost(nums, k, list);
            if(whole < rest.getLeft()) {
                return Pair.of(whole, new ArrayList<>());
            } else {
                return rest;
            }
        }

        private void testMemo(Map<String, Pair<Integer, List<Integer>>> memo) {
            System.out.println(memo.get(Arrays.asList(11, 14).toString()));
        }

        public Pair<Integer,List<Integer>> minCost(int[] nums, int k, List<Integer> indices) {
            Map<String, Pair<Integer,List<Integer>>> memo = new HashMap<>();
            var retVal = minCost(nums, k, indices, memo);
            memo.forEach((key,v) -> printResult(nums, v, pw));
            testMemo(memo);
            return retVal;
        }

        public Pair<Integer,List<Integer>> minCost(int[] nums, int k, List<Integer> indices,
                                                   Map<String, Pair<Integer,List<Integer>>> memo) {
            Integer lastIndex = indices.get(indices.size()-1);
            String memoKey = indices.toString();
            var maybeRet = memo.get(memoKey);
            if(maybeRet != null) {
                return maybeRet;
            } else if(lastIndex == nums.length-1) {
                int sum = sumImportance(nums, k, indices);
                var p = Pair.of(sum,indices);
                memo.put(memoKey, p);
                return p;
            }
            int currentSumImportance = sumImportance(nums, k, indices);
            List<Integer> indices1 = new ArrayList<>(indices);
            indices1.set(indices.size()-1, lastIndex+1);
            List<Integer> indices2 = new ArrayList<>(indices);
            indices2.add(lastIndex+1);

            var p1 = minCost(nums, k, indices1, memo);
            var p2 = minCost(nums, k, indices2, memo);
            Pair<Integer,List<Integer>> retP = null;
            if(currentSumImportance < p1.getLeft()) {
                if(currentSumImportance < p2.getLeft()) {
                    retP = Pair.of(currentSumImportance, indices);
                } else {
                    retP = Pair.of(p2.getLeft(), indices);
                }
            } else {
                if(p1.getLeft() < p2.getLeft()) {
                    retP = Pair.of(p1.getLeft(), indices);
                } else {
                    retP = Pair.of(p2.getLeft(), indices);
                }
            }
            memo.put(memoKey, retP);
            return retP;
        }

        private int sumImportance(int[] nums, int k, List<Integer> indices) {
            int index = 0;
            int startIndex = 0;
            int sum = 0;
            if(indices.equals(Arrays.asList(9))) {
                System.out.println();
            }
            for(int i = 0; i < nums.length; i++) {
                if(i == indices.get(index)) {
                    sum += importance(nums, k, startIndex, i);
                    startIndex = i;
                    index++;
                    if(index > indices.size()-1) {
                        sum+= importance(nums, k, startIndex, nums.length);;
                        break;
                    }
                }
            }
            return sum;
        }

        private int importance(int[] nums, int k, int startIndex, int endIndex) {
            if(endIndex == startIndex + 1) {
                return k;
            } else if (endIndex == startIndex + 2) {
                if (nums[startIndex] != nums[endIndex - 1]) {
                    return k;
                } else {
                    return k + 2;
                }
            }
            int[] ar = Arrays.copyOfRange(nums, startIndex, endIndex);
            Arrays.sort(ar);

            int retVal = ar.length + k;
            int current = ar[0];
            int countCurr = 1;
            for(int i = 1; i < ar.length; i++) {
                if(ar[i] == current) {
                    countCurr++;
                } else {
                    if(countCurr == 1) {
                        retVal--;
                    }
                    current = ar[i];
                    countCurr = 1;
                }
            }
            if(ar[ar.length-1] != ar[ar.length-2]) {
                retVal--;
            }
            return retVal;
        }

    }
}
