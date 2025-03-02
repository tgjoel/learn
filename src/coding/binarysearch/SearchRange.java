package coding.binarysearch;

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class SearchRange {

    public static void main( String[] args ) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange( int[] nums, int target ) {

        int start = search(nums, target, true);
        int end = search(nums, target, false);
        return new int[] {start, end};
    }

    private static int search( int[] nums, int target, boolean isFirstOccurrence ) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (isFirstOccurrence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
