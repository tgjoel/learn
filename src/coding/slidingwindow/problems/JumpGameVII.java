package coding.slidingwindow.problems;

// 1871. Jump Game VII

/*
You are given a 0-indexed binary string s and two integers minJump and maxJump. In the beginning, you are standing at index 0, which is equal to '0'. You can move from index i to index j if the following conditions are fulfilled:
i + minJump <= j <= min(i + maxJump, s.length - 1), and
s[j] == '0'.
Return true if you can reach index s.length - 1 in s, or false otherwise.
 */


// More of a DP problem

public class JumpGameVII {

    public static void main( String[] args ) {
       // String  s = "011010"; int minJump = 2, maxJump = 3;
        String  s = "01101110"; int minJump = 2, maxJump = 3;
        System.out.println("Can Reach: " + canReach(s, minJump, maxJump));
    }

    public static boolean canReach( String s, int minJump, int maxJump ) {
        int n = s.length();
        int count = 0;

        if (s.charAt(n - 1) == '1')  // can only jump if position is 0;
            return false;


        boolean[] dp = new boolean[n];
        dp[0] = true;  // start of the string is always 0;


        for (int i = minJump; i < n; ++i) {
            if (i >= minJump && dp[i - minJump]) {
                ++count;
            }
            if (i > maxJump && dp[i - maxJump - 1]) {
                --count;
            }
            if (s.charAt(i) == '0' && count > 0)
                dp[i] = true;
        }
        return dp[n - 1];
    }

    public boolean canReach1(String s, int minJump, int maxJump) {
        return util3(s,minJump,maxJump);
    }
    // optimised dp

    public boolean util3(String str, int minJump, int maxJump) {
        if (str.charAt(str.length() - 1) == '1') {
            return false;
        }
        int n = str.length();
        int start = 0;
        int end = 0;
        boolean dp[] = new boolean[str.length()];
        dp[0] = true;
        for (int i = 0; i < str.length(); i++) {
            if (dp[i] == false) {
                continue;
            }
            start = Math.max(i + minJump, end + 1);
            end = Math.min(n - 1, i + maxJump);
            for (int j = start; j <= end; j++) {
                if (str.charAt(j) == '0') {
                    dp[j] = true;
                }
            }
            if (dp[n - 1]) {
                return true;
            }
        }
        return dp[n - 1];
    }
}
