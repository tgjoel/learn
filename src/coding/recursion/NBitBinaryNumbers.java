package coding.recursion;

import java.util.ArrayList;
import java.util.List;

//  Print N-bit binary numbers having more 1’s than 0’s for any prefix
public class NBitBinaryNumbers {
    public static void main( String[] args ) {
        List<String> ansList = new ArrayList<>();
        ansList = solveNBitBinaryNumbers(5);
        ansList.forEach(System.out::println);
    }
    private static List<String> solveNBitBinaryNumbers(int n) {
        List<String> ansList = new ArrayList<>();
        int oneCount = 0;
        int zeroCount = 0;
        String output = "";
        solveNBitBinaryNumbers(output, oneCount, zeroCount, n, ansList);
        return ansList;
    }
    private static void solveNBitBinaryNumbers(String output, int oneCount, int zeroCount, int n, List<String> ansList) {
        if(n == 0) {
            ansList.add(output);
            return;
        }
        String output1 = output + "1";
        solveNBitBinaryNumbers(output1, oneCount +1, zeroCount, n - 1, ansList);
        if(oneCount > zeroCount) {
            String output2 = output + "0";
            solveNBitBinaryNumbers(output2, oneCount, zeroCount + 1 , n - 1, ansList);
        }
    }
}
