package problem;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main( String[] args ) {
        int[] nums1 = {2, 4, 7, 9, 10, 0, 0, 0};
        int m = 5;
        int[] nums2 = {1, 5, 6};
        int n = 3;

//        int[] nums1 = {0};
//        int m = 0;
//        int[] nums2 = {1};
//        int n = 1;

        merge(nums1, m, nums2, n);
        ;
        Arrays.stream(nums1).forEach(System.out::println);
    }

    public static void merge( int[] nums1, int m, int[] nums2, int n ) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        } else if (nums2 == null) {
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        for (; i > -1 && j > -1; k--) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }

        for (int l = 0; l <= j; l++) {
            nums1[l] = nums2[l];
        }

    }
}
