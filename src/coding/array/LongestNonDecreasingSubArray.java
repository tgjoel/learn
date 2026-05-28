package coding.array;

public class LongestNonDecreasingSubArray {

    public static void main(String[] args) {
       //Length of longest non decreasing subarray
       //{5, 3, 6, 4, 6, 6, 7, 5}
        System.out.println(getMaxLength(new int[]{9, 1, 2, 2}));
        System.out.println(getMaxLength1(new int[]{9, 1, 2, 2}));
    }

    private static int getMaxLength(int[] arr) {
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
        return maxLength + 1;
    }


    private static int getMaxLength1(int[] arr) {
        int maxLength = 1;

        int currentLength = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] >= arr[i-1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }

        return Math.max(maxLength, currentLength);
    }


}
