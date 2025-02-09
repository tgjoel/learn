package coding.problem;

import java.util.HashSet;
import java.util.Set;

//217. Contains Duplicate
public class ContainsDuplicate {
    public static void main( String[] args ) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
    public static  boolean containsDuplicate(int[] nums) {
        Set<Integer> ansSet = new HashSet<>();
        for (int num : nums) {
            if (ansSet.contains(num)) {
                return true;
            }
            ansSet.add(num);
        }
        return false;
    }
}
