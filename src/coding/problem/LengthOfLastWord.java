package problem;

public class LengthOfLastWord {
    public static void main( String[] args ) {
        String s = "   fly me   to   the moon a ";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord2(s));
    }
    public static int lengthOfLastWord(String s) {
        int length =0;
        boolean flag = false;
        for(int i =s.length()-1; i>-1;i--) {
            if(s.charAt(i) != ' ') {
                length++;
                flag = true;
            }
            if(s.charAt(i) == ' ' && flag) {
                break;
            }
        }
        return length;
    }

    public static int lengthOfLastWord2(String s) {
        int length =0;
        for(int i =s.length()-1; i>-1;i--) {
            if(s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                break;
            }
        }
        return length;
    }
}
