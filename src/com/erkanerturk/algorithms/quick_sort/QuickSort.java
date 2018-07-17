package com.erkanerturk.algorithms.quick_sort;

public class QuickSort {

	// Time complexity O(n^2)
	// Space complexity is O(log n)

	private static int partition(int array[], int low, int high) {
		int pivot = array[high];
		int i = low;

		for (int j = low; j < high; j++) {
			if (array[j] <= pivot) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
			}
		}

		int temp = array[i];
		array[i] = array[high];
		array[high] = temp;

		return i;
	}

	private static void sort(int array[], int low, int high) {
		if (low < high) {
			int pi = partition(array, low, high);

			sort(array, low, pi - 1);
			sort(array, pi + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] array = { 33, 1, 98, 29, 17, 5, 35, 85, 18, 56, 74, 36 };
		sort(array, 0, array.length - 1);

		for (int i : array) {
			System.out.println(i);
		}
	}
}
