package coding.knapsack;

// https://leetcode.com/problems/coin-change-ii
public class CoinChangeNoOfWays {

    public static void main(String[] args) {
        System.out.println(change(new int[]{1, 2, 5}, 5));
        System.out.println(change(new int[]{2}, 3));
        System.out.println(change(new int[]{10}, 10));

    }

    private static int change(int[] coins, int amount) {



        int[][] dp = new int[coins.length + 1][amount + 1];

        //initialization
        for(int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;   // For sum = 0, can select no coin. so that is possible
        }

        for(int i = 1; i <coins.length +1; i++) {
            for (int j = 1; j <amount +1; j++) {

                if(coins[i-1] <= j) {
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
