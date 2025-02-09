package coding.recursion;

public class SimpleRecursion {
    public static void main( String[] args ) {
        //print(7);

        printReverse(7);

        //System.out.println(isPowerOfThree(45));
    }

    private static boolean isPowerOfThree( int n ) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }

    private static void print( int n ) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }

    private static void printReverse( int n ) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printReverse(n - 1);
    }
}
