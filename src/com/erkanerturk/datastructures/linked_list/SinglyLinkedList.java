package com.erkanerturk.datastructures.linked_list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

	private static class Node<T> {
		private T data;
		private Node<T> next;

		private Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private Node<T> headNode;

	public SinglyLinkedList() {
		headNode = null;
	}

	public void append(T data) {
		if (headNode == null) {
			headNode = new Node<T>(data, null);
		} else {
			Node<T> currentNode = headNode;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = new Node<T>(data, null);
		}
	}

	public void prepand(T data) {
		Node<T> newNode = new Node<T>(data, headNode);
		headNode = newNode;
	}

	public void add(T data, int index) {
		if (index < 0 || index > getSizeOfList()) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		if (index == 0) {
			prepand(data);
		} else if (index == getSizeOfList()) {
			append(data);
		} else {
			Node<T> currentNode = headNode;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			Node<T> newNode = new Node<T>(data, currentNode.next);
			currentNode.next = newNode;
		}
	}

	public T deleteFirst() {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}

		T deletedData = headNode.data;
		headNode = headNode.next;
		return deletedData;
	}

	public T deleteLast() {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}

		T deletedData;
		if (headNode.next == null) {
			deletedData = headNode.data;
			headNode = null;
		} else {
			Node<T> currentNode = headNode;
			while (currentNode.next.next != null) {
				currentNode = currentNode.next;
			}
			deletedData = currentNode.next.data;
			currentNode.next = null;
		}
		return deletedData;
	}

	public T deleteWithValue(T data) {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}

		T deletedData = null;
		if (headNode.data.equals(data)) {
			deletedData = headNode.data;
			headNode = headNode.next;
		} else {
			Node<T> currentNode = headNode;
			while (currentNode.next != null) {
				if (currentNode.next.data.equals(data)) {
					deletedData = currentNode.next.data;
					currentNode.next = currentNode.next.next;
				}
				currentNode = currentNode.next;
			}
		}
		return deletedData;
	}

	public T delete(int index) {
		if (index < 0 || index >= getSizeOfList()) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		if (index == 0) {
			return deleteFirst();
		} else {
			Node<T> currentNode = headNode;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			T deletedData = currentNode.next.data;
			currentNode.next = currentNode.next.next;
			return deletedData;
		}
	}

	public T getFirst() {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}
		return headNode.data;
	}

	public T getLast() {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}

		Node<T> currentNode = headNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	public Node<T> getNode(int index) {
		if (index < 0 || index >= getSizeOfList()) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		Node<T> currentNode = headNode;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	public void display() {
		Node<T> currentNode = headNode;
		while (currentNode != null) {
			System.out.println(currentNode.toString());
			currentNode = currentNode.next;
		}
	}

	public int getSizeOfList() {
		int sizeOfList = 0;
		Node<T> currentNode = headNode;
		while (currentNode != null) {
			sizeOfList++;
			currentNode = currentNode.next;
		}
		return sizeOfList;
	}

	public void clear() {
		Node<T> currentNode = headNode;
		while (currentNode != null) {
			Node<T> nextNode = currentNode;
			currentNode.data = null;
			currentNode.next = null;
			currentNode = nextNode;
		}
		headNode = null;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[ ");
		Node<T> currentNode = headNode;
		while (currentNode.next != null) {
			stringBuilder.append(currentNode.data + ", ");
			currentNode = currentNode.next;
		}
		stringBuilder.append(" ]");
		return stringBuilder.toString();
	}
}