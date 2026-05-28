package coding.dp.mcm;

public class ScrambledStringRecursive06 {
    static void main() {
        System.out.println(isScramble("great", "rgeat"));
    }

    private static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // first condition for without swapping
            boolean noSwap = isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i));

            //second condition with swapping
            boolean swap = isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i));

            if (noSwap || swap) {
                return true;
            }
        }
        return false;
    }

    // Improved version with pruning for same characters
    private static boolean isScramble1(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        // check if s1 and s2 has same characters. if they are not having same character then it cannot be scrambled
        int[] charCount = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false;
            }
        }

        int n = s1.length();
        for (int i = 1; i < n; i++) {   // As we are checking OR condition we can return if one is returned TRUE
            // first condition for without swapping
            boolean noSwap = isScramble1(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble1(s1.substring(i), s2.substring(i));

            if(noSwap) {
                return true;
            }
            //second condition with swapping
            boolean swap = isScramble1(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble1(s1.substring(i), s2.substring(0, n - i));

            if (swap) {
                return true;
            }
        }
        return false;
    }
}
