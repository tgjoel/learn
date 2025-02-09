package coding.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
public class MinimumWindowSubstring {

    public static void main( String[] args ) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int minSubstringLength = Integer.MAX_VALUE;
        Map<Character, Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0;
        int startWindow = 0;
        int ansCount = tmap.size();
        while (j < s.length()) {
            char currentChar = s.charAt(j);
            // if the tmap contains the character decrementing the count. once the count is 0, then that window is possible solution. Then optimize the solution when window size = 0;
            if(tmap.containsKey(currentChar)) {
                int curentCount = tmap.get(currentChar);
                curentCount--;
                if(curentCount == 0) {
                    ansCount--;
                }
                tmap.put(currentChar, curentCount);
            }
            if(ansCount > 0 ) {
                j++;
            } else if(ansCount == 0) {
                if(j -i +1 < minSubstringLength) {
                    minSubstringLength = j - i +1;
                    startWindow = i;
                }
                while(ansCount == 0) {
                    // This means this window is the possible answers, but will need to optimize to get the solution.
                    // Because, we have access character in the window then, count will be -ve that needs to be reduced.
                    // or there could have a smaller window which satisfy the condition. so we will keep the j and start reducing the the window size, ie increment i;
                    char windowStartChar = s.charAt(i);
                    if(tmap.containsKey(windowStartChar)) {
                        tmap.put(windowStartChar,tmap.get(windowStartChar) + 1);
                        if(tmap.get(windowStartChar) == 1) {  //  when incrementing the i, need to exclude form the window. so do the opposite of when included in the window
                            ansCount++;
                        }
                    }
                    i++;
                    if(ansCount == 0) {
                        if(j -i +1 < minSubstringLength) {
                            minSubstringLength = j -i +1;
                            startWindow = i;
                        }
                    }
                }
                j++;
            }
        }
        if(minSubstringLength ==  Integer.MAX_VALUE) {  // incase the string is empty the loop is not executed
            return "";
        } else {
            return s.substring(startWindow, startWindow+minSubstringLength);
        }
    }
}
