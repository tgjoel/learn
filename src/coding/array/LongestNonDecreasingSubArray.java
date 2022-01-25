package coding.array;

public class LongestNonDecreasingSubArray {

    public static void main(String[] args) {
       //Length of longest non decreasing subarray
        int[] arr = {9, 1, 2, 2}; //{5, 3, 6, 4, 6, 6, 7, 5}
        int maxLength = 0, count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                count = 0;
            } else {
                count++;
                if (count > maxLength) {
                    maxLength = count;
                }
            }
        }
        System.out.println(maxLength + 1);  // if there is no increasing then its 1
    }
}
