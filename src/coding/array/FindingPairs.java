package coding.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FindingPairs {

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1,5,3,4,2,-1,-4,-1,4);
        int k = 3;

        Map<Integer, Boolean> numMap = new HashMap<>();
        for (Integer integer : numList) {
            numMap.put(integer, true);
        }

        int count = 0;
        for (Integer i : numList) {
           if(Objects.nonNull(numMap.get(i-k))) {
               count++;
           } else if(Objects.nonNull(numMap.get(i+k))){
               count++;
           }
        }
        if(count !=0) {
            System.out.println("Total count: " + count/2);
        } else {
            System.out.println("Total count: " + count);
        }

    }
}
