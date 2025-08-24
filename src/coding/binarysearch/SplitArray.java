package coding.binarysearch;

//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArray {
    public static void main(String[] args) {
        int[] nums1 ={7,2,5,10,8}; int k1 = 2;
        System.out.println(splitArray(nums1, k1));


        int[] nums2 ={1,2,3,4,5}; int k2 = 2;
        System.out.println(splitArray(nums2, k2));
    }

    public static int splitArray(int[] nums, int k) {

        int start = 0;
        int end = 0;

        for(int i = 0; i< nums.length;i++) {
            start = Math.max(start, nums[i]); /// this is when the array is split across nums.length part. The max sum will be max element of the array as each element forms its own array;
            end += nums[i]; // this is when the array is split only once, that is the entire array itself, so its the sum of the array
        }

        // binary search. when start == end
        while(start < end) {

            int mid = (start + end) / 2;

            //calculate the number of subarrays we can have
            int sum = 0;
            int splitCount = 1;
            for (int num: nums) {
                if( (sum + num) > mid) {
                    // this means we cannot add this number into this subarray. we will need new subarray
                    sum = num; // new sum of the new subarray created will be num
                    splitCount++;  // count is incremented
                } else {
                    sum +=num;
                }
            }
            if(splitCount > k) {
                // the split count is more means the avg sum we assumed was less, and hence we were able to split with more numbers in the array.
                // so inorder to reduce this we need to increase the avg sum
                start = mid + 1;
            } else {
                // this split count was less, means the avg sum assumed was larger and this needs to be decreased so we will be able to split more
                end = mid;
            }

        }
        return start; // start will be equal to end
    }
}
