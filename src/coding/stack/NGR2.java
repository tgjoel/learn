package coding.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/
// need to find if the array is circular
public class NGR2 {
    public static void main(String[] args) {
        int[] n = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements1(n)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Stack<Integer> intStack = new Stack<>();
        List<Integer> ansList = new ArrayList<>();

        // for circular check
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int index = i % nums.length;

            while (!intStack.isEmpty() && intStack.peek() <= nums[index]) {
                intStack.pop();
            }
            if (i < nums.length) {  // we only need to find the answer for the n elements
                if (!intStack.isEmpty()) {
                    ansList.add(intStack.peek());
                } else {
                    ansList.add(-1);
                }
            }
            intStack.push(nums[index]);
        }
        return ansList.reversed().stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] nextGreaterElements1(int[] nums) {
        Stack<Integer> intStack = new Stack<>();
        int[] ansList = new int[nums.length];


        // for circular check
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int index = i % nums.length;

            while (!intStack.isEmpty() && intStack.peek() <= nums[index]) {
                intStack.pop();
            }
            if (i < nums.length) {
                if (!intStack.isEmpty()) {
                    ansList[index] = intStack.peek();
                } else {
                    ansList[index] = -1;
                }
            }
            intStack.push(nums[index]);
        }
        return ansList;
    }
}
