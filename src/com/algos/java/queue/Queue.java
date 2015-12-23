package com.algos.java.queue;

import java.util.NoSuchElementException;

public class Queue<T> {

	private Node<T> front;
	private Node<T> back;

	public static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	public Queue() {
		this.front = null;
		this.back = null;
	}

	public boolean isEmpty() {
		if (front == null && back == null) {
			return true;
		} else {
			return false;
		}
	}

	public Node<T> getFront() {
		return front;
	}

	public Node<T> getBack() {
		return back;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Node<T> temp = front;
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

	public void enqueue(T data) {
		Node<T> temp = new Node<T>(data);
		if (isEmpty()) {
			front = temp;
			back = temp;
		} else {
			back.next = temp;
			back = temp;
		}
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<T> temp = getFront();
			front = front.next;
			return temp.data;
		}
	}

	public static void main(String[] args) {

		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		System.out.println(queue.toString());
	}

}
