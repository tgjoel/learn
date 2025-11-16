package coding.knapsack;

public class CountSubsetsSumWithGivenSum03 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 6, 8, 10, 4};
        int sum = 10;
        System.out.println("count: " + countSubsetsSum(nums, sum));
    }

    public static int countSubsetsSum(int[] nums, int sum) {
        int[][] dp = new int[nums.length + 1][sum + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1; // initialization when sum = 0, then empty subset is possible
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
