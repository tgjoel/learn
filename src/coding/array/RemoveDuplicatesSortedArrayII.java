package coding.array;

/*
80. Remove Duplicates from Sorted Array II
Sorted in non-decreasing order, remove some duplicates in-place such
that each unique element appears at most twice
Must do this by modifying the input array in-place with O(1) extra memory.
End can be anything. Should return the size till we have the answer
 */
public class RemoveDuplicatesSortedArrayII {
    public static void main( String[] args ) {
        int[] nums = { 1,1,1,1,2,2,2,3}; // {1,1,2,2,3,_,_,_} ans = 5
        System.out.println(removeDuplicates(nums));
    }
    public static int removeDuplicates(int[] nums) {
       int i = 2;
       for(int j = 2; j< nums.length; j++) {
           if(nums[j] != nums[i-2]) {
               nums[i] = nums[j];
               i++;
           }
       }
       return i;
    }
    // Array is sorted ordered. if j = i-2, that mean 0 and 1 are the same and
    // we need to replace the  current j with the one that is not equal
}
