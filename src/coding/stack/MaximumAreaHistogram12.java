package coding.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class MaximumAreaHistogram12 {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int[] arr1 = {2,1,5,6,2,3};
        int[] arr2 = {1,1};
        System.out.println(maximumAreaHistogram(arr));
    }

    private static int maximumAreaHistogram(int[] arr) {

        // find index of  the nsl
        // find index of the nsr
        // substract the index of nsr - nsl - 1 as need in between
        // condition is if either nsr or nsl is not there then no substraction
        // multiple the ans index with the array value
        // find max of the above

        //Finding the nsl
        int[] nsl = findNSL(arr);

        //finding the nsr
        int[] nsr = findNSR(arr);

        int maxArea = 0;
        for(int i = 0 ; i < arr.length; i++) {
            maxArea = Math.max(maxArea,(nsr[i] - nsl[i] - 1) * arr[i]);
        }
        return maxArea;
    }

    private static int[] findNSL(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!integerStack.isEmpty() && arr[integerStack.peek()] >= arr[i]) {
                integerStack.pop();
            }
            if (integerStack.isEmpty()) {
                ans[i] = -1; // when there is no number on the left
            } else {
                ans[i] = integerStack.peek();
            }
            integerStack.push(i);
        }
        return ans;
    }

    private static int[] findNSR(int[] arr) {
        List<Integer> ansList = new ArrayList<>();

        Stack<Integer> integerStack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!integerStack.isEmpty() && arr[integerStack.peek()] >= arr[i]) {
                integerStack.pop();
            }
            if (integerStack.isEmpty()) {
                ansList.add(arr.length); // instead of the -1 if there is no number on the right
                // keep as length of arr for the calculation purpose
            } else {
                ansList.add(integerStack.peek());
            }
            integerStack.push(i);
        }
        return ansList.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
}
