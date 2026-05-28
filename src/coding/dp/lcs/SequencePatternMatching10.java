package coding.dp.lcs;

// Given two string. Fetch if one string is sequence matching on the other
public class SequencePatternMatching10 {
    public static void main(String[] args) {
        System.out.println(sequencePatternMatch("axy", "adxcpy"));
        System.out.println(sequencePatternMatch("axyd", "adxcpy"));
    }

    private static boolean sequencePatternMatch(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();

        int min = Math.min(m,n); // only the smaller string can be present in the other string. if smaller string was given could have taken its length directly

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m +1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int lcsLength = dp[m][n];
        return lcsLength == min;
    }

}
