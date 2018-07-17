package com.erkanerturk.algorithms.bubble_sort;
public class BubbleSort {

	// Time complexity O(n^2)
	// Space complexity is O(1)

	private static void bubbleSort(int[] array) {
		int arrayLength = array.length;

		for (int i = 0; i < arrayLength - 1; i++) {
			boolean swapped = false;

			for (int j = 0; j < arrayLength - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					swapped = true;
				}
			}

			if (swapped == false) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 33, 1, 98, 29, 17, 5, 35, 85, 18, 56, 74, 36 };
		bubbleSort(array);

		for (int i : array) {
			System.out.println(i);
		}
	}
}
