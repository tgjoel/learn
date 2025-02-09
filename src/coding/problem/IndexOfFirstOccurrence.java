package coding.problem;

public class IndexOfFirstOccurrence {
    public static void main( String[] args ) {
    //String haystack = "mississippi", needle = "issip";
    String haystack = "lmississippi", needle = "issipi";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        int index = -1;
        if(needle.length() > haystack.length()) {
            return index;
        }
        for(int i =0, j =0; i< haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                if(index ==-1) {
                    index = i; // getting the first index
                }
                j++;
            } else {
                index = -1;
                i= i-j; // index should start from the previous , the point till both needle and hay was same
                j=0;  // when needle is not fully fond start from the beginning
            }
            if(j==needle.length()) {
                return index;
            }
        }

        return -1;
    }


    public static int strStr1(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        int nIndex = 0;
        for(int i=0; i<hLen; i++){
            // as long as the characters are equal, increment needleIndex
            if(haystack.charAt(i)==needle.charAt(nIndex)){
                nIndex++;
            }
            else{
                // start from the next index of previous start index
                i=i-nIndex;
                // needle should start from index 0
                nIndex=0;
            }
            // check if needleIndex reached needle length
            if(nIndex==nLen){
                // return the first index
                return i-nLen+1;
            }
        }
        return -1;
    }
}
