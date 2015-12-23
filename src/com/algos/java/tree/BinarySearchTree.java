package com.algos.java.tree;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> root;

	public BinarySearchTree() {
		root = null;
	}

	private static class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private int compare(T x, T y) {
		return x.compareTo(y);
	}

	public void insert(T data) {
		root = insertData(root, data);
	}

	private Node<T> insertData(Node<T> root, T data) {

		if (root == null) {
			return new Node<T>(data, null, null);
		} else if (compare(root.data, data) == 0) {
			return root;
		} else if (compare(data, root.data) < 0) {
			root.left = insertData(root.left, data);
		} else {
			root.right = insertData(root.right, data);
		}
		return root;
	}

	public boolean search(T data) {
		return searchElement(root, data);
	}

	private boolean searchElement(Node<T> root, T data) {

		if (root == null) {
			return false;
		} else {
			if (compare(data, root.data) == 0) {
				return true;
			}
			if (compare(data, root.data) < 0) {
				return searchElement(root.left, data);
			} else {
				return searchElement(root.right, data);
			}
		}
	}

	public void displayPreOrder() {
		displayPreOrderUtility(root);
	}

	private void displayPreOrderUtility(Node<T> root) {

		if (root != null) {
			System.out.println(root.data + "  ");
			displayPreOrderUtility(root.left);
			displayPreOrderUtility(root.right);
		}
	}

	public void displayInOrder() {
		displayInorderUtility(root);
	}

	private void displayInorderUtility(Node<T> root) {

		if (root != null) {
			displayInorderUtility(root.left);
			System.out.println(root.data);
			displayInorderUtility(root.right);
		}
	}

	public void displayPostOrder() {
		displayPostOrderUtility(root);
	}

	private void displayPostOrderUtility(Node<T> root) {

		if (root != null) {
			displayPostOrderUtility(root.left);
			displayPostOrderUtility(root.right);
			System.out.println(root.data);
		}
	}

	/*
	 * public void delete(T data) { root = deleteNodeFromTree(root, data); }
	 * 
	 * private Node<T> deleteNodeFromTree(Node<T> root,T data){
	 * 
	 * if(root==null){ throw new RuntimeException(); }else
	 * if(compare(data,root.data)<0){ root.left=deleteNodeFromTree(root.left,
	 * data); } else if(compare(data,root.data)>0){
	 * root.right=deleteNodeFromTree(root.right, data); }else if()
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return root; }
	 */

	public void delete(T toDelete) {
		root = delete(root, toDelete);
	}

	private Node<T> delete(Node<T> p, T toDelete) {
		if (p == null)
			throw new RuntimeException("cannot delete.");
		else if (compare(toDelete, p.data) < 0) {
			p.left = delete(p.left, toDelete);
		} else if (compare(toDelete, p.data) > 0) {
			p.right = delete(p.right, toDelete);
		} else {
			if (p.left == null) {
				return p.right;
			} else if (p.right == null)
				return p.left;
			else {
				// get data from the rightmost node in the left subtree
				p.data = retrieveData(p.left);
				// delete the rightmost node in the left subtree
				p.left = delete(p.left, p.data);
			}
		}
		return p;
	}

	private T retrieveData(Node<T> p) {
		while (p.right != null)
			p = p.right;

		return p.data;
	}

	public static void main(String[] args) {

		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		tree.insert(1);
		tree.insert(5);
		tree.insert(2);
		tree.insert(7);
		tree.insert(4);

		// tree.displayPreOrder();
		// tree.displayInOrder();

		// tree.displayPostOrder();

		tree.delete(4);
		// tree.displayPreOrder();

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
