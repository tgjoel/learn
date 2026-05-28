package coding.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = {7,10,4,3,20,15,5,1};
        System.out.println(kthLargestElement(arr, 3));
    }

    private static int kthLargestElement(int[] arr, int k) {
    // kth Largest means Min heap

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i ++) {
            minHeap.offer(arr[i]);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.isEmpty() ?  -1 : minHeap.peek();
    }
}
