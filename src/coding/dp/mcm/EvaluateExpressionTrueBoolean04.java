package coding.dp.mcm;


//Recursive solution
public class EvaluateExpressionTrueBoolean04 {

    static void main() {
        System.out.println(countWaysRecursive("T|T&F^T"));
        System.out.println(countWaysRecursive("T^F&T"));
    }

    private static int countWaysRecursive(String s) {
        return countWaysRecursive(s, 0, s.length() - 1, true);
    }

    private static int countWaysRecursive(String s, int i, int j, boolean isTrue) {

        //base condition
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if (isTrue) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }
        // base condition ends
        int ways = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {

            // will count the number of ways the left side and right side can be true and false. Depending on the operator would be able to return the answer
            int leftTrue = countWaysRecursive(s, i, k - 1, true);
            int leftFalse = countWaysRecursive(s, i, k - 1, false);
            int rightFalse = countWaysRecursive(s, k + 1, j, false);
            int rightTrue = countWaysRecursive(s, k + 1, j, true);

            if (s.charAt(k) == '|') {
                if (isTrue) {
                    ways = ways + (
                            leftTrue * rightTrue +
                                    leftTrue * rightFalse +
                                    leftFalse * rightTrue
                    );
                } else {
                    ways = ways + (leftFalse * rightFalse);
                }
            } else if (s.charAt(k) == '&') {
                if (isTrue) {
                    ways = ways + (
                            leftTrue * rightTrue
                    );
                } else {
                    ways = ways + (
                            leftTrue * rightFalse +
                                    leftFalse * rightTrue +
                                    leftFalse * rightFalse
                    );
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue) {
                    ways = ways + (
                            leftTrue * rightFalse +
                                    leftFalse * rightTrue
                    );
                } else {
                    ways = ways + (
                            leftTrue * rightTrue +
                                    leftFalse * rightFalse
                    );
                }
            }
        }
        return ways;
    }
}