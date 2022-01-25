package coding.stackproblems;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPrefix {

	public static void main(String[] args) {
		
		String s = "(a-b/c)*(a/k-l)"; 
		
		System.out.println("Infix to prefix: " + infixToPrefix(s));
		
	}
	
	private static String infixToPrefix(String exp) {
		
		//reverse the exp
		//get the postfix of the reversed exp, not open and closed parenthesis order is also reversed
		//reverse the postfix expresion
		
		
		//reversing
		String exprev = reverseString(exp);
	
		
//>>>>>>>>>>> either below changes or change in the order of checking while converting to postfix
		
		//adjusting the paranthesis
		char[] revArray = exprev.toCharArray();
		
		// Replace ( with ) and vice versa 
	    for (int i = 0; i < revArray.length; i++) { 
	  
	        if (revArray[i] == '(') { 
	        	revArray[i] = ')'; 
	            i++; 
	        } 
	        else if (revArray[i] == ')') { 
	        	revArray[i] = '('; 
	            i++; 
	        } 
	    } 
   exprev = new String(revArray);
		
		
		System.out.println("reversed string: " + exprev);
		
		
		//getting the post fix of the reverse string
		String postfix = infixToPostfix(exprev);
		
		//revesing the postfix
		
		String prefix = reverseString(postfix);
		return prefix;
	}

	private static String reverseString(String exp) {
		
		String rev= "";
		for (int i = exp.length()-1; i >= 0; i--) {
			rev+=exp.charAt(i);
		}
		return rev;
	}

	private static String infixToPostfix(String exp) {
		Stack<Character> stack = new Stack<>();
		String result = "";
		
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if(!isOperator(ch)) {
				result+=ch;
			} else if(ch == '(' ||  stack.isEmpty())  {
				stack.push(ch);
			} else if(ch == ')') {
				
				while(!stack.isEmpty() && stack.peek()!= '(') {
					result+=stack.pop();
				}
				stack.pop();
			} else if((precedence(ch) >  precedence(stack.peek())) ||  ch == '^') {
				stack.push(ch);
			} else {
				
				while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
					result+=stack.pop();
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) {
			result+=stack.pop();
		}
	
		System.out.println("Infix To Postfix: " + result);
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
