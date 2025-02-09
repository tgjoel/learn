package coding.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main( String[] args ) {
        String s = "aabacbebebe";

        System.out.println("Maximum size: " + maxlengthWithoutRepeating(s));
    }

    private static int maxlengthWithoutRepeating( String s ) {

        if(s.isEmpty()) {
            return 0;
        }
        int i = 0, j = 0, maxlength = Integer.MIN_VALUE;

        Map<Character, Integer> charMap = new HashMap<>();
        while (j < s.length()) {
            charMap.put(s.charAt(j), charMap.getOrDefault(s.charAt(j), 0) + 1);
           /*
            Non-repeating character means, all unique character. That is all the character in the window should be unique. Window size is dynamic and will be equal to the size of the map.
            When the map size is less than window size then the window contains non-unique character. hence window size is reduced
            */
            if ((j - i + 1) < charMap.size()) {
                j++; // this condition will never happen
            } else
            if ((j - i + 1) == charMap.size()) {
                maxlength = Math.max(maxlength, (j - i + 1));
                j++;
            } else if ((j - i + 1) > charMap.size()) {
                while ((j - i + 1) > charMap.size()) {
                    char windowStartChar = s.charAt(i);
                    int currentCharacterSize = charMap.get(windowStartChar) - 1;
                    if (currentCharacterSize == 0) {
                        charMap.remove(windowStartChar);
                    } else {
                        charMap.put(windowStartChar, currentCharacterSize);
                    }
                    i++;
                }
                if (charMap.size() == (j - i + 1)) {
                    int currWindowSize = j - i + 1;
                    maxlength = Math.max(maxlength, currWindowSize);
                }
                j++;
            }
        }
        return maxlength;
    }
}
