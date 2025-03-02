package coding.problem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class PlusOne {
    public static void main( String[] args ) {
        int[] digit = {8, 9, 9, 9};
        int[] ans = plusOne(digit);
        Arrays.stream(ans).forEach(System.out::print);
    }

    public static int[] plusOne( int[] digits ) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //only cases having all 9 will reach here
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }

    public static int[] plusOne1( int[] digits ) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
