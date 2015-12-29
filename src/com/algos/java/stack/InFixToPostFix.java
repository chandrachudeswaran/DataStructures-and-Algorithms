package com.algos.java.stack;

import java.util.Scanner;

public class InFixToPostFix {

	public String getPostFixExpression(String input) {
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<String>();
		
		for (int i = 0; i < input.length(); i++) {
			boolean condition=true;
			String c = String.valueOf(input.charAt(i));
			if (isOpeningParenthesis(c)) {
				stack.push(c);
			} else if (isOperand(c)) {
				sb.append(c);
			} 
			else if(isOperator(c)) {
				while (!stack.isEmpty() && hasHigherPrecedence(stack.peek(), c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
			else{
				switch(c){
				case ")":
					do{
						String data = stack.pop();
						if(data.equals("(")){
							condition=false;
						}else{
							sb.append(data);
						}
					}while(condition&&!stack.isEmpty());
					break;
				case "}":
					do{
						String data = stack.pop();
						if(data.equals("{")){
							condition=false;
						}else{
							sb.append(data);
						}
					}while(condition&&!stack.isEmpty());
					break;	
				case "]":
					do{
						String data = stack.pop();
						if(data.equals("[")){
							condition=false;
						}else{
							sb.append(data);
						}
					}while(condition&&!stack.isEmpty());
					break;
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the InFix Expression: ");
		InFixToPostFix expression = new InFixToPostFix();
		String input = s.next();
		String postfix= expression.getPostFixExpression(input);
		System.out.println("The postfix expression is : "+ " "+postfix);
		System.out.println("\n"+ "The result is :"+ " "+ expression.evaluatePostFixExpression(postfix));
		s.close();
	}

	public boolean isOperand(String c) {
		if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
			return false;
		} else if(isClosingParenthesis(c)){
			return false;	
		}else {
			return true;
		}
	}

	public boolean hasHigherPrecedence(String top, String currentString) {
		switch (top) {
		case "/":
			return true;
		case "*":
			return true;
		case "+":
			if (currentString.equals("*") || currentString.equals("/")) {
				return false;
			} else {
				return true;
			}
		case "-":
			if (currentString.equals("*") || currentString.equals("/")) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean isOpeningParenthesis(String currentString) {
		if (currentString.equals("(") || currentString.equals("{")
				|| currentString.equals("[")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOperator(String c) {
		if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isClosingParenthesis(String currentString) {
		if (currentString.equals(")") || currentString.equals("}")
				|| currentString.equals("]")) {
			return true;
		} else {
			return false;
		}
	}
	
	public int evaluatePostFixExpression(String input){
		
		Stack<String> expressionStack = new Stack<String>();
		
		for(int i=0;i<input.length();i++){
			String c = String.valueOf(input.charAt(i));
			if(!isOperator(c)){
				expressionStack.push(c);
			}else{
				String operand2= expressionStack.pop();
				String operand1= expressionStack.pop();
				String operator= c;
				expressionStack.push(String.valueOf(calculateValue(operator, operand1, operand2)));
			}
		}
		
		return Integer.valueOf(expressionStack.pop());
	}
	
	public int calculateValue(String operator,String operand1,String operand2){
		
		switch(operator){
		case "+":
			return Integer.valueOf(operand1)+Integer.valueOf(operand2);
		case "-":
			return Integer.valueOf(operand1)-Integer.valueOf(operand2);
		case "*":
			return Integer.valueOf(operand1)*Integer.valueOf(operand2);
		case "/":
			return Integer.valueOf(operand1)/Integer.valueOf(operand2);
			
		}
		return 0;
		
	}
}
