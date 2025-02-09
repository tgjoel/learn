package coding.slidingwindow.fixedwindow;

public class MaxSumSubarray {
    public static void main( String[] args ) {

        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;

        long max = maximumSumSubarray(nums,k);

    }

    private static long maximumSumSubarray( int[] nums, int k ) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0, i = 0, j =0;

        while(j < nums.length) {
            sum += nums[j];
            if( (j - i + 1)< k) {
                j++;
            } else if ( (j-i+1) ==k) {
                maxSum   = Math.max(maxSum, sum);
                sum -= nums[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
