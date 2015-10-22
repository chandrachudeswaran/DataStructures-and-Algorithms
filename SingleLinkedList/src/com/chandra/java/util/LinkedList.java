package com.chandra.java.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {

	private Node<T> head;

	public LinkedList() {
		head = null;
	}

	private static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	public boolean add(T element) {
		Node<T> tmp = head;
		if (isEmpty()) {
			head = new Node<T>(element, head);
			return true;
		} else {
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new Node<T>(element, null);
			return true;
		}
	}

	public void add(int index, T element) {
		Node<T> tmp = head;
		if (isEmpty() || index < 0 || index > size()) {
			throw new NoSuchElementException();
		} else if (index == 0) {
			head = new Node<T>(element, head);
		} else {
			int count = 1;
			while (tmp.next != null) {
				Node<T> previous = tmp;
				tmp = tmp.next;
				if (count == index) {
					Node<T> tmp1 = new Node<T>(element, null);
					previous.next = tmp1;
					tmp1.next = tmp;
				}
				count++;
			}
		}
	}

	public void addFirst(T element) {
		head = new Node<T>(element, head);
	}

	public void addLast(T element) {
		Node<T> tmp = head;
		if (isEmpty()) {
			addFirst(element);
		} else {
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			tmp.next = new Node<T>(element, null);
		}
	}

	public void insertAfter(T key, T element) {
		Node<T> tmp = head;
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			while (tmp.next != null) {
				if (key.equals(tmp.data)) {
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
		} else if (head.data == key) {
			addFirst(element);
		} else {
			while (tmp.next != null) {
				Node<T> previous = tmp;
				tmp = tmp.next;
				if (key.equals(tmp.data)) {
					previous.next = new Node<T>(element, tmp);
				}

			}
		}
	}

	public void clear() {
		head = null;
	}

	public boolean contains(T element) {
		Node<T> tmp = head;
		if (isEmpty()) {
			return false;
		} else {
			while (tmp.next != null) {
				if (tmp.data.equals(element)) {
					return true;
				}
				tmp = tmp.next;
			}
			return false;
		}
	}

	public T get(int index) {
		Node<T> tmp = head;
		int count = 0;
		if (isEmpty() || index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			while (tmp.next != null) {
				if (count == index) {
					return tmp.data;
				}
				count++;
				tmp = tmp.next;
			}
			return tmp.data;
		}
	}

	public T getFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			return head.data;
		}
	}

	public T getLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<T> tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			}
			return tmp.data;
		}
	}

	public T remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			T element = head.data;
			head = head.next;
			return element;
		}
	}

	public boolean remove(T element) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<T> tmp = head;
			while (tmp.next != null) {
				Node<T> previous = tmp.next;
				tmp = tmp.next;
				if (tmp.data.equals(element)) {
					previous.next = tmp.next;
					return true;
				}
			}
			return false;
		}
	}

	public boolean remove(int index) {
		if (isEmpty() || index < 0 || index > size()) {
			throw new NoSuchElementException();
		} else {
			Node<T> tmp = head;
			if (index == 0) {
				head = head.next;
			} else {
				int count = 1;
				while (tmp.next != null) {
					Node<T> previous = tmp;
					tmp = tmp.next;
					if (count == index) {
						previous.next = tmp.next;
						return true;
					}
					count++;
				}
			}
			return false;
		}
	}

	public T removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			T data = head.data;
			head = head.next;
			return data;
		}
	}

	public T removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			Node<T> tmp = head;
			Node<T> previous = head;
			while (tmp.next != null) {
				previous = tmp;
				tmp = tmp.next;
			}
			T data = tmp.data;
			previous.next = tmp.next;
			return data;
		}
	}

	public int size() {
		Node<T> tmp = head;
		if (isEmpty()) {
			return 0;
		} else {
			int size = 1;
			while (tmp.next != null) {
				tmp = tmp.next;
				size++;
			}
			return size;
		}
	}

	public T set(int index, T element) {
		if (isEmpty() || index < 0 || index > size()) {
			throw new NoSuchElementException();
		} else {
			Node<T> tmp = head;
			int count = 0;
			T data = null;
			while (tmp.next != null) {
				if (count == index) {
					data = tmp.data;
					tmp.data = element;
				}
				count++;
				tmp = tmp.next;
			}
			return data;
		}
	}

	public boolean isEmpty() {
		return head == null;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node<T> tmp = head;
		sb.append("[");
		if (tmp != null) {
			while (tmp.next != null) {
				sb.append(tmp.data);
				sb.append(",");
				tmp = tmp.next;
			}
			sb.append(tmp.data);
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<T> {

		private Node<T> nodeNext;

		public LinkedListIterator() {
			this.nodeNext = head;
		}

		@Override
		public boolean hasNext() {
			return nodeNext != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				T data = nodeNext.data;
				nodeNext = nodeNext.next;
				return data;
			}
		}

		@Override
		public void remove() {
		}

	}

}
