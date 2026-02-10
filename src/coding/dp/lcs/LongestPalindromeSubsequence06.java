package coding.dp.lcs;

//https://leetcode.com/problems/longest-palindromic-subsequence/description/
public class LongestPalindromeSubsequence06 {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    private static int longestPalindromeSubseq(String s) {

        int m = s.length();
        int n = s.length();
        String s1 = new StringBuilder(s).reverse().toString();


        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == s1.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }

            }

        }
        return dp[m][n];
    }
}
