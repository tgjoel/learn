package coding.array;

import concepts.interfacesample.A;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
K-Diff Pairs in an Array
Find the number of unique pairs (a, b) within the given list of integers where the absolute difference between them is exactly k.
 */
public class FindingPairs {

    public static void main(String[] args) {

        System.out.println(findPairs(List.of(1, 5, 3, 4, 2, -1, -4, -1, 4, 7), 3));
        System.out.println(findPairs(List.of(1, 4, 7), 3));
        System.out.println(findPairs(List.of(3, -3, 3), 0));
        System.out.println(findPairs(List.of(3, -3, -2), 0));
    }

    private static int findPairs(List<Integer> numList, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();

        for (Integer num : numList) {
            numFrequencyMap.put(num, numFrequencyMap.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if (k > 0 && numFrequencyMap.containsKey(num + k)) {
                count++;
            }

            /// for k to be 0, we would need at least 2 occurrence of the same number
            if (k == 0 && frequency > 1) {
                count++;
            }
        }
        return count;
    }
}
