package problem;

public class ValidPalindrome {
    public static void main( String[] args ) {
       // String s = "A man, a plan, a canal: Panama";
        String s = "9,8";
        //"amanaplanacanalpanama" is a palindrome. after removing all the alphanumeric and converting to small letters
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();
        int dif = 'a' -'A';
        for (int i = 0; i< s.length();i++) {
            if(s.charAt(i) >= 'A' && s.charAt(i) <='Z') {
                char cha = (char) (s.charAt(i) + dif);
                sb.append(cha);
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <='z') {
                sb.append(s.charAt(i));
            }
        }

        String pal = sb.toString();
       for (int i = 0, j = sb.length()-1; i< sb.length()/2;i++,j--) {
           if(pal.charAt(i)!=pal.charAt(j)) {
               return false;
           }
       }
    return true;

    }
}
