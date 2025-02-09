package coding.binarysearch;

import java.util.Arrays;

public class BinarySearchAlgo {
    public static void main( String[] args ) {
        int arr[] = {10, 20, 30, 45, 65, 87, 90, 97};
        int arrs[] = {100, 85, 73, 64, 45, 37, 20, 17};
        System.out.println("Ascending");
        System.out.println("Searching for: 90 :" + binarySearch(arr, 90));
        System.out.println("Searching for: 47 :" + binarySearch(arr, 47));
        System.out.println("Searching for: 10 :" + binarySearch(arr, 10));
        System.out.println("Descending");
        System.out.println("Searching for: 100 :" + binarySearch(arrs, 100));
        System.out.println("Searching for: 20 :" + binarySearch(arrs, 20));
        System.out.println("Searching for: 10 :" + binarySearch(arrs, 10));
    }

    public static int binarySearch( int arr[], int target ) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            //int mid = (start + end)/2; // this may exceed the range of int in the calculation so better to use
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            boolean isAsc = arr[start] < arr[end]; // to make it order agnostic


            if(isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }


        }
        return -1;
    }
}
