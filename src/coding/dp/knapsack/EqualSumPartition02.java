package coding.dp.knapsack;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/description/
public class EqualSumPartition02 {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }

    private static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            //sum is odd that means we cannot split them into two equal subset sum
            return false;
        }
        // now we need to only find out one subset with target = sum/2;
        //same as the subsets sum problem
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {

                if (nums[i - 1] <= j) {

                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }

}
