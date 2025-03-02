package coding.slidingwindow.problems;

/*
LC: 1248
Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
Return the number of nice sub-arrays.
 */

public class CountNumberofNiceSubarrays {
    public static void main( String[] args ) {

        //int[] nums = new int[]{1,1,2,1,1,2,3,4,6,6}; // int k = 3;
        int[] nums = new int[]{2,2,2,1,2,2,1,2,2,2}; int k = 2;

        System.out.println("With K: " + countNumberOfSubarray(nums, k));
        System.out.println("With K-1: " + countNumberOfSubarray(nums, k-1));
        System.out.println(countNumberOfSubarray(nums, k) - countNumberOfSubarray(nums, k-1));
    }

    private static int countNumberOfSubarray( int[] nums, int k ) {
        int i =0, j = 0;
        int count = 0;
        int ans = 0;

        while(j < nums.length) {
            count += nums[j]%2;// for odd number the modulus is 1;

             if (count > k) {
                while(count > k) {
                    count -= nums[i]%2;
                    i++;
                }
            }
            ans+= j-i+1;
             j++;
        }
       return (ans);
    }
}

//The number of subarrays with exactly  `k`  odd numbers equals the count of
//subarrays with at most `k` odd numbers minus the count of subarrays with at most `k - 1` odd numbers.