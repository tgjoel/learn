package coding.stack;

import java.util.Arrays;
import java.util.Stack;

//nearest greater element to the left
public class NGL {
    public static void main(String[] args) {
        int[] n = {5, 3, 2, 4, 6};
        System.out.println(Arrays.toString(nearestElementToLeft(n)));
    }

    public static int[] nearestElementToLeft(int[] nums) {
        Stack<Integer> integerStack = new Stack<>();
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!integerStack.isEmpty() && integerStack.peek() <= nums[i]) {
                integerStack.pop();
            }

            if (!integerStack.isEmpty()) {
                ans[i] = integerStack.peek();
            } else {
                ans[i] = -1;
            }
            integerStack.push(nums[i]);
        }
        return ans;
    }
}
