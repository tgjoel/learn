package coding.heap;

import java.util.PriorityQueue;

/**
You are given an array ropes[], where each value represents the length of a rope. You must connect all ropes into one rope.
The cost of connecting two ropes is the sum of their lengths. Find the minimum possible total cost required to connect all ropes.

 Time complexity: O(n log n)
Space complexity: O(n)
 */

public class ConnectRopesToMinimiseCost08 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        int cost = connectToMinimise(arr);
        System.out.println(cost);
    }

    private static int connectToMinimise(int[] arr) {

        int cost = 0;

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int i : arr) {
            minheap.offer(i);
        }

        while (minheap.size() > 1) {
            int smallest = minheap.poll() + minheap.poll(); // polling the smallest
            cost+=smallest;
            minheap.offer(smallest);
        }
        return cost;
    }
}
