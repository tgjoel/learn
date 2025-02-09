package coding.slidingwindow.problems;

//1052. Grumpy Bookstore Owner
/*
There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
Return the maximum number of customers that can be satisfied throughout the day.

Example 1:
Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
public class GrumpyBookstoreOwner {
    public static void main( String[] args ) {
//        int[] customers = new int[]{1,0,1,2,1,1,7,5};
//        int[] grumpy =    new int[]{0,1,0,1,0,1,0,1};
//        int minutes = 3;
        int[] customers = new int[]{4,10,10};
        int[] grumpy = new int[]{1,1,0};
        int minutes = 2;

        System.out.println(maxSatisfied(customers,grumpy,minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = Integer.MIN_VALUE;
        int i = 0; int j = 0;
        int sum = 0;
        int maxWindowStart = 0;
        int maxWindowEnd = 0;
        while(j < customers.length) {
            sum += customers[j] * grumpy[j];
            if(j -i +1 < minutes) {
                j++;
            } else if (j-i+1 == minutes) {
                if(ans < sum) {
                    ans = sum;
                    maxWindowStart = i;
                    maxWindowEnd = j;
                }
                sum -= customers[i] * grumpy[i];
                i++;
                j++;
            }
        }
        System.out.println(ans);
       // System.out.println(maxWindowStart);
       // System.out.println(maxWindowEnd);

        int res= 0;
        for(int k = 0; k< grumpy.length; k++) {
            if(k >= maxWindowStart && k <= maxWindowEnd) {
                res +=  customers[k];
                continue;
            }
            if(grumpy[k] == 0) {
                res += customers[k];
            }
        }
        return res;
    }
}
