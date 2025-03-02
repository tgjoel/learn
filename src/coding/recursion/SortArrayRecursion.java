package coding.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class SortArrayRecursion {
    public static void main( String[] args ) {
        int[] input = new int[]{3,1,5,2,9,0};
        //converting the array to list
        List<Integer> arr = Arrays.stream(input).boxed().collect(Collectors.toList());
        sort(arr);
        arr.forEach(System.out::println);

    }

    public static void sort( List<Integer> arr ) {
        //Base condition
        if(arr.size() ==0) { // the size of the array is being reduced so the last valid size is 0
            return;
        }
        //Hypothesis
        // reducing the size of the array.
        int temp = arr.getLast();
        arr.removeLast();
        sort(arr); // sorting the array with the

        //induction
         insert(arr, temp); // insert the removed element to the sorted array

    }

    private static void insert( List<Integer> arr, int temp ) {
        //Base condition
        if(arr.isEmpty() || arr.getLast() <= temp) {
            arr.add(temp); // if the array is empty or the number to be inserted is greater than the greatest element in the array insert at the end
            return;
        }

        //hypothesis
        int val = arr.getLast();  // reducing the size of the array and insert
        arr.removeLast();
        insert(arr, temp);  // inserting to the reduced size of the array
        arr.add(val); // add back the removed element
    }
}
