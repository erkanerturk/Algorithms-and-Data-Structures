package com.erkanerturk.datastructures.stack;

import java.util.EmptyStackException;

public class StackLinkedList<T> {

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

	private Node<T> topNode;
	private int size;

	public StackLinkedList() {
		this.topNode = null;
		size = 0;
	}

	public void push(T data) {
		topNode = new Node<T>(data, topNode);
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T deletedValue = topNode.data;
		topNode = topNode.next;
		size--;
		return deletedValue;
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return topNode.data;
	}

	public boolean isEmpty() {
		return topNode == null;
	}

	public int getSize() {
		return size;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("The stack is empty");
		} else {
			Node<T> currentNode = topNode;
			while (currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}
}
