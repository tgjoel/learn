package coding.array;

public class FirstDuplicateInArray {
    public static void main(String[] args) {
         /*Given an array of N integers with possible values from 1 to N, find the first duplicate in the array.
        If there is no duplicate return -1.
         */
        // int arr[] = {3,4,2,1};
        solutionWithExtraSpace(); // -O(n) time and O(n) space
        solutionWithoutExtraSpace(); // O(n) time and O(1) space
    }

    private static void solutionWithoutExtraSpace() {
        int[] arr = {1,4,2,3,6,5};
        int ans = -1;
        for(int i = 0; i < arr.length; i++) {
            /* gets the absolute value of element at i
                changes element at that index to -ve if positive. if its already neagtive then its a duplicate
                since our array contains only positive values.
             */
            int j = Math.abs(arr[i]);
            if(arr[j-1] > 0) { // need to reduce one as
                arr[j-1]*= -1; // changing to negative
            } else {
                ans = j; // its negative already means its a duplicate
                break; // if just the first duplicate is only required.
            }
        }
        System.out.println(ans);

    }

    private static void solutionWithExtraSpace() {
        int[] arr = {1,4,2,3,7,6,2,7};
        int[] out = new int[arr.length+1];
        int ans = -1;
        for(int i = 0; i < arr.length; i++) {
            if(out[arr[i]]!= 0) {
                ans = i;
                break;
            }
            out[arr[i]]++;
        }
        if(ans !=-1) {
            System.out.println(arr[ans]);
        } else {
            System.out.println(-1);
        }
    }
}
