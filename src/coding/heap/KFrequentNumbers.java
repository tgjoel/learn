package coding.heap;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class KFrequentNumbers {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ans = topKFrequent(arr, k);
        Arrays.stream(ans).forEach(System.out::print);
        System.out.println();

        int[] arr1 = {-1, -1 };
        int k1 = 1;
        int[] ans1 = topKFrequent(arr1, k1);
        Arrays.stream(ans1).forEach(System.out::print);


    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        //(a,b) -> a[0] - b[0]
        // should be in the ascending order a[0] - b[0]

        frequencyMap.forEach((number, frequency) -> {
            minHeap.offer(new int[]{frequency, number});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        int[] ans = new int[k];
        int index = k-1;
        while (!minHeap.isEmpty()) {
            ans[index--] = minHeap.poll()[1];
        }
        return ans;

        /*
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        frequencyMap.entrySet().forEach(entry -> {
            minHeap.offer(entry);
            if(minHeap.size() >  k) {
                minHeap.poll();
            }
        });

        int[] ans = new int[k];
        int index = k-1;
        while (!minHeap.isEmpty()) {
            ans[index--] = minHeap.poll().getKey();
        }
         */
    }
}
