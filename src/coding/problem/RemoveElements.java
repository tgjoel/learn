package coding.problem;

public class RemoveElements {
    public static void main( String[] args ) {
        int[] nums  = {3,2,2,3};
        int val = 3;
       int ans =  removeElement(nums, val);
        System.out.println(ans);
    }

    public static int removeElement(int[] nums, int val) {
        int j =0;
        for(int i = 0; i < nums.length;i++) {
            if(nums[i]!=val) {
                nums[j] = nums[i];
                j++;
            }
        }

        for(int i = 0; i <j ;i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return j;
    }
}
