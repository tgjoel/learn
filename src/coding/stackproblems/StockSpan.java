package coding.stackproblems;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] input = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(input);
        Arrays.stream(span).forEach(System.out::print);
    }
    private static int[] calculateSpan(int[] input) {
        int[] span = new int[input.length];
        //first element span is always 1
        span[0] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // first index
        //iterating from the second on the list
        for (int i = 1; i < input.length; i++) {
            //popping the index of the elements out until the incoming number is less than the top of the stack
            while (!stack.isEmpty() && input[i] >= input[stack.peek()]) {
                stack.pop();
            }
            //if stack is empty then all previous ones were less than the current.
            //else current will be equal to the current index - current top of the stack index
            span[i] = stack.isEmpty() ? i + 1 : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }
}
