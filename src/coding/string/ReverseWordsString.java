package coding.string;


//151. Reverse Words in a String
public class ReverseWordsString {
    public static void main( String[] args ) {
        String s = " a good   example  ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords1( String s ) {
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static String reverseWords( String s ) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                int j = i;
                while(j >=0 && s.charAt(j) != ' ') {
                    j--;
                }
                sb.append(s, j+1, i+1).append(" ");
                i = j;
            }

        }

        return sb.substring(0, sb.length()-1);
    }
}
