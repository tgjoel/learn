package coding.dp.mcm;

public class PalindromePartitioningRecursive01 {

    static void main() {
        System.out.println("Minimum number of portioning to make it as palindrome: " +palindromePartition("joel"));
        System.out.println("Minimum number of portioning to make it as palindrome: " +  palindromePartition("nitin"));
        System.out.println("Minimum number of portioning to make it as palindrome: " + palindromePartition("abacbc"));
    }

    private static int palindromePartition(String s) {
        return solve(s, 0, s.length()-1);
    }

    private static int solve(String s, int i, int j) {
        if( i > j) {  // if i == j, then only one char, no split. if i > j: then no char, no split
            return 0;
        }
        if(isPalindrome(s, i , j)) {   // if the string is already a palindrome, then no need to split
            return 0;
        }

        System.out.println(s.substring(i,j));

        int minSplit = Integer.MAX_VALUE;
        for (int k = i; k <j; k++) {
            int tmp = solve(s, i, k) + solve(s, k+1, j) + 1;  // Adding the 1 as we already split the s from i to k and k+1 to j
            minSplit = Math.min(minSplit, tmp);
        }
        return minSplit;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
