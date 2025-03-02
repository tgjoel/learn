package coding.recursion;

import java.util.Stack;

public class DeleteMiddleElementStack {
    public static void main( String[] args ) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        stack.push(5);
//        stack.push(6);
//        stack.push(7);
        int k = stack.size()/2 + 1;
        System.out.println("Element position to be deleted " + k);
        delete(stack, k);
        stack.forEach(System.out::println);
    }

    private static void delete( Stack<Integer> stack, int k ) {
        //base condition
        if(k == 1) {
            stack.pop(); // delete from the top, when k == 1
            return;
        }
        //hypothesis
        //reduce the input
        int temp = stack.pop();
        delete(stack, k-1); // when stack input is reduced k is also reduced

        //induction
        stack.push(temp); // push back the temp to the removed stack
    }
}
