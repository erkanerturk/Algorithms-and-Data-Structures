package com.erkanerturk.datastructures.linked_list;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

	private static class Node<T> {
		private T data;
		private Node<T> previous, next;

		private Node(T data, Node<T> previous, Node<T> next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	private Node<T> headNode;
	private Node<T> tailNode;

	public DoublyLinkedList() {
		headNode = null;
		tailNode = null;
	}

	public void append(T data) {
		if (headNode == null) {
			headNode = tailNode = new Node<T>(data, null, null);
		} else {
			Node<T> newNode = new Node<T>(data, tailNode, null);
			tailNode.next = newNode;
			tailNode = newNode;
		}
	}

	public void prepand(T data) {
		if (headNode == null) {
			headNode = tailNode = new Node<T>(data, null, null);
		} else {
			Node<T> newNode = new Node<T>(data, null, headNode);
			headNode.previous = newNode;
			headNode = newNode;
		}
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
			Node<T> newNode = new Node<T>(data, currentNode, currentNode.next);
			currentNode.next.previous = newNode;
			currentNode.next = newNode;
		}
	}

	public T deleteFirst() {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}

		T deletedData = headNode.data;
		headNode = headNode.next;

		if (headNode == null) {
			tailNode = null;
		} else {
			headNode.previous = null;
		}
		return deletedData;
	}

	public T deleteLast() {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}

		T deletedData = tailNode.data;
		tailNode = tailNode.previous;

		if (tailNode == null) {
			headNode = null;
		} else {
			tailNode.next = null;
		}
		return deletedData;
	}

	public boolean deleteWithValue(T data) {
		if (headNode == null) {
			throw new NoSuchElementException("List is empty");
		}

		if (headNode.data.equals(data)) {
			deleteFirst();
			return true;
		} else if (tailNode.data.equals(data)) {
			deleteLast();
			return true;
		}

		Node<T> currentNode = headNode;
		while (currentNode.next != null) {
			if (currentNode.next.data.equals(data)) {
				currentNode.next = currentNode.next.next;
				currentNode.next.previous = currentNode;
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	public T delete(int index) {
		if (index < 0 || index >= getSizeOfList()) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		if (index == 0) {
			return deleteFirst();
		} else if (index == getSizeOfList() - 1) {
			return deleteLast();
		} else {
			Node<T> currentNode = headNode;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			T deletedData = currentNode.next.data;
			currentNode.next.next.previous = currentNode;
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
		return tailNode.data;
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
			System.out.println(currentNode.data);
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
			currentNode.next = currentNode.previous = null;
			currentNode = nextNode;
		}
		headNode = tailNode = null;
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