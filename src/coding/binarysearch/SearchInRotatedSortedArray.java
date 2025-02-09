package coding.binarysearch;

/// https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchInRotatedSortedArray {

    public static void main( String[] args ) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
       // System.out.println(search(nums, target));  // Output: 4

        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 3;
       // System.out.println(search(nums1, target1)); // Output: -1

        int[] nums2 = {5, 1 , 3};
        int target2 = 5;
        System.out.println(search(nums2, target2));  // Output: 0


    }

    public static int search( int[] nums, int target ) {
        int peakIndex = peakOfArray(nums);

        if (nums[peakIndex] == target) {
            return peakIndex;
        }
        int index = search(nums, target, 0, peakIndex, true);

        if (index == -1) {// not found in the ascending index
            index = search(nums, target, peakIndex + 1, nums.length - 1, true);
        }
        return index;
    }

    public static int search( int[] nums, int target, int start, int end, boolean isAscending ) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
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

    public static int peakOfArray( int[] nums ) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
