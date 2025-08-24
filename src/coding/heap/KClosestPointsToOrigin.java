package coding.heap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };
        int k = 2;

        int[][] ansList = closesPointsToOrigin(matrix, k);
        for (int i = 0; i < ansList.length; i++) {
            System.out.print(ansList[i][0] + "  " + ansList[i][1]);
            System.out.println();
        }

    }

    private static int[][] closesPointsToOrigin(int[][] matrix, int k) {

        // Distance between two points = Sqrt of ((x2-x1)^2 + (y2-y1)^2)
        // since origin x1,y1  == 0; ineffective it will be X2^2 + Y2^2

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for (int i = 0; i < matrix.length; i++) {
            maxHeap.offer(matrix[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int ans[][] = new int[k][2];
        int index = k - 1;
        while (!maxHeap.isEmpty()) {
            ans[index--] = maxHeap.poll();
        }
        return ans;


    }
}
