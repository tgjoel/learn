package coding.string;

//5. Longest Palindromic Substring
public class LongestPalindromicSubstring {
    public static void main( String[] args ) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
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
