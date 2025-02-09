package coding.problem;
//169: The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
public class MajorityElement {
    public static void main( String[] args ) {
        int[] nums = {2,2,1,3}; // not a valid input as the ans is not repeating more than n/2
        //int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement1(nums));
    }
    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;

        for (int i = 1; i<nums.length;i++) {
            if(nums[i] == majority) {
                count++;
            } else {
                count--;
                if(count==0) {
                    majority = nums[i];
                    count = 1;
                }
            }
        }
        return majority;
    }

    public static int majorityElement1(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }
        return candidate;
    }
}
