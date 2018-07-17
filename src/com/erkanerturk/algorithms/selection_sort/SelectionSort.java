package com.erkanerturk.algorithms.selection_sort;

public class SelectionSort {

	// Time complexity O(n^2)
	// Space complexity is O(1)

	private static void selectionSort(int[] array) {
		int arrayLength = array.length;

		for (int i = 0; i < arrayLength - 1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < arrayLength; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}

	public static void main(String[] args) {
		int[] array = { 33, 1, 98, 29, 17, 5, 35, 85, 18, 56, 74, 36 };
		selectionSort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}
}
