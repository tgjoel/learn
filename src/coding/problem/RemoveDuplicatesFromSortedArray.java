package coding.problem;

public class RemoveDuplicatesFromSortedArray {
    public static void main( String[] args ) {
    //int[] nums = {0,0,1,1,1,2,2,3,3,4};
    int[] nums = {1,1,2,3};
     int k = removeDuplicates(nums);
        System.out.println("Number: " + k);
    }
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int j =0;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] != nums[j]) {
                nums[++j] =nums[i];
            }
        }
        int k = j+1;
        return k;
    }
}
