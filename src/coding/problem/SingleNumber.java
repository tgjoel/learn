package coding.problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//136. Single Number
//Input: nums = [2,2,1]
//Output: 1
public class SingleNumber {
    public static void main( String[] args ) {
        int[] nums = {1,2,1,2,4};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        for (int num : nums) {
            if (mp.containsKey(num)) {
                mp.put(num, mp.get(num) + 1);
            } else {
                mp.put(num, 1);
            }
        }

        int nonRepeated = 0;
        for (Map.Entry<Integer, Integer> mpItr : mp.entrySet()) {
            if(mpItr.getValue() == 1) {
                nonRepeated = mpItr.getKey();
            }
        }

        // TODO: Better Solution using bitwise xor operator:
        /*
        Explanation:

         A xor A = 0
         A xor 0 = A
         A xor B xor C = A xor C xor B

        1,2,1,2,4 -->>>
        iterate over each of the element
        1 xor 2 = 1 xor 2 (or something)
        next loop
        1 xor 2 xor 1
        this is 1 xor 1 xor 2 -->>> 0 xor 2 ---> 2
        next loop
        2 xor 2 = 0
        next loop
        0 xor 4 = 4;


         */

//        int xor = 0;
//        for (int i = 0; i < nums.length; i++) {
//            xor = xor ^ nums[i];
//        }
//        return xor;





//        AtomicInteger nonRepeated = new AtomicInteger();
//        mp.forEach((k,v) -> {
//            if(v==1){
//                nonRepeated.set(k);
//            }
//        });
//        return nonRepeated.get();

        return nonRepeated;
    }


}
