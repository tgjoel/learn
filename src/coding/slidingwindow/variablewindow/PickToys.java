package coding.slidingwindow.variablewindow;

import java.util.HashMap;
import java.util.Map;

// Also as 904. Fruit Into Baskets in LeetCode
public class PickToys {
    public static void main( String[] args ) {
        //int[] fruits = new int[]{1, 2, 3, 2, 2};
        int[] fruits = new int[]{0, 0, 0};

        Map<Integer, Integer> tempMap = new HashMap<>();
        int i = 0, j = 0, maxCount = Integer.MIN_VALUE;

        int k = 2;// as per the condition
        while (j < fruits.length) {
            tempMap.put(fruits[j], tempMap.getOrDefault(fruits[j], 0) + 1);
            if (tempMap.size() <= k) {    // there can be condition when there is only one type is there, then the entire window can be used
                maxCount = Math.max(maxCount, j - i + 1);
                j++;
            } else if (tempMap.size() > k) {
                while (tempMap.size() > k) {
                    int startCount = tempMap.get(fruits[i]);
                    startCount--;
                    if (startCount == 0) {
                        tempMap.remove(fruits[i]);
                    } else {
                        tempMap.put(fruits[i], startCount);
                    }
                    i++;
                }
                if (tempMap.size() == k)
                    maxCount = Math.max(maxCount, j - i + 1);
                j++;
            }
        }
        System.out.println("Max count: " + maxCount);
    }

}