package com.algos.java.stack;

import java.util.Scanner;

public class BalancingParenthesis {

	public boolean checkBalancing(String input) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < input.length(); i++) {
			switch (input.charAt(i)) {
			case '{':
				stack.push('{');
				break;

			case '[':
				stack.push('[');
				break;

			case '(':
				stack.push('(');
				break;

			case '}':
				if (!stack.isEmpty()) {
					if (stack.pop() == '{') {
						continue;
					} else {
						return false;
					}
				}else{
					return false;
				}

			case ']':
				if (!stack.isEmpty()) {
					if (stack.pop() == '[') {
						continue;
					} else {
						return false;
					}
				}else{
					return false;
				}
			

			case ')':
				if (!stack.isEmpty()) {
					if (stack.pop() == '(') {
						continue;
					} else {
						return false;
					}
				}
				else{
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the string to check for balancing:" + "\n");
		BalancingParenthesis b = new BalancingParenthesis();
		if (b.checkBalancing(s.next())) {
			System.out.println("String is balanced");
		} else {
			System.out.println("String is not balanced");
		}
	}

}
