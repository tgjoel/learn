package coding.binarysearch;

//LC 744. Find Smallest Letter Greater Than Target
public class FindSmallestLetterGreaterThanTarget {
    public static void main( String[] args ) {
        char[] str = {'c','f','j'};
        char target1= 'c'; // expected f
        char target2= 'j'; // expected c --- the first in the array
        System.out.println(nextGreatestLetter(str, target1));
        System.out.println(nextGreatestLetter(str, target2));

    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length -1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if(target >= letters[mid]) {
                start = mid +1;
            } else {
                end = mid-1;
            }
        }
//        if(start >= letters.length) {
//            return letters[0];
//        } else {
//            return letters[start];
//        }

        return letters[start % letters.length];
    }
}
