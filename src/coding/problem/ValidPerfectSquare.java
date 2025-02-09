package coding.problem;

// 367. Valid Perfect Square
public class ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201)); // true
    }
    public static boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        long i = 0;
        while(i <= num/2) {
            if(i * i == num) {
                return true;
            } else if (i*i < num) {
                i++;
            } else {
                return false;
            }
        }
        return false;
    }
    public static boolean isPerfectSquare1(int num) {
        int start = 1;
        int end = num/2; // just need to check from the half of the number
        int mid;
        while(start <=end) {
            mid = (start + end)/2;
            if((long) mid*mid == num) {
                return true;
            } else if ((long) mid*mid  > num) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
