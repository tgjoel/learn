package coding.binarysearch;

/// https://leetcode.com/problems/find-in-mountain-array/
public class FindInMountainArray {
    public static void main( String[] args ) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;  //3 exists in the array, at index=2 and index=5. Return the
        // minimum index, which is 2.
        int[] arr2 = {0, 1, 2, 4, 2, 1};
        int target2 = 3;  //3 does not exist in the array, so we return -1

        System.out.println(findInMountainArray(target, arr));
        System.out.println(findInMountainArray(target2, arr2));
        System.out.println(findInMountainArray(2, new int[]{1, 5, 2}));
    }

    public static int findInMountainArray( int target, int[] arr ) {
        // find peak element
        // do search by making peak as start or end

        int peakIndex = peakInMountainArray(arr);
        System.out.println("peakIndex: " + peakIndex);

        int ascendingIndex = binarySearch(arr, 0, peakIndex, target, true);

//        int descendingIndex = binarySearch(arr, peakIndex, arr.length - 1, target, false);

//        if (ascendingIndex == -1) {
//            return descendingIndex;
//        } else if (descendingIndex == -1) {
//            return ascendingIndex;
//        } else {
//            return Math.min(ascendingIndex, descendingIndex);
//        }
        // same as below as if both index is present then we need the min
        if (ascendingIndex != -1) {
            return ascendingIndex;
        } else {
            return binarySearch(arr, peakIndex + 1, arr.length - 1, target, false);
        }

    }

    public static int binarySearch( int[] arr, int start, int end, int target, boolean isAscending ) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                if (isAscending) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (isAscending) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int peakInMountainArray( int[] arr ) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
