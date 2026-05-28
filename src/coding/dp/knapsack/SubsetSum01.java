package coding.dp.knapsack;

public class SubsetSum01 {

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;

        System.out.println(isSubsetSum(arr, target));

    }

    private static boolean isSubsetSum(int[] arr, int target) {

        boolean[][] dp = new boolean[arr.length + 1][target + 1]; // by default its false
        //initialization

        for (int i = 0; i < arr.length + 1; i++) {
            //setting the value as True as we can have an array with target == 0
            dp[i][0] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i - 1] <= j) {
                    // we have two choice to include or not to include
                    dp[i][j] =
                            //include
                            dp[i - 1][j - arr[i - 1]]
                                     //not include
                                    || dp[i - 1][j];
                } else {
                    // we cannot include
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length][target];

    }
}
