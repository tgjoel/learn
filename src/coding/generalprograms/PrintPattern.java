package coding.generalprograms;

public class PrintPattern {
 /*

1
2 6
3 7 10
4 8 11 13
5 9 12 14 15

*/

    public static void main(String[] args) {
        int n = 6;
        for (int i = 1; i <=n; i++) {
            int value = i;
            System.out.println();
            for (int j = 1; j <=i; j++) {
                System.out.print(value+ "  ");
                value = value + n - j;
            }

        }
    }


}
