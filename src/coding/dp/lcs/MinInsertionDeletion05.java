package coding.dp.lcs;

// https://leetcode.com/problems/delete-operation-for-two-strings/description/

//Minimum Number of Insertion and Deletion to convert String a to String b
//Ex: Heap --> Pea
// 1 insertion 2 deletion
public class MinInsertionDeletion05 {
    public static void main(String[] args) {
        String s1 = "heapp";
        String s2 = "peah";
        minimumInsertionDeletion(s1, s2);
    }

    private static void minimumInsertionDeletion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i][j - 1]);
                }
            }
        }
        int lcsLength = dp[m][n];
        System.out.println("No. of deletion: " + (m - lcsLength));
        System.out.println("No. of insertion: " + (n - lcsLength));
    }
}
