package coding.dp.mcm;

public class PalindromePartitioningMemoization02 {

    static void main() {
        System.out.println("Minimum number of portioning to make it as palindrome: " +palindromePartition("joel"));
        System.out.println("Minimum number of portioning to make it as palindrome: " +  palindromePartition("nitin"));
        System.out.println("Minimum number of portioning to make it as palindrome: " + palindromePartition("abacbc"));
    }

    private static int palindromePartition(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return solve(s, 0, s.length()-1, memo);
    }

    private static int solve(String s, int i, int j, int[][] memo) {
        if( i > j) {
            return 0;
        }
        if(isPalindrome(s, i , j)) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        int minSplit = Integer.MAX_VALUE;
        for (int k = i; k <j; k++) {
            int tmp = 1 + solve(s, i, k, memo) + solve(s, k+1, j, memo) ;
            minSplit = Math.min(minSplit, tmp);
        }
        memo[i][j] = minSplit;
        return minSplit;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
