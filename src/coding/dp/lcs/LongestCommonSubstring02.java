package coding.dp.lcs;

public class LongestCommonSubstring02 {

    //For substring needs to be continuous
    public static void main(String[] args) {
        String x = "abcde";
        String y = "abedfg";

        //For subsequence need not be continuous, but order needs to be maintained;
        System.out.println(longestCommonSubstring(x,y));

    }

    private static int longestCommonSubstring(String x, String y) {

        int m = x.length();
        int n = y.length();
        int maxLength = 0;

        int[][] dp = new int[m+1][n+1];

        //initialization
        for(int i = 0; i < m +1; i ++) {
            for (int j = 0; j < n+1; j++) {
                if(i==0 || j ==0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {

                if(x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(dp[i][j], maxLength); // need to keep track of the longest substring till then
                } else {
                    dp[i][j] = 0; /// needs to be continuous. so reset the length to 0
                }
            }
        }

        return maxLength;
    }
}
