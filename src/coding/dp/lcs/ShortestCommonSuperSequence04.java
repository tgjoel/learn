package coding.dp.lcs;

public class ShortestCommonSuperSequence04 {
    public static void main(String[] args) {

        System.out.println(shortestCommonSuperSequence("aggtab", "gxtxayb"));
        System.out.println(shortestCommonSuperSequence("abac", "cab"));
    }

    private static int shortestCommonSuperSequence(String x, String y) {
        // get the lcs of both.
        //it should be added only once. as its the common.
        // x + y - lcs should give the shortest

        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m+1][n+1];
        //initialisation not needed as java by default assign );

        for(int i = 1; i < m+1; i++ ) {
            for (int j =1; j< n+1; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }
        int lcsLength = dp[m][n];
        return m + n - lcsLength;
    }
}
