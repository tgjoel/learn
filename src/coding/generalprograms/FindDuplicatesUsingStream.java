package coding.generalprograms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicatesUsingStream {

    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList( 1,2,3,2,1,4,5,3,4,7,5,7,8,8,3,2,2,1,4,2);
        List<String>  stringList = Arrays.asList("Ram", "Sam","Ram", "Roy", "Rai", "Roy","Sam","Bob", "Rai", "Ram");

        Map<Integer, Long> numMap = numList.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<String, Long> strMap = stringList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        numMap.forEach((k,v) -> System.out.println(k + " - " + v));
        strMap.forEach((k,v) -> System.out.println(k + " - " + v));

        System.out.println("Legacy method");
        Map<String, Integer> strMap2 = new HashMap<>();
        for (String s : stringList) {
            if(!strMap2.containsKey(s)) {
                strMap2.put(s, 1);
            } else {
                int count = strMap2.get(s);
                count++;
                strMap2.put(s, count);
            }
        }



    }
}
