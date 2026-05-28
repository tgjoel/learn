package coding.stack;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/description/
public class MinStackWithoutExtraSpace {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    /*
    static class MinStack1 {
        private Stack<Long> stack;
        private long min;

        public MinStack1() {
            stack = new Stack<>();
            min = Long.MAX_VALUE;
        }

        public void push(int val) {
            long value = val;
            if (stack.isEmpty()) {
                stack.push(value);
                min = val;
            } else if (value >= min) {
                stack.push(value);
            } else {
                stack.push(2 * value - min);
                min = value;
            }
        }

        public void pop() {
            if (stack.peek() < min) {
                min = 2 * min - stack.peek();
            }
            stack.pop();
        }

        public int top() {
            if (stack.peek() < min) {
                return (int) min;
            }
            return stack.peek().intValue();
        }

        public int getMin() {
            return (int) min;
        }
    } */


    static class MinStack {
        int min;
        Stack<Integer> intStack = new Stack<>();

        private void push(int val) {
            if (intStack.isEmpty()) {
                intStack.push(val);
                min = val;
            } else if (val >= min) {
                intStack.push(val);
            } else {
                //calculation: calculatedVal =  2 * Val - currentMin
                int calculatedTop = 2 * val - min;
                intStack.push(calculatedTop);
                min = val; // assigning the current val as new min

            }
        }

        private int pop() {
            int popped = intStack.pop();
            if (popped < min) {
                // the actual element is stored in the min value as we are storing the calculated val in the stack
                // need to calculate the new min
                //calculation: currentMin = 2 * Val - calculatedVal
                int newMin = 2 * min - popped;
                popped = min;
                min = newMin;
            }
            return popped;
        }

        public int top() {
            // If the top element is calculated value then actual element is the min element
            if (intStack.peek() < min) {
                return min;
            }
            return intStack.peek();
        }

        public int getMin() {
            return min;
        }

    }
}
