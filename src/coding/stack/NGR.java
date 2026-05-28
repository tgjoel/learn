package coding.stack;

//Nearest Greater to right | Next Largest Element

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NGR {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        int[] ans = ngr(nums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] ngr(int[] nums) {
        //int[] ans = new int[nums.length];
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> intStack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {   /// ---- O(n)
            // if stack is empty meaning there is no element greater than the current element. so adding -1.
            // we need to push the current element into the array
//            if (intStack.isEmpty()) {
//                ans.add(-1);
//                intStack.push(nums[i]);
//                continue;
//            }
            // will keep on poping from the stack till we get the top element greater than current element.
            // also note that all the elements less than current element is of no use as the ngr for the next element will be current element. so pooping them out
            while (!intStack.isEmpty() && intStack.peek() <= nums[i]) {    /// ---- O(n)
                intStack.pop();
            }
            // if we found an element greater than the current element, then that is the ans.
            if (!intStack.isEmpty()) {
                ans.add(intStack.peek());
            } else {
                ans.add(-1); // adding -1 to the ans as the stack is empty
            }
            // also need to push the current element to the stack, as it could be greater element to the next one
            intStack.push(nums[i]);
        }
        return ans.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
    /// ---- O(n) +  O(n) =  O(2n) ~ O(n)
}
