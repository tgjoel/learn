package coding.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15,5,1};
        System.out.println(kthSmallestElement(arr,3));
    }

    private static int kthSmallestElement(int[] arr, int k) {
        //Kth smallest element means maxHeap

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if(maxHeap.size()>k) {
                maxHeap.poll();
            }
        }
        return maxHeap.isEmpty() ? -1: maxHeap.peek();
    }
}
