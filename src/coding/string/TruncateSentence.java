package coding.string;

//1816. Truncate Sentence
/*
Input: s = "Hello how are you Contestant", k = 4
Output: "Hello how are you"
*/
public class TruncateSentence {
    public static void main( String[] args ) {
        problem1();

        detectCapitalUse("USA");


    }

    public static boolean detectCapitalUse(String word) {
        int captialCount = 0;
        int smallCount = 0;
        for(int i = 0; i< word.length(); i++) {
            char c = word.charAt(i);
            if('a' <= c  && c <= 'z') {
                smallCount++;
            } else {
                captialCount++;
            }
        }

        if(captialCount == word.length() || smallCount == word.length()) {
            return true;
        }
        if(captialCount == 1 && ('A'<= word.charAt(0) && word.charAt(0) <= 'Z' )) return true;

        return false;
    }

    private static void problem1() {
        String s = "chopper is not a tanuki";
        int k = 5;
        int i = 0;
        for(; i <s.length() && k > 0;i++) {
            if(s.charAt(i) == ' ') k--;
        }
        System.out.println(k == 0  ? s.substring(0, i-1) : s);
    }
}
