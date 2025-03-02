package coding.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {
    public static void main( String[] args ) {

        String s = "aabacbebebe";
        int k = 3;

        System.out.println("Maximum size: " + maxlength(s, k));


    }

    private static int maxlength( String s, int k ) {
        //solution
        int maxLength = Integer.MIN_VALUE;
        int i =0, j = 0;
        Map<Character, Integer> characterMap = new HashMap<>();

        while(j < s.length()) {
            char currentChar = s.charAt(j);
            //adding to the map to get the unique characters
            characterMap.put(currentChar,characterMap.getOrDefault(currentChar,0) + 1);
            if(characterMap.size() < k) {
                j++; // slide the window until the condition is satisfied
            } else if (characterMap.size() == k) {
                int currentWindowSize = j -i + 1;
                maxLength = Math.max(maxLength, currentWindowSize);
                j++;
            } else if (characterMap.size() > k) {
                while(characterMap.size() > k) {
                    char windowStartChar = s.charAt(i);
                    int currentCharacterSize = characterMap.get(windowStartChar) - 1;
                    if(currentCharacterSize == 0){
                        characterMap.remove(windowStartChar);
                    } else {
                        characterMap.put(windowStartChar, currentCharacterSize);
                    }
                    i++;
                }
                //after sliding the start of the window will check if the condition satisfy or not
                if(characterMap.size() == k) {
                    int currentWindowSize = j -i + 1;
                    maxLength = Math.max(maxLength, currentWindowSize);
                }
                j++; // slide the end of the windo
            }

        }
        return maxLength;
    }
}
