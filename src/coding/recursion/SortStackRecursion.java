package coding.recursion;

import java.util.Stack;

public class SortStackRecursion {
    public static void main( String[] args ) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(0);

        sort(stack);
        stack.forEach(System.out::println);
    }

    private static void sort( Stack<Integer> stack ) {

        if(stack.isEmpty()) return;
        int val = stack.pop();
        sort(stack);
        insert(stack, val);

    }

    private static void insert( Stack<Integer> stack, int val ) {
        if(stack.isEmpty() || val < stack.peek()) {
            stack.push(val);
            return;
        }
        int temp = stack.pop(); // reducing the stack
        insert(stack, val);// inserting the val
        stack.push(temp);
        return;
    }
}
