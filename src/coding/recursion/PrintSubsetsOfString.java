package coding.recursion;

/*
Question variation
1. Print all subset,
2. Print all unique subsets
3. Print all Power sets
4. Print all subsequence
 */


public class PrintSubsetsOfString {
    public static void main( String[] args ) {
        String input = "ab";
        String output = "";
        printSubset(input, output);
    }

    private static void printSubset( String input, String output ) {
        if(input.length() <= 0) {
            System.out.println(output);
            return;
        }
        String output1 = output;  // case when we do not consider
        String output2 = output + input.charAt(0); // case when we considered the input

        input = input.substring(1);  // Reducing the input as its already considered

        printSubset(input, output1);
        printSubset(input, output2);
    }
}
