package coding.dp.lcs;

public class LongestRepeatingSubsequence09 {
    public static void main(String[] args) {
        System.out.println(lsr("abadbcc"));
    }

    private static String lsr(String s) {
        int m = s.length();
        int[][] dp = new int[m + 1][m + 1];

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(s.charAt(i-1) == s.charAt(j-1) && i != j)  {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int i = m;
        int j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if((s.charAt(i-1) == s.charAt(j-1) )&& i !=j) {
                sb.append(s.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return sb.reverse().toString();
    }
}
