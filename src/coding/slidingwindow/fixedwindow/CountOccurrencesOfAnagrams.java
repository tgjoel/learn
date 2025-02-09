package coding.slidingwindow.fixedwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOccurrencesOfAnagrams {
    public static void main( String[] args ) {

        String mainString = "cbaebabacd";
        String patternString = "abc";
        Map<Character, Integer> patternCharacterMap = new HashMap<>();
        for ( int i = 0; i < patternString.length(); i++ ) {
            char currentChar = patternString.charAt(i);
            patternCharacterMap.put(currentChar,patternCharacterMap.getOrDefault(currentChar,0)+1);
        }

        int i=0,j=0;
        int k = patternString.length();
        int uniqueCount = patternCharacterMap.size();
        int anagramCount = 0;
        List<Integer> anagramIndexes = new ArrayList<>();
        while(j< mainString.length()) {
            char currentChar = mainString.charAt(j);
            if(patternCharacterMap.containsKey(currentChar)) {
                patternCharacterMap.put(currentChar, patternCharacterMap.get(currentChar)-1);
                if(patternCharacterMap.get(currentChar) == 0) {
                    uniqueCount--;
                }
            }
           if(j-i+1 <k) {
               j++;
           } else if (j-i+1 ==k) {
               if(uniqueCount == 0) {
                   anagramCount++;
                   anagramIndexes.add(i);
               }
               char removingChar = mainString.charAt(i);
               if(patternCharacterMap.containsKey(removingChar)) {
                   patternCharacterMap.put(removingChar, patternCharacterMap.get(removingChar) + 1);
                   if (patternCharacterMap.get(removingChar) == 1) {
                       uniqueCount++;
                   }
               }
               i++;
               j++;
           }
        }

        System.out.println("Anagrams: " + anagramCount);
        System.out.println("Anagrams: " + anagramIndexes);

    }
}
