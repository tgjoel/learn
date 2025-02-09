package slidingwindow.fixedwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInWindow {
    public static void main( String[] args ) {
        int[] nums = {-8, 2, 3, -6, 10};
       // int[] nums = {-8, 2, 3, -6, 10};
        int k = 2;

        int i =0;
        int j =0;
        List<Integer> list = new ArrayList<>();
        //long[] ans = new long[nums.length - k+1]; // this will be the answer size always
        int x = 0;
        while( j < nums.length ) {
            if(nums[j] < 0) {
                list.add(nums[j]);
            }
            if(j-i+1 < k) {
                j++;
            } else if(j - i+1 ==k) {
                if(list.isEmpty()) {
                    System.out.print(0 + " ");
                  //  ans[x++] = 0;
                } else {
                    System.out.print(list.get(0) +" ");
                   // ans[x++] = list.get(0);
                    if(nums[i] == list.get(0)) {
                        list.remove(0);
                    }
                }
                j++;
                i++;
            }
        }

    }
}
