package coding.binarysearch;

// Check search in rotated array for better understanding
public class RotationCount {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int[] nums1 = {4,5,6,7};

        System.out.println(rotationCount(nums));
        System.out.println(rotationCount(nums1));
    }

    static int rotationCount(int[] nums) {

        int pivot = findPivotOfArray(nums);

        return pivot + 1 ;
    }

    static int findPivotOfArray(int[] nums) {

        int start = 0;
        int end = nums.length -1;

        while (start < end) {
            int mid = start +  (end - start)/2;

            if(mid < end && nums[mid] > nums[mid +1]) {
                return  mid;
            }
            if(mid > start && nums[mid] < nums[mid -1]) {
                return mid-1;
            }
            if(nums[start] <= nums[mid]) {
                start = mid +1;
            } else {
                end = mid -1;
            }
        }
        return -1;
    }

}
