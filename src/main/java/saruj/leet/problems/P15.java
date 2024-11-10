package saruj.leet.problems;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i !=
 * j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * <p>Notice that the solution set must not contain duplicate triplets.
 */
public class P15 {

  public static void main(String[] args) {
    P15 p15 = new P15();
    int[] nums1;

//    nums1 = new int[]{-1,0,1,2,-1,-4};
//    System.out.println(p15.threeSum(nums1));;

//    nums1 = new int[]{0,1,1};
//    System.out.println(p15.threeSum(nums1));

//    nums1 = new int[]{0,0,0};
//    System.out.println(p15.threeSum(nums1));

//    nums1 = new int[]{-1,-2,-3,-4,-5,-10,1,2,3,4,5,10};
//    System.out.println(p15.threeSum(nums1));

//    nums1 = new int[]{0,-1,-2,-3,-4,-5,-10,1,2,3,4,5,10};
//    System.out.println(p15.threeSum(nums1));

    nums1 = new int[]{34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};
    System.out.println(p15.threeSum(nums1));
  }

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    Data sortedData;
    try {
      sortedData = Data.splitAndDivideNums(nums);
    } catch (NoPositiveOrNoNegativeElemsException e) {
      List<List<Integer>> result = new ArrayList<>();
      if(e.threeZeroes) {
        result.add(Arrays.asList(0,0,0));
      }
      return result;
    }

    List<List<Integer>> result = calculateResult(sortedData);
    if (sortedData.threeZeroes) {
      result.add(Arrays.asList(0, 0, 0));
    }

    return result;
  }

  private List<List<Integer>> calculateResult(Data data) {
    List<List<Integer>> result = new ArrayList<>();
    oneNegativeTwoPositives(result, data);
    onePositiveTwoNegatives(result, data);
    if(data.zero) {
      zeroOnePositiveOneNegative(result, data);
    }
    return result;
  }

  private void zeroOnePositiveOneNegative(List<List<Integer>> result, Data data) {
    List<Integer> negatives = data.oneElementNegatives;
    List<Integer> positives = data.oneElementPositives;
    int ineg = 0;
    int ipos = positives.size()-1;
    while(ineg < negatives.size() && ipos >= 0) {
      int sumpos = positives.get(ipos);
      int sumneg = negatives.get(ineg);
      int comparison = sumpos + sumneg;
      if(comparison == 0) {
        List<Integer> singlePos = new ArrayList<>();
        while(ipos >= 0 && positives.get(ipos) == sumpos) {
          singlePos.add(positives.get(ipos));
          ipos--;
        }
        List<Integer> singleNeg = new ArrayList<>();
        while(ineg < negatives.size() && negatives.get(ineg) == sumneg) {
          singleNeg.add(negatives.get(ineg));
          ineg++;
        }
        combineSinglesIntoResult(result, singleNeg, singlePos);
      } else if (comparison < 0) {
        ineg++;
      } else {
        ipos--;
      }
    }
  }

  private void onePositiveTwoNegatives(List<List<Integer>> result, Data data) {
    List<Triple> negatives = data.twoElementNegatives;
    List<Integer> positives = data.oneElementPositives;
    int ineg = 0;
    int ipos = positives.size()-1;
    while(ineg < negatives.size() && ipos >= 0) {
      int sumpos = positives.get(ipos);
      int sumneg = negatives.get(ineg).sum;
      int comparison = sumpos + sumneg;
      if(comparison == 0) {
        List<Integer> singles = new ArrayList<>();
        while(ipos >= 0 && positives.get(ipos) == sumpos) {
          singles.add(positives.get(ipos));
          ipos--;
        }
        List<Triple> triples = new ArrayList<>();
        while(ineg < negatives.size() && negatives.get(ineg).sum == sumneg) {
          triples.add(negatives.get(ineg));
          ineg++;
        }
        combineIntoResult(result, triples, singles);
      } else if (comparison < 0) {
        ineg++;
      } else {
        ipos--;
      }
    }

  }

  private void oneNegativeTwoPositives(List<List<Integer>> result, Data data) {
    List<Integer> negatives = data.oneElementNegatives;
    List<Triple> positives = data.twoElementPositives;
    int ineg = 0;
    int ipos = positives.size()-1;
    while(ineg < negatives.size() && ipos >= 0) {
      int sumpos = positives.get(ipos).sum;
      int sumneg = negatives.get(ineg);
      int comparison = sumpos + sumneg;
      if(comparison == 0) {
        List<Triple> triples = new ArrayList<>();
        while(ipos >= 0 && positives.get(ipos).sum == sumpos) {
          triples.add(positives.get(ipos));
          ipos--;
        }
        List<Integer> singles = new ArrayList<>();
        while(ineg < negatives.size() && negatives.get(ineg) == sumneg) {
          singles.add(sumneg);
          ineg++;
        }
        combineIntoResult(result, triples, singles);
      } else if (comparison < 0) {
        ineg++;
      } else {
        ipos--;
      }
    }
  }

  private void combineSinglesIntoResult(List<List<Integer>> result, List<Integer> singles1, List<Integer> singles2) {
    for(int s1 : singles1) {
      for(int s2 : singles2) {
        result.add(List.of(0, s1, s2));
      }
    }
  }

  private void combineIntoResult(List<List<Integer>> result, List<Triple> triples, List<Integer> singles) {
    for(Triple triple : triples) {
      for(int single : singles) {
        result.add(List.of(single, triple.first, triple.second));
      }
    }
  }

  private static class Data {
    private boolean zero;
    private boolean threeZeroes;

    private int firstPositiveIndex;
    private int lastNegativeIndex;
    private int locatedZeroIndex;

    private List<Integer> oneElementNegatives;
    private List<Triple> twoElementNegatives;
    private List<Integer> oneElementPositives;
    private List<Triple> twoElementPositives;

    public Data(int length) {
      oneElementNegatives = new ArrayList<>(length);
      twoElementNegatives = new ArrayList<>(length);
      oneElementPositives = new ArrayList<>(length);
      twoElementPositives = new ArrayList<>(length);
    }

    private static Data splitAndDivideNums(int[] sortedNums) {
      Data data = new Data(sortedNums.length);
      data.locatedZeroIndex = Arrays.binarySearch(sortedNums, 0);
      if(data.locatedZeroIndex < 0) {
        findIndices_noZeroInNums(sortedNums, data);
      } else {
        findIndices_zeroInNums(sortedNums, data);
      }
      if(data.firstPositiveIndex < 0 || data.lastNegativeIndex < 0) {
        throw new NoPositiveOrNoNegativeElemsException(data.threeZeroes);
      }

      divideIntoLists(data, sortedNums);
      return data;
    }

    private static void divideIntoLists(Data data, int[] sortedNums) {
      int previousElem = 1;
      for(int i = 0; i <= data.lastNegativeIndex; i++) {
        if (sortedNums[i] != previousElem) {
          data.oneElementNegatives.add(sortedNums[i]);
        }
        previousElem = sortedNums[i];
      }
      previousElem = -1;
      for(int i = data.firstPositiveIndex; i < sortedNums.length; i++) {
        if(sortedNums[i] != previousElem) {
          data.oneElementPositives.add(sortedNums[i]);
        }
        previousElem = sortedNums[i];
      }

      Set<Triple> setOfNegativePairs = new HashSet<>();
      for(int i = 0; i < data.lastNegativeIndex; i++) {
        for(int j = i+1; j <= data.lastNegativeIndex; j++) {
          setOfNegativePairs.add(new Triple(sortedNums[i], sortedNums[j]));
        }
      }
      data.twoElementNegatives.addAll(setOfNegativePairs);
      data.twoElementNegatives.sort(Comparator.comparing(t -> t.sum));

      Set<Triple> setOfPositivePairs = new HashSet<>();
      for (int i = data.firstPositiveIndex; i < sortedNums.length-1; i++) {
        for(int j = i+1; j < sortedNums.length; j++) {
          setOfPositivePairs.add(new Triple(sortedNums[i], sortedNums[j]));
        }
      }
      data.twoElementPositives.addAll(setOfPositivePairs.stream().toList());
      data.twoElementPositives.sort(Comparator.comparing(t -> t.sum));
    }

    private static void findIndices_zeroInNums(int[] sortedNums, Data sortedData) {
      sortedData.zero = true;
      int zeroCount = 1;
      int i = sortedData.locatedZeroIndex+1;
      for(; i < sortedNums.length && sortedNums[i] == 0; i++) {
        zeroCount++;
      }
      sortedData.firstPositiveIndex = i;
      if(sortedData.firstPositiveIndex >= sortedNums.length) {
        sortedData.firstPositiveIndex = -1;
      }

      i = sortedData.locatedZeroIndex-1;
      for(; i >= 0 && sortedNums[i] == 0; i--) {
        zeroCount++;
      }
      sortedData.lastNegativeIndex = i; // this includes if i == -1

      if(zeroCount >= 3) {
        sortedData.threeZeroes = true;
      }
    }

    private static void findIndices_noZeroInNums(int[] sortedNums, Data sortedData) {
      sortedData.zero = false;
      sortedData.threeZeroes = false;
      sortedData.firstPositiveIndex = (sortedData.locatedZeroIndex + 1) * -1;
      if (sortedData.firstPositiveIndex == sortedNums.length) {
        sortedData.firstPositiveIndex = -1;
      }
      sortedData.lastNegativeIndex = sortedData.firstPositiveIndex - 1;
    }

  }

  private static class NoPositiveOrNoNegativeElemsException extends RuntimeException {
    private final boolean threeZeroes;

    public NoPositiveOrNoNegativeElemsException(boolean threeZeroes) {
      this.threeZeroes = threeZeroes;
    }
  }

  private static class Triple {
    private final int sum;
    private final int first;
    private final int second;

    public Triple(int first, int second) {
      this.sum = first + second;
      this.first = first;
      this.second = second;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Triple triple = (Triple) o;
      return sum == triple.sum && first == triple.first && second == triple.second;
    }

    @Override
    public int hashCode() {
      return Objects.hash(sum, first, second);
    }

    @Override
    public String toString() {
      return "[" + first + ", " + second + ']';
    }
  }

}
