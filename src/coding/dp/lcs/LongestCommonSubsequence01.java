package coding.dp.lcs;

public class LongestCommonSubsequence01 {
    public static void main(String[] args) {

        String x = "abcde";
        String y = "abedfg";

        //For subsequence need not be continuous, but order needs to be maintained;
        System.out.println(longestCommonSubsequence(x,y));

    }

    private static int longestCommonSubsequence(String x, String y) {

        int m = x.length();
        int n = y.length();
        int[][] dp = new int[m +1 ][n + 1];

        //initialization

        for(int i = 0; i < m +1; i++) {
            for(int j = 0; j < n+1; j++) {
             if(i == 0 || j == 0) {
                 dp[i][j] = 0;
             }
            }
        }

        // rest of the code for the calculation
        for (int i = 1; i < m+1; i ++) {
            for(int j = 1; j < n+1; j++) {

                if(x.charAt(i-1) == y.charAt(j-1)) {
                    // both are equal
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i][j-1],
                            dp[i-1][j]
                    );
                }

            }
        }
        return dp[m][n];
    }

}
