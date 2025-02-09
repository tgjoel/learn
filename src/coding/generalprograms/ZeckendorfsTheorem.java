package coding.generalprograms;

public class ZeckendorfsTheorem {
    //States that every positive integer can be written uniquely as a sum of distinct non-neighbouring Fibonacci numbers.

    // While n >= 0
    //     a) Find the greatest Fibonacci Number smaller than n.
    //        Let this number be 'f'.  Print 'f'
    //     b) n = n - f

    public static void main(String[] args) {
        int n = 30;
        System.out.println("Non-neighbouring Fibonacci Representation of " + n + ": ");
        printFibonacciRepresentation(30);
    }

    private static void printFibonacciRepresentation(int i) {

        if(i == 0 || i ==1) {
            System.out.println(i);
            return;
        }
        while (i > 0) {
            int first = 0, second = 1, third = 1;
            while(third <=i) {
                first = second;
                second = third;// after the loop second will have the greatest fibnocci number less than or equal to i
                third = first + second;
            }
            // need to use the second as third is updated and its greater than i
            System.out.print(" " + second);
            i = i - second;
        }

    }
}
