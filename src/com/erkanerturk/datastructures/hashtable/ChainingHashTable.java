package com.erkanerturk.datastructures.hashtable;
import java.util.LinkedList;

public class ChainingHashTable<T> {

	private static class Data<T> {
		private int key;
		private T value;

		public Data() {
		}

		public Data(int key, T value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public T getValue() {
			return value;
		}
	}

	private LinkedList<Data<T>>[] arrayHash;
	private int size, capacity;

	public ChainingHashTable(int capacity) {
		this.capacity = capacity;
		size = 0;
		arrayHash = new LinkedList[capacity];
	}

	public void put(int key, T value) {
		if (value == null) {
			throw new NullPointerException("Value is null");
		}

		if (arrayHash[hashFunc(key)] == null) {
			arrayHash[hashFunc(key)] = new LinkedList<Data<T>>();
		}
		arrayHash[hashFunc(key)].addFirst(new Data<T>(key, value));
		size++;
	}

	public T get(int key) {
		return find(key).getValue();
	}

	private Data<T> find(int key) {
		LinkedList<Data<T>> list = arrayHash[hashFunc(key)];
		if (list != null) {
			for (Data<T> temp : list) {
				if (temp.getKey() == key) {
					return temp;
				}
			}
		}
		return null;
	}

	public T remove(int key) {
		Data<T> removedData = find(key);

		if (removedData != null) {
			arrayHash[hashFunc(key)].remove(removedData);
			size--;

			if (arrayHash[hashFunc(key)].isEmpty()) {
				arrayHash[hashFunc(key)] = null;
			}
		}
		return removedData.getValue();
	}

	private int hashFunc(int key) {
		return key % capacity;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Hash table is empty");
		} else {
			for (int i = 0; i < capacity; i++) {
				if (arrayHash[i] != null) {
					for (Data<T> temp : arrayHash[i]) {
						System.out.println("Index: " + i + " Key: " + temp.getKey() + " Value:" + temp.getValue());
					}
				}
			}
		}
	}
}
