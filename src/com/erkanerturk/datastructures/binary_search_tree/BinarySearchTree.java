package com.erkanerturk.datastructures.binary_search_tree;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> {

	private static class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private Node<T> root;
	private int size;

	public BinarySearchTree() {
		root = null;
		size = 0;
	}

	public BinarySearchTree(T data) {
		root = new Node<T>(data);
		size = 0;
	}

	// Add with loop
	public void insert(T data) {
		Node<T> iterator = root;
		Node<T> parentNode = null;

		while (iterator != null) {
			parentNode = iterator;
			if (data.compareTo(iterator.data) < 0) {
				iterator = iterator.left;
			} else if (data.compareTo(iterator.data) > 0) {
				iterator = iterator.right;
			} else {
				return;
			}
		}

		if (isEmpty()) {
			root = new Node<T>(data);
		} else if (data.compareTo(parentNode.data) < 0) {
			parentNode.left = new Node<T>(data);
		} else if (data.compareTo(parentNode.data) > 0) {
			parentNode.right = new Node<T>(data);
		}
		size++;
	}

	// Add with recursive function
	public void add(T data) {
		if (isEmpty()) {
			root = new Node<T>(data);
			size++;
		} else {
			add(root, data);
		}
	}

	private void add(Node<T> node, T data) {
		if (data.compareTo(node.data) < 0) {
			if (node.left == null) {
				node.left = new Node<T>(data);
				size++;
			} else {
				add(node.left, data);
			}
		} else if (data.compareTo(node.data) > 0) {
			if (node.right == null) {
				node.right = new Node<T>(data);
				size++;
			} else {
				add(node.right, data);
			}
		} else {
			return;
		}
	}

	// Search with loop
	public boolean search(T data) {
		Node<T> iterator = root;

		while (iterator != null) {
			if (iterator.data == data) {
				return true;
			} else if (data.compareTo(iterator.data) < 0) {
				iterator = iterator.left;
			} else if (data.compareTo(iterator.data) > 0) {
				iterator = iterator.right;
			}
		}
		return false;
	}

	// Search with recursive function
	public boolean find(T data) {
		if (isEmpty()) {
			return false;
		} else {
			return find(root, data);
		}
	}

	private boolean find(Node<T> node, T data) {
		if (node == null) {
			return false;
		}
		if (data.compareTo(node.data) < 0) {
			return find(node.left, data);
		}
		if (data.compareTo(node.data) > 0) {
			return find(node.right, data);
		}
		return true;
	}

	public boolean delete(T data) {
		if (isEmpty()) {
			throw new NoSuchElementException("Binary search tree is empty");
		}
		if (find(data)) {
			root = delete(root, data);
			return true;
		}
		return false;
	}

	private Node<T> delete(Node<T> node, T data) {
		if (node == null) {
			return null;
		}

		if (data.compareTo(node.data) < 0) {
			node.left = delete(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = delete(node.right, data);
		} else {
			if (node.left == null) {
				Node<T> rightChild = node.right;
				node.data = null;
				node = null;
				return rightChild;
			} else if (node.right == null) {
				Node<T> leftChild = node.left;
				node.data = null;
				node = null;
				return leftChild;
			} else {
				T newParent = findMin(root.right);
				node.data = newParent;
				node.right = delete(node.right, newParent);
			}
		}
		return node;
	}

	public T findMax() {
		if (isEmpty()) {
			throw new NoSuchElementException("Binary search tree is empty");
		}
		return findMax(root);
	}

	private T findMax(Node<T> node) {
		if (node.right == null) {
			return node.data;
		}
		return findMax(node.right);
	}

	public T findMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("Binary search tree is empty");
		}
		return findMin(root);
	}

	private T findMin(Node<T> node) {
		if (node.left == null) {
			return node.data;
		}
		return findMin(node.left);
	}

	public int getSize() {
		return size;
	}

	private int getSize(Node<T> node) {
		if (node == null) {
			return 0;
		}
		return getSize(node.left) + getSize(node.right) + 1;
	}

	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node<T> node) {
		if (node == null) {
			return -1;
		}
		return Integer.max(getHeight(node.left), getHeight(node.right)) + 1;
	}

	public T getSuccessor() {
		return findMin(root.right);
	}

	public T getPredecessor() {
		return findMax(root.left);
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}

	private boolean isBalanced(Node<T> node) {
		if (node == null) {
			return true;
		}

		int heightDiff = getHeight(node.left) - getHeight(node.right);

		if (heightDiff > 1 || heightDiff < -1) {
			return false;
		} else {
			// Is balance in the subtree ?
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void printPreOrder() {
		if (isEmpty()) {
			System.out.println("Binary search tree is empty");
		} else {
			printPreOrder(root);
		}
	}

	private void printPreOrder(Node<T> node) {
		System.out.print(node.data + " ");
		if (node.left != null) {
			printPreOrder(node.left);
		}
		if (node.right != null) {
			printPreOrder(node.right);
		}
	}

	public void printInOrder() {
		if (isEmpty()) {
			System.out.println("Binary search tree is empty");
		} else {
			printInOrder(root);
		}
	}

	private void printInOrder(Node<T> node) {
		if (node.left != null) {
			printInOrder(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			printInOrder(node.right);
		}
	}

	public void printPostOrder() {
		if (isEmpty()) {
			System.out.println("Binary search tree is empty");
		} else {
			printPostOrder(root);
		}
	}

	private void printPostOrder(Node<T> node) {
		if (node.left != null) {
			printPostOrder(node.left);
		}
		if (node.right != null) {
			printPostOrder(node.right);
		}
		System.out.print(node.data + " ");
	}
}
