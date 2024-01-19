package saruj.leet.problems;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class P380Test {
    public static void main(String[]args) throws IOException {
        String expected = Files.readString(Paths.get("src/main/resources/leetcode/380/expected"));
        String real= Files.readString(Paths.get("src/main/resources/leetcode/380/real"));
        Map<Integer,Integer> expectedMap = readIntoMap(expected);
        Map<Integer,Integer> realMap = readIntoMap(real);
        List<Integer> keys1 = expectedMap.keySet().stream()
                .sorted()
                .toList();
        List<Integer> keys2 = realMap.keySet().stream()
                .sorted()
                .toList();
        if(!keys1.equals(keys2)) {
            System.out.println("not same!");
            System.out.println("   EXPECTED|REAL");
            for(Integer k : keys1) {
                System.out.println(StringUtils.leftPad(Objects.toString(expectedMap.get(k)),10)
                        + "|" + realMap.get(k));
            }
        }
        System.out.println("   EXPECTED|REAL");
        for(Integer k : keys2) {
            System.out.println(StringUtils.leftPad(Objects.toString(expectedMap.get(k)),10)
            + "|" + realMap.get(k));
        }
        System.out.println(expectedMap);
        System.out.println(realMap);
    }

    private static Map<Integer, Integer> readIntoMap(String line) {
        List<String> words = Arrays.asList("null","true","false");
        Map<Integer,Integer> map = new HashMap<>();
        for(String word : line.split(",")) {
            if(!words.contains(word)) {
                map.merge(Integer.parseInt(word), 1, Integer::sum);
            }
        }
        return map;
    }
}
