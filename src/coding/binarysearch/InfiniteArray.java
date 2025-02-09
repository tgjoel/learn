package coding.binarysearch;

// the size of the array is infinite. Meaning we cannot use the array.length() method to calculate
public class InfiniteArray {

    public static void main( String[] args ) {
        int arr[] = {2, 3, 5, 6, 7, 8, 10, 15, 18, 19, 20, 38, 49, 56, 65, 76, 85, 89, 100}; /// for executing we take this
        System.out.println(search(arr, 56));
        System.out.println(search(arr, 10));
        System.out.println(search(arr, 65)); /// this would cause index out of bound exception, because we have
        ///finite array in the example, but the question was for infinite array
    }


    ///  Will consider the array into chunks. The chunk size is determined exponential of 2.
    static int search( int[] arr, int target ) {
        int start = 0;
        int end = 1;
        /// need to find the target between the window. keep on doubling the window as the target is greater than the
       // end element

//        while (true) {
//            if (target >= arr[start] && target <= arr[end]) {
//                break;
//            } else {
//                int newStart = end + 1;
//                end = end + (end - start + 1) * 2;
//                start = newStart;
//            }
//

        // same as the above condition
        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
