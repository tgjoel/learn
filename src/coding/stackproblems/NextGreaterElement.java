package coding.stackproblems;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {11, 21, 12, 3, 15};  // {4, 5, 2, 25}  // {13, 7, 6, 12}
        printNGE(arr);
    }
    private static void printNGE(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        //here actually we are comparing the element in the stack with the loop.
        for (int i = 1; i < arr.length; i++) {
            int elm = stack.pop();
            //for all the elements in the stack checking if the current one is the greater element
            while (elm < arr[i]) {
                System.out.println(elm + "--->" + arr[i]);
                if (stack.isEmpty()) {
                    break;
                }
                elm = stack.pop();
            }
            if (elm > arr[i]) {
                stack.push(elm);
            }
            stack.push(arr[i]);
        }
        if (!stack.isEmpty()) {
            for (Integer i : stack) {
                System.out.println(i + "--->" + -1);
            }
        }
    }
}
