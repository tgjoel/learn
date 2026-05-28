package coding.stack;

import java.util.Arrays;
import java.util.Stack;

//https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6&ab_channel=AdityaVerma
// https://leetcode.com/problems/online-stock-span/
public class StockSpanProblem11 {
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85, 100};

        // three different way to solve, but mostly logic is same
        System.out.println(Arrays.toString(stockSpan(arr)));
        System.out.println(Arrays.toString(stockSpanUsingPairWithIndex(arr)));
        System.out.println(Arrays.toString(stockSpanUsingPairWithoutIndex(arr)));

    }

    /// Without pair using the index from the question
    private static int[] stockSpan(int[] arr) {

        int[] ans = new int[arr.length];
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {

            while (!integerStack.isEmpty() && arr[integerStack.peek()] <= arr[i]) {
                integerStack.pop(); // keep popping all the elements which are less or equal to current number in the stack
            }
            if (integerStack.isEmpty()) {
                ans[i] = i + 1; // all the previous elements are smaller than this and include the current number
            } else {
                ans[i] = i - integerStack.peek();
            }
            integerStack.push(i);
        }

        return ans;
    }

    /// Using pair with the index
    private static int[] stockSpanUsingPairWithIndex(int[] arr) {

        Stack<int[]> arrayStack = new Stack<>();  // int array store the price and index in {price,index}
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            while (!arrayStack.isEmpty() && arrayStack.peek()[0] <= arr[i]) {
                arrayStack.pop();
            }
            if (arrayStack.isEmpty()) {
                ans[i] = i + 1;
            } else {
                ans[i] = i - arrayStack.peek()[1];
            }
            arrayStack.push(new int[]{arr[i], i});
        }

        return ans;
    }

    /// Using pair without the index and counting
    private static int[] stockSpanUsingPairWithoutIndex(int[] arr) {

        Stack<int[]> arrayStack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int span = 1;  // initializing as 1 as current element needs to be counted. span counts the number of elements which were smaller to left
            // than that of the elemnt
            while (!arrayStack.isEmpty() && arrayStack.peek()[0] <= arr[i]) {
                int[] currentTop = arrayStack.pop();
                span = span + currentTop[1]; // adding the current top value to the span, as the current top wil be removed.
            }
            ans[i] = span;

            arrayStack.push(new int[]{arr[i], span});
        }

        return ans;
    }

}
