package coding.array;

public class SquareOfNonDecreasingNumber {
    /*Given an array of integers sorted in non-decreasing order, return the squares of this array,
       sorted in the same order*/
    public static void main(String[] args) {
        int[] arr = {-7,-4,-2,-1};
        int[] out = new int[arr.length];
        for (int i = 0, j = arr.length-1, k = arr.length-1; i <= j; k--) {
            if(Math.abs(arr[i]) > Math.abs(arr[j])) {
                out[k] = arr[i] * arr[i];
                i++;
            } else {
                out[k] = arr[j] * arr[j];
                j--;
            }
        }
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i] + " ");
        }
    }
}
