package com.erkanerturk.datastructures.queue;
import java.util.NoSuchElementException;

public class QueueArray<T> {

	private final static int DEFAULT_CAPACITY = 10;
	private int lastIndex, capacity;
	private T[] queueArray;

	public QueueArray() {
		this(DEFAULT_CAPACITY);
	}

	public QueueArray(int capacity) {
		this.capacity = capacity;
		queueArray = (T[]) new Object[capacity];
		lastIndex = -1;
	}

	public void enqueue(T data) {
		checkArray();
		queueArray[++lastIndex] = data;
	}

	public T dequeue() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}

		checkArray();

		T deletedValue = queueArray[0];
		for (int i = 0; i < lastIndex; i++) {
			queueArray[i] = queueArray[i + 1];
		}
		queueArray[lastIndex] = null;
		lastIndex--;
		return deletedValue;
	}

	// remove the head of this queue or return null if this queue is empty
	public T pool() {
		return getSize() == 0 ? null : dequeue();
	}

	public T peek() {
		return getSize() == 0 ? null : queueArray[0];
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public int getSize() {
		return lastIndex + 1;
	}

	private void ensureCapacity(int newCapacity) {
		capacity = newCapacity;
		T[] newQueueArray = (T[]) new Object[capacity];

		for (int i = 0; i <= lastIndex; i++) {
			newQueueArray[i] = queueArray[i];
		}
		queueArray = newQueueArray;
	}

	private void checkArray() {
		if (lastIndex >= capacity - 1) {
			ensureCapacity(capacity * 2);
		} else if (lastIndex + 1 < capacity / 2) {
			ensureCapacity(capacity / 2);
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("The queue is empty");
		} else {
			for (int i = 0; i <= lastIndex; i++) {
				System.out.println(queueArray[i]);
			}
		}
	}
}
