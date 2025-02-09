package coding.generalprograms;

public class PrintTillNWithoutUsingLoop {
    static int N = 10;
    public static void main(String[] args) {
        new PrintTillNWithoutUsingLoop().printNUsingRecursion(1);
        System.out.println();
        new MethodChainingClass().printUsingMethodChaining();
    }


    public void printNUsingRecursion(int i) {
        if(i > 10) {
            return;
        }
        System.out.print(i++ + " ");
        printNUsingRecursion(i);
    }
}

class MethodChainingClass {
    static int i = 1;
    public void printUsingMethodChaining() {
        // suppose its for 10
        print10();
    }

    private void print1() {
        System.out.print(i++ + " ");
    }

    private void print3() {
        print1();
        print1();
        print1();
    }
    private void print10() {
        print3();
        print3();
        print3();
        print1();
    }

    private void print30() {
        print10();
        print10();
        print10();
    }
    private void print100() {
        print30();
        print30();
        print30();
        print10();
    }
}
