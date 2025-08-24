package coding.stack;

import java.util.Arrays;
import java.util.Stack;

//Nearest smallest element to the left
public class NSL {
    public static void main(String[] args) {
        int arr[] = {4,5,2,10,8};
        System.out.println(Arrays.toString(nearestSmallestElementToLeft(arr)));
    }

    private static int[] nearestSmallestElementToLeft(int[] arr) {
        int[] ans = new int[arr.length];

        Stack<Integer> integerStack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            while (!integerStack.isEmpty() && integerStack.peek() >= arr[i]) {
                integerStack.pop();
            }
            if(integerStack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = integerStack.peek();
            }
            integerStack.push(arr[i]);
        }
        return ans;
    }
}
