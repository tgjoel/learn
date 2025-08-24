package coding.heap;

import java.util.PriorityQueue;

public class ConnectRopesToMinimiseCost {
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
