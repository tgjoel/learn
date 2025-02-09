package coding.slidingwindow.fixedwindow;

import java.util.ArrayDeque;
import java.util.Deque;

//LeetCode: 239
public class MaxOfAllSubarrays {

    public static void main( String[] args ) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k =3;
        int[] ans = maxSlidingWindow(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int i =0; int j =0;
      //  List<Integer> tempList = new ArrayList<>();
        int[] ans = new int[nums.length-k+1];  // ans size will be always array length - k + 1
        int ansCount = 0;

        Deque<Integer> tempList = new ArrayDeque<>();

        while(j < nums.length){
            //calculation where the elements which are less than j is removed as they are of no use in the future calculation
            // and the largest element will be at the index 0;

            while(!tempList.isEmpty() && tempList.peekLast() < nums[j]) {
                tempList.removeLast();
            }

//           The list solution gives timeout in the leetcode
//            while (!tempList.isEmpty() && x < tempList.size()){
//                if(tempList.get(x) < nums[j]){
//                    tempList.remove(x);
//                    x--;         // each time when the elements are removed the size of array is reduced. so inorder to accommodate
//                }
//                x++;
//            }

            tempList.add(nums[j]); // elements after the j is being added as it would be useful

            if(j-i+1 < k) {
                j++;
            } else if (j -i +1 ==k) {
                ans[ansCount++] = tempList.getFirst(); // maximum will be at the top
                if(nums[i] == tempList.getFirst()){ // removing the element from the list if the element is moved out of window
                    tempList.removeFirst();
                }
                i++; // sliding the window
                j++;
            }

        }

        return ans;
    }
}
