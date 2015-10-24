package com.chandra.java.util;

import java.util.NoSuchElementException;

public class CircularLinkedList<T> {

	private static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<T> head;

	public CircularLinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> tmp = head;
		sb.append("[");
		if (tmp != null) {
			while (tmp.next != head) {
				sb.append(tmp.data);
				sb.append(",");
				tmp = tmp.next;
			}
			sb.append(tmp.data);
		}
		sb.append("]");
		return sb.toString();
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			Node<T> tmp = head;
			int count = 1;
			while (tmp.next != head) {
				tmp = tmp.next;
				count++;
			}
			return count;
		}
	}

	public boolean add(T element) {
		if (isEmpty()) {
			head = new Node<T>(element, null);
			head.next = head;
			return true;
		} else {
			Node<T> tmp = head;
			while (tmp.next != head) {
				tmp = tmp.next;
			}
			tmp.next = new Node<T>(element, head);
			return true;
		}

	}

	public void add(int index, T element) {
		if (index < 0 || index > size()) {
			throw new NoSuchElementException();
		} else if (isEmpty() && (index > 0)) {
			throw new NoSuchElementException();
		} else if (isEmpty() && (index == 0)) {
			add(element);
		} else if (!isEmpty()) {
			if (index == 0) {
				addFirst(element);
			} else {
				int count=0;
				Node<T> tmp =head;
				while(tmp.next!=head){
					if(index==count){
						insertBefore(tmp.data, element);
					}
					count++;
					tmp=tmp.next;
				}
				if(index==size()){
					add(element);
				}
			}
		}
	}

	public void addFirst(T element) {
		Node<T> tmp = new Node<T>(element, head);
		Node<T> last = getLastPointer();
		last.next = tmp;
		head = tmp;
	}

	public void addLast(T element) {
		Node<T> tmp = new Node<T>(element, head);
		Node<T> last = getLastPointer();
		last.next = tmp;
	}

	public void insertAfter(T key, T element) {
		Node<T> tmp = head;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			while (tmp.next != head) {
				if (tmp.data.equals(key)) {
					tmp.next = new Node<T>(element, tmp.next);
				}
				tmp = tmp.next;
			}
		}
	}

	public void insertBefore(T key, T element) {
		Node<T> tmp = head;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<T> previous = tmp;
			while (tmp.next != head) {
				previous = tmp;
				tmp = tmp.next;
				if (tmp.data.equals(key)) {
					previous.next = new Node<T>(element, tmp);
				}
			}
		}
	}

	public void clear() {
		head = null;
	}

	private Node<T> getLastPointer() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<T> tmp = head;
			while (tmp.next != head) {
				tmp = tmp.next;
			}
			return tmp;
		}
	}



}
