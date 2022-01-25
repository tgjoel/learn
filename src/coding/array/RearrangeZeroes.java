package coding.array;

import java.util.Arrays;

public class RearrangeZeroes {

    public static void main(String[] args) {
       // Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
       // Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};

        //move to the end of the array.
        int[] arr = {1, 2, 0, 4, 3, 0, 5, 0};
        System.out.println("Original Array");
        Arrays.stream(arr).forEach(a -> System.out.print(a +" "));
        int count = 0;
        for(int i = 0; i< arr.length; i++) {
            if(arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        //at then end of the iteration count will have the last non zero index. adding the rest of the zeros

        for (int i = count+1; i < arr.length ; i++) {
            arr[i] = 0;
        }
        System.out.println();
        System.out.println("Zeros in the back of the array");
        Arrays.stream(arr).forEach(a -> System.out.print(a +" "));

        System.out.println();
        arr = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
        count = arr.length - 1;
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i]!=0) {
                arr[count] = arr[i];
                count--;
            }
        }
        for(int i = count -1; i >=0; i-- ) {
            arr[i] = 0;
        }
        System.out.println("Zeros in the front of the array");
        Arrays.stream(arr).forEach(a -> System.out.print(a +" "));
    }
}
