package coding.dp.lcs;

public class PrintSCS08 {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
        System.out.println(shortestCommonSupersequence("aaaaaaaa", "aaaaaaaa"));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }

        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    sb.append(str1.charAt(i - 1));
                    i--;
                } else {
                    sb.append(str2.charAt(j - 1));
                    j--;
                }
            }
        }

        //adding the remaining
        while( i > 0) {
            sb.append(str1.charAt(i-1));
            i--;
        }
        while( j > 0) {
            sb.append(str2.charAt(j-1));
            j--;
        }

        return sb.reverse().toString();
    }
}
