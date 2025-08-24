package coding.binarysearch;

import com.sun.security.auth.UnixNumericGroupPrincipal;

//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));

    }
     static int search(int[] nums, int target) {

        int pivot = findPivot(nums);

        if(pivot == -1)  {
            // the array is not rotated, so simple binary search to get the ans
            return binarySearch(nums, target, 0, nums.length-1);
        }

        if(nums[pivot] == target) {
            return pivot;
        }

        if(nums[0] > target) {
            //then the target is after the pivot
            return binarySearch(nums, target, pivot+1, nums.length-1);
        } else {
            return binarySearch(nums, target, 0, pivot-1);
        }

    }

    static int binarySearch(int[] nums, int target, int start, int end) {

        while(start <= end) {
            int mid  = start + (end - start)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target > nums[mid]) {
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            //case -1
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid; // only at the pivot the array will be in descending and  mid +1 should not exceed the length of array to avoid the index out of bound exception
            }

            //case -2
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            //case -3
            if(nums[start] >= nums[mid]) { // pivot will be the largest in the array, so all the elements after the middle is smaller and they are ignored
                end = mid -1;
            } else { //case -4
                start = mid + 1; // larger number will be present after the pivot
            }
        }
        return -1;
    }

    static int findPivotWithDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length -1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            //case -1
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid; // only at the pivot the array will be in descending and as mid +1 should not exceed the length of array
            }

            //case -2
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid - 1;
            }

            //case-3,
            // if start, end, middle are equal then skip the duplicates.
            //But before ignoring we need to check if that is the pivot or not;
            if(nums[start] == nums[mid] && nums[end] == nums[mid]) {
                //if start is the pivot
                if (nums[start] > nums[start + 1]) {
                    return start;
                }
                start++;
                //check if the end is the pivot
                if (nums[end] < nums[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            //case -4
            // if left is sorted, so pivot is on the right as the pivot is the largest in the array
            // for the pivot to be in the right cases are
               // 1. start is less than the mid
               // 2. if start and mid are equal and end is less than mid, then pivot is somewhere in the mid and end
            else if(nums[start] < nums[mid] || ( (nums[start] == nums[mid]) && (nums[end] < nums[mid]))) {
                start = mid +1;
            } else { //case 4
                end = mid -1;
            }


        }
        return -1;
    }
}
