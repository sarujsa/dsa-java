package saruj.leet.problems;

import java.util.*;

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
public class P2547 {

    public static void main(String[]args) {
        int[] nums = new int[]{2,3,3,3,1,5,5,0,5,3,4,2,1,2,5,1,2,0};
        int k = 5;
        Solution s = new Solution();
        int ret = s.minCost(nums, k);
        System.out.println(ret);
    }

    static class Solution {
        public int minCost(int[] nums, int k) {
            initImportanceGrid(nums, k);
            int[] dp = new int[nums.length];
            dp[0] = k;
            for(int i = 1; i < dp.length; i++) {
                int min = importanceGrid[0][i];
                for(int j = 0; j < i; j++) {
                    min = Math.min(min, dp[j] + importanceGrid[j+1][i]);
                }
                dp[i] = min;
            }
            return dp[dp.length-1];
        }
        int[][] importanceGrid = null;

        private void initImportanceGrid(int[] nums, int k) {
            importanceGrid = new int[nums.length][nums.length];
            for(int i = 0; i < nums.length; i++) {
                int[] frequencies = new int[1001];
                int importance = k;
                for(int j = i; j < nums.length; j++) {
                    frequencies[nums[j]]++;
                    if(frequencies[nums[j]] == 2) {
                        importance+=2;
                    } else if(frequencies[nums[j]] > 1) {
                        importance++;
                    }
                    importanceGrid[i][j] = importance;
                }
            }
        }


        /**
         * As the name suggest, this solution is correct but time complexity is O(n^3).
         * However, it's a precomputed DP-solved problem, not recursively.  That is why
         * it is faster than the other O(n^3) solution.
         * @param nums
         * @param k
         * @return
         */
        public int minCost_BigOn3(int[] nums, int k) {
            initImportanceGrid(nums, k);
            int[][] M = new int[nums.length][nums.length];
            for(int i = nums.length-1; i >= 0; i--) {
                for(int j = i; j < nums.length; j++) {
                    if(j == i) {
                        M[i][j] = k;
                    } else {
                        int min = importanceGrid[i][j];
                        for(int t = i; t < j; t++) {
                            min = Math.min(min, M[i][t] + M[t+1][j]);
                        }
                        M[i][j] = min;
                    }
                }
            }
            return M[0][nums.length-1];
        }
        /**
         * As the name suggests, this method has time complexity O(n^3).
         * Unlike the other similarly named method, this method uses wrong memoization
         * (so memo is useless, effectively it uses brute force).
         * Also it does not precompute DP, it goes recursively.
         * @param nums
         * @param k
         * @return
         */
        public int minCost_BigOn3_wrongMemo(int[] nums, int k) {
            List<Integer> list = new ArrayList<>();
            initImportanceGrid(nums, k);
            list.add(1);
//            return Math.min(importance(nums, k, 0, nums.length, new HashMap<>()), minCost(nums, k, list));
            return Math.min(importanceGrid[0][nums.length-1], minCost_BigOn3_wrongMemo(nums, k, list));
        }

        public int minCost_BigOn3_wrongMemo(int[] nums, int k, List<Integer> indices) {
            Map<List<Integer>,Integer> memo = new HashMap<>();
            return minCost_BigOn3_wrongMemo(nums, k, indices, memo);
        }

        int memoCallCounter = 0;

        public int minCost_BigOn3_wrongMemo(int[] nums, int k, List<Integer> indices, Map<List<Integer>, Integer> memo) {
            Integer lastIndex = indices.get(indices.size()-1);
            Integer maybeRet = memo.get(indices);
            if(maybeRet != null) {
                memoCallCounter++;
                return maybeRet;
            } else if(lastIndex == nums.length-1) {
                int sum = sumImportance(nums, k, indices);
                memo.put(indices, sum);
                return sum;
            }
            int currentSumImportance = sumImportance(nums, k, indices);
            List<Integer> indices1 = new ArrayList<>(indices);
            indices1.set(indices.size()-1, lastIndex+1);
            List<Integer> indices2 = new ArrayList<>(indices);
            indices2.add(lastIndex+1);

            int retVal = Math.min(currentSumImportance,
                    Math.min(minCost_BigOn3_wrongMemo(nums, k, indices1, memo), minCost_BigOn3_wrongMemo(nums, k, indices2, memo)));
            memo.put(indices, retVal);
            return retVal;
        }

        private int sumImportance(int[] nums, int k, List<Integer> indices) {
            int index = 0;
            int startIndex = 0;
            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                if(i == indices.get(index)) {
//                    sum += importance(nums, k, startIndex, i, importanceMemo);
                    sum += importanceGrid[startIndex][i-1];
                    startIndex = i;
                    index++;
                    if(index > indices.size()-1) {
//                        sum+= importance(nums, k, startIndex, nums.length, importanceMemo);;
                        sum += importanceGrid[startIndex][nums.length-1];
                        break;
                    }
                }
            }
            return sum;
        }

        private int importance(int[] nums, int k, int startIndex, int endIndex, Map<Integer, Integer> importanceMemo) {
            if(endIndex == startIndex + 1) {
                return k;
            } else if (endIndex == startIndex + 2) {
                if (nums[startIndex] != nums[endIndex - 1]) {
                    return k;
                } else {
                    return k + 2;
                }
            }
            int key = (endIndex * 100000 + startIndex);
            if(importanceMemo.containsKey(key)) return importanceMemo.get(key);
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
            importanceMemo.put(key, retVal);
            return retVal;
        }

    }
}
