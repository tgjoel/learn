package coding.dp.lcs;

//https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
public class MinInsertionDeletionPalindrome11 {
    public static void main(String[] args) {
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
    }

    private static int minInsertions(String s) {
        String s1 = new StringBuilder(s).reverse().toString();

        int m = s.length();

        int[][] dp = new int[m+1][m+1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < m +1; j++) {
                if(s.charAt(i-1)== s1.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return m - dp[m][m];
    }

}
