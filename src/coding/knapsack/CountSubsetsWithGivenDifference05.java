package coding.knapsack;

public class CountSubsetsWithGivenDifference05 {

    public static void main(String[] args) {
        System.out.println(countSubsetsWithDiff(new int[]{1, 1, 2, 3}, 1));
    }

    private static int countSubsetsWithDiff(int[] nums, int diff) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
    /*
      s1 - s2 = diff
      s1 + s2 = sum
      s1 = (sum + diff)/ 2
     */
        int target = (sum + diff) / 2;

        int[][] dp = new int[nums.length + 1][target + 1];

        //initialization
        for (int i : dp[0]) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j < target + 1; j++) {

                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
