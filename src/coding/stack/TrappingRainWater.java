package coding.stack;

//https://leetcode.com/problems/trapping-rain-water/description/
//Not a stack problem not related to the NGR/NGL or NSL/NSR even though looks like histogram
public class TrappingRainWater {

    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int arr1[] = {4, 2, 0, 3, 2, 5};

        System.out.println(trap(arr));
        System.out.println(trap(arr1));
    }

    private static int trap(int[] height) {

        //find max in the array to the right
        //find max in the left array
        //get the min of them
        //subtract the height of the building
        // sum up to the get the trapping volumes

        int[] maxLeftArr = new int[height.length];
        int maxLeft = height[0];
        for(int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft,height[i]);
            maxLeftArr[i] = maxLeft;
        }

        int[] maxRightArr = new int[height.length];
        int maxRight = height[height.length-1];
        for(int i = height.length-1; i>=0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            maxRightArr[i] = Math.max(maxRight, height[i]);
        }

        int sum = 0;
        for(int i = 0; i < height.length; i++) {
            sum += Math.min(maxLeftArr[i], maxRightArr[i]) - height[i];
        }
        return sum;
    }
}

