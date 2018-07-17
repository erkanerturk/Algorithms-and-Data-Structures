package com.erkanerturk.algorithms.insertion_sort;

public class InsertionSort {

	// Time complexity O(n^2)
	// Space complexity is O(1)

	public static void insertionSort(int[] array) {
		int arrayLength = array.length;

		for (int i = 1; i < arrayLength; ++i) {
			int key = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	public static void main(String[] args) {
		int[] array = { 33, 1, 98, 29, 17, 5, 35, 85, 18, 56, 74, 36 };
		insertionSort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}
}
