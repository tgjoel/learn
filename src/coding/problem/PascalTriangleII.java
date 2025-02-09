package coding.problem;

import java.util.ArrayList;
import java.util.List;

//119. Pascal's Triangle II
/*
Input: rowIndex = 3
Output: [1,3,3,1]
 */
public class PascalTriangleII {
    public static void main(String[] args) {
        List<Integer> ansList = getRow(3);
        ansList.forEach(System.out::println);
    }

    public static List<Integer> getRow( int rowIndex) {
            List<List<Integer>> triangle = new ArrayList<>();
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            triangle.add(newRow);
            for(int i = 1 ; i <= rowIndex ; i++) {
                List<Integer> currRow = triangle.get(i-1);
                newRow = new ArrayList<>();
                newRow.add(1);
                for (int j = 0; j < currRow.size(); j++) {
                    if(j+1 < currRow.size()) {
                        newRow.add(currRow.get(j) + currRow.get(j+1));
                    } else {
                        newRow.add(currRow.get(j));
                    }
                }
                triangle.add(newRow);
            }
            return triangle.get(rowIndex);
    }
}
