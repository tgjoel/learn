package coding.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/description/
public class DailyTemperatures15 {

    static void main() {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        Arrays.stream(dailyTemperatures(temperatures)).forEach(value -> System.out.print(value + " "));
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = temperatures.length-1; i>=0;i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
