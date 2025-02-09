package coding.problem;

/*
11. Container With Most Water
 */
public class ContainerWithMostWater {
    public static void main( String[] args ) {
       // int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {1,1};
        System.out.println("Max area " + maxArea(height));
    }
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0, j = height.length-1; i < j;) {

            int minHeight = Math.min(height[i], height[j]);
            int length = j -i;
            max = Math.max(max, (minHeight * length));

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public void reverseString(char[] s) {
        for(int i =0, j = s.length-1; i< j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
