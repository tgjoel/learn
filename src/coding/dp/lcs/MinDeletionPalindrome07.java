package coding.dp.lcs;

public class MinDeletionPalindrome07 {

    public static void main(String[] args) {
        System.out.println(minDeletionPalidrome("aebcbda"));
    }

    private static int minDeletionPalidrome(String s) {
       int m = s.length();
       String s1 = new StringBuilder(s).reverse().toString();

       int[][] dp = new int[m+1][m+1];

       for(int i = 1; i < m +1; i++) {
           for(int j = 1; j < m+1; j++) {
               if(s.charAt(i-1) == s1.charAt(j-1)) {
                   dp[i][j] = 1 + dp[i-1][j-1];
               } else {
                   dp[i][j] = Math.max(
                           dp[i-1][j],
                           dp[i][j-1]
                   );
               }
           }
       }
       return m - dp[m][m];
    }
}
