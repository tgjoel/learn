package coding.binarysearch;

/// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class PeakIndexInMountainArray {
    public static void main( String[] args ) {
        int[] arr = {0,10,5,2};
        System.out.println( peakIndexInMountainArray( arr ));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid + 1]) {
                // this is the increasing part of the array. mid is one of the possible ans. there can be other ans
                // in the right. Mid +1 is anyways greater than mid, so no point in checking the mid again
                start = mid + 1;
            } else {
                // this is the decreasing part of the array, mid is one possible there can be other ans in the left
                end = mid ;
            }
        }
        // loop will break when start = end
        return start; // or end
    }
}
