package com.erkanerturk.datastructures.queue;
import java.util.NoSuchElementException;

public class QueueLinkedList<T> {

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

	private Node<T> head, tail;
	private int size;

	public QueueLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public void enqueue(T data) {
		if (isEmpty()) {
			head = tail = new Node<T>(data, null);
		} else {
			Node<T> newNode = new Node<T>(data, null);
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public T dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}

		T deletedValue = head.data;
		head = head.next;
		size--;
		if (head == null) {
			tail = null;
		}
		return deletedValue;
	}

	// remove the head of this queue or return null if this queue is empty
	public T pool() {
		return getSize() == 0 ? null : dequeue();
	}

	public T peek() {
		return getSize() == 0 ? null : head.data;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public int getSize() {
		return size;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("The queue is empty");
		} else {
			Node<T> currentNode = head;
			while (currentNode != null) {
				System.out.println(currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}
}
