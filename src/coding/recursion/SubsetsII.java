package coding.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LC: 90. Subsets II
public class SubsetsII {
    public static void main( String[] args ) {
        int nums[] = {4,4,4,1,4};
        List<List<Integer>> powerSet =  printPowerSets(nums);
        powerSet.forEach(System.out::println);
    }

    private static List<List<Integer>> printPowerSets( int[] nums ) {
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        printPowerSets(nums, 0, output, powerSet);
        return powerSet;
    }

    private static void printPowerSets( int[] nums, int index, List<Integer> output, List<List<Integer>> powerSet ) {
        if(index == nums.length) {
            if(!powerSet.contains(output)) {
                powerSet.add(output);
            }
            return;
        }
        List<Integer> output1 = new ArrayList<>(output); // not considering decision
        List<Integer> output2 = new ArrayList<>(output);
        output1.add(nums[index]); // considering the input decision

        printPowerSets(nums, index + 1, output1, powerSet);
        printPowerSets(nums, index + 1, output2, powerSet);

    }
}
