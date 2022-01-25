package coding.stackproblems;

import java.util.Stack;

public class BalanceExpression {

	public static void main(String[] args) {

		String exp1 = "[()]{}{[()()]()}";
		String exp2 = "[(){])";

		isBalanced(exp1);
		isBalanced(exp2);

	}

	private static void isBalanced(String exp) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {

			char ch = exp.charAt(i);

			// if its opening brackets the pushing to the stack
			if (ch == '{' || ch == '[' || ch == '(') {
				stack.push(ch);
			} else {
				// then its a closing bracket

				if (stack.isEmpty()) {
					System.out.println("Not balanced");
					return;
				}

				if (ch == '}' && stack.pop() != '{') {
					System.out.println("Not balanced");
					return;
				}

				if (ch == ']' && stack.pop() != '[') {
					System.out.println("Not balanced");
					return;
				}

				if (ch == ')' && stack.pop() != '(') {
					System.out.println("Not balanced");
					return;
				}

			}

		}

		if (!stack.isEmpty()) {
			System.out.println("Not balanced");
			return;
		}
		System.out.println("Balanced");

	}

}
