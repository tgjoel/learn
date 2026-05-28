package coding.string;

//5. Longest Palindromic Substring
public class LongestPalindromicSubstring {
    public static void main( String[] args ) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome1(s));
    }

    ///  Solution in O (N2)
    public static String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length() ; i++) {

            int length1 = expandCenter(s, i, i); // this is for the odd palindromes
            int length2 = expandCenter(s, i, i + 1); // this is for the odd palindromes

            int maxLength = Math.max(length1, length2);

            if (maxLength > (end - start)) {
                ///  the current substring is greater than existing one

                ///  for odd length
                if (maxLength % 2 != 0) {
                    start = i - (maxLength / 2);
                    end = i + (maxLength / 2);
                } else {
                    ///  for even we have like towards left we have one less as per the calculation for example abba, middle would be at 1.
                    start = i - (maxLength / 2 - 1);
                    end = i + maxLength / 2;
                }

            }
        }
        return s.substring(start, end + 1); /// substring excludes the character at the endIndex so inorder to include that
    }

    private static int expandCenter(String s, int left, int right) {

        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; /// Need to reduce 1, as the while loop exited after calculating left and right when the word was no longer palindrome.
        ///we need the previous condition where the loop was true

    }






    /// this solution will take ON3
    public static String longestPalindrome1(String s) {
        if(s.length() == 1) return s;
        String ans = "";

        for (int i = 0; i < s.length() -1 ; i++) {
            int j = s.length();
            while (j > i) {
                String sub = s.substring(i, j);
                if(isPalindromeString(sub)) {
                    if(sub.length() > ans.length()) {
                        ans = sub;
                    }
                }
                j--;
            }

        }
        return ans;
    }

    private static boolean isPalindromeString( String string ) {
     for(int i = 0, j = string.length() - 1; i < j; i++, j--) {
         if(string.charAt(i) != string.charAt(j)) return false;
     }
     return true;
    }
}
