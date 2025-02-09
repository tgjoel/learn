package coding.slidingwindow.problems;

import java.util.HashMap;
import java.util.Map;

/*
2461. Maximum Sum of Distinct Subarrays With Length K

You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:

The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.

Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.

 */
public class MaxSumDistinctSubarray {

    public static void main( String[] args ) {

//        int[] nums = {1,5,4,2,9,9,9};
//        int k = 3;

        int[] nums = {1,1,1,7,8,9};
        int k = 3;
        long max = maximumSumDistinctSubarray(nums,k);
        System.out.println("Maximum sum of distinct subarray of size is " + max);

    }

    private static long maximumSumDistinctSubarray( int[] nums, int k ) {
        long maxSum = Long.MIN_VALUE;
        Map<Integer,Integer> countMap = new HashMap<>();

        int i = 0, j = 0;
        long sum = 0;
        while(j < nums.length) {
            sum+=nums[j];
            countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);
            if(j - i + 1 < k) {
                j++;
            } else if(j - i + 1 == k) {
                if(countMap.size() == k){
                    maxSum = Math.max(maxSum, sum);
                }
                sum-=nums[i];
                countMap.put(nums[i], countMap.get(nums[i]) - 1);
                if(countMap.get(nums[i]) == 0) {
                    countMap.remove(nums[i]);
                }
                i++;
                j++;
            }
        }
        System.out.println(maxSum);
        return maxSum != Integer.MIN_VALUE ? maxSum : 0;
    }
}
