package coding.knapsack;

public class CoinChangeMinimumCoins {
    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));

    }

    private static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        //initialization
        /// first column would be max -1
        for (int i = 1; i < amount + 1; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }

        /// first row would be 0
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(
                            1 + dp[i][j - coins[i - 1]],
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        if (dp[coins.length][amount] == Integer.MAX_VALUE - 1) {
            return -1;
        } else {
            return dp[coins.length][amount];
        }
    }
}
