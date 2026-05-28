package coding.dp.mcm;

import java.util.Arrays;

public class EggDropProblemMemoization09 {
    static void main() {
        System.out.println(superEggDrop(2, 6));
        System.out.println(superEggDrop(3, 14));
    }

    private static int superEggDrop(int k, int n) {
        int[][] memo = new int[k + 1][n + 1];
//        for (int i = 0; i < e + 1; i++)
//            for (int j = 0; j < f + 1; j++) {
//                memo[i][j] = -1;
//            }
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return superEggDrop(k, n, memo);
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

            int eggBreaks = superEggDrop(e - 1, k - 1);
            int eggRemains = superEggDrop(e, f - k);

            int temp = 1 + Math.max(eggBreaks, eggRemains);

            minAttempts = Math.min(minAttempts, temp);
        }
        memo[e][f] = minAttempts;
        return minAttempts;
    }
}
