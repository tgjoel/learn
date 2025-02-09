package coding.array;

/* 15. 3Sum

i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
Notice that the solution set must not contain duplicate triplets.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {
    public static void main( String[] args ) {
        //int[] nums = {-1,0,1,2,-1,-4}; //ans = 2
      //  int[] nums = {1,2,-2,-1}; //ans = 0
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> ans = threeSum(nums);
        System.out.println();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // if adjacent are same its already taken into consideration hence skipping that
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    j++;

                    // if adjacent are same its already taken into consideration hence skipping that
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return ans;
    }

    // This approch is not passing all the test cases
//    public static  List<List<Integer>> threeSum1( int[] nums) {
//        Map<Integer,Integer> countMap = new HashMap<>();
//        int sum = 0; // as per the question
//        for (int i = 0; i < nums.length; i++) {
//            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
//        }
//        int n = nums.length;
//        List<List<Integer>> ans = new ArrayList<>();
//        for(int i = 0; i < n-2; i++) {
//            for(int j = i+1; j < n - 1; j++) {
//                int currSum = nums[i] + nums[j];
//                if(countMap.containsKey(sum - currSum) && countMap.get(sum - currSum) > 0) {
//                    // checking if we have already used the nums
//                    countMap.put(nums[i], countMap.get(nums[i])-1);
//                    countMap.put(nums[j], countMap.get(nums[j])-1);
//                    if(countMap.get(sum - currSum) > 0) {
//                        ArrayList<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(sum - currSum);
//                        Collections.sort(list);
//                        ans.add(list);
//                    } else { // it means the i and j element was not used, so adding the count back
//                        countMap.put(nums[i], countMap.get(nums[i])+1);
//                        countMap.put(nums[j], countMap.get(nums[j])+1);
//                    }
//                }
//            }
//        }
//        if(ans.size() == 0 || ans.size() == 1) return ans;
//
//        // the ans will contains duplicates.  need to remove the duplicates
//        return new ArrayList<>(new HashSet<>(ans));
//    }
}
