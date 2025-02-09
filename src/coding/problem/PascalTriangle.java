package coding.problem;

import java.util.ArrayList;
import java.util.List;

//118. Pascal's Triangle
/*
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class PascalTriangle {
    public static void main( String[] args ) {
        List<List<Integer>> s = generate(5);
        s.forEach(s1->s1.forEach(System.out::println));
    }
    public static List<List<Integer>> generate( int numRows) {

        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        ansList.add(newRow);
        for(int i = 1; i < numRows; i++) {
            List<Integer> currRow = ansList.get(i-1);
            newRow = new ArrayList<>();
            newRow.add(1);
            for(int j = 0; j < currRow.size(); j++) {
                if(j+1 < currRow.size()) {
                    newRow.add(currRow.get(j) + currRow.get(j+1) );
                } else {
                    newRow.add(currRow.get(j));
                }
            }

            ansList.add(newRow);
        }
        return ansList;
    }
}
