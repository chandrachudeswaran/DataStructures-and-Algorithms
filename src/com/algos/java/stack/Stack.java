package com.algos.java.stack;

import java.util.NoSuchElementException;

public class Stack<T> {

	private Node<T> top;

	public Stack() {
		top = null;
	}

	public void push(T data) {
		Node<T> temp = new Node<T>(data);
		temp.next=top;
		top=temp;
	}

	public boolean isEmpty() {
		if (top == null) {
			return true;
		} else {
			return false;
		}
	}

	public T pop() {
		if (!isEmpty()) {
			T data = top.data;
			top = top.next;
			return data;
		} else {
			throw new NoSuchElementException();
		}
	}

	public T peek() {
		if (!isEmpty()) {
			return top.data;
		} else {
			throw new NoSuchElementException();
		}
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> temp = top;
		if (temp != null) {
			while (temp.next != null) {
				sb.append(temp.data);
				sb.append(",");
				temp = temp.next;
			}
			sb.append(temp.data);
			
		}
		sb.append("]");
		return sb.toString();

	}
	

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.toString());
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		System.out.println(stack.toString());

	}

}
