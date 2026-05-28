package coding.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/maximal-rectangle/description/
public class MaximalRectangle13 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        char[][] matrix1 = {{'0'}};
        char[][] matrix2 = {{'1'}};

       System.out.println(maximalRectangle(matrix));
       System.out.println(maximalRectangle(matrix1));
       System.out.println(maximalRectangle(matrix2));

    }

    private static int maximalRectangle(char[][] matrix) {
        // make the 2d array into  rows number of 1d array histogram
        // find the max area of each the above 1d array
        // do NSR for the index
        // do NSL
        // Width array = NSR - NSL - 1
        // Array * Width array and find the max area
        // Get the maximum of the array
        int maxArea = 0;
        int[] previousHistogram = null;
        for (int i = 0; i < matrix.length; i++) {
            int[] currHistogram = createArray(matrix[i], previousHistogram);
            previousHistogram = currHistogram;

            int[] nsr = findNSR(currHistogram);
            int[] nsl = findNSL(currHistogram);
            int currMaxArea = getMaxArea(nsr, nsl, currHistogram);
            maxArea = Math.max(maxArea, currMaxArea);
        }
        return maxArea;
    }

    private static int getMaxArea(int[] nsr, int[] nsl, int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            maxArea = Math.max(maxArea, ((nsr[i] - nsl[i] - 1) * arr[i]));
        }
        return maxArea;
    }

    private static int[] findNSR(int[] arr) {
        List<Integer> ansList = new ArrayList<>();
        Stack<Integer> integerStack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!integerStack.isEmpty() && arr[integerStack.peek()] >= arr[i]) {
                integerStack.pop();
            }
            if (integerStack.isEmpty()) {
                ansList.add(arr.length);
            } else {
                ansList.add(integerStack.peek());
            }
            integerStack.push(i);
        }
        return ansList.reversed().stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] findNSL(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> integerStack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!integerStack.isEmpty() && arr[integerStack.peek()] >= arr[i]) {
                integerStack.pop();
            }

            if (integerStack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = integerStack.peek();
            }
            integerStack.push(i);
        }
        return ans;
    }

    private static int[] createArray(char[] matrix, int[] created) {
        int[] numberArray = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            numberArray[i] = Character.getNumericValue(matrix[i]);
        }
        if (created != null) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i] != '0') {
                    numberArray[i] = created[i] + 1;
                } else {
                    numberArray[i] = 0;
                }
            }
        }
        return numberArray;
    }

}





