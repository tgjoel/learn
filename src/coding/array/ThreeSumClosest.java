package coding.array;

import java.util.Arrays;
import java.util.Map;

//16. 3Sum Closest
/*
Given an integer array nums of length n and an integer target,
find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public static void main( String[] args ) {
       // int[] nums = {-1, 2, 1, -4};
       // int target = 1; // output  is 2  [-1,2,1] is the closest
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        int target = -2; // output  is -2
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest( int[] nums, int target ) {
        Arrays.sort(nums);
        int n = nums.length;
        int closetSum = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                if(currSum == target) {
                    return currSum;
                }
                if (Math.abs(target - currSum) < Math.abs(target - closetSum)) {
                    closetSum = currSum;
                }
                if (currSum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closetSum;
    }
}
