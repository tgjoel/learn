package coding.problem;

//3046. Split the Array
public class SplitArray {
    public static void main( String[] args ) {
       int[] nums = {2,10,2,7,8,9,7,6,6,9};
        System.out.println(isPossibleToSplit(nums));
    }

    public static boolean isPossibleToSplit( int[] nums ) {

        int n = nums.length;
        int[] arr1 = new int[n/2];
        int[] arr2 = new int[n/2];

        for (int i = 0, j = 0, k=0; i < n; i++) {
           int elm = nums[i];
           boolean isPresent = checkIsPresent(arr1,elm);
           if(!isPresent && j < n/2) {
               arr1[j] = elm;
               j++;
           } else {
               if (checkIsPresent(arr2,elm) && checkIsPresent(arr1,elm)) {
                   return false;
               }
               arr2[k] = elm;
               k++;
           }
        }
        return true;
    }

    private static boolean checkIsPresent( int[] arr, int elm) {
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if(elm == arr[i]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
