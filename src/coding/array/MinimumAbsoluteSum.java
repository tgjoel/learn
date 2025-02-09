package coding.array;

public class MinimumAbsoluteSum {
    /* Given a sorted integer array, find a pair in it having an absolute minimum sum.
        A = [-6, -5, -3, 0, 2, 4, 9] ::   (-5, 4)
     */

    public static void main(String[] args) {
        int[] arr = {-6, -5, -3, 0, 2, 4, 9};

        int m = 0,n = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = arr.length-1; i < j ;) {
            int absSum = Math.abs(arr[i]+ arr[j]);
            if(absSum < min) {
                min = absSum;
                m = i;
                n = j;
            }
            if(arr[i] + arr[j] > 0) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(arr[m] + " " +  arr[n]);
    }
}
