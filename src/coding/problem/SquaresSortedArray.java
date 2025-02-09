package coding.problem;

import java.util.Arrays;

// 977. Squares of a Sorted Array
public class SquaresSortedArray {
    public static void main( String[] args ) {
        int[] nums = {-7,-3,2,3,11};

        int[] ans = new int[nums.length];
        int n = nums.length;
        for (int i = 0, j = n-1, k = n-1 ; i <= j; k--) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])) {
                ans[k] = nums[i] * nums[i];
                i++;
            } else {
                ans[k] = nums[j] * nums[j];
                j--;
            }
        }
    Arrays.stream(ans).forEach(System.out::println);
    }
}
