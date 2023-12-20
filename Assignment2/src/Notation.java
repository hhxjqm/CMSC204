/*
	 * Class: CMSC204
	 * Program: Assignment 2
	 *  Instructor: Khandan Monshi
	 * Description: ()
	 * Due: 10/2/2020 
	 * I pledge that I have completed the programming assignment independently.
	   I have not copied the code from a student or any source.
	   I have not given my code to any student.
	   Print your Name here: Huan Shiuan Huang
*/


/**
 * 
 * @author Huan Shiuan Huang
 *
 */
public class Notation {

	public static String operator = "+-*/";

	/**
	 * Evaluates a postfix expression from a string to a double
	 * 
	 * @param postfixExpr - the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException {
		NotationStack<String> stack = new NotationStack<>(postfixExpr.length());

		double result = 0;

		// check every character in the String
		for (int i = 0; i < postfixExpr.length(); i++) {
			String c = String.valueOf(postfixExpr.charAt(i));

			// ignore space character
			if (postfixExpr.charAt(i) == ' ')
				continue;

			// When the character is digit
			try {
				if (Character.isDigit(postfixExpr.charAt(i)) || postfixExpr.charAt(i) == '(')
					stack.push(c);
			} catch (StackOverflowException e) {
				System.out.println(e.getMessage());
			}

			// When the character is operator
			try {
				if (operator.contains(c)) {
					if (stack.size() < 2)
						throw new InvalidNotationFormatException();
					double a = Double.parseDouble(stack.pop());
					double b = Double.parseDouble(stack.pop());
					double r;

					if (c.equals("+"))
						r = b + a;
					else if (c.equals("-"))
						r = b - a;
					else if (c.equals("*"))
						r = b * a;
					else
						r = b / a;
					stack.push(String.valueOf(r));
				}
			} catch (StackUnderflowException | StackOverflowException e) {
				System.out.println(e.getMessage());
			}
		}

		// Get the result from stack
		if (stack.size() > 1)
			throw new InvalidNotationFormatException();
		else {
			try {
				result = Double.parseDouble(stack.pop());
			} catch (StackUnderflowException e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

	/**
	 * Convert the Postfix expression to the Infix expression
	 * 
	 * @param postfix - the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix)
			throws InvalidNotationFormatException {
		NotationStack<String> stack = new NotationStack<>(postfix.length());

		String str = "";

		// check every character in the String
		for (int i = 0; i < postfix.length(); i++) {
			String c = String.valueOf(postfix.charAt(i));

			// Ignore the space character
			if (postfix.charAt(i) == ' ')
				continue;

			// When the character is digit
			try {
				if (Character.isDigit(postfix.charAt(i)))
					stack.push(c);
			} catch (StackOverflowException e) {
				System.out.println(e.getMessage());
			}

			// When the character is operator
			try {
				if (operator.contains(c)) {
					if (stack.size() < 2)
						throw new InvalidNotationFormatException();
					String result = "";
					result = c + stack.pop() + ")";
					result = "(" + stack.pop() + result;
					stack.push(result);
				}
			} catch (StackUnderflowException | StackOverflowException e) {
				System.out.println(e.getMessage());
			}
		}

		// Get the result from stack
		if (stack.size() > 1)
			throw new InvalidNotationFormatException();
		else {
			try {
				str = stack.pop();
			} catch (StackUnderflowException e) {
				System.out.println(e.getMessage());
			}
		}

		return str;
	}

	/**
	 * Convert an infix expression into a postfix expression
	 * 
	 * @param infix - the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException - if the infix expression format is invalid
	 */
	public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException {

		NotationStack<String> stack = new NotationStack<>(infix.length());
		NotationQueue<String> queue = new NotationQueue<>(infix.length());

		String str = "";

		// check every character in the String
		for (int i = 0; i < infix.length(); i++) {
			String c = String.valueOf(infix.charAt(i));

			// Give + - a low precedence and * / high precedence
			int precedence;
			if (infix.charAt(i) == '+' || infix.charAt(i) == '-')
				precedence = 1;
			else
				precedence = 2;

			// Ignore the space character
			if (infix.charAt(i) == ' ')
				continue;

			// When the character is digit
			try {
				if (Character.isDigit(infix.charAt(i)))
					queue.enqueue(c);
			} catch (QueueOverflowException e) {
				System.out.println("!!!!");
			}

			// When the character is left parenthesis
			try {
				if (infix.charAt(i) == '(')
					stack.push(c);
			} catch (StackOverflowException e) {
				System.out.println("!!!!");
			}

			// When the character is operator
			try {

				if (operator.contains(c)) {

					if (!stack.isEmpty()) {
						while (operator.contains(stack.top())) {

							int precedence1 = 0;
							if (stack.top().equals("+") || stack.top().equals("-"))
								precedence1 = 1;
							else
								precedence1 = 2;

							if (precedence < precedence1) {
								stack.push(c);
								break;
							} else
								queue.enqueue(stack.pop());
						}
					}

					stack.push(c);

				}

			} catch (QueueOverflowException | StackUnderflowException | StackOverflowException e) {
				System.out.println("!!!!");
			}

			// When the character is right parenthesis
			try {
				if (infix.charAt(i) == ')') {
					while (!stack.top().equals("(")) {

						queue.enqueue(stack.pop());

						if (stack.isEmpty())
							throw new InvalidNotationFormatException();
					}
					stack.pop();

				}
			} catch (StackUnderflowException | QueueOverflowException e) {
				System.out.println("!!!!");
			}

		}

		// Pop all remain operator in stack to solution queue.
		try {
			while (!stack.isEmpty())
				queue.enqueue(stack.pop());
		} catch (StackUnderflowException | QueueOverflowException e) {
			System.out.println("!!!!");
		}

		str = queue.toString();

		return str;
	}
}
