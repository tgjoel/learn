package coding.slidingwindow.problems;

/*
1004. Max Consecutive Ones III
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class MaxConsecutiveOnes {
    public static void main( String[] args ) {
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
        // int[] nums = { 0,0,1,1,0,0,1,1,1,0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        // int k = 3;
        int[] nums = {0, 0, 0, 0, 0};
        int k = 3;
        System.out.println("Longest: " + longestOnes(nums, k));

    }

    public static int longestOnes( int[] nums, int k ) {
        int ans = 0;
        int i = 0, j = 0;
        int[] count = new int[2];
        while (j < nums.length) {
            count[nums[j]]++;
            if (count[0] <= k) {
                ans = Math.max(ans, j - i + 1);
                j++;
            } else if (count[0] > k) {
                while (count[0] > k) {
                    if (nums[i] == 0) {
                        count[0]--;
                    }
                    i++;
                }
                if (count[0] <= k) {
                    ans = Math.max(ans, j - i + 1);
                }
                j++;
            }
        }
        return ans;
    }
}
