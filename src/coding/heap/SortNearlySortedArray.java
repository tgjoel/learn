package coding.heap;

import java.util.PriorityQueue;

/// Also known as Sort a K Sorted Array
public class SortNearlySortedArray {

    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 3, 8, 10, 9};
        int[] ans = sortKSortedArray(arr, 3);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    private static int[] sortKSortedArray(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] ans = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(arr[i]);

            // smallest number will be at the top
            if (minHeap.size() > k) {
                ans[index++] = minHeap.poll();
            }
        }
        //add back the remaining elements
        while(!minHeap.isEmpty()) {
            ans[index++] = minHeap.poll();
        }
        return ans;
    }

}
