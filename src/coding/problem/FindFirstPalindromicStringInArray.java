package problem;

public class FindFirstPalindromicStringInArray {
    public static void main( String[] args ) {

       // String[] words = {"abc","car","adaa","racecar1","cool"};
        String[] words = {"xngla","e","itrn","y","s","pfp","rfd"};
        System.out.println(firstPalindrome(words));
    }
    public static String firstPalindrome(String[] words) {
        boolean flag = false;
        for (int i = 0; i<words.length;i++) {
            String word = words[i];
            if(word.length() ==1) {
                return word;
            }
            for (int j =0, k = word.length()-1; j< word.length()/2;j++,k--) {
                if(word.charAt(j) != word.charAt(k)) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if(flag) {
                return word;
            }
        }
        return  "";
    }
}
