package coding.stack;

import java.util.*;

//Nearest smallest element to the right
public class NSR {
    public static void main(String[] args) {

        int arr[] = {4,5,2,10,8};
        System.out.println(Arrays.toString(nearestSmallestElementToRight(arr)));

    }

    private static int[] nearestSmallestElementToRight(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> intstack = new Stack<>();

        for(int i = arr.length-1; i>=0; i--) {

            while (!intstack.isEmpty() && intstack.peek() >= arr[i]) {
                intstack.pop();
            }

            if(intstack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(intstack.peek());
            }
            intstack.push(arr[i]);
        }
        return ans.reversed().stream().mapToInt(Integer::intValue).toArray();
    }
}
