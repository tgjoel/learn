package problem;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnTitle {
    public static void main( String[] args ) {
        System.out.println(convertToTitle(701));
    }

    public static String convertToTitle(int columnNumber) {
        Map<Integer,Character> aphaMap = new HashMap<>();
        aphaMap.put(0,'Z');
        for (int i = 0; i < 26; i++) {
            aphaMap.put(i+1, (char)(i+'A'));
        }
        StringBuilder sb = new StringBuilder();
        if(columnNumber <=26) {
            sb.append(aphaMap.get(columnNumber));
        }
        while (columnNumber >= 27) {
            int mod = columnNumber%26;
            columnNumber = columnNumber/26;
             if(mod ==0) {
                 columnNumber--; // this is needed because the AA starts after A, B, C..... Z
             }
            sb.append(aphaMap.get(mod));
             if(columnNumber <= 26) {
                 sb.append(aphaMap.get(columnNumber));
             }
        }
        return sb.reverse().toString();
    }
}
