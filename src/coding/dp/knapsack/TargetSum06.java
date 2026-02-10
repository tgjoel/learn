package coding.dp.knapsack;


// Need to assign signs (+ve or -ve) to the provided numbers so after that their sum equals the provided target sum. Need to such count
// https://leetcode.com/problems/target-sum
/*
   nums = 1, 1, 2, 3 , target sum = 1
   possible ans
    a. +1, -1 , -2 , 3
    b. -1, +1, -2, 3
    c. +1, +1, +2, -3

 */
public class TargetSum06 {

    public static void main(String[] args) {
        System.out.println(countTargetSum(new int[]{1, 1, 2, 3}, 1));
        System.out.println(countTargetSum(new int[]{0}, 0));
        System.out.println(countTargetSum(new int[]{1, 1, 1, 1, 1}, 3));
    }

    private static int countTargetSum(int[] nums, int targetSum) {

        int sum = 0;
        int zeroCount = 0;  /// As 0 can be both +ve and -ve. counting them ahead
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            sum += nums[i];
        }

        // edge case test
        /*
            1. target sum cannot be greater than sum
            2. if s1 = (s + targetsum)/2. but s1 cannot be a fractional. meaning (s + targetsum) must be even
         */

        if (Math.abs(targetSum) > sum || (sum + targetSum) % 2 != 0)
            return 0;


        // basically its same as s1 - s2 = targetsum.

        // s1 = (s + diff) / 2

        int s1 = (sum + targetSum) / 2;

        int[][] dp = new int[nums.length + 1][s1 + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < s1 + 1; j++) {
                // need to check only for the non zero numbers
                if (nums[i - 1] != 0 && nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int result = dp[nums.length][s1];
        return result * (int) Math.pow(2, zeroCount);
    }

}
