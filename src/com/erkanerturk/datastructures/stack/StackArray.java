package com.erkanerturk.datastructures.stack;

import java.util.EmptyStackException;

public class StackArray<T> {

	int capacity;
	private T[] stackArray;
	private int topIndex;

	public StackArray(int capacity) {
		this.capacity = capacity;
		this.stackArray = (T[]) new Object[capacity];
		this.topIndex = -1;
	}

	public void push(T data) {
		checkArray();
		stackArray[++topIndex] = data;
	}

	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		checkArray();
		return stackArray[topIndex--];
	}

	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stackArray[topIndex];
	}

	public boolean isFull() {
		return (topIndex == capacity - 1);
	}

	public boolean isEmpty() {
		return topIndex == -1;
	}

	private void ensureCapacity(int newCapacity) {
		this.capacity = newCapacity;
		T[] newStackArray = (T[]) new Object[capacity];

		for (int i = 0; i <= topIndex; i++) {
			newStackArray[i] = stackArray[i];
		}
		stackArray = newStackArray;
	}

	private void checkArray() {
		if (topIndex >= capacity - 1) {
			ensureCapacity(capacity * 2);
		} else if (topIndex + 1 < capacity / 2) {
			ensureCapacity(capacity / 2);
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("The stack is empty");
		} else {
			for (int i = 0; i <= topIndex; i++) {
				System.out.println(stackArray[i]);
			}
		}
	}
}
