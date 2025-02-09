package coding.problem;

//860. Lemonade Change
/*
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
Note that you do not have any change in hand at first.
Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.
 */


public class LemonadeChange {
    public static void main( String[] args ) {
        //int[] bills = {5,5,5,10,20};
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                count5++;
                continue;
            } else if (bills[i] == 10) {
                count10++;
                if(count5 < 1) {
                    return false;
                }
                count5--;
                continue;
            }
            if(bills[i] == 20) {
                if (count5 < 3 && (count10 < 1 || count5 < 1)) {
                    return false;
                } else {
                    if(count10 >= 1) {
                        count10--;
                        count5--;
                    }else {
                        count5-=3;
                    }
                }
            }
        }
        return true;
    }
}
