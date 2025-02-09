package coding.recursion;


import java.util.ArrayList;
import java.util.List;

// LC : 78. Subsets
public class Subsets {
    public static void main( String[] args ) {
        int nums[] = {1, 2, 3};
        subsets(nums);
    }

    public static List<List<Integer>> subsets( int[] nums) {
       List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<>();
        subsets(nums, 0 , output, subsets);
       return subsets;
    }
    private static void subsets( int[] nums, int index,  List<Integer> output, List<List<Integer>> subsets ) {
        if(index == nums.length) {
            subsets.add(output);
            return;
        }

        List<Integer> output1 = new ArrayList<>(output);
        List<Integer> output2 = new ArrayList<>(output);
        output2.add(nums[index]);
        subsets(nums,index + 1,  output1, subsets);
        subsets(nums, index + 1, output2, subsets);
    }
}
