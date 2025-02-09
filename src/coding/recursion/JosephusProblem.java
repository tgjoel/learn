package coding.recursion;


import java.util.ArrayList;
import java.util.List;

// Game of Death in a circle | Execution in Circle
//LC 1823. Find the Winner of the Circular Game
public class JosephusProblem {

    public static void main( String[] args ) {
        int n = 5, k = 2;
        System.out.println("Last one :" + solveJosephusProblem(n, k) );
    }

    private static int solveJosephusProblem( int n, int k ) {
        //Will represent the people as interger array
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        // As K is the position and index starts from Zero reducing the K-1 for further calculation
        return solveJosephusProblem(0, k-1, list);

    }
    private static int solveJosephusProblem( int index, int k, List<Integer> list) {
        // base condition
        if(list.size() == 1) {
            return list.getFirst();
        }
        //Hypothesis -- Reducing the input.

        //Index of the position to be removed will be (currentIndex + k) % listSize. Modulus is needed to make it circular
        index = (index + k) % list.size();
        list.remove(index); // removing the element
        return solveJosephusProblem(index, k, list);

        // Induction : Nothing to be done as the element that was removed for reducing the input is not required further.
    }
}
