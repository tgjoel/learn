package coding.stackproblems;

import java.util.Arrays;
import java.util.Stack;

public class PrefixPostfixInfixConversions {

	public static void main(String[] args) {
		//  *+AB-CD : ((A+B)*(C-D))
		//  *-A/BC-/AKL: ((A-(B/C))*((A/K)-L)) 
		
//		String s1 = "*+AB-CD";
//		System.out.println("Prefix String: " + s1);
//		prefixToInfix(s1);
//		String c1 = prefixToPostFix(s1);
//		postfixToPrefix(c1);
//		
//		
//		String s2 = "*-A/BC-/AKL";
//		System.out.println("Prefix String: " + s2);
//		prefixToInfix(s2);
//		String c2 = prefixToPostFix(s2);
//		postfixToPrefix(c2);
		
		String q1 = "abcd^e-fgh*+^*+i-";
		postfixToInfix(q1);
		String q2 = "KL+MN*-OP^W*U/V/T*+Q+";
		postfixToInfix(q2);
		
	}

	private static void prefixToInfix(String s1) {
		
		Stack<String> stack = new Stack<>();
		
		//read from right to left
		for (int i = s1.length()-1; i >= 0; i--) {
			
			char ch = s1.charAt(i);
			//if its an operator popping out two operands from the stack and appending the operator in between 
			// --->>>>>> string = operand1 + operator + operand2  <<<<<<--------
			// and pushing the into the stack
			if(isOperator(ch)) {
				
				String op1 = stack.pop();
				String op2 = stack.pop();
				
				String tmp = '(' + op1 + ch + op2 + ')';
				stack.push(tmp);
			} else {
				//if its an operand pushing to the stack
				stack.push(ch + "");
			}
			//repeating this till the end of the expression
			
		}
		
		System.out.println("Prefix to Infix: " + stack.pop());
		
	}
	
	
	private static String prefixToPostFix(String string) {
		Stack<String> stack = new Stack<>();
		
		//reading expression in reverse order
		for (int i = string.length()-1; i >=0; i--) {
			
			char ch = string.charAt(i);
			
			//if its an operator popping out two operands from the stack and appending the operator in between 
			// --->>>>>> string = operand1 + operand2 + operator <<<<<<--------
			// and pushing the into the stack
			if(isOperator(ch)) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String tmp = op1 + op2 + ch;
				stack.push(tmp);
			} else {
				stack.push(ch + "");
			}
		}
		System.out.println("Prefix to Postfix: " + stack.peek());
		return stack.peek();
		
	}
	
	private static void postfixToPrefix(String st) {
		Stack<String> stack = new Stack<>();
		
		//reading expression in natural order
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			//if its an operator popping out two operands from the stack and appending the operator in between 
			// --->>>>>> string = operator +  operand2 + operand1 <<<<<<---
			// and pushing the into the stack
			if(isOperator(ch)) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String tmp = ch + op2 + op1;
				stack.push(tmp);
			} else {
				stack.push(ch + "");
			}
		}
		
		
		// concatenate all strings in stack
		String ans = "";
        for (String i : stack)
            ans += i;
    
		System.out.println("Postfix to Prefix: " + ans);
		
	}
	
	private static void postfixToInfix(String st) {
		Stack<String> stack = new Stack<>();
		
		//reading expression in natural order
		for (int i = 0; i < st.length(); i++) {
			
			char ch = st.charAt(i);
			//if its an operator popping out two operands from the stack and appending the operator in between 
			// --->>>>>> string = operand2 + operator +  operand1 <<<<<<---
			// and pushing the into the stack
			if(isOperator(ch)) {
				String op1 = stack.pop();
				String op2 = stack.pop();
				String tmp =  '(' + op2 + ch + op1 + ')';
				stack.push(tmp);
			} else {
				stack.push(ch + "");
			}
		}
		System.out.println("Postfix to Infix: " + stack.peek());
		
	}
	
	private static boolean isOperator(char c) {
		return Arrays.asList('+', '-' , '/','*','^').stream().anyMatch(ch -> ch.equals(c));
	}

}
