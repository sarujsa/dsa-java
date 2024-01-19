package saruj.leet.problems;

import java.util.*;

/**
 * Letter Combinations of a Phone Number
 */
public class P17 {

    public static void main(String[] args) {
        P17 p = new P17();

        System.out.println(p.letterCombinations("2"));
        System.out.println(p.letterCombinations(""));
        System.out.println(p.letterCombinations("23"));
        System.out.println(p.letterCombinations("234"));
        System.out.println(p.letterCombinations("2345"));
    }

    private final Map<Character,List<String>> map;

    public P17() {
        this.map = new HashMap<>();
        map.put('2', asList("abc"));
        map.put('3', asList("def"));
        map.put('4', asList("ghi"));
        map.put('5', asList("jkl"));
        map.put('6', asList("mno"));
        map.put('7', asList("pqrs"));
        map.put('8', asList("tuv"));
        map.put('9', asList("wxyz"));
    }

    private List<String> asList(String str) {
        List<String> list = new ArrayList<>(str.length());
        for(char c : str.toCharArray()) {
            list.add(Character.toString(c));
        }
        return list;
    }

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        } else if(digits.length() == 1) {
            return map.get(digits.charAt(0));
        } else {
            List<String> second = map.get(digits.charAt(digits.length()-1));
            for(int i = digits.length()-2; i >= 0; i--) {
                List<String> first = map.get(digits.charAt(i));
                second = combineTwoLists(first, second);
            }
            return second;
        }
    }

    private List<String> combineTwoLists(List<String> first, List<String> second) {
        List<String> resultList = new ArrayList<>(first.size()*second.size());
        for(String f : first) {
            for(String s : second) {
                resultList.add(f+s);
            }
        }
        return resultList;
    }


}
