package coding.array;

/*
167. Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

 */
public class TwoSumII {
    public static void main( String[] args ) {

        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ans = twoSum(numbers, target);
        System.out.println("Two Sum: " + ans[0] + "   " + ans[1] );
    }


    public static int[] twoSum( int[] numbers, int target ) {

        int[] result = new int[2];
        for (int i = 0, j = numbers.length-1; i < j; ) {

            //since its sorted apply the two pointer approach
            if (numbers[i] + numbers[j] == target) { // if sum is equal then that is the result
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;

    }
}
