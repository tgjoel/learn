package coding.dp.knapsack;

/**
 * Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i.
 * Your task is to determine the maximum value obtainable by cutting up the rod and selling the pieces.
 */

public class RodCutting07 {

    public static void main(String[] args) {
        int[] price = {3, 5, 8, 9, 10, 17, 17, 20}; //ans:24
        int[] price1 = {1, 5, 8, 9, 10, 17, 17, 20}; //ans:22
        int[] price2 = {3}; //ans:3

        System.out.println(maxCutProfit(price));
        System.out.println(maxCutProfit(price1));
        System.out.println(maxCutProfit(price2));
    }

    private static int maxCutProfit(int[] price) {

        int n = price.length;

        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        // can cut rod of same size multiple times
        int[][] dp = new int[n + 1][n + 1];

        // initialize the matrix when i = 0 and j = 0 with 0;
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(
                            price[i - 1] + dp[i][j - length[i - 1]],  // here we are considering the length. but same length can be repeated
                            dp[i - 1][j]  /// rejecting the length. so it can never be considered again. hence reducing the i
                    );
                } else {
                    dp[i][j] = dp[i - 1][j]; /// rejecting the length. so it can never be considered again. hence reducing the i
                }

            }
        }
        return dp[n][n];
    }
}
