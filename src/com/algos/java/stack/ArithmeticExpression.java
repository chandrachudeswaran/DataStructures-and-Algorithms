package com.algos.java.stack;

import java.util.Scanner;

public class ArithmeticExpression {

	public void parseExpression(String input) {
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> results = new Stack<Integer>();

		for (int i = 0; i < input.length(); i++) {
			boolean condition = true;
			char c = input.charAt(i);
			if (c == '{' || c == '[' || c == '(' || c == '+' || c == '-'
					|| c == '*' || c == '/') {
				stack.push(c);
			} else if (c == '}' || c == ']' || c == ')') {
				Character operand1 = null;
				Character operand2 = null;
				Character operator = null;
				int op1 = 0;
				int op2 = 0;
				if (!stack.isEmpty()) {
					do {
						Character pop = stack.pop();

						if (pop == '+' || pop == '-' || pop == '*'
								|| pop == '/') {
							operator = pop;
						} else if (pop == '{' || pop == '[' || pop == '(') {
							condition = false;
							if (operand1 == null) {
								op1 = results.pop();
							} else {
								op1 = Character.getNumericValue(operand1);
							}
							if (operand2 == null) {
								op2 = results.pop();
							} else {
								op2 = Character.getNumericValue(operand2);
							}
							int result = calculateValue(operator, op1, op2);
							if (stack.isEmpty()) {
								System.out.println("Result is : "+ result);
							} else {
								results.push(result);
							}
						} else {
							if (operand2 == null) {
								operand2 = pop;
							} else {
								operand1 = pop;
							}
						}
					} while (condition);
				}

			} else {
				stack.push(c);
			}

		}

	}

	public int calculateValue(Character operator, Integer op1, Integer op2) {
		switch (operator) {

		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 * op2;
		case '/':
			return op1 / op2;

		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArithmeticExpression a = new ArithmeticExpression();
		System.out.println("Enter Arithmetic expression");
		a.parseExpression(s.next());

	}

}
