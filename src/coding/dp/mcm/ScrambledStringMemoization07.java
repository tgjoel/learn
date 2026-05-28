package coding.dp.mcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMemoization07 {
    static void main() {
        System.out.println(isScrambleMemoized("great", "rgeat"));
    }

    static Map<String, Boolean> memo = new HashMap<>();
    private static boolean isScrambleMemoized(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.equals(s2)) {
            return true;
        }

        String key = s1 +"_" + s2;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();
        //checking if the s1 and s2 has the same characters
        int[] charCount = new int[26];
        for (int i = 0; i < n; i++) {
            charCount[s1.charAt(i) - 'a']++;
            charCount[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26 ; i++) {
            if(charCount[i] != 0) {
                return false;
            }
        }
        for (int i = 1; i < n; i++) {
            boolean noSwap = isScrambleMemoized(s1.substring(0, i), s2.substring(0, i)) &&
                    isScrambleMemoized(s1.substring(i), s2.substring(i));
            if(noSwap) {
                memo.put(key, true);
                return true;
            }
            boolean swap = isScrambleMemoized(s1.substring(0,i), s2.substring(n-i)) &&
                    isScrambleMemoized(s1.substring(i), s2.substring(0, n-i));
            if(swap) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}
