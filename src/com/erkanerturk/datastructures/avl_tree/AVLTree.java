package com.erkanerturk.datastructures.avl_tree;
public class AVLTree<T extends Comparable<T>> {

	private static class Node<T> {
		private T data;
		private int height;
		private Node<T> left, right;

		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
			height = 0;
		}
	}

	private Node<T> root;

	public AVLTree() {
		root = null;
	}

	public AVLTree(T data) {
		this.root = new Node<T>(data);
	}

	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> node, T data) {
		if (node == null) {
			return new Node<T>(data);
		}
		if (data.compareTo(node.data) < 0) {
			node.left = insert(node.left, data);
		}
		if (data.compareTo(node.data) > 0) {
			node.right = insert(node.right, data);
		}
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		node = settleViolation(node, data);
		return node;
	}

	public boolean find(T data) {
		return root == null ? false : find(root, data);
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

	private Node<T> settleViolation(Node<T> node, T data) {
		int balance = getBalance(node);

		// Left-left
		if (balance > 1 && data.compareTo(node.left.data) < 0) {
			return rightRotation(node);
		}

		// Right-Right
		if (balance < -1 && data.compareTo(node.right.data) > 0) {
			return leftRotation(node);
		}

		// Left-Right
		if (balance > 1 && data.compareTo(node.right.data) > 0) {
			node.left = leftRotation(node.left);
			return rightRotation(node);
		}

		// Right-Left
		if (balance < -1 && data.compareTo(node.right.data) < 0) {
			node.right = rightRotation(node.right);
			return leftRotation(node);
		}

		return node;
	}

	private Node<T> leftRotation(Node<T> node) {
		System.out.println("Sol: " + node.data);
		Node<T> tempRightNode = node.right;
		node.right = tempRightNode.left;
		tempRightNode.left = node;

		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		tempRightNode.height = 1 + Math.max(getHeight(tempRightNode.left), getHeight(tempRightNode.right));

		return tempRightNode;
	}

	private Node<T> rightRotation(Node<T> node) {
		System.out.println("Sað: " + node.data);
		Node<T> tempLeftNode = node.left;
		node.left = tempLeftNode.right;
		tempLeftNode.right = node;

		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		tempLeftNode.height = 1 + Math.max(getHeight(tempLeftNode.left), getHeight(tempLeftNode.right));

		return tempLeftNode;
	}

	private int getBalance(Node<T> node) {
		if (root == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	private int getHeight(Node<T> node) {
		return node == null ? -1 : node.height;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void traverse() {
		if (root == null) {
			System.out.println("Empty");
		} else {
			inOrderTraversal(root);
		}
	}

	private void inOrderTraversal(Node<T> node) {
		if (node.left != null) {
			inOrderTraversal(node.left);
		}
		System.out.print(node.data + " ");
		if (node.right != null) {
			inOrderTraversal(node.right);

		}
	}
}
