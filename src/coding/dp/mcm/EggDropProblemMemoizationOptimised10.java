package coding.dp.mcm;

import java.util.Arrays;

public class EggDropProblemMemoizationOptimised10 {
    static void main() {
        System.out.println(superEggDrop(2, 6));
        System.out.println(superEggDrop(3, 14));
        System.out.println(superEggDrop(9, 5000));
        System.out.println(superEggDrop11(9, 5000));
    }

    private static int superEggDrop(int k, int n) {
        int[][] memo = new int[k + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return superEggDropOptimised(k, n, memo);
    }

    private static int superEggDropOptimised(int e, int f, int[][] memo) {
        if (f == 0 | f == 1) {
            return f;
        }
        if (e == 1) {
            return f;
        }

        if (memo[e][f] != -1) {
            return memo[e][f];
        }
        int minAttempts = Integer.MAX_VALUE;

        int low = 1;
        int high = f;

        while (low <= high) {
            int k = low + (high - low) / 2;  // instead of (a + b) / 2 which can exceed the integer limit

            // will check if its already solved and present in the matrix
            int eggBreaks;
            int eggRemains;

            if (memo[e - 1][k - 1] != -1) {
                eggBreaks = memo[e - 1][k - 1];
            } else {
                eggBreaks = superEggDrop(e - 1, k - 1, memo);
                memo[e - 1][k - 1] = eggBreaks;
            }

            if (memo[e][f - k] != -1) {
                eggRemains = memo[e][f - k];
            } else {
                eggRemains = superEggDrop(e, f - k, memo);
                memo[e][f - k] = eggRemains;
            }

            int temp = 1 + Math.max(eggBreaks, eggRemains);

            minAttempts = Math.min(minAttempts, temp);

            if (eggBreaks > eggRemains) { // Breaking is the worst case, to minimise try at lower levels
                high = k - 1;
            } else { // Remaining is the worst case, try at higher level
                low = k + 1;
            }
        }
        memo[e][f] = minAttempts;
        return minAttempts;
    }

    // futher optimised for leetcode
        public static int superEggDrop11(int k, int n) {
            int[][] dp = new int[k + 1][n + 1];  // here we take eggs and attempts
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    // current = egg broke, attempt reduced  + egg remain, but attempts reduce + current attemps
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + 1;

                    if (dp[k][j] >= n) { // if for K eggs and J attempts, is higher than the no. of floors then we need only j attempts
                        return j; // the number of attempts will never exceed the floor
                    }
                }
            }
            return n; // would need equal to no. of floor attempts
        }



    private static int superEggDrop(int e, int f, int[][] memo) {
        if (f == 0 | f == 1) {
            return f;
        }
        if (e == 1) {
            return f;
        }

        if (memo[e][f] != -1) {
            return memo[e][f];
        }
        int minAttempts = Integer.MAX_VALUE;
        for (int k = 1; k <= f; k++) {
            // will check if its already solved and present in the matrix
            int eggBreaks;
            int eggRemains;

            if (memo[e - 1][k - 1] != -1) {
                eggBreaks = memo[e - 1][k - 1];
            } else {
                eggBreaks = superEggDrop(e - 1, k - 1, memo);
                memo[e - 1][k - 1] = eggBreaks;
            }

            if (memo[e][f - k] != -1) {
                eggRemains = memo[e][f - k];
            } else {
                eggRemains = superEggDrop(e, f - k, memo);
                memo[e][f - k] = eggRemains;
            }

            int temp = 1 + Math.max(eggBreaks, eggRemains);

            minAttempts = Math.min(minAttempts, temp);
        }
        memo[e][f] = minAttempts;
        return minAttempts;
    }
}
