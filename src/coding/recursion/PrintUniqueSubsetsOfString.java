package coding.recursion;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueSubsetsOfString {
    public static void main( String[] args ) {
        String input = "aab";
        uniqueSubsets(input);
    }

    private static void uniqueSubsets( String input ) {
        String output = "";
        Set<String> uniqueSubsets = new HashSet<>();
        uniqueSubsets(input, output, uniqueSubsets);
        uniqueSubsets.forEach( System.out::println);
    }
    private static void uniqueSubsets( String input, String output, Set<String> uniqueSubsets ) {
        if(input.length() == 0) {
            uniqueSubsets.add(output);
            return;
        }
        String output1 = output; // will not consider
        String output2 = output +  input.charAt(0); // will consider

        input = input.substring(1); // reduce the input
        uniqueSubsets(input, output1, uniqueSubsets);
        uniqueSubsets(input, output2, uniqueSubsets);
    }
}
