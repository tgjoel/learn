package coding.problem;

public class ArrayConcatenation {
    public static void main( String[] args ) {

        int[] nums = new int[]{1,2,3,1};
        int n = nums.length;
        int[] ans = new int[n*2];
        for(int i = 0; i<n; i++) {
           ans[i] = nums[i];
           ans[n+i] =nums[i];
        }
        for (int i = 0; i<ans.length;i++) {
            System.out.print(ans[i] + " ");
        }



    }
}