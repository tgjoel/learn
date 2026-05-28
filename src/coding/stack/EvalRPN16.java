package coding.stack;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class EvalRPN16 {
    static void main() {
        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}; // ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(token.equals("*") || token.equals("/") || token.equals("+") || token.equals("-")) {
                if(!stack.isEmpty()) {
                    int first = stack.pop();
                    int second = stack.pop();
                    int calculated = processToken(first, second, token);
                    stack.push(calculated);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }

        }
        return stack.pop();
    }

    private static int processToken(int first, int second, String token) {
        return switch (token) {
            case "*" -> second * first;
            case "/" -> second / first;
            case "+" -> second + first;
            case "-" -> second - first;
            default -> 0;
        };
    }
}
