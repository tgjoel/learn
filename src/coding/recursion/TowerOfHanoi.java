package coding.recursion;

public class TowerOfHanoi {
    static int  count = 0;
    public static void main( String[] args ) {
        int numberOfPlates = 3;
        /*
            Mapping Tower Source - 1 || Tower Destination - 3 || Tower helper - 2
         */
        solveTowerOfHanoi(1, 3, 2,numberOfPlates);

        System.out.println("The number of steps to solve tower of hanoi: " + count);
    }
    public static void solveTowerOfHanoi(int source, int destination, int helper, int numberOfPlates) {
       count++;
        if(numberOfPlates == 1) {
            System.out.println("Moving the plate from " + source + " to " + destination);
            return;
        }

        // Step 1: We will move n-1 plates from source to helper by using the destination as placeholder
        solveTowerOfHanoi(source, helper, destination, numberOfPlates - 1);

        // Step 2: Move the nth plates from source to destination
        System.out.println("Moving the plate from " + source + " to " + destination);

        // Step 2: Move the N-1 plates from helper to destination by using the source as placeholder
        solveTowerOfHanoi(helper, destination, source, numberOfPlates-1);

    }
}
