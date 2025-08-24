package coding.heap;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        int[] arr = {6,1,1,1,3,2,2,4};

        List<Integer> ans = frequencySort(arr);
        ans.forEach(System.out::print);
    }

    private static List<Integer> frequencySort(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Arrays.stream(arr).forEach(num -> freqMap.put(num, freqMap.getOrDefault(num, 0) +1));

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey(): a.getValue() - b.getValue());

       freqMap.entrySet().forEach(minHeap::offer);

       List<Integer> ansList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ansList.add(minHeap.poll().getKey());
        }
        return ansList;
    }
}
