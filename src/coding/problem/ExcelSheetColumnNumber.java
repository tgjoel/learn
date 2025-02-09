package coding.problem;

public class ExcelSheetColumnNumber {
    public static void main( String[] args ) {
        System.out.println(titleToNumber("A"));
    }
    public static  int titleToNumber(String columnTitle) {
        if(columnTitle == null) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            sum = sum *26;
            sum = sum+ c - 'A' + 1;
        }
        return sum;
    }
}
