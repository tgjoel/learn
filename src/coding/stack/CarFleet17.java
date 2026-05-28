package coding.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/// https://leetcode.com/problems/car-fleet/description/
public class CarFleet17 {

    static void main() {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleetWithStack(target, position, speed));
        System.out.println(carFleetWithArray(target, position, speed));
    }

    private static int carFleetWithStack(int target, int[] position, int[] speed) {
        double[][] positionTime = new double[position.length][2];

        for(int i = 0; i < position.length; i++) {
            positionTime[i][0] = position[i];
            positionTime[i][1] = (double) (target - position[i])/speed[i];
        }

        //sorting the position in ascending as per reaching to the target
        Arrays.sort(positionTime, Comparator.comparing(x -> x[0]));

        Stack<Double> stack = new Stack<>();
        for(int i = positionTime.length-1; i >=0; i--) {
            if(stack.isEmpty() || stack.peek() < positionTime[i][1]) {
                stack.push(positionTime[i][1]);
            }
        }
        return stack.size();
    }

    public static int carFleetWithArray(int target, int[] position, int[] speed) {

        // finding the time taken to reach the target from each position
        double[][] positionTime = new double[position.length][2];

        for(int i = 0; i < position.length; i++) {
            positionTime[i][0] = position[i];
            positionTime[i][1] = (double)(target - position[i])/speed[i];
        }

        //sorting the position in ascending as per reaching to the target
       Arrays.sort(positionTime, Comparator.comparing(x -> x[0]));

        // Cars reaching the same time will be in same fleet
        // the car in the behind reaching the target faster can join with the car in the ahead at shorter seep at some point

        ///using arrays

        int carFleets = 0;
        double maxtime = 0;
        for(int i = positionTime.length-1; i >= 0; i--) {
            double currTime = positionTime[i][1];
            if(currTime > maxtime){
                maxtime = currTime;
                carFleets = carFleets + 1;
            }
        }
        return carFleets;
    }
}
