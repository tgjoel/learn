package coding.dp.mcm;

import java.util.Arrays;

//memoization approach
public class EvaluateExpressionTrueBoolean05 {
    static void main() {
        System.out.println(countWaysMemoized("T|T&F^T"));
        System.out.println(countWaysMemoized("T^F&T"));
    }
    private static int countWaysMemoized(String word) {
        int[][][] memo = new int[word.length() +1][word.length() +1][2];

        for(int[][] matrix : memo) {
            for(int[] row: matrix) {
                Arrays.fill(row, -1);
            }
        }
       return countWaysMemoized(word, 0, word.length()-1, 1,memo);
    }

    private static int countWaysMemoized(String s, int i, int j, int isTrue, int[][][] memo) {
        if(i > j) {
            return 0;
        }
        if(i==j){
            if(isTrue == 1) {
                return s.charAt(i) == 'T' ? 1: 0;
            } else {
                return s.charAt(i) == 'F' ? 1: 0;
            }
        }
        if(memo[i][j][isTrue] != -1) {
            return memo[i][j][isTrue];
        }

        int ways = 0;
        for(int k = i+1; k <=j-1; k = k+2) {
            int leftTrue = countWaysMemoized(s, i, k-1, 1, memo);
            int leftFalse = countWaysMemoized(s, i, k-1, 0, memo);
            int rightTrue = countWaysMemoized(s, k+1, j, 1, memo);
            int rightFalse = countWaysMemoized(s, k+1, j, 0, memo);
            if (s.charAt(k) == '|') {
                if (isTrue == 1) {
                    ways = ways + (
                            leftTrue * rightTrue +
                                    leftTrue * rightFalse +
                                    leftFalse * rightTrue
                    );
                } else {
                    ways = ways + (leftFalse * rightFalse);
                }
            } else if (s.charAt(k) == '&') {
                if (isTrue == 1) {
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
                if (isTrue == 1) {
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
        memo[i][j][isTrue] = ways;
        return ways;
    }
}
