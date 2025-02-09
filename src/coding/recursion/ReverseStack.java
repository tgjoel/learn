package coding.recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main( String[] args ) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.forEach(System.out::println);
        System.out.println("Reverse Stack");
        reverse(stack);
        stack.forEach(System.out::println);
    }

    private static void reverse(Stack<Integer> stack) {
        //base condition
        if(stack.isEmpty()) return;

        //Hypothesis
        int temp = stack.pop();
        reverse(stack); // solve with reduced input

        //induction
        //need to insert back the popped element back to the stack.  but it needs to be insert at the end. this is itself another recursive problem.
        insertAtEnd(stack, temp);
    }
    private static void insertAtEnd(Stack<Integer> stack, int value) {
        //Base condition push to the stack when its empty
        if(stack.isEmpty()) {
            stack.push(value);
            return;
        }
        //hypothesis: solve in reduced input
        int temp = stack.pop();
        insertAtEnd(stack, value);
        //induction insert back the popped value
        stack.push(temp);
    }
}
