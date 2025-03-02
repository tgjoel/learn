package coding.slidingwindow.problems;

/*
1423. Maximum Points You Can Obtain from Cards
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
public class MaximumPointsCards {

    public static void main( String[] args ) {

        int[] cardPoints = {32,69,37,79,4,33,29,33,45,1,99,90,56,24,76};
        int k = 10;
//        int[] cardPoints = {100, 40, 17, 9, 73, 75};
//        int k = 3;
        System.out.println("Max Score Points: " + maxScore(cardPoints, k));

    }

    // need to check as a circular array
    public static int maxScore( int[] cardPoints, int k ) {

        int rightIndex = cardPoints.length-1;
        int maxSum = 0;
        int currentWindowSum = 0;

        for (int i = 0; i < k ; i++) {
            currentWindowSum += cardPoints[i];
        }
        maxSum = currentWindowSum;

        for(int i = k-1, j = rightIndex; i >= 0; i--, j--) {
            currentWindowSum -= cardPoints[i]; // decreasing the sum from K and adding the last
            currentWindowSum += cardPoints[j];
            maxSum =  Math.max(maxSum, currentWindowSum);
        }
        return maxSum;




//        int leftSum = 0;
//        int rightSum = 0;
//        int maxsum;
//        //first find the sum till the K
//        for (int i = 0; i < k; i++) {
//            leftSum += cardPoints[i];  //100 + 40 + 17
//        }
//        maxsum = leftSum;
//
//        int rightIndex = cardPoints.length - 1;
//        for (int i = k - 1; i >= 0; i--) {
//            leftSum -= cardPoints[i];  // now decrease from the k-1 and add from the last. Forming 75 + 100 + 40 ---->> 73 + 75 + 100 ----> 9 + 73 + 75
//            rightSum += cardPoints[rightIndex];
//            maxsum = Math.max(maxsum, leftSum + rightSum); // find the max in each calculation
//            rightIndex--;
//        }
//        return maxsum;
    }
}
