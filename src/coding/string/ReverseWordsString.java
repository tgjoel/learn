package coding.string;


//151. Reverse Words in a String
public class ReverseWordsString {
    public static void main( String[] args ) {
        String s = " a good   example  ";
        System.out.println(reverseWords(s));
        System.out.println(reverseWords2(s));
    }
    
    
    public static String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();

        for(int start, end = s.length() - 1; end >=0;) {

            while(end >=0 && s.charAt(end) == ' ') {
                end--;  // removing all the trailing spaces
            }

            if(end < 0) {
                break; // the string was all spaces
            }

            start = end;
            while(start >=0 && s.charAt(start) != ' ') {
                start--; // getting the start of the work
            }

            if (sb.length() > 0) {
                sb.append(" "); // adding the space between the words
            }

            sb.append(s.substring(start + 1, end + 1)); /// +1 for end because substring is excluisve of end index
        /// +1 for start is beacuse of while loop reduced the start, then the condition failed. so need the state of start before it failed

            end = start;  // setting the end to start to process the next word
        }
        return sb.toString();
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
