package coding.recursion;


import java.util.ArrayList;
import java.util.List;

public class PermutationWithSpaces {
    public static void main( String[] args ) {
        String input = "abc";
        List<String> ans = solvePermutationWithSpaces(input);
        ans.forEach(System.out::println);
    }

    private static List<String> solvePermutationWithSpaces( String input ) {
        List<String> ansList = new ArrayList<>();
        String output = String.valueOf(input.charAt(0)); // adding the first into output as space is not needed in the beginning
        input = input.substring(1); // reducing the input as we already considered.
        solvePermutationWithSpaces(input, output, ansList);
        return ansList;
    }

    private static void solvePermutationWithSpaces( String input, String output, List<String> ansList ) {
        if (input.length() == 0) {
            ansList.add(output);
            return;
        }
        String output1 = output + input.charAt(0);
        String output2 = output + " " + input.charAt(0);
        input = input.substring(1); // reducing the input

        solvePermutationWithSpaces(input, output1, ansList);
        solvePermutationWithSpaces(input, output2, ansList);
    }
}
