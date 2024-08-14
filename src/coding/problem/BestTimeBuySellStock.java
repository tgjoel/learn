package problem;

//121. Best Time to Buy and Sell Stock
public class BestTimeBuySellStock {

    public static void main( String[] args ) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int leastValue = Integer.MAX_VALUE;
        int onDayProfit = 0;
        for (int i =0; i< prices.length;i++) {
            if(prices[i] < leastValue) {
                leastValue = prices[i];
            }
            onDayProfit = prices[i] - leastValue;
            if(onDayProfit > maxProfit) {
                maxProfit = onDayProfit;
            }
        }
        return maxProfit;
    }


    //brute force soulution
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i =0; i< prices.length-1;i++) {
            for (int j =i+1; j<prices.length;j++) {
                if(prices[j]-prices[i] > maxProfit) {
                    maxProfit = prices[j]-prices[i];
                }
            }
        }
        return maxProfit;
    }
}
