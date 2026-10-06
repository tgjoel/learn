package coding.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation13 {
    public static void main( String[] args ) {
        String s = "3a1b2";
        letterCasePermutation(s).forEach(System.out::println); // with character array and index.
        letterCasePermutation1(s).forEach(System.out::println); // with string manipulation
    }

    public static List<String> letterCasePermutation( String s) {
        List<String> result = new ArrayList<>();
        String output = "";
        char[] input = s.toCharArray();
        letterCasePermutation(input, 0,  output, result);
        return result;
    }

    private static void letterCasePermutation( char[] s,int index, String output, List<String> result ) {
        if(s.length == index) {
            result.add(output);
            return;
        }
        if(Character.isDigit(s[index])) {
            String output1 = output + s[index];
            letterCasePermutation(s, index + 1, output1, result);
        } else {
            String output1 = output + Character.toLowerCase(s[index]);
            String output2 = output + Character.toUpperCase(s[index]);
            letterCasePermutation(s, index + 1, output1, result);
            letterCasePermutation(s, index + 1, output2, result);
        }
    }

    /*
    static void solve(String input, String output, List<String> result) {
    if (input.isEmpty()) {
        result.add(output);
        return;
    }

    char ch = input.charAt(0);
    String remaining = input.substring(1);

    if (Character.isDigit(ch)) {
        solve(remaining, output + ch, result);
    } else {
        solve(remaining, output + Character.toLowerCase(ch), result);
        solve(remaining, output + Character.toUpperCase(ch), result);
    }
}
     */

    public static List<String> letterCasePermutation1(String s) {
        List<String> result = new ArrayList<>();
        String output = "";
        letterCasePermutation1(s, output, result);
        return result;
    }

    private static void letterCasePermutation1( String s, String output, List<String> result ) {
        if(s.isEmpty()) {
            result.add(output);
            return;
        }
        if(Character.isDigit(s.charAt(0))) {
            String output1 = output + s.charAt(0);
            s = s.substring(1);
            letterCasePermutation1(s, output1, result);
        } else {
            String output1 = output + Character.toLowerCase(s.charAt(0));
            String output2 = output + Character.toUpperCase(s.charAt(0));
            s = s.substring(1);
            letterCasePermutation1(s, output1, result);
            letterCasePermutation1(s, output2, result);
        }
    }
}
