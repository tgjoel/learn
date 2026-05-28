package coding.binarysearch;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(17));
    }

    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if (mid * mid < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
