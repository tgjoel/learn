package coding.knapsack;

// https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
public class MinimumSubSetSum04 {

    public static void main(String[] args) {
        // only considers +ve nums
        System.out.println(minimumDifference(new int[]{3,9,7,3}));
        System.out.println(minimumDifference(new int[]{36, 36}));
        System.out.println(minimumDifference(new int[]{2,1,0,4,2,9}));
    }

    public static int minimumDifference(int[] nums) {
        // s1 +  s2 = s
        // s2 - s1 = min --> s-s1 -s1 = min --> s - 2*s1 = min
        // s1 would be in the range of 0 to S.  find all the possible s1 in 0 to S which can be the subset sum problem
        int sum = 0;
        for (int i : nums) {
            sum += Math.abs(i);
        }

        boolean[][] t = new boolean[nums.length + 1][sum + 1];

        /// initialization
        for (int i = 0; i < nums.length + 1; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        // to have the s1 as smaller by restricting its sum less than s/2
        for (int i = 0; i <= (sum/ 2); i++) {
            if (t[nums.length][i]) {  // need to get the min sum from the possible subset sums
                min = Math.min(min, (sum - 2 * i));
            }
        }

        return min;
    }
}
