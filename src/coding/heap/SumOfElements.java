package coding.heap;

import java.util.PriorityQueue;

public class SumOfElements {

    // find the Sum of Elements between k1 smallest and k2 smallest numbers

    public static void main(String[] args) {
        int arr[] = {1,12,15,5,3,11};
        int k1 = 3 , k2= 6;

        System.out.println(findSumBetween(arr, k1, k2));
    }

    private static int findSumBetween(int[] arr, int k1, int k2) {
        
        int k1Smallest = findKthSmallest(arr, k1);
        int k2Smallest = findKthSmallest(arr, k2);

        int sum = 0;

        for(int i : arr) {
            if(i > k1Smallest && i< k2Smallest) {
                sum +=i;
            }
        }
        return sum;
    }

    private static int findKthSmallest(int[] arr, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i : arr) {
            maxHeap.offer(i);
            if(maxHeap.size() > k) {
                maxHeap.poll() ;
            }
        }
        return maxHeap.poll();
    }

}
