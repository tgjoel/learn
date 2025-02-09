package coding.slidingwindow.variablewindow;

// this problem only solves for the positive numbers
public class LargestSubarrayOfSumKForPositiveIntegers {

    public static void main( String[] args ) {
        //int[] arr = {10, 5, 2, 7, 1, 9,1,2,2,1}; int k = 15;
        int[] arr = {1,1,5};  int k = 5;

        System.out.println("Length = " +
                lenOfLongSubArray(arr, k));
    }

    private static int lenOfLongSubArray( int[] arr,  int k ) {
    int max = Integer.MIN_VALUE;

    int i = 0; int j = 0;
    int sum = 0;
    while(j < arr.length) {
        sum +=arr[j];
        if(sum < k) { //until we reach the condition increment the sum and calculate the sum
            j++;
        } else if(sum == k) {
            int currentWindowSize = j -i + 1;  //this will be the window size
            max = Math.max(max, currentWindowSize);
            j++;
        } else if (sum > k) { // when sum is greater than k, sliding the window until the sum is greater than k
            while(sum > k) {
                sum -= arr[i];
                i++;
            }
            // After incrementing the i, need to check if the sum is equal to k.
            if(sum == k) {
                int currentWindowSize = j - i + 1;
                max = Math.max(max, currentWindowSize);
            }
            j++;
        }
    }
    return max;
    }
}
