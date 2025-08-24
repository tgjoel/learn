package coding.binarysearch;

public class SingleNonDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4,8,8,9,9};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2;
            //Ans is when next and previous element is not equal
            if((mid > start && nums[mid] != nums[mid-1]) && (mid < end && nums[mid] != nums[mid + 1])) {
                return  nums[mid];
            }

            //in normal condition, every even index element the next element should be equal to it and for odd index the previous should be equal to it.
            // no if mid is odd and the previous element is not equal to or the mid is even, but still the next element is not equal to it
            // that means the distinct element must lies in the left of mid else it would be on the right.
            if((mid < end && mid % 2 == 0 && nums[mid]!= nums[mid+1])
            || (mid > start && mid % 2 == 1 && nums[mid] != nums[mid-1])) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return nums[start];
    }
}

