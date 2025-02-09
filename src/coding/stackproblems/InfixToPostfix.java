package coding.stackproblems;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {

		//a+b*(c^d-e)^(f+g*h)-i :  abcd^e-fgh*+^*+i- 
		// a+b-c+d-e : ab+c-d+e-
		// K+L-M*N+(O^P)*W/U/V*T+Q : KL+MN*-OP^W*U/V/T*+Q+
		String expresssion = "a+b*(c^d-e)^(f+g*h)-i";
		System.out.println(infixToPostFix(expresssion));
	}

	private static String infixToPostFix(String s) {
		Stack<Character> stack = new Stack<>();
		String result = "";

		for (int i = 0; i < s.length(); i++) {

			Character ch = s.charAt(i);

			if (!isOperator(ch)) {
				//if operator directly adding to the result
				result += ch;
			} else if(stack.isEmpty() || ch == '(') {
				// if opening bracket directly pushing to the stack  or if the stack is empty
				stack.push(ch);
			} else if(ch == ')') {
				// if closing bracket then needs to pop until opening bracket
				while(!stack.isEmpty() && stack.peek() != '(') {
					result+=stack.pop();
				}
				stack.pop(); // poping out the opening bracket
			} else if(precedence(ch) > precedence(stack.peek()) || ch =='^') {
				stack.push(ch);
			} else {
		
				// if the precedence is equal we need to pop out if the associativity is left to right.
				//among this only ^ have right to left associativity and this is handled above hence poping out anyway
				//if the precedence is less than the incoming poping out until the incoming is greater than or equal.
				while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
					result+=stack.pop();
				}
				
				stack.push(ch);
	
			}
			
		}
		
		while(!stack.isEmpty()) {
			result+=stack.pop();
		}

		return result;
	}

	private static boolean isOperator(Character c) {
		return Arrays.asList('+', '-', '*', '/', '^', '(', ')').stream().anyMatch(operator -> operator.equals(c));
	}

	private static int precedence(Character c) {
		switch (c) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;
		}
	}
}
