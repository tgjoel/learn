package coding.binarysearch;

public class CeilingOfNumber {
    //Smallest number which is greater or equal to target
    public static void main( String[] args ) {
        int arr[] = {2, 3, 14, 20, 45, 65, 72, 75, 80, 85, 90, 192};
        int target = 89;
        int ans = ceilingOfNumber(arr, target);
        System.out.println("Ceiling of number " + target + " is: " + ans + " and the number is: " + arr[ans]);
    }

    static int ceilingOfNumber( int arr[], int target ) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
//                if(arr[start] >= target) {
//                    return start;
//                }
            }
        }
        return start;
        // return end; --- for getting the floor of the number
    }
}
