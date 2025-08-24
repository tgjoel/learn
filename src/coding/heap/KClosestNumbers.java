package coding.heap;


import java.util.*;

/// https://leetcode.com/problems/find-k-closest-elements/description/
public class KClosestNumbers {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3, 4, 5};
        int k = 4, x = -1;
        List<Integer> ansList = findClosestElements(arr, k, x);
        ansList.forEach(System.out::print);

        System.out.println();
        int[] arr2 = {1,2,3,4,5};
        int k2 = 4, x2 = 3;
        List<Integer> ansList2 = findClosestElements(arr2, k2, x2);
        ansList2.forEach(System.out::print);

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

      //  PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a,b) -> b[0] - a[0]); // the comparison should be done using the distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a,b) -> a[0] ==  b[0] ? b[1] - a[1]: b[0] - a[0]);
        // this is needed because if the distance is same, then need to consider the ascending ordered element


        for (int i : arr) {
            int distance = Math.abs(i - x);
            maxHeap.offer(new int[]{distance, i});
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<Integer> ansList = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            ansList.add(maxHeap.poll()[1]); // need to poll the actual number
        }
        Collections.sort(ansList);  // sorting the ans list
        return ansList;
    }
}
