package coding.recursion;


//779. K-th Symbol in Grammar
public class KthSymbolGrammar {
    public static void main( String[] args ) {
        System.out.println(kthGrammar(4,6));  //  0 1 1 0 1 0 0 1. Ans: 0. which is the sixth element in the nth row
    }


    public static int kthGrammar(int n, int k) {
            if(n == 1 && k == 1) {
                return 0;
            }
            int mid = (int)(Math.pow(2,n-1)) / 2;

            if(k <= mid) {
                return kthGrammar(n-1, k);
            } else {
                return kthGrammar(n-1, k-mid) == 0 ? 1: 0; // need to do the complement
            }
    }
}
