import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
//		String exp = "15 7 1 1 + - / 3 * 2 1 1 + + -";
		
		String exp = "( ( 15 / ( 7 - ( 1 + 1 ) ) ) * 3 ) - ( 2 + ( 1 + 1 ) )";
		
		String [] expA = exp.split("\\s+");
		
		List<String> expL = new InfixToPostfix().infixToPostfix(exp);
		
		System.out.println(new InfixToPostfix().evaluatePostfix(expL));
	}

	public List<String> infixToPostfix(String exp) {
		List<String> res = new ArrayList<>();
		
		String [] expA = exp.split("\\s+");
		
		Stack<String> stack = new Stack<>();
		
		for(String str : expA) {
			if(str.equals("(")) {
				stack.push(str);
			} else if(str.equals(")")) {
				
				String peekS = stack.pop();
				while(!peekS.equals("(")) {
					res.add(peekS);
					peekS = stack.pop();
				}
				
			} else if(isOperator(str)) {
				if(!stack.isEmpty()) {
					String peekS = stack.peek();
					
					while(greaterPrecedence(str, peekS) && !peekS.equals("(")) {
						res.add(peekS);
						stack.pop();
						peekS = stack.peek();
					}
				}
				
				stack.push(str);
				
			} else {
				res.add(str);
			}
		}
		
		while(!stack.isEmpty()) {
			res.add(stack.pop());
		}
		
		return res;
	}
	
	private boolean greaterPrecedence(String first, String fromStack) {
		int firstP = getPrecedence(first.charAt(0));
		int seconfP = getPrecedence(fromStack.charAt(0));
		
		return seconfP >= firstP;
	}
	
	public float evaluatePostfix(List<String> exp) {
		
		Stack<String> stack = new Stack<>();
		
		for(String str : exp) {
			if( isOperator(str)) {
				float op2 = Float.parseFloat(stack.pop());
				float op1 = Float.parseFloat(stack.pop());
				
				float res = doOperation(op1, op2, str.charAt(0));
				
				stack.push(String.valueOf(res));
			} else {
				stack.push(str);
			}
		}
		
		return Float.parseFloat(stack.pop());
	}
	
	private boolean isOperator(String str) {
		if(str == null || str.isEmpty() || str.length() > 1) {
			return false;
		}
		char strCh = str.charAt(0);
		return strCh == '+' || strCh == '-' || strCh == '*' || strCh == '/';
	}
	
	private int getPrecedence(char operator) {
		int res = 0;

		switch (operator) {
		case '+':
			res = 0;
			break;
		case '-':
			res = 0;
			break;
		case '*':
			res = 1;
			break;
		case '/':
			res = 1;
			break;

		}

		return res;
	}

	private float doOperation(float operandOne, float operandTwo, char operator) {
		float res = 0;

		switch (operator) {
		case '+':
			res = operandOne + operandTwo;
			break;
		case '-':
			res = operandOne - operandTwo;
			break;
		case '*':
			res = operandOne * operandTwo;
			break;
		case '/':
			res = operandOne / operandTwo;
			break;

		}

		return res;
	}
}
