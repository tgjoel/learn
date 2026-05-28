package coding.stack;

import java.util.Stack;

public class MinStackWithExtraSpace {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(3);
        minStack.push(-2);
        System.out.println("Min:" + minStack.getMin());
        System.out.println("Popped: " + minStack.pop());
        System.out.println("Min: " + minStack.getMin());
    }

    static class MinStack {
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> supportingStack = new Stack<>();

        private void push(int a) {
            this.minStack.push(a);
            if (supportingStack.isEmpty() || supportingStack.peek() >= a) {
                supportingStack.push(a);
            }
        }

        private int pop() {
            if (minStack.isEmpty()) {
                return -1;
            }
            int poppedElement = minStack.pop();
            if (!supportingStack.isEmpty() && supportingStack.peek() == poppedElement) {
                supportingStack.pop();
            }
            return poppedElement;
        }

        private int getMin() {
            if (supportingStack.isEmpty()) {
                return -1;
            } else {
                return supportingStack.peek();
            }
        }
    }
}
