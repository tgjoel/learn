package coding.dp.mcm;

public class PalindromePartitioningMemoizationOptimised03 {

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
        if (i > j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int minSplit = Integer.MAX_VALUE;
        int left;
        int right;
        int tmp;
//        for (int k = i; k <j; k++) {
//            if(memo[i][k] != -1) {
//                left = memo[i][k];
//            } else {
//                left = solve(s, i, k, memo);
//                memo[i][k] = left;
//            }
//
//            if(memo[k+1][j] != -1) {
//                right = memo[k+1][j];
//            } else {
//                right = solve(s, k+1, j, memo);
//                memo[k+1][j] = right;
//            }
//
//            tmp = 1 + left + right ;
//            minSplit = Math.min(minSplit, tmp);
//        }
//        memo[i][j] = minSplit;
//        return minSplit;

        for (int k = i; k < j; k++) {
            if (memo[i][k] != -1) {  // meaning the subproblem is already solved so use that directly from the table
                left = memo[i][k];
            } else if (isPalindrome(s, i, k)) { // checking if the subproblem string is already palindrom, then its partition is 0
                left = 0;
                memo[i][k] = left;
            } else {  // else need to solve for the left subproblem and store in the table
                left = solve(s, i, k, memo);
                memo[i][k] = left;
            }

            if (memo[k + 1][j] != -1) {
                right = memo[k + 1][j];
            } else if (isPalindrome(s, k + 1, j)) {
                right = 0;
                memo[k + 1][j] = right;
            } else {
                right = solve(s, k + 1, j, memo);
                memo[k + 1][j] = right;
            }

            tmp = 1 + left + right;
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
