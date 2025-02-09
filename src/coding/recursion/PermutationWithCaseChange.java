package coding.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithCaseChange {
    public static void main( String[] args ) {
        String input = "aBC";
        List<String> ans = solvePermutationWithCaseChange(input);
        ans.forEach(System.out::println);
    }

    private static List<String> solvePermutationWithCaseChange( String input ) {
        List<String> ans = new ArrayList<String>();
        String output = "";
        solvePermutationWithCaseChange(input, output, ans);
        return ans;
    }

    private static void solvePermutationWithCaseChange(String input, String output, List<String> ans) {
        if(input.length() == 0) {
            ans.add(output);
            return;
        }
        // choice is to either to make it small letter or capital letter
        String output1 = output +  Character.toLowerCase(input.charAt(0));
        String output2 = output +  Character.toUpperCase(input.charAt(0));

        input = input.substring(1);

        solvePermutationWithCaseChange(input, output1, ans);
        solvePermutationWithCaseChange(input, output2, ans);
    }
}
