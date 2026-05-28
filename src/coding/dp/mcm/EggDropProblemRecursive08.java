package coding.dp.mcm;


public class EggDropProblemRecursive08 {
    static void main() {
        System.out.println(superEggDrop(2,6));
        System.out.println(superEggDrop(3,14));
    }

    private static int superEggDrop(int e, int f) {
        //base conditions
        // 0 floor -- 0 attempts
        // 1 floor -- 1 attempt
        if(f ==0 | f == 1) {
            return f;
        }

        //if there is 1 egg, then worst case is need to attempt from 1 to n floor
        if(e == 1) {
            return f;
        }
        // Try from the kth floor. if it breaks then egg reduced and try from k-1 to below
        // if egg does not break, then egg remains and try from the floors above k
        int minAttempts = Integer.MAX_VALUE;
        for(int k = 1; k <=f; k++) {

            int eggBreaks = superEggDrop(e-1, k-1); // egg breaks, so egg is reduced and try from the below floors
            int eggRemains = superEggDrop(e, f-k);// egg remains, so egg count remain same and need to try from the above floors

            int temp = 1 +  Math.max(eggBreaks, eggRemains); // 1 + because of the current attempt
            // getting max so that we get the worst case scenarios

            minAttempts = Math.min(minAttempts, temp); // need to get the min attempts for the worst case scenario
        }
        return minAttempts;
    }
}
