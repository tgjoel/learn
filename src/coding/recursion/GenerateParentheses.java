package coding.recursion;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
public class GenerateParentheses {

    public static void main( String[] args ) {
        List<String> parentheses = solveGenerateParentheses(1);
        parentheses.forEach(System.out::println);
    }
    private static List<String> solveGenerateParentheses( int count ) {
        List<String> parentheses = new ArrayList<>();
        String output = "";
        int openCount = count;
        int closeCount = count;
        solveGenerateParentheses(parentheses, output, openCount, closeCount);
        return parentheses;
    }

    private static void solveGenerateParentheses( List<String> parentheses, String output, int openCount, int closeCount ) {
        if( openCount == 0 && closeCount == 0 ) {
            parentheses.add(output);
            return;
        }
        if (openCount != 0) {
            String output1 = output + "(";
            solveGenerateParentheses(parentheses, output1, openCount-1, closeCount);
        }
        if(closeCount > openCount) {
            String output1 = output + ")";
            solveGenerateParentheses(parentheses, output1, openCount, closeCount-1);
        }
    }
}
